import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    // Segment Tree to maintain the maximum gap in any coordinate range
    private int[] tree;
    private int maxCoord;

    // Standard Point Update: O(log M)
    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    // Standard Range Maximum Query: O(log M)
    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0; // Out of bounds range contributes 0 to max gap
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        int p1 = query(2 * node, start, mid, l, r);
        int p2 = query(2 * node + 1, mid + 1, end, l, r);
        return Math.max(p1, p2);
    }

    public List<Boolean> getResults(int[][] queries) {
        // Find the maximum upper coordinate boundary to size our Segment Tree
        maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        // Safely buffer the limit (adding a small cushion for boundaries)
        maxCoord = Math.max(maxCoord, 3) + 1; 
        
        // Allocate space for the tree (4 * M is standard for complete binary trees)
        tree = new int[4 * maxCoord];
        
        // TreeSet tracks positions of obstacles. 
        // We pre-seed 0 and maxCoord as permanent boundary walls.
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(maxCoord);

        // Initially, there are no internal obstacles, so the gap ending at maxCoord is maxCoord itself
        update(1, 0, maxCoord, maxCoord, maxCoord);

        List<Boolean> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            
            if (type == 1) {
                int x = q[1];
                if (obstacles.contains(x)) continue; // Already added

                // Find adjacent existing obstacles using binary search methods
                int prev = obstacles.floor(x);
                int next = obstacles.ceiling(x);

                // Insert the new obstacle
                obstacles.add(x);

                // Update the broken gaps in our Segment Tree
                update(1, 0, maxCoord, x, x - prev);       // New gap from prev to x
                update(1, 0, maxCoord, next, next - x);    // Reduced gap from x to next
                
            } else {
                int range = q[1];
                int size = q[2];

                // 1. Check the largest gap completely within the known obstacles up to 'range'
                int maxGap = query(1, 0, maxCoord, 0, range);

                // 2. Account for the final trailing gap between the last obstacle before 'range' and 'range' itself
                int lastObstacleBeforeRange = obstacles.floor(range);
                int trailingGap = range - lastObstacleBeforeRange;
                
                maxGap = Math.max(maxGap, trailingGap);

                // If our maximum found gap can accommodate the requested size, return true
                ans.add(maxGap >= size);
            }
        }

        return ans;
    }
}