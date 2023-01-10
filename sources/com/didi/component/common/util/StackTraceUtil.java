package com.didi.component.common.util;

public class StackTraceUtil {
    public static void stackTrace(String str) {
        TracerException tracerException = new TracerException();
        tracerException.fillInStackTrace();
        GLog.m11355d(str, "stackTrace", tracerException);
    }

    private static class TracerException extends Exception {
        private TracerException() {
        }
    }
}
