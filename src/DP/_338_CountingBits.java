package DP;

public class _338_CountingBits {
    public int[] countBits(int num) {
        if (num <= 0)
            return new int[]{0};
        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        int lastFlag = 0;
        for (int i=2; i<=num; i++) {
            int quotient = i / 2, remainder = i % 2;
            if (dp[quotient] == 1 && remainder == 0) {
                dp[i] = 1;
                lastFlag = i;
            }
            else {
                dp[i] = 1 + dp[i-lastFlag];
            }
        }

        return dp;

    }

    public static void main(String[] args) {
        System.out.println(new _338_CountingBits().countBits(10));
    }
}
