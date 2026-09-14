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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if(root ==null)
        return ans ;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (queue.size()> 0){
            Double currSum = 0D; 
            int memberCounts = queue.size();


            for (int i =0; i< memberCounts ;i ++){

                TreeNode node = queue.poll();
                currSum+= node.val;

                if (node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }

            ans.add(currSum/memberCounts);
        }

        return ans ;
    }
}