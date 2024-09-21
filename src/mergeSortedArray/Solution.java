package mergeSortedArray;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (n >= 0) {
            while (m >= 0 && nums1[m] > nums2[n]) {
                swap(nums1, i, nums1, m);
                m--;
                i--;
            }
            swap(nums1, i, nums2, n);
            n--;
            i--;
        }

    }

    void swap(int[] a, int i, int[] b, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        Solution solution = new Solution();
        solution.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
