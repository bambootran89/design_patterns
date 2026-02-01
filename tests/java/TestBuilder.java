public class TestBuilder {
    public static void main(String[] args) {
        System.out.println("Testing Java Builder...");
        try {
            Client.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java Builder Test Passed!");
    }
}
