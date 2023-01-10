package com.didi.hawaii.mapsdkv2.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.didi.hawaii.mapsdkv2.MapConfigHelper;
import com.didi.hawaii.mapsdkv2.Prefs;
import com.didi.hawaii.utils.C10024IO;
import com.didi.map.common.MapAssets;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import rui.config.RConfigConstants;

public final class Resources {

    /* renamed from: a */
    private static final String f26238a = "hawaii_sdk_user_custom_color#";

    /* renamed from: d */
    private static boolean f26239d;

    /* renamed from: b */
    private final Context f26240b;

    /* renamed from: c */
    private final MapContext f26241c;

    /* renamed from: e */
    private final Map<String, WeakReference<Bitmap>> f26242e = new HashMap();

    /* renamed from: f */
    private final Prefs f26243f;

    Resources(Context context, MapContext mapContext) {
        this.f26240b = context;
        this.f26241c = mapContext;
        this.f26243f = new Prefs(context);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo76368a(boolean z) {
        synchronized (Resources.class) {
            if (z) {
                C10024IO.deleteFileOrFolder(this.f26243f.getConfigPath());
                f26239d = false;
            }
            if (!f26239d) {
                m20732a();
                MapConfigHelper mapConfigHelper = new MapConfigHelper(this.f26240b, this.f26241c.getHttpClient(), this.f26243f);
                mapConfigHelper.copyBaseMapConfigFile();
                if (!z) {
                    mapConfigHelper.checkUpdate();
                }
                f26239d = true;
            }
        }
    }

    /* renamed from: a */
    private void m20732a() {
        C10024IO.ensureDir(this.f26243f.getMapPath4Language(0));
        C10024IO.ensureDir(this.f26243f.getSatPath());
        C10024IO.ensureDir(this.f26243f.getConfigPath());
        C10024IO.ensureDir(this.f26243f.getWmsPath());
    }

    public Prefs getPrefs() {
        return this.f26243f;
    }

    /* renamed from: a */
    static String m20731a(int i) {
        return f26238a + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo76367a(Bitmap bitmap) {
        String b = m20734b(bitmap);
        this.f26242e.put(b, new WeakReference(bitmap));
        return b;
    }

    /* renamed from: b */
    private String m20734b(Bitmap bitmap) {
        String hexString = Integer.toHexString(bitmap.hashCode());
        return hexString + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getWidth() + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getHeight() + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getRowBytes() + RConfigConstants.KEYWORD_COLOR_SIGN + bitmap.getPixel(bitmap.getWidth() / 2, bitmap.getHeight() / 2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Bitmap mo76366a(String str) {
        if (str.contains(f26238a)) {
            return m20733b(Integer.valueOf(str.replace(f26238a, "")).intValue());
        }
        WeakReference weakReference = this.f26242e.get(str);
        if (weakReference != null) {
            return (Bitmap) weakReference.get();
        }
        return null;
    }

    /* renamed from: b */
    private Bitmap m20733b(int i) {
        int[] iArr = new int[33];
        for (int i2 = 0; i2 < 33; i2++) {
            iArr[i2] = i;
        }
        return Bitmap.createBitmap(iArr, 0, 33, 33, 1, Bitmap.Config.ARGB_8888);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Bitmap mo76369b(String str) {
        if (!new File(str).exists()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public Bitmap mo76370c(String str) {
        Bitmap d = m20735d(str);
        if (d != null) {
            return d;
        }
        Bitmap bitmapInMapDir = MapAssets.bitmapInMapDir(this.f26240b, str);
        if (bitmapInMapDir != null) {
            return bitmapInMapDir;
        }
        return MapAssets.bitmap(this.f26240b, str);
    }

    /* renamed from: d */
    private Bitmap m20735d(String str) {
        InputStream inputStream;
        Throwable th;
        try {
            inputStream = C10024IO.getInputStream(this.f26243f.getConfigPath() + str);
            if (inputStream != null) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inScaled = false;
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    C10024IO.safeClose(inputStream);
                    return decodeStream;
                } catch (Throwable th2) {
                    th = th2;
                    C10024IO.safeClose(inputStream);
                    throw th;
                }
            } else {
                C10024IO.safeClose(inputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            C10024IO.safeClose(inputStream);
            throw th;
        }
    }
}
