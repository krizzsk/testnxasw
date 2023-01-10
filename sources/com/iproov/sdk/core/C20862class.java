package com.iproov.sdk.core;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import com.iproov.sdk.core.C20864const;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.logging.IPLog;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import p095switch.C3660catch;
import p095switch.C3673for;
import p095switch.C3675if;
import p098try.C3688do;
import p235do.C21824for;

/* renamed from: com.iproov.sdk.core.class */
/* compiled from: LivenessFrameSelector */
class C20862class {

    /* renamed from: a */
    private static final String f57034a = "class";

    /* renamed from: b */
    private final C3675if f57035b = new C3675if();

    /* renamed from: c */
    private final BlockingQueue<C20863do> f57036c;

    /* renamed from: d */
    private C20864const.C20865do f57037d;

    /* renamed from: e */
    private final int f57038e;

    /* renamed from: f */
    private int f57039f = 0;

    /* renamed from: g */
    private int f57040g = 1;

    /* renamed from: h */
    private final AtomicInteger f57041h = new AtomicInteger(0);

    /* renamed from: i */
    private Double f57042i = null;

    /* renamed from: j */
    private C20863do f57043j = null;

    /* renamed from: k */
    private boolean f57044k = true;

    /* renamed from: l */
    private int f57045l = 0;

    /* renamed from: m */
    private long f57046m = 0;

    /* renamed from: n */
    private int f57047n = 0;

    /* renamed from: o */
    private int f57048o = 0;

    /* renamed from: p */
    private final StringBuffer f57049p = new StringBuffer();

    /* renamed from: q */
    private final StringBuffer f57050q = new StringBuffer();

    /* renamed from: com.iproov.sdk.core.class$do */
    /* compiled from: LivenessFrameSelector */
    private static class C20863do {

        /* renamed from: case  reason: not valid java name */
        public final boolean f62368case;

        /* renamed from: do */
        public final C21824for f57051do;

        /* renamed from: else  reason: not valid java name */
        public final int f62369else;

        /* renamed from: for  reason: not valid java name */
        public final FaceFeature f62370for;

        /* renamed from: if */
        public final Bitmap f57052if;

        /* renamed from: new  reason: not valid java name */
        public final RectF f62371new;

        /* renamed from: try  reason: not valid java name */
        public final int f62372try;

        public C20863do(C21824for forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, C3688do doVar, int i, boolean z, int i2) {
            this.f57051do = forR;
            this.f57052if = bitmap;
            this.f62370for = faceFeature;
            this.f62371new = rectF;
            this.f62372try = i;
            this.f62368case = z;
            this.f62369else = i2;
        }
    }

    public C20862class(C20864const.C20865do doVar, int i, int i2) {
        this.f57038e = i2;
        this.f57037d = doVar;
        this.f57036c = new ArrayBlockingQueue(i2 * i);
        C3660catch.m7404do("LivenessFrameSelector", C3660catch.C3662for.LOW, (Runnable) new Runnable(doVar) {
            public final /* synthetic */ C20864const.C20865do f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                C20862class.this.m43258a(this.f$1);
            }
        }).start();
    }

    /* renamed from: a */
    private void m43255a(int i) {
        this.f57041h.set(i);
    }

    /* renamed from: a */
    private void m43256a(C20863do doVar) {
        this.f57037d.mo171469do(doVar.f57051do, doVar.f62368case, doVar.f62371new);
    }

    /* renamed from: b */
    private double m43259b(C20863do doVar) {
        FaceFeature faceFeature = doVar.f62370for;
        Bitmap bitmap = doVar.f57052if;
        if (faceFeature != null) {
            RectF faceBounds = faceFeature.getFaceBounds();
            float f = faceBounds.left;
            float f2 = faceBounds.top;
            bitmap = C3673for.m7419do(bitmap, (int) f, (int) f2, (int) (faceBounds.right - f), (int) (faceBounds.bottom - f2));
            if (bitmap == null) {
                throw new IllegalStateException("Bitmap can not be null");
            }
        }
        return this.f57035b.mo43503do(bitmap);
    }

    /* renamed from: c */
    private void m43260c(C20863do doVar) {
        try {
            if (doVar.f62368case) {
                m43255a(doVar.f62372try);
            }
            this.f57036c.add(doVar);
            int size = this.f57036c.size();
            if (this.f57047n < size) {
                this.f57047n = size;
            }
            StringBuffer stringBuffer = this.f57049p;
            stringBuffer.append(" ");
            stringBuffer.append(size);
            StringBuilder sb = new StringBuilder();
            sb.append("queue size = ");
            sb.append(size);
        } catch (IllegalStateException unused) {
            IPLog.m43494w(f57034a, "Liveness Blur Detection Queue full");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m43258a(C20864const.C20865do doVar) {
        C20863do doVar2 = null;
        while (this.f57044k) {
            try {
                C20863do poll = this.f57036c.poll(1, TimeUnit.SECONDS);
                if (poll != null) {
                    boolean z = poll.f62372try < this.f57041h.get();
                    if (poll.f62369else == 1) {
                        m43257a(poll, doVar2, z);
                    } else if (!z) {
                        m43261d(poll);
                    }
                    doVar2 = poll;
                }
            } catch (InterruptedException e) {
                doVar.mo171470do(e);
                return;
            } catch (IllegalStateException e2) {
                doVar.mo171470do(e2);
                return;
            }
        }
        this.f57037d = null;
    }

    /* renamed from: d */
    private void m43261d(C20863do doVar) {
        if (this.f57042i == null) {
            this.f57042i = Double.valueOf(m43259b(this.f57043j));
        }
        double b = m43259b(doVar);
        if (b > this.f57042i.doubleValue()) {
            this.f57043j = doVar;
            this.f57042i = Double.valueOf(b);
        }
    }

    /* renamed from: a */
    private void m43257a(C20863do doVar, C20863do doVar2, boolean z) {
        int i;
        if (this.f57043j != null) {
            if (doVar2 == null) {
                i = 0;
            } else {
                i = doVar2.f62369else - 1;
            }
            this.f57048o += i;
            this.f57050q.append(String.format(" %d", new Object[]{Integer.valueOf(i)}));
            m43256a(this.f57043j);
            this.f57043j = null;
        }
        if (z || doVar.f62368case) {
            this.f57050q.append(" 0");
            m43256a(doVar);
            if (doVar.f62368case) {
                String.format("Stats: device %s %s cpus[%d] frames %3d choices[%3d] %s (overrun %.2f)", new Object[]{Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Runtime.getRuntime().availableProcessors()), Integer.valueOf(this.f57045l), Integer.valueOf(this.f57048o), this.f57050q.toString(), Double.valueOf(((double) (System.nanoTime() - this.f57046m)) / 1.0E9d)});
                this.f57044k = false;
                return;
            }
            return;
        }
        this.f57043j = doVar;
        this.f57042i = null;
    }

    /* renamed from: a */
    public C3688do mo171460a(C21824for forR, Bitmap bitmap, FaceFeature faceFeature, RectF rectF, C3688do doVar, int i, int i2) {
        boolean z;
        int i3;
        int i4 = i;
        this.f57045l++;
        int i5 = this.f57040g + 1;
        this.f57040g = i5;
        boolean z2 = i5 > this.f57038e;
        if (i4 != this.f57039f) {
            i3 = i2;
            z = true;
        } else {
            i3 = i2;
            z = false;
        }
        boolean z3 = i4 == i3;
        if (z) {
            this.f57039f = i4;
            this.f57040g = 1;
            if (z3) {
                this.f57046m = System.nanoTime();
            }
            m43260c(new C20863do(forR, bitmap, faceFeature, rectF, doVar, i, z3, this.f57040g));
            if (z3) {
                return C3688do.END_FACE_PATH;
            }
            return C3688do.FACE_PATH;
        } else if (z2) {
            return doVar;
        } else {
            m43260c(new C20863do(forR, bitmap, faceFeature, rectF, doVar, i, z3, i5));
            return C3688do.FACE_PATH;
        }
    }

    /* renamed from: a */
    public void mo171461a() {
        this.f57044k = false;
    }
}
