/**
 * Finds the maximum profit from buying and selling a stock once.
 *
 * 🔗 LeetCode Link:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * 🧠 Algorithm:
 * - Traverse the prices array from right to left.
 * - Track the maximum future selling price from each day forward using DayPrice.
 * - For each day, calculate the profit if you bought on that day and sold at the max future price.
 * - Return the highest profit found.
 *
 * 🧮 Time Complexity: O(n)
 * - Two single-pass traversals of the array.
 *
 * 💾 Space Complexity: O(n)
 * - Uses an auxiliary array to store max selling price per day.
 *
 * 🎯 Difficulty: Easy–Medium
 * - Requires understanding of future-looking max tracking.
 */

public class MaxProfitWithDayPrice {

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println("Max profit (example 1): " + maxProfit(prices1)); // Output: 5
        System.out.println("Max profit (example 2): " + maxProfit(prices2)); // Output: 0
    }

    /**
     * Computes the maximum profit from a single buy and sell transaction.
     * @param prices Array of stock prices by day
     * @return Maximum possible profit
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        DayPrice[] maxFuture = new DayPrice[n];
        DayPrice currentMax = new DayPrice(n - 1, prices[n - 1]);

        // Precompute the max price from current day to the end
        for (int i = n - 1; i >= 0; i--) {
            if (prices[i] > currentMax.getPrice()) {
                currentMax = new DayPrice(i, prices[i]);
            }
            maxFuture[i] = new DayPrice(currentMax.getDay(), currentMax.getPrice());
        }

        // Compute max profit by buying on day i and selling at future max price
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int profit = maxFuture[i].getPrice() - prices[i];
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    /**
     * Represents a price at a given day.
     */
    static class DayPrice {
        private final int day;
        private final int price;

        public DayPrice(int day, int price) {
            this.day = day;
            this.price = price;
        }

        public int getPrice() {
            return this.price;
        }

        public int getDay() {
            return this.day;
        }
    }
}
