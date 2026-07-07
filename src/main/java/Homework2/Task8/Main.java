package Homework2.Task8;

import java.util.Arrays;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

        // ==================== NUMBERS ====================

        Collection<Integer> numbers =
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, -8, 9);

        FilterCollection<Integer> numberFilter =
                new FilterCollection<>(numbers);

        System.out.println("Коллекция:");
        printCollection(numbers);

        numberFilter.setFilter(new ObjectFilters.EvenFilter<>());
        System.out.println("\nПравило: Только на четных позициях");
        printCollection(numberFilter.applyFilter());

        numberFilter.setFilter(new NumberFilters.GreaterThanFilter<>(4));
        System.out.println("\nПравило: Только числа больше 4");
        printCollection(numberFilter.applyFilter());

        numberFilter.setFilter(new NumberFilters.PositiveFilter<>());
        System.out.println("\nПравило: Только положительные");
        printCollection(numberFilter.applyFilter());

        numberFilter.setFilter(new NumberFilters.PowerOfTwoFilter<>());
        System.out.println("\nПравило: Только степени двойки");
        printCollection(numberFilter.applyFilter());



        // ==================== STRINGS ====================

        Collection<String> strings =
                Arrays.asList(
                        "Строка1",
                        "СТРОКА2",
                        "СТР",
                        "Java",
                        "JAVA",
                        "HELLO"
                );

        FilterCollection<String> stringFilter =
                new FilterCollection<>(strings);

        System.out.println("\n==============================");
        System.out.println("Коллекция:");
        printCollection(strings);

        stringFilter.setFilter(new StringFilters.UppercaseFilter());
        System.out.println("\nПравило: Только верхний регистр");
        printCollection(stringFilter.applyFilter());

        stringFilter.setFilter(new StringFilters.LengthFilter<>(4, 6));
        System.out.println("\nПравило: Длина от 4 до 6");
        printCollection(stringFilter.applyFilter());



        // ==================== OBJECT ====================

        Collection<String> objects =
                Arrays.asList("A", "B", "A", "C", "A");

        FilterCollection<String> objectFilter =
                new FilterCollection<>(objects);

        System.out.println("\n==============================");
        System.out.println("Коллекция:");
        printCollection(objects);

        objectFilter.setFilter(new ObjectFilters.AllObjectsFilter<>());
        System.out.println("\nПравило: Все объекты");
        printCollection(objectFilter.applyFilter());

        objectFilter.setFilter(new ObjectFilters.NoObjectsFilter<>());
        System.out.println("\nПравило: Ни одного объекта");
        printCollection(objectFilter.applyFilter());

        objectFilter.setFilter(new ObjectFilters.EqualFilter<>("A"));
        System.out.println("\nПравило: Только равные \"A\"");
        printCollection(objectFilter.applyFilter());



        // ==================== FRACTIONS ====================

        Collection<Fraction> fractions =
                Arrays.asList(
                        new Fraction(1, 2),
                        new Fraction(-3, 4),
                        new Fraction(2, 8),
                        new Fraction(5, 6),
                        new Fraction(7, 9)
                );

        FilterCollection<Fraction> fractionFilter =
                new FilterCollection<>(fractions);

        System.out.println("\n==============================");
        System.out.println("Коллекция:");
        printCollection(fractions);

        fractionFilter.setFilter(
                new FractionFilters.DoubleFilter<>(0.2, 0.8));

        System.out.println("\nПравило: Значение между 0.2 и 0.8");
        printCollection(fractionFilter.applyFilter());

        fractionFilter.setFilter(
                new FractionFilters.NegativeFilter<>());

        System.out.println("\nПравило: Только отрицательные");
        printCollection(fractionFilter.applyFilter());

        fractionFilter.setFilter(
                new FractionFilters.DenominatorFilter<>(2));

        System.out.println("\nПравило: Знаменатель кратен 2");
        printCollection(fractionFilter.applyFilter());

        fractionFilter.setFilter(
                new FractionFilters.SubstractionFilter<>(
                        new Fraction(1, 1)));

        System.out.println("\nПравило: X - дробь < 1/3");
        printCollection(fractionFilter.applyFilter());

    }

    private static void printCollection(Collection<?> collection) {

        for (Object obj : collection) {
            System.out.print(obj + " ");
        }

        System.out.println();
    }

}