package com.didi.safetoolkit.imageloader;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.target.Target;
import java.io.File;

/* renamed from: com.didi.safetoolkit.imageloader.a */
/* compiled from: SfImageLoader */
class C12598a implements ISfImageLoader {

    /* renamed from: a */
    private RequestManager f37285a;

    /* renamed from: a */
    private static Object m28110a(Object obj) {
        return obj == null ? "" : obj;
    }

    public C12598a(Context context) {
        this.f37285a = Glide.with(context);
    }

    public void loadInto(Object obj, View view) {
        Object a = m28110a(obj);
        if (m28111a(view)) {
            try {
                if (view instanceof ImageView) {
                    m28109a(a, 0).into((ImageView) view);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void loadInto(Object obj, View view, int i) {
        Object a = m28110a(obj);
        if (m28111a(view)) {
            try {
                if (view instanceof ImageView) {
                    m28109a(a, i).into((ImageView) view);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void cancel(Object obj) {
        if (obj instanceof ImageView) {
            this.f37285a.clear((View) (ImageView) obj);
        } else if (obj instanceof Target) {
            this.f37285a.clear((Target<?>) (Target) obj);
        }
    }

    /* renamed from: a */
    private RequestBuilder m28109a(Object obj, int i) {
        if (obj instanceof Integer) {
            return ((RequestBuilder) this.f37285a.asBitmap().placeholder(i)).load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return ((RequestBuilder) this.f37285a.asBitmap().placeholder(i)).load((Uri) obj);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str) || !str.endsWith(".gif")) {
                return ((RequestBuilder) this.f37285a.asBitmap().placeholder(i)).load(str);
            }
            return ((RequestBuilder) this.f37285a.asGif().placeholder(i)).load(str);
        } else if (obj instanceof File) {
            return ((RequestBuilder) this.f37285a.asBitmap().placeholder(i)).load((File) obj);
        } else {
            throw new IllegalArgumentException("This source typeLocal is not accepted. {src = " + obj + "}");
        }
    }

    /* renamed from: a */
    private static boolean m28111a(View view) {
        return (view == null || view.getVisibility() == 8) ? false : true;
    }
}
