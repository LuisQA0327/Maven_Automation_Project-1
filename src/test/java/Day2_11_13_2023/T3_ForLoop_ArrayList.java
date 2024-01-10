package Day2_11_13_2023;

import java.util.ArrayList;

public class T3_ForLoop_ArrayList {
    public static void main(String[] args) {
//declare an arraylist variables
        ArrayList<String> countries = new ArrayList<>();
//add some values to the countries arraylist
        countries.add("USA"); //index 0
        countries.add("INDIA"); //index 1
        countries.add("PAKISTAN"); //index 2
        countries.add("BANGLADESH"); //index 3
        countries.add("MEXICO"); //index 4
//print out all the countries from the arraylist
        for (int i = 0; i < countries.size(); i++) {
            //print out all the countries
            System.out.println("My country is " + countries.get(i));
        }//end of loop
    }//end of main
}//end of class
