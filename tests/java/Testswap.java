public class Testswap {
    public static void main(String[] args) {
        System.out.println("Testing Java swap...");
        try {
            Swap.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java swap Test Passed!");
    }
}
