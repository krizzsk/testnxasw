package com.didi.entrega.customer.widget.dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.widget.dialog.SodaWindowFactory;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public final class CommonLoadingDialog extends Dialog {
    public static final String DEFAULT_TAG = "CommonLoadingDialog";

    /* renamed from: a */
    private static final int f22249a = 5000;

    /* renamed from: b */
    private LottieLoadingView f22250b;

    /* renamed from: c */
    private View f22251c;

    /* renamed from: d */
    private boolean f22252d;

    /* renamed from: e */
    private SodaWindowFactory.DialogKeyBackListener f22253e;

    /* renamed from: f */
    private boolean f22254f;

    /* renamed from: g */
    private Runnable f22255g = new Runnable() {
        public void run() {
            if (!CommonLoadingDialog.this.isDestroyed()) {
                CommonLoadingDialog.this.m18360e();
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
        this.f22252d = z2;
        this.f22253e = dialogKeyBackListener;
        this.f22254f = z3;
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2) {
        return getLoadingDialog(z, z2, true, (SodaWindowFactory.DialogKeyBackListener) null);
    }

    public static CommonLoadingDialog getLoadingDialog(boolean z, boolean z2, boolean z3, SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener) {
        return new CommonLoadingDialog(z, z2, z3, dialogKeyBackListener);
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.entrega_customer_common_dialog_loading, (ViewGroup) null, false);
        this.f22251c = inflate.findViewById(R.id.loading_box_view);
        this.f22250b = (LottieLoadingView) inflate.findViewById(R.id.loading_dot_view);
        return inflate;
    }

    public boolean onHandleBack() {
        SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener = this.f22253e;
        if (dialogKeyBackListener != null) {
            return dialogKeyBackListener.handleBack();
        }
        return super.onHandleBack();
    }

    public void onDestroy() {
        UiHandlerUtil.removeCallbacks(this.f22255g);
    }

    public void onDismiss() {
        this.f22250b.stop();
        UiHandlerUtil.removeCallbacks(this.f22255g);
    }

    public void onShow() {
        this.f22250b.start();
        if (this.f22252d) {
            this.f22251c.setVisibility(0);
        } else {
            this.f22251c.setVisibility(8);
        }
        if (this.f22254f) {
            UiHandlerUtil.postDelayed(this.f22255g, 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m18360e() {
        View view = getView();
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    CommonLoadingDialog.this.dismiss();
                }
            });
        }
    }
}
