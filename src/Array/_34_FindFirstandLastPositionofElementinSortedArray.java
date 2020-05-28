package Array;

public class _34_FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int start = 0, end = nums.length;
        int mid = -1;
        while (start < end) {
            mid = start + (end-start)/2;
            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid;
            else {
                int left = parseBorder(nums, start, mid+1, target, true);
                int right = parseBorder(nums, mid, nums.length, target, false);
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }

    private int parseBorder(int[] nums, int start, int end, int target, boolean left) {
        int index = -1;
        while (start < end) {
            int mid = start + (end-start)/2;
            if (nums[mid] < target)
                start = mid + 1;
            else if (nums[mid] > target)
                end = mid;
            else {
                if (left) {
                    end = mid;
                    index = mid;
                } else {
                    start = mid + 1;
                    index = mid;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new _34_FindFirstandLastPositionofElementinSortedArray().searchRange(new int[]{5,7,7,8,8,10}, 5);
    }
}
