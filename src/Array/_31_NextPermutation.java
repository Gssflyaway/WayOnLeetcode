package Array;

import java.util.Arrays;

public class _31_NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;

        int len = nums.length;
        for (int i=len-1; i>0; i--) {
            if (i == 1 && nums[0] > nums[1]) {
                Arrays.sort(nums);
                break;
            }

            if (nums[i] > nums[i-1]) {
                int ceilIndex = i, ceilValue = nums[i];
                for (int j=i+1; j<len; j++){
                    if (nums[j] <= nums[i-1])
                        continue;
                    if (nums[j] < ceilValue) {
                        ceilIndex = j;
                        ceilValue = nums[j];
                    }
                }
                int temp = nums[ceilIndex];
                nums[ceilIndex] = nums[i-1];
                nums[i-1] = temp;
                Arrays.sort(nums, i, len);
                break;
            }
        }
//        System.out.println(Arrays.stream(nums).allMatch(i -> i%2==0));
        System.out.println(nums);
    }

    public static void main(String[] args) {
        new _31_NextPermutation().nextPermutation(new int[]{1,5,1});
    }
}
