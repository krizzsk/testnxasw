package com.didi.global.fintech.cashier.soda.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p118ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p118ui.viewholder.GlobalCashierBaseViewHolder;
import com.didi.global.fintech.cashier.soda.contract.ISodaHeaderViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u001cH\u0016R\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/viewholder/SodaHeaderViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/soda/contract/ISodaHeaderViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "ivClose", "Landroid/widget/ImageView;", "getIvClose", "()Landroid/widget/ImageView;", "setIvClose", "(Landroid/widget/ImageView;)V", "tvTitle", "Landroid/widget/TextView;", "getTvTitle", "()Landroid/widget/TextView;", "setTvTitle", "(Landroid/widget/TextView;)V", "initView", "", "layout", "", "updateHeaderInfo", "title", "", "click", "Lkotlin/Function0;", "Companion", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaHeaderViewHolder.kt */
public final class SodaHeaderViewHolder extends GlobalCashierBaseViewHolder implements ISodaHeaderViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public ImageView ivClose;
    public TextView tvTitle;

    public int layout() {
        return R.layout.viewholder_global_cashier_header;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SodaHeaderViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/soda/viewholder/SodaHeaderViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/soda/viewholder/SodaHeaderViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_soda_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SodaHeaderViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SodaHeaderViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new SodaHeaderViewHolder(context, viewGroup);
        }
    }

    public final ImageView getIvClose() {
        ImageView imageView = this.ivClose;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ivClose");
        return null;
    }

    public final void setIvClose(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.ivClose = imageView;
    }

    public final TextView getTvTitle() {
        TextView textView = this.tvTitle;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    public final void setTvTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvTitle = textView;
    }

    public void initView() {
        super.initView();
        View findViewById = getMRootView().findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.iv_close)");
        setIvClose((ImageView) findViewById);
        View findViewById2 = getMRootView().findViewById(R.id.tv_page_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.tv_page_title)");
        setTvTitle((TextView) findViewById2);
    }

    public void updateHeaderInfo(String str, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "click");
        ViewKtxKt.content(getTvTitle(), str);
        getIvClose().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SodaHeaderViewHolder.m19230a(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19230a(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$click");
        function0.invoke();
    }
}
