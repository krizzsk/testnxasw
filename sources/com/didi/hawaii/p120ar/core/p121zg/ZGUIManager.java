package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
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
import com.didi.hawaii.p120ar.core.BaseDelegate;
import com.didi.hawaii.p120ar.core.DiAREngine;
import com.didi.hawaii.p120ar.core.p121zg.slidingup.SlidingUpPanelLayout;
import com.didi.hawaii.p120ar.jni.DARCPointF;
import com.didi.hawaii.p120ar.jni.DARCRectF;
import com.didi.hawaii.p120ar.jni.DARCSizeF;
import com.didi.hawaii.p120ar.utils.AROmega;
import com.didi.hawaii.p120ar.utils.DisplayUtils;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* renamed from: com.didi.hawaii.ar.core.zg.ZGUIManager */
public class ZGUIManager extends BaseDelegate {
    public static final int BACKMSG = 10001;
    public static final int GPSWEAKMSG = 1017;
    public static final int HELPMSG = 10002;
    public static final int REACHENDMSG = 1018;
    public static final int SAFETIPS = 1015;

    /* renamed from: a */
    private static final int f25446a = 40;

    /* renamed from: b */
    private static final int f25447b = 100;

    /* renamed from: c */
    private static final int f25448c = 130;

    /* renamed from: d */
    private static final int f25449d = 20;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static int f25450e;

    /* renamed from: f */
    private int f25451f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f25452g;

    /* renamed from: h */
    private float f25453h;

    /* renamed from: i */
    private SlidingUpPanelLayout f25454i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ZGUIListener f25455j;

    /* renamed from: k */
    private Context f25456k = null;

    /* renamed from: l */
    private View f25457l = null;

    /* renamed from: m */
    private ViewGroup f25458m = null;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public RelativeLayout f25459n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public TextView f25460o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public RelativeLayout f25461p;

    /* renamed from: q */
    private Button f25462q;

    /* renamed from: r */
    private Button f25463r;

    /* renamed from: s */
    private FrameLayout f25464s;

    /* renamed from: t */
    private int f25465t;

    /* renamed from: u */
    private ArcLayout f25466u;

    /* renamed from: v */
    private boolean f25467v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Handler f25468w = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                int i = message.what;
                if (i == 1015) {
                    ZGUIManager.this.f25459n.setVisibility(8);
                } else if (i == 1017) {
                    ZGUIManager.this.m20318a(((Boolean) message.obj).booleanValue());
                } else if (i != 1018) {
                    if (i != 10001) {
                        if (i == 10002 && ZGUIManager.this.f25455j != null) {
                            ZGUIManager.this.f25455j.onHelpBtnClick();
                        }
                    } else if (ZGUIManager.this.f25455j != null) {
                        ZGUIManager.this.f25455j.onFinishBtnClick();
                    }
                } else if (ZGUIManager.this.f25455j != null) {
                    ZGUIManager.this.f25455j.onReachDestination();
                }
            }
        }
    };

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.zg.ZGUIManager$MsgType */
    public @interface MsgType {
    }

    /* renamed from: com.didi.hawaii.ar.core.zg.ZGUIManager$ZGUIListener */
    public interface ZGUIListener {
        void onFinishBtnClick();

        void onHelpBtnClick();

        void onReachDestination();
    }

    public void onDriverArrived(String str) {
    }

    public float getWindowWidthDP() {
        return ((float) this.f25451f) / this.f25453h;
    }

    public float getWindowHeightDP() {
        return ((float) this.f25452g) / this.f25453h;
    }

    public ArcLayout getArcLayout() {
        return this.f25466u;
    }

    public ZGUIManager(Context context, ViewGroup viewGroup, DiAREngine diAREngine) {
        attachEngine(diAREngine);
        this.f25456k = context;
        this.f25458m = viewGroup;
        m20316a(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.hawaii_ar_zg, (ViewGroup) null);
        this.f25457l = inflate;
        this.f25459n = (RelativeLayout) inflate.findViewById(R.id.safe_alert);
        TextView textView = (TextView) this.f25457l.findViewById(R.id.gps_weak);
        this.f25460o = textView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        f25450e = layoutParams.bottomMargin;
        layoutParams.bottomMargin = (int) (((float) this.f25452g) / 2.3f);
        this.f25460o.setLayoutParams(layoutParams);
        this.f25462q = (Button) this.f25457l.findViewById(R.id.back_btn);
        this.f25463r = (Button) this.f25457l.findViewById(R.id.question_btn);
        this.f25462q.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGUIManager.this.f25468w.obtainMessage();
                obtainMessage.what = 10001;
                ZGUIManager.this.f25468w.sendMessage(obtainMessage);
            }
        });
        this.f25463r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = ZGUIManager.this.f25468w.obtainMessage();
                obtainMessage.what = 10002;
                ZGUIManager.this.f25468w.sendMessage(obtainMessage);
            }
        });
        RelativeLayout relativeLayout = (RelativeLayout) this.f25457l.findViewById(R.id.expand_map);
        this.f25461p = relativeLayout;
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ZGUIManager.this.expandMapView();
            }
        });
        this.f25461p.setOnTouchListener(new View.OnTouchListener() {
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
                    ZGUIManager.this.expandMapView();
                    return false;
                }
            }
        });
        m20320b();
        m20322c();
        updateZGEffectiveRect();
    }

    /* renamed from: a */
    private void m20316a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        } else {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        this.f25451f = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f25452g = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.f25453h = displayMetrics.density;
    }

    /* renamed from: b */
    private void m20320b() {
        SlidingUpPanelLayout slidingUpPanelLayout = (SlidingUpPanelLayout) this.f25457l.findViewById(R.id.sliding_layout);
        this.f25454i = slidingUpPanelLayout;
        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        this.f25454i.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            SlidingUpPanelLayout.PanelState prevStateWhenChanged;

            public void onPanelSlide(View view, float f) {
            }

            public void onPanelStateChanged(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
                if (!(panelState == SlidingUpPanelLayout.PanelState.DRAGGING || panelState == SlidingUpPanelLayout.PanelState.ANCHORED)) {
                    this.prevStateWhenChanged = panelState;
                }
                if (SlidingUpPanelLayout.PanelState.DRAGGING == panelState2) {
                    ZGUIManager.this.f25461p.setVisibility(8);
                } else if (SlidingUpPanelLayout.PanelState.ANCHORED == panelState2) {
                    if (this.prevStateWhenChanged == SlidingUpPanelLayout.PanelState.EXPANDED) {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                    } else {
                        ((SlidingUpPanelLayout) view).setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                    }
                } else if (SlidingUpPanelLayout.PanelState.EXPANDED == panelState2) {
                    ZGUIManager.this.f25461p.setVisibility(8);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ZGUIManager.this.f25460o.getLayoutParams();
                    layoutParams.bottomMargin = (int) (((float) ZGUIManager.this.f25452g) / 2.3f);
                    ZGUIManager.this.f25460o.setLayoutParams(layoutParams);
                    AROmega.zgMapARNavDirectMapShow();
                } else if (SlidingUpPanelLayout.PanelState.COLLAPSED == panelState2) {
                    ZGUIManager.this.f25461p.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) ZGUIManager.this.f25460o.getLayoutParams();
                    layoutParams2.bottomMargin = ZGUIManager.f25450e;
                    ZGUIManager.this.f25460o.setLayoutParams(layoutParams2);
                    AROmega.zgMapARNavDirectMapHide();
                }
                ZGUIManager.this.updateZGEffectiveRect();
            }
        });
        this.f25465t = ((int) (((float) this.f25452g) / 3.0f)) + DisplayUtils.dip2px(this.f25456k, 40.0f);
        this.f25464s = (FrameLayout) this.f25457l.findViewById(R.id.drag_view);
        this.f25464s.setLayoutParams(new SlidingUpPanelLayout.LayoutParams(-1, this.f25465t));
        LinearLayout linearLayout = (LinearLayout) this.f25457l.findViewById(R.id.map_container);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
        layoutParams.height = (int) (((float) this.f25452g) / 3.0f);
        linearLayout.setLayoutParams(layoutParams);
        this.f25466u = new ArcLayout(this.f25456k);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.f25466u.setLayoutParams(layoutParams2);
        linearLayout.addView(this.f25466u);
        LinearLayout linearLayout2 = (LinearLayout) this.f25457l.findViewById(R.id.map_back_container);
        linearLayout2.setLayoutParams(layoutParams);
        ArcLayout arcLayout = new ArcLayout(this.f25456k);
        arcLayout.setLayoutParams(layoutParams2);
        arcLayout.setClipAreaColor(-1);
        linearLayout2.addView(arcLayout);
    }

    public void updateZGEffectiveRect() {
        DARCPointF dARCPointF = new DARCPointF();
        dARCPointF.setX(20.0f);
        dARCPointF.setY(100.0f);
        DARCSizeF dARCSizeF = new DARCSizeF();
        int i = (int) ((((float) this.f25451f) / this.f25453h) - 40.0f);
        float f = 0.0f;
        dARCSizeF.setW(i > 0 ? (float) i : 0.0f);
        int i2 = (((int) (((float) this.f25452g) / this.f25453h)) - 100) - 130;
        if (SlidingUpPanelLayout.PanelState.EXPANDED == this.f25454i.getPanelState()) {
            i2 = ((int) (((float) (this.f25452g - this.f25465t)) / this.f25453h)) - 100;
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
    private void m20322c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f25458m.indexOfChild(this.f25457l) < 0) {
            this.f25458m.addView(this.f25457l, layoutParams);
        } else {
            this.f25458m.updateViewLayout(this.f25457l, layoutParams);
        }
    }

    public void setListener(ZGUIListener zGUIListener) {
        this.f25455j = zGUIListener;
    }

    public void showSafeTips(int i) {
        if (!this.f25467v) {
            this.f25459n.setVisibility(0);
            Message obtainMessage = this.f25468w.obtainMessage();
            obtainMessage.what = 1015;
            this.f25468w.sendMessageDelayed(obtainMessage, (long) i);
            this.f25467v = true;
        }
    }

    public void onGpsWeak(boolean z) {
        Message obtainMessage = this.f25468w.obtainMessage();
        obtainMessage.what = 1017;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f25468w.sendMessage(obtainMessage);
    }

    public void onReachEnd(int i) {
        Message obtainMessage = this.f25468w.obtainMessage();
        obtainMessage.what = 1018;
        this.f25468w.sendMessageDelayed(obtainMessage, (long) i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20318a(boolean z) {
        if (z) {
            this.f25460o.setVisibility(0);
        } else {
            this.f25460o.setVisibility(8);
        }
    }

    public void expandMapView() {
        SlidingUpPanelLayout slidingUpPanelLayout = this.f25454i;
        if (slidingUpPanelLayout != null && slidingUpPanelLayout.getPanelState() != SlidingUpPanelLayout.PanelState.EXPANDED) {
            this.f25454i.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
        }
    }

    public void release() {
        this.f25466u.removeAllViews();
        this.f25468w.removeCallbacksAndMessages((Object) null);
        this.f25455j = null;
    }
}
