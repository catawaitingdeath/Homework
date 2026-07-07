package Homework2.Task13;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(new AscendingComparator());
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        System.out.println("Итерация в глубину (DFS):");
        Iterator<Integer> dfsIterator = bst.dfsIterator();
        while (dfsIterator.hasNext()) {
            System.out.print(dfsIterator.next() + " ");
        }
    }
}
