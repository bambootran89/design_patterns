public class TestStrategyAssert {
    public static void main(String[] args) {
        System.out.println("Testing Java Strategy with Assertions...");

        // Setup
        Customer a = new Customer(new NormalStrategy());

        // Action 1: Add item with Normal Strategy
        a.add(1.0, 1);
        // Calculation: 1.0 * 1 = 1.0
        assertDoubleEquals(a.getTotalDue(), 1.0, "Normal Strategy Sum Mismatch");

        // Action 2: Change to Happy Hour (50% off) and add item
        // Note: HappyHourStrategy in Java hardcodes 0.5 discount
        a.setStrategy(new HappyHourStrategy());
        a.add(1.0, 2);
        // Calculation: 1.0 * 0.5 * 2 = 1.0
        // Total Sum: 1.0 (previous) + 1.0 (current) = 2.0
        assertDoubleEquals(a.getTotalDue(), 2.0, "HappyHour Strategy Sum Mismatch");

        System.out.println("Java Strategy Assert Test Passed!");
    }

    private static void assertDoubleEquals(double actual, double expected, String message) {
        if (Math.abs(actual - expected) > 0.0001) {
            System.err.println("Assertion Failed: " + message);
            System.err.println("Expected: " + expected);
            System.err.println("Actual:   " + actual);
            System.exit(1);
        }
    }
}
