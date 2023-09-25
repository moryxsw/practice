package network.y9;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        HashMap<String, Integer> map = new HashMap<>(){{
            put("a", 1);
        }};

        map.merge("a", 2, Integer::sum);
        System.out.println(map);

        Map<String, Integer> code = new HashMap<>();
        code.put("a",99);
        code.put("c", 50);
        code.put("b", 101);


        //  按照键排序
        Map<String, Integer> sorted = code.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new));
        System.out.println(sorted);

        //  按照值排序
        Map<String, Integer> sorted2 = code.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, (oldVal, newVal) -> oldVal,
                        LinkedHashMap::new));
        System.out.println(sorted2);


        // treemap排序
        Map<String, Integer> sorted3 = new TreeMap<>(code);
        System.out.println(sorted3);
    }
}
