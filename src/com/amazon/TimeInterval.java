package com.amazon;

import java.time.Instant;

public class TimeInterval extends AbstractInterval<Instant>{

    public TimeInterval(Instant start, Instant end) {
        super(start, end);
    }
}
