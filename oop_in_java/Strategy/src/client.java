/** Client demonstration code for the pattern. */
public class client {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Customer a = new Customer(new NormalStrategy());
    a.add(1.0, 1);
    a.setStrategy(new HappyHourStrategy());
    a.add(1.0, 2);

    Customer b = new Customer(new HappyHourStrategy());
    b.add(0.8, 1);
    a.printBill();
    b.setStrategy(new NormalStrategy());
    b.add(1.3, 2);
    b.add(2.5, 1);
    b.printBill();
  }
}
