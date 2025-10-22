import java.util.*;
public class LargestElementInArray {
 
  public static void main(String args[]) {
 
    int arr1[] =  {2,5,1,3,0};
    System.out.println("The Largest element in the array is: " + sort(arr1));
   
    int arr2[] =  {8,10,5,7,9};
    System.out.println("The Largest element in the array is: " + sort(arr2));

    int arr3[] = {4,6,2,1,8,9,20,3,5,7};
    System.out.println("The Largest element in the array is: " + findLargestNaive(arr3));
  }
  static int sort(int arr[]) {
    Arrays.sort(arr);
    return arr[arr.length - 1];
  }
 // Naive approach to find the largest element
public static int findLargestNaive(int[] arr) {
    int largest = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > largest) {
            largest = arr[i];
        }
    }
    return largest;
}

}
