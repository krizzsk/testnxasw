package com.didi.global.fintech.cashier.p118ui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p118ui.IFastPaySettingContentViewHolder;
import com.didi.global.fintech.cashier.p118ui.kts.ViewKtxKt;
import com.didi.global.fintech.cashier.p118ui.viewholder.item.FastPaySettingContentItemViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016J\u0016\u0010\u0018\u001a\u00020\u00102\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0015H\u0016J\"\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010!H\u0016R\u000e\u0010\b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006#"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingContentViewHolder;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "Lcom/didi/global/fintech/cashier/ui/IFastPaySettingContentViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "itemsContainer", "ivIcon", "Landroid/widget/ImageView;", "tvSubTitle", "Landroid/widget/TextView;", "tvTerm", "tvTitle", "initView", "", "layout", "", "updateIconUrl", "icon", "", "updateMainTitle", "title", "updateSettingItems", "items", "", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingItem;", "updateSubTitle", "subtitle", "updateTermUrl", "termContent", "click", "Lkotlin/Function0;", "Companion", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingContentViewHolder */
/* compiled from: FastPaySettingContentViewHolder.kt */
public final class FastPaySettingContentViewHolder extends GlobalCashierBaseViewHolder implements IFastPaySettingContentViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ImageView f23682a;

    /* renamed from: b */
    private TextView f23683b;

    /* renamed from: c */
    private TextView f23684c;

    /* renamed from: d */
    private TextView f23685d;

    /* renamed from: e */
    private ViewGroup f23686e;

    public int layout() {
        return R.layout.viewholder_fast_pay_setting_content;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastPaySettingContentViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingContentViewHolder$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPaySettingContentViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.FastPaySettingContentViewHolder$Companion */
    /* compiled from: FastPaySettingContentViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FastPaySettingContentViewHolder newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new FastPaySettingContentViewHolder(context, viewGroup);
        }
    }

    public void initView() {
        super.initView();
        this.f23682a = (ImageView) getView(R.id.iv_icon);
        this.f23683b = (TextView) getView(R.id.tv_title);
        this.f23684c = (TextView) getView(R.id.tv_sub_title);
        this.f23685d = (TextView) getView(R.id.tv_term);
        this.f23686e = (ViewGroup) getView(R.id.llc_items);
        TextView textView = this.f23685d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTerm");
            textView = null;
        }
        textView.getPaint().setFlags(8);
    }

    public void updateMainTitle(String str) {
        TextView textView = this.f23683b;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
    }

    public void updateSubTitle(String str) {
        TextView textView = this.f23684c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
    }

    public void updateIconUrl(String str) {
        ImageView imageView = this.f23682a;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivIcon");
            imageView = null;
        }
        ViewKtxKt.load(imageView, str);
    }

    public void updateTermUrl(String str, Function0<Unit> function0) {
        TextView textView = this.f23685d;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTerm");
            textView = null;
        }
        ViewKtxKt.content(textView, str);
        TextView textView3 = this.f23685d;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTerm");
        } else {
            textView2 = textView3;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FastPaySettingContentViewHolder.m19251a(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19251a(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void updateSettingItems(List<FastPaySettingItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        ViewGroup viewGroup = this.f23686e;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemsContainer");
            viewGroup = null;
        }
        viewGroup.removeAllViews();
        for (FastPaySettingItem fastPaySettingItem : list) {
            FastPaySettingContentItemViewHolder.Companion companion = FastPaySettingContentItemViewHolder.Companion;
            Context context = getContext();
            ViewGroup viewGroup2 = this.f23686e;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemsContainer");
                viewGroup2 = null;
            }
            companion.newInstance(context, viewGroup2).updateSettingItem(fastPaySettingItem);
        }
    }
}
