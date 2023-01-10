package p230const;

import android.graphics.Rect;
import p096this.C3683do;
import p235do.C21820break;

/* renamed from: const.do */
/* compiled from: CroppingParams */
public class C21727do {

    /* renamed from: a */
    private float f59064a = 1.0f;

    /* renamed from: b */
    private float f59065b = 1.0f;

    /* renamed from: c */
    private float f59066c = 0.5f;

    /* renamed from: d */
    private float f59067d = 0.5f;

    /* renamed from: a */
    private int m44655a() {
        return C3683do.m7486if();
    }

    /* renamed from: case  reason: not valid java name */
    public float m48204case() {
        return this.f59065b;
    }

    /* renamed from: do */
    public float mo178970do() {
        return this.f59066c;
    }

    /* renamed from: for  reason: not valid java name */
    public void m48205for(float f) {
        this.f59067d = f;
    }

    /* renamed from: if */
    public void mo178974if(float f) {
        this.f59066c = f;
    }

    /* renamed from: try  reason: not valid java name */
    public float m48206try() {
        return this.f59064a;
    }

    /* renamed from: b */
    private int m44657b() {
        return C3683do.m7484do();
    }

    /* renamed from: do */
    public void mo178971do(Rect rect, C21820break breakR) {
        m44656a(((float) breakR.mo180432do()) / ((float) rect.height()));
        float f = 0.0f;
        float f2 = 0.5f;
        if (((float) m44655a()) / ((float) m44657b()) < ((float) breakR.mo180435if()) / ((float) breakR.mo180432do())) {
            if (rect.left != 0) {
                f = rect.right == breakR.mo180435if() ? 1.0f : 0.5f;
            }
            float b = (((float) m44657b()) - (((((float) breakR.mo180432do()) * 1.0f) * ((float) m44655a())) / ((float) breakR.mo180435if()))) / (((float) m44657b()) * 2.0f);
            if (rect.top == 0) {
                f2 = 1.0f - b;
            } else if (rect.bottom == breakR.mo180432do()) {
                f2 = b;
            }
        } else {
            if (rect.top == 0) {
                f = 1.0f;
            } else if (rect.bottom != breakR.mo180432do()) {
                f = 0.5f;
            }
            float a = (((float) m44655a()) - (((((float) breakR.mo180435if()) * 1.0f) * ((float) m44657b())) / ((float) breakR.mo180432do()))) / (((float) m44655a()) * 2.0f);
            if (rect.left == 0) {
                f2 = f;
                f = a;
            } else if (rect.right == breakR.mo180435if()) {
                f2 = f;
                f = 1.0f - a;
            } else {
                f2 = f;
                f = 0.5f;
            }
        }
        m48205for(f2);
        mo178974if(f);
    }

    /* renamed from: if */
    public float mo178973if() {
        return this.f59067d;
    }

    /* renamed from: a */
    private void m44656a(float f) {
        this.f59064a = f;
        this.f59065b = f;
    }
}
