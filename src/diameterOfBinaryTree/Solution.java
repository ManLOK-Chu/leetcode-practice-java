package diameterOfBinaryTree;

import common.TreeNode;

public class Solution {

    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.getLeft());
        int right = depth(node.getRight());
        res = Math.max(res, left + right + 1);
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] array1 = {1, 2, 3, 4, 5};
        System.out.println(solution.diameterOfBinaryTree(TreeNode.createTree(array1)));
    }

}