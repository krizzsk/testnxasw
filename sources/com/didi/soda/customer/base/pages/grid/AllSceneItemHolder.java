package com.didi.soda.customer.base.pages.grid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/AllSceneItemHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "bindData", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridPageItemBinder.kt */
public final class AllSceneItemHolder extends ItemViewHolder<GridItemModel> {

    /* renamed from: a */
    private final TextView f42947a;

    /* renamed from: b */
    private final ImageView f42948b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllSceneItemHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.customer_item_scene_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…customer_item_scene_text)");
        this.f42947a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.customer_item_scene_image);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…ustomer_item_scene_image)");
        this.f42948b = (ImageView) findViewById2;
    }

    public final void bindData() {
        this.itemView.setVisibility(0);
        this.f42947a.setText(((GridItemModel) getItem()).getTitle());
        CharSequence img = ((GridItemModel) getItem()).getImg();
        if (img == null || img.length() == 0) {
            this.f42948b.setVisibility(8);
            return;
        }
        this.f42948b.setVisibility(0);
        FlyImageLoader.loadImageUnspecified(this.itemView.getContext(), ((GridItemModel) getItem()).getImg()).placeholder((int) R.drawable.customer_icon_category_round_logo).error((int) R.drawable.customer_icon_category_round_logo).fitCenter().transform(new RoundedCornersTransformation(this.itemView.getContext(), CustomerExtentionKt.getPx(R.dimen.rf_dimen_40), 0, RoundedCornersTransformation.CornerType.BOTTOM_RIGHT, true)).into(this.f42948b);
    }
}
