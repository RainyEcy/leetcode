package movezero;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZero {

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，其中 n 为序列长度。每个位置至多被遍历两次。
     * <p>
     * 空间复杂度：O(1)。只需要常数的空间存放若干变量。
     */
    public void moveZero(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num != 0) {
                swap(nums, zero, i);
                ++zero;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }


}
