package com.amazon;

import com.sun.tools.javac.util.List;

import java.time.Instant;
import java.util.ArrayList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Interval<Integer> t1 = new IntegerInterval(0, 5);
        Interval<Integer> t2 = new IntegerInterval(2, 7);
        ArrayList<Interval<Integer>> intervalList = new ArrayList<Interval<Integer>>();
        intervalList.add(t1);
        intervalList.add(t2);
        Intervals<Integer> intervals = new Intervals<Integer>(intervalList);
        intervals.collectOverlapping()
                .mapInterval(i->new IntegerInterval(i.getStart()+1, i.getEnd()+1))
                .map(i -> i.getStart())
                .filter(s -> s != 0)
                .forEach(t -> System.out.println(t.toString()));

        Interval<Instant> t3 = new TimeInterval(Instant.now(), Instant.EPOCH);
        Interval<Instant> t4 = new TimeInterval(Instant.now(), Instant.EPOCH);
        Intervals<Instant> intervals1 = new Intervals<Instant>(List.of(t3, t4));
        intervals1.collectOverlapping()
                .mapInterval(i->new IntegerInterval(i.getStart().getNano(), i.getEnd().getNano()))
                .map(i->i.getStart())
                .forEach(System.out::println);

	// write your code here
    }
}
