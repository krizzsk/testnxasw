package com.didi.common.map.model;

import android.content.Context;
import android.graphics.Bitmap;

public final class BitmapDescriptor {

    /* renamed from: d */
    private static final String f12628d = "BitmapDescriptor";

    /* renamed from: a */
    final float f12629a;

    /* renamed from: b */
    final float f12630b;

    /* renamed from: c */
    final float f12631c;

    /* renamed from: e */
    private final Type f12632e;

    /* renamed from: f */
    private final Bitmap f12633f;

    /* renamed from: g */
    private final String f12634g;

    /* renamed from: h */
    private final int f12635h;

    enum Type {
        BITMAP,
        PATH_ABSOLUTE,
        PATH_ASSET,
        PATH_FILEINPUT,
        RESOURCE_ID
    }

    BitmapDescriptor(Bitmap bitmap) {
        this(bitmap, -1.0f, -1.0f, -1.0f);
    }

    BitmapDescriptor(Bitmap bitmap, float f, float f2, float f3) {
        this.f12632e = Type.BITMAP;
        this.f12629a = f;
        this.f12630b = f2;
        this.f12631c = f3;
        this.f12633f = bitmap;
        this.f12634g = null;
        this.f12635h = 0;
    }

    BitmapDescriptor(Context context, String str, Type type) {
        this.f12632e = type;
        this.f12631c = -1.0f;
        this.f12630b = -1.0f;
        this.f12629a = -1.0f;
        this.f12634g = str;
        this.f12635h = 0;
        this.f12633f = loadBitmap(context);
    }

    BitmapDescriptor(Context context, int i) {
        this.f12632e = Type.RESOURCE_ID;
        this.f12631c = -1.0f;
        this.f12630b = -1.0f;
        this.f12629a = -1.0f;
        this.f12633f = loadBitmap(context);
        this.f12634g = null;
        this.f12635h = i;
    }

    /* renamed from: com.didi.common.map.model.BitmapDescriptor$1 */
    static /* synthetic */ class C50521 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$common$map$model$BitmapDescriptor$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.common.map.model.BitmapDescriptor$Type[] r0 = com.didi.common.map.model.BitmapDescriptor.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$common$map$model$BitmapDescriptor$Type = r0
                com.didi.common.map.model.BitmapDescriptor$Type r1 = com.didi.common.map.model.BitmapDescriptor.Type.BITMAP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$common$map$model$BitmapDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.common.map.model.BitmapDescriptor$Type r1 = com.didi.common.map.model.BitmapDescriptor.Type.PATH_ABSOLUTE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$common$map$model$BitmapDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.common.map.model.BitmapDescriptor$Type r1 = com.didi.common.map.model.BitmapDescriptor.Type.PATH_ASSET     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$common$map$model$BitmapDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.common.map.model.BitmapDescriptor$Type r1 = com.didi.common.map.model.BitmapDescriptor.Type.PATH_FILEINPUT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$common$map$model$BitmapDescriptor$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.common.map.model.BitmapDescriptor$Type r1 = com.didi.common.map.model.BitmapDescriptor.Type.RESOURCE_ID     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.model.BitmapDescriptor.C50521.<clinit>():void");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0064 A[SYNTHETIC, Splitter:B:42:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x006b A[SYNTHETIC, Splitter:B:49:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap loadBitmap(android.content.Context r5) {
        /*
            r4 = this;
            r0 = 0
            int[] r1 = com.didi.common.map.model.BitmapDescriptor.C50521.$SwitchMap$com$didi$common$map$model$BitmapDescriptor$Type     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            com.didi.common.map.model.BitmapDescriptor$Type r2 = r4.f12632e     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            int r2 = r2.ordinal()     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            r1 = r1[r2]     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            r2 = 1
            if (r1 == r2) goto L_0x005e
            r2 = 2
            if (r1 == r2) goto L_0x0057
            r2 = 3
            if (r1 == r2) goto L_0x0043
            r2 = 4
            if (r1 == r2) goto L_0x002c
            r2 = 5
            if (r1 == r2) goto L_0x001b
            return r0
        L_0x001b:
            android.content.res.Resources r5 = r5.getResources()     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            int r1 = r4.f12635h     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            android.graphics.drawable.BitmapDrawable r5 = (android.graphics.drawable.BitmapDrawable) r5     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            android.graphics.Bitmap r5 = r5.getBitmap()     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            return r5
        L_0x002c:
            java.lang.String r1 = r4.f12634g     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            java.io.FileInputStream r5 = r5.openFileInput(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ IOException -> 0x0041, all -> 0x003c }
            if (r5 == 0) goto L_0x003b
            r5.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            return r0
        L_0x003c:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x0062
        L_0x0041:
            goto L_0x0069
        L_0x0043:
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            java.lang.String r1 = r4.f12634g     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            java.io.InputStream r5 = r5.open(r1)     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ IOException -> 0x0041, all -> 0x003c }
            if (r5 == 0) goto L_0x0056
            r5.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            return r0
        L_0x0057:
            java.lang.String r5 = r4.f12634g     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFile(r5)     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            return r5
        L_0x005e:
            android.graphics.Bitmap r5 = r4.f12633f     // Catch:{ IOException -> 0x0068, all -> 0x0061 }
            return r5
        L_0x0061:
            r5 = move-exception
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.close()     // Catch:{ IOException -> 0x0067 }
        L_0x0067:
            throw r5
        L_0x0068:
            r5 = r0
        L_0x0069:
            if (r5 == 0) goto L_0x006e
            r5.close()     // Catch:{ IOException -> 0x006e }
        L_0x006e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.common.map.model.BitmapDescriptor.loadBitmap(android.content.Context):android.graphics.Bitmap");
    }

    public Bitmap getBitmap() {
        return this.f12633f;
    }
}
