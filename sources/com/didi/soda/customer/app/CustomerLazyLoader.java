package com.didi.soda.customer.app;

import android.os.Looper;
import android.os.MessageQueue;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;

public final class CustomerLazyLoader {

    /* renamed from: a */
    private static final String f42889a = "CustomerLazyLoader";

    /* renamed from: b */
    private static CustomerLazyLoader f42890b = new CustomerLazyLoader();

    private CustomerLazyLoader() {
    }

    public static CustomerLazyLoader getLoader() {
        return f42890b;
    }

    public void loadDelayed(Runnable runnable, int i) {
        if (runnable != null) {
            UiHandlerUtil.postDelayed(runnable, (long) i);
        }
    }

    public void loadOnIdle(final Runnable runnable) {
        if (runnable != null) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                public boolean queueIdle() {
                    runnable.run();
                    return false;
                }
            });
        }
    }
}
