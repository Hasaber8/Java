public int deepestLeavesSum_dfs(TreeNode root) {
    int maxDepth = getMaxDepth(root);
    return dfs(root, 1, maxDepth);
}

public int getMaxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }

    return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
}

public int dfs(TreeNode root, int curDepth, int maxDepth) {
    if (root == null) {
        return 0;
    }

    if (curDepth == maxDepth) {
        return root.val;
    }

    int left = dfs(root.left, curDepth + 1, maxDepth);
    int right = dfs(root.right, curDepth + 1, maxDepth);

    return left + right;
}