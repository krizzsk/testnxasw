package com.didi.component.evaluateentrance.evaluate.view;

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
import com.didi.component.evaluateentrance.evaluate.model.GXPCarTipInfo;
import com.global.didi.elvish.Elvish;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class GXPTipInputPopWindow extends PopupWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f15389a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Double f15390b = Double.valueOf(0.0d);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ConfirmButtonClickListener f15391c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f15392d;

    /* renamed from: e */
    private View f15393e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public GXPCarTipInfo f15394f;

    /* renamed from: g */
    private double f15395g = 0.0d;

    /* renamed from: h */
    private String f15396h = "";

    /* renamed from: i */
    private View f15397i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public EditText f15398j;

    public interface ConfirmButtonClickListener {
        void confirmClick(String str, Double d);
    }

    public GXPTipInputPopWindow(View view, int i, int i2, Context context, GXPCarTipInfo gXPCarTipInfo, double d, String str, ConfirmButtonClickListener confirmButtonClickListener) {
        super(view, i, i2);
        this.f15393e = view;
        this.f15391c = confirmButtonClickListener;
        this.f15392d = context;
        this.f15394f = gXPCarTipInfo;
        this.f15395g = d;
        this.f15396h = str;
        m12692a();
    }

    public void show() {
        Context context = this.f15392d;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !isShowing()) {
            setFocusable(true);
            setInputMethodMode(1);
            setSoftInputMode(16);
            setBackgroundDrawable(new ColorDrawable(1076176429));
            setClippingEnabled(true);
            setOutsideTouchable(true);
            this.f15397i.setAnimation(AnimationUtils.loadAnimation(this.f15392d, R.anim.ggk_drawer_bottom_in));
            showAtLocation(this.f15393e, 80, 0, 0);
            this.f15398j.requestFocus();
            this.f15398j.setFocusableInTouchMode(true);
            ((InputMethodManager) this.f15398j.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
        }
    }

    /* renamed from: a */
    private void m12692a() {
        if (this.f15394f != null) {
            this.f15397i = this.f15393e.findViewById(R.id.tip_popup_view);
            this.f15398j = (EditText) this.f15393e.findViewById(R.id.tip_input_drawer_et);
            final TextView textView = (TextView) this.f15393e.findViewById(R.id.tip_input_drawer_btn);
            TextView textView2 = (TextView) this.f15393e.findViewById(R.id.currency_text);
            final ImageView imageView = (ImageView) this.f15393e.findViewById(R.id.del_text_btn);
            if (this.f15395g == 0.0d) {
                EditText editText = this.f15398j;
                editText.setHint(this.f15394f.min + "-" + this.f15394f.max);
                textView.setEnabled(false);
                imageView.setVisibility(8);
            } else {
                EditText editText2 = this.f15398j;
                editText2.setText(this.f15395g + "");
                this.f15389a = this.f15396h;
                this.f15390b = Double.valueOf(this.f15395g);
                textView.setEnabled(true);
                imageView.setVisibility(0);
            }
            textView2.setText(this.f15394f.currency);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GXPTipInputPopWindow.this.f15398j.setText("");
                    if (GXPTipInputPopWindow.this.f15394f != null) {
                        EditText a = GXPTipInputPopWindow.this.f15398j;
                        a.setHint(GXPTipInputPopWindow.this.f15394f.min + "-" + GXPTipInputPopWindow.this.f15394f.max);
                    }
                    imageView.setVisibility(8);
                }
            });
            this.f15398j.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    imageView.setVisibility(0);
                    try {
                        String unused = GXPTipInputPopWindow.this.f15389a = Elvish.Companion.getInstance().formatNumber(Double.valueOf(Double.parseDouble(editable.toString())), -1, 1);
                        if (!GXPTipInputPopWindow.this.f15389a.isEmpty()) {
                            Double unused2 = GXPTipInputPopWindow.this.f15390b = Double.valueOf(Elvish.Companion.getInstance().parseNumberSafety(GXPTipInputPopWindow.this.f15389a, Double.valueOf(0.0d)).doubleValue());
                            if (GXPTipInputPopWindow.this.f15390b.doubleValue() <= 0.0d) {
                                GXPTipInputPopWindow.this.f15398j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f15392d, R.color.g_color_000));
                                textView.setEnabled(false);
                            } else if (GXPTipInputPopWindow.this.f15390b.doubleValue() >= ((double) GXPTipInputPopWindow.this.f15394f.min) && GXPTipInputPopWindow.this.f15390b.doubleValue() <= ((double) GXPTipInputPopWindow.this.f15394f.max)) {
                                GXPTipInputPopWindow.this.f15398j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f15392d, R.color.g_color_000));
                                textView.setEnabled(true);
                            } else if (GXPTipInputPopWindow.this.f15390b.doubleValue() > ((double) GXPTipInputPopWindow.this.f15394f.max)) {
                                GXPTipInputPopWindow.this.f15398j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f15392d, R.color.g_color_FFFF525D));
                                textView.setEnabled(false);
                                HashMap hashMap = new HashMap();
                                hashMap.put(CarServerParam.PARAM_FEE, GXPTipInputPopWindow.this.f15390b.toString());
                                hashMap.put("source", "tipentrance");
                                GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_error_bt", (Map<String, Object>) hashMap);
                            } else {
                                GXPTipInputPopWindow.this.f15398j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f15392d, R.color.g_color_000));
                                textView.setEnabled(false);
                            }
                        } else {
                            GXPTipInputPopWindow.this.f15398j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f15392d, R.color.g_color_FFFF525D));
                            textView.setEnabled(false);
                        }
                    } catch (NumberFormatException unused3) {
                        GXPTipInputPopWindow.this.f15398j.setTextColor(ContextCompat.getColor(GXPTipInputPopWindow.this.f15392d, R.color.g_color_FFFF525D));
                        textView.setEnabled(false);
                    }
                }
            });
            ((ImageView) this.f15393e.findViewById(R.id.tip_input_drawer_close)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GXPTipInputPopWindow.this.dismiss();
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_close_ck", "source", "tipentrance");
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GXPTipInputPopWindow.this.f15391c.confirmClick(GXPTipInputPopWindow.this.f15389a, GXPTipInputPopWindow.this.f15390b);
                    GXPTipInputPopWindow.this.dismiss();
                    HashMap hashMap = new HashMap();
                    hashMap.put("source", "tipentrance");
                    if (!GXPTipInputPopWindow.this.f15389a.isEmpty()) {
                        hashMap.put(CarServerParam.PARAM_FEE, GXPTipInputPopWindow.this.f15389a);
                    }
                    GlobalOmegaUtils.trackEvent("ibt_gp_tipeamount_complete_ck", (Map<String, Object>) hashMap);
                }
            });
        }
    }

    public void dismiss() {
        this.f15397i.setAnimation(AnimationUtils.loadAnimation(this.f15392d, R.anim.ggk_drawer_bottom_out));
        this.f15397i.requestLayout();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                GXPTipInputPopWindow.super.dismiss();
            }
        }, 250);
    }
}
