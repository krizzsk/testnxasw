package com.didi.payment.wallet.global.riskcontrol.sms;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 =2\u00020\u0001:\u0005=>?@AB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\"\u001a\u00020#2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014J(\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0007H\u0014J*\u0010/\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J\u0012\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u000e\u00109\u001a\u00020#2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010:\u001a\u00020#2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020 0\u001fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomColor", "bottomSpace", "bottomStroke", "clearListener", "Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IClearListener;", "closeBitmap", "Landroid/graphics/Bitmap;", "closeBitmapLeft", "", "closeBitmapTop", "closePaint", "Landroid/graphics/Paint;", "closeWidth", "currentInputLength", "currentModel", "errorColor", "inputListener", "Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IInputListener;", "mBottomPaint", "mHeight", "mWidth", "modelMap", "", "Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IShowUI;", "smsLength", "getAttrSet", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setClearListener", "setInputListener", "updateUI", "model", "Companion", "IClearListener", "IInputListener", "IShowUI", "ShowSmsModel", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SmsEditView.kt */
public final class SmsEditView extends AppCompatEditText {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MODEL_ERROR = 1;
    public static final int MODEL_NORMAL = 0;

    /* renamed from: a */
    private final Map<Integer, IShowUI> f34324a;

    /* renamed from: b */
    private int f34325b;

    /* renamed from: c */
    private int f34326c;

    /* renamed from: d */
    private int f34327d;

    /* renamed from: e */
    private int f34328e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f34329f;

    /* renamed from: g */
    private int f34330g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f34331h;

    /* renamed from: i */
    private int f34332i;

    /* renamed from: j */
    private float f34333j;

    /* renamed from: k */
    private float f34334k;

    /* renamed from: l */
    private int f34335l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Paint f34336m;

    /* renamed from: n */
    private int f34337n;

    /* renamed from: o */
    private IInputListener f34338o;

    /* renamed from: p */
    private IClearListener f34339p;

    /* renamed from: q */
    private Bitmap f34340q;

    /* renamed from: r */
    private Paint f34341r;

    @Metadata(mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IClearListener;", "", "onClear", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SmsEditView.kt */
    public interface IClearListener {
        void onClear();
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IInputListener;", "", "onInputContinue", "", "onInputDone", "text", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SmsEditView.kt */
    public interface IInputListener {
        void onInputContinue();

        void onInputDone(String str);
    }

    @Metadata(mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$IShowUI;", "", "onShow", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SmsEditView.kt */
    public interface IShowUI {
        void onShow();
    }

    @Metadata(mo148867d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$ShowSmsModel;", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: SmsEditView.kt */
    public @interface ShowSmsModel {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmsEditView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SmsEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmsEditView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmsEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f34324a = new LinkedHashMap();
        this.f34328e = 6;
        this.f34330g = 1;
        this.f34332i = 20;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.f34336m = paint;
        this.f34341r = new Paint();
        m26217a(attributeSet);
        setFocusableInTouchMode(true);
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));
        List arrayList = new ArrayList();
        arrayList.add(new InputFilter.LengthFilter(this.f34328e));
        Unit unit2 = Unit.INSTANCE;
        Object[] array = arrayList.toArray(new InputFilter[0]);
        if (array != null) {
            setFilters((InputFilter[]) array);
            setInputType(2);
            setCursorVisible(true);
            this.f34336m.setStrokeWidth((float) this.f34330g);
            this.f34340q = BitmapFactory.decodeResource(getResources(), R.drawable.ic_sms_edit_del);
            this.f34324a.put(0, new IShowUI(this) {
                final /* synthetic */ SmsEditView this$0;

                {
                    this.this$0 = r1;
                }

                public void onShow() {
                    this.this$0.f34336m.setColor(this.this$0.f34329f);
                }
            });
            this.f34324a.put(1, new IShowUI(this) {
                final /* synthetic */ SmsEditView this$0;

                {
                    this.this$0 = r1;
                }

                public void onShow() {
                    this.this$0.f34336m.setColor(this.this$0.f34331h);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/sms/SmsEditView$Companion;", "", "()V", "MODEL_ERROR", "", "MODEL_NORMAL", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SmsEditView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    private final void m26217a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.SmsEditView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "this.context.obtainStyle… R.styleable.SmsEditView)");
        this.f34329f = obtainStyledAttributes.getColor(0, -16777216);
        this.f34330g = obtainStyledAttributes.getDimensionPixelOffset(2, 2);
        this.f34328e = obtainStyledAttributes.getInt(4, 6);
        this.f34331h = obtainStyledAttributes.getColor(3, -65536);
        this.f34332i = obtainStyledAttributes.getDimensionPixelOffset(1, 20);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f34326c = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + this.f34332i);
        } else {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        }
        setPadding((int) ((((float) this.f34326c) - (getPaint().measureText("0") * ((float) this.f34328e))) / ((float) 2)), 0, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f34326c = i;
        this.f34327d = i2;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String obj;
        super.onTextChanged(charSequence, i, i2, i3);
        int i4 = i3 + i;
        this.f34337n = i4;
        if (i > 0 && i4 == this.f34328e) {
            SystemUtils.log(4, "benzhang", "input done", (Throwable) null, "com.didi.payment.wallet.global.riskcontrol.sms.SmsEditView", 134);
            IInputListener iInputListener = this.f34338o;
            if (iInputListener != null) {
                String str = "";
                if (!(charSequence == null || (obj = charSequence.toString()) == null)) {
                    str = obj;
                }
                iInputListener.onInputDone(str);
            }
        }
        if (this.f34337n < this.f34328e) {
            SystemUtils.log(4, "benzhang", "continue input", (Throwable) null, "com.didi.payment.wallet.global.riskcontrol.sms.SmsEditView", 138);
            IInputListener iInputListener2 = this.f34338o;
            if (iInputListener2 != null) {
                iInputListener2.onInputContinue();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        IShowUI iShowUI = this.f34324a.get(Integer.valueOf(this.f34325b));
        if (iShowUI != null) {
            iShowUI.onShow();
        }
        if (canvas != null) {
            int i = this.f34327d;
            canvas.drawLine(0.0f, (float) i, (float) this.f34326c, (float) i, this.f34336m);
        }
        Editable text = getText();
        int i2 = 0;
        if ((text == null ? 0 : text.length()) > 0 && (bitmap = this.f34340q) != null) {
            if (bitmap != null) {
                i2 = bitmap.getWidth();
            }
            Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
            float f = ((fontMetrics.bottom - fontMetrics.top) / ((float) 2)) - fontMetrics.bottom;
            if (canvas != null) {
                canvas.drawBitmap(bitmap, (float) (this.f34326c - i2), f, this.f34341r);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        float x = motionEvent == null ? 0.0f : motionEvent.getX();
        if (motionEvent != null) {
            f = motionEvent.getY();
        }
        float f2 = this.f34333j;
        if (x >= f2) {
            int i = this.f34335l;
            if (x <= f2 + ((float) i)) {
                float f3 = this.f34334k;
                if (f >= f3 && f <= f3 + ((float) i)) {
                    IClearListener iClearListener = this.f34339p;
                    if (iClearListener != null) {
                        iClearListener.onClear();
                    }
                    invalidate();
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setInputListener(IInputListener iInputListener) {
        this.f34338o = iInputListener;
    }

    public final void setClearListener(IClearListener iClearListener) {
        Intrinsics.checkNotNullParameter(iClearListener, "clearListener");
        this.f34339p = iClearListener;
    }

    public final void updateUI(int i) {
        this.f34325b = i;
        invalidate();
    }
}
