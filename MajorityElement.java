
/**
 * Finds the majority element in an array.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 *
 * 🧠 Algorithm (Boyer-Moore Voting):
 * - Keep a candidate and a counter.
 * - If the counter is 0, update the candidate to the current element.
 * - If the current element equals the candidate, increment the counter.
 * - Otherwise, decrement the counter.
 * - The majority element is guaranteed to exist, so the final candidate is the answer.
 *
 * 🧮 Time Complexity: O(n)
 * - Single pass through the array.
 *
 * 🧠 Space Complexity: O(1)
 * - Constant space; no extra memory used.
 *
 * 🎯 Difficulty: Easy
 * - The logic is subtle but elegant — each conflicting pair cancels each other out.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        int result = majorityElement(nums);

        System.out.println("Majority element: " + result); // Output: 2
    }

    public static int majorityElement(int[] nums) {
        int count = 0, candidate = nums[0];

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
