package DP;

public class _63_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[obstacleGrid.length+1][obstacleGrid[0].length];
        int height = 0;
        for (int i=0; i<obstacleGrid.length; i++){
            height = i;
            for (int j=0; j<obstacleGrid[i].length; j++){
                if (i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                if (obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }

                int topMethod = j-1 >= 0 ? dp[i][j-1] : 0;
                int leftMethod = i-1 >=0 ? dp[i-1][j] : 0;
                dp[i][j] = leftMethod + topMethod;
            }
        }
        return dp[height][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        _63_UniquePathsII main = new _63_UniquePathsII();
        System.out.println(main.uniquePathsWithObstacles(new int[][]{{0,0}}));
    }

}
