package binaryTreeZigzagLevelOrderTraversal;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */
public class Solution {

    // 双端队列
    // 广度优先搜索，对树进行逐层遍历，用队列维护当前层的所有元素，
    // 当队列不为空的时候，求得当前队列的长度 size，
    // 每次从队列中取出 size 个元素进行拓展，然后进行下一次迭代
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;

        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (isLeft) {
                    //如果从左至右，我们每次将被遍历到的元素插入至双端队列的末尾。
                    levelList.addLast(cur.val);
                } else {
                    //如果从右至左，我们每次将被遍历到的元素插入至双端队列的头部。
                    levelList.addFirst(cur.val);
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(new LinkedList<>(levelList));
            isLeft = !isLeft;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        System.out.println(solution.zigzagLevelOrder(TreeNode.createTree(array)));
    }
}
