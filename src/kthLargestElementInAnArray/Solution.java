package kthLargestElementInAnArray;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class Solution {
    /**
     * 快速排序的核心包括“哨兵划分” 和 “递归” 。
     * 哨兵划分： 以数组某个元素（一般选取首元素）为基准数，将所有小于基准数的元素移动至其左边，大于基准数的元素移动至其右边。
     * 递归： 对 左子数组 和 右子数组 递归执行 哨兵划分，直至子数组长度为 1 时终止递归，即可完成对整个数组的排序。
     */
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return quickSelect(list, k);
    }

    public int quickSelect(List<Integer> list, int k) {
        //随机选取基准
        Random random = new Random();
        int baseNum = list.get(random.nextInt(list.size()));
        //将大于、小于、等于 baseNum 到元素划分到big,small,equal中
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        for (int num : list) {
            if (num > baseNum) {
                big.add(num);
            } else if (num < baseNum) {
                small.add(num);
            }
        }
        // 第k大元素在big中，递归划分
        if (k <= big.size()) {
            return quickSelect(big, k);
        }
        // 第k大元素在small中，递归划分
        if (list.size() - small.size() < k) {
            return quickSelect(small, k - list.size() + small.size());
        }
        // 第k大元素在equal中，直接返回
        return baseNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(nums1, 2));
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(solution.findKthLargest(nums2, 4));
    }
}
