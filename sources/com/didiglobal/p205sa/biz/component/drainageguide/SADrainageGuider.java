package com.didiglobal.p205sa.biz.component.drainageguide;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.sdk.util.SaApolloUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuider */
public class SADrainageGuider {
    public static final String kingkong_item_tips = "sa_business_icon";

    /* renamed from: a */
    private final RecyclerView.LayoutManager f53448a;

    /* renamed from: b */
    private final Context f53449b;

    /* renamed from: c */
    private SADrainageModel f53450c;

    /* renamed from: d */
    private RecyclerView f53451d;

    /* renamed from: e */
    private List<GudieModel> f53452e;

    /* renamed from: f */
    private int f53453f = 0;

    /* renamed from: g */
    private long f53454g;

    public SADrainageGuider(Context context, RecyclerView recyclerView, List<SACardProperty> list, SADrainageModel sADrainageModel) {
        this.f53449b = context;
        this.f53451d = recyclerView;
        this.f53448a = recyclerView.getLayoutManager();
        this.f53450c = sADrainageModel;
        m39925a(list);
    }

    /* renamed from: a */
    private void m39925a(List<SACardProperty> list) {
        this.f53452e = new ArrayList();
        String[] strArr = {this.f53450c.getBusiness_type()};
        for (int i = 0; i < 1; i++) {
            String str = strArr[i];
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (ComponentType.COMPONENT_BUSINESS_CARD.equals(list.get(i2).getId())) {
                    GudieModel gudieModel = new GudieModel();
                    gudieModel.f53455id = str;
                    gudieModel.postion = i2;
                    SADrainageGuideView a = m39922a(str, i2, list);
                    if (a != null) {
                        gudieModel.guideView = a;
                        this.f53452e.add(gudieModel);
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39923a() {
        if (this.f53453f < this.f53452e.size()) {
            this.f53452e.get(this.f53453f).guideView.hide();
            HashMap hashMap = new HashMap(1);
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f53454g));
            omegaTrack("ibt_gp_grayband_staytime_sw", hashMap);
            int i = this.f53453f + 1;
            this.f53453f = i;
            if (i >= this.f53452e.size()) {
                this.f53448a.smoothScrollToPosition(this.f53451d, new RecyclerView.State(), 0);
                return;
            }
            this.f53448a.smoothScrollToPosition(this.f53451d, new RecyclerView.State(), this.f53452e.get(i).postion);
            View findViewByPosition = this.f53448a.findViewByPosition(this.f53452e.get(i).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f53451d.scrollBy(0, top - ((this.f53451d.getHeight() / 2) - (height / 2)));
                this.f53452e.get(i).guideView.show();
            }
        }
    }

    /* renamed from: a */
    private SADrainageGuideView m39922a(String str, int i, List<SACardProperty> list) {
        SADrainageGuideView.Direction direction = SADrainageGuideView.Direction.CENTER_TIPS_BOTTOM;
        int dip2px = UiUtils.dip2px(this.f53449b, 200.0f);
        ICardPosition position = list.get(i).getPosition();
        View cardPosition = position != null ? position.getCardPosition(str) : null;
        SADrainageGuideView.Direction direction2 = SADrainageGuideView.Direction.ANIMATION_TIPS_BOTTOM;
        int i2 = 1;
        if (cardPosition != null) {
            int[] iArr = new int[2];
            cardPosition.getLocationInWindow(iArr);
            if (iArr[1] > dip2px) {
                i2 = 0;
                direction2 = SADrainageGuideView.Direction.ANIMATION_TIPS_TOP;
            }
        }
        SADrainageGuideBgViewTips sADrainageGuideBgViewTips = new SADrainageGuideBgViewTips(this.f53449b, i2);
        if (cardPosition == null || cardPosition.getHeight() == 0 || cardPosition.getWidth() == 0) {
            return null;
        }
        sADrainageGuideBgViewTips.setOnGetClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SADrainageGuider.this.omegaTrack("ibt_gp_grayband_close_ck", (HashMap) null);
                SADrainageGuider.this.m39923a();
            }
        });
        sADrainageGuideBgViewTips.setmGuideViewListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SADrainageGuider.this.omegaTrack("ibt_gp_grayband_ck", (HashMap) null);
                SADrainageGuider.this.m39923a();
            }
        });
        sADrainageGuideBgViewTips.setData(this.f53450c);
        SADrainageGuideView build = SADrainageGuideView.Builder.newInstance(this.f53449b).setTargetView(cardPosition).setCustomGuideView(sADrainageGuideBgViewTips).setDirction(direction2).setShape(SADrainageGuideView.MyShape.RECTANGULAR).setBgColor(Color.parseColor("#B30A121A")).build();
        build.setOnTouchOutListener(new SADrainageGuideView.DrainageClickListener() {
            public void onClickDrainage(boolean z) {
                if (z) {
                    SADrainageGuider.this.omegaTrack("ibt_gp_grayband_tab_ck", (HashMap) null);
                } else {
                    SADrainageGuider.this.omegaTrack("ibt_gp_out_grayband_ck", (HashMap) null);
                }
            }
        });
        return build;
    }

    public void showGuides() {
        if (this.f53448a != null && this.f53452e.size() > 0) {
            this.f53448a.smoothScrollToPosition(this.f53451d, new RecyclerView.State(), this.f53452e.get(0).postion);
            View findViewByPosition = this.f53448a.findViewByPosition(this.f53452e.get(0).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f53451d.scrollBy(0, top - ((this.f53451d.getHeight() / 2) - (height / 2)));
                this.f53452e.get(0).guideView.show();
                this.f53454g = System.currentTimeMillis();
                omegaTrack("ibt_gp_grayband_sw", (HashMap) null);
            }
        }
    }

    public void omegaTrack(String str, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("tag", getSAType());
        SADrainageModel sADrainageModel = this.f53450c;
        if (!(sADrainageModel == null || sADrainageModel.getLog_data() == null)) {
            hashMap2.putAll(this.f53450c.getLog_data());
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap2);
    }

    public static String getSAType() {
        SaApolloUtil.SaType saType = SaApolloUtil.INSTANCE.getSaType();
        if (saType == SaApolloUtil.SaType.SA_A) {
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }
        if (saType == SaApolloUtil.SaType.SA_B) {
            return "B";
        }
        return saType == SaApolloUtil.SaType.SA_C ? "C" : "default";
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuider$GudieModel */
    public class GudieModel {
        public SADrainageGuideView guideView;

        /* renamed from: id */
        public String f53455id;
        public int postion;

        public GudieModel() {
        }
    }
}
