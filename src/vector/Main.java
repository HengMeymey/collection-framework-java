package vector;

import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Vector<String> allNames = new Vector<>(){{
            add("Meymey");
            add("Linda");
        }};
        allNames.remove("Linda");
        allNames.add(1,"Bona Gosling");
        allNames.set(1,"James Gosling");



        System.out.println("All names : "+allNames);

        System.out.println("=========== Enumeration ===========");
        Enumeration<String> names = allNames.elements();
        while (names.hasMoreElements()){
            System.out.println("Name is : "+names.nextElement());
        }

    }
}
