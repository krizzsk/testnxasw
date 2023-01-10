package com.didi.sdk.sidebar.component;

import android.text.TextUtils;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.view.TextComponentView;

@ComponentType(name = "menu_setting_common_link")
public class NavigationWithArrowComponent extends AbsComponent<TextComponentView> {

    /* renamed from: a */
    private TextComponentView f39924a;

    public NavigationWithArrowComponent(BaseBusinessContext baseBusinessContext, SidebarItem sidebarItem, String str) {
        super(baseBusinessContext, sidebarItem, str);
    }

    /* access modifiers changed from: protected */
    public void initData(TextComponentView textComponentView) {
        textComponentView.setName(this.sidebarItem.getName());
        if (!TextUtils.isEmpty(this.sidebarItem.getRightDes())) {
            textComponentView.setRightDes(this.sidebarItem.getRightDes());
        }
    }

    public void hideDivider() {
        this.f39924a.hideDivider();
    }

    /* access modifiers changed from: protected */
    public TextComponentView createComponentView() {
        if (this.f39924a == null) {
            this.f39924a = new TextComponentView(this.businessContext.getContext());
        }
        return this.f39924a;
    }
}
