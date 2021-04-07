import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
   public static int middleOfThree(int a, int b, int c) {
       if ((a < b && b < c) || (c < b && b < a))
           return b;
       else if ((b < a && a < c) || (c < a && a < b))
           return a;
       else
           return c;
   }
  
   public static void quicksort(int[] arr, int low, int high, String version) {
       //to store left and right of the array
       int left = low;
       int right = high;
      
       //if left crosses right than return
       if (left >= right) {
           return;
       }
      
       //find middle
       int mid = (low + high) / 2;
       //by default pivot is first
       int pivot = arr[low];
       //change pivo according to version of quick sort
       if (version.compareTo("BASIC") == 0) {
           pivot = arr[mid];
       } else if (version.compareTo("MEDIAN") == 0) {
           pivot = middleOfThree(arr[low], arr[high], arr[mid]);
       }

       // partitioning in quick sort while left haven crossed right
       while (left <= right) {
  
           //move left to right untill u find an element greater than pivot
           while (arr[left] < pivot) {
               left++;
           }
          
           //move right to left untill u find an element lesser than pivot
           while (arr[right] > pivot) {
               right--;
           }
          
           //if still left havent crossed riht swap those elements
           if (left <= right) {
               int temp = arr[right];
               arr[right] = arr[left];
               arr[left] = temp;
               left++;
               right--;
           }

       }
      
       //call sort fun recurssivelly
       quicksort(arr, low, right, version);
       quicksort(arr, left, high, version);

   }


   public static void main(String[] args) {
      
       int[] arr = {1,4,2,6,3,4,2,7,8,90,5,4,2,96,6,5};
       quicksort(arr, 0, arr.length-1, "BASIC");
       System.out.println("Quick Sort with First as Pivote");
       for(int val : arr) {
           System.out.println(val);
       }
      
       int[] arr1 = {1,4,2,6,3,4,2,7,8,90,5,4,2,96,6,5};
       quicksort(arr1, 0, arr1.length-1, "MEDIAN");
       System.out.println("Quick Sort with Median of First, Last, Middle as Pivote");
       for(int val : arr1) {
           System.out.println(val);
       }
   }

}