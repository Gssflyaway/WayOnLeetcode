package DP;

public class _72_EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return Integer.MAX_VALUE;
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=0; i<=word1.length(); i++)
            dp[i][0] = i;
        for(int i=0; i<=word2.length(); i++)
            dp[0][i] = i;

        for (int i=1; i<=word1.length(); i++){
            for (int j=1; j<=word2.length(); j++){
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else {
//        插入：在word1[i-1]的位置上插入word2[j-1],也就是说word1[0...i-1]=word2[0...j-1],steps[i][j]=steps[i][j-1]+1
//        替换：将word1[i-1]的值替换为word2[j-1]。steps[i][j]=steps[i-1][j-1]+1
//        删除：将word1[i-1]的值删除使word1[0...i-2]等价于word2[j-1], steps[i][j] = steps[i-1][j]+1
//        每次去比较i,j位置的时候就是把(i-1, j), (i-1, j-1), (i, j-1)分别当做两个字符串的终点
//        然后在这个基础上去插入，替换或者删除
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;//核心在这里
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}
