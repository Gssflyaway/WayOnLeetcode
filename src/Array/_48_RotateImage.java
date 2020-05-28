package Array;

public class _48_RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length == 1)
            return;

        int len = matrix[0].length;
        for (int i=0; i<(len+1)/2; i++) {
            for (int j=i; j<len-1-i; j++) {
                int temp = matrix[j][len-1-i];

                matrix[j][len-1-i] = matrix[i][j];
                matrix[i][j] = matrix[len-1-j][i];
                matrix[len-1-j][i] = matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j] = temp;
            }
        }

//        System.out.println(matrix);
    }

    public static void main(String[] args) {
        new _48_RotateImage().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
