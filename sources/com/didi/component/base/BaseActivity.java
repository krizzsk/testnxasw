package com.didi.component.base;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.core.IGroupView;
import com.didi.component.core.PresenterGroup;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.component.core.dialog.ToastHandler;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;

public abstract class BaseActivity<T extends PresenterGroup> extends FragmentActivity implements IGroupView<T> {

    /* renamed from: a */
    private T f12813a;

    /* renamed from: b */
    private boolean f12814b = false;

    /* renamed from: c */
    private ProgressDialogFragment f12815c;
    protected Bundle mBundle;

    public boolean isDialogShowing() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract T onCreateTopPresenter();

    /* access modifiers changed from: protected */
    public void onDestroyImpl() {
    }

    public void onDialogClicked(int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onPauseImpl() {
    }

    /* access modifiers changed from: protected */
    public void onResumeImpl() {
    }

    /* access modifiers changed from: protected */
    public void onStartImpl() {
    }

    /* access modifiers changed from: protected */
    public void onStopImpl() {
    }

    public void setBackVisible(boolean z) {
    }

    public void setTitle(String str) {
    }

    public void showDialog(DialogInfo dialogInfo) {
    }

    public void showToast(ToastHandler.ToastInfo toastInfo) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.mBundle = getIntent().getExtras() == null ? new Bundle() : getIntent().getExtras();
        this.f12814b = false;
        setPresenter(onCreateTopPresenter());
        T t = this.f12813a;
        if (t != null) {
            t.setIView(this);
        }
    }

    public void setPresenter(T t) {
        this.f12813a = t;
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        T t = this.f12813a;
        if (t != null) {
            t.dispatchPageCreate();
        }
    }

    public void onBackPressed() {
        m10810a();
    }

    /* renamed from: a */
    private void m10810a() {
        finish();
    }

    public final void onStart() {
        super.onStart();
        T t = this.f12813a;
        if (t != null) {
            t.dispatchPageStart();
        }
        onStartImpl();
    }

    public final void onResume() {
        super.onResume();
        T t = this.f12813a;
        if (t != null) {
            t.dispatchPageResume();
        }
        onResumeImpl();
    }

    public final void onPause() {
        super.onPause();
        T t = this.f12813a;
        if (t != null) {
            t.dispatchPagePause();
        }
        onPauseImpl();
    }

    public final void onStop() {
        super.onStop();
        T t = this.f12813a;
        if (t != null) {
            t.dispatchPageStop();
        }
        onStopImpl();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f12814b = true;
        super.onDestroy();
        T t = this.f12813a;
        if (t != null) {
            t.dispatchPageDestroy();
        }
        onDestroyImpl();
        this.f12813a = null;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        T t = this.f12813a;
        if (t != null) {
            t.onDispatchActivityResult(i, i2, intent);
        }
    }

    public boolean ismDestroyed() {
        return this.f12814b;
    }

    /* access modifiers changed from: protected */
    public void showDialogLoading(String str, boolean z) {
        if (this.f12815c == null) {
            ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
            this.f12815c = progressDialogFragment;
            progressDialogFragment.setContent(str, z);
        }
        if (!this.f12815c.isAdded()) {
            this.f12815c.show(getSupportFragmentManager(), "");
        }
    }

    /* access modifiers changed from: protected */
    public void dismissDialogLoading() {
        ProgressDialogFragment progressDialogFragment = this.f12815c;
        if (progressDialogFragment != null && progressDialogFragment.isAdded()) {
            this.f12815c.dismissAllowingStateLoss();
        }
    }
}
