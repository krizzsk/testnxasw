package com.didiglobal.pay.paysecure.prepaidcard;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.passenger.C11267R;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 L2\u00020\u0001:\u0001LB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ4\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020\u0007H\u0002J\u0012\u0010.\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010/\u001a\u00020%2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0012\u00101\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0018\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0014J(\u00105\u001a\u00020%2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u0007H\u0014J*\u0010:\u001a\u00020%2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u0007H\u0014J\u0016\u0010@\u001a\u00020%2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020%0BJ\u0018\u0010C\u001a\u00020%2\b\b\u0002\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020+J\u0010\u0010F\u001a\u00020%2\b\u0010G\u001a\u0004\u0018\u00010\fJ\u000e\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\u0007J\u0016\u0010J\u001a\u00020%2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020%0BJ\u000e\u0010K\u001a\u00020%2\u0006\u0010I\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0007X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdEditView;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentInputLength", "currentShowModel", "inputListener", "Lcom/didiglobal/pay/paysecure/prepaidcard/InputListener;", "mErrorBackground", "mErrorInputColor", "mGapWidth", "mInputBackGround", "mInputColor", "mInputFontBold", "", "mInputFontSize", "mInputMode", "mInputMode$annotations", "()V", "mInputRadius", "pwdHeight", "pwdLength", "getPwdLength", "()I", "setPwdLength", "(I)V", "pwdWidth", "showModelMap", "", "Lcom/didiglobal/pay/paysecure/prepaidcard/IShowModel;", "spaceCount", "drawPwdCircle", "", "paint", "Landroid/graphics/Paint;", "canvas", "Landroid/graphics/Canvas;", "cx", "", "cy", "type", "drawRectPwd", "getAttrSet", "init", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTextChanged", "text", "", "start", "lengthBefore", "lengthAfter", "reset", "callback", "Lkotlin/Function0;", "setGapWidth", "unit", "width", "setInputListener", "listener", "setInputMode", "mode", "showError", "updateUI", "Companion", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: CommonPwdEditView.kt */
public final class CommonPwdEditView extends AppCompatEditText {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long ERROR_DELAY = 500;
    public static final int ERROR_SHOW_MODEL = 1;
    public static final int INPUT_MODEL_LAWS = 1;
    public static final int INPUT_MODEL_PWD = 0;
    public static final int NORMAL_SHOW_MODEL = 0;

    /* renamed from: a */
    private int f52872a;

    /* renamed from: b */
    private int f52873b;

    /* renamed from: c */
    private int f52874c;

    /* renamed from: d */
    private int f52875d;

    /* renamed from: e */
    private int f52876e;

    /* renamed from: f */
    private int f52877f;

    /* renamed from: g */
    private InputListener f52878g;

    /* renamed from: h */
    private final Map<Integer, IShowModel> f52879h;

    /* renamed from: i */
    private int f52880i;

    /* renamed from: j */
    private int f52881j;

    /* renamed from: k */
    private int f52882k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f52883l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f52884m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f52885n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f52886o;

    /* renamed from: p */
    private int f52887p;

    /* renamed from: q */
    private boolean f52888q;

    public CommonPwdEditView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public CommonPwdEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* renamed from: a */
    private static /* synthetic */ void m39654a() {
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CommonPwdEditView$Companion;", "", "()V", "ERROR_DELAY", "", "ERROR_SHOW_MODEL", "", "INPUT_MODEL_LAWS", "INPUT_MODEL_PWD", "NORMAL_SHOW_MODEL", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: CommonPwdEditView.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final int getPwdLength() {
        return this.f52874c;
    }

    public final void setPwdLength(int i) {
        this.f52874c = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonPwdEditView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonPwdEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f52874c = 4;
        this.f52875d = 4 - 1;
        this.f52879h = new LinkedHashMap();
        this.f52881j = 10;
        this.f52888q = true;
        m39657a(attributeSet);
        m39659b();
    }

    /* renamed from: a */
    private final void m39657a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.CommonPwdEditView);
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "this.context.obtainStyle…leable.CommonPwdEditView)");
        this.f52880i = obtainStyledAttributes.getInt(8, 0);
        this.f52881j = obtainStyledAttributes.getDimensionPixelOffset(2, 0);
        this.f52882k = obtainStyledAttributes.getDimensionPixelOffset(9, 0);
        this.f52883l = obtainStyledAttributes.getColor(3, Color.parseColor("#E9EAEB"));
        this.f52884m = obtainStyledAttributes.getColor(4, -16777216);
        this.f52885n = obtainStyledAttributes.getColor(0, -65536);
        this.f52886o = obtainStyledAttributes.getColor(1, -65536);
        this.f52887p = obtainStyledAttributes.getDimensionPixelOffset(6, 30);
        this.f52888q = obtainStyledAttributes.getBoolean(5, true);
        int i = obtainStyledAttributes.getInt(7, 4);
        this.f52874c = i;
        this.f52875d = i - 1;
        obtainStyledAttributes.recycle();
    }

    /* renamed from: b */
    private final void m39659b() {
        setCursorVisible(false);
        setBackgroundColor(0);
        List arrayList = new ArrayList();
        arrayList.add(new InputFilter.LengthFilter(this.f52874c));
        Object[] array = arrayList.toArray(new InputFilter[0]);
        if (array != null) {
            setFilters((InputFilter[]) array);
            setInputType(2);
            setFocusableInTouchMode(true);
            requestFocus();
            Map<Integer, IShowModel> map = this.f52879h;
            map.put(0, new CommonPwdEditView$init$$inlined$apply$lambda$1(this));
            map.put(1, new CommonPwdEditView$init$$inlined$apply$lambda$2(this));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f52872a = i;
        this.f52873b = i2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = (getMeasuredWidth() - (this.f52875d * this.f52881j)) / this.f52874c;
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(getMeasuredWidth(), measuredWidth);
        } else {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        m39655a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        InputListener inputListener;
        InputListener inputListener2;
        InputListener inputListener3;
        super.onTextChanged(charSequence, i, i2, i3);
        SystemUtils.log(4, "benzhang", "text:" + charSequence + "  start: " + i + " lengthBefore: " + i2 + " lengthAfter" + i3, (Throwable) null, "com.didiglobal.pay.paysecure.prepaidcard.CommonPwdEditView", 141);
        this.f52876e = Math.min(i3 + i, this.f52874c);
        invalidate();
        if (i > 0 && this.f52876e == this.f52874c && (inputListener3 = this.f52878g) != null) {
            inputListener3.onInputDone(charSequence != null ? charSequence.toString() : null);
        }
        if (this.f52876e == 0 && i2 > 0 && (inputListener2 = this.f52878g) != null) {
            inputListener2.onInputEmpty();
        }
        int i4 = this.f52874c;
        int i5 = this.f52876e;
        if (1 <= i5 && i4 > i5 && (inputListener = this.f52878g) != null) {
            inputListener.onInputChange();
        }
    }

    /* renamed from: a */
    private final void m39655a(Canvas canvas) {
        int i = (this.f52872a - (this.f52875d * this.f52881j)) / this.f52874c;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        IShowModel iShowModel = this.f52879h.get(Integer.valueOf(this.f52877f));
        paint.setColor(iShowModel != null ? iShowModel.getBackgroundColor() : -7829368);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        IShowModel iShowModel2 = this.f52879h.get(Integer.valueOf(this.f52877f));
        paint2.setColor(iShowModel2 != null ? iShowModel2.getInputContentColor() : -16777216);
        int i2 = this.f52874c;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (this.f52881j + i) * i3;
            RectF rectF = new RectF((float) i4, 0.0f, (float) (i4 + i), (float) i);
            if (canvas != null) {
                int i5 = this.f52882k;
                canvas.drawRoundRect(rectF, (float) i5, (float) i5, paint);
            }
            if (this.f52876e > i3) {
                int i6 = i / 2;
                int i7 = i4 + i6;
                int i8 = this.f52880i;
                if (i8 == 0) {
                    m39658a(this, paint2, canvas, (float) i7, (float) i6, 0, 16, (Object) null);
                } else if (i8 == 1) {
                    paint2.setTextSize((float) this.f52887p);
                    paint2.setTextAlign(Paint.Align.CENTER);
                    if (this.f52888q) {
                        paint2.setTypeface(Typeface.DEFAULT_BOLD);
                    }
                    Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
                    float centerY = rectF.centerY() + (((fontMetrics.bottom - fontMetrics.top) / ((float) 2)) - fontMetrics.bottom);
                    if (canvas != null) {
                        Editable text = getText();
                        canvas.drawText(String.valueOf(text != null ? Character.valueOf(text.charAt(i3)) : null), rectF.centerX(), centerY, paint2);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m39658a(CommonPwdEditView commonPwdEditView, Paint paint, Canvas canvas, float f, float f2, int i, int i2, Object obj) {
        commonPwdEditView.m39656a(paint, canvas, f, f2, (i2 & 16) != 0 ? 0 : i);
    }

    /* renamed from: a */
    private final void m39656a(Paint paint, Canvas canvas, float f, float f2, int i) {
        if (canvas != null) {
            canvas.drawCircle(f, f2, 20.0f, paint);
        }
    }

    public final void setInputListener(InputListener inputListener) {
        this.f52878g = inputListener;
    }

    public static /* synthetic */ void setGapWidth$default(CommonPwdEditView commonPwdEditView, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        commonPwdEditView.setGapWidth(i, f);
    }

    public final void setGapWidth(int i, float f) {
        Resources resources = getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "resources");
        this.f52881j = (int) TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
    }

    public final void setInputMode(int i) {
        this.f52880i = i;
    }

    public final void updateUI(int i) {
        this.f52877f = i;
        invalidate();
    }

    public static /* synthetic */ void showError$default(CommonPwdEditView commonPwdEditView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = CommonPwdEditView$showError$1.INSTANCE;
        }
        commonPwdEditView.showError(function0);
    }

    public final void showError(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        updateUI(1);
        postDelayed(new CommonPwdEditView$showError$2(this, function0), 500);
    }

    public static /* synthetic */ void reset$default(CommonPwdEditView commonPwdEditView, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = CommonPwdEditView$reset$1.INSTANCE;
        }
        commonPwdEditView.reset(function0);
    }

    public final void reset(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "callback");
        postDelayed(new CommonPwdEditView$reset$2(this, function0), 50);
    }
}
