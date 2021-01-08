package Fib_log_n;

import java.util.Arrays;

public class fib_log_n {


    static long[][] multMatrix(long[][] mat, long[][] mat2) {

        long[][] ans = new long[2][2];

        ans[0][0] = mat[0][0] * mat2[0][0] + mat[0][1] * mat2[1][0];
        ans[0][1] = mat[0][0] * mat2[0][1] + mat[0][1] * mat2[1][1];
        ans[1][0] = mat[1][0] * mat2[0][0] + mat[1][1] * mat2[1][0];
        ans[1][1] = mat[1][0] * mat2[0][1] + mat[1][1] * mat2[1][1];

        return ans;
    }

    static long fibLoop(int n) { // log(n)

        int k = n;
        if (k == 1 || k == 2) return 1; // This is the case of the two first numbers in fib
        k -= 2;

        long mat[][] = {{1, 1}, {1, 0}};
        long result[][] = {{1, 1}, {1, 0}};
        while (k != 0) {
            if ((k % 2) != 0)
                result = multMatrix(result, mat);
            mat = multMatrix(mat, mat);
            k /= 2;
        }
        System.out.println("F(" + n + ")=" + result[0][0]);
        return result[0][0];
    }


    public static void main(String[] args) {

        fibLoop(8);

    }


}
