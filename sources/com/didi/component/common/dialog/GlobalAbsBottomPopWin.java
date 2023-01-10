package com.didi.component.common.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.sdk.logging.LoggerFactory;
import com.taxis99.R;

public abstract class GlobalAbsBottomPopWin {

    /* renamed from: a */
    private PopupWindow f13371a;

    /* renamed from: b */
    private LinearLayout f13372b;

    /* renamed from: c */
    private boolean f13373c;

    /* renamed from: d */
    private boolean f13374d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnAntiShakeClickListener f13375e;
    protected Context mContext;

    /* access modifiers changed from: protected */
    public abstract int getCustomView();

    /* access modifiers changed from: protected */
    public abstract boolean onShowPrepare();

    public GlobalAbsBottomPopWin(Context context) {
        this.mContext = context;
    }

    public void show() {
        Activity activity = (Activity) this.mContext;
        if (!activity.isFinishing() && !this.f13373c) {
            m11214a();
            if (onShowPrepare()) {
                PopupWindow popupWindow = new PopupWindow(this.f13372b, -1, this.mContext.getApplicationInfo().targetSdkVersion >= 22 ? -1 : UiUtils.getWindowHeight(activity));
                this.f13371a = popupWindow;
                popupWindow.setSoftInputMode(16);
                setFocusable(true);
                this.f13371a.setBackgroundDrawable(new BitmapDrawable());
                try {
                    this.f13371a.showAtLocation(activity.getWindow().getDecorView(), 81, 0, 0);
                    this.f13373c = true;
                } catch (Exception e) {
                    LoggerFactory.getLogger(getClass()).error("showAtLocation exception, ", (Throwable) e);
                }
            }
        }
    }

    public void setTouchable(boolean z) {
        PopupWindow popupWindow = this.f13371a;
        if (popupWindow != null) {
            popupWindow.setTouchable(z);
        }
    }

    public void setFocusable(boolean z) {
        PopupWindow popupWindow = this.f13371a;
        if (popupWindow != null) {
            popupWindow.setFocusable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.f13374d = z;
    }

    public void setOutClickListener(OnAntiShakeClickListener onAntiShakeClickListener) {
        this.f13375e = onAntiShakeClickListener;
    }

    /* renamed from: a */
    private void m11214a() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        this.f13372b = (LinearLayout) from.inflate(R.layout.g_bottom_pop_win_layout, (ViewGroup) null);
        if (getCustomView() != 0) {
            from.inflate(getCustomView(), this.f13372b);
        }
        View findViewById = findViewById(R.id.g_bottom_pop_bg);
        if (this.f13374d) {
            findViewById.setOnClickListener(new OnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    try {
                        if (GlobalAbsBottomPopWin.this.f13375e != null) {
                            GlobalAbsBottomPopWin.this.f13375e.onClick(view);
                        }
                    } catch (Exception unused) {
                    }
                    GlobalAbsBottomPopWin.this.dismiss();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        LinearLayout linearLayout = this.f13372b;
        if (linearLayout == null) {
            return null;
        }
        return linearLayout.findViewById(i);
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.f13371a;
        if (popupWindow != null && this.f13373c && popupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        this.f13373c = false;
        if (this.f13371a == null) {
            GLog.m11362w("mAcceptWindow dismiss()    2, mAcceptWindow:" + toString());
            return;
        }
        GLog.m11362w("mAcceptWindow dismiss()    3, mAcceptWindow:" + toString());
        this.f13371a.dismiss();
    }
}
