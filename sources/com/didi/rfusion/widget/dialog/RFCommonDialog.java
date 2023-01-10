package com.didi.rfusion.widget.dialog;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFCommonDialog extends RFDialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CommonModel f36247a;

    /* renamed from: b */
    private RFTextView f36248b;

    /* renamed from: c */
    private FrameLayout f36249c;

    /* renamed from: d */
    private NestedScrollView f36250d;

    /* renamed from: e */
    private boolean f36251e;

    public interface OnInflaterListener {
        View onInflater(LayoutInflater layoutInflater, ViewGroup viewGroup);
    }

    private RFCommonDialog() {
        this.f36247a = new CommonModel();
    }

    /* access modifiers changed from: protected */
    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) layoutInflater.inflate(R.layout.rf_dialog_common, viewGroup, false);
        this.f36249c = frameLayout;
        return frameLayout;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        m27306e();
    }

    /* renamed from: e */
    private void m27306e() {
        if (!TextUtils.isEmpty(this.f36247a.message)) {
            setMessage(this.f36247a.message);
        }
        if (this.f36247a.view != null) {
            setView(this.f36247a.view);
        }
        if (this.f36247a.inflaterListener != null) {
            setView(this.f36247a.inflaterListener);
        }
    }

    /* renamed from: f */
    private void m27307f() {
        if (isPrepared() && this.f36251e) {
            this.f36249c.post(new Runnable() {
                public final void run() {
                    RFCommonDialog.this.m27309h();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ void m27309h() {
        int dimens = (int) RFResUtils.getDimens(R.dimen.rf_dialog_margin_height);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36249c.getLayoutParams();
        if (!TextUtils.isEmpty(getTitle())) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = dimens;
            layoutParams.gravity = 0;
            if (this.f36248b.getLineCount() <= 1) {
                this.f36248b.setGravity(1);
            } else {
                this.f36248b.setGravity(0);
            }
        } else {
            layoutParams.topMargin = dimens;
            layoutParams.bottomMargin = dimens;
            layoutParams.gravity = 17;
        }
        this.f36249c.setLayoutParams(layoutParams);
    }

    public void setMessage(CharSequence charSequence) {
        if (!isPrepared()) {
            this.f36247a.setMessage(charSequence);
            return;
        }
        if (!this.f36251e) {
            this.f36249c.removeAllViews();
            NestedScrollView nestedScrollView = (NestedScrollView) LayoutInflater.from(getContext()).inflate(R.layout.rf_layout_dialog_common_content, this.f36249c, false);
            this.f36250d = nestedScrollView;
            RFTextView rFTextView = (RFTextView) nestedScrollView.findViewById(R.id.rf_tv_content);
            this.f36248b = rFTextView;
            rFTextView.setLineSpacing((float) RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_6), 1.0f);
            this.f36249c.addView(this.f36250d);
            this.f36251e = true;
        }
        this.f36248b.setText(charSequence);
        m27307f();
    }

    public void setView(View view) {
        if (!isPrepared()) {
            this.f36247a.setView(view);
            return;
        }
        this.f36249c.removeAllViews();
        this.f36249c.addView(view);
        this.f36251e = false;
        m27308g();
    }

    /* renamed from: g */
    private void m27308g() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36249c.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        layoutParams.gravity = 0;
        this.f36249c.setLayoutParams(layoutParams);
    }

    public void setView(OnInflaterListener onInflaterListener) {
        if (!isPrepared()) {
            this.f36247a.setView(onInflaterListener);
        } else if (onInflaterListener != null) {
            this.f36249c.addView(onInflaterListener.onInflater(LayoutInflater.from(getContext()), this.f36249c));
            this.f36251e = false;
            m27308g();
        }
    }

    public CharSequence getMessage() {
        return !isPrepared() ? this.f36247a.message : this.f36248b.getText();
    }

    public void setTitle(String str) {
        super.setTitle(str);
        m27307f();
    }

    public static class Builder extends RFDialogBuilder<Builder, RFCommonDialog> {
        CommonModel model = new CommonModel();

        public Builder setMessage(CharSequence charSequence) {
            this.model.setMessage(charSequence);
            return this;
        }

        public Builder setView(View view) {
            this.model.setView(view);
            return this;
        }

        public Builder setView(OnInflaterListener onInflaterListener) {
            this.model.setView(onInflaterListener);
            return this;
        }

        /* access modifiers changed from: protected */
        public RFCommonDialog createDialog() {
            RFCommonDialog rFCommonDialog = new RFCommonDialog();
            CommonModel unused = rFCommonDialog.f36247a = this.model;
            return rFCommonDialog;
        }
    }

    private static class CommonModel {
        public OnInflaterListener inflaterListener;
        public CharSequence message;
        public View view;

        private CommonModel() {
        }

        public void setMessage(CharSequence charSequence) {
            this.message = charSequence;
            this.view = null;
            this.inflaterListener = null;
        }

        public void setView(View view2) {
            this.view = view2;
            this.message = null;
            this.inflaterListener = null;
        }

        public void setView(OnInflaterListener onInflaterListener) {
            this.inflaterListener = onInflaterListener;
            this.message = null;
            this.view = null;
        }
    }
}
