package com.didi.component.comp_homecard.locpermission;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.common.util.LocationUtils;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.util.permission.PermissionActivity;
import com.didi.sdk.util.permission.PermissionCallback;
import com.didichuxing.bigdata.p174dp.locsdk.setting.LocationSettingRequestCallback;
import com.didichuxing.bigdata.p174dp.locsdk.setting.LocationSettingRequestManager;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.Map;

public class LocPermission {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f14094a;

    public LocPermission(Context context) {
        this.f14094a = context;
    }

    public void onMainBtnClick() {
        if (this.f14094a instanceof FragmentActivity) {
            PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog((FragmentActivity) this.f14094a, PrivacyTypeEnum.LOCATION, new PrivacyDisclosureBaseDialog.Callback() {
                public void onNegativeResult() {
                }

                public void onPositiveResult(PositiveResultReason positiveResultReason) {
                    LocPermission.this.m11687b();
                }
            });
        } else {
            m11687b();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11685a() {
        XEngineReq.simpleRequest(XERequestKey.SCENE_HOME, XERequestKey.REQUEST_KEY_PASSENGER_HOME_CARD);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11687b() {
        if (!LocationUtils.isLocationPermissionGranted(this.f14094a) && Build.VERSION.SDK_INT >= 23 && ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.f14094a, Permission.ACCESS_FINE_LOCATION)) {
            PermissionActivity.request(this.f14094a, new String[]{Permission.ACCESS_FINE_LOCATION}, new PermissionCallback() {
                public void onPermissionGranted() {
                    LocPermission.this.m11685a();
                    LocPermission.this.showOpenPositionDialog();
                    HashMap hashMap = new HashMap();
                    hashMap.put("action", 1);
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("map_loc_permission_ck", (Map<String, Object>) hashMap);
                }

                public void onPermissionReject(String str) {
                    HashMap hashMap = new HashMap();
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) LocPermission.this.f14094a, Permission.ACCESS_FINE_LOCATION)) {
                        hashMap.put("action", 0);
                    } else {
                        hashMap.put("action", -1);
                    }
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("map_loc_permission_ck", (Map<String, Object>) hashMap);
                }
            });
        } else if (!LocationUtils.isLocationPermissionGranted(this.f14094a) && Build.VERSION.SDK_INT >= 23 && !ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.f14094a, Permission.ACCESS_FINE_LOCATION)) {
            DRouter.build("taxis99onetravel://one/syssettings?permission=android.permission.ACCESS_FINE_LOCATION&type=2").start(this.f14094a);
        } else if (LocationUtils.isLocationPermissionGranted(this.f14094a)) {
            showOpenPositionDialog();
        }
    }

    public void showOpenPositionDialog() {
        if (LocationUtils.isLocationPermissionGranted(this.f14094a)) {
            LocationSettingRequestManager.getInstance().checkSettingRequest((Activity) this.f14094a, new LocationSettingRequestCallback() {
                public void onFailed() {
                }

                public /* synthetic */ void onFailed(boolean z) {
                    LocationSettingRequestCallback.CC.$default$onFailed(this, z);
                }

                public void onSuccess() {
                }
            });
        }
    }
}
