package com.didi.component.comp_recommend_boarding_point.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.comp_recommend_boarding_point.AbsRecommendBoardingPointPresent;
import com.didi.component.comp_recommend_boarding_point.IRecommendBoardingPointView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;

public class RecommendBoardingPointView implements View.OnClickListener, IRecommendBoardingPointView {

    /* renamed from: a */
    private final View f14214a;

    /* renamed from: b */
    private AbsRecommendBoardingPointPresent f14215b;

    /* renamed from: c */
    private final TextView f14216c;

    /* renamed from: d */
    private final TextView f14217d = ((TextView) this.f14214a.findViewById(R.id.tv_content));

    /* renamed from: e */
    private final TextView f14218e;

    /* renamed from: f */
    private Button f14219f;

    public RecommendBoardingPointView(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recommend_boarding_point_layout, viewGroup, false);
        this.f14214a = inflate;
        this.f14216c = (TextView) inflate.findViewById(R.id.tv_title);
        TextView textView = (TextView) this.f14214a.findViewById(R.id.tv_time);
        this.f14218e = textView;
        textView.setOnClickListener(this);
        Button button = (Button) this.f14214a.findViewById(R.id.btn_use);
        this.f14219f = button;
        button.setOnClickListener(this);
    }

    public View getView() {
        return this.f14214a;
    }

    public void setPresenter(AbsRecommendBoardingPointPresent absRecommendBoardingPointPresent) {
        this.f14215b = absRecommendBoardingPointPresent;
    }

    public void setTime(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f14218e.setText(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtil.isEmpty(str)) {
            GlobalRichInfo globalRichInfo = new GlobalRichInfo();
            globalRichInfo.setInfo(str);
            globalRichInfo.bindTextView(this.f14216c);
        }
    }

    public void setContent(String str) {
        if (!TextUtil.isEmpty(str)) {
            GlobalRichInfo globalRichInfo = new GlobalRichInfo();
            globalRichInfo.setInfo(str);
            globalRichInfo.bindTextView(this.f14217d);
        }
    }

    public void setButtonText(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f14219f.setText(str);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.btn_use) {
            this.f14215b.cardUseDismissClick(true);
        } else if (id == R.id.tv_time) {
            this.f14215b.cardUseDismissClick(false);
        }
    }

    public void hideView() {
        View view = this.f14214a;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
