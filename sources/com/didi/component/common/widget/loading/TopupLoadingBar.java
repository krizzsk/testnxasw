package com.didi.component.common.widget.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;

public class TopupLoadingBar {

    /* renamed from: a */
    private final Context f13905a;

    /* renamed from: b */
    private Dialog f13906b;

    public TopupLoadingBar(Activity activity) {
        this.f13905a = activity;
    }

    public void showInfoDialog(int i) {
        Context context = this.f13905a;
        if (context != null && !((Activity) context).isFinishing()) {
            if (this.f13906b == null) {
                View inflate = LayoutInflater.from(this.f13905a).inflate(R.layout.g_payment_loading, (ViewGroup) null);
                Dialog dialog = new Dialog(this.f13905a, R.style.gp_topup_dialog_style);
                this.f13906b = dialog;
                dialog.setContentView(inflate);
                Window window = this.f13906b.getWindow();
                window.setGravity(80);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = UIUtils.getScreenWidth(this.f13905a);
                window.setAttributes(attributes);
            }
            ProgressBar progressBar = (ProgressBar) this.f13906b.findViewById(R.id.g_payment_loading_progressbar);
            ImageView imageView = (ImageView) this.f13906b.findViewById(R.id.g_payment_loading_icon);
            TextView textView = (TextView) this.f13906b.findViewById(R.id.g_payment_loading_text);
            boolean z = false;
            if (i == LoadingState.TYPE_SUCCESS5.type) {
                progressBar.setVisibility(8);
                imageView.setVisibility(0);
                imageView.setBackgroundResource(R.drawable.g_icon_payment_success);
                textView.setText(R.string.GRider_0_Success_ocUh);
            } else {
                progressBar.setVisibility(0);
                imageView.setVisibility(8);
                if (i == LoadingState.TYPE_WAITING.type) {
                    textView.setText(R.string.g_payment_waiting);
                } else if (i == LoadingState.TYPE_REFRESHING.type) {
                    textView.setText(R.string.g_payment_refreshing);
                } else if (i == LoadingState.TYPE_PAYING.type) {
                    textView.setText(R.string.g_payment_paying);
                } else if (i == LoadingState.TYPE_FAILURE.type) {
                    textView.setText(R.string.GRider_0_Failed_to_XZku);
                } else {
                    textView.setText(R.string.GRider_0_In_the_nmGX);
                }
            }
            if (i == LoadingState.TYPE_FAILURE.type || i == LoadingState.TYPE_SUCCESS5.type) {
                z = true;
            }
            this.f13906b.setCancelable(z);
            if (!this.f13906b.isShowing()) {
                SystemUtils.showDialog(this.f13906b);
            }
        }
    }

    public void hideInfoDialog() {
        Dialog dialog = this.f13906b;
        if (dialog != null) {
            dialog.dismiss();
            this.f13906b = null;
        }
    }

    public enum LoadingState {
        TYPE_LOADING(1),
        TYPE_REFRESHING(2),
        TYPE_PAYING(3),
        TYPE_WAITING(4),
        TYPE_SUCCESS5(5),
        TYPE_FAILURE(6);
        
        public int type;

        private LoadingState(int i) {
            this.type = i;
        }
    }
}
