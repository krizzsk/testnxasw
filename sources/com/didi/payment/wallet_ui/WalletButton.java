package com.didi.payment.wallet_ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.passenger.C11267R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\b\u0010\u0019\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001b\u001a\u00020\u0013H\u0002J\u0018\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020 H\u0016R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/WalletButton;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "btnLevel", "corner", "", "pressedEndColor", "pressedForeBgColorInt", "pressedStartColor", "secondLevelPressedColor", "sizeType", "widthType", "configAttr", "", "configButton", "content", "", "clickListener", "Landroid/view/View$OnClickListener;", "configEnableBg", "configPressedBg", "configUnableBg", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "setEnabled", "enabled", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletButton.kt */
public final class WalletButton extends AppCompatTextView {

    /* renamed from: A */
    private static final int f35427A = Color.parseColor("#D4D7D9");

    /* renamed from: B */
    private static final int f35428B = Color.parseColor(ColorUtils.DIDI_GREY);

    /* renamed from: C */
    private static final int f35429C = Color.parseColor(ColorUtils.DIDI_GREY);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int LEVEL_FIRST = 1;
    public static final int LEVEL_SECOND = 2;
    public static final int TYPE_BIG = 1;
    public static final int TYPE_MID = 2;
    public static final int TYPE_SMALL = 3;
    public static final int WIDTH_TYPE_MAX = 3;
    public static final int WIDTH_TYPE_MIN = 2;
    public static final int WIDTH_TYPE_WRAP = 1;

    /* renamed from: i */
    private static final int f35430i;

    /* renamed from: j */
    private static final int f35431j;

    /* renamed from: k */
    private static final int f35432k = UiUtils.Companion.intSize(32);

    /* renamed from: l */
    private static final int f35433l = UiUtils.Companion.intSize(30);

    /* renamed from: m */
    private static final int f35434m = UiUtils.Companion.intSize(21);

    /* renamed from: n */
    private static final int f35435n = UiUtils.Companion.intSize(15);

    /* renamed from: o */
    private static final int f35436o = UiUtils.Companion.intSize(104);

    /* renamed from: p */
    private static final int f35437p = UiUtils.Companion.intSize(80);

    /* renamed from: q */
    private static final int f35438q = UiUtils.Companion.intSize(200);

    /* renamed from: r */
    private static final int f35439r = UiUtils.Companion.intSize(670);

    /* renamed from: s */
    private static final float f35440s = UiUtils.Companion.floatSize(40);

    /* renamed from: t */
    private static final int f35441t = UiUtils.Companion.intSize(260);

    /* renamed from: u */
    private static final int f35442u = UiUtils.Companion.intSize(345);

    /* renamed from: v */
    private static final float f35443v = UiUtils.Companion.floatSize(32);

    /* renamed from: w */
    private static final int f35444w = UiUtils.Companion.intSize(140);

    /* renamed from: x */
    private static final int f35445x = UiUtils.Companion.intSize(212);

    /* renamed from: y */
    private static final int f35446y = UiUtils.Companion.intSize(60);

    /* renamed from: z */
    private static final float f35447z = UiUtils.Companion.floatSize(24);

    /* renamed from: a */
    private int f35448a;

    /* renamed from: b */
    private float f35449b;

    /* renamed from: c */
    private int f35450c;

    /* renamed from: d */
    private int f35451d;

    /* renamed from: e */
    private final int f35452e;

    /* renamed from: f */
    private final int f35453f;

    /* renamed from: g */
    private final int f35454g;

    /* renamed from: h */
    private final int f35455h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 16842884 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35448a = 1;
        this.f35450c = 1;
        this.f35451d = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletButton);
        if (!obtainStyledAttributes.getBoolean(3, false)) {
            this.f35448a = obtainStyledAttributes.getInt(2, 1);
            this.f35451d = obtainStyledAttributes.getInt(0, 1);
            int i2 = obtainStyledAttributes.getInt(4, 1);
            this.f35450c = i2;
            configAttr(this.f35448a, this.f35451d, i2);
        }
        obtainStyledAttributes.recycle();
        int parseColor = Color.parseColor("#1A000000");
        this.f35452e = parseColor;
        this.f35453f = androidx.core.graphics.ColorUtils.compositeColors(parseColor, UiUtils.Companion.getWalletFirstLevelButtonBgStartColor());
        this.f35454g = androidx.core.graphics.ColorUtils.compositeColors(this.f35452e, UiUtils.Companion.getWalletFirstLevelButtonBgEndColor());
        this.f35455h = Color.parseColor("#E9EAEB");
    }

    public final void configButton(CharSequence charSequence, View.OnClickListener onClickListener) {
        setText(charSequence);
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/WalletButton$Companion;", "", "()V", "LEVEL_FIRST", "", "LEVEL_SECOND", "TYPE_BIG", "TYPE_MID", "TYPE_SMALL", "WIDTH_TYPE_MAX", "WIDTH_TYPE_MIN", "WIDTH_TYPE_WRAP", "heightBig", "heightMid", "heightSmall", "maxWidthBig", "maxWidthMid", "maxWidthSmall", "minWidthBig", "minWidthMid", "minWidthSmall", "paddingBigLR", "paddingBigTB", "paddingMidLR", "paddingMidTB", "paddingSmallLR", "paddingSmallTB", "secondEnableBgColor", "textSizeBig", "", "textSizeMid", "textSizeSmall", "unableBgColor", "unableTextColor", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletButton.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        int intSize = UiUtils.Companion.intSize(40);
        f35430i = intSize;
        f35431j = intSize;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.f35448a;
        if (i7 == 1) {
            i5 = f35438q;
            i4 = f35439r;
            i3 = f35430i;
        } else if (i7 != 2) {
            i5 = f35444w;
            i4 = f35445x;
            i3 = f35432k;
        } else {
            i5 = f35441t;
            i4 = f35442u;
            i3 = f35431j;
        }
        if (getText() == null) {
            i6 = i3 * 2;
        } else {
            i6 = (i3 * 2) + ((int) getPaint().measureText(getText().toString()));
        }
        int i8 = this.f35450c;
        if (i8 == 2) {
            i = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        } else if (i8 == 3) {
            i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        } else if (i6 > i4) {
            i = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public final void configAttr(int i, int i2, int i3) {
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        setGravity(17);
        setTypeface(Typeface.DEFAULT_BOLD);
        setIncludeFontPadding(false);
        this.f35448a = i;
        if (i == 1) {
            setTextSize(0, f35440s);
            int i4 = f35430i;
            int i5 = f35433l;
            setPadding(i4, i5, i4, i5);
            this.f35449b = UiUtils.Companion.getBigBtnCornerFraction() * ((float) f35436o);
        } else if (i == 2) {
            setTextSize(0, f35443v);
            int i6 = f35431j;
            int i7 = f35434m;
            setPadding(i6, i7, i6, i7);
            this.f35449b = UiUtils.Companion.getMidBtnCornerFraction() * ((float) f35437p);
        } else if (i == 3) {
            setTextSize(0, f35447z);
            int i8 = f35432k;
            int i9 = f35435n;
            setPadding(i8, i9, i8, i9);
            this.f35449b = UiUtils.Companion.getSmallBtnCornerFraction() * ((float) f35446y);
        }
        this.f35451d = i2;
        this.f35450c = i3;
        setText(getText());
        setEnabled(isEnabled());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Integer num;
        if (!isEnabled() || !isClickable()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent == null) {
            num = null;
        } else {
            num = Integer.valueOf(motionEvent.getAction());
        }
        if (num != null && num.intValue() == 0) {
            m26874a();
        } else {
            boolean z = true;
            if ((num == null || num.intValue() != 1) && (num == null || num.intValue() != 3)) {
                z = false;
            }
            if (z) {
                m26876c();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    private final void m26874a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f35449b);
        int i = -16777216;
        if (this.f35451d == 1) {
            int i2 = this.f35452e;
            if (UiUtils.Companion.isWhiteInThemeBg()) {
                i = -1;
            }
            setTextColor(androidx.core.graphics.ColorUtils.compositeColors(i2, i));
            gradientDrawable.setOrientation(UiUtils.Companion.getWalletFirstLevelButtonBgColorOrientation());
            gradientDrawable.setColors(new int[]{this.f35453f, this.f35454g});
        } else {
            setTextColor(androidx.core.graphics.ColorUtils.compositeColors(this.f35452e, -16777216));
            IWalletSecondButtonConfig walletSecondButtonConfig = UiUtils.Companion.getWalletSecondButtonConfig();
            if (walletSecondButtonConfig != null) {
                if (walletSecondButtonConfig.getBorderWidth() > 0) {
                    gradientDrawable.setStroke(walletSecondButtonConfig.getBorderWidth(), walletSecondButtonConfig.getPressedBorderColor());
                }
                gradientDrawable.setColor(walletSecondButtonConfig.getPressedBgColor());
            } else {
                gradientDrawable.setColor(this.f35455h);
            }
        }
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (this.f35451d > 0) {
            if (!isEnabled()) {
                m26875b();
            } else {
                m26876c();
            }
        }
    }

    /* renamed from: b */
    private final void m26875b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        setTextColor(f35427A);
        gradientDrawable.setCornerRadius(this.f35449b);
        if (this.f35451d == 1) {
            gradientDrawable.setColor(f35428B);
        } else {
            IWalletSecondButtonConfig walletSecondButtonConfig = UiUtils.Companion.getWalletSecondButtonConfig();
            if (walletSecondButtonConfig != null) {
                if (walletSecondButtonConfig.getBorderWidth() > 0) {
                    gradientDrawable.setStroke(walletSecondButtonConfig.getBorderWidth(), walletSecondButtonConfig.getUnableBorderColor());
                }
                gradientDrawable.setColor(walletSecondButtonConfig.getUnableBgColor());
            } else {
                gradientDrawable.setColor(f35428B);
            }
        }
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    /* renamed from: c */
    private final void m26876c() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f35449b);
        int i = -16777216;
        if (this.f35451d == 1) {
            if (UiUtils.Companion.isWhiteInThemeBg()) {
                i = -1;
            }
            setTextColor(i);
            gradientDrawable.setOrientation(UiUtils.Companion.getWalletFirstLevelButtonBgColorOrientation());
            gradientDrawable.setColors(new int[]{UiUtils.Companion.getWalletFirstLevelButtonBgStartColor(), UiUtils.Companion.getWalletFirstLevelButtonBgEndColor()});
        } else {
            setTextColor(-16777216);
            IWalletSecondButtonConfig walletSecondButtonConfig = UiUtils.Companion.getWalletSecondButtonConfig();
            if (walletSecondButtonConfig != null) {
                if (walletSecondButtonConfig.getBorderWidth() > 0) {
                    gradientDrawable.setStroke(walletSecondButtonConfig.getBorderWidth(), walletSecondButtonConfig.getEnableBorderColor());
                }
                gradientDrawable.setColor(walletSecondButtonConfig.getEnableBgColor());
            } else {
                gradientDrawable.setColor(f35429C);
            }
        }
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }
}
