package com.didi.component.drainage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.drainage.DrainageGuideView;
import com.didi.sdk.global.common.com.UiUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrainageGuider {
    public static final String business_credit = "loan";
    public static final String business_food = "soda";

    /* renamed from: a */
    private final Context f14747a;

    /* renamed from: b */
    private final List<String> f14748b;

    /* renamed from: c */
    private DrainageData f14749c;

    /* renamed from: d */
    private List<GudieModel> f14750d;

    /* renamed from: e */
    private int f14751e;

    /* renamed from: f */
    private long f14752f;

    public DrainageGuider(Context context, List<View> list, List<String> list2, DrainageData drainageData) {
        this.f14747a = context;
        this.f14749c = drainageData;
        this.f14748b = list2;
        m12167a(list);
    }

    /* renamed from: a */
    private void m12167a(List<View> list) {
        this.f14750d = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            View view = list.get(i);
            if (!(view == null || view.getHeight() == 0 || view.getWidth() == 0)) {
                DrainageGuideView a = m12164a(this.f14748b.get(i), view);
                GudieModel gudieModel = new GudieModel();
                gudieModel.guideView = a;
                gudieModel.f14753id = this.f14748b.get(i);
                this.f14750d.add(gudieModel);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12165a() {
        if (this.f14751e < this.f14750d.size()) {
            this.f14750d.get(this.f14751e).guideView.hide();
            HashMap hashMap = new HashMap(1);
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f14752f));
            omegaTrack("ibt_gp_grayband_staytime_sw", hashMap);
            int i = this.f14751e + 1;
            this.f14751e = i;
            if (i < this.f14750d.size()) {
                this.f14750d.get(i).guideView.show();
            }
        }
    }

    /* renamed from: a */
    private DrainageGuideView m12164a(String str, View view) {
        DrainageGuideView.MyShape myShape;
        DrainageGuideView.Direction direction;
        int i;
        DrainageGuideView.Direction direction2 = DrainageGuideView.Direction.ANIMATION_TIPS_TOP;
        DrainageGuideView.MyShape myShape2 = DrainageGuideView.MyShape.RECTANGULAR;
        if (str.equals(business_credit)) {
            i = 1;
            direction = DrainageGuideView.Direction.ANIMATION_TIPS_BOTTOM;
            myShape = DrainageGuideView.MyShape.CIRCLE;
        } else {
            direction = DrainageGuideView.Direction.ANIMATION_TIPS_TOP;
            myShape = myShape2;
            i = 0;
        }
        DrainageGuideBgViewTips drainageGuideBgViewTips = new DrainageGuideBgViewTips(this.f14747a, i);
        if (view == null || view.getHeight() == 0 || view.getWidth() == 0) {
            return null;
        }
        drainageGuideBgViewTips.setShape(myShape);
        drainageGuideBgViewTips.setOnGetClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DrainageGuider.this.m12165a();
                DrainageGuider.this.omegaTrack("ibt_gp_grayband_close_ck", (HashMap) null);
            }
        });
        drainageGuideBgViewTips.setmGuideViewListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DrainageGuider.this.m12165a();
                DrainageGuider.this.omegaTrack("ibt_gp_grayband_ck", (HashMap) null);
            }
        });
        drainageGuideBgViewTips.setData(this.f14749c);
        DrainageGuideView build = DrainageGuideView.Builder.newInstance(this.f14747a).setTargetView(view).setCustomGuideView(drainageGuideBgViewTips).setDirction(direction).setShape(DrainageGuideView.MyShape.RECTANGULAR).setBgColor(Color.parseColor("#B30A121A")).build();
        if (!str.equals(business_credit)) {
            int width = view.getWidth();
            int height = view.getHeight();
            Rect rect = new Rect();
            int dip2px = UiUtils.dip2px(this.f14747a, 97.0f);
            int dip2px2 = UiUtils.dip2px(this.f14747a, 41.0f);
            int i2 = (width - dip2px) / 2;
            rect.left = i2;
            rect.right = i2;
            int i3 = (height - dip2px2) / 2;
            rect.top = i3;
            rect.bottom = i3;
            build.setVisiblePaddings(rect);
        }
        build.setOnTouchOutListener(new DrainageGuideView.DrainageClickListener() {
            public void onClickDrainage(boolean z) {
                if (z) {
                    DrainageGuider.this.omegaTrack("ibt_gp_grayband_tab_ck", (HashMap) null);
                } else {
                    DrainageGuider.this.omegaTrack("ibt_gp_out_grayband_ck", (HashMap) null);
                }
            }
        });
        return build;
    }

    public void showGuides() {
        if (this.f14750d.size() > 0) {
            this.f14750d.get(0).guideView.show();
            this.f14752f = System.currentTimeMillis();
            omegaTrack("ibt_gp_grayband_sw", (HashMap) null);
        }
    }

    public void omegaTrack(String str, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("tag", "NOW");
        DrainageData drainageData = this.f14749c;
        if (!(drainageData == null || drainageData.getLogDataMap() == null)) {
            hashMap2.putAll(this.f14749c.getLogDataMap());
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap2);
    }

    public class GudieModel {
        public DrainageGuideView guideView;

        /* renamed from: id */
        public String f14753id;
        public int postion;

        public GudieModel() {
        }
    }
}
