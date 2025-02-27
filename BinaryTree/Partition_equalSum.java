// Balbir Singh is working with networked systems, where servers are connected 
// in a hierarchical structure, represented as a Binary Tree. Each server (node) has 
// a certain processing load (integer value).

// Balbir has been given a critical task: split the network into two balanced 
// sub-networks by removing only one connection (edge). The total processing 
// load in both resulting sub-networks must be equal after the split.

// Network Structure:
// - The network of servers follows a binary tree structure.
// - Each server is represented by an integer value, indicating its processing load.
// - If a server does not exist at a particular position, it is represented as '-1' (NULL).
	
// Help Balbir Singh determine if it is possible to split the network into two equal 
// processing load sub-networks by removing exactly one connection.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 1 2 3 5 -1 -1 5

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 3 2 4 3 2 -1 7

// Sample Output-2:
// ----------------
// false


import java.util.*;

class TreeNode {
  int data;
  TreeNode left, right;
  TreeNode(int val) {
    data = val;
    left = null;
    right = null;
  }
}

class Solution{
    
    private static int findSum(TreeNode root,Hashtable<Integer,Integer> h){
        if(root==null) return 0;
        int temp=root.data+findSum(root.left,h)+findSum(root.right,h);
        h.put(temp,1);
        return temp;
    }
    
    private static boolean balancedLoad(TreeNode root){
        if(root==null || (root.left==null && root.right==null)) return false;
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int sum=findSum(root,h);
        if(sum%2!=0) return false;
        for(Integer x:h.keySet()){
            if(sum/2==x) return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
          nums[i] = Integer.parseInt(s[i]);
    
        TreeNode root = buildTree(nums);
        
        System.out.println(balancedLoad(root));
    }
}