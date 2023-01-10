package com.didiglobal.pay.paysecure.prepaidcard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u000b\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\b\u0010\u001d\u001a\u00020\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo148868d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CommonLoadingTVButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hintText", "", "isLoading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "lav", "Lcom/airbnb/lottie/LottieAnimationView;", "textVal", "tvConfirm", "Landroid/widget/TextView;", "getTextView", "hideLoading", "", "", "setBackground", "result", "setEnabled", "enabled", "setText", "text", "", "showLoading", "startLoading", "stopLoading", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: CommonLoadingTVButton.kt */
public final class CommonLoadingTVButton extends FrameLayout {

    /* renamed from: a */
    private CharSequence f52859a;

    /* renamed from: b */
    private CharSequence f52860b;

    /* renamed from: c */
    private AtomicBoolean f52861c;

    /* renamed from: d */
    private final TextView f52862d;

    /* renamed from: e */
    private final LottieAnimationView f52863e;

    public CommonLoadingTVButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public CommonLoadingTVButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonLoadingTVButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonLoadingTVButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f52859a = "";
        this.f52860b = "";
        this.f52861c = new AtomicBoolean(false);
        View.inflate(context, R.layout.wallet_common_btn_confirm, this);
        View findViewById = findViewById(R.id.tv_common_button_confirm);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.tv_common_button_confirm)");
        this.f52862d = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.lav_common_button_loading);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.lav_common_button_loading)");
        this.f52863e = (LottieAnimationView) findViewById2;
        ColorStateList colorStateList = null;
        Drawable drawable = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.CommonLoadingTVButton, 0, 0);
        this.f52859a = obtainStyledAttributes.getText(1);
        this.f52860b = obtainStyledAttributes.getText(2);
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(0);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
        obtainStyledAttributes.recycle();
        if (colorStateList2 != null) {
            this.f52862d.setTextColor(colorStateList2);
        }
        if (drawable2 != null) {
            this.f52862d.setBackground(drawable2);
        }
        this.f52862d.setText(this.f52859a);
        this.f52862d.setHint(this.f52860b);
    }

    public final void setText(String str) {
        this.f52862d.setText(str);
    }

    public void startLoading() {
        this.f52861c.getAndSet(true);
        m39652a();
    }

    public void stopLoading() {
        this.f52861c.getAndSet(false);
        m39653b();
    }

    public final boolean isLoading() {
        return this.f52861c.get();
    }

    public final TextView getTextView() {
        return this.f52862d;
    }

    public final void setBackground(int i) {
        this.f52862d.setBackgroundResource(i);
        this.f52862d.setTextColor(ContextCompat.getColor(getContext(), R.color.wallet_button_text_disable));
    }

    /* renamed from: a */
    private final void m39652a() {
        this.f52863e.setVisibility(0);
        this.f52863e.setRepeatCount(-1);
        this.f52863e.playAnimation();
        this.f52862d.setVisibility(8);
    }

    /* renamed from: b */
    private final void m39653b() {
        this.f52862d.setVisibility(0);
        this.f52863e.setVisibility(8);
        this.f52863e.cancelAnimation();
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(i)");
            childAt.setEnabled(z);
        }
    }
}
