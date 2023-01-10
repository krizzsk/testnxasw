package com.didi.sdk.sidebar.component;

import android.view.View;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.business.BffCallbackAdapter;
import com.android.didi.bfflib.business.BffResponseListener;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.bff.BffConstants;
import com.didi.sdk.sidebar.model.CurpInfo;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.TextComponentView;
import com.taxis99.R;

@ComponentType(name = "account_verify_curp")
public class CurpComponent extends AbsComponent<TextComponentView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f39907a;

    /* renamed from: b */
    private IBffProxy.Ability f39908b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f39909c;

    public CurpComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void initData(TextComponentView textComponentView) {
        textComponentView.setName(this.sidebarItem.getName());
    }

    /* access modifiers changed from: protected */
    public TextComponentView createComponentView() {
        return new TextComponentView(this.businessContext.getContext());
    }

    public void onResume() {
        super.onResume();
        IBffProxy.Ability ability = this.f39908b;
        if (ability != null) {
            Bff.cancel(ability);
        }
        IBffProxy.Ability build = new IBffProxy.Ability.Builder(this.businessContext.getContext(), BffConstants.AbilityID.ABLITY_PASSENGER_CURP).setBffCallBack(new BffCallbackAdapter(new BffResponseListener<CurpInfo>() {
            public void onSuccess(CurpInfo curpInfo) {
                if (!CurpComponent.this.f39907a) {
                    int unused = CurpComponent.this.f39909c = curpInfo.status;
                    if (curpInfo.status == 1) {
                        ((TextComponentView) CurpComponent.this.componentView).setRightIconRes(R.drawable.common_icn_arrow);
                        ((TextComponentView) CurpComponent.this.componentView).setRightDesTipVisibility(true);
                        ((TextComponentView) CurpComponent.this.componentView).setRightDes("");
                        return;
                    }
                    ((TextComponentView) CurpComponent.this.componentView).setRightIconRes(R.drawable.combined_shape);
                    ((TextComponentView) CurpComponent.this.componentView).setRightDesTipVisibility(false);
                    ((TextComponentView) CurpComponent.this.componentView).setRightDes(curpInfo.idNumber);
                }
            }
        })).build();
        this.f39908b = build;
        Bff.call(build);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.f39909c == 1) {
            if (this.sidebarItem.getUrl() != null && !this.sidebarItem.getUrl().contains("needClose")) {
                SidebarItem sidebarItem = this.sidebarItem;
                sidebarItem.setUrl(this.sidebarItem.getUrl() + "&needClose=1");
            }
            super.onClick(view);
        }
    }

    public void onDestroy() {
        this.f39907a = true;
        IBffProxy.Ability ability = this.f39908b;
        if (ability != null) {
            Bff.cancel(ability);
        }
    }
}
