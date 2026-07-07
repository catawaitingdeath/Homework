package Homework2.Task8;

import java.util.ArrayList;
import java.util.Collection;

public class FractionFilters {
    public static class DoubleFilter<T extends Fraction> implements Filter<T> {

        private final double x;
        private final double y;

        public DoubleFilter(double x, double y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for(T t : collection){
                if(t.getValue() > x && t.getValue() < y){
                    result.add(t);
                }
            }
            return result;
        }
    }

    public static class NegativeFilter<T extends Fraction> implements Filter<T> {
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for(T t : collection){
                if(t.getNumerator() < 0 || t.getDenominator() < 0){
                    result.add(t);
                }
            }
            return result;
        }
    }

    public static class DenominatorFilter<T extends Fraction> implements Filter<T> {

        private final int x;

        public DenominatorFilter(int x) {
            this.x = x;
        }

        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for (T t : collection){
                if (t.getDenominator() % x == 0){
                    result.add(t);
                }
            }
            return result;
        }

    }

    public static class SubstractionFilter<T extends Fraction> implements Filter<T> {

        private final Fraction x;

        public SubstractionFilter(Fraction x) {
            this.x = x;
        }

        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for (T t : collection){
                if (x.substract(t).getValue() < (1.0 / 3.0)){
                    result.add(t);
                }
            }
            return result;
        }
    }
}


