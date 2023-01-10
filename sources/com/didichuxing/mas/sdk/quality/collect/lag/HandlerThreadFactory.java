package com.didichuxing.mas.sdk.quality.collect.lag;

import android.os.Handler;
import android.os.HandlerThread;

public final class HandlerThreadFactory {

    /* renamed from: a */
    private static HandlerThreadWrapper f50675a = new HandlerThreadWrapper("loop");

    /* renamed from: b */
    private static HandlerThreadWrapper f50676b = new HandlerThreadWrapper("writer");

    private HandlerThreadFactory() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static Handler getTimerThreadHandler() {
        return f50675a.getHandler();
    }

    public static Handler getWriteLogThreadHandler() {
        return f50676b.getHandler();
    }

    private static class HandlerThreadWrapper {
        private Handler handler = null;

        public HandlerThreadWrapper(String str) {
            HandlerThread handlerThread = new HandlerThread("BlockCanary-" + str);
            handlerThread.start();
            this.handler = new Handler(handlerThread.getLooper());
        }

        public Handler getHandler() {
            return this.handler;
        }
    }
}
