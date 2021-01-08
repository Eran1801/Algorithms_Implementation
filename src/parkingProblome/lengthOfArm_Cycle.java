package parkingProblome;

public class lengthOfArm_Cycle {

    public static void main(String[] args) {


        List list = new List();

        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        Node head = list.head;
        int armLength = 0;
        int cyclePerimeter = 0;

        if (head != null) {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null && slow != null) {
                if (fast == slow) {
                    slow = list.head;
                    fast = fast.next;
                    while (fast != slow) {
                        armLength++;
                        // both slow steps
                        fast = fast.next;
                        slow = slow.next;
                    }
                    slow = slow.next;
                    while (slow != fast ){
                        cyclePerimeter++;
                        slow = slow.next;
                    }
                    cyclePerimeter++;
                    System.out.println("The length of the arm is:" + armLength + "\n and the length of the cycle is : " + cyclePerimeter);
                    break;
                } else {
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }
        } else {
            System.out.println("There is no circle");
        }

    }

}

