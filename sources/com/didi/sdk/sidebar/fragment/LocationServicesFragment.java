package com.didi.sdk.sidebar.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.feature.FeatureManager;
import com.didi.sdk.sidebar.view.SettingsSwitchView;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.GlobalDialog;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class LocationServicesFragment extends AbsLoadingFragment implements View.OnClickListener, IComponent<BaseBusinessContext>, IStatusBar {

    /* renamed from: a */
    private static final String f39987a = "101_0011";

    /* renamed from: b */
    private BaseBusinessContext f39988b;

    /* renamed from: c */
    private RelativeLayout f39989c;

    /* renamed from: d */
    private LinearLayout f39990d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SettingsSwitchView f39991e;

    /* renamed from: f */
    private FrameLayout f39992f = null;

    /* renamed from: g */
    private GlobalDialog f39993g;

    /* renamed from: h */
    private GlobalDialog.IButtonAction[] f39994h = {new GlobalDialog.IButtonAction() {
        public String getName() {
            return LocationServicesFragment.this.getString(R.string.global_settings_discount_dialog_ok);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    FeatureManager.setFeature(LocationServicesFragment.f39987a, false, LocationServicesFragment.this.f39996j);
                    GlobalOmegaUtils.sendClickLocationDialogOK();
                    LocationServicesFragment.this.m30138b();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
        }
    }, new GlobalDialog.IButtonAction() {
        public String getName() {
            return LocationServicesFragment.this.getString(R.string.global_settings_discount_dialog_cancel);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    GlobalOmegaUtils.sendClickLocationDialogCancel();
                    if (LocationServicesFragment.this.f39991e != null) {
                        LocationServicesFragment.this.f39991e.setChecked(true);
                    }
                    LocationServicesFragment.this.m30138b();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
        }
    }};

    /* renamed from: i */
    private ResponseListener<Map<String, Boolean>> f39995i = new ResponseListener<Map<String, Boolean>>() {
        public void onSuccess(Map<String, Boolean> map) {
            LocationServicesFragment.this.hideLoading();
            for (Map.Entry next : map.entrySet()) {
                if (LocationServicesFragment.f39987a.equals((String) next.getKey())) {
                    LocationServicesFragment.this.f39991e.setChecked(((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onFail(Throwable th) {
            LocationServicesFragment.this.hideLoading();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ResponseListener<JsonObject> f39996j = new ResponseListener<JsonObject>() {
        public void onSuccess(JsonObject jsonObject) {
        }

        public void onFail(Throwable th) {
            ToastHelper.showShortCompleted(LocationServicesFragment.this.getContext(), (int) R.string.no_net);
        }
    };

    public boolean showStatusBar() {
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_location_services, (ViewGroup) null);
        CommonTitleBar commonTitleBar = (CommonTitleBar) inflate.findViewById(R.id.title_bar);
        commonTitleBar.setLeftBackListener(this);
        commonTitleBar.setTitle((int) R.string.global_settings_location_services_title);
        commonTitleBar.setTitleBarLineVisible(8);
        this.f39993g = new GlobalDialog();
        this.f39992f = (FrameLayout) inflate.findViewById(R.id.progressbar_layout);
        RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.location_permissions_item);
        this.f39989c = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HashMap hashMap = new HashMap();
                if (!(NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLoginInfo() == null)) {
                    hashMap.put("passenger_id", NationTypeUtil.getNationComponentData().getLoginInfo().getUid());
                }
                OmegaSDKAdapter.trackEvent("gd_profile_setting_location_sevice_ck", (String) null, hashMap);
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + LocationServicesFragment.this.getContext().getPackageName()));
                intent.addCategory("android.intent.category.DEFAULT");
                LocationServicesFragment.this.startActivity(intent);
            }
        });
        this.f39990d = (LinearLayout) inflate.findViewById(R.id.location_share_layout);
        this.f39991e = (SettingsSwitchView) inflate.findViewById(R.id.location_share_switch);
        if (GlobalApolloUtils.getShareLocationSwitch()) {
            this.f39990d.setVisibility(0);
            this.f39991e.setTitle(getString(R.string.global_settings_location_services_location_share));
            this.f39991e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    GlobalOmegaUtils.sendClickLocationSwitchShare();
                    if (compoundButton.isChecked()) {
                        FeatureManager.setFeature(LocationServicesFragment.f39987a, true, LocationServicesFragment.this.f39996j);
                    } else {
                        LocationServicesFragment.this.m30137a();
                    }
                }
            });
            showLoading();
            FeatureManager.getFeature(this.f39995i, f39987a);
        } else {
            this.f39990d.setVisibility(8);
        }
        return inflate;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f39988b.getNavigation().popBackStack();
    }

    public BaseBusinessContext getBusinessContext() {
        return this.f39988b;
    }

    public void setBusinessContext(BaseBusinessContext baseBusinessContext) {
        this.f39988b = baseBusinessContext;
    }

    public View getFallbackView() {
        return this.f39992f;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30137a() {
        if (this.f39993g.isPendingDismiss() || !this.f39993g.isVisible()) {
            this.f39993g.build().title(getString(R.string.global_settings_location_dialog_title)).content(getString(R.string.global_settings_location_dialog_content)).actions(this.f39994h).show(getFragmentManager(), LocationServicesFragment.class.getName());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30138b() {
        if (this.f39993g.isVisible()) {
            this.f39993g.dismiss();
        }
    }
}
