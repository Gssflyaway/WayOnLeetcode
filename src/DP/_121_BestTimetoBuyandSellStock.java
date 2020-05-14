package DP;

/*
* easy level题
* 但是想了蛮久
* 思想就是从前往后扫，因为只进行一次交易，那么只需要找出最大的差值
* 设置一个start和end，往后扫的过程中发现值比start的小，那么肯定就要更新start了
* 如果发现值比start大，且差值大于之前的差值，那么就要更新end
* */
public class _121_BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int start = -1, end = -1;
        int profit = 0;

        for (int i=0; i<prices.length; i++) {
            if (start < 0) {
                start = i;
                continue;
            } else if (prices[start] > prices[i]) {
                start = i;
            } else if (prices[i] - prices[start] > profit){
                end = i;
                profit = prices[i] - prices[start];
            }
        }
        return profit;
    }

}
