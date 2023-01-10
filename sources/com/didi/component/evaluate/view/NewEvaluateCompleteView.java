package com.didi.component.evaluate.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.ImageUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.loading.OnRetryListener;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.widget.AbsBaseTagLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagImageLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagTextLayout;
import com.didi.component.evaluate.view.widget.NewFiveStarEvaluatedView;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.android.flexbox.FlexboxLayout;
import com.taxis99.R;
import java.util.List;

public class NewEvaluateCompleteView extends AbsNewEvaluateView implements IEvaluateView {

    /* renamed from: a */
    private static final int f15176a = 4;

    /* renamed from: b */
    private Context f15177b;

    /* renamed from: c */
    private ImageView f15178c;

    /* renamed from: d */
    private TextView f15179d;

    /* renamed from: e */
    private TextView f15180e;

    /* renamed from: f */
    private LinearLayout f15181f;

    /* renamed from: g */
    private TextView f15182g;

    /* renamed from: h */
    private TextView f15183h;

    /* renamed from: i */
    private LinearLayout f15184i;

    /* renamed from: j */
    private ImageView f15185j;

    /* renamed from: k */
    private NewFiveStarEvaluatedView f15186k;

    /* renamed from: l */
    private FlexboxLayout f15187l;

    /* renamed from: m */
    private NewEvaluateScrollView f15188m;
    protected IEvaluateView.OnCloseListener mOnCloseListener;

    /* renamed from: n */
    private int f15189n = 0;

    public void hideLoading() {
    }

    public void initIsInFiveStar(boolean z) {
    }

    public void onAdd() {
    }

    public void onPause() {
    }

    public void onRemove() {
    }

    public void onResume() {
    }

    public void setCarEvaluateTags(List<CarNoEvaluateData.CarEvaluateTag> list) {
    }

    public void setCardTitle(String str) {
    }

    public void setCommentAreaVisibility(boolean z) {
    }

    public void setDefaultDriverIcon(int i) {
    }

    public void setEvaluateListener(IEvaluateView.EvaluateListener evaluateListener) {
    }

    public void setOnCancelListener(IEvaluateView.OnCancelListener onCancelListener) {
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
    }

    public void setSymbol(String str) {
    }

    public void setTagTitle(String str, String str2) {
    }

    public void showHeader() {
    }

    public void showLoading() {
    }

    public void showLoadingFail(boolean z) {
    }

    public void showSubmitFail() {
    }

    public void showSubmitSuccess() {
    }

    public NewEvaluateCompleteView(Context context, int i) {
        this.f15177b = context;
        this.f15189n = i;
        this.mRootView = LayoutInflater.from(context).inflate(i == 1 ? R.layout.g_xp_evaluate_complete_layout : R.layout.global_new_evaluate_complete_layout, (ViewGroup) null);
        m12526a();
    }

    /* renamed from: a */
    private void m12526a() {
        this.f15178c = (ImageView) this.mRootView.findViewById(R.id.driver_image);
        this.f15179d = (TextView) this.mRootView.findViewById(R.id.evalute_refine_guide);
        this.f15180e = (TextView) this.mRootView.findViewById(R.id.evaluate_content);
        this.f15181f = (LinearLayout) this.mRootView.findViewById(R.id.evaluate_content_layout);
        this.f15182g = (TextView) this.mRootView.findViewById(R.id.tips_fee);
        this.f15183h = (TextView) this.mRootView.findViewById(R.id.tips_currency);
        this.f15184i = (LinearLayout) this.mRootView.findViewById(R.id.evaluate_tips_layout);
        NewFiveStarEvaluatedView newFiveStarEvaluatedView = (NewFiveStarEvaluatedView) this.mRootView.findViewById(R.id.five_star_view);
        this.f15186k = newFiveStarEvaluatedView;
        newFiveStarEvaluatedView.setMargin(4);
        this.f15186k.setEnable(false);
        this.f15186k.setIsHideUnselect(true);
        this.f15187l = (FlexboxLayout) this.mRootView.findViewById(R.id.evaluate_tag_layout);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.f15185j = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NewEvaluateCompleteView.this.mOnCloseListener != null) {
                    NewEvaluateCompleteView.this.mOnCloseListener.onClose();
                }
            }
        });
        NewEvaluateScrollView newEvaluateScrollView = (NewEvaluateScrollView) this.mRootView.findViewById(R.id.evaluate_scroll_view);
        this.f15188m = newEvaluateScrollView;
        newEvaluateScrollView.setMaxHeight(UIUtils.getScreenWidth(this.f15177b));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            setDriverIconAndName(order.carDriver.avatarUrl, order.carDriver.name);
        }
    }

    public void setLevel(int i) {
        NewFiveStarEvaluatedView newFiveStarEvaluatedView = this.f15186k;
        if (newFiveStarEvaluatedView != null) {
            newFiveStarEvaluatedView.setVisibility(0);
            this.f15186k.showEvaluated(i);
        }
    }

    public void setDriverIconAndName(String str, String str2) {
        if (this.f15178c != null && !TextUtils.isEmpty(str)) {
            ImageUtils.glideLoad(this.f15178c.getContext(), str, this.f15178c);
        }
    }

    public void setTags(List<EvaluateTag> list) {
        AbsBaseTagLayout absBaseTagLayout;
        this.f15187l.removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            EvaluateTag evaluateTag = list.get(i);
            if (this.f15186k.getCurrentStar() == 5) {
                absBaseTagLayout = new EvaluateTagImageLayout(this.f15177b);
            } else {
                absBaseTagLayout = new EvaluateTagTextLayout(this.f15177b);
            }
            absBaseTagLayout.setTagModel(evaluateTag);
            absBaseTagLayout.setSelected(true);
            absBaseTagLayout.setEnable(false);
            this.f15187l.addView(absBaseTagLayout);
        }
    }

    public void setCommentContent(String str) {
        if (this.f15180e != null && !TextUtils.isEmpty(str)) {
            this.f15180e.setText(str);
            this.f15181f.setVisibility(0);
        }
    }

    public void setRefineGuide(String str) {
        if (this.f15179d != null && !TextUtils.isEmpty(str)) {
            this.f15179d.setText(str);
        }
    }

    public void refreshThanksTipData(CarTipInfo carTipInfo) {
        if (carTipInfo != null && this.f15182g != null && carTipInfo.isShow() && carTipInfo.isPay()) {
            if (TextUtils.isEmpty(carTipInfo.msg)) {
                this.f15184i.setVisibility(8);
                return;
            }
            this.f15184i.setVisibility(0);
            String str = carTipInfo.msg;
            String a = m12525a(str, "(", ")");
            String a2 = m12525a(str, Const.joLeft, "}");
            this.f15183h.setText(a);
            this.f15182g.setText(a2);
        }
    }

    /* renamed from: a */
    private String m12525a(String str, String str2, String str3) {
        return str.substring(str.indexOf(str2) + 1, str.indexOf(str3));
    }

    public void setOnCloseListener(IEvaluateView.OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void close() {
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onClose();
        }
    }

    public void closeWithoutOmega() {
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onCloseWithOutOmega();
        }
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(IPresenter iPresenter) {
        this.mAbsEvaluatePresenter = (AbsCommonEvaluatePresenter) iPresenter;
    }

    public int getStyle() {
        return this.f15189n;
    }
}
