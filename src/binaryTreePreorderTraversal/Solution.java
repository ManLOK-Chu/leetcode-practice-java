package binaryTreePreorderTraversal;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);//添加右节点
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                stack.push(node);//添加中节点
                stack.push(null);//中节点遍历过，但是还没处理，加入空节点作为标记

            } else {
                TreeNode element = stack.pop();//重新取出栈中元素
                res.add(element.val);//加到结果集
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] array = {1, null, 2, 3};
        System.out.println(solution.preorderTraversal(TreeNode.createTree(array)));
    }
}
