package DP;

public class _64_MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null)
            return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0; i<dp.length; i++){
            for (int j=0; j<dp[0].length; j++){
                if (i == 0 && j ==0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int top = j-1 >= 0 ? dp[i][j-1] : Integer.MAX_VALUE;
                int left = i-1 >= 0 ? dp[i-1][j] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(top, left) + grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
