package com.didi.beatles.p101im.views.widget.longimage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.didi.beatles.im.views.widget.longimage.IMImageSource */
public final class IMImageSource {

    /* renamed from: a */
    static final String f12354a = "file:///";

    /* renamed from: b */
    static final String f12355b = "file:///android_asset/";

    /* renamed from: c */
    private final Uri f12356c;

    /* renamed from: d */
    private final Bitmap f12357d;

    /* renamed from: e */
    private final Integer f12358e;

    /* renamed from: f */
    private boolean f12359f;

    /* renamed from: g */
    private int f12360g;

    /* renamed from: h */
    private int f12361h;

    /* renamed from: i */
    private Rect f12362i;

    /* renamed from: j */
    private boolean f12363j;

    private IMImageSource(Bitmap bitmap, boolean z) {
        this.f12357d = bitmap;
        this.f12356c = null;
        this.f12358e = null;
        this.f12359f = false;
        this.f12360g = bitmap.getWidth();
        this.f12361h = bitmap.getHeight();
        this.f12363j = z;
    }

    private IMImageSource(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(f12354a) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.f12357d = null;
        this.f12356c = uri;
        this.f12358e = null;
        this.f12359f = true;
    }

    private IMImageSource(int i) {
        this.f12357d = null;
        this.f12356c = null;
        this.f12358e = Integer.valueOf(i);
        this.f12359f = true;
    }

    public static IMImageSource resource(int i) {
        return new IMImageSource(i);
    }

    public static IMImageSource asset(String str) {
        if (str != null) {
            return uri(f12355b + str);
        }
        throw new NullPointerException("Asset name must not be null");
    }

    public static IMImageSource uri(String str) {
        if (str != null) {
            if (!str.contains(HWMapConstant.HTTP.SEPARATOR)) {
                if (str.startsWith("/")) {
                    str = str.substring(1);
                }
                str = f12354a + str;
            }
            return new IMImageSource(Uri.parse(str));
        }
        throw new NullPointerException("Uri must not be null");
    }

    public static IMImageSource uri(Uri uri) {
        if (uri != null) {
            return new IMImageSource(uri);
        }
        throw new NullPointerException("Uri must not be null");
    }

    public static IMImageSource bitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new IMImageSource(bitmap, false);
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    public static IMImageSource cachedBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            return new IMImageSource(bitmap, true);
        }
        throw new NullPointerException("Bitmap must not be null");
    }

    public IMImageSource tilingEnabled() {
        return tiling(true);
    }

    public IMImageSource tilingDisabled() {
        return tiling(false);
    }

    public IMImageSource tiling(boolean z) {
        this.f12359f = z;
        return this;
    }

    public IMImageSource region(Rect rect) {
        this.f12362i = rect;
        m10526a();
        return this;
    }

    public IMImageSource dimensions(int i, int i2) {
        if (this.f12357d == null) {
            this.f12360g = i;
            this.f12361h = i2;
        }
        m10526a();
        return this;
    }

    /* renamed from: a */
    private void m10526a() {
        Rect rect = this.f12362i;
        if (rect != null) {
            this.f12359f = true;
            this.f12360g = rect.width();
            this.f12361h = this.f12362i.height();
        }
    }

    /* access modifiers changed from: protected */
    public final Uri getUri() {
        return this.f12356c;
    }

    /* access modifiers changed from: protected */
    public final Bitmap getBitmap() {
        return this.f12357d;
    }

    /* access modifiers changed from: protected */
    public final Integer getResource() {
        return this.f12358e;
    }

    /* access modifiers changed from: protected */
    public final boolean getTile() {
        return this.f12359f;
    }

    /* access modifiers changed from: protected */
    public final int getSWidth() {
        return this.f12360g;
    }

    /* access modifiers changed from: protected */
    public final int getSHeight() {
        return this.f12361h;
    }

    /* access modifiers changed from: protected */
    public final Rect getSRegion() {
        return this.f12362i;
    }

    /* access modifiers changed from: protected */
    public final boolean isCached() {
        return this.f12363j;
    }
}
