/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root ==null)
        return root ;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
    

        while (queue.size()> 0){
            
            Node lastNode = queue.poll();
            int memberCounts = queue.size();

            if (lastNode.left != null)
                queue.offer(lastNode.left);
            if(lastNode.right != null)
                queue.offer(lastNode.right);

            


            for (int i =0; i< memberCounts ;i ++){
                Node node = queue.poll();
                lastNode.next = node ;
                lastNode =node ;

                if (node.left != null)
                queue.offer(node.left);
                if(node.right != null)
                queue.offer(node.right);
            }

            
        }

        return root ;
    }
}