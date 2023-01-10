package rui.internal.loopview;

import android.os.Handler;
import android.os.Message;
import rui.internal.loopview.LoopView;

/* renamed from: rui.internal.loopview.c */
/* compiled from: MessageHandler */
final class C3571c extends Handler {

    /* renamed from: a */
    public static final int f8647a = 1000;

    /* renamed from: b */
    public static final int f8648b = 2000;

    /* renamed from: c */
    public static final int f8649c = 3000;

    /* renamed from: d */
    private final LoopView f8650d;

    C3571c(LoopView loopView) {
        this.f8650d = loopView;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.f8650d.invalidate();
        } else if (i == 2000) {
            this.f8650d.mo43346a(LoopView.ACTION.FLING);
        } else if (i == 3000) {
            this.f8650d.onItemSelected();
        }
    }
}
