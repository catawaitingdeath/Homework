package Homework2.Task8;

import java.util.ArrayList;
import java.util.Collection;

public class ObjectFilters {
    public static class AllObjectsFilter<T> implements Filter<T> {
        @Override
        public Collection<T> filter(Collection<T> collection){
            return new ArrayList<T>(collection);
        }
    }

    public static class NoObjectsFilter<T> implements Filter<T> {
        @Override
        public Collection<T> filter(Collection<T> collection){
            return new ArrayList<T>();
        }
    }

    public static class EvenFilter<T> implements Filter<T> {
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            int count = 1;
            for (T element : collection){
                if (count % 2 == 0){
                    result.add(element);
                }
                count++;
            }
            return result;
        }

    }

    public static class EqualFilter<T> implements Filter<T> {

        private final T x;
        public EqualFilter(T x) {
            this.x = x;
        }
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for (T element : collection){
                if (element.equals(x)){
                    result.add(element);
                }
            }
            return result;
        }
    }
}


