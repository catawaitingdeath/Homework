package Homework2.Task14;

import java.util.ArrayList;
import java.util.Iterator;

public class OneDirectionalLinkedList<T> implements Iterable<T>, Cloneable  {
    protected ListNode<T> head;
    protected Integer size;

    public OneDirectionalLinkedList(){
        head = null;
        size = 0;
    };
    public OneDirectionalLinkedList(Iterable<T> iterable) {
        this();
        for (T element : iterable) {
            add(element);
        }
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode<T> current = head;
        while(current != null){
            sb.append(current.getValue());
            if(current.getNext() != null){
                sb.append(" ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }

    public void add(T value){
        if(head == null){
            head = new ListNode<>(value);
        }
        else{
            ListNode<T> node = head;
            while(node.getNext() != null){
                node = node.getNext();
            }
            node.setNext(new ListNode<>(value));
        }
        size++;
    }

    public void add(int index, T value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            var prevHead = head;
            head = new ListNode<>(value);
            head.setNext(prevHead);
        }
        else{
            int counter = 0;
            ListNode<T> node = head;
            while(counter < index - 1){
                node = node.getNext();
                counter++;
            }
            var nextNode = node.getNext();
            node.setNext(new ListNode<>(value));
            node.getNext().setNext(nextNode);
        }
        size++;
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        ListNode<T> node = head;
        while(counter < index){
            node = node.getNext();
            counter++;
        }
        return node.getValue();
    }

    public boolean contains(T value){
        ListNode<T> node = head;
        while(node != null){
            if(node.getValue().equals(value)){
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public int indexOf(T value){
        int counter = 0;
        ListNode<T> node = head;
        while(node != null){
            if(node.getValue().equals(value)){
                return counter;
            }
            node = node.getNext();
            counter++;
        }
        return -1;
    }

    public void remove(T value){
        if(head == null) return;

        if(head.getValue().equals(value)){
            head = head.getNext();
            size--;
            return;
        }

        ListNode<T> current = head;

        while(current.getNext() != null){
            if(current.getNext().getValue().equals(value)){
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }

    public void removeAll(T value){
        if(head == null) return;
        while(head != null && head.getValue().equals(value)){
            head = head.getNext();
            size--;
        }
        if(head == null) return;
        ListNode<T> current = head;
        while(current.getNext() != null){
            if(current.getNext().getValue().equals(value)){
                current.setNext(current.getNext().getNext());
                size--;
            } else {
                current = current.getNext();
            }
        }
    }

    public void remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        ListNode<T> node = head;
        if(index == 0){
            head = head.getNext();
        }
        else{
            while(counter < index - 1){
                node = node.getNext();
                counter++;
            }
            node.setNext(node.getNext().getNext());
        }
        size--;
    }

    public void replace(int index, T newValue){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        ListNode<T> node = head;
        while(counter < index){
            node = node.getNext();
            counter++;
        }
        node.setValue(newValue);
    }
    public Iterator<T> iterator(){
        ArrayList<T> list = new ArrayList<>();
        ListNode<T> current = head;
        while(current != null){
            list.add(current.getValue());
            current = current.getNext();
        }
        return list.iterator();
    }
    public OneDirectionalLinkedList<T> clone(){
        OneDirectionalLinkedList<T> cloned = new OneDirectionalLinkedList<>();
        for(T value: this){
            cloned.add(value);
        }
        return cloned;
    }
}
