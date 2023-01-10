package com.didichuxing.dfbasesdk.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didichuxing.security.safecollector.WsgSecInfo;
import com.taxis99.R;

@Deprecated
public class ProgressbarActivity extends FragmentActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile ProgressbarActivity f49588a = null;

    /* renamed from: b */
    private static volatile boolean f49589b = false;

    /* renamed from: c */
    private static volatile String f49590c;
    protected ProgressDialogFragment mProgress;

    /* access modifiers changed from: protected */
    public boolean progressCancelable() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_algo_model_loading;
    }

    public static void setProgressVisible(Context context, boolean z) {
        f49589b = z;
        if (z) {
            if (f49588a == null) {
                Intent intent = new Intent(context, ProgressbarActivity.class);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } else if (f49588a != null) {
            f49588a.finish();
        }
    }

    public static void setProgressVisible(Context context, boolean z, String str) {
        f49589b = z;
        f49590c = str;
        if (z) {
            if (f49588a == null) {
                Intent intent = new Intent(context, ProgressbarActivity.class);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        } else if (f49588a != null) {
            f49588a.finish();
        }
    }

    public static void setProgressContent(final String str) {
        f49590c = str;
        if (f49588a != null && f49588a.mProgress != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                f49588a.mProgress.setContent(str, f49588a.progressCancelable());
            } else {
                f49588a.runOnUiThread(new Runnable() {
                    public void run() {
                        ProgressbarActivity.f49588a.mProgress.setContent(str, ProgressbarActivity.f49588a.progressCancelable());
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (f49588a != null) {
            f49588a.finish();
            f49588a = null;
        }
        if (f49589b) {
            f49588a = this;
            ProgressDialogFragment createProgressDialogFragment = createProgressDialogFragment();
            this.mProgress = createProgressDialogFragment;
            createProgressDialogFragment.show(getSupportFragmentManager(), "df_progress");
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public ProgressDialogFragment createProgressDialogFragment() {
        InnerFragment innerFragment = new InnerFragment();
        innerFragment.setContent(f49590c != null ? f49590c : getResources().getString(progressMsgResId()), progressCancelable());
        int progressDrawable = getProgressDrawable();
        if (progressDrawable > 0) {
            innerFragment.setIndeterminateDrawable(progressDrawable);
        }
        return innerFragment;
    }

    /* access modifiers changed from: protected */
    public int getProgressDrawable() {
        String packageName = WsgSecInfo.packageName(this);
        if ("com.huaxiaozhu.driver".equalsIgnoreCase(packageName)) {
            return R.drawable.df_loading_hxz;
        }
        if ("com.huaxiaozhu.rider".equalsIgnoreCase(packageName)) {
            return R.drawable.df_loading_hxz_rider;
        }
        return 0;
    }

    public void finish() {
        super.finish();
        ProgressDialogFragment progressDialogFragment = this.mProgress;
        if (progressDialogFragment != null) {
            progressDialogFragment.dismiss();
        }
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (f49588a == this) {
            f49588a = null;
        }
    }

    public static class InnerFragment extends ProgressDialogFragment {
        private TextView contentView;

        public void setContent(String str, boolean z) {
            View view;
            super.setContent(str, z);
            if (this.contentView == null && (view = getView()) != null) {
                View findViewById = view.findViewById(R.id.tv_msg);
                if (findViewById instanceof TextView) {
                    this.contentView = (TextView) findViewById;
                }
            }
            TextView textView = this.contentView;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}
