package ActionItems;
import java.util.ArrayList;
public class ActionItem2_Part_1 {
    public static void main(String[] args) {
        //declare an arraylist variables
        // Creating ArrayLists for region and areaCode
        ArrayList<String> region = new ArrayList<>();
        ArrayList<String> areaCode = new ArrayList<>();

        // Adding values to the ArrayLists
        region.add("Brooklyn");
        region.add("Manhattan");
        region.add("Queens");
        region.add("Staten Island");

        areaCode.add("07083");
        areaCode.add("07208");
        areaCode.add("11348");
        areaCode.add("10957");

        // Iterating through the ArrayLists using a for loop
        for (int i = 0; i < region.size(); i++) {
            System.out.println("My region is " + region.get(i) + " and my area code is " + areaCode.get(i));
        }//end of loop
    }//end of main
}//end of assignment


