package com.didi.payment.wallet_ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0014J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0006\u0010&\u001a\u00020\u001eJ\u0006\u0010'\u001a\u00020\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00168F@FX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/WalletLoadingButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "loadingBtnAutoClickLoading", "", "mAvLoading", "Lcom/airbnb/lottie/LottieAnimationView;", "mTvContent", "Lcom/didi/payment/wallet_ui/WalletButton;", "preLoadingTextColor", "getPreLoadingTextColor", "()I", "setPreLoadingTextColor", "(I)V", "value", "", "text", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "isEnabled", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setEnabled", "enabled", "setOnClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "startLoading", "stopLoading", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletLoadingButton.kt */
public final class WalletLoadingButton extends FrameLayout {

    /* renamed from: a */
    private LottieAnimationView f35456a;

    /* renamed from: b */
    private WalletButton f35457b;

    /* renamed from: c */
    private boolean f35458c;

    /* renamed from: d */
    private int f35459d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletLoadingButton(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletLoadingButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35458c = true;
        View.inflate(context, R.layout.wallet_ui_button, this);
        View findViewById = findViewById(R.id.av_loading);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.av_loading)");
        this.f35456a = (LottieAnimationView) findViewById;
        View findViewById2 = findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_content)");
        this.f35457b = (WalletButton) findViewById2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WalletLoadingButton);
        LottieAnimationView lottieAnimationView = this.f35456a;
        ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
        int i4 = obtainStyledAttributes.getInt(3, 1);
        if (i4 != 2) {
            i3 = i4 != 3 ? (UiUtils.Companion.intSize(104) * 36) / 104 : (UiUtils.Companion.intSize(60) * 36) / 104;
        } else {
            i3 = (UiUtils.Companion.intSize(80) * 36) / 104;
        }
        layoutParams.height = i3;
        layoutParams.width = (layoutParams.height * 60) / 36;
        Unit unit = Unit.INSTANCE;
        lottieAnimationView.setLayoutParams(layoutParams);
        this.f35456a.setAnimation((obtainStyledAttributes.getInt(1, 1) != 1 || !UiUtils.Companion.isWhiteInThemeBg()) ? R.raw.wallet_button_loading_dark : R.raw.wallet_button_loading_light);
        this.f35457b.setText(obtainStyledAttributes.getString(2));
        this.f35458c = obtainStyledAttributes.getBoolean(0, true);
        this.f35457b.configAttr(obtainStyledAttributes.getInt(3, 1), obtainStyledAttributes.getInt(1, 1), obtainStyledAttributes.getInt(4, 1));
        obtainStyledAttributes.recycle();
    }

    public final CharSequence getText() {
        return this.f35457b.getText();
    }

    public final void setText(CharSequence charSequence) {
        this.f35457b.setText(charSequence);
    }

    public final void startLoading() {
        if (!this.f35456a.isAnimating()) {
            this.f35459d = this.f35457b.getCurrentTextColor();
            this.f35457b.setClickable(false);
            this.f35457b.setTextColor(0);
            this.f35456a.setVisibility(0);
            this.f35456a.playAnimation();
        }
    }

    public final void stopLoading() {
        if (this.f35456a.isAnimating()) {
            this.f35457b.setClickable(true);
            this.f35456a.setVisibility(8);
            this.f35456a.cancelAnimation();
            this.f35457b.setTextColor(this.f35459d);
        }
    }

    public final int getPreLoadingTextColor() {
        return this.f35459d;
    }

    public final void setPreLoadingTextColor(int i) {
        this.f35459d = i;
    }

    public boolean isEnabled() {
        return this.f35457b.isEnabled();
    }

    public void setEnabled(boolean z) {
        this.f35457b.setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f35457b.measure(i, i2);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f35457b.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.f35457b.getMeasuredHeight(), 1073741824));
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        if (!this.f35458c) {
            this.f35457b.setOnClickListener(onClickListener);
        } else if (onClickListener != null) {
            this.f35457b.setOnClickListener(new View.OnClickListener(onClickListener) {
                public final /* synthetic */ View.OnClickListener f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    WalletLoadingButton.m26877a(WalletLoadingButton.this, this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m26877a(WalletLoadingButton walletLoadingButton, View.OnClickListener onClickListener, View view) {
        Intrinsics.checkNotNullParameter(walletLoadingButton, "this$0");
        Intrinsics.checkNotNullParameter(onClickListener, "$listener");
        if (!walletLoadingButton.f35456a.isAnimating()) {
            walletLoadingButton.startLoading();
            onClickListener.onClick(view);
        }
    }
}
