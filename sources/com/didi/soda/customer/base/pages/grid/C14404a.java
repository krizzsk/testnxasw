package com.didi.soda.customer.base.pages.grid;

import android.graphics.Rect;
import com.didi.soda.customer.component.feed.decorator.GridPaddingDecorator;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/SpaceItemDecoration;", "Lcom/didi/soda/customer/component/feed/decorator/GridPaddingDecorator;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "position", "", "positionType", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.soda.customer.base.pages.grid.a */
/* compiled from: GridView.kt */
final class C14404a extends GridPaddingDecorator {
    public void getItemOffsets(Rect rect, int i, int i2) {
        super.getItemOffsets(rect, i, i2);
        if (!((i2 & 8) == 0 || rect == null)) {
            rect.bottom = CustomerExtentionKt.getPx(R.dimen.customer_22px);
        }
        if ((i2 & 2) != 0 && rect != null) {
            rect.top = CustomerExtentionKt.getPx(R.dimen.customer_10px);
        }
    }
}
