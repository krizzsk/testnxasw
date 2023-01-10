package com.didi.rfusion.widget.toast.helper;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import java.lang.reflect.Field;

public class RFToastSafeHook {

    /* renamed from: a */
    private static Field f36773a;

    /* renamed from: b */
    private static Field f36774b;

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f36773a = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f36773a.getType().getDeclaredField("mHandler");
            f36774b = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    public static void makeSafe(Toast toast) {
        try {
            Object obj = f36773a.get(toast);
            f36774b.set(obj, new SafeHandler((Handler) f36774b.get(obj)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static class SafeHandler extends Handler {
        private Handler impl;

        SafeHandler(Handler handler) {
            this.impl = handler;
        }

        public void handleMessage(Message message) {
            this.impl.handleMessage(message);
        }

        public void dispatchMessage(Message message) {
            try {
                this.impl.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
