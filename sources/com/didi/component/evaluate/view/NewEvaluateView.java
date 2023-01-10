package com.didi.component.evaluate.view;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.ImageUtils;
import com.didi.component.business.util.SourceUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.widget.loading.OnRetryListener;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluate.EvaluateRootContainer;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.view.TipInputPopWindow;
import com.didi.component.evaluate.view.widget.AbsBaseTagLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagImageLayout;
import com.didi.component.evaluate.view.widget.EvaluateTagTextLayout;
import com.didi.component.evaluate.view.widget.FiveStarEvaluatedView;
import com.didi.component.evaluate.view.widget.NewEvaluateTipsView;
import com.didi.component.evaluate.view.widget.NewFiveStarEvaluatedView;
import com.didi.component.evaluate.widget.KeyboardHeightProvider;
import com.didi.component.evaluate.widget.NewCommentView;
import com.didi.trackupload.sdk.Constants;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.google.android.flexbox.FlexboxLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewEvaluateView extends AbsNewEvaluateView implements EvaluateRootContainer.OnTouchWhenInterceptListener, IEvaluateView, FiveStarEvaluatedView.OnStarListener {

    /* renamed from: a */
    private static final int f15191a = 11;

    /* renamed from: b */
    private static final int f15192b = 6;

    /* renamed from: c */
    private static final int f15193c = 7;

    /* renamed from: d */
    private static final float[] f15194d = {100.0f, 90.0f, 80.0f, 90.0f, 160.0f, 182.0f, 119.0f};

    /* renamed from: e */
    private static final int f15195e = 228;

    /* renamed from: A */
    private List<CarNoEvaluateData.CarEvaluateTag> f15196A;

    /* renamed from: B */
    private CarNoEvaluateData.CarEvaluateTag f15197B;

    /* renamed from: C */
    private IEvaluateView.EvaluateListener f15198C;

    /* renamed from: D */
    private boolean f15199D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public ScrollView f15200E;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public ViewTreeObserver.OnDrawListener f15201F;

    /* renamed from: G */
    private KeyboardHeightProvider f15202G;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public String f15203H = "";

    /* renamed from: I */
    private NewEvaluateScrollView f15204I;

    /* renamed from: J */
    private FrameLayout f15205J;
    /* access modifiers changed from: private */

    /* renamed from: K */
    public RelativeLayout f15206K;

    /* renamed from: L */
    private int f15207L;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Context f15208f;

    /* renamed from: g */
    private ImageView f15209g;

    /* renamed from: h */
    private TextView f15210h;

    /* renamed from: i */
    private View f15211i;

    /* renamed from: j */
    private ImageView f15212j;

    /* renamed from: k */
    private NewFiveStarEvaluatedView f15213k;

    /* renamed from: l */
    private ImageView f15214l;

    /* renamed from: m */
    private FlexboxLayout f15215m;
    protected NewCommentView mCommentView;
    protected EvaluateRootContainer mEvaluateRoot;
    protected KeyboardHeightProvider.KeyboardHeightObserver mHeightObserver = new KeyboardHeightProvider.KeyboardHeightObserver() {
        public void onKeyboardHeightChanged(int i, int i2) {
            if (NewEvaluateView.this.mCommentView != null) {
                boolean z = i > 0;
                NewEvaluateView.this.mCommentView.onKeyboardHeightChange(i);
                if (z) {
                    int bottom = i - NewEvaluateView.this.mCommentView.getBottom();
                    if (bottom > 0) {
                        NewEvaluateView.this.mCommentView.setPadding(0, 0, 0, bottom + 200);
                        if (bottom - UiUtils.getViewLocation(NewEvaluateView.this.mEvaluateRoot)[1] > 0) {
                            ViewTreeObserver.OnDrawListener unused = NewEvaluateView.this.f15201F = new ViewTreeObserver.OnDrawListener() {
                                public void onDraw() {
                                    NewEvaluateView.this.mCommentView.post(new Runnable() {
                                        public void run() {
                                            NewEvaluateView.this.f15200E.scrollTo(0, 10000);
                                            NewEvaluateView.this.f15200E.setOnTouchListener(new View.OnTouchListener() {
                                                public boolean onTouch(View view, MotionEvent motionEvent) {
                                                    NewEvaluateView.this.mCommentView.hideSoftInput();
                                                    return false;
                                                }
                                            });
                                            NewEvaluateView.this.mCommentView.getViewTreeObserver().removeOnDrawListener(NewEvaluateView.this.f15201F);
                                        }
                                    });
                                }
                            };
                            NewEvaluateView.this.mCommentView.getViewTreeObserver().addOnDrawListener(NewEvaluateView.this.f15201F);
                        }
                    }
                } else if (NewEvaluateView.this.mCommentView.getPaddingBottom() > 0) {
                    NewEvaluateView.this.mCommentView.setPadding(0, 0, 0, 0);
                    NewEvaluateView.this.f15200E.setOnTouchListener(new View.OnTouchListener() {
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            return false;
                        }
                    });
                    NewEvaluateView.this.clearCommentViewFocus();
                }
            }
        }
    };
    protected IEvaluateView.OnCloseListener mOnCloseListener;

    /* renamed from: n */
    private RelativeLayout f15216n;

    /* renamed from: o */
    private RelativeLayout f15217o;

    /* renamed from: p */
    private RelativeLayout f15218p;

    /* renamed from: q */
    private ImageView f15219q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public TextView f15220r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public TextView f15221s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public LinearLayout f15222t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public TextView f15223u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public TextView f15224v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public LinearLayout f15225w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public View f15226x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public PopupWindow f15227y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public ImageView f15228z;

    private interface AnimateFinishListener {
        void onFinish();
    }

    private interface SubmitSuccessListener {
        void onSuccess();
    }

    public void hideLoading() {
    }

    public void initIsInFiveStar(boolean z) {
    }

    public void onAdd() {
    }

    public void onTouchWhenIntercept() {
    }

    public void setCardTitle(String str) {
    }

    public void setCommentAreaVisibility(boolean z) {
    }

    public void setCommentContent(String str) {
    }

    public void setDefaultDriverIcon(int i) {
    }

    public void setOnCancelListener(IEvaluateView.OnCancelListener onCancelListener) {
    }

    public void setOnRetryListener(OnRetryListener onRetryListener) {
    }

    public void setSymbol(String str) {
    }

    public void setTagTitle(String str, String str2) {
    }

    public void setTags(List<EvaluateTag> list) {
    }

    public void showHeader() {
    }

    public void showLoading() {
    }

    public void showLoadingFail(boolean z) {
    }

    public NewEvaluateView(Context context, int i) {
        this.f15208f = context;
        this.f15207L = i;
        this.mRootView = LayoutInflater.from(context).inflate(i == 1 ? R.layout.g_xp_evaluate_layout : R.layout.global_new_evaluate_layout, (ViewGroup) null);
        m12530a();
    }

    /* renamed from: a */
    private void m12530a() {
        this.f15209g = (ImageView) this.mRootView.findViewById(R.id.driver_image);
        this.f15210h = (TextView) this.mRootView.findViewById(R.id.evalute_refine_guide);
        this.f15211i = this.mRootView.findViewById(R.id.evalute_refine_guide_loading);
        this.f15213k = (NewFiveStarEvaluatedView) this.mRootView.findViewById(R.id.five_star_view);
        this.f15214l = (ImageView) this.mRootView.findViewById(R.id.five_star_mask);
        this.f15213k.setMargin(11);
        this.f15213k.setOnStarListener(this);
        this.f15215m = (FlexboxLayout) this.mRootView.findViewById(R.id.evaluate_tag_layout);
        this.f15222t = (LinearLayout) this.mRootView.findViewById(R.id.evaluate_tips_layout);
        this.f15205J = (FrameLayout) this.mRootView.findViewById(R.id.tip_container_fl);
        this.f15223u = (TextView) this.mRootView.findViewById(R.id.evaluate_tips_title);
        this.f15224v = (TextView) this.mRootView.findViewById(R.id.evaluate_tips_sub_title);
        this.f15206K = (RelativeLayout) this.mRootView.findViewById(R.id.tip_title_ll);
        this.f15228z = (ImageView) this.mRootView.findViewById(R.id.tip_edit_icon);
        this.f15225w = (LinearLayout) this.mRootView.findViewById(R.id.tips_container);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.close_button);
        this.f15212j = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewEvaluateView.this.close();
            }
        });
        this.f15216n = (RelativeLayout) this.mRootView.findViewById(R.id.load_layout);
        this.f15217o = (RelativeLayout) this.mRootView.findViewById(R.id.load_ing_icon_layout);
        this.f15218p = (RelativeLayout) this.mRootView.findViewById(R.id.load_success_icon_layout);
        this.f15219q = (ImageView) this.mRootView.findViewById(R.id.load_icon);
        this.f15220r = (TextView) this.mRootView.findViewById(R.id.load_text);
        this.f15226x = this.mRootView.findViewById(R.id.tips_bg);
        TextView textView = (TextView) this.mRootView.findViewById(R.id.submit_btn);
        this.f15221s = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewEvaluateView.this.submit();
            }
        });
        this.f15221s.setEnabled(false);
        this.f15200E = (ScrollView) this.mRootView.findViewById(R.id.evaluate_comment_scroll_view);
        this.mEvaluateRoot = (EvaluateRootContainer) this.mRootView.findViewById(R.id.global_evaluate);
        NewCommentView newCommentView = (NewCommentView) this.mRootView.findViewById(R.id.new_evaluate_comment_view);
        this.mCommentView = newCommentView;
        newCommentView.setEnabled(false);
        this.mEvaluateRoot.setCanTouchView(R.id.oc_evaluate_comment_view);
        NewEvaluateScrollView newEvaluateScrollView = (NewEvaluateScrollView) this.mRootView.findViewById(R.id.evaluate_tag_scroll_view);
        this.f15204I = newEvaluateScrollView;
        newEvaluateScrollView.setMaxHeight(UIUtils.dip2pxInt(this.f15208f, 228.0f));
        m12540b();
        startKeyboardHeightDetector();
    }

    /* access modifiers changed from: protected */
    public void submit() {
        String str;
        if (this.f15198C != null) {
            NewCommentView newCommentView = this.mCommentView;
            if (newCommentView != null) {
                str = newCommentView.getText();
            } else {
                str = "";
            }
            LinearLayout linearLayout = this.f15225w;
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                int i = 0;
                while (true) {
                    if (i >= this.f15225w.getChildCount()) {
                        break;
                    }
                    View childAt = this.f15225w.getChildAt(i);
                    if (childAt instanceof NewEvaluateTipsView) {
                        double tips = ((NewEvaluateTipsView) childAt).getTips();
                        if (childAt.isSelected() && tips > 0.0d) {
                            this.f15203H = tips + "";
                            break;
                        }
                    }
                    i++;
                }
            }
            this.f15198C.onSubmit(m12550e(), str, this.f15203H);
            showLoadingView();
            m12538a(str, m12550e(), this.f15203H);
        }
    }

    /* renamed from: a */
    private void m12538a(String str, List<EvaluateTag> list, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("rate", Integer.valueOf(this.f15213k.getCurrentStar()));
        String str3 = "";
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                str3 = str3 + list.get(i).getText();
                if (i < list.size() - 1) {
                    str3 = str3 + ";";
                }
            }
        }
        hashMap.put("tag", str3);
        hashMap.put("comment", str);
        hashMap.put("tip", str2);
        hashMap.put("source", Integer.valueOf(SourceUtils.getSource()));
        GlobalOmegaUtils.trackEvent("pas_starratecard_submit_ck", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m12540b() {
        HashMap hashMap = new HashMap();
        hashMap.put("source", Integer.valueOf(SourceUtils.getSource()));
        GlobalOmegaUtils.trackEvent("pas_starratecard_detail_sw", (Map<String, Object>) hashMap);
    }

    public void onRemove() {
        KeyboardHeightProvider keyboardHeightProvider = this.f15202G;
        if (keyboardHeightProvider != null) {
            keyboardHeightProvider.close();
        }
    }

    public void setLevel(int i) {
        NewFiveStarEvaluatedView newFiveStarEvaluatedView = this.f15213k;
        if (newFiveStarEvaluatedView != null) {
            newFiveStarEvaluatedView.setVisibility(0);
            this.f15213k.showEvaluated(i);
            m12545c(i);
        }
    }

    public void setDriverIconAndName(String str, String str2) {
        if (this.f15209g != null && !TextUtils.isEmpty(str)) {
            ImageUtils.glideLoad(this.f15209g.getContext(), str, this.f15209g);
        }
    }

    public void setCarEvaluateTags(List<CarNoEvaluateData.CarEvaluateTag> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        this.f15196A = arrayList;
        arrayList.addAll(list);
        onStarChanged(this.f15213k.getCurrentStar());
        hideLoadingView();
    }

    public void setRefineGuide(String str) {
        if (this.f15210h != null && !TextUtils.isEmpty(str)) {
            this.f15210h.setVisibility(0);
            this.f15211i.setVisibility(8);
            this.f15210h.setText(str);
        }
    }

    public void refreshThanksTipData(final CarTipInfo carTipInfo) {
        if (carTipInfo == null) {
            this.f15222t.setVisibility(8);
        } else if (!carTipInfo.isShow() || carTipInfo.feeItems == null || carTipInfo.feeItems.length <= 0) {
            this.f15222t.setVisibility(8);
        } else {
            this.f15222t.setVisibility(0);
            if (!carTipInfo.isPay()) {
                this.f15205J.setVisibility(0);
                this.f15225w.removeAllViews();
                this.f15222t.post(new Runnable() {
                    public void run() {
                        if (!carTipInfo.title.isEmpty() || !carTipInfo.tipSubTitle.isEmpty()) {
                            NewEvaluateView.this.f15206K.setVisibility(0);
                            if (!TextUtils.isEmpty(carTipInfo.title)) {
                                NewEvaluateView.this.f15223u.setVisibility(0);
                                NewEvaluateView.this.f15223u.setText(carTipInfo.title);
                            } else {
                                NewEvaluateView.this.f15223u.setVisibility(8);
                            }
                            if (!carTipInfo.tipSubTitle.isEmpty()) {
                                NewEvaluateView.this.f15224v.setVisibility(0);
                                NewEvaluateView.this.f15224v.setText(carTipInfo.tipSubTitle);
                            } else {
                                NewEvaluateView.this.f15224v.setVisibility(8);
                            }
                        } else {
                            NewEvaluateView.this.f15206K.setVisibility(8);
                        }
                        int width = NewEvaluateView.this.f15222t.getWidth() / carTipInfo.feeItems.length;
                        ((FrameLayout.LayoutParams) NewEvaluateView.this.f15226x.getLayoutParams()).width = width;
                        for (int i = 0; i < carTipInfo.feeItems.length; i++) {
                            CarTipInfo.FeeItem feeItem = carTipInfo.feeItems[i];
                            NewEvaluateTipsView newEvaluateTipsView = new NewEvaluateTipsView(NewEvaluateView.this.f15208f);
                            if (!carTipInfo.isShowCustomizeTip() || i != carTipInfo.feeItems.length - 1) {
                                newEvaluateTipsView.setCurrency(feeItem.currency);
                            } else if (feeItem.tipString.isEmpty()) {
                                feeItem.tipString = NewEvaluateView.this.f15208f.getString(R.string.GRider_starratePage_tip_options_other);
                            }
                            newEvaluateTipsView.setTips(feeItem.tipString, feeItem.tipNum);
                            NewEvaluateView.this.f15225w.addView(newEvaluateTipsView);
                            newEvaluateTipsView.setWidth(width);
                            newEvaluateTipsView.setIndex(i);
                            if (i == 0) {
                                newEvaluateTipsView.setLineVisibility(8);
                            } else {
                                newEvaluateTipsView.setLineVisibility(0);
                            }
                            newEvaluateTipsView.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View view) {
                                    final View view2 = view;
                                    AutoTrackHelper.trackViewOnClick(view);
                                    NewEvaluateTipsView newEvaluateTipsView = (NewEvaluateTipsView) view2;
                                    int index = newEvaluateTipsView.getIndex();
                                    if (view.isSelected()) {
                                        if (NewEvaluateView.this.f15226x.getTag() != null) {
                                            NewEvaluateView.this.m12541b(((Integer) NewEvaluateView.this.f15226x.getTag()).intValue());
                                        }
                                        NewEvaluateView.this.f15226x.setVisibility(8);
                                        view2.setSelected(false);
                                        String unused = NewEvaluateView.this.f15203H = "";
                                        NewEvaluateView.this.m12535a(NewEvaluateView.this.f15221s, NewEvaluateView.this.f15208f.getString(R.string.global_new_evaluate_submit), 100);
                                        return;
                                    }
                                    if (NewEvaluateView.this.f15226x.getVisibility() == 0) {
                                        for (int i = 0; i < NewEvaluateView.this.f15225w.getChildCount(); i++) {
                                            View childAt = NewEvaluateView.this.f15225w.getChildAt(i);
                                            if ((childAt instanceof NewEvaluateTipsView) && childAt.isSelected()) {
                                                childAt.setSelected(false);
                                            }
                                        }
                                        if (NewEvaluateView.this.f15226x.getTag() != null) {
                                            NewEvaluateView.this.m12541b(((Integer) NewEvaluateView.this.f15226x.getTag()).intValue());
                                        }
                                    }
                                    if (carTipInfo.isShowCustomizeTip() && index == carTipInfo.feeItems.length - 1) {
                                        View inflate = LayoutInflater.from(NewEvaluateView.this.f15208f).inflate(R.layout.global_new_evaluate_custom_tip, (ViewGroup) null);
                                        double tips = newEvaluateTipsView.getTips();
                                        String tipText = newEvaluateTipsView.getTipText();
                                        new TipInputPopWindow(inflate, -1, -1, NewEvaluateView.this.f15208f, carTipInfo, tips, tipText, new TipInputPopWindow.ConfirmButtonClickListener() {
                                            public void confirmClick(String str, Double d) {
                                                if (!str.isEmpty()) {
                                                    NewEvaluateView newEvaluateView = NewEvaluateView.this;
                                                    String unused = newEvaluateView.f15203H = d + "";
                                                    NewEvaluateView.this.f15226x.setX(view2.getX());
                                                    ((NewEvaluateTipsView) view2).setTips(str, d.doubleValue());
                                                    ((NewEvaluateTipsView) view2).setCurrency(carTipInfo.currency);
                                                    view2.setSelected(true);
                                                    NewEvaluateView.this.f15228z.setVisibility(0);
                                                    NewEvaluateView.this.m12535a(NewEvaluateView.this.f15221s, NewEvaluateView.this.f15208f.getString(R.string.global_new_evaluate_submit_with_tips), 100);
                                                    return;
                                                }
                                                NewEvaluateView.this.f15226x.setX(view2.getX());
                                                view2.setSelected(true);
                                            }
                                        }).show();
                                        HashMap hashMap = new HashMap();
                                        hashMap.put("source", "starratedetail");
                                        if (tips == 0.0d) {
                                            hashMap.put("type", "0");
                                        } else {
                                            hashMap.put("type", "1");
                                        }
                                        GlobalOmegaUtils.trackEvent("ibt_gp_starratecard_detai_tipmount_ck", (Map<String, Object>) hashMap);
                                    }
                                    NewEvaluateView.this.f15226x.setX(view.getX());
                                    view2.setSelected(true);
                                    double tips2 = newEvaluateTipsView.getTips();
                                    NewEvaluateView newEvaluateView = NewEvaluateView.this;
                                    String unused2 = newEvaluateView.f15203H = tips2 + "";
                                    NewEvaluateView.this.m12531a(index);
                                    NewEvaluateView.this.f15226x.setTag(Integer.valueOf(index));
                                    if (!(NewEvaluateView.this.f15203H == null || NewEvaluateView.this.f15203H.isEmpty() || tips2 == 0.0d)) {
                                        NewEvaluateView.this.m12535a(NewEvaluateView.this.f15221s, NewEvaluateView.this.f15208f.getString(R.string.global_new_evaluate_submit_with_tips), 100);
                                    }
                                    NewEvaluateView.this.f15226x.setVisibility(0);
                                }
                            });
                        }
                    }
                });
                return;
            }
            this.f15205J.setVisibility(8);
            if (!TextUtils.isEmpty(carTipInfo.title)) {
                this.f15223u.setText(carTipInfo.title);
            }
            if (!carTipInfo.tipSubTitle.isEmpty()) {
                this.f15224v.setVisibility(0);
                this.f15224v.setText(carTipInfo.tipSubTitle);
                return;
            }
            this.f15224v.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12531a(int i) {
        if (i < this.f15225w.getChildCount()) {
            ((NewEvaluateTipsView) this.f15225w.getChildAt(i)).setLineVisibility(8);
        }
        int i2 = i + 1;
        if (i2 < this.f15225w.getChildCount()) {
            ((NewEvaluateTipsView) this.f15225w.getChildAt(i2)).setLineVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12541b(int i) {
        if (i != 0 && i < this.f15225w.getChildCount()) {
            ((NewEvaluateTipsView) this.f15225w.getChildAt(i)).setLineVisibility(0);
        }
        int i2 = i + 1;
        if (i2 < this.f15225w.getChildCount()) {
            ((NewEvaluateTipsView) this.f15225w.getChildAt(i2)).setLineVisibility(0);
        }
    }

    /* renamed from: a */
    private void m12533a(final View view, final float f, final AnimateFinishListener animateFinishListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(view.getX(), f, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
                View view = view;
                view.layout((int) f, view.getTop(), ((int) f) + view.getWidth(), view.getBottom());
                AnimateFinishListener animateFinishListener = animateFinishListener;
                if (animateFinishListener != null) {
                    animateFinishListener.onFinish();
                }
            }
        });
        view.startAnimation(translateAnimation);
    }

    /* renamed from: a */
    private void m12532a(final View view, float f, float f2) {
        view.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(f, f2, 0.0f, 0.0f);
        translateAnimation.setDuration(1000);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }
        });
        view.startAnimation(translateAnimation);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12535a(final TextView textView, String str, int i) {
        String charSequence = textView.getText().toString();
        if (!charSequence.endsWith(str)) {
            int abs = Math.abs(charSequence.length() - str.length());
            int i2 = i / abs;
            if (charSequence.length() > str.length()) {
                int i3 = 0;
                while (i3 <= abs) {
                    final String substring = charSequence.substring(0, charSequence.length() - i3);
                    i3++;
                    textView.postDelayed(new Runnable() {
                        public void run() {
                            textView.setText(substring);
                        }
                    }, (long) (i2 * i3));
                }
            } else if (charSequence.length() < str.length()) {
                int i4 = 0;
                while (i4 <= abs) {
                    final String substring2 = str.substring(0, charSequence.length() + i4);
                    i4++;
                    textView.postDelayed(new Runnable() {
                        public void run() {
                            textView.setText(substring2);
                        }
                    }, (long) (i2 * i4));
                }
            }
        }
    }

    public void setEvaluateListener(IEvaluateView.EvaluateListener evaluateListener) {
        this.f15198C = evaluateListener;
    }

    public void showSubmitSuccess() {
        if (TextUtils.isEmpty(this.f15203H)) {
            m12534a((View) this.f15217o, (View) this.f15218p, (SubmitSuccessListener) new SubmitSuccessListener() {
                public void onSuccess() {
                    NewEvaluateView.this.f15220r.setVisibility(0);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public void run() {
                            if (NewEvaluateView.this.mOnCloseListener != null) {
                                NewEvaluateView.this.mOnCloseListener.onCloseWithOutOmega();
                            }
                        }
                    }, Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
                }
            });
            return;
        }
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onCloseWithOutOmega();
        }
    }

    public void showSubmitFail() {
        hideLoadingView();
    }

    public void showLoadingView() {
        this.f15216n.setVisibility(0);
        this.f15221s.setVisibility(8);
        this.f15220r.setVisibility(8);
        m12544c();
    }

    public void hideLoadingView() {
        this.f15216n.setVisibility(8);
        this.f15221s.setVisibility(0);
    }

    /* renamed from: c */
    private void m12544c() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setStartOffset(10);
        this.f15219q.setAnimation(rotateAnimation);
    }

    public void setOnCloseListener(IEvaluateView.OnCloseListener onCloseListener) {
        this.mOnCloseListener = onCloseListener;
    }

    public void close() {
        NewCommentView newCommentView;
        NewCommentView newCommentView2 = this.mCommentView;
        if (newCommentView2 != null && newCommentView2.isFocused()) {
            this.mCommentView.clearFocus();
        } else if (m12550e().size() > 0 || ((newCommentView = this.mCommentView) != null && !TextUtils.isEmpty(newCommentView.getText()))) {
            showBackDialog(true);
        } else {
            IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
            if (onCloseListener != null) {
                onCloseListener.onClose();
            }
        }
    }

    public void closeWithoutOmega() {
        NewCommentView newCommentView;
        if (m12550e().size() > 0 || ((newCommentView = this.mCommentView) != null && !TextUtils.isEmpty(newCommentView.getText()))) {
            showBackDialog(false);
            return;
        }
        IEvaluateView.OnCloseListener onCloseListener = this.mOnCloseListener;
        if (onCloseListener != null) {
            onCloseListener.onCloseWithOutOmega();
        }
    }

    public void onResume() {
        this.f15202G.setKeyboardHeightObserver(this.mHeightObserver);
    }

    public void onPause() {
        this.f15202G.setKeyboardHeightObserver((KeyboardHeightProvider.KeyboardHeightObserver) null);
    }

    public View getView() {
        return this.mRootView;
    }

    public void setPresenter(IPresenter iPresenter) {
        this.mAbsEvaluatePresenter = (AbsCommonEvaluatePresenter) iPresenter;
    }

    public void onStarChanged(int i) {
        this.mAbsEvaluatePresenter.setOrderLevel(i);
        List<CarNoEvaluateData.CarEvaluateTag> list = this.f15196A;
        if (list != null) {
            for (CarNoEvaluateData.CarEvaluateTag next : list) {
                if (next.level == i) {
                    this.f15197B = next;
                    m12547d();
                }
            }
        }
        m12548d(i);
        if (i == 5) {
            m12532a((View) this.f15214l, this.f15213k.getX() - ((float) this.f15214l.getWidth()), this.f15213k.getX() + ((float) this.f15213k.getWidth()));
        }
    }

    /* renamed from: c */
    private void m12545c(int i) {
        AbsBaseTagLayout absBaseTagLayout;
        this.f15215m.removeAllViews();
        int i2 = i >= 5 ? 6 : 7;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i == 5) {
                absBaseTagLayout = new EvaluateTagImageLayout(this.f15208f);
                if ((i3 + 1) % 3 == 0) {
                    absBaseTagLayout.setMarginRight(0);
                }
            } else {
                absBaseTagLayout = new EvaluateTagTextLayout(this.f15208f);
                absBaseTagLayout.setLoadingWidth(UIUtils.dip2pxInt(this.f15208f, f15194d[i3]));
            }
            absBaseTagLayout.setLoading(true);
            this.f15215m.addView(absBaseTagLayout);
        }
    }

    /* renamed from: d */
    private void m12547d() {
        AbsBaseTagLayout absBaseTagLayout;
        this.f15199D = true;
        setRefineGuide(this.f15197B.refine_guide);
        this.f15215m.removeAllViews();
        for (int i = 0; i < this.f15197B.tag_list.size(); i++) {
            CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl = this.f15197B.tag_list.get(i);
            if (this.f15197B.level == 5) {
                absBaseTagLayout = new EvaluateTagImageLayout(this.f15208f);
            } else {
                absBaseTagLayout = new EvaluateTagTextLayout(this.f15208f);
                absBaseTagLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (NewEvaluateView.this.m12550e().size() > 0 || !TextUtils.isEmpty(NewEvaluateView.this.mCommentView.getText())) {
                            NewEvaluateView.this.f15221s.setEnabled(true);
                        } else {
                            NewEvaluateView.this.f15221s.setEnabled(false);
                        }
                    }
                });
            }
            absBaseTagLayout.setTagModel(evaluateTagImpl);
            this.f15215m.addView(absBaseTagLayout);
        }
        m12548d(this.f15197B.level);
        this.mCommentView.setEnabled(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public List<EvaluateTag> m12550e() {
        CarNoEvaluateData.EvaluateTagImpl tagModel;
        ArrayList arrayList = new ArrayList();
        if (this.f15215m != null) {
            for (int i = 0; i < this.f15215m.getChildCount(); i++) {
                View childAt = this.f15215m.getChildAt(i);
                if (childAt instanceof AbsBaseTagLayout) {
                    AbsBaseTagLayout absBaseTagLayout = (AbsBaseTagLayout) childAt;
                    if (absBaseTagLayout.isSelected() && (tagModel = absBaseTagLayout.getTagModel()) != null) {
                        arrayList.add(new EvaluateTag(tagModel.getText(), tagModel.getId(), tagModel.getIcon()));
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: d */
    private void m12548d(int i) {
        if (i < 5 || !this.f15199D) {
            this.f15221s.setEnabled(false);
        } else {
            this.f15221s.setEnabled(true);
        }
    }

    /* renamed from: a */
    private void m12534a(final View view, final View view2, final SubmitSuccessListener submitSuccessListener) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
                view2.setVisibility(0);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(300);
                scaleAnimation.setFillAfter(true);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        if (submitSuccessListener != null) {
                            submitSuccessListener.onSuccess();
                        }
                    }
                });
                view2.startAnimation(scaleAnimation);
            }
        });
        view.startAnimation(scaleAnimation);
    }

    public void showBackDialog(final boolean z) {
        PopupWindow popupWindow = this.f15227y;
        if (popupWindow == null || !popupWindow.isShowing()) {
            int windowHeight = this.f15208f.getApplicationInfo().targetSdkVersion >= 22 ? -1 : UiUtils.getWindowHeight((Activity) this.mRootView.getContext());
            View inflate = LayoutInflater.from(getView().getContext()).inflate(R.layout.global_new_evaluate_close_dialog_layout, (ViewGroup) null);
            PopupWindow popupWindow2 = new PopupWindow(inflate, -1, windowHeight);
            this.f15227y = popupWindow2;
            popupWindow2.setSoftInputMode(16);
            this.f15227y.setOutsideTouchable(false);
            this.f15227y.setClippingEnabled(false);
            this.f15227y.setFocusable(true);
            int navigationBarHeight = UiUtils.getNavigationBarHeight(this.f15208f);
            if (this.f15207L == 1) {
                inflate.findViewById(R.id.ll_g_close_dialog_container).setBackgroundResource(R.drawable.g_xp_evaluate_background);
            }
            ((TextView) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    NewEvaluateView.this.f15227y.dismiss();
                }
            });
            ((TextView) inflate.findViewById(R.id.ok_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    NewEvaluateView.this.f15227y.dismiss();
                    if (NewEvaluateView.this.mOnCloseListener == null) {
                        return;
                    }
                    if (z) {
                        NewEvaluateView.this.mOnCloseListener.onClose();
                    } else {
                        NewEvaluateView.this.mOnCloseListener.onCloseWithOutOmega();
                    }
                }
            });
            this.f15227y.showAtLocation(this.mRootView, 80, 0, navigationBarHeight);
        }
    }

    /* access modifiers changed from: protected */
    public void clearCommentViewFocus() {
        NewCommentView newCommentView = this.mCommentView;
        if (newCommentView != null && newCommentView.isFocused()) {
            this.mCommentView.clearFocus();
        }
    }

    /* access modifiers changed from: protected */
    public void startKeyboardHeightDetector() {
        KeyboardHeightProvider keyboardHeightProvider = new KeyboardHeightProvider((Activity) this.f15208f);
        this.f15202G = keyboardHeightProvider;
        keyboardHeightProvider.start();
    }

    public int getStyle() {
        return this.f15207L;
    }
}
