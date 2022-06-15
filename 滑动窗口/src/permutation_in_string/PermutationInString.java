package permutation_in_string;

import java.util.Arrays;

/**
 * 字符串的排列
 * <p>
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationInString {

    /**
     * 等长滑动对比法：对比两个数组字符出现次数与种类数,对比数组进行等长滑动右移
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度 O(n+m+∣Σ∣)，其中 n 是字符串 s1的长度，m 是字符串 s2的长度，
     * Σ 是字符集，这道题中的字符集是小写字母，∣Σ∣=26。
     * <p>
     * 空间复杂度：O(∣Σ∣)。
     */
    public boolean checkInclusionA(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        int length = s1.length();

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < length; i++) {
            s2Count[s2Array[i] - 'a']++;
            s1Count[s1Array[i] - 'a']++;
        }

        for (int i = length; i < s2Count.length; i++) {
            s2Count[s2Array[i] - 'a']++;
            s2Count[s2Array[i - length] - 'a']--;
            if (Arrays.equals(s1Count, s2Count)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 等长滑动差异对比：初始化等长时差异个数diff，然后等长向后移动，当差异diff=0时则匹配成功
     *
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度 O(n+m+∣Σ∣)，其中 n 是字符串 s1的长度，m 是字符串 s2的长度，
     * Σ 是字符集，这道题中的字符集是小写字母，∣Σ∣=26。
     * <p>
     * 空间复杂度：O(∣Σ∣)。
     */
    public boolean checkInclusionB(String s1, String s2) {
        int diff = 0;
        int[] cnt = new int[26];

        // 处理等长差异性
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            cnt[s1.charAt(i) - 'a']--;
            cnt[s2.charAt(i) - 'a']++;
        }

        // 差异性整合
        for (int j : cnt) {
            if (j != 0) {
                diff++;
            }
        }

        // 初步对比
        if (diff == 0) {
            return true;
        }

        // 等长滑动差异增减
        for (int k = length; k < s2.length(); k++) {
            char end = s2.charAt(k);
            char start = s2.charAt(k - length);
            // 前后一致不变继续
            if (end == start) {
                continue;
            }

            // 后位增加后增加差异
            if (cnt[end - 'a'] == 0) {
                diff++;
            }
            cnt[end - 'a']++;
            // 后位增加后减少差异
            if (cnt[end - 'a'] == 0) {
                diff--;
            }

            // 前位增加后增加差异
            if (cnt[start - 'a'] == 0) {
                diff++;
            }
            cnt[start - 'a']++;
            // 前位增加后减少差异
            if (cnt[start - 'a'] == 0) {
                diff--;
            }

            // diff = 0 匹配成功
            if (diff == 0) {
                return true;
            }

        }

        return false;
    }


    /**
     * 双指针反推：正向为 长度为n时 ，cnt各项为0时匹配成功。反推则为 cnt =0 时，长度为n匹配成功，升级cnt<=0时即可。
     */
    public boolean checkInclusionC(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if (s2Length < s1Length) {
            return false;
        }

        int[] cnt = new int[26];

        // 初始化各项出现次数
        for (int i = 0; i < s1Length; i++) {
            --cnt[s1.charAt(i) - 'a'];
        }

        // 双指针对比 right left
        int left = 0;

        for (int right = 0; right < s2Length; right++) {
            int x = s2.charAt(right) - 'a';
            ++cnt[x];
            while (cnt[x] > 0) {
                --cnt[s2.charAt(left) - 'a'];
                ++left;
            }
            if (right >= left && right - left + 1 == s1Length) {
                return true;
            }

        }

        return false;
    }


}
