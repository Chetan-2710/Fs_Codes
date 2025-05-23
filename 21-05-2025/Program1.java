// There is a large table, and a shooter kept N watermelons on it.
// Each watermelon is kept one after the other in the given X-axis positions.
// The length of the watermelons may vary.

// The shooter has a raffle gun, and it can blast any number of watermelons
// into pieces with single shot in a straight line. After each gun shot,
// you can remove the blasted watermelons

// You will be given the positions of the watermelons on the large table
// melons[]. where melon[i] = [Xi, Xj], indicates the melon kept in the table
// between Xi and Xj and watermelon length is Xj-Xi, and Xi<Xj.

// Your task is to find the minimum number of gun shots,
// required to blast all the watermelons into pieces.

// Input Format:
// -------------
// Line-1: An integer N, number of watermelons.
// Next N lines: Two space separated integers, Xi and Xj.

// Output Format:
// --------------
// Print an integer result, number of gunshots required.

// Sample Input-1:
// ---------------
// 5
// 5 8
// 4 10
// 6 11
// 10 14
// 11 16

// Sample Output-1:
// ----------------
// 2

// Sample Input-2:
// ---------------
// 5
// 1 3
// 5 7
// 8 10
// 6 9
// 11 13

// Sample Output-2:
// ----------------
// 4

import java.util.*;

class Program1 {

  private static int helper(int[][] nums) {
    Arrays.sort(nums, (a, b) -> a[1] - b[1]);

    int res = 0, endpoint = Integer.MIN_VALUE;
    for (int[] x : nums) {
      if (x[0] > endpoint) {
        res++;
        endpoint = x[1];
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[][] nums = new int[n][2];
    for (int i = 0; i < n; i++) {
      nums[i][0] = sc.nextInt();
      nums[i][1] = sc.nextInt();
    }

    System.out.print(helper(nums));
    sc.close();
  }
}