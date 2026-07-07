package Homework2.Task13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T> {
    private TreeNode<T> root;
    private Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> comparator){
        this.comparator = comparator;
        this.root = null;
    }

    public void insert(T value) {
        if(root == null){
            root = new TreeNode<>(value);
        }
        else{
            TreeNode<T> current = root;
            TreeNode<T> parent = null;
            while(current != null){
                parent = current;
                if(comparator.compare(value, current.getValue()) < 0){
                    current = current.getLeft();
                }
                else if(comparator.compare(value, current.getValue()) > 0){
                    current = current.getRight();
                }
                else{
                    return;
                }
            }
            if(comparator.compare(value, parent.getValue()) < 0){
                parent.setLeft(new TreeNode<>(value));
            }
            else{
                parent.setRight(new TreeNode<>(value));
            }
        }
    }

    public Iterator<T> dfsIterator() {
        ArrayList<T> list = new ArrayList<>();
        iterate(root, list);
        return list.iterator();
    }

    private void iterate(TreeNode<T> root, ArrayList<T> list){
        if(root != null){
            iterate(root.getLeft(), list);
            list.add(root.getValue());
            iterate(root.getRight(), list);
        }
    }
}
