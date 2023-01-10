package com.didi.sdk.sidebar.component;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.util.SideBarBusinessUtil;
import com.didi.sdk.sidebar.view.SideBarSwitchItemView;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@ComponentType(name = "menu_switch_link")
public class SidebarSwitchItemComponent extends AbsComponent<SideBarSwitchItemView> {

    /* renamed from: a */
    private static final int f39927a = 30;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SideBarSwitchItemView f39928b;

    /* renamed from: c */
    private String f39929c;

    /* renamed from: d */
    private String f39930d;

    /* renamed from: e */
    private String f39931e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AlertDialogFragment f39932f;

    public SidebarSwitchItemComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
        OneLoginFacade.getFunction().addLoginOutListener(new LoginListeners.LoginOutListener() {
            public void onSuccess() {
                SideBarBusinessUtil.setPriceFix(false);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initData(SideBarSwitchItemView sideBarSwitchItemView) {
        this.f39928b = sideBarSwitchItemView;
        sideBarSwitchItemView.setName(this.sidebarItem.getName());
        sideBarSwitchItemView.setIcon(this.sidebarItem.getIconUrl());
        sideBarSwitchItemView.setDesc(this.sidebarItem.getDes());
        if (this.sidebarItem.getDialog() != null) {
            try {
                JSONObject jSONObject = new JSONObject(String.valueOf(this.sidebarItem.getDialog()));
                this.f39929c = jSONObject.optString("content");
                this.f39930d = jSONObject.optString("leftBtn");
                String optString = jSONObject.optString("rightBtn");
                this.f39931e = optString;
                this.f39932f = m30059a(this.f39929c, this.f39930d, optString, this.sidebarItem.getUrl());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.sidebarItem.getId() == 30) {
            sideBarSwitchItemView.setSwitchBtn(SideBarBusinessUtil.isPriceFix());
        } else {
            sideBarSwitchItemView.setSwitchBtn(this.sidebarItem.isToggle());
        }
    }

    public void onResume() {
        super.onResume();
        OmegaSDKAdapter.trackEvent("pas_sidebar_jp_fixprice_sw");
    }

    /* access modifiers changed from: protected */
    public SideBarSwitchItemView createComponentView() {
        return new SideBarSwitchItemView(this.businessContext.getContext());
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.sidebarItem.getId() == 30) {
            if (this.f39928b.isChecked()) {
                this.f39928b.setSwitchBtn(false);
                SideBarBusinessUtil.setPriceFix(false);
            } else if (this.f39932f != null) {
                try {
                    this.f39932f.show(((FragmentActivity) this.businessContext.getContext()).getSupportFragmentManager(), (String) null);
                    OmegaSDKAdapter.trackEvent("fixedprice_rulesreminder_show");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.sidebarItem != null) {
            String traceEvent = this.sidebarItem.getTraceEvent();
            if (!TextUtils.isEmpty(traceEvent)) {
                HashMap hashMap = new HashMap();
                hashMap.put("city_id", NationTypeUtil.getNationComponentData().getCityId());
                hashMap.put("country_code", NationTypeUtil.getNationComponentData().getLocCountry());
                OmegaSDKAdapter.trackEvent(traceEvent, (Map<String, Object>) hashMap);
            }
        }
    }

    /* renamed from: a */
    private AlertDialogFragment m30059a(String str, String str2, String str3, final String str4) {
        ((FragmentActivity) this.businessContext.getContext()).getSupportFragmentManager();
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.businessContext.getContext());
        builder.setIcon((int) R.drawable.common_dialog_icon_info);
        builder.setMessage(str).setNegativeButton((CharSequence) str2, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SideBarBusinessUtil.gotoWeb(SidebarSwitchItemComponent.this.businessContext.getContext(), str4);
                OmegaSDKAdapter.trackEvent("fixedprice_rulesreminder_click");
            }
        }).setPositiveButton((CharSequence) str3, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SidebarSwitchItemComponent.this.f39928b.setSwitchBtn(true);
                SideBarBusinessUtil.setPriceFix(true);
                if (SidebarSwitchItemComponent.this.f39932f != null) {
                    SidebarSwitchItemComponent.this.f39932f.dismiss();
                }
                OmegaSDKAdapter.trackEvent("fixedprice_knowrules_click");
            }
        }).setDefaultButtonTxtColor(R.color.global_text_orage).setPositiveButtonDefault();
        return builder.create();
    }
}
