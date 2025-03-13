
class TreeNode {
    Integer val;
    TreeNode left, right;
    
    TreeNode(Integer val) {
        this.val = val;
        this.left = this.right = null;
    }
}



class Solution
{
    private static int postOrder(TreeNode root,int[] res){
        if(root==null || root.val==-1) return Integer.MIN_VALUE;
        
        int l=postOrder(root.left,res);
        int r=postOrder(root.right,res);
        int maxi=Math.max(l,r);
        int mini=Math.min(l,r);
        
        if(maxi!=Integer.MIN_VALUE) root.val=maxi;
        else maxi=root.val;
        
        if(res[0]<maxi) res[0]=maxi;
        if(maxi<res[0] && maxi>res[1]) res[1]=maxi;
        if(mini<res[0] && mini>res[1]) res[1]=mini;
        
        return root.val;
    }
    
    public int secondHighest(TreeNode root) 
    {
        // Write your code and return the second top value. 
        // (return -2 if no second highest.)

        //1st way
        int[] res=new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
        postOrder(root,res);
        return (res[1]==Integer.MIN_VALUE)?-2:res[1];

        //2nd way
        if(root==null) return -2;
        
        int l=-2,r=-2;
        
        if(root.left!=null){
            l=root.left.val;
            if(root.val==l){
                l=secondHighest(root.left);
            }
        }
        
        
        if(root.right!=null){
            r=root.right.val;
            if(root.val==r){
                r=secondHighest(root.right);
            }
        }
        
        return Math.max(l,r);

    }
}