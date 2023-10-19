package map;

import com.sun.source.tree.Tree;

import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

class Student{
    int id;
    String name;
    String gender;
    Student(){}
    Student(int id,String name,String gender){
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}'+'\n';
    }


}

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String,Student> students = new TreeMap<>(){{
           put("M-1000",new Student(10001,"Mey","female"));
           put("F-1001",new Student(10002,"Sela","male"));
        }};

        TreeMap<String,String> nameList = new TreeMap<>(){{
           put("zzz","this is zzz value");
           put("bbb","this is bbb value");
           put("aaa","this is aaa value .");
           put("ccc",null);        }};

//        System.out.println(students);
        System.out.println(nameList);
        System.out.println(new TreeSet<>(nameList.keySet()).descendingSet()); //descending order
    }
}
