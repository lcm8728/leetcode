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
    public int pathSum(TreeNode root, int targetSum) {
        return recurse(root, targetSum);
    }
    
    private int recurse(TreeNode node, int target) {
        if(node == null) return 0;
        int sum = 0;
        sum += find(node, target);
        if(node.left != null) sum += recurse(node.left, target);
        if(node.right != null) sum += recurse(node.right, target);
        return sum;
    }
    
    private int find(TreeNode node, int target) {
        int sum = 0;
        if(node.val == target) sum += 1;
        if(node.left != null) sum += find(node.left, target - node.val);
        if(node.right != null) sum += find(node.right, target - node.val);
        return sum;
    }
}