package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionItemModel;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionModel;
import com.didi.component.evaluateentrance.evaluate.toolkit.QuestionItemAnimator;
import com.didi.component.evaluateentrance.evaluate.toolkit.ViewToolKit;
import com.didi.component.evaluateentrance.evaluate.view.EvaluateQuestionItemAdapter;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EvaluateQuestionView extends AbsEvaluateQuestionView {

    /* renamed from: a */
    private static final int f15356a = 1;

    /* renamed from: b */
    private static final int f15357b = 3;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewToolKit f15358c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecyclerView f15359d;

    /* renamed from: e */
    private EvaluateQuestionItemAdapter f15360e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f15361f;

    /* renamed from: g */
    private FrameLayout f15362g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public GXPEvaluateTipPayDrawer f15363h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public EvaluateQuestionModel f15364i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f15365j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f15366k;

    /* renamed from: l */
    private LinearLayoutAnimator f15367l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f15368m = -1;

    public void hideLoading() {
    }

    public void showLoading() {
    }

    public EvaluateQuestionView(Context context) {
        super(context);
        this.parentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.g_xp_evaluate_question_layout, (ViewGroup) null);
        this.f15358c = ViewToolKit.create(this.parentView);
        m12659a((View) this.parentView);
    }

    /* renamed from: a */
    private void m12659a(View view) {
        this.f15362g = (FrameLayout) view.findViewById(R.id.fl_evaluate_question_container);
        this.f15359d = (RecyclerView) view.findViewById(R.id.g_xp_evaluate_question_recyclerView);
        this.f15367l = (LinearLayoutAnimator) view.findViewById(R.id.ll_evaluate_question_container);
        EvaluateQuestionItemAdapter evaluateQuestionItemAdapter = new EvaluateQuestionItemAdapter();
        this.f15360e = evaluateQuestionItemAdapter;
        this.f15359d.setAdapter(evaluateQuestionItemAdapter);
        this.f15359d.setNestedScrollingEnabled(false);
        QuestionItemAnimator questionItemAnimator = new QuestionItemAnimator();
        questionItemAnimator.setMoveDuration(400);
        questionItemAnimator.setAddDuration(400);
        questionItemAnimator.setRemoveDuration(400);
        this.f15359d.setItemAnimator(questionItemAnimator);
        View findViewById = view.findViewById(R.id.global_new_question_retry_view);
        this.f15361f = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EvaluateQuestionView.this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (int) R.string.GR_Feedback_2020_uploading);
                if (EvaluateQuestionView.this.presenter != null) {
                    EvaluateQuestionView.this.presenter.onEvaluatedClicked(EvaluateQuestionView.this.f15368m, EvaluateQuestionView.this.f15364i);
                }
                EvaluateQuestionView.this.f15361f.setVisibility(4);
                EvaluateQuestionView.this.f15359d.setVisibility(0);
            }
        });
        this.f15360e.setOnSelectedListener(new EvaluateQuestionItemAdapter.OnSelectedListener() {
            public void onSelected(int i) {
                int unused = EvaluateQuestionView.this.f15368m = i;
                if (EvaluateQuestionView.this.presenter != null) {
                    EvaluateQuestionView.this.presenter.onEvaluatedClicked(i, EvaluateQuestionView.this.f15364i);
                }
            }
        });
    }

    public void initData(final EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel == null || !evaluateQuestionModel.hasQuestionaireInfo) {
            getView().setVisibility(8);
            return;
        }
        this.f15367l.setEnableAnimator(false);
        closeDrawer();
        this.f15364i = evaluateQuestionModel;
        m12662b(evaluateQuestionModel);
        ViewGroup.LayoutParams layoutParams = this.f15362g.getLayoutParams();
        if (evaluateQuestionModel.isVertical) {
            layoutParams.width = -1;
            int dip2px = UiUtils.dip2px(this.context, 17.0f);
            this.f15362g.setPadding(dip2px, 0, dip2px, 0);
            this.f15362g.setLayoutParams(layoutParams);
            this.f15359d.setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        } else {
            layoutParams.width = -2;
            this.f15362g.setPadding(0, 0, 0, 0);
            this.f15362g.setLayoutParams(layoutParams);
            this.f15359d.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        }
        this.f15360e.setData(m12658a(evaluateQuestionModel), this.context, evaluateQuestionModel.isVertical);
        if (this.f15359d.getItemDecorationCount() == 0) {
            this.f15359d.addItemDecoration(new RecyclerView.ItemDecoration() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    if (!evaluateQuestionModel.isVertical) {
                        if (recyclerView.getAdapter().getItemCount() == 1) {
                            rect.setEmpty();
                            if (EvaluateQuestionView.this.f15365j == 0) {
                                if (recyclerView.getChildLayoutPosition(view) == 0) {
                                    rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                                    rect.right = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                                } else {
                                    rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 13.0f);
                                }
                            } else if (EvaluateQuestionView.this.f15366k) {
                                rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                                rect.right = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                            } else {
                                boolean unused = EvaluateQuestionView.this.f15366k = true;
                            }
                        } else if (recyclerView.getChildLayoutPosition(view) == 1) {
                            rect.setEmpty();
                            rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 16.0f);
                        }
                        rect.bottom = UiUtils.dip2px(EvaluateQuestionView.this.context, 30.0f);
                    } else if (recyclerView.getChildLayoutPosition(view) > 0) {
                        rect.setEmpty();
                        rect.top = UiUtils.dip2px(EvaluateQuestionView.this.context, 15.0f);
                    }
                }
            });
        }
        this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
        this.f15358c.setTextViewTextWithEmptyGone(R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
        final EvaluateTipView evaluateTipView = (EvaluateTipView) this.f15358c.findViewById(R.id.eve_tip);
        evaluateTipView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EvaluateQuestionView.this.f15363h == null) {
                    GXPEvaluateTipPayDrawer unused = EvaluateQuestionView.this.f15363h = new GXPEvaluateTipPayDrawer(evaluateTipView.getContext(), EvaluateQuestionView.this.presenter, evaluateQuestionModel.tipInfo, "question", evaluateQuestionModel.avatarIcon);
                }
                EvaluateQuestionView.this.f15363h.show();
                GlobalOmegaUtils.trackEvent("ibt_gp_tipentrance_btn_ck", "source", "question");
            }
        });
        evaluateTipView.initData(evaluateQuestionModel.tipInfo, "question");
    }

    public void showBeforeEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel != null && evaluateQuestionModel.style == 1) {
            ArrayList arrayList = new ArrayList();
            EvaluateQuestionItemModel evaluateQuestionItemModel = null;
            if (evaluateQuestionModel.questionOptions != null && evaluateQuestionModel.questionOptions.size() > i) {
                UnevaluatedViewModel.QuestionDataOption questionDataOption = evaluateQuestionModel.questionOptions.get(i);
                EvaluateQuestionItemModel a = m12655a(questionDataOption.iconUrl, questionDataOption.text, true);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (CharSequence) questionDataOption.title, evaluateQuestionModel.questionTitle);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, (CharSequence) questionDataOption.description, evaluateQuestionModel.questionBody);
                evaluateQuestionItemModel = a;
            } else if (evaluateQuestionModel.answers == null || evaluateQuestionModel.answers.length <= i) {
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
            } else {
                evaluateQuestionItemModel = m12655a("", evaluateQuestionModel.answers[i], false);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
            }
            if (evaluateQuestionItemModel != null) {
                arrayList.add(evaluateQuestionItemModel);
                if (evaluateQuestionModel.isVertical) {
                    this.f15360e.updateData(arrayList);
                    return;
                }
                this.f15367l.setEnableAnimator(true);
                this.f15365j = i;
                this.f15366k = false;
                this.f15360e.updateHorizontalData(i);
            }
        }
    }

    public void showAfterEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel.style == 1) {
            if (evaluateQuestionModel.questionOptions == null || evaluateQuestionModel.questionOptions.size() <= i) {
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
            } else {
                UnevaluatedViewModel.QuestionDataOption questionDataOption = evaluateQuestionModel.questionOptions.get(i);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (CharSequence) questionDataOption.title, evaluateQuestionModel.questionTitle);
                this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, (CharSequence) questionDataOption.description, evaluateQuestionModel.questionBody);
            }
        }
        getView().postDelayed(new Runnable() {
            public void run() {
                EvaluateQuestionView.this.presenter.refreshXpanel();
            }
        }, 1000);
    }

    public void showError() {
        this.f15361f.setVisibility(0);
        this.f15359d.setVisibility(4);
        this.f15358c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (int) R.string.GR_Feedback_2020_uploadFail);
    }

    public void hideError() {
        this.f15361f.setVisibility(8);
        this.f15359d.setVisibility(0);
    }

    /* renamed from: a */
    private List<EvaluateQuestionItemModel> m12658a(EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (evaluateQuestionModel.style == 0) {
            if (evaluateQuestionModel.questionOptions != null && evaluateQuestionModel.questionOptions.size() > 0) {
                for (UnevaluatedViewModel.QuestionDataOption next : evaluateQuestionModel.questionOptions) {
                    arrayList.add(m12655a(next.iconUrl, next.text, false));
                }
            } else if (evaluateQuestionModel.answers != null && evaluateQuestionModel.answers.length > 0 && evaluateQuestionModel.answerState != null && evaluateQuestionModel.answerState.length > 0) {
                for (String a : evaluateQuestionModel.answers) {
                    arrayList.add(m12655a("", a, false));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private EvaluateQuestionItemModel m12655a(String str, String str2, boolean z) {
        return new EvaluateQuestionItemModel(str, str2, z);
    }

    /* renamed from: b */
    private void m12662b(EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel == null) {
            return;
        }
        if ((evaluateQuestionModel.questionOptions != null && evaluateQuestionModel.questionOptions.size() >= 3) || (evaluateQuestionModel.answers != null && evaluateQuestionModel.answers.length >= 3)) {
            evaluateQuestionModel.isVertical = true;
        }
    }

    public void closeDrawer() {
        GXPEvaluateTipPayDrawer gXPEvaluateTipPayDrawer = this.f15363h;
        if (gXPEvaluateTipPayDrawer != null && gXPEvaluateTipPayDrawer.isShowing()) {
            this.f15363h.dismiss();
        }
    }
}
