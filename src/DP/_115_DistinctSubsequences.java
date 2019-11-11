package DP;

/*
* 这个题主要是求s中非连续的t的个数
* 思路是dp数组中dp[i][j]表示的是s的前i位包含多少个非连续的t的前j位
* 如果s[i] == t[j]， 那么dp[i][j] = dp[i-1][j-1] + dp[i-1][j]; 意思就是s的前i-1位包含t的前j-1位或者j位两种情况的和
* 不等于的话，dp[i][j] = dp[i-1][j];
* */
public class _115_DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null)
            return 0;
        if ("".equals(t))
            return 1;
        if (s.length() < t.length())
            return 0;

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i=0 ;i<s.length()+1; i++)
            dp[i][0] = 1;
        for (int i=0; i<t.length()+1; i++)
            dp[0][i] = 1;

        for (int i=1; i<s.length()+1; i++){
            for (int j=1; j<=i && j<t.length()+1; j++){
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    if (i - 1 < j)
                        dp[i-1][j] = 0;
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else{
                    if (i-1 < j)
                        dp[i][j] = 0;
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        _115_DistinctSubsequences main = new _115_DistinctSubsequences();
        System.out.println(main.numDistinct("rabbbit", "rabbit"));
    }
}
