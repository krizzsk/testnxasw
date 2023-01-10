package com.didi.soda.order.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.order.builder.FeeItem;
import com.taxis99.R;

public class OrderDetailFeeItemView extends ConstraintLayout {

    /* renamed from: a */
    private TextView f46115a;

    /* renamed from: b */
    private ImageView f46116b;

    /* renamed from: c */
    private TextView f46117c;

    /* renamed from: d */
    private ImageView f46118d;

    public OrderDetailFeeItemView(Context context) {
        super(context);
        m34260a();
    }

    public OrderDetailFeeItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34260a();
    }

    public OrderDetailFeeItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34260a();
    }

    public OrderDetailFeeItemView setData(FeeItem feeItem) {
        this.f46115a.setText(feeItem.mLeftContent);
        if (feeItem.mLeftIcon > 0) {
            this.f46116b.setImageResource(feeItem.mLeftIcon);
            this.f46116b.setVisibility(0);
        } else {
            this.f46116b.setVisibility(8);
        }
        if (feeItem.mListener != null) {
            this.f46116b.setOnClickListener(feeItem.mListener);
        }
        this.f46117c.setText(feeItem.mRigthContent);
        if (!TextUtils.isEmpty(feeItem.mRightIcon)) {
            FlyImageLoader.loadImageUnspecified(getContext(), feeItem.mRightIcon).centerCrop().into(this.f46118d);
            this.f46118d.setVisibility(0);
        } else {
            this.f46118d.setVisibility(8);
        }
        return this;
    }

    public void setLeftIconClickListener(View.OnClickListener onClickListener) {
        this.f46116b.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: protected */
    public void inflate() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_item_order_fee, this);
    }

    /* renamed from: a */
    private void m34260a() {
        inflate();
        this.f46115a = (TextView) findViewById(R.id.customer_tv_fee_name);
        this.f46116b = (ImageView) findViewById(R.id.customer_iv_fee_left_icon);
        this.f46117c = (TextView) findViewById(R.id.customer_tv_right_content);
        this.f46118d = (ImageView) findViewById(R.id.customer_iv_fee_right_icon);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f46117c, IToolsService.FontType.MEDIUM);
    }
}
