package com.didi.payment.wallet_ui.edit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\b\b\u0003\u0010\u001b\u001a\u00020\u00072\b\b\u0003\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/edit/WalletMoneyEdit;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "flSearchContainer", "Landroid/widget/FrameLayout;", "isDeleteShow", "", "mEtInput", "Landroid/widget/EditText;", "mFlTips", "mIvDelete", "Landroid/widget/ImageView;", "mTvCurrencyPrefix", "Landroid/widget/TextView;", "mVBottomLine", "Landroid/view/View;", "mVPlaceHolder", "addCancelListener", "", "configTips", "tipsViewLayout", "contentColor", "getEditText", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletMoneyEdit.kt */
public final class WalletMoneyEdit extends ConstraintLayout {

    /* renamed from: a */
    private FrameLayout f35534a;

    /* renamed from: b */
    private View f35535b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f35536c;

    /* renamed from: d */
    private EditText f35537d;

    /* renamed from: e */
    private final FrameLayout f35538e;

    /* renamed from: f */
    private TextView f35539f;

    /* renamed from: g */
    private View f35540g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f35541h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletMoneyEdit(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletMoneyEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletMoneyEdit(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletMoneyEdit(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletMoneyEdit(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_money_edit, this);
        View findViewById = findViewById(R.id.tv_currency_prefix);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_currency_prefix)");
        this.f35539f = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.fl_search_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fl_search_container)");
        this.f35538e = (FrameLayout) findViewById2;
        boolean z = true;
        this.f35537d = UiUtils.Companion.inflateCursorDrawableEdittext(this.f35538e, 40.0f, true);
        View findViewById3 = findViewById(R.id.iv_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_delete)");
        this.f35536c = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.v_bottom_line);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.v_bottom_line)");
        this.f35535b = findViewById4;
        View findViewById5 = findViewById(R.id.fl_tips);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.fl_tips)");
        this.f35534a = (FrameLayout) findViewById5;
        View findViewById6 = findViewById(R.id.v_place_holder);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.v_place_holder)");
        this.f35540g = findViewById6;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(UiUtils.Companion.floatSize(20));
        gradientDrawable.setColor(-1);
        Unit unit = Unit.INSTANCE;
        setBackground(gradientDrawable);
        this.f35541h = this.f35536c.getVisibility() != 0 ? false : z;
        m26890a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletMoneyEdit);
        this.f35539f.setText(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private final void m26890a() {
        this.f35536c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletMoneyEdit.m26891a(WalletMoneyEdit.this, view);
            }
        });
        this.f35537d.addTextChangedListener(new WalletMoneyEdit$addCancelListener$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26891a(WalletMoneyEdit walletMoneyEdit, View view) {
        Intrinsics.checkNotNullParameter(walletMoneyEdit, "this$0");
        walletMoneyEdit.f35537d.getText().clear();
    }

    public static /* synthetic */ void configTips$default(WalletMoneyEdit walletMoneyEdit, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = -1;
        }
        if ((i3 & 2) != 0) {
            i2 = Color.parseColor(ColorUtils.DIDI_RED);
        }
        walletMoneyEdit.configTips(i, i2);
    }

    public final void configTips(int i, int i2) {
        if (i != -1) {
            this.f35534a.removeAllViews();
            this.f35534a.addView(View.inflate(getContext(), i, (ViewGroup) null));
            this.f35535b.setVisibility(0);
            this.f35534a.setVisibility(0);
            this.f35539f.setTextColor(i2);
            this.f35537d.setTextColor(i2);
            return;
        }
        this.f35535b.setVisibility(8);
        this.f35534a.setVisibility(8);
    }

    public final EditText getEditText() {
        return this.f35537d;
    }
}
