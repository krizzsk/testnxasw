package com.didiglobal.p205sa.biz.component.guide.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.guide.GuideTipModel;
import com.didiglobal.p205sa.biz.component.guide.view.GuideView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.guide.view.Guider */
public class Guider {
    public static final String kingkong_item_tips = "sa_business_icon";

    /* renamed from: a */
    private final RecyclerView.LayoutManager f53515a;

    /* renamed from: b */
    private final Context f53516b;

    /* renamed from: c */
    private GuideTipModel f53517c;

    /* renamed from: d */
    private RecyclerView f53518d;

    /* renamed from: e */
    private List<GudieModel> f53519e;

    /* renamed from: f */
    private int f53520f = 0;

    public Guider(Context context, RecyclerView recyclerView, List<SACardProperty> list, GuideTipModel guideTipModel) {
        this.f53516b = context;
        this.f53518d = recyclerView;
        this.f53515a = recyclerView.getLayoutManager();
        this.f53517c = guideTipModel;
        m39953a(list);
    }

    /* renamed from: a */
    private void m39953a(List<SACardProperty> list) {
        String[] strArr;
        this.f53519e = new ArrayList();
        if (this.f53517c.getUser_type() == 1) {
            strArr = new String[]{"sa_business_icon", ComponentType.COMPONENT_BUSINESS_CARD, ComponentType.COMPONENT_RECOMMEND};
        } else {
            strArr = new String[]{ComponentType.COMPONENT_RIDE_CARD, ComponentType.COMPONENT_BUSINESS_CARD, ComponentType.COMPONENT_RECOMMEND};
        }
        for (String str : strArr) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (str.equals("sa_business_icon") && ComponentType.COMPONENT_BUSINESS_CARD.equals(list.get(i).getId())) {
                    GudieModel gudieModel = new GudieModel();
                    gudieModel.f53521id = str;
                    gudieModel.postion = i;
                    GuideView a = m39947a(str, i, list);
                    if (a != null) {
                        gudieModel.guideView = a;
                        this.f53519e.add(gudieModel);
                    }
                } else if (str.equals(list.get(i).getId())) {
                    GudieModel gudieModel2 = new GudieModel();
                    gudieModel2.f53521id = str;
                    gudieModel2.postion = i;
                    GuideView a2 = m39947a(str, i, list);
                    if (a2 != null) {
                        gudieModel2.guideView = a2;
                        this.f53519e.add(gudieModel2);
                    }
                } else {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39949a() {
        if (this.f53520f < this.f53519e.size()) {
            this.f53519e.get(this.f53520f).guideView.hide();
            int i = this.f53520f + 1;
            this.f53520f = i;
            if (i >= this.f53519e.size()) {
                this.f53515a.smoothScrollToPosition(this.f53518d, new RecyclerView.State(), 0);
                return;
            }
            this.f53515a.smoothScrollToPosition(this.f53518d, new RecyclerView.State(), this.f53519e.get(i).postion);
            View findViewByPosition = this.f53515a.findViewByPosition(this.f53519e.get(i).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f53518d.scrollBy(0, top - ((this.f53518d.getHeight() / 2) - (height / 2)));
                this.f53519e.get(i).guideView.show();
                m39952a(this.f53519e.get(i).f53521id, "ibt_gp_noob_sw");
            }
        }
    }

    /* renamed from: a */
    private GuideView m39947a(final String str, int i, List<SACardProperty> list) {
        GuideView.Direction direction;
        IGuideInterface iGuideInterface;
        View view;
        int i2;
        GuideView.Direction direction2;
        ICardPosition position;
        int i3;
        GuideView.Direction direction3 = GuideView.Direction.CENTER_TIPS_BOTTOM;
        int dimension = (int) this.f53516b.getResources().getDimension(R.dimen.view_bg_content);
        int dimension2 = (int) this.f53516b.getResources().getDimension(R.dimen.view_bg_arrow);
        if (str.equals("sa_business_icon")) {
            ICardPosition position2 = list.get(i).getPosition();
            view = position2 != null ? position2.getCardPosition("soda") : null;
            int i4 = i + 1;
            int i5 = 0;
            while (i4 < list.size() && (r7 = this.f53515a.findViewByPosition(i4)) != null && (i5 = i5 + r7.getHeight()) <= dimension2) {
                i4++;
            }
            if (i5 > dimension2) {
                direction = GuideView.Direction.BOTTOM_ARROW;
                i3 = 0;
            } else {
                direction = GuideView.Direction.TOP_ARROW;
                i3 = 1;
            }
            iGuideInterface = new GuideBgArrow(this.f53516b, i3);
        } else {
            View view2 = list.get(i).getView();
            if (ComponentType.COMPONENT_RECOMMEND.equals(str) && (position = list.get(i).getPosition()) != null) {
                view2 = position.getCardPosition("recomd");
            }
            int i6 = i + 1;
            int i7 = 0;
            while (i6 < list.size() && (r7 = this.f53515a.findViewByPosition(i6)) != null && (i7 = i7 + r7.getHeight()) <= dimension) {
                i6++;
            }
            if (i7 > dimension) {
                direction2 = GuideView.Direction.CENTER_TIPS_BOTTOM;
                i2 = 1;
            } else {
                direction2 = GuideView.Direction.CENTER_TIPS_TOP;
                i2 = 0;
            }
            View view3 = view2;
            iGuideInterface = new GuideBgViewTips(this.f53516b, i2);
            view = view3;
        }
        if (view == null || view.getHeight() == 0 || view.getWidth() == 0) {
            return null;
        }
        iGuideInterface.setOnGetClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Guider.this.m39952a(str, "ibt_gp_noob_ck");
                Guider.this.m39949a();
            }
        });
        iGuideInterface.setGuideTips(m39948a(str));
        iGuideInterface.setBtnText(m39954b());
        GuideView build = GuideView.Builder.newInstance(this.f53516b).setTargetView(view).setCustomGuideView((View) iGuideInterface).setDirction(direction).setShape(GuideView.MyShape.RECTANGULAR).setBgColor(Color.parseColor("#B30A121A")).build();
        if (ComponentType.COMPONENT_RECOMMEND.equals(str)) {
            build.setBgmargin(0);
            build.setTargetViewpadding(UiUtils.dip2px(this.f53516b, 6.0f));
            build.setVisiblePaddings(new Rect(UiUtils.dip2px(this.f53516b, 6.0f), 0, UiUtils.dip2px(this.f53516b, 6.0f), 0));
            int dimension3 = ((int) this.f53516b.getResources().getDimension(R.dimen.view_bg_radius)) * 2;
            int dimension4 = ((int) this.f53516b.getResources().getDimension(R.dimen.view_radius)) * 2;
            GuideBgViewTips guideBgViewTips = (GuideBgViewTips) iGuideInterface;
            guideBgViewTips.setmAllBgDiameter(guideBgViewTips.getmTipType() == 1 ? new int[]{dimension4, dimension4, dimension3, dimension3} : new int[]{dimension3, dimension3, dimension4, dimension4});
        }
        if (ComponentType.COMPONENT_BUSINESS_CARD.equals(str)) {
            build.setVisiblePaddings(new Rect(UiUtils.dip2px(this.f53516b, 16.0f), UiUtils.dip2px(this.f53516b, 10.0f), UiUtils.dip2px(this.f53516b, 16.0f), UiUtils.dip2px(this.f53516b, 17.0f)));
        }
        return build;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39952a(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(ParamConst.PARAM_MODULE_ID, str);
        OmegaSDKAdapter.trackEvent(str2, (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private String m39954b() {
        GuideTipModel guideTipModel = this.f53517c;
        if (guideTipModel == null) {
            return "";
        }
        return guideTipModel.getAction_button();
    }

    /* renamed from: a */
    private String m39948a(String str) {
        if (this.f53517c == null) {
            return "";
        }
        if (ComponentType.COMPONENT_RECOMMEND.equals(str)) {
            return this.f53517c.getRecommend_card_tips();
        }
        if (ComponentType.COMPONENT_RIDE_CARD.equals(str)) {
            return this.f53517c.getMain_card_tips();
        }
        if (ComponentType.COMPONENT_BUSINESS_CARD.equals(str)) {
            return this.f53517c.getKingkong_card_tips();
        }
        if ("sa_business_icon".equals(str)) {
            return this.f53517c.getKingkong_item_tips();
        }
        return "";
    }

    public void showGuides() {
        if (this.f53515a != null && this.f53519e.size() > 0) {
            this.f53515a.smoothScrollToPosition(this.f53518d, new RecyclerView.State(), this.f53519e.get(0).postion);
            View findViewByPosition = this.f53515a.findViewByPosition(this.f53519e.get(0).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f53518d.scrollBy(0, top - ((this.f53518d.getHeight() / 2) - (height / 2)));
                this.f53519e.get(0).guideView.show();
                m39952a(this.f53519e.get(0).f53521id, "ibt_gp_noob_sw");
            }
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.Guider$GudieModel */
    public class GudieModel {
        public GuideView guideView;

        /* renamed from: id */
        public String f53521id;
        public int postion;

        public GudieModel() {
        }
    }
}
