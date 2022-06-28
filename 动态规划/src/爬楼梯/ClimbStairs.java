package 爬楼梯;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 提示：
 * 1 <= n <= 45
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbStairs {

    /**
     * 动态规划
     * F（n） = F(n-2) + F(n-1)
     * F(n-2) + 2 || F(n-1) + 1
     * <p>
     * 前置 1 start=0  end=1 cur=0+1=1
     * 2 start=1 end=1 cur=1+1=2
     * 3 start=1 end=2 cur=1+2=3
     */
    public int climbStairs(int n) {
        int start = 0, end = 1, cur = 0;
        for (int i = 0; i <= n; i++) {
            cur = start + end;
            start = end;
            end = cur;
        }
        return cur;
    }
}
