package com.didi.payment.wallet_ui.edit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u001c\u0010\u0019\u001a\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0003\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/edit/WalletTitleEdit;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "flSearchContainer", "Landroid/widget/FrameLayout;", "isDeleteShow", "", "mEtInput", "Landroid/widget/EditText;", "mIvDelete", "Landroid/widget/ImageView;", "mTvTips", "Landroid/widget/TextView;", "mTvTitle", "mVBottomLine", "Landroid/view/View;", "addCancelListener", "", "configTips", "tips", "", "tipsType", "getEditText", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletTitleEdit.kt */
public final class WalletTitleEdit extends ConstraintLayout {

    /* renamed from: a */
    private TextView f35542a;

    /* renamed from: b */
    private View f35543b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ImageView f35544c;

    /* renamed from: d */
    private EditText f35545d;

    /* renamed from: e */
    private final FrameLayout f35546e;

    /* renamed from: f */
    private TextView f35547f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f35548g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletTitleEdit(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletTitleEdit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletTitleEdit(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletTitleEdit(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTitleEdit(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_title_edit, this);
        View findViewById = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_title)");
        this.f35547f = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.fl_search_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fl_search_container)");
        this.f35546e = (FrameLayout) findViewById2;
        this.f35545d = UiUtils.Companion.inflateCursorDrawableEdittext(this.f35546e, 24.0f, true);
        View findViewById3 = findViewById(R.id.iv_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.iv_delete)");
        this.f35544c = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.v_bottom_line);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.v_bottom_line)");
        this.f35543b = findViewById4;
        View findViewById5 = findViewById(R.id.tv_tips);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_tips)");
        this.f35542a = (TextView) findViewById5;
        this.f35548g = this.f35544c.getVisibility() == 0;
        m26892a();
        setBackground(new ColorDrawable(-1));
        setPadding(UiUtils.Companion.intSize(17), UiUtils.Companion.intSize(18), UiUtils.Companion.intSize(20), 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletTitleEdit);
        String string = obtainStyledAttributes.getString(4);
        if (string != null) {
            this.f35547f.setText(string);
        }
        String string2 = obtainStyledAttributes.getString(0);
        if (string2 != null) {
            this.f35545d.setHint(string2);
        }
        CharSequence string3 = obtainStyledAttributes.getString(2);
        if (!TextUtils.isEmpty(string3)) {
            configTips(string3, obtainStyledAttributes.getInt(3, 1));
        } else if (obtainStyledAttributes.getBoolean(1, false)) {
            this.f35542a.setVisibility(4);
        } else {
            this.f35542a.setVisibility(8);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private final void m26892a() {
        this.f35544c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletTitleEdit.m26893a(WalletTitleEdit.this, view);
            }
        });
        this.f35545d.addTextChangedListener(new WalletTitleEdit$addCancelListener$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26893a(WalletTitleEdit walletTitleEdit, View view) {
        Intrinsics.checkNotNullParameter(walletTitleEdit, "this$0");
        walletTitleEdit.f35545d.getText().clear();
    }

    public static /* synthetic */ void configTips$default(WalletTitleEdit walletTitleEdit, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = null;
        }
        if ((i2 & 2) != 0) {
            i = 1;
        }
        walletTitleEdit.configTips(charSequence, i);
    }

    public final void configTips(CharSequence charSequence, @WalletEditTipsType int i) {
        int i2;
        this.f35542a.setText(charSequence);
        TextView textView = this.f35542a;
        if (i == 1) {
            i2 = Color.parseColor("#919599");
        } else {
            i2 = Color.parseColor("#FF525D");
        }
        textView.setTextColor(i2);
        this.f35542a.setVisibility(0);
    }

    public final EditText getEditText() {
        return this.f35545d;
    }
}
