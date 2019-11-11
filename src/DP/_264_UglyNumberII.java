package DP;

/*
* 思路：后面的丑数除以2/3/5肯定是前面的一个丑数
* 所以分为三个不同的标记去做，而值都存在一个队列里，不断地用前面的去算后面的
* */
public class _264_UglyNumberII {
    public int nthUglyNumber(int n) {
        int index2 = 0, index3 = 0, index5 = 0;
        int[] number = new int[n];
        number[0] = 1;
        int count = 1;
        while (count < n){
            int next2 = number[index2] * 2;
            int next3 = number[index3] * 3;
            int next5 = number[index5] * 5;
            number[count] = Math.min(Math.min(next2, next3), next5);
            if (number[count] == next2)
                index2++;
            if (number[count] == next3)
                index3++;
            if (number[count] == next5)
                index5++;
            count++;
        }
        return number[n-1];
    }

    public static void main(String[] args) {
        _264_UglyNumberII main = new _264_UglyNumberII();
        System.out.println("xxx: " + main.nthUglyNumber(15));
    }
}
