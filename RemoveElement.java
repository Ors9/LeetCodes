
/**
 * Removes all occurrences of val from the array in-place and returns the new length.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150
 *
 * 🧠 Algorithm:
 * - Two pointers approach: one from the beginning (`i`) and one from the end (`j`).
 * - Whenever nums[i] == val, we swap it with nums[j], and decrease j.
 * - Otherwise, we increment i.
 * - We stop when i > j.
 *
 *
 * 🧮 Time Complexity: O(n)
 * - Each element is visited at most once by either `i` or `j`.
 *
 * 🧠 Space Complexity: O(1)
 * - In-place algorithm, using constant extra space.
 *
 * 🎯 Difficulty: Easy
 * - But careful pointer management is required to avoid logic bugs.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};  // Edge case where your version may fail
        int val = 2;

        int newLength = removeElement(nums, val);

        System.out.println("New length: " + newLength);
        System.out.print("Modified array: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {

        int i = 0, j = nums.length - 1;
        while (i <= j) {
            while (i <= j && nums[j] == val) {
                j--;
            }
            if (i <= j && nums[i] == val) {
                nums[i] = nums[j];
                nums[j] = val;
            }
            if (nums[i] != val) {
                i++;
            }
        }

        return i;
    }

}
