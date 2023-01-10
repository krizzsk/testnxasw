package com.didi.component.evaluatequestion.impl.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.loading.LoadingWrapper;
import com.didi.component.evaluatequestion.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.UnevaluatedViewModel;
import com.didi.component.evaluatequestion.impl.view.widget.QuestionEvaluatedView;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.taxis99.R;

public class EndServiceEvaluateQuestionView extends LoadingWrapper implements IEvaluatedView, ILoadingHolder {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsEvaluateQuestionPresenter f15417a;

    /* renamed from: b */
    private Activity f15418b;

    /* renamed from: c */
    private ViewGroup f15419c;

    /* renamed from: d */
    private TextView f15420d = ((TextView) this.f15419c.findViewById(R.id.tv_global_unevaluate_title));

    /* renamed from: e */
    private TextView f15421e = ((TextView) this.f15419c.findViewById(R.id.tv_global_unevaluate_subtitle));

    /* renamed from: f */
    private TextView f15422f = ((TextView) this.f15419c.findViewById(R.id.tv_global_unevaluate_content));

    /* renamed from: g */
    private TextView f15423g = ((TextView) this.f15419c.findViewById(R.id.tv_global_unevaluate_question_content));

    /* renamed from: h */
    private IEvaluatedView f15424h;

    /* renamed from: i */
    private FrameLayout f15425i;

    /* renamed from: j */
    private View f15426j;

    /* renamed from: k */
    private FrameLayout f15427k;

    public EndServiceEvaluateQuestionView(Activity activity, ViewGroup viewGroup) {
        this.f15418b = activity;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.global_endservice_evaluate_question_layout, viewGroup, false);
        this.f15419c = viewGroup2;
        this.f15426j = viewGroup2.findViewById(R.id.global_evaluate_question_close_button);
        FrameLayout frameLayout = (FrameLayout) this.f15419c.findViewById(R.id.fl_global_evaluate_container);
        this.f15425i = frameLayout;
        QuestionEvaluatedView questionEvaluatedView = new QuestionEvaluatedView(this.f15418b, frameLayout);
        this.f15424h = questionEvaluatedView;
        this.f15425i.addView(questionEvaluatedView.getView());
        this.f15424h.setPresenter(this.f15417a);
        this.f15427k = (FrameLayout) this.f15419c.findViewById(R.id.global_endservice_evaluate_loading);
        setLoadingShowOn(this);
    }

    public void setPresenter(AbsEvaluateQuestionPresenter absEvaluateQuestionPresenter) {
        this.f15417a = absEvaluateQuestionPresenter;
        IEvaluatedView iEvaluatedView = this.f15424h;
        if (iEvaluatedView != null) {
            iEvaluatedView.setPresenter(absEvaluateQuestionPresenter);
            this.f15426j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    EndServiceEvaluateQuestionView.this.f15417a.close();
                }
            });
        }
    }

    public View getView() {
        return this.f15419c;
    }

    public void showUnevaluated(UnevaluatedViewModel unevaluatedViewModel) {
        if (unevaluatedViewModel != null) {
            if (!TextUtils.isEmpty(unevaluatedViewModel.questionTitle)) {
                this.f15420d.setVisibility(0);
                this.f15420d.setText(unevaluatedViewModel.questionTitle);
            } else {
                this.f15420d.setVisibility(8);
            }
            if (!TextUtils.isEmpty(unevaluatedViewModel.subTitle)) {
                this.f15421e.setText(unevaluatedViewModel.subTitle);
                this.f15421e.setVisibility(0);
            } else {
                this.f15421e.setVisibility(8);
            }
            if (!TextUtils.isEmpty(unevaluatedViewModel.content)) {
                this.f15422f.setText(unevaluatedViewModel.content);
                this.f15422f.setVisibility(0);
            } else {
                this.f15422f.setVisibility(8);
            }
            if (TextUtils.isEmpty(unevaluatedViewModel.questionBody) || !TextUtils.isEmpty(unevaluatedViewModel.userReply)) {
                this.f15423g.setVisibility(8);
            } else {
                this.f15423g.setText(unevaluatedViewModel.questionBody);
                this.f15423g.setVisibility(0);
            }
            IEvaluatedView iEvaluatedView = this.f15424h;
            if (iEvaluatedView != null) {
                iEvaluatedView.showUnevaluated(unevaluatedViewModel);
            }
        }
    }

    public void showUnevaluated() {
        this.f15424h.showUnevaluated();
    }

    public void showEvaluated(int i, UnevaluatedViewModel unevaluatedViewModel) {
        this.f15424h.showEvaluated(i, unevaluatedViewModel);
    }

    public void onEvaluateDialogClosed() {
        IEvaluatedView iEvaluatedView = this.f15424h;
        if (iEvaluatedView != null) {
            iEvaluatedView.onEvaluateDialogClosed();
        }
    }

    public void showLoading() {
        super.showLoading();
        IEvaluatedView iEvaluatedView = this.f15424h;
        if (iEvaluatedView != null) {
            iEvaluatedView.showLoading();
        }
    }

    public void hideLoading() {
        super.hideLoading();
        IEvaluatedView iEvaluatedView = this.f15424h;
        if (iEvaluatedView != null) {
            iEvaluatedView.hideLoading();
        }
    }

    public void showError() {
        IEvaluatedView iEvaluatedView = this.f15424h;
        if (iEvaluatedView != null) {
            iEvaluatedView.showError();
        }
    }

    public void hideError() {
        IEvaluatedView iEvaluatedView = this.f15424h;
        if (iEvaluatedView != null) {
            iEvaluatedView.hideError();
        }
    }

    public void close() {
        IEvaluatedView iEvaluatedView = this.f15424h;
        if (iEvaluatedView != null) {
            iEvaluatedView.close();
        }
    }

    public View getFallbackView() {
        return this.f15427k;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }
}
