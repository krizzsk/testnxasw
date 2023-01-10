package com.didi.component.evaluate.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.UIUtils;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.taxis99.R;

public class TipView extends LinearLayout {

    /* renamed from: a */
    private TextView f15239a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RadioGroup f15240b;

    /* renamed from: c */
    private CarTipInfo.FeeItem[] f15241c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f15242d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnTipSelected f15243e;

    interface OnTipSelected {
        void onSelected(String str);
    }

    public void setOnTipSelected(OnTipSelected onTipSelected) {
        this.f15243e = onTipSelected;
    }

    public TipView(Context context) {
        super(context);
        m12573a();
    }

    public TipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12573a();
    }

    public TipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12573a();
    }

    /* renamed from: a */
    private void m12573a() {
        setOrientation(1);
        setGravity(1);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_evaluate_tip_view, this, true);
        this.f15239a = (TextView) inflate.findViewById(R.id.tv_hint);
        this.f15240b = (RadioGroup) inflate.findViewById(R.id.rg_tip);
    }

    public void setTipPriceList(CarTipInfo.FeeItem[] feeItemArr, String str) {
        if (feeItemArr != null && feeItemArr.length > 0) {
            this.f15241c = feeItemArr;
            int length = feeItemArr.length;
            this.f15240b.removeAllViews();
            for (int i = 0; i < length; i++) {
                String str2 = feeItemArr[i].tipString;
                if (!TextUtils.isEmpty(str2)) {
                    RadioButton radioButton = new RadioButton(getContext());
                    radioButton.setButtonDrawable(new ColorDrawable(0));
                    radioButton.setGravity(17);
                    if (!TextUtils.isEmpty(str)) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + str2);
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(UIUtils.dip2pxInt(getContext(), 10.0f)), 0, str.length(), 33);
                        radioButton.setText(spannableStringBuilder);
                    } else {
                        radioButton.setText(str2);
                    }
                    radioButton.setTextSize(18.0f);
                    radioButton.setTextColor(getResources().getColorStateList(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.selected_item_text_color_selector)));
                    radioButton.setBackgroundResource(DidiThemeManager.getIns().getResPicker(getContext()).getResIdByTheme(R.attr.selected_item_round_corner_bg_selector));
                    radioButton.setEnabled(true);
                    radioButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            int indexOfChild = TipView.this.f15240b.indexOfChild(view);
                            if (TipView.this.f15242d == indexOfChild) {
                                TipView.this.f15240b.clearCheck();
                                int unused = TipView.this.f15242d = -1;
                                if (TipView.this.f15243e != null) {
                                    TipView.this.f15243e.onSelected((String) null);
                                    return;
                                }
                                return;
                            }
                            int unused2 = TipView.this.f15242d = indexOfChild;
                            if (TipView.this.f15243e != null) {
                                TipView.this.f15243e.onSelected(TipView.this.getTipValueString());
                            }
                        }
                    });
                    RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(0, -2);
                    layoutParams.weight = 1.0f;
                    if (i < length - 1) {
                        layoutParams.setMargins(0, 0, (int) UIUtils.dip2px(getContext(), 40.0f), 0);
                    }
                    this.f15240b.addView(radioButton, layoutParams);
                }
            }
        }
    }

    public String getTipValueString() {
        try {
            if (this.f15242d >= 0) {
                return this.f15241c[this.f15242d].tipString;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public double getTipValueNum() {
        try {
            if (this.f15242d >= 0) {
                return this.f15241c[this.f15242d].tipNum;
            }
            return 0.0d;
        } catch (Exception unused) {
            return 0.0d;
        }
    }
}
