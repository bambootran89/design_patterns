public class TestThread {
    public static void main(String[] args) {
        System.out.println("Testing Java Thread...");
        try {
            client.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java Thread Test Passed!");
    }
}
