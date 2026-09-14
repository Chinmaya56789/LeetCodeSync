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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
        return new ArrayList<List<Integer>>() ;

        Deque<List<Integer>> levels = new ArrayDeque<List<Integer>>();
        
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);

        while(queue.size()>0){
            ArrayList<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();

            for (int i =0 ;i<levelSize ;i ++){
                TreeNode currentNode = queue.poll() ;
                currentLevel.add(currentNode.val);

                if(currentNode.left != null)
                    queue.add(currentNode.left);
                if(currentNode.right != null)
                    queue.add(currentNode.right);
            }

            levels.push(currentLevel);

        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        while (levels.size()>0){
            ans.add(levels.pop());
        }
        return ans ;

    }
}