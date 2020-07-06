package algorithm;

/**
 * @author Kwin
 * @since 2020/7/6 18:47
 * <p>
 * 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *  
 * <p>
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseNodesinKGroup {
    static ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    static ListNode head2 = new ListNode(1, new ListNode(2));
    static ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

    public static void main(String[] args) {
//        System.out.println(reverseKGroup(head1, 2));
//        System.out.println(reverseKGroup(head1, 3));
//        System.out.println(reverseKGroup(head2, 2));
//        System.out.println(reverseKGroup(head3, 2));
        System.out.println(reverseKGroup0(head1, 3));
        System.out.println(reverseKGroup0(head2, 2));
        System.out.println(reverseKGroup0(head3, 2));
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        ListNode cur = head;
        int count = 0;
        LABEL:
        while (true) {
            int t = k;
            ListNode nullPointer = cur;
            while (t-- > 0) {
                count++;
                if ((nullPointer = nullPointer.next) == null) {
                    break LABEL;
                }
            }
            ListNode pointer = cur;
            for (int i = 0; i < k; i++) {
                ListNode tmp = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                pointer = cur;
                cur = tmp;
            }
            int t1 = k;
            while (t1-- > 1) {
                pointer = pointer.next;
            }
            pre = pointer;
        }
        if (count % k == 0) {
            for (int i = 0; i < k; i++) {
                ListNode tmp = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = tmp;
            }
        } else {
            while (cur != null) {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    static ListNode reverseKGroup0(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;
        while (tail.next != null) {
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if (tail == null) {
                break;
            }
            ListNode oldHead = pre.next;
            ListNode oldTail = tail.next;
            tail.next = null;
            pre.next = reverse(pre.next);
            oldHead.next = oldTail;

            pre = oldHead;
            tail = pre;
        }

        return dummy.next;
    }

    static ListNode reverse(ListNode head) {
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
            return this.val + " -> " + next;
        }
    }
}
