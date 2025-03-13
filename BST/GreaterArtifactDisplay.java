// Imagine you're the chief curator at a renowned museum that houses a rare
// collection of ancient artifacts. These artifacts are arranged in a special
// display that follows a strict rule: any artifact positioned to the left of
// another has a lower value, and any artifact on the right has a higher value.

// Your task is to transform this display into what is known as a "Greater
// Artifact Display." In this new arrangement, each artifact’s new value will be
// its original value plus the sum of the values of all artifacts that are more
// valuable than it.

// Example 1:
// ----------
// input=
// 4 2 6 1 3 5 7
// output=
// 22 27 13 28 25 18 7

// Explanation:
// Input structure
//        4
//       / \
//      2   6
//     / \ / \
//    1  3 5  7

// Output structure:
//         22
//       /   \
//      27   13
//     / \   / \
//    28 25 18  7

// Reverse updates:
// - Artifact 7: 7
// - Artifact 6: 6 + 7 = 13
// - Artifact 5: 5 + 13 = 18
// - Artifact 4: 4 + 18 = 22
// - Artifact 3: 3 + 22 = 25
// - Artifact 2: 2 + 25 = 27
// - Artifact 1: 1 + 27 = 28

// change the code by to use a variable and send it to all the nodes which will
// be added to node and then its value will be incremented by the value of the
// node

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

  private static void printTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode temp = q.poll();
        if (temp.left != null)
          q.offer(temp.left);
        if (temp.right != null)
          q.offer(temp.right);
        System.out.print(temp.data + " ");
      }
    }
  }
  private static int changeTree(TreeNode root, int sum, int flag) {
    if (root == null)
      return 0;

    int r = changeTree(root.right, sum, Math.max(flag, 0));

    if (flag == 1)
      root.data += Math.max(sum, r);
    else
      root.data = root.data + r;

    int l = changeTree(root.left, root.data, 1);
    return Math.max(l, root.data);
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

    changeTree(root, 0, 0);

    printTree(root);
  }
}