// There are N computers in a network, all the computers are connected as tree 
// structure. And one new connection is added in the Network. The computers in 
// the network are identified with their IDs, the IDs are numbered between 1 to N.

// The connections in the network is given as coonection[i] = [comp-A, comp-B], 
// there is a connection between comp-A and comp-B.

// Your task is to remove a connection in the network and print it, so that 
// all the computers are connected as tree structure. If there are multiple 
// options to remove, remove the connection that occurs last in the input.

// Note :- The Tree is not a directed Tree

// Input Format:
// -------------
// Line-1: Two space separated integers N, number of computers.
// Next N lines: Two space separated integers, comp-A & comp-B.

// Output Format:
// --------------
// Print the connection which is removed.


// Sample Input-1:
// ---------------
// 6
// 1 2
// 3 4
// 3 6
// 4 5
// 5 6
// 2 3

// Sample Output-1:
// ---------------
// 5 6


// Sample Input-2:
// ---------------
// 4
// 1 2
// 2 3
// 3 4
// 2 4

// Sample Output-2:
// ---------------
// 2 4

import java.util.*;

class Solution{
    private static int[] p;
    
    private static int find(int z){
        if(p[z]!=z){
            p[z]=find(p[z]);
        }
        return p[z];
    }
    
    private static void union(int a,int b,List<int[]> l){
        int x=find(a);
        int y=find(b);
        
        if(x!=y){
            if(x<y){
                p[y]=x;
            }else p[x]=y;
        }else l.add(new int[]{a,b});
    }
    private static void helper(int[][] nums,int max){
        p=new int[max+1];
        for(int i=0;i<max+1;i++) p[i]=i;
        
        List<int[]> l=new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            union(nums[i][0],nums[i][1],l);
        }
        
        int[] res=l.remove(l.size()-1);
        
        System.out.print(res[0]+" "+res[1]);
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int[][] nums=new int[n][2];
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            nums[i][0]=sc.nextInt();
            nums[i][1]=sc.nextInt();
            max=Math.max(max,Math.max(nums[i][0],nums[i][1]));
        }
        
        helper(nums,max);
    }
} 