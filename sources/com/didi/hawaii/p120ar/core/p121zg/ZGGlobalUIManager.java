package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.MapVendor;
import com.didi.hawaii.p120ar.core.BaseDelegate;
import com.didi.hawaii.p120ar.core.DiAREngine;
import com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout;
import com.didi.hawaii.p120ar.jni.DARCPointF;
import com.didi.hawaii.p120ar.jni.DARCRectF;
import com.didi.hawaii.p120ar.jni.DARCSizeF;
import com.didi.hawaii.p120ar.utils.AROmega;
import com.didi.hawaii.p120ar.utils.ARSharePref;
import com.didi.hawaii.p120ar.utils.DisplayUtils;
import com.didi.hawaii.p120ar.utils.MapVenderUtil;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGGlobalUIManager */
public class ZGGlobalUIManager extends BaseDelegate {
    public static final int BACKMSG = 10001;
    public static final int BEHINDTIPSMSG = 1021;
    public static final int DRIVERARRIVEMSG = 1020;
    public static final int GPSWEAKMSG = 1017;
    public static final int GUIDESHOWMSG = 1019;
    public static final int HELPMSG = 10002;
    public static final int REACHENDMSG = 1018;
    public static final int SAFETIPS = 1015;

    /* renamed from: a */
    private static final int f25413a = 40;

    /* renamed from: b */
    private static final int f25414b = 100;

    /* renamed from: c */
    private static final int f25415c = 130;

    /* renamed from: d */
    private static final int f25416d = 20;

    /* renamed from: e */
    private static final int f25417e = 10000;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static int f25418f;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f25419A = false;

    /* renamed from: B */
    private Bitmap f25420B;

    /* renamed from: C */
    private boolean f25421C = false;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public Handler f25422D = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                int i = message.what;
                if (i == 1015) {
                    ZGGlobalUIManager.this.f25432o.setVisibility(8);
                } else if (i != 10001) {
                    if (i != 10002) {
                        switch (i) {
                            case 1017:
                                boolean unused = ZGGlobalUIManager.this.f25419A = ((Boolean) message.obj).booleanValue();
                                ZGGlobalUIManager.this.m20309e();
                                return;
                            case 1018:
                                if (ZGGlobalUIManager.this.f25428k != null) {
                                    ZGGlobalUIManager.this.f25428k.onReachDestination();
                                    return;
                                }
                                return;
                            case 1019:
                                ZGGlobalUIManager.this.m20305d();
                                return;
                            case 1020:
                                ZGGlobalUIManager.this.m20296a((String) message.obj);
                                return;
                            case 1021:
                                ZGGlobalUIManager.this.m20297a(((Boolean) message.obj).booleanValue());
                                return;
                            default:
                                return;
                        }
                    } else if (ZGGlobalUIManager.this.f25428k != null) {
                        ZGGlobalUIManager.this.f25428k.onHelpBtnClick();
                    }
                } else if (ZGGlobalUIManager.this.f25428k != null) {
                    ZGGlobalUIManager.this.f25428k.onFinishBtnClick();
                }
            }
        }
    };

    /* renamed from: E */
    private Runnable f25423E = new Runnable() {
        public void run() {
            ZGGlobalUIManager.this.f25433p.setVisibility(8);
            boolean unused = ZGGlobalUIManager.this.f25443z = false;
            ZGGlobalUIManager.this.m20309e();
        }
    };

    /* renamed from: g */
    private int f25424g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f25425h;

    /* renamed from: i */
    private float f25426i;

    /* renamed from: j */
    private SlidingUpPanelLayout f25427j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ZGUIListener f25428k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Context f25429l = null;

    /* renamed from: m */
    private View f25430m = null;

    /* renamed from: n */
    private ViewGroup f25431n = null;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public RelativeLayout f25432o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LinearLayout f25433p;

    /* renamed from: q */
    private TextView f25434q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public RelativeLayout f25435r;

    /* renamed from: s */
    private Button f25436s;

    /* renamed from: t */
    private Button f25437t;

    /* renamed from: u */
    private FrameLayout f25438u;

    /* renamed from: v */
    private LinearLayout f25439v;

    /* renamed from: w */
    private int f25440w;

    /* renamed from: x */
    private FrameLayout f25441x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f25442y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f25443z = false;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.zg.ZGGlobalUIManager$MsgType */
    public @interface MsgType {
    }

    public float getWindowWidthDP() {
        return ((float) this.f25424g) / this.f25426i;
    }

    public float getWindowHeightDP() {
        return ((float) this.f25425h) / this.f25426i;
    }

    public FrameLayout getArcLayout() {
        return this.f25441x;
    }

    public ZGGlobalUIManager(Context context, ViewGroup viewGroup, DiAREngine diAREngine) {
        attachEngine(diAREngine);
        this.f25429l = context;
        this.f25431n = viewGroup;
        m20293a(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hawaii_ar_zg_global, (ViewGroup) null);
        this.f25430m = inflate;
        this.f25432o = (RelativeLayout) inflate.findViewById(R.id.safe_alert);
        this.f25433p = (LinearLayout) this.f25430m.findViewById(R.id.common_toast);
        this.f25434q = (TextView) this.f25430m.findViewById(R.id.common_toast_tv);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f25433p.getLayoutParams();
        f25418f = layoutParams.bottomMargin;
        layoutParams.bottomMargin = ((int) (((float) this.f25425h) / 3.0f)) + DisplayUtils.dip2px(this.f25429l, 30.0f);
        this.f25433p.setLayoutParams(layoutParams);
        this.f25436s = (Button) this.f25430m.findViewById(R.id.back_btn);
        this.f25437t = (Button) this.f25430m.findViewById(R.id.question_btn);
        this.f25436s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGGlobalUIManager.this.f25422D.obtainMessage();
                obtainMessage.what = 10001;
                ZGGlobalUIManager.this.f25422D.sendMessage(obtainMessage);
            }
        });
        this.f25437t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGGlobalUIManager.this.f25422D.obtainMessage();
                obtainMessage.what = 10002;
                ZGGlobalUIManager.this.f25422D.sendMessage(obtainMessage);
            }
        });
        LinearLayout linearLayout = (LinearLayout) this.f25430m.findViewById(R.id.behind_tips);
        this.f25439v = linearLayout;
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams2.topMargin = (int) (((float) this.f25425h) / 3.0f);
        this.f25439v.setLayoutParams(layoutParams2);
        RelativeLayout relativeLayout = (RelativeLayout) this.f25430m.findViewById(R.id.expand_map);
        this.f25435r = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ZGGlobalUIManager.this.expandMapView();
            }
        });
        this.f25435r.setOnTouchListener(new View.OnTouchListener() {
            private int preX;
            private int preY;

            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.preX = (int) motionEvent.getRawX();
                    this.preY = (int) motionEvent.getRawY();
                    return false;
                } else if (action != 1) {
                    return false;
                } else {
                    int rawX = ((int) motionEvent.getRawX()) - this.preX;
                    int rawY = ((int) motionEvent.getRawY()) - this.preY;
                    if (Math.abs(rawX) >= Math.abs(rawY) || rawY >= 0) {
                        return false;
                    }
                    ZGGlobalUIManager.this.expandMapView();
                    return false;
                }
            }
        });
        m20300b();
        m20303c();
        updateZGEffectiveRect();
    }

    /* renamed from: a */
    private void m20293a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.f25424g = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f25425h = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f25426i = displayMetrics.density;
    }

    /* renamed from: b */
    private void m20300b() {
        SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) this.f25430m.findViewById(R.id.sliding_layout);
        this.f25427j = slidingUpPanelLayout;
        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        this.f25427j.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            SlidingUpPanelLayout.PanelState prevStateWhenChanged;

            public void onPanelSlide(View view, float f) {
            }

            public void onPanelStateChanged(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
                if (!(panelState == SlidingUpPanelLayout.PanelState.DRAGGING || panelState == SlidingUpPanelLayout.PanelState.ANCHORED)) {
                    this.prevStateWhenChanged = panelState;
                }
                if (SlidingUpPanelLayout.PanelState.DRAGGING == panelState2) {
                    ZGGlobalUIManager.this.f25435r.setVisibility(8);
                } else if (SlidingUpPanelLayout.PanelState.ANCHORED == panelState2) {
                    if (this.prevStateWhenChanged == SlidingUpPanelLayout.PanelState.EXPANDED) {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                    } else {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                    }
                } else if (SlidingUpPanelLayout.PanelState.EXPANDED == panelState2) {
                    ZGGlobalUIManager.this.f25435r.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ZGGlobalUIManager.this.f25433p.getLayoutParams();
                    layoutParams.bottomMargin = ((int) (((float) ZGGlobalUIManager.this.f25425h) / 3.0f)) + DisplayUtils.dip2px(ZGGlobalUIManager.this.f25429l, 30.0f);
                    ZGGlobalUIManager.this.f25433p.setLayoutParams(layoutParams);
                    AROmega.zgMapARNavDirectMapShow();
                } else if (SlidingUpPanelLayout.PanelState.COLLAPSED == panelState2) {
                    ZGGlobalUIManager.this.f25435r.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ZGGlobalUIManager.this.f25433p.getLayoutParams();
                    layoutParams2.bottomMargin = ZGGlobalUIManager.f25418f;
                    ZGGlobalUIManager.this.f25433p.setLayoutParams(layoutParams2);
                    AROmega.zgMapARNavDirectMapHide();
                }
                ZGGlobalUIManager.this.updateZGEffectiveRect();
            }
        });
        this.f25440w = ((int) (((float) this.f25425h) / 3.0f)) + DisplayUtils.dip2px(this.f25429l, 40.0f);
        this.f25438u = (FrameLayout) this.f25430m.findViewById(R.id.drag_view);
        this.f25438u.setLayoutParams(new SlidingUpPanelLayout.LayoutParams(-1, this.f25440w));
        FrameLayout frameLayout = (FrameLayout) this.f25430m.findViewById(R.id.map_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
        layoutParams.height = (int) (((float) this.f25425h) / 3.0f);
        frameLayout.setLayoutParams(layoutParams);
        if (MapVenderUtil.getCurrentMapType(this.f25429l) == MapVendor.DIDI) {
            this.f25441x = new ArcLayout(this.f25429l);
            frameLayout.addView(this.f25441x, new FrameLayout.LayoutParams(-1, -1));
            ArcLayout arcLayout = (ArcLayout) this.f25430m.findViewById(R.id.map_back_container);
            arcLayout.setVisibility(0);
            arcLayout.setClipAreaColor(-1);
            arcLayout.setLayoutParams(layoutParams);
            return;
        }
        this.f25430m.findViewById(R.id.map_back_container).setVisibility(8);
        int dip2px = DisplayUtils.dip2px(this.f25429l, 14.0f);
        View view = new View(this.f25429l);
        view.setBackgroundColor(-1);
        this.f25441x = new FrameLayout(this.f25429l);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) ((((float) this.f25425h) / 3.0f) - ((float) dip2px)));
        layoutParams2.gravity = 80;
        frameLayout.addView(this.f25441x, layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, dip2px);
        layoutParams3.gravity = 48;
        frameLayout.addView(view, layoutParams3);
    }

    public void updateZGEffectiveRect() {
        DARCPointF dARCPointF = new DARCPointF();
        dARCPointF.setX(20.0f);
        dARCPointF.setY(100.0f);
        DARCSizeF dARCSizeF = new DARCSizeF();
        int i = (int) ((((float) this.f25424g) / this.f25426i) - 40.0f);
        float f = 0.0f;
        dARCSizeF.setW(i > 0 ? (float) i : 0.0f);
        int i2 = (((int) (((float) this.f25425h) / this.f25426i)) - 100) - 130;
        if (SlidingUpPanelLayout.PanelState.EXPANDED == this.f25427j.getPanelState()) {
            i2 = ((int) (((float) (this.f25425h - this.f25440w)) / this.f25426i)) - 100;
        }
        if (i2 > 0) {
            f = (float) i2;
        }
        dARCSizeF.setH(f);
        DARCRectF dARCRectF = new DARCRectF();
        dARCRectF.setOrigin(dARCPointF);
        dARCRectF.setSize(dARCSizeF);
        if (this.mAREngine != null) {
            this.mAREngine.setZGEffectiveRect(dARCRectF);
        }
    }

    /* renamed from: c */
    private void m20303c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f25431n.indexOfChild(this.f25430m) < 0) {
            this.f25431n.addView(this.f25430m, layoutParams);
        } else {
            this.f25431n.updateViewLayout(this.f25430m, layoutParams);
        }
    }

    public void setListener(ZGUIListener zGUIListener) {
        this.f25428k = zGUIListener;
    }

    public void showSafeTips(int i) {
        if (!this.f25421C) {
            this.f25432o.setVisibility(0);
            Message obtainMessage = this.f25422D.obtainMessage();
            obtainMessage.what = 1015;
            this.f25422D.sendMessageDelayed(obtainMessage, (long) i);
            this.f25421C = true;
        }
    }

    public void onDriverArrived(String str) {
        if (!TextUtils.isEmpty(str)) {
            Message obtainMessage = this.f25422D.obtainMessage();
            obtainMessage.what = 1020;
            obtainMessage.obj = str;
            this.f25422D.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20296a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f25443z = false;
            this.f25422D.removeCallbacks(this.f25423E);
            this.f25442y = true;
            this.f25434q.setText(str);
            this.f25433p.setVisibility(0);
            this.f25422D.postDelayed(new Runnable() {
                public void run() {
                    ZGGlobalUIManager.this.f25433p.setVisibility(8);
                    boolean unused = ZGGlobalUIManager.this.f25442y = false;
                    ZGGlobalUIManager.this.m20309e();
                }
            }, 10000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m20305d() {
        if (!ARSharePref.isARZGFirstLaunch()) {
            ARSharePref.setARZGLaunched();
            this.f25443z = true;
            m20309e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m20309e() {
        if (!this.f25442y) {
            if (this.f25443z) {
                this.f25434q.setText(this.f25429l.getString(R.string.GRider_guide_Follow_the_iJTd));
                this.f25433p.setVisibility(0);
                this.f25422D.postDelayed(this.f25423E, 10000);
            } else if (this.f25419A) {
                this.f25434q.setText(this.f25429l.getString(R.string.GRider_guide_The_satellite_cwIE));
                this.f25433p.setVisibility(0);
            } else {
                this.f25433p.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20297a(boolean z) {
        if (z) {
            this.f25439v.setVisibility(0);
        } else {
            this.f25439v.setVisibility(8);
        }
    }

    public void onShowEndGuideNode() {
        Message obtainMessage = this.f25422D.obtainMessage();
        obtainMessage.what = 1019;
        this.f25422D.sendMessage(obtainMessage);
    }

    public void onBehindTipsMsg(boolean z) {
        Message obtainMessage = this.f25422D.obtainMessage();
        obtainMessage.what = 1021;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f25422D.sendMessage(obtainMessage);
    }

    public void onGpsWeak(boolean z) {
        Message obtainMessage = this.f25422D.obtainMessage();
        obtainMessage.what = 1017;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f25422D.sendMessage(obtainMessage);
    }

    public void onReachEnd(int i) {
        Message obtainMessage = this.f25422D.obtainMessage();
        obtainMessage.what = 1018;
        this.f25422D.sendMessageDelayed(obtainMessage, (long) i);
    }

    public void expandMapView() {
        SlidingUpPanelLayout slidingUpPanelLayout = this.f25427j;
        if (slidingUpPanelLayout != null && slidingUpPanelLayout.getPanelState() != SlidingUpPanelLayout.PanelState.EXPANDED) {
            this.f25427j.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        }
    }

    public void release() {
        this.f25441x.removeAllViews();
        this.f25422D.removeCallbacksAndMessages((Object) null);
        this.f25428k = null;
    }
}
