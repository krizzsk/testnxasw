package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class FailStateView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f47111a;

    /* renamed from: b */
    private TextView f47112b;

    /* renamed from: c */
    private TextView f47113c;

    /* renamed from: d */
    private TextView f47114d;

    /* renamed from: e */
    private ClickListener f47115e;

    public interface ClickListener {
        void onCancel();

        void onConfirm();
    }

    public static class Config {
        public static final int ICON_INFO = 2131689490;
        public static final int ICON_NETWORK_ERROR = 2131689489;
        public static final int ICON_SMILE = 2131689492;
        public String cancelText;
        public String confirmText;
        public int errorCode;
        public boolean hideAllButton = false;
        public int icon = ICON_INFO;
        public ClickListener listener;
        public String message;
        public boolean singleButton = false;
    }

    public FailStateView(Context context) {
        super(context);
        m35054a();
    }

    public FailStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35054a();
    }

    /* renamed from: a */
    private void m35054a() {
        View inflate = inflate(getContext(), R.layout.oc_unified_pay_failed_state_layout, this);
        this.f47111a = (ImageView) inflate.findViewById(R.id.oc_iv_fail_state_icon);
        this.f47112b = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_str);
        this.f47113c = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_cancle);
        this.f47114d = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_ok);
        this.f47113c.setOnClickListener(this);
        this.f47114d.setOnClickListener(this);
    }

    public void setIcon(Drawable drawable) {
        this.f47111a.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.f47111a.setImageResource(i);
    }

    public void setMessage(CharSequence charSequence) {
        if (charSequence == null || TextUtils.isEmpty(charSequence.toString())) {
            this.f47112b.setVisibility(8);
            return;
        }
        this.f47112b.setText(charSequence);
        this.f47112b.setVisibility(0);
    }

    public void setMessage(int i) {
        this.f47112b.setText(i);
        this.f47112b.setVisibility(0);
    }

    public void setCancelText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47113c.setText(str);
        }
    }

    public void setCancelText(int i) {
        this.f47113c.setText(i);
    }

    public void setConfirmText(int i) {
        this.f47114d.setText(i);
    }

    public void setConfirmText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47114d.setText(str);
        }
    }

    public void setFailViewClickListener(ClickListener clickListener) {
        this.f47115e = clickListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        ClickListener clickListener = this.f47115e;
        if (clickListener != null) {
            if (view == this.f47113c) {
                clickListener.onCancel();
            } else if (view == this.f47114d) {
                clickListener.onConfirm();
            }
        }
    }

    public void setupView(Config config) {
        if (config != null) {
            if (config.icon > 0) {
                this.f47111a.setImageResource(config.icon);
            }
            if (config.hideAllButton) {
                this.f47114d.setVisibility(8);
                this.f47113c.setVisibility(8);
            } else {
                if (config.singleButton) {
                    this.f47113c.setVisibility(8);
                } else {
                    this.f47113c.setVisibility(0);
                    this.f47113c.setText(config.cancelText);
                }
                this.f47114d.setVisibility(0);
            }
            this.f47114d.setText(config.confirmText);
            if (TextUtils.isEmpty(config.message)) {
                this.f47112b.setVisibility(8);
            } else {
                this.f47112b.setVisibility(0);
                this.f47112b.setText(config.message);
            }
            setFailViewClickListener(config.listener);
        }
    }
}
