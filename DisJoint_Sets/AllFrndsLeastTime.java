// There are N people in a private party. Initially all are strangers to each other,
// and the people are identified by unique ID from 0 to N-1.

// In the party, whenever two persons (person-A and person-B) become friends, they 
// took a photo. Each of the photo has some information, photos[i]=[T-i, P-j,P-k],
// here T-i indicates time of the photo taken, P-j person with ID 'j', and 
// P-k indicates person with ID 'k'.

// Friendship is symmetric[i.e., If P-j is friend of P-k, then P-k is a friend of P-j].
// Additionally, if person-A is "a friend of person-B OR a friend of someone who is 
// friend of person-B", then person-A is friend of person-B.

// You are given L photos information, Your task is to find the earliest time 
// for which every person became friend with every other person in the party.
// If there is no such earliest time, return -1.


// Input Format:
// -------------
// Line-1: Two space separated integers, N and L.
// Next L lines: Three space separated integers, log[i], 0<=i<L.

// Output Format:
// --------------
// Print an integer result.


// Sample Input-1:
// ---------------
// 6 8
// 5 0 1
// 7 3 4
// 12 2 3
// 21 1 5
// 34 2 4
// 37 0 3
// 42 1 2
// 93 4 5

// Sample Output-1:
// ----------------
// 37


// Sample Input-2:
// ---------------
// 7 6
// 2 0 3
// 5 1 5
// 8 2 5
// 7 3 6
// 9 4 6
// 6 4 5

// Sample Output-2:
// ----------------
// 9


import java.util.*;

class Solution{
    
    private static int[] p;
    private static int res=-1;
    
    private static int find(int z){
        if(p[z]!=z){
            p[z]=find(p[z]);
        }
        return p[z];
    }
    private static void union(int[] data){
        int x=find(data[1]);
        int y=find(data[2]);
        
        if(x!=y){
            if(x<y) p[y]=x;
            else p[x]=y;
            res=Math.max(res,data[0]);
        }
    }
    
    private static void helper(int[][] nums){
        Arrays.sort(nums,(a,b) -> a[0]-b[0]);
        
        for(int i=0;i<nums.length;i++){
            union(nums[i]);
        }
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        p=new int[n];
        for(int i=0;i<n;i++) p[i]=i;
        int m=sc.nextInt();
        int[][] nums=new int[m][3];
        
        for(int i=0;i<m;i++){
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
            nums[i][2]=sc.nextInt();
        }
        
        helper(nums);
        
        System.out.print(res);
    }
}