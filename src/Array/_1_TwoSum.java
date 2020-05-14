package Array;

public class _1_TwoSum {
    public int[] twoSum(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return new int[]{};
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] >= target)
                continue;
            for (int j=i+1; j<nums.length; j++) {
                if (target == nums[i] + nums[j])
                    return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}
