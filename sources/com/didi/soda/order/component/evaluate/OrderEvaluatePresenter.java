package com.didi.soda.order.component.evaluate;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.UploadPhotoEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationItemsListEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.RiderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.entity.order.ShopEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.didi.soda.home.feedback.GetPhotoPlugin;
import com.didi.soda.order.component.evaluate.Contract;
import com.didi.soda.order.omega.EvaluateOmegaHelper;
import com.didi.soda.router.DiRouter;
import com.didi.soda.web.model.PhotoJsBridgeData;
import com.taxis99.R;
import java.util.List;

public class OrderEvaluatePresenter extends Contract.AbsOrderEvaluatingPresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f45938a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f45939b;

    /* renamed from: c */
    private final int f45940c = 3;

    /* renamed from: d */
    private final int f45941d = 2;

    /* renamed from: e */
    private final String f45942e = "push";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f45943f = 0;

    public void saveEvaluationInfo(ShopEvaluationEntity shopEvaluationEntity, RiderEvaluationEntity riderEvaluationEntity, List<OrderEvaluationItemsListEntity> list, int i) {
        CustomerRpcManagerProxy.get().saveEvaluationInfo(this.f45938a, shopEvaluationEntity, riderEvaluationEntity, list, i, new CustomerRpcCallback<OrderEvaluationResultEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                DialogUtil.hideLoadingDialog();
                ToastUtil.showCustomerErrorToast(OrderEvaluatePresenter.this.getScopeContext(), sFRpcException.getMessage());
                ((Contract.AbsOrderEvaluatingView) OrderEvaluatePresenter.this.getLogicView()).submitError();
            }

            public void onRpcSuccess(OrderEvaluationResultEntity orderEvaluationResultEntity, long j) {
                DialogUtil.hideLoadingDialog();
                ((Contract.AbsOrderEvaluatingView) OrderEvaluatePresenter.this.getLogicView()).submitSuccess(orderEvaluationResultEntity);
            }
        });
    }

    public void closePage(boolean z, OrderEvaluationResultEntity orderEvaluationResultEntity) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isEvaluatedResult", z);
        bundle.putBoolean("data", z);
        if (z) {
            if (orderEvaluationResultEntity == null || orderEvaluationResultEntity.getEvaluationFeedback() == null || TextUtil.isEmpty(orderEvaluationResultEntity.getEvaluationFeedback().getAftersaleUrl())) {
                DialogUtil.showEvaluateFeedbackDialog(getContext(), getScopeContext(), new EvaluateCallback(bundle) {
                    public final /* synthetic */ Bundle f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void invoke() {
                        OrderEvaluatePresenter.this.m34075a(this.f$1);
                    }
                });
                return;
            }
            DiRouter.request().path(RoutePath.ORDER_EVALUATE_SUCCESS).putSerializable(Const.PageParams.EVALUATE_RESULT, orderEvaluationResultEntity.getEvaluationFeedback()).open();
            getScopeContext().getNavigator().finish(bundle);
        } else if (!((Contract.AbsOrderEvaluatingView) getLogicView()).isEditEvaluation() || !getScopeContext().getLiveHandler().isActive()) {
            getScopeContext().getNavigator().finish(bundle);
        } else {
            EvaluateOmegaHelper.Companion.trackEvaluatePopSw();
            DialogUtil.showOrderEvaluationDialog(getScopeContext().getNavigator(), new RFDialogInterface.OnClickListener() {
                public final void onClick(RFDialog rFDialog) {
                    OrderEvaluatePresenter.this.m34080b(rFDialog);
                }
            }, new RFDialogInterface.OnClickListener(bundle) {
                public final /* synthetic */ Bundle f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(RFDialog rFDialog) {
                    OrderEvaluatePresenter.this.m34076a(this.f$1, rFDialog);
                }
            }, $$Lambda$OrderEvaluatePresenter$Rx9HpBI0O1Sgo84sJlZgvndD2r0.INSTANCE);
            OmegaTracker.Builder.create(EventConst.SideBar.SAILING_C_X_SIDEBAR_EVALUATE_DETAIN_POPUP_SW).build().track();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34075a(Bundle bundle) {
        getScopeContext().getNavigator().finish(bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m34080b(RFDialog rFDialog) {
        DialogUtil.showLoadingDialog(getScopeContext(), false);
        EvaluateOmegaHelper.Companion.trackEvaluatePageCompleteCk(1, this.f45943f, 1, 1, ((Contract.AbsOrderEvaluatingView) getLogicView()).getShopEvaluationEntity().tagIds, ((Contract.AbsOrderEvaluatingView) getLogicView()).getRiderEvaluationEntity().tagIds, ((Contract.AbsOrderEvaluatingView) getLogicView()).getShopEvaluationEntity().content, ((Contract.AbsOrderEvaluatingView) getLogicView()).getRiderEvaluationEntity().content, ((Contract.AbsOrderEvaluatingView) getLogicView()).getShopEvaluationEntity().score, ((Contract.AbsOrderEvaluatingView) getLogicView()).getGoodsEvaluationEntity(), ((Contract.AbsOrderEvaluatingView) getLogicView()).getRiderEvaluationEntity().score);
        saveEvaluationInfo(((Contract.AbsOrderEvaluatingView) getLogicView()).getShopEvaluationEntity(), ((Contract.AbsOrderEvaluatingView) getLogicView()).getRiderEvaluationEntity(), ((Contract.AbsOrderEvaluatingView) getLogicView()).getGoodsEvaluationEntity(), 3);
        EvaluateOmegaHelper.Companion.trackEvaluatePopCk(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34076a(Bundle bundle, RFDialog rFDialog) {
        getScopeContext().getNavigator().finish(bundle);
        EvaluateOmegaHelper.Companion.trackEvaluatePopCk(1);
    }

    public void retryRequest() {
        m34074a();
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString("orderid");
        this.f45938a = string;
        if (TextUtils.isEmpty(string)) {
            this.f45938a = bundle.getString("orderId");
        }
        if ("push".equals(bundle.getString("source"))) {
            this.f45939b = 3;
        } else {
            this.f45939b = bundle.getInt("from", 0);
        }
        m34074a();
    }

    /* renamed from: a */
    private void m34074a() {
        if (!TextUtils.isEmpty(this.f45938a)) {
            ((Contract.AbsOrderEvaluatingView) getLogicView()).hideAbnormalView();
            DialogUtil.showLoadingDialog(getScopeContext(), false);
            CustomerRpcManagerProxy.get().getEvaluationIndex(this.f45938a, new CustomerRpcCallback<OrderEvaluationEntity>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    DialogUtil.hideLoadingDialog();
                    ((Contract.AbsOrderEvaluatingView) OrderEvaluatePresenter.this.getLogicView()).showErrorNetView(sFRpcException.getMessage());
                }

                public void onRpcSuccess(OrderEvaluationEntity orderEvaluationEntity, long j) {
                    DialogUtil.hideLoadingDialog();
                    if (orderEvaluationEntity == null) {
                        ((Contract.AbsOrderEvaluatingView) OrderEvaluatePresenter.this.getLogicView()).showErrorNetView((String) null);
                        return;
                    }
                    int i = OrderEvaluatePresenter.this.getScopeContext().getBundle().getInt(Const.FlutterBundleKey.SELECTED_NUMBER, 0);
                    if ((OrderEvaluatePresenter.this.f45939b == 2 && orderEvaluationEntity.shop != null && orderEvaluationEntity.shop.hasEvalScore == 500) || i == 5) {
                        ToastUtil.showCustomerToast(OrderEvaluatePresenter.this.getScopeContext(), OrderEvaluatePresenter.this.getContext().getString(R.string.FoodC_improve__chkD));
                    } else if ((orderEvaluationEntity.rider != null && orderEvaluationEntity.rider.hasEval) || (orderEvaluationEntity.shop != null && orderEvaluationEntity.shop.hasEval)) {
                        int unused = OrderEvaluatePresenter.this.f45943f = 1;
                        ToastUtil.showCustomerToast(OrderEvaluatePresenter.this.getScopeContext(), OrderEvaluatePresenter.this.getContext().getString(R.string.FoodC_improve__KTQu));
                    }
                    EvaluateOmegaHelper.Companion companion = EvaluateOmegaHelper.Companion;
                    String b = OrderEvaluatePresenter.this.f45938a;
                    String str = "";
                    String str2 = orderEvaluationEntity.shop != null ? orderEvaluationEntity.shop.shopId : str;
                    if (orderEvaluationEntity.rider != null) {
                        str = orderEvaluationEntity.rider.riderId;
                    }
                    companion.init(b, str2, str);
                    EvaluateOmegaHelper.Companion.trackEvaluatePageShow(OrderEvaluatePresenter.this.f45939b, OrderEvaluatePresenter.this.f45943f);
                    ((Contract.AbsOrderEvaluatingView) OrderEvaluatePresenter.this.getLogicView()).initEvaluationView(i, orderEvaluationEntity);
                }
            });
        }
    }

    /* renamed from: b */
    private void m34079b() {
        DialogUtil.showLoadingDialog(getScopeContext(), true, false, new SodaWindowFactory.DialogKeyBackListener() {
            public final boolean handleBack() {
                return OrderEvaluatePresenter.this.m34086e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ boolean m34086e() {
        m34082c();
        getScopeContext().getNavigator().finish((Bundle) null);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34082c() {
        DialogUtil.hideLoadingDialog();
    }

    public void onUploadAddBtnClk() {
        m34079b();
        PhotoJsBridgeData.GetPhotoData defaultPhotoData = GetPhotoPlugin.Companion.getDefaultPhotoData();
        defaultPhotoData.setQuality(1.0f);
        PhotoJsBridgeData.GetPhotoData.PicSize picSize = new PhotoJsBridgeData.GetPhotoData.PicSize();
        picSize.setWidth(CustomerSystemUtil.getScreenWidth(getContext()) / 3);
        picSize.setHeight(CustomerSystemUtil.getScreenHeight(getContext()) / 3);
        defaultPhotoData.setResize(picSize);
        GetPhotoPlugin.Companion.getPhotoString(defaultPhotoData, new GetPhotoPlugin.CallBack() {
            public void onSuccess(final String str) {
                CustomerRpcManagerProxy.get().updatePhoto(str, 1, new CustomerRpcCallback<UploadPhotoEntity>() {
                    public void onRpcSuccess(UploadPhotoEntity uploadPhotoEntity, long j) {
                        String downloadUrl = uploadPhotoEntity.getDownloadUrl();
                        if (!StringUtils.isEmpty(downloadUrl)) {
                            ((Contract.AbsOrderEvaluatingView) OrderEvaluatePresenter.this.getLogicView()).addUploadImageView(GetPhotoPlugin.Companion.getImageStringByPhoto(str), downloadUrl);
                        }
                        OrderEvaluatePresenter.this.m34082c();
                    }

                    public void onRpcFailure(SFRpcException sFRpcException) {
                        super.onRpcFailure(sFRpcException);
                        OrderEvaluatePresenter.this.m34083d();
                    }
                });
            }

            public void onFailed(String str) {
                OrderEvaluatePresenter.this.m34083d();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EvaluateOmegaHelper.Companion.detach();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m34083d() {
        m34082c();
        ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.FoodC_C_Image_upload_QdPk));
    }
}
