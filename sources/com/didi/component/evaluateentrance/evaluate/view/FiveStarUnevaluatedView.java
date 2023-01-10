package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.evaluateentrance.evaluate.model.FiveStarModel;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsFiveStarPresenter;
import com.didi.component.evaluateentrance.evaluate.toolkit.ViewToolKit;
import com.didi.component.evaluateentrance.evaluate.view.FiveStarRenderView;
import com.taxis99.R;

public class FiveStarUnevaluatedView implements IFiveStarView {

    /* renamed from: a */
    private final ViewGroup f15374a;

    /* renamed from: b */
    private final ViewToolKit f15375b;

    /* renamed from: c */
    private final FiveStarRenderView f15376c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbsFiveStarPresenter f15377d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GXPEvaluateTipPayDrawer f15378e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f15379f;

    public FiveStarUnevaluatedView(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.g_xp_evaluate_five_star_layout, (ViewGroup) null, false);
        this.f15374a = viewGroup;
        ViewToolKit create = ViewToolKit.create(viewGroup);
        this.f15375b = create;
        this.f15376c = (FiveStarRenderView) create.findViewById(R.id.fsv_evaluate);
        m12674a();
    }

    /* renamed from: a */
    private void m12674a() {
        this.f15376c.setClickFiveStarListener(new FiveStarRenderView.OnClickFiveStarListener() {
            public void onClickFiveStarLevel(int i) {
                FiveStarUnevaluatedView.this.f15377d.onEvaluatedClicked(i, FiveStarUnevaluatedView.this.f15379f);
            }
        });
    }

    public void initData(final FiveStarModel fiveStarModel) {
        if (fiveStarModel.normal != null) {
            FiveStarModel.NormalBean normalBean = fiveStarModel.normal;
            this.f15375b.setImageView(R.id.civ_avatar, normalBean.avatarIcon, R.drawable.global_xp_driver_car_default_avatar);
            this.f15375b.setTextViewText((int) R.id.tv_title, (CharSequence) normalBean.title, (int) R.string.global_new_evaluate_five_star_title_current);
            this.f15375b.setTextViewText((int) R.id.tv_sub_title, (CharSequence) normalBean.subTitle, (int) R.string.global_new_evaluate_five_star_subtitle);
            this.f15376c.setEnable(true);
            this.f15379f = normalBean.evaluateInfoJson;
            final EvaluateTipView evaluateTipView = (EvaluateTipView) this.f15375b.findViewById(R.id.eve_tip);
            if (normalBean != null && normalBean.status == 0) {
                evaluateTipView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (FiveStarUnevaluatedView.this.f15378e == null) {
                            GXPEvaluateTipPayDrawer unused = FiveStarUnevaluatedView.this.f15378e = new GXPEvaluateTipPayDrawer(evaluateTipView.getContext(), FiveStarUnevaluatedView.this.f15377d, fiveStarModel.normal.tipInfo, "starrate", fiveStarModel.normal.avatarIcon);
                        }
                        FiveStarUnevaluatedView.this.f15378e.show();
                        GlobalOmegaUtils.trackEvent("ibt_gp_tipentrance_btn_ck", "source", "starrate");
                    }
                });
                evaluateTipView.initData(normalBean.tipInfo, "starrate");
            }
            closeDrawer();
        }
    }

    public void showEvaluated(int i) {
        this.f15376c.setEnable(false);
        this.f15376c.flushRateStar(i - 1);
        this.f15377d.refreshXpanel();
    }

    public View getView() {
        return this.f15374a;
    }

    public void setPresenter(AbsFiveStarPresenter absFiveStarPresenter) {
        this.f15377d = absFiveStarPresenter;
    }

    public void closeDrawer() {
        GXPEvaluateTipPayDrawer gXPEvaluateTipPayDrawer = this.f15378e;
        if (gXPEvaluateTipPayDrawer != null && gXPEvaluateTipPayDrawer.isShowing()) {
            this.f15378e.dismiss();
        }
    }
}
