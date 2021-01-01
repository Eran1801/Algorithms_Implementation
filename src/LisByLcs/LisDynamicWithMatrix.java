package LisByLcs;

import java.util.Arrays;

public class LisDynamicWithMatrix {

    // Complexity time : O(n^2 + nlog(n))
    // in this algorithm we only look on the diagonal in the matrix.
    // in the end, the last row will be the the LIS himself, and the diagonal will be the size of the LIS

    public static void LIS(int[] arr) {

        int sizeArr = arr.length;
        int matrix[][] = new int[sizeArr][sizeArr]; // in our case is 10 X 10
        matrix[0][0] = arr[0]; // initialization the first place in the matrix
        int currentLengthLis = 0;

        for (int i = 1; i < sizeArr; i++) {
            // know the binarySearch goes through the diagnol in the matrix
            int index = binarySearchBetween(matrix, currentLengthLis, arr[i]);
            for (int j = 0; j < index; j++) {
                matrix[index][j] = matrix[index - 1][j]; // copy's all the numbers that are above me
            }
            matrix[index][index] = arr[i]; // every time [index][index] is the diagonal of the matrix
            if (index > currentLengthLis)
                currentLengthLis++; // the size of the lis grows

        }
        int[] lis = new int[currentLengthLis + 1]; // this is the final lis array to print it and get its size
        for (int i = 0; i <= currentLengthLis; i++) {
            lis[i] = matrix[currentLengthLis][i];
        }
        System.out.println("The lis is:" + Arrays.toString(lis));
        System.out.println("And its length is :" + lis.length);
        return;

    }

    public static int binarySearchBetween(int[][] matrix, int currentLengthLis, int key) {

        int left = 0;
        int right = currentLengthLis; // == end  // the index of right is the size of the current LIS
        int middle;

        if (key < matrix[0][0])
            return 0;

        if (key > matrix[currentLengthLis][currentLengthLis])
            return currentLengthLis + 1;

        while (left < right - 1) {
            middle = (left + right) / 2;
            if (matrix[middle][middle] < key)
                left = middle;
            else
                right = middle;
        }
        return right;

    }

    public static void main(String[] args) {

        int[] a = {5,9,4,20,6,3,7,8,11};

         LIS(a);
    }
}

