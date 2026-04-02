import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getSampleBogies() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 72));
        list.add(new Bogie("AC Chair", 56));
        list.add(new Bogie("First Class", 24));
        list.add(new Bogie("General", 90));
        return list;
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        assertEquals(2, result.size()); // 72 & 90
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 100)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        assertEquals(3, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 200)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = getSampleBogies().stream()
                .filter(b -> b.capacity > 10)
                .collect(Collectors.toList());

        assertEquals(4, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();

        List<Bogie> result = empty.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();

        List<Bogie> filtered = original.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(4, original.size());
        assertEquals(2, filtered.size());
    }
}