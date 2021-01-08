package numberGame;

public class adaptiveAlgorithm {

    static public int aliceResult;
    static public int bobResult;
    static public int array[];
    static public int begin;
    static public int end;
    static public int oddSum;
    static public int evenSum;

    public adaptiveAlgorithm() {

        aliceResult = 0;
        bobResult = 0;
        array = buildArray(); // a function that build an array
        begin = 0;
        end = array.length - 1;
        oddSum = 0; // the sum of all the numbers in the odd index inside the array
        evenSum = 0; // the sum of all the numbers in the even index inside the array
    }

    public static void oddEvenAdaptiveAlgorithm() {

        boolean even = true;
        if (evenSum < oddSum) {
            even = false;
        }
        int endNew = 0;
        int beginNew = 0;

        while (end > begin) {

            // first player = Alice
            if (begin > 0) {
                endNew = end - begin; //  ? לא רלוונטי
                beginNew = 0;
            }
            if ((even && beginNew % 2 == 0) || (!even && beginNew % 2 != 0)) {
                aliceResult = aliceResult + array[begin++];
            } else {
                aliceResult = aliceResult + array[end--];
            }

            if (array[begin] > array[end]) {
                bobResult = bobResult + array[begin++];
            } else {
                bobResult = bobResult + array[end--];
            }

            evenSum = 0;
            oddSum = 0;
            calculateOddEvenSum();
            even = true;

            if (evenSum < oddSum) {
                even = false;
            }

        }
    }

    private static void calculateOddEvenSum() {
        for (int i = begin; i < end; i += 2) {
            evenSum = evenSum + array[i];
            oddSum = oddSum + array[i + 1];
        }

    }

    public static int[] buildArray() {

        int[] arr = {6, 9, 1, 2, 16, 12};
        return arr;
    }

}
