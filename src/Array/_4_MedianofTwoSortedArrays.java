package Array;

public class _4_MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 && len2 == 0)
            return 0;
        if (len1 > len2)
            return findMedianSortedArrays(nums2, nums1);

        int start = 0, end = len1, mid1 = 0, mid2 = 0;
        int midIndex = (len1+len2+1) / 2;
        while (start < end) {
            mid1 = start + (end-start)/2;
            mid2 = midIndex - mid1;
            if (nums1[mid1] > nums2[mid2-1])
                end = mid1;
            else
                start++;
        }
        mid1 = start;
        mid2 = midIndex - mid1;

        int left = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
        left = Math.max(left,mid2 == 0 ? Integer.MIN_VALUE :  nums2[mid2-1]);
        if ((len1+len2)%2 == 1){
            return left;
        }

        int right = Math.min(mid1 == len1 ? Integer.MAX_VALUE : nums1[mid1], mid2 == len2 ? Integer.MAX_VALUE : nums2[mid2]);
        return (right+left) / 2.0;
    }

    public static void main(String[] args) {
        System.out.println(new _4_MedianofTwoSortedArrays().findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
