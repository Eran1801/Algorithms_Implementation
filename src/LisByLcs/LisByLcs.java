package LisByLcs;

import java.util.Arrays;

public class LisByLcs {


    /**
     * In this class we gets the LIS with the help of LCS algorithm :
     * ---------
     * In the first function "createHelpArray" we create a new Array in the same size of the original and just putting
     * the same values in this Array.
     * ---------
     * In the second function we build the matrix and also the ans array that will contains the LIS in numbers
     */

    public static int createHelpArray(int[] oriArray) {
        int[] helpArray = new int[oriArray.length];
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = oriArray[i];
        }
        // Sorting the helpArray, and know "oriArray" is not sorted and "helpArray" it is but inside them there is the same values
        Arrays.sort(helpArray);
        return length(oriArray, helpArray);
    }

    public static int length(int[] a, int[] b) {
        int mat[][] = buildMatrix(a, b);// Create a two-dimension matrix
        int i = mat.length - 1; // the size of the rows
        int j = mat[0].length - 1; // the size of the column
        int end = mat[i][j]; // inside the end val there is the length of the LIS
        int[] ans = new int[end]; // This array will be the ans - the LIS
        int start = 0;
        while (start < end) {
            if (a[i - 1] == b[j - 1]) {
                ans[end - start - 1] = a[i - 1];
                i--;
                j--;
                start++;
            } else if (mat[i - 1][j] >= mat[i][j - 1]) i--;
            else j--;
        }
        System.out.println("The LIS is : " + Arrays.toString(ans));
        System.out.println("And the size of it is :");
        return mat[mat.length - 1][mat.length - 1];
    }

    public static int[][] buildMatrix(int[] X, int[] Y) {
        int[][] mat = new int[X.length + 1][Y.length + 1]; // Building the array that is size is +1 bigger from the row and the column
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (X[i - 1] == Y[j - 1]) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }
        return mat;
    }


    public static void main(String[] args) {
        int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15,-5};

        System.out.println(createHelpArray(a));
    }
}



