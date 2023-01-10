package com.didi.soda.bill.page;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.didi.soda.bill.component.tipfee.BillTipsFeeEditComponent;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lcom/didi/soda/bill/page/BillTipsFeeEditPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "mBillTipsFeeEditComponent", "Lcom/didi/soda/bill/component/tipfee/BillTipsFeeEditComponent;", "mRootContainer", "Landroid/widget/FrameLayout;", "initContentView", "", "onCreate", "view", "Landroid/view/View;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route({"billTipFeeEditPage"})
/* compiled from: BillTipsFeeEditPage.kt */
public final class BillTipsFeeEditPage extends FloatingCustomerPage {

    /* renamed from: a */
    private BillTipsFeeEditComponent f41862a;

    /* renamed from: b */
    private FrameLayout f41863b;

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        FrameLayout frameLayout = this.f41863b;
        BillTipsFeeEditComponent billTipsFeeEditComponent = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout = null;
        }
        setContentView((View) frameLayout);
        FrameLayout frameLayout2 = this.f41863b;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout2 = null;
        }
        BillTipsFeeEditComponent billTipsFeeEditComponent2 = new BillTipsFeeEditComponent(frameLayout2);
        this.f41862a = billTipsFeeEditComponent2;
        if (billTipsFeeEditComponent2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBillTipsFeeEditComponent");
        } else {
            billTipsFeeEditComponent = billTipsFeeEditComponent2;
        }
        addComponent(billTipsFeeEditComponent);
        RFFloatingNavBar navBar = getNavBar();
        if (navBar != null) {
            navBar.setTitle(new RFFloatingTextAttr.Builder(ResourceHelper.getString(R.string.FoodC_2022__SEQk)).build());
        }
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        FrameLayout frameLayout = new FrameLayout(getBaseContext());
        this.f41863b = frameLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
            frameLayout = null;
        }
        frameLayout.setBackgroundResource(R.color.rf_color_v2_grey2_10_a100);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        FrameLayout frameLayout3 = this.f41863b;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootContainer");
        } else {
            frameLayout2 = frameLayout3;
        }
        frameLayout2.setLayoutParams(layoutParams);
    }
}
