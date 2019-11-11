package Sort;

public class HeapSort {

    public void heapSort(int[] nums){
        for (int i=0; i<nums.length-1; i++){
            heapAdjust(nums, 0, nums.length-1-i);
            swap(nums, 0, nums.length-1-i);
            print(nums);
        }
    }

    private void heapAdjust(int[] nums, int s, int e) {
        for (int i=(e-1)/2; i>=0; i--){
            int j = 2 * i +1;
            if (j+1 <= e && nums[j] < nums[j+1]){
                j = j + 1;
            }
            if (nums[i] < nums[j]){
                swap(nums, i, j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j)
            return;
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];

    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(new int[]{5, 3, 6, 2, 1, 9, 4, 8, 7 });
    }
}
