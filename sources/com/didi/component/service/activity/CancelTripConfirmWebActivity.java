package com.didi.component.service.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NotificationUtils;
import com.didi.component.business.util.UiHelper;
import com.didi.component.common.GlobalWebActivity;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.log.LogOutput;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;
import java.util.Map;
import org.json.JSONObject;

public class CancelTripConfirmWebActivity extends GlobalWebActivity {
    public static final String KEY_IS_FROM_DASH_CAM = "key_is_from_dash_cam";

    /* renamed from: d */
    private static final String f17530d = "cancellation_fee_waived";

    /* renamed from: a */
    private final Logger f17531a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private Context f17532b;

    /* renamed from: c */
    private ProgressDialogFragment f17533c;

    /* renamed from: e */
    private boolean f17534e;

    /* renamed from: f */
    private Object f17535f;

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<JSONObject> f17536g = new BaseEventPublisher.OnEventListener<JSONObject>() {
        public void onEvent(String str, JSONObject jSONObject) {
            if (jSONObject != null) {
                CancelTripConfirmWebActivity.this.m14859a(jSONObject);
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.f17535f = OmegaSDK.getGlobalAttr("g_PageId");
        OmegaSDK.putGlobalAttr("g_PageId", "cancel");
        m14860b();
        this.f17532b = this;
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.OnService.EVENT_CANCEL_TRIP_H5_CALLBACK, this.f17536g);
        if (getIntent() != null) {
            this.f17534e = getIntent().getBooleanExtra(KEY_IS_FROM_DASH_CAM, false);
        }
    }

    /* renamed from: b */
    private void m14860b() {
        if (getWebView() != null) {
            getWebView().getSettings().setCacheMode(2);
            getWebView().getSettings().setAppCacheEnabled(false);
        }
    }

    public void onBackPressed() {
        finish();
    }

    public void postCancelTrip(int i, String str) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (this.f17533c == null) {
                ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
                this.f17533c = progressDialogFragment;
                progressDialogFragment.setContent(this.f17532b.getString(R.string.scar_wait_for_arrival_cancel_trip_waiting_txt), false);
            }
            if (!this.f17533c.isAdded() && getSupportFragmentManager() != null) {
                this.f17533c.show(getSupportFragmentManager(), "");
            }
            CarRequest.cancelTrip(getApplicationContext(), order.oid, 0, i, str, (Map<String, Object>) null, new ResponseListener<CarCancelTrip>() {
                public void onError(CarCancelTrip carCancelTrip) {
                    super.onError(carCancelTrip);
                }

                public void onFail(CarCancelTrip carCancelTrip) {
                    super.onFail(carCancelTrip);
                }

                public void onFinish(CarCancelTrip carCancelTrip) {
                    CancelTripConfirmWebActivity.this.m14857a(carCancelTrip);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14857a(CarCancelTrip carCancelTrip) {
        ProgressDialogFragment progressDialogFragment = this.f17533c;
        if (progressDialogFragment != null && progressDialogFragment.isAdded()) {
            this.f17533c.dismissAllowingStateLoss();
        }
        int errorCode = carCancelTrip.getErrorCode();
        String errorMsg = carCancelTrip.getErrorMsg();
        NotificationUtils.getInstance(this.f17532b).hideNotification();
        this.f17531a.info(LogOutput.showOutputLog(carCancelTrip, "get cancel trip result"), new Object[0]);
        if (errorCode == 1035) {
            if (!TextUtil.isEmpty(errorMsg)) {
                ToastHelper.showShortInfo((Context) this, errorMsg);
            }
            m14858a((CarCancelTrip) null, errorCode);
        } else if (errorCode == 596) {
            Context context = this.f17532b;
            ToastHelper.showShortInfo(context, ResourcesHelper.getString(context, R.string.global_system_busy_click_toast), (int) R.drawable.global_toast_error);
        } else if (CarHttpHelper.validate(this, carCancelTrip)) {
            m14862c();
            ToastHelper.showShortInfo((Context) this, ResourcesHelper.getString(this, R.string.global_rider_cancel_success));
            m14861b(carCancelTrip);
        }
    }

    /* renamed from: c */
    private void m14862c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.comboType == 500 && order.carDriver != null) {
            CarRequest.notifyDriverStateOfPsg(this.f17532b, 2, order.carDriver.did, (ResponseListener<BaseObject>) null);
        }
    }

    /* renamed from: b */
    private void m14861b(final CarCancelTrip carCancelTrip) {
        String str = carCancelTrip.title;
        String str2 = carCancelTrip.explainText;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            m14858a(carCancelTrip, 0);
        } else if (((FragmentActivity) this.f17532b).getSupportFragmentManager() != null) {
            AlertDialogFragment.Builder alertDialogBuilder = UiHelper.getAlertDialogBuilder(this.f17532b);
            alertDialogBuilder.setTitle(str).setMessage(str2).setPositiveButton((CharSequence) ResourcesHelper.getString(this.f17532b, R.string.cancellation_fee_waived_dialog_confirm), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    CancelTripConfirmWebActivity.this.m14858a(carCancelTrip, 0);
                    alertDialogFragment.dismiss();
                }
            }).setPositiveButtonDefault();
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.create().show(((FragmentActivity) this.f17532b).getSupportFragmentManager(), f17530d);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14858a(CarCancelTrip carCancelTrip, int i) {
        CarOrder order;
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.OnService.EVENT_CANCEL_TRIP_H5_CALLBACK, this.f17536g);
        if (!(carCancelTrip == null || carCancelTrip.errno != 0 || (order = CarOrderHelper.getOrder()) == null)) {
            order.carCancelTrip = carCancelTrip;
            CarOrderHelper.saveOrder(order);
        }
        if (this.f17534e) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.OnService.EVENT_DISAGREE_DASH_CAM);
        }
        if (carCancelTrip == null) {
            carCancelTrip = new CarCancelTrip();
        }
        carCancelTrip.errno = i;
        Bundle bundle = new Bundle();
        bundle.putSerializable(BaseExtras.CancelService.EXTRA_CANCEL_TRIP_CONTENT, carCancelTrip);
        Intent intent = new Intent();
        intent.putExtra(BaseExtras.CancelService.EXTRA_CANCEL_TRIP_DATA, bundle);
        setResult(-1, intent);
        onBackPressed();
    }

    public void handleException(int i, String str) {
        NotificationUtils.getInstance(this.f17532b).hideNotification();
        if (i == 1044 || i == 1035) {
            m14858a((CarCancelTrip) null, i);
            return;
        }
        ToastHelper.showShortInfo((Context) this, str);
        finish();
    }

    public void onActivityFinish() {
        ProgressDialogFragment progressDialogFragment = this.f17533c;
        if (progressDialogFragment != null && progressDialogFragment.isAdded()) {
            this.f17533c.dismissAllowingStateLoss();
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        OmegaSDK.putGlobalAttr("g_PageId", this.f17535f);
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.OnService.EVENT_CANCEL_TRIP_H5_CALLBACK, this.f17536g);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14859a(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("errno");
        String optString = jSONObject.optString("errmsg");
        if (optInt == 0) {
            int optInt2 = jSONObject.optInt("type");
            if (optInt2 == 0) {
                onBackPressed();
            } else if (optInt2 == 1) {
                postCancelTrip(2, "");
            } else if (optInt2 == 2) {
                String optString2 = jSONObject.optString("reason");
                String optString3 = jSONObject.optString("extra");
                StringBuilder sb = new StringBuilder();
                if (!TextUtil.isEmpty(optString2)) {
                    sb.append(optString2);
                    if (!TextUtil.isEmpty(optString3.trim())) {
                        sb.append("|");
                        sb.append(optString3);
                    }
                } else {
                    sb.append(optString3.trim());
                }
                postCancelTrip(2, sb.toString());
            }
        } else {
            handleException(optInt, optString);
        }
    }
}
