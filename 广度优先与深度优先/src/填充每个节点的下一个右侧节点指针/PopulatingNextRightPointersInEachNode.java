package 填充每个节点的下一个右侧节点指针;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有next 指针都被设置为 NULL。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 * 示例 2:
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点的数量在[0, 212- 1]范围内
 * -1000 <= node.val <= 1000
 * <p>
 * 进阶：
 * <p>
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    /**
     * 利用队列进行层序遍历
     */
    public Node connecQueueBfs(Node root) {
        if (root == null) {
            return root;
        }
        // 初始化第一层数据
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        // 当队列里有数据则进行遍历取出
        while (nodeQueue.size() > 0) {

            // 队列遍历当前树层
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                Node poll = nodeQueue.poll();
                if (i < size - 1) {
                    poll.next = nodeQueue.peek();
                }

                // 填充下一数层数据
                if (poll.left != null) {
                    nodeQueue.add(poll.left);
                    nodeQueue.add(poll.right);
                }
            }
        }

        return root;
    }

    /**
     * 利用node规则进行深度遍历
     * - node.left.next = node.right
     * - node.right.next = node.next.left
     */
    public Node connecNodeDfs(Node root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = root.next == null ? null : root.next.left;
            connecNodeDfs(root.left);
            connecNodeDfs(root.right);
        }

        return root;
    }

    /**
     * 利用node规则进行广度遍历
     * - node.left.next = node.right
     * - node.right.next = node.next.left
     */
    public Node connecNodeBfs(Node root) {
        if (root == null) {
            return root;
        }

        Node leftPoint = root;
        Node levelPoint = leftPoint;

        while (leftPoint != null) {
            while (levelPoint != null) {
                if (levelPoint.left != null) {
                    levelPoint.left.next = levelPoint.right;
                    levelPoint.right.next = levelPoint.next == null ? null : levelPoint.next.left;
                }
                levelPoint = levelPoint.next;
            }
            leftPoint = leftPoint.left;
            levelPoint = leftPoint;
        }

        return root;
    }

}
