package com.didi.zxing.scan.util;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class TopPermissionViewHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final ViewGroup f48178a;

    /* renamed from: b */
    private final int f48179b;

    /* renamed from: c */
    private final LayoutInflater f48180c;

    /* renamed from: d */
    private final Handler f48181d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f48182e;

    /* renamed from: f */
    private Runnable f48183f;

    public TopPermissionViewHelper(ViewGroup viewGroup) {
        this(viewGroup, 0);
    }

    public TopPermissionViewHelper(ViewGroup viewGroup, int i) {
        this.f48178a = viewGroup;
        this.f48179b = i;
        this.f48180c = LayoutInflater.from(viewGroup.getContext());
        this.f48181d = new Handler(Looper.getMainLooper());
    }

    public void showViewDelayed(int i, int i2, long j) {
        View inflate = this.f48180c.inflate(R.layout.zxing_qr_code_top_permission_desc_view, this.f48178a, false);
        this.f48182e = inflate;
        ((TextView) inflate.findViewById(R.id.top_title_tv)).setText(i);
        ((TextView) this.f48182e.findViewById(R.id.top_desc_tv)).setText(i2);
        if (this.f48179b > 0 && (this.f48182e.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.f48182e.getLayoutParams()).topMargin = this.f48179b;
        }
        C157921 r5 = new Runnable() {
            public void run() {
                TopPermissionViewHelper.this.f48178a.addView(TopPermissionViewHelper.this.f48182e);
            }
        };
        this.f48183f = r5;
        this.f48181d.postDelayed(r5, j);
    }

    public void removeIfNeeded() {
        Runnable runnable = this.f48183f;
        if (runnable != null) {
            this.f48181d.removeCallbacks(runnable);
        }
        View view = this.f48182e;
        if (view != null) {
            this.f48178a.removeView(view);
        }
    }
}
