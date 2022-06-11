package rotatearray;

import java.util.Arrays;

/**
 * 轮转数组
 * <p>
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateArray {

    /**
     * 解法1 中间数组暂存 一个个循环
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度： O(n)，其中 n 为数组的长度。
     * <p>
     * 空间复杂度： O(n)
     */
    public void roteteArrayAAA(int[] nums, int k) {
        int[] temp = Arrays.copyOf(nums, nums.length);

        for (int i = 0; i < temp.length; i++) {
            int fromNum = temp[i];
            nums[(i + k) % nums.length] = fromNum;
        }
    }


    /**
     * 解放2 环状替换
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，其中 n 为数组的长度。每个元素只会被遍历一次。
     * <p>
     * 空间复杂度：O(1)。我们只需常数空间存放若干变量。
     */
    public void roteteArrayBBB(int[] nums, int k) {
        // 总数标识
        int count = 0;

        for (int i = 0; i < nums.length && count < nums.length; i++) {

            int current = i;
            int fromNum = nums[i];
            int fromPoint = i;

            do {
                int toPoint = (fromPoint + k) % nums.length;
                int toNum = nums[toPoint];
                nums[toPoint] = fromNum;
                fromPoint = toPoint;
                fromNum = toNum;
            } while (fromPoint != current);

        }

    }

    /**
     * 解法3 反转法
     */
    public void roteteArrayCCC(int[] nums, int k) {
        revertArray(nums, 0, nums.length - 1);
        revertArray(nums, 0, k % nums.length - 1);
        revertArray(nums, k % nums.length, nums.length - 1);
    }

    private void revertArray(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

}
