package com.blab.circularlist;
// Node class of generic type
public class Node <E extends Comparable> {
    // generic type data
    E data;
    // next address variable to point to next node
    Node next;

    // COnstructor to initialize node data
    Node(E data)
    {
        this.data = data;
        this.next = null;
    }
}
