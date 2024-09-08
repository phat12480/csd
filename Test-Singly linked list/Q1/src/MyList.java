/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xProducer, int xWeight, int xPrice) { //f1
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------
        Laptop x = new Laptop(xProducer, xWeight, xPrice);
        if (x.weight > 0 && x.price > 0) {
            if (isEmpty()) {
                head = tail = new Node(x);
            } else {
                Node newNode = new Node(x);
                tail.next = newNode;
                tail = newNode;
            }
        }
        //---------------------------------------------------------
    }

    //==================================================================
    //You do not need to edit this function. Your task is to complete the 
    //addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    //add w at 2 and v at 3
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        Node v = new Node(new Laptop("V", 8, 9));
        Node w = new Node(new Laptop("W", 1, 7));
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        
		Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (isEmpty()) {
            System.out.println("List Empty");
        } else {
            v.next = head.next;
            w.next = v;
            head.next = w;
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    //Remove highest right weight
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        
		Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        if (isEmpty()) {
            System.out.println("List Empty");
        } else {
            Node maxWeightNode = head;
            int maxWeight = head.info.price;
            Node current = head;
            Node prev = null;

            while (current.next.next != null) {
                if (current.next.info.weight >= maxWeight) {
                    maxWeight = current.next.info.weight;
                    maxWeightNode = current.next;
                    prev = current;
                }
                current = current.next;
            }
            if (maxWeightNode == head) {
                head = head.next;
            } else {
                prev.next = maxWeightNode.next;
            }

        }

        // Delete the last node holding the heaviest Laptop
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        
		Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        int laptopCount = 0;
        for (Node current = head; current != null; current = current.next) {
            laptopCount++;
        }
        f.writeBytes(String.valueOf(laptopCount));
        //------------------------------------------------------------------------------------
        f.close();
    }

//==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        
		Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (isEmpty()) {
            System.out.println("Empty");
        } else if (head.next == null) {
            System.out.println("1 Node");
        } else {
            Node current = head;
            Node prev = null;
            // Tìm node cuối và node trước cuối
            while (current.next != null) {
                prev = current;
                current = current.next;
            }

            Node newTail = head; // Node đầu tiên trở thành tail mới
            Node newHead = tail; // Node cuối trở thành head mới

            // Cập nhật liên kết
            prev.next = null; // Node trước cuối không liên kết với node cuối nữa
            newHead.next = newTail.next; // Đặt liên kết của node cuối (head mới) với phần còn lại của danh sách
            prev.next = newTail; // Node head cũ không còn liên kết với bất kỳ node nào
            newTail.next = null;
            // Cập nhật head và tail
            head = newHead;
            tail = newTail;
        }
        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
