class Codec {
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        return encode(root);
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        int pos = 0;
        return decode(data, pos);
    }

private:
    string encode(TreeNode* root) {
        if (!root) return "#,";
        return to_string(root->val) + "," + encode(root->left) + encode(root->right);
    }

    TreeNode* decode(const string &data, int &pos) {
        if (pos >= data.size()) return nullptr;

        // read token
        int start = pos;
        while (pos < data.size() && data[pos] != ',') pos++;
        string token = data.substr(start, pos - start);
        pos++; // skip comma

        if (token == "#") return nullptr;

        TreeNode* node = new TreeNode(stoi(token));
        node->left = decode(data, pos);
        node->right = decode(data, pos);
        return node;
    }
};
