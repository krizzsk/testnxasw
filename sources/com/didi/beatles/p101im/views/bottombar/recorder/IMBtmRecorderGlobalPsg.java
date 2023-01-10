package com.didi.beatles.p101im.views.bottombar.recorder;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.graphics.drawable.DrawableCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.beatles.p101im.IMContextInfoHelper;
import com.didi.beatles.p101im.activity.IMMessageActivity;
import com.didi.beatles.p101im.common.IMBtsAudioHelper;
import com.didi.beatles.p101im.common.audio.IMRecorderManager;
import com.didi.beatles.p101im.resource.IMResource;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import com.didi.beatles.p101im.views.IMTipsToast;
import com.didi.beatles.p101im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p101im.views.bottombar.IMConversationBottomBar;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg */
public class IMBtmRecorderGlobalPsg implements IMBtmRecorder {

    /* renamed from: b */
    private static final int f11910b = 0;

    /* renamed from: c */
    private static final int f11911c = 1;

    /* renamed from: d */
    private static final int f11912d = 0;

    /* renamed from: e */
    private static final int f11913e = 1;

    /* renamed from: f */
    private static final int f11914f = 2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public int f11915A = 0;

    /* renamed from: B */
    private int f11916B = 1;

    /* renamed from: C */
    private String f11917C = null;

    /* renamed from: D */
    private IMRecorderManager.Callback f11918D = null;

    /* renamed from: E */
    private View.OnTouchListener f11919E = new View.OnTouchListener() {
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
            if (r4 != 3) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouch(android.view.View r4, android.view.MotionEvent r5) {
            /*
                r3 = this;
                int r4 = r5.getAction()
                r0 = 1
                if (r4 == 0) goto L_0x0066
                r1 = 2
                if (r4 == r0) goto L_0x0035
                if (r4 == r1) goto L_0x0011
                r5 = 3
                if (r4 == r5) goto L_0x0035
                goto L_0x0085
            L_0x0011:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r4 = r4.f11915A
                if (r4 != 0) goto L_0x001a
                return r0
            L_0x001a:
                float r4 = r5.getRawX()
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r5 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r5 = r5.f11921g
                float r5 = (float) r5
                int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                if (r4 <= 0) goto L_0x002f
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m10257a((int) r0)
                goto L_0x0085
            L_0x002f:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m10257a((int) r1)
                goto L_0x0085
            L_0x0035:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                com.airbnb.lottie.LottieAnimationView r4 = r4.f11927m
                r4.cancelAnimation()
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r4 = r4.f11915A
                r5 = 0
                if (r4 != 0) goto L_0x0048
                return r5
            L_0x0048:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                int r4 = r4.f11915A
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r2 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                if (r4 != r0) goto L_0x0053
                r5 = 1
            L_0x0053:
                r2.m10264a((boolean) r5)
                if (r4 != r0) goto L_0x005e
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m10274f()
                goto L_0x0085
            L_0x005e:
                if (r4 != r1) goto L_0x0085
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m10275g()
                goto L_0x0085
            L_0x0066:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m10256a()
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                com.airbnb.lottie.LottieAnimationView r4 = r4.f11927m
                boolean r4 = r4.isAnimating()
                if (r4 != 0) goto L_0x0080
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                com.airbnb.lottie.LottieAnimationView r4 = r4.f11927m
                r4.playAnimation()
            L_0x0080:
                com.didi.beatles.im.views.bottombar.recorder.IMBtmRecorderGlobalPsg r4 = com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.this
                r4.m10271e()
            L_0x0085:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p101im.views.bottombar.recorder.IMBtmRecorderGlobalPsg.C48642.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    };

    /* renamed from: a */
    private final String f11920a = "IMBtmRecorderGlobalPsg";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final int f11921g = IMViewUtil.dp2px(IMContextInfoHelper.getContext(), 100.0f);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Activity f11922h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ViewGroup f11923i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ConstraintLayout f11924j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IMBaseBottomBar.BottomBarListener f11925k;

    /* renamed from: l */
    private TextView f11926l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public LottieAnimationView f11927m;

    /* renamed from: n */
    private View f11928n;

    /* renamed from: o */
    private View f11929o;

    /* renamed from: p */
    private View f11930p;

    /* renamed from: q */
    private View f11931q;

    /* renamed from: r */
    private View f11932r;

    /* renamed from: s */
    private View f11933s;

    /* renamed from: t */
    private Drawable f11934t;

    /* renamed from: u */
    private GradientDrawable f11935u;

    /* renamed from: v */
    private GradientDrawable f11936v;

    /* renamed from: w */
    private GradientDrawable f11937w;

    /* renamed from: x */
    private Drawable f11938x;

    /* renamed from: y */
    private ConstraintSet f11939y;

    /* renamed from: z */
    private ConstraintSet f11940z;

    public void bindListener(TextView textView, IMBaseBottomBar iMBaseBottomBar) {
        this.f11922h = (Activity) iMBaseBottomBar.context;
        this.f11925k = ((IMConversationBottomBar) iMBaseBottomBar).mListener;
        this.f11923i = (ViewGroup) ((IMMessageActivity) iMBaseBottomBar.context).findViewById(R.id.bts_im_layout_root);
        textView.setOnTouchListener(this.f11919E);
    }

    public boolean interceptBackPressed() {
        if (this.f11915A == 0) {
            return false;
        }
        m10264a(false);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10256a() {
        m10266b();
        ConstraintLayout constraintLayout = this.f11924j;
        if (constraintLayout != null) {
            if (this.f11923i.indexOfChild(constraintLayout) < 0) {
                this.f11923i.addView(this.f11924j, new ViewGroup.LayoutParams(-1, -1));
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f11922h, R.anim.im_record_in_global_psg);
            this.f11924j.clearAnimation();
            this.f11924j.setAnimation(loadAnimation);
            loadAnimation.start();
            m10257a(1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10264a(final boolean z) {
        if (this.f11915A != 0) {
            this.f11915A = 0;
            if (this.f11924j != null) {
                this.f11923i.post(new Runnable() {
                    public void run() {
                        Animation animation;
                        if (IMBtmRecorderGlobalPsg.this.f11915A == 0) {
                            IMBtmRecorderGlobalPsg.this.f11924j.clearAnimation();
                            if (z) {
                                animation = AnimationUtils.loadAnimation(IMBtmRecorderGlobalPsg.this.f11922h, R.anim.im_record_out_global_psg);
                            } else {
                                animation = AnimationUtils.loadAnimation(IMBtmRecorderGlobalPsg.this.f11922h, R.anim.im_record_cancel_global_psg);
                            }
                            IMBtmRecorderGlobalPsg.this.f11924j.setAnimation(animation);
                            animation.setAnimationListener(new Animation.AnimationListener() {
                                public void onAnimationRepeat(Animation animation) {
                                }

                                public void onAnimationStart(Animation animation) {
                                }

                                public void onAnimationEnd(Animation animation) {
                                    UiThreadHandler.post(new Runnable() {
                                        public void run() {
                                            if (IMBtmRecorderGlobalPsg.this.f11915A == 0) {
                                                IMBtmRecorderGlobalPsg.this.f11923i.removeView(IMBtmRecorderGlobalPsg.this.f11924j);
                                            }
                                        }
                                    });
                                }
                            });
                            animation.start();
                        }
                    }
                });
            }
        }
    }

    /* renamed from: b */
    private void m10266b() {
        if (this.f11924j == null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(this.f11923i.getContext()).inflate(R.layout.im_layout_recorder_global_psg, this.f11923i, false);
            this.f11924j = constraintLayout;
            this.f11926l = (TextView) constraintLayout.findViewById(R.id.im_record_tip_text);
            this.f11928n = this.f11924j.findViewById(R.id.im_record_icon_icon);
            this.f11929o = this.f11924j.findViewById(R.id.im_record_icon_bg);
            this.f11930p = this.f11924j.findViewById(R.id.im_record_tip_shape);
            this.f11931q = this.f11924j.findViewById(R.id.im_record_tip_triangle);
            this.f11932r = this.f11924j.findViewById(R.id.im_record_del);
            this.f11933s = this.f11924j.findViewById(R.id.im_record_del_bg);
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f11924j.findViewById(R.id.im_record_sound);
            this.f11927m = lottieAnimationView;
            lottieAnimationView.setAnimation("im/im_recording_global_psg.json");
            this.f11927m.setRepeatCount(-1);
            ConstraintSet constraintSet = new ConstraintSet();
            this.f11939y = constraintSet;
            constraintSet.clone(this.f11924j);
            ConstraintSet constraintSet2 = new ConstraintSet();
            this.f11940z = constraintSet2;
            constraintSet2.clone(this.f11923i.getContext(), R.layout.im_layout_recorder_cancel_global_psg);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10257a(int i) {
        if (i != this.f11915A && this.f11924j != null) {
            this.f11915A = i;
            if (Build.VERSION.SDK_INT >= 19) {
                TransitionManager.beginDelayedTransition(this.f11924j, (Transition) null);
            }
            int i2 = this.f11915A;
            if (i2 == 1) {
                m10268c();
                this.f11939y.applyTo(this.f11924j);
            } else if (i2 == 2) {
                m10270d();
                this.f11940z.applyTo(this.f11924j);
            }
        }
    }

    /* renamed from: c */
    private void m10268c() {
        this.f11926l.setText(IMResource.getString(R.string.bts_im_record_bt_tip));
        this.f11928n.setBackgroundResource(R.drawable.im_icon_record_global_psg);
        if (this.f11935u == null) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.f11929o.getResources().getDrawable(R.drawable.im_default_circle_mask).mutate();
            this.f11935u = gradientDrawable;
            gradientDrawable.setColor(-1);
        }
        this.f11929o.setBackgroundDrawable(this.f11935u);
        this.f11930p.setBackgroundResource(R.drawable.im_record_tip_shape_global_psg);
        this.f11931q.setBackgroundResource(R.drawable.im_record_tip_triangle_global_psg);
        this.f11933s.setBackgroundResource(R.drawable.im_trans_fun_shaped_mask);
        this.f11932r.setBackgroundResource(R.drawable.im_icon_del_global_psg);
    }

    /* renamed from: d */
    private void m10270d() {
        this.f11926l.setText(IMResource.getString(R.string.bts_im_record_cancle_tip));
        if (this.f11934t == null) {
            Drawable wrap = DrawableCompat.wrap(this.f11928n.getResources().getDrawable(R.drawable.im_icon_record_global_psg).mutate());
            this.f11934t = wrap;
            wrap.setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        }
        this.f11928n.setBackgroundDrawable(this.f11934t);
        if (this.f11936v == null) {
            GradientDrawable gradientDrawable = (GradientDrawable) this.f11929o.getResources().getDrawable(R.drawable.im_default_circle_mask).mutate();
            this.f11936v = gradientDrawable;
            gradientDrawable.setColor(Color.parseColor("#660A121A"));
        }
        this.f11929o.setBackgroundDrawable(this.f11936v);
        if (this.f11937w == null) {
            GradientDrawable gradientDrawable2 = (GradientDrawable) this.f11930p.getResources().getDrawable(R.drawable.im_record_tip_shape_global_psg).mutate();
            this.f11937w = gradientDrawable2;
            gradientDrawable2.setColor(Color.parseColor(ColorUtils.DIDI_RED));
        }
        this.f11930p.setBackgroundDrawable(this.f11937w);
        if (this.f11938x == null) {
            Drawable mutate = this.f11930p.getResources().getDrawable(R.drawable.im_record_tip_triangle_global_psg).mutate();
            this.f11938x = mutate;
            mutate.setColorFilter(Color.parseColor(ColorUtils.DIDI_RED), PorterDuff.Mode.SRC_ATOP);
        }
        this.f11931q.setBackgroundDrawable(this.f11938x);
        this.f11933s.setBackgroundResource(R.drawable.im_default_fun_shaped_mask);
        this.f11932r.setBackgroundResource(R.drawable.im_icon_open_del_global_psg);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m10271e() {
        IMLog.m10020d("IMBtmRecorderGlobalPsg", this.f11916B + "");
        if (this.f11916B == 1) {
            this.f11916B = 0;
            IMBtsAudioHelper.stopPlaying();
            m10278h();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m10274f() {
        IMLog.m10020d("IMBtmRecorderGlobalPsg", this.f11916B + "");
        if (this.f11916B == 0) {
            this.f11916B = 1;
            IMRecorderManager.getInstance().stop(this.f11917C, this.f11918D);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m10275g() {
        IMLog.m10020d("IMBtmRecorderGlobalPsg", this.f11916B + "");
        if (this.f11916B == 0) {
            this.f11916B = 1;
            IMRecorderManager.getInstance().cancel(this.f11917C, this.f11918D);
        }
    }

    /* renamed from: h */
    private void m10278h() {
        this.f11917C = IMRecorderManager.createFileId();
        this.f11918D = new IMRecorderManager.Callback() {
            public void onResidueTimeChange(String str) {
            }

            public void onSoundLevelChange(int i) {
            }

            public void onStartRecord() {
            }

            public void onError(int i, String str) {
                if (i == 1) {
                    IMBtmRecorderGlobalPsg.this.m10259a((int) R.drawable.im_toast_warm, str);
                } else if (i == 2) {
                    IMBtmRecorderGlobalPsg.this.m10258a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_audio_recorded_so_short);
                } else if (i != 3) {
                    IMLog.m10026w(C4786I.m9980t("startAudioRecorder errNo ", Integer.valueOf(i), " errMsg ", str), new Object[0]);
                } else {
                    IMBtmRecorderGlobalPsg.this.m10258a((int) R.drawable.im_toast_warm, (int) R.string.bts_im_record_error);
                }
            }

            public void onSuccess(String str, long j) {
                if (IMBtmRecorderGlobalPsg.this.f11925k != null) {
                    IMBtmRecorderGlobalPsg.this.f11925k.sendVoiceMessage(str, j);
                }
            }

            public void onEndRecord() {
                IMBtmRecorderGlobalPsg.this.m10264a(true);
            }
        };
        IMRecorderManager.getInstance().recorder(this.f11917C, this.f11918D);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10258a(int i, int i2) {
        m10259a(i, IMResource.getString(i2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10259a(int i, String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) str, 0);
        SystemUtils.showToast(makeText);
        IMTipsToast.setIconKeepSize(makeText, i);
        IMTipsToast.setText(makeText, str);
    }
}
