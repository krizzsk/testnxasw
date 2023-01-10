package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.Clock;
import com.didi.soda.customer.widget.countdown.DurationFormatUtils;
import com.didi.soda.home.topgun.binder.model.HomeTaskCenterRvModel;
import com.taxis99.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002J\u000e\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010J\b\u0010'\u001a\u00020\u0010H\u0002J\u0006\u0010(\u001a\u00020\u0019J\b\u0010)\u001a\u00020\u0019H\u0014J\b\u0010*\u001a\u00020\u0019H\u0014J\u0016\u0010+\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-H\u0002J\u000e\u0010/\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$J\b\u00100\u001a\u00020\u0019H\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u00020\u0010H\u0002J\u0010\u00103\u001a\u00020\u00192\u0006\u0010#\u001a\u00020$H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/CountDownTimer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "antiShake", "", "getAntiShake", "()Z", "setAntiShake", "(Z)V", "deadline", "", "dotWidth", "expireWhenDetach", "Ljava/lang/Runnable;", "isActive", "isHasRemainTimeWhenDetach", "maxNumWidth", "onTimerFinished", "Lkotlin/Function0;", "", "getOnTimerFinished", "()Lkotlin/jvm/functions/Function0;", "setOnTimerFinished", "(Lkotlin/jvm/functions/Function0;)V", "overdueShowType", "timer", "timerHandler", "Landroid/os/Handler;", "bindData", "rvModel", "Lcom/didi/soda/home/topgun/binder/model/HomeTaskCenterRvModel;", "getLocalDeadline", "overdueTime", "getRemainTime", "measureSingleNumWidth", "onAttachedToWindow", "onDetachedFromWindow", "setTextWithFixWidth", "nextTextList", "", "", "setupTime", "tearDown", "updateUI", "remainTime", "updateView", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CountDownTimer.kt */
public final class CountDownTimer extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SHOW_TYPE_DAY = 2;
    public static final int SHOW_TYPE_TIME = 1;

    /* renamed from: a */
    private final Handler f45530a;

    /* renamed from: b */
    private long f45531b;

    /* renamed from: c */
    private boolean f45532c;

    /* renamed from: d */
    private boolean f45533d;

    /* renamed from: e */
    private int f45534e;

    /* renamed from: f */
    private int f45535f;

    /* renamed from: g */
    private int f45536g;

    /* renamed from: h */
    private boolean f45537h;

    /* renamed from: i */
    private Function0<Unit> f45538i;

    /* renamed from: j */
    private final Runnable f45539j;

    /* renamed from: k */
    private final Runnable f45540k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountDownTimer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountDownTimer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountDownTimer(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountDownTimer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f45530a = new Handler(Looper.getMainLooper());
        this.f45531b = -1;
        this.f45534e = -1;
        this.f45535f = -1;
        this.f45539j = new Runnable() {
            public final void run() {
                CountDownTimer.m33833a(CountDownTimer.this);
            }
        };
        this.f45540k = new Runnable() {
            public final void run() {
                CountDownTimer.m33835b(CountDownTimer.this);
            }
        };
        LayoutInflater.from(context).inflate(R.layout.customer_widget_task_center_timer, this);
    }

    public final boolean getAntiShake() {
        return this.f45537h;
    }

    public final void setAntiShake(boolean z) {
        this.f45537h = z;
    }

    public final Function0<Unit> getOnTimerFinished() {
        return this.f45538i;
    }

    public final void setOnTimerFinished(Function0<Unit> function0) {
        this.f45538i = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33833a(CountDownTimer countDownTimer) {
        Function0<Unit> onTimerFinished;
        Intrinsics.checkNotNullParameter(countDownTimer, "this$0");
        long remainTime = countDownTimer.getRemainTime();
        countDownTimer.m33831a(Math.max(remainTime, 0));
        int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
        if (i > 0 && countDownTimer.f45532c) {
            countDownTimer.m33830a();
        }
        if (i <= 0 && (onTimerFinished = countDownTimer.getOnTimerFinished()) != null) {
            onTimerFinished.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m33835b(CountDownTimer countDownTimer) {
        Intrinsics.checkNotNullParameter(countDownTimer, "this$0");
        Function0<Unit> onTimerFinished = countDownTimer.getOnTimerFinished();
        if (onTimerFinished != null) {
            onTimerFinished.invoke();
        }
    }

    /* renamed from: a */
    private final void m33830a() {
        this.f45530a.postDelayed(this.f45539j, 1000);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f45530a.removeCallbacks(this.f45539j);
        this.f45532c = false;
        long remainTime = getRemainTime();
        if (remainTime > 0 && this.f45536g == 1) {
            this.f45533d = true;
            getHandler().postDelayed(this.f45540k, remainTime);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getHandler().removeCallbacks(this.f45540k);
        if (!this.f45532c && this.f45533d && this.f45536g == 1) {
            this.f45533d = false;
            this.f45532c = true;
            this.f45539j.run();
        }
    }

    public final void setupTime(HomeTaskCenterRvModel homeTaskCenterRvModel) {
        Intrinsics.checkNotNullParameter(homeTaskCenterRvModel, "rvModel");
        m33832a(homeTaskCenterRvModel);
        m33834b(homeTaskCenterRvModel);
    }

    /* renamed from: a */
    private final void m33832a(HomeTaskCenterRvModel homeTaskCenterRvModel) {
        this.f45536g = homeTaskCenterRvModel.getOverdueShowType();
        ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).setVisibility(0);
        int overdueShowType = homeTaskCenterRvModel.getOverdueShowType();
        if (overdueShowType != 1 && overdueShowType != 2) {
            setVisibility(8);
        }
    }

    /* renamed from: b */
    private final void m33834b(HomeTaskCenterRvModel homeTaskCenterRvModel) {
        if (homeTaskCenterRvModel.getOverdueShowType() == 2) {
            ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).setData((List<String>) null);
            ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).setText(homeTaskCenterRvModel.getOverdueDays());
        } else if (homeTaskCenterRvModel.getOverdueShowType() == 1) {
            this.f45531b = getLocalDeadline(homeTaskCenterRvModel.getOverdueTime());
            long remainTime = getRemainTime();
            int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
            if (i < 0) {
                LogUtil.m32588i("TimerWidget", ">>>>>>>>异常<<<<<<<< 剩余时间 = " + remainTime + "。当前时间 = " + System.currentTimeMillis() + " 截止时间 = " + this.f45531b + ' ');
            }
            this.f45530a.removeCallbacks(this.f45539j);
            if (this.f45531b <= 0 || i <= 0) {
                ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).setVisibility(8);
                return;
            }
            ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).setText("");
            ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).setVisibility(0);
            this.f45532c = true;
            this.f45539j.run();
        }
    }

    public final void measureSingleNumWidth() {
        if (this.f45534e < 0) {
            TextPaint paint = ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).getPaint();
            Iterator it = new IntRange(0, 9).iterator();
            while (it.hasNext()) {
                this.f45534e = Math.max((int) Layout.getDesiredWidth(String.valueOf(((IntIterator) it).nextInt()), paint), this.f45534e);
            }
            this.f45535f = (int) Layout.getDesiredWidth(":", paint);
        }
    }

    private final long getRemainTime() {
        return this.f45531b - System.currentTimeMillis();
    }

    /* renamed from: a */
    private final void m33831a(long j) {
        String formatDuration = DurationFormatUtils.formatDuration(j, "HH:mm:ss");
        Intrinsics.checkNotNullExpressionValue(formatDuration, "formatDuration");
        setTextWithFixWidth(StringsKt.split$default((CharSequence) formatDuration, new String[]{":"}, false, 0, 6, (Object) null));
    }

    private final void setTextWithFixWidth(List<String> list) {
        ((TopicCountDownTimeView) findViewById(R.id.customer_tv_timer_right_view)).setData(list);
    }

    public final long getLocalDeadline(long j) {
        if (j == 0) {
            return j;
        }
        return System.currentTimeMillis() + ((j - Clock.timeAtSeconds()) * ((long) 1000));
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/CountDownTimer$Companion;", "", "()V", "SHOW_TYPE_DAY", "", "SHOW_TYPE_TIME", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CountDownTimer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
