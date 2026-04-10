import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    boolean search(String[] arr, String key) {
        if (arr.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] arr = {};
        assertThrows(IllegalStateException.class, () -> search(arr, "BG101"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};
        assertDoesNotThrow(() -> search(arr, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(search(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertFalse(search(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        assertTrue(search(arr, "BG101"));
    }
}