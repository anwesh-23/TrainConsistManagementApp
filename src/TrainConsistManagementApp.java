/**
 * =========================================================
 * MAIN CLASS – UseCase18TrainConsistMgmt
 * =========================================================
 *
 * Use Case 18: Linear Search for Bogie ID
 */

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   UC18 - Linear Search for Bogie ID ");
        System.out.println("======================================\n");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        String searchId = "BG309";

        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        boolean found = false;

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}