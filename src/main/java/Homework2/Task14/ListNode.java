package Homework2.Task14;

public class ListNode<T> {
    private ListNode<T> next;
    private T value;
    public ListNode(T value) {
        this.value = value;
        this.next = null;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public ListNode<T> getNext() {
        return next;
    }
    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
