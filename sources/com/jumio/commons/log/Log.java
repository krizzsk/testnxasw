package com.jumio.commons.log;

import android.graphics.Bitmap;
import java.io.File;

public class Log {
    public static final String TAG = "JumioMobileSDK";

    public enum LogLevel {
        OFF,
        VERBOSE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public static void allowFileLogging(boolean z) {
    }

    /* renamed from: d */
    public static void m43643d(String str) {
    }

    /* renamed from: d */
    public static void m43644d(String str, File file, String str2) {
    }

    /* renamed from: d */
    public static void m43645d(String str, String str2) {
    }

    /* renamed from: d */
    public static void m43646d(String str, String str2, Throwable th) {
    }

    /* renamed from: d */
    public static void m43647d(String str, Throwable th) {
    }

    public static void data(byte[] bArr, File file, String str) {
    }

    /* renamed from: e */
    public static void m43648e(String str) {
    }

    /* renamed from: e */
    public static void m43649e(String str, File file, String str2) {
    }

    /* renamed from: e */
    public static void m43650e(String str, String str2) {
    }

    /* renamed from: e */
    public static void m43651e(String str, String str2, Throwable th) {
    }

    /* renamed from: e */
    public static void m43652e(String str, Throwable th) {
    }

    public static LogLevel getLogLevel() {
        return LogLevel.OFF;
    }

    /* renamed from: i */
    public static void m43653i(String str) {
    }

    /* renamed from: i */
    public static void m43654i(String str, File file, String str2) {
    }

    /* renamed from: i */
    public static void m43655i(String str, String str2) {
    }

    /* renamed from: i */
    public static void m43656i(String str, String str2, Throwable th) {
    }

    /* renamed from: i */
    public static void m43657i(String str, Throwable th) {
    }

    public static void image(Bitmap bitmap, File file, String str) {
    }

    public static void image(Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i) {
    }

    public static boolean isFileLoggingActivated() {
        return false;
    }

    public static boolean isLogEnabledForLevel(LogLevel logLevel) {
        return false;
    }

    public static void printStackTrace(Throwable th) {
    }

    public static void setLogLevel(LogLevel logLevel) {
    }

    /* renamed from: v */
    public static void m43658v(String str) {
    }

    /* renamed from: v */
    public static void m43659v(String str, File file, String str2) {
    }

    /* renamed from: v */
    public static void m43660v(String str, String str2) {
    }

    /* renamed from: v */
    public static void m43661v(String str, String str2, Throwable th) {
    }

    /* renamed from: v */
    public static void m43662v(String str, Throwable th) {
    }

    /* renamed from: w */
    public static void m43663w(String str) {
    }

    /* renamed from: w */
    public static void m43664w(String str, File file, String str2) {
    }

    /* renamed from: w */
    public static void m43665w(String str, String str2) {
    }

    /* renamed from: w */
    public static void m43666w(String str, String str2, Throwable th) {
    }

    /* renamed from: w */
    public static void m43667w(String str, Throwable th) {
    }
}
