package Day4_12202023;

import java.util.HashMap;

public class T1_HashMap {
    public static void main(String[] args) {
        //create a hashmap consisting of name and age for Triage Students
        HashMap<String, Integer> traigeStudents = new HashMap<>();
        //add some values for the triagestudents hashmap
        traigeStudents.put("Noor", 25);
        traigeStudents.put("Asif", 26);
        traigeStudents.put("Justin", 28);
        //print out the size of the triagestudents hashmap
        System.out.println("The size of the hasmap is " + traigeStudents.size());
        //print out the content of the hashmap
        System.out.println(traigeStudents);

        //print out Asifs age only if Asif exist in the data set
        if (traigeStudents.containsKey("Asif")){
            int asifAge = traigeStudents.get("Asif");
            System.out.println("Asifs age is" + asifAge );
        }//end of if condition
        //does not print Asfanas age because we never added her to the data set
        System.out.println("Afsana age is " + traigeStudents.get("Afsana"));

    }
    //end of main
//end of class
}
