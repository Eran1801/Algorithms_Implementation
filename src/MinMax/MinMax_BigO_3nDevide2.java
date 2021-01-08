package MinMax;

public class MinMax_BigO_3nDevide2 {

    public static String MinMax_3nDevide2(int[] arr) {

        int comparisons = 1;
        int max, min;
        int indexMax, indexMin;

        if (arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
            indexMax = 0;
            indexMin = 1;
        } else {
            max = arr[1];
            min = arr[0];
            indexMax = 1;
            indexMin = 0;
        }

        for (int i = 2; i < arr.length-1; i += 2) {
            comparisons++;
            if (arr[i] < arr[i + 1]) {
                comparisons += 2;
                if (arr[i] < min) {
                    min = arr[i];
                    indexMin = i;
                }
                if (arr[i + 1] > max) {
                    max = arr[i + 1];
                    indexMax = i; // need to check if its i instead of i+1
                }
            } else {
                comparisons += 2;
                if (arr[i + 1] < min) {
                    min = arr[i + 1];
                    indexMin = i;
                }
                if (arr[i] > max) {
                    max = arr[i];
                    indexMax = i;
                }
            }
        }
        if (arr.length % 2 != 0) { // not even
            comparisons++;
            if (arr[arr.length - 1] > max) {
                max = arr[arr.length - 1];
                indexMax = arr.length - 1;
            } else {
                comparisons++;
                if (arr[arr.length - 1] < min) {
                    min = arr[arr.length - 1];
                    indexMin = arr.length - 1;
                }
            }
        }

        String ans = "The max value is :" + max + "\nThe min value is :" + min + "\nAnd the number of steps was :" + comparisons;
        return ans;

    }

    public static void main(String[] args) {

        int[] arr = {0, 6, 3, -2, -8, 9,20,15,13,14,18,95,-86,-47,-3,-2,-6,5,81,298,100,5,2828,-10000};
        System.out.println(MinMax_3nDevide2(arr));

    }
}
