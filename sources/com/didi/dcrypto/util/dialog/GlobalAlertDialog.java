package com.didi.dcrypto.util.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.UIUtil;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GlobalAlertDialog extends BaseDialogFragment {

    /* renamed from: a */
    private View f18392a;

    /* renamed from: b */
    private TextView f18393b;

    /* renamed from: c */
    private TextView f18394c;

    /* renamed from: d */
    private TextView[] f18395d = new TextView[3];

    /* renamed from: e */
    private List<String> f18396e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<OnBtnClickListener> f18397f = new ArrayList();

    /* renamed from: g */
    private String f18398g;

    /* renamed from: h */
    private String f18399h;

    public interface OnBtnClickListener {
        void onBtnClick(DialogFragment dialogFragment, int i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            dialog.getWindow().getAttributes().windowAnimations = R.style.common_dialog_anim_style;
        }
        return layoutInflater.inflate(R.layout.pay_base_global_dialog_alert, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m15570a(view);
        m15569a();
    }

    /* renamed from: a */
    private void m15570a(View view) {
        this.f18392a = view.findViewById(R.id.image_close);
        this.f18393b = (TextView) view.findViewById(R.id.text_title);
        this.f18394c = (TextView) view.findViewById(R.id.text_message);
        this.f18395d[0] = (TextView) view.findViewById(R.id.button_top_bottom_1);
        this.f18395d[1] = (TextView) view.findViewById(R.id.button_top_bottom_2);
        this.f18395d[2] = (TextView) view.findViewById(R.id.button_top_bottom_3);
    }

    /* renamed from: a */
    private void m15569a() {
        int i = 0;
        while (i < this.f18395d.length && i < this.f18396e.size()) {
            TextView textView = this.f18395d[i];
            if (textView != null) {
                textView.setText(this.f18396e.get(i));
            }
            i++;
        }
        final int i2 = 0;
        while (i2 < this.f18395d.length && i2 < this.f18397f.size()) {
            TextView textView2 = this.f18395d[i2];
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        OnBtnClickListener onBtnClickListener = (OnBtnClickListener) GlobalAlertDialog.this.f18397f.get(i2);
                        if (onBtnClickListener != null) {
                            onBtnClickListener.onBtnClick(GlobalAlertDialog.this, i2);
                        }
                    }
                });
            }
            i2++;
        }
        int size = this.f18396e.size();
        while (true) {
            TextView[] textViewArr = this.f18395d;
            if (size >= textViewArr.length) {
                break;
            }
            ((View) textViewArr[size].getParent()).setVisibility(8);
            size++;
        }
        this.f18394c.setText(this.f18398g);
        if (!TextUtils.isEmpty(this.f18399h)) {
            this.f18393b.setVisibility(0);
            this.f18393b.setText(this.f18399h);
            return;
        }
        this.f18393b.setVisibility(8);
    }

    public void setMsg(String str) {
        this.f18398g = str;
    }

    public void setTitle(String str) {
        this.f18399h = str;
    }

    public void setButtons(List<String> list) {
        if (list != null) {
            this.f18396e.clear();
            this.f18396e.addAll(list);
        }
    }

    public void setListeners(List<OnBtnClickListener> list) {
        if (list != null) {
            this.f18397f.clear();
            this.f18397f.addAll(list);
        }
    }

    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            dialog.getWindow().setLayout(displayMetrics.widthPixels - UIUtil.dip2px(getContext(), 108.0f), -2);
        }
    }
}
