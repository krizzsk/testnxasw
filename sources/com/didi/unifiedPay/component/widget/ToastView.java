package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.unifiedPay.util.UiThreadHandler;
import com.taxis99.R;

public class ToastView extends FrameLayout {

    /* renamed from: a */
    private ImageView f47130a;

    /* renamed from: b */
    private TextView f47131b;

    /* renamed from: c */
    private long f47132c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DismissListener f47133d;

    public static class Config {
        public static final int ICON_INFO = 2131689490;
        public static final int ICON_NETWORK_ERROR = 2131689489;
        public static final int ICON_SMILE = 2131689492;

        /* renamed from: ICON_SUCCESS */
        public static final int dialog_icon_success = 2131689491;
        public long dismissMs = 2000;
        public int icon = ICON_INFO;
        public DismissListener listener;
        public String message;
    }

    public interface DismissListener {
        void onDismiss();
    }

    public ToastView(Context context) {
        super(context);
        m35067a();
    }

    public ToastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m35067a();
    }

    /* renamed from: a */
    private void m35067a() {
        View inflate = inflate(getContext(), R.layout.oc_unified_pay_failed_state_layout, this);
        this.f47130a = (ImageView) inflate.findViewById(R.id.oc_iv_fail_state_icon);
        this.f47131b = (TextView) inflate.findViewById(R.id.oc_tv_fail_state_str);
        ((LinearLayout) inflate.findViewById(R.id.oc_ll_fail_state_btn)).setVisibility(8);
    }

    public void setupView(Config config) {
        if (config != null) {
            this.f47132c = config.dismissMs;
            if (config.icon > 0) {
                this.f47130a.setImageResource(config.icon);
            }
            if (TextUtils.isEmpty(config.message)) {
                this.f47131b.setVisibility(8);
            } else {
                this.f47131b.setVisibility(0);
                this.f47131b.setText(config.message);
            }
            m35068b();
        }
    }

    /* renamed from: b */
    private void m35068b() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                if (ToastView.this.f47133d != null) {
                    ToastView.this.f47133d.onDismiss();
                }
            }
        }, this.f47132c);
    }

    public void setListener(DismissListener dismissListener) {
        this.f47133d = dismissListener;
    }
}
