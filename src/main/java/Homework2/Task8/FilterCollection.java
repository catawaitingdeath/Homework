package Homework2.Task8;

import java.util.Collection;

public class FilterCollection<T> {

    private final Collection<T> collection;

    private Filter<T> filter;

    public FilterCollection(Collection<T> collection) {
        this.collection = collection;
    }

    public void setFilter(Filter<T> filter) {
        this.filter = filter;
    }

    public Collection<T> applyFilter() {
        return filter.filter(collection);
    }

}
