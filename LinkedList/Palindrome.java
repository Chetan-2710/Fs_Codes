// Cliff Shaw is working on the singly linked list.
// He is given a list of boxes arranged as singly linked list,
// where each box is printed a positive number on it.

// Your task is to help Mr Cliff to find the given list is equivalent to 
// the reverse of it or not. If yes, print "true", otherwise print "false"

// Input Format:
// -------------
// Line-1: space separated integers, boxes as list.

// Output Format:
// --------------
// Print a boolean a value.


// Sample Input-1:
// ---------------
// 3 6 2 6 3

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 3 6 2 3 6

// Sample Output-2:
// ----------------
// false


import java.util.*;

class LL{
    int data;
    LL next;
    LL(int data){
        this.data=data;
        next=null;
    }
}

class Solution{  
    
    private static void reverse(LL x,LL ne){
        if(x==null) return;
        LL temp=x.next;
        x.next=ne;
        reverse(temp,x);
    }
    
    private static boolean helper(int[] nums){
        LL start=null;
        LL temp=null;
        for(int i=0;i<nums.length;i++){
            LL x=new LL(nums[i]);
            if(start==null){
                start=x;
                temp=x;
            }else{
                temp.next=x;
                temp=x;
            }
        }
        
        LL slow=start;
        LL fast=start;
        
        int flag=0;
        while(fast.next!=null){
            if(fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }else{
                fast=fast.next;
                // System.out.println(start.data+" "+fast.data);
                LL x=slow.next;
                if(slow.next.next==null) return slow.data==slow.next.data;
                slow.next=null;
                reverse(x,null);
                flag=1;
                // System.out.println(start.data+" "+fast.data);
                break;
            }
        }
        
        if(flag==0 && fast.next==null){
            if(slow.next==null) return true;
            LL x=slow.next;
            slow.next=null;
            reverse(x,slow);
        }
        // System.out.println(start.data+" "+fast.data);
        while(start!=null && fast!=null){
            // System.out.println(start.data+" "+fast.data);
            if(start.data!=fast.data) return false;
            start=start.next;
            fast=fast.next;
        }
        // System.out.println(start+" "+fast);
        if(start==null && fast==null) return true;
        return false;
    }
    public static void main(String[] args){
        String[] s=new Scanner(System.in).nextLine().split(" ");
        
        int[] nums=new int[s.length];
        for(int i=0;i<s.length;i++) nums[i]=Integer.parseInt(s[i]);
        
        System.out.print(helper(nums));
    }
}