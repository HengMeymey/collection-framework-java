package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer,String> studentInfos = new HashMap<>(){{
            put(1000,"Sreypich");
//            put(null,null);
        }};
        studentInfos.put(1001,"Meymey");
        studentInfos.put(1005,"Neary");
        studentInfos.put(1003,"John");

        System.out.println("Here are students information : ");
        System.out.println(studentInfos);

        //loop
        System.out.println("Key is 1001 : "+studentInfos.get(1001));
//        Set<Integer> keys = studentInfos.keySet();
        Set<Integer> keys = new TreeSet<>(studentInfos.keySet());
        System.out.println("All keys are : "+keys);

        //print value base on key
        for(Integer key : keys){
            System.out.println("Key = "+key+" => "+studentInfos.get(key));
        }

        System.out.println("================ Using EntrySet ================");
        Set<Map.Entry<Integer,String>> entries = studentInfos.entrySet();
        for (Map.Entry<Integer,String> entry : entries){
            System.out.println("Key = "+entry.getKey()+""+" , Value is : "+entry.getValue());
        }

        //stream
        System.out.println("=================== Printing using stream");
        studentInfos.keySet().forEach(
                e-> System.out.println(studentInfos.get(e))
        );
    }
}
