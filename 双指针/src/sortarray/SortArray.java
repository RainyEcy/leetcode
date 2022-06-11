package sortarray;

import java.util.Arrays;
import java.util.List;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class SortArray {

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。
     * <p>
     * 空间复杂度：O(1)。除了存储答案的数组以外，我们只需要维护常量空间。
     *
     * @param nums
     */
    public Integer[] sortArray(Integer[] nums) {
        int left = 0;
        int right = nums.length - 1;
        Integer[] sortNums = new Integer[nums.length];
        int maxPoint = sortNums.length - 1;

        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                sortNums[maxPoint] = nums[left] * nums[left];
                left++;
            } else {
                sortNums[maxPoint] = nums[right] * nums[right];
                right--;
            }
            maxPoint--;
        }

        return sortNums;
    }

    public static void main(String[] args) {
        SortArray sortArray = new SortArray();
        Integer[] nums = {-3, -1, 2, 3, 11};
        Integer[] ints = sortArray.sortArray(nums);
        List<Integer> x = Arrays.asList(ints);
        System.out.println(x);
    }
}
