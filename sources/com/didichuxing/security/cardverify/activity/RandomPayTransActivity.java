package com.didichuxing.security.cardverify.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerDismissListener;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.didichuxing.security.cardverify.presenter.VerificationPrePresenter;
import com.didichuxing.security.cardverify.report.DiCardVerifyTracker;
import com.didichuxing.security.cardverify.utils.VerifyDialogUtil;
import com.google.gson.Gson;

public class RandomPayTransActivity extends FragmentActivity {
    public static final String EXTRA_MSG = "msg";
    public static final String EXTRA_PARAM = "param";
    public static DiCardVerifyCallback callback;

    /* renamed from: a */
    private int f51459a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LEGODrawer f51460b = null;

    public static void start(Context context, DiCardVerifyParam diCardVerifyParam, String str, DiCardVerifyCallback diCardVerifyCallback) {
        callback = diCardVerifyCallback;
        Intent intent = new Intent(context, RandomPayTransActivity.class);
        intent.putExtra("param", new Gson().toJson((Object) diCardVerifyParam));
        intent.putExtra("msg", str);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        DiCardVerifyParam diCardVerifyParam = (DiCardVerifyParam) new Gson().fromJson(getIntent().getStringExtra("param"), DiCardVerifyParam.class);
        new VerificationPrePresenter(diCardVerifyParam).startVerification(this, diCardVerifyParam, getIntent().getStringExtra("msg"), callback);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        callback = null;
    }

    public void finish() {
        int i = this.f51459a;
        if (2 == i) {
            DiCardVerifyTracker.trackDeductSucceed();
        } else if (1 == i) {
            DiCardVerifyTracker.trackDeductFailed();
        }
        LEGODrawer lEGODrawer = this.f51460b;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            super.finish();
            return;
        }
        this.f51460b.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                RandomPayTransActivity.super.finish();
            }
        });
        this.f51460b.dismiss();
    }

    public void payStart() {
        this.f51459a = 1;
    }

    public void paySuccess() {
        this.f51459a = 2;
    }

    public void showVerifyConfirmDialog(final String str, final View.OnClickListener onClickListener, final View.OnClickListener onClickListener2) {
        LEGODrawer lEGODrawer = this.f51460b;
        if (lEGODrawer == null || !lEGODrawer.isShowing()) {
            this.f51460b = VerifyDialogUtil.showVerifyConfirmDialog(this, str, onClickListener, onClickListener2);
            return;
        }
        this.f51460b.setDismissListener(new LEGODrawerDismissListener() {
            public void onDismiss() {
                RandomPayTransActivity randomPayTransActivity = RandomPayTransActivity.this;
                LEGODrawer unused = randomPayTransActivity.f51460b = VerifyDialogUtil.showVerifyConfirmDialog(randomPayTransActivity, str, onClickListener, onClickListener2);
            }
        });
        this.f51460b.dismiss();
    }

    public void showDrawerLoading() {
        LEGODrawer lEGODrawer = this.f51460b;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f51460b.showLoading();
        }
    }
}
