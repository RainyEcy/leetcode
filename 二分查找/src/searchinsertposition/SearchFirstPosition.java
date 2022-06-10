package searchinsertposition;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchFirstPosition {

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(logn)，其中 nn 为数组的长度。二分查找所需的时间复杂度为 O(logn)。
     * <p>
     * 空间复杂度：O(1)。我们只需要常数空间存放若干变量。
     */
    public int serarchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int middleNum = nums[middle];
            if (target == middleNum) {
                return middle;
            } else if (target > middleNum) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        SearchFirstPosition searchFirstPosition = new SearchFirstPosition();
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchFirstPosition.serarchInsert(nums, 5));
        System.out.println(searchFirstPosition.serarchInsert(nums, 2));
        System.out.println(searchFirstPosition.serarchInsert(nums, 7));
    }

}
