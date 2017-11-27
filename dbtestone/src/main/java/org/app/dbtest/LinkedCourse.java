package org.app.dbtest;

public class LinkedCourse  {

    public static void main(String args[])
    {
        Node root = null;
        LinkedCourse lk = new LinkedCourse();
        root = lk.insert(12,root);
        root = lk.insert(45,root);
        root = lk.insert(55,root);
        root = lk.insert(95,root);
        System.out.println(root);
    }

    public Node insert(int i, Node node)
    {
        if(node==null)
        {
            return getNewNode(i);
        }
        else
            node.next = insert(i,node.next);
        return node;
    }

    private Node getNewNode(int i)
    {
        Node n = new Node();
        n.data=i;
        n.next = null;
        return n;
    }
}

class Node{
    int data;
    Node next;
    public String toString()
    {
        return " "+this.data+" "+this.next+" ";
    }
}
