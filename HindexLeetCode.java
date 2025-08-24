/**
 * Computes the H-Index of a researcher.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/h-index/
 *
 * 🧠 Algorithm (Counting sort buckets):
 * - We need the maximum h such that at least h papers have ≥ h citations.
 * - Use an auxiliary array paperCount[0..n]:
 *   - Clamp every citation value c to ≤ n.
 *   - Increment paperCount[min(c, n)].
 * - Accumulate from the back:
 *   - paperAtLeastH = total papers with ≥ h citations.
 *   - If paperAtLeastH ≥ h, then h is the answer.
 *
 * 🧮 Time Complexity: O(n)
 * 🧠 Space Complexity: O(n)
 * 🎯 Difficulty: Medium
 */
public class HindexLeetCode {

    private final int UNREACHABLE = -1;

    public static void main(String[] args) {
        HindexLeetCode sol = new HindexLeetCode();

        int[] c1 = {3, 0, 6, 1, 5};     // expected 3
        int[] c2 = {1, 3, 1};           // expected 1
        int[] c3 = {0, 0, 0};           // expected 0
        int[] c4 = {100};               // expected 1
        int[] c5 = {4, 4, 0, 0};        // expected 2
        int[] c6 = {11, 15, 2, 2, 2};   // expected 2

        System.out.println("Answer 1: " + sol.hIndex(c1));
        System.out.println("Answer 2: " + sol.hIndex(c2));
        System.out.println("Answer 3: " + sol.hIndex(c3));
        System.out.println("Answer 4: " + sol.hIndex(c4));
        System.out.println("Answer 5: " + sol.hIndex(c5));
        System.out.println("Answer 6: " + sol.hIndex(c6));
    }

    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] paperCount = new int[n + 1]; // buckets: 0..n, clamp ≥n into n

        // explicit zeroing (Java initializes to 0 anyway; kept to match your style)
        for (int i = 0; i < paperCount.length; i++) {
            paperCount[i] = 0;
        }

        // fill buckets with clamped citation counts
        for (int i = 0; i < citations.length; i++) {
            int index = Math.min(n, citations[i]);
            paperCount[index]++;
        }

        // accumulate from right to left and check h-index condition
        int paperAtLeastH = 0;
        for (int h = n; h >= 0; h--) {
            paperAtLeastH += paperCount[h];
            if (paperAtLeastH >= h) {
                return h;
            }
        }

        return UNREACHABLE; // logically unreachable (h=0 will return inside the loop)
    }
}
