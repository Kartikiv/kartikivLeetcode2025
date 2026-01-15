
import java.util.*;

//Open Adderessing 

/* 
Open Adderessing
 */

 class Node {
    int key;
    int val;
    Node next;

    public Node(int key){
        this.key = key;
    }
 }
class MyHashSet {
    Node [] map ;
    public MyHashSet() {
        this.map = new Node[1000];
        Arrays.fill(map, new Node(-1));
    }

    public int getAddress(int key){
        return key % 1000;
    }
    
    public void add(int key) {
        int address = getAddress(key);
        Node insertPoint = map[address];

        while(insertPoint.next != null){
            if(insertPoint.next.key == key) return;
            insertPoint = insertPoint.next;
        }
        insertPoint.next = new Node(key);

    }
    
    public void remove(int key) {
        Node removeNode = map[getAddress(key)];
        while(removeNode.next != null){
            if(removeNode.next.key == key){
                removeNode.next = removeNode.next.next;
                return;
            }
            removeNode = removeNode.next;
        }
    }
    
    public boolean contains(int key) {
        Node checkNode = map[getAddress(key)];
        while(checkNode.next != null){
            if(checkNode.next.key == key){
                return true;
            }
            checkNode = checkNode.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */