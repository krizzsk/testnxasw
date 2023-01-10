package com.didi.payment.wallet_ui.loading;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.WalletButton;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJb\u0010\u0012\u001a\u00020\u00132\b\b\u0003\u0010\u0014\u001a\u00020\u00072\b\b\u0003\u0010\u0015\u001a\u00020\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001bR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/WalletReplaceView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mBtnFirst", "Lcom/didi/payment/wallet_ui/WalletButton;", "mBtnSecond", "mIvImage", "Landroid/widget/ImageView;", "mTvSubTitle", "Landroid/widget/TextView;", "mTvTitle", "config", "", "emptyType", "imageRes", "title", "", "subTitle", "firstBtnText", "firstClickListener", "Landroid/view/View$OnClickListener;", "secondBtnText", "secondClickListener", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletReplaceView.kt */
public final class WalletReplaceView extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SIZE_TYPE_FULL = 1;
    public static final int SIZE_TYPE_INNER = 2;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int f35665f = UiUtils.Companion.intSize(100);
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final int f35666g = UiUtils.Companion.intSize(80);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final int f35667h = UiUtils.Companion.intSize(60);
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final int f35668i = UiUtils.Companion.intSize(60);

    /* renamed from: a */
    private WalletButton f35669a;

    /* renamed from: b */
    private WalletButton f35670b;

    /* renamed from: c */
    private TextView f35671c;

    /* renamed from: d */
    private TextView f35672d;

    /* renamed from: e */
    private ImageView f35673e;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletReplaceView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletReplaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletReplaceView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletReplaceView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018J<\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0003\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/loading/WalletReplaceView$Companion;", "", "()V", "SIZE_TYPE_FULL", "", "SIZE_TYPE_INNER", "fullPaddingLR", "getFullPaddingLR", "()I", "fullPaddingTB", "getFullPaddingTB", "innerPaddingLR", "getInnerPaddingLR", "innerPaddingTB", "getInnerPaddingTB", "createEmptyView", "Lcom/didi/payment/wallet_ui/loading/WalletReplaceView;", "context", "Landroid/content/Context;", "emptyType", "title", "", "firstBtnText", "firstClickListener", "Landroid/view/View$OnClickListener;", "createNetErrorView", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletReplaceView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getFullPaddingTB() {
            return WalletReplaceView.f35665f;
        }

        public final int getFullPaddingLR() {
            return WalletReplaceView.f35666g;
        }

        public final int getInnerPaddingTB() {
            return WalletReplaceView.f35667h;
        }

        public final int getInnerPaddingLR() {
            return WalletReplaceView.f35668i;
        }

        public static /* synthetic */ WalletReplaceView createEmptyView$default(Companion companion, Context context, int i, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener, int i2, Object obj) {
            return companion.createEmptyView(context, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? null : charSequence, (i2 & 8) != 0 ? null : charSequence2, (i2 & 16) != 0 ? null : onClickListener);
        }

        public final WalletReplaceView createEmptyView(Context context, @WalletReplaceViewSizeType int i, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            WalletReplaceView walletReplaceView = new WalletReplaceView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            walletReplaceView.config(i, R.drawable.wallet_icon_default_empty, charSequence, (CharSequence) null, charSequence2, onClickListener, (CharSequence) null, (View.OnClickListener) null);
            return walletReplaceView;
        }

        public static /* synthetic */ WalletReplaceView createNetErrorView$default(Companion companion, Context context, int i, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener, int i2, Object obj) {
            return companion.createNetErrorView(context, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? null : charSequence, (i2 & 8) != 0 ? null : charSequence2, (i2 & 16) != 0 ? null : onClickListener);
        }

        public final WalletReplaceView createNetErrorView(Context context, @WalletReplaceViewSizeType int i, CharSequence charSequence, CharSequence charSequence2, View.OnClickListener onClickListener) {
            Intrinsics.checkNotNullParameter(context, "context");
            WalletReplaceView walletReplaceView = new WalletReplaceView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            walletReplaceView.config(i, R.drawable.wallet_icon_net_error, charSequence, (CharSequence) null, charSequence2, onClickListener, (CharSequence) null, (View.OnClickListener) null);
            return walletReplaceView;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletReplaceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_default_empty, this);
        View findViewById = findViewById(R.id.iv_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_image)");
        this.f35673e = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_title)");
        this.f35672d = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tv_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_sub_title)");
        this.f35671c = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.btn_first);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.btn_first)");
        this.f35670b = (WalletButton) findViewById4;
        View findViewById5 = findViewById(R.id.btn_second);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.btn_second)");
        this.f35669a = (WalletButton) findViewById5;
        setOrientation(1);
        setBackground(new ColorDrawable(-1));
        setGravity(1);
    }

    public static /* synthetic */ void config$default(WalletReplaceView walletReplaceView, int i, int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, View.OnClickListener onClickListener, CharSequence charSequence4, View.OnClickListener onClickListener2, int i3, Object obj) {
        int i4 = i3;
        int i5 = (i4 & 1) != 0 ? 1 : i;
        int i6 = (i4 & 2) != 0 ? -1 : i2;
        View.OnClickListener onClickListener3 = null;
        CharSequence charSequence5 = (i4 & 4) != 0 ? null : charSequence;
        CharSequence charSequence6 = (i4 & 8) != 0 ? null : charSequence2;
        CharSequence charSequence7 = (i4 & 16) != 0 ? null : charSequence3;
        View.OnClickListener onClickListener4 = (i4 & 32) != 0 ? null : onClickListener;
        CharSequence charSequence8 = (i4 & 64) != 0 ? null : charSequence4;
        if ((i4 & 128) == 0) {
            onClickListener3 = onClickListener2;
        }
        walletReplaceView.config(i5, i6, charSequence5, charSequence6, charSequence7, onClickListener4, charSequence8, onClickListener3);
    }

    public final void config(@WalletReplaceViewSizeType int i, int i2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, View.OnClickListener onClickListener, CharSequence charSequence4, View.OnClickListener onClickListener2) {
        if (i == 1) {
            int i3 = f35666g;
            int i4 = f35665f;
            setPadding(i3, i4, i3, i4);
        } else {
            int i5 = f35668i;
            int i6 = f35667h;
            setPadding(i5, i6, i5, i6);
        }
        if (i2 != -1) {
            this.f35673e.setImageResource(i2);
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f35672d.setVisibility(8);
        } else {
            this.f35672d.setText(charSequence);
            this.f35672d.setVisibility(0);
        }
        if (TextUtils.isEmpty(charSequence2)) {
            this.f35671c.setVisibility(8);
        } else {
            this.f35671c.setText(charSequence2);
            this.f35671c.setVisibility(0);
        }
        if (TextUtils.isEmpty(charSequence3)) {
            this.f35670b.setVisibility(8);
        } else {
            this.f35670b.setText(charSequence3);
            this.f35670b.setOnClickListener(onClickListener);
            this.f35670b.setVisibility(0);
        }
        if (TextUtils.isEmpty(charSequence4)) {
            this.f35669a.setVisibility(8);
            return;
        }
        this.f35669a.setText(charSequence4);
        this.f35669a.setOnClickListener(onClickListener2);
        this.f35669a.setVisibility(0);
    }
}
