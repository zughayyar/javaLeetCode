public class SinglyLinkedList {
    int value;
    SinglyLinkedList next;

    SinglyLinkedList() {
        this.value = 0;
        this.next = null;
    }

    public SinglyLinkedList(int value) {
        this.value = value;
        this.next = null;
    }

    public SinglyLinkedList(int value, SinglyLinkedList next) {
        this.value = value;
        this.next = next;
    }
}
