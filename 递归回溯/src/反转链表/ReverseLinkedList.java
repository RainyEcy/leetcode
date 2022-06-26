package 反转链表;

/**
 * 反转链表
 * <p>
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * <p>
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * <p>
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedList {

    static class ListNode {
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
    }

    /**
     * 迭代循环
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要遍历链表一次。
     * 空间复杂度：O(1)。
     */
    public ListNode reverseListA(ListNode head) {
        ListNode current = head;
        ListNode over = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = over;
            over = current;
            current = next;
        }

        return head;

    }

    /**
     * 迭代循环
     * 复杂度分析
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
     * 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 n 层。
     */
    public ListNode reverseListB(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseListB(head.next);

        head.next.next = head.next;
        head.next = null;

        return p;

    }


}
