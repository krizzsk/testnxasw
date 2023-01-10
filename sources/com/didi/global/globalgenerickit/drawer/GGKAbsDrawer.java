package com.didi.global.globalgenerickit.drawer;

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
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingConfig;
import com.taxis99.R;

public abstract class GGKAbsDrawer {

    /* renamed from: a */
    private PopupWindow f24050a;

    /* renamed from: b */
    private LinearLayout f24051b;

    /* renamed from: c */
    private boolean f24052c;

    /* renamed from: d */
    private boolean f24053d;

    /* renamed from: e */
    private boolean f24054e;

    /* renamed from: f */
    private View f24055f;

    /* renamed from: g */
    private RelativeLayout f24056g;

    /* renamed from: h */
    private boolean f24057h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public GGKOnAntiShakeClickListener f24058i;
    protected Context mContext;

    /* access modifiers changed from: protected */
    public abstract int getCustomView();

    /* access modifiers changed from: protected */
    public abstract boolean onShowPrepare();

    public GGKAbsDrawer(Context context) {
        this.mContext = context;
    }

    public void show() {
        Context context = this.mContext;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !this.f24052c) {
            m19445a();
            if (onShowPrepare()) {
                View findViewById = findViewById(R.id.g_bottom_pop_bg);
                if (this.f24053d) {
                    findViewById.setOnClickListener(new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            try {
                                if (GGKAbsDrawer.this.f24058i != null) {
                                    GGKAbsDrawer.this.f24058i.onClick(view);
                                }
                            } catch (Exception unused) {
                            }
                            GGKAbsDrawer.this.dismiss();
                        }
                    });
                }
                GGKPopupWindow gGKPopupWindow = new GGKPopupWindow(this.f24051b, -1, -1, this.f24055f, this.mContext);
                this.f24050a = gGKPopupWindow;
                gGKPopupWindow.setSoftInputMode(16);
                if (isBackPressedEnabled()) {
                    setFocusable(true);
                }
                View view = this.f24055f;
                if (view != null) {
                    view.setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.ggk_drawer_bottom_in));
                }
                this.f24050a.setClippingEnabled(false);
                this.f24050a.setBackgroundDrawable(new ColorDrawable(0));
                try {
                    this.f24050a.showAtLocation(activity.getWindow().getDecorView(), 81, 0, 0);
                    if (UiUtils.isNavigationBarExist(activity)) {
                        ViewGroup.LayoutParams layoutParams = this.f24055f.getLayoutParams();
                        if (layoutParams instanceof LinearLayout.LayoutParams) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f24055f.getLayoutParams();
                            layoutParams2.bottomMargin = UiUtils.getNavigationBarHeight(activity);
                            this.f24055f.setLayoutParams(layoutParams2);
                        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) this.f24055f.getLayoutParams()).bottomMargin = UiUtils.getNavigationBarHeight(activity);
                            this.f24055f.setLayoutParams(layoutParams);
                        }
                    }
                    this.f24052c = true;
                    if (GGKDrawerManager.showingDrawer == null) {
                        GGKDrawerManager.showingDrawer = this;
                    } else {
                        GGKDrawerManager.showingDrawer.dismiss();
                        GGKDrawerManager.showingDrawer = this;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f24050a.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        GGKDrawerManager.showingDrawer = null;
                    }
                });
            }
        }
    }

    public void setTouchable(boolean z) {
        PopupWindow popupWindow = this.f24050a;
        if (popupWindow != null) {
            popupWindow.setTouchable(z);
        }
    }

    public void setFocusable(boolean z) {
        PopupWindow popupWindow = this.f24050a;
        if (popupWindow != null) {
            popupWindow.setFocusable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.f24053d = z;
    }

    public void setOutClickListener(GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener) {
        this.f24058i = gGKOnAntiShakeClickListener;
    }

    /* renamed from: a */
    private void m19445a() {
        this.f24051b = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ggk_drawer_layout, (ViewGroup) null);
        if (getCustomView() != 0) {
            this.f24055f = LayoutInflater.from(this.mContext).inflate(getCustomView(), (ViewGroup) null);
        }
        View view = this.f24055f;
        if (view == null) {
            return;
        }
        if (this.f24057h) {
            this.f24056g = new RelativeLayout(this.mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(14);
            this.f24056g.addView(this.f24055f, layoutParams);
            this.f24051b.addView(this.f24056g);
            return;
        }
        this.f24051b.addView(view);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        LinearLayout linearLayout = this.f24051b;
        if (linearLayout == null) {
            return null;
        }
        return linearLayout.findViewById(i);
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.f24050a;
        if (popupWindow != null && this.f24052c && popupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        this.f24052c = false;
        PopupWindow popupWindow = this.f24050a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void setLoadingEnable(boolean z) {
        this.f24057h = z;
    }

    public void showLoading() {
        if (this.mContext != null && this.f24057h && this.f24055f != null) {
            Loading.make(this.mContext, this.f24055f, LoadingConfig.create().setLoadingGravity(48).build()).show();
        }
    }

    public void hideLoading() {
        View view;
        if (this.f24057h && (view = this.f24055f) != null) {
            Loading.hide(view);
        }
    }

    public boolean isBackPressedEnabled() {
        return this.f24054e;
    }

    public void setBackPressedEnabled(boolean z) {
        this.f24054e = z;
    }
}
