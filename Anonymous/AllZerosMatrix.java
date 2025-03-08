// A grid of light bulbs is given, represented as a matrix of size rows x cols, 
// where each cell contains either 0 (off) or 1 (on).

// Your task is to turn all the light bulbs off (0) by following the toggle rule:
//     - In each step, you can choose either an entire row or an entire column 
//     and toggle all its elements (change 0 to 1 and 1 to 0).
    
// At the end, if all light bulbs are turned off, print true, otherwise print false.


// Input Format
// -------------
// Line-1: Read two integers rows and cols(space separated).
// Line-2: Read the matrix of dimension rows X cols.

// Output Format
// --------------
// Print a boolean result.



// Sample input-1:
// ---------------
// 5 5
// 0 0 1 0 0
// 0 0 1 0 0
// 1 1 0 1 1
// 0 0 1 0 0
// 0 0 1 0 0

// Sample output-1:
// ----------------
// true

// Explanation:
// ------------
// 0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
// 0 0 1 0 0   row-3  0 0 1 0 0   cols-3  0 0 0 0 0
// 1 1 0 1 1   --->   0 0 1 0 0   --->    0 0 0 0 0
// 0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
// 0 0 1 0 0          0 0 1 0 0           0 0 0 0 0 


// Sample input-2
// --------------
// 2 2
// 1 1
// 0 1

// Sample output-2
// ---------------
// false


import java.util.*;

class AllZerosMatrix{
    
    private static boolean helper(int[][] nums){
        
        
        for(int i=1;i<nums.length;i++){
            boolean same=true,opp=true;
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]!=nums[i-1][j]){
                    same=false;
                    break;
                }
            }
            
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==nums[i-1][j]){
                    opp=false;
                    break;
                }
            }
            
            if(same==false && opp==false) return false;
        }
        
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int m=sc.nextInt(),n=sc.nextInt();
        int[][] nums=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) nums[i][j]=sc.nextInt();
        }
        
        System.out.print(helper(nums));
        sc.close();
    }
}