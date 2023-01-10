package com.didi.dimina.starbox.p108ui.windowpop;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.util.PixUtil;
import com.google.android.material.badge.BadgeDrawable;
import com.taxis99.R;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.ClosePop */
public final class ClosePop implements AsyncWindow, Dispatcher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnCloseCallback f20015a;

    /* renamed from: b */
    private final ImageView f20016b;

    /* renamed from: c */
    private final Context f20017c;

    /* renamed from: d */
    private final AsyncWindow f20018d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final AsyncWindowPop f20019e;

    /* renamed from: f */
    private Dispatcher f20020f;

    /* renamed from: com.didi.dimina.starbox.ui.windowpop.ClosePop$OnCloseCallback */
    public interface OnCloseCallback {
        void onClose();
    }

    public void setOnCloseCallback(OnCloseCallback onCloseCallback) {
        this.f20015a = onCloseCallback;
    }

    public ClosePop(Context context, AsyncWindow asyncWindow, OnCloseCallback onCloseCallback) {
        this.f20017c = context;
        this.f20015a = onCloseCallback;
        this.f20018d = asyncWindow;
        this.f20016b = new AppCompatImageView(context);
        m16974a(context);
        this.f20019e = new AsyncWindowPop(context, this, this);
    }

    /* renamed from: a */
    private void m16974a(Context context) {
        this.f20016b.setImageResource(R.drawable.dimina_starbox_close_white);
        int dip2px = PixUtil.dip2px(context, 10.0f);
        this.f20016b.setPadding(dip2px, dip2px, dip2px, dip2px);
        this.f20016b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ClosePop.this.f20015a != null) {
                    ClosePop.this.f20015a.onClose();
                    ClosePop.this.f20019e.cancel();
                    return;
                }
                throw new IllegalStateException("setOnCloseCallback must not be null");
            }
        });
    }

    public void onLayoutParams(WindowManager.LayoutParams layoutParams) {
        layoutParams.flags = 40;
        layoutParams.width = PixUtil.dip2px(this.f20017c, 30.0f);
        layoutParams.height = PixUtil.dip2px(this.f20017c, 30.0f);
        layoutParams.gravity = BadgeDrawable.TOP_END;
        AsyncWindow asyncWindow = this.f20018d;
        if (asyncWindow != null) {
            asyncWindow.onLayoutParams(layoutParams);
        }
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.f20020f = dispatcher;
    }

    public void pop() {
        this.f20019e.pop();
    }

    public View provideView() {
        AsyncWindow asyncWindow = this.f20018d;
        if (asyncWindow != null) {
            return asyncWindow.provideView();
        }
        return this.f20016b;
    }

    public boolean onForegroundChange(boolean z) {
        AsyncWindow asyncWindow = this.f20018d;
        if (asyncWindow != null) {
            return asyncWindow.onForegroundChange(z);
        }
        return false;
    }

    /* renamed from: a */
    private Dispatcher m16973a() {
        if (this.f20020f == null) {
            this.f20020f = new DefaultDispatcher();
        }
        return this.f20020f;
    }

    public void post(Runnable runnable) {
        m16973a().post(runnable);
    }

    public void postDelay(Runnable runnable, long j) {
        m16973a().postDelay(runnable, j);
    }
}
