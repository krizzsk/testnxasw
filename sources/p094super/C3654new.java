package p094super;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import com.didi.raven.config.RavenKey;
import com.iproov.sdk.cameray.C20759const;
import com.iproov.sdk.cameray.C20776try;
import com.iproov.sdk.face.model.FaceFeature;
import p094super.C3650for;
import p098try.C3688do;
import p098try.C3690if;
import p235do.C21825goto;
import p235do.C21828this;

/* renamed from: super.new */
/* compiled from: LightingDetectorImpl */
public class C3654new implements C3650for {

    /* renamed from: a */
    private final C3650for.C3651do f8721a;

    /* renamed from: b */
    private final C3656try f8722b;

    /* renamed from: c */
    private final C20759const f8723c;

    /* renamed from: d */
    private Bitmap f8724d;

    /* renamed from: e */
    private boolean f8725e = false;

    /* renamed from: f */
    private boolean f8726f = false;

    /* renamed from: g */
    private long f8727g = 0;

    public C3654new(Context context, C20776try tryR, C3649else elseR, C3650for.C3651do doVar, C21825goto gotoR) {
        this.f8722b = new C3656try(context, elseR, gotoR);
        this.f8723c = tryR.mo171306if();
        this.f8721a = doVar;
        StringBuilder sb = new StringBuilder();
        sb.append("Started lighting detector for ");
        sb.append(tryR.mo171306if());
    }

    /* renamed from: a */
    private boolean m7340a() {
        return this.f8723c == C20759const.CAMERA1;
    }

    /* renamed from: b */
    private void m7342b() {
        this.f8722b.mo43488e();
    }

    /* renamed from: do */
    public void mo43465do(C21828this thisR) {
        this.f8722b.mo43478a(thisR);
    }

    /* renamed from: for  reason: not valid java name */
    public C3690if.C3697if m46664for(Bitmap bitmap, FaceFeature faceFeature) throws C3647case {
        long currentTimeMillis = System.currentTimeMillis() - this.f8727g;
        StringBuilder sb = new StringBuilder();
        sb.append("Legacy: FRAME ");
        sb.append(this.f8725e ? "LOCKED" : "UNLOCKED");
        sb.append(" for ");
        sb.append(((double) currentTimeMillis) / 1000.0d);
        sb.append(RavenKey.STACK);
        if (this.f8725e) {
            C3690if.C3697if ifVar = mo43474if(bitmap, faceFeature);
            if (faceFeature == null) {
                this.f8721a.mo43470do(false);
            } else if (m7341a(currentTimeMillis)) {
                this.f8726f = true;
                this.f8721a.mo43470do(false);
            }
            return ifVar;
        } else if (faceFeature == null && !this.f8726f && !m7343b(currentTimeMillis)) {
            return null;
        } else {
            this.f8726f = false;
            this.f8721a.mo43469do();
            return null;
        }
    }

    /* renamed from: if */
    public C3690if.C3697if mo43474if(Bitmap bitmap, FaceFeature faceFeature) throws C3647case {
        if (faceFeature == null) {
            this.f8722b.mo43479a((Double) null);
            this.f8722b.mo43481a((C3653if) null);
            this.f8724d = null;
        } else {
            RectF faceBounds = faceFeature.getFaceBounds();
            float f = faceBounds.right;
            float f2 = faceBounds.left;
            float f3 = f - f2;
            int i = (int) ((((double) f3) * 0.6d) / 2.0d);
            float f4 = faceBounds.bottom;
            float f5 = faceBounds.top;
            float f6 = f4 - f5;
            Bitmap bitmap2 = C3652goto.m7338do(bitmap, ((int) f2) + i, ((int) f5) + i, ((int) f3) - (i * 2), ((int) f6) - (((int) ((((double) f6) * 0.4d) / 2.0d)) * 2));
            this.f8724d = bitmap2;
            C3653if ifVar = new C3653if(bitmap2);
            this.f8722b.mo43479a(Double.valueOf(faceFeature.getNormalizedSize()));
            this.f8722b.mo43481a(ifVar);
        }
        C3655this a = this.f8722b.mo43477a(m7340a());
        mo43472do(a);
        C3688do doVar = C3688do.READY;
        if (faceFeature == null) {
            doVar = C3688do.NO_FACE;
        } else if (this.f8722b.mo43486c()) {
            doVar = C3688do.TOO_BRIGHT;
        } else if (this.f8722b.mo43484b()) {
            doVar = C3688do.TOO_FAR;
        } else if (this.f8722b.mo43482a()) {
            doVar = C3688do.TOO_CLOSE;
        }
        return new C3690if.C3697if(doVar, a);
    }

    /* renamed from: do */
    public void mo43464do(float f) {
        this.f8722b.mo43480a(Float.valueOf(f));
    }

    /* renamed from: do */
    public C3690if.C3697if mo43463do(Bitmap bitmap, FaceFeature faceFeature) throws C3647case {
        return m7340a() ? m46664for(bitmap, faceFeature) : mo43474if(bitmap, faceFeature);
    }

    /* renamed from: do */
    public void mo43466do(boolean z) {
        if (m7340a()) {
            this.f8725e = z;
            this.f8727g = System.currentTimeMillis();
            if (z) {
                m7342b();
            }
        }
    }

    /* renamed from: b */
    private boolean m7343b(long j) throws C3647case {
        return this.f8722b.mo43485b(j);
    }

    /* renamed from: do */
    public synchronized void mo43472do(C3655this thisR) {
        thisR.mo43476do("ld", Double.valueOf(this.f8723c == C20759const.CAMERA1 ? 0.0d : 1.0d));
    }

    /* renamed from: do */
    public String mo43462do() {
        return this.f8722b.mo43489f();
    }

    /* renamed from: for  reason: not valid java name */
    public final double m46663for() {
        return this.f8722b.mo43487d();
    }

    /* renamed from: a */
    private boolean m7341a(long j) throws C3647case {
        return this.f8722b.mo43483a(j);
    }

    /* renamed from: if */
    public Bitmap mo43468if() {
        return this.f8724d;
    }
}
