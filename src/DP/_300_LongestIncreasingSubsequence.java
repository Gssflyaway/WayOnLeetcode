package DP;

import java.util.TreeSet;

public class _300_LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for(int num : nums) {
            Integer ceil = set.ceiling(num);
            if(ceil != null) set.remove(ceil);
            set.add(num);
        }
        return set.size();
    }


    public static void main(String[] args) {
        _300_LongestIncreasingSubsequence main = new _300_LongestIncreasingSubsequence();
        System.out.println(main.lengthOfLIS(new int[]{2, 7, 8, 3, 4, 5}));
    }
}
