package sumRootToLeafNumbers;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        Stack<Integer> pathStack = new Stack<>();
        treeStack.push(root);
        pathStack.push(root.val);
        while (!treeStack.isEmpty()) {
            TreeNode node = treeStack.pop();
            Integer path = pathStack.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.right != null) {
                treeStack.push(node.right);
                pathStack.push(path * 10 + node.right.val);
            }
            if (node.left != null) {
                treeStack.push(node.left);
                pathStack.push(path * 10 + node.left.val);
            }
        }
        int sum = 0;
        for (Integer i : res) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {

    }
}
