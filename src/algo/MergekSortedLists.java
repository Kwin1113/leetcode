package algo;

/**
 * @author Kwin
 * @since 2020/7/5 23:29
 * <p>
 * 23. 合并K个排序链表
 * <p>
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergekSortedLists {
    static ListNode[] lists1 = new ListNode[]
            {
                    new ListNode(1, new ListNode(4, new ListNode(5))),
                    new ListNode(1, new ListNode(3, new ListNode(4))),
                    new ListNode(2, new ListNode(6))
            };

    public static void main(String[] args) {

    }

    static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 定义一个dummy head
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (true) {
            ListNode min = null;
            int pointer = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (min == null || lists[i].val < min.val) {
                    min = lists[i];
                    pointer = i;
                }
            }

            if (pointer == -1) {
                break;
            }
            cur.next = min;
            cur = cur.next;
            lists[pointer] = lists[pointer].next;
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
    }
}
