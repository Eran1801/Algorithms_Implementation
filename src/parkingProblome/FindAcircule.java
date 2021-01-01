package parkingProblome;

import java.awt.datatransfer.ClipboardOwner;
import java.util.LinkedList;

public class FindAcircule {

    public static void main(String[] args) {

        List list = new List();

        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        Node head = list.head;

        if (head != null) {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null && slow != null) {
                if (fast == slow) {
                    System.out.println("There is a circle");
                    break;
                } else {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
        }
        else {
            System.out.println("There is no circle");
        }

    }

}

