package com.didi.entrega.order.component;

import com.didi.entrega.customer.map.listener.MapGestureListener;
import com.didi.entrega.order.component.Contract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/entrega/order/component/DefaultMapGestureListener;", "Lcom/didi/entrega/customer/map/listener/MapGestureListener;", "presenter", "Lcom/didi/entrega/order/component/Contract$AbsMapPresenter;", "(Lcom/didi/entrega/order/component/Contract$AbsMapPresenter;)V", "mDownX", "", "mDownY", "getPresenter", "()Lcom/didi/entrega/order/component/Contract$AbsMapPresenter;", "setPresenter", "onDown", "", "x", "y", "onScroll", "onUp", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DefaultMapGestureListener.kt */
public final class DefaultMapGestureListener extends MapGestureListener {

    /* renamed from: a */
    private Contract.AbsMapPresenter f22680a;

    /* renamed from: b */
    private float f22681b;

    /* renamed from: c */
    private float f22682c;

    public DefaultMapGestureListener(Contract.AbsMapPresenter absMapPresenter) {
        Intrinsics.checkNotNullParameter(absMapPresenter, "presenter");
        this.f22680a = absMapPresenter;
    }

    public final Contract.AbsMapPresenter getPresenter() {
        return this.f22680a;
    }

    public final void setPresenter(Contract.AbsMapPresenter absMapPresenter) {
        Intrinsics.checkNotNullParameter(absMapPresenter, "<set-?>");
        this.f22680a = absMapPresenter;
    }

    public boolean onScroll(float f, float f2) {
        this.f22680a.setDraggedMap(true);
        return super.onScroll(f, f2);
    }

    public boolean onDown(float f, float f2) {
        this.f22681b = f;
        this.f22682c = f2;
        return super.onDown(f, f2);
    }

    public boolean onUp(float f, float f2) {
        if (Math.abs(f - this.f22681b) > 0.0f || Math.abs(f2 - this.f22682c) > 0.0f) {
            this.f22680a.setDraggedMap(true);
        }
        return super.onUp(f, f2);
    }
}
