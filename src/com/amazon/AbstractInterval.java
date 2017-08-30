package com.amazon;

import java.util.*;

public class AbstractInterval<T extends Comparable<T>> implements Interval<T>{

    private T start;
    private T end;

    protected List<Interval<T>> subIntervals;

    public AbstractInterval(T start, T end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public T getStart() {
        return start;
    }

    @Override
    public T getEnd() {
        return end;
    }

    @Override
    public boolean overlaps(Interval<T> interval) {
        if (start.compareTo(interval.getStart())>=0 && start.compareTo(interval.getEnd()) <= 0 ||
                end.compareTo(interval.getStart()) >= 0 && end.compareTo(interval.getEnd()) <= 0)
            return true;
        return false;
    }

    @Override
    public int compareTo(Interval<T> o) {
        return this.start.compareTo(o.getStart());
    }
}
