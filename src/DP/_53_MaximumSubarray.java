package DP;

/*
* 这里面还算了初始和结束位置
* 思想就是local存的是包含当前节点的最大值，如果local>0，表示包含当前节点的字符串还有机会变成最大的，但是如果<0,除非所有都是负数，不然包含此节点的子串不可能最大
* 如果local小于0，那就表示从下一个开始要重新开始新一轮的计算了
* 这是核心的逻辑
* 如果用dp的思想就是dp[i] = max(temp[i], dp[i-1])； temp[i] = max(num[i], num[i] + temp[i-1])
* temp是包含第i个元素本身的最大值
* dp是前i个的最大值
* */
public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int local = nums[0], global = nums[0];
        int temp = 0;
        int start = 0, end = 0;
        for (int i=1; i<nums.length; i++){
            if (local < 0) {
                local = 0;
                temp = i;//local<0，表示从这个数开始又开始新的计算了，即temp是新一轮计算的起点
            }
            local += nums[i];
            if (local > global){
                start = temp;//如果local>global代表新的全局最大值产生了，temp存的是起点
                global = local;
                end = i;
            }
        }
        System.out.println("Start: " + start + " End: " + end);
        return global;
    }

    public static void main(String[] args) {
        _53_MaximumSubarray main = new _53_MaximumSubarray();
//        int[] ary = {1, -2, 3, 10, -4, 7, 2, -5};
//        int[] ary = {4, -10, 3, 5, -1, 2};
        int[] ary = {-9, -2, -3, -5, -3};
//        int[] ary = {1, -2, 3, 5, -3, 2};
        System.out.println(main.maxSubArray(ary));
    }
}
