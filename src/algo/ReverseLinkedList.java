package algo;

/**
 * @author Kwin
 * @since 2020/7/4 11:18
 * <p>
 * 206. 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {
    static ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    public static void main(String[] args) {
//        System.out.println(reverseList(head1));
        System.out.println(reverseList0(head1));
    }

    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    static ListNode reverseList0(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
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
