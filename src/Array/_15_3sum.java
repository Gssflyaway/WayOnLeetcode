package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i=0; i<nums.length-1;) {
            int newTarget = 0 - nums[i];
            for (int s=i+1,t=nums.length-1; s<t;) {
                int temp = nums[s] + nums[t];
                if (temp == newTarget){
                    List<Integer> newSolution = new ArrayList<>(4);
                    newSolution.add(nums[i]);
                    newSolution.add(nums[s]);
                    newSolution.add(nums[t]);
                    resultList.add(newSolution);
                    s++;
                    while (s < t && nums[s] == nums[s-1]) s++;
                    t--;
                    while (s < t && nums[t] == nums[t+1]) t--;
                } else if (temp < newTarget) {
                    s++;
                    while (s < t && nums[s] == nums[s-1]) s++;
                } else {
                    t--;
                    while (s < t && nums[t] == nums[t+1]) t--;
                }
            }
            i++;
            while (i>0 && i<nums.length-1 && nums[i] == nums[i-1]) i++;
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new _15_3sum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
