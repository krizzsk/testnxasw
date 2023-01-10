package com.didi.consume.phone.view.prsenter;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.consume.base.CsNetModel;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.base.CsRouter;
import com.didi.consume.orderdetail.view.CsTopupOrderDetailActivity;
import com.didi.consume.phone.model.CsAmountListResp;
import com.didi.consume.phone.model.CsCouponOrderBody;
import com.didi.consume.phone.model.CsCreateOrderBody;
import com.didi.consume.phone.model.CsCreateOrderResp;
import com.didi.consume.phone.model.CsVoucherResponse;
import com.didi.consume.phone.view.contract.CsPhoneAmountContract;
import com.didi.payment.base.dialog.PayCommonDialogFragment;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.wallet.contract.WalletLoadingContract;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsPhoneAmountPresenter implements CsPhoneAmountContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f18247a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CsPhoneAmountContract.View f18248b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletLoadingContract f18249c;

    /* renamed from: d */
    private CsNetModel f18250d;

    /* renamed from: e */
    private WalletPageModel f18251e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f18252f = -1;

    public CsPhoneAmountPresenter(FragmentActivity fragmentActivity, CsPhoneAmountContract.View view, WalletLoadingContract walletLoadingContract) {
        this.f18247a = fragmentActivity;
        this.f18248b = view;
        this.f18249c = walletLoadingContract;
        this.f18250d = CsNetModel.getIns(fragmentActivity);
        this.f18251e = new WalletPageModel(this.f18247a);
        if (fragmentActivity.getIntent() != null) {
            this.f18252f = fragmentActivity.getIntent().getIntExtra("order_type", -1);
            SystemUtils.log(3, "hgl_tag", "order_type = " + this.f18252f, (Throwable) null, "com.didi.consume.phone.view.prsenter.CsPhoneAmountPresenter", 60);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("topup_channel", Integer.valueOf(this.f18252f != 1 ? 0 : 1));
        FinOmegaSDK.trackEvent("ibt_mouton_pax_phone_topup_by_drv_amount_sw", hashMap);
    }

    public void getAmountList(int i, String str, String str2, String str3, String str4) {
        this.f18249c.showLoadingDialog();
        this.f18250d.getAmountList(i, str, str2, str3, str4, new RpcService.Callback<CsAmountListResp>() {
            public void onSuccess(CsAmountListResp csAmountListResp) {
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                if (csAmountListResp == null) {
                    WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, CsPhoneAmountPresenter.this.f18247a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsPhoneAmountPresenter.this.f18248b.onNetworkError();
                } else if (csAmountListResp.errno != 0 || csAmountListResp.data == null) {
                    WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, csAmountListResp.errmsg);
                    CsPhoneAmountPresenter.this.f18248b.onNetworkError();
                } else {
                    CsPhoneAmountPresenter.this.f18248b.showAmountList(csAmountListResp.data);
                }
            }

            public void onFailure(IOException iOException) {
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, CsPhoneAmountPresenter.this.f18247a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsPhoneAmountPresenter.this.f18248b.onNetworkError();
            }
        });
    }

    public void getVoucherDiscount(int i, String str) {
        this.f18248b.showVoucherLoading();
        this.f18249c.showLoadingDialog();
        this.f18250d.getVoucherDiscount(i, str, new RpcService.Callback<CsVoucherResponse>() {
            public void onSuccess(CsVoucherResponse csVoucherResponse) {
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                if (csVoucherResponse == null) {
                    WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, CsPhoneAmountPresenter.this.f18247a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsPhoneAmountPresenter.this.f18248b.onNetworkError();
                } else if (csVoucherResponse.errno != 0 || csVoucherResponse.data == null) {
                    WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, csVoucherResponse.errmsg);
                    CsPhoneAmountPresenter.this.f18248b.onNetworkError();
                } else {
                    CsPhoneAmountPresenter.this.f18248b.showVoucherAmount(csVoucherResponse.data);
                }
            }

            public void onFailure(IOException iOException) {
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, CsPhoneAmountPresenter.this.f18247a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsPhoneAmountPresenter.this.f18248b.onNetworkError();
            }
        });
    }

    public void trackOmega(int i) {
        if (i == 0) {
            HashMap hashMap = new HashMap();
            hashMap.put("page", "amount");
            int i2 = 1;
            if (this.f18252f != 1) {
                i2 = 0;
            }
            hashMap.put("order_type", Integer.valueOf(i2));
            CsOmegaUtils.trackPhoneBillConfirmBtnClicked((Map<String, Object>) hashMap);
        }
    }

    public void createPhoneRefillOrder(final int i, String str, CsCreateOrderBody csCreateOrderBody, CsCouponOrderBody csCouponOrderBody) {
        this.f18249c.showLoadingDialog();
        this.f18250d.createPhoneRefillOrder(i, str, csCreateOrderBody, csCouponOrderBody, new RpcService.Callback<CsCreateOrderResp>() {
            public void onSuccess(CsCreateOrderResp csCreateOrderResp) {
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                CsPhoneAmountPresenter.this.m15427a(csCreateOrderResp);
                if (csCreateOrderResp == null) {
                    WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, CsPhoneAmountPresenter.this.f18247a.getResources().getString(R.string.one_payment_global_net_toast_serverbusy));
                    CsPhoneAmountPresenter.this.f18248b.onNetworkError();
                } else if (csCreateOrderResp.errno != 0 || csCreateOrderResp.data == null) {
                    WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, csCreateOrderResp.errmsg);
                    CsPhoneAmountPresenter.this.f18248b.onNetworkError();
                } else {
                    if (TextUtils.isEmpty(csCreateOrderResp.data.outTradeId)) {
                        CsPhoneAmountPresenter.this.m15426a(i, csCreateOrderResp.data.orderId);
                    } else if (!CsPhoneAmountPresenter.this.m15432a(csCreateOrderResp.data)) {
                        PayTracker.trackEvent("ibt_gp_didipay_phonebill_create_order_rsp_ok_unified_pay_bt");
                        CsPhoneAmountPresenter.this.f18248b.goToUniPay(CsPhoneAmountPresenter.this.f18247a, csCreateOrderResp.data);
                    }
                    CsCreateOrderResp.ToastInfo toastInfo = csCreateOrderResp.data.toastInfo;
                    if (toastInfo != null && toastInfo.isErrorToast()) {
                        WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, toastInfo.message);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                PayTracker.trackEvent("ibt_gp_didipay_phonebill_create_order_rsp_fail_bt");
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                WalletToastNew.showFailedMsg(CsPhoneAmountPresenter.this.f18247a, CsPhoneAmountPresenter.this.f18247a.getResources().getString(R.string.one_payment_global_net_toast_connectionerror));
                CsPhoneAmountPresenter.this.f18248b.onNetworkError();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15427a(CsCreateOrderResp csCreateOrderResp) {
        String str;
        if (csCreateOrderResp == null) {
            str = "empty_json";
        } else if (csCreateOrderResp.errno != 0) {
            str = "errno=" + csCreateOrderResp.errno;
        } else {
            str = (csCreateOrderResp.data == null || !TextUtils.isEmpty(csCreateOrderResp.data.outTradeId)) ? "" : "no_outtraceid";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("err_reason", str);
        PayTracker.trackEvent("ibt_gp_didipay_phonebill_create_order_rsp_ok_error_bt", hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15426a(final int i, final String str) {
        this.f18249c.showLoadingDialog();
        this.f18251e.getOrderStatus(i, str, new RpcService.Callback<WalletPayResultResp>() {
            public void onSuccess(WalletPayResultResp walletPayResultResp) {
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                Bundle bundle = new Bundle();
                bundle.putInt("product_line", i);
                bundle.putString("order_id", str);
                bundle.putInt("order_type", CsPhoneAmountPresenter.this.f18252f);
                bundle.putInt(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_FROM_PAGE, 258);
                CsTopupOrderDetailActivity.launch(CsPhoneAmountPresenter.this.f18247a, 1002, bundle);
            }

            public void onFailure(IOException iOException) {
                CsPhoneAmountPresenter.this.f18249c.dismissLoadingDialog();
                SystemUtils.log(3, "hgl_tag", "request order status fail ...", (Throwable) null, "com.didi.consume.phone.view.prsenter.CsPhoneAmountPresenter$4", 222);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m15432a(final CsCreateOrderResp.DataBean dataBean) {
        if (dataBean == null || dataBean.extraInfo == null || dataBean.extraInfo.prePayDialogInfo == null || dataBean.extraInfo.accountInfo == null) {
            return false;
        }
        CsCreateOrderResp.PrePayDialogInfo prePayDialogInfo = dataBean.extraInfo.prePayDialogInfo;
        boolean isNewPayMethodListEnable = WalletApolloUtil.isNewPayMethodListEnable();
        String str = prePayDialogInfo.title;
        String str2 = prePayDialogInfo.posBtnText;
        String str3 = prePayDialogInfo.negBtnText;
        if (isNewPayMethodListEnable) {
            if (!TextUtil.isEmpty(prePayDialogInfo.newTitle)) {
                str = prePayDialogInfo.newTitle;
            }
            if (!TextUtil.isEmpty(prePayDialogInfo.newPosBtnText)) {
                str2 = prePayDialogInfo.newPosBtnText;
            }
            if (!TextUtil.isEmpty(prePayDialogInfo.newNegBtnText)) {
                str3 = prePayDialogInfo.newNegBtnText;
            }
        }
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        C79425 r11 = new PayCommonDialogFragment.OnButtonClickedListener() {
            public void onPosButtonClicked(PayCommonDialogFragment payCommonDialogFragment) {
                CsPhoneAmountPresenter.this.m15431a("ibt_gp_didipay_phonebill_pk_didi_ck", dataBean);
                CsRouter.gotoAccountStatusPage(CsPhoneAmountPresenter.this.f18247a, dataBean);
            }

            public void onNegButtonClicked(PayCommonDialogFragment payCommonDialogFragment) {
                CsPhoneAmountPresenter.this.m15431a("ibt_gp_didipay_phonebill_pk_other_ck", dataBean);
                if (dataBean.extraInfo.prePayDialogInfo.canUseOtherPay) {
                    CsPhoneAmountPresenter.this.f18248b.goToUniPay(CsPhoneAmountPresenter.this.f18247a, dataBean);
                }
                payCommonDialogFragment.dismiss();
            }
        };
        PayTracker.trackEvent("ibt_gp_didipay_phonebill_create_order_rsp_ok_prepay_dialog_bt");
        PayCommonDialogFragment.show(this.f18247a, str4, "", str5, str6, r11);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15431a(String str, CsCreateOrderResp.DataBean dataBean) {
        if (dataBean != null && dataBean.extraInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(TransGlobalOmegaKey.KEY_ACCOUNT_STATUS, Integer.valueOf(dataBean.extraInfo.accountStatus));
            PayTracker.trackEvent(str, hashMap);
        }
    }
}
