package com.didi.component.evaluatequestion.impl.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.view.DotLoadingView;
import com.didi.component.common.view.TextImageView;
import com.didi.component.evaluatequestion.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.UnevaluatedViewModel;
import com.didi.component.evaluatequestion.impl.view.IEvaluatedView;
import com.taxis99.R;

public class QuestionEvaluatedView implements View.OnClickListener, IEvaluatedView {

    /* renamed from: m */
    private static final int[] f15428m = {R.drawable.global_evaluate_face_pos_pressed, R.drawable.global_evaluate_face_neg_pressed};

    /* renamed from: a */
    private View f15429a;

    /* renamed from: b */
    private View f15430b;

    /* renamed from: c */
    private TextImageView f15431c;

    /* renamed from: d */
    private View f15432d;

    /* renamed from: e */
    private TextImageView f15433e;

    /* renamed from: f */
    private View f15434f;

    /* renamed from: g */
    private TextImageView f15435g;

    /* renamed from: h */
    private Context f15436h;

    /* renamed from: i */
    private View f15437i;

    /* renamed from: j */
    private View f15438j;

    /* renamed from: k */
    private DotLoadingView f15439k;

    /* renamed from: l */
    private int f15440l;

    /* renamed from: n */
    private AbsEvaluateQuestionPresenter f15441n;

    public void close() {
    }

    public void onEvaluateDialogClosed() {
    }

    public QuestionEvaluatedView(View view) {
        this.f15436h = view.getContext();
        this.f15429a = view;
        m12718a();
    }

    public QuestionEvaluatedView(Context context, ViewGroup viewGroup) {
        this.f15436h = context;
        this.f15429a = LayoutInflater.from(context).inflate(R.layout.global_evaluate_question_layout, viewGroup, false);
        m12718a();
    }

    /* renamed from: a */
    private void m12718a() {
        this.f15430b = this.f15429a.findViewById(R.id.rl_global_evaluate_pos_layout);
        this.f15432d = this.f15429a.findViewById(R.id.rl_global_evaluate_neg_layout);
        this.f15431c = (TextImageView) this.f15429a.findViewById(R.id.iv_global_evaluate_pos_button);
        this.f15433e = (TextImageView) this.f15429a.findViewById(R.id.iv_global_evaluate_neg_button);
        this.f15434f = this.f15429a.findViewById(R.id.rl_global_evaluated_layout);
        this.f15435g = (TextImageView) this.f15429a.findViewById(R.id.iv_global_evaluated_button);
        this.f15437i = this.f15429a.findViewById(R.id.global_evaluate_question_error_layout);
        this.f15439k = (DotLoadingView) this.f15429a.findViewById(R.id.global_evaluate_question_loading);
        this.f15438j = this.f15429a.findViewById(R.id.global_evaluate_question_loading_container);
        this.f15430b.setOnClickListener(this);
        this.f15432d.setOnClickListener(this);
        this.f15437i.setOnClickListener(this);
    }

    public View getView() {
        return this.f15429a;
    }

    public void setPresenter(AbsEvaluateQuestionPresenter absEvaluateQuestionPresenter) {
        this.f15441n = absEvaluateQuestionPresenter;
    }

    public void showUnevaluated() {
        this.f15430b.setVisibility(0);
        this.f15432d.setVisibility(0);
        this.f15434f.setVisibility(8);
    }

    public void showEvaluated(int i, UnevaluatedViewModel unevaluatedViewModel) {
        if (i < 2 && i >= 0 && unevaluatedViewModel != null && unevaluatedViewModel.answers != null && unevaluatedViewModel.answers.length >= 2) {
            this.f15430b.setVisibility(8);
            this.f15432d.setVisibility(8);
            this.f15434f.setVisibility(0);
            this.f15435g.setCompoundDrawablesWithIntrinsicBounds(this.f15436h.getResources().getDrawable(f15428m[i]), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f15435g.setText(unevaluatedViewModel.answers[i]);
            this.f15435g.setDrawablesSize();
        }
    }

    public void showUnevaluated(UnevaluatedViewModel unevaluatedViewModel) {
        this.f15430b.setVisibility(0);
        this.f15432d.setVisibility(0);
        this.f15434f.setVisibility(8);
        if (unevaluatedViewModel.answers != null && unevaluatedViewModel.answers.length >= 2) {
            String str = unevaluatedViewModel.answers[0];
            String str2 = unevaluatedViewModel.answers[1];
            this.f15431c.setText(str);
            this.f15433e.setText(str2);
        }
    }

    public void showLoading() {
        this.f15438j.setVisibility(0);
    }

    public void hideLoading() {
        this.f15438j.setVisibility(8);
    }

    public void showError() {
        this.f15430b.setVisibility(8);
        this.f15432d.setVisibility(8);
        this.f15437i.setVisibility(0);
    }

    public void hideError() {
        this.f15437i.setVisibility(8);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.rl_global_evaluate_pos_layout) {
            this.f15440l = 0;
            this.f15441n.onEvaluatedClicked(0);
        } else if (id == R.id.rl_global_evaluate_neg_layout) {
            this.f15440l = 1;
            this.f15441n.onEvaluatedClicked(1);
        } else if (id == R.id.rl_global_evaluated_layout) {
            this.f15440l = -1;
            this.f15441n.onEvaluatedClicked(-1);
        } else if (id == R.id.global_evaluate_question_error_layout) {
            hideError();
            this.f15441n.onEvaluatedClicked(this.f15440l);
        }
    }
}
