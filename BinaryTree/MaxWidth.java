// Imagine you are designing a network of secret corridors in an ancient castle. 
// Each chamber in the castle leads to at most two other chambers through 
// hidden passageways, forming a branching layout. 
// The castle’s "longest secret route" is defined as the maximum number of corridors 
// you must traverse to get from one chamber to another (without repeating the corridor). 
// This route may or may not pass through the main entry chamber.

// Your task is to compute the length of longest secret route between 
// two chambers which is represented by the number of corridors between them.

// Example 1
// input=
// 1 2 3 4 5 
// output=
// 3

// Structure:
//        1
//       / \
//      2   3
//     / \
//    4   5

// Explanation:
// The longest secret route from chamber 4 to chamber 3 
// (alternatively, from chamber 5 to chamber 3) along the route:
// 4 → 2 → 1 → 3
// This path has 3 corridors (4–2, 2–1, 1–3), so the length is 3.

// Example 2:
// input=
// 1 -1 2 3 4
// output=
// 2

// Structure:
//    1
//     \
//      2
//     / \
//    3   4

// Explanation:
// The longest secret route from chamber 3 to chamber 4 
// (alternatively, from chamber 1 to chamber 4) along the route:
// 3 → 2 → 4
// This path has 2 corridors (3–2, 2–4), so the length is 2.


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

class MaxWidth{

    private static int helper(TreeNode root,int[] count){
        if(root==null) return 0;
        
        int l=helper(root.left,count);
        int r=helper(root.right,count);
        
        count[0]=(count[0]<(l+r))?(l+r):count[0];
        
        return Math.max(l,r)+1;
        
    }

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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] s = sc.nextLine().split(" ");
    int n = s.length;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = Integer.parseInt(s[i]);

    TreeNode root = buildTree(nums);
    
    int[] count=new int[]{0};
    
    helper(root,count);
    
    System.out.print(count[0]);
    
    sc.close();
  }
}  