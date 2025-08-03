
/**
 * Calculates the maximum profit from stock prices,
 * allowing multiple transactions (buy/sell) as long as you don't hold more than one stock at a time.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150
 *
 * 🧠 Algorithm (Greedy Peak Valley Detection):
 * - Start with the first day's price as the initial buy.
 * - Whenever a price drop is detected, sell at the previous peak and reset the buy price.
 * - After the loop, if the last price is higher than the last buy price, sell it.
 *
 * 🧮 Time Complexity: O(n)
 * - Traverse the array once.
 *
 * 💾 Space Complexity: O(1)
 * - No extra space used.
 *
 * 🎯 Difficulty: Medium
 * - Slightly more intuitive than dynamic programming; based on trend following.
 */
public class BestTimeToSellStock2 {

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            // If today's price is lower than yesterday's, sell at yesterday's peak
            if (prices[i] < prices[i - 1]) {
                profit += prices[i - 1] - buyPrice;
                buyPrice = prices[i]; // Set new buy price
            }
        }

        // Final sell if the last price is still higher than the last buy price
        if (prices[prices.length - 1] > buyPrice) {
            profit += prices[prices.length - 1] - buyPrice;
        }

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToSellStock2 s = new BestTimeToSellStock2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max profit: " + s.maxProfit(prices)); // Output: 7
    }

}
