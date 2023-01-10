package com.iproov.sdk.graphics.iproov;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import com.iproov.sdk.IProov;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.C20882import;
import com.iproov.sdk.core.C20893while;
import com.iproov.sdk.graphics.iproov.C20904do;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p057class.C1281break;
import p057class.C1288for;
import p057class.C1291new;
import p057class.C1292this;
import p057class.C1293try;
import p095switch.C3668else;
import p095switch.C3679throw;
import p096this.C3683do;
import p096this.C3685if;
import p230const.C21728for;
import p230const.C21729if;
import p230const.C21730new;
import p235do.C21820break;
import p241goto.C21997if;

public class OpenGLRenderer extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: a */
    private Context f57203a;

    /* renamed from: b */
    private C20776try f57204b;

    /* renamed from: c */
    private IProov.Options.C20735UI f57205c;

    /* renamed from: d */
    private C21997if f57206d;

    /* renamed from: e */
    private final C21730new f57207e = new C21730new();

    /* renamed from: f */
    private C1293try f57208f;

    /* renamed from: g */
    private C1281break f57209g;

    /* renamed from: h */
    private C1291new f57210h;

    /* renamed from: i */
    private C1292this f57211i;

    /* renamed from: j */
    private C1288for f57212j;

    /* renamed from: k */
    private boolean f57213k;

    /* renamed from: l */
    private boolean f57214l;

    /* renamed from: m */
    private SurfaceTexture f57215m;

    /* renamed from: n */
    private int f57216n;

    /* renamed from: o */
    private volatile boolean f57217o;

    /* renamed from: p */
    private int f57218p = 0;

    /* renamed from: q */
    private int f57219q = 0;

    /* renamed from: r */
    private final C21729if f57220r = new C21729if();

    /* renamed from: s */
    private boolean f57221s = false;

    /* renamed from: t */
    private C20903do f57222t;

    /* renamed from: com.iproov.sdk.graphics.iproov.OpenGLRenderer$do */
    public interface C20903do {
        /* renamed from: do */
        void mo171364do();
    }

    public OpenGLRenderer(Context context) {
        super(context);
        m43475a(context);
    }

    /* renamed from: a */
    private void m43474a() {
        queueEvent(new Runnable() {
            public final void run() {
                OpenGLRenderer.this.m43482g();
            }
        });
    }

    /* renamed from: a */
    private void m43475a(Context context) {
        this.f57203a = context;
        setEGLContextClientVersion(2);
        setPreserveEGLContextOnPause(true);
        setRenderer(this);
        setRenderMode(0);
    }

    /* renamed from: b */
    private void m43477b() {
        C1293try c = m43478c();
        this.f57208f = c;
        c.m46673new();
    }

    /* renamed from: c */
    private C1293try m43478c() {
        C1293try tryR = new C1293try(C3668else.m7417do(this.f57207e.mo178985if()));
        DisplayMetrics displayMetrics = this.f57203a.getResources().getDisplayMetrics();
        C20904do doVar = new C20904do(new C21820break(displayMetrics.widthPixels, displayMetrics.heightPixels), this.f57205c);
        tryR.mo14164do(doVar.mo171563do(C20904do.C20906if.CROP));
        tryR.mo14164do(doVar.mo171563do(C20904do.C20906if.LUMINANCE));
        tryR.mo14164do(doVar.mo171563do(C20904do.C20906if.HORIZONTAL_BLUR));
        tryR.mo14164do(doVar.mo171563do(C20904do.C20906if.VERTICAL_BLUR));
        tryR.mo14164do(doVar.mo171563do(C20904do.C20906if.SOBEL));
        tryR.mo14164do(doVar.mo171563do(C20904do.C20906if.SUPRESSION));
        tryR.mo14164do(doVar.mo171563do(C20904do.C20906if.INCLUSION));
        C1281break breakR = (C1281break) doVar.mo171563do(C20904do.C20906if.SHADE);
        this.f57209g = breakR;
        tryR.mo14164do(breakR);
        C1288for forR = (C1288for) doVar.mo171563do(C20904do.C20906if.FADE);
        this.f57212j = forR;
        tryR.mo14164do(forR);
        C1291new newR = (C1291new) doVar.mo171563do(C20904do.C20906if.FLASHING);
        this.f57210h = newR;
        tryR.mo14164do(newR);
        C1292this thisR = (C1292this) doVar.mo171563do(C20904do.C20906if.SCANNER);
        this.f57211i = thisR;
        tryR.mo14164do(thisR);
        return tryR;
    }

    /* renamed from: d */
    private void m43479d() {
        this.f57206d = C21728for.m44662do(this.f57204b, this.f57207e.m48210for(), this.f57207e.mo178981do(), this.f57207e.mo178985if());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m43480e() {
        SurfaceTexture surfaceTexture = this.f57215m;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m43481f() {
        setBackgroundColor(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m43482g() {
        if (this.f57217o) {
            this.f57218p++;
            requestRender();
        }
    }

    private C21820break getCameraPreviewSizeForCrop() {
        C21820break breakR = this.f57204b.m48075new().mo171312if();
        return !this.f57207e.mo178985if().isPortrait() ? new C21820break(breakR.mo180432do(), breakR.mo180435if()) : breakR;
    }

    /* renamed from: break  reason: not valid java name */
    public void m48144break() {
        float f;
        m43479d();
        C3683do.m7485do(this.f57207e.m48210for(), this.f57207e.mo178981do());
        float f2 = 0.0f;
        if (this.f57205c.orientation.isPortrait()) {
            f = (((float) (this.f57207e.mo178981do() - this.f57206d.f60028if)) / ((float) this.f57207e.mo178981do())) * 0.5f;
        } else {
            f2 = (((float) (this.f57207e.m48210for() - this.f57206d.f60027do)) / ((float) this.f57207e.m48210for())) * 0.5f;
            f = 0.0f;
        }
        this.f57212j.mo14158do(f2, f);
        this.f57221s = true;
    }

    /* renamed from: catch  reason: not valid java name */
    public synchronized void m48145catch() {
        this.f57217o = false;
        this.f57219q = 0;
        this.f57218p = 0;
        C1293try tryR = this.f57208f;
        if (tryR != null) {
            tryR.m46674try();
        }
        C20776try tryR2 = this.f57204b;
        if (tryR2 != null) {
            tryR2.mo171303do((Runnable) new Runnable() {
                public final void run() {
                    OpenGLRenderer.this.m43480e();
                }
            });
        }
    }

    public float getFrameRate() {
        return this.f57220r.mo178976do();
    }

    public String getScreenSizeString() {
        return this.f57207e.m48210for() + " x " + this.f57207e.mo178981do();
    }

    public synchronized void onDrawFrame(GL10 gl10) {
        while (this.f57217o && this.f57219q != this.f57218p) {
            GLES20.glClear(16384);
            this.f57215m.updateTexImage();
            this.f57219q++;
            this.f57208f.mo43518do(this.f57216n, this.f57207e.m48210for(), this.f57207e.mo178981do(), this.f57206d);
            GLES20.glFlush();
            if (!this.f57214l) {
                C3679throw.m7442do((Runnable) new Runnable() {
                    public final void run() {
                        OpenGLRenderer.this.m43481f();
                    }
                });
                this.f57214l = true;
            }
            this.f57220r.m48207for();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.f57207e.mo178982do(i, i2);
        mo171552do();
    }

    public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.f57217o = true;
    }

    public void setPermissionsDelegate(C20903do doVar) {
        this.f57222t = doVar;
    }

    /* renamed from: this  reason: not valid java name */
    public void m48146this() {
        if (!this.f57213k) {
            this.f57213k = true;
            this.f57212j.m46093new();
        }
    }

    /* renamed from: do */
    public void mo171555do(C20776try tryR, IProov.Options.C20735UI ui, Orientation orientation) {
        this.f57204b = tryR;
        this.f57205c = ui;
        this.f57207e.mo178983do(orientation);
        m43477b();
        this.f57216n = C3685if.m7495do(36197);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f57216n);
        this.f57215m = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                OpenGLRenderer.this.m43476a(surfaceTexture);
            }
        });
        tryR.mo171301do(this.f57215m);
    }

    public OpenGLRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m43475a(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m43476a(SurfaceTexture surfaceTexture) {
        C20893while.m43453do(C20882import.AND4);
        if (this.f57221s) {
            m43474a();
        }
    }

    /* renamed from: do */
    public void mo171553do(int i, float f, long j) {
        this.f57209g.mo14153do(1.0f);
        this.f57211i.mo14162do(f, j);
        this.f57210h.mo14161if(C21728for.m44663do(i));
        this.f57210h.mo14160do(C21728for.m44663do(C21728for.m44664if(i)));
    }

    /* renamed from: do */
    public void mo171552do() {
        this.f57222t.mo171364do();
    }

    /* renamed from: do */
    public void mo171554do(Rect rect) {
        this.f57208f.mo43520do(rect, getCameraPreviewSizeForCrop());
    }
}
