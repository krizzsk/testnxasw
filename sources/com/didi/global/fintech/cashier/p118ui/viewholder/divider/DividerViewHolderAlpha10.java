package com.didi.global.fintech.cashier.p118ui.viewholder.divider;

import android.content.Context;
import android.view.ViewGroup;
import com.didi.global.fintech.cashier.p118ui.viewholder.GlobalCashierBaseViewHolder;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/divider/DividerViewHolderAlpha10;", "Lcom/didi/global/fintech/cashier/ui/viewholder/GlobalCashierBaseViewHolder;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "(Landroid/content/Context;Landroid/view/ViewGroup;)V", "initView", "", "layout", "", "Companion", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.divider.DividerViewHolderAlpha10 */
/* compiled from: DividerViewHolderAlpha10.kt */
public final class DividerViewHolderAlpha10 extends GlobalCashierBaseViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public void initView() {
    }

    public int layout() {
        return R.layout.view_item_divider_alpha_10;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DividerViewHolderAlpha10(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    @Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/divider/DividerViewHolderAlpha10$Companion;", "", "()V", "newInstance", "Lcom/didi/global/fintech/cashier/ui/viewholder/divider/DividerViewHolderAlpha10;", "context", "Landroid/content/Context;", "parent", "Landroid/view/ViewGroup;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* renamed from: com.didi.global.fintech.cashier.ui.viewholder.divider.DividerViewHolderAlpha10$Companion */
    /* compiled from: DividerViewHolderAlpha10.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DividerViewHolderAlpha10 newInstance(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            return new DividerViewHolderAlpha10(context, viewGroup);
        }
    }
}
