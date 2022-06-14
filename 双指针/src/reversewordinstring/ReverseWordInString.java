package reversewordinstring;

/**
 * 给定一个字符串s，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * 示例 2:
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 104
 * s包含可打印的 ASCII 字符。
 * s不包含任何开头或结尾空格。
 * s里 至少 有一个词。
 * s中的所有单词都用一个空格隔开。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-words-in-a-string-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseWordInString {

    /**
     * 复杂度分析
     * <p>
     * 时间复杂度：O(N)，其中 N 为字符串的长度。原字符串中的每个字符都会在 O(1) 的时间内放入新字符串中。
     * <p>
     * 空间复杂度：O(N)。我们开辟了与原字符串等大的空间。
     */
    public String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        int left, right = 0;
        while (right < s.length()) {
            left = right;
            while (right < s.length() && s.charAt(right) != ' ') {
                ++right;
            }

            for (int start = right - 1; start >= left; start--) {
                sb.append(s.charAt(start));
            }

            if (right < s.length() && s.charAt(right) == ' ') {
                sb.append(' ');
                ++right;
            }
        }
        return sb.toString();
    }
}
