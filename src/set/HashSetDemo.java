package set;

import java.util.*;


// store element no order can store null value


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

    //equals & hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender);
    }
}
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> uniqueNames = new HashSet(){{
           add("Thida");
           add("Bona");
           add("James");
           add("Bona");
        }};
        uniqueNames.remove("Thida");
        for (String name : uniqueNames){
            System.out.println("Name is : "+name);
        }

        Iterator<String> itr = uniqueNames.iterator();
        while (itr.hasNext()){
            System.out.println("Name -> "+itr.next());
        }

        System.out.println("Here are all names : "+uniqueNames);


        ArrayList<String> roles = new ArrayList<>(List.of("Customer","Admin","Admin","Customer"));
        HashSet<String> uniqueRoles = new HashSet<>(roles);
        roles = new ArrayList<>(uniqueRoles);
        System.out.println("Roles : "+roles);



        HashSet<Student> students = new HashSet<>(){{
            add(new Student(1001,"Meymey","female"));
            add(new Student(1002,"Linda","male"));
            add(new Student(1001,"Meymey","female"));
        }};

        System.out.println("Here are all students : ");
        System.out.println(students);
    }
}
