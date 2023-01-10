package com.didi.payment.wallet.global.utils;

import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.wallet.global.model.resp.WalletBalanceHistoryResp;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletNewBalanceHistoryAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\fH\u0002J\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fJ\u0010\u0010\u000f\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/utils/WalletDateUtil;", "", "()V", "dateFormat", "Ljava/text/SimpleDateFormat;", "mCalendar", "Ljava/util/Calendar;", "getMCalendar", "()Ljava/util/Calendar;", "setMCalendar", "(Ljava/util/Calendar;)V", "topTime", "", "getTopTime", "()J", "setTopTime", "(J)V", "getCurrentMonthEnd", "getDateStr", "", "getDefaultDate", "getNextMonthEnd", "getNextRefreshTime", "setTime", "", "long", "item", "Lcom/didi/payment/wallet/global/wallet/view/adapter/WalletNewBalanceHistoryAdapter$HistoryItem;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletDateUtil.kt */
public final class WalletDateUtil {

    /* renamed from: a */
    private final SimpleDateFormat f34541a = new SimpleDateFormat("MM/yyyy");

    /* renamed from: b */
    private Calendar f34542b;

    /* renamed from: c */
    private long f34543c;

    public WalletDateUtil() {
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        this.f34542b = instance;
    }

    public final Calendar getMCalendar() {
        return this.f34542b;
    }

    public final void setMCalendar(Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "<set-?>");
        this.f34542b = calendar;
    }

    public final long getTopTime() {
        return this.f34543c;
    }

    public final void setTopTime(long j) {
        this.f34543c = j;
    }

    public final void setTopTime(WalletNewBalanceHistoryAdapter.HistoryItem historyItem) {
        WalletBalanceHistoryResp.StatementBean statementBean;
        Long l;
        long j = 0;
        if (!(historyItem == null || (statementBean = historyItem.mItem) == null || (l = statementBean.time) == null)) {
            j = l.longValue();
        }
        this.f34543c = j;
        this.f34542b.setTimeInMillis(j);
    }

    public final void setTime(long j) {
        this.f34542b.setTime(new Date(j));
    }

    public final long getNextRefreshTime() {
        if (WalletCommonParamsUtil.isBrazilDriverClient()) {
            return m26333a();
        }
        return m26334b();
    }

    /* renamed from: a */
    private final long m26333a() {
        Calendar calendar = this.f34542b;
        calendar.set(5, calendar.getActualMaximum(5));
        int actualMaximum = this.f34542b.getActualMaximum(5);
        Calendar calendar2 = this.f34542b;
        calendar2.set(calendar2.get(1), this.f34542b.get(2), actualMaximum, 23, 59);
        this.f34542b.set(13, 59);
        this.f34542b.set(14, 999);
        return this.f34542b.getTimeInMillis();
    }

    /* renamed from: b */
    private final long m26334b() {
        this.f34542b.add(2, 1);
        Calendar calendar = this.f34542b;
        calendar.set(5, calendar.getActualMaximum(5));
        int actualMaximum = this.f34542b.getActualMaximum(5);
        Calendar calendar2 = this.f34542b;
        calendar2.set(calendar2.get(1), this.f34542b.get(2), actualMaximum, 23, 59);
        this.f34542b.set(13, 59);
        this.f34542b.set(14, 999);
        return this.f34542b.getTimeInMillis();
    }

    public final String getDateStr() {
        Date date;
        if (this.f34542b.getTime().compareTo(Calendar.getInstance().getTime()) > 0) {
            date = Calendar.getInstance().getTime();
        } else {
            date = this.f34542b.getTime();
        }
        String format = this.f34541a.format(date);
        if (format.length() == 6) {
            return Intrinsics.stringPlus("0", format);
        }
        Intrinsics.checkNotNullExpressionValue(format, "str");
        return format;
    }

    public final String getDefaultDate() {
        String format = this.f34541a.format(Calendar.getInstance().getTime());
        if (format.length() == 6) {
            return Intrinsics.stringPlus("0", format);
        }
        Intrinsics.checkNotNullExpressionValue(format, "str");
        return format;
    }
}
