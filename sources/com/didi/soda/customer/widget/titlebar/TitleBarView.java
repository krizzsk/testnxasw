package com.didi.soda.customer.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C11267R;
import com.didi.soda.customer.widget.text.IconRichTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class TitleBarView extends ConstraintLayout {

    /* renamed from: a */
    View f44805a;

    /* renamed from: b */
    IconTextView f44806b;

    /* renamed from: c */
    TextView f44807c;

    /* renamed from: d */
    IconRichTextView f44808d;

    /* renamed from: e */
    CharSequence f44809e;

    /* renamed from: f */
    CharSequence f44810f;

    /* renamed from: g */
    CharSequence f44811g;

    /* renamed from: h */
    OnBackClickListener f44812h;

    /* renamed from: i */
    OnRightClickListener f44813i;

    public TitleBarView(Context context) {
        super(context);
        m33231a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m33232a(context, attributeSet, 0);
        m33231a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m33232a(context, attributeSet, i);
        m33231a(context);
    }

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.f44812h = onBackClickListener;
    }

    public void setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.f44813i = onRightClickListener;
    }

    public void setOnRightClickListener(String str, OnRightClickListener onRightClickListener) {
        setRightText(str);
        this.f44813i = onRightClickListener;
    }

    public void setBackIconText(int i) {
        this.f44806b.setText(i);
    }

    public void hideBackView() {
        this.f44806b.setVisibility(8);
    }

    public View getContainer() {
        return this.f44805a;
    }

    public IconTextView getBackView() {
        return this.f44806b;
    }

    public TextView getTitleView() {
        return this.f44807c;
    }

    public void setTitleText(int i) {
        this.f44807c.setText(i);
    }

    public void setTitleText(String str) {
        this.f44807c.setText(str);
    }

    public void setRigthText(int i) {
        this.f44808d.setText(i);
    }

    public void setRightText(String str) {
        if (str == null || str.length() <= 0) {
            this.f44808d.setVisibility(4);
            return;
        }
        this.f44808d.setText(str);
        this.f44808d.setVisibility(0);
    }

    public void setBackgroundResource(int i) {
        this.f44805a.setBackgroundResource(i);
    }

    /* renamed from: a */
    private void m33232a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.TitleBarView, i, 0);
        this.f44809e = obtainStyledAttributes.getText(2);
        this.f44810f = obtainStyledAttributes.getText(0);
        this.f44811g = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m33231a(Context context) {
        inflate(context, R.layout.customer_common_title_bar_close, this);
        this.f44805a = findViewById(R.id.customer_custom_title_container);
        this.f44806b = (IconTextView) findViewById(R.id.customer_iv_page_back);
        this.f44807c = (TextView) findViewById(R.id.customer_tv_title_label);
        this.f44808d = (IconRichTextView) findViewById(R.id.customer_tv_page_opt_label);
        this.f44807c.setText(this.f44809e);
        CharSequence charSequence = this.f44810f;
        if (charSequence == null || charSequence.length() <= 0) {
            this.f44806b.setText(R.string.customer_common_icon_closed);
        } else {
            this.f44806b.setText(this.f44810f);
        }
        CharSequence charSequence2 = this.f44811g;
        if (charSequence2 != null && charSequence2.length() > 0) {
            this.f44808d.setText(this.f44811g);
            this.f44808d.setVisibility(0);
        }
        this.f44806b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TitleBarView.this.f44812h != null) {
                    TitleBarView.this.f44812h.onBackClick(view);
                }
            }
        });
        this.f44808d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TitleBarView.this.f44813i != null) {
                    TitleBarView.this.f44813i.onRightClick(view);
                }
            }
        });
    }
}
