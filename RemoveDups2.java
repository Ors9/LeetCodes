
/**
 * Removes duplicates from a **sorted** array in-place and returns the new length,
 * allowing each unique element to appear at most twice.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 *
 * 🧠 Algorithm:
 * Uses the two-pointer technique to overwrite extra duplicates while maintaining
 * at most two instances of each unique number.
 *
 * 🧮 Time Complexity: O(n)
 * - The array is traversed once with a single pass.
 * - Each element is read and written at most once.
 *
 * 🧮 Space Complexity: O(1)
 * - In-place algorithm: no extra space is used.
 *
 * 🎯 Difficulty: Medium
 * - Requires understanding of two-pointer technique and in-place modification.
 */
public class RemoveDups2 {

    public static void main(String[] args) {
        RemoveDups2 remover = new RemoveDups2();

        int[] nums = {1, 1, 1, 2, 2, 2, 2, 3}; // Expected result: [1, 1, 2, 2, 3]
        int newLength = remover.removeDuplicates(nums);

        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int appearTimes = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                appearTimes = 0;
                i++;
                nums[i] = nums[j];
            } else if (nums[j] == nums[i]) {
                appearTimes++;
                if (appearTimes >= 2) {
                    continue;
                } else {
                    i++;
                    nums[i] = nums[j];
                }
            }

        }
        return i + 1;
    }

}
