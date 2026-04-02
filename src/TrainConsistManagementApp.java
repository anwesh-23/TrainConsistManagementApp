import java.util.ArrayList;
import java.util.List;

/**
 * =========================================================
 * MAIN CLASS – UseCase12TrainConsistMgmt
 * =========================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 */

public class TrainConsistManagementApp {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   UC12 - Safety Compliance Check ");
        System.out.println("======================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        !b.type.equals("Cylindrical") ||
                                b.cargo.equals("Petroleum")
                );

        System.out.println("Train Safety Status: " + (isSafe ? "SAFE" : "UNSAFE"));

        System.out.println("\nUC12 safety validation completed...");
    }
}