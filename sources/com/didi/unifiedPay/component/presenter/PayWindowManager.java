package com.didi.unifiedPay.component.presenter;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.component.AbsUnifiedPaymentPresenter;
import com.didi.unifiedPay.component.manager.PayTranceEventManager;
import com.didi.unifiedPay.component.model.PayErrorEvent;
import com.didi.unifiedPay.component.view.IPayView;
import com.didi.unifiedPay.component.widget.FailStateView;
import com.taxis99.R;
import global.didi.pay.model.LoadingState;
import org.greenrobot.eventbus.EventBus;

public class PayWindowManager {

    /* renamed from: a */
    private IPayView f47034a;

    /* renamed from: b */
    private Context f47035b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AbsUnifiedPaymentPresenter f47036c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayTranceEventManager f47037d;

    public PayWindowManager(IPayView iPayView, AbsUnifiedPaymentPresenter absUnifiedPaymentPresenter, Context context, String str, int i) {
        this.f47034a = iPayView;
        this.f47036c = absUnifiedPaymentPresenter;
        this.f47035b = context;
        this.f47037d = new PayTranceEventManager(context, str, i);
    }

    public void showFailView(String str, String str2, String str3, String str4) {
        this.f47037d.doOmegaPayCardFailure(str2, str3, str4, false);
        m34997a(str);
    }

    /* renamed from: a */
    private void m34997a(String str) {
        m34998a(str, 0, ResourcesHelper.getString(this.f47035b, R.string.car_confirm), (FailStateView.ClickListener) null);
    }

    public void showFailAndGoPayedPage(String str) {
        m34998a(str, 0, ResourcesHelper.getString(this.f47035b, R.string.car_confirm), (FailStateView.ClickListener) new FailStateView.ClickListener() {
            public void onCancel() {
            }

            public void onConfirm() {
                PayWindowManager.this.f47036c.gotoPayedPage();
            }
        });
    }

    public void showFailView(final int i, final String str, final boolean z) {
        m34998a(str, i, ResourcesHelper.getString(this.f47035b, R.string.car_confirm), (FailStateView.ClickListener) new FailStateView.ClickListener() {
            public void onCancel() {
            }

            public void onConfirm() {
                if (z) {
                    EventBus.getDefault().post(new PayErrorEvent(i, str));
                }
            }
        });
    }

    public void payFailedAndReflushBill(String str, String str2, String str3, String str4) {
        payFailedAndReflushBill(str, ResourcesHelper.getString(this.f47035b, R.string.oc_fail_state_retry), str2, str3, str4);
    }

    public void payFailedAndReflushBill(String str, String str2, final String str3, final String str4, final String str5) {
        this.f47037d.doOmegaPayCardFailure(str3, str4, str5, false);
        m34998a(str, 0, str2, (FailStateView.ClickListener) new FailStateView.ClickListener() {
            public void onCancel() {
                PayWindowManager.this.f47037d.doOmegaPayCardFailureCancel(str3, str4, str5, false);
            }

            public void onConfirm() {
                PayWindowManager.this.f47037d.doOmegaPayCardFailureRetry(str3, str4, str5, false);
                PayWindowManager.this.f47036c.getPayInfo();
            }
        });
    }

    public void payFailedAndRePay(String str) {
        if (TextUtil.isEmpty(str)) {
            str = ResourcesHelper.getString(this.f47035b, R.string.car_no_pwd_pay_fail_title);
        }
        m34998a(str, 0, ResourcesHelper.getString(this.f47035b, R.string.oc_fail_state_retry), (FailStateView.ClickListener) new FailStateView.ClickListener() {
            public void onCancel() {
            }

            public void onConfirm() {
                PayWindowManager.this.f47036c.onPayButtonClick();
            }
        });
    }

    public void serviceNotUsable(String str) {
        m34998a(str, 0, ResourcesHelper.getString(this.f47035b, R.string.car_confirm), (FailStateView.ClickListener) new FailStateView.ClickListener() {
            public void onCancel() {
            }

            public void onConfirm() {
                PayWindowManager.this.f47036c.onCloseBtnClick();
            }
        });
    }

    public void onNotGetPayResult(String str, String str2, String str3, String str4) {
        this.f47037d.doOmegaPayCardFailure(str2, str3, str4, true);
        m35001b(str);
    }

    /* renamed from: b */
    private void m35001b(String str) {
        if (!TextUtil.isEmpty(str)) {
            m34999a(str, ResourcesHelper.getString(this.f47035b, R.string.oc_fail_state_cancel), ResourcesHelper.getString(this.f47035b, R.string.oc_fail_state_retry), (FailStateView.ClickListener) new FailStateView.ClickListener() {
                public void onCancel() {
                }

                public void onConfirm() {
                    PayWindowManager.this.f47036c.queryPayResult(true, LoadingState.TYPE_LOADING, 0);
                }
            });
        }
    }

    public void showOrderFreezeDialog(String str) {
        m34998a(str, 1, this.f47035b.getResources().getString(R.string.oc_uni_pay_i_know), (FailStateView.ClickListener) new FailStateView.ClickListener() {
            public void onCancel() {
            }

            public void onConfirm() {
                SystemUtils.log(3, "showOrderFreezeDialog", "onConfirm", (Throwable) null, "com.didi.unifiedPay.component.presenter.PayWindowManager$7", 213);
                PayWindowManager.this.f47036c.onOrderFeezeConfirmClick();
            }
        });
    }

    /* renamed from: a */
    private void m34998a(String str, int i, String str2, final FailStateView.ClickListener clickListener) {
        FailStateView.Config config = new FailStateView.Config();
        config.icon = FailStateView.Config.ICON_INFO;
        config.singleButton = true;
        config.message = str;
        config.errorCode = i;
        config.confirmText = str2;
        config.listener = new FailStateView.ClickListener() {
            public void onCancel() {
                FailStateView.ClickListener clickListener = clickListener;
                if (clickListener != null) {
                    clickListener.onCancel();
                }
            }

            public void onConfirm() {
                FailStateView.ClickListener clickListener = clickListener;
                if (clickListener != null) {
                    clickListener.onConfirm();
                }
            }
        };
        this.f47034a.showErrorView(config);
    }

    /* renamed from: a */
    private void m34999a(String str, String str2, String str3, final FailStateView.ClickListener clickListener) {
        FailStateView.Config config = new FailStateView.Config();
        config.icon = FailStateView.Config.ICON_INFO;
        config.singleButton = false;
        config.message = str;
        config.cancelText = str2;
        config.confirmText = str3;
        config.listener = new FailStateView.ClickListener() {
            public void onCancel() {
                FailStateView.ClickListener clickListener = clickListener;
                if (clickListener != null) {
                    clickListener.onCancel();
                }
            }

            public void onConfirm() {
                FailStateView.ClickListener clickListener = clickListener;
                if (clickListener != null) {
                    clickListener.onConfirm();
                }
            }
        };
        this.f47034a.showErrorView(config);
    }
}
