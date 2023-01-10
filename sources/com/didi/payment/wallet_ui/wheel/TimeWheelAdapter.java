package com.didi.payment.wallet_ui.wheel;

import com.contrarywind.adapter.WheelAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/TimeWheelAdapter;", "Lcom/contrarywind/adapter/WheelAdapter;", "", "type", "", "start", "end", "adapter", "Lcom/didi/payment/wallet_ui/wheel/TimeItemAdapter;", "(IIILcom/didi/payment/wallet_ui/wheel/TimeItemAdapter;)V", "getEnd", "()I", "getStart", "getItem", "index", "getItemsCount", "indexOf", "item", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TimeWheelAdapter.kt */
public final class TimeWheelAdapter implements WheelAdapter<Object> {

    /* renamed from: a */
    private final int f35757a;

    /* renamed from: b */
    private final int f35758b;

    /* renamed from: c */
    private final int f35759c;

    /* renamed from: d */
    private final TimeItemAdapter f35760d;

    public int indexOf(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "item");
        return -1;
    }

    public TimeWheelAdapter(int i, int i2, int i3, TimeItemAdapter timeItemAdapter) {
        this.f35757a = i;
        this.f35758b = i2;
        this.f35759c = i3;
        this.f35760d = timeItemAdapter;
    }

    public final int getStart() {
        return this.f35758b;
    }

    public final int getEnd() {
        return this.f35759c;
    }

    public int getItemsCount() {
        return (this.f35759c - this.f35758b) + 1;
    }

    public Object getItem(int i) {
        TimeItemAdapter timeItemAdapter = this.f35760d;
        boolean z = true;
        if (timeItemAdapter == null) {
            if (i < 0 || i >= getItemsCount()) {
                z = false;
            }
            int i2 = this.f35758b;
            if (z) {
                i2 += i;
            }
            return Integer.valueOf(i2);
        }
        String onGetItem = timeItemAdapter.onGetItem(this.f35757a, this.f35758b + i);
        if (onGetItem != null) {
            return onGetItem;
        }
        if (i < 0 || i >= getItemsCount()) {
            z = false;
        }
        int i3 = this.f35758b;
        if (z) {
            i3 += i;
        }
        return Integer.valueOf(i3);
    }
}
