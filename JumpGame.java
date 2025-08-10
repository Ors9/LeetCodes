/**
 * Determines if you can reach the last index of the array.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/jump-game/
 *
 * 🧠 Algorithm (Greedy – Farthest Reach):
 * - Track the farthest index reachable so far (farthest).
 * - Scan left → right:
 *   - If i > farthest, we've hit an unreachable gap → return false.
 *   - Update farthest = max(farthest, i + nums[i]).
 *   - If farthest >= last index, we can finish → return true.
 *
 * 💡 Intuition:
 * Every position gives a *range* of next positions (a continuous interval).
 * Keeping only the farthest boundary of the union of all ranges seen so far
 * suffices—if any intermediate index enables a farther reach, we'll visit it
 * when we get there and extend the boundary.
 *
 * ✅ Correctness Sketch:
 * - If we ever reach i > farthest, no earlier index could jump to i, so the
 *   suffix is unreachable → false.
 * - Otherwise, by induction over i, farthest is the maximum reachable index
 *   using some valid sequence of jumps among 0..i. If it ever covers the last
 *   index, a valid sequence exists → true.
 *
 * 🧮 Time Complexity: O(n)
 * 🧠 Space Complexity: O(1)
 * 🎯 Difficulty: Medium
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;                 // stuck before reaching i
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) {
                return true;                  // can reach or pass the last index
            }
        }
        return true;                          // never got stuck
    }

    // Demo
    public static void main(String[] args) {
        JumpGame s = new JumpGame();

        int[] a = {2, 3, 1, 1, 4};
        int[] b = {3, 2, 1, 0, 4};

        System.out.println(s.canJump(a)); // true
        System.out.println(s.canJump(b)); // false
    }
}
