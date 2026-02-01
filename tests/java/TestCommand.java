public class TestCommand {
    public static void main(String[] args) {
        System.out.println("Testing Java Command...");
        try {
            RemoteLoader.main(args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Java Command Test Passed!");
    }
}
