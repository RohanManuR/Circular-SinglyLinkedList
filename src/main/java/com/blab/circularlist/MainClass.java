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

    }
}