package com.didichuxing.saimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.File;
import java.net.URL;

/* renamed from: com.didichuxing.saimageloader.b */
/* compiled from: GlideV4Wrapper */
class C17097b {

    /* renamed from: a */
    private Context f51162a = null;

    /* renamed from: b */
    private ImageView f51163b = null;

    /* renamed from: c */
    private Object f51164c = null;

    /* renamed from: d */
    private Object f51165d = null;

    /* renamed from: e */
    private Object f51166e = null;

    private C17097b(Context context) {
        this.f51162a = context;
    }

    /* renamed from: a */
    static C17097b m38257a(Context context) {
        return new C17097b(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C17097b mo126952a(Object obj) {
        this.f51164c = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C17097b mo126954b(Object obj) {
        this.f51165d = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C17097b mo126955c(Object obj) {
        this.f51166e = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo126953a(ImageView imageView) {
        this.f51163b = imageView;
        m38258a();
    }

    /* renamed from: a */
    private void m38258a() {
        RequestBuilder<Drawable> requestBuilder;
        Object obj = this.f51164c;
        if (obj instanceof String) {
            requestBuilder = Glide.with(this.f51162a).load((String) this.f51164c);
        } else if (obj instanceof Integer) {
            requestBuilder = Glide.with(this.f51162a).load((Integer) this.f51164c);
        } else if (obj instanceof Drawable) {
            requestBuilder = Glide.with(this.f51162a).load((Drawable) this.f51164c);
        } else if (obj instanceof Bitmap) {
            requestBuilder = Glide.with(this.f51162a).load((Bitmap) this.f51164c);
        } else if (obj instanceof Uri) {
            requestBuilder = Glide.with(this.f51162a).load((Uri) this.f51164c);
        } else if (obj instanceof URL) {
            requestBuilder = Glide.with(this.f51162a).load((URL) this.f51164c);
        } else if (obj instanceof File) {
            requestBuilder = Glide.with(this.f51162a).load((File) this.f51164c);
        } else if (obj instanceof byte[]) {
            requestBuilder = Glide.with(this.f51162a).load((byte[]) this.f51164c);
        } else {
            requestBuilder = Glide.with(this.f51162a).load(this.f51164c);
        }
        if (requestBuilder != null) {
            requestBuilder = (RequestBuilder) requestBuilder.diskCacheStrategy(DiskCacheStrategy.DATA);
        }
        if (requestBuilder != null) {
            Object obj2 = this.f51165d;
            if (obj2 instanceof Integer) {
                requestBuilder = (RequestBuilder) requestBuilder.placeholder(((Integer) obj2).intValue());
            } else if (obj2 instanceof Drawable) {
                requestBuilder = (RequestBuilder) requestBuilder.placeholder((Drawable) obj2);
            }
        }
        if (requestBuilder != null) {
            Object obj3 = this.f51166e;
            if (obj3 instanceof Integer) {
                requestBuilder = (RequestBuilder) requestBuilder.error(((Integer) obj3).intValue());
            } else if (obj3 instanceof Drawable) {
                requestBuilder = (RequestBuilder) requestBuilder.error((Drawable) obj3);
            }
        }
        if (requestBuilder != null) {
            requestBuilder.into(this.f51163b);
        }
    }
}
