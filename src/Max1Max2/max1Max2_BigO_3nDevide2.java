package Max1Max2;

public class max1Max2_BigO_3nDevide2 {


    public static void max1Max2_3nDevide2(int[] arr) {

        int max1 = arr[0];
        int max2 = arr[1];

        int countOfStep = 1;
        countOfStep++;
        if (max2 > max1) {
            int tempMax = max1;
            max1 = max2;
            max2 = tempMax;
        }

        for (int i = 2; i < arr.length - 1; i += 2) {
            countOfStep++;
            if (arr[i] > arr[i + 1]) {
                countOfStep++;
                if (arr[i] > max2) {
                    countOfStep++;
                    if (arr[i] > max1) {
                        max2 = max1;
                        max1 = arr[i];
                    } else
                        max2 = arr[i];
                }
            } else {
                countOfStep++;
                if (arr[i + 1] > max2) {
                    countOfStep++;
                    if (arr[i + 1] > max1) {
                        max2 = max1;
                        max1 = arr[i + 1];
                    } else
                        max2 = arr[i + 1];
                }
            }
        }

        countOfStep++;
        if(arr.length %2 == 0){
            if(arr[arr.length-1]>max2){
                if(arr[arr.length-1]>max1){
                    max2 = max1;
                    max1 = arr[arr.length-1];
                }
                else
                    max2 = arr[arr.length-1];
            }
        }
        countOfStep++;

        System.out.println("Max number 1 is :" + max1);
        System.out.println("Max number 2 is :" + max2);

    }


    public static void main(String[] args) {

        int[] arr = {0, 6, 3, -2, -8, 9, 20, 15, 13, 14, 18, 95, -86, -47, -3, -2, -6, 5, 81, 298, 100, 5, 2828, -10000};
        max1Max2_3nDevide2(arr);

    }
}
