package com.didi.global.fintech.cashier.p118ui.viewholder;

import android.view.View;
import android.widget.TextView;
import com.didi.global.fintech.cashier.p118ui.viewholder.ItemViewFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0017H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/global/fintech/cashier/ui/viewholder/AddCardItem;", "Lcom/didi/global/fintech/cashier/ui/viewholder/BaseItemView;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "setSubTitle", "(Landroid/widget/TextView;)V", "title", "getTitle", "setTitle", "type", "Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "getType", "()Lcom/didi/global/fintech/cashier/ui/viewholder/ItemViewFactory$Type;", "bind", "", "data", "Lcom/didi/global/fintech/cashier/ui/viewholder/FastPayOrderItem;", "addCardClick", "Lkotlin/Function0;", "cashier_ui_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.viewholder.AddCardItem */
/* compiled from: FastPayOrderContentViewHolder.kt */
public final class AddCardItem extends BaseItemView {

    /* renamed from: a */
    private final ItemViewFactory.Type f23672a = ItemViewFactory.Type.AddCard;

    /* renamed from: b */
    private TextView f23673b;

    /* renamed from: c */
    private TextView f23674c;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddCardItem(android.view.ViewGroup r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r0 = r4.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            r1 = 2131626484(0x7f0e09f4, float:1.8880205E38)
            r2 = 0
            android.view.View r4 = r0.inflate(r1, r4, r2)
            java.lang.String r0 = "from(parent.context)\n   …card_item, parent, false)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            r3.<init>(r4)
            com.didi.global.fintech.cashier.ui.viewholder.ItemViewFactory$Type r4 = com.didi.global.fintech.cashier.p118ui.viewholder.ItemViewFactory.Type.AddCard
            r3.f23672a = r4
            android.view.View r4 = r3.itemView
            r0 = 2131435258(0x7f0b1efa, float:1.8492353E38)
            android.view.View r4 = r4.findViewById(r0)
            java.lang.String r0 = "itemView.findViewById(R.id.tv_item_title)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.f23673b = r4
            android.view.View r4 = r3.itemView
            r0 = 2131435257(0x7f0b1ef9, float:1.8492351E38)
            android.view.View r4 = r4.findViewById(r0)
            java.lang.String r0 = "itemView.findViewById(R.id.tv_item_sub_title)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r3.f23674c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.viewholder.AddCardItem.<init>(android.view.ViewGroup):void");
    }

    /* access modifiers changed from: protected */
    public ItemViewFactory.Type getType() {
        return this.f23672a;
    }

    public final TextView getTitle() {
        return this.f23673b;
    }

    public final void setTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f23673b = textView;
    }

    public final TextView getSubTitle() {
        return this.f23674c;
    }

    public final void setSubTitle(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.f23674c = textView;
    }

    public void bind(FastPayOrderItem fastPayOrderItem, Function0<Unit> function0) {
        super.bind(fastPayOrderItem, function0);
        String str = null;
        this.f23673b.setText(fastPayOrderItem == null ? null : fastPayOrderItem.getContent());
        TextView textView = this.f23674c;
        if (fastPayOrderItem != null) {
            str = fastPayOrderItem.getSubContent();
        }
        textView.setText(str);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AddCardItem.m19247a(Function0.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19247a(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }
}
