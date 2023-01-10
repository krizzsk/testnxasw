package com.didi.component.service.cancelreason.newcr;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarHttpHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.cancelreason.ISubmitReason;
import com.didi.component.service.cancelreason.cache.CancelReasonStore;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.component.service.view.NewCancelInterceptPopup;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.misconfig.p154v2.ConfProxy;
import com.didi.sdk.monitor.PubSIDManager;
import com.didi.soda.customer.app.constant.Const;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.didi.travel.psnger.model.response.CarCancelTrip;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class NewCancelReasonActivity extends AbsLoadingActivity {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17646a = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED.equals(str)) {
                NewCancelReasonActivity.this.m14940c();
            } else if (BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST.equals(str)) {
                NewCancelReasonActivity.this.m14942d();
            }
        }
    };

    /* renamed from: b */
    private ImageView f17647b;

    /* renamed from: c */
    private RecyclerView f17648c;

    /* renamed from: d */
    private FrameLayout f17649d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ComponentParams f17650e;

    /* renamed from: f */
    private ISubmitReason f17651f = new ISubmitReason() {
        public void submit(CRListModel cRListModel) {
            final String str;
            if (CarOrderHelper.getOrder() != null && !NewCancelReasonActivity.this.isFinishing()) {
                CarOrder order = CarOrderHelper.getOrder();
                NewCancelReasonActivity.this.showLoading();
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("reason_id", cRListModel.f17645id);
                    str = jSONObject.toString();
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = "{\"reason_id\":\"101\"}";
                }
                hashMap.put(ParamKeys.PARAM_CANCEL_REASON, str);
                CarRequest.cancelTrip(NewCancelReasonActivity.this, order.oid, 1, 1, "", hashMap, new ResponseListener<CarCancelTrip>() {
                    public void onSuccess(CarCancelTrip carCancelTrip) {
                        super.onSuccess(carCancelTrip);
                        NewCancelReasonActivity.this.hideLoading();
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(NewCancelInterceptPopup.KEY_CANCEL_TRIP, carCancelTrip);
                        NewCancelInterceptPopup.show(NewCancelReasonActivity.this.getSupportFragmentManager(), NewCancelInterceptPopup.CancelInterceptScene.on_service, NewCancelReasonActivity.this.f17650e, bundle, str, new NewCancelInterceptPopup.IStateListener() {
                            public void onCancel() {
                                NewCancelReasonActivity.this.finish();
                            }

                            public void onBack() {
                                NewCancelReasonActivity.this.finish();
                            }
                        });
                        NewCancelReasonActivity.this.m14938b();
                    }

                    public void onError(CarCancelTrip carCancelTrip) {
                        super.onError(carCancelTrip);
                        NewCancelReasonActivity.this.hideLoading();
                    }

                    public void onFail(CarCancelTrip carCancelTrip) {
                        super.onFail(carCancelTrip);
                        NewCancelReasonActivity.this.hideLoading();
                        CarHttpHelper.validate(NewCancelReasonActivity.this, carCancelTrip);
                        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.CancelOrder.EVENT_PRE_CANCEL_FAIL, carCancelTrip);
                    }
                });
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_new_cancel_reason);
        initViews();
        m14937a();
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f17646a);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST, this.f17646a);
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(View.STATUS_BAR_TRANSIENT);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(Color.parseColor(ColorUtils.DIDI_GREY));
        }
        OmegaSDKAdapter.trackEvent("gp_cancelreason_sw");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.EVENT_ORDER_STATUS_RECEIVED, this.f17646a);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Service.CancelOrder.EVENT_HIDE_CANCEL_REASON_LIST, this.f17646a);
    }

    public void initViews() {
        this.f17647b = (ImageView) findViewById(R.id.cr_left_btn);
        this.f17648c = (RecyclerView) findViewById(R.id.rv_cancel_reason);
        this.f17649d = (FrameLayout) findViewById(R.id.fallback_view_layout);
        this.f17648c.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f17647b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                hashMap.put(Const.CampaignKey.KEY_CLICK_TIME, Long.valueOf(System.currentTimeMillis()));
                hashMap.put("u_id", Long.valueOf(NationComponentDataUtil.getUid()));
                if (CarOrderHelper.getOrder() != null) {
                    hashMap.put("o_id", CarOrderHelper.getOrder().oid);
                }
                OmegaSDKAdapter.trackEvent("gp_cancelreason_close_ck", (Map<String, Object>) hashMap);
                NewCancelReasonActivity.this.finish();
            }
        });
    }

    /* renamed from: a */
    private void m14937a() {
        ComponentParams componentParams = new ComponentParams();
        this.f17650e = componentParams;
        componentParams.bid = ConfProxy.getInstance().getSelectedGroupId();
        this.f17650e.bizCtx = (BusinessContext) BusinessContextManager.getInstance().getCurBusinessContext();
        CancelReasonInfo currCancelReasonInfo = CancelReasonStore.getInstance().getCurrCancelReasonInfo();
        if (currCancelReasonInfo != null) {
            NewCancelReasonAdapter newCancelReasonAdapter = new NewCancelReasonAdapter(currCancelReasonInfo);
            newCancelReasonAdapter.setSubmitReason(this.f17651f);
            this.f17648c.setAdapter(newCancelReasonAdapter);
            return;
        }
        GLog.m11356e("get cancel reason info fail");
        finish();
    }

    public View getFallbackView() {
        return this.f17649d;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14938b() {
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.FILE_OOM_KEY, 2);
        PubSIDManager.getInstance().setPubSID(hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m14940c() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            if (6 == order.status || 2 == order.status || CarOrderHelper.isOnService()) {
                m14942d();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m14942d() {
        if (!isFinishing()) {
            finish();
        }
    }
}
