package com.blab.circularlist;

public class MainClass {
    public static void main(String[] args) {

        // CircularSinglyLinkedList object created
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        // adding the elements to list using add()
        list.add(10);
        list.add(20);
        list.add(300);
        list.add(15);
        list.add(25);
        list.add(5);
        // adding data based on index
        list.add(0,25);
        list.add(4,35);
        // displaying the circular list elements
        System.out.println(list);
        // searching element in list
        System.out.println(list.search(5));
        // remove element based on data
        list.delete(300);
        // display the updated list
        System.out.println(list);

    }
}