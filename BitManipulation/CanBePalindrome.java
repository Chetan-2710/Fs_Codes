// AlphaCipher is a string formed from another string by rearranging its letters

// You are given a string S.
// Your task is to check, can any one of the AlphaCipher is a palindrome or not.

// Input Format:
// -------------
// A string S

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// carrace

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// code

// Sample Output-2:
// ----------------
// false


import java.util.*;

class Solution{
    
    private static boolean helper(String s){
        int bitmask=0;
        
        for(int i=0;i<s.length();i++){
            int count=s.charAt(i)-'a';
            bitmask=bitmask^(1<<count);
        }
        return (bitmask & (bitmask-1))==0;
    }
    public static void main(String[] args){
        String s=new Scanner(System.in).next();
        
        System.out.print(helper(s));
    }
} 