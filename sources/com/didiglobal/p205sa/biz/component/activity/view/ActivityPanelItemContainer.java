package com.didiglobal.p205sa.biz.component.activity.view;

import android.content.Context;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didiglobal.p205sa.biz.component.sapanel.view.SaShadowCard;
import com.taxis99.R;

/* renamed from: com.didiglobal.sa.biz.component.activity.view.ActivityPanelItemContainer */
public class ActivityPanelItemContainer extends SaShadowCard {

    /* renamed from: a */
    private int f53286a;

    /* renamed from: b */
    private String f53287b;

    public ActivityPanelItemContainer(String str, int i, Context context) {
        super(context);
        this.f53287b = str;
        this.f53286a = i;
        m39871a();
    }

    /* renamed from: a */
    private void m39871a() {
        int dip2px = UiUtils.dip2px(getContext(), 14.0f);
        int i = this.f53286a;
        setPadding((int) getContext().getResources().getDimension(R.dimen.view_padding), 0, (int) getContext().getResources().getDimension(R.dimen.view_padding), dip2px);
    }
}
