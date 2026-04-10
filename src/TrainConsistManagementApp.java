import java.util.*;

/**
 * =========================================================
 * MAIN CLASS – UseCase15TrainConsistMgmt
 * =========================================================
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 */

public class TrainConsistManagementApp {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie Model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                // Rule: Rectangular bogie cannot carry Petroleum
                if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("   UC15 - Safe Cargo Assignment ");
        System.out.println("======================================\n");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe assignment
        b1.assignCargo("Petroleum");

        System.out.println();

        // Unsafe assignment
        b2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}