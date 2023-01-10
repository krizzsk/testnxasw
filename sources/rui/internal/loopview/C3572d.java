package rui.internal.loopview;

/* renamed from: rui.internal.loopview.d */
/* compiled from: OnItemSelectedRunnable */
final class C3572d implements Runnable {

    /* renamed from: a */
    final LoopView f8651a;

    C3572d(LoopView loopView) {
        this.f8651a = loopView;
    }

    public final void run() {
        this.f8651a.f8633o.onItemSelected(this.f8651a.getSelectedItemPosition());
    }
}
