package Homework2.Task8;

import java.util.ArrayList;
import java.util.Collection;

public class NumberFilters {
    public static class PositiveFilter<T extends Number> implements Filter<T> {
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for(T t: collection){
                if(t.intValue() > 0){
                    result.add(t);
                }
            }
            return result;
        }
    }

    public static class GreaterThanFilter<T extends Number> implements Filter<T> {

        private final int x;

        public GreaterThanFilter(int x) {
            this.x = x;
        }

        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for(T t: collection){
                if(t.intValue() > x){
                    result.add(t);
                }
            }
            return result;
        }
    }

    public static class PowerOfTwoFilter<T extends Number> implements Filter<T> {
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for(T t: collection){
                int n = t.intValue();
                if((n > 0) && ((n & (n - 1)) == 0)){
                    result.add(t);
                }
            }
            return result;
        }
    }
}


