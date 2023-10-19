package linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>(){{
            add("January");
            add("February");
            add("March");
        }};

        names.add("April");;
        names.set(2,"Mana");
        names.remove(1);

        String popItem = names.pop();
        names.push("Iterator");
        System.out.println("Pop Item is : "+popItem);

        System.out.println("All names : "+names);

        Iterator<String> itr= names.iterator();
        while (itr.hasNext()){
            System.out.println("Name is : "+itr.next());
        }
    }
}
