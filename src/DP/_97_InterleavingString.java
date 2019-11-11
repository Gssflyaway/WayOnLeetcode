package DP;

public class _97_InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if ("".equals(s1))
            return s2.equals(s3);
        if ("".equals(s2))
            return s1.equals(s3);
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;

        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for (int i=1; i<=len1; i++){
            if (dp[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1)){
                dp[i][0] = true;
            }else {
                dp[i][0] = false;
            }
        }
        for (int i=1; i<=len2; i++){
            if (dp[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1)){
                dp[0][i] = true;
            }else {
                dp[0][i] = false;
            }
        }
        for (int i=1; i<=len1; i++){
            for (int j=1; j<=len2; j++){
                System.out.println(s1.charAt(i-1) + " !!! " + s3.charAt(i+j-1) + " !!! " + s2.charAt(j-1));
                if ((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)))
                    dp[i][j] = true;
                else
                    dp[i][j] = false;
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        _97_InterleavingString main = new _97_InterleavingString();
//        System.out.println(main.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(main.isInterleave("aa", "ab", "abaa"));
    }
}
