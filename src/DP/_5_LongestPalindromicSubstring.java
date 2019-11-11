package DP;

import java.util.Arrays;

public class _5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s == "")
            return "";
        char[] stringArray = s.toCharArray();
        int len = stringArray.length;
        int[][] dp = new int[len][len];
        int max = 0, start = 0, end = 0;

        for (int i=0; i<len; i++) {
            dp[i][i] = 1;
        }

        for (int step=1; step<len; step++){
            for (int i=0, j=i+step; i<len && j<len; i++, j++) {
                if (stringArray[i] != stringArray[j])
                    dp[i][j] = 0;
                else {
                    if (j==i+1){
                        dp[i][j] = 2;
                        if (dp[i][j] > max){
                            max = dp[i][j];
                            start = i;
                            end = j;
                        }
                    } else {
                        if (dp[i+1][j-1] == 0)
                            dp[i][j] = 0;
                        else {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                            if (dp[i][j] > max){
                                max = dp[i][j];
                                start = i;
                                end = j;
                            }
                        }
                    }
                }
            }
        }
        return new String(Arrays.copyOfRange(stringArray, start, end+1));
    }

    public static void main(String[] args) {
        _5_LongestPalindromicSubstring main = new _5_LongestPalindromicSubstring();
        System.out.println(main.longestPalindrome("aaaa"));
    }
}
