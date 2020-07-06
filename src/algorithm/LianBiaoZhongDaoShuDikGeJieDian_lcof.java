package algorithm;

/**
 * @author Kwin
 * @since 2020/7/5 23:18
 * <p>
 * 剑指 Offer 22. 链表中倒数第k个节点
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class LianBiaoZhongDaoShuDikGeJieDian_lcof {
    static ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    static int k1 = 2;

    public static void main(String[] args) {
        System.out.println(getKthFromEnd(head1, k1));
    }

    static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode s = head;
        ListNode f = head;
        for (int i = 0; i < k; i++) {
            f = f.next;
        }
        while (f != null) {
            s = s.next;
            f = f.next;
        }

        return s;
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
    }
}
