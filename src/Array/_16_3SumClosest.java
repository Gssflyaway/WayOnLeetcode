package Array;

import java.util.Arrays;

public class _16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE, result = Integer.MAX_VALUE;
        for (int i=0; i<nums.length-1; i++){
            int newTarget = target-nums[i];
            int start = i+1, end = nums.length-1;
            while (start < end){
                int temp = Math.abs(newTarget - (nums[start] + nums[end]));
                if (temp < gap){
                    if (temp == 0)
                        return target;
                    gap = temp;
                    result = nums[start] + nums[end] + nums[i];
                }
                if (nums[start] + nums[end] > newTarget)
                    end--;
                else
                    start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new _16_3SumClosest().threeSumClosest(new int[]{-1,2,1,4}, 1);
    }
}
