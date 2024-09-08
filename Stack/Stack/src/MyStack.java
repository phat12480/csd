
import java.util.*;
import java.io.*;

class MyStack {

    Node top;

    // Constructor
    MyStack() {
        this.top = null;
    }

    public void push(int x) // insert at the beginning
    {
        if (isEmpty()) {
            top = new Node(x);
        } else {
            Node newNode = new Node(x);
            newNode.next = top;
            top = newNode;
        }

    }

    public void load() // insert at the beginning
    {
        this.push(10);
        this.push(14);
        this.push(7);
        this.push(7);
        this.push(3);
        this.push(2);
        this.push(15);
        this.push(9);
    }

    // Utility function to check if the stack is empty or
    // not
    public boolean isEmpty() {
        return top == null;
    }

    // Utility function to return top element in a stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
        }
        return top.info;
    }

    // Utility function to pop top element from the stack
    public void pop() // remove at the beginning
    {
        if (isEmpty()) {
            System.out.println("Stack Empty");
        }
        top = top.next;
    }

    public void display() {
        if(isEmpty()){
            System.out.println("Stack Empty");
        }
        else{
            for(Node current=top;current!=null;current=current.next){
                System.out.println(current.info+" ");
                
            }
        }
    }

}
