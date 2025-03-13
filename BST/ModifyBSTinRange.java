// Imagine you're the curator of an ancient manuscript archive. Each manuscript is
// assigned a unique significance score, and the archive is arranged so that every 
// manuscript on the left has a lower score and every manuscript on the right has a
// higher score, forming a special ordered display. Now, for an upcoming exhibition,
// scholars have decided that only manuscripts with significance scores between low 
// and high (inclusive) are relevant. Your task is to update the archive by removing
// any manuscripts whose scores fall outside the range [low, high]. Importantly, 
// while you remove some manuscripts, you must preserve the relative order of the 
// remaining ones—if a manuscript was originally displayed as a descendant of another, 
// that relationship should remain intact. It can be proven that there is a unique 
// way to update the archive.

// Display the manuscript of the updated archive. Note that the main manuscript 
// (the root) may change depending on the given score boundaries.

// Input format:
// Line 1: space separated scores to build the manuscript archive
// Line 2: two space seperated integers, low and high.

// Output format:
// space separated scores of the updated archive

// Example 1:
// input=
// 1 0 2
// 1 2
// output=
// 1 2

// Explanation:// Initial archieve:
//       1
//      / \
//     0   2


// Updated archieve:
//     1
//      \
//       2
// After removing manuscripts scores below 1 (i.e. 0), only the manuscript with 1 
// and its right manuscript 2 remain.

// Example 2:
// input=
// 3 0 4 2 1
// 1 3
// output=
// 3 2 1

// Explanation:
// Initial archieve:
//           3
//          / \
//         0   4
//          \
//           2
//          /
//         1

// Updated archieve:
//       3
//      /
//     2
//    /
//   1


import java.util.*;

class TreeNode{
    int data;
    TreeNode left=null;
    TreeNode right=null;
    TreeNode(int val){
        data=val;
    }
}

class Solution{
    
    private static TreeNode changeTree(TreeNode root,int low,int high){
        if(root==null){
            return null;
        }
        
        if(root.data<low){
            return changeTree(root.right,low,high);
        }
        if(root.data>high) return changeTree(root.left,low,high);
        
        root.left=changeTree(root.left,low,high);
        root.right=changeTree(root.right,low,high);
        return root;
    }
    
    private static void printTree(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }
        // System.out.println();
    }
    private static TreeNode helper(TreeNode root,int x){
        if(root==null) return new TreeNode(x);
        
        if(x<root.data){
            root.left=helper(root.left,x);
        }else root.right=helper(root.right,x);
        
        return root;
        
    }
    private static TreeNode buildTree(int[] nums){
        if(nums.length==0) return null;
        
        TreeNode root=null;
        for(int x:nums){
            root=helper(root,x);
        }
        return root;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        String[] s=sc.nextLine().split(" ");
        int[] nums=new int[s.length];
        for(int i=0;i<nums.length;i++) nums[i]=Integer.parseInt(s[i]);
        
        TreeNode root=buildTree(nums);
        
        int low=sc.nextInt(),high=sc.nextInt();
        
        // printTree(root);
        
        changeTree(root,low,high);
        
        printTree(root);
        sc.close();
    }
}