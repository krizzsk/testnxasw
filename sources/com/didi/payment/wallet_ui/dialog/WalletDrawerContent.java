package com.didi.payment.wallet_ui.dialog;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.didi.payment.wallet_ui.UiUtils;
import com.didi.payment.wallet_ui.WalletButton;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001LB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ¨\u0001\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u0002092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010;2\b\b\u0003\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u0002092\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010C\u001a\u0004\u0018\u0001022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010?J8\u0010J\u001a\u0002072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010?H\u0002JP\u0010K\u001a\u0002072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010?2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010A2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010?H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u0011\u0010%\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010'\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010)\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0011\u00101\u001a\u000202¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletDrawerContent;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mFlBottomBtn", "Landroid/widget/FrameLayout;", "getMFlBottomBtn", "()Landroid/widget/FrameLayout;", "mFlInsert", "getMFlInsert", "mIvClose", "Landroid/widget/ImageView;", "getMIvClose", "()Landroid/widget/ImageView;", "mIvImage", "getMIvImage", "mLlHorizontalBtn", "getMLlHorizontalBtn", "()Landroid/widget/LinearLayout;", "mLlVerticalBtn", "getMLlVerticalBtn", "mNsvContent", "Landroidx/core/widget/NestedScrollView;", "getMNsvContent", "()Landroidx/core/widget/NestedScrollView;", "mTvBtnHorizontalFirst", "Lcom/didi/payment/wallet_ui/WalletButton;", "getMTvBtnHorizontalFirst", "()Lcom/didi/payment/wallet_ui/WalletButton;", "mTvBtnHorizontalSecond", "getMTvBtnHorizontalSecond", "mTvBtnVerticalFirst", "getMTvBtnVerticalFirst", "mTvBtnVerticalSecond", "getMTvBtnVerticalSecond", "mTvBtnVerticalThird", "getMTvBtnVerticalThird", "mTvContent", "Landroid/widget/TextView;", "getMTvContent", "()Landroid/widget/TextView;", "mTvTitle", "getMTvTitle", "mVClose", "Landroid/view/View;", "getMVClose", "()Landroid/view/View;", "maxDrawerHeight", "config", "", "horizontalAction", "", "imageUrl", "", "imageRes", "showClose", "closeClickListener", "Landroid/view/View$OnClickListener;", "title", "", "content", "insertView", "firstBtnText", "firstClickListener", "secondBtnText", "secondClickListener", "thirdBtnText", "thirdClickListener", "configHorizontalAction", "configVerticalAction", "Builder", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletDrawerContent.kt */
public final class WalletDrawerContent extends LinearLayout {

    /* renamed from: a */
    private final WalletButton f35498a;

    /* renamed from: b */
    private final WalletButton f35499b;

    /* renamed from: c */
    private final WalletButton f35500c;

    /* renamed from: d */
    private final WalletButton f35501d;

    /* renamed from: e */
    private final WalletButton f35502e;

    /* renamed from: f */
    private final NestedScrollView f35503f;

    /* renamed from: g */
    private final FrameLayout f35504g;

    /* renamed from: h */
    private final TextView f35505h;

    /* renamed from: i */
    private final TextView f35506i;

    /* renamed from: j */
    private final View f35507j;

    /* renamed from: k */
    private final ImageView f35508k;

    /* renamed from: l */
    private final ImageView f35509l;

    /* renamed from: m */
    private final FrameLayout f35510m;

    /* renamed from: n */
    private final LinearLayout f35511n;

    /* renamed from: o */
    private final LinearLayout f35512o;

    /* renamed from: p */
    private final int f35513p;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletDrawerContent(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletDrawerContent(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.wallet_ui_dialog_drawer, this);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        setOrientation(1);
        Unit unit = Unit.INSTANCE;
        setLayoutParams(layoutParams);
        View findViewById = findViewById(R.id.iv_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_image)");
        this.f35509l = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_close)");
        this.f35508k = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.v_close);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.v_close)");
        this.f35507j = findViewById3;
        View findViewById4 = findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_title)");
        this.f35506i = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_content)");
        this.f35505h = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.fl_insert);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.fl_insert)");
        this.f35504g = (FrameLayout) findViewById6;
        View findViewById7 = findViewById(R.id.nsv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.nsv_content)");
        this.f35503f = (NestedScrollView) findViewById7;
        View findViewById8 = findViewById(R.id.tv_btn_vertical_first);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.tv_btn_vertical_first)");
        this.f35502e = (WalletButton) findViewById8;
        View findViewById9 = findViewById(R.id.tv_btn_vertical_second);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.tv_btn_vertical_second)");
        this.f35501d = (WalletButton) findViewById9;
        View findViewById10 = findViewById(R.id.tv_btn_vertical_third);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.tv_btn_vertical_third)");
        this.f35500c = (WalletButton) findViewById10;
        View findViewById11 = findViewById(R.id.tv_btn_horizontal_first);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.tv_btn_horizontal_first)");
        this.f35499b = (WalletButton) findViewById11;
        View findViewById12 = findViewById(R.id.tv_btn_horizontal_second);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.tv_btn_horizontal_second)");
        this.f35498a = (WalletButton) findViewById12;
        View findViewById13 = findViewById(R.id.ll_horizontal_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.ll_horizontal_btn)");
        this.f35511n = (LinearLayout) findViewById13;
        View findViewById14 = findViewById(R.id.ll_vertical_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.ll_vertical_btn)");
        this.f35512o = (LinearLayout) findViewById14;
        View findViewById15 = findViewById(R.id.fl_bottom_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.fl_bottom_btn)");
        this.f35510m = (FrameLayout) findViewById15;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), WalletDialog.Companion.getRadius(), 0.0f, 0.0f, 0.0f, 0.0f});
        Unit unit2 = Unit.INSTANCE;
        setBackground(gradientDrawable);
        this.f35513p = UiUtils.Companion.getScreenHeight() - UiUtils.Companion.intSize(180);
    }

    public final WalletButton getMTvBtnHorizontalSecond() {
        return this.f35498a;
    }

    public final WalletButton getMTvBtnHorizontalFirst() {
        return this.f35499b;
    }

    public final WalletButton getMTvBtnVerticalThird() {
        return this.f35500c;
    }

    public final WalletButton getMTvBtnVerticalSecond() {
        return this.f35501d;
    }

    public final WalletButton getMTvBtnVerticalFirst() {
        return this.f35502e;
    }

    public final NestedScrollView getMNsvContent() {
        return this.f35503f;
    }

    public final FrameLayout getMFlInsert() {
        return this.f35504g;
    }

    public final TextView getMTvContent() {
        return this.f35505h;
    }

    public final TextView getMTvTitle() {
        return this.f35506i;
    }

    public final View getMVClose() {
        return this.f35507j;
    }

    public final ImageView getMIvClose() {
        return this.f35508k;
    }

    public final ImageView getMIvImage() {
        return this.f35509l;
    }

    public final FrameLayout getMFlBottomBtn() {
        return this.f35510m;
    }

    public final LinearLayout getMLlHorizontalBtn() {
        return this.f35511n;
    }

    public final LinearLayout getMLlVerticalBtn() {
        return this.f35512o;
    }

    public static /* synthetic */ void config$default(WalletDrawerContent walletDrawerContent, boolean z, String str, int i, boolean z2, View.OnClickListener onClickListener, CharSequence charSequence, CharSequence charSequence2, View view, CharSequence charSequence3, View.OnClickListener onClickListener2, CharSequence charSequence4, View.OnClickListener onClickListener3, CharSequence charSequence5, View.OnClickListener onClickListener4, int i2, Object obj) {
        int i3 = i2;
        boolean z3 = false;
        boolean z4 = (i3 & 1) != 0 ? false : z;
        View.OnClickListener onClickListener5 = null;
        String str2 = (i3 & 2) != 0 ? null : str;
        int i4 = (i3 & 4) != 0 ? -1 : i;
        if ((i3 & 8) == 0) {
            z3 = z2;
        }
        View.OnClickListener onClickListener6 = (i3 & 16) != 0 ? null : onClickListener;
        CharSequence charSequence6 = (i3 & 32) != 0 ? null : charSequence;
        CharSequence charSequence7 = (i3 & 64) != 0 ? null : charSequence2;
        View view2 = (i3 & 128) != 0 ? null : view;
        CharSequence charSequence8 = (i3 & 256) != 0 ? null : charSequence3;
        View.OnClickListener onClickListener7 = (i3 & 512) != 0 ? null : onClickListener2;
        CharSequence charSequence9 = (i3 & 1024) != 0 ? null : charSequence4;
        View.OnClickListener onClickListener8 = (i3 & 2048) != 0 ? null : onClickListener3;
        CharSequence charSequence10 = (i3 & 4096) != 0 ? null : charSequence5;
        if ((i3 & 8192) == 0) {
            onClickListener5 = onClickListener4;
        }
        walletDrawerContent.config(z4, str2, i4, z3, onClickListener6, charSequence6, charSequence7, view2, charSequence8, onClickListener7, charSequence9, onClickListener8, charSequence10, onClickListener5);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a4, code lost:
        if (r1 <= 1) goto L_0x00a8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void config(boolean r10, java.lang.String r11, int r12, boolean r13, android.view.View.OnClickListener r14, java.lang.CharSequence r15, java.lang.CharSequence r16, android.view.View r17, java.lang.CharSequence r18, android.view.View.OnClickListener r19, java.lang.CharSequence r20, android.view.View.OnClickListener r21, java.lang.CharSequence r22, android.view.View.OnClickListener r23) {
        /*
            r9 = this;
            r0 = r9
            r1 = r11
            r2 = r12
            r3 = r17
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            r5 = 8
            r6 = 0
            if (r4 == 0) goto L_0x001a
            r4 = -1
            if (r2 != r4) goto L_0x001a
            android.widget.ImageView r1 = r0.f35509l
            r1.setVisibility(r5)
            goto L_0x002e
        L_0x001a:
            android.widget.ImageView r4 = r0.f35509l
            r4.setVisibility(r6)
            android.content.Context r4 = r9.getContext()
            com.didi.payment.wallet_ui.dialog.WalletDialog$Companion r7 = com.didi.payment.wallet_ui.dialog.WalletDialog.Companion
            float r7 = r7.getRadius()
            android.widget.ImageView r8 = r0.f35509l
            com.didi.payment.base.utils.GlideUtils.loadTopRoundImageMix(r4, r12, r11, r7, r8)
        L_0x002e:
            if (r13 == 0) goto L_0x0041
            android.widget.ImageView r1 = r0.f35508k
            r1.setVisibility(r6)
            android.view.View r1 = r0.f35507j
            r1.setVisibility(r6)
            android.view.View r1 = r0.f35507j
            r2 = r14
            r1.setOnClickListener(r14)
            goto L_0x004b
        L_0x0041:
            android.widget.ImageView r1 = r0.f35508k
            r1.setVisibility(r5)
            android.view.View r1 = r0.f35507j
            r1.setVisibility(r5)
        L_0x004b:
            boolean r1 = android.text.TextUtils.isEmpty(r15)
            if (r1 == 0) goto L_0x0057
            android.widget.TextView r1 = r0.f35506i
            r1.setVisibility(r5)
            goto L_0x0062
        L_0x0057:
            android.widget.TextView r1 = r0.f35506i
            r1.setVisibility(r6)
            android.widget.TextView r1 = r0.f35506i
            r2 = r15
            r1.setText(r15)
        L_0x0062:
            boolean r1 = android.text.TextUtils.isEmpty(r16)
            if (r1 == 0) goto L_0x006e
            android.widget.TextView r1 = r0.f35505h
            r1.setVisibility(r5)
            goto L_0x007a
        L_0x006e:
            android.widget.TextView r1 = r0.f35505h
            r1.setVisibility(r6)
            android.widget.TextView r1 = r0.f35505h
            r2 = r16
            r1.setText(r2)
        L_0x007a:
            if (r3 != 0) goto L_0x0082
            android.widget.FrameLayout r1 = r0.f35504g
            r1.setVisibility(r5)
            goto L_0x0091
        L_0x0082:
            android.widget.FrameLayout r1 = r0.f35504g
            r1.setVisibility(r6)
            android.widget.FrameLayout r1 = r0.f35504g
            r1.removeAllViews()
            android.widget.FrameLayout r1 = r0.f35504g
            r1.addView(r3)
        L_0x0091:
            if (r10 == 0) goto L_0x00a7
            r1 = 2
            boolean r2 = android.text.TextUtils.isEmpty(r18)
            r3 = 1
            if (r2 == 0) goto L_0x009c
            r1 = 1
        L_0x009c:
            boolean r2 = android.text.TextUtils.isEmpty(r20)
            if (r2 == 0) goto L_0x00a4
            int r1 = r1 + -1
        L_0x00a4:
            if (r1 > r3) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r6 = r10
        L_0x00a8:
            if (r6 == 0) goto L_0x00b6
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r9.m26883a(r1, r2, r3, r4)
            goto L_0x00ce
        L_0x00b6:
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r10 = r9
            r11 = r18
            r12 = r19
            r13 = r20
            r14 = r21
            r15 = r22
            r16 = r23
            r10.m26884a(r11, r12, r13, r14, r15, r16)
        L_0x00ce:
            com.didi.payment.wallet_ui.UiUtils$Companion r1 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r1 = r1.getScreenWidth()
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r2)
            com.didi.payment.wallet_ui.UiUtils$Companion r3 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r3 = r3.getScreenHeight()
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            r9.measure(r1, r3)
            android.widget.FrameLayout r1 = r0.f35510m
            com.didi.payment.wallet_ui.UiUtils$Companion r3 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r3 = r3.getScreenWidth()
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            com.didi.payment.wallet_ui.UiUtils$Companion r4 = com.didi.payment.wallet_ui.UiUtils.Companion
            int r4 = r4.getScreenHeight()
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r2)
            r1.measure(r3, r2)
            int r1 = r9.getMeasuredHeight()
            int r2 = r0.f35513p
            if (r1 <= r2) goto L_0x0120
            androidx.core.widget.NestedScrollView r1 = r0.f35503f
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            int r3 = r0.f35513p
            android.widget.FrameLayout r4 = r9.getMFlBottomBtn()
            int r4 = r4.getMeasuredHeight()
            int r3 = r3 - r4
            r2.height = r3
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            r1.setLayoutParams(r2)
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet_ui.dialog.WalletDrawerContent.config(boolean, java.lang.String, int, boolean, android.view.View$OnClickListener, java.lang.CharSequence, java.lang.CharSequence, android.view.View, java.lang.CharSequence, android.view.View$OnClickListener, java.lang.CharSequence, android.view.View$OnClickListener, java.lang.CharSequence, android.view.View$OnClickListener):void");
    }

    /* renamed from: a */
    static /* synthetic */ void m26882a(WalletDrawerContent walletDrawerContent, CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2, CharSequence charSequence3, View.OnClickListener onClickListener3, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        if ((i & 8) != 0) {
            onClickListener2 = null;
        }
        if ((i & 16) != 0) {
            charSequence3 = null;
        }
        if ((i & 32) != 0) {
            onClickListener3 = null;
        }
        walletDrawerContent.m26884a(charSequence, onClickListener, charSequence2, onClickListener2, charSequence3, onClickListener3);
    }

    /* renamed from: a */
    private final void m26884a(CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2, CharSequence charSequence3, View.OnClickListener onClickListener3) {
        this.f35512o.setVisibility(0);
        this.f35511n.setVisibility(8);
        this.f35502e.setVisibility(0);
        this.f35502e.configButton(charSequence, onClickListener);
        if (TextUtils.isEmpty(charSequence2)) {
            this.f35501d.setVisibility(8);
        } else {
            this.f35501d.setVisibility(0);
            this.f35501d.configButton(charSequence2, onClickListener2);
        }
        if (TextUtils.isEmpty(charSequence3)) {
            this.f35500c.setVisibility(8);
            return;
        }
        this.f35500c.setVisibility(0);
        this.f35500c.configButton(charSequence3, onClickListener3);
    }

    /* renamed from: a */
    static /* synthetic */ void m26881a(WalletDrawerContent walletDrawerContent, CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = null;
        }
        if ((i & 2) != 0) {
            onClickListener = null;
        }
        if ((i & 4) != 0) {
            charSequence2 = null;
        }
        if ((i & 8) != 0) {
            onClickListener2 = null;
        }
        walletDrawerContent.m26883a(charSequence, onClickListener, charSequence2, onClickListener2);
    }

    /* renamed from: a */
    private final void m26883a(CharSequence charSequence, View.OnClickListener onClickListener, CharSequence charSequence2, View.OnClickListener onClickListener2) {
        this.f35512o.setVisibility(8);
        this.f35511n.setVisibility(0);
        this.f35499b.setVisibility(0);
        this.f35499b.setText(charSequence);
        this.f35499b.setOnClickListener(onClickListener);
        this.f35498a.setVisibility(0);
        this.f35498a.setText(charSequence2);
        this.f35498a.setOnClickListener(onClickListener2);
    }

    @Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000eR\u001c\u00100\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR\u001a\u00103\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR\u001c\u00106\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001c\u0010<\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\f\"\u0004\b>\u0010\u000e¨\u0006C"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/dialog/WalletDrawerContent$Builder;", "", "()V", "closeClickListener", "Landroid/view/View$OnClickListener;", "getCloseClickListener", "()Landroid/view/View$OnClickListener;", "setCloseClickListener", "(Landroid/view/View$OnClickListener;)V", "content", "", "getContent", "()Ljava/lang/CharSequence;", "setContent", "(Ljava/lang/CharSequence;)V", "firstBtnText", "getFirstBtnText", "setFirstBtnText", "firstClickListener", "getFirstClickListener", "setFirstClickListener", "horizontalAction", "", "getHorizontalAction", "()Z", "setHorizontalAction", "(Z)V", "imageRes", "", "getImageRes", "()I", "setImageRes", "(I)V", "imageUrl", "", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "insertView", "Landroid/view/View;", "getInsertView", "()Landroid/view/View;", "setInsertView", "(Landroid/view/View;)V", "secondBtnText", "getSecondBtnText", "setSecondBtnText", "secondClickListener", "getSecondClickListener", "setSecondClickListener", "showClose", "getShowClose", "setShowClose", "thirdBtnText", "getThirdBtnText", "setThirdBtnText", "thirdClickListener", "getThirdClickListener", "setThirdClickListener", "title", "getTitle", "setTitle", "build", "Lcom/didi/payment/wallet_ui/dialog/WalletDrawerContent;", "context", "Landroid/content/Context;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletDrawerContent.kt */
    public static final class Builder {
        private View.OnClickListener closeClickListener;
        private CharSequence content;
        private CharSequence firstBtnText;
        private View.OnClickListener firstClickListener;
        private boolean horizontalAction;
        private int imageRes = -1;
        private String imageUrl;
        private View insertView;
        private CharSequence secondBtnText;
        private View.OnClickListener secondClickListener;
        private boolean showClose;
        private CharSequence thirdBtnText;
        private View.OnClickListener thirdClickListener;
        private CharSequence title;

        public final boolean getHorizontalAction() {
            return this.horizontalAction;
        }

        public final void setHorizontalAction(boolean z) {
            this.horizontalAction = z;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }

        public final int getImageRes() {
            return this.imageRes;
        }

        public final void setImageRes(int i) {
            this.imageRes = i;
        }

        public final boolean getShowClose() {
            return this.showClose;
        }

        public final void setShowClose(boolean z) {
            this.showClose = z;
        }

        public final View.OnClickListener getCloseClickListener() {
            return this.closeClickListener;
        }

        public final void setCloseClickListener(View.OnClickListener onClickListener) {
            this.closeClickListener = onClickListener;
        }

        public final CharSequence getTitle() {
            return this.title;
        }

        public final void setTitle(CharSequence charSequence) {
            this.title = charSequence;
        }

        public final CharSequence getContent() {
            return this.content;
        }

        public final void setContent(CharSequence charSequence) {
            this.content = charSequence;
        }

        public final View getInsertView() {
            return this.insertView;
        }

        public final void setInsertView(View view) {
            this.insertView = view;
        }

        public final CharSequence getFirstBtnText() {
            return this.firstBtnText;
        }

        public final void setFirstBtnText(CharSequence charSequence) {
            this.firstBtnText = charSequence;
        }

        public final View.OnClickListener getFirstClickListener() {
            return this.firstClickListener;
        }

        public final void setFirstClickListener(View.OnClickListener onClickListener) {
            this.firstClickListener = onClickListener;
        }

        public final CharSequence getSecondBtnText() {
            return this.secondBtnText;
        }

        public final void setSecondBtnText(CharSequence charSequence) {
            this.secondBtnText = charSequence;
        }

        public final View.OnClickListener getSecondClickListener() {
            return this.secondClickListener;
        }

        public final void setSecondClickListener(View.OnClickListener onClickListener) {
            this.secondClickListener = onClickListener;
        }

        public final CharSequence getThirdBtnText() {
            return this.thirdBtnText;
        }

        public final void setThirdBtnText(CharSequence charSequence) {
            this.thirdBtnText = charSequence;
        }

        public final View.OnClickListener getThirdClickListener() {
            return this.thirdClickListener;
        }

        public final void setThirdClickListener(View.OnClickListener onClickListener) {
            this.thirdClickListener = onClickListener;
        }

        public final WalletDrawerContent build(Context context) {
            Context context2 = context;
            Intrinsics.checkNotNullParameter(context2, "context");
            WalletDrawerContent walletDrawerContent = new WalletDrawerContent(context2, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
            walletDrawerContent.config(getHorizontalAction(), getImageUrl(), getImageRes(), getShowClose(), getCloseClickListener(), getTitle(), getContent(), getInsertView(), getFirstBtnText(), getFirstClickListener(), getSecondBtnText(), getSecondClickListener(), getThirdBtnText(), getThirdClickListener());
            return walletDrawerContent;
        }
    }
}
