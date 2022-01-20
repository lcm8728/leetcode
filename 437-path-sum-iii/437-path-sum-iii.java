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
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return find(root, 0, targetSum, preSum);
    }
    
    private int find(TreeNode node, int curSum, int target, HashMap<Integer, Integer> preSum) {
        if(node == null) {
            return 0;
        }
        
        curSum += node.val;
        int ret = preSum.getOrDefault(curSum - target, 0);
        preSum.put(curSum, preSum.getOrDefault(curSum, 0) + 1);
        ret += find(node.left, curSum, target, preSum) + find(node.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return ret;
    }
}