/**
 * Removes duplicates from a **sorted** array in-place and returns the number of unique elements.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 *
 * 🧠 Algorithm:
 * - Two pointers approach: `i` for the last unique element, `j` for scanning the array.
 * - Start with i = 0, and j = 1.
 * - For each nums[j], compare it to nums[i]:
 *     - If nums[j] != nums[i], it's a new unique element:
 *         - increment i
 *         - copy nums[j] to nums[i]
 *     - Otherwise (it's a duplicate), skip it.
 * - After the loop, the first i+1 elements in nums are unique and sorted.
 *
 * 🧮 Time Complexity: O(n)
 * - We traverse the array once with a single pass.
 * - Each element is read and written at most once.
 *
 * 🧠 Space Complexity: O(1)
 * - In-place algorithm: no extra space is used.
 *
 * 🎯 Difficulty: Easy
 * - Requires understanding of two-pointer technique and in-place modification.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        Solution sol = new Solution();
        int k = sol.removeDuplicates(nums);

        System.out.println("Unique count: " + k);
        System.out.print("Updated array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class Solution {

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
