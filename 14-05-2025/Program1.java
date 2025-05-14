// You are given two strings 'Org' and 'Sub' where Sub is a subsequence of Org. 
// You aer given a list of R indices[] (Unique indices), and you need to delete 
// P letters from the given string 'Org', with the following conditions:
//     - You need to delete the first P letters from strin 'Org'in the given order
//       of indices[] only.
//     - After deleting P letters, the string 'Sub' should be subsequence of 'Org'.
//       Where, 0 <= i < P and P < R.
     
// Your task is to maximixe the value of P such that 'Sub' is still a subsequence 
// of 'Org' after the deletion of letters, and return P.

// Input Format:
// -------------
// Line-1: Two space seperated strings, Original and Sub
// Line-2: An integer, R, number of indices.
// Line-3: R space separated integers, indices[].

// Output Format:
// --------------
// Print an integer, the maximum value of P.


// Sample Input-1:
// ---------------
// pqrprq pr
// 3
// 3 1 0

// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// After deleting 2 letters at indices 3 and 1, "pqrprq" becomes "prrq".
// "pq" is a subsequence of "prrq".
// If you delete 3 letters at indices 3, 1, and 0, "pqrprq" becomes "rrq", 
// and "pq" is not a subsequence of "rrq".
// Hence, the maximum P is 2.

// Sample Input-2:
// ---------------
// pqrqssss pqrs
// 6
// 3 2 1 4 5 6

// Sample Output-2:
// ----------------
// 1

// Explanation: 
// ------------
// After deleting 1 letter at index 3, "pqrqssss" becomes "pqrssss".
// "pqrs" is a subsequence of "pqrssss".


import java.util.*;

class Program1{
    
    private static boolean check(String org,String sub,Set<Integer> set){
        int i=0,j=0;
        
        while(i<org.length() && j<sub.length()){
            if(!set.contains(i) && org.charAt(i)==sub.charAt(j)) j++;
            i++;
        }
        
        return j==sub.length();
    }
    
    private static int helper(String org,String sub,int[] nums){
        int p=0;
        Set<Integer> set=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
            if(check(org,sub,set)) p++;
            else break;
        }
        
        return p;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String org=sc.next(),sub=sc.next();
        sc.nextLine();
        
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        
        System.out.print(helper(org,sub,nums));
        sc.close();
    }
}