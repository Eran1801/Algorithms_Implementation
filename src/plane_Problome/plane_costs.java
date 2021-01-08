package plane_Problome;

import java.util.Arrays;

public class plane_costs {

    static public Node[][] mat;// on what the airplane goes
    static public int row;
    static public int col;


    public plane_costs() {

        mat = initMatrix();
        row = mat.length;
        col = mat[0].length;

    }

    // This method creates the matrix with some values to detriment what is the best path
    private static Node[][] initMatrix() { // Big O(nxm)

        int row = 4;
        int col = 4;

        Node[][] mat = new Node[row][col];

        // The first row, we exactly going forward throw the column and not with the rows
        mat[0][0] = new Node(3, 1);
        mat[0][1] = new Node(5, 2);
        mat[0][2] = new Node(10, 4);
        mat[0][3] = new Node(0, 4);

        // The second row
        mat[1][0] = new Node(6, 9);
        mat[1][1] = new Node(7, 12);
        mat[1][2] = new Node(21, 5);
        mat[1][3] = new Node(0, 4);

        // The third row
        mat[2][0] = new Node(7, 1);
        mat[2][1] = new Node(7, 2);
        mat[2][2] = new Node(10, 3);
        mat[2][3] = new Node(0, 4);

        // The forth row
        mat[3][0] = new Node(12, 1);
        mat[3][1] = new Node(21, 19);
        mat[3][2] = new Node(12, 4);
        mat[3][3] = new Node(6, 4);

        return mat;

    }

    // Now what we want to do is first to initialize the prices in the first row and the first column
    // And then - to go throw all over the matrix and set all the other rows and columns in according with the initialize

    public static int buildPriceMatrix() {


        // ------------------- Rows Prices ----------------------------------
        // When i initialize the first row i need to run on the amount of the column in the matrix
        for (int j = 1; j < col; j++) {
            mat[0][j].price = mat[0][j - 1].price + mat[0][j - 1].priceX;
        }

        // ------------------- Column Prices ----------------------------------
        // When i initialize the first column i need to run on the amount of the rows in the matrix
        for (int i = 1; i < row; i++) {
            mat[i][0].price = mat[i - 1][0].price + mat[i - 1][0].priceY;
        }

        // ------------------- All Prices ----------------------------------
        // now we will find the shortest path to each node in that we will ask every time
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
                int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
                if (y < x)
                    mat[i][j].price = y;
                if (y > x)
                    mat[i][j].price = x;
                if (x == y)
                    mat[i][j].price = y;

            }
        }

        return mat[row - 1][col - 1].price;
    }

    public static int buildBestTracksMatrix() {


        // ------------------- Rows Best Track Number ----------------------------------
        for (int j = 1; j < col; j++) {
            mat[0][j].bestTrackNumber = 1;
        }

        // ------------------- Column Best Track Number ----------------------------------
        for (int i = 1; i < row; i++) {
            mat[i][0].bestTrackNumber = 1;
        }

        // ------------------- All Best Track Number ----------------------------------
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
                int x = mat[i][j - 1].price + mat[i][j - 1].priceX;

                if (y < x)
                    mat[i][j].bestTrackNumber = mat[i - 1][j].bestTrackNumber;
                if (y > x)
                    mat[i][j].bestTrackNumber = mat[i][j - 1].bestTrackNumber;
                if (x == y)
                    // There is a 'x' of ways to get mat[i][j] node, accordingly to the previous node.bestTrackNumber
                    mat[i][j].bestTrackNumber = mat[i - 1][j].bestTrackNumber + mat[i][j - 1].bestTrackNumber;

            }
        }


        return mat[row - 1][col - 1].bestTrackNumber;

    }

    public static String getOneBestTrack() {  // Returns the path from start to end, 1 - means down , 0 - means left

        String track = ""; // Holds the direction for the path

        int i = row - 1;
        int j = col - 1;

        while (i > 0 && j > 0) {
            int y = mat[i - 1][j].price + mat[i - 1][j].priceY;
            int x = mat[i][j - 1].price + mat[i][j - 1].priceX;
            if (y <= x) {
                track += "1->"; // going down
                i--;
            } else { // if  ( y >= x )
                track += "0->";
                j--;
            }
        }

        // if we reach the end of the row or the column we need to go always left or always down

        while (j > 0) {
            track += "0->";
            j--;
        }
        while (i > 0) {
            track += "0->";
            i--;
        }
        return track.substring(0,track.length()-2);

    }

    public static void main(String[] args) {

        plane_costs plane = new plane_costs();


        System.out.println("The price to get to the last node in the matrix is :" + buildPriceMatrix());
        System.out.println("And the number of ways to get to the end of the matrix is :" + buildBestTracksMatrix());
        System.out.println("The path from the start to the end is :" + getOneBestTrack());


    }


}
