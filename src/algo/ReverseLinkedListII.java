package algo;

/**
 * @author Kwin
 * @since 2020/7/4 12:14
 * <p>
 * 92. 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    static ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    static int m1 = 2, n1 = 4;

    public static void main(String[] args) {
        System.out.println(reverseBetween(head1, m1, n1));
    }

    /**
     * 迭代
     */
    static ListNode reverseBetween(ListNode head, int m, int n) {
        // 定义pre和cur
        ListNode pre = null;
        ListNode cur = head;
        // 将pre和cur移动到指定位置
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }

        // 记录两个指针，一个是反转链表部分的前一节点，一个是反转链表部分的后一节点
        ListNode con = pre;
        ListNode tail = cur;

        // 开始进行部分链表反转
        while (n > 0) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            n--;
        }

        // 将反转链表部分与剩余部分重新连接
        if (con != null) {
            con.next = pre;
        } else {
            head = pre;
        }
        tail.next = cur;

        return head;
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
