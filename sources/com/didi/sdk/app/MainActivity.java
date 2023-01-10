package com.didi.sdk.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.common.TaskScheduler;
import com.didi.sdk.util.ApplicationLifeUtils;
import com.didi.sdk.util.RunTimeStatistics;

public class MainActivity extends FragmentActivity implements PermissionContext {

    /* renamed from: a */
    private boolean f37938a = false;

    /* renamed from: b */
    private ActivityDelegateManager f37939b;

    /* renamed from: c */
    private ActivityLifecycleManager.AppStateListener f37940c;

    /* renamed from: d */
    private ActivityLifecycleManager.AppStateListener f37941d;

    public Context getContextByPermissionContext() {
        return this;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        new RunTimeStatistics.SliceTime().setStart(System.currentTimeMillis());
        ActivityDelegateManager activityDelegateManager = new ActivityDelegateManager(this);
        this.f37939b = activityDelegateManager;
        activityDelegateManager.notifyOnPreCreateMethod();
        super.onCreate(bundle);
        m28589a(false);
        this.f37939b.notifyOnCreateMethod();
        ActivityLifecycleManager.getInstance().addAppStateListener(this.f37941d);
        m28591b();
        m28592c();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.f37939b.notifyOnWindowFocusChanged(z);
        if (z && !m28590a()) {
            TaskScheduler.getDefault().notify(2);
            m28589a(true);
        }
    }

    /* renamed from: a */
    private boolean m28590a() {
        return this.f37938a;
    }

    /* renamed from: a */
    private void m28589a(boolean z) {
        this.f37938a = z;
    }

    /* renamed from: b */
    private void m28591b() {
        this.f37940c = new ActivityLifecycleManager.AppStateListener() {
            public void onStateChanged(int i) {
            }
        };
        ActivityLifecycleManager.getInstance().addAppStateListener(this.f37940c);
    }

    /* renamed from: c */
    private void m28592c() {
        this.f37941d = new ActivityLifecycleManager.AppStateListener() {
            public void onStateChanged(int i) {
            }
        };
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.f37939b.notifyOnStartMethod();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f37939b.notifyOnResumeMethod();
        ApplicationLifeUtils.setApplicationFinishInit(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.f37939b.notifyOnStopMethod();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f37939b.notifyOnPauseMethod();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        TaskScheduler.getDefault().clear();
        this.f37939b.notifyOnDestroyMethod();
        ActivityLifecycleManager.getInstance().removeAppStateListener(this.f37940c);
        ActivityLifecycleManager.getInstance().removeAppStateListener(this.f37941d);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f37939b.notifyOnNewIntent();
    }

    public void startActivityByPermissionContext(Intent intent) {
        startActivity(intent);
    }

    public void startActivityForResultByPermissionContext(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public void requestPermissionsByPermissionContext(String[] strArr, int i) {
        ActivityCompat.requestPermissions(this, strArr, i);
    }
}
