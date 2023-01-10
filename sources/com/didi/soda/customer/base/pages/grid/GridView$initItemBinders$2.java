package com.didi.soda.customer.base.pages.grid;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridView.kt */
/* synthetic */ class GridView$initItemBinders$2 extends FunctionReferenceImpl implements Function2<GridItemModel, Integer, Unit> {
    GridView$initItemBinders$2(Object obj) {
        super(2, obj, GridView.class, "onGridItemBindEvent", "onGridItemBindEvent(Lcom/didi/soda/customer/base/pages/grid/GridItemModel;I)V", 0);
    }

    public /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((GridItemModel) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(GridItemModel gridItemModel, int i) {
        Intrinsics.checkNotNullParameter(gridItemModel, "p0");
        ((GridView) this.receiver).m32114a(gridItemModel, i);
    }
}
