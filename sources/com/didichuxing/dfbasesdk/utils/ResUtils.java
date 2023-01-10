package com.didichuxing.dfbasesdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Window;
import com.didichuxing.dfbasesdk.AppContextHolder;
import java.io.InputStream;
import java.nio.charset.Charset;

public class ResUtils {

    /* renamed from: a */
    private static DisplayMetrics f49407a = Resources.getSystem().getDisplayMetrics();

    public static Resources getResources() {
        return m37065a().getResources();
    }

    public static int getColor(int i) {
        return m37065a().getResources().getColor(i);
    }

    /* renamed from: a */
    private static Context m37065a() {
        return AppContextHolder.getAppContext();
    }

    public static String readRawFile(int i) {
        InputStream inputStream;
        String str = null;
        try {
            inputStream = getResources().openRawResource(i);
            try {
                str = IOUtils.toString(inputStream, Charset.forName("UTF-8"));
            } catch (Exception e) {
                e = e;
                try {
                    LogUtils.logStackTrace(e);
                    IOUtils.closeQuietly(inputStream);
                    return str;
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            inputStream = null;
            LogUtils.logStackTrace(e);
            IOUtils.closeQuietly(inputStream);
            return str;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            IOUtils.closeQuietly(inputStream);
            throw th;
        }
        IOUtils.closeQuietly(inputStream);
        return str;
    }

    public static int getDimen(int i) {
        return getResources().getDimensionPixelOffset(i);
    }

    public static String getString(int i) {
        return m37065a().getString(i);
    }

    public static String getString(int i, Object... objArr) {
        return m37065a().getString(i, objArr);
    }

    public static int getScreenWidth() {
        return f49407a.widthPixels;
    }

    public static int getScreenHeight() {
        return f49407a.heightPixels;
    }

    public static int getScreenOrientation(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static boolean isScreenPortrait(Context context) {
        return getScreenOrientation(context) == 1;
    }

    public static int getWindowRotation(Window window) {
        return window.getWindowManager().getDefaultDisplay().getRotation();
    }

    public static float getDensity() {
        return f49407a.density;
    }

    public static int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, f49407a);
    }

    public static int sp2Px(float f) {
        return (int) TypedValue.applyDimension(2, f, f49407a);
    }

    public static int px2Dp(int i) {
        return Math.round(((float) i) / getDensity());
    }
}
