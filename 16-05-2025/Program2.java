// There are N employees from 3 different companies in a row, emps[], the employees 
// are identified using company IDs as 1,2,3. A Courier Boy need to deliver 
// P parcels to these 3 companies. The parcel details are given as parcels[],
// where parcel[i]=[Ci,CIDi], i-th parcel, 'Ci' is Courier Boy's current position, 
// and  'CIDi' is company's ID, he/she need to deliver parcel[i] from Ci position 
// to the nearest employee belongs to companay ID equals to CIDi in the row.

// You are given emps[] and parcels[] information,
// Your task is to help the courier boy to find the distance between him to 
// the nearest employee in that row to deliver the parcel.
// If there is no solution found, return -1.

// Input Format:
// -------------
// Line-1: Two space separated integers, N and P
// Line-2: N space separated integers, only 1, 2 & 3.
// Next P lines: Two space separated integers, position Ci and Company ID

// Output Format:
// --------------
// Print the space separated integers, distance between boy and the employee for 
// all the parcels.


// Sample Input-1:
// ---------------
// 6 2
// 1 1 2 2 3 3
// 1 3
// 2 2

// Sample Output-1:
// ----------------
// 3 0 

// Sample Input-2:
// ---------------
// 5 2
// 1 2 3 2 1
// 2 1
// 1 1

// Sample Output-2:
// ----------------
// 2 1 

import java.util.*;

class Program2{
    public static void  main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt(),p=sc.nextInt();
        
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        
        int[] res=new int[p];
        Arrays.fill(res,Integer.MAX_VALUE);
        
        for(int x=0;x<p;x++){
            int src=sc.nextInt();
            int id=sc.nextInt();
            
            int left=0;
            for(int i=src;i>=0;i--){
                if(nums[i]==id){
                    res[x]=Math.min(res[x],left);
                    break;
                }
                left++;
            }
            
            int right=0;
            for(int i=src;i<n;i++){
                if(nums[i]==id){
                    res[x]=Math.min(res[x],right);
                    break;
                }
                right++;
            }
            
            if(res[x]==Integer.MAX_VALUE) res[x]=-1;
        }
        
        for(int i=0;i<p;i++){
            System.out.print(res[i]);
            if(i!=p-1) System.out.print(" ");
        }
        sc.close();
    }
}
