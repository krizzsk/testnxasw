package com.didi.soda.customer.base.pages.grid;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.foundation.util.CustomerExtentionKt;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\b\u001a\u00020\tH\u0014J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo148868d2 = {"Lcom/didi/soda/customer/base/pages/grid/GridPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "Lcom/didi/soda/customer/base/pages/grid/ICorrespond;", "()V", "containerLayout", "Landroid/widget/FrameLayout;", "getSceneData", "Lcom/didi/soda/customer/base/pages/grid/GridPageData;", "initContentView", "", "initGridData", "onCreate", "view", "Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GridPage.kt */
public abstract class GridPage extends FloatingCustomerPage implements ICorrespond {

    /* renamed from: a */
    private FrameLayout f42957a;

    public abstract GridPageData initGridData();

    /* access modifiers changed from: protected */
    public void initContentView() {
        FrameLayout frameLayout = new FrameLayout(getBaseContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        frameLayout.setBackgroundColor(CustomerExtentionKt.getColor(R.color.rf_color_v2_grey2_10_a100));
        Unit unit = Unit.INSTANCE;
        this.f42957a = frameLayout;
    }

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        FrameLayout frameLayout = this.f42957a;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerLayout");
            frameLayout = null;
        }
        setContentView((View) frameLayout);
        setType(1);
        GridPageData b = m32111b();
        ICorrespond iCorrespond = this;
        FrameLayout frameLayout3 = this.f42957a;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("containerLayout");
        } else {
            frameLayout2 = frameLayout3;
        }
        GridComponent gridComponent = new GridComponent(iCorrespond, frameLayout2);
        gridComponent.setUpdateSceneDataBlock(new GridPage$onCreate$1(b));
        addComponent(gridComponent);
    }

    /* renamed from: b */
    private final GridPageData m32111b() {
        GridPageData initGridData = initGridData();
        RFFloatingNavBar navBar = getNavBar();
        String title = initGridData == null ? null : initGridData.getTitle();
        if (title == null) {
            title = "";
        }
        navBar.setTitle(new RFFloatingTextAttr.Builder(title).build());
        return initGridData;
    }
}
