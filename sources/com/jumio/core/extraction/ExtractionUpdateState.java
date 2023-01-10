package com.jumio.core.extraction;

import java.util.concurrent.atomic.AtomicInteger;

public class ExtractionUpdateState {

    /* renamed from: id */
    public static AtomicInteger f57570id;
    public static final int notifyFocus;
    public static final int receiveClickListener = f57570id.getAndIncrement();
    public static final int resetOverlay = f57570id.getAndIncrement();
    public static final int saveImage = f57570id.getAndIncrement();
    public static final int shotTaken = f57570id.getAndIncrement();

    static {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        f57570id = atomicInteger;
        notifyFocus = atomicInteger.getAndIncrement();
    }
}
