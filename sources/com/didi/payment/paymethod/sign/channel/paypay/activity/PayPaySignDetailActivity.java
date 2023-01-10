package com.didi.payment.paymethod.sign.channel.paypay.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.router.ActivityLauncher;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.view.PayGlobalLoading;
import com.didi.payment.paymethod.omega.GlobalOmegaUtils;
import com.didi.payment.paymethod.sign.channel.paypay.contract.PayPaySignDetailContract;
import com.didi.payment.paymethod.sign.channel.paypay.presenter.PayPaySignDetailPresenter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class PayPaySignDetailActivity extends FragmentActivity implements PayPaySignDetailContract.View {

    /* renamed from: a */
    private static final String f33529a = "email";

    /* renamed from: b */
    private ImageView f33530b;

    /* renamed from: c */
    private TextView f33531c;

    /* renamed from: d */
    private TextView f33532d;

    /* renamed from: e */
    private TextView f33533e;

    /* renamed from: f */
    private TextView f33534f;

    /* renamed from: g */
    private String f33535g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public PayPaySignDetailContract.Presenter f33536h;

    public Activity getActivity() {
        return this;
    }

    public static void launch(Activity activity, String str, ActivityLauncher.Callback callback) {
        Intent intent = new Intent(activity, PayPaySignDetailActivity.class);
        intent.putExtra("email", str);
        ActivityLauncher.init(activity).startActivityForResult(intent, callback);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m25466c();
        m25467d();
        super.onCreate(bundle);
        setContentView((int) R.layout.paymethod_activity_global_paypay_detail);
        m25462a();
        m25465b();
    }

    /* renamed from: a */
    private void m25462a() {
        Intent intent = getIntent();
        if (intent == null) {
            setResult(0);
            finish();
        } else {
            this.f33535g = intent.getStringExtra("email");
        }
        this.f33536h = new PayPaySignDetailPresenter(this);
    }

    /* renamed from: b */
    private void m25465b() {
        this.f33531c = (TextView) findViewById(R.id.tv_email);
        this.f33533e = (TextView) findViewById(R.id.tv_title);
        this.f33532d = (TextView) findViewById(R.id.tv_right);
        this.f33530b = (ImageView) findViewById(R.id.iv_left);
        this.f33534f = (TextView) findViewById(R.id.tv_content_title);
        this.f33533e.setText(R.string.one_payment_global_detail_page_paypay_title);
        this.f33532d.setText(R.string.one_payment_global_detail_page_remove_btn);
        this.f33534f.setText(R.string.one_payment_global_detail_page_paypay_content_title);
        this.f33531c.setText(this.f33535g);
        this.f33532d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalOmegaUtils.trackPayPayRemoveCK(PayPaySignDetailActivity.this);
                PayPaySignDetailActivity payPaySignDetailActivity = PayPaySignDetailActivity.this;
                payPaySignDetailActivity.m25463a((FragmentActivity) payPaySignDetailActivity);
            }
        });
        this.f33530b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PayPaySignDetailActivity.this.onBackPressed();
            }
        });
    }

    public void showLoadingDialog() {
        PayGlobalLoading.show((Activity) this, (int) R.id.layout_title_bar, true);
    }

    public void dismissLoadingDialog() {
        PayGlobalLoading.hide();
    }

    public void onCancelSignSuccess(String str) {
        PayBaseToast.showSucc((Context) this, str);
        setResult(-1);
        finish();
    }

    public void onCancelSignFailure(String str) {
        PayBaseToast.showInfo((Context) this, str);
    }

    /* renamed from: c */
    private void m25466c() {
        setTheme(R.style.GlobalActivityTheme);
    }

    /* renamed from: d */
    private void m25467d() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25463a(FragmentActivity fragmentActivity) {
        final AlertDialogFragment create = new AlertDialogFragment.Builder(fragmentActivity).setMessage(fragmentActivity.getString(R.string.one_payment_global_detail_page_paypay_dialog_remove_content)).setIcon(AlertController.IconType.INFO).setPositiveButtonDefault().setNegativeButton((int) R.string.one_payment_global_detail_page_dialog_remove_negative, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                GlobalOmegaUtils.trackPayPayRemoveCancelCK(PayPaySignDetailActivity.this);
            }
        }).setPositiveButton((int) R.string.one_payment_global_detail_page_dialog_remove_positive, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                PayPaySignDetailActivity.this.f33536h.requestCancelSign();
                GlobalOmegaUtils.trackPayPayRemoveOKCK(PayPaySignDetailActivity.this);
            }
        }).create();
        create.show(fragmentActivity.getSupportFragmentManager(), "tag");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public void run() {
                if (create.getDialog() != null) {
                    create.getDialog().setCanceledOnTouchOutside(false);
                }
            }
        }, 500);
    }
}
