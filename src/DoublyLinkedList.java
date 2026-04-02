public class DoublyLinkedList {
    int key, value;
    DoublyLinkedList prev, next;

    DoublyLinkedList(int k, int v) {
        this.key = k;
        this.value = v;
        this.prev = this.next = null;
    }
}
