package com.didi.soda.bill.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class CustomerExpandView extends ConstraintLayout {
    public static final int PUT_AWAY = 2;
    public static final int SHOW_ALL = 1;

    /* renamed from: c */
    private static final int f42003c = -1;

    /* renamed from: a */
    TextView f42004a;

    /* renamed from: b */
    IconTextView f42005b;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f42006d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnStatusChangeListener f42007e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f42008f;

    public interface OnStatusChangeListener {
        void onChanged(int i);
    }

    public CustomerExpandView(Context context) {
        super(context);
        m31509a();
    }

    public CustomerExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31509a();
    }

    public CustomerExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m31509a();
    }

    public int getCurrentStatus() {
        return this.f42006d;
    }

    public void setData(int i, int i2) {
        this.f42008f = i;
        if (this.f42006d == -1) {
            this.f42006d = i2;
        }
        if (getCurrentStatus() == 1) {
            m31510a(i);
        } else if (getCurrentStatus() == 2) {
            m31513b(i);
        }
        OnStatusChangeListener onStatusChangeListener = this.f42007e;
        if (onStatusChangeListener != null) {
            onStatusChangeListener.onChanged(this.f42006d);
        }
    }

    public void setInitStatus(int i) {
        if (this.f42006d == -1) {
            this.f42006d = i;
        }
    }

    public void setStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.f42007e = onStatusChangeListener;
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CustomerExpandView.this.f42006d == 1) {
                    CustomerExpandView customerExpandView = CustomerExpandView.this;
                    customerExpandView.m31513b(customerExpandView.f42008f);
                } else if (CustomerExpandView.this.f42006d == 2) {
                    CustomerExpandView customerExpandView2 = CustomerExpandView.this;
                    customerExpandView2.m31510a(customerExpandView2.f42008f);
                }
                if (CustomerExpandView.this.f42007e != null) {
                    CustomerExpandView.this.f42007e.onChanged(CustomerExpandView.this.f42006d);
                }
            }
        });
    }

    /* renamed from: a */
    private void m31509a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_cart_expand_container, this);
        this.f42004a = (TextView) findViewById(R.id.customer_tv_expand);
        this.f42005b = (IconTextView) findViewById(R.id.customer_custom_expand_arrow);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31510a(int i) {
        this.f42004a.setText(getResources().getQuantityString(R.plurals.customer_put_away, i, new Object[]{Integer.valueOf(i)}));
        this.f42005b.setText(getResources().getString(R.string.customer_common_icon_retract));
        this.f42006d = 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31513b(int i) {
        this.f42004a.setText(getResources().getQuantityString(R.plurals.customer_show_all, i, new Object[]{Integer.valueOf(i)}));
        this.f42005b.setText(getResources().getString(R.string.customer_common_icon_spread));
        this.f42006d = 2;
    }
}
