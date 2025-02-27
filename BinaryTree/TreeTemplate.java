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

class TreeTemplate {

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
  }
}