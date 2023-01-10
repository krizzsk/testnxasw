package com.didi.payment.wallet_ui.label;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ$\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0007J\u001a\u0010\u0019\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u001a\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u001b\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u001c\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/label/WalletCardLabel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIvArrow", "Landroid/widget/ImageView;", "mLlContent", "Landroid/widget/LinearLayout;", "mTvCard", "Landroid/widget/TextView;", "mVTriangle", "Lcom/didi/payment/wallet_ui/label/WalletCardLabelBottomTriangle;", "setDynamic", "", "statusContent", "", "showArrow", "", "bgColor", "setError", "setProcessing", "setReady", "setSuccess", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletCardLabel.kt */
public final class WalletCardLabel extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int TYPE_STATUS_DYNAMIC = 5;
    public static final int TYPE_STATUS_ERROR = 3;
    public static final int TYPE_STATUS_PROCESSING = 2;
    public static final int TYPE_STATUS_READY = 1;
    public static final int TYPE_STATUS_SUCCESS = 4;

    /* renamed from: e */
    private static final float f35615e = TypedValue.applyDimension(1, 26.5f, Resources.getSystem().getDisplayMetrics());

    /* renamed from: f */
    private static final float f35616f;

    /* renamed from: g */
    private static final float[] f35617g;

    /* renamed from: h */
    private static final int f35618h = Color.parseColor("#1F68EC");

    /* renamed from: i */
    private static final int f35619i = Color.parseColor("#FF8040");

    /* renamed from: j */
    private static final int f35620j = Color.parseColor(ColorUtils.DIDI_RED);

    /* renamed from: k */
    private static final int f35621k = Color.parseColor("#3FC790");

    /* renamed from: a */
    private ImageView f35622a;

    /* renamed from: b */
    private TextView f35623b;

    /* renamed from: c */
    private LinearLayout f35624c;

    /* renamed from: d */
    private WalletCardLabelBottomTriangle f35625d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCardLabel(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCardLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletCardLabel(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletCardLabel(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/label/WalletCardLabel$Companion;", "", "()V", "TYPE_STATUS_DYNAMIC", "", "TYPE_STATUS_ERROR", "TYPE_STATUS_PROCESSING", "TYPE_STATUS_READY", "TYPE_STATUS_SUCCESS", "errorColor", "leftTopCorner", "", "processingColor", "readyColor", "rightTopCorner", "successColor", "textCornerRadii", "", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletCardLabel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardLabel(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_card_label, this);
        View findViewById = findViewById(R.id.tv_card);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_card)");
        this.f35623b = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_arrow)");
        this.f35622a = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.ll_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.ll_content)");
        this.f35624c = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R.id.v_triangle);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.v_triangle)");
        this.f35625d = (WalletCardLabelBottomTriangle) findViewById4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletCardLabel);
        int i4 = obtainStyledAttributes.getInt(3, 1);
        String string = obtainStyledAttributes.getString(0);
        boolean z = obtainStyledAttributes.getBoolean(2, false);
        if (i4 == 5) {
            setDynamic(string, z, obtainStyledAttributes.getColor(1, f35618h));
        } else {
            CharSequence charSequence = string;
            if (i4 == 1) {
                i3 = f35618h;
            } else if (i4 == 2) {
                i3 = f35619i;
            } else if (i4 == 3) {
                i3 = f35620j;
            } else if (i4 != 4) {
                i3 = f35618h;
            } else {
                i3 = f35621k;
            }
            setDynamic(charSequence, z, i3);
        }
        obtainStyledAttributes.recycle();
    }

    static {
        float applyDimension = TypedValue.applyDimension(1, 7.0f, Resources.getSystem().getDisplayMetrics());
        f35616f = applyDimension;
        float f = f35615e;
        f35617g = new float[]{f, f, applyDimension, applyDimension, 0.0f, 0.0f, f, f};
    }

    public static /* synthetic */ void setReady$default(WalletCardLabel walletCardLabel, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        walletCardLabel.setReady(charSequence, z);
    }

    public final void setReady(CharSequence charSequence, boolean z) {
        setDynamic(charSequence, z, f35618h);
    }

    public static /* synthetic */ void setProcessing$default(WalletCardLabel walletCardLabel, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        walletCardLabel.setProcessing(charSequence, z);
    }

    public final void setProcessing(CharSequence charSequence, boolean z) {
        setDynamic(charSequence, z, f35619i);
    }

    public static /* synthetic */ void setError$default(WalletCardLabel walletCardLabel, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        walletCardLabel.setError(charSequence, z);
    }

    public final void setError(CharSequence charSequence, boolean z) {
        setDynamic(charSequence, z, f35620j);
    }

    public static /* synthetic */ void setSuccess$default(WalletCardLabel walletCardLabel, CharSequence charSequence, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        walletCardLabel.setSuccess(charSequence, z);
    }

    public final void setSuccess(CharSequence charSequence, boolean z) {
        setDynamic(charSequence, z, f35621k);
    }

    public static /* synthetic */ void setDynamic$default(WalletCardLabel walletCardLabel, CharSequence charSequence, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        walletCardLabel.setDynamic(charSequence, z, i);
    }

    public final void setDynamic(CharSequence charSequence, boolean z, int i) {
        LinearLayout linearLayout = this.f35624c;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadii(f35617g);
        gradientDrawable.setColor(i);
        Unit unit = Unit.INSTANCE;
        linearLayout.setBackground(gradientDrawable);
        this.f35625d.setThemeBgColor(i);
        this.f35622a.setVisibility(z ? 0 : 8);
        this.f35623b.setText(charSequence);
    }
}
