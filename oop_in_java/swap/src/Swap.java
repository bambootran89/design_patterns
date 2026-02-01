/** Utility class for swapping values. */
public class Swap {

  /** @param args */
  public static void main(String[] args) {
    // TODO Auto-generated method stub

    ValueTest c = new ValueTest(123);

    ValueTest d = new ValueTest(456);
    c.show();
    d.show();

    swap(c, d);

    c.show();
    d.show();
  }

  static void swap(ValueTest A, ValueTest B) {

    ValueTest temp;

    temp = A;
    A = B;
    B = temp;

    A.show();
    B.show();
  }

  static class ValueTest {
    int a;

    public ValueTest(int a_) {
      // TODO Auto-generated constructor stub

      a = a_;
    }

    public void show() {
      System.out.println("Value = " + a);
    }
  }
}
