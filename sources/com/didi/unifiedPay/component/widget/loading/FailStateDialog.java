package com.didi.unifiedPay.component.widget.loading;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;

public class FailStateDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private ImageView f47149a;

    /* renamed from: b */
    private TextView f47150b;

    /* renamed from: c */
    private TextView f47151c;

    /* renamed from: d */
    private TextView f47152d;

    /* renamed from: e */
    private onClickListener f47153e;

    /* renamed from: f */
    private Object f47154f;

    public static class Config {
        public static final int ICON_INFO = 2131689490;
        public static final int ICON_NETWORK_ERROR = 2131689489;
        public static final int ICON_SMILE = 2131689492;
        public String cancelText;
        public String confirmText;
        public boolean hideAllButton = false;
        public int icon = ICON_INFO;
        public onClickListener listener;
        public String message;
        public boolean singleButton = false;
    }

    public interface onClickListener {
        void onCancel();

        void onConfirm();
    }

    public FailStateDialog(Context context) {
        super(context);
        m35083a(context);
    }

    public FailStateDialog(Context context, int i) {
        super(context, i);
        m35083a(context);
    }

    protected FailStateDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        m35083a(context);
    }

    /* renamed from: a */
    private void m35083a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_pay_failed_layout, (ViewGroup) null);
        setContentView(inflate);
        this.f47149a = (ImageView) inflate.findViewById(R.id.oc_iv_fail_state_icon);
        this.f47150b = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_str);
        this.f47151c = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_cancle);
        this.f47152d = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_ok);
        this.f47151c.setOnClickListener(this);
        this.f47152d.setOnClickListener(this);
    }

    public void setIcon(Drawable drawable) {
        this.f47149a.setImageDrawable(drawable);
    }

    public void setIcon(int i) {
        this.f47149a.setImageResource(i);
    }

    public void setMessage(CharSequence charSequence) {
        if (charSequence == null || TextUtils.isEmpty(charSequence.toString())) {
            this.f47150b.setVisibility(8);
            return;
        }
        this.f47150b.setText(charSequence);
        this.f47150b.setVisibility(0);
    }

    public void setMessage(int i) {
        this.f47150b.setText(i);
        this.f47150b.setVisibility(0);
    }

    public void setCancelText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47151c.setText(str);
        }
    }

    public void setCancelText(int i) {
        this.f47151c.setText(i);
    }

    public void setConfirmText(int i) {
        this.f47152d.setText(i);
    }

    public void setConfirmText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f47152d.setText(str);
        }
    }

    public void setTag(Object obj) {
        this.f47154f = obj;
    }

    public Object getTag() {
        return this.f47154f;
    }

    public void setOnClickListener(onClickListener onclicklistener) {
        this.f47153e = onclicklistener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        onClickListener onclicklistener = this.f47153e;
        if (onclicklistener != null) {
            if (view == this.f47151c) {
                onclicklistener.onCancel();
            } else if (view == this.f47152d) {
                onclicklistener.onConfirm();
            }
        }
    }

    public void setupView(Config config) {
        if (config != null) {
            if (config.icon > 0) {
                this.f47149a.setImageResource(config.icon);
            }
            if (config.hideAllButton) {
                this.f47152d.setVisibility(8);
                this.f47151c.setVisibility(8);
            } else if (config.singleButton) {
                this.f47152d.setVisibility(0);
                this.f47151c.setVisibility(8);
            } else {
                this.f47152d.setVisibility(0);
                this.f47151c.setVisibility(0);
            }
            if (!TextUtil.isEmpty(config.confirmText)) {
                this.f47152d.setText(config.confirmText);
            } else {
                this.f47152d.setText(ResourcesHelper.getString(getContext(), R.string.oc_uni_pay_i_know));
            }
            if (!TextUtil.isEmpty(config.cancelText)) {
                this.f47151c.setText(config.cancelText);
            } else {
                this.f47151c.setText(ResourcesHelper.getString(getContext(), R.string.oc_fail_state_cancel));
            }
            this.f47150b.setText(config.message);
            setOnClickListener(config.listener);
        }
    }
}
