package com.amazon;

public interface Interval<T extends Comparable<T>> extends Comparable<Interval<T>> {

    T getStart();
    T getEnd();
    boolean overlaps(Interval<T> interval);


}
