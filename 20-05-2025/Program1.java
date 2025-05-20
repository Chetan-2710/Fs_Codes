// A binary word Bn is formed as follows:
//     B[1] = "0"
//     B[i+1] =  B[i] $ "1" $ reverse(complement(B[i])) for i > 1

// where $ denotes the concatenation operation, reverse(complement(B)) returns 
// the reversed word of complement(B), which perform 1's complement of B 
// (0 changes to 1 and 1 changes to 0).

// For example, the first 4 words in the above sequence are:

//     B[1] = "0"
//     B[2] = "011"
//     B[3] = "0111001"
//     B[4] = "011100110110001"

// Return the Pth bit in B[N]. It is guaranteed that P is valid for the given N.

// Input Format:
// -------------
// Line-1: Two space seperated integers represents N and P.

// Output Format:
// --------------
// Return a bit (0 or 1).


// Sample Input-1:
// ---------------
// 3 4

// Sample Output-1:
// ----------------
// 1

// Explanation:
// ------------
// B[3] = "0111001" and 4th bit is 1.

// Sample Input-2:
// ---------------
// 4 10

// Sample Output-2:
// ----------------
// 1

// Explanation:
// -------------
// B[4] = "011100110110001" and 10th bit is 1.



// Time Complexity - O(n)
import java.util.*;

class Program1{

    // Recursive function to get P-th bit of B[N]
    static int getBit(int n, int p) {
        if (n == 1) return 0; // B[1] = "0"

        int mid = (1 << (n - 1)); // mid position = 2^(n-1)

        if (p == mid) {
            return 1; // middle bit is always '1'
        } else if (p < mid) {
            return getBit(n - 1, p); // first half, same as B[n-1]
        } else {
            int mirror = (1 << n) - p; // mirrored position
            return 1 - getBit(n - 1, mirror); // complement of mirror
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = sc.nextInt();
        System.out.println(getBit(n, p));
        sc.close();
    }
}



// Time Complexity ~ O(2^n)
// import java.util.*;

// class Program1{

//     private static char helper(StringBuilder sb,int p){
//         if(p<sb.length()) return sb.charAt(p);
        
//         int n=sb.length();
//         sb.append("1");
        
//         for(int i=n-1;i>=0;i--){
//             if(sb.charAt(i)=='0') sb.append("1");
//             else sb.append("0");
//         }
        
//         return helper(sb,p);
//     }
    
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
        
//         int n=sc.nextInt(),p=sc.nextInt();
        
//         System.out.print(helper(new StringBuilder("0"),p-1));

//         sc.close();
//     }
// }