package com.didi.entrega.customer.widget.titlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C11267R;
import com.didi.rfusion.widget.RFIconView;
import com.taxis99.R;

public class TitleBarView extends ConstraintLayout {

    /* renamed from: a */
    View f22475a;

    /* renamed from: b */
    RFIconView f22476b;

    /* renamed from: c */
    TextView f22477c;

    /* renamed from: d */
    TextView f22478d;

    /* renamed from: e */
    CharSequence f22479e;

    /* renamed from: f */
    CharSequence f22480f;

    /* renamed from: g */
    CharSequence f22481g;

    /* renamed from: h */
    OnBackClickListener f22482h;

    /* renamed from: i */
    OnRightClickListener f22483i;

    public TitleBarView(Context context) {
        super(context);
        m18493a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18494a(context, attributeSet, 0);
        m18493a(context);
    }

    public TitleBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18494a(context, attributeSet, i);
        m18493a(context);
    }

    public void setOnBackClickListener(OnBackClickListener onBackClickListener) {
        this.f22482h = onBackClickListener;
    }

    public void setOnRightClickListener(OnRightClickListener onRightClickListener) {
        this.f22483i = onRightClickListener;
    }

    public void setOnRightClickListener(String str, OnRightClickListener onRightClickListener) {
        setRightText(str);
        this.f22483i = onRightClickListener;
    }

    public void setBackIconText(int i) {
        this.f22476b.setText(i);
    }

    public void hideBackView() {
        this.f22476b.setVisibility(8);
    }

    public View getContainer() {
        return this.f22475a;
    }

    public RFIconView getBackView() {
        return this.f22476b;
    }

    public TextView getTitleView() {
        return this.f22477c;
    }

    public void setTitleText(int i) {
        this.f22477c.setText(i);
    }

    public void setTitleText(String str) {
        this.f22477c.setText(str);
    }

    public void setRigthText(int i) {
        this.f22478d.setText(i);
    }

    public void setRightText(String str) {
        if (str == null || str.length() <= 0) {
            this.f22478d.setVisibility(4);
            return;
        }
        this.f22478d.setText(str);
        this.f22478d.setVisibility(0);
    }

    public void setBackgroundResource(int i) {
        this.f22475a.setBackgroundResource(i);
    }

    /* renamed from: a */
    private void m18494a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.EntregaTitleBarView, i, 0);
        this.f22479e = obtainStyledAttributes.getText(2);
        this.f22480f = obtainStyledAttributes.getText(0);
        this.f22481g = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    private void m18493a(Context context) {
        inflate(context, R.layout.entrega_common_title_bar_close, this);
        this.f22475a = findViewById(R.id.entrega_custom_title_container);
        this.f22476b = (RFIconView) findViewById(R.id.entrega_iv_page_back);
        this.f22477c = (TextView) findViewById(R.id.entrega_tv_title_label);
        this.f22478d = (TextView) findViewById(R.id.entrega_tv_page_opt_label);
        this.f22477c.setText(this.f22479e);
        CharSequence charSequence = this.f22480f;
        if (charSequence == null || charSequence.length() <= 0) {
            this.f22476b.setText(R.string.rf_icon_outline_close);
        } else {
            this.f22476b.setText(this.f22480f);
        }
        CharSequence charSequence2 = this.f22481g;
        if (charSequence2 != null && charSequence2.length() > 0) {
            this.f22478d.setText(this.f22481g);
            this.f22478d.setVisibility(0);
        }
        this.f22476b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TitleBarView.this.f22482h != null) {
                    TitleBarView.this.f22482h.onBackClick(view);
                }
            }
        });
        this.f22478d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TitleBarView.this.f22483i != null) {
                    TitleBarView.this.f22483i.onRightClick(view);
                }
            }
        });
    }
}
