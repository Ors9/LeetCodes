package LeetCodes;


/**
 * LeetCode - Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * Difficulty: Easy
 * Topic: Arrays, Two Pointers
 *
 * Description:
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
 * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums2 into nums1 as one sorted array.
 *
 * Note: The final sorted array should not be returned by the function,
 * but instead be stored inside the array nums1.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);

        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    /*Time complexy  and space complexy O(n+m) */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[m + n];
        int i = 0;
        int j = 0;
        int z = 0;
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                nums3[z] = nums1[i];
                i++;
            } else {
                nums3[z] = nums2[j];
                j++;
            }

            z++;
        }

        while (i < m) {
            nums3[z] = nums1[i];
            i++;
            z++;
        }

        while (j < n) {
            nums3[z] = nums2[j];
            j++;
            z++;
        }

        for (i = 0; i < m + n; i++) {
            nums1[i] = nums3[i];
        }
    }

}
