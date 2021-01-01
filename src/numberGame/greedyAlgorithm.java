package numberGame;

public class greedyAlgorithm {

    static public int aliceResult;
    static public int bobResult;
    static public int array[];
    static public int begin;
    static public int end;

    public greedyAlgorithm() {
        aliceResult = 0;
        bobResult = 0;
        array = buildArray();
        begin = 0;
        end = array.length - 1;
    }

    public static void gameGreedy() {

        int step = 1;
        while (end > begin) {
            if (array[begin] > array[end])
                aliceResult += array[begin++];
            else
                aliceResult += array[end--];

            // second player choice

            if (array[begin] > array[end])
                bobResult += array[begin++];
            else
                bobResult += array[end--];

            step++;
        }


    }

    public static int[] buildArray() {

        int[] arr = {6, 9, 1, 2, 16, 12};
        return arr;
    }

    public static void main(String[] args) {

    }
}
