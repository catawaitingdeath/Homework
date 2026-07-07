package Homework2.Task8;

import java.util.Collection;

public interface Filter<T> {
    public Collection<T> filter(Collection<T> collection);
}
