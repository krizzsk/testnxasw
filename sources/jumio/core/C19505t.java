package jumio.core;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.t */
/* compiled from: DrawView.kt */
public final class C19505t extends RelativeLayout {

    /* renamed from: a */
    public C19506a f55405a;

    /* renamed from: jumio.core.t$a */
    /* compiled from: DrawView.kt */
    public interface C19506a {
        /* renamed from: a */
        void mo148736a(int i, int i2);

        /* renamed from: a */
        void mo148737a(Canvas canvas);

        /* renamed from: a */
        void mo148738a(ViewGroup viewGroup);
    }

    public C19505t(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        C19506a aVar = this.f55405a;
        if (aVar != null) {
            aVar.mo148737a(canvas);
        }
    }

    public void onMeasure(int i, int i2) {
        C19506a aVar;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0 && (aVar = this.f55405a) != null) {
            aVar.mo148736a(measuredWidth, measuredHeight);
        }
    }

    public final void setDrawViewInterface(C19506a aVar) {
        this.f55405a = aVar;
        if (aVar != null) {
            aVar.mo148738a((ViewGroup) this);
        }
    }
}
