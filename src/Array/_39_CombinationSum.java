package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || target < 0)
            return new ArrayList<>();

        List<List<Integer>> result = parseSolution(candidates, 0, candidates.length, target);
        return result;
    }

    private List<List<Integer>> parseSolution(int[] candidates, int start, int end, int target) {
        if (start >= end || target < 0)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            List<Integer> integerList = new ArrayList<>();
//            integerList.add(target);
            result.add(integerList);
            return result;
        }
        for (int i=start; i<end; i++) {
            if (candidates[i] > target)
                break;
            //两种皆可以
//            if (candidates[i] == target) {
//                List<Integer> integerList = new ArrayList<>();
//                integerList.add(target);
//                result.add(integerList);
//                break;
//            }
            List<List<Integer>> nextLayerResult = parseSolution(candidates, i, end, target-candidates[i]);

            for (int j=0; j<nextLayerResult.size(); j++){
                nextLayerResult.get(j).add(0, candidates[i]);
            }
            result.addAll(nextLayerResult);
        }
        return result;
    }

    public static void main(String[] args) {
        new _39_CombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
    }
}
