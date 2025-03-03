// Two brothers want to play a game,
// The rules of the game are: one player gives two sorted lists of
// numerical elements and a number (sum).
// The opponent has to find the closest pair of elements
// to the given sum.
// -> pair consists of elements from each list

// Please help those brothers to develop a program, that takes
// two sorted lists as input and return a pair as output.

// Input Format:
// -------------
// size of list_1
// list_1 values
// size of list_2
// list_2 values
// closest number

// Output Format:
// --------------
// comma-separated pair

// Sample Input-1:
// ---------------
// 4
// 1 4 5 7
// 4
// 10 20 30 40
// 32
// Sample Output-1
// ---------------
// 1, 30

// Sample Input-2
// ---------------
// 3
// 2 4 6
// 4
// 5 7 11 13
// 15
// sample output-2
// ---------------
// 2, 13

// NOTE :- Do using binary search

import java.util.*;

class Solution {

  private static int[] helper(int n1, int[] nums1, int n2, int[] nums2,
                              int target) {

    int[] res = new int[] {-1, -1};
    int min = Integer.MAX_VALUE;

    int x = 0, y = n2 - 1;

    while (x < n1 && y >= 0) {

      int temp = nums1[x] + nums2[y];

      if (temp == target)
        return new int[] {nums1[x], nums2[y]};

      int dif = Math.abs(target - temp);
      if (dif < min) {
        min = dif;
        res[0] = nums1[x];
        res[1] = nums2[y];
      }

      if (temp > target) {
        y--;
      } else {
        x++;
      }
    }
    return res;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n1 = sc.nextInt();
    int[] nums1 = new int[n1];
    for (int i = 0; i < n1; i++)
      nums1[i] = sc.nextInt();

    int n2 = sc.nextInt();
    int[] nums2 = new int[n2];
    for (int i = 0; i < n2; i++)
      nums2[i] = sc.nextInt();

    int target = sc.nextInt();

    int[] res = helper(n1, nums1, n2, nums2, target);
    System.out.print(res[0] + ", " + res[1]);
  }
}