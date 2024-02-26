package assignments;

import java.util.*;

public class _task01 {
    public static void main(String[] args) {
        List<String> listNames = new ArrayList<>();
        listNames.add("John");
        listNames.add("James");
        listNames.add("Jessica");
        listNames.add("Jerry");

        System.out.println("for loop");
        for (int i = 0; i < listNames.size(); i++) {
            System.out.println(listNames.get(i));
        }

        System.out.println("foreach loop");
        for (String x : listNames) {
            System.out.println(x);
        }

        Iterator <String> it = listNames.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        Map<String, String> mapList = new HashMap<>();
        mapList.put("11B", "John");
        mapList.put("10B", "James");


    }
}
