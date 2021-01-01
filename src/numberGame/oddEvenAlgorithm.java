package numberGame;

public class oddEvenAlgorithm {

    static public int aliceResult;
    static public int bobResult;
    static public int array[];
    static public int begin;
    static public int end;
    static public int oddSum;
    static public int evenSum;


    public oddEvenAlgorithm() {

        aliceResult = 0;
        bobResult = 0;
        array = buildArray(); // a function that build an array
        begin = 0;
        end = array.length - 1;
        oddSum = 0; // the sum of all the numbers in the odd index inside the array
        evenSum = 0; // the sum of all the numbers in the even index inside the array
    }

    public static void gameOddEven() {

        boolean even = true; // a boolean flag that tells us which index to chose, the odd or the even
        if (evenSum < oddSum) {
            even = false;
        }
        int step = 1;
        while (end > begin) {

            // first player - ALICE
            if ((even && begin % 2 == 0) || (!even && begin % 2 != 0)) {
                System.out.println("Alice: i take the first" + array[begin]);
                aliceResult = aliceResult + array[begin++]; // moving forward the begin index because alice took it.
            } else {
                System.out.println("Alice : i take the last " + array[end]);
                aliceResult = aliceResult + array[end--];
            }
            // second player - BOB
            if (array[begin] > array[end]) {
                bobResult = bobResult + array[begin++];
            } else {
                bobResult = bobResult + array[end--];
            }
            step++;
        }
    }

    public static int[] buildArray() {

        int[] arr = {6, 1, 5, 4, 8, 2, 9,10};
        return arr;
    }


}
