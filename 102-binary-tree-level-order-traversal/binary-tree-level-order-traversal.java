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

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void traverse(TreeNode root , int level ){

        
        if (root==null)
            return;
            
        if (levels.size() <level +1 )
        levels.add(new ArrayList<Integer>());

        levels.get(level).add(root.val);
        traverse(root.left , level+1);
        traverse(root.right, level+1);

        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root ,0 );
        return levels;
    }
}