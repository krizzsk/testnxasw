package com.didi.soda.business.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class BusinessDyClassifyALayout extends ConstraintLayout {

    /* renamed from: a */
    private static final String f42370a = "BusinessDyClassifyALayout";
    @BindView(18394)
    RFIconView mClassifyIcon;
    @BindView(18359)
    RFIconView mClassifySearchIcon;
    @BindView(18881)
    TextView mClassifyTv;

    public BusinessDyClassifyALayout(Context context) {
        super(context);
        m31873a();
    }

    public BusinessDyClassifyALayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31873a();
    }

    public BusinessDyClassifyALayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31873a();
    }

    public void setMenuClickListener(View.OnClickListener onClickListener) {
        this.mClassifyIcon.setOnClickListener(onClickListener);
        this.mClassifyTv.setOnClickListener(onClickListener);
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.mClassifySearchIcon.setOnClickListener(onClickListener);
    }

    /* renamed from: a */
    private void m31873a() {
        ButterKnife.bind((Object) this, LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_dy_business_classify_a, this, true));
        setClickable(false);
    }
}
