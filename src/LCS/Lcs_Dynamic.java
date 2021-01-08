package LCS;

public class Lcs_Dynamic {

    // A function that creates an two dimension array with zeros inside him in the length and wide of the Strings + 1
    public static int[][] getCleanMatrix(String oneS, String twoS) {

        int one = oneS.length() + 1; // we do the plus 1 because of the ("") empty String that we need to do the equal
        int two = twoS.length() + 1;
        int matAns[][] = new int[one][two];
        return matAns;
    }


    public static int[][] fillMatrix(String oneS, String twoS) {

        int mat[][] = getCleanMatrix(oneS, twoS);

        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                if (oneS.charAt(i - 1) == twoS.charAt(j - 1)) {
                    mat[i][j] = mat[i - 1][j - 1] + 1;
                } else mat[i][j] = Math.max(mat[i][j - 1], mat[i - 1][j]);
            }
        }
        return mat;

    }

    // A function that gets the full Matrix and return the LCS in the Matrix with a String
    public static String goBack(int mat[][], String oneS, String twoS) {

        int i = mat.length - 1; // in this example i = 6
        int j = mat[0].length - 1; // in this example j = 7
        int max = mat[i][j]; // in our example the max = 4
        int start = 0;
        String ans = ""; // This is the our answer

        while (start < max) {
            if (oneS.charAt(i - 1) == twoS.charAt(j - 1)) {
                ans = oneS.charAt(i - 1) + ans;
                i--;
                j--;
                start++;
            } else {
                if (mat[i - 1][j] >= mat[i][j - 1]) i--;
                j--;

            }
        }
        return ans;
    }


    public static void main(String[] args) {

        String a = "AGGTAB";
        String b = "GXTXAYB";

        int[][] ans = fillMatrix(a, b);

        String stringAns = goBack(ans, a, b);

        int stringAnsLength = stringAns.length();

        System.out.println("The lcs is: "+stringAns);
        System.out.println("Ans his length is: "+stringAnsLength);

    }


}
