package LisByLcs;

import java.util.Arrays;

public class LIsGreedy {

    /**
     *
     * LIS = Longest Increasing Subsequence Algorithm
     *
     * The Greedy algorithm goes like this:
     *
     * In the first function "lengthLis" her purpose is to find the length that i will be needed to initialization
     * the lisAns Array, by go over the arr and find the max value to determent the length of the lisAns Array
     *
     * In the second function "lis" her purpose is to create the final answer for this algorithm by go over the 2 arrays
     * and putting the right value in the right place
     */

    public static int arr[] = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
    public static int length;
    public static int lisAns[];


    // This function finds the length of the array and the max value in it
    public static void lengthLis() {

        int max = arr[0];
        length = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                length++;
                max = arr[i]; // Why the max value is important? to know the length of the the rising string of numbers
            }
        }
        System.out.println(length);
    }

    public static void lis() {

        lisAns = new int[length]; // This array will be the answer
        lisAns[0] = arr[0]; //
        int j = 1;
        for ( int i = 1 ; i < arr.length; i++){
            if(arr[i] > lisAns[j-1]){
                lisAns[j] = arr[i];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        lengthLis();
        System.out.println("Length LIS = " + length);
        lis();
        System.out.println("lis :" + Arrays.toString(lisAns));

        // The output will be : {0,8,12,14,15}
    }
}
