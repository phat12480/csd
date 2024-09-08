// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
class Laptop {
  String producer;
  int weight,price;
  Laptop() {
   }
  Laptop(String xProducer, int xWeight, int xPrice){
    producer=xProducer;weight=xWeight; price=xPrice;
   }
  public String toString(){
    return("(" + producer +","+ weight + "," + price + ")");
   }
 }
