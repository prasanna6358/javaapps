package org.app.dbtest;


public class CircularLinkedList {

    private CNode last;
    private int length;
    private int size;

    public void createLinkedList()
    {
        CNode head = new CNode(12);
        CNode node2 = new CNode(15);
        CNode node3 = new CNode(67);
        CNode tail = new CNode(45);
        head.next = node2;
        node2.next = node3;
        node3.next = tail;
        tail.next = head;
        System.out.println(tail);
        System.out.println(head);
    }

    public static void main(String[] args)
    {
        System.out.println("Linked list");
        CircularLinkedList cl = new CircularLinkedList();
        cl.createLinkedList();

    }


}
class CNode {
    int data;
    CNode next;

    public CNode(int data)
    {
        if(next == null)
        this.data = data;
    }

    public String toString() {
        return " " + this.data + " " + this.next + " ";
    }
}
