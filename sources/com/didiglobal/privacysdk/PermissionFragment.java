package com.didiglobal.privacysdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;
import com.didiglobal.privacysdk.util.PermissionUtils;
import com.didiglobal.privacysdk.view.GlobalPrivacyTitleBar;
import com.didiglobal.privacysdk.view.TextComponentView;
import com.taxis99.R;

public class PermissionFragment extends AbsLoadingFragment implements View.OnClickListener {

    /* renamed from: a */
    private static final int f53123a = 1713710637;

    /* renamed from: b */
    private static final int f53124b = -45992;

    /* renamed from: c */
    private boolean f53125c = false;

    /* renamed from: d */
    private boolean f53126d = false;

    /* renamed from: e */
    private boolean f53127e = false;

    /* renamed from: f */
    private boolean f53128f = false;

    /* renamed from: g */
    private boolean f53129g = false;

    /* renamed from: h */
    private TextComponentView f53130h;

    /* renamed from: i */
    private TextComponentView f53131i;

    /* renamed from: j */
    private TextComponentView f53132j;

    /* renamed from: k */
    private TextComponentView f53133k;

    /* renamed from: l */
    private TextComponentView f53134l;

    /* renamed from: m */
    private GlobalPrivacyTitleBar f53135m;

    /* renamed from: n */
    private GlobalPrivacyListeners.IAppInfo f53136n;

    /* renamed from: o */
    private GlobalPrivacyListeners.IPrivacyStrings f53137o;

    public View getFallbackView() {
        return null;
    }

    public PermissionFragment() {
        GlobalPrivacyListeners.IAppInfo appInfo = GlobalPrivacySDK.getAppInfo();
        this.f53136n = appInfo;
        this.f53137o = appInfo.getIPrivacyStrings();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_privacy_fragment_permission, (ViewGroup) null);
        GlobalPrivacyTitleBar globalPrivacyTitleBar = (GlobalPrivacyTitleBar) inflate.findViewById(R.id.title_bar);
        this.f53135m = globalPrivacyTitleBar;
        globalPrivacyTitleBar.setOnLeftImgClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PermissionFragment.this.getActivity().onBackPressed();
            }
        });
        GlobalPrivacyThemeOptions globalPrivacyThemeOptions = GlobalPrivacySDK.getGlobalPrivacyThemeOptions();
        if (globalPrivacyThemeOptions != null) {
            this.f53135m.setBackgroundColor(globalPrivacyThemeOptions.getTitleBarBgColor());
            this.f53135m.setTitleColor(globalPrivacyThemeOptions.getTitleBarTitleColor());
            if (globalPrivacyThemeOptions.isUseTitleBarSmallLeftImg()) {
                this.f53135m.setLeftSmallImgRes(globalPrivacyThemeOptions.getTitleBarSmallLeftImgRes());
            } else {
                this.f53135m.setLeftImgRes(globalPrivacyThemeOptions.getTitleBarLeftImgRes());
            }
            if (globalPrivacyThemeOptions.isTitleInCenter()) {
                this.f53135m.setMidTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Permissions_systems_KEWu);
            } else {
                this.f53135m.setLeftTitle(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Permissions_systems_KEWu);
            }
        }
        TextComponentView textComponentView = (TextComponentView) inflate.findViewById(R.id.item_permission_location);
        this.f53130h = textComponentView;
        textComponentView.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Location_uqBG));
        this.f53130h.setOnItemClickListener(this);
        TextComponentView textComponentView2 = (TextComponentView) inflate.findViewById(R.id.item_permission_camera);
        this.f53131i = textComponentView2;
        textComponentView2.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__camera_Vhsj));
        this.f53131i.setOnItemClickListener(this);
        TextComponentView textComponentView3 = (TextComponentView) inflate.findViewById(R.id.item_permission_album);
        this.f53132j = textComponentView3;
        textComponentView3.setName(getString(R.string.GDriver_scene_storage_mobile_ZEvo));
        this.f53132j.setOnItemClickListener(this);
        TextComponentView textComponentView4 = (TextComponentView) inflate.findViewById(R.id.item_permission_contacts);
        this.f53133k = textComponentView4;
        textComponentView4.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Contacts_extf));
        this.f53133k.setOnItemClickListener(this);
        TextComponentView textComponentView5 = (TextComponentView) inflate.findViewById(R.id.item_permission_microphone);
        this.f53134l = textComponentView5;
        textComponentView5.setName(getString(R.string.Global_Driver_Privacy_ComplianceFunctionCenter__microphone_yeZK));
        this.f53134l.setOnItemClickListener(this);
        return inflate;
    }

    public void onResume() {
        super.onResume();
        m39760a();
    }

    /* renamed from: a */
    private void m39760a() {
        m39761b();
        m39762c();
        m39763d();
    }

    /* renamed from: b */
    private void m39761b() {
        this.f53125c = PermissionUtils.hasLocationPermission(getContext());
        this.f53126d = PermissionUtils.hasCameraPermission(getContext());
        this.f53127e = PermissionUtils.hasAlbumPermission(getContext());
        this.f53128f = PermissionUtils.hasContractsPermission(getContext());
        this.f53129g = PermissionUtils.hasMicrophonePermission(getContext());
        GlobalOmegaUtils.sendPositionAuthorityStatusSw(this.f53125c);
        GlobalOmegaUtils.sendCameraAuthorityStatusSw(this.f53126d);
        GlobalOmegaUtils.sendAlbumAuthorityStatusSw(this.f53127e);
        GlobalOmegaUtils.sendAddressBookAuthorityStatusSw(this.f53128f);
        GlobalOmegaUtils.sendMicrophoneAuthorityStatusSw(this.f53129g);
    }

    /* renamed from: c */
    private void m39762c() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TextComponentView textComponentView = this.f53130h;
        if (this.f53125c) {
            i = this.f53137o.getLocationPermissionEnableDescRes();
        } else {
            i = this.f53137o.getLocationPermissionDisableDescRes();
        }
        textComponentView.setDescText(i);
        TextComponentView textComponentView2 = this.f53131i;
        if (this.f53126d) {
            i2 = this.f53137o.getCameraPermissionEnableDescRes();
        } else {
            i2 = this.f53137o.getCameraPermissionDisableDescRes();
        }
        textComponentView2.setDescText(i2);
        TextComponentView textComponentView3 = this.f53132j;
        if (this.f53127e) {
            i3 = this.f53137o.getAlbumPermissionEnableDescRes();
        } else {
            i3 = this.f53137o.getAlbumPermissionDisableDescRes();
        }
        textComponentView3.setDescText(i3);
        TextComponentView textComponentView4 = this.f53133k;
        if (this.f53128f) {
            i4 = this.f53137o.getContactsPermissionEnableDescRes();
        } else {
            i4 = this.f53137o.getContactsPermissionDisableDescRes();
        }
        textComponentView4.setDescText(i4);
        TextComponentView textComponentView5 = this.f53134l;
        if (this.f53129g) {
            i5 = this.f53137o.getMicrophonePermissionEnableDescRes();
        } else {
            i5 = this.f53137o.getMicrophonePermissionDisableDescRes();
        }
        textComponentView5.setDescText(i5);
    }

    /* renamed from: d */
    private void m39763d() {
        TextComponentView textComponentView = this.f53130h;
        boolean z = this.f53125c;
        int i = f53123a;
        textComponentView.setDescTextColor(z ? f53123a : f53124b);
        this.f53130h.setRightDesColor(this.f53125c ? f53123a : f53124b);
        TextComponentView textComponentView2 = this.f53130h;
        boolean z2 = this.f53125c;
        int i2 = R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU;
        textComponentView2.setRightDes(z2 ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f53131i.setDescTextColor(this.f53126d ? f53123a : f53124b);
        this.f53131i.setRightDesColor(this.f53126d ? f53123a : f53124b);
        this.f53131i.setRightDes(this.f53126d ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f53132j.setDescTextColor(this.f53127e ? f53123a : f53124b);
        this.f53132j.setRightDesColor(this.f53127e ? f53123a : f53124b);
        this.f53132j.setRightDes(this.f53127e ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f53133k.setDescTextColor(this.f53128f ? f53123a : f53124b);
        this.f53133k.setRightDesColor(this.f53128f ? f53123a : f53124b);
        this.f53133k.setRightDes(this.f53128f ? R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_RYuU : R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf);
        this.f53134l.setDescTextColor(this.f53129g ? f53123a : f53124b);
        TextComponentView textComponentView3 = this.f53134l;
        if (!this.f53129g) {
            i = f53124b;
        }
        textComponentView3.setRightDesColor(i);
        TextComponentView textComponentView4 = this.f53134l;
        if (!this.f53129g) {
            i2 = R.string.Global_Driver_Privacy_ComplianceFunctionCenter__Authorization_IBwf;
        }
        textComponentView4.setRightDes(i2);
    }

    /* renamed from: e */
    private void m39764e() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + getContext().getPackageName()));
            intent.addCategory("android.intent.category.DEFAULT");
            startActivity(intent);
        } catch (Exception unused) {
            startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        m39764e();
    }
}
