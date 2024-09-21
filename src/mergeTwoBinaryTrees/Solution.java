package mergeTwoBinaryTrees;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        queue.add(root2);
        TreeNode root = new TreeNode();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            TreeNode cur = queue.poll();
            cur.val = node1.val + node2.val;
            if (node1.left != null && node2.left != null) {
                queue.add(node1.left);
                queue.add(node2.left);
                cur.left = new TreeNode();
                queue.add(cur.left);
            }
            if (node1.right != null && node2.right != null) {
                queue.add(node1.right);
                queue.add(node2.right);
                cur.right = new TreeNode();
                queue.add(cur.right);
            }
            if (node1.left != null && node2.left == null) {
                cur.left = node1.left;
            }
            if (node1.right != null && node2.right == null) {
                cur.right = node1.right;
            }
            if (node1.left == null && node2.left != null) {
                cur.left = node2.left;
            }
            if (node1.right == null && node2.right != null) {
                cur.right = node2.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] tree1 = {1, 3, 2, 5};
        Integer[] tree2 = {2, 1, 3, null, 4, null, 7};
        System.out.println(TreeNode.binaryTreePaths(
                solution.mergeTrees(TreeNode.createTree(tree1), TreeNode.createTree(tree2))));
    }
}
