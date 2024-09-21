package common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public int getVal() {
        return val;
    }

    public static TreeNode createTree(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    queue.add(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    queue.add(node.right);
                }
                queue.remove(node);
                isLeft = true;
            }
        }
        return root;
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        treeStack.push(root);
        pathStack.push(String.valueOf(root.val));
        while (!treeStack.isEmpty()) {
            TreeNode node = treeStack.pop();
            String path = pathStack.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
            }
            if (node.right != null) {
                treeStack.push(node.right);
                pathStack.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                treeStack.push(node.left);
                pathStack.push(path + "->" + node.left.val);
            }
        }
        return res;
    }
}
