package com.didi.soda.business.page;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.soda.business.component.detail.BusinessDetailComponent;
import com.didi.soda.customer.base.pages.FloatingCustomerPage;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;

@Route({"businessDetailPage"})
public class BusinessDetailPage extends FloatingCustomerPage {

    /* renamed from: a */
    View f42324a;

    /* renamed from: b */
    FrameLayout f42325b;

    /* renamed from: c */
    private BusinessDetailComponent f42326c;

    public BusinessDetailPage() {
        DiRouter.registerHub(RoutePath.BUSINESS_DETAIL, this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f42324a);
        setType(2);
        BusinessDetailComponent businessDetailComponent = new BusinessDetailComponent(this.f42325b);
        this.f42326c = businessDetailComponent;
        addComponent(businessDetailComponent);
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.customer_page_business_detail, (ViewGroup) getView(), false);
        this.f42324a = inflate;
        this.f42325b = (FrameLayout) inflate.findViewById(R.id.customer_fl_business_detail_container);
    }
}
