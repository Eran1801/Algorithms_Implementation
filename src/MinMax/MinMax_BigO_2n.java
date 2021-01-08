package MinMax;

public class MinMax_BigO_2n {


    public static String MaxMin_2n(int[] arr) {

        int max = arr[0];
        int min = arr[0];

        int countSteps = 0;
        for (int i = 1; i < arr.length; i++) {
            countSteps++;
            if (arr[i] > max) {
                max = arr[i];
                countSteps++;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        String ans = "The max value is :" + max + "\nThe min value is :" + min + "\nAnd the number of steps was :" + countSteps;
        return ans;

    }

    public static void main(String[] args) {

        int[] arr = {0, 6, 3, -2, -8, 9,20,15,13,14,18,95,-86,-47,-3,-2,-6,5,81,298,100,5,2828,-1000};
        System.out.println(MaxMin_2n(arr));


    }


}
