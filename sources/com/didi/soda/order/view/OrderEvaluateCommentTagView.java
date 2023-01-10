package com.didi.soda.order.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.didi.nova.assembly.p128ui.flowlayout.NovaFlowLayout;
import com.didi.soda.bill.widgets.CustomerSelectableTagView;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationTagEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.view.OrderEvaluateScoreView;
import com.didi.soda.order.view.upload.pic.ImageUploadFlowLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderEvaluateCommentTagView extends LinearLayout {

    /* renamed from: b */
    private static final int f46132b = 1000;

    /* renamed from: c */
    private static final int f46133c = 4;

    /* renamed from: d */
    private static final String f46134d = "0/";

    /* renamed from: e */
    private static final String f46135e = "/";

    /* renamed from: a */
    OnClickTaglListener f46136a = null;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public NovaFlowLayout f46137f;

    /* renamed from: g */
    private EditText f46138g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f46139h;

    /* renamed from: i */
    private View f46140i;

    /* renamed from: j */
    private ViewGroup f46141j;

    /* renamed from: k */
    private ImageUploadFlowLayout f46142k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public List<OrderEvaluationTagEntity> f46143l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Set<Integer> f46144m = new HashSet();

    /* renamed from: n */
    private int f46145n = -1;

    /* renamed from: o */
    private Animator f46146o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public OnCommentChangeListener f46147p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public OnSubmitStatusListener f46148q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public OrderEvaluateScoreView.OnInterceptClickListener f46149r;

    public interface OnClickTaglListener {
        void onClickTag(int i);
    }

    public interface OnCommentChangeListener {
        void onCommentChange();
    }

    public interface OnSubmitStatusListener {
        void onStatusChange();
    }

    public OrderEvaluateCommentTagView(Context context) {
        super(context);
        m34276e();
    }

    public OrderEvaluateCommentTagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34276e();
    }

    public OrderEvaluateCommentTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34276e();
    }

    public boolean updateBusinessScore(int i) {
        int i2 = this.f46145n;
        if (i2 == -1) {
            this.f46145n = i;
            return true;
        } else if ((i2 != 4 || i >= 4) && (this.f46145n >= 4 || i != 4)) {
            return false;
        } else {
            this.f46145n = i;
            return true;
        }
    }

    public boolean updateRiderScore(int i) {
        if (this.f46145n == i) {
            return false;
        }
        this.f46145n = i;
        return true;
    }

    public void setPhotoLayoutVisible(int i) {
        this.f46142k.setVisibility(i);
    }

    public void setTagList(List<Integer> list, List<OrderEvaluationTagEntity> list2) {
        if (!CollectionsUtil.isEmpty(list2)) {
            this.f46143l = list2;
            this.f46137f.removeAllViews();
            ArrayList arrayList = new ArrayList();
            if (!CollectionsUtil.isEmpty(list)) {
                this.f46144m.addAll(list);
            }
            for (int i = 0; i < list2.size(); i++) {
                OrderEvaluationTagEntity orderEvaluationTagEntity = list2.get(i);
                if (orderEvaluationTagEntity != null && !TextUtils.isEmpty(orderEvaluationTagEntity.content)) {
                    CustomerSelectableTagView a = m34265a(orderEvaluationTagEntity);
                    a.setText(orderEvaluationTagEntity.content);
                    arrayList.add(a);
                }
            }
            this.f46137f.addView(arrayList);
            this.f46137f.setClickListener(new NovaFlowLayout.NovaFlowLayoutClickListener<CustomerSelectableTagView>() {
                public void onClick(int i, CustomerSelectableTagView customerSelectableTagView, CustomerSelectableTagView customerSelectableTagView2) {
                    if (OrderEvaluateCommentTagView.this.f46149r == null || !OrderEvaluateCommentTagView.this.f46149r.onInterceptTouch()) {
                        KeyboardUtils.hideSoftInput(OrderEvaluateCommentTagView.this.getContext(), customerSelectableTagView);
                        customerSelectableTagView.setSelected(!customerSelectableTagView.isSelected());
                        if (customerSelectableTagView.isSelected()) {
                            OrderEvaluateCommentTagView.this.f46144m.add(Integer.valueOf(((OrderEvaluationTagEntity) OrderEvaluateCommentTagView.this.f46143l.get(i)).tagId));
                            customerSelectableTagView.setFontType(IToolsService.FontType.MEDIUM);
                        } else {
                            OrderEvaluateCommentTagView.this.f46144m.remove(Integer.valueOf(((OrderEvaluationTagEntity) OrderEvaluateCommentTagView.this.f46143l.get(i)).tagId));
                            customerSelectableTagView.setFontType(IToolsService.FontType.LIGHT);
                        }
                        if (OrderEvaluateCommentTagView.this.f46147p != null) {
                            OrderEvaluateCommentTagView.this.f46147p.onCommentChange();
                        }
                        if (OrderEvaluateCommentTagView.this.f46148q != null) {
                            OrderEvaluateCommentTagView.this.f46148q.onStatusChange();
                        }
                        if (OrderEvaluateCommentTagView.this.f46136a != null) {
                            OrderEvaluateCommentTagView.this.f46136a.onClickTag(i);
                        }
                    }
                }
            });
            boolean z = this.f46137f.getVisibility() == 8;
            this.f46137f.setVisibility(0);
            if (this.f46140i.getVisibility() == 0 && z) {
                this.f46140i.setVisibility(8);
                setRootVisible();
            }
        } else if (this.f46140i.getVisibility() == 0 && this.f46137f.getVisibility() == 0) {
            m34270b();
        } else {
            m34272c();
            this.f46137f.setVisibility(8);
        }
    }

    public void setCommentHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f46138g.setHint(str);
        }
    }

    public String getCommentContent() {
        if (this.f46138g.getText() != null) {
            return this.f46138g.getText().toString();
        }
        return null;
    }

    public List<Integer> getChoiceTags() {
        int childCount = this.f46137f.getChildCount();
        ArrayList arrayList = new ArrayList();
        if (m34280g()) {
            for (int i = 0; i < childCount; i++) {
                if (this.f46137f.getChildAt(i).isSelected()) {
                    arrayList.add(Integer.valueOf(this.f46143l.get(i).tagId));
                }
            }
        }
        return arrayList;
    }

    public List<String> getImageList() {
        return this.f46142k.getImageUrlList();
    }

    public EditText getCommentView() {
        return this.f46138g;
    }

    public void setRootVisible() {
        this.f46141j.setVisibility(0);
        boolean z = this.f46140i.getVisibility() == 8;
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
            translateAnimation.setDuration(300);
            translateAnimation.setInterpolator(CustomerInterpolator.newInstance());
            this.f46140i.startAnimation(translateAnimation);
        }
        this.f46140i.setVisibility(0);
        if (z) {
            this.f46140i.post(new Runnable() {
                public void run() {
                    if (OrderEvaluateCommentTagView.this.f46137f.getVisibility() == 0) {
                        OrderEvaluateCommentTagView.this.m34267a();
                    } else {
                        OrderEvaluateCommentTagView.this.m34272c();
                    }
                }
            });
        }
    }

    public void setCommentChangeListener(OnCommentChangeListener onCommentChangeListener) {
        this.f46147p = onCommentChangeListener;
    }

    public void setOnStatusChangeListener(OnSubmitStatusListener onSubmitStatusListener) {
        this.f46148q = onSubmitStatusListener;
    }

    public void setOnInterceptClickListener(OrderEvaluateScoreView.OnInterceptClickListener onInterceptClickListener) {
        this.f46149r = onInterceptClickListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34267a() {
        m34274d();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px), 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f46137f, new PropertyValuesHolder[]{ofFloat2, ofFloat});
        ofPropertyValuesHolder.setDuration(400);
        ofPropertyValuesHolder.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ofPropertyValuesHolder.setStartDelay(100);
        ofPropertyValuesHolder.start();
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px), 0.0f});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(this.f46141j, new PropertyValuesHolder[]{ofFloat4, ofFloat3});
        ofPropertyValuesHolder2.setDuration(400);
        ofPropertyValuesHolder2.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        ofPropertyValuesHolder2.setStartDelay(200);
        ofPropertyValuesHolder2.start();
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ofPropertyValuesHolder);
        arrayList.add(ofPropertyValuesHolder2);
        animatorSet.playTogether(arrayList);
        animatorSet.start();
        this.f46146o = animatorSet;
    }

    /* renamed from: b */
    private void m34270b() {
        m34274d();
        this.f46141j.setAlpha(0.0f);
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) ResourceHelper.getDimensionPixelSize(R.dimen.customer_60px), 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f46141j, new PropertyValuesHolder[]{ofFloat2, ofFloat});
        ofPropertyValuesHolder.setDuration(300);
        ofPropertyValuesHolder.setStartDelay(100);
        this.f46137f.setVisibility(4);
        ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f46137f.getMeasuredHeight(), 0}).setDuration(300);
        duration.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                OrderEvaluateCommentTagView.this.f46137f.setVisibility(8);
                OrderEvaluateCommentTagView.this.f46137f.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                OrderEvaluateCommentTagView.this.f46137f.setPadding(0, 0, 0, ResourceHelper.getDimensionPixelSize(R.dimen.customer_24px));
            }
        });
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                OrderEvaluateCommentTagView.this.m34268a(valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(duration);
        arrayList.add(ofPropertyValuesHolder);
        animatorSet.setInterpolator(CustomerInterpolator.newInstance());
        animatorSet.playTogether(arrayList);
        animatorSet.start();
        this.f46146o = animatorSet;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34268a(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.f46137f.getLayoutParams();
        layoutParams.height = intValue;
        this.f46137f.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34272c() {
        m34274d();
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{(float) this.f46141j.getMeasuredHeight(), 0.0f});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f});
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f46141j, new PropertyValuesHolder[]{ofFloat2, ofFloat});
        ofPropertyValuesHolder.setDuration(300);
        ofPropertyValuesHolder.setInterpolator(new AccelerateInterpolator());
        ofPropertyValuesHolder.setStartDelay(100);
        ofPropertyValuesHolder.start();
        this.f46146o = ofPropertyValuesHolder;
    }

    /* renamed from: d */
    private void m34274d() {
        Animator animator = this.f46146o;
        if (animator != null) {
            animator.end();
        }
    }

    /* renamed from: e */
    private void m34276e() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_comment_tag, this, true);
        this.f46140i = inflate.findViewById(R.id.customer_ll_root_container);
        this.f46137f = (NovaFlowLayout) inflate.findViewById(R.id.customer_nfl_order_evaluating_tag);
        this.f46139h = (TextView) inflate.findViewById(R.id.customer_tv_word_num);
        this.f46138g = (EditText) inflate.findViewById(R.id.customer_et_comment);
        this.f46141j = (ViewGroup) inflate.findViewById(R.id.customer_cl_comment_container);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46138g, IToolsService.FontType.LIGHT);
        this.f46137f.setMaxRows(Integer.MAX_VALUE);
        this.f46139h.setText("0/1000");
        m34278f();
        this.f46142k = (ImageUploadFlowLayout) inflate.findViewById(R.id.customer_business_image_flow_layout);
    }

    public void setPhotoLayoutListener(ImageUploadFlowLayout.Companion.FlowLayoutListener flowLayoutListener) {
        this.f46142k.setPhotoLayoutListener(flowLayoutListener);
    }

    /* renamed from: f */
    private void m34278f() {
        this.f46138g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (OrderEvaluateCommentTagView.this.f46148q != null) {
                    OrderEvaluateCommentTagView.this.f46148q.onStatusChange();
                }
                if (editable != null) {
                    if (editable.length() >= 1000) {
                        TextView i = OrderEvaluateCommentTagView.this.f46139h;
                        i.setText(editable.length() + "/" + 1000);
                        OrderEvaluateCommentTagView.this.f46139h.setTextColor(ResourceHelper.getColor(R.color.rf_color_alert_red_100_FF4E45));
                    } else if (editable.length() == 0) {
                        OrderEvaluateCommentTagView.this.f46139h.setText("0/1000");
                        OrderEvaluateCommentTagView.this.f46139h.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_3_60_999999));
                    } else {
                        SpannableString spannableString = new SpannableString(String.valueOf(editable.length()));
                        spannableString.setSpan(new ForegroundColorSpan(OrderEvaluateCommentTagView.this.getResources().getColor(R.color.rf_color_gery_1_0_000000)), 0, spannableString.length(), 17);
                        SpannableString spannableString2 = new SpannableString("/1000");
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        spannableStringBuilder.append(spannableString);
                        spannableStringBuilder.append(spannableString2);
                        OrderEvaluateCommentTagView.this.f46139h.setText(spannableStringBuilder);
                        OrderEvaluateCommentTagView.this.f46139h.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_3_60_999999));
                    }
                    if (OrderEvaluateCommentTagView.this.f46147p != null) {
                        OrderEvaluateCommentTagView.this.f46147p.onCommentChange();
                        return;
                    }
                    return;
                }
                OrderEvaluateCommentTagView.this.f46139h.setText("0/1000");
                OrderEvaluateCommentTagView.this.f46139h.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_3_60_999999));
            }
        });
    }

    /* renamed from: a */
    private CustomerSelectableTagView m34265a(OrderEvaluationTagEntity orderEvaluationTagEntity) {
        if (orderEvaluationTagEntity == null || TextUtils.isEmpty(orderEvaluationTagEntity.content)) {
            return null;
        }
        CustomerSelectableTagView customerSelectableTagView = new CustomerSelectableTagView(getContext());
        customerSelectableTagView.setText(orderEvaluationTagEntity.content);
        customerSelectableTagView.setGravity(17);
        customerSelectableTagView.setTextSize(0, (float) getContext().getResources().getDimensionPixelSize(R.dimen.customer_24px));
        customerSelectableTagView.setSingleLine();
        customerSelectableTagView.setEllipsize(TextUtils.TruncateAt.END);
        customerSelectableTagView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        int dimensionPixelSize = ResourceHelper.getDimensionPixelSize(R.dimen.customer_18px);
        int dimensionPixelSize2 = ResourceHelper.getDimensionPixelSize(R.dimen.customer_24px);
        customerSelectableTagView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(customerSelectableTagView, IToolsService.FontType.LIGHT);
        if (this.f46144m.contains(Integer.valueOf(orderEvaluationTagEntity.tagId))) {
            customerSelectableTagView.setSelected(true);
        }
        return customerSelectableTagView;
    }

    /* renamed from: g */
    private boolean m34280g() {
        return this.f46137f.getVisibility() == 0;
    }

    public void addUploadImageView(String str, String str2) {
        this.f46142k.addImageLayout(str, str2);
    }

    public void setOnClickTagListener(OnClickTaglListener onClickTaglListener) {
        this.f46136a = onClickTaglListener;
    }
}
