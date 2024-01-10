package Day2_11_13_2023;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
   //declare an arrayList variable
   ArrayList<String> countries = new ArrayList<>();
   //add some values to the countries array list
        countries.add("USA"); //index 0
        countries.add("INDIA"); //index 1
        countries.add("PAKISTAN"); //index 2
        countries.add("BANGLADESH"); //index 3
        //print out USA
        System.out.println("the first country is" + countries.get(0));
        //print out the current size of the arraylist
        System.out.println("The total size of the countries arraylist is" + countries.size());
        //add another country
        countries.add("CANADA");
        //print the new size of the arraylist
        System.out.println("The new size of the countries arraylist is" + countries.size());
        //declare an integer arraylist
        ArrayList<Integer> studentGrades = new ArrayList<>();
        //add values to studentgrades
        studentGrades.add(90);
        studentGrades.add(80);
        studentGrades.add(20);
        //print out the last students grade
        System.out.println("The third student grade is " + studentGrades.get(2));







    }//end of main code

}//end of class