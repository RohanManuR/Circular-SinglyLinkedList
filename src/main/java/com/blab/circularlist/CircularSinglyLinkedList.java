package com.blab.circularlist;

// CircularSinglyLinkedList class created
public class CircularSinglyLinkedList<E extends Comparable> {

    // head variable poiniting to first element
    Node head;

    // method to add element to list
    public boolean add(E data)
    {
        // node object created
        Node node = new Node(data);
        // checking head is empty or not
        if(head==null) {
            // pointing both head and head.next to same, to make circular
            head = node;
            head.next = node;
            return true;
        }

        // checking that head is pointing to element or not
        if(head!=null && head==head.next){
            head.next = node;
            node.next = head;
            return true;
        }
        // temp node pointing to head
        Node temp = head;
        // traversing the temp till last to add next node
        do{
            temp = temp.next;
            // condition to check temp pointing back to head to stop the iteration
        } while(temp.next!=head);

        temp.next = node;
        node.next = head;
        return true;
    }

    // overriding toString() to display list elements
    public String toString()
    {
        // checking head is empty or not
        if(head==null){
            return "List is empty,....";
        }
        // temp node pointing to head
        Node temp = head;
        // traversing the temp till last to stop iteration
        do{
            System.out.print(temp.data+"-->");
            temp = temp.next;
        }while(temp!=head);
        System.out.println("connecting back");
        return "";
    }



}
