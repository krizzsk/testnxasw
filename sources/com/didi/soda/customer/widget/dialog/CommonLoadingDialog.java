package com.didi.soda.customer.widget.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public final class CommonLoadingDialog extends Dialog {
    public static final String DEFAULT_TAG = "CommonLoadingDialog";

    /* renamed from: a */
    private static final int f44308a = 5000;

    /* renamed from: b */
    private LottieLoadingView f44309b;

    /* renamed from: c */
    private View f44310c;

    /* renamed from: d */
    private boolean f44311d;

    /* renamed from: e */
    private SodaWindowFactory.DialogKeyBackListener f44312e;

    /* renamed from: f */
    private boolean f44313f;

    /* renamed from: g */
    private Runnable f44314g = new Runnable() {
        public void run() {
            if (!CommonLoadingDialog.this.isDestroyed()) {
                CommonLoadingDialog.this.m32947e();
            }
        }
    };

    public TransformAnimation getEnterAnimation() {
        return null;
    }

    public TransformAnimation getExitAnimation() {
        return null;
    }

    private CommonLoadingDialog(boolean z, boolean z2, boolean z3, SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener) {
        setCancelable(z);
        this.f44311d = z2;
        this.f44312e = dialogKeyBackListener;
        this.f44313f = z3;
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2) {
        return getLoadingDialog(z, z2, true, (SodaWindowFactory.DialogKeyBackListener) null);
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2, boolean z3, SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener) {
        return new CommonLoadingDialog(z, z2, z3, dialogKeyBackListener);
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_common_dialog_loading, (ViewGroup) null, false);
        this.f44310c = inflate.findViewById(R.id.loading_box_view);
        this.f44309b = (LottieLoadingView) inflate.findViewById(R.id.loading_dot_view);
        return inflate;
    }

    public boolean onHandleBack() {
        SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener = this.f44312e;
        if (dialogKeyBackListener != null) {
            return dialogKeyBackListener.handleBack();
        }
        return super.onHandleBack();
    }

    public void onDestroy() {
        UiHandlerUtil.removeCallbacks(this.f44314g);
    }

    public void onDismiss() {
        this.f44309b.stop();
        UiHandlerUtil.removeCallbacks(this.f44314g);
    }

    public void onShow() {
        this.f44309b.start();
        if (this.f44311d) {
            this.f44310c.setVisibility(0);
        } else {
            this.f44310c.setVisibility(8);
        }
        if (this.f44313f) {
            UiHandlerUtil.postDelayed(this.f44314g, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m32947e() {
        View view = getView();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CommonLoadingDialog.this.dismiss();
                }
            });
        }
    }
}
