package jumpGameTwo;

import java.util.Arrays;

public class Solution {
    //动态规划 不建议用贪心
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        int level = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            dp[level + 1] = Math.max(dp[level + 1], i + nums[i]);
            if (i == dp[level]) {
                level++;
            }
        }
        return level;
    }

//    public int jump(int[] nums) {
//        if(nums.length == 1){
//            return 0;
//        }
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = i - 1; j >= 0; j--) {
//                // 往前找，找到能走到当前位置的， + 1代表走一步到当前位置
//                // 找最小值
//                if (j + nums[j] >= i) {
//                    dp[i] = Math.min(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp[nums.length - 1];
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums1));
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println(solution.jump(nums2));
    }
}
