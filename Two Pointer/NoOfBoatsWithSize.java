// There are floods in the eastern India.There are infinite number ofboats available
// with National Disaster Response force.Where each boat can carry a maximum weight 
// limit.

// Each boat carries at most two people at same time provided the sum of those people 
// is at most limit. 

// Return the minimum number of boats to carry every given person to rescue them
 
// Input Format
// ------------
// Line1: Two space separated integers, representing no of people and limit of boat
// Line2: space separated integers represents weight of each person 

// Output Format
// -------------
// An integer represents minimum no of boats required


// Example 1:
// -----------
// Input1: 2 3
//         1 2
// Output: 1
// Explanation: 1 boat (1, 2)


// Example 2:
// ----------
// Input2: 4 3
//         3 2 2 1
// Output2: 3
// Explanation: 3 boats (1, 2), (2) and (3)


// Example 3:
// ----------
// Input3: 4 5
//         3 5 3 4
// Output3: 4
// Explanation: 4 boats (3), (3), (4), (5)



import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int max=sc.nextInt();
        int[] nums=new int[n];
        int[] vis=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        Arrays.sort(nums);
        
        int left=0,right=n-1;
        int count=0;
        int prev=-1;
        
        while(right>=0){
            
            if(vis[right]==1){
                right--;
                continue;
            }
            if(left==right){
                if(prev==-1){
                    vis[right]=1;
                    count++;
                    left=0;
                    right--;
                    prev=-1;
                    
                }else{
                    count++;
                    vis[prev]=1;
                    left=0;
                    right--;
                    prev=-1;
                    vis[right]=1;
                }
                continue;
            }
            
            if(vis[left]==0){
                if(nums[left]+nums[right]<=max) prev=left;
                else if(nums[left]+nums[right]>max){
                    if(prev!=-1){
                        vis[prev]=1;
                        prev=-1;
                    }
                        vis[right]=1;
                        count++;
                        right--;
                        left=-1;
                }
            }
            left++;
        }
        
        
        
        System.out.print(count);
        
        
    }
}