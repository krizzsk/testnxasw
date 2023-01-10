package com.didi.dimina.starbox.p108ui.windowpop;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.didi.dimina.starbox.util.ForegroundChecker;

/* renamed from: com.didi.dimina.starbox.ui.windowpop.AsyncWindowPop */
public class AsyncWindowPop implements WindowManager, Dispatcher, ForegroundChecker.OnForegroundChange {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final WindowManager f20010a;

    /* renamed from: b */
    private final Dispatcher f20011b;

    /* renamed from: c */
    private final AsyncWindow f20012c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final WindowManager.LayoutParams f20013d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f20014e;

    public AsyncWindowPop(Context context, AsyncWindow asyncWindow) {
        this(context, asyncWindow, (Dispatcher) null);
    }

    public AsyncWindowPop(Context context, AsyncWindow asyncWindow, Dispatcher dispatcher) {
        this.f20013d = new WindowManager.LayoutParams();
        this.f20012c = asyncWindow;
        this.f20010a = (WindowManager) context.getSystemService("window");
        if (dispatcher == null) {
            this.f20011b = new DefaultDispatcher();
        } else {
            this.f20011b = dispatcher;
        }
    }

    public void pop() {
        if (this.f20014e == null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f20013d.type = 2038;
            } else {
                this.f20013d.type = 2002;
            }
            this.f20013d.format = -2;
            this.f20013d.height = -1;
            this.f20013d.width = -1;
            this.f20014e = this.f20012c.provideView();
            this.f20012c.onLayoutParams(this.f20013d);
            addView(this.f20014e, this.f20013d);
            ForegroundChecker.getIns().addChecker(this);
        }
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return this.f20013d;
    }

    public View getFloatView() {
        return this.f20014e;
    }

    public void cancel() {
        View view = this.f20014e;
        if (view != null) {
            removeView(view);
            this.f20014e = null;
        }
        ForegroundChecker.getIns().removeChecker(this);
    }

    public void onChange(final boolean z) {
        if (!this.f20012c.onForegroundChange(z) && this.f20014e != null) {
            this.f20011b.post(new Runnable() {
                public void run() {
                    if (z) {
                        AsyncWindowPop asyncWindowPop = AsyncWindowPop.this;
                        asyncWindowPop.addView(asyncWindowPop.f20014e, AsyncWindowPop.this.f20013d);
                        return;
                    }
                    AsyncWindowPop asyncWindowPop2 = AsyncWindowPop.this;
                    asyncWindowPop2.removeView(asyncWindowPop2.f20014e);
                }
            });
        }
    }

    public void post(Runnable runnable) {
        this.f20011b.post(runnable);
    }

    public void postDelay(Runnable runnable, long j) {
        this.f20011b.postDelay(runnable, j);
    }

    public Display getDefaultDisplay() {
        return this.f20010a.getDefaultDisplay();
    }

    public void removeViewImmediate(final View view) {
        this.f20011b.post(new Runnable() {
            public void run() {
                AsyncWindowPop.this.f20010a.removeViewImmediate(view);
            }
        });
    }

    public void addView(final View view, final ViewGroup.LayoutParams layoutParams) {
        this.f20011b.post(new Runnable() {
            public void run() {
                if (!view.isShown()) {
                    AsyncWindowPop.this.f20010a.addView(view, layoutParams);
                }
            }
        });
    }

    public void updateViewLayout(final View view, final ViewGroup.LayoutParams layoutParams) {
        this.f20011b.post(new Runnable() {
            public void run() {
                AsyncWindowPop.this.f20010a.updateViewLayout(view, layoutParams);
            }
        });
    }

    public void removeView(final View view) {
        this.f20011b.post(new Runnable() {
            public void run() {
                if (view.isShown()) {
                    AsyncWindowPop.this.f20010a.removeView(view);
                }
            }
        });
    }
}
