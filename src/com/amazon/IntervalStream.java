package com.amazon;

import java.util.function.Function;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

public interface IntervalStream<T extends Comparable<T>> extends BaseStream<Interval<T>, IntervalStream<T>> {

    public IntervalStream<T> collectOverlapping();
    public <R> Stream<R> map(Function<? super Interval<T>, ? extends R> mapper);
    public <R extends Comparable<R>>IntervalStream<R> mapInterval(Function<? super Interval<T>, ? extends Interval<R>> mapper);
}
