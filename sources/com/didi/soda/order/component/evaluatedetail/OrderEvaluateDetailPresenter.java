package com.didi.soda.order.component.evaluatedetail;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.order.component.evaluatedetail.Contract;
import com.didi.soda.order.omega.EvaluateOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class OrderEvaluateDetailPresenter extends Contract.AbsOrderEvaluateDetailPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f45952a;

    /* renamed from: b */
    private String f45953b;

    /* renamed from: c */
    private String f45954c;

    public void closePage() {
        getScopeContext().getNavigator().finish();
    }

    public void retryRequest() {
        m34111a();
    }

    public void onImageItemClick(ImageView imageView, String str) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = imageView.getContext().getString(R.string.customer_transition_tag_evaluate_preview_image_named, new Object[]{valueOf});
        int width = imageView.getWidth();
        ViewCompat.setTransitionName(imageView, string);
        if (!TextUtils.isEmpty(str)) {
            DiRouter.request().path(RoutePath.EVALUATE_PREVIEW_IMAGE).putString(Const.PageParams.TRANSITION_NAMES, string).putString(Const.PageParams.PREVIEW_IMAGE_URL, str).putInt(Const.PageParams.PREVIEW_IMAGE_WIDTH, width).open();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString("orderid");
        this.f45952a = string;
        if (TextUtils.isEmpty(string)) {
            this.f45952a = bundle.getString("orderId");
        }
        String string2 = bundle.getString("from");
        this.f45953b = string2;
        if (TextUtils.isEmpty(string2)) {
            this.f45953b = bundle.getInt("from") + "";
        }
        this.f45954c = bundle.getString(Const.PageParams.PUSH_METHOD, "");
        m34111a();
    }

    /* renamed from: a */
    private void m34111a() {
        if (!TextUtils.isEmpty(this.f45952a)) {
            ((Contract.AbsOrderEvaluateDetailView) getLogicView()).hideAbnormalView();
            DialogUtil.showLoadingDialog(getScopeContext(), false);
            CustomerRpcManagerProxy.get().getEvaluationInfo(this.f45952a, this.f45954c, new CustomerRpcCallback<OrderEvaluationEntity>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    DialogUtil.hideLoadingDialog();
                    ((Contract.AbsOrderEvaluateDetailView) OrderEvaluateDetailPresenter.this.getLogicView()).showErrorNetView(sFRpcException.getMessage());
                }

                public void onRpcSuccess(OrderEvaluationEntity orderEvaluationEntity, long j) {
                    DialogUtil.hideLoadingDialog();
                    if (orderEvaluationEntity == null) {
                        ((Contract.AbsOrderEvaluateDetailView) OrderEvaluateDetailPresenter.this.getLogicView()).showErrorNetView((String) null);
                        return;
                    }
                    ((Contract.AbsOrderEvaluateDetailView) OrderEvaluateDetailPresenter.this.getLogicView()).initEvaluationView(orderEvaluationEntity);
                    int i = 0;
                    if (!(orderEvaluationEntity.shop == null || orderEvaluationEntity.shop.reply == null)) {
                        i = 1;
                    }
                    EvaluateOmegaHelper.Companion.trackEvaluateDetailSw(OrderEvaluateDetailPresenter.this.f45952a, OrderEvaluateDetailPresenter.this.m34112b(), i);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m34112b() {
        if (!TextUtils.isEmpty(this.f45954c)) {
            String str = this.f45954c;
            char c = 65535;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        c = 1;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                return "3";
            }
            if (c == 1) {
                return "2";
            }
            if (c == 2) {
                return "4";
            }
        }
        return this.f45953b;
    }
}
