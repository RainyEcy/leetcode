package 合并两个有序链表;

/**
 * 合并两个有序链表
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {

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
     * 方法一
     * 双指针递进
     * 复杂度分析
     * 时间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。因为每次循环迭代中，l1 和 l2 只有一个元素会被放进合并链表中，
     * 因此 while 循环的次数不会超过两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间复杂度为 O(n+m)。
     * 空间复杂度：O(1)。我们只需要常数的空间存放若干变量。
     */
    public ListNode mergeTwoListsA(ListNode list1, ListNode list2) {
        // 设置新链表存取排序后数据
        ListNode returnNode = new ListNode();
        ListNode nodePoint = returnNode;

        // 迭代遍历整个list1和list2
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                nodePoint.next = list1;
                list1 = list1.next;
            } else {
                nodePoint.next = list2;
                list2 = list2.next;
            }
            nodePoint = nodePoint.next;
        }

        // 未遍历到的数据进行后续追加
        nodePoint.next = list1 == null ? list2 : list1;

        return returnNode.next;
    }

    /**
     * 方法二
     * 递归回溯 正向思考递归
     * 复杂度分析
     * 时间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），
     * 函数 mergeTwoList 至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
     * 空间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，
     * 栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+m 次，因此空间复杂度为 O(n+m)。
     */
    public ListNode mergeTwoListsB(ListNode list1, ListNode list2) {
        // 设置新链表存取排序后数据
        ListNode returnNode = new ListNode();

        mergeTwoListsBRecursion(list1, list2, returnNode);

        return returnNode.next;

    }

    private void mergeTwoListsBRecursion(ListNode list1, ListNode list2, ListNode returnNode) {
        if (list1 == null) {
            returnNode.next = list2;
            return;
        }
        if (list2 == null) {
            returnNode.next = list1;
            return;
        }

        if (list1.val <= list2.val) {
            returnNode.next = list1;
            list1 = list1.next;
        } else {
            returnNode.next = list2;
            list2 = list2.next;
        }
        mergeTwoListsBRecursion(list1, list2, returnNode.next);
    }

    /**
     * 方法三
     * 逆向递归
     * 复杂度分析
     * 时间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），
     * 函数 mergeTwoList 至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
     * 空间复杂度：O(n+m)，其中 n 和 m 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，
     * 栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+m 次，因此空间复杂度为 O(n+m)。
     */
    public ListNode mergeTwoListsC(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val <= list2.val) {
            list1.next = mergeTwoListsC(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsC(list1, list2.next);
            return list2;
        }
    }


}
