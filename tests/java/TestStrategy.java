public class TestStrategy {
    public static void main(String[] args) {
        System.out.println("Testing Java Strategy...");
        try {
            client.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java Strategy Test Passed!");
    }
}
