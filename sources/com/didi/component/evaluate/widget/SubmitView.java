package com.didi.component.evaluate.widget;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class SubmitView extends LinearLayout implements ISubmitView {

    /* renamed from: a */
    private final int f15318a = 0;

    /* renamed from: b */
    private final int f15319b = 1;

    /* renamed from: c */
    private final int f15320c = 2;

    /* renamed from: d */
    private final int f15321d = 3;

    /* renamed from: e */
    private TextView f15322e;

    /* renamed from: f */
    private View f15323f;

    /* renamed from: g */
    private ImageView f15324g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View.OnClickListener f15325h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f15326i = 0;

    public SubmitView(Context context) {
        super(context);
        m12618a();
    }

    public SubmitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12618a();
    }

    public SubmitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12618a();
    }

    /* renamed from: a */
    private void m12618a() {
        setOrientation(1);
        setGravity(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_evaluate_submit_view, this, true);
        this.f15323f = inflate;
        this.f15322e = (TextView) inflate.findViewById(R.id.submit_button_view);
        this.f15324g = (ImageView) this.f15323f.findViewById(R.id.submitting_view);
        this.f15323f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SubmitView.this.f15325h != null && SubmitView.this.f15326i != 1 && SubmitView.this.f15326i != 3) {
                    SubmitView.this.m12620b();
                    SubmitView.this.f15325h.onClick(view);
                }
            }
        });
        setTipHint((String) null);
        this.f15322e.setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
        this.f15322e.setBackgroundResource(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_bg_selector));
        this.f15324g.setBackgroundResource(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_bg_selector));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12620b() {
        this.f15326i = 1;
        this.f15322e.setVisibility(8);
        this.f15324g.setVisibility(0);
        ((AnimationDrawable) this.f15324g.getDrawable()).start();
    }

    public void setEnable(boolean z) {
        setVisibility(0);
        if (z) {
            this.f15322e.setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.submit_btn_text_color_selector));
            this.f15322e.setBackgroundResource(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.submit_btn_bg_selector));
        } else {
            this.f15322e.setTextColor(getResources().getColor(R.color.g_color_CCCCCC));
            this.f15322e.setBackgroundColor(getResources().getColor(R.color.g_color_EEE));
        }
        this.f15323f.setClickable(z);
    }

    public void showLoading() {
        this.f15324g.setVisibility(0);
        this.f15322e.setVisibility(8);
        this.f15323f.setClickable(false);
    }

    public void hideLoading() {
        this.f15324g.setVisibility(8);
        this.f15322e.setVisibility(0);
        this.f15323f.setClickable(true);
    }

    public void setOnclickListener(View.OnClickListener onClickListener) {
        this.f15325h = onClickListener;
    }

    public void setTipHint(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f15322e.setText(R.string.oc_evaluate_submit);
        } else {
            this.f15322e.setText(String.format(getResources().getString(R.string.global_evaluate_commit_tip), new Object[]{str}));
        }
        this.f15322e.setContentDescription(this.f15322e.getText().toString().trim() + getResources().getString(R.string.global_evaluate_button_to_submit));
    }

    public void submitSuccess() {
        this.f15326i = 3;
        this.f15322e.setVisibility(0);
        this.f15324g.setVisibility(8);
        this.f15322e.setText(R.string.oc_evaluate_submitted);
    }

    public void submitFail() {
        this.f15326i = 2;
        this.f15322e.setVisibility(0);
        this.f15324g.setVisibility(8);
        this.f15322e.setText(R.string.oc_evaluate_submit_retry);
    }
}
