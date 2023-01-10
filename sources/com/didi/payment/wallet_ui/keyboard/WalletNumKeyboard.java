package com.didi.payment.wallet_ui.keyboard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import com.appsflyer.internal.referrer.Payload;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.UiUtilsKt;
import com.didi.payment.wallet_ui.keyboard.system.SystemKeyboardListener;
import com.didi.payment.wallet_ui.keyboard.system.SystemKeyboardUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB;\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u0013J&\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010a\u001a\u00020&2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010]J&\u0010c\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010a\u001a\u00020&2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010]J2\u0010d\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u00162\b\b\u0001\u0010e\u001a\u00020\r2\b\b\u0002\u0010a\u001a\u00020&2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010]H\u0002J\u001a\u0010f\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010a\u001a\u00020&J0\u0010g\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u00162\b\b\u0001\u0010e\u001a\u00020\r2\b\b\u0002\u0010a\u001a\u00020&2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010]J6\u0010h\u001a\u00020_2\u0006\u0010B\u001a\u00020\u001a2\b\b\u0003\u0010C\u001a\u00020\r2\b\b\u0003\u0010D\u001a\u00020\r2\b\b\u0002\u0010E\u001a\u00020 2\b\b\u0003\u0010A\u001a\u00020\rJ0\u0010i\u001a\u00020 2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020 2\u0006\u0010m\u001a\u00020 2\u0006\u0010n\u001a\u00020 2\u0006\u0010o\u001a\u00020 H\u0002J\u0010\u0010p\u001a\u00020_2\u0006\u0010j\u001a\u00020kH\u0002J\u0018\u0010q\u001a\u00020_2\u0006\u0010j\u001a\u00020k2\u0006\u0010r\u001a\u00020&H\u0002J\u0018\u0010s\u001a\u0002082\u0006\u0010n\u001a\u00020 2\u0006\u0010o\u001a\u00020 H\u0002J\u000e\u0010t\u001a\u00020_2\u0006\u0010u\u001a\u00020&J\u0006\u0010/\u001a\u00020&J\u0012\u0010v\u001a\u00020_2\b\u0010w\u001a\u0004\u0018\u00010WH\u0016J\u0012\u0010x\u001a\u00020_2\b\u0010j\u001a\u0004\u0018\u00010kH\u0014J\u001a\u0010y\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u00012\u0006\u0010z\u001a\u00020&H\u0016J\b\u0010{\u001a\u00020_H\u0016J\b\u0010|\u001a\u00020_H\u0016J\u0010\u0010}\u001a\u00020_2\u0006\u0010~\u001a\u00020\rH\u0016J\u001a\u0010\u001a\u00020_2\u0007\u0010\u0001\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020\rH\u0014J\u001f\u0010\u0001\u001a\u00020&2\b\u0010`\u001a\u0004\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0015\u0010\u0001\u001a\u00020&2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020&H\u0016J\t\u0010\u0001\u001a\u00020_H\u0002J\u001c\u0010\u0001\u001a\u00020_2\t\b\u0002\u0010\u0001\u001a\u00020&2\b\u0010P\u001a\u0004\u0018\u00010QJ\u0011\u0010\u0001\u001a\u00020_2\b\u0010R\u001a\u0004\u0018\u00010SJ\u0007\u0010\u0001\u001a\u00020_J\u0010\u0010\u0001\u001a\u00020_2\u0007\u0010\u0001\u001a\u00020\rJ\u0011\u0010\u0001\u001a\u00020_2\u0006\u0010u\u001a\u00020&H\u0002J\t\u0010\u0001\u001a\u00020_H\u0002J\t\u0010\u0001\u001a\u00020_H\u0002R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\r0\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001b\u00107\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b;\u0010\u001e\u001a\u0004\b9\u0010:R\u000e\u0010<\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010=\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b?\u0010\u001e\u001a\u0004\b>\u0010:R\u000e\u0010@\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010C\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010D\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\bH\u0010\u001e\u001a\u0004\bG\u0010:R\u001b\u0010I\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\bK\u0010\u001e\u001a\u0004\bJ\u0010:R\u000e\u0010L\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010QX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010WX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020]0\u0015X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/keyboard/WalletNumKeyboard;", "Landroid/view/View;", "Landroid/view/View$OnTouchListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/view/View$OnFocusChangeListener;", "Lcom/didi/payment/wallet_ui/keyboard/system/SystemKeyboardListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "transitionView", "bindWindow", "Landroid/view/Window;", "attrs", "(Landroid/content/Context;Landroid/view/View;Landroid/view/Window;Landroid/util/AttributeSet;I)V", "bindViewMap", "", "Landroid/widget/EditText;", "curView", "curY", "decimalText", "", "getDecimalText", "()Ljava/lang/String;", "decimalText$delegate", "Lkotlin/Lazy;", "decimalTextSize", "", "deleteCorner", "deleteHeight", "deleteStrokeWidth", "deleteWidth", "disableAnim", "", "getDisableAnim", "()Z", "setDisableAnim", "(Z)V", "eventX", "eventY", "finalKeyboardY", "isOk", "isShow", "itemHeight", "itemWidthNumOnly", "itemWidthOk", "keyboardHeight", "keyboardType", "lineColor", "lineWidth", "numDeletePath", "Landroid/graphics/Path;", "getNumDeletePath", "()Landroid/graphics/Path;", "numDeletePath$delegate", "numOnlyTextSize", "numPath", "getNumPath", "numPath$delegate", "numTextSize", "okBtnMaxLine", "okBtnText", "okBtnTextColor", "okBtnTextEmptyColor", "okBtnTextSize", "okDeletePath", "getOkDeletePath", "okDeletePath$delegate", "okPath", "getOkPath", "okPath$delegate", "okTextBg", "okTextBgEmpty", "okTextColorEmpty", "okTextSize", "onHeightChangeListener", "Lcom/didi/payment/wallet_ui/keyboard/OnHeightChangeListener;", "onKeyClickListener", "Lcom/didi/payment/wallet_ui/keyboard/OnKeyClickListener;", "paint", "Landroid/graphics/Paint;", "preAnimator", "Landroid/animation/ValueAnimator;", "preYDiff", "singleLineMaxLength", "startKeyboardY", "systemKeyboardHeight", "viewOkClickMap", "Lcom/didi/payment/wallet_ui/keyboard/OnOkClickListener;", "bindDecimalOkKeyboard", "", "view", "controlByTouch", "onOkClickListener", "bindIntOkKeyboard", "bindKeyboard", "numKeyboardType", "bindNumOnlyKeyboard", "changeBindType", "configOkBtn", "drawNum", "canvas", "Landroid/graphics/Canvas;", "itemTextSize", "itemWidth", "startX", "startY", "drawNumOnlyKeyBoard", "drawOkKeyboard", "isDecimal", "getDeletePath", "hideKeyboard", "hideDirectly", "onAnimationUpdate", "animation", "onDraw", "onFocusChange", "hasFocus", "onKeyBoardAnimEnd", "onKeyBoardAnimStart", "onKeyBoardHeightChange", "height", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouch", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "performClick", "resetTransitionView", "setOnHeightChangeListener", "mixinSystemKeyboard", "setOnKeyClickListener", "showKeyboard", "selectType", "startHideAnimator", "startShowAnimator", "startTransitionView", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletNumKeyboard.kt */
public final class WalletNumKeyboard extends View implements ValueAnimator.AnimatorUpdateListener, View.OnFocusChangeListener, View.OnTouchListener, SystemKeyboardListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int KEY_DELETE = -2;
    public static final int KEY_DOT = -1;
    public static final int KEY_OK = -3;
    public static final int TYPE_DECIMAL = 2;
    public static final int TYPE_INT = 1;
    public static final int TYPE_NUM_ONLY = 3;

    /* renamed from: A */
    private int f35564A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final float f35565B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public final float f35566C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public final float f35567D;

    /* renamed from: E */
    private final float f35568E;

    /* renamed from: F */
    private final float f35569F;

    /* renamed from: G */
    private final int f35570G;

    /* renamed from: H */
    private final float f35571H;

    /* renamed from: I */
    private final float f35572I;

    /* renamed from: J */
    private final float f35573J;

    /* renamed from: K */
    private final float f35574K;

    /* renamed from: L */
    private final float f35575L;

    /* renamed from: M */
    private final float f35576M;

    /* renamed from: N */
    private final float f35577N;

    /* renamed from: O */
    private final Paint f35578O;

    /* renamed from: P */
    private final Lazy f35579P;

    /* renamed from: Q */
    private final Lazy f35580Q;

    /* renamed from: R */
    private final Lazy f35581R;

    /* renamed from: S */
    private final Lazy f35582S;

    /* renamed from: T */
    private final Lazy f35583T;

    /* renamed from: U */
    private ValueAnimator f35584U;

    /* renamed from: V */
    private int f35585V;

    /* renamed from: a */
    private final View f35586a;

    /* renamed from: b */
    private final Window f35587b;

    /* renamed from: c */
    private final int f35588c;

    /* renamed from: d */
    private final int f35589d;

    /* renamed from: e */
    private final float f35590e;

    /* renamed from: f */
    private final int f35591f;

    /* renamed from: g */
    private int f35592g;

    /* renamed from: h */
    private int f35593h;

    /* renamed from: i */
    private String f35594i;

    /* renamed from: j */
    private float f35595j;

    /* renamed from: k */
    private int f35596k;

    /* renamed from: l */
    private int f35597l;

    /* renamed from: m */
    private boolean f35598m;

    /* renamed from: n */
    private boolean f35599n;

    /* renamed from: o */
    private boolean f35600o;

    /* renamed from: p */
    private OnKeyClickListener f35601p;

    /* renamed from: q */
    private OnHeightChangeListener f35602q;

    /* renamed from: r */
    private final Map<EditText, Integer> f35603r;

    /* renamed from: s */
    private final Map<EditText, OnOkClickListener> f35604s;

    /* renamed from: t */
    private int f35605t;

    /* renamed from: u */
    private EditText f35606u;

    /* renamed from: v */
    private float f35607v;

    /* renamed from: w */
    private float f35608w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public final float f35609x;

    /* renamed from: y */
    private int f35610y;

    /* renamed from: z */
    private int f35611z;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletNumKeyboard(Context context, View view, Window window, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : view, (i2 & 4) != 0 ? null : window, (i2 & 8) != 0 ? null : attributeSet, (i2 & 16) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletNumKeyboard(Context context, View view, Window window, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35586a = view;
        this.f35587b = window;
        this.f35588c = Color.parseColor("#F1F2F4");
        this.f35589d = Color.parseColor("#D9DBDD");
        this.f35590e = UiUtils.Companion.floatSize(36);
        this.f35591f = UiUtils.Companion.getThemeBgColor();
        this.f35592g = this.f35589d;
        int i2 = -16777216;
        this.f35593h = UiUtils.Companion.isWhiteInThemeBg() ? -1 : -16777216;
        this.f35594i = Payload.RESPONSE_OK;
        this.f35595j = this.f35590e;
        this.f35596k = 1;
        this.f35597l = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletNumKeyboard);
        setDisableAnim(obtainStyledAttributes.getBoolean(0, false));
        this.f35597l = obtainStyledAttributes.getInt(1, 1);
        String string = obtainStyledAttributes.getString(3);
        if (!TextUtils.isEmpty(string)) {
            Intrinsics.checkNotNull(string);
            this.f35594i = string;
        }
        this.f35593h = obtainStyledAttributes.getColor(4, UiUtils.Companion.isWhiteInThemeBg() ? -1 : i2);
        this.f35592g = obtainStyledAttributes.getColor(5, this.f35589d);
        this.f35595j = obtainStyledAttributes.getDimension(6, this.f35590e);
        this.f35596k = obtainStyledAttributes.getInt(2, 1);
        obtainStyledAttributes.recycle();
        setBackground(new ColorDrawable(-1));
        this.f35603r = new LinkedHashMap();
        this.f35604s = new LinkedHashMap();
        this.f35605t = -1;
        this.f35607v = -1.0f;
        this.f35608w = -1.0f;
        this.f35609x = UiUtils.Companion.floatSize(408);
        int screenHeight = UiUtils.Companion.getScreenHeight();
        this.f35610y = screenHeight;
        this.f35611z = screenHeight - UiUtils.Companion.intSize(408);
        this.f35564A = this.f35610y;
        this.f35565B = this.f35609x / 4.0f;
        this.f35566C = ((float) UiUtils.Companion.getScreenWidth()) / 4.0f;
        this.f35567D = ((float) UiUtils.Companion.getScreenWidth()) / 3.0f;
        this.f35568E = UiUtils.Companion.floatSize(50);
        this.f35569F = UiUtils.Companion.floatSize(44);
        this.f35570G = Color.parseColor("#14000000");
        this.f35571H = UiUtils.Companion.floatSize(1);
        this.f35572I = UiUtils.Companion.floatSize(32);
        this.f35573J = UiUtils.Companion.floatSize(40);
        this.f35574K = this.f35572I / ((float) 8);
        this.f35575L = UiUtils.Companion.floatSize(50);
        this.f35576M = UiUtils.Companion.floatSize(3);
        this.f35577N = this.f35566C - UiUtils.Companion.floatSize(20);
        this.f35578O = new Paint();
        this.f35579P = LazyKt.lazy(WalletNumKeyboard$decimalText$2.INSTANCE);
        this.f35580Q = LazyKt.lazy(LazyThreadSafetyMode.NONE, new WalletNumKeyboard$okPath$2(this));
        this.f35581R = LazyKt.lazy(LazyThreadSafetyMode.NONE, new WalletNumKeyboard$numPath$2(this));
        this.f35582S = LazyKt.lazy(new WalletNumKeyboard$okDeletePath$2(this));
        this.f35583T = LazyKt.lazy(new WalletNumKeyboard$numDeletePath$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletNumKeyboard(Context context) {
        this(context, (View) null, (Window) null, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletNumKeyboard(Context context, AttributeSet attributeSet) {
        this(context, (View) null, (Window) null, attributeSet, 0, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletNumKeyboard(Context context, AttributeSet attributeSet, int i) {
        this(context, (View) null, (Window) null, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
    }

    public final boolean getDisableAnim() {
        return this.f35598m;
    }

    public final void setDisableAnim(boolean z) {
        this.f35598m = z;
    }

    @Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/keyboard/WalletNumKeyboard$Companion;", "", "()V", "KEY_DELETE", "", "KEY_DOT", "KEY_OK", "TYPE_DECIMAL", "TYPE_INT", "TYPE_NUM_ONLY", "bindWindow", "Lcom/didi/payment/wallet_ui/keyboard/WalletNumKeyboard;", "context", "Landroid/content/Context;", "window", "Landroid/view/Window;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletNumKeyboard.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WalletNumKeyboard bindWindow(Context context, Window window) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(window, "window");
            View findViewById = window.findViewById(16908290);
            if (findViewById == null) {
                findViewById = window.getDecorView();
            }
            View view = null;
            ViewGroup viewGroup = findViewById instanceof ViewGroup ? (ViewGroup) findViewById : null;
            if (viewGroup == null) {
                return null;
            }
            if (viewGroup.getChildCount() > 0) {
                view = viewGroup.getChildAt(0);
            }
            WalletNumKeyboard walletNumKeyboard = new WalletNumKeyboard(context, view, window, (AttributeSet) null, 0, 24, (DefaultConstructorMarker) null);
            walletNumKeyboard.setVisibility(8);
            viewGroup.addView(walletNumKeyboard, new ViewGroup.LayoutParams(-1, -2));
            return walletNumKeyboard;
        }
    }

    public final boolean isShow() {
        return this.f35600o;
    }

    public static /* synthetic */ void configOkBtn$default(WalletNumKeyboard walletNumKeyboard, String str, int i, int i2, float f, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = UiUtils.Companion.isWhiteInThemeBg() ? -1 : -16777216;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = walletNumKeyboard.f35589d;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            f = walletNumKeyboard.f35590e;
        }
        walletNumKeyboard.configOkBtn(str, i5, i6, f, (i4 & 16) != 0 ? 1 : i3);
    }

    public final void configOkBtn(String str, int i, int i2, float f, int i3) {
        Intrinsics.checkNotNullParameter(str, "okBtnText");
        if (!TextUtils.isEmpty(str)) {
            this.f35594i = str;
        }
        this.f35593h = i;
        this.f35592g = i2;
        if (f > 0.0f) {
            this.f35595j = f;
        }
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 2) {
            i3 = 2;
        }
        this.f35596k = i3;
        invalidate();
    }

    public final void setOnKeyClickListener(OnKeyClickListener onKeyClickListener) {
        this.f35601p = onKeyClickListener;
    }

    public static /* synthetic */ void setOnHeightChangeListener$default(WalletNumKeyboard walletNumKeyboard, boolean z, OnHeightChangeListener onHeightChangeListener, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        walletNumKeyboard.setOnHeightChangeListener(z, onHeightChangeListener);
    }

    public final void setOnHeightChangeListener(boolean z, OnHeightChangeListener onHeightChangeListener) {
        if (z && this.f35587b != null) {
            SystemKeyboardUtils.Companion.setSystemKeyboardListener(this.f35587b.getDecorView(), this);
        }
        this.f35602q = onHeightChangeListener;
    }

    public static /* synthetic */ void bindIntOkKeyboard$default(WalletNumKeyboard walletNumKeyboard, EditText editText, boolean z, OnOkClickListener onOkClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            onOkClickListener = null;
        }
        walletNumKeyboard.bindIntOkKeyboard(editText, z, onOkClickListener);
    }

    public final void bindIntOkKeyboard(EditText editText, boolean z, OnOkClickListener onOkClickListener) {
        m26899a(editText, 1, z, onOkClickListener);
    }

    public static /* synthetic */ void bindDecimalOkKeyboard$default(WalletNumKeyboard walletNumKeyboard, EditText editText, boolean z, OnOkClickListener onOkClickListener, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            onOkClickListener = null;
        }
        walletNumKeyboard.bindDecimalOkKeyboard(editText, z, onOkClickListener);
    }

    public final void bindDecimalOkKeyboard(EditText editText, boolean z, OnOkClickListener onOkClickListener) {
        m26899a(editText, 2, z, onOkClickListener);
    }

    public static /* synthetic */ void bindNumOnlyKeyboard$default(WalletNumKeyboard walletNumKeyboard, EditText editText, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        walletNumKeyboard.bindNumOnlyKeyboard(editText, z);
    }

    public final void bindNumOnlyKeyboard(EditText editText, boolean z) {
        m26900a(this, editText, 3, z, (OnOkClickListener) null, 8, (Object) null);
    }

    /* renamed from: a */
    static /* synthetic */ void m26900a(WalletNumKeyboard walletNumKeyboard, EditText editText, int i, boolean z, OnOkClickListener onOkClickListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            onOkClickListener = null;
        }
        walletNumKeyboard.m26899a(editText, i, z, onOkClickListener);
    }

    /* renamed from: a */
    private final void m26899a(EditText editText, @WalletNumKeyboardType int i, boolean z, OnOkClickListener onOkClickListener) {
        if (editText != null) {
            UiUtilsKt.disableShowSoftInputOnFocus(editText);
            this.f35603r.put(editText, Integer.valueOf(i));
            if (editText.hasFocus()) {
                showKeyboard(i);
            }
            if (z) {
                editText.setOnTouchListener(this);
            } else {
                editText.setOnFocusChangeListener(this);
            }
            if (onOkClickListener != null) {
                this.f35604s.put(editText, onOkClickListener);
            }
        }
    }

    public final void showKeyboard() {
        showKeyboard(this.f35597l);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showKeyboard(int r4) {
        /*
            r3 = this;
            android.widget.EditText r0 = r3.f35606u
            r1 = 0
            if (r0 != 0) goto L_0x0007
        L_0x0005:
            r0 = 0
            goto L_0x0012
        L_0x0007:
            android.text.Editable r0 = r0.getText()
            if (r0 != 0) goto L_0x000e
            goto L_0x0005
        L_0x000e:
            int r0 = r0.length()
        L_0x0012:
            r2 = 1
            if (r0 <= 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            r3.f35599n = r0
            r3.setVisibility(r1)
            boolean r0 = r3.f35600o
            if (r0 != 0) goto L_0x0029
            r3.f35600o = r2
            r0 = r3
            android.view.View r0 = (android.view.View) r0
            com.didi.payment.wallet_ui.UiUtilsKt.hideSystemInputMethod(r0)
        L_0x0029:
            r3.f35597l = r4
            r3.invalidate()
            r3.m26896a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet_ui.keyboard.WalletNumKeyboard.showKeyboard(int):void");
    }

    public final void hideKeyboard(boolean z) {
        if (this.f35600o) {
            this.f35600o = false;
            m26901a(z);
        }
    }

    public static /* synthetic */ void changeBindType$default(WalletNumKeyboard walletNumKeyboard, EditText editText, int i, boolean z, OnOkClickListener onOkClickListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            onOkClickListener = null;
        }
        walletNumKeyboard.changeBindType(editText, i, z, onOkClickListener);
    }

    public final void changeBindType(EditText editText, @WalletNumKeyboardType int i, boolean z, OnOkClickListener onOkClickListener) {
        if (editText != null) {
            this.f35603r.put(editText, Integer.valueOf(i));
            if (onOkClickListener != null) {
                this.f35604s.put(editText, onOkClickListener);
            }
            if (z) {
                editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            } else {
                editText.setOnTouchListener(this);
            }
            if (editText.hasFocus()) {
                showKeyboard(i);
            }
        }
    }

    public void onKeyBoardAnimStart() {
        this.f35605t = -1;
    }

    public void onKeyBoardHeightChange(int i) {
        OnHeightChangeListener onHeightChangeListener;
        int i2 = this.f35605t;
        if (i2 == -1) {
            this.f35605t = i;
        } else if (i2 != i) {
            if (i > i2) {
                if (this.f35606u != null) {
                    hideKeyboard(true);
                    this.f35606u = null;
                }
                OnHeightChangeListener onHeightChangeListener2 = this.f35602q;
                if (onHeightChangeListener2 != null) {
                    onHeightChangeListener2.onHeightChange(i);
                }
            } else if (!this.f35600o && (onHeightChangeListener = this.f35602q) != null) {
                onHeightChangeListener.onHeightChange(i);
            }
            this.f35605t = i;
        }
    }

    public void onKeyBoardAnimEnd() {
        this.f35605t = -1;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        Integer num;
        boolean z = true;
        if (motionEvent == null || motionEvent.getAction() != 1) {
            z = false;
        }
        if (!(!z || view == null || (num = this.f35603r.get(view)) == null)) {
            int intValue = num.intValue();
            this.f35606u = view instanceof EditText ? (EditText) view : null;
            showKeyboard(intValue);
        }
        return false;
    }

    public void onFocusChange(View view, boolean z) {
        boolean z2;
        Map.Entry next;
        int i;
        Editable text;
        if (view != null) {
            if (z) {
                Integer num = this.f35603r.get(view);
                if (num != null) {
                    int intValue = num.intValue();
                    this.f35606u = view instanceof EditText ? (EditText) view : null;
                    showKeyboard(intValue);
                    return;
                }
                return;
            }
            Iterator<Map.Entry<EditText, Integer>> it = this.f35603r.entrySet().iterator();
            do {
                z2 = false;
                if (it.hasNext()) {
                    next = it.next();
                } else {
                    hideKeyboard(false);
                    return;
                }
            } while (!((EditText) next.getKey()).hasFocus());
            this.f35597l = ((Number) next.getValue()).intValue();
            EditText editText = (EditText) next.getKey();
            this.f35606u = editText;
            if (editText == null || (text = editText.getText()) == null) {
                i = 0;
            } else {
                i = text.length();
            }
            if (i > 0) {
                z2 = true;
            }
            this.f35599n = z2;
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer valueOf = motionEvent == null ? null : Integer.valueOf(motionEvent.getAction());
        if (valueOf != null && valueOf.intValue() == 0) {
            this.f35607v = motionEvent.getX();
            this.f35608w = motionEvent.getY();
        } else if (valueOf != null && valueOf.intValue() == 1) {
            performClick();
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0145, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean performClick() {
        /*
            r12 = this;
            float r0 = r12.f35607v
            r1 = 0
            r2 = 0
            int r3 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x0161
            float r3 = r12.f35608w
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0010
            goto L_0x0161
        L_0x0010:
            float r1 = r12.f35565B
            float r3 = r3 / r1
            int r1 = r12.f35597l
            r4 = -2
            java.lang.String r5 = "0"
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = 3
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 1
            r10 = 2
            r11 = 1077936128(0x40400000, float:3.0)
            if (r1 == r9) goto L_0x007f
            if (r1 == r10) goto L_0x007f
            if (r1 == r7) goto L_0x0029
            goto L_0x013f
        L_0x0029:
            float r1 = r12.f35567D
            float r0 = r0 / r1
            int r1 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x004d
            int r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x004d
            int r0 = (int) r0
            int r1 = (int) r3
            int r1 = r1 * 3
            int r0 = r0 + r1
            int r0 = r0 + r9
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r1 = r12.f35601p
            if (r1 != 0) goto L_0x003f
            goto L_0x0042
        L_0x003f:
            r1.onKeyClick(r0)
        L_0x0042:
            android.widget.EditText r1 = r12.f35606u
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.didi.payment.wallet_ui.UiUtilsKt.insert(r1, r0)
            goto L_0x013f
        L_0x004d:
            int r1 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0068
            int r1 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x0068
            int r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x0068
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r0 = r12.f35601p
            if (r0 != 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r0.onKeyClick(r2)
        L_0x0061:
            android.widget.EditText r0 = r12.f35606u
            com.didi.payment.wallet_ui.UiUtilsKt.insert(r0, r5)
            goto L_0x013f
        L_0x0068:
            int r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x013f
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x013f
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r0 = r12.f35601p
            if (r0 != 0) goto L_0x0075
            goto L_0x0078
        L_0x0075:
            r0.onKeyClick(r4)
        L_0x0078:
            android.widget.EditText r0 = r12.f35606u
            com.didi.payment.wallet_ui.UiUtilsKt.delete(r0)
            goto L_0x013f
        L_0x007f:
            float r0 = r12.f35607v
            float r1 = r12.f35566C
            float r0 = r0 / r1
            int r1 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b8
            int r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b8
            int r0 = (int) r0
            int r1 = (int) r3
            int r1 = r1 * 3
            int r0 = r0 + r1
            int r0 = r0 + r9
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r1 = r12.f35601p
            if (r1 != 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            r1.onKeyClick(r0)
        L_0x009a:
            int r1 = r12.f35597l
            if (r1 != r10) goto L_0x00ad
            android.widget.EditText r1 = r12.f35606u
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = r12.getDecimalText()
            com.didi.payment.wallet_ui.UiUtilsKt.insertNum(r1, r0, r3)
            goto L_0x013f
        L_0x00ad:
            android.widget.EditText r1 = r12.f35606u
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.didi.payment.wallet_ui.UiUtilsKt.insert(r1, r0)
            goto L_0x013f
        L_0x00b8:
            int r1 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r1 >= 0) goto L_0x00dd
            int r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x00dd
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r0 = r12.f35601p
            if (r0 != 0) goto L_0x00c5
            goto L_0x00c8
        L_0x00c5:
            r0.onKeyClick(r2)
        L_0x00c8:
            int r0 = r12.f35597l
            if (r0 != r10) goto L_0x00d7
            android.widget.EditText r0 = r12.f35606u
            java.lang.String r1 = r12.getDecimalText()
            com.didi.payment.wallet_ui.UiUtilsKt.insertNum(r0, r5, r1)
            goto L_0x013f
        L_0x00d7:
            android.widget.EditText r0 = r12.f35606u
            com.didi.payment.wallet_ui.UiUtilsKt.insert(r0, r5)
            goto L_0x013f
        L_0x00dd:
            float r1 = (float) r10
            float r1 = r0 - r1
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ff
            int r1 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ff
            int r1 = r12.f35597l
            if (r1 != r10) goto L_0x00ff
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r0 = r12.f35601p
            if (r0 != 0) goto L_0x00f1
            goto L_0x00f5
        L_0x00f1:
            r1 = -1
            r0.onKeyClick(r1)
        L_0x00f5:
            android.widget.EditText r0 = r12.f35606u
            java.lang.String r1 = r12.getDecimalText()
            com.didi.payment.wallet_ui.UiUtilsKt.insertDecimal(r0, r1)
            goto L_0x013f
        L_0x00ff:
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x0115
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0115
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r0 = r12.f35601p
            if (r0 != 0) goto L_0x010c
            goto L_0x010f
        L_0x010c:
            r0.onKeyClick(r4)
        L_0x010f:
            android.widget.EditText r0 = r12.f35606u
            com.didi.payment.wallet_ui.UiUtilsKt.delete(r0)
            goto L_0x013f
        L_0x0115:
            if (r0 <= 0) goto L_0x013f
            int r0 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x013f
            boolean r0 = r12.f35599n
            if (r0 == 0) goto L_0x013f
            com.didi.payment.wallet_ui.keyboard.OnKeyClickListener r0 = r12.f35601p
            if (r0 != 0) goto L_0x0124
            goto L_0x0128
        L_0x0124:
            r1 = -3
            r0.onKeyClick(r1)
        L_0x0128:
            java.util.Map<android.widget.EditText, com.didi.payment.wallet_ui.keyboard.OnOkClickListener> r0 = r12.f35604s
            android.widget.EditText r1 = r12.f35606u
            if (r1 != 0) goto L_0x0133
            boolean r0 = super.performClick()
            return r0
        L_0x0133:
            java.lang.Object r0 = r0.get(r1)
            com.didi.payment.wallet_ui.keyboard.OnOkClickListener r0 = (com.didi.payment.wallet_ui.keyboard.OnOkClickListener) r0
            if (r0 != 0) goto L_0x013c
            goto L_0x013f
        L_0x013c:
            r0.onOkClick()
        L_0x013f:
            android.widget.EditText r0 = r12.f35606u
            if (r0 != 0) goto L_0x0145
        L_0x0143:
            r0 = 0
            goto L_0x0150
        L_0x0145:
            android.text.Editable r0 = r0.getText()
            if (r0 != 0) goto L_0x014c
            goto L_0x0143
        L_0x014c:
            int r0 = r0.length()
        L_0x0150:
            if (r0 <= 0) goto L_0x0153
            r2 = 1
        L_0x0153:
            boolean r0 = r12.f35599n
            if (r2 == r0) goto L_0x015c
            r12.f35599n = r2
            r12.invalidate()
        L_0x015c:
            boolean r0 = super.performClick()
            return r0
        L_0x0161:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet_ui.keyboard.WalletNumKeyboard.performClick():boolean");
    }

    private final String getDecimalText() {
        return (String) this.f35579P.getValue();
    }

    private final Path getOkPath() {
        return (Path) this.f35580Q.getValue();
    }

    private final Path getNumPath() {
        return (Path) this.f35581R.getValue();
    }

    private final Path getOkDeletePath() {
        return (Path) this.f35582S.getValue();
    }

    private final Path getNumDeletePath() {
        return (Path) this.f35583T.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final Path m26895a(float f, float f2) {
        Path path = new Path();
        path.moveTo(f, f2);
        float f3 = this.f35572I;
        float f4 = (float) 2;
        float f5 = f3 / f4;
        float f6 = this.f35573J - f3;
        float f7 = -f5;
        path.rLineTo(f6, f7);
        path.rLineTo(this.f35572I - this.f35574K, 0.0f);
        float f8 = this.f35574K;
        path.rQuadTo(f8, 0.0f, f8, f8);
        path.rLineTo(0.0f, this.f35572I - (this.f35574K * f4));
        float f9 = this.f35574K;
        path.rQuadTo(0.0f, f9, -f9, f9);
        path.rLineTo(this.f35574K - this.f35572I, 0.0f);
        path.rLineTo(-f6, f7);
        path.rMoveTo(f6 + (f5 / f4), f7 / f4);
        path.rLineTo(f5, f5);
        path.rMoveTo(f7, 0.0f);
        path.rLineTo(f5, f7);
        return path;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(UiUtils.Companion.getScreenWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(UiUtils.Companion.intSize(408), 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            int i = this.f35597l;
            if (i == 1) {
                m26898a(canvas, false);
            } else if (i == 2) {
                m26898a(canvas, true);
            } else if (i == 3) {
                m26897a(canvas);
            }
        }
    }

    /* renamed from: a */
    private final void m26898a(Canvas canvas, boolean z) {
        Canvas canvas2 = canvas;
        Path okPath = getOkPath();
        Paint paint = this.f35578O;
        paint.reset();
        paint.setStrokeWidth(this.f35571H);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.f35570G);
        Unit unit = Unit.INSTANCE;
        canvas2.drawPath(okPath, paint);
        float f = this.f35566C;
        float f2 = (float) 2;
        float f3 = f / f2;
        float f4 = this.f35565B;
        float f5 = f4 / f2;
        float f6 = (float) 3;
        canvas2.drawText("0", f, (f5 + (f4 * f6)) - m26894a(canvas, this.f35568E, f, f3, f5), this.f35578O);
        if (z) {
            float f7 = this.f35609x - (this.f35565B / f6);
            Paint paint2 = this.f35578O;
            paint2.reset();
            paint2.setTextSize(this.f35575L);
            paint2.setColor(-16777216);
            paint2.setStrokeCap(Paint.Cap.SQUARE);
            Unit unit2 = Unit.INSTANCE;
            canvas2.drawText(getDecimalText(), (this.f35566C * f2) + f3, f7, paint2);
        }
        Path okDeletePath = getOkDeletePath();
        Paint paint3 = this.f35578O;
        paint3.reset();
        paint3.setStrokeWidth(this.f35576M);
        paint3.setColor(-16777216);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setAntiAlias(true);
        Unit unit3 = Unit.INSTANCE;
        canvas2.drawPath(okDeletePath, paint3);
        float f8 = this.f35566C;
        float f9 = f6 * f8;
        float f10 = this.f35565B;
        float f11 = ((float) 4) * f8;
        float f12 = this.f35609x;
        Paint paint4 = this.f35578O;
        paint4.reset();
        paint4.setColor(this.f35599n ? this.f35591f : this.f35588c);
        paint4.setStyle(Paint.Style.FILL);
        Unit unit4 = Unit.INSTANCE;
        canvas.drawRect(f9, f10, f11, f12, paint4);
        int i = this.f35596k;
        float f13 = ((float) i) * this.f35577N;
        Paint paint5 = this.f35578O;
        paint5.reset();
        paint5.setTextSize(this.f35595j);
        paint5.setColor(this.f35599n ? this.f35593h : this.f35592g);
        paint5.setAntiAlias(true);
        paint5.setTypeface(Typeface.DEFAULT_BOLD);
        float measureText = paint5.measureText(this.f35594i);
        if (measureText < this.f35577N) {
            i = 1;
        } else if (measureText > f13) {
            paint5.setTextSize((f13 * paint5.getTextSize()) / (measureText + ((f2 * measureText) / ((float) this.f35594i.length()))));
        }
        Paint.FontMetrics fontMetrics = paint5.getFontMetrics();
        float f14 = fontMetrics.descent - fontMetrics.ascent;
        float f15 = (fontMetrics.top + fontMetrics.bottom) / f2;
        if (i == 1) {
            canvas2.drawText(this.f35594i, f3 + (f6 * this.f35566C), (f5 + (f2 * this.f35565B)) - f15, this.f35578O);
            return;
        }
        Paint paint6 = this.f35578O;
        String str = this.f35594i;
        int breakText = paint6.breakText(str, 0, str.length(), true, this.f35577N, (float[]) null);
        String str2 = this.f35594i;
        if (str2 != null) {
            String substring = str2.substring(0, breakText);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            float f16 = f14 / f2;
            canvas2.drawText(substring, (this.f35566C * f6) + f3, (((this.f35565B * f2) + f5) - f16) - f15, this.f35578O);
            String str3 = this.f35594i;
            if (str3 != null) {
                String substring2 = str3.substring(breakText);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
                canvas2.drawText(substring2, f3 + (f6 * this.f35566C), ((f5 + (f2 * this.f35565B)) + f16) - f15, this.f35578O);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private final void m26897a(Canvas canvas) {
        Path numPath = getNumPath();
        Paint paint = this.f35578O;
        paint.reset();
        paint.setStrokeWidth(this.f35571H);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.f35570G);
        Unit unit = Unit.INSTANCE;
        canvas.drawPath(numPath, paint);
        float f = this.f35567D;
        float f2 = (float) 2;
        float f3 = f / f2;
        float f4 = this.f35565B;
        float f5 = f4 / f2;
        canvas.drawText("0", f3 + f, (this.f35609x - (f4 / f2)) - m26894a(canvas, this.f35569F, f, f3, f5), this.f35578O);
        Path numDeletePath = getNumDeletePath();
        Paint paint2 = this.f35578O;
        paint2.reset();
        paint2.setStrokeWidth(this.f35576M);
        paint2.setColor(-16777216);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setAntiAlias(true);
        Unit unit2 = Unit.INSTANCE;
        canvas.drawPath(numDeletePath, paint2);
    }

    /* renamed from: a */
    private final float m26894a(Canvas canvas, float f, float f2, float f3, float f4) {
        Paint paint = this.f35578O;
        paint.reset();
        paint.setTextSize(f);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setColor(-16777216);
        paint.setAntiAlias(true);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        float f5 = (paint.getFontMetrics().top + paint.getFontMetrics().bottom) / ((float) 2);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                canvas.drawText(String.valueOf((i3 * 3) + i + 1), (((float) i) * f2) + f3, ((((float) i3) * this.f35565B) + f4) - f5, this.f35578O);
                if (i4 > 2) {
                    break;
                }
                i3 = i4;
            }
            if (i2 > 2) {
                return f5;
            }
            i = i2;
        }
    }

    /* renamed from: a */
    private final void m26896a() {
        if (!this.f35598m) {
            ValueAnimator valueAnimator = this.f35584U;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            int i = this.f35564A;
            int i2 = this.f35611z;
            if (i <= i2) {
                this.f35564A = i2;
                setY((float) i2);
                m26902b();
                OnHeightChangeListener onHeightChangeListener = this.f35602q;
                if (onHeightChangeListener != null) {
                    onHeightChangeListener.onHeightChange((int) this.f35609x);
                    return;
                }
                return;
            }
            m26902b();
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f35564A, this.f35611z});
            long j = (long) (((float) ((this.f35564A - this.f35611z) * 300)) / this.f35609x);
            if (j <= 0) {
                j = 0;
            }
            ofInt.setDuration(j);
            ofInt.addUpdateListener(this);
            ofInt.start();
            Unit unit = Unit.INSTANCE;
            this.f35584U = ofInt;
        }
    }

    /* renamed from: b */
    private final void m26902b() {
        EditText editText;
        if (this.f35586a != null && (editText = this.f35606u) != null) {
            int[] iArr = new int[2];
            editText.getLocationOnScreen(iArr);
            int height = (iArr[1] + editText.getHeight()) - this.f35611z;
            if (height > 0) {
                this.f35585V += height;
                View view = this.f35586a;
                view.setY(view.getY() - ((float) height));
            }
        }
    }

    /* renamed from: c */
    private final void m26903c() {
        if (this.f35585V != 0) {
            View view = this.f35586a;
            if (view != null) {
                view.setY(view.getY() + ((float) this.f35585V));
            }
            this.f35585V = 0;
        }
    }

    /* renamed from: a */
    private final void m26901a(boolean z) {
        if (!this.f35598m) {
            ValueAnimator valueAnimator = this.f35584U;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            m26903c();
            int i = this.f35564A;
            int i2 = this.f35610y;
            if (i - i2 <= 1 || z) {
                int i3 = this.f35610y;
                this.f35564A = i3;
                setY((float) i3);
                OnHeightChangeListener onHeightChangeListener = this.f35602q;
                if (onHeightChangeListener != null) {
                    onHeightChangeListener.onHeightChange(0);
                    return;
                }
                return;
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
            long j = (long) (((float) ((this.f35610y - this.f35564A) * 300)) / this.f35609x);
            if (j <= 0) {
                j = 0;
            }
            ofInt.setDuration(j);
            ofInt.addUpdateListener(this);
            ofInt.start();
            Unit unit = Unit.INSTANCE;
            this.f35584U = ofInt;
        }
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (valueAnimator != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
            int intValue = num == null ? this.f35600o ? this.f35611z : this.f35610y : num.intValue();
            this.f35564A = intValue;
            setY((float) intValue);
            OnHeightChangeListener onHeightChangeListener = this.f35602q;
            if (onHeightChangeListener != null) {
                onHeightChangeListener.onHeightChange(this.f35610y - this.f35564A);
            }
        }
    }
}
