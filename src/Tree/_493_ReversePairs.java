package Tree;

public class _493_ReversePairs {
    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        mergeSort(nums, 0, nums.length-1);
        return count;
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start == end){
            return ;
        }

        mergeSort(nums, start, (start + end)/2);
        mergeSort(nums, (start + end)/2 + 1, end);
        merge(nums, start, (start + end)/2, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[nums.length];
        int i = mid, j = end;
        int index = end;

        while (i>=start && j>mid){
            if (nums[i] > 2*nums[j]){
                count += j-mid;
                i--;
            }else {
                j--;
            }
        }

        i = mid;
        j = end;
        while (i>=start && j>mid){
            if (nums[i] > nums[j]){
                temp[index--] = nums[i--];
            }else {
                temp[index--] = nums[j--];
            }
        }
        while (i>=start)
            temp[index--] = nums[i--];
        while (j>mid)
            temp[index--] = nums[j--];
        for (i = start; i <= end; i++)
            nums[i] = temp[i];
    }

    public static void main(String[] args) {
        _493_ReversePairs main = new _493_ReversePairs();
        int[] nums = {-5, -5};
        System.out.println(main.reversePairs(nums));
    }
}
