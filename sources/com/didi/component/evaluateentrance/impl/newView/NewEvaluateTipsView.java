package com.didi.component.evaluateentrance.impl.newView;

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
    private ViewGroup f15406a;

    /* renamed from: b */
    private TextView f15407b;

    /* renamed from: c */
    private TextView f15408c;

    /* renamed from: d */
    private View f15409d;

    /* renamed from: e */
    private double f15410e;

    /* renamed from: f */
    private String f15411f;

    /* renamed from: g */
    private boolean f15412g = false;

    /* renamed from: h */
    private int f15413h;

    /* renamed from: b */
    private void m12706b() {
    }

    public NewEvaluateTipsView(Context context) {
        super(context);
        m12705a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12705a();
    }

    public NewEvaluateTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12705a();
    }

    /* renamed from: a */
    private void m12705a() {
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_tips_item_layout, this, true)).findViewById(R.id.layout);
        this.f15406a = viewGroup;
        this.f15407b = (TextView) viewGroup.findViewById(R.id.currency);
        this.f15408c = (TextView) this.f15406a.findViewById(R.id.tips);
        this.f15409d = this.f15406a.findViewById(R.id.line);
        m12706b();
    }

    public void setCurrency(String str) {
        this.f15407b.setText(str);
    }

    public void setTips(String str, double d) {
        this.f15408c.setText(str);
        this.f15410e = d;
        this.f15411f = str;
    }

    public double getTips() {
        return this.f15410e;
    }

    public String getTipText() {
        return this.f15411f;
    }

    public void setSelected(boolean z) {
        this.f15412g = z;
        this.f15408c.setSelected(z);
        this.f15407b.setSelected(z);
    }

    public boolean isSelected() {
        return this.f15412g;
    }

    public void setWidth(int i) {
        ((RelativeLayout.LayoutParams) this.f15406a.getLayoutParams()).width = i;
    }

    public View getView() {
        return this.f15406a;
    }

    public void setLineVisibility(int i) {
        this.f15409d.setVisibility(i);
    }

    public int getIndex() {
        return this.f15413h;
    }

    public void setIndex(int i) {
        this.f15413h = i;
    }
}
