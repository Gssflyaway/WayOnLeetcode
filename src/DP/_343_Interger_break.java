package DP;

//这里有两种思路：
//自己想的：就是n肯定是由a*b组成，其中a,b可以再拆分，这样就可以用上dp，但是需要注意，dp[n]不一定是最大的，因为对于2，3来说dp[n]<n，不过可以特殊处理
//更好的办法，n可以拆分为尽量多的3以及不多于两个2
//数学证明就是对于一个数a，拆成2*（a-2），只要n>4时，2*（a-2）都是>a的，也就是说只要是a>4都可以再拆，而为什么尽量多的3，是因为对于2*2*2，和3*3，
//明显3*3更优秀，唯一的特殊情况就是2*2*3 > 1*3*3，所以只需要判断4这种特殊情况就可以
public class _343_Interger_break {
    public int integerBreak(int n) {
        if (n <= 2)
            return 1;
        else if (n == 3)
            return 2;
        else if (n == 4)
            return 4;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for (int i=5; i<=n; i++){
            int temp = 0;
            for (int j=0; j<i; j++){
                int temp1 = dp[j] > j ? dp[j] : j;
                int temp2 = dp[i-j] > i-j ? dp[i-j] : i-j;
                int product = temp1 * temp2;
                temp = temp > product ? temp : product;
            }
            dp[i] = temp;
        }
        return dp[n];
    }

    public int integerBreak1(int n) {
        if (n <= 2)
            return 1;
        else if (n == 3)
            return 2;
        else if (n == 4)
            return 4;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;

        for (int i = 5; i <= n; i++) {
            int temp = i, result = 1;
            while (temp > 4) {
                result *= 3;
                temp -= 3;
            }

            if (temp != 0)
                result *= temp;

            dp[i] = result;
        }
        return dp[n];
    }
}
