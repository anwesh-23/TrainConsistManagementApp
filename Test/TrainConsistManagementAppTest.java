import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    int[] bubbleSort(int[] arr) {
        int[] a = arr.clone();

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    @Test
    void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};

        assertArrayEquals(input, bubbleSort(input));
    }

    @Test
    void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        assertArrayEquals(expected, bubbleSort(input));
    }

    @Test
    void testSort_SingleElementArray() {
        int[] input = {50};

        assertArrayEquals(input, bubbleSort(input));
    }

    @Test
    void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};

        assertArrayEquals(input, bubbleSort(input));
    }
}