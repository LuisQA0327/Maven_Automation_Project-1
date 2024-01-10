package Day3_11_14_2023;

public class T5_MultiConditionalLoop {
    public static void main(String[] args) {
        String[] fruitBasket = new String[]{"Grape", "Orange", "Apple", "Mango"};
        //pick out only apple from the basket / array
        //start the for loop because we need to check everything in the basket / array
        for (int i = 0; i < fruitBasket.length; i++) {
            // == (double equal sign) means its a comparison operator
            // = (single equal sign) assigns a value to variable
            // || (two straight bars) is called the OR operator
            //only one condition needs to be true to execute
            if (fruitBasket[i] == "Apple" || fruitBasket[i] == "Grape") {
                System.out.println("My fruit is " + fruitBasket[i]);
            }//end of if clause
        }//end of first for loop
        //&& is the AND operator where both conditions need to be true
        for (int i = 0; i < fruitBasket.length; i++) {
            if (fruitBasket[i] == "Apple" && fruitBasket[i] == "Grape") {
                System.out.println("My fruit is " + fruitBasket[i]);
            }//end of if clause
        }//end of second for loop
    }//end of main
}//end of class
