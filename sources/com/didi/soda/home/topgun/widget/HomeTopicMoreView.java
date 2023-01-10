package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ViewMoreEntity;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000e¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicMoreView;", "Lcom/didi/soda/home/topgun/widget/HomeTopicBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "iconView", "Landroid/widget/TextView;", "getIconView", "()Landroid/widget/TextView;", "setIconView", "(Landroid/widget/TextView;)V", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "setRootView", "(Landroid/view/ViewGroup;)V", "textView", "getTextView", "setTextView", "onAppear", "", "setData", "model", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ViewMoreEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HomeTopicMoreView.kt */
public final class HomeTopicMoreView extends HomeTopicBaseView {

    /* renamed from: a */
    private TextView f45678a;

    /* renamed from: b */
    private TextView f45679b;

    /* renamed from: c */
    private ViewGroup f45680c;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicMoreView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicMoreView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void onAppear() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTopicMoreView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopicMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.customer_home_item_topic_more, this);
        View findViewById = findViewById(R.id.customer_tv_home_efo_more_circle);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…_tv_home_efo_more_circle)");
        this.f45678a = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_tv_home_efo_more);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_tv_home_efo_more)");
        this.f45679b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_cl_efo_more_root);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_cl_efo_more_root)");
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        this.f45680c = viewGroup;
        viewGroup.getLayoutParams().height = -1;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    }

    public final TextView getIconView() {
        return this.f45678a;
    }

    public final void setIconView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f45678a = textView;
    }

    public final TextView getTextView() {
        return this.f45679b;
    }

    public final void setTextView(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f45679b = textView;
    }

    public final ViewGroup getRootView() {
        return this.f45680c;
    }

    public final void setRootView(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<set-?>");
        this.f45680c = viewGroup;
    }

    public final void setData(ViewMoreEntity viewMoreEntity) {
        Intrinsics.checkNotNullParameter(viewMoreEntity, "model");
        this.f45678a.setText(viewMoreEntity.getIcon());
        this.f45679b.setText(viewMoreEntity.getText());
    }
}
