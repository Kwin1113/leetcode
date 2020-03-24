package Daily;

/**
 * @author Kwin
 * @since 2020/3/23 22:34
 * <p>
 * 876. 链表的中间结点
 * <p>
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * <p>
 * 提示：
 * 给定链表的结点数介于 1 和 100 之间。
 */
public class Daily200323 {

    static ListNode head1;
    static ListNode head2;
    static ListNode head3;

    static {
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        head2.next.next.next.next.next = new ListNode(6);

        head3 = new ListNode(1);
    }

    public static void main(String[] args) {
//        ListNode listNode = solution1(head1);
//        ListNode listNode = solution1(head2);
//        ListNode listNode = solution1(head3);
//        ListNode listNode = bestSolution(head1);
//        ListNode listNode = bestSolution(head2);
        ListNode listNode = bestSolution(head3);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    static ListNode solution1(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode mid;
        ListNode midNext;
        int num = 0;
        do {
            num++;
            mid = getNextNum(head, num);
            midNext = getNextNum(mid, num);
        } while (midNext != null && midNext.next != null);
        return mid;
    }

    static ListNode getNextNum(ListNode node, int num) {
        ListNode tmp = node;
        for (int i = 0; i < num; i++) {
            tmp = tmp.next;
        }
        return tmp;
    }

    static ListNode bestSolution(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(val).append(" ");
        while (next != null) {
            sb.append(next.toString());
        }
        return sb.toString();
    }
}