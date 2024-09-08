
import java.util.*;
import java.io.*;

class MyQueue {

    Node head, tail;

    public MyQueue() {
        head = tail = null;
    }

    // Method to add an key to the queue.
    void enqueue(int key) {
        if (isEmpty()) {
            head = tail = new Node(key);
        } else {
            Node newNode = new Node(key);
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Method to remove an key from queue.
    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
        } else if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
        }
    }

    public void load() // insert at the beginning
    {
        this.enqueue(10);
        this.enqueue(14);
        this.enqueue(7);
        this.enqueue(7);
        this.enqueue(3);
        this.enqueue(2);
        this.enqueue(15);
        this.enqueue(9);
    }

    // Utility function to check if the stack is empty or
    // not
    public boolean isEmpty() {
        return head == null;
    }

    // Utility function to return top element in a stack
    public int front() {
        if (isEmpty()) {
            System.out.println("Queue Empty");
        }
        return head.info;
    }

    public void display() {
        for (Node current = head; current != null; current = current.next) {
            System.out.println(current.info + "");
        }
    }

    void enqueueWithPriority(int key, int priority_level) {
        Node newNode = new Node(key);
        if (isEmpty() || priority_level < 1) { // assume priority level >= 1 means higher priority
            enqueue(key);
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && priority_level > 1) {
            previous = current;
            current = current.next;
            priority_level--;
        }

        if (previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
        }

        if (newNode.next == null) {
            tail = newNode;
        }
    }

}
