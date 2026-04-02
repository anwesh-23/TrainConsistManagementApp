import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * =========================================================
 * MAIN CLASS – UseCase11TrainConsistMgmt
 * =========================================================
 *
 * Use Case 11: Validate Train ID & Cargo Codes (Regex)
 */

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   UC11 - Validate Train ID & Cargo Codes ");
        System.out.println("======================================\n");

        String trainId = "TRN-1234";
        String cargoCode = "PET-AB";

        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "PET-[A-Z]{2}";

        Pattern trainRegex = Pattern.compile(trainPattern);
        Pattern cargoRegex = Pattern.compile(cargoPattern);

        Matcher trainMatcher = trainRegex.matcher(trainId);
        Matcher cargoMatcher = cargoRegex.matcher(cargoCode);

        System.out.println("Train ID: " + trainId);
        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID");
        } else {
            System.out.println("Invalid Train ID");
        }

        System.out.println("\nCargo Code: " + cargoCode);
        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code");
        } else {
            System.out.println("Invalid Cargo Code");
        }

        System.out.println("\nUC11 validation completed...");
    }
}