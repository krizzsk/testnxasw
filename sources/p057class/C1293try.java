package p057class;

import android.opengl.GLES20;
import java.util.ArrayList;
import p096this.C3683do;
import p096this.C3684for;

/* renamed from: class.try */
/* compiled from: GroupFilter */
public class C1293try extends C3683do {

    /* renamed from: h */
    private ArrayList<C1286do> f517h = new ArrayList<>();

    /* renamed from: i */
    private C3684for f518i;

    /* renamed from: j */
    private C3684for f519j;

    public C1293try(float[] fArr) {
        super(fArr);
    }

    /* renamed from: a */
    private void m1016a(int i, int i2) {
        C3684for forR = this.f518i;
        if (!(forR != null && forR.m46676for() == i2 && this.f518i.m46678try() == i)) {
            this.f518i = new C3684for(i, i2, 33988);
        }
        C3684for forR2 = this.f519j;
        if (forR2 == null || forR2.m46676for() != i2 || this.f519j.m46678try() != i) {
            this.f519j = new C3684for(i, i2, 33989);
        }
    }

    /* renamed from: do */
    public void mo14164do(C1286do doVar) {
        this.f517h.add(doVar);
    }

    /* renamed from: do */
    public void mo14163do(int i, int i2, int i3) {
        int i4;
        m1016a(i2, i3);
        C3684for forR = null;
        for (int i5 = 0; i5 < this.f517h.size(); i5++) {
            if (i5 == 0) {
                forR = this.f518i;
                i4 = i;
            } else {
                C3684for forR2 = this.f518i;
                if (forR == forR2) {
                    forR = this.f519j;
                    i4 = forR2.m46677new();
                } else {
                    i4 = this.f519j.m46677new();
                    forR = forR2;
                }
            }
            C1286do doVar = this.f517h.get(i5);
            if (i5 == this.f517h.size() - 1) {
                m1017a(doVar, i2, i3, i4);
                return;
            }
            if (!doVar.mo14155if()) {
                m1019a(doVar, i2, i3, i4, forR);
            } else {
                m1018a(doVar, i2, i3, i4, i, forR);
            }
        }
    }

    /* renamed from: a */
    private void m1019a(C1286do doVar, int i, int i2, int i3, C3684for forR) {
        mo43519do(doVar.mo14156do(), new int[]{i, i2}, new int[]{i3}, new int[][]{new int[]{i, i2}, new int[]{i, i2}});
        doVar.m46090for();
        forR.mo43524do();
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        forR.m46675case();
        GLES20.glClear(16384);
    }

    /* renamed from: a */
    private void m1018a(C1286do doVar, int i, int i2, int i3, int i4, C3684for forR) {
        mo43519do(doVar.mo14156do(), new int[]{i, i2}, new int[]{i3, i4}, new int[][]{new int[]{i, i2}, new int[]{i, i2}});
        doVar.m46090for();
        forR.mo43524do();
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        forR.m46675case();
        GLES20.glClear(16384);
    }

    /* renamed from: a */
    private void m1017a(C1286do doVar, int i, int i2, int i3) {
        mo43519do(doVar.mo14156do(), new int[]{i, i2}, new int[]{i3}, new int[][]{new int[]{i, i2}, new int[]{i, i2}});
        doVar.m46090for();
        GLES20.glDrawArrays(5, 0, 4);
    }
}
