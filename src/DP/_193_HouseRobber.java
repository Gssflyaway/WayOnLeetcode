package DP;

public class _193_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = dp[0] > dp[1] ? dp[0] : dp[1];

        for (int i=2; i<nums.length; i++){
            int temp = -1, temp1 = -1;
            if (i - 3 >= 0)
                temp = dp[i-3];
            temp1 = dp[i-2];
            dp[i] = temp > temp1 ? temp : temp1;
            dp[i] += nums[i];
            //下面确实是此题的状态转移方程
            //但是这样做过不了，因为其实dp[1]并没有应用这个方程，可能导致后面的结果不准确，比如nums是2，1，1，2这种情况，就算不对
            //正确的用法应该是dp的数组长度为nums的长度+1，然后从dp[1]开始应用这个方程
//            dp[i] = dp[i-1] > dp[i-2] + nums[i] ? dp[i-1] : dp[i-2] + nums[i];
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        _193_HouseRobber main = new _193_HouseRobber();
        int[] nums = {1,8,2,1,5};
        System.out.println(main.rob(nums));
    }
}
