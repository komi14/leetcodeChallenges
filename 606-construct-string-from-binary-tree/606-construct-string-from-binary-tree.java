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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        util(root, sb, false);

        return sb.length() == 0 ? "" : sb.toString().substring(1, sb.length() - 1);
    }

    private void util(TreeNode node, StringBuilder sb, boolean add) {
        if(add || node != null) {
            sb.append("(");
        }

        if(node != null) {
            sb.append(node.val);
            util(node.left, sb, node.right != null);
            util(node.right, sb, false);
        }

        if(add || node != null) {
            sb.append(")");
        }
    }
}