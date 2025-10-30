/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
/* 
 For every root they are three paths the maxStraight path  or the max of the all the node with the root 
 To reach the children first we need to use dfs in the left right root order such that we calculate all
 the children first then the root 
*/
class Solution {
    int ans = INT_MIN;
public:
    int maxPathSum(TreeNode* root) {
        helper(root);
        return ans;
        }
    int helper(TreeNode* root){
        if(root == nullptr) return 0;
      
        int x = max(0,helper(root->left));
        int y = max(0,helper(root->right));
        ans = max(ans, root->val + x + y);


    return max(x,y) + root->val;
    }    
};