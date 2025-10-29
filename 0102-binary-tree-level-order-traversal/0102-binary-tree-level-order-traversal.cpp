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
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        if (root == nullptr) return vector<vector<int>> ();
        vector<vector<int>> ans;
        queue<TreeNode*> queue;
        queue.push(root);
        while(!queue.empty()){
            vector<int> temp;
            int n = queue.size();
            for (int i =0 ; i < n; i++){
                TreeNode* node = queue.front();
                queue.pop();
                temp.push_back(node->val);
                if (node->left != nullptr)  queue.push(node->left);
                if (node->right != nullptr)  queue.push(node->right);

            }
            ans.push_back(temp);
        }

    return ans;}
};