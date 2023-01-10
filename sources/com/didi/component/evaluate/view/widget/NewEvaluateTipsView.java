package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

public class NewEvaluateTipsView extends RelativeLayout {

    /* renamed from: a */
    private ViewGroup f15266a;

    /* renamed from: b */
    private TextView f15267b;

    /* renamed from: c */
    private TextView f15268c;

    /* renamed from: d */
    private View f15269d;

    /* renamed from: e */
    private double f15270e;

    /* renamed from: f */
    private String f15271f;

    /* renamed from: g */
    private boolean f15272g = false;

    /* renamed from: h */
    private int f15273h;

    /* renamed from: b */
    private void m12590b() {
    }

    public NewEvaluateTipsView(Context context) {
        super(context);
        m12589a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12589a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12589a();
    }

    /* renamed from: a */
    private void m12589a() {
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_tips_item_layout, this, true)).findViewById(R.id.layout);
        this.f15266a = viewGroup;
        this.f15267b = (TextView) viewGroup.findViewById(R.id.currency);
        this.f15268c = (TextView) this.f15266a.findViewById(R.id.tips);
        this.f15269d = this.f15266a.findViewById(R.id.line);
        m12590b();
    }

    public void setCurrency(String str) {
        this.f15267b.setText(str);
    }

    public void setTips(String str, double d) {
        this.f15268c.setText(str);
        this.f15270e = d;
        this.f15271f = str;
    }

    public double getTips() {
        return this.f15270e;
    }

    public String getTipText() {
        return this.f15271f;
    }

    public void setSelected(boolean z) {
        this.f15272g = z;
        this.f15268c.setSelected(z);
        this.f15267b.setSelected(z);
    }

    public boolean isSelected() {
        return this.f15272g;
    }

    public void setWidth(int i) {
        ((RelativeLayout.LayoutParams) this.f15266a.getLayoutParams()).width = i;
    }

    public View getView() {
        return this.f15266a;
    }

    public void setLineVisibility(int i) {
        this.f15269d.setVisibility(i);
    }

    public int getIndex() {
        return this.f15273h;
    }

    public void setIndex(int i) {
        this.f15273h = i;
    }
}
