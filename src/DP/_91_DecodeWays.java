package DP;

public class _91_DecodeWays {
    public int numDecodings(String s) {
        if (s ==  null || s.charAt(0) == '0')
            return 0;
        if (s.length() <= 1)
            return s.length();
        int[] dp = new int[s.length()+1];
        dp[1] = dp[0] = 1;

        for (int i=1; i<s.length(); i++){
            int num1 = s.charAt(i-1) - '0';
            int num2 = s.charAt(i) - '0';
            int temp = 10 * num1 + num2;
            if (temp == 0)
                return 0;
            if (temp <= 26 && num1 > 0)
                dp[i+1] += dp[i-1];
            if (num2 != 0)
                dp[i+1] += dp[i];
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new _91_DecodeWays().numDecodings("10"));
    }
}
