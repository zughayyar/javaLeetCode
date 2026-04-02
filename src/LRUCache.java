import java.util.HashMap;

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer, DoublyLinkedList> map;
    private final DoublyLinkedList head;
    private final DoublyLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = this.tail = new DoublyLinkedList(0, 0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        DoublyLinkedList node = map.get(key);
        remove(node);
        insertToFront(node);
        return node.value;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyLinkedList node = map.get(key);
            node.value = value;
            remove(node);
            insertToFront(node);
        } else {
            if (map.size() == capacity) {
                DoublyLinkedList lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            DoublyLinkedList newNode = new DoublyLinkedList(key, value);
            insertToFront(newNode);
            map.put(key, newNode);
        }
    }

    private void remove(DoublyLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToFront(DoublyLinkedList node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

/*
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
