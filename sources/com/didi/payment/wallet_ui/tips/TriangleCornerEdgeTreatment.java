package com.didi.payment.wallet_ui.tips;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/tips/TriangleCornerEdgeTreatment;", "Lcom/google/android/material/shape/EdgeTreatment;", "width", "", "height", "corner", "(III)V", "getEdgePath", "", "length", "", "center", "interpolation", "shapePath", "Lcom/google/android/material/shape/ShapePath;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TriangleCornerEdgeTreatment.kt */
public final class TriangleCornerEdgeTreatment extends EdgeTreatment {

    /* renamed from: a */
    private final int f35720a;

    /* renamed from: b */
    private final int f35721b;

    /* renamed from: c */
    private final int f35722c;

    public TriangleCornerEdgeTreatment(int i, int i2, int i3) {
        this.f35720a = i;
        this.f35721b = i2;
        this.f35722c = i3;
    }

    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        Intrinsics.checkNotNullParameter(shapePath, "shapePath");
        int i = this.f35722c / 2;
        float f4 = ((float) (-(this.f35721b - i))) * f3;
        float f5 = ((float) (this.f35720a / 2)) * f3;
        shapePath.lineTo(f2 - f5, 0.0f);
        float f6 = ((float) i) * f3;
        shapePath.lineTo(f2 - f6, f4);
        shapePath.quadToPoint(f2, f4, f6 + f2, f4);
        shapePath.lineTo(f2 + f5, 0.0f);
        shapePath.lineTo(f, 0.0f);
    }
}
