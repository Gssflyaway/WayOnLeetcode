package DP;

public class _309_BestTimetoBuyandSellStockwithCooldown {
    //会tle
//    public int maxProfit(int[] prices) {
//        if (prices == null || prices.length == 0)
//            return 0;
//        int length = prices.length;
//        int[][] dp = new int[length][length];
//        int max = 0;
//
//        for (int step=1; step<length; step++) {
//            for (int i=0; i<length-step; i++){
//                int direct = prices[i+step]-prices[i]>0 ? prices[i+step]-prices[i] : 0;
//                for (int j=0; j<step; j++){
//
//                    int temp = dp[i][i+j];
//                    if (j+2 < step && j != 0)
//                        temp += dp[i+j+2][i+step];
//                    else if (j == 0)
//                        temp += dp[i+1][i+step];
//                    if (direct < temp)
//                        direct = temp;
//                }
//                dp[i][i+step] = direct;
//            }
//        }
//
//        return dp[0][length-1];
//    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int hold = Integer.MIN_VALUE, rest = 0, sell = 0;
        for (int i=0; i<prices.length; i++) {
            int holdPrev = hold, restPrev = rest, sellPrev = sell;
            hold = Math.max(holdPrev, restPrev - prices[i]);
            rest = Math.max(restPrev, sellPrev);
            sell = holdPrev + prices[i];
        }

        return hold > sell ? hold > rest ? hold : rest : sell > rest ? sell : rest;
    }

    public static void main(String[] args) {
        System.out.println(new _309_BestTimetoBuyandSellStockwithCooldown().maxProfit(new int[]{2,1,4}));
    }
}
