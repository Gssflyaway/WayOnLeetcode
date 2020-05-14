package DP;

import java.util.Arrays;

public class _322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
            return 0;

        int[] dp = new int[amount + 1];

        for (int i=1; i<= amount; i++) {
            for (int j=0; j<coins.length; j++){
                if (coins[j] == i) {
                    dp[i] = 1;
                    break;
                } else if (coins[j] < i && dp[i-coins[j]] != 0){
                    if (dp[i] == 0)
                        dp[i] = dp[i-coins[j]] + 1;
                    else
                        dp[i] = dp[i-coins[j]] + 1 > dp[i] ? dp[i] : dp[i-coins[j]] + 1;
                }
            }
        }
        int result = dp[amount] == 0 ? -1 : dp[amount];
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _322_CoinChange().coinChange(new int[]{1}, 0));
    }
}
