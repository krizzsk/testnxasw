package com.didi.payment.wallet_ui.wheel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.contrarywind.view.WheelView;
import com.didi.payment.wallet_ui.WalletButton;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u001c\u0010\u001f\u001a\u00020\u001c2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ(\u0010\"\u001a\u00020\u001c2\b\b\u0002\u0010#\u001a\u00020\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010!R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/WalletWheel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIvCancel", "Landroid/widget/ImageView;", "mIvDelete", "mLlWheelContainer", "Landroid/widget/LinearLayout;", "mTvDelete", "Landroid/widget/TextView;", "mTvTitle", "mVDelete", "Landroid/view/View;", "mWbConfirm", "Lcom/didi/payment/wallet_ui/WalletButton;", "addItem", "Lcom/contrarywind/view/WheelView;", "isCycle", "", "isCenterLabel", "configCancelClick", "", "onCancelListener", "Landroid/view/View$OnClickListener;", "configConfirm", "confirmText", "", "configDelete", "showDelete", "deleteText", "deleteClickListener", "configTitle", "title", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletWheel.kt */
public final class WalletWheel extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: h */
    private static final int f35781h = Color.parseColor("#999999");

    /* renamed from: i */
    private static final int f35782i = Color.parseColor("#FFD4D7D9");

    /* renamed from: a */
    private WalletButton f35783a;

    /* renamed from: b */
    private LinearLayout f35784b;

    /* renamed from: c */
    private ImageView f35785c;

    /* renamed from: d */
    private TextView f35786d;

    /* renamed from: e */
    private ImageView f35787e;

    /* renamed from: f */
    private View f35788f;

    /* renamed from: g */
    private TextView f35789g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletWheel(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletWheel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletWheel(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletWheel(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletWheel(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_wheel, this);
        View findViewById = findViewById(R.id.iv_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_delete)");
        this.f35787e = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tv_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_delete)");
        this.f35786d = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.v_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.v_delete)");
        this.f35788f = findViewById3;
        View findViewById4 = findViewById(R.id.iv_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_cancel)");
        this.f35785c = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_title)");
        this.f35789g = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.ll_wheel_container);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.ll_wheel_container)");
        this.f35784b = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.wb_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.wb_confirm)");
        this.f35783a = (WalletButton) findViewById7;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/wheel/WalletWheel$Companion;", "", "()V", "dividerColor", "", "outTextColor", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletWheel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public static /* synthetic */ WheelView addItem$default(WalletWheel walletWheel, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        return walletWheel.addItem(z, z2);
    }

    public final WheelView addItem(boolean z, boolean z2) {
        WheelView wheelView = new WheelView(getContext());
        wheelView.setTextSize(20.0f);
        wheelView.setTextColorCenter(-16777216);
        wheelView.setTextColorOut(f35781h);
        wheelView.setItemsVisibleCount(5);
        wheelView.setAlphaGradient(true);
        wheelView.setDividerColor(f35782i);
        wheelView.setCyclic(z);
        wheelView.setLineSpacingMultiplier(2.0f);
        wheelView.isCenterLabel(z2);
        this.f35784b.addView(wheelView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        return wheelView;
    }

    public static /* synthetic */ void configDelete$default(WalletWheel walletWheel, boolean z, CharSequence charSequence, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            onClickListener = null;
        }
        walletWheel.configDelete(z, charSequence, onClickListener);
    }

    public final void configDelete(boolean z, CharSequence charSequence, View.OnClickListener onClickListener) {
        if (z) {
            this.f35786d.setVisibility(0);
            this.f35787e.setVisibility(0);
            this.f35788f.setVisibility(0);
            if (charSequence != null) {
                this.f35786d.setText(charSequence);
            }
            this.f35788f.setOnClickListener(onClickListener);
            return;
        }
        this.f35786d.setVisibility(8);
        this.f35787e.setVisibility(8);
        this.f35788f.setVisibility(8);
        this.f35788f.setOnClickListener((View.OnClickListener) null);
    }

    public final void configCancelClick(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f35785c.setOnClickListener(onClickListener);
        }
    }

    public static /* synthetic */ void configConfirm$default(WalletWheel walletWheel, CharSequence charSequence, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        walletWheel.configConfirm(charSequence, onClickListener);
    }

    public final void configConfirm(CharSequence charSequence, View.OnClickListener onClickListener) {
        if (charSequence != null) {
            this.f35783a.setText(charSequence);
        }
        if (onClickListener != null) {
            this.f35783a.setOnClickListener(onClickListener);
        }
    }

    public final void configTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f35789g.setVisibility(8);
            return;
        }
        this.f35789g.setVisibility(0);
        this.f35789g.setText(charSequence);
    }
}
