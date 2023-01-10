package com.didi.component.phoneentrance.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p101im.views.imageView.IMRoundedImageView;
import com.didi.sdk.view.dialog.AlertDialogBase;
import com.taxis99.R;

public class PhoneSecurityDialog extends AlertDialogBase {

    /* renamed from: a */
    private View f17080a;

    /* renamed from: b */
    private ImageView f17081b;

    /* renamed from: c */
    private TextView f17082c;

    /* renamed from: d */
    private TextView f17083d;

    /* renamed from: e */
    private Button f17084e;

    /* renamed from: f */
    private Button f17085f;

    public interface OnCancelClickedListener {
        void onCancelClicked(PhoneSecurityDialog phoneSecurityDialog);
    }

    public interface OnConfirmClickedListener {
        void onConfirmClicked(PhoneSecurityDialog phoneSecurityDialog);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static PhoneSecurityDialog m14331b(Context context) {
        PhoneSecurityDialog phoneSecurityDialog = new PhoneSecurityDialog();
        phoneSecurityDialog.m14334c(context);
        return phoneSecurityDialog;
    }

    /* renamed from: c */
    private void m14334c(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_phone_security_dialog_layout, (ViewGroup) null);
        this.f17080a = inflate;
        this.f17081b = (ImageView) inflate.findViewById(R.id.iv_phone_security_icon);
        this.f17082c = (TextView) this.f17080a.findViewById(R.id.tv_phone_security_title);
        this.f17083d = (TextView) this.f17080a.findViewById(R.id.tv_phone_security_content);
        this.f17084e = (Button) this.f17080a.findViewById(R.id.bt_phone_security_left);
        this.f17085f = (Button) this.f17080a.findViewById(R.id.bt_phone_security_right);
        ((IMRoundedImageView) this.f17080a.findViewById(R.id.iv_phone_security_icon)).setCornerType(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14323a(int i) {
        this.f17081b.setImageResource(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14328a(CharSequence charSequence) {
        this.f17082c.setText(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m14333b(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f17083d.setVisibility(8);
            return;
        }
        this.f17083d.setVisibility(0);
        this.f17083d.setText(charSequence);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14330a(CharSequence charSequence, final OnConfirmClickedListener onConfirmClickedListener) {
        this.f17085f.setText(charSequence);
        this.f17085f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                onConfirmClickedListener.onConfirmClicked(PhoneSecurityDialog.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14329a(CharSequence charSequence, final OnCancelClickedListener onCancelClickedListener) {
        this.f17084e.setText(charSequence);
        this.f17084e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                onCancelClickedListener.onCancelClicked(PhoneSecurityDialog.this);
            }
        });
    }

    /* access modifiers changed from: protected */
    public View getRootView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return this.f17080a;
    }

    public static class Builder {
        private OnCancelClickedListener mCancelListener;
        private CharSequence mCancelText;
        private OnConfirmClickedListener mConfirmListener;
        private CharSequence mConfirmText;
        private CharSequence mContent;
        private int mImageId = R.drawable.global_phone_security_dialog_icon;
        private CharSequence mTitle;

        public Builder setImage(int i) {
            this.mImageId = i;
            return this;
        }

        public Builder setTitle(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public Builder setContent(CharSequence charSequence) {
            this.mContent = charSequence;
            return this;
        }

        public Builder setConfirmListener(CharSequence charSequence, OnConfirmClickedListener onConfirmClickedListener) {
            this.mConfirmText = charSequence;
            this.mConfirmListener = onConfirmClickedListener;
            return this;
        }

        public Builder setCancelListener(CharSequence charSequence, OnCancelClickedListener onCancelClickedListener) {
            this.mCancelText = charSequence;
            this.mCancelListener = onCancelClickedListener;
            return this;
        }

        public PhoneSecurityDialog build(Context context) {
            PhoneSecurityDialog a = PhoneSecurityDialog.m14331b(context);
            a.m14323a(this.mImageId);
            a.m14328a(this.mTitle);
            a.m14333b(this.mContent);
            a.m14330a(this.mConfirmText, this.mConfirmListener);
            a.m14329a(this.mCancelText, this.mCancelListener);
            return a;
        }
    }
}
