package com.didi.entrega.order.debt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.entrega.customer.base.pages.FloatingCustomerPage;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.taxis99.R;

@Route({"debtOrderPayPage"})
public class DebtOrderPayPage extends FloatingCustomerPage {

    /* renamed from: a */
    FrameLayout f22730a;

    /* renamed from: b */
    private View f22731b;

    /* renamed from: c */
    private DebtOrderPayComponent f22732c;

    public DebtOrderPayPage() {
        DiRouter.registerHub("debtOrderPayPage", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        setContentView(this.f22731b);
        setType(1);
        DebtOrderPayComponent debtOrderPayComponent = new DebtOrderPayComponent(this.f22730a);
        this.f22732c = debtOrderPayComponent;
        addComponent(debtOrderPayComponent);
    }

    public void onPageResult(Bundle bundle) {
        DebtOrderPayComponent debtOrderPayComponent;
        super.onPageResult(bundle);
        if (bundle != null && (debtOrderPayComponent = this.f22732c) != null) {
            debtOrderPayComponent.onPageResult(bundle);
        }
    }

    public boolean onHandleBack() {
        DebtOrderPayComponent debtOrderPayComponent = this.f22732c;
        if (debtOrderPayComponent != null) {
            return debtOrderPayComponent.onHandleBack();
        }
        return super.onHandleBack();
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.entrega_customer_page_order_pay_info, (ViewGroup) getView(), false);
        this.f22731b = inflate;
        this.f22730a = (FrameLayout) inflate.findViewById(R.id.customer_fl_pay_info_container);
    }
}
