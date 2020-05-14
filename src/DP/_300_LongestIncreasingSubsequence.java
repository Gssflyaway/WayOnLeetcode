package DP;

import java.util.Arrays;
import java.util.TreeSet;

public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i=1; i<nums.length; i++){
            for (int j=0; j<i; j++){
                if (nums[j] < nums[i] && (dp[j] + 1 > dp[i])){
                    dp[i] = dp[j] + 1;
                    if (max < dp[i])
                        max = dp[i];
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        _300_LongestIncreasingSubsequence main = new _300_LongestIncreasingSubsequence();
        System.out.println(main.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
