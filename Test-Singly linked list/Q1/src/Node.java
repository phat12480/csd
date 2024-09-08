// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Node {
  Laptop info;
  Node next;
  Node() {
   }
  Node(Laptop x, Node p) {
    info=x;next=p;
   }
  Node(Laptop x) {
    this(x,null);
   }
 }

