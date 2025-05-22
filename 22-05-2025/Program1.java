// Sampoornesh Babu is working with Strings.
// He is trying to form a palindrome using two strings P and Q.
// The rules to form the palindrome are as follows:
// 	- Divide the strings P and Q into two parts, and length of P and Q are
// same.
// 	- Division of P and Q should be done at same index position.
// 	- After Division P -> P1 + P2 and Q -> Q1 + Q2, where + indicates
// concatenation.
// 	- Now, check whether P1 + Q2 or Q1 + P2 forms a palindrome or not.
// 	- if palindrome is formed print 'true', otherwise 'false'.

// For Example: 'job' can be divided in the following ways:
// ""+"job", "j"+"ob",  "jo"+"b", "job"+"".

// Your task is to help Sampoornesh Babu to find whether palindrome can be
// formed with the strings P and Q.

// Input Format:
// -------------
// Two space separated strings P and Q

// Output Format:
// --------------
// Print a boolean value, whether can you form a palindrome or not.

// Sample Input-1:
// ---------------
// mortal carrom

// Sample Output-1:
// ----------------
// true

// Explanation:
// ------------
// Divide P="mortal" and Q="carrom" at index 3 as follows:
//     P -> "mor" + "tal", P1 = "mor" and P2 = "tal"
//     Q -> "car" + "rom", Q1 = "car" and Q2 = "rom"

// P1 + Q2 = "morrom" is a palindrome,so print true.

// Sample Input-2:
// ---------------
// romans carrom

// Sample Output-2:
// ----------------
// false


// Time complexity - O(n)
import java.util.*;

class Solution {

  private static boolean helper(String p, String q) {
    int left = 0, right = p.length() - 1;

    boolean flag = true;
    while (left <= right) {
      if (flag) {
        if (p.charAt(left) != q.charAt(right)) {
          flag = false;
          continue;
        }
      } else {
        if (p.charAt(left) != p.charAt(right))
          return false;
      }
      left++;
      right--;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String p = sc.next(), q = sc.next();

    System.out.print(helper(p, q) || helper(q, p));
    sc.close();
  }
}


// Time complexity - O(n^2)
// import java.util.*;

// class Solution{

//     private static boolean isPalindrome(String x){
//         int left=0,right=x.length()-1;

//         while(left<=right){
//             if(x.charAt(left)!=x.charAt(right)) return false;
//             left++;
//             right--;
//         }

//         return true;
//     }

//     private static boolean helper(String p,String q){
//         if(isPalindrome(p) || isPalindrome(q)) return true;

//         int n=p.length();

//         for(int i=0;i<n-1;i++){
//             if(isPalindrome(p.substring(0,i+1)+q.substring(i+1,n)) ||
//             isPalindrome(q.substring(0,i+1)+p.substring(i+1,n))) return true;
//         }

//         return false;
//     }

//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);

//         String p=sc.next(),q=sc.next();

//         System.out.print(helper(p,q));
//     }
// }

