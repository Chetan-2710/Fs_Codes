// Imagine you’re decoding a secret message that outlines the hierarchical
// structure of a covert spy network. The message is a string composed of
// numbers and parentheses. Here’s how the code works:

// - The string always starts with an agent’s identification number, this is the
//   leader of the network.
// - After the leader’s ID, there can be zero, one, or two segments enclosed in
//   parentheses. Each segment represents the complete structure of one
//   subordinate network.
// - If two subordinate networks are present, the one enclosed in the first
// (leftmost)
//   pair of parentheses represents the left branch, and the second (rightmost)
//   represents the right branch.

// Your mission is to reconstruct the entire spy network hierarchy based on this
// coded message.

// Example 1:
// Input: 4(2(3)(1))(6(5))
// Output: [4, 2, 6, 3, 1, 5]

// Spy network:
//         4
//        / \
//       2   6
//      / \  /
//     3   1 5

// Explanation:
// Agent 4 is the leader.
// Agent 2 (with its own subordinates 3 and 1) is the left branch.
// Agent 6 (with subordinate 5) is the right branch.

// Example 2:
// Input: 4(2(3)(1))(6(5)(7))
// Output: [4, 2, 6, 3, 1, 5, 7]

// Spy network:
//          4
//        /   \
//       2     6
//      / \   / \
//     3   1 5   7

// Explanation:
// Agent 4 leads the network.
// Agent 2 with subordinates 3 and 1 forms the left branch.
// Agent 6 with subordinates 5 and 7 forms the right branch.

// Improvement :- Do an Iterative approach with Stack...

import java.util.*;

class TreeNode {
  int data;
  TreeNode left, right;
  TreeNode(int data) {
    this.data = data;
    left = null;
    right = null;
  }
}
class SpyNetwork{

  private static void printTree(TreeNode root, List<Integer> res) {
    if (root == null)
      return;

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode temp = q.poll();
        // System.out.println(temp.data);
        res.add(temp.data);
        if (temp.left != null)
          q.offer(temp.left);
        if (temp.right != null)
          q.offer(temp.right);
      }
    }
  }

  private static TreeNode buildTree(String s, int[] index) {
    if (index[0] >= s.length())
      return null;

    if (s.charAt(index[0]) == ')') {
      index[0]++;
      return null;
    }

    int endi;
    for (endi = index[0]; endi < s.length(); endi++) {
      if (s.charAt(endi) == '(' || s.charAt(endi) == ')') {
        break;
      }
    }

    TreeNode root = new TreeNode(Integer.parseInt(s.substring(index[0], endi)));

    index[0] = endi;

    if (index[0] < s.length() && s.charAt(index[0]) == '(') {
      index[0]++;
      root.left = buildTree(s, index);
    }

    if (index[0] < s.length() && s.charAt(index[0]) == '(') {
      index[0]++;
      root.right = buildTree(s, index);
    }

    if (index[0] < s.length() && s.charAt(index[0]) == ')') {
      index[0]++;
    }

    return root;
  }

  public static void main(String[] args) {
    String s = new Scanner(System.in).nextLine();

    TreeNode root = buildTree(s, new int[] {0});

    List<Integer> res = new ArrayList<>();
    printTree(root, res);
    System.out.print(res);
  }
}