package com.didi.soda.customer.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.countdown.DurationFormatUtils;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010#\u001a\u00020\u0010H\u0002J\u0017\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u001bJ\b\u0010)\u001a\u00020\u001bH\u0014J\b\u0010*\u001a\u00020\u001bH\u0014J\u001a\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010%2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020%H\u0002J\u0016\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\b\u00105\u001a\u00020\u001bH\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/TimerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "antiShake", "", "getAntiShake", "()Z", "setAntiShake", "(Z)V", "deadline", "", "dotWidth", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "expireWhenDetach", "Ljava/lang/Runnable;", "isActive", "isHasRemainTimeWhenDetach", "maxNumWidth", "onTimerFinished", "Lkotlin/Function0;", "", "getOnTimerFinished", "()Lkotlin/jvm/functions/Function0;", "setOnTimerFinished", "(Lkotlin/jvm/functions/Function0;)V", "timer", "timerHandler", "Landroid/os/Handler;", "getRemainTime", "getTimeFormat", "", "style", "(Ljava/lang/Integer;)Ljava/lang/String;", "measureSingleNumWidth", "onAttachedToWindow", "onDetachedFromWindow", "parseColor", "colorString", "defaultColorRes", "setScopeContext", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "setTextWithFixWidth", "nextText", "setupTimeEntity", "localDeadLine", "tearDown", "updateUI", "remainTime", "updateView", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TimerView.kt */
public final class TimerView extends LinearLayout {

    /* renamed from: a */
    private final Handler f44214a;

    /* renamed from: b */
    private long f44215b;

    /* renamed from: c */
    private CountDownEntity f44216c;

    /* renamed from: d */
    private boolean f44217d;

    /* renamed from: e */
    private boolean f44218e;

    /* renamed from: f */
    private int f44219f;

    /* renamed from: g */
    private int f44220g;

    /* renamed from: h */
    private boolean f44221h;

    /* renamed from: i */
    private Function0<Unit> f44222i;

    /* renamed from: j */
    private final Runnable f44223j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Runnable f44224k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f44214a = new Handler(Looper.getMainLooper());
        this.f44215b = -1;
        this.f44219f = -1;
        this.f44220g = -1;
        this.f44221h = true;
        this.f44223j = new Runnable() {
            public final void run() {
                TimerView.m32904a(TimerView.this);
            }
        };
        this.f44224k = new Runnable() {
            public final void run() {
                TimerView.m32905b(TimerView.this);
            }
        };
        LayoutInflater.from(context).inflate(R.layout.customer_widget_timer, this);
    }

    public final boolean getAntiShake() {
        return this.f44221h;
    }

    public final void setAntiShake(boolean z) {
        this.f44221h = z;
    }

    public final Function0<Unit> getOnTimerFinished() {
        return this.f44222i;
    }

    public final void setOnTimerFinished(Function0<Unit> function0) {
        this.f44222i = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32904a(TimerView timerView) {
        Function0<Unit> onTimerFinished;
        Intrinsics.checkNotNullParameter(timerView, "this$0");
        long remainTime = timerView.getRemainTime();
        timerView.m32902a(Math.max(remainTime, 0));
        int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
        if (i > 0 && timerView.f44217d) {
            timerView.m32901a();
        }
        if (i <= 0 && (onTimerFinished = timerView.getOnTimerFinished()) != null) {
            onTimerFinished.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m32905b(TimerView timerView) {
        Intrinsics.checkNotNullParameter(timerView, "this$0");
        Function0<Unit> onTimerFinished = timerView.getOnTimerFinished();
        if (onTimerFinished != null) {
            onTimerFinished.invoke();
        }
    }

    /* renamed from: a */
    private final void m32901a() {
        this.f44214a.postDelayed(this.f44223j, 1000);
    }

    public final void setScopeContext(ScopeContext scopeContext) {
        if (scopeContext != null) {
            scopeContext.addObserver(new TimerView$setScopeContext$1(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f44214a.removeCallbacks(this.f44223j);
        this.f44217d = false;
        long remainTime = getRemainTime();
        if (remainTime > 0) {
            this.f44218e = true;
            Handler handler = getHandler();
            if (handler != null) {
                handler.postDelayed(this.f44224k, remainTime);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f44224k);
        }
        if (!this.f44217d && this.f44218e) {
            this.f44218e = false;
            this.f44217d = true;
            this.f44223j.run();
        }
    }

    /* renamed from: a */
    private final void m32903a(CountDownEntity countDownEntity) {
        CharSequence countDownDesc = countDownEntity.getCountDownDesc();
        if (countDownDesc == null || countDownDesc.length() == 0) {
            ((RichTextView) findViewById(R.id.customer_tv_timer_left_view)).setVisibility(8);
        } else {
            ((RichTextView) findViewById(R.id.customer_tv_timer_left_view)).setVisibility(0);
            ((RichTextView) findViewById(R.id.customer_tv_timer_left_view)).setText(countDownEntity.getCountDownDesc());
        }
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setTextColor(m32899a(countDownEntity.getTextColor(), R.color.rf_color_brands_1_100));
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setTextSize((float) countDownEntity.getTextSize());
        RichTextView richTextView = (RichTextView) findViewById(R.id.customer_tv_timer_right_view);
        Intrinsics.checkNotNullExpressionValue(richTextView, "customer_tv_timer_right_view");
        CustomerExtentionKt.setCustomerTextWeight(richTextView, countDownEntity.getTextWeight());
    }

    public final void setupTimeEntity(long j, CountDownEntity countDownEntity) {
        Intrinsics.checkNotNullParameter(countDownEntity, "entity");
        this.f44216c = countDownEntity;
        m32903a(countDownEntity);
        this.f44215b = j;
        long remainTime = getRemainTime();
        int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
        if (i < 0) {
            LogUtil.m32588i("TimerWidget", ">>>>>>>>异常<<<<<<<< 剩余时间 = " + remainTime + "。当前时间 = " + System.currentTimeMillis() + " 截止时间 = " + this.f44215b + ' ');
        }
        this.f44214a.removeCallbacks(this.f44223j);
        if (this.f44215b <= 0 || i <= 0) {
            ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setVisibility(8);
            return;
        }
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setVisibility(0);
        this.f44217d = true;
        this.f44223j.run();
    }

    public final void measureSingleNumWidth() {
        if (this.f44219f < 0) {
            TextPaint paint = ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getPaint();
            Iterator it = new IntRange(0, 9).iterator();
            while (it.hasNext()) {
                this.f44219f = Math.max((int) Layout.getDesiredWidth(String.valueOf(((IntIterator) it).nextInt()), paint), this.f44219f);
            }
            this.f44220g = (int) Layout.getDesiredWidth(":", paint);
        }
    }

    private final long getRemainTime() {
        return this.f44215b - System.currentTimeMillis();
    }

    /* renamed from: a */
    private final void m32902a(long j) {
        CountDownEntity countDownEntity = this.f44216c;
        String formatDuration = DurationFormatUtils.formatDuration(j, m32900a(countDownEntity == null ? null : Integer.valueOf(countDownEntity.getStyle())));
        Intrinsics.checkNotNullExpressionValue(formatDuration, "formatDuration");
        setTextWithFixWidth(formatDuration);
    }

    /* renamed from: a */
    private final String m32900a(Integer num) {
        if ((num != null && num.intValue() == 1) || num == null || num.intValue() != 3) {
            return "HH:mm:ss";
        }
        return "dd:HH:mm:ss";
    }

    private final void setTextWithFixWidth(String str) {
        if (this.f44221h) {
            CharSequence text = ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getText();
            int length = str.length();
            if (text.length() != length || ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getWidth() == 0) {
                if (this.f44219f <= 0) {
                    measureSingleNumWidth();
                }
                ViewGroup.LayoutParams layoutParams = ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getLayoutParams();
                int size = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).size() - 1;
                layoutParams.width = (this.f44219f * (length - size)) + (this.f44220g * size);
                requestLayout();
            }
        }
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setText(str);
    }

    /* renamed from: a */
    private final int m32899a(String str, int i) {
        if (str == null) {
            return ResourceHelper.getColor(i);
        }
        try {
            return Color.parseColor(str);
        } catch (Exception e) {
            e.printStackTrace();
            return ResourceHelper.getColor(i);
        }
    }
}
