package plane_Problome;

public class Node {

    int priceX;
    int priceY;
    int price;
    int bestTrackNumber; // the number that will be here will defined the number of paths to this node

    // default constructor
    public Node(int x, int y) {

        this.priceX = x;
        this.price = y;
        this.price = 0;
        this.bestTrackNumber = 0;
    }

}
