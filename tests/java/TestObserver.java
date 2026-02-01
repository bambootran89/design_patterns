public class TestObserver {
    public static void main(String[] args) {
        System.out.println("Testing Java Observer...");
        try {
            client.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java Observer Test Passed!");
    }
}
