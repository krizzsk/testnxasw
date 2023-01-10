package com.didi.component.evaluate.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarServerParam;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class TipInputPopWindow extends PopupWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f15229a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Double f15230b = Double.valueOf(0.0d);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ConfirmButtonClickListener f15231c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f15232d;

    /* renamed from: e */
    private View f15233e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CarTipInfo f15234f;

    /* renamed from: g */
    private double f15235g = 0.0d;

    /* renamed from: h */
    private String f15236h = "";

    /* renamed from: i */
    private View f15237i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public EditText f15238j;

    interface ConfirmButtonClickListener {
        void confirmClick(String str, Double d);
    }

    public TipInputPopWindow(View view, int i, int i2, Context context, CarTipInfo carTipInfo, double d, String str, ConfirmButtonClickListener confirmButtonClickListener) {
        super(view, i, i2);
        this.f15233e = view;
        this.f15231c = confirmButtonClickListener;
        this.f15232d = context;
        this.f15234f = carTipInfo;
        this.f15235g = d;
        this.f15236h = str;
        m12564a();
    }

    public void show() {
        Context context = this.f15232d;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !isShowing()) {
            setFocusable(true);
            setInputMethodMode(1);
            setSoftInputMode(16);
            setBackgroundDrawable(new ColorDrawable(1076176429));
            setClippingEnabled(true);
            setOutsideTouchable(true);
            showAtLocation(this.f15233e, 80, 0, 0);
            this.f15237i.setAnimation(AnimationUtils.loadAnimation(this.f15232d, R.anim.ggk_drawer_bottom_in));
            showAtLocation(this.f15233e, 80, 0, 0);
            this.f15238j.requestFocus();
            this.f15238j.setFocusableInTouchMode(true);
            ((InputMethodManager) this.f15238j.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        }
    }

    /* renamed from: a */
    private void m12564a() {
        if (this.f15234f != null) {
            this.f15237i = this.f15233e.findViewById(R.id.evaluate_tip_view);
            this.f15238j = (EditText) this.f15233e.findViewById(R.id.tip_input_drawer_et);
            final TextView textView = (TextView) this.f15233e.findViewById(R.id.tip_input_drawer_btn);
            TextView textView2 = (TextView) this.f15233e.findViewById(R.id.currency_text);
            final ImageView imageView = (ImageView) this.f15233e.findViewById(R.id.del_text_btn);
            if (this.f15235g == 0.0d) {
                EditText editText = this.f15238j;
                editText.setHint(this.f15234f.min + "-" + this.f15234f.max);
                textView.setEnabled(false);
                imageView.setVisibility(8);
            } else {
                EditText editText2 = this.f15238j;
                editText2.setText(this.f15235g + "");
                this.f15230b = Double.valueOf(this.f15235g);
                this.f15229a = this.f15236h;
                textView.setEnabled(true);
                imageView.setVisibility(0);
            }
            textView2.setText(this.f15234f.currency);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipInputPopWindow.this.f15238j.setText("");
                    if (TipInputPopWindow.this.f15234f != null) {
                        EditText a = TipInputPopWindow.this.f15238j;
                        a.setHint(TipInputPopWindow.this.f15234f.min + "-" + TipInputPopWindow.this.f15234f.max);
                    }
                    imageView.setVisibility(8);
                }
            });
            this.f15238j.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    imageView.setVisibility(0);
                    try {
                        String unused = TipInputPopWindow.this.f15229a = Elvish.Companion.getInstance().formatNumber(Double.valueOf(Double.parseDouble(editable.toString())), -1, 1);
                        if (!TipInputPopWindow.this.f15229a.isEmpty()) {
                            Double unused2 = TipInputPopWindow.this.f15230b = Double.valueOf(Elvish.Companion.getInstance().parseNumberSafety(TipInputPopWindow.this.f15229a, Double.valueOf(0.0d)).doubleValue());
                            if (TipInputPopWindow.this.f15230b.doubleValue() <= 0.0d) {
                                TipInputPopWindow.this.f15238j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f15232d, R.color.g_color_000));
                                textView.setEnabled(false);
                            } else if (TipInputPopWindow.this.f15230b.doubleValue() >= ((double) TipInputPopWindow.this.f15234f.min) && TipInputPopWindow.this.f15230b.doubleValue() <= ((double) TipInputPopWindow.this.f15234f.max)) {
                                TipInputPopWindow.this.f15238j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f15232d, R.color.g_color_000));
                                textView.setEnabled(true);
                            } else if (TipInputPopWindow.this.f15230b.doubleValue() > ((double) TipInputPopWindow.this.f15234f.max)) {
                                TipInputPopWindow.this.f15238j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f15232d, R.color.g_color_FFFF525D));
                                textView.setEnabled(false);
                                HashMap hashMap = new HashMap();
                                hashMap.put(CarServerParam.PARAM_FEE, TipInputPopWindow.this.f15230b.toString());
                                hashMap.put("source", "starratedetail");
                                GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_error_bt", (Map<String, Object>) hashMap);
                            } else {
                                TipInputPopWindow.this.f15238j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f15232d, R.color.g_color_000));
                                textView.setEnabled(false);
                            }
                        } else {
                            TipInputPopWindow.this.f15238j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f15232d, R.color.g_color_FFFF525D));
                            textView.setEnabled(false);
                        }
                    } catch (NumberFormatException unused3) {
                        TipInputPopWindow.this.f15238j.setTextColor(ContextCompat.getColor(TipInputPopWindow.this.f15232d, R.color.g_color_FFFF525D));
                        textView.setEnabled(false);
                    }
                }
            });
            ((ImageView) this.f15233e.findViewById(R.id.tip_input_drawer_close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipInputPopWindow.this.dismiss();
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_close_ck", "source", "starratedetail");
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    TipInputPopWindow.this.f15231c.confirmClick(TipInputPopWindow.this.f15229a, TipInputPopWindow.this.f15230b);
                    TipInputPopWindow.this.dismiss();
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", "starratedetail");
                    if (!TipInputPopWindow.this.f15229a.isEmpty()) {
                        hashMap.put(CarServerParam.PARAM_FEE, TipInputPopWindow.this.f15229a);
                    }
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_complete_ck", (Map<String, Object>) hashMap);
                }
            });
        }
    }

    public void dismiss() {
        this.f15237i.setAnimation(AnimationUtils.loadAnimation(this.f15232d, R.anim.ggk_drawer_bottom_out));
        this.f15237i.requestLayout();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                TipInputPopWindow.super.dismiss();
            }
        }, 250);
    }
}
