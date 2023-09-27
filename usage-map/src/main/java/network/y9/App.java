package network.y9;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

    }



    public void sort(){
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


    /**
     * 根据value删除map中的元素
     */
    public void delByValue(){
        Map<String, String> init = new HashMap<>();
        init.put("1","01");


        // 1. hashMap 使用的是fail fast错误机制，所以使用CopyOnWriteArraySet保障线程安全
        Set<Map.Entry<String, String>> entries = new CopyOnWriteArraySet<>(init.entrySet());
        for (Map.Entry<String, String> entry : entries) {
            if("01".equals(entry.getValue())){
                init.remove(entry.getKey());
            }
        }


        // foreach
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(init);
        map.forEach((k,v)->{
            if("01".equals(v)){
                map.remove(k);
            }
        });

        // 迭代器
        Iterator<Map.Entry<String, String>> iterator = init.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            if("01".equals(next.getValue())){
                iterator.remove();
            }
        }

        // remove if

        init.entrySet().removeIf(entry -> "01".equals(entry.getValue()));


        // stream
        init = init.entrySet().stream().filter(entry -> !"01".equals(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    }
}
