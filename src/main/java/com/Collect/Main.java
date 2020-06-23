package com.Collect;

import com.TPM_Network.TPM.InputStage;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : wangxuan
 * @date : 15:15 2020/6/23 0023
 */

class person{
    public String name;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public person setname(String name){
        return new person();
    }
    public person setage(int age){
        return new person();
    }
}
public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("1","wang");
        map.put("2","xuan");
        list.add("1");
        list.add("3");
        list.add("5");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Collections.sort(list);
        Collections.reverse(list);
//        Collections.sort(list,((o1, o2) -> {
//
//            return 0;
//        }));
        Collection<String> collection = new LinkedList<>();

        List<person> people = new ArrayList<>();
        List<String> name = people.stream().map(person::getName).limit(2).collect(Collectors.toList());

        person p = new person();
        p.setname("1111").setage(1).setName("111");
        System.out.println(list);
    }
}
