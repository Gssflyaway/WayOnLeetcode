package DP;

public class _213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int max1 = robSub(nums, 0, nums.length-2);
        int max2 = robSub(nums, 1, nums.length-1);

        return max1 > max2 ? max1 : max2;
    }

    private int robSub(int[] nums, int s, int e) {
        if (nums == null || nums.length == 0)
            return 0;
        if (s-e == 0)
            return nums[s];
        int[] dp = new int[nums.length];
        int max = -1;
        dp[s] = nums[s];
        dp[s+1] = nums[s+1];
        max = dp[s] > dp[s+1] ? dp[s] : dp[s+1];
        for (int i=s+2; i<=e; i++){
            int temp = -1, temp1 = -1;
            if (i-3 >= s)
                temp = dp[i-3];
            temp1 = dp[i-2];
            dp[i] = temp > temp1 ? temp : temp1;
            dp[i] += nums[i];
            if (max < dp[i])
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        _213_HouseRobberII main = new _213_HouseRobberII();
        int[] nums = {1,7,9,2};
        System.out.println(main.rob(nums));
    }


}
