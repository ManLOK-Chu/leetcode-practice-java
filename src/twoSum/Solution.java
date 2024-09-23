package twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && index != i) {
                return new int[]{index, i};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(nums1, 9)));
        int[] nums2 = {3, 2, 4};
        System.out.println(Arrays.toString(solution.twoSum(nums2, 6)));
        int[] nums3 = {3, 3};
        System.out.println(Arrays.toString(solution.twoSum(nums3, 6)));
    }
}
