package DP;

import java.util.List;

public class _139_wordbreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        if (s == null || wordDict == null || wordDict.size() == 0)
            return false;

        for (int  i=0; i<s.length(); i++){
            for (int j=0; j<=i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i+1)))
                    dp[i+1] = true;
            }
        }
        return dp[s.length()];
    }

}
