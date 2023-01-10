package com.didichuxing.saimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URL;

/* renamed from: com.didichuxing.saimageloader.a */
/* compiled from: GlideV3Wrapper */
class C17096a {

    /* renamed from: a */
    private Context f51157a = null;

    /* renamed from: b */
    private ImageView f51158b = null;

    /* renamed from: c */
    private Object f51159c = null;

    /* renamed from: d */
    private Object f51160d = null;

    /* renamed from: e */
    private Object f51161e = null;

    C17096a(Context context) {
        this.f51157a = context;
    }

    /* renamed from: a */
    static C17096a m38251a(Context context) {
        return new C17096a(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C17096a mo126948a(Object obj) {
        this.f51159c = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C17096a mo126950b(Object obj) {
        this.f51160d = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C17096a mo126951c(Object obj) {
        this.f51161e = obj;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo126949a(ImageView imageView) {
        this.f51158b = imageView;
        m38252a();
    }

    /* renamed from: a */
    private void m38252a() {
        RequestBuilder<Drawable> requestBuilder;
        Object obj = this.f51159c;
        if (obj instanceof Drawable) {
            this.f51158b.setImageDrawable((Drawable) obj);
            return;
        }
        if (obj instanceof String) {
            requestBuilder = Glide.with(this.f51157a).load((String) this.f51159c);
        } else if (obj instanceof Integer) {
            requestBuilder = Glide.with(this.f51157a).load((Integer) this.f51159c);
        } else if (obj instanceof Uri) {
            requestBuilder = Glide.with(this.f51157a).loadFromMediaStore((Uri) this.f51159c);
        } else if (obj instanceof URL) {
            requestBuilder = Glide.with(this.f51157a).load((URL) this.f51159c);
        } else if (obj instanceof Bitmap) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap) this.f51159c).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            requestBuilder = Glide.with(this.f51157a).load(byteArrayOutputStream.toByteArray());
        } else if (obj instanceof File) {
            requestBuilder = Glide.with(this.f51157a).load((File) this.f51159c);
        } else if (obj instanceof byte[]) {
            requestBuilder = Glide.with(this.f51157a).load((byte[]) this.f51159c);
        } else {
            requestBuilder = Glide.with(this.f51157a).load(this.f51159c);
        }
        if (requestBuilder != null) {
            requestBuilder = requestBuilder.diskCacheStrategy(DiskCacheStrategy.SOURCE);
        }
        if (requestBuilder != null) {
            Object obj2 = this.f51160d;
            if (obj2 instanceof Integer) {
                requestBuilder = requestBuilder.placeholder(((Integer) obj2).intValue());
            } else if (obj2 instanceof Drawable) {
                requestBuilder = requestBuilder.placeholder((Drawable) obj2);
            }
        }
        if (requestBuilder != null) {
            Object obj3 = this.f51161e;
            if (obj3 instanceof Integer) {
                requestBuilder = requestBuilder.error(((Integer) obj3).intValue());
            } else if (obj3 instanceof Drawable) {
                requestBuilder = requestBuilder.error((Drawable) obj3);
            }
        }
        if (requestBuilder != null) {
            requestBuilder.into(this.f51158b);
        }
    }
}
