package algo;

/**
 * @author Kwin
 * @since 2020/7/4 11:36
 * <p>
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapNodesinPairs {
    static ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

    public static void main(String[] args) {
//        System.out.println(swapPairs(head1));
        System.out.println(swapPairs0(head1));
    }

    static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fist = head;
        ListNode second = head.next;

        fist.next = swapPairs(second.next);
        second.next = fist;

        return second;
    }

    static ListNode swapPairs0(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            pre.next = second;
            first.next = second.next;
            second.next = first;

            pre = first;
            head = first.next;
        }

        return dummy.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            String next = this.next == null ? "null" : this.next.toString();
            return val + "->" + next;
        }
    }

}
