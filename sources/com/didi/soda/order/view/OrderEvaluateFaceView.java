package com.didi.soda.order.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationScoreInfoEntity;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import java.util.List;

public class OrderEvaluateFaceView extends FrameLayout {
    public static final int BAD_TAG = 0;
    public static final int GOOD_TAG = 1;

    /* renamed from: a */
    private TextView f46150a;

    /* renamed from: b */
    private TextView f46151b;

    /* renamed from: c */
    private RFIconView f46152c;

    /* renamed from: d */
    private RFIconView f46153d;

    /* renamed from: e */
    private int f46154e;

    /* renamed from: f */
    private List<OrderEvaluationScoreInfoEntity> f46155f;

    /* renamed from: g */
    private OnFaceClickListener f46156g;

    public interface OnFaceClickListener {
        boolean onFaceClick(int i);
    }

    public OrderEvaluateFaceView(Context context) {
        super(context);
        m34283a();
    }

    public OrderEvaluateFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34283a();
    }

    public OrderEvaluateFaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34283a();
    }

    public void setScoreInfo(int i, List<OrderEvaluationScoreInfoEntity> list) {
        this.f46155f = list;
        if (!CollectionsUtil.isEmpty(list)) {
            for (int i2 = 0; i2 < this.f46155f.size(); i2++) {
                if (i2 == 0 && !TextUtils.isEmpty(this.f46155f.get(0).desc)) {
                    this.f46150a.setText(this.f46155f.get(0).desc);
                }
                if (i2 == 1 && !TextUtils.isEmpty(this.f46155f.get(1).desc)) {
                    this.f46151b.setText(this.f46155f.get(1).desc);
                }
            }
            if (i == 2) {
                this.f46152c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
                this.f46152c.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
                this.f46153d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
                this.f46153d.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46150a, IToolsService.FontType.MEDIUM);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46151b, IToolsService.FontType.LIGHT);
                this.f46154e = i;
            } else if (i == 10) {
                this.f46153d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
                this.f46153d.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
                this.f46152c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
                this.f46152c.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46151b, IToolsService.FontType.MEDIUM);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46150a, IToolsService.FontType.LIGHT);
                this.f46154e = i;
            }
        }
    }

    public int getScore() {
        return this.f46154e;
    }

    public void setOnFaceClickListener(OnFaceClickListener onFaceClickListener) {
        this.f46156g = onFaceClickListener;
    }

    /* renamed from: a */
    private void m34283a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_face, this, true);
        this.f46153d = (RFIconView) inflate.findViewById(R.id.customer_iv_good_bg);
        this.f46152c = (RFIconView) inflate.findViewById(R.id.customer_iv_bad_bg);
        this.f46150a = (TextView) inflate.findViewById(R.id.customer_bad_tip);
        this.f46151b = (TextView) inflate.findViewById(R.id.customer_good_tip);
        ((LinearLayout) inflate.findViewById(R.id.customer_ll_bad_container)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateFaceView.this.m34285b(view);
            }
        });
        ((LinearLayout) inflate.findViewById(R.id.customer_ll_good_container)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateFaceView.this.m34284a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m34285b(View view) {
        OnFaceClickListener onFaceClickListener = this.f46156g;
        if (onFaceClickListener == null || !onFaceClickListener.onFaceClick(0)) {
            this.f46152c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
            this.f46152c.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
            this.f46153d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
            this.f46153d.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46150a, IToolsService.FontType.MEDIUM);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46151b, IToolsService.FontType.LIGHT);
            List<OrderEvaluationScoreInfoEntity> list = this.f46155f;
            if (list != null && list.size() > 0) {
                this.f46154e = this.f46155f.get(0).score;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34284a(View view) {
        OnFaceClickListener onFaceClickListener = this.f46156g;
        if (onFaceClickListener == null || !onFaceClickListener.onFaceClick(1)) {
            this.f46153d.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
            this.f46153d.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
            this.f46152c.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_9_a4));
            this.f46152c.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46151b, IToolsService.FontType.MEDIUM);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46150a, IToolsService.FontType.LIGHT);
            List<OrderEvaluationScoreInfoEntity> list = this.f46155f;
            if (list != null && list.size() > 1) {
                this.f46154e = this.f46155f.get(1).score;
            }
        }
    }
}
