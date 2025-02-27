// Balbir Singh is working with Binary Trees.
// The elements of the tree is given in the level order format.
// Balbir has a task to split the tree into two parts by removing only one edge
// in the tree, such that the product of sums of both the splitted-trees should be maximum.

// You will be given the root of the binary tree.
// Your task is to help the Balbir Singh to split the binary tree as specified.
// print the product value, as the product may be large, print the (product % 1000000007)
	
// NOTE: 
// Please do consider the node with data as '-1' as null in the given trees.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// Print an integer value.


// Sample Input-1:
// ---------------
// 1 2 4 3 5 6

// Sample Output-1:
// ----------------
// 110

// Explanation:
// ------------
// if you split the tree by removing edge between 1 and 4, 
// then the sums of two trees are 11 and 10. So, the max product is 110.


// Sample Input-2:
// ---------------
// 3 2 4 3 2 -1 6

// Sample Output-2:
// ----------------
// 100


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

class Solution {
    private static int findSum(TreeNode root,Hashtable<Integer,Integer> h){
        if(root==null) return 0;
        int s=root.data+findSum(root.left,h)+findSum(root.right,h);
        h.put(s,1);
        return s;
    }
    
    
    private static int max(TreeNode root){
        if(root==null) return 0;
        Hashtable<Integer,Integer> h=new Hashtable<>();
        int sum=findSum(root,h);
        int res=Integer.MIN_VALUE;
        for(Integer k:h.keySet()){
            res=Math.max(res,(k*(sum-k))%1000000007);
        }
        return res;
    }
    
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] s = sc.nextLine().split(" ");
    int n = s.length;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = Integer.parseInt(s[i]);

    TreeNode root = buildTree(nums);
    
    System.out.println(max(root));
  }
} 