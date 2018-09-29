package Tree;

/**
 * Created by sigong on 2018/7/18.
 */
public class _96_UniqueBinarySearchTrees {
        public static int numTrees(int n) {
                if(n == 0 ||  n == 1){
                        return 1;
                }
                //不记录，会超时
//                int sum = 0;
//                for(int i=0; i<n; i++){
//                        sum += numTrees(i)*numTrees(n-i-1);
//                }

                int[] a = new int[n+1];
                for (int tmp:a){
                        tmp = 0;
                }
                a[0] = 1;
                for(int i=1; i<=n ;i++){
                        for (int j=0; j<i; j++){
                                a[i] += a[j]*a[i-j-1];
                        }
                }
                return a[n];
        }


        public static void main(String[] args) {
                for (int i=1; i<11; i++){
                        System.out.println(_96_UniqueBinarySearchTrees.numTrees(i));
                }
                System.out.println(_96_UniqueBinarySearchTrees.numTrees(7));
        }
}
