// Budget Padmanabham planned to visit the tourist places. There are N tourist 
// places in the city. The tourist places are numbered from 1 to N.

// You are given the routes[] to travel between the tourist places in the city.
// where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
// You can travel from place-1 to place-2 or place-2 to place-1 with the given price.
 
// Your task is to help Budget Padmanabham to find the cheapest route plan, to 
// visit all the tourist places in the city. If you are not able to find such plan, 
// print -1.
 
// Input Format:
// -------------
// Line-1: Two space separated integers N and R,number of places and routes.
// Next R lines: Three space separated integers, start, end and price.
  
// Output Format:
// --------------
// Print an integer, minimum cost to visit all the tourist places.
 
 
// Sample Input-1:
// ---------------
// 4 5
// 1 2 3
// 1 3 5
// 2 3 4
// 3 4 1
// 2 4 5
 
// Sample Output-1:
// ----------------
// 8
 
// Explanation:
// ------------
// The cheapest route plan is as follows:
// 1-2, 2-3, 3-4 and cost is 3 + 4 + 1 = 8
 
 
// Sample Input-2:
// ---------------
// 4 3
// 1 2 3
// 1 3 5
// 2 3 4
 
// Sample Output-2:
// ----------------
// -1


import java.util.*;

class Solution{
    
    private static int[] p;
    private static int res=0;
    
    private static int find(int z){
        if(p[z]!=z){
            p[z]=find(p[z]);
        }
        return p[z];
    }
    private static void union(int[] data){
        int x=find(data[0]);
        int y=find(data[1]);
        
        if(x!=y){
            if(x<y) p[y]=x;
            else p[x]=y;
            res+=data[2];
        }
    }
    
    private static int helper(int[][] nums){
        Arrays.sort(nums,(a,b) -> a[2]-b[2]);
        
        for(int i=0;i<nums.length;i++){
            union(nums[i]);
        }
        
        for(int i=2;i<p.length;i++){
            if(find(p[i])!=find(p[i-1])) return -1;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        p=new int[n+1];
        for(int i=0;i<n;i++) p[i]=i;
        
        int m=sc.nextInt();
        int[][] nums=new int[m][3];
        
        for(int i=0;i<m;i++){
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
            nums[i][2]=sc.nextInt();
        }
        
        System.out.print(helper(nums));
        
    }
} 