package reversestring;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * <p>
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseString {

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N)，其中 NN 为字符数组的长度。一共执行了 N/2N/2 次的交换。
     * 空间复杂度：OO(1)。只使用了常数空间来存放若干变量。
     */
    public void reverseString(char[] s) {
        /*int left = 0, right = s.length - 1;
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }*/

        for (int left = 0, right = s.length - 1; left < right; ++left, --right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

}
