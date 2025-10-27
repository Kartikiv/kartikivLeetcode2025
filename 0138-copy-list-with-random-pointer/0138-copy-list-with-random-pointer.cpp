/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        map<Node*, Node*> map;
        Node *ans = new Node(0);
        ans->next = head;
        Node* dummy = ans;
        while (head){
            if (map.find(head) == map.end()){
                map[head] = new Node(head->val);
                }
            if (head-> random != nullptr && map.find(head->random) == map.end()){
                map[head->random] = new Node(head->random->val);
            }
            dummy->next = map[head];
            map[head]->random = map[head->random];
            head = head->next;
            dummy = dummy->next;

        }
    return ans->next;
    }
};