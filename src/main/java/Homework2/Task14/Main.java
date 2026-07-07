package Homework2.Task14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        var list = new OneDirectionalLinkedList<String>();
        list.add("banana");
        list.add("apple");
        list.add("banana");
        list.add("pineapple");
        list.add("banana");
        System.out.println("Исходный список:");
        System.out.println(list);
        list.add(1, "watermelon");
        System.out.println("После добавления watermelon:");
        System.out.println(list);
        list.replace(2, "blueberry");
        System.out.println("После замены 2 элемента на blueberry:");
        System.out.println(list);
        var sortedList = sorted(list, Comparator.comparingInt(String::length));
        System.out.println("Отсортированный вариант списка:");
        System.out.println(sortedList);
        list.remove("watermelon");
        System.out.println("После удаления 'watermelon':");
        System.out.println(list);
        list.removeAll("banana");
        System.out.println("После удаления всех 'banana':");
        System.out.println(list);
    }

    public static <T> OneDirectionalLinkedList<T>
    sorted(OneDirectionalLinkedList<T> list, Comparator<T> comparator) {
        ArrayList<T> newList = new ArrayList<>();
        for(T value: list){
            newList.add(value);
        }
        Collections.sort(newList, comparator);
        return new OneDirectionalLinkedList<>(newList);
    }

}
