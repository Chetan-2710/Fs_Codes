// Siddu wants to get some rain coats before the rainy season begins. 
// There are N rain coats in a store. He is provided an array price[], 
// where price[i] represents the dollar price of the i-th rain coat. 

// Siddu has D dollars to spend, and he wants to buy as many rain coats as 
// he can, to give to his family and friends as gifts.

// Your task is to assist Siddu in purchasing the most number of rain coats 
// possible using D dollars.

// Note: Siddu can purchase the rain coats in any order.

// Input Format:
// -------------
// Line-1: Two space separated integers, N and D
// Line-2: N space separated integers, prices of N rain coats.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 7 15
// 6 12 7 5 13 10 1

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// Siddu purchases Rain coats with price [1$, 5$, 7$] or [1$, 6$, 7$] or [1$, 5$, 6$].


// Sample Input-2:
// ---------------
// 10 3
// 15 13 11 4 11 5 9 14 14 5

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// Siddu can't purchase any rain coat, because he has only 3$s with him.


import java.util.*;

class Program2{
    
    private static int helper(int[] nums,int money,int index,int[][] dp){
        if(index>=nums.length) return 0;
        if(money<0) return 0;
        
        if(dp[index][money]!=-1) return dp[index][money];
        
        int max=helper(nums,money,index+1,dp);
        if(nums[index]<=money) max=Math.max(max,1+helper(nums,money-nums[index],index+1,dp));
        
        return dp[index][money]=max;
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt(),money=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        
        // Arrays.sort(nums);
        
        // int res=0;
        // for(int i=0;i<n;i++){
        //     if(money>=nums[i]){
        //         res++;
        //         money-=nums[i];
        //     }else break;
        // }
        // System.out.print(res);
        
        int[][] dp=new int[n][money+1];
        for(int[] x:dp) Arrays.fill(x,-1);
        
        System.out.print(helper(nums,money,0,dp));
    }
}