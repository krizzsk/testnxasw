package com.didi.beatles.p101im.utils.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.didi.beatles.p101im.IMCommonContextInfoHelper;
import com.didi.beatles.p101im.utils.IMLog;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didi.beatles.im.utils.imageloader.BtsImageLoader */
public final class BtsImageLoader implements IBtsImageLoader {

    /* renamed from: a */
    private static BtsImageLoader f11668a;

    /* renamed from: b */
    private IBtsImageLoader f11669b;

    public static BtsImageLoader getInstance() {
        if (f11668a == null) {
            synchronized (BtsImageLoader.class) {
                if (f11668a == null) {
                    f11668a = new BtsImageLoader();
                }
            }
        }
        f11668a.with(IMCommonContextInfoHelper.getContext());
        return f11668a;
    }

    public BtsImageLoader() {
        IBtsImageLoader iBtsImageLoader = (IBtsImageLoader) ServiceLoader.load(IBtsImageLoader.class).iterator().next();
        this.f11669b = iBtsImageLoader;
        if (iBtsImageLoader == null) {
            IMLog.m10021e("IMImageLoader", "init fail not found IBtsImageLoader spi");
            this.f11669b = IBtsImageLoader.empty;
        }
    }

    public IBtsImageLoader with(Context context) {
        this.f11669b.with(context);
        return f11668a;
    }

    public void loadInto(Object obj, View view) {
        this.f11669b.loadInto(obj, view);
    }

    public void loadInto(Object obj, View view, Drawable drawable) {
        this.f11669b.loadInto(obj, view, drawable);
    }

    public void loadInto(Object obj, View view, int i) {
        this.f11669b.loadInto(obj, view, i);
    }

    public void loadInto(Object obj, View view, Callback callback) {
        this.f11669b.loadInto(obj, view, callback);
    }

    public void loadIntoAsGif(Object obj, View view, Callback callback) {
        this.f11669b.loadIntoAsGif(obj, view, callback);
    }

    public void loadIntoAsGif(Object obj, View view, int i, Callback callback) {
        this.f11669b.loadIntoAsGif(obj, view, i, callback);
    }

    public void loadRoundInto(Object obj, View view, int i) {
        this.f11669b.loadRoundInto(obj, view, i);
    }

    public void loadRoundInto(Object obj, View view) {
        this.f11669b.loadRoundInto(obj, view);
    }

    public void loadRoundInto(Object obj, int i, View view) {
        this.f11669b.loadRoundInto(obj, i, view);
    }

    public Object download(String str, Callback callback) {
        return this.f11669b.download(str, callback);
    }

    public Object download(String str, int i, int i2, Callback callback) {
        return this.f11669b.download(str, i, i2, callback);
    }

    public void loadInto(Object obj, View view, Animator animator, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        this.f11669b.loadInto(obj, view, animator, iMImageRequestOptions, callback);
    }

    public Object download(String str, int i, int i2, IMImageRequestOptions iMImageRequestOptions, Callback callback) {
        return this.f11669b.download(str, i, i2, iMImageRequestOptions, callback);
    }

    public void cancel(Object obj) {
        this.f11669b.cancel(obj);
    }

    public void clearMemory() {
        this.f11669b.clearMemory();
    }

    public static Callback getEmptyCallback() {
        return new Callback() {
            public void onFailed() {
            }

            public void onStart() {
            }

            public void onSuccess(Bitmap bitmap) {
            }
        };
    }
}
