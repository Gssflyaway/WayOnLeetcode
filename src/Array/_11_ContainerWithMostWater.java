package Array;

/*
这题不应该做不出来的
这种题思路要弄清楚，一般是先从一个极端条件开始（此题中就是从最两端开始往内），然后变一个条件（此题是往内扫的时候看高度*长度是不是符合，符合的时候变）
* */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int length = height.length;
        if (length <= 1)
            return 0;
        int left = 0, right = length-1;
        int area = -1;
        while (left < right) {
            int tempArea = Math.min(height[left], height[right]) * (right - left);
            if (tempArea > area)
                area = tempArea;
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return area;
    }
}
