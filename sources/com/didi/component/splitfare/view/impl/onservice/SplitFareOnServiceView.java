package com.didi.component.splitfare.view.impl.onservice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.loading.XPanelLoadingWrapper;
import com.didi.component.common.view.PositionSensitiveView;
import com.didi.component.splitfare.presenter.impl.SplitFareOnServicePresenter;
import com.didi.component.splitfare.view.ISplitFareOnServiceView;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SplitFareOnServiceView extends XPanelLoadingWrapper implements PositionSensitiveView, ISplitFareOnServiceView {

    /* renamed from: a */
    private View f17896a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public SplitFareOnServicePresenter f17897b;

    /* renamed from: c */
    private SplitFareAdapter f17898c;

    /* renamed from: d */
    private RecyclerView f17899d;

    /* renamed from: e */
    private View f17900e;

    /* renamed from: f */
    private View f17901f;

    /* renamed from: g */
    private int f17902g = -1;

    /* renamed from: h */
    private ViewGroup f17903h;

    public SplitFareOnServiceView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.comp_sf_onservice, viewGroup, false);
        this.f17896a = inflate;
        this.f17900e = inflate.findViewById(R.id.tv_tip);
        this.f17901f = this.f17896a.findViewById(R.id.tv_stop);
        this.f17899d = (RecyclerView) this.f17896a.findViewById(R.id.sf_list);
        this.f17903h = (ViewGroup) this.f17896a.findViewById(R.id.box_triangle);
        this.f17898c = new SplitFareAdapter(CarOrderHelper.getOrder() != null && CarOrderHelper.getOrder().isSplitFareOwner());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(viewGroup.getContext());
        linearLayoutManager.setOrientation(0);
        this.f17899d.setLayoutManager(linearLayoutManager);
        this.f17899d.setAdapter(this.f17898c);
        this.f17901f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SplitFareOnServiceView.this.f17897b.onStopSplitFare();
            }
        });
    }

    public View getView() {
        return this.f17896a;
    }

    public void setPresenter(SplitFareOnServicePresenter splitFareOnServicePresenter) {
        this.f17897b = splitFareOnServicePresenter;
        this.f17898c.setPresenter(splitFareOnServicePresenter);
    }

    public void show(CarOrder carOrder) {
        if (carOrder == null || !carOrder.isSplitFareOrder()) {
            hide();
            return;
        }
        ArrayList arrayList = new ArrayList(carOrder.splitFareInfo.split_user_list);
        int i = 0;
        this.f17896a.setVisibility(0);
        if (carOrder.isSplitFareOwner()) {
            this.f17900e.setVisibility(8);
            this.f17901f.setVisibility(8);
        } else {
            this.f17900e.setVisibility(8);
            this.f17901f.setVisibility(8);
        }
        SplitFareAdapter splitFareAdapter = this.f17898c;
        int width = this.f17899d.getWidth();
        if (carOrder.carInfo != null) {
            i = carOrder.carInfo.passengerCount;
        }
        splitFareAdapter.update(arrayList, width, i);
    }

    /* renamed from: a */
    private void m15210a(List<DTSDKSplitFareInfo.SplitUser> list) {
        DTSDKSplitFareInfo.SplitUser splitUser = new DTSDKSplitFareInfo.SplitUser();
        splitUser._extType = SplitFareAdapter.EXT_TYPE_ACTION;
        splitUser.nick = ResourcesHelper.getString(this.f17896a.getContext(), R.string.g_splitfare_list_add_btn);
        splitUser.name = splitUser.nick;
        list.add(splitUser);
    }

    public void hide() {
        this.f17896a.setVisibility(8);
    }

    public void loading(boolean z) {
        if (z) {
            showMaskLayerLoading();
        } else {
            hideLoading();
        }
    }

    public void setPositionOfParentComponent(int i) {
        if (CarOrderHelper.getOrder() == null || !CarOrderHelper.getOrder().isSplitFareOwner()) {
            this.f17903h.setVisibility(8);
        } else if (this.f17902g != i) {
            this.f17902g = i;
            int childCount = this.f17903h.getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                this.f17903h.getChildAt(i2).setVisibility(i2 == 0 ? 0 : 4);
                i2++;
            }
        }
    }

    public int getPositionOfParentComponent() {
        return this.f17902g;
    }
}
