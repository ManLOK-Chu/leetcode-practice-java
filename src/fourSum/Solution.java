package fourSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 */
//思路：先排序后剪枝
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        //1. 先对数组进行排序
        Arrays.sort(nums);
        //2. 从左到右遍历i
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {//去重
                continue;
            }
            //3. 固定i, 枚举j 且 j > i
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {//去重
                    continue;
                }
                //4. 在 (j,nums.size) 这个区间内使 l 和 r 双向滑动，求解满足元素和为 target 的四元组。
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (left > j + 1 && nums[left] == nums[left - 1]) {//去重
                        left++;
                        continue;
                    }
                    if (right < nums.length - 1 && nums[right] == nums[right + 1]) {//去重
                        right--;
                        continue;
                    }
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 0, -1, 0, -2, 2};
        System.out.println(solution.fourSum(nums1, 0));
        int[] nums2 = {2, 2, 2, 2, 2};
        System.out.println(solution.fourSum(nums2, 8));
    }
}
