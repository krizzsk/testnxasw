package com.didiglobal.e_container.home;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.component.never.core.ComponentParams;
import com.didiglobal.common.business.constant.ComponentType;
import com.didiglobal.common.common.never.component.container.EeveeContainerPresenter;
import com.didiglobal.mew.framework.MUIUtils;
import java.util.LinkedHashMap;

public class HomeContainerPresenter extends EeveeContainerPresenter {
    public HomeContainerPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public LinkedHashMap<String, ViewGroup.LayoutParams> setLayoutParams(ComponentParams componentParams) {
        LinkedHashMap<String, ViewGroup.LayoutParams> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(ComponentType.COMP_MEW, m39499a());
        linkedHashMap.put(ComponentType.COMP_TOP_BAR, m39500a(componentParams.getActivity()));
        return linkedHashMap;
    }

    /* renamed from: a */
    private ViewGroup.LayoutParams m39499a() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.addRule(10);
        return layoutParams;
    }

    /* renamed from: a */
    private ViewGroup.LayoutParams m39500a(Context context) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, MUIUtils.getStatusBarHeight(context), 0, 0);
        layoutParams.addRule(10);
        return layoutParams;
    }
}
