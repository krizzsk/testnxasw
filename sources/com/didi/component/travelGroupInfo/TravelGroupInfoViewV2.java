package com.didi.component.travelGroupInfo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.core.IViewContainer;
import com.taxis99.R;

public class TravelGroupInfoViewV2 implements IViewContainer, ITravelGroupInfoViewV2 {

    /* renamed from: a */
    private View f18029a;

    /* renamed from: b */
    private AbsTravelGroupInfoPresenterV2 f18030b;

    public TravelGroupInfoViewV2(Context context, ViewGroup viewGroup) {
        this.f18029a = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.layout_travel_group_info_v2, viewGroup, false);
    }

    public View getView() {
        return this.f18029a;
    }

    public void setPresenter(AbsTravelGroupInfoPresenterV2 absTravelGroupInfoPresenterV2) {
        this.f18030b = absTravelGroupInfoPresenterV2;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        AbsTravelGroupInfoPresenterV2 absTravelGroupInfoPresenterV2 = this.f18030b;
        if (absTravelGroupInfoPresenterV2 != null) {
            absTravelGroupInfoPresenterV2.setComponentCreator(iComponentCreator);
        }
    }
}
