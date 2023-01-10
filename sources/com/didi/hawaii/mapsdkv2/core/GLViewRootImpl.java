package com.didi.hawaii.mapsdkv2.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.ViewDebug;
import com.didi.hawaii.mapsdkv2.MapHost;
import com.didi.hawaii.mapsdkv2.MapRender;
import com.didi.hawaii.mapsdkv2.core.GLInstrumentation;
import com.didi.hawaii.mapsdkv2.core.RenderHeartbeat;
import com.didi.hawaii.mapsdkv2.view.RenderTask;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

final class GLViewRootImpl implements MapHost.LifeCycleCallback, GLViewManager, GLViewParent {

    /* renamed from: a */
    static final boolean f26194a = false;

    /* renamed from: c */
    private static final String f26195c = "GLViewRootImpl";

    /* renamed from: d */
    private static final int f26196d = 1;

    /* renamed from: e */
    private static final int f26197e = 2;

    /* renamed from: f */
    private static final int f26198f = 10;

    /* renamed from: g */
    private static final int f26199g = 100;

    /* renamed from: A */
    private final Thread f26200A = Thread.currentThread();

    /* renamed from: B */
    private final GLInstrumentation f26201B = new GLInstrumentation() {
        public boolean postToRenderThread(final GLInstrumentation.GLInstrumentationTask gLInstrumentationTask) {
            return GLViewRootImpl.this.postToRenderThread((RenderTask) new RenderTask() {
                public void run() {
                    gLInstrumentationTask.run(GLViewRootImpl.this.f26205j, GLViewRootImpl.this.f26202b);
                }
            });
        }

        public <T> Future<T> postToRenderThread(final GLInstrumentation.GLInstrumentationFutureTask<T> gLInstrumentationFutureTask) {
            return GLViewRootImpl.this.postToRenderThread(new Callable<T>() {
                public T call() throws Exception {
                    return gLInstrumentationFutureTask.call(GLViewRootImpl.this.f26205j, GLViewRootImpl.this.f26202b);
                }
            });
        }
    };

    /* renamed from: b */
    final MapCanvas f26202b;

    /* renamed from: h */
    private MapRender f26203h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final GLBaseMapView f26204i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final MapEngine f26205j;

    /* renamed from: k */
    private final List<GLView> f26206k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final SparseArray<GLOverlayView> f26207l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final SparseArray<GLOverlayView> f26208m;

    /* renamed from: n */
    private final Handler f26209n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public final C9943e f26210o;

    /* renamed from: p */
    private final TouchDispatcher f26211p;

    /* renamed from: q */
    private Thread f26212q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final RenderHeartbeat f26213r;

    /* renamed from: s */
    private RenderProfile f26214s;

    /* renamed from: t */
    private int f26215t = 100;

    /* renamed from: u */
    private volatile boolean f26216u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f26217v = -1;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public int f26218w = -1;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final List<C9942d> f26219x = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f26220y;

    /* renamed from: z */
    private int f26221z = 2;

    /* renamed from: c */
    private void m20702c(int i) {
    }

    GLViewRootImpl(MapRender mapRender, GLBaseMapFactory gLBaseMapFactory, GLHttpClient gLHttpClient) {
        C9943e a = C9943e.m20756a(mapRender.getContext(), gLHttpClient);
        this.f26210o = a;
        this.f26203h = mapRender;
        if (mapRender instanceof MapHostView) {
            a.f26275a = ((MapHostView) mapRender).mEGLContextFactory;
        }
        C9944f fVar = new C9944f();
        this.f26205j = fVar;
        this.f26202b = fVar;
        this.f26209n = new Handler(Looper.getMainLooper());
        GLBaseMapView newGLBaseMapView = gLBaseMapFactory.newGLBaseMapView(this);
        this.f26204i = newGLBaseMapView;
        this.f26210o.f26276b = newGLBaseMapView.f26141f;
        this.f26204i.mo75561a(this.f26205j);
        this.f26206k = new ArrayList(10);
        this.f26207l = new SparseArray<>();
        this.f26208m = new SparseArray<>();
        this.f26211p = new TouchDispatcher(this, this.f26205j);
        this.f26213r = new RenderHeartbeat(new RenderHeartbeat.RenderListener() {
            public void invokeRequestRender() {
                GLViewRootImpl.this.m20701c();
            }
        });
        this.f26220y = 1;
        this.f26204i.mo75562a((OnBaseMapCreateCallback) new OnBaseMapCreateCallback() {
            public void onCreate() {
                GLViewRootImpl.this.f26213r.mo76360a(GLViewRootImpl.this.f26220y);
            }
        });
        this.f26216u = true;
        SetTransaction setTransaction = new SetTransaction((Runnable) null, this);
        setTransaction.chain(new Runnable() {
            public void run() {
                GLViewRootImpl.this.f26210o.getResources().mo76368a(GLViewRootImpl.this.f26205j.checkNeedGuard(GLViewRootImpl.this.f26210o.getResources().getPrefs().getMapGuardPath()));
            }
        });
        m20698a((GLView) this.f26204i, setTransaction);
        GLLocator gLLocator = new GLLocator(this, this.f26205j);
        m20698a((GLView) gLLocator, setTransaction);
        setTransaction.commit();
        this.f26204i.mo75560a(gLLocator);
    }

    /* renamed from: a */
    public void mo76048a(OnBaseMapCreateCallback onBaseMapCreateCallback) {
        if (this.f26216u) {
            this.f26204i.mo75569b(onBaseMapCreateCallback);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20701c() {
        if (this.f26203h != null && this.f26216u) {
            this.f26203h.requestRender();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo76049a() {
        if (this.f26214s != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            boolean renderFrame = this.f26205j.renderFrame();
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            long uptimeMillis3 = SystemClock.uptimeMillis();
            m20697a(renderFrame);
            m20696a(SystemClock.uptimeMillis() - uptimeMillis, uptimeMillis2, SystemClock.uptimeMillis() - uptimeMillis3);
            return renderFrame;
        }
        boolean renderFrame2 = this.f26205j.renderFrame();
        m20697a(renderFrame2);
        return renderFrame2;
    }

    /* renamed from: a */
    private void m20696a(long j, long j2, long j3) {
        RenderProfile renderProfile = this.f26214s;
        if (renderProfile != null) {
            renderProfile.onFrame(j, j2, j3);
            if (j > ((long) this.f26215t)) {
                this.f26214s.onSlowRender(j, j2, j3);
            }
        }
    }

    public boolean addView(GLOverlayView gLOverlayView) {
        SetTransaction setTransaction = new SetTransaction((Runnable) null, this);
        return m20698a((GLView) gLOverlayView, setTransaction) && setTransaction.commit();
    }

    public int addView(GLOverlayView... gLOverlayViewArr) {
        SetTransaction setTransaction = new SetTransaction((Runnable) null, this);
        int i = 0;
        for (GLOverlayView gLOverlayView : gLOverlayViewArr) {
            if (gLOverlayView != null && m20698a((GLView) gLOverlayView, setTransaction)) {
                i++;
            }
        }
        if (i <= 0 || !setTransaction.commit()) {
            return 0;
        }
        return i;
    }

    /* renamed from: a */
    private boolean m20698a(final GLView gLView, SetTransaction setTransaction) {
        final GLOverlayView gLOverlayView;
        if (!this.f26216u) {
            return false;
        }
        m20702c(2);
        if (gLView.mParent != null) {
            return false;
        }
        synchronized (this.f26206k) {
            if ((gLView instanceof GLOverlayView) && ((GLOverlayView) gLView).mSingleInstance) {
                Iterator<GLView> it = this.f26206k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        gLOverlayView = null;
                        break;
                    }
                    GLView next = it.next();
                    if (next.getClass().equals(gLView.getClass()) && next.mParent != null) {
                        gLOverlayView = (GLOverlayView) next;
                        it.remove();
                        break;
                    }
                }
                if (!(gLOverlayView == null || gLOverlayView.mParent == null)) {
                    gLOverlayView.mParent = null;
                    setTransaction.chain(new Runnable() {
                        public void run() {
                            synchronized (GLViewRootImpl.this.f26207l) {
                                GLViewRootImpl.this.f26207l.remove(gLOverlayView.mDisplayId);
                            }
                            if (gLOverlayView.mBubbleId > 0) {
                                synchronized (GLViewRootImpl.this.f26208m) {
                                    GLViewRootImpl.this.f26208m.remove(gLOverlayView.mBubbleId);
                                }
                            }
                            gLOverlayView.performRemove();
                        }
                    });
                }
            }
            if (!this.f26206k.contains(gLView)) {
                this.f26206k.add(gLView);
            }
        }
        if (gLView.mParent != null) {
            return false;
        }
        gLView.mParent = this;
        int i = this.f26218w;
        if (i != -1) {
            gLView.onHostSizeChanged(this.f26217v, i);
        }
        setTransaction.chain(new Runnable() {
            public void run() {
                gLView.performAdd();
                GLView gLView = gLView;
                if (gLView instanceof GLOverlayView) {
                    GLOverlayView gLOverlayView = (GLOverlayView) gLView;
                    if (gLOverlayView.mBubbleId > 0) {
                        synchronized (GLViewRootImpl.this.f26208m) {
                            GLViewRootImpl.this.f26208m.append(gLOverlayView.mBubbleId, gLOverlayView);
                        }
                    }
                    if (gLOverlayView.mDisplayId >= 0) {
                        synchronized (GLViewRootImpl.this.f26207l) {
                            GLViewRootImpl.this.f26207l.append(gLOverlayView.mDisplayId, gLOverlayView);
                        }
                    }
                }
            }
        });
        return true;
    }

    public boolean removeView(final GLOverlayView gLOverlayView) {
        boolean remove;
        m20702c(2);
        if (!this.f26216u) {
            return false;
        }
        synchronized (this.f26206k) {
            remove = this.f26206k.remove(gLOverlayView);
        }
        if (!remove || gLOverlayView.mParent == null) {
            return false;
        }
        gLOverlayView.mParent = null;
        return postToRenderThread((RenderTask) new RenderTask() {
            public void run() {
                synchronized (GLViewRootImpl.this.f26207l) {
                    GLViewRootImpl.this.f26207l.remove(gLOverlayView.mDisplayId);
                }
                if (gLOverlayView.mBubbleId > 0) {
                    synchronized (GLViewRootImpl.this.f26208m) {
                        GLViewRootImpl.this.f26208m.remove(gLOverlayView.mBubbleId);
                    }
                }
                gLOverlayView.performRemove();
            }
        });
    }

    public GLOverlayView findViewById(String str) {
        m20702c(2);
        if (!this.f26216u) {
            return null;
        }
        synchronized (this.f26206k) {
            for (GLView next : this.f26206k) {
                if (next.mParent != null) {
                    if (next.mID.equals(str) && (next instanceof GLOverlayView)) {
                        GLOverlayView gLOverlayView = (GLOverlayView) next;
                        return gLOverlayView;
                    }
                }
            }
            return null;
        }
    }

    public void insertCollisionDisPlayId(int i, GLOverlayView gLOverlayView) {
        m20702c(1);
        if (this.f26216u) {
            synchronized (this.f26207l) {
                this.f26207l.append(i, gLOverlayView);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public GLOverlayView mo76046a(int i) {
        GLOverlayView gLOverlayView;
        m20702c(2);
        if (!this.f26216u) {
            return null;
        }
        synchronized (this.f26207l) {
            gLOverlayView = this.f26207l.get(i);
        }
        return gLOverlayView;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo76047a(int i, GLOverlayView gLOverlayView) {
        m20702c(1);
        if (this.f26216u) {
            synchronized (this.f26207l) {
                this.f26207l.append(i, gLOverlayView);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public GLOverlayView mo76051b(int i) {
        GLOverlayView gLOverlayView;
        m20702c(2);
        if (!this.f26216u) {
            return null;
        }
        synchronized (this.f26208m) {
            gLOverlayView = this.f26208m.get(i);
        }
        return gLOverlayView;
    }

    @ViewDebug.ExportedProperty(deepExport = true)
    public GLBaseMapView getBaseMap() {
        return this.f26204i;
    }

    public MapContext getMapContext() {
        m20702c(3);
        return this.f26210o;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m20704d() {
        synchronized (this.f26206k) {
            for (GLView next : this.f26206k) {
                if (next instanceof GLOverlayView) {
                    ((GLOverlayView) next).mDisplayId = -2;
                } else if (next instanceof GLBaseMapView) {
                }
                next.performRemove();
            }
            this.f26206k.clear();
            this.f26204i.performRemove();
        }
    }

    public Handler getMainHandler() {
        return this.f26209n;
    }

    public boolean postToRenderThread(RenderTask renderTask) {
        MapRender mapRender;
        if (!this.f26216u || (mapRender = this.f26203h) == null) {
            return false;
        }
        mapRender.queueRenderEvent(renderTask);
        return true;
    }

    public <T> Future<T> postToRenderThread(Callable<T> callable) {
        if (!this.f26216u || this.f26203h == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        this.f26203h.queueEvent(futureTask);
        return futureTask;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo76050a(MotionEvent motionEvent) {
        return this.f26211p.mo76388a(motionEvent);
    }

    public void onHostCreated() {
        this.f26212q = Thread.currentThread();
        this.f26204i.mo75556a();
    }

    public void onHostDestroy() {
        this.f26204i.mo75567b();
    }

    public void onHostDetached() {
        m20702c(2);
        synchronized (this.f26206k) {
            for (GLView gLView : this.f26206k) {
                gLView.mParent = null;
            }
        }
        this.f26216u = false;
        new CleanUpThread(this).start();
    }

    public void addFrameCallback(final C9942d dVar) {
        if (this.f26216u) {
            postToRenderThread((RenderTask) new RenderTask() {
                public void run() {
                    GLViewRootImpl.this.f26219x.add(dVar);
                }
            });
        }
    }

    public void removeFrameCallback(final C9942d dVar) {
        postToRenderThread((RenderTask) new RenderTask() {
            public void run() {
                GLViewRootImpl.this.f26219x.remove(dVar);
            }
        });
    }

    public void setFps(int i) {
        int i2;
        if (this.f26216u && (i2 = this.f26221z) != 1 && i2 != 3 && this.f26220y != i) {
            this.f26220y = i;
            this.f26213r.mo76363c(i);
        }
    }

    public void setFpsMode(int i) {
        this.f26221z = i;
    }

    public int getFps() {
        return this.f26220y;
    }

    public GLInstrumentation getGLInstrumentation() {
        return this.f26201B;
    }

    public Future<Bitmap> screenShots() {
        return postToRenderThread(new Callable<Bitmap>() {
            public Bitmap call() throws Exception {
                return GLViewRootImpl.this.f26205j.screenShot(GLViewRootImpl.this.f26217v, GLViewRootImpl.this.f26218w, Bitmap.Config.ARGB_8888);
            }
        });
    }

    public Future<File> dumpInspectInfo(final File file) {
        return postToRenderThread(new Callable<File>() {
            public File call() throws Exception {
                try {
                    return GLViewDebug.m20683a(GLViewRootImpl.this, GLViewRootImpl.this.f26205j.screenShot(GLViewRootImpl.this.f26217v, GLViewRootImpl.this.f26218w, Bitmap.Config.ARGB_8888), file);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        });
    }

    /* renamed from: a */
    private void m20697a(boolean z) {
        if (!this.f26219x.isEmpty()) {
            for (C9942d onFrameFinish : this.f26219x) {
                onFrameFinish.onFrameFinish(z);
            }
        }
    }

    public void setRenderProfile(RenderProfile renderProfile) {
        if (this.f26216u) {
            this.f26214s = renderProfile;
            int slowRenderInterval = renderProfile.getSlowRenderInterval();
            if (slowRenderInterval > 0) {
                this.f26215t = slowRenderInterval;
            }
        }
    }

    public void onHostResume() {
        this.f26213r.mo76362b(this.f26220y);
        this.f26204i.mo75580d();
    }

    public void onHostPause() {
        this.f26204i.mo75584e();
        this.f26213r.mo76359a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public GLView[] mo76052b() {
        GLView[] gLViewArr;
        synchronized (this.f26206k) {
            gLViewArr = (GLView[]) this.f26206k.toArray(new GLView[this.f26206k.size()]);
        }
        return gLViewArr;
    }

    public void onHostSizeChanged(int i, int i2) {
        GLView[] gLViewArr;
        this.f26217v = i;
        this.f26218w = i2;
        synchronized (this.f26206k) {
            gLViewArr = (GLView[]) this.f26206k.toArray(new GLView[this.f26206k.size()]);
        }
        for (GLView onHostSizeChanged : gLViewArr) {
            onHostSizeChanged.onHostSizeChanged(i, i2);
        }
    }

    private static class CleanUpThread extends Thread {
        /* access modifiers changed from: private */
        public final GLViewRootImpl glViewRoot;

        CleanUpThread(GLViewRootImpl gLViewRootImpl) {
            super("GLViewCleanUp");
            this.glViewRoot = gLViewRootImpl;
            gLViewRootImpl.f26213r.mo76359a();
        }

        public void run() {
            this.glViewRoot.f26213r.mo76361b();
            if (C9946h.m20772a()) {
                this.glViewRoot.f26204i.mo75563a((Runnable) new Runnable() {
                    public void run() {
                        CleanUpThread.this.glViewRoot.f26205j.setRenderThread(Thread.currentThread());
                        CleanUpThread.this.glViewRoot.m20704d();
                    }
                });
                return;
            }
            this.glViewRoot.f26205j.setRenderThread(this);
            this.glViewRoot.f26204i.mo75563a((Runnable) null);
            this.glViewRoot.m20704d();
        }
    }
}
