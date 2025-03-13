// You are a gardener designing a beautiful floral pathway in a vast botanical 
// garden. The garden is currently overgrown with plants, trees, and bushes 
// arranged in a complex branching structure, much like a binary tree. Your task 
// is to carefully prune and rearrange the plants to form a single-file walking 
// path that visitors can follow effortlessly.

// To accomplish this, you must flatten the garden’s layout into a linear sequence 
// while following these rules:
//     1. The garden path should maintain the same PlantNode structure, 
//        where the right branch connects to the next plant in the sequence, 
//        and the left branch is always trimmed (set to null).
//     2. The plants in the final garden path should follow the same arrangement 
//        as a pre-order traversal of the original garden layout. 

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// Print the list.


// Sample Input:
// -------------
// 1 2 5 3 4 -1 6

// Sample Output:
// --------------
// 1 2 3 4 5 6


// Explanation:
// ------------
// input structure:
//        1
//       / \
//      2   5
//     / \    \
//    3   4    6
   
// output structure:
// 	1
// 	 \
// 	  2
// 	   \
// 		3
// 		 \
// 		  4
// 		   \
// 			5
// 			 \
// 			  6


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

    private static TreeNode buildTree(int[] nums) {

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        q.offer(root);
    
        int i = 1;
        while (!q.isEmpty() && i < nums.length) {
    
          TreeNode temp = q.poll();
    
          if (nums[i] != -1) {
            temp.left = new TreeNode(nums[i]);
            q.offer(temp.left);
          }
    
          i++;
          if (i < nums.length && nums[i] != -1) {
            temp.right = new TreeNode(nums[i]);
            q.offer(temp.right);
          }
    
          i++;
        }
        return root;
    }
    
    private static TreeNode helper(TreeNode root){
        if(root==null) return null;
        TreeNode lr=helper(root.left);
        TreeNode rr=helper(root.right);
        
        
        
        if(lr==null){ // you checked left but forgot
            if(rr==null) return root;
            return rr;
        }
        
        // TreeNode l=root.left;
        // TreeNode r=root.right;
        
        lr.right=root.right;
        root.right=root.left;
        root.left=null;
        return (rr!=null)?rr:lr; //forgot this
    }

    private static void printLL(TreeNode root){
        if(root==null) return;
        System.out.print(root.data+" ");
        printLL(root.right);
    }
    private static void flattenTree(TreeNode root){
        if(root==null) return;
        helper(root);
        printLL(root);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        // sc.nextDo
        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
          nums[i] = Integer.parseInt(s[i]);
    
        TreeNode root = buildTree(nums);
        
        flattenTree(root);
        sc.close();
    }
} 