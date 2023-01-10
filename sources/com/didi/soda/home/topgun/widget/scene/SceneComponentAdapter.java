package com.didi.soda.home.topgun.widget.scene;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.customer.base.pages.grid.GridItemModel;
import com.didi.soda.customer.foundation.util.CollectionUtilsKt;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\rH\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\rH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/scene/SceneComponentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/soda/home/topgun/widget/scene/SceneComponentAdapter$ViewHolder;", "()V", "dataSource", "", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "getDataSource", "()Ljava/util/List;", "setDataSource", "(Ljava/util/List;)V", "onItemBindListener", "Lkotlin/Function2;", "", "", "getOnItemBindListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemBindListener", "(Lkotlin/jvm/functions/Function2;)V", "onItemClickListener", "getOnItemClickListener", "setOnItemClickListener", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SceneComponentAdapter.kt */
public final class SceneComponentAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: a */
    private Function2<? super GridItemModel, ? super Integer, Unit> f45817a;

    /* renamed from: b */
    private Function2<? super GridItemModel, ? super Integer, Unit> f45818b;

    /* renamed from: c */
    private List<GridItemModel> f45819c = new ArrayList();

    public final Function2<GridItemModel, Integer, Unit> getOnItemClickListener() {
        return this.f45817a;
    }

    public final void setOnItemClickListener(Function2<? super GridItemModel, ? super Integer, Unit> function2) {
        this.f45817a = function2;
    }

    public final Function2<GridItemModel, Integer, Unit> getOnItemBindListener() {
        return this.f45818b;
    }

    public final void setOnItemBindListener(Function2<? super GridItemModel, ? super Integer, Unit> function2) {
        this.f45818b = function2;
    }

    public final List<GridItemModel> getDataSource() {
        return this.f45819c;
    }

    public final void setDataSource(List<GridItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.f45819c = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_item_home_scene_comp_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …comp_item, parent, false)");
        return new ViewHolder(inflate);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        GridItemModel gridItemModel = (GridItemModel) CollectionUtilsKt.safeGet(this.f45819c, i);
        if (gridItemModel != null) {
            viewHolder.itemView.setVisibility(0);
            viewHolder.bindData(gridItemModel, i);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener(gridItemModel, i) {
                public final /* synthetic */ GridItemModel f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    SceneComponentAdapter.m33973a(SceneComponentAdapter.this, this.f$1, this.f$2, view);
                }
            });
            viewHolder.itemView.post(new Runnable(gridItemModel, i) {
                public final /* synthetic */ GridItemModel f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    SceneComponentAdapter.m33972a(SceneComponentAdapter.this, this.f$1, this.f$2);
                }
            });
            return;
        }
        viewHolder.itemView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33973a(SceneComponentAdapter sceneComponentAdapter, GridItemModel gridItemModel, int i, View view) {
        Intrinsics.checkNotNullParameter(sceneComponentAdapter, "this$0");
        Function2<GridItemModel, Integer, Unit> onItemClickListener = sceneComponentAdapter.getOnItemClickListener();
        if (onItemClickListener != null) {
            onItemClickListener.invoke(gridItemModel, Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m33972a(SceneComponentAdapter sceneComponentAdapter, GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(sceneComponentAdapter, "this$0");
        Function2<GridItemModel, Integer, Unit> onItemBindListener = sceneComponentAdapter.getOnItemBindListener();
        if (onItemBindListener != null) {
            onItemBindListener.invoke(gridItemModel, Integer.valueOf(i));
        }
    }

    public int getItemCount() {
        return this.f45819c.size();
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/soda/home/topgun/widget/scene/SceneComponentAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "textView", "Landroid/widget/TextView;", "bindData", "", "model", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "position", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SceneComponentAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView textView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.customer_item_scene_text);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.…customer_item_scene_text)");
            this.textView = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.customer_item_scene_image);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.…ustomer_item_scene_image)");
            this.imageView = (ImageView) findViewById2;
        }

        public final void bindData(GridItemModel gridItemModel, int i) {
            Intrinsics.checkNotNullParameter(gridItemModel, "model");
            this.itemView.setVisibility(0);
            this.textView.setText(gridItemModel.getTitle());
            CharSequence img = gridItemModel.getImg();
            if (img == null || img.length() == 0) {
                this.imageView.setVisibility(8);
                return;
            }
            this.imageView.setVisibility(0);
            FlyImageLoader.loadImageUnspecified(this.itemView.getContext(), gridItemModel.getImg()).placeholder((int) R.drawable.customer_icon_category_round_logo).error((int) R.drawable.customer_icon_category_round_logo).fitCenter().transform(new RoundedCornersTransformation(this.itemView.getContext(), CustomerExtentionKt.getPx(R.dimen.rf_dimen_40), 0, RoundedCornersTransformation.CornerType.RIGHT, true)).into(this.imageView);
        }
    }
}
