package 组合;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combinations {

    public static List<List<Integer>> RETURN_LIST = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        combineN(1, n, k, new ArrayDeque<>());
        return RETURN_LIST;
    }

    public void combineN(int start, int n, int k, Deque<Integer> intList) {
        // 已经满足个数限制
        if (k == 0) {
            RETURN_LIST.addAll(new ArrayList(intList));
            return;
        }

        // 剪枝考虑
        // n-k+1 满足剩余个数下最大数字
        for (int i = start; i <= n - k + 1; i++) {
            intList.offerLast(i);
            combineN(start++, n, k--, intList);
            intList.removeLast();
        }
    }
}
