import java.util.*;

/********************************************************************
 * Purpose/Description: Given an array, returns its balance index (any) or -1
 * if no balance index exists.
 * Author’s Panther ID: 3354122
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person.
 * Astrid Manuel
 *
 * Running Time: O(n)
 * T(n) = 2n + C
 * Because two for loops are run, each of complexity n (given their size), the
 * complexity of this algorithm is O(n)
 *
 *********************************************************************/

public class ProblemTwo {

  private static final int[] s = {-5, 3, 7, -8, -2, 5, 2};

  /**
   * Runs each test case.
   */
  private static void run() {
    System.out.println("Case #1: Result = " + testCase(s));
  }

  /**
   * Runs a test against a single case.
   *
   * @param nums an array of integers
   * @param key a value to search for
   * @return true if found
   */
  private static int testCase(int[] nums) {
    int total = 0;
    for (int i = 0; i < nums.length; i++) {
      total += nums[i];
    }
    int left = 0;
    for (int i = 0; i < nums.length; i++) {
      total -= nums[i];
      if (left == total) {
        return i;
      }
      left += nums[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    run();
  }
}
