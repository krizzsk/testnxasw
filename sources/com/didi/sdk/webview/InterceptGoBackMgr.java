package com.didi.sdk.webview;

import android.text.TextUtils;
import android.view.View;
import com.didi.global.globalgenerickit.GGKUICreator;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel2;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.sdk.util.UiThreadHandler;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

public class InterceptGoBackMgr {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static InterceptGoBackBridgeParams f41101a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static GGKDrawer f41102b;

    public interface GoBackCallback {
        void goBack();
    }

    public static class InterceptGoBackBridgeParams {
        public InterceptModel intercept_model;
        public int intercept_style;
        public boolean needs_intercept;
        public OmegaConfig omega_config;
    }

    public static class InterceptModel {
        public String cancel_btn_title;
        public String confirm_btn_title;
        public String subtitle;
        public String title;
    }

    public static class OmegaConfig {
        public String cancel_ck_event;
        public String confirm_ck_event;
        public Map<String, Object> params;
        public String sw_event;
    }

    public static boolean checkToIntercept(WebActivity webActivity, final GoBackCallback goBackCallback) {
        InterceptGoBackBridgeParams interceptGoBackBridgeParams = f41101a;
        if (interceptGoBackBridgeParams == null || interceptGoBackBridgeParams.intercept_model == null || !f41101a.needs_intercept) {
            cleanData();
            return false;
        }
        f41102b = GGKUICreator.showDrawerModel(webActivity, new GGKDrawerModel2(f41101a.intercept_model.title, new GGKBtnTextAndCallback(f41101a.intercept_model.cancel_btn_title, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (!(InterceptGoBackMgr.f41101a == null || InterceptGoBackMgr.f41101a.omega_config == null || TextUtils.isEmpty(InterceptGoBackMgr.f41101a.omega_config.confirm_ck_event))) {
                    OmegaSDKAdapter.trackEvent(InterceptGoBackMgr.f41101a.omega_config.confirm_ck_event, InterceptGoBackMgr.f41101a.omega_config.params);
                }
                if (InterceptGoBackMgr.f41102b != null) {
                    InterceptGoBackMgr.f41102b.dismiss();
                }
                if (InterceptGoBackMgr.f41101a != null && InterceptGoBackMgr.f41101a.intercept_style == 0 && goBackCallback != null) {
                    InterceptGoBackMgr.cleanData();
                    goBackCallback.goBack();
                }
            }
        }), new GGKBtnTextAndCallback(f41101a.intercept_model.confirm_btn_title, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (!(InterceptGoBackMgr.f41101a == null || InterceptGoBackMgr.f41101a.omega_config == null || TextUtils.isEmpty(InterceptGoBackMgr.f41101a.omega_config.cancel_ck_event))) {
                    OmegaSDKAdapter.trackEvent(InterceptGoBackMgr.f41101a.omega_config.cancel_ck_event, InterceptGoBackMgr.f41101a.omega_config.params);
                }
                if (InterceptGoBackMgr.f41102b != null) {
                    InterceptGoBackMgr.f41102b.dismiss();
                }
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (InterceptGoBackMgr.f41101a != null && InterceptGoBackMgr.f41101a.intercept_style == 1 && goBackCallback != null) {
                            InterceptGoBackMgr.cleanData();
                            goBackCallback.goBack();
                        }
                    }
                }, 400);
            }
        })).setSubTitle(f41101a.intercept_model.subtitle).setClickOutsideCanCancel(true));
        if (f41101a.omega_config != null && !TextUtils.isEmpty(f41101a.omega_config.sw_event)) {
            OmegaSDKAdapter.trackEvent(f41101a.omega_config.sw_event, f41101a.omega_config.params);
        }
        return true;
    }

    public static void setData(InterceptGoBackBridgeParams interceptGoBackBridgeParams) {
        f41101a = interceptGoBackBridgeParams;
    }

    public static void cleanData() {
        f41101a = null;
    }
}
