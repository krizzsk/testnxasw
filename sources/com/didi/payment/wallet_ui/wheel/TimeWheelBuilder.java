package com.didi.payment.wallet_ui.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(mo148867d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 a2\u00020\u0001:\u0002abB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020NJ\u001a\u0010O\u001a\u00020P2\b\u0010Q\u001a\u0004\u0018\u00010\u00142\u0006\u0010R\u001a\u00020LH\u0002J\u0018\u0010S\u001a\u0002092\u0006\u0010T\u001a\u00020#2\u0006\u0010U\u001a\u000209H\u0002J\u0018\u0010V\u001a\u0002092\u0006\u0010T\u001a\u00020#2\u0006\u0010U\u001a\u000209H\u0002J\u0018\u0010W\u001a\u0002092\u0006\u0010T\u001a\u00020#2\u0006\u0010U\u001a\u000209H\u0002J \u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u00020J2\u0006\u0010Q\u001a\u0002092\u0006\u0010U\u001a\u000209H\u0002J\u0018\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u0002092\u0006\u0010T\u001a\u00020#H\u0002J \u0010\\\u001a\u00020P2\u0006\u0010T\u001a\u00020#2\u0006\u0010U\u001a\u0002092\u0006\u0010]\u001a\u000209H\u0002J.\u0010^\u001a\u00020P2\u0006\u0010Y\u001a\u00020J2\u0006\u0010Q\u001a\u0002092\u0006\u0010U\u001a\u0002092\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00010`H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010\"\u001a\n $*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0016\u00107\u001a\n $*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010:\u001a\n $*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010;\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010(\"\u0004\b=\u0010*R\u001a\u0010>\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00104\"\u0004\b@\u00106R\u0016\u0010A\u001a\n $*\u0004\u0018\u00010#0#X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010B\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010(\"\u0004\bD\u0010*R\u001c\u0010E\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u000f\"\u0004\bG\u0010\u0011R\u001a\u0010H\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020J0IX\u0004¢\u0006\u0002\n\u0000¨\u0006c"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/TimeWheelBuilder;", "", "()V", "cancelClick", "Lcom/didi/payment/wallet_ui/wheel/OnTimeWheelClick;", "getCancelClick", "()Lcom/didi/payment/wallet_ui/wheel/OnTimeWheelClick;", "setCancelClick", "(Lcom/didi/payment/wallet_ui/wheel/OnTimeWheelClick;)V", "confirmClick", "getConfirmClick", "setConfirmClick", "confirmText", "", "getConfirmText", "()Ljava/lang/CharSequence;", "setConfirmText", "(Ljava/lang/CharSequence;)V", "dateTypeList", "", "Lcom/didi/payment/wallet_ui/wheel/TimeWheelBuilder$TimeType;", "getDateTypeList", "()Ljava/util/List;", "setDateTypeList", "(Ljava/util/List;)V", "deleteText", "getDeleteText", "setDeleteText", "dialog", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "getDialog", "()Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "setDialog", "(Lcom/didi/payment/wallet_ui/dialog/WalletDialog;)V", "endCalendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "endDate", "Ljava/util/Date;", "getEndDate", "()Ljava/util/Date;", "setEndDate", "(Ljava/util/Date;)V", "itemAdapter", "Lcom/didi/payment/wallet_ui/wheel/TimeItemAdapter;", "getItemAdapter", "()Lcom/didi/payment/wallet_ui/wheel/TimeItemAdapter;", "setItemAdapter", "(Lcom/didi/payment/wallet_ui/wheel/TimeItemAdapter;)V", "keepLastSelected", "", "getKeepLastSelected", "()Z", "setKeepLastSelected", "(Z)V", "resultCalendar", "selectType", "", "selectedCalendar", "selectedDate", "getSelectedDate", "setSelectedDate", "showDelete", "getShowDelete", "setShowDelete", "startCalendar", "startDate", "getStartDate", "setStartDate", "title", "getTitle", "setTitle", "viewMap", "", "Lcom/contrarywind/view/WheelView;", "build", "Lcom/didi/payment/wallet_ui/wheel/WalletWheel;", "context", "Landroid/content/Context;", "configWheelItem", "", "dateType", "walletWheel", "getCalendarShowMaxValue", "calendar", "calendarType", "getCalendarShowMinValue", "getCalendarShowValue", "initWheelView", "wheelView", "isLimitTime", "type", "setCalendarValue", "value", "setOnItemSelectedListener", "adapter", "Lcom/contrarywind/adapter/WheelAdapter;", "Companion", "TimeType", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TimeWheelBuilder.kt */
public final class TimeWheelBuilder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DAY = 3;
    public static final int HOUR = 4;
    public static final int MINUTE = 5;
    public static final int MONTH = 2;
    public static final int SELECT_TYPE_END = 3;
    public static final int SELECT_TYPE_MID = 2;
    public static final int SELECT_TYPE_START = 1;
    public static final int YEAR = 1;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public static final Map<Integer, Integer> f35761t = MapsKt.mapOf(TuplesKt.m41339to(1, 1), TuplesKt.m41339to(2, 2), TuplesKt.m41339to(3, 5), TuplesKt.m41339to(4, 11), TuplesKt.m41339to(5, 12));

    /* renamed from: a */
    private int f35762a = 1;

    /* renamed from: b */
    private final Calendar f35763b = Calendar.getInstance();

    /* renamed from: c */
    private final Calendar f35764c = Calendar.getInstance();

    /* renamed from: d */
    private final Calendar f35765d = Calendar.getInstance();

    /* renamed from: e */
    private final Calendar f35766e = Calendar.getInstance();

    /* renamed from: f */
    private final Map<Integer, WheelView> f35767f = new LinkedHashMap();

    /* renamed from: g */
    private WalletDialog f35768g;

    /* renamed from: h */
    private List<TimeType> f35769h;

    /* renamed from: i */
    private TimeItemAdapter f35770i;

    /* renamed from: j */
    private Date f35771j;

    /* renamed from: k */
    private Date f35772k;

    /* renamed from: l */
    private Date f35773l;

    /* renamed from: m */
    private boolean f35774m;

    /* renamed from: n */
    private boolean f35775n;

    /* renamed from: o */
    private CharSequence f35776o;

    /* renamed from: p */
    private OnTimeWheelClick f35777p;

    /* renamed from: q */
    private CharSequence f35778q;

    /* renamed from: r */
    private OnTimeWheelClick f35779r;

    /* renamed from: s */
    private CharSequence f35780s;

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/TimeWheelBuilder$TimeType;", "", "type", "", "(I)V", "getType", "()I", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TimeWheelBuilder.kt */
    public static final class TimeType {
        private final int type;

        public TimeType() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public TimeType(int i) {
            this.type = i;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TimeType(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1 : i);
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/TimeWheelBuilder$Companion;", "", "()V", "DAY", "", "HOUR", "MINUTE", "MONTH", "SELECT_TYPE_END", "SELECT_TYPE_MID", "SELECT_TYPE_START", "YEAR", "typeMap", "", "getTypeMap", "()Ljava/util/Map;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: TimeWheelBuilder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Integer, Integer> getTypeMap() {
            return TimeWheelBuilder.f35761t;
        }
    }

    public final WalletDialog getDialog() {
        return this.f35768g;
    }

    public final void setDialog(WalletDialog walletDialog) {
        this.f35768g = walletDialog;
    }

    public final List<TimeType> getDateTypeList() {
        return this.f35769h;
    }

    public final void setDateTypeList(List<TimeType> list) {
        this.f35769h = list;
    }

    public final TimeItemAdapter getItemAdapter() {
        return this.f35770i;
    }

    public final void setItemAdapter(TimeItemAdapter timeItemAdapter) {
        this.f35770i = timeItemAdapter;
    }

    public final Date getStartDate() {
        return this.f35771j;
    }

    public final void setStartDate(Date date) {
        this.f35771j = date;
    }

    public final Date getEndDate() {
        return this.f35772k;
    }

    public final void setEndDate(Date date) {
        this.f35772k = date;
    }

    public final Date getSelectedDate() {
        return this.f35773l;
    }

    public final void setSelectedDate(Date date) {
        this.f35773l = date;
    }

    public final boolean getKeepLastSelected() {
        return this.f35774m;
    }

    public final void setKeepLastSelected(boolean z) {
        this.f35774m = z;
    }

    public final boolean getShowDelete() {
        return this.f35775n;
    }

    public final void setShowDelete(boolean z) {
        this.f35775n = z;
    }

    public final CharSequence getDeleteText() {
        return this.f35776o;
    }

    public final void setDeleteText(CharSequence charSequence) {
        this.f35776o = charSequence;
    }

    public final OnTimeWheelClick getCancelClick() {
        return this.f35777p;
    }

    public final void setCancelClick(OnTimeWheelClick onTimeWheelClick) {
        this.f35777p = onTimeWheelClick;
    }

    public final CharSequence getConfirmText() {
        return this.f35778q;
    }

    public final void setConfirmText(CharSequence charSequence) {
        this.f35778q = charSequence;
    }

    public final OnTimeWheelClick getConfirmClick() {
        return this.f35779r;
    }

    public final void setConfirmClick(OnTimeWheelClick onTimeWheelClick) {
        this.f35779r = onTimeWheelClick;
    }

    public final CharSequence getTitle() {
        return this.f35780s;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f35780s = charSequence;
    }

    public final WalletWheel build(Context context) {
        Date date;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f35769h == null) {
            return null;
        }
        if (this.f35771j == null && this.f35772k == null) {
            Calendar instance = Calendar.getInstance();
            this.f35771j = instance.getTime();
            instance.add(1, 10);
            this.f35772k = instance.getTime();
        } else if (this.f35771j != null || (date = this.f35772k) == null) {
            Date date2 = this.f35771j;
            if (!(date2 == null || this.f35772k != null || date2 == null)) {
                Calendar instance2 = Calendar.getInstance();
                instance2.setTime(date2);
                instance2.add(1, 10);
                setEndDate(instance2.getTime());
            }
        } else if (date != null) {
            Calendar instance3 = Calendar.getInstance();
            instance3.setTime(date);
            instance3.add(1, -10);
            setStartDate(instance3.getTime());
        }
        List<TimeType> list = this.f35769h;
        Date date3 = this.f35771j;
        Date date4 = this.f35772k;
        if (list == null || date3 == null || date4 == null || date3.after(date4)) {
            return null;
        }
        Date date5 = this.f35773l;
        if (date5 == null || date5.before(date3)) {
            this.f35762a = 1;
            date5 = date3;
        } else if (date5.before(date4)) {
            this.f35762a = 2;
        } else {
            this.f35762a = 3;
            date5 = date4;
        }
        WalletWheel walletWheel = new WalletWheel(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        this.f35763b.setTime(date3);
        this.f35764c.setTime(date4);
        this.f35765d.setTime(date5);
        this.f35766e.setTime(date5);
        for (TimeType a : list) {
            m26932a(a, walletWheel);
        }
        walletWheel.configDelete(getShowDelete(), getDeleteText(), new View.OnClickListener() {
            public final void onClick(View view) {
                TimeWheelBuilder.m26934a(TimeWheelBuilder.this, view);
            }
        });
        walletWheel.configCancelClick(new View.OnClickListener() {
            public final void onClick(View view) {
                TimeWheelBuilder.m26938b(TimeWheelBuilder.this, view);
            }
        });
        walletWheel.configTitle(getTitle());
        walletWheel.configConfirm(getConfirmText(), new View.OnClickListener(this) {
            public final /* synthetic */ TimeWheelBuilder f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                TimeWheelBuilder.m26931a(OnTimeWheelClick.this, this.f$1, view);
            }
        });
        return walletWheel;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26934a(TimeWheelBuilder timeWheelBuilder, View view) {
        Intrinsics.checkNotNullParameter(timeWheelBuilder, "this$0");
        for (Map.Entry next : timeWheelBuilder.f35767f.entrySet()) {
            int intValue = ((Number) next.getKey()).intValue();
            WheelView wheelView = (WheelView) next.getValue();
            Integer num = f35761t.get(Integer.valueOf(intValue));
            if (num != null) {
                timeWheelBuilder.m26929a(wheelView, intValue, num.intValue());
                timeWheelBuilder.f35766e.setTime(timeWheelBuilder.f35765d.getTime());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m26938b(TimeWheelBuilder timeWheelBuilder, View view) {
        WalletDialog dialog;
        Intrinsics.checkNotNullParameter(timeWheelBuilder, "this$0");
        OnTimeWheelClick cancelClick = timeWheelBuilder.getCancelClick();
        boolean z = false;
        if (cancelClick != null && !cancelClick.onClick(timeWheelBuilder.f35766e.getTime())) {
            z = true;
        }
        if (!z && (dialog = timeWheelBuilder.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26931a(OnTimeWheelClick onTimeWheelClick, TimeWheelBuilder timeWheelBuilder, View view) {
        WalletDialog dialog;
        Intrinsics.checkNotNullParameter(timeWheelBuilder, "this$0");
        boolean z = false;
        if (onTimeWheelClick != null && !onTimeWheelClick.onClick(timeWheelBuilder.f35766e.getTime())) {
            z = true;
        }
        if (!z && (dialog = timeWheelBuilder.getDialog()) != null) {
            dialog.dismiss();
        }
    }

    /* renamed from: a */
    private final void m26932a(TimeType timeType, WalletWheel walletWheel) {
        Integer num;
        if (timeType != null && (num = f35761t.get(Integer.valueOf(timeType.getType()))) != null) {
            int intValue = num.intValue();
            WheelView addItem$default = WalletWheel.addItem$default(walletWheel, false, false, 3, (Object) null);
            this.f35767f.put(Integer.valueOf(timeType.getType()), addItem$default);
            m26929a(addItem$default, timeType.getType(), intValue);
            int type = timeType.getType();
            WheelAdapter adapter = addItem$default.getAdapter();
            Intrinsics.checkNotNullExpressionValue(adapter, "adapter");
            m26930a(addItem$default, type, intValue, adapter);
        }
    }

    /* renamed from: a */
    private final void m26929a(WheelView wheelView, int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i == 1) {
            Calendar calendar = this.f35763b;
            Intrinsics.checkNotNullExpressionValue(calendar, "startCalendar");
            i3 = m26928a(calendar, 1);
            Calendar calendar2 = this.f35764c;
            Intrinsics.checkNotNullExpressionValue(calendar2, "endCalendar");
            i4 = m26928a(calendar2, 1);
            Calendar calendar3 = this.f35765d;
            Intrinsics.checkNotNullExpressionValue(calendar3, "selectedCalendar");
            i5 = m26928a(calendar3, 1);
        } else {
            Calendar calendar4 = this.f35765d;
            Intrinsics.checkNotNullExpressionValue(calendar4, "selectedCalendar");
            i4 = m26928a(calendar4, i2);
            Calendar calendar5 = this.f35765d;
            Intrinsics.checkNotNullExpressionValue(calendar5, "selectedCalendar");
            int b = m26937b(calendar5, i2);
            Calendar calendar6 = this.f35765d;
            Intrinsics.checkNotNullExpressionValue(calendar6, "selectedCalendar");
            i3 = m26939c(calendar6, i2);
            int i6 = this.f35762a;
            if (i6 == 1) {
                i3 = i4;
                i5 = i3;
            } else if (i6 != 3) {
                i5 = i4;
            } else {
                i5 = i4;
            }
            i4 = b;
        }
        wheelView.setAdapter(new TimeWheelAdapter(i, i3, i4, this.f35770i));
        wheelView.setCurrentItem(i5 - i3);
    }

    /* renamed from: a */
    private final void m26930a(WheelView wheelView, int i, int i2, WheelAdapter<Object> wheelAdapter) {
        TimeWheelAdapter timeWheelAdapter = wheelAdapter instanceof TimeWheelAdapter ? (TimeWheelAdapter) wheelAdapter : null;
        if (timeWheelAdapter != null) {
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener(i2, timeWheelAdapter, i) {
                public final /* synthetic */ int f$1;
                public final /* synthetic */ TimeWheelAdapter f$2;
                public final /* synthetic */ int f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onItemSelected(int i) {
                    TimeWheelBuilder.m26933a(TimeWheelBuilder.this, this.f$1, this.f$2, this.f$3, i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26933a(TimeWheelBuilder timeWheelBuilder, int i, TimeWheelAdapter timeWheelAdapter, int i2, int i3) {
        boolean z;
        Integer num;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(timeWheelBuilder, "this$0");
        Intrinsics.checkNotNullParameter(timeWheelAdapter, "$curAdapter");
        Calendar calendar = timeWheelBuilder.f35766e;
        Intrinsics.checkNotNullExpressionValue(calendar, "resultCalendar");
        timeWheelBuilder.m26935a(calendar, i, timeWheelAdapter.getStart() + i3);
        Calendar calendar2 = timeWheelBuilder.f35763b;
        Intrinsics.checkNotNullExpressionValue(calendar2, "startCalendar");
        boolean a = timeWheelBuilder.m26936a(i, calendar2);
        if (!a) {
            Calendar calendar3 = timeWheelBuilder.f35764c;
            Intrinsics.checkNotNullExpressionValue(calendar3, "endCalendar");
            z = timeWheelBuilder.m26936a(i, calendar3);
        } else {
            z = false;
        }
        int i6 = i2 + 1;
        if (i6 <= 5) {
            while (true) {
                int i7 = i6 + 1;
                WheelView wheelView = timeWheelBuilder.f35767f.get(Integer.valueOf(i6));
                if (!(wheelView == null || (num = f35761t.get(Integer.valueOf(i6))) == null)) {
                    int intValue = num.intValue();
                    WheelAdapter adapter = wheelView.getAdapter();
                    TimeWheelAdapter timeWheelAdapter2 = adapter instanceof TimeWheelAdapter ? (TimeWheelAdapter) adapter : null;
                    if (timeWheelAdapter2 != null) {
                        if (a) {
                            Calendar calendar4 = timeWheelBuilder.f35763b;
                            Intrinsics.checkNotNullExpressionValue(calendar4, "startCalendar");
                            i4 = timeWheelBuilder.m26928a(calendar4, intValue);
                        } else {
                            Calendar calendar5 = timeWheelBuilder.f35766e;
                            Intrinsics.checkNotNullExpressionValue(calendar5, "resultCalendar");
                            i4 = timeWheelBuilder.m26939c(calendar5, intValue);
                        }
                        if (z) {
                            Calendar calendar6 = timeWheelBuilder.f35764c;
                            Intrinsics.checkNotNullExpressionValue(calendar6, "endCalendar");
                            i5 = timeWheelBuilder.m26928a(calendar6, intValue);
                        } else {
                            Calendar calendar7 = timeWheelBuilder.f35766e;
                            Intrinsics.checkNotNullExpressionValue(calendar7, "resultCalendar");
                            i5 = timeWheelBuilder.m26937b(calendar7, intValue);
                        }
                        if (!(timeWheelAdapter2.getStart() == i4 && timeWheelAdapter2.getEnd() == i5)) {
                            int coerceAtMost = timeWheelBuilder.getKeepLastSelected() ? RangesKt.coerceAtMost(timeWheelAdapter2.getStart() + wheelView.getCurrentItem(), i5) : i4;
                            wheelView.setAdapter(new TimeWheelAdapter(i6, i4, i5, timeWheelBuilder.getItemAdapter()));
                            wheelView.setCurrentItem(coerceAtMost - i4);
                            Calendar calendar8 = timeWheelBuilder.f35766e;
                            Intrinsics.checkNotNullExpressionValue(calendar8, "resultCalendar");
                            timeWheelBuilder.m26935a(calendar8, intValue, coerceAtMost);
                        }
                    }
                }
                if (i7 <= 5) {
                    i6 = i7;
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m26936a(int i, Calendar calendar) {
        if (1 <= i) {
            int i2 = 1;
            while (true) {
                int i3 = i2 + 1;
                Integer num = f35761t.get(Integer.valueOf(i2));
                if (num != null) {
                    int intValue = num.intValue();
                    if (calendar.get(intValue) != this.f35766e.get(intValue)) {
                        return false;
                    }
                }
                if (i2 == i) {
                    break;
                }
                i2 = i3;
            }
        }
        return true;
    }

    /* renamed from: a */
    private final int m26928a(Calendar calendar, int i) {
        return calendar.get(i) + (i == 2 ? 1 : 0);
    }

    /* renamed from: b */
    private final int m26937b(Calendar calendar, int i) {
        return calendar.getActualMaximum(i) + (i == 2 ? 1 : 0);
    }

    /* renamed from: c */
    private final int m26939c(Calendar calendar, int i) {
        return calendar.getActualMinimum(i) + (i == 2 ? 1 : 0);
    }

    /* renamed from: a */
    private final void m26935a(Calendar calendar, int i, int i2) {
        calendar.set(i, i2 + (i == 2 ? -1 : 0));
    }
}
