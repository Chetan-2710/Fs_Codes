// Birbal is creating a new binary code system BBC (Birbal Binary Code) as
// follows:

// I	f(I)
// -------
// 0	""
// 1	"0"
// 2	"1"
// 3	"00"
// 4	"01"
// 5	"10"
// 6	"11"
// 7	"000"

// You are given an integer value I, where I is positive number.
// Your task is to find BBC representation of  the given number I.

// Input Format:
// -------------
// An integer I

// Output Format:
// --------------
// Print the BBC representation of I.

// Sample Input-1:
// ---------------
// 23

// Sample Output-1:
// ----------------
// 1000

// Sample Input-2:
// ---------------
// 45

// Sample Output-2:
// ----------------
// 01110

// NOTE :- DO this
// 0, 1,
// 00, 01
// 10, 11  =>  Add the values of 0 and 1 at the back of the previous strings i.e
// build the number from scratch

import java.util.*;

class Solution {
  public static void main(String[] args) {
    int n = new Scanner(System.in).nextInt();

    int sum = 0;
    StringBuilder sb = new StringBuilder();
    if (n != 0) {
      for (int i = 1; i <= 30; i++) {
        sum += Math.pow(2, i);
        if (n <= sum) {
          int base = sum - (int)Math.pow(2, i) + 1;
          int dif = n - base;
          String s = Integer.toBinaryString(dif);

          for (int j = 0; j < i - s.length(); j++) {
            sb.append("0");
          }
          sb.append(s);
          break;
        }
      }
    }

    System.out.print(sb.toString());
  }
}