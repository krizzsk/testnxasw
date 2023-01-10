package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.didi.hawaii.log.HWThreadPool;
import com.didi.hawaii.mapsdkv2.common.MapLog;
import com.didi.hawaii.mapsdkv2.core.GLBaseMapView;
import com.didi.hawaii.mapsdkv2.core.MapEngine;
import com.didi.map.base.TextLableOnRoute;
import com.didi.map.common.utils.SystemUtil;
import java.util.List;

/* renamed from: com.didi.hawaii.mapsdkv2.core.c */
/* compiled from: EngineCallbackImpl */
final class C9941c implements MapEngine.Callback {

    /* renamed from: a */
    private static final String f26265a = "EngineCallbackImpl";

    /* renamed from: b */
    private final GLBaseMapView f26266b;

    /* renamed from: c */
    private final Resources f26267c;

    /* renamed from: d */
    private Paint f26268d;

    /* renamed from: e */
    private float f26269e;

    /* renamed from: f */
    private Bitmap f26270f;

    /* renamed from: g */
    private int f26271g = 300;

    /* renamed from: h */
    private int f26272h = 100;

    /* renamed from: i */
    private final PointF f26273i = new PointF();

    /* renamed from: j */
    private final Canvas f26274j = new Canvas();

    C9941c(GLBaseMapView gLBaseMapView) {
        this.f26266b = gLBaseMapView;
        this.f26267c = gLBaseMapView.getMapContext().getResources();
    }

    public LoadedImage onLoadBitmap(int i, String str) {
        if (i == 1) {
            return new LoadedImage(this.f26267c.mo76369b(str), SystemUtil.getDensity(this.f26266b.getMapContext().getAndroidContext()), 0.5f, 0.5f);
        }
        Bitmap a = this.f26267c.mo76366a(str);
        if (a == null && this.f26266b.f26145j != null) {
            a = this.f26266b.f26145j.onLoadBitmap(i, str);
        }
        if (a == null) {
            a = this.f26267c.mo76370c(str);
        }
        if (a == null) {
            MapLog.m20587e(f26265a, "onLoadBitmap:Can't find texture " + str);
            a = Bitmap.createBitmap(16, 16, Bitmap.Config.RGB_565);
            new Canvas(a).drawColor(-65536);
        }
        return new LoadedImage(a, SystemUtil.getDensity(this.f26266b.getMapContext().getAndroidContext()), 0.5f, 0.5f);
    }

    public Bitmap onLoadTextBitmap(String str, int i, int i2, int i3, int i4, boolean z) {
        boolean z2 = this.f26272h < i3 || this.f26271g < i2;
        if (this.f26270f == null || z2) {
            int i5 = this.f26271g;
            if (i2 > i5) {
                i5 = i2;
            }
            this.f26271g = i5;
            int i6 = this.f26272h;
            if (i3 > i6) {
                i6 = i3;
            }
            this.f26272h = i6;
            Bitmap createBitmap = Bitmap.createBitmap(this.f26271g, i6, Bitmap.Config.ALPHA_8);
            this.f26270f = createBitmap;
            this.f26274j.setBitmap(createBitmap);
        }
        Paint a = m20755a(i);
        this.f26270f.eraseColor(0);
        a.setFakeBoldText(z);
        this.f26274j.drawText(str, ((float) i2) / 2.0f, (((float) i3) / 2.0f) - ((a.descent() + a.ascent()) / 2.0f), a);
        return this.f26270f;
    }

    public PointF onGetTextSize(String str, int i, boolean z) {
        Paint a = m20755a(i);
        this.f26273i.x = a.measureText(str) + 1.0f;
        this.f26273i.y = (float) (i + 2);
        return this.f26273i;
    }

    public void onDownload(String str) {
        MapDataUpdateHandler mapDataUpdateHandler = this.f26266b.f26138c;
        GLBaseMapView gLBaseMapView = this.f26266b;
        mapDataUpdateHandler.onUpdateBaseMapData(gLBaseMapView, gLBaseMapView.f26139d, str);
    }

    public void onLabelOnRouteNew(List<TextLableOnRoute> list) {
        GLBaseMapView.LabelOnRouteCallback labelOnRouteCallback = this.f26266b.f26144i;
        if (labelOnRouteCallback != null) {
            labelOnRouteCallback.onRouteNew(list);
        }
    }

    public void onDownloadDynamicLayer(boolean z, String str, byte[] bArr, int i) {
        GLBaseMapView gLBaseMapView = this.f26266b;
        if (gLBaseMapView != null && gLBaseMapView.f26138c != null) {
            MapDataUpdateHandler mapDataUpdateHandler = this.f26266b.f26138c;
            GLBaseMapView gLBaseMapView2 = this.f26266b;
            mapDataUpdateHandler.onDownloadDynamicLayer(gLBaseMapView2, gLBaseMapView2.f26139d, z, str, bArr);
        }
    }

    public void onWriteFile(String str, byte[] bArr) {
        HWThreadPool.execute(new EngineCallbackImpl$1(this, str, bArr));
    }

    /* renamed from: a */
    private Paint m20755a(int i) {
        if (this.f26268d == null) {
            Paint paint = new Paint();
            this.f26268d = paint;
            paint.setTypeface(Typeface.DEFAULT);
            this.f26268d.setAntiAlias(true);
            this.f26268d.setStyle(Paint.Style.FILL);
            this.f26268d.setTextAlign(Paint.Align.CENTER);
            this.f26268d.setLinearText(true);
            this.f26269e = this.f26268d.getTextSize();
        }
        float f = (float) i;
        if (this.f26269e != f) {
            this.f26268d.setTextSize(f);
            this.f26269e = f;
        }
        return this.f26268d;
    }
}
