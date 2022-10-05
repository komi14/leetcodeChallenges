/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int d;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        d=depth;
        
        if(d==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        
        solve(root,val,1); 
        return root;
    }
    
    public void solve(TreeNode root, int val,int cur){
        if(cur>d)
            return;
			
        if(cur==d-1){
            TreeNode temp=root.left;
            TreeNode newLeft=new TreeNode(val);
            root.left=newLeft;
            newLeft.left=temp;
                 
            TreeNode temp1=root.right;
            TreeNode newRight=new TreeNode(val);
            root.right=newRight;
            newRight.right=temp1;
       
   
        }
        if(root.left!=null)
            solve(root.left,val,cur+1);
        if(root.right!=null)
            solve(root.right,val,cur+1);

    }
}