package com.didi.soda.order.page.refund;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.order.component.refund.RefundDetailComponent;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/soda/order/page/refund/RefundDetailPage;", "Lcom/didi/soda/customer/base/pages/FloatingCustomerPage;", "()V", "refundContainer", "Landroid/widget/FrameLayout;", "rootView", "Landroid/view/View;", "initContentView", "", "onCreate", "view", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
@Route({"refundDetailPage"})
/* compiled from: RefundDetailPage.kt */
public final class RefundDetailPage extends FloatingCustomerPage {

    /* renamed from: a */
    private FrameLayout f46093a;

    /* renamed from: b */
    private View f46094b;

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f46094b;
        FrameLayout frameLayout = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view2 = null;
        }
        setContentView(view2);
        setType(2);
        FrameLayout frameLayout2 = this.f46093a;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refundContainer");
        } else {
            frameLayout = frameLayout2;
        }
        addComponent(new RefundDetailComponent(frameLayout));
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_rff_refund_detail, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f46094b = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.customer_fl_refund_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.…omer_fl_refund_container)");
        this.f46093a = (FrameLayout) findViewById;
    }
}
