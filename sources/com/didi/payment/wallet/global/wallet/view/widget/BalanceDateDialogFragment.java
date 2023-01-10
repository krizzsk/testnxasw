package com.didi.payment.wallet.global.wallet.view.widget;

import android.view.View;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.contrarywind.view.WheelView;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.p074io.IOUtils;

@Metadata(mo148867d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0011\u001a\u00020\u000b2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\bJ\b\u0010\u0013\u001a\u00020\u0005H\u0014J\b\u0010\u0014\u001a\u00020\u000bH\u0014J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/widget/BalanceDateDialogFragment;", "Lcom/didi/sdk/view/SimplePopupBase;", "()V", "monthList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "timeListener", "Lkotlin/Function2;", "", "", "", "getTimeListener", "()Lkotlin/jvm/functions/Function2;", "setTimeListener", "(Lkotlin/jvm/functions/Function2;)V", "yearList", "addOnSelectListener", "time", "getLayout", "initView", "setSelectedCalendar", "year", "mCalendar", "Ljava/util/Calendar;", "Companion", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BalanceDateDialogFragment.kt */
public final class BalanceDateDialogFragment extends SimplePopupBase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f35369d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f35370e = -1;

    /* renamed from: a */
    private final ArrayList<Integer> f35371a = CollectionsKt.arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

    /* renamed from: b */
    private final ArrayList<Integer> f35372b = new ArrayList<>();

    /* renamed from: c */
    private Function2<? super Long, ? super String, Unit> f35373c;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_dialog_balance_date;
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/widget/BalanceDateDialogFragment$Companion;", "", "()V", "mYearIndex", "", "getMYearIndex", "()I", "setMYearIndex", "(I)V", "monthIndex", "getMonthIndex", "setMonthIndex", "init", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: BalanceDateDialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getMYearIndex() {
            return BalanceDateDialogFragment.f35369d;
        }

        public final void setMYearIndex(int i) {
            BalanceDateDialogFragment.f35369d = i;
        }

        public final int getMonthIndex() {
            return BalanceDateDialogFragment.f35370e;
        }

        public final void setMonthIndex(int i) {
            BalanceDateDialogFragment.f35370e = i;
        }

        public final void init() {
            setMYearIndex(-1);
            setMonthIndex(-1);
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        int i;
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        View findViewById = this.mRootView.findViewById(R.id.wheelView1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.wheelView1)");
        WheelView wheelView = (WheelView) findViewById;
        View findViewById2 = this.mRootView.findViewById(R.id.wheelView2);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.wheelView2)");
        WheelView wheelView2 = (WheelView) findViewById2;
        View findViewById3 = this.mRootView.findViewById(R.id.btn_balance_date);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.btn_balance_date)");
        View findViewById4 = this.mRootView.findViewById(R.id.btn_closeImg);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.btn_closeImg)");
        wheelView.setItemsVisibleCount(5);
        wheelView2.setItemsVisibleCount(5);
        wheelView.setCyclic(false);
        wheelView.setAdapter(new ArrayWheelAdapter(this.f35371a));
        if (f35370e == -1) {
            f35370e = instance.get(2);
        }
        if (f35370e < this.f35371a.size() && (i = f35370e) >= 0) {
            wheelView.setCurrentItem(i);
        }
        wheelView.setOnItemSelectedListener($$Lambda$BalanceDateDialogFragment$4Bc05r8tKer8Q5lPMZ4rU6FIcG4.INSTANCE);
        int i2 = instance.get(1);
        this.f35372b.clear();
        int i3 = 3;
        while (true) {
            int i4 = i3 - 1;
            this.f35372b.add(Integer.valueOf(i2 - i3));
            if (i4 < 0) {
                break;
            }
            i3 = i4;
        }
        wheelView2.setCyclic(false);
        wheelView2.setAdapter(new ArrayWheelAdapter(this.f35372b));
        if (f35369d == -1 && this.f35372b.size() > 0) {
            f35369d = this.f35372b.size() - 1;
        }
        int i5 = f35369d;
        if (i5 >= 0) {
            wheelView2.setCurrentItem(i5);
        }
        wheelView2.setOnItemSelectedListener($$Lambda$BalanceDateDialogFragment$IYwiqXbM93WBlIUiO2kDm2ePbHw.INSTANCE);
        findViewById3.setOnClickListener(new View.OnClickListener(instance) {
            public final /* synthetic */ Calendar f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BalanceDateDialogFragment.m26850a(BalanceDateDialogFragment.this, this.f$1, view);
            }
        });
        findViewById4.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BalanceDateDialogFragment.m26849a(BalanceDateDialogFragment.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26848a(int i) {
        f35370e = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26851b(int i) {
        f35369d = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26850a(BalanceDateDialogFragment balanceDateDialogFragment, Calendar calendar, View view) {
        Intrinsics.checkNotNullParameter(balanceDateDialogFragment, "this$0");
        Intrinsics.checkNotNullParameter(calendar, "$mCalendar");
        if (f35369d < balanceDateDialogFragment.f35372b.size()) {
            Integer num = balanceDateDialogFragment.f35372b.get(f35369d);
            Intrinsics.checkNotNullExpressionValue(num, "it");
            int a = balanceDateDialogFragment.m26847a(num.intValue(), calendar);
            if (calendar.getTimeInMillis() > Calendar.getInstance().getTime().getTime()) {
                f35370e = Calendar.getInstance().get(2);
                a = balanceDateDialogFragment.m26847a(num.intValue(), calendar);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(a);
            sb.append(IOUtils.DIR_SEPARATOR_UNIX);
            sb.append(num.intValue());
            String sb2 = sb.toString();
            Function2<Long, String, Unit> timeListener = balanceDateDialogFragment.getTimeListener();
            if (timeListener != null) {
                Long valueOf = Long.valueOf(calendar.getTimeInMillis());
                if (sb2.length() == 6) {
                    sb2 = Intrinsics.stringPlus("0", sb2);
                }
                timeListener.invoke(valueOf, sb2);
            }
        }
        balanceDateDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26849a(BalanceDateDialogFragment balanceDateDialogFragment, View view) {
        Intrinsics.checkNotNullParameter(balanceDateDialogFragment, "this$0");
        balanceDateDialogFragment.dismiss();
    }

    /* renamed from: a */
    private final int m26847a(int i, Calendar calendar) {
        Integer num = this.f35371a.get(f35370e);
        Intrinsics.checkNotNullExpressionValue(num, "monthList[monthIndex]");
        int intValue = num.intValue();
        int i2 = intValue - 1;
        calendar.set(i, i2, 1);
        calendar.set(i, i2, calendar.getActualMaximum(5), 23, 59);
        calendar.set(13, 59);
        calendar.set(14, 999);
        return intValue;
    }

    public final Function2<Long, String, Unit> getTimeListener() {
        return this.f35373c;
    }

    public final void setTimeListener(Function2<? super Long, ? super String, Unit> function2) {
        this.f35373c = function2;
    }

    public final void addOnSelectListener(Function2<? super Long, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "time");
        this.f35373c = function2;
    }
}
