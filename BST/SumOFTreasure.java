// Imagine you are designing a grand castle where each room holds a specific amount 
// of treasure. The castle is built in a binary layout, meaning every room may lead 
// to two adjacent wings—a left wing and a right wing. 

// An "organized section" of the castle follows this rule: for any given room, 
// every room in its left wing contains a treasure value that is strictly less 
// than the current room’s value, and every room in its right wing contains a 
// value that is strictly greater. Additionally, each wing must itself be organized
// according to the same rule.

// Your challenge is to determine the maximum total treasure (i.e., the sum of 
// treasure values) that can be gathered from any such organized section of the castle.

// Example 1:
// input=
// 1 4 3 2 4 2 5 -1 -1 -1 -1 -1 -1 4 6
// output=
// 20

// Castle:
//           1
//         /   \
//        4     3
//       / \   / \
//      2   4 2   5
//               / \
//              4   6

// Explanation: The best organized section starts at the room with a treasure value 
// of 3, yielding a total treasure of 20.

// Example 2:
// input=
// 4 3 -1 1 2
// output=
// 2

// Castle:
//     4
//    /
//   3
//  / \
// 1   2

// Explanation: The optimal organized section is just the single room with a 
// treasure value of 2.

// Example 3:
// input=
// -4 -2 -5
// output=
// 0

// Castle:
//    -4
//   /  \
// -2   -5
 
// Explanation: Since all rooms contain negative treasure values, no beneficial 
// organized section exists, so the maximum total treasure is 0.

// Constraints:

// - The number of rooms in the castle ranges from 1 to 40,000.
// - Each room’s treasure value is an integer between -40,000 and 40,000.


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
    
    private static int findMax(TreeNode root,int[] res){
        if(root==null) return 0;
        
        int l=findMax(root.left,res);
        int r=findMax(root.right,res);
        
        int maxi=0;
        // maxi=Math.max(maxi,root.data);
        if(l==-1 || r==-1) return -1;
        
        // if(l<0) l=0;
        // if(r<0) r=0;
        
        if(l!=0 && root.left.data>=root.data) return -1;
        if(r!=0 && root.right.data<=root.data) return -1;
        
        res[0]=Math.max(res[0],root.data+l+r);
        
        // if(root.data<low || root.data>high) return -1;
        return root.data+l+r;
        
        
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

  public static void SumOfTreasure(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] s = sc.nextLine().split(" ");
    int n = s.length;
    int[] nums = new int[n];
    for (int i = 0; i < n; i++)
      nums[i] = Integer.parseInt(s[i]);

    TreeNode root = buildTree(nums);
    // System.out.println(root.data);
    int[] res=new int[]{0};
    findMax(root,res);
    System.out.print(res[0]);
    sc.close();
  }
}   