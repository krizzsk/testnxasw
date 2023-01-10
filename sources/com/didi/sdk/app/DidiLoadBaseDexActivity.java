package com.didi.sdk.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.multidex.MultiDex;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.taxis99.R;

public class DidiLoadBaseDexActivity extends TheOneBaseActivity {
    protected final String TAG = "DidiLoadBaseDexActivity";

    /* renamed from: a */
    Thread f37929a = null;

    /* renamed from: b */
    private Handler f37930b = new Handler();

    /* renamed from: c */
    private boolean f37931c = false;

    /* renamed from: d */
    private boolean f37932d = false;

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public boolean requestLawAgreement() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean requestPermissions() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean requestPrivacyDisclosure() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        boolean a = C12840g.m28662a(getIntent());
        this.f37932d = a;
        if (a || C12840g.m28665b((Context) this)) {
            FrameLayout frameLayout = new FrameLayout(this);
            if (Build.VERSION.SDK_INT < 21) {
                TextView textView = new TextView(this);
                textView.setTextSize(20.0f);
                textView.setGravity(17);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                textView.setText(getString(R.string.loadex_waiting));
                frameLayout.addView(textView, layoutParams);
            }
            setContentView((View) frameLayout);
            return;
        }
        startSplashActivity(true, true);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f37929a == null) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    DidiLoadBaseDexActivity.this.m28577a();
                    DidiLoadBaseDexActivity.this.f37929a = null;
                }
            });
            this.f37929a = thread;
            thread.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28577a() {
        if (!this.f37931c) {
            MultiDex.install(this);
            m28579b();
            this.f37931c = true;
        }
    }

    /* renamed from: b */
    private void m28579b() {
        if (this.f37932d) {
            C12840g.m28666c(getApplication());
            this.f37930b.postDelayed(new Runnable() {
                public void run() {
                    DidiLoadBaseDexActivity.this.finish();
                    Process.killProcess(Process.myPid());
                }
            }, 110);
            return;
        }
        startSplashActivity(10);
    }

    public void startSplashActivity(long j) {
        this.f37930b.postDelayed(new Runnable() {
            public void run() {
                DidiLoadBaseDexActivity.this.startSplashActivity(true, true);
            }
        }, j);
    }

    /* access modifiers changed from: protected */
    public void startSplashActivity(boolean z) {
        startSplashActivity(z, true);
    }

    /* access modifiers changed from: protected */
    public void startSplashActivity(boolean z, boolean z2) {
        this.f37931c = true;
        if (z) {
            boolean requestLawAgreement = requestLawAgreement();
            Log.d("DidiLoadBaseDexActivity", "requestLawAgreement:" + requestLawAgreement);
            if (!requestLawAgreement) {
                return;
            }
        }
        if (z2) {
            boolean requestPrivacyDisclosure = requestPrivacyDisclosure();
            Log.d("DidiLoadBaseDexActivity", "requestPrivacyDisclosure:" + requestPrivacyDisclosure);
            if (!requestPrivacyDisclosure) {
                return;
            }
        }
        boolean requestPermissions = requestPermissions();
        Log.d("DidiLoadBaseDexActivity", "requestPermissions:" + requestPermissions);
        if (requestPermissions) {
            Log.d("DidiLoadBaseDexActivity", "permission ok");
            toSplashActivity();
        }
    }

    /* access modifiers changed from: protected */
    public void toSplashActivity() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setComponent(new ComponentName(this, "com.didi.sdk.splash.SplashActivity"));
        startActivity(intent);
        finish();
    }
}
