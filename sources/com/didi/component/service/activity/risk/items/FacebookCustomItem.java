package com.didi.component.service.activity.risk.items;

import android.app.Activity;
import com.didi.component.service.activity.risk.RiskListAdapter;
import com.didi.component.service.activity.risk.model.RiskVerifyListItem;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

public class FacebookCustomItem extends FacebookItem implements FacebookCallback<LoginResult> {

    /* renamed from: a */
    private RiskVerifyListItem f17605a;

    /* access modifiers changed from: protected */
    public boolean isCustomItem() {
        return true;
    }

    public FacebookCustomItem(String str, RiskListAdapter riskListAdapter, Activity activity, RiskVerifyListItem riskVerifyListItem) {
        super(str, riskListAdapter, activity);
        this.f17605a = riskVerifyListItem;
    }

    /* access modifiers changed from: protected */
    public String getItemTitleStr() {
        return this.f17605a.content;
    }

    /* access modifiers changed from: protected */
    public String getItemIconUrl() {
        return this.f17605a.head;
    }
}
