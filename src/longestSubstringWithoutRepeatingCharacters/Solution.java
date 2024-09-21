package longestSubstringWithoutRepeatingCharacters;

import java.util.Arrays;

//滑动窗口
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] cache = new int[255];
        Arrays.fill(cache, Integer.MIN_VALUE);
        int start = 0, result = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = cache[s.charAt(i)];
            if (index != Integer.MIN_VALUE && start <= index) {
                start = index + 1;
            } else {
                result = Math.max(result, i - start + 1);
            }
            cache[s.charAt(i)] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("babad"));
    }
}
