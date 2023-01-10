package com.didi.globalsafetoolkit.imageloader;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.collection.SparseArrayCompat;
import java.lang.ref.WeakReference;

public class SfImageLoaderHolder {

    /* renamed from: a */
    private static SparseArrayCompat<WeakReference<ISfImageLoader>> f25173a = new SparseArrayCompat<>();

    /* renamed from: b */
    private static final ISfImageLoader f25174b = new SfImageLoaderStub();

    public static ISfImageLoader getInstance(Context context) {
        if (context == null || ((context instanceof Activity) && !m20121a((Activity) context))) {
            return f25174b;
        }
        int hashCode = context.hashCode();
        WeakReference weakReference = f25173a.get(hashCode);
        ISfImageLoader iSfImageLoader = weakReference != null ? (ISfImageLoader) weakReference.get() : null;
        if (iSfImageLoader != null) {
            return iSfImageLoader;
        }
        C9557a aVar = new C9557a(context);
        f25173a.put(hashCode, new WeakReference(aVar));
        return aVar;
    }

    /* renamed from: a */
    private static boolean m20121a(Activity activity) {
        return activity != null && !activity.isFinishing() && (Build.VERSION.SDK_INT < 17 || !activity.isDestroyed());
    }

    private static class SfImageLoaderStub implements ISfImageLoader {
        public void cancel(Object obj) {
        }

        public void loadInto(Object obj, View view) {
        }

        public void loadInto(Object obj, View view, int i) {
        }

        private SfImageLoaderStub() {
        }
    }
}
