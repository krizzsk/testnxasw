package com.didi.payment.commonsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.passenger.C11267R;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.taxis99.R;

public class WCommonAccountFieldView extends LinearLayout {
    public static final int MODE_DISPLAY_ONLY = 1;
    public static final int MODE_EDITABLE = 0;

    /* renamed from: a */
    private TextView f32695a;

    /* renamed from: b */
    private CommonEditText f32696b;

    /* renamed from: c */
    private TextView f32697c;

    /* renamed from: d */
    private ImageView f32698d;

    /* renamed from: e */
    private boolean f32699e = false;

    /* renamed from: f */
    private CharSequence f32700f = "";

    /* renamed from: g */
    private TextView f32701g;

    /* renamed from: h */
    private int f32702h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnExpandListener f32703i;

    public interface OnExpandListener {
        void onExpandIconClick();
    }

    public WCommonAccountFieldView(Context context) {
        super(context);
        m24761a();
    }

    public WCommonAccountFieldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24761a();
    }

    public WCommonAccountFieldView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.WCommonEditText, 0, 0);
        this.f32699e = obtainStyledAttributes.getBoolean(0, false);
        this.f32700f = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
        m24761a();
    }

    /* renamed from: a */
    private void m24761a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.wcommon_account_field_lay, this, true);
        this.f32695a = (TextView) inflate.findViewById(R.id.common_account_field_label_tv);
        this.f32696b = (CommonEditText) inflate.findViewById(R.id.common_account_field_input_et);
        this.f32701g = (TextView) inflate.findViewById(R.id.common_account_field_input_tv);
        this.f32696b.setHint(this.f32700f);
        this.f32696b.setMaxLines(1);
        this.f32697c = (TextView) inflate.findViewById(R.id.common_account_field_hidden_info_tv);
        this.f32698d = (ImageView) inflate.findViewById(R.id.common_expand_img);
        if (this.f32699e) {
            enableExpandFunc();
        }
    }

    public void switchType(boolean z) {
        if (z) {
            this.f32696b.setVisibility(0);
            if (this.f32701g.getVisibility() == 0) {
                this.f32696b.setVisibility(8);
            }
            this.f32702h = 0;
            return;
        }
        this.f32696b.setVisibility(4);
        if (this.f32701g.getVisibility() != 0) {
            this.f32701g.setVisibility(0);
        }
        this.f32702h = 1;
    }

    public void enableExpandFunc() {
        this.f32698d.setVisibility(0);
        this.f32698d.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WCommonAccountFieldView.this.f32703i != null) {
                    WCommonAccountFieldView.this.f32703i.onExpandIconClick();
                }
            }
        });
    }

    public EditText getInputET() {
        return this.f32696b;
    }

    public TextView getInputTv() {
        return this.f32701g;
    }

    @Deprecated
    public void setType(CommonEditText.TYPE type) {
        this.f32696b.setType(type);
    }

    public void setEditType(CommonEditText.TYPE type) {
        this.f32696b.setType(type);
    }

    public void setLabel(String str) {
        setLabel(str, "");
    }

    public void setExpandImg(int i) {
        this.f32698d.setImageResource(i);
    }

    public void setText(String str) {
        m24762b();
        if (this.f32702h == 0) {
            this.f32696b.setText(str);
        } else {
            this.f32701g.setText(str);
        }
    }

    /* renamed from: b */
    private void m24762b() {
        if (this.f32702h == 0) {
            this.f32696b.setVisibility(0);
            this.f32701g.setVisibility(8);
            return;
        }
        this.f32696b.setVisibility(4);
        this.f32701g.setVisibility(0);
    }

    public void setLabel(String str, String str2) {
        this.f32695a.setText(str);
        if (this.f32696b.getVisibility() == 0) {
            this.f32696b.setHint(str2);
        } else {
            this.f32701g.setHint(str2);
        }
    }

    public void setMaxLength(int i) {
        this.f32696b.setMaxLength(i);
    }

    public void setEnableExpand(boolean z) {
        this.f32699e = z;
        if (z) {
            enableExpandFunc();
        }
    }

    public void setInputEnable(boolean z) {
        this.f32696b.setEnabled(z);
    }

    public void showErrorInfo(String str) {
        this.f32697c.setVisibility(0);
        this.f32697c.setText(str);
    }

    public void setOnTextChangeListener(CommonEditText.OnTextChangeListener onTextChangeListener) {
        this.f32696b.registeTextChangeListener(onTextChangeListener);
    }

    public String getInputValue() {
        if (this.f32702h == 0) {
            return this.f32696b.getTextString();
        }
        return String.valueOf(this.f32701g.getText());
    }

    public boolean isValidInput() {
        return !TextUtils.isEmpty(this.f32696b.getTextWithoutSpace());
    }

    public void setOnExpandListener(OnExpandListener onExpandListener) {
        this.f32703i = onExpandListener;
    }
}
