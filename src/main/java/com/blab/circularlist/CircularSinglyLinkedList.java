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

    // method to delete the data in list
    public boolean delete(E data){
        // checking atleast one element is present or not
        if(head==null) {
            System.out.println("list is empty");
            return false;
        }

        // temp node pointing to head
        Node temp = head;
        // traversing over the circular list
        for (int i=1;i<size();i++){
            // checking the data and removing
            if(temp.next.data.equals(data)){
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        // checking that to remove first element
        if(head.data.equals(data)){
            temp.next = temp.next.next;
            head = temp.next;
            return true;
        }
        return false;
    }

    // method to modify the data in list based on index
    public boolean set(int index,E newData)
    {
        // checking the index is within the limit or not
        if(index>=size()){
            System.out.println("index is out of limit.");
            return false;
        }
        // checking the modifying data is first element or not
        if(index==0)
            head.data = newData;

        // temp node pointing to 2nd node
        Node temp = head.next;
        // traversing over the circular list
        for(int i=1;i<size();i++)
        {
            if(index==i){
                temp.data = newData;
            }
            temp = temp.next;
        }
        return true;
    }

    // sorting the element in circular list
    public void sort()
    {
        // checking that atleast 2 elements present or not to sort
        if (head==null || head==head.next){
            System.out.println("list is too small");
            return;
        }
        // outer loop to traversing over the circular list
        for (int i = 0; i < size(); i++) {
            Node temp = head;
            // traversing over the circular list and swapping based on condition
            for (int j = i; j < size(); j++) {

                if(temp.data.compareTo(temp.next.data)>0){
                    Comparable swap = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = swap;
                }
                temp = temp.next;
            }
        }
    }

}
