package com.didi.map.sdk.sharetrack.external.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.common.map.MapVendor;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.sdk.util.WindowUtil;
import com.didichuxing.nightmode.sdk.INightModeChangeCallback;
import com.didichuxing.nightmode.sdk.NightModeManager;
import com.didichuxing.nightmode.sdk.NightModeState;
import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.TimeStyle;
import com.taxis99.R;

public class FullScreenNavSkinView extends RelativeLayout implements INavSkin, INightModeChangeCallback {

    /* renamed from: a */
    private static final long f31171a = 30000;

    /* renamed from: b */
    private TextView f31172b;

    /* renamed from: c */
    private TextView f31173c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f31174d;

    /* renamed from: e */
    private ImageView f31175e;

    /* renamed from: f */
    private ImageView f31176f;

    /* renamed from: g */
    private ImageView f31177g;

    /* renamed from: h */
    private ImageView f31178h;

    /* renamed from: i */
    private RelativeLayout f31179i;

    /* renamed from: j */
    private FrameLayout f31180j;

    /* renamed from: k */
    private FrameLayout f31181k;

    /* renamed from: l */
    private View f31182l;

    /* renamed from: m */
    private boolean f31183m;

    /* renamed from: n */
    private int f31184n;

    /* renamed from: o */
    private CameraMode f31185o;

    /* renamed from: p */
    private MapVendor f31186p;

    /* renamed from: q */
    private RelativeLayout f31187q;

    /* renamed from: r */
    private RelativeLayout f31188r;

    /* renamed from: s */
    private View f31189s;

    /* renamed from: t */
    private OnSkinInteractionListener f31190t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f31191u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Handler f31192v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Runnable f31193w;

    public void setOrderId(String str) {
    }

    public FullScreenNavSkinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FullScreenNavSkinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullScreenNavSkinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f31184n = -1;
        this.f31185o = CameraMode.CAR_HEAD_UP;
        this.f31193w = new Runnable() {
            public void run() {
                if (FullScreenNavSkinView.this.f31191u > 0 && FullScreenNavSkinView.this.f31174d != null) {
                    FullScreenNavSkinView.this.m23854b();
                }
                if (FullScreenNavSkinView.this.f31192v != null) {
                    FullScreenNavSkinView.this.f31192v.removeCallbacks(FullScreenNavSkinView.this.f31193w);
                    FullScreenNavSkinView.this.f31192v.postDelayed(FullScreenNavSkinView.this.f31193w, 30000);
                }
            }
        };
        m23852a((MapVendor) null, (View) null, (View) null);
    }

    public FullScreenNavSkinView(Context context, MapVendor mapVendor, View view, View view2) {
        super(context);
        this.f31184n = -1;
        this.f31185o = CameraMode.CAR_HEAD_UP;
        this.f31193w = new Runnable() {
            public void run() {
                if (FullScreenNavSkinView.this.f31191u > 0 && FullScreenNavSkinView.this.f31174d != null) {
                    FullScreenNavSkinView.this.m23854b();
                }
                if (FullScreenNavSkinView.this.f31192v != null) {
                    FullScreenNavSkinView.this.f31192v.removeCallbacks(FullScreenNavSkinView.this.f31193w);
                    FullScreenNavSkinView.this.f31192v.postDelayed(FullScreenNavSkinView.this.f31193w, 30000);
                }
            }
        };
        m23852a(mapVendor, view, view2);
    }

    /* renamed from: a */
    private void m23852a(MapVendor mapVendor, View view, View view2) {
        if (getContext() != null) {
            this.f31186p = mapVendor;
            if (mapVendor == null || MapVendor.DIDI != mapVendor) {
                this.f31189s = LayoutInflater.from(getContext()).inflate(R.layout.maprouter_full_nav_skin_v2, this);
            } else {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.maprouter_full_nav_skin_v2, (ViewGroup) null);
                this.f31189s = inflate;
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.maprouter_fullnav_navcard_layout);
                this.f31187q = relativeLayout;
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams.topMargin += WindowUtil.getStatusBarHeight(getContext());
                    this.f31187q.setLayoutParams(layoutParams);
                    this.f31187q.addView(view, new ViewGroup.LayoutParams(-2, -2));
                    this.f31187q.setVisibility(0);
                }
                this.f31188r = (RelativeLayout) this.f31189s.findViewById(R.id.maprouter_fullnav_limit_speed_layout);
                if (view2 != null) {
                    this.f31188r.addView(view2, new ViewGroup.LayoutParams(-2, -2));
                    this.f31188r.setVisibility(0);
                }
            }
            this.f31172b = (TextView) this.f31189s.findViewById(R.id.maprouter_tv_nav_full_eta_v2);
            this.f31173c = (TextView) this.f31189s.findViewById(R.id.maprouter_tv_nav_full_eda_v2);
            this.f31174d = (TextView) this.f31189s.findViewById(R.id.maprouter_tv_nav_full_arrive_t_v2);
            this.f31175e = (ImageView) this.f31189s.findViewById(R.id.maprouter_iv_nav_full_close_v2);
            this.f31176f = (ImageView) this.f31189s.findViewById(R.id.maprouter_iv_nav_full_setting_v2);
            this.f31181k = (FrameLayout) this.f31189s.findViewById(R.id.maprouter_fl_nav_full_safe_v2);
            this.f31177g = (ImageView) this.f31189s.findViewById(R.id.maprouter_iv_nav_full_zoom_back_v2);
            this.f31180j = (FrameLayout) this.f31189s.findViewById(R.id.maprouter_fl_nav_full_tel_v2);
            this.f31178h = (ImageView) this.f31189s.findViewById(R.id.maprouter_iv_nav_full_camera_mode_v2);
            this.f31179i = (RelativeLayout) this.f31189s.findViewById(R.id.maprouter_rl_nav_full_bottom_bar_v2);
            this.f31182l = this.f31189s.findViewById(R.id.maprouter_v_nav_full_center_dot_v2);
            m23849a();
            this.f31192v = new Handler(Looper.getMainLooper());
        }
    }

    /* renamed from: a */
    private void m23849a() {
        this.f31175e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m23866g(view);
            }
        });
        this.f31176f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m23865f(view);
            }
        });
        this.f31181k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m23864e(view);
            }
        });
        this.f31177g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m23861d(view);
            }
        });
        this.f31180j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m23857c(view);
            }
        });
        this.f31178h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m23855b(view);
            }
        });
        if (this.f31179i.getViewTreeObserver() != null) {
            this.f31179i.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    FullScreenNavSkinView.this.m23863e();
                }
            });
        }
        NightModeManager.getInstance(getContext().getApplicationContext()).addNightModeChangeListener(this, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m23866g(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f31190t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onCloseClicked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m23865f(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f31190t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onSettingToolClicked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m23864e(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f31190t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onSafeToolClicked(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m23861d(View view) {
        this.f31177g.setVisibility(8);
        OnSkinInteractionListener onSkinInteractionListener = this.f31190t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onZoomBackClicked(this.f31185o);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m23857c(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f31190t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onTelClicked(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m23855b(View view) {
        if (this.f31185o == CameraMode.CAR_HEAD_UP) {
            this.f31185o = CameraMode.NORTH_UP;
        } else {
            this.f31185o = CameraMode.CAR_HEAD_UP;
        }
        m23860d();
        OnSkinInteractionListener onSkinInteractionListener = this.f31190t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onSwitchCameraModeClicked(this.f31185o);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m23863e() {
        int bottom = this.f31179i.getBottom() - this.f31179i.getTop();
        RelativeLayout relativeLayout = this.f31187q;
        int bottom2 = (relativeLayout == null || relativeLayout.getVisibility() != 0) ? 0 : this.f31187q.getBottom();
        FrameLayout frameLayout = this.f31181k;
        if (frameLayout != null && frameLayout.getVisibility() == 0 && this.f31181k.getTop() > 0) {
            int height = this.f31181k.getHeight();
            int width = this.f31181k.getWidth();
            if (this.f31186p == null || MapVendor.DIDI != this.f31186p || height < width) {
                bottom = this.f31179i.getBottom() - this.f31181k.getTop();
            } else {
                DLog.m23962d("FullScreenNavSkinView", "hawaii do not need mSafeContainer padding", new Object[0]);
            }
        }
        if (bottom < 0) {
            bottom = 300;
        }
        if (this.f31184n != bottom) {
            this.f31184n = bottom;
            OnSkinInteractionListener onSkinInteractionListener = this.f31190t;
            if (onSkinInteractionListener != null) {
                onSkinInteractionListener.onMapPaddingCalculateComplete(0, bottom2, 0, bottom);
            }
        }
    }

    public void updateEtaEda(int i, int i2) {
        String str;
        if (getContext() != null && getContext().getResources() != null) {
            if (i <= 0) {
                i = 1;
            }
            String formatCountdownTime = Elvish.Companion.getInstance().formatCountdownTime(i * 60, false);
            TextView textView = this.f31172b;
            if (textView != null) {
                textView.setText(formatCountdownTime);
            }
            if (i2 < 100) {
                i2 = 100;
            }
            if (i2 < 1000) {
                str = Elvish.Companion.getInstance().formatDistance((double) i2, DistanceStyle.M, 0, false);
            } else {
                str = Elvish.Companion.getInstance().formatDistance((double) i2, DistanceStyle.KM, 1, false);
            }
            TextView textView2 = this.f31173c;
            if (textView2 != null) {
                textView2.setText(str);
            }
            this.f31191u = i;
            m23854b();
            Handler handler = this.f31192v;
            if (handler != null) {
                handler.removeCallbacks(this.f31193w);
                this.f31192v.postDelayed(this.f31193w, 30000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23854b() {
        String formatDateTime = Elvish.Companion.getInstance().formatDateTime((System.currentTimeMillis() / 1000) + ((long) (this.f31191u * 60)), DateStyle.NONE, TimeStyle.TIME_HH_MM, true);
        TextView textView = this.f31174d;
        if (textView != null) {
            textView.setText(formatDateTime);
        }
    }

    /* renamed from: a */
    private void m23850a(int i) {
        Handler handler = this.f31192v;
        if (handler != null) {
            handler.removeCallbacks(this.f31193w);
        }
        if (i == 0) {
            if (this.f31191u > 0 && this.f31174d != null) {
                m23854b();
            }
            Handler handler2 = this.f31192v;
            if (handler2 != null) {
                handler2.postDelayed(this.f31193w, 30000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        m23850a(i);
    }

    public void changeNightMode(boolean z) {
        this.f31183m = z;
        m23856c();
    }

    public void updateZoomBackVisibility(boolean z) {
        ImageView imageView = this.f31177g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void updateCameraMode(CameraMode cameraMode) {
        this.f31185o = cameraMode;
        m23860d();
    }

    public void setTelephoneView(View view) {
        if (view != null && this.f31180j != null) {
            m23851a(view);
            this.f31180j.removeAllViews();
            this.f31180j.addView(view);
            this.f31180j.setVisibility(0);
        }
    }

    public void setSafeToolView(View view) {
        if (view != null && this.f31181k != null) {
            m23851a(view);
            this.f31181k.removeAllViews();
            this.f31181k.addView(view);
            this.f31181k.setVisibility(0);
        }
    }

    public void destroy() {
        FrameLayout frameLayout = this.f31181k;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.f31181k = null;
        }
        FrameLayout frameLayout2 = this.f31180j;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
            this.f31180j = null;
        }
        Handler handler = this.f31192v;
        if (handler != null) {
            handler.removeCallbacks(this.f31193w);
        }
        this.f31190t = null;
        NightModeManager.getInstance(getContext().getApplicationContext()).removeNightModeChangeListener(this);
    }

    public void setOnSkinInteractionListener(OnSkinInteractionListener onSkinInteractionListener) {
        this.f31190t = onSkinInteractionListener;
    }

    /* renamed from: c */
    private void m23856c() {
        if (this.f31183m) {
            this.f31177g.setBackgroundResource(R.drawable.maprouter_selector_nav_full_zoom_back_night);
            this.f31175e.setImageResource(R.drawable.maprouter_nav_full_close_night);
            this.f31176f.setImageResource(R.drawable.maprouter_nav_full_setting_night);
            this.f31179i.setBackgroundResource(R.drawable.maprouter_nav_full_bootom_bar_night);
            this.f31182l.setBackgroundResource(R.drawable.maprouter_nav_full_dot_night);
            if (getResources() != null) {
                this.f31172b.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_de_white));
                this.f31173c.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_de_white));
                this.f31174d.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_white));
            }
        } else {
            this.f31177g.setBackgroundResource(R.drawable.maprouter_selector_nav_full_zoom_back_day);
            this.f31175e.setImageResource(R.drawable.maprouter_nav_full_close);
            this.f31176f.setImageResource(R.drawable.maprouter_nav_full_setting);
            this.f31179i.setBackgroundResource(R.drawable.maprouter_nav_full_bootom_bar_day);
            this.f31182l.setBackgroundResource(R.drawable.maprouter_nav_full_dot_day);
            if (getResources() != null) {
                this.f31172b.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_setting_scheme_disable_text));
                this.f31173c.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_setting_scheme_disable_text));
                this.f31174d.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_normal_text_day));
            }
        }
        m23860d();
    }

    /* renamed from: d */
    private void m23860d() {
        if (this.f31185o == CameraMode.CAR_HEAD_UP) {
            if (this.f31183m) {
                this.f31178h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_overview_night);
            } else {
                this.f31178h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_overview_day);
            }
        } else if (this.f31185o != CameraMode.NORTH_UP) {
        } else {
            if (this.f31183m) {
                this.f31178h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_car_up_night);
            } else {
                this.f31178h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_car_up_day);
            }
        }
    }

    public View getSkinRootView() {
        return this.f31189s;
    }

    public void setSkinVisibility(int i) {
        View view = this.f31189s;
        if (view != null) {
            view.setVisibility(i);
            m23850a(i);
        }
    }

    public boolean isVisible() {
        View view = this.f31189s;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public CameraMode getCameraMode() {
        return this.f31185o;
    }

    public void onNightModeStateChange(NightModeState nightModeState) {
        this.f31183m = nightModeState == NightModeState.NIGHT;
        m23856c();
    }

    /* renamed from: a */
    private void m23851a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }
}
