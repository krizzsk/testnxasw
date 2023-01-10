package com.didiglobal.privacysdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.one.netdetect.http.ResponseListener;
import com.didi.sdk.util.ToastHelper;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.view.GlobalDialog;
import com.didiglobal.privacysdk.view.GlobalPrivacyTitleBar;
import com.didiglobal.privacysdk.view.SettingsSwitchView;
import com.didiglobal.privacysdk.view.TextComponentView;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrivacyFragment extends AbsLoadingFragment {

    /* renamed from: a */
    private static final String f53138a = "101_0001";

    /* renamed from: b */
    private static final String f53139b = "101_0002";

    /* renamed from: c */
    private static final String f53140c = "101_0003";

    /* renamed from: d */
    private static final String f53141d = "101_0011";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f53142A = false;

    /* renamed from: B */
    private GlobalPrivacyTitleBar f53143B;

    /* renamed from: C */
    private GlobalDialog.IButtonAction[] f53144C = {new GlobalDialog.IButtonAction() {
        public String getName() {
            return PrivacyFragment.this.getString(R.string.Global_Driver_LGPD_Translation_Requirements_Confirmation_ZhBT);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    PrivacyFragment.this.m39771a(PrivacyFragment.this.f53164w, false, (ResponseListener<JsonObject>) new SetSwitchResponseListener(PrivacyFragment.this.f53165x));
                    if (PrivacyFragment.this.f53164w == PrivacyFragment.f53141d) {
                        GlobalOmegaUtils.sendSharedPositionConfirmCloseCk();
                    } else {
                        GlobalOmegaUtils.sendDiscountSwitchConfirmCloseCk(PrivacyFragment.this.f53164w);
                    }
                    PrivacyFragment.this.m39767a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
        }
    }, new GlobalDialog.IButtonAction() {
        public String getName() {
            return PrivacyFragment.this.getString(R.string.Global_Driver_LGPD_Translation_Requirements_Cancelled_DtEy);
        }

        public Runnable getAction() {
            return new Runnable() {
                public void run() {
                    if (PrivacyFragment.this.f53165x != null) {
                        PrivacyFragment.this.f53165x.setChecked(true);
                    }
                    PrivacyFragment.this.m39767a();
                }
            };
        }

        public GlobalDialog.IButtonAction.ButtonType getType() {
            return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
        }
    }};

    /* renamed from: D */
    private ResponseListener<Map<String, Boolean>> f53145D = new ResponseListener<Map<String, Boolean>>() {
        public void onSuccess(Map<String, Boolean> map) {
            PrivacyFragment.this.hideLoading();
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                boolean booleanValue = ((Boolean) next.getValue()).booleanValue();
                if (PrivacyFragment.f53140c.equals(str)) {
                    PrivacyFragment.this.f53159r.setChecked(booleanValue);
                    GlobalOmegaUtils.sendDiscountSwitchStatusSw(PrivacyFragment.f53140c, booleanValue);
                } else if (PrivacyFragment.f53138a.equals(str)) {
                    PrivacyFragment.this.f53158q.setChecked(booleanValue);
                    GlobalOmegaUtils.sendDiscountSwitchStatusSw(PrivacyFragment.f53138a, booleanValue);
                } else if (PrivacyFragment.f53139b.equals(str)) {
                    PrivacyFragment.this.f53157p.setChecked(booleanValue);
                    GlobalOmegaUtils.sendDiscountSwitchStatusSw(PrivacyFragment.f53139b, booleanValue);
                } else if (PrivacyFragment.f53141d.equals(str)) {
                    PrivacyFragment.this.f53160s.setChecked(booleanValue);
                    GlobalOmegaUtils.sendSharedPositionSwitchStatusSw(booleanValue);
                }
            }
        }

        public void onFail(Throwable th) {
            PrivacyFragment.this.hideLoading();
        }
    };

    /* renamed from: e */
    private FrameLayout f53146e = null;

    /* renamed from: f */
    private boolean f53147f = false;

    /* renamed from: g */
    private boolean f53148g = false;

    /* renamed from: h */
    private boolean f53149h = false;

    /* renamed from: i */
    private boolean f53150i = false;

    /* renamed from: j */
    private boolean f53151j = false;

    /* renamed from: k */
    private boolean f53152k = false;

    /* renamed from: l */
    private boolean f53153l = false;

    /* renamed from: m */
    private TextComponentView f53154m;

    /* renamed from: n */
    private ViewGroup f53155n;

    /* renamed from: o */
    private SettingsSwitchView f53156o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public SettingsSwitchView f53157p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public SettingsSwitchView f53158q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public SettingsSwitchView f53159r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SettingsSwitchView f53160s;

    /* renamed from: t */
    private TextComponentView f53161t;

    /* renamed from: u */
    private TextComponentView f53162u;

    /* renamed from: v */
    private List<String> f53163v = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public String f53164w = "";
    /* access modifiers changed from: private */

    /* renamed from: x */
    public SettingsSwitchView f53165x = null;

    /* renamed from: y */
    private int f53166y;

    /* renamed from: z */
    private GlobalDialog f53167z;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_privacy_fragment_privacy, (ViewGroup) null);
        this.f53142A = false;
        this.f53167z = new GlobalDialog();
        this.f53146e = (FrameLayout) inflate.findViewById(R.id.progressbar_layout);
        GlobalPrivacyTitleBar globalPrivacyTitleBar = (GlobalPrivacyTitleBar) inflate.findViewById(R.id.title_bar);
        this.f53143B = globalPrivacyTitleBar;
        globalPrivacyTitleBar.setOnLeftImgClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PrivacyFragment.this.getActivity().onBackPressed();
            }
        });
        GlobalPrivacyThemeOptions globalPrivacyThemeOptions = GlobalPrivacySDK.getGlobalPrivacyThemeOptions();
        if (globalPrivacyThemeOptions != null) {
            this.f53143B.setBackgroundColor(globalPrivacyThemeOptions.getTitleBarBgColor());
            this.f53143B.setTitleColor(globalPrivacyThemeOptions.getTitleBarTitleColor());
            if (globalPrivacyThemeOptions.isUseTitleBarSmallLeftImg()) {
                this.f53143B.setLeftSmallImgRes(globalPrivacyThemeOptions.getTitleBarSmallLeftImgRes());
            } else {
                this.f53143B.setLeftImgRes(globalPrivacyThemeOptions.getTitleBarLeftImgRes());
            }
            if (globalPrivacyThemeOptions.isTitleInCenter()) {
                this.f53143B.setMidTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Privacy_ToTQ);
            } else {
                this.f53143B.setLeftTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Privacy_ToTQ);
            }
            this.f53166y = globalPrivacyThemeOptions.getSwitchColor();
        }
        GlobalPrivacyListeners.ItemDisplayListener itemDisplayListener = GlobalPrivacySDK.getItemDisplayListener();
        this.f53147f = itemDisplayListener.displaySms();
        this.f53148g = itemDisplayListener.displayDiscountPush();
        this.f53149h = itemDisplayListener.displayDiscountEmail();
        this.f53150i = itemDisplayListener.displayLocationShare();
        this.f53151j = itemDisplayListener.displayDownloadData();
        this.f53152k = itemDisplayListener.displaySystemPermission();
        this.f53153l = itemDisplayListener.displayDeleteAccount();
        TextComponentView textComponentView = (TextComponentView) inflate.findViewById(R.id.item_download_data);
        this.f53154m = textComponentView;
        if (this.f53151j) {
            textComponentView.setVisibility(0);
            this.f53154m.setName((int) R.string.Global_Driver_LGPD_Translation_Requirements_Download_personal_EEJQ);
            this.f53154m.setOnItemClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalPrivacyListeners.WebViewListener webViewListener = GlobalPrivacySDK.getWebViewListener();
                    if (webViewListener != null) {
                        String downloadDataUrl = GlobalPrivacySDK.getDownloadDataUrl();
                        if (TextUtils.isEmpty(downloadDataUrl)) {
                            downloadDataUrl = "https://page.didiglobal.com/passenger-page/download/index.html";
                        }
                        webViewListener.jumpWebViewPage(PrivacyFragment.this.getContext(), downloadDataUrl);
                        GlobalOmegaUtils.sendDataDownloadEntranceCK();
                    }
                }
            });
        } else {
            textComponentView.setVisibility(8);
        }
        TextComponentView textComponentView2 = (TextComponentView) inflate.findViewById(R.id.item_system_permission);
        this.f53161t = textComponentView2;
        if (this.f53152k) {
            textComponentView2.setVisibility(0);
            this.f53161t.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Permissions_systems_KEWu));
            this.f53161t.setDescText((CharSequence) getString(R.string.GDriver_update_Permissions_scenes_DiXo));
            this.f53161t.setOnItemClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    FragmentActivity activity = PrivacyFragment.this.getActivity();
                    if (activity != null && (activity instanceof PrivacyActivity)) {
                        ((PrivacyActivity) activity).jumpPermissionFragment();
                        GlobalOmegaUtils.sendSystemPermissionEntranceCK();
                    }
                }
            });
        } else {
            textComponentView2.setVisibility(8);
        }
        TextComponentView textComponentView3 = (TextComponentView) inflate.findViewById(R.id.item_delete_account);
        this.f53162u = textComponentView3;
        if (this.f53153l) {
            textComponentView3.setVisibility(0);
            this.f53162u.setName(getString(R.string.commonapi_sidebar_menu_25));
            this.f53162u.setOnItemClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (GlobalPrivacySDK.getOnItemClickedListener() != null) {
                        GlobalPrivacySDK.getOnItemClickedListener().onDeleteAccountItemClicked(PrivacyFragment.this.getActivity());
                    }
                }
            });
        } else {
            textComponentView3.setVisibility(8);
        }
        this.f53155n = (ViewGroup) inflate.findViewById(R.id.discount_items_container);
        this.f53156o = (SettingsSwitchView) inflate.findViewById(R.id.item_discount);
        this.f53157p = (SettingsSwitchView) inflate.findViewById(R.id.sms_switch);
        this.f53158q = (SettingsSwitchView) inflate.findViewById(R.id.push_switch);
        this.f53159r = (SettingsSwitchView) inflate.findViewById(R.id.email_switch);
        SettingsSwitchView settingsSwitchView = (SettingsSwitchView) inflate.findViewById(R.id.location_share_switch);
        this.f53160s = settingsSwitchView;
        settingsSwitchView.setDescText(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Location_sharing_boFB));
        if (this.f53147f || this.f53148g || this.f53149h) {
            this.f53155n.setVisibility(0);
        } else {
            this.f53155n.setVisibility(8);
        }
        this.f53163v.clear();
        this.f53156o.setTitle(getString(GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountTitleRes()));
        int discountDescRes = GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountDescRes();
        this.f53156o.setSwitchVisibility(8);
        this.f53156o.setDividerVisibility(4);
        if (discountDescRes != 0) {
            this.f53156o.setDescText(getString(discountDescRes));
        }
        if (this.f53147f) {
            this.f53157p.setVisibility(0);
            this.f53157p.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_SMS_nElm));
            this.f53157p.setSwitchColor(this.f53166y);
            this.f53157p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f53142A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m39771a(PrivacyFragment.f53139b, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f53157p));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m39770a(PrivacyFragment.f53139b, privacyFragment2.f53157p);
                    }
                }
            });
            this.f53163v.add(f53139b);
        } else {
            this.f53157p.setVisibility(8);
        }
        if (this.f53148g) {
            this.f53158q.setVisibility(0);
            this.f53158q.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Notification_cWbM));
            this.f53158q.setSwitchColor(this.f53166y);
            this.f53158q.setDividerVisibility(4);
            this.f53158q.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f53142A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m39771a(PrivacyFragment.f53138a, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f53158q));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m39770a(PrivacyFragment.f53138a, privacyFragment2.f53158q);
                    }
                }
            });
            this.f53163v.add(f53138a);
        } else {
            this.f53158q.setVisibility(8);
        }
        if (this.f53149h) {
            this.f53159r.setVisibility(0);
            this.f53159r.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Mail_QXpk));
            this.f53159r.setSwitchColor(this.f53166y);
            this.f53159r.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f53142A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m39771a(PrivacyFragment.f53140c, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f53159r));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m39770a(PrivacyFragment.f53140c, privacyFragment2.f53159r);
                    }
                }
            });
            this.f53163v.add(f53140c);
        } else {
            this.f53159r.setVisibility(8);
        }
        if (this.f53150i) {
            this.f53160s.setTitle(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Share_location_hkgv));
            this.f53160s.setDividerVisibility(4);
            this.f53160s.setSwitchColor(this.f53166y);
            this.f53160s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    if (PrivacyFragment.this.f53142A) {
                        if (compoundButton.isChecked()) {
                            PrivacyFragment privacyFragment = PrivacyFragment.this;
                            privacyFragment.m39771a(PrivacyFragment.f53141d, true, (ResponseListener<JsonObject>) new SetSwitchResponseListener(privacyFragment.f53160s));
                            return;
                        }
                        PrivacyFragment privacyFragment2 = PrivacyFragment.this;
                        privacyFragment2.m39770a(PrivacyFragment.f53141d, privacyFragment2.f53160s);
                    }
                }
            });
            this.f53163v.add(f53141d);
        } else {
            this.f53160s.setVisibility(8);
        }
        List<String> list = this.f53163v;
        if (list != null && list.size() > 0) {
            showLoading();
            FeatureManager.getFeatureList(getContext(), this.f53145D, this.f53163v);
        }
        return inflate;
    }

    public void onStart() {
        super.onStart();
        this.f53142A = true;
    }

    public View getFallbackView() {
        return this.f53146e;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39770a(String str, SettingsSwitchView settingsSwitchView) {
        Class<PrivacyFragment> cls = PrivacyFragment.class;
        if (this.f53167z.isPendingDismiss() || !this.f53167z.isVisible()) {
            if (str == f53141d) {
                this.f53167z.build().title(getString(R.string.Global_Driver_LGPD_Translation_Requirements_Close_location_iyDl)).content(getString(R.string.GDriver_update_Close_real_QoXo)).actions(this.f53144C).show(getFragmentManager(), cls.getName());
            } else {
                this.f53167z.build().title(getString(GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountDialogTitleRes())).content(getString(GlobalPrivacySDK.getAppInfo().getIPrivacyStrings().getDiscountDialogDescRes())).actions(this.f53144C).show(getFragmentManager(), cls.getName());
            }
            this.f53164w = str;
            this.f53165x = settingsSwitchView;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39767a() {
        if (this.f53167z.isVisible()) {
            this.f53167z.dismiss();
        }
        this.f53164w = "";
        this.f53165x = null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39771a(String str, boolean z, ResponseListener<JsonObject> responseListener) {
        showLoading();
        FeatureManager.setFeature(getContext(), str, z, responseListener);
    }

    private class SetSwitchResponseListener implements ResponseListener<JsonObject> {
        SettingsSwitchView switchView;

        SetSwitchResponseListener(SettingsSwitchView settingsSwitchView) {
            this.switchView = settingsSwitchView;
        }

        public void onSuccess(JsonObject jsonObject) {
            PrivacyFragment.this.hideLoading();
        }

        public void onFail(Throwable th) {
            PrivacyFragment.this.hideLoading();
            SettingsSwitchView settingsSwitchView = this.switchView;
            if (settingsSwitchView != null) {
                settingsSwitchView.setChecked(!settingsSwitchView.isChecked());
            }
            Context context = PrivacyFragment.this.getContext();
            if (context != null) {
                ToastHelper.showShortCompleted(context, (int) R.string.no_net);
            }
        }
    }
}
