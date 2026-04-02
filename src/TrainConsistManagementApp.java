import java.util.ArrayList;
import java.util.List;

/**
 * =========================================================
 * MAIN CLASS – UseCase14TrainConsistMgmt
 * =========================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 */

public class TrainConsistManagementApp {

    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   UC14 - Handle Invalid Bogie Capacity ");
        System.out.println("======================================\n");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 56));

            // This will throw exception
            bogies.add(new PassengerBogie("First Class", -10));

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nValid Bogies Created:");
        for (PassengerBogie b : bogies) {
            System.out.println(b.type + " -> " + b.capacity);
        }

        System.out.println("\nUC14 validation completed...");
    }
}