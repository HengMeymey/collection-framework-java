import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // class , wrapper class , not for primitive
        List<String> names = new ArrayList<>(List.of("John","James"));  //Down casting
        names = new ArrayList<>(Arrays.asList("JOhn","Bona"));

        //initial for your own custom class
        names = new ArrayList<>(){{
            add("Meymey");
            add("Thida");
        }};

        names.add("Nisa");
        names.set(1,"Bona"); // Modify

        //names.clear(); //delete all

        names.remove("Bona"); //delete by object
//        names.remove(1); //delete by index

        names.add(0,"Neary"); //add by index


        //for loop
        for (int i = 0; i<names.size(); i++){
            System.out.println("Name "+(i+1)+" : "+names.get(i));
        }

        //foreach loop
        System.out.println("Using foreach loop : ");
        for (String name : names){
            System.out.println("Name is : "+name);
        }

        System.out.println("Meymey at index : "+names.indexOf("Meymey")); //find index
        System.out.println("Total element : "+names.size()); // count element
        System.out.println("Name at index 2 : "+names.get(2)); //find name by index
        System.out.println("All names are : "+names); // output all object
    }
}
