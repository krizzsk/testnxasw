package com.didi.sdk.sidebar.component;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.util.SideBarBusinessUtil;
import com.didi.sdk.sidebar.view.GradeComponetView;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;

@ComponentType(name = "account_grade_level")
public class GradeComponent extends AbsComponent<GradeComponetView> {

    /* renamed from: a */
    private GradeComponetView f39919a;

    public GradeComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public GradeComponetView createComponentView() {
        if (this.f39919a == null) {
            this.f39919a = new GradeComponetView(this.businessContext.getContext());
        }
        return this.f39919a;
    }

    /* access modifiers changed from: protected */
    public void initData(GradeComponetView gradeComponetView) {
        if (this.sidebarItem != null) {
            gradeComponetView.setName(this.sidebarItem.getName());
            gradeComponetView.setDesc(this.sidebarItem.getDes(), this.sidebarItem.getFontColor());
            gradeComponetView.setGradeIcon(this.sidebarItem.getMemberIcon());
            gradeComponetView.setBackground(this.sidebarItem.getColor());
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (this.sidebarItem != null) {
            SideBarBusinessUtil.gotoWeb(view.getContext(), this.sidebarItem.getUrl());
            OmegaSDKAdapter.trackEvent("gp_mement2_ck");
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
