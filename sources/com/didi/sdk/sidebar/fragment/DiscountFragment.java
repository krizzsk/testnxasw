package com.didi.sdk.sidebar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.sidebar.feature.FeatureManager;
import com.didi.sdk.sidebar.view.SettingsSwitchView;
import com.didi.sdk.util.GlobalApolloUtils;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.GlobalDialog;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiscountFragment extends AbsLoadingFragment implements View.OnClickListener, IComponent<BaseBusinessContext>, IStatusBar {

    /* renamed from: a */
    private static final String f39956a = "101_0001";

    /* renamed from: b */
    private static final String f39957b = "101_0002";

    /* renamed from: c */
    private static final String f39958c = "101_0003";

    /* renamed from: d */
    private BaseBusinessContext f39959d;

    /* renamed from: e */
    private FrameLayout f39960e = null;

    /* renamed from: f */
    private boolean f39961f = true;

    /* renamed from: g */
    private boolean f39962g = true;

    /* renamed from: h */
    private boolean f39963h = true;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public SettingsSwitchView f39964i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public SettingsSwitchView f39965j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SettingsSwitchView f39966k;

    /* renamed from: l */
    private List<String> f39967l = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f39968m = "";
    /* access modifiers changed from: private */

    /* renamed from: n */
    public SettingsSwitchView f39969n = null;

    /* renamed from: o */
    private GlobalDialog f39970o;

    /* renamed from: p */
    private GlobalDialog.IButtonAction[] f39971p = {new GlobalDialog.IButtonAction() {
        public String getName() {
            return DiscountFragment.this.getString(R.string.global_settings_discount_dialog_ok);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    FeatureManager.setFeature(DiscountFragment.this.f39968m, false, DiscountFragment.this.f39973r);
                    GlobalOmegaUtils.sendClickDiscountDialogOK();
                    DiscountFragment.this.m30121a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
        }
    }, new GlobalDialog.IButtonAction() {
        public String getName() {
            return DiscountFragment.this.getString(R.string.global_settings_discount_dialog_cancel);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    GlobalOmegaUtils.sendClickDiscountDialogCancel();
                    if (DiscountFragment.this.f39969n != null) {
                        DiscountFragment.this.f39969n.setChecked(true);
                    }
                    DiscountFragment.this.m30121a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
        }
    }};

    /* renamed from: q */
    private ResponseListener<Map<String, Boolean>> f39972q = new ResponseListener<Map<String, Boolean>>() {
        public void onSuccess(Map<String, Boolean> map) {
            DiscountFragment.this.hideLoading();
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (DiscountFragment.f39958c.equals(str)) {
                    DiscountFragment.this.f39966k.setChecked(((Boolean) next.getValue()).booleanValue());
                } else if (DiscountFragment.f39956a.equals(str)) {
                    DiscountFragment.this.f39965j.setChecked(((Boolean) next.getValue()).booleanValue());
                } else if (DiscountFragment.f39957b.equals(str)) {
                    DiscountFragment.this.f39964i.setChecked(((Boolean) next.getValue()).booleanValue());
                }
            }
        }

        public void onFail(Throwable th) {
            DiscountFragment.this.hideLoading();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: r */
    public ResponseListener<JsonObject> f39973r = new ResponseListener<JsonObject>() {
        public void onSuccess(JsonObject jsonObject) {
        }

        public void onFail(Throwable th) {
            ToastHelper.showShortCompleted(DiscountFragment.this.getContext(), (int) R.string.no_net);
        }
    };

    public boolean showStatusBar() {
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_discount_fragment, (ViewGroup) null);
        this.f39970o = new GlobalDialog();
        CommonTitleBar commonTitleBar = (CommonTitleBar) inflate.findViewById(R.id.title_bar);
        commonTitleBar.setLeftBackListener(this);
        commonTitleBar.setTitle((int) R.string.global_settings_discount_title);
        commonTitleBar.setTitleBarLineVisible(8);
        this.f39960e = (FrameLayout) inflate.findViewById(R.id.progressbar_layout);
        this.f39964i = (SettingsSwitchView) inflate.findViewById(R.id.sms_switch);
        this.f39965j = (SettingsSwitchView) inflate.findViewById(R.id.push_switch);
        this.f39966k = (SettingsSwitchView) inflate.findViewById(R.id.email_switch);
        this.f39961f = GlobalApolloUtils.getDiscountSMSSwitch();
        this.f39962g = GlobalApolloUtils.getDiscountPushSwitch();
        this.f39963h = GlobalApolloUtils.getDiscountEmailSwitch();
        this.f39967l.clear();
        if (this.f39961f) {
            this.f39964i.setVisibility(0);
            this.f39964i.setTitle(getString(R.string.global_settings_discount_switch_sms));
            this.f39964i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    GlobalOmegaUtils.sendClickDiscountSwitchSMS();
                    if (compoundButton.isChecked()) {
                        FeatureManager.setFeature(DiscountFragment.f39957b, true, DiscountFragment.this.f39973r);
                        return;
                    }
                    DiscountFragment discountFragment = DiscountFragment.this;
                    discountFragment.m30123a(DiscountFragment.f39957b, discountFragment.f39964i);
                }
            });
            this.f39967l.add(f39957b);
        }
        if (this.f39962g) {
            this.f39965j.setVisibility(0);
            this.f39965j.setTitle(getString(R.string.global_settings_discount_switch_push));
            this.f39965j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    GlobalOmegaUtils.sendClickDiscountSwitchPush();
                    if (compoundButton.isChecked()) {
                        FeatureManager.setFeature(DiscountFragment.f39956a, true, DiscountFragment.this.f39973r);
                        return;
                    }
                    DiscountFragment discountFragment = DiscountFragment.this;
                    discountFragment.m30123a(DiscountFragment.f39956a, discountFragment.f39965j);
                }
            });
            this.f39967l.add(f39956a);
        }
        if (this.f39963h) {
            this.f39966k.setVisibility(0);
            this.f39966k.setTitle(getString(R.string.global_settings_discount_switch_email));
            this.f39966k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    GlobalOmegaUtils.sendClickDiscountSwitchEmail();
                    if (compoundButton.isChecked()) {
                        FeatureManager.setFeature(DiscountFragment.f39958c, true, DiscountFragment.this.f39973r);
                        return;
                    }
                    DiscountFragment discountFragment = DiscountFragment.this;
                    discountFragment.m30123a(DiscountFragment.f39958c, discountFragment.f39966k);
                }
            });
            this.f39967l.add(f39958c);
        }
        showLoading();
        FeatureManager.getFeatureList(this.f39972q, this.f39967l);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30123a(String str, SettingsSwitchView settingsSwitchView) {
        if (this.f39970o.isPendingDismiss() || !this.f39970o.isVisible()) {
            this.f39970o.build().title(getString(R.string.global_settings_discount_dialog_title)).content(getString(R.string.global_settings_discount_dialog_content)).actions(this.f39971p).show(getFragmentManager(), DiscountFragment.class.getName());
            this.f39968m = str;
            this.f39969n = settingsSwitchView;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m30121a() {
        if (this.f39970o.isVisible()) {
            this.f39970o.dismiss();
        }
        this.f39968m = "";
        this.f39969n = null;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f39959d.getNavigation().popBackStack();
    }

    public BaseBusinessContext getBusinessContext() {
        return this.f39959d;
    }

    public void setBusinessContext(BaseBusinessContext baseBusinessContext) {
        this.f39959d = baseBusinessContext;
    }

    public View getFallbackView() {
        return this.f39960e;
    }
}
