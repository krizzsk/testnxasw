package com.google.p223ar.core;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.apm.SystemUtils;
import com.google.p223ar.core.ArCoreApk;
import com.google.p223ar.core.exceptions.FatalException;
import com.google.p223ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p223ar.core.exceptions.UnavailableUserDeclinedInstallationException;
import com.taxis99.R;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.ar.core.InstallActivity */
public class InstallActivity extends Activity {
    private static final int BOX_SIZE_DP = 280;
    private static final int INSTALLING_TEXT_BOTTOM_MARGIN_DP = 30;
    static final String INSTALL_BEHAVIOR_KEY = "behavior";
    static final String MESSAGE_TYPE_KEY = "message";
    private static final String TAG = "ARCore-InstallActivity";
    private boolean finished;
    private ArCoreApk.InstallBehavior installBehavior;
    private boolean installStarted;
    /* access modifiers changed from: private */
    public C20290o lastEvent = C20290o.CANCELLED;
    private ArCoreApk.UserMessageType messageType;
    private final ContextThemeWrapper themeWrapper = new ContextThemeWrapper(this, 16974394);
    /* access modifiers changed from: private */
    public boolean waitingForCompletion;

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                finishWithFailure(new FatalException("Install activity was suspended and recreated."));
            } catch (RuntimeException e) {
                finishWithFailure(new FatalException("Exception starting install flow", e));
            }
        } else {
            this.messageType = (ArCoreApk.UserMessageType) getIntent().getSerializableExtra("message");
            ArCoreApk.InstallBehavior installBehavior2 = (ArCoreApk.InstallBehavior) getIntent().getSerializableExtra(INSTALL_BEHAVIOR_KEY);
            this.installBehavior = installBehavior2;
            if (this.messageType != null) {
                if (installBehavior2 != null) {
                    setTheme(16974394);
                    getWindow().requestFeature(1);
                    setFinishOnTouchOutside(isOptional());
                    if (this.messageType == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                        showSpinner();
                        return;
                    }
                    AtomicReference atomicReference = new AtomicReference(ArCoreApk.Availability.UNKNOWN_CHECKING);
                    C20283h.m42667a().mo164848a((Context) this).mo164858a((Context) this, (ArCoreApk.C20243a) new C20257ac(atomicReference));
                    int ordinal = ((ArCoreApk.Availability) atomicReference.get()).ordinal();
                    if (ordinal == 0) {
                        SystemUtils.log(5, TAG, "Preliminary compatibility check failed.", (Throwable) null, "com.google.ar.core.InstallActivity", 28);
                    } else if (ordinal == 3) {
                        finishWithFailure(new UnavailableDeviceNotCompatibleException());
                        return;
                    }
                    showEducationDialog();
                    return;
                }
            }
            SystemUtils.log(6, TAG, "missing intent data.", (Throwable) null, "com.google.ar.core.InstallActivity", 13);
            finishWithFailure(new FatalException("Install activity launched without config data."));
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("didResume", true);
    }

    private void showEducationDialog() {
        setContentView(R.layout.__arcore_education);
        findViewById(R.id.__arcore_cancelButton).setOnClickListener(new C20287l(this));
        if (!isOptional()) {
            findViewById(R.id.__arcore_cancelButton).setVisibility(8);
        }
        findViewById(R.id.__arcore_continueButton).setOnClickListener(new C20286k(this));
        TextView textView = (TextView) findViewById(R.id.__arcore_messageText);
        if (this.messageType.ordinal() != 1) {
            textView.setText(R.string.__arcore_install_app);
        } else {
            textView.setText(R.string.__arcore_install_feature);
        }
    }

    /* access modifiers changed from: private */
    public void showSpinner() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (displayMetrics.density * 280.0f);
        getWindow().setLayout(i, i);
        RelativeLayout relativeLayout = new RelativeLayout(this.themeWrapper);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        ProgressBar progressBar = new ProgressBar(this.themeWrapper);
        progressBar.setIndeterminate(true);
        progressBar.setLayoutParams(layoutParams);
        relativeLayout.addView(progressBar);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        layoutParams2.bottomMargin = (int) (displayMetrics.density * 30.0f);
        TextView textView = new TextView(this.themeWrapper);
        textView.setText(R.string.__arcore_installing);
        textView.setLayoutParams(layoutParams2);
        relativeLayout.addView(textView);
        setContentView(relativeLayout);
        getWindow().setLayout(i, i);
    }

    /* access modifiers changed from: private */
    public void animateToSpinner() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = (int) (displayMetrics.density * 280.0f);
        int width = getWindow().getDecorView().getWidth();
        int height = getWindow().getDecorView().getHeight();
        setContentView(new RelativeLayout(this));
        getWindow().getDecorView().setMinimumWidth(i);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new C20289n(this, width, i, height));
        ofFloat.addListener(new C20288m(this));
        ofFloat.start();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.installStarted) {
            if (this.messageType == ArCoreApk.UserMessageType.USER_ALREADY_INFORMED) {
                startInstaller();
            }
        } else if (!this.finished) {
            synchronized (this) {
                if (this.lastEvent == C20290o.CANCELLED) {
                    finish();
                } else if (this.lastEvent == C20290o.ACCEPTED) {
                    this.waitingForCompletion = true;
                } else {
                    finishWithFailure(C20283h.m42667a().f56468a);
                }
            }
        }
    }

    public void finish() {
        finishWithFailure(new UnavailableUserDeclinedInstallationException());
    }

    /* access modifiers changed from: private */
    public void finishWithFailure(Exception exc) {
        C20283h.m42667a().f56468a = exc;
        C20283h.m42667a().mo164849b();
        this.finished = true;
        super.finish();
    }

    public void onDestroy() {
        if (!this.finished) {
            C20283h.m42667a().mo164849b();
        }
        super.onDestroy();
    }

    private boolean isOptional() {
        return this.installBehavior == ArCoreApk.InstallBehavior.OPTIONAL;
    }

    /* access modifiers changed from: private */
    public void startInstaller() {
        this.installStarted = true;
        this.lastEvent = C20290o.CANCELLED;
        C20283h.m42667a().mo164848a((Context) this).mo164856a((Activity) this, new C20293s(this));
    }

    /* access modifiers changed from: private */
    public void closeInstaller() {
        startActivity(new Intent(this, InstallActivity.class).setFlags(View.STATUS_BAR_TRANSIENT));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder(27);
        sb.append("activityResult: ");
        sb.append(i2);
        SystemUtils.log(4, TAG, sb.toString(), (Throwable) null, "com.google.ar.core.InstallActivity", 121);
    }
}
