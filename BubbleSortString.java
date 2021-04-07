import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSortString {

   public static void main(String[] args) {
       //create arrayy list from given array of string
       ArrayList<String> list = new ArrayList<String>(
               Arrays.asList("right",
                       "subdued",
                       "trick",
                       "crayon",
                       "punishment",
                       "silk",
                       "describe",
                       "royal",
                       "prevent",
                       "slope"));
      
       //bubble sort
       for (int i = 0; i < list.size(); i++) {
           for (int j = 0; j < list.size(); j++) {
               //compare ith jth string if ith > jth swap
               if(list.get(i).compareTo(list.get(j)) < 0) {
                   String temp = list.get(i);
                   list.set(i, list.get(j));
                   list.set(j, temp);
               }
           }
       }
      
       //print sorted list
       for (String val : list) {
           System.out.println(val);
       }
   }

}