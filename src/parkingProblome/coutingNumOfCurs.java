package parkingProblome;

public class coutingNumOfCurs {

    public static void main(String[] args) {

        List list = new List();
        int countCars = 0;

        list.add(8);
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        list.head.data = -1; // mark the opening car
        // temp = the Node after the head, we marked the head to be -1 and know we continue with temp all over the list
        Node temp = list.head.next;
        boolean ans = false; // A condition to enter the while loop

        while (!ans) {
            int count = 1;
            // continue until you meet the -1 sign that indicate on the first car that was marked in the beginning
            while ( temp.data != -1 ){
                count++;
                temp = temp.next;
            }
            temp.data = 0; // initialization the temp Node = head, the next step is to go in reverse on the list
            countCars = count; // because we are decreasing the count var
            while ( count > 0){
                temp = temp.prev; // going in reverse
                count--;
            }
            if ( temp.data == 0) ans = true; // Done!
            else temp = temp.next; // we didn't get to the start Node, try again
        }
        System.out.println("The number of cars in the parking loot is :" + countCars);

    }

}
