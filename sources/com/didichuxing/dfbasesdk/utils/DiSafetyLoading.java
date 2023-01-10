package com.didichuxing.dfbasesdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DiSafetyLoading {

    /* renamed from: a */
    private static int f49386a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Map<Integer, WeakReference<DiSafetyLoading>> f49387b = new ConcurrentHashMap();

    /* renamed from: c */
    private final int f49388c;

    /* renamed from: d */
    private Context f49389d;

    /* renamed from: e */
    private DiSafetyLoadingFragment f49390e;

    /* renamed from: f */
    private String f49391f;

    /* renamed from: g */
    private int f49392g;

    /* renamed from: h */
    private boolean f49393h;

    /* renamed from: i */
    private LoadingListener f49394i;

    public interface LoadingListener {
        void onHide();

        void onShow();
    }

    public DiSafetyLoading(Context context) {
        int i = f49386a;
        f49386a = i + 1;
        this.f49388c = i;
        this.f49389d = context;
    }

    public void show() {
        if (!f49387b.containsKey(Integer.valueOf(this.f49388c))) {
            f49387b.put(Integer.valueOf(this.f49388c), new WeakReference(this));
            Context context = this.f49389d;
            if (context instanceof FragmentActivity) {
                m37042a((FragmentActivity) context);
                return;
            }
            Intent intent = new Intent(this.f49389d, DfLoadingActivity.class);
            intent.putExtra("loading_id", this.f49388c);
            intent.addFlags(268435456);
            this.f49389d.startActivity(intent);
        }
    }

    public void hide() {
        f49387b.remove(Integer.valueOf(this.f49388c));
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f49390e;
        this.f49390e = null;
        if (diSafetyLoadingFragment != null) {
            Activity parentActivity = diSafetyLoadingFragment.getParentActivity();
            diSafetyLoadingFragment.dismiss();
            if (parentActivity instanceof DfLoadingActivity) {
                parentActivity.finish();
            }
            LoadingListener loadingListener = this.f49394i;
            if (loadingListener != null) {
                loadingListener.onHide();
            }
        }
    }

    public DiSafetyLoading setMessage(String str) {
        this.f49391f = str;
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f49390e;
        if (diSafetyLoadingFragment != null) {
            diSafetyLoadingFragment.setContent(str, diSafetyLoadingFragment.isCancelable());
        }
        return this;
    }

    public DiSafetyLoading setDrawable(int i) {
        this.f49392g = i;
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f49390e;
        if (diSafetyLoadingFragment != null) {
            diSafetyLoadingFragment.setIndeterminateDrawable(i);
        }
        return this;
    }

    public DiSafetyLoading setCancelable(boolean z) {
        this.f49393h = z;
        DiSafetyLoadingFragment diSafetyLoadingFragment = this.f49390e;
        if (diSafetyLoadingFragment != null) {
            diSafetyLoadingFragment.setCancelable(z);
        }
        return this;
    }

    public DiSafetyLoading setListener(LoadingListener loadingListener) {
        this.f49394i = loadingListener;
        return this;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m37042a(FragmentActivity fragmentActivity) {
        DiSafetyLoadingFragment diSafetyLoadingFragment = new DiSafetyLoadingFragment();
        this.f49390e = diSafetyLoadingFragment;
        diSafetyLoadingFragment.setParentActivity(fragmentActivity);
        this.f49390e.setContent(TextUtils.isEmpty(this.f49391f) ? "加载中，请稍后..." : this.f49391f, this.f49393h);
        int i = this.f49392g;
        if (i != 0) {
            this.f49390e.setIndeterminateDrawable(i);
        }
        DiSafetyLoadingFragment diSafetyLoadingFragment2 = this.f49390e;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        diSafetyLoadingFragment2.show(supportFragmentManager, "df_progress" + this.f49388c);
        LoadingListener loadingListener = this.f49394i;
        if (loadingListener != null) {
            loadingListener.onShow();
        }
    }

    public static class DfLoadingActivity extends FragmentActivity {
        public static final String EXTRA_ID = "loading_id";

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            SystemUtils.hookOnlyFullscreenOpaque(this);
            requestWindowFeature(1);
            super.onCreate(bundle);
            getWindow().setFlags(1024, 1024);
            getWindow().setSoftInputMode(2);
            WeakReference weakReference = (WeakReference) DiSafetyLoading.f49387b.get(Integer.valueOf(getIntent().getIntExtra("loading_id", 0)));
            if (weakReference == null) {
                finish();
                return;
            }
            DiSafetyLoading diSafetyLoading = (DiSafetyLoading) weakReference.get();
            if (diSafetyLoading == null) {
                finish();
            } else {
                diSafetyLoading.m37042a(this);
            }
        }
    }

    public static class DiSafetyLoadingFragment extends ProgressDialogFragment {
        private TextView contentView;
        private Activity parentActivity;

        public void setParentActivity(Activity activity) {
            this.parentActivity = activity;
        }

        public Activity getParentActivity() {
            return this.parentActivity;
        }

        public void setContent(String str, boolean z) {
            View view;
            super.setContent(str, z);
            if (this.contentView == null && (view = getView()) != null) {
                try {
                    View findViewById = view.findViewById(R.id.tv_msg);
                    if (findViewById instanceof TextView) {
                        this.contentView = (TextView) findViewById;
                    }
                } catch (Throwable unused) {
                }
            }
            TextView textView = this.contentView;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }
}
