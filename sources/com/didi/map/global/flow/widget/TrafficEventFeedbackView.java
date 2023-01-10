package com.didi.map.global.flow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.map.global.flow.scene.order.bluetooth_meet.ViewExtKt;
import com.didi.map.global.flow.scene.order.serving.ITrafficEventFeedbackViewCallback;
import com.didi.map.global.sctx.event_reveal.TriggeredTrafficEventShowModel;
import com.didi.map.global.sctx.event_reveal.VerifyBtnModel;
import com.didiglobal.font.DiDiTypeface;
import com.taxis99.R;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

@Metadata(mo148867d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u001aH\u0002J\b\u0010&\u001a\u00020\u001aH\u0014J\u0010\u0010'\u001a\u00020\u001a2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, mo148868d2 = {"Lcom/didi/map/global/flow/widget/TrafficEventFeedbackView;", "Landroid/widget/FrameLayout;", "model", "Lcom/didi/map/global/sctx/event_reveal/TriggeredTrafficEventShowModel;", "callback", "Lcom/didi/map/global/flow/scene/order/serving/ITrafficEventFeedbackViewCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Lcom/didi/map/global/sctx/event_reveal/TriggeredTrafficEventShowModel;Lcom/didi/map/global/flow/scene/order/serving/ITrafficEventFeedbackViewCallback;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "PLACE_HOLDER", "", "btnContainer", "Landroid/widget/LinearLayout;", "getCallback", "()Lcom/didi/map/global/flow/scene/order/serving/ITrafficEventFeedbackViewCallback;", "getModel", "()Lcom/didi/map/global/sctx/event_reveal/TriggeredTrafficEventShowModel;", "msg", "Landroid/widget/TextView;", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "addButtons", "", "list", "", "Lcom/didi/map/global/sctx/event_reveal/VerifyBtnModel;", "dp2px", "", "dp", "geneBtnView", "Landroid/view/View;", "major", "", "initView", "onDetachedFromWindow", "setMessage", "countDownTime", "startCountDown", "duration", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TrafficEventFeedbackView.kt */
public final class TrafficEventFeedbackView extends FrameLayout {

    /* renamed from: a */
    private final TriggeredTrafficEventShowModel f29836a;

    /* renamed from: b */
    private final ITrafficEventFeedbackViewCallback f29837b;

    /* renamed from: c */
    private TextView f29838c;

    /* renamed from: d */
    private LinearLayout f29839d;

    /* renamed from: e */
    private final String f29840e;

    /* renamed from: f */
    private final CoroutineScope f29841f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrafficEventFeedbackView(TriggeredTrafficEventShowModel triggeredTrafficEventShowModel, ITrafficEventFeedbackViewCallback iTrafficEventFeedbackViewCallback, Context context) {
        this(triggeredTrafficEventShowModel, iTrafficEventFeedbackViewCallback, context, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(triggeredTrafficEventShowModel, "model");
        Intrinsics.checkNotNullParameter(iTrafficEventFeedbackViewCallback, "callback");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrafficEventFeedbackView(TriggeredTrafficEventShowModel triggeredTrafficEventShowModel, ITrafficEventFeedbackViewCallback iTrafficEventFeedbackViewCallback, Context context, AttributeSet attributeSet) {
        this(triggeredTrafficEventShowModel, iTrafficEventFeedbackViewCallback, context, attributeSet, 0, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(triggeredTrafficEventShowModel, "model");
        Intrinsics.checkNotNullParameter(iTrafficEventFeedbackViewCallback, "callback");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TrafficEventFeedbackView(TriggeredTrafficEventShowModel triggeredTrafficEventShowModel, ITrafficEventFeedbackViewCallback iTrafficEventFeedbackViewCallback, Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(triggeredTrafficEventShowModel, iTrafficEventFeedbackViewCallback, context, (i2 & 8) != 0 ? null : attributeSet, (i2 & 16) != 0 ? 0 : i);
    }

    public final TriggeredTrafficEventShowModel getModel() {
        return this.f29836a;
    }

    public final ITrafficEventFeedbackViewCallback getCallback() {
        return this.f29837b;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrafficEventFeedbackView(TriggeredTrafficEventShowModel triggeredTrafficEventShowModel, ITrafficEventFeedbackViewCallback iTrafficEventFeedbackViewCallback, Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(triggeredTrafficEventShowModel, "model");
        Intrinsics.checkNotNullParameter(iTrafficEventFeedbackViewCallback, "callback");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f29836a = triggeredTrafficEventShowModel;
        this.f29837b = iTrafficEventFeedbackViewCallback;
        this.f29840e = "{{close_time}}";
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        Dispatchers dispatchers = Dispatchers.INSTANCE;
        this.f29841f = CoroutineScopeKt.CoroutineScope(SupervisorJob$default.plus(Dispatchers.getMain().getImmediate()));
        LayoutInflater.from(context).inflate(R.layout.sctx_traffic_event_verify, this, true);
        m23108a();
    }

    /* renamed from: a */
    private final void m23108a() {
        TextView textView = (TextView) findViewById(R.id.msg);
        this.f29838c = textView;
        if (textView != null) {
            ViewExtKt.setDidiTypeFont(textView, DiDiTypeface.FONT_BOLD);
        }
        setMessage(this.f29836a.getCountDownTime());
        m23109a(this.f29836a.getCountDownTime());
        this.f29839d = (LinearLayout) findViewById(R.id.btn_container);
        List<VerifyBtnModel> btnList = this.f29836a.getBtnList();
        if (btnList != null) {
            m23111a(btnList);
        }
    }

    /* renamed from: a */
    private final void m23111a(List<VerifyBtnModel> list) {
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            VerifyBtnModel verifyBtnModel = (VerifyBtnModel) next;
            boolean z = true;
            if (i != list.size() - 1) {
                z = false;
            }
            View a = m23107a(verifyBtnModel, z);
            if (i > 0) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
                layoutParams.weight = 1.0f;
                LinearLayout linearLayout = this.f29839d;
                if (linearLayout != null) {
                    linearLayout.addView(new View(getContext()), layoutParams);
                }
            }
            LinearLayout linearLayout2 = this.f29839d;
            if (linearLayout2 != null) {
                linearLayout2.addView(a, new LinearLayout.LayoutParams((int) m23106a(149.5f), (int) m23106a(30.0f)));
            }
            i = i2;
        }
    }

    /* renamed from: a */
    private final View m23107a(VerifyBtnModel verifyBtnModel, boolean z) {
        TextView textView = new TextView(getContext());
        textView.setWidth((int) m23106a(149.5f));
        textView.setHeight((int) m23106a(30.0f));
        textView.setGravity(17);
        textView.setText(verifyBtnModel.getText());
        textView.setTextSize(12.0f);
        View view = textView;
        ViewExtKt.setDidiTypeFont(view, DiDiTypeface.FONT_BOLD);
        textView.setTextColor(z ? -1 : -16777216);
        textView.setBackgroundResource(z ? R.drawable.traffic_event_btn_bg_major : R.drawable.traffic_event_btn_bg_minor);
        textView.setOnClickListener(new View.OnClickListener(verifyBtnModel) {
            public final /* synthetic */ VerifyBtnModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                TrafficEventFeedbackView.m23110a(TrafficEventFeedbackView.this, this.f$1, view);
            }
        });
        return view;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23110a(TrafficEventFeedbackView trafficEventFeedbackView, VerifyBtnModel verifyBtnModel, View view) {
        Intrinsics.checkNotNullParameter(trafficEventFeedbackView, "this$0");
        Intrinsics.checkNotNullParameter(verifyBtnModel, "$model");
        trafficEventFeedbackView.getCallback().onVerifyCode(verifyBtnModel.getCode());
    }

    /* access modifiers changed from: private */
    public final void setMessage(int i) {
        String message = this.f29836a.getMessage();
        String replace$default = message == null ? null : StringsKt.replace$default(message, this.f29840e, String.valueOf(i), false, 4, (Object) null);
        TextView textView = this.f29838c;
        if (textView != null) {
            textView.setText(replace$default);
        }
    }

    /* renamed from: a */
    private final void m23109a(int i) {
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i;
        Job unused = C2746d.m5821a(this.f29841f, (CoroutineContext) null, (CoroutineStart) null, new TrafficEventFeedbackView$startCountDown$1(intRef, this, (Continuation<? super TrafficEventFeedbackView$startCountDown$1>) null), 3, (Object) null);
    }

    /* renamed from: a */
    private final float m23106a(float f) {
        return (f * getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.f29841f, (CancellationException) null, 1, (Object) null);
        this.f29837b.onDismiss();
    }
}
