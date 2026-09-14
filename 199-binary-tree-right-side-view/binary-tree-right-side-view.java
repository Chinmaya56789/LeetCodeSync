/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root ==null)
        return ans  ;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
    

        while (queue.size()> 0){
            int memberCounts = queue.size();

            ans.add(queue.getLast().val);
            for (int i =0; i< memberCounts ;i ++){
                TreeNode  node = queue.poll();

                if (node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }

            
        }

        return ans ;
    }
}