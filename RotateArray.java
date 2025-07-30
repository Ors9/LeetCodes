/**
 * Rotates an array to the right by k steps.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * 🧠 Algorithm (Three-Reversals In-Place):
 * - First, reverse the entire array.
 * - Then, reverse the first k elements.
 * - Finally, reverse the rest of the array.
 * - This results in rotating the array to the right by k positions.
 *
 * 🧮 Time Complexity: O(n)
 * - Each element is swapped at most once.
 *
 * 💾 Space Complexity: O(1)
 * - In-place with no extra memory used, only temporary variables.
 *
 * 🎯 Difficulty: Medium
 * - Simple logic once you know the reverse trick, but it's a clever insight.
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotate(nums, k);

        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 5 6 7 1 2 3 4
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;  // Normalize k to avoid over-rotation
        reverse(nums, 0, nums.length - 1);     // Reverse the whole array
        reverse(nums, 0, k - 1);               // Reverse the first k elements
        reverse(nums, k, nums.length - 1);     // Reverse the rest
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
