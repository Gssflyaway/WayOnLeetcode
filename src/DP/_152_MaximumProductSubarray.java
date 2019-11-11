package DP;

/*
* 与53题求最大连续子序列和差不多
* dp[i]=max(tempMax[i-1]*nums[i], tempMin[i-1]*nums[i], dp[i-1], nums[i])
* 为什么还有nums[i]，因为nums[i-1]可能会为0，这样max和min都是0了
* */
public class _152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int localMin = nums[0], localMax = nums[0], global = nums[0];
        for (int i=1; i<nums.length; i++){
            int tempMin = Math.min(Math.min(nums[i], nums[i]*localMax),  nums[i]*localMin);
            int tempMax = Math.max(Math.max(nums[i], nums[i]*localMax),  nums[i]*localMin);
            localMax = tempMax;
            localMin = tempMin;
            if (tempMax > global)
                global = tempMax;
        }
        return global;
    }
}
