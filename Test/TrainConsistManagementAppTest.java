import org.junit.jupiter.api.Test;

import java.util.*;
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
        list.add(new Bogie("Sleeper", 70));
        list.add(new Bogie("AC Chair", 60));
        return list;
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> map =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(map.containsKey("Sleeper"));
        assertTrue(map.containsKey("AC Chair"));
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> map =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, map.get("Sleeper").size());
    }

    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> map =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(3, map.keySet().size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> empty = new ArrayList<>();

        Map<String, List<Bogie>> map =
                empty.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(map.isEmpty());
    }

    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> map =
                list.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, map.size());
    }

    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> map =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(map.containsKey("First Class"));
    }

    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> map =
                getSampleBogies().stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, map.get("AC Chair").size());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = getSampleBogies();

        Map<String, List<Bogie>> map =
                original.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(5, original.size());
        assertEquals(3, map.size());
    }
}