import java.util.*;

/********************************************************************
 * Purpose/Description: Given a sorted array with possible duplicate elements,
 * a value k is checked for number of occurences.
 * Author’s Panther ID: 3354122
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person.
 * Astrid Manuel
 *
 * Running Time: O(n)
 * T(n) = n + C
 * Because one for loop is run, of complexity n (given its size), the
 * complexity of this algorithm is O(n)
 *
 *********************************************************************/

public class ProblemThree{

  //variables for test cases

  public static final int k1 =  -1;
  public static final int k2 = 3;
  public static final int k3 = 7;
  public static final int[] a = {-1, -1, 2, 3, 3, 3, 5, 6, 9, 10};

  /**
   * Performs linear search of array and returns number of occurences
   *

   * @param a an array of sorted integers with possible duplicates
   * @param k a value to search for
   * @return count the number of occurences for integer k
   */
  public static int linearSearch(int[] a, int k){
    int count = 0;
    for(int i=0; i < a.length; i++){
      if (a[i] == k){
        count++;
      }
    }
    return count;
  }

public static void main(String[] args){
  System.out.println("Test1: k1 = " + k1 + " Result = " + linearSearch(a, k1));
  System.out.println("Test2: k2 = " + k2 + " Result = " + linearSearch(a, k2));
  System.out.println("Test3: k3 = " + k3 + " Result = " + linearSearch(a, k3));
}

}
