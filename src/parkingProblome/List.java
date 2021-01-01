package parkingProblome;

public class List {

    Node head;
    Node tail;

    public List () {
        tail = null;
        head = tail;
    }

    public void add ( int data ) {
        if(head == null) {
            head = new Node(data);
            head.next = head; // because its a circle linkedList
            head.prev = head;
            tail = head;
        }
        else {
            Node node = new Node(data);
            node.next = head;
            node.prev = tail;
            head.prev = node;
            tail.next = node;
            tail = tail.next;

        }
    }

}
