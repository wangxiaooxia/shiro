package com.qianfeng;


import java.util.*;

public class TestMap {
    public static void main(String[] args) {
//        HashMap<String,String> map = new HashMap<>();
//        map.put("name","test");
//        map.put("name2","test1");
//        map.put("name3","test2");
//
//        HashMap<String,String> map2 = new HashMap<>();
//        map2.put("name5","test1");
//        map2.put("name6","test7");
//        map2.put("name7","test3");
//        List list = new ArrayList();
//
//        Map<String,String> r1 = Maps.filterValues(map,e-> !map2.containsKey(e));
//        Map<String,String> r2 = Maps.filterValues(map2,e-> !map.containsKey(e));
//
//        list.add(r1.values());
//        list.add(r2.values());
//        System.out.println(list);
        Map<String, Integer> map0 = new HashMap<String, Integer>();
        Map<String, Integer> map1 = new HashMap<String, Integer>();
        map0.put("a", 1);
        map0.put("b", 2);
        map0.put("c", 3);

        map1.put("a", 1);
        map1.put("d", 12);
        map1.put("c", 13);
        //map1.put("d", 14);
        Set<String> set = map0.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Integer val0 = map0.get(key);
            Integer val1 = map1.get(key);
            if (val0 != val1) {
                System.out.println(val0);
                System.out.println(val1);
            }
        }

    }
}
