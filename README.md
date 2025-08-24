# 📘 LeetCodes — Java Solutions

This repository contains my **LeetCode practice solutions in Java**.  
Each solution is written as a **self-contained Java class** with:
- A detailed **comment header** (problem link, algorithm, complexity, difficulty).
- The required **method** implementation.
- An optional **`main` method** with test cases for local runs.

---

## 📂 Repository Structure

All solutions are stored as `.java` files, one per problem:

```
LeetCodes/
├── HindexLeetCode.java # Problem 274. H-Index
├── JumpGame2LeetCode.java # Problem 45. Jump Game II
├── TwoSumLeetCode.java # Problem 1. Two Sum
└── ...
```


👉 Each file corresponds to one LeetCode problem.  
👉 The **class name matches the file name** (`HindexLeetCode.java` → `public class HindexLeetCode`).  
👉 The **header** at the top of each file describes the problem and approach.

---

## 🧱 File Layout

Every file follows the same structure:

```java
/**
 * <Problem Number>. <Problem Title>
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/<slug>/
 *
 * 🧠 Algorithm:
 * - Short explanation of the approach
 *
 * 🧮 Time Complexity: O(...)
 * 🧠 Space Complexity: O(...)
 * 🎯 Difficulty: Easy/Medium/Hard
 */
public class <ProblemName>LeetCode {

    // Optional constant or helper fields
    private final int UNREACHABLE = -1;

    // Main method for local testing
    public static void main(String[] args) {
        <ProblemName>LeetCode sol = new <ProblemName>LeetCode();
        int[] input = { ... };
        System.out.println("Answer: " + sol.solve(input));
    }

    // Core solution method (signature matches LeetCode)
    public <ReturnType> solve(<Params>) {
        // Implementation
    }
}
