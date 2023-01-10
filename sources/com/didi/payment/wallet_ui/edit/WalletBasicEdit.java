package com.didi.payment.wallet_ui.edit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0003\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/edit/WalletBasicEdit;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "flSearchContainer", "Landroid/widget/FrameLayout;", "isDeleteShow", "", "mEtInput", "Landroid/widget/EditText;", "mIvDelete", "Landroid/widget/ImageView;", "mIvFunction", "mTvPrefix", "Landroid/widget/TextView;", "mTvTips", "mVBottomLine", "Landroid/view/View;", "addCancelListener", "", "configTips", "tips", "", "tipsType", "getEditText", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletBasicEdit.kt */
public final class WalletBasicEdit extends ConstraintLayout {

    /* renamed from: a */
    private TextView f35526a;

    /* renamed from: b */
    private View f35527b;

    /* renamed from: c */
    private ImageView f35528c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ImageView f35529d;

    /* renamed from: e */
    private EditText f35530e;

    /* renamed from: f */
    private final FrameLayout f35531f;

    /* renamed from: g */
    private TextView f35532g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f35533h;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBasicEdit(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBasicEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBasicEdit(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletBasicEdit(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBasicEdit(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_basic_edit, this);
        View findViewById = findViewById(R.id.tv_prefix);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_prefix)");
        this.f35532g = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.fl_search_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fl_search_container)");
        this.f35531f = (FrameLayout) findViewById2;
        this.f35530e = UiUtils.Companion.inflateCursorDrawableEdittext(this.f35531f, 24.0f, true);
        View findViewById3 = findViewById(R.id.iv_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_delete)");
        this.f35529d = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.iv_function);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.iv_function)");
        this.f35528c = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.v_bottom_line);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.v_bottom_line)");
        this.f35527b = findViewById5;
        View findViewById6 = findViewById(R.id.tv_tips);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.tv_tips)");
        this.f35526a = (TextView) findViewById6;
        this.f35533h = this.f35529d.getVisibility() == 0;
        m26888a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletBasicEdit);
        CharSequence string = obtainStyledAttributes.getString(2);
        if (TextUtils.isEmpty(string)) {
            this.f35532g.setVisibility(8);
        } else {
            this.f35532g.setText(string);
            this.f35532g.setVisibility(0);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            this.f35528c.setImageDrawable(drawable);
            this.f35528c.setVisibility(0);
        } else {
            this.f35528c.setVisibility(8);
        }
        int intSize = UiUtils.Companion.intSize(20);
        int intSize2 = (!TextUtils.isEmpty(string) || drawable != null) ? intSize : UiUtils.Companion.intSize(16);
        String string2 = obtainStyledAttributes.getString(1);
        if (string2 != null) {
            this.f35530e.setHint(string2);
        }
        String string3 = obtainStyledAttributes.getString(4);
        if (!TextUtils.isEmpty(string3)) {
            configTips(string3, obtainStyledAttributes.getInt(5, 1));
        } else if (obtainStyledAttributes.getBoolean(3, false)) {
            this.f35526a.setVisibility(4);
        } else {
            this.f35526a.setVisibility(8);
        }
        setPadding(intSize2, 0, intSize, 0);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private final void m26888a() {
        this.f35529d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletBasicEdit.m26889a(WalletBasicEdit.this, view);
            }
        });
        this.f35530e.addTextChangedListener(new WalletBasicEdit$addCancelListener$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26889a(WalletBasicEdit walletBasicEdit, View view) {
        Intrinsics.checkNotNullParameter(walletBasicEdit, "this$0");
        if (walletBasicEdit.f35533h) {
            walletBasicEdit.f35530e.getText().clear();
            walletBasicEdit.f35533h = false;
            walletBasicEdit.f35529d.setVisibility(4);
        }
    }

    public static /* synthetic */ void configTips$default(WalletBasicEdit walletBasicEdit, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        walletBasicEdit.configTips(str, i);
    }

    public final void configTips(String str, @WalletEditTipsType int i) {
        int i2;
        this.f35526a.setText(str);
        TextView textView = this.f35526a;
        if (i == 1) {
            i2 = Color.parseColor("#919599");
        } else {
            i2 = Color.parseColor("#FF525D");
        }
        textView.setTextColor(i2);
        this.f35526a.setVisibility(0);
    }

    public final EditText getEditText() {
        return this.f35530e;
    }
}
