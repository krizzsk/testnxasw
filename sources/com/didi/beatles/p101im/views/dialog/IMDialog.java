package com.didi.beatles.p101im.views.dialog;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.beatles.p101im.common.IMLifecycleHandler;
import java.lang.ref.WeakReference;

/* renamed from: com.didi.beatles.im.views.dialog.IMDialog */
public class IMDialog {

    /* renamed from: a */
    private WeakReference<Activity> f12018a;

    /* renamed from: b */
    private DialogFragment f12019b;

    /* renamed from: c */
    private boolean f12020c = false;

    /* renamed from: com.didi.beatles.im.views.dialog.IMDialog$Callback */
    public interface Callback {
        void onCancel();

        void onSubmit();
    }

    public IMDialog(Activity activity) {
        this.f12018a = new WeakReference<>(activity);
    }

    public void setDialog(DialogFragment dialogFragment) {
        if ((dialogFragment instanceof IMProgressDialogFragment) || (dialogFragment instanceof IMAlertDialogFragment)) {
            this.f12019b = dialogFragment;
            return;
        }
        throw new IllegalArgumentException("IMDialog only accept ProgressDialogFragment or AlertDialogFragment.");
    }

    public void setCancelable(boolean z) {
        this.f12020c = z;
    }

    public void show(IMLifecycleHandler.Controller controller, final FragmentManager fragmentManager, final String str) {
        if (controller != null) {
            controller.post(new Runnable() {
                public void run() {
                    IMDialog.this.m10329a(fragmentManager, str);
                }
            });
        } else {
            m10329a(fragmentManager, str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10329a(FragmentManager fragmentManager, String str) {
        if (m10332b()) {
            this.f12019b.setCancelable(this.f12020c);
            this.f12019b.show(fragmentManager, str);
        }
    }

    public void dismiss(IMLifecycleHandler.Controller controller) {
        controller.post(new Runnable() {
            public void run() {
                IMDialog.this.m10328a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10328a() {
        if (m10332b()) {
            this.f12019b.dismiss();
        }
    }

    public void dismiss() {
        m10328a();
    }

    /* renamed from: b */
    private boolean m10332b() {
        WeakReference<Activity> weakReference;
        Activity activity;
        if (this.f12019b == null || (weakReference = this.f12018a) == null || weakReference.get() == null || (activity = (Activity) this.f12018a.get()) == null || activity.isFinishing() || !(activity instanceof FragmentActivity) || ((FragmentActivity) activity).getSupportFragmentManager() == null) {
            return false;
        }
        return true;
    }
}
