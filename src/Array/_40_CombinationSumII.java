package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0 || target <= 0)
            return new ArrayList<>();

        List<List<Integer>> result = parseSolution(candidates, 0, candidates.length, target);
        return result;
    }

    private List<List<Integer>> parseSolution(int[] candidates, int start, int end, int target) {
        if (start > end || target < 0)
            return null;

        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            List<Integer> integerList = new ArrayList<>();
            result.add(integerList);
            return result;
        }
        for (int i=start; i<end;) {
            if (candidates[i] > target)
                break;
            List<List<Integer>> nextLayerResult = parseSolution(candidates, i+1, end, target-candidates[i]);
            if (nextLayerResult != null) {
                for (List<Integer> item : nextLayerResult)
                    item.add(0, candidates[i]);
                result.addAll(nextLayerResult);
            }
            i++;
            while (i<end && candidates[i] == candidates[i-1])
                i++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new _40_CombinationSumII().combinationSum2(new int[]{2,5,2,1,2}, 5));
    }
}
