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
    public int maxLevelSum(TreeNode root) {
        int ans =1 ;
        int max = Integer.MIN_VALUE;
        int  currLevel =0 ;
        if(root ==null)
        return ans ;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
    

        while (queue.size()> 0){
            currLevel ++;
            int currSum = 0; 
            int memberCounts = queue.size();


            for (int i =0; i< memberCounts ;i ++){

                TreeNode node = queue.poll();
                currSum+= node.val;

                if (node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }
            if(currSum > max ){
                ans =  currLevel;
                max = currSum;
            }
            
        }

        return ans ;
    }
}