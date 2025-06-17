// Time Complexity : O(n)
// Space Complexity : O(n)
/* Approach : we add the root to queue and iterate over it. 
Keep comparing the current root to its next root at every level and add the max
of both into list, follow this approach until the last node.
 */

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();           // initialize list to store the largest value of roots at given level
        if(root == null) return result;                     // validate if root is empty or not

        Queue<TreeNode> q = new LinkedList<>();             // initialize queue
        q.add(root);                                        // add root to queue
      
        while(!q.isEmpty()){                                // validate if queue is empty
            int qSize = q.size();                           // get queue size
            int temp = Integer.MIN_VALUE;                   // this value will store the max value at every level
            for(int i=0; i<qSize; i++){                     // traverse through current roots of queue
                TreeNode currVal = q.poll();                // get current root out of queue
                temp = Math.max(temp,currVal.val);          // compare max value for currRoot and previous root of same level
                if(currVal.left != null){                   // validate if left node is empty
                    q.add(currVal.left);                    // add left node to queue
                }
                if(currVal.right != null){                  // validate if right node is empty
                    q.add(currVal.right);                   // add right node into queue
                }
            }
            result.add(temp);                               // after every level simply add the largest value into list
        }

       return result; 
    }
}