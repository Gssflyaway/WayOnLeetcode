package DP;

/*
* 分段找最大的
* 第21行total+local千万别忘了
* 如果忘了1，2，3，4，5这种情况就处理不了了！
* */
public class _122_BestTimetoBuyandSellStock2 {
    public static int maxProfit(int[] prices) {
        int start = -1;
        int total = 0, local = 0;

        for (int i=0; i<prices.length; i++){
            if (start < 0 || prices[i] < prices[i-1]) {
                start = i;
                total += local;
                local = 0;
            } else if (prices[i] - prices[start] > local) {
                local = prices[i] - prices[start];
            }
        }
        return total + local;
    }

    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }
}
