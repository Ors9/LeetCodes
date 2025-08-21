/**
 * Computes the minimum number of jumps to reach the last index.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/jump-game-ii/
 *
 * 🧠 Algorithm (Greedy "BFS window"):
 * - Maintain two ranges:
 *   - end: rightmost index reachable with the current number of jumps (current window end).
 *   - farthest: rightmost index reachable if we take one more jump from inside the window.
 * - Scan i from 0 to n-2:
 *   - Update farthest = max(farthest, i + nums[i]).
 *   - When i == end, we must use another jump:
 *       jumps++, end = farthest.
 * - This minimizes jumps by expanding to the farthest possible next window each time.
 *
 * 🧮 Time Complexity: O(n)
 * - Single pass over the array.
 *
 * 🧠 Space Complexity: O(1)
 * - Constant extra space.
 *
 * 🎯 Difficulty: Medium
 * - Think of each jump as completing a "layer" like BFS on indices.
 */
public class JumpGame2 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {2, 3, 0, 1, 4};
        int[] nums3 = {1};                 // already at last index → 0 jumps
        int[] nums4 = {1, 2, 3};           // sample small case

        System.out.println("Answer 1: " + jump(nums1)); // 2
        System.out.println("Answer 2: " + jump(nums2)); // 2
        System.out.println("Answer 3: " + jump(nums3)); // 0
        System.out.println("Answer 4: " + jump(nums4)); // 2
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0; // already at (or beyond) last index

        int jumps = 0, end = 0, farthest = 0;
        // up to n-2: when we land on the last index we don't need another jump
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {    // finish current window → must take a jump
                jumps++;
                end = farthest;
                if (end >= n - 1) break; // optional fast-exit
            }
        }
        return jumps;
    }
}
