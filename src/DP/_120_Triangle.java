package DP;

import java.util.List;

//从下往上扫就ok
public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null)
            return 0;
        int len = triangle.size();
        if (len == 1)
            return triangle.get(0).get(0);
        int[] dp = new int[len];

        List<Integer> integers = triangle.get(len-1);
        for (int i=0; i<integers.size(); i++)
            dp[i] = integers.get(i);

        for (int i=triangle.size() - 2; i>=0; i--){
            for (int j=0; j<triangle.get(i).size(); j++){
                dp[j] = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j);//1
                triangle.get(i).set(j, dp[j]);//2
                //1+2 -> dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}

