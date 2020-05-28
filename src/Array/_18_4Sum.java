package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int level = 4;
        if (nums.length < 4)
            return new ArrayList<>();

        Arrays.sort(nums);
        return getSolution(nums, level, 0, target);
    }

    private List<List<Integer>> getSolution(int[] nums, int level, int start, int target) {
        List<List<Integer>> subResultList = new ArrayList<>();
        if (level > 2){
            for (int i=start; i<nums.length-level+1; ) {
                int newTarget = target - nums[i];
                List<List<Integer>> tempList = getSolution(nums, level-1, i+1, newTarget);
                for (List<Integer> item: tempList){
                    item.add(0, nums[i]);
                }
                subResultList.addAll(tempList);
                i++;
                while(i<nums.length-level+1 && nums[i] == nums[i-1])  i++;
            }
        } else if (level == 2) {
            int startIndex = start, endIndex = nums.length-1;
            while (startIndex < endIndex) {
                if (nums[startIndex] + nums[endIndex] == target){
                    List<Integer> solution = new ArrayList<>();
                    solution.add(nums[startIndex]);
                    solution.add(nums[endIndex]);
                    subResultList.add(solution);
                    startIndex++;
                    endIndex--;
                    while(startIndex < endIndex && nums[startIndex] == nums[startIndex-1])  startIndex++;
                    while(startIndex < endIndex && nums[endIndex] == nums[endIndex+1])  endIndex--;
                } else if (nums[startIndex] + nums[endIndex] < target){
                    startIndex++;
                    while(startIndex < endIndex && nums[startIndex] == nums[startIndex-1])  startIndex++;
                } else {
                    endIndex--;
                    while(startIndex < endIndex && nums[endIndex] == nums[endIndex+1])  endIndex--;
                }
            }
        }
        return subResultList;
    }

    public static void main(String[] args) {
        System.out.println(new _18_4Sum().fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0));
    }

}
