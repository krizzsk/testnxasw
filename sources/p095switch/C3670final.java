package p095switch;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: switch.final */
/* compiled from: UITimer */
public class C3670final {

    /* renamed from: a */
    private Timer f8785a;

    /* renamed from: switch.final$do */
    /* compiled from: UITimer */
    class C3671do extends TimerTask {

        /* renamed from: do */
        final /* synthetic */ Runnable f8786do;

        C3671do(C3670final finalR, Runnable runnable) {
            this.f8786do = runnable;
        }

        public void run() {
            C3679throw.m7442do(this.f8786do);
        }
    }

    /* renamed from: switch.final$if */
    /* compiled from: UITimer */
    class C3672if extends TimerTask {

        /* renamed from: do */
        final /* synthetic */ Runnable f8787do;

        C3672if(C3670final finalR, Runnable runnable) {
            this.f8787do = runnable;
        }

        public void run() {
            C3679throw.m7442do(this.f8787do);
        }
    }

    public C3670final(long j, boolean z, Runnable runnable) {
        Timer timer = new Timer();
        this.f8785a = timer;
        if (z) {
            timer.schedule(new C3671do(this, runnable), j, j);
        } else {
            timer.schedule(new C3672if(this, runnable), j);
        }
    }

    /* renamed from: do */
    public void mo43498do() {
        this.f8785a.cancel();
    }
}
