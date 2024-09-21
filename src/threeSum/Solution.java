package threeSum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
//解题思路：先排序，然后双指针遍历
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums); // O（nlogn) 排序后为升序
        //O(n^2)
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {//排序后跳过重复值（剪枝）
                continue;
            }
            int target = -nums[i];//在i+1到nums.length-1中查找相加等于-nums[i]到两个数
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重（剪枝）
                    while (left < right) {
                        left++;
                        if (nums[left - 1] != nums[left]) {
                            break;
                        }
                    }
                    //去重（剪枝）
                    while (left < right) {
                        right--;
                        if (nums[right] != nums[right + 1]) {
                            break;
                        }
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1));
        int[] nums2 = {0, 1, 1};
        System.out.println(solution.threeSum(nums2));
        int[] nums3 = {0, 0, 0};
        System.out.println(solution.threeSum(nums3));
    }
}
