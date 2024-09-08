
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;
    int size;

    MyList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    void ftraverseFW(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     ");
            p = p.next;
        }

        f.writeBytes("\r\n");
    }

    void ftraverseBW(RandomAccessFile f) throws Exception {
        Node p = tail;
        while (p != null) {
            f.writeBytes(p.info.ID + "-" + p.info.name + "-" + p.info.price + "     ");
            p = p.pre;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) {
        String[] a = Lib.readLineToStrArray("data.txt", k);
        String[] b = Lib.readLineToStrArray("data.txt", k + 1);
        String[] c = Lib.readLineToStrArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(a[i]);
            int y = Integer.parseInt(c[i]);
            addLast(x, b[i], y);
        }
    }

    void addLast(int id, String name, int price) {
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Phone phone = new Phone(id, name, price);

        if (phone.price > 0) {
            if (isEmpty()) {
                head = tail = new Node(phone);
            } else {
                Node newNode = new Node(phone);
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
            }
            size++;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
    }

    void f1() throws Exception {
        clear();
        loadData(0);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }
// add v at 2 and w at 3

    void f2() throws Exception {
        clear();
        loadData(0);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        Phone v = new Phone(7, "V", 8);
        Phone w = new Phone(9, "W", 10);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        Node v1 = new Node(v);
        Node w1 = new Node(w);
        if (isEmpty()) {
            System.out.println("Empty List");
        } else {
            w1.next = head.next;
            head.next.pre = w1;
            v1.next = w1;
            w1.pre = v1;
            head.next = v1;
            v1.pre = head;
        }

        size += 2;
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }
//remove highest right price

    void f3() throws Exception {
        clear();
        loadData(0);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        if (isEmpty()) {
            System.out.println("Empty List");
        } else {
            Node maxPriceNode = head;
            int maxPrice = head.info.price;
            Node current = head;
            Node prevMaxPriceNode = null;

            while (current.next != null) {
                if (current.next.info.price >= maxPrice) {
                    maxPrice = current.next.info.price;
                    maxPriceNode = current.next;
                    prevMaxPriceNode = current;
                }
                current = current.next;
            }

            // Delete the last node holding the most expensive Phone
            if (maxPriceNode == head) {
                head = head.next;
                head.pre = null;
            } else if (maxPriceNode == tail) {
                tail = prevMaxPriceNode;
                tail.next = null;
            } else {
                prevMaxPriceNode.next = maxPriceNode.next;
            }
            size--;
        }

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }
//compute count

    void f4() throws Exception {
        clear();
        loadData(0);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
        int count = 0;
        for (Node current = head; current != null; current = current.next) {
            count++;
        }
        f.writeBytes(String.valueOf(count));

        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        f.close();
    }
//swap first and last

    void f5() throws Exception {
        clear();
        loadData(0);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverseFW(f);
        ftraverseBW(f);
        //------------------------------------------------------------------------------------
        //------ Start your code here---------------------------------------------------------
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
            newTail.next.pre = newHead;
            newHead.pre = null;
            prev.next = newTail; // Node head cũ không còn liên kết với bất kỳ node nào
            newTail.next = null;
            prev.next = newTail;
            newTail.pre = prev;
            newTail.next = null;

            // Cập nhật head và tail
            head = newHead;
            tail = newTail;
        }
        //------ End your code here-----------------------------------------------------------
        //------------------------------------------------------------------------------------
        ftraverseFW(f);
        ftraverseBW(f);
        f.close();
    }

}
