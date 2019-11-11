package DP;

/*
* 给了一个数字n，开始的想法是从1,4,9...这样一直找找到所有完美数然后再把n-完美数再用同样的方法算一次，也就是注释部分的思路
* 但是这样时间复杂度似乎有点高
* 于是从1开始往后一个一个记录，这样后面的算可以基于前面的基础
*
* */
public class _279_PerfectSquares {
    public int numSquares(int n) {
        if (n < 4)
            return n;
        int[] num = new int[n+1];
        num[1] = 1;
        num[2] = 2;
        num[3] = 3;
        num[4] = 1;
        for (int i=5; i<=n; i++){
            newGetSquare(i, num);
        }
        return num[n];
//        return getSquare(n, num);
    }

    private void newGetSquare(int n, int[] num) {
        int base = 1;
        int min = Integer.MAX_VALUE;
        while (true){
            int prod = base * base;
            if (prod == n) {
                num[n] = 1;
                break;
            }
            else if (prod > n) {
                num[n] = min;
                break;
            }
            else
                min = Math.min(min, 1 + num[n-prod]);
            base++;
        }
    }

    public static void main(String[] args) {
        _279_PerfectSquares main = new _279_PerfectSquares();
        main.numSquares(12);
    }

//    private int getSquare(int n, int[] num) {
//        int base = 1;
//        int min = Integer.MAX_VALUE;
//        while (true){
//            int prod = base * base;
//            if (prod == n)
//                return 1;
//            else if (prod > n)
//                break;
//            else{
//                min = Math.min(min, 1 + getSquare(n-prod, num));
//            }
//            base++;
//        }
//        return min;
//    }
}
