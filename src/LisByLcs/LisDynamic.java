package LisByLcs;

public class LisDynamic {

// Complexity time : O(nLog(n))
// return just the size of the lis, and not the String himself

    public static int lengthLis(int[] arr) {

        int sizeArr = arr.length;
        int[] helpArray = new int[sizeArr]; // a temp array that helps us to get the result we need

        helpArray[0] = arr[0];
        int currentLengthLis = 0; // this var will increment every time and in the end return the length of the lis

        for (int i = 1; i < sizeArr; i++) {
            int index = binarySearchBetween(helpArray, currentLengthLis, arr[i]);
            helpArray[index] = arr[i];
            if (index > currentLengthLis){
                currentLengthLis++;
            }
        }
        return currentLengthLis+1;
    }

    public static int binarySearchBetween(int[] helpArray, int currentLengthLis, int key) {

        int left = 0;
        int right = currentLengthLis; // == end  // the index of right is the size of the current LIS
        int middle;

        if (key < helpArray[0])
            return 0;

        if (key > helpArray[currentLengthLis])
            return currentLengthLis + 1;

        while (left < right - 1) {
            middle = (left + right) / 2;
            if (helpArray[middle] < key)
                left = middle;
            else
                right = middle;
        }
        return right;

    }


    public static void main(String[] args) {

        int[] a = {5,9,4,20,6,3,7,8,11};

        System.out.println("The size of the lis is : " + lengthLis(a) );

    }
}