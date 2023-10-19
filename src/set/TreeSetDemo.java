package set;

import java.util.List;
import java.util.TreeSet;

// order and not null value

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<String> name = new TreeSet<>(
                List.of("z-index","apple","orange","banana")
        );

        //ascending order
        System.out.println("Names : "+name);

        //descending order
        System.out.println("Names in descending order is : "+name.descendingSet());
    }
}
