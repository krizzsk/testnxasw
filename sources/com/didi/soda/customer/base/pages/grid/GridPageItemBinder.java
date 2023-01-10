package com.didi.soda.customer.base.pages.grid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.decorator.ItemDecorator;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001Bo\u0012/\u0010\u0004\u001a+\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000b\u0012/\u0010\f\u001a+\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0016R7\u0010\f\u001a+\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\rX\u0004¢\u0006\u0002\n\u0000R7\u0010\u0004\u001a+\u0012\u0004\u0012\u00020\u0002\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/GridPageItemBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/soda/customer/base/pages/grid/GridItemModel;", "Lcom/didi/soda/customer/base/pages/grid/AllSceneItemHolder;", "onGridItemClickEvent", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "Lcom/didi/soda/customer/base/pages/grid/OnGridItemClickEvent;", "onGridItemBindEvent", "Lcom/didi/soda/customer/base/pages/grid/OnGridItemBindEvent;", "itemDecorator", "Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lcom/didi/app/nova/support/view/recyclerview/decorator/ItemDecorator;)V", "bind", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "getColumnCount", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridPageItemBinder.kt */
public final class GridPageItemBinder extends ItemBinder<GridItemModel, AllSceneItemHolder> {

    /* renamed from: a */
    private final Function2<GridItemModel, Integer, Unit> f42960a;

    /* renamed from: b */
    private final Function2<GridItemModel, Integer, Unit> f42961b;

    public Class<GridItemModel> bindDataType() {
        return GridItemModel.class;
    }

    public int getColumnCount() {
        return 2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GridPageItemBinder(Function2<? super GridItemModel, ? super Integer, Unit> function2, Function2<? super GridItemModel, ? super Integer, Unit> function22, ItemDecorator itemDecorator) {
        super(itemDecorator);
        Intrinsics.checkNotNullParameter(itemDecorator, "itemDecorator");
        this.f42960a = function2;
        this.f42961b = function22;
    }

    public AllSceneItemHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = layoutInflater.inflate(R.layout.customer_item_home_all_scene_comp_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new AllSceneItemHolder(inflate);
    }

    public void bind(AllSceneItemHolder allSceneItemHolder, GridItemModel gridItemModel) {
        Intrinsics.checkNotNullParameter(allSceneItemHolder, "holder");
        if (gridItemModel == null) {
            allSceneItemHolder.itemView.setVisibility(8);
            return;
        }
        allSceneItemHolder.itemView.setVisibility(0);
        int positionInManager = allSceneItemHolder.getPositionInManager();
        allSceneItemHolder.bindData();
        allSceneItemHolder.itemView.setOnClickListener(new View.OnClickListener(gridItemModel, positionInManager) {
            public final /* synthetic */ GridItemModel f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                GridPageItemBinder.m32113a(GridPageItemBinder.this, this.f$1, this.f$2, view);
            }
        });
        allSceneItemHolder.itemView.post(new Runnable(gridItemModel, positionInManager) {
            public final /* synthetic */ GridItemModel f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GridPageItemBinder.m32112a(GridPageItemBinder.this, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32113a(GridPageItemBinder gridPageItemBinder, GridItemModel gridItemModel, int i, View view) {
        Intrinsics.checkNotNullParameter(gridPageItemBinder, "this$0");
        Function2<GridItemModel, Integer, Unit> function2 = gridPageItemBinder.f42960a;
        if (function2 != null) {
            function2.invoke(gridItemModel, Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m32112a(GridPageItemBinder gridPageItemBinder, GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(gridPageItemBinder, "this$0");
        Function2<GridItemModel, Integer, Unit> function2 = gridPageItemBinder.f42961b;
        if (function2 != null) {
            function2.invoke(gridItemModel, Integer.valueOf(i));
        }
    }
}
