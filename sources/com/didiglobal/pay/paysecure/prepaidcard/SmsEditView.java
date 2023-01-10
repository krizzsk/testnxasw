package com.didiglobal.pay.paysecure.prepaidcard;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
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
import kotlin.TypeCastException;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 G2\u00020\u0001:\u0005GHIJKB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010,\u001a\u00020-2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0018\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0014J(\u00104\u001a\u00020-2\u0006\u00105\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0014J*\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u0007H\u0014J\u0012\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\u000e\u0010C\u001a\u00020-2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010D\u001a\u00020-2\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020*0)X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomColor", "bottomSpace", "bottomStroke", "clearListener", "Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$IClearListener;", "closeBitmap", "Landroid/graphics/Bitmap;", "closeBitmapLeft", "", "getCloseBitmapLeft", "()F", "setCloseBitmapLeft", "(F)V", "closeBitmapTop", "getCloseBitmapTop", "setCloseBitmapTop", "closePaint", "Landroid/graphics/Paint;", "closeWidth", "getCloseWidth", "()I", "setCloseWidth", "(I)V", "currentInputLength", "currentModel", "errorColor", "inputListener", "Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$IInputListener;", "mBottomPaint", "mHeight", "mWidth", "modelMap", "", "Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$IShowUI;", "smsLength", "getAttrSet", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setClearListener", "setInputListener", "updateUI", "model", "Companion", "IClearListener", "IInputListener", "IShowUI", "ShowSmsModel", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: SmsEditView.kt */
public final class SmsEditView extends AppCompatEditText {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MODEL_ERROR = 1;
    public static final int MODEL_NORMAL = 0;

    /* renamed from: a */
    private final Map<Integer, IShowUI> f52895a;

    /* renamed from: b */
    private int f52896b;

    /* renamed from: c */
    private int f52897c;

    /* renamed from: d */
    private int f52898d;

    /* renamed from: e */
    private int f52899e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f52900f;

    /* renamed from: g */
    private int f52901g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f52902h;

    /* renamed from: i */
    private int f52903i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Paint f52904j;

    /* renamed from: k */
    private int f52905k;

    /* renamed from: l */
    private IInputListener f52906l;

    /* renamed from: m */
    private IClearListener f52907m;

    /* renamed from: n */
    private Bitmap f52908n;

    /* renamed from: o */
    private Paint f52909o;

    /* renamed from: p */
    private float f52910p;

    /* renamed from: q */
    private float f52911q;

    /* renamed from: r */
    private int f52912r;

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$IClearListener;", "", "onClear", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: SmsEditView.kt */
    public interface IClearListener {
        void onClear();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$IInputListener;", "", "onInputContinue", "", "onInputDone", "text", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: SmsEditView.kt */
    public interface IInputListener {
        void onInputContinue();

        void onInputDone(String str);
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$IShowUI;", "", "onShow", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: SmsEditView.kt */
    public interface IShowUI {
        void onShow();
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$ShowSmsModel;", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: SmsEditView.kt */
    public @interface ShowSmsModel {
    }

    public SmsEditView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public SmsEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SmsEditView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmsEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f52895a = new LinkedHashMap();
        this.f52899e = 6;
        this.f52901g = 1;
        this.f52903i = 20;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.f52904j = paint;
        this.f52909o = new Paint();
        m39660a(attributeSet);
        setFocusableInTouchMode(true);
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent));
        List arrayList = new ArrayList();
        arrayList.add(new InputFilter.LengthFilter(this.f52899e));
        Object[] array = arrayList.toArray(new InputFilter[0]);
        if (array != null) {
            setFilters((InputFilter[]) array);
            setInputType(2);
            setCursorVisible(true);
            this.f52904j.setStrokeWidth((float) this.f52901g);
            this.f52908n = BitmapFactory.decodeResource(getResources(), R.drawable.ic_sms_edit_del);
            this.f52895a.put(0, new IShowUI(this) {
                final /* synthetic */ SmsEditView this$0;

                {
                    this.this$0 = r1;
                }

                public void onShow() {
                    this.this$0.f52904j.setColor(this.this$0.f52900f);
                }
            });
            this.f52895a.put(1, new IShowUI(this) {
                final /* synthetic */ SmsEditView this$0;

                {
                    this.this$0 = r1;
                }

                public void onShow() {
                    this.this$0.f52904j.setColor(this.this$0.f52902h);
                }
            });
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/SmsEditView$Companion;", "", "()V", "MODEL_ERROR", "", "MODEL_NORMAL", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: SmsEditView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private final void m39660a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.SmsEditView);
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "this.context.obtainStyle… R.styleable.SmsEditView)");
        this.f52900f = obtainStyledAttributes.getColor(0, -16777216);
        this.f52901g = obtainStyledAttributes.getDimensionPixelOffset(2, 2);
        this.f52899e = obtainStyledAttributes.getInt(4, 6);
        this.f52902h = obtainStyledAttributes.getColor(3, -65536);
        this.f52903i = obtainStyledAttributes.getDimensionPixelOffset(1, 20);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f52897c = View.MeasureSpec.getSize(i);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + this.f52903i);
        } else {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        }
        setPadding((int) ((((float) this.f52897c) - (getPaint().measureText("0") * ((float) this.f52899e))) / ((float) 2)), 0, 0, 0);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f52897c = i;
        this.f52898d = i2;
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String str;
        super.onTextChanged(charSequence, i, i2, i3);
        int i4 = i3 + i;
        this.f52905k = i4;
        if (i > 0 && i4 == this.f52899e) {
            SystemUtils.log(4, "benzhang", "input done", (Throwable) null, "com.didiglobal.pay.paysecure.prepaidcard.SmsEditView", 131);
            IInputListener iInputListener = this.f52906l;
            if (iInputListener != null) {
                if (charSequence == null || (str = charSequence.toString()) == null) {
                    str = "";
                }
                iInputListener.onInputDone(str);
            }
        }
        if (this.f52905k < this.f52899e) {
            SystemUtils.log(4, "benzhang", "continue input", (Throwable) null, "com.didiglobal.pay.paysecure.prepaidcard.SmsEditView", 135);
            IInputListener iInputListener2 = this.f52906l;
            if (iInputListener2 != null) {
                iInputListener2.onInputContinue();
            }
        }
    }

    public final float getCloseBitmapLeft() {
        return this.f52910p;
    }

    public final void setCloseBitmapLeft(float f) {
        this.f52910p = f;
    }

    public final float getCloseBitmapTop() {
        return this.f52911q;
    }

    public final void setCloseBitmapTop(float f) {
        this.f52911q = f;
    }

    public final int getCloseWidth() {
        return this.f52912r;
    }

    public final void setCloseWidth(int i) {
        this.f52912r = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        super.onDraw(canvas);
        IShowUI iShowUI = this.f52895a.get(Integer.valueOf(this.f52896b));
        if (iShowUI != null) {
            iShowUI.onShow();
        }
        if (canvas != null) {
            int i = this.f52898d;
            canvas.drawLine(0.0f, (float) i, (float) this.f52897c, (float) i, this.f52904j);
        }
        Editable text = getText();
        int i2 = 0;
        if ((text != null ? text.length() : 0) > 0 && (bitmap = this.f52908n) != null) {
            if (bitmap != null) {
                i2 = bitmap.getWidth();
            }
            this.f52912r = i2;
            TextPaint paint = getPaint();
            Intrinsics.checkExpressionValueIsNotNull(paint, "paint");
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            float f = ((fontMetrics.bottom - fontMetrics.top) / ((float) 2)) - fontMetrics.bottom;
            float f2 = (float) (this.f52897c - this.f52912r);
            this.f52910p = f2;
            this.f52911q = f;
            if (canvas != null) {
                canvas.drawBitmap(bitmap, f2, f, this.f52909o);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f = 0.0f;
        float x = motionEvent != null ? motionEvent.getX() : 0.0f;
        if (motionEvent != null) {
            f = motionEvent.getY();
        }
        float f2 = this.f52910p;
        if (x >= f2) {
            int i = this.f52912r;
            if (x <= f2 + ((float) i)) {
                float f3 = this.f52911q;
                if (f >= f3 && f <= f3 + ((float) i)) {
                    IClearListener iClearListener = this.f52907m;
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
        this.f52906l = iInputListener;
    }

    public final void setClearListener(IClearListener iClearListener) {
        Intrinsics.checkParameterIsNotNull(iClearListener, "clearListener");
        this.f52907m = iClearListener;
    }

    public final void updateUI(int i) {
        this.f52896b = i;
        invalidate();
    }
}
