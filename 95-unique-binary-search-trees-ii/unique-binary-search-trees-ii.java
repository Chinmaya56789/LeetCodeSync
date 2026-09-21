class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        Map<String, List<TreeNode>> memo = new HashMap<>();
        return build(1, n, memo);
    }

    private List<TreeNode> build(int start, int end, Map<String, List<TreeNode>> memo) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        String key = start + "," + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = build(start, i - 1, memo);
            List<TreeNode> rightSubtrees = build(i + 1, end, memo);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        memo.put(key, result);
        return result;
    }
}