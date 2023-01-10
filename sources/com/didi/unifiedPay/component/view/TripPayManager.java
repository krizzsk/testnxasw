package com.didi.unifiedPay.component.view;

import android.content.Context;
import com.taxis99.R;

public class TripPayManager implements IPayManager {

    /* renamed from: a */
    private Context f47105a;

    /* renamed from: b */
    private PaymentView f47106b;

    public TripPayManager(Context context, PaymentView paymentView) {
        this.f47105a = context;
        this.f47106b = paymentView;
    }

    public void showQueryPayResultView(boolean z) {
        if (z) {
            if (this.f47106b.mListener != null) {
                this.f47106b.mListener.onShowQueryPayResultView();
            }
            if (this.f47106b.payBtnClicked) {
                if (this.f47106b.isShowLoadingStateView()) {
                    this.f47106b.showLoadingView("", false);
                }
                m35051a();
                return;
            }
            this.f47106b.showLoadingView(this.f47105a.getString(R.string.oc_pay_loading_state_string), z);
            return;
        }
        this.f47106b.showLoadingView("", false);
        this.f47106b.resetViewClickable();
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showSuccessView(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x006a
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            com.didi.unifiedPay.component.view.IPayView$PayViewListener r4 = r4.mListener
            if (r4 == 0) goto L_0x000f
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            com.didi.unifiedPay.component.view.IPayView$PayViewListener r4 = r4.mListener
            r4.onPaySuccess()
        L_0x000f:
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            boolean r4 = r4.payBtnClicked
            if (r4 == 0) goto L_0x0023
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            boolean r4 = r4.isShowBizView()
            if (r4 == 0) goto L_0x0023
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            r4.showSuccessOnPayBtn()
            return
        L_0x0023:
            r4 = 0
            com.didi.unifiedPay.component.view.PaymentView r0 = r3.f47106b
            android.widget.FrameLayout r0 = r0.payStateLayout
            int r0 = r0.getChildCount()
            r1 = 0
            if (r0 <= 0) goto L_0x0040
            com.didi.unifiedPay.component.view.PaymentView r0 = r3.f47106b
            android.widget.FrameLayout r0 = r0.payStateLayout
            android.view.View r0 = r0.getChildAt(r1)
            boolean r2 = r0 instanceof com.didi.unifiedPay.component.widget.LoadingStateView
            if (r2 == 0) goto L_0x0040
            r4 = r0
            com.didi.unifiedPay.component.widget.LoadingStateView r4 = (com.didi.unifiedPay.component.widget.LoadingStateView) r4
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r4 != 0) goto L_0x004a
            com.didi.unifiedPay.component.widget.LoadingStateView r4 = new com.didi.unifiedPay.component.widget.LoadingStateView
            android.content.Context r2 = r3.f47105a
            r4.<init>(r2)
        L_0x004a:
            r4.setText((java.lang.String) r5)
            com.didi.unifiedPay.component.widget.LoadingStateView$State r5 = com.didi.unifiedPay.component.widget.LoadingStateView.State.SUCCESS_STATE
            r4.changeState(r5)
            if (r0 != 0) goto L_0x0076
            com.didi.unifiedPay.component.view.PaymentView r5 = r3.f47106b
            r5.showPayStateView(r4)
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            android.widget.LinearLayout r4 = r4.payBizViewLayout
            r5 = 8
            r4.setVisibility(r5)
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            android.widget.FrameLayout r4 = r4.payStateLayout
            r4.setVisibility(r1)
            goto L_0x0076
        L_0x006a:
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            android.widget.FrameLayout r4 = r4.payStateLayout
            r4.removeAllViews()
            com.didi.unifiedPay.component.view.PaymentView r4 = r3.f47106b
            r4.showBizViewLayout()
        L_0x0076:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.unifiedPay.component.view.TripPayManager.showSuccessView(boolean, java.lang.String):void");
    }

    public void onPayBtnClick() {
        this.f47106b.setPayBtnState(PayBtnState.LOADING);
        this.f47106b.rootGroupView.setIntercept(true);
    }

    /* renamed from: a */
    private void m35051a() {
        if (!this.f47106b.rootGroupView.isIntercept()) {
            this.f47106b.rootGroupView.setIntercept(true);
        }
        this.f47106b.setPayBtnState(PayBtnState.LOADING);
    }
}
