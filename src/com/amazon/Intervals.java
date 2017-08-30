package com.amazon;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Intervals<T extends Comparable<T>> implements IntervalStream<T> {

    private List<Interval<T>> intervals;

    public Intervals(List<Interval<T>> intervals) {
        this.intervals = intervals;
    }

    public <K extends Interval<T>> void addInterval(K interval) {
        this.intervals.add(interval);
    }

    @Override
    public <R> Stream<R> map(Function<? super Interval<T>, ? extends R> mapper) {
        return intervals.stream().map(mapper);
    }

    @Override
    public <R extends Comparable<R>>IntervalStream<R> mapInterval(Function<? super Interval<T>, ? extends Interval<R>> mapper) {
        return new Intervals<R>(this.intervals.stream().map(mapper).collect(Collectors.toList()));
    }

    @Override
    public IntervalStream<T> collectOverlapping() {
        //TODO do something
        return this;
    }

    @Override
    public Iterator<Interval<T>> iterator() {
        return intervals.iterator();
    }

    @Override
    public Spliterator<Interval<T>> spliterator() {
        return intervals.spliterator();
    }

    @Override
    public boolean isParallel() {
        return false;
    }

    @Override
    public IntervalStream<T> sequential() {
        return this;
    }

    @Override
    public IntervalStream<T> parallel() {
        return null;
    }

    @Override
    public IntervalStream<T> unordered() {
        return null;
    }

    @Override
    public IntervalStream<T> onClose(Runnable closeHandler) {
        return null;
    }

    @Override
    public void close() {

    }
}
