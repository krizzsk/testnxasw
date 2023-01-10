package com.didi.payment.wallet.global.wallet.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class MobileTopUpTipDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private static final String f35376a = "MOBLIE_TOPUP_TIP_KEY";

    /* renamed from: b */
    private Context f35377b;

    /* renamed from: c */
    private LinearLayout f35378c;

    /* renamed from: d */
    private LinearLayout f35379d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnClickListener f35380e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f35381f;

    public MobileTopUpTipDialogFragment() {
        setStyle(0, R.style.cornerdialog);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        View inflate = layoutInflater.inflate(R.layout.wallet_global_dialog_mobile_topup_tip, (ViewGroup) null, false);
        this.f35378c = (LinearLayout) inflate.findViewById(R.id.ll_confirm);
        this.f35379d = (LinearLayout) inflate.findViewById(R.id.ll_cancel);
        this.f35378c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MobileTopUpTipDialogFragment.this.dismissAllowingStateLoss();
                if (MobileTopUpTipDialogFragment.this.f35380e != null) {
                    MobileTopUpTipDialogFragment.this.f35380e.onClick(view);
                }
            }
        });
        this.f35379d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MobileTopUpTipDialogFragment.this.dismissAllowingStateLoss();
                if (MobileTopUpTipDialogFragment.this.f35381f != null) {
                    MobileTopUpTipDialogFragment.this.f35381f.onClick(view);
                }
            }
        });
        return inflate;
    }

    public void show(FragmentManager fragmentManager, String str) {
        super.show(fragmentManager, str);
        PaySharedPreferencesUtil.putBoolean(this.f35377b, f35376a, true);
    }

    public void setConfirmClickListener(View.OnClickListener onClickListener) {
        this.f35380e = onClickListener;
    }

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        this.f35381f = onClickListener;
    }

    public void setContext(Context context) {
        this.f35377b = context;
    }

    public static boolean canShow(Context context) {
        return !PaySharedPreferencesUtil.getBoolean(context, f35376a, false);
    }
}
