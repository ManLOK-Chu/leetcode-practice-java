package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void iterate() {
        ListNode cur = this;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.println(' ');
            cur = cur.next;
        }
    }

    public static ListNode createList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        ListNode curr = dummyHead;
        for (int i = 0; i < array.length; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
