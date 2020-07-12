package algo;

/**
 * @author Kwin
 * @since 2020/7/4 10:52
 * <p>
 * 21. 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    static ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    static ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

    public static void main(String[] args) {
        System.out.println(mergeTwoLists(l1, l2));
    }

    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            String next = this.next == null ? "null" : this.next.toString();
            return val + "->" + next;
        }
    }
}
