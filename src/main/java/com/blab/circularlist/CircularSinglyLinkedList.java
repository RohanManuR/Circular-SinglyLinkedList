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

    // method to display size of list
    public int size()
    {
        // temp node pointing to head
        Node temp = head;
        // variable to store size
        int size = 0;
        // checking head is empty or not
        if(head == null)
            return 0;
        // traversing the temp till last to stop iteration
        do {
            size++;
            temp = temp.next;
        }while(temp!=head);
        return size;
    }

    // method to add element to circular list based on index
    public boolean add(int index,E data)
    {
        // checking index is within the limit or not
        if(index>size()){
            System.out.println("Index is out of limit");
            return false;
        }
        // node object created
        Node node = new Node(data);
        // temp node pointing to head
        Node temp = head;
        // previous node to point back element
        Node previous = null;
        // traversing over the circular list
        for (int i=1;i<=size();i++)
        {
            // checking the index and position
            if(i==index) {
                node.next = temp.next;
                temp.next = node;
                return true;
            }
            previous = temp;
            temp = temp.next;

        }
        // checking that to add first position
        if(index==0){
            previous.next = node;
            node.next = head;
            head = node;
        }

        return true;
    }

    // method to search element in circular list
    public boolean search(E data)
    {
        // checking atleast one element is present or not
        if(head==null) {
            System.out.println("list is empty");
            return false;
        }
        // temp node pointing to head
        Node temp = head;
        // traversing over the circular list
        for (int i = 0; i < size(); i++) {
            // checking the data is present or not in list
            if (temp.data.equals(data))
                return true;
            temp = temp.next;
        }
        return false;
    }


}
