package DP;

//其实并不是dp的解法，是用数学总结的方式，用dp其实就是把之前的加起来？
/*
这题是个数学题，需要总结,f(n)代表n位是unique的数字个数，注意这里不包括首位为0的情况
N=0: 1(0算作n=0时的情况)
N=1: 9
N=2:9*9
N=3:9*9*8
N=4:9*9*8*7
…
规律大概可以看出来，可以自己去总结，而且脑补可知，0-9总共只有10个数，当超过10位时就不可能有不重复的数了
* */
public class _357_CountNumberswithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        int[] count = new int[n+1];
        count[1] = 10;

        for (int i=2; i<=n; i++){
            if (n > 10) //>10不会有不重复的
                break;
            int temp = 9;
            int item = 9;
            while (item >= (9-(i-2))) {
                temp *=  item;
                item--;
            }
            count[i] = temp;
        }

        if (n > 10)
            n = 10;
        for (int i=1; i<n; i++){
            count[n] += count[i];
        }
        return count[n];
    }

    public static void main(String[] args) {
        new _357_CountNumberswithUniqueDigits().countNumbersWithUniqueDigits(6);
    }
}
