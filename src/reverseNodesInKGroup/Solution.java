package reverseNodesInKGroup;

import common.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode pre = dummyHead;

        while (head != null) {
            ListNode tail = pre;
            //查看剩余部分长度是否大于等于k
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummyHead.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverses = reverse(head, tail);
            head = reverses[0];
            tail = reverses[1];
            //把子链表重新接回原来链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return dummyHead.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode pre = tail.next;
        ListNode cur = head;
        while (pre != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array1 = {1, 2, 3, 4, 5};
        solution.reverseKGroup(ListNode.createList(array1), 2).iterate();
        System.out.println();
        solution.reverseKGroup(ListNode.createList(array1), 3).iterate();
    }
}
