package com.didi.globalsafetoolkit.imageloader;

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

/* renamed from: com.didi.globalsafetoolkit.imageloader.a */
/* compiled from: SfImageLoader */
class C9557a implements ISfImageLoader {

    /* renamed from: a */
    private RequestManager f25175a;

    /* renamed from: a */
    private static Object m20123a(Object obj) {
        return obj == null ? "" : obj;
    }

    public C9557a(Context context) {
        this.f25175a = Glide.with(context);
    }

    public void loadInto(Object obj, View view) {
        Object a = m20123a(obj);
        if (m20124a(view)) {
            try {
                if (view instanceof ImageView) {
                    m20122a(a, 0).into((ImageView) view);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void loadInto(Object obj, View view, int i) {
        Object a = m20123a(obj);
        if (m20124a(view)) {
            try {
                if (view instanceof ImageView) {
                    m20122a(a, i).into((ImageView) view);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void cancel(Object obj) {
        if (obj instanceof ImageView) {
            this.f25175a.clear((View) (ImageView) obj);
        } else if (obj instanceof Target) {
            this.f25175a.clear((Target<?>) (Target) obj);
        }
    }

    /* renamed from: a */
    private RequestBuilder m20122a(Object obj, int i) {
        if (obj instanceof Integer) {
            return ((RequestBuilder) this.f25175a.asBitmap().placeholder(i)).load((Integer) obj);
        }
        if (obj instanceof Uri) {
            return ((RequestBuilder) this.f25175a.asBitmap().placeholder(i)).load((Uri) obj);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str) || !str.endsWith(".gif")) {
                return ((RequestBuilder) this.f25175a.asBitmap().placeholder(i)).load(str);
            }
            return ((RequestBuilder) this.f25175a.asGif().placeholder(i)).load(str);
        } else if (obj instanceof File) {
            return ((RequestBuilder) this.f25175a.asBitmap().placeholder(i)).load((File) obj);
        } else {
            throw new IllegalArgumentException("This source typeLocal is not accepted. {src = " + obj + "}");
        }
    }

    /* renamed from: a */
    private static boolean m20124a(View view) {
        return (view == null || view.getVisibility() == 8) ? false : true;
    }
}
