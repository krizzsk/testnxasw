package jumio.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.didi.passenger.C11267R;
import com.jumio.commons.log.Log;
import com.jumio.sdk.scanpart.JumioScanPart;
import jumio.core.C19479h;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.core.i */
/* compiled from: CheckView.kt */
public abstract class C19481i<I extends C19479h> extends RelativeLayout {

    /* renamed from: a */
    public int f55357a;

    /* renamed from: b */
    public I f55358b;

    public C19481i(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
    }

    public C19481i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
    }

    public C19481i(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C19481i(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* renamed from: a */
    public final void mo148635a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = 0;
            TypedArray obtainStyledAttributes = context == null ? null : context.obtainStyledAttributes(attributeSet, C11267R.styleable.CheckView, 0, 0);
            if (obtainStyledAttributes != null) {
                try {
                    i = obtainStyledAttributes.getDimensionPixelSize(0, 0);
                } catch (Throwable th) {
                    if (obtainStyledAttributes != null) {
                        obtainStyledAttributes.recycle();
                    }
                    throw th;
                }
            }
            this.f55357a = i;
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void attach(JumioScanPart jumioScanPart) {
        Intrinsics.checkNotNullParameter(jumioScanPart, "scanPart");
        try {
            I i = (C19479h) jumioScanPart.getScanPart$jumio_core_release();
            this.f55358b = i;
            if (i != null) {
                i.mo148630a(this);
            }
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
    }

    public final void detach$jumio_core_release() {
        this.f55358b = null;
    }

    public final I getCheckInterface() {
        return this.f55358b;
    }

    public final int getCornerRadius$jumio_core_release() {
        return this.f55357a;
    }

    public final void setCheckInterface(I i) {
        this.f55358b = i;
    }

    public final void setCornerRadius$jumio_core_release(int i) {
        this.f55357a = i;
    }

    public C19481i(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f55357a = i2;
        mo148635a(context, attributeSet);
    }
}
