package firstbadversion;

/**
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 *
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 *
 * 你可以通过调用bool isBadVersion(version)接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/first-bad-version
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstBadVersion extends VersionControl {

    /**
     * 初始化错误版本
     */
    public void initBadVersion(int badVersion) {
        super.badVersion = badVersion;
    }

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度 O(logn)，其中 n 是给定版本的数量。
     * <p>
     * 空间复杂度：O(1)。我们只需要常数的空间保存若干变量。
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int middle = (right - left) / 2 + left;
            if (isBadVersion(middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        FirstBadVersion firstBadVersion = new FirstBadVersion();
        firstBadVersion.initBadVersion(4);
        System.out.println(firstBadVersion.firstBadVersion(8));
    }


}
