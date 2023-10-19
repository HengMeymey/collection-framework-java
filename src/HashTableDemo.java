import java.util.Hashtable;

// Cannot null either key or value
//synchronize

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<String, String> nameList = new Hashtable<>(){{
           put("bbb","James Gosling");
           put("ccc","Meymey");
           put("aaa","Thida");
        }};
        System.out.println("Here are the student name : ");
        System.out.println(nameList);
    }
}
