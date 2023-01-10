package com.didi.soda.order.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationScoreInfoEntity;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.CustomerSeekBar;
import com.taxis99.R;
import java.util.List;

public class OrderEvaluateScoreView extends FrameLayout {
    public static final int MAX_STAR_COUNT = 3;

    /* renamed from: a */
    private TextView f46161a;

    /* renamed from: b */
    private CustomerSeekBar f46162b;

    /* renamed from: c */
    private int f46163c;

    /* renamed from: d */
    private List<OrderEvaluationScoreInfoEntity> f46164d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnStarClickListener f46165e;

    /* renamed from: f */
    private ScaleAnimation f46166f;

    /* renamed from: g */
    private int f46167g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnInterceptClickListener f46168h;

    public interface OnInterceptClickListener {
        boolean onInterceptTouch();
    }

    public interface OnStarClickListener {
        void onStarClick(int i);
    }

    public OrderEvaluateScoreView(Context context) {
        super(context);
        m34288a();
    }

    public OrderEvaluateScoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34288a();
    }

    public OrderEvaluateScoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34288a();
    }

    public void setScoreInfo(int i, List<OrderEvaluationScoreInfoEntity> list) {
        this.f46164d = list;
        if (i > 0 && i <= list.size()) {
            CustomerSeekBar customerSeekBar = this.f46162b;
            m34290a(customerSeekBar, i * customerSeekBar.getMinStep(), this.f46162b.getMaxProgress(), true);
        }
    }

    public int getScore() {
        return this.f46163c;
    }

    public void setOnStarClickListener(OnStarClickListener onStarClickListener) {
        this.f46165e = onStarClickListener;
    }

    public void setOnInterceptClickListener(OnInterceptClickListener onInterceptClickListener) {
        this.f46168h = onInterceptClickListener;
    }

    /* renamed from: a */
    private void m34288a() {
        this.f46162b = (CustomerSeekBar) LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_score, this, true).findViewById(R.id.customer_v_rate_seek_bar);
        this.f46161a = (TextView) findViewById(R.id.customer_star_choose_tip);
        this.f46162b.setOnTrackListener(new CustomerSeekBar.OnTrackListener() {
            public void onStartTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2) {
                OrderEvaluateScoreView.this.m34290a(customerSeekBar, i, i2, false);
            }

            public void onTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2) {
                OrderEvaluateScoreView.this.m34290a(customerSeekBar, i, i2, false);
            }

            public void onEndTrackingTouch(CustomerSeekBar customerSeekBar, int i, int i2, boolean z) {
                if (i == 0) {
                    i = (int) (((float) i2) * 0.2f);
                    customerSeekBar.setCurrentProgress(i);
                }
                if (z) {
                    OrderEvaluateScoreView.this.m34289a((i / customerSeekBar.getMinStep()) - 1);
                }
                if (OrderEvaluateScoreView.this.f46165e != null) {
                    OrderEvaluateScoreView.this.f46165e.onStarClick((i / customerSeekBar.getMinStep()) - 1);
                }
            }

            public boolean onInterceptTouch() {
                if (OrderEvaluateScoreView.this.f46168h != null) {
                    return OrderEvaluateScoreView.this.f46168h.onInterceptTouch();
                }
                return false;
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34290a(CustomerSeekBar customerSeekBar, int i, int i2, boolean z) {
        if (z) {
            customerSeekBar.setCurrentProgress(i);
        } else if (i == 0) {
            i = (int) (((float) i2) * 0.2f);
            customerSeekBar.setCurrentProgress(i);
        }
        m34289a((i / customerSeekBar.getMinStep()) - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34289a(int i) {
        OrderEvaluationScoreInfoEntity orderEvaluationScoreInfoEntity;
        if (i != this.f46167g) {
            this.f46167g = i;
            if (!CollectionsUtil.isEmpty(this.f46164d) && i < this.f46164d.size() && (orderEvaluationScoreInfoEntity = this.f46164d.get(i)) != null && !TextUtils.isEmpty(orderEvaluationScoreInfoEntity.desc) && this.f46163c != orderEvaluationScoreInfoEntity.score) {
                this.f46161a.setText(orderEvaluationScoreInfoEntity.desc);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46161a, IToolsService.FontType.MEDIUM);
                this.f46161a.setVisibility(0);
                this.f46163c = orderEvaluationScoreInfoEntity.score;
                if (i < 3) {
                    this.f46161a.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_2_40_666666));
                } else {
                    this.f46161a.setTextColor(SkinUtil.getBrandPrimaryColor());
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f46161a, View.ALPHA, new float[]{0.0f, 1.0f, 1.0f});
                ofFloat.setDuration(400);
                ofFloat.start();
            }
        }
    }
}
