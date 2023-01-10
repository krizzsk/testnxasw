package com.didichuxing.saimageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.io.File;
import java.net.URL;

public final class DiSafetyImageLoader {

    /* renamed from: a */
    private static boolean f51151a = true;

    /* renamed from: b */
    private Context f51152b = null;

    /* renamed from: c */
    private ImageView f51153c = null;

    /* renamed from: d */
    private Object f51154d = null;

    /* renamed from: e */
    private Object f51155e = null;

    /* renamed from: f */
    private Object f51156f = null;

    private DiSafetyImageLoader(Context context) {
        this.f51152b = context;
    }

    public static DiSafetyImageLoader with(Context context) {
        return new DiSafetyImageLoader(context);
    }

    public DiSafetyImageLoader load(String str) {
        this.f51154d = str;
        return this;
    }

    public DiSafetyImageLoader load(int i) {
        this.f51154d = Integer.valueOf(i);
        return this;
    }

    public DiSafetyImageLoader load(Drawable drawable) {
        this.f51154d = drawable;
        return this;
    }

    public DiSafetyImageLoader load(Bitmap bitmap) {
        this.f51154d = bitmap;
        return this;
    }

    public DiSafetyImageLoader load(Uri uri) {
        this.f51154d = uri;
        return this;
    }

    public DiSafetyImageLoader load(URL url) {
        this.f51154d = url;
        return this;
    }

    public DiSafetyImageLoader load(File file) {
        this.f51154d = file;
        return this;
    }

    @Deprecated
    public DiSafetyImageLoader load(Object obj) {
        this.f51154d = obj;
        return this;
    }

    public DiSafetyImageLoader placeholder(int i) {
        this.f51155e = Integer.valueOf(i);
        return this;
    }

    public DiSafetyImageLoader placeholder(Drawable drawable) {
        this.f51155e = drawable;
        return this;
    }

    public DiSafetyImageLoader error(int i) {
        this.f51156f = Integer.valueOf(i);
        return this;
    }

    public DiSafetyImageLoader error(Drawable drawable) {
        this.f51156f = drawable;
        return this;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0015 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:8:0x0015=Splitter:B:8:0x0015, B:4:0x000a=Splitter:B:4:0x000a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void into(android.widget.ImageView r1) {
        /*
            r0 = this;
            r0.f51153c = r1
            boolean r1 = f51151a
            if (r1 == 0) goto L_0x0011
            r0.m38249a()     // Catch:{ all -> 0x000a }
            goto L_0x001b
        L_0x000a:
            r0.m38250b()     // Catch:{ all -> 0x001b }
            r1 = 0
            f51151a = r1     // Catch:{ all -> 0x001b }
            goto L_0x001b
        L_0x0011:
            r0.m38250b()     // Catch:{ all -> 0x0015 }
            goto L_0x001b
        L_0x0015:
            r0.m38249a()     // Catch:{ all -> 0x001b }
            r1 = 1
            f51151a = r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.saimageloader.DiSafetyImageLoader.into(android.widget.ImageView):void");
    }

    /* renamed from: a */
    private void m38249a() {
        C17097b.m38257a(this.f51152b).mo126952a(this.f51154d).mo126954b(this.f51155e).mo126955c(this.f51156f).mo126953a(this.f51153c);
    }

    /* renamed from: b */
    private void m38250b() {
        C17096a.m38251a(this.f51152b).mo126948a(this.f51154d).mo126950b(this.f51155e).mo126951c(this.f51156f).mo126949a(this.f51153c);
    }
}
