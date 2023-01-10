package com.didi.soda.customer.app;

import com.didi.sdk.app.BusinessContext;

public class TitleAndBizBarManager {

    /* renamed from: a */
    private BusinessContext f42912a;

    public void attachBusinessContext(BusinessContext businessContext) {
        this.f42912a = businessContext;
    }

    public void showTitleBarAndBizBar() {
        BusinessContext businessContext = this.f42912a;
        if (businessContext != null) {
            businessContext.restoreTitleBar();
            this.f42912a.showBizBar();
        }
    }

    public void hideTitleBarAndBizBar() {
        BusinessContext businessContext = this.f42912a;
        if (businessContext != null) {
            businessContext.hideTitleBar();
            this.f42912a.hideBizBar();
        }
    }

    public void hideTitleBar() {
        BusinessContext businessContext = this.f42912a;
        if (businessContext != null) {
            businessContext.hideTitleBar();
        }
    }

    public int getBizBarHeight() {
        BusinessContext businessContext = this.f42912a;
        if (businessContext != null) {
            return businessContext.getBizBarHeight();
        }
        return 0;
    }

    public void offsetTitleBar(float f, float f2) {
        BusinessContext businessContext = this.f42912a;
        if (businessContext != null) {
            businessContext.resetTitleBarYPosition((int) f);
            this.f42912a.resetTitleBarAlpha(f2);
        }
    }
}
