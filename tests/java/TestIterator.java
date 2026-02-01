public class TestIterator {
    public static void main(String[] args) {
        System.out.println("Testing Java Iterator...");
        try {
            client.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java Iterator Test Passed!");
    }
}
