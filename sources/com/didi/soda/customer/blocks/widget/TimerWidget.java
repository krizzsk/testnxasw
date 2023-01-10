package com.didi.soda.customer.blocks.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.blocks.BinderRootConfig;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.constant.Const;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CountDownEntity;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.countdown.DurationFormatUtils;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

@WidgetNameMeta(widgetName = "countdown_timer_v2")
@Metadata(mo148867d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ0\u0010*\u001a\u00020\"2&\u0010+\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,\u0018\u0001`\u0016H\u0016J\b\u0010-\u001a\u00020\u0011H\u0002J\u0017\u0010.\u001a\u00020\u00152\b\u0010/\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u00100J\b\u00101\u001a\u000202H\u0016J\u0006\u00103\u001a\u00020\"J\b\u00104\u001a\u00020\"H\u0014J\b\u00105\u001a\u00020\"H\u0014J\u001a\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u00152\u0006\u00108\u001a\u00020\bH\u0002J\u0010\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020;H\u0016J\u0010\u0010<\u001a\u00020\"2\u0006\u0010=\u001a\u00020\u0015H\u0002J\u0016\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ0\u0010@\u001a\u00020\u000b2&\u0010+\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,\u0018\u00010\u0014j\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020,\u0018\u0001`\u0016H\u0016J\b\u0010A\u001a\u00020\"H\u0002J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020\u0011H\u0002J\u0010\u0010D\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R4\u0010\u0013\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00020\u0014j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u0002`\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, mo148868d2 = {"Lcom/didi/soda/customer/blocks/widget/TimerWidget;", "Landroid/widget/LinearLayout;", "Lcom/didi/soda/blocks/widget/Buildable;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "antiShake", "", "getAntiShake", "()Z", "setAntiShake", "(Z)V", "deadline", "", "dotWidth", "dynamicChildren", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDynamicChildren", "()Ljava/util/HashMap;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CountDownEntity;", "expireWhenDetach", "Ljava/lang/Runnable;", "isActive", "isHasRemainTimeWhenDetach", "maxNumWidth", "onTimerFinished", "Lkotlin/Function0;", "", "getOnTimerFinished", "()Lkotlin/jvm/functions/Function0;", "setOnTimerFinished", "(Lkotlin/jvm/functions/Function0;)V", "timer", "timerHandler", "Landroid/os/Handler;", "bindProps", "props", "", "getRemainTime", "getTimeFormat", "style", "(Ljava/lang/Integer;)Ljava/lang/String;", "getView", "Landroid/view/View;", "measureSingleNumWidth", "onAttachedToWindow", "onDetachedFromWindow", "parseColor", "colorString", "defaultColorRes", "setScope", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "setTextWithFixWidth", "nextText", "setupTimeEntity", "localDeadLine", "shouldShow", "tearDown", "updateUI", "remainTime", "updateView", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TimerWidget.kt */
public final class TimerWidget extends LinearLayout implements Buildable {

    /* renamed from: a */
    private final Handler f43314a;

    /* renamed from: b */
    private long f43315b;

    /* renamed from: c */
    private CountDownEntity f43316c;

    /* renamed from: d */
    private boolean f43317d;

    /* renamed from: e */
    private boolean f43318e;

    /* renamed from: f */
    private int f43319f;

    /* renamed from: g */
    private int f43320g;

    /* renamed from: h */
    private boolean f43321h;

    /* renamed from: i */
    private Function0<Unit> f43322i;

    /* renamed from: j */
    private final Runnable f43323j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Runnable f43324k;

    /* renamed from: l */
    private final HashMap<String, Buildable> f43325l;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimerWidget(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimerWidget(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void bindProps(HashMap<String, Object> hashMap) {
    }

    public void bindChildren(List<? extends Buildable> list) {
        Buildable.DefaultImpls.bindChildren(this, list);
    }

    public void bindStyles(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.bindStyles(this, hashMap);
    }

    public Buildable findWidgetByComponentId(String str, int i) {
        return Buildable.DefaultImpls.findWidgetByComponentId(this, str, i);
    }

    public Buildable getParentWidget() {
        return Buildable.DefaultImpls.getParentWidget(this);
    }

    public Buildable getRoot() {
        return Buildable.DefaultImpls.getRoot(this);
    }

    public boolean handleClickTrigger(IBlockScope iBlockScope, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleClickTrigger(this, iBlockScope, list, function3);
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        return Buildable.DefaultImpls.handleOtherTrigger(this, iBlockScope, str, list, function3);
    }

    public boolean handleShownTrigger(IBlockScope iBlockScope, WidgetNodeModel widgetNodeModel, List<? extends BaseAction> list, Function4<? super IBlockScope, ? super WidgetNodeModel, ? super Buildable, ? super List<? extends BaseAction>, Unit> function4) {
        return Buildable.DefaultImpls.handleShownTrigger(this, iBlockScope, widgetNodeModel, list, function4);
    }

    public boolean isRoot() {
        return Buildable.DefaultImpls.isRoot(this);
    }

    public void onBindFinish(HashMap<String, Object> hashMap) {
        Buildable.DefaultImpls.onBindFinish(this, hashMap);
    }

    public void refreshLayout() {
        Buildable.DefaultImpls.refreshLayout(this);
    }

    public void setBinderRootConfig(BinderRootConfig<?> binderRootConfig) {
        Buildable.DefaultImpls.setBinderRootConfig(this, binderRootConfig);
    }

    public void setWidgetNode(WidgetNodeModel widgetNodeModel) {
        Buildable.DefaultImpls.setWidgetNode(this, widgetNodeModel);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TimerWidget(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimerWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43314a = new Handler(Looper.getMainLooper());
        this.f43315b = -1;
        this.f43319f = -1;
        this.f43320g = -1;
        this.f43323j = new Runnable() {
            public final void run() {
                TimerWidget.m32399a(TimerWidget.this);
            }
        };
        this.f43324k = new Runnable() {
            public final void run() {
                TimerWidget.m32401b(TimerWidget.this);
            }
        };
        this.f43325l = new HashMap<>();
        LayoutInflater.from(context).inflate(R.layout.customer_widget_timer, this);
    }

    public final boolean getAntiShake() {
        return this.f43321h;
    }

    public final void setAntiShake(boolean z) {
        this.f43321h = z;
    }

    public final Function0<Unit> getOnTimerFinished() {
        return this.f43322i;
    }

    public final void setOnTimerFinished(Function0<Unit> function0) {
        this.f43322i = function0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32399a(TimerWidget timerWidget) {
        Function0<Unit> onTimerFinished;
        Intrinsics.checkNotNullParameter(timerWidget, "this$0");
        long remainTime = timerWidget.getRemainTime();
        timerWidget.m32398a(Math.max(remainTime, 0));
        int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
        if (i > 0 && timerWidget.f43317d) {
            timerWidget.m32397a();
        }
        if (i <= 0 && (onTimerFinished = timerWidget.getOnTimerFinished()) != null) {
            onTimerFinished.invoke();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m32401b(TimerWidget timerWidget) {
        Intrinsics.checkNotNullParameter(timerWidget, "this$0");
        Function0<Unit> onTimerFinished = timerWidget.getOnTimerFinished();
        if (onTimerFinished != null) {
            onTimerFinished.invoke();
        }
    }

    public HashMap<String, Buildable> getDynamicChildren() {
        return this.f43325l;
    }

    /* renamed from: a */
    private final void m32397a() {
        this.f43314a.postDelayed(this.f43323j, 1000);
    }

    public void setScope(IBlockScope iBlockScope) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        ScopeContext scopeContext = (ScopeContext) iBlockScope.getObject(Const.BusinessConst.SCOPE_KEY_SCOPE_CONTEXT);
        if (scopeContext != null) {
            scopeContext.addObserver(new TimerWidget$setScope$1(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f43314a.removeCallbacks(this.f43323j);
        this.f43317d = false;
        long remainTime = getRemainTime();
        if (remainTime > 0) {
            this.f43318e = true;
            getHandler().postDelayed(this.f43324k, remainTime);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getHandler().removeCallbacks(this.f43324k);
        if (!this.f43317d && this.f43318e) {
            this.f43318e = false;
            this.f43317d = true;
            this.f43323j.run();
        }
    }

    /* renamed from: a */
    private final void m32400a(CountDownEntity countDownEntity) {
        CharSequence countDownDesc = countDownEntity.getCountDownDesc();
        boolean z = true;
        if (countDownDesc == null || countDownDesc.length() == 0) {
            ((RichTextView) findViewById(R.id.customer_tv_timer_left_view)).setVisibility(8);
        } else {
            ((RichTextView) findViewById(R.id.customer_tv_timer_left_view)).setVisibility(0);
            ((RichTextView) findViewById(R.id.customer_tv_timer_left_view)).setText(countDownEntity.getCountDownDesc());
        }
        CharSequence icon = countDownEntity.getIcon();
        if (!(icon == null || icon.length() == 0)) {
            z = false;
        }
        if (z) {
            ((IconRichTextView) findViewById(R.id.customer_tv_timer_icon_view)).setVisibility(8);
        } else {
            ((IconRichTextView) findViewById(R.id.customer_tv_timer_icon_view)).setVisibility(0);
            ((IconRichTextView) findViewById(R.id.customer_tv_timer_icon_view)).setText(countDownEntity.getIcon());
        }
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setTextColor(m32395a(countDownEntity.getTextColor(), R.color.rf_color_brands_1_100));
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setTextSize((float) countDownEntity.getTextSize());
        RichTextView richTextView = (RichTextView) findViewById(R.id.customer_tv_timer_right_view);
        Intrinsics.checkNotNullExpressionValue(richTextView, "customer_tv_timer_right_view");
        CustomerExtentionKt.setCustomerTextWeight(richTextView, countDownEntity.getTextWeight());
    }

    public final void setupTimeEntity(long j, CountDownEntity countDownEntity) {
        Intrinsics.checkNotNullParameter(countDownEntity, "entity");
        this.f43316c = countDownEntity;
        m32400a(countDownEntity);
        this.f43315b = j;
        long remainTime = getRemainTime();
        int i = (remainTime > 0 ? 1 : (remainTime == 0 ? 0 : -1));
        if (i < 0) {
            LogUtil.m32588i("TimerWidget", ">>>>>>>>异常<<<<<<<< 剩余时间 = " + remainTime + "。当前时间 = " + System.currentTimeMillis() + " 截止时间 = " + this.f43315b + ' ');
        }
        this.f43314a.removeCallbacks(this.f43323j);
        if (this.f43315b <= 0 || i <= 0) {
            ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setVisibility(8);
            return;
        }
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setVisibility(0);
        this.f43317d = true;
        this.f43323j.run();
    }

    public final void measureSingleNumWidth() {
        if (this.f43319f < 0) {
            TextPaint paint = ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getPaint();
            Iterator it = new IntRange(0, 9).iterator();
            while (it.hasNext()) {
                this.f43319f = Math.max((int) Layout.getDesiredWidth(String.valueOf(((IntIterator) it).nextInt()), paint), this.f43319f);
            }
            this.f43320g = (int) Layout.getDesiredWidth(":", paint);
        }
    }

    private final long getRemainTime() {
        return this.f43315b - System.currentTimeMillis();
    }

    /* renamed from: a */
    private final void m32398a(long j) {
        CountDownEntity countDownEntity = this.f43316c;
        String formatDuration = DurationFormatUtils.formatDuration(j, m32396a(countDownEntity == null ? null : Integer.valueOf(countDownEntity.getStyle())));
        Intrinsics.checkNotNullExpressionValue(formatDuration, "formatDuration");
        setTextWithFixWidth(formatDuration);
    }

    /* renamed from: a */
    private final String m32396a(Integer num) {
        if ((num != null && num.intValue() == 1) || num == null || num.intValue() != 3) {
            return "HH:mm:ss";
        }
        return "dd:HH:mm:ss";
    }

    private final void setTextWithFixWidth(String str) {
        if (this.f43321h) {
            CharSequence text = ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getText();
            int length = str.length();
            if (text.length() != length || ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getWidth() == 0) {
                if (this.f43319f <= 0) {
                    measureSingleNumWidth();
                }
                ViewGroup.LayoutParams layoutParams = ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).getLayoutParams();
                int size = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null).size() - 1;
                layoutParams.width = (this.f43319f * (length - size)) + (this.f43320g * size);
                requestLayout();
            }
        }
        ((RichTextView) findViewById(R.id.customer_tv_timer_right_view)).setText(str);
    }

    public View getView() {
        return this;
    }

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return hashMap != null && hashMap.size() > 0;
    }

    /* renamed from: a */
    private final int m32395a(String str, int i) {
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
