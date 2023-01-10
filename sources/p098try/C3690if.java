package p098try;

import com.iproov.sdk.core.C20871for;
import com.iproov.sdk.core.exception.IProovException;
import p094super.C3655this;
import p095switch.C3679throw;
import p098try.C3690if;
import p238for.C21839do;

/* renamed from: try.if */
/* compiled from: State */
public abstract class C3690if {

    /* renamed from: do */
    private String f8826do;

    /* renamed from: try.if$break */
    /* compiled from: State */
    public static final class C3691break extends C3690if {

        /* renamed from: for  reason: not valid java name */
        private final String f62332for;

        /* renamed from: if */
        private final double f8827if;

        public C3691break(double d, String str) {
            this.f8827if = d;
            this.f62332for = str;
        }

        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43565do(this);
        }

        /* renamed from: do */
        public boolean mo43550do() {
            return true;
        }

        /* renamed from: new  reason: not valid java name */
        public String m46686new() {
            return this.f62332for;
        }

        public String toString() {
            return C3690if.super.toString() + " (" + this.f8827if + " - " + this.f62332for + ")";
        }

        /* renamed from: try  reason: not valid java name */
        public double m46687try() {
            return this.f8827if;
        }
    }

    /* renamed from: try.if$case */
    /* compiled from: State */
    public static final class C3692case extends C3690if {

        /* renamed from: if */
        private final C20871for f8828if;

        public C3692case(C20871for forR) {
            this.f8828if = forR;
        }

        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43566do(this);
        }

        /* renamed from: if */
        public boolean mo43553if() {
            return true;
        }

        /* renamed from: new  reason: not valid java name */
        public C20871for m46688new() {
            return this.f8828if;
        }
    }

    /* renamed from: try.if$do */
    /* compiled from: State */
    public static final class C3693do extends C3690if {
        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43567do(this);
        }

        /* renamed from: if */
        public boolean mo43553if() {
            return true;
        }
    }

    /* renamed from: try.if$for */
    /* compiled from: State */
    public static final class C3695for extends C3690if {

        /* renamed from: if */
        private final String f8830if;

        public C3695for(String str) {
            this.f8830if = str;
        }

        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43569do(this);
        }

        /* renamed from: new  reason: not valid java name */
        public String m46693new() {
            return this.f8830if;
        }
    }

    /* renamed from: try.if$goto */
    /* compiled from: State */
    public static final class C3696goto extends C3690if {
    }

    /* renamed from: try.if$if */
    /* compiled from: State */
    public static final class C3697if extends C3690if {

        /* renamed from: for  reason: not valid java name */
        private final C3655this f62336for;

        /* renamed from: if */
        private final C3688do f8831if;

        public C3697if(C3688do doVar, C3655this thisR) {
            this.f8831if = doVar;
            this.f62336for = thisR;
        }

        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43570do(this);
        }

        /* renamed from: do */
        public boolean mo43550do() {
            return true;
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m46694for() {
            return this.f8831if == C3688do.READY;
        }

        /* renamed from: new  reason: not valid java name */
        public C3688do m46695new() {
            return this.f8831if;
        }

        public String toString() {
            return C3697if.class.getSimpleName() + " (" + this.f8831if + ")";
        }

        /* renamed from: try  reason: not valid java name */
        public C3655this m46696try() {
            return this.f62336for;
        }
    }

    /* renamed from: try.if$new */
    /* compiled from: State */
    public static final class C3698new extends C3690if {
        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43571do(this);
        }
    }

    /* renamed from: try.if$this */
    /* compiled from: State */
    public interface C3699this {
        /* renamed from: do */
        void mo43565do(C3691break breakR);

        /* renamed from: do */
        void mo43566do(C3692case caseR);

        /* renamed from: do */
        void mo43567do(C3693do doVar);

        /* renamed from: do */
        void mo43568do(C3694else elseR);

        /* renamed from: do */
        void mo43569do(C3695for forR);

        /* renamed from: do */
        void mo43570do(C3697if ifVar);

        /* renamed from: do */
        void mo43571do(C3698new newR);

        /* renamed from: do */
        void mo43572do(C3700try tryR);

        /* renamed from: do */
        void mo43573do(C3690if ifVar);
    }

    /* renamed from: try.if$try */
    /* compiled from: State */
    public static final class C3700try extends C3690if {

        /* renamed from: if */
        private final IProovException f8832if;

        public C3700try(IProovException iProovException) {
            this.f8832if = iProovException;
        }

        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43572do(this);
        }

        /* renamed from: if */
        public boolean mo43553if() {
            return true;
        }

        /* renamed from: new  reason: not valid java name */
        public IProovException m46697new() {
            return this.f8832if;
        }

        public String toString() {
            return C3690if.super.toString() + " - " + this.f8832if.getReason() + " - " + this.f8832if.getMessage();
        }
    }

    /* renamed from: do */
    public void m46684for(C3699this thisR) {
        thisR.mo43573do(this);
    }

    /* renamed from: do */
    public boolean mo43550do() {
        return false;
    }

    /* renamed from: for  reason: not valid java name */
    public boolean m46685for() {
        return false;
    }

    /* renamed from: if */
    public final void mo43552if(C3699this thisR) {
        C3679throw.m7442do((Runnable) new Runnable(thisR) {
            public final /* synthetic */ C3690if.C3699this f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                C3690if.this.m46684for(this.f$1);
            }
        });
    }

    /* renamed from: if */
    public boolean mo43553if() {
        return false;
    }

    public String toString() {
        if (this.f8826do == null) {
            this.f8826do = getClass().getSimpleName();
        }
        return this.f8826do;
    }

    /* renamed from: try.if$else */
    /* compiled from: State */
    public static final class C3694else extends C3690if {

        /* renamed from: for  reason: not valid java name */
        private final int f62333for;

        /* renamed from: if */
        private final C21839do f8829if;

        /* renamed from: new  reason: not valid java name */
        private final float f62334new;

        /* renamed from: try  reason: not valid java name */
        private final C3655this f62335try;

        public C3694else(C21839do doVar, int i, float f, float f2) {
            this.f8829if = doVar;
            this.f62333for = i;
            this.f62334new = f2;
            this.f62335try = null;
        }

        /* renamed from: case  reason: not valid java name */
        public float m46689case() {
            return this.f62334new;
        }

        /* renamed from: do */
        public void mo43549do(C3699this thisR) {
            C3690if.super.m46684for(thisR);
            thisR.mo43568do(this);
        }

        /* renamed from: do */
        public boolean mo43550do() {
            return true;
        }

        /* renamed from: else  reason: not valid java name */
        public boolean m46690else() {
            return this.f8829if == null;
        }

        /* renamed from: new  reason: not valid java name */
        public int m46691new() {
            return this.f62333for;
        }

        public String toString() {
            return C3690if.super.toString() + " (" + this.f8829if + ")";
        }

        /* renamed from: try  reason: not valid java name */
        public C3655this m46692try() {
            return this.f62335try;
        }

        public C3694else(C3655this thisR) {
            this.f8829if = null;
            this.f62333for = 0;
            this.f62334new = 0.0f;
            this.f62335try = thisR;
        }
    }
}
