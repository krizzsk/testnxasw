package com.didi.payment.creditcard.global.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.creditcard.global.omega.GlobalOmegaConstant;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.taxis99.R;

public class CheckTipDialogFragment extends BottomSheetDialog {
    public static final int TYPE_CID = 2;
    public static final int TYPE_CVV = 1;
    public static final int TYPE_DATE = 3;

    /* renamed from: a */
    private Context f33076a;

    /* renamed from: b */
    private View f33077b;

    /* renamed from: c */
    private TextView f33078c;

    /* renamed from: d */
    private TextView f33079d;

    /* renamed from: e */
    private ImageView f33080e;

    /* renamed from: f */
    private DialogCallback f33081f;

    public interface DialogCallback {
        void afterDismiss();

        void beforeShow();
    }

    public CheckTipDialogFragment(Context context) {
        super(context);
        m25130a(context);
    }

    public CheckTipDialogFragment(Context context, int i) {
        super(context, i);
        m25130a(context);
    }

    protected CheckTipDialogFragment(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        m25130a(context);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        BottomSheetBehavior from;
        super.onStart();
        try {
            if (this.f33077b != null && (from = BottomSheetBehavior.from((View) this.f33077b.getParent())) != null) {
                from.setState(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m25130a(Context context) {
        this.f33076a = context;
        View inflate = getLayoutInflater().inflate(R.layout.one_payment_creditcard_global_dialog_check_tip, (ViewGroup) null);
        this.f33077b = inflate;
        this.f33078c = (TextView) inflate.findViewById(R.id.tv_title);
        this.f33079d = (TextView) inflate.findViewById(R.id.tv_content);
        this.f33080e = (ImageView) inflate.findViewById(R.id.iv_card_icon);
        inflate.findViewById(R.id.btn_commit).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CheckTipDialogFragment.this.dismiss();
            }
        });
        setContentView(inflate);
    }

    public void show(int i) {
        m25129a(i);
        if (isShowing()) {
            dismiss();
        }
        SystemUtils.showDialog(this);
    }

    public void show(int i, DialogCallback dialogCallback) {
        this.f33081f = dialogCallback;
        if (dialogCallback != null) {
            dialogCallback.beforeShow();
        }
        show(i);
    }

    public void dismiss() {
        super.dismiss();
        DialogCallback dialogCallback = this.f33081f;
        if (dialogCallback != null) {
            dialogCallback.afterDismiss();
        }
    }

    /* renamed from: a */
    private void m25129a(int i) {
        Resources resources = this.f33076a.getResources();
        if (i == 1) {
            this.f33078c.setText(resources.getText(R.string.one_payment_creditcard_global_tipdialog_cvv_title));
            this.f33079d.setText(resources.getText(R.string.one_payment_creditcard_global_tipdialog_cvv_content));
            this.f33080e.setImageResource(R.drawable.one_payment_creditcard_check_tip_cvv);
            GlobalOmegaUtils.track(this.f33076a, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_CREDITCARD_CVVHLP_CL);
        } else if (i == 2) {
            this.f33078c.setText(resources.getText(R.string.one_payment_creditcard_global_tipdialog_cid_title));
            this.f33079d.setText(resources.getText(R.string.one_payment_creditcard_global_tipdialog_cid_content));
            this.f33080e.setImageResource(R.drawable.one_payment_creditcard_check_tip_cid);
            GlobalOmegaUtils.track(this.f33076a, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_CREDITCARD_CIDHLP_CL);
        } else if (i == 3) {
            this.f33078c.setText(resources.getText(R.string.one_payment_creditcard_global_tipdialog_date_title));
            this.f33079d.setText(resources.getText(R.string.one_payment_creditcard_global_tipdialog_date_content));
            this.f33080e.setImageResource(R.drawable.one_payment_creditcard_check_tip_date);
            GlobalOmegaUtils.track(this.f33076a, GlobalOmegaConstant.AddCardPage.EventId.GLOBAL_PAS_CREDITCARD_VLDHLP_CL);
        }
    }
}
