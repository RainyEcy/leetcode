package binarysearch;

/**
 * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(logn)，其中 n 是数组的长度。
     * <p>
     * 空间复杂度：O(1)
     */
    public static int search(int[] nums, int target) {
        // 1 定义初始下标轴区间
        int start = 0;
        int end = nums.length - 1;

        // 2 下标轴进行二分法对比循环
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int middleNum = nums[middle];
            if (target > middleNum) {
                start = ++middle;
            } else if (target < middleNum) {
                end = --middle;
            } else {
                return middle;
            }
        }

        return -1;
    }

    /**
     * [-1,0,3,5,9,12]
     * 9
     * 2
     */
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(search(new int[]{5}, 5));

    }


}
