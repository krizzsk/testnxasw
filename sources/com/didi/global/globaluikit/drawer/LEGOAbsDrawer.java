package com.didi.global.globaluikit.drawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.widget.PopupWindowCompat;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingConfig;
import com.taxis99.R;

public abstract class LEGOAbsDrawer {

    /* renamed from: a */
    private LEGOPopupWindow f24453a;

    /* renamed from: b */
    private LinearLayout f24454b;

    /* renamed from: c */
    private boolean f24455c;

    /* renamed from: d */
    private boolean f24456d;

    /* renamed from: e */
    private boolean f24457e;

    /* renamed from: f */
    private RelativeLayout f24458f;

    /* renamed from: g */
    private boolean f24459g;

    /* renamed from: h */
    private LEGODrawerDismissListener f24460h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LEGOOnAntiShakeClickListener f24461i;
    protected Context mContext;
    protected View mRealView;

    /* access modifiers changed from: protected */
    public abstract int getCustomView();

    /* access modifiers changed from: protected */
    public abstract boolean onShowPrepare();

    public LEGOAbsDrawer(Context context) {
        this.mContext = context;
    }

    public void show() {
        show(1000);
    }

    public void show(int i) {
        Context context = this.mContext;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !this.f24455c) {
            m19629a();
            if (onShowPrepare()) {
                View findViewById = findViewById(R.id.g_bottom_pop_bg);
                if (this.f24456d) {
                    findViewById.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            try {
                                if (LEGOAbsDrawer.this.f24461i != null) {
                                    LEGOAbsDrawer.this.f24461i.onClick(view);
                                }
                            } catch (Exception unused) {
                            }
                            LEGOAbsDrawer.this.dismiss();
                        }
                    });
                }
                LEGOPopupWindow lEGOPopupWindow = new LEGOPopupWindow(this.f24454b, -1, -1, this.mRealView, this.mContext, isBackPressedEnabled(), this.f24460h);
                this.f24453a = lEGOPopupWindow;
                lEGOPopupWindow.setSoftInputMode(16);
                View view = this.mRealView;
                if (view != null) {
                    view.setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.lego_drawer_bottom_in));
                }
                this.f24453a.setClippingEnabled(false);
                this.f24453a.setBackgroundDrawable(new ColorDrawable(0));
                setFocusable(true);
                PopupWindowCompat.setWindowLayoutType(this.f24453a, i);
                try {
                    this.f24453a.showAtLocation(activity.getWindow().getDecorView(), 81, 0, 0);
                    if (UiUtils.isNavigationBarExist(activity)) {
                        ViewGroup.LayoutParams layoutParams = this.mRealView.getLayoutParams();
                        if (layoutParams instanceof LinearLayout.LayoutParams) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mRealView.getLayoutParams();
                            layoutParams2.bottomMargin += UiUtils.getNavigationBarHeight(activity);
                            this.mRealView.setLayoutParams(layoutParams2);
                        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) this.mRealView.getLayoutParams()).bottomMargin += UiUtils.getNavigationBarHeight(activity);
                            this.mRealView.setLayoutParams(layoutParams);
                        }
                    }
                    this.f24455c = true;
                    if (LEGODrawerManager.showingDrawer == null) {
                        LEGODrawerManager.showingDrawer = this;
                    } else {
                        LEGODrawerManager.showingDrawer.dismiss();
                        LEGODrawerManager.showingDrawer = this;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f24453a.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        LEGODrawerManager.showingDrawer = null;
                    }
                });
            }
        }
    }

    public void setTouchable(boolean z) {
        LEGOPopupWindow lEGOPopupWindow = this.f24453a;
        if (lEGOPopupWindow != null) {
            lEGOPopupWindow.setTouchable(z);
        }
    }

    public void setFocusable(boolean z) {
        LEGOPopupWindow lEGOPopupWindow = this.f24453a;
        if (lEGOPopupWindow != null) {
            lEGOPopupWindow.setFocusable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.f24456d = z;
    }

    public void setOutClickListener(LEGOOnAntiShakeClickListener lEGOOnAntiShakeClickListener) {
        this.f24461i = lEGOOnAntiShakeClickListener;
    }

    /* renamed from: a */
    private void m19629a() {
        this.f24454b = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.lego_drawer_layout, (ViewGroup) null);
        if (getCustomView() != 0) {
            this.mRealView = LayoutInflater.from(this.mContext).inflate(getCustomView(), (ViewGroup) null);
        }
        View view = this.mRealView;
        if (view == null) {
            return;
        }
        if (this.f24459g) {
            this.f24458f = new RelativeLayout(this.mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(14);
            this.f24458f.addView(this.mRealView, layoutParams);
            this.f24454b.addView(this.f24458f);
            return;
        }
        this.f24454b.addView(view);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        LinearLayout linearLayout = this.f24454b;
        if (linearLayout == null) {
            return null;
        }
        return linearLayout.findViewById(i);
    }

    public boolean isShowing() {
        LEGOPopupWindow lEGOPopupWindow = this.f24453a;
        if (lEGOPopupWindow != null && this.f24455c && lEGOPopupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        this.f24455c = false;
        LEGOPopupWindow lEGOPopupWindow = this.f24453a;
        if (lEGOPopupWindow != null) {
            lEGOPopupWindow.dismissBySelf();
        }
    }

    public void setLoadingEnable(boolean z) {
        this.f24459g = z;
    }

    public void showLoading() {
        if (this.mContext != null && this.f24459g && this.mRealView != null) {
            Loading.make(this.mContext, this.mRealView, LoadingConfig.create().setLoadingGravity(48).build()).show();
        }
    }

    public void hideLoading() {
        View view;
        if (this.f24459g && (view = this.mRealView) != null) {
            Loading.hide(view);
        }
    }

    public boolean isBackPressedEnabled() {
        return this.f24457e;
    }

    public void setBackPressedEnabled(boolean z) {
        this.f24457e = z;
    }

    public void setDismissListener(LEGODrawerDismissListener lEGODrawerDismissListener) {
        this.f24460h = lEGODrawerDismissListener;
        LEGOPopupWindow lEGOPopupWindow = this.f24453a;
        if (lEGOPopupWindow != null) {
            lEGOPopupWindow.setDismissListener(lEGODrawerDismissListener);
        }
    }
}
