package com.didi.payment.wallet_ui.bulletin;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.passenger.C11267R;
import com.didi.payment.wallet_ui.UiUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ>\u0010\u000f\u001a\u00020\u00102\b\b\u0003\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/bulletin/WalletBulletin;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mIvArrow", "Landroid/widget/ImageView;", "mIvIcon", "mTvNoticeContent", "Landroid/widget/TextView;", "configBulletin", "", "bulletinType", "showIcon", "", "showArrow", "bulletinText", "", "onBulletinClick", "Landroid/view/View$OnClickListener;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletBulletin.kt */
public final class WalletBulletin extends ConstraintLayout {
    public static final int BULLETIN_TYPE_ERROR = 2;
    public static final int BULLETIN_TYPE_WARN = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d */
    private static final int f35483d = Color.parseColor("#FFEEF0");

    /* renamed from: e */
    private static final int f35484e = Color.parseColor("#FFF7EB");

    /* renamed from: f */
    private static final int f35485f = Color.parseColor(ColorUtils.DIDI_RED);

    /* renamed from: g */
    private static final int f35486g = Color.parseColor("#FCA009");

    /* renamed from: a */
    private final TextView f35487a;

    /* renamed from: b */
    private final ImageView f35488b;

    /* renamed from: c */
    private final ImageView f35489c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBulletin(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBulletin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletBulletin(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletBulletin(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBulletin(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_bulletin, this);
        View findViewById = findViewById(R.id.iv_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_icon)");
        this.f35489c = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.iv_arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_arrow)");
        this.f35488b = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_notice_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_notice_content)");
        this.f35487a = (TextView) findViewById3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletBulletin);
        m26880a(this, obtainStyledAttributes.getInt(1, 1), obtainStyledAttributes.getBoolean(3, false), obtainStyledAttributes.getBoolean(2, false), obtainStyledAttributes.getString(0), (View.OnClickListener) null, 16, (Object) null);
        obtainStyledAttributes.recycle();
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/bulletin/WalletBulletin$Companion;", "", "()V", "BG_COLOR_TYPE_ERROR", "", "BG_COLOR_TYPE_WARN", "BULLETIN_TYPE_ERROR", "BULLETIN_TYPE_WARN", "TEXT_COLOR_TYPE_ERROR", "TEXT_COLOR_TYPE_WARN", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletBulletin.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m26880a(WalletBulletin walletBulletin, int i, boolean z, boolean z2, String str, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            z2 = true;
        }
        if ((i2 & 8) != 0) {
            str = null;
        }
        if ((i2 & 16) != 0) {
            onClickListener = null;
        }
        walletBulletin.m26879a(i, z, z2, str, onClickListener);
    }

    /* renamed from: a */
    private final void m26879a(@WalletBulletinType int i, boolean z, boolean z2, String str, View.OnClickListener onClickListener) {
        if (z) {
            this.f35489c.setVisibility(0);
            this.f35489c.setImageResource(i == 1 ? R.drawable.wallet_icon_bulletin_warn : R.drawable.wallet_icon_bulletin_error);
        } else {
            this.f35489c.setVisibility(8);
        }
        if (z2) {
            this.f35488b.setVisibility(0);
            this.f35488b.setImageResource(i == 1 ? R.drawable.wallet_icon_bulletin_arrow_warn : R.drawable.wallet_icon_bulletin_arrow_error);
        } else {
            this.f35488b.setVisibility(8);
        }
        if (i == 1) {
            setBackground(new ColorDrawable(f35484e));
            this.f35487a.setTextColor(f35486g);
        } else {
            setBackground(new ColorDrawable(f35483d));
            this.f35487a.setTextColor(f35485f);
        }
        this.f35487a.setText(str);
        setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(UiUtils.Companion.getScreenWidth(), 1073741824), i2);
    }
}
