package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class PhotoDialog implements View.OnClickListener {

    /* renamed from: a */
    private final Dialog f19122a;

    /* renamed from: b */
    private final View f19123b;

    /* renamed from: c */
    private final View f19124c;

    /* renamed from: d */
    private final TextView f19125d;

    /* renamed from: e */
    private SingleCallback<Void> f19126e;

    /* renamed from: f */
    private SingleCallback<Void> f19127f;

    /* renamed from: g */
    private SingleCallback<Void> f19128g;

    PhotoDialog(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dimina_photo_select_type, (ViewGroup) null);
        this.f19123b = inflate.findViewById(R.id.take_capture);
        this.f19124c = inflate.findViewById(R.id.take_pick);
        this.f19125d = (TextView) inflate.findViewById(R.id.take_cancel);
        this.f19123b.setOnClickListener(this);
        this.f19124c.setOnClickListener(this);
        this.f19125d.setOnClickListener(this);
        this.f19122a = new AlertDialog.Builder(context, R.style.DiminaPhotoDialog).setCancelable(false).setView(inflate).create();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60717a(int i) {
        TextView textView = this.f19125d;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60716a() {
        Dialog dialog = this.f19122a;
        if (dialog != null) {
            SystemUtils.showDialog(dialog);
            if (this.f19122a.getWindow() != null) {
                Window window = this.f19122a.getWindow();
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = -2;
                attributes.width = -1;
                attributes.gravity = 81;
                window.setAttributes(attributes);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60718a(SingleCallback<Void> singleCallback) {
        this.f19126e = singleCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo60719b(SingleCallback<Void> singleCallback) {
        this.f19127f = singleCallback;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo60720c(SingleCallback<Void> singleCallback) {
        this.f19128g = singleCallback;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view == this.f19125d) {
            this.f19122a.dismiss();
            SingleCallback<Void> singleCallback = this.f19128g;
            if (singleCallback != null) {
                singleCallback.onCallback(null);
            }
        } else if (view == this.f19124c) {
            this.f19122a.dismiss();
            SingleCallback<Void> singleCallback2 = this.f19126e;
            if (singleCallback2 != null) {
                singleCallback2.onCallback(null);
            }
        } else if (view == this.f19123b) {
            this.f19122a.dismiss();
            SingleCallback<Void> singleCallback3 = this.f19127f;
            if (singleCallback3 != null) {
                singleCallback3.onCallback(null);
            }
        }
    }
}
