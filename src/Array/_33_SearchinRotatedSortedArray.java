package Array;

public class _33_SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0, end = nums.length;
        int mid = start + (end-start)/2;
        while (start < end) {
            if (nums[mid] == target)
                return mid;
            if (mid == 0)
                return nums[0] == target ? 0 : -1;
            if (nums[mid] < nums[mid-1])
                break;
            else {
                if (nums[mid] > nums[0])
                    start = mid + 1;
                else
                    end = mid;
                mid = start + (end-start)/2;
            }
        }

        if (mid == nums.length) {
            start = 0;
            end = mid;
        } else {
            if (target > nums[mid] && target <= nums[nums.length-1]) {
                start = mid + 1;
                end = nums.length;
            } else {
                start = 0;
                end = mid;
            }
        }

        mid = start + (end-start)/2;
        while (start < end){
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                end = mid;
            else
                start = mid + 1;
            mid = start + (end-start)/2;
        }
        return -1;
    }

    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;
        int len = nums.length;
        int start = 0, end = len;
        int mid = -1;

        while (start<end) {
            mid = start + (end-start)/2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > nums[start]) {
                if (target < nums[start])
                    start = mid+1;
                else if (target > nums[mid])
                    start = mid+1;
                else
                    end = mid;
            } else {
                if (target >= nums[start])
                    end = mid;
                else if (target < nums[mid])
                    end = mid;
                else
                    start = mid + 1;
            }
        }
        System.out.println(start + " " + mid + " " + end);
        if (mid >= len)
            return -1;
        return nums[mid] == target ? mid : -1;
    }

    public static void main(String[] args) {
        System.out.println(new _33_SearchinRotatedSortedArray().search1(new int[]{3,1}, 2));
    }
}
