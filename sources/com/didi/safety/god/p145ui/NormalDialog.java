package com.didi.safety.god.p145ui;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

/* renamed from: com.didi.safety.god.ui.NormalDialog */
public class NormalDialog extends DialogFragment implements DialogInterface.OnKeyListener, View.OnClickListener {

    /* renamed from: a */
    private TextView f37546a;

    /* renamed from: b */
    private TextView f37547b;

    /* renamed from: c */
    private TextView f37548c;

    /* renamed from: d */
    private TextView f37549d;

    /* renamed from: e */
    private View f37550e;

    /* renamed from: f */
    private View.OnClickListener f37551f;

    /* renamed from: g */
    private String f37552g;

    /* renamed from: h */
    private String f37553h;

    /* renamed from: i */
    private String f37554i;

    /* renamed from: j */
    private String f37555j;

    /* renamed from: k */
    private View f37556k;

    /* renamed from: l */
    private boolean f37557l;

    /* renamed from: m */
    private int f37558m;

    /* renamed from: n */
    private float f37559n;

    /* renamed from: o */
    private float f37560o;

    /* renamed from: p */
    private int f37561p;

    /* renamed from: q */
    private int f37562q;

    /* renamed from: r */
    private int f37563r;

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int i = this.f37561p;
        if (i != 0) {
            view = layoutInflater.inflate(i, viewGroup);
        } else {
            view = layoutInflater.inflate(R.layout.safety_god_dialog, viewGroup);
        }
        this.f37546a = (TextView) view.findViewById(R.id.title);
        this.f37547b = (TextView) view.findViewById(R.id.content);
        this.f37548c = (TextView) view.findViewById(R.id.cancel);
        this.f37549d = (TextView) view.findViewById(R.id.confirm);
        this.f37550e = view.findViewById(R.id.cancel_divider);
        this.f37556k = view.findViewById(R.id.bottom_layout);
        this.f37548c.setOnClickListener(this);
        this.f37549d.setOnClickListener(this);
        String str = this.f37552g;
        if (str != null) {
            this.f37546a.setText(str);
        } else {
            this.f37546a.setVisibility(8);
        }
        String str2 = this.f37553h;
        if (str2 != null) {
            this.f37547b.setText(str2);
        }
        float f = this.f37560o;
        if (f != 0.0f) {
            this.f37547b.setTextSize(0, f);
        }
        if (this.f37554i == null && this.f37555j == null) {
            this.f37556k.setVisibility(8);
        } else {
            String str3 = this.f37554i;
            if (str3 != null) {
                this.f37549d.setText(str3);
                int i2 = this.f37563r;
                if (i2 != 0) {
                    this.f37549d.setTextColor(i2);
                }
            } else {
                this.f37549d.setVisibility(8);
            }
            String str4 = this.f37555j;
            if (str4 != null) {
                this.f37548c.setText(str4);
                int i3 = this.f37562q;
                if (i3 != 0) {
                    this.f37548c.setTextColor(i3);
                }
            } else {
                this.f37548c.setVisibility(8);
                this.f37550e.setVisibility(8);
            }
        }
        getDialog().setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setOnKeyListener(this);
        return view;
    }

    public void setInfo(String str, String str2, String str3, String str4) {
        this.f37552g = str;
        this.f37553h = str2;
        this.f37554i = str3;
        this.f37555j = str4;
    }

    public void setConfirmTextColor(int i) {
        this.f37563r = i;
    }

    public void onResume() {
        Window window;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.safety_god_dialog_width);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.safety_god_dialog_height);
        int i = this.f37558m;
        if (i != 0) {
            dimensionPixelSize2 = i;
        }
        float f = this.f37559n;
        if (f != 0.0f) {
            dimensionPixelSize = (int) (((float) dimensionPixelSize) * f);
        }
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setLayout(dimensionPixelSize, dimensionPixelSize2);
        }
        super.onResume();
    }

    public void onStart() {
        super.onStart();
        if (this.f37557l) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
            attributes.width = displayMetrics.widthPixels;
            attributes.height = displayMetrics.heightPixels;
            attributes.gravity = 80;
            getDialog().getWindow().setAttributes(attributes);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        View.OnClickListener onClickListener = this.f37551f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f37551f = onClickListener;
    }

    public void show(Activity activity, String str) {
        try {
            setConfirmTextColor(activity.getResources().getColor(R.color.safety_god_confirm_color));
            FragmentTransaction beginTransaction = activity.getFragmentManager().beginTransaction();
            beginTransaction.add(this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
