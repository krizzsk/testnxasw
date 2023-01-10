package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class FiveStarEvaluatedView extends FrameLayout {

    /* renamed from: a */
    private ViewGroup f15260a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f15261b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f15262c = new Handler();

    /* renamed from: d */
    private OnStarListener f15263d;

    /* renamed from: e */
    private int f15264e = 0;

    /* renamed from: f */
    private boolean f15265f = false;
    protected List<CheckBox> mCheckBoxes = new ArrayList();

    public interface OnStarListener {
        void onStarChanged(int i);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_evaluate_five_star_view_layout;
    }

    public FiveStarEvaluatedView(Context context) {
        super(context);
        m12585a();
    }

    public FiveStarEvaluatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12585a();
    }

    public FiveStarEvaluatedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12585a();
    }

    /* renamed from: a */
    private void m12585a() {
        this.f15260a = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(getLayout(), this, true)).findViewById(R.id.global_evaluate_five_star_group);
        for (int i = 0; i < this.f15260a.getChildCount(); i++) {
            View childAt = this.f15260a.getChildAt(i);
            if (childAt instanceof CheckBox) {
                this.mCheckBoxes.add((CheckBox) childAt);
            }
        }
        m12588b();
    }

    /* renamed from: b */
    private void m12588b() {
        for (int i = 0; i < this.mCheckBoxes.size(); i++) {
            this.mCheckBoxes.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (FiveStarEvaluatedView.this.f15261b) {
                        int indexOf = FiveStarEvaluatedView.this.mCheckBoxes.indexOf(view);
                        if (indexOf != -1) {
                            FiveStarEvaluatedView.this.flushRateStar(indexOf);
                        }
                        FiveStarEvaluatedView.this.f15262c.removeCallbacksAndMessages((Object) null);
                    }
                }
            });
        }
    }

    public void showEvaluated(int i) {
        flushRateStar(i - 1);
    }

    /* access modifiers changed from: protected */
    public void flushRateStar(int i) {
        int i2 = i + 1;
        this.f15264e = i2;
        for (int i3 = 0; i3 < this.mCheckBoxes.size(); i3++) {
            CheckBox checkBox = this.mCheckBoxes.get(i3);
            if (i3 <= i) {
                checkBox.setChecked(true);
                if (this.f15265f) {
                    checkBox.setVisibility(0);
                }
            } else {
                checkBox.setChecked(false);
                if (this.f15265f) {
                    checkBox.setVisibility(8);
                }
            }
            checkBox.invalidate();
        }
        OnStarListener onStarListener = this.f15263d;
        if (onStarListener != null) {
            onStarListener.onStarChanged(i2);
        }
    }

    public void setOnStarListener(OnStarListener onStarListener) {
        this.f15263d = onStarListener;
    }

    public void setEnable(boolean z) {
        this.f15261b = z;
        for (CheckBox enabled : this.mCheckBoxes) {
            enabled.setEnabled(z);
        }
    }

    public View getView() {
        return this.f15260a;
    }

    public int getCurrentStar() {
        return this.f15264e;
    }

    public void setMargin(int i) {
        for (int i2 = 0; i2 < this.mCheckBoxes.size(); i2++) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mCheckBoxes.get(i2).getLayoutParams();
            if (layoutParams != null && layoutParams.leftMargin > 0) {
                layoutParams.leftMargin = UIUtils.dip2pxInt(getContext(), (float) i);
            }
        }
    }

    public void setIsHideUnselect(boolean z) {
        this.f15265f = z;
    }
}
