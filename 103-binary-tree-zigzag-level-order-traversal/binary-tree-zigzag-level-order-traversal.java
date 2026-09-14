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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root ==null)
        return ans ;
        

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean isLeftToRight =false ;

        while(queue.size()>0){
            List<Integer> currentLevel = new LinkedList<>();
            int  levelSize = queue.size();
            isLeftToRight = !isLeftToRight ;

            for (int i =0 ; i< levelSize ;i++){
                TreeNode  node = queue.poll();
                if (isLeftToRight)
                    currentLevel.addLast(node.val);
                else 
                    currentLevel.addFirst(node.val);

                if(node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }

            ans.add(currentLevel);

        }

        return ans ;
    }
}