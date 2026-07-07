package Homework2.Task8;

import java.util.ArrayList;
import java.util.Collection;

public class StringFilters {
    public static class LengthFilter<T extends String> implements Filter<T> {

        private final int x;
        private final int y;

        public LengthFilter(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for(T t : collection){
                if(t.length() >= x && t.length() <= y){
                    result.add(t);
                }
            }
            return result;
        }
    }

    public static class UppercaseFilter<T extends String> implements Filter<T> {
        @Override
        public Collection<T> filter(Collection<T> collection){
            ArrayList<T> result = new ArrayList<T>();
            for(T t : collection){
                if(t.toUpperCase() == t){
                    result.add(t);
                }
            }
            return result;
        }
    }
}


