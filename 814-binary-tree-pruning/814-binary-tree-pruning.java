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
    public TreeNode pruneTree(TreeNode root) {
        if(go(root)) return root;
        return null;
    }
    boolean go(TreeNode node){
        if(node==null)return false;
        boolean left=go(node.left),right=go(node.right);
        if(!left)node.left=null;
        if(!right)node.right=null;
        return node.val==1 || left || right;
    }
}