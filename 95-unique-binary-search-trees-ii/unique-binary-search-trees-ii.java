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
    public List<TreeNode> generateTrees(int n) {
          return backtrack (  1  , n );
    }


    public List<TreeNode> backtrack(int start ,  int end  ){
        List<TreeNode> ans = new ArrayList<>();
        if( start > end ){
            ans.add(null) ;return ans;}


        for (int i =start ;i<= end;i++ ){
                List<TreeNode> leftList =  backtrack(start , i-1);
                List<TreeNode> rightList =  backtrack(i+1 , end );


                for (TreeNode left : leftList){
                    for (TreeNode right : rightList){
                        TreeNode root = new TreeNode(i);
                        root.left = left ;
                        root.right = right ;

                        ans.add(root);
                    }
                }
                
            
        }
        return ans ;
    
    }
}