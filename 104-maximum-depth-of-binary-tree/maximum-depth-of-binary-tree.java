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
    public int maxDepth(TreeNode root) {
        int  currLevel =0 ;

        int maxLevel = Integer.MIN_VALUE;
        if(root ==null)
        return currLevel ;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
    

        while (queue.size()> 0){
            currLevel ++;
            int memberCounts = queue.size();


            for (int i =0; i< memberCounts ;i ++){
                TreeNode node = queue.poll();

                if (node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }

            
        }

        return currLevel++ ;
    }
}