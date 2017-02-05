import java.util.*;

/********************************************************************
 * Purpose/Description: Contains the program logic for determining whether
 * a given integer is in an array containing a strictly increasing sequence
 * followed by a decreasing sequence.
 * Author’s Panther ID: 3354122
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of
 * any other person.
 * Astrid Manuel
 *
 * Running Time: O(log n)
 * T(n) = 2logn + C
 * Because two binary searches were used to search through 2 sub arrays, the complexity
 * of this algorithm is log n.
 *
 */

public class ProblemOne {

  private static final int k1 = 3;
  private static final int k2 = 2;
  private static final int k3 = 15;
  private static final int[] a = {1, 3, 4, 5, 7, 14, 11, 7, 2, -4, -8};
  private static final int[] b = {1, 5, 8, 9, 12, 54, 64, 100, 39, 43, 15, 3, -3};

  /**
   * Runs each test case.
   */
  private static void run() {
    System.out.println("Case #1: k = " + k1 + ", Result = " + testCase(a, k1));
    System.out.println("Case #1: k = " + k2 + ", Result = " + testCase(a, k2));
    System.out.println("Case #1: k = " + k3 + ", Result = " + testCase(a, k3));
    System.out.println("Case #2: k = " + k1 + ", Result = " + testCase(b,k1));
    System.out.println("Case #2: k = " + k2 + ", Result = " + testCase(b,k2));
    System.out.println("Case #2: k = " + k3 + ", Result = " + testCase(b,k3));
  }

  /**
   * Runs a test against a single case.
   *
   * @param nums an array of integers
   * @param key a value to search for
   * @return true if found
   */
  private static boolean testCase(int[] nums, int key) {
    if (nums.length <= 2) {
      return false;
    }
    int mid = (nums.length - 1) / 2;
    int a = mid;
    int b = mid;
    // Find the greatest value
    while (nums[mid] < nums[mid - 1] || nums[mid] < nums[mid + 1]) {
      if (a > 0 && nums[--a] > mid) {
        mid = a;
      }
      if (b < nums.length - 1 && nums[++b] > mid) {
        mid = b;
      }
    }
    // Build subarrays
    int[] left = Arrays.copyOfRange(nums, 0, mid);
    int[] right = Arrays.copyOfRange(nums, mid, nums.length);
    // Perform searches against each
    if (search(left, key, true) || search(right, key, false)) {
      return true;
    }
    return false;
  }

  /**
   * Performs a binary search on an ascending or descending array of integers.
   *
   * @param arr a sorted array of integers
   * @param key a value to search for
   * @param asc use true if ascending, false if descending
   * @return true if found
   */
  private static boolean search(int[] arr, int key, boolean asc) {
    int a = 0;
    int b = arr.length - 1;
    while (a <= b) {
      int mid = (a + b) / 2;
      if (key == arr[mid]) {
        return true;
      } if ((asc && key < arr[mid]) || (!asc && key > arr[mid])) {
        b = mid - 1;
      } else {
        a = mid + 1;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    run();
  }
}
