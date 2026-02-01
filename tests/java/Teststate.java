public class Teststate {
    public static void main(String[] args) {
        System.out.println("Testing Java state...");
        try {
            client.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java state Test Passed!");
    }
}
