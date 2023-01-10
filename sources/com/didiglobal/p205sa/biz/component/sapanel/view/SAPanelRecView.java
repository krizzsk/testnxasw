package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.map.setting.common.utils.DisplayUtil;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.sdk.app.business.SaTabIds;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ISAPanel;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.didiglobal.p205sa.biz.component.sapanel.omega.PanelOmegaTracker;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SAPanelRecView */
public class SAPanelRecView implements ISAPanel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f53681a;

    /* renamed from: b */
    private View f53682b;

    /* renamed from: c */
    private LayoutInflater f53683c;

    /* renamed from: d */
    private SAPanelAdapter f53684d;

    /* renamed from: e */
    private RecyclerView f53685e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PanelOmegaTracker f53686f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f53687g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f53688h = 0;

    /* renamed from: b */
    static /* synthetic */ int m40068b(SAPanelRecView sAPanelRecView, int i) {
        int i2 = sAPanelRecView.f53687g + i;
        sAPanelRecView.f53687g = i2;
        return i2;
    }

    public SAPanelRecView(Activity activity) {
        this.f53681a = activity;
        this.f53686f = new PanelOmegaTracker();
        m40065a();
    }

    /* renamed from: a */
    private void m40065a() {
        LayoutInflater from = LayoutInflater.from(this.f53681a);
        this.f53683c = from;
        View inflate = from.inflate(R.layout.component_panel_recyclerview, (ViewGroup) null);
        this.f53682b = inflate;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.xp_scroll_view);
        this.f53685e = recyclerView;
        this.f53685e.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        SAPanelAdapter sAPanelAdapter = new SAPanelAdapter(this.f53685e.getContext());
        this.f53684d = sAPanelAdapter;
        this.f53685e.setAdapter(sAPanelAdapter);
        this.f53685e.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            SAPanelRecView.this.f53686f.omegaScrollTrack();
                        }
                    });
                    int i2 = 1;
                    HashMap hashMap = new HashMap(1);
                    if (SAPanelRecView.this.f53687g - SAPanelRecView.this.f53688h <= 0) {
                        i2 = 2;
                    }
                    hashMap.put("type", Integer.valueOf(i2));
                    OmegaSDKAdapter.trackEvent("ibt_gp_sa_home_sd", (Map<String, Object>) hashMap);
                    SAPanelRecView sAPanelRecView = SAPanelRecView.this;
                    int unused = sAPanelRecView.f53688h = sAPanelRecView.f53687g;
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                SAPanelRecView.m40068b(SAPanelRecView.this, i2);
                if (SAPanelRecView.this.f53687g > DisplayUtil.getScreenHeight(SAPanelRecView.this.f53681a) / 2) {
                    SaBusinessManager.Companion.getIns().notifyTabUp(SaTabIds.TAB_HOME.getId());
                } else {
                    SaBusinessManager.Companion.getIns().notifyTabDown(SaTabIds.TAB_HOME.getId());
                }
                PanelAnimatorMgr.onRvScroll(SAPanelRecView.this.f53687g);
            }
        });
    }

    public void setData(List<SACardProperty> list) {
        if (list != null) {
            m40066a(list);
        }
    }

    /* renamed from: a */
    private void m40066a(List<SACardProperty> list) {
        PageTouchEventManger.showMap = false;
        PageTouchEventManger.mapInFirstPosition = false;
        for (int i = 0; i < list.size(); i++) {
            SACardProperty sACardProperty = list.get(i);
            if (ComponentType.COMPONENT_RIDE_CARD.equals(sACardProperty.getId())) {
                if (sACardProperty.isTransparent()) {
                    PageTouchEventManger.showMap = true;
                }
                if (i == 0) {
                    PageTouchEventManger.mapInFirstPosition = true;
                }
            }
        }
        this.f53684d.setCardPropertyList(list);
        this.f53686f.setCurrentCardProperties(list);
    }

    public void addCard(SACardProperty sACardProperty, int i) {
        this.f53684d.addCard(sACardProperty, i);
    }

    public void removeCard(int i) {
        this.f53684d.removeCard(i);
    }

    public void updateCard(SACardProperty sACardProperty) {
        this.f53684d.updateCard(sACardProperty);
    }

    public View getView() {
        return this.f53682b;
    }

    public RecyclerView getContainer() {
        return this.f53685e;
    }

    public void resumePageSize() {
        RecyclerView recyclerView = this.f53685e;
        if (recyclerView != null) {
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                if (behavior instanceof SARecycleViewBehavior) {
                    ((SARecycleViewBehavior) behavior).reverseAnimator();
                }
            }
        }
    }

    public void expandPage() {
        RecyclerView recyclerView = this.f53685e;
        if (recyclerView != null) {
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                if (behavior instanceof SARecycleViewBehavior) {
                    ((SARecycleViewBehavior) behavior).expandToRid(1);
                }
            }
        }
    }

    public void scrollTop(int i) {
        if (this.f53687g > DisplayUtil.getScreenHeight(this.f53681a) / 2) {
            this.f53685e.smoothScrollToPosition(0);
        }
    }
}
