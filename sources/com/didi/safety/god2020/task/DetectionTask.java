package com.didi.safety.god2020.task;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.safety.god.event.RestartDetectionEvent;
import com.didi.safety.god.event.TaskType;
import com.didi.safety.god.http.Card;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.p145ui.CaptureRequestsFragment;
import com.didi.safety.god.p145ui.DetectionRectBgDrawables;
import com.didi.safety.god.p145ui.GLSurfaceRecorder;
import com.didi.safety.god.p145ui.HollowEffectView;
import com.didi.safety.god.p145ui.PosSizeInfo;
import com.didi.safety.god.util.Constant;
import com.didi.safety.god.util.IMediaPlayer;
import com.didi.safety.god.util.LogUtils;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public abstract class DetectionTask implements View.OnClickListener, GLSurfaceRecorder.RecordListener {

    /* renamed from: H */
    private static final int f37616H = 0;

    /* renamed from: I */
    private static final int f37617I = 1;

    /* renamed from: J */
    private static final int f37618J = 2;

    /* renamed from: K */
    private static final int f37619K = 3;

    /* renamed from: L */
    private static final int f37620L = 4;

    /* renamed from: M */
    private static final int f37621M = 5;

    /* renamed from: N */
    private static final int f37622N = 6;

    /* renamed from: k */
    private static final String f37623k = "voice_on";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public AnimatorSet f37624A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final int f37625B;

    /* renamed from: C */
    private boolean f37626C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public float f37627D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public float f37628E;

    /* renamed from: F */
    private SPHelper f37629F;

    /* renamed from: G */
    private IMediaPlayer f37630G;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public int f37631O;

    /* renamed from: P */
    private final Runnable f37632P = new Runnable() {
        public void run() {
            DetectionTask.this.f37651q.setVisibility(4);
        }
    };

    /* renamed from: Q */
    private boolean f37633Q;

    /* renamed from: R */
    private boolean f37634R;

    /* renamed from: S */
    private String f37635S = "global_doorgod_torch_state";

    /* renamed from: a */
    private final GLSurfaceRecorder f37636a;
    protected final FragmentActivity activity;

    /* renamed from: b */
    private final View f37637b;

    /* renamed from: c */
    private final View f37638c;
    protected final Card card;
    protected String cardDesc;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TaskListener f37639d;

    /* renamed from: e */
    private ImageView f37640e;

    /* renamed from: f */
    private TextView f37641f;

    /* renamed from: g */
    private TextView f37642g;

    /* renamed from: h */
    private ImageView f37643h;

    /* renamed from: i */
    private ImageView f37644i;

    /* renamed from: j */
    private boolean f37645j;

    /* renamed from: l */
    private HollowEffectView f37646l;
    protected int label;

    /* renamed from: m */
    private TextView f37647m;

    /* renamed from: n */
    private TextView f37648n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public FrameLayout f37649o;

    /* renamed from: p */
    private FrameLayout f37650p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ImageView f37651q;

    /* renamed from: r */
    private TextView f37652r;

    /* renamed from: s */
    private View f37653s;

    /* renamed from: t */
    private ImageView f37654t;

    /* renamed from: u */
    private ImageView f37655u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public FrameLayout f37656v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public View f37657w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ImageView f37658x;

    /* renamed from: y */
    private TextView f37659y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public TextView f37660z;

    public interface TaskListener {
        void onComplete();
    }

    public void onDetectNoGoodQuality(int i) {
    }

    public DetectionTask(FragmentActivity fragmentActivity, View view, View view2, GLSurfaceRecorder gLSurfaceRecorder, Card card2) {
        this.activity = fragmentActivity;
        this.f37637b = view;
        this.f37638c = view2;
        this.f37636a = gLSurfaceRecorder;
        gLSurfaceRecorder.setVideoLength(card2.getVideoLength());
        this.f37636a.setTimeoutSec(card2.getTimeOutSec());
        this.card = card2;
        this.f37625B = card2.getVideoLength();
        if (this.card.getTimeOutSec() > 0) {
            GodManager.getInstance().getConfig().timeOutSec = (long) this.card.getTimeOutSec();
        }
        if (card2.getAlgoType() != null) {
            this.label = card2.getAlgoType().intValue();
        } else {
            this.label = TaskType.convertToLocalType(card2.getCardName());
        }
        if (!card2.algoModelSwitch) {
            GodManager.getInstance().setManual(true);
        }
        if (card2.getCardImgName() == null || card2.getCardImgName().trim().length() <= 0) {
            this.cardDesc = TaskType.getTaskDesc(this.label);
        } else {
            this.cardDesc = card2.getCardImgName();
        }
        this.f37629F = new SPHelper(fragmentActivity, Constant.SP_FILE);
        this.f37630G = IMediaPlayer.getInstance();
    }

    /* renamed from: d */
    private void m28325d() {
        this.f37637b.findViewById(R.id.start_detection).setOnClickListener(this);
        this.f37637b.findViewById(R.id.back_layout).setOnClickListener(this);
        this.f37640e = (ImageView) this.f37637b.findViewById(R.id.card_preview);
        this.f37641f = (TextView) this.f37637b.findViewById(R.id.card_preview_title);
        this.f37642g = (TextView) this.f37637b.findViewById(R.id.card_preview_requests);
        ImageView imageView = (ImageView) this.f37638c.findViewById(R.id.camera_icon_click);
        this.f37643h = imageView;
        if (imageView.getVisibility() == 0) {
            this.f37643h.setVisibility(4);
        }
        this.f37643h.setOnClickListener(this);
        this.f37646l = (HollowEffectView) this.f37638c.findViewById(R.id.detection_hollow_effect_view);
        this.f37647m = (TextView) this.f37638c.findViewById(R.id.detection_label_title);
        FrameLayout frameLayout = (FrameLayout) this.f37638c.findViewById(R.id.detection_real_rect);
        this.f37649o = frameLayout;
        frameLayout.setOnClickListener(this);
        this.f37649o.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (DetectionTask.this.f37631O != 1 || motionEvent.getActionMasked() != 0) {
                    return false;
                }
                int left = DetectionTask.this.f37651q.getLeft();
                int top = DetectionTask.this.f37651q.getTop();
                int width = DetectionTask.this.f37651q.getWidth();
                int height = DetectionTask.this.f37651q.getHeight();
                LogUtils.m28307d("down focusIcon, left===" + left + ", w=" + width + ", top=" + top + ", h=" + height);
                float x = motionEvent.getX() - (((float) width) / 2.0f);
                float y = motionEvent.getY() - (((float) height) / 2.0f);
                StringBuilder sb = new StringBuilder();
                sb.append("down x===");
                sb.append(x);
                sb.append(", y=");
                sb.append(y);
                LogUtils.m28307d(sb.toString());
                float unused = DetectionTask.this.f37627D = x - ((float) left);
                float unused2 = DetectionTask.this.f37628E = y - ((float) top);
                LogUtils.m28307d("down transX===" + DetectionTask.this.f37627D + ", transY=" + DetectionTask.this.f37628E);
                return false;
            }
        });
        this.f37650p = (FrameLayout) this.f37638c.findViewById(R.id.detection_preview_rect);
        this.f37651q = (ImageView) this.f37638c.findViewById(R.id.detection_focus_icon);
        this.f37653s = this.f37638c.findViewById(R.id.detection_weak_warn);
        this.f37652r = (TextView) this.f37638c.findViewById(R.id.detection_weak_warn_text);
        this.f37654t = (ImageView) this.f37638c.findViewById(R.id.detection_cover_layer_icon);
        ImageView imageView2 = (ImageView) this.f37638c.findViewById(R.id.camera_flashlight_click);
        this.f37655u = imageView2;
        imageView2.setImageResource(this.f37634R ? R.drawable.btn_torch_open : R.drawable.btn_torch_close);
        this.f37655u.setOnClickListener(this);
        this.f37656v = (FrameLayout) this.f37638c.findViewById(R.id.detection_recognize_rect);
        this.f37657w = this.f37638c.findViewById(R.id.detection_bg_grid);
        this.f37658x = (ImageView) this.f37638c.findViewById(R.id.detection_animator_view);
        this.f37659y = (TextView) this.f37638c.findViewById(R.id.detection_recognize_title);
        this.f37660z = (TextView) this.f37638c.findViewById(R.id.detection_recognize_countdown);
        this.f37638c.findViewById(R.id.back_layout).setOnClickListener(this);
        this.f37638c.findViewById(R.id.detection_label_req_icon).setOnClickListener(this);
    }

    public void setLast() {
        this.f37626C = true;
    }

    /* access modifiers changed from: protected */
    public boolean isLast() {
        return this.f37626C;
    }

    public void start(TaskListener taskListener) {
        m28325d();
        this.f37639d = taskListener;
        m28327e();
    }

    /* renamed from: e */
    private void m28327e() {
        closeCamera();
        m28319a(this.cardDesc, this.card.getCardReqContent(this.activity), this.card.getPreviewUrl());
        this.activity.setContentView(this.f37637b);
        this.f37631O = 0;
    }

    /* renamed from: a */
    private void m28319a(String str, String str2, String str3) {
        this.f37641f.setText(str);
        this.f37642g.setText(Html.fromHtml(str2));
        DiSafetyImageLoader.with(this.activity).load(str3).placeholder((int) R.drawable.safety_preview_default).into(this.f37640e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo96470a() {
        m28329f();
        this.f37636a.setRecordListener(this);
        boolean startDetection = this.f37636a.startDetection(this.label, this.card.getCardName(), this.card.getPicAutoDect());
        m28320a(startDetection);
        if (startDetection) {
            this.f37646l.setTargetView(this.f37649o);
            m28331g();
            return;
        }
        ToastHelper.showLongInfo((Context) this.activity, (int) R.string.GRider_OCR_Camera_permissions_jaju);
        this.activity.finish();
    }

    /* renamed from: f */
    private void m28329f() {
        this.f37631O = 1;
        DetectionRectBgDrawables.setBg(this.f37649o, R.drawable.safety_detection_scanner_rect_orange);
        this.f37650p.setVisibility(0);
        this.f37656v.setVisibility(4);
        this.f37651q.setTranslationX(0.0f);
        this.f37651q.setTranslationY(0.0f);
        this.f37647m.setText(this.card.getCardImgName());
        if ("CL_J1".equals(this.card.getCardName())) {
            DiSafetyImageLoader.with(this.activity.getApplicationContext()).load(this.card.getOutlineUrl()).into(this.f37654t);
        } else {
            this.f37654t.setImageResource(0);
        }
        this.f37659y.setText(R.string.GRider_OCR_Do_not_ftpI);
        this.activity.setContentView(this.f37638c);
    }

    /* renamed from: a */
    private void m28320a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "STARTCAPTURE");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, z ? "" : "open camera failed");
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* renamed from: g */
    private void m28331g() {
        this.f37636a.startAutoFocus(GodManager.getInstance().getConfig().delayedFocusTime);
        this.f37651q.setVisibility(0);
        UIHandler.removeCallbacks(this.f37632P);
        UIHandler.postDelayed(2000, this.f37632P);
    }

    /* access modifiers changed from: protected */
    public void moveToUploadStep() {
        this.f37631O = 3;
    }

    /* access modifiers changed from: protected */
    public void moveToOcrFailedStep() {
        this.f37631O = 4;
    }

    /* access modifiers changed from: protected */
    public void moveToReconizedFailedStep() {
        this.f37631O = 5;
    }

    /* access modifiers changed from: protected */
    public void moveToDefaultFailedStep() {
        this.f37631O = 6;
    }

    /* renamed from: h */
    private void m28333h() {
        if (this.f37631O == 1) {
            this.f37636a.refocus();
            this.f37651q.setVisibility(0);
            this.f37651q.setTranslationX(this.f37627D);
            this.f37651q.setTranslationY(this.f37628E);
            UIHandler.removeCallbacks(this.f37632P);
            UIHandler.postDelayed(2000, this.f37632P);
        }
    }

    public void logReqFocusEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "REQFOCUS");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void logFocusEvent(Map<String, Object> map) {
        map.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(map);
    }

    public String getCollectType() {
        return this.card.getCardName();
    }

    /* access modifiers changed from: protected */
    public void changeToRedErrorRect() {
        DetectionRectBgDrawables.setBg(this.f37649o, R.drawable.safety_detection_scanner_rect_red);
    }

    public void onDetectPosSizeInfo(PosSizeInfo posSizeInfo) {
        if (posSizeInfo.disState > 0) {
            this.f37652r.setText(posSizeInfo.disState == 1 ? R.string.GRider_OCR_Please_come_OLDR : R.string.GRider_OCR_Stay_away_HQmP);
            this.f37653s.setVisibility(0);
            this.f37652r.setVisibility(0);
            this.f37633Q = true;
        } else if (posSizeInfo.notCentered) {
            this.f37652r.setText(R.string.GRider_OCR_Please_complete_gZWm);
            this.f37653s.setVisibility(0);
            this.f37652r.setVisibility(0);
        } else {
            this.f37652r.setText("");
            this.f37653s.setVisibility(4);
            this.f37652r.setVisibility(4);
            if (this.f37633Q) {
                m28333h();
                this.f37633Q = false;
            }
        }
    }

    public void onLightnessChecked(float f) {
        if (GodManager.getInstance().getManualState()) {
            ImageView imageView = this.f37643h;
            if (imageView == null || imageView.getVisibility() == 0) {
                if (f <= 800.0f) {
                    this.f37643h.setVisibility(4);
                    this.f37643h.setEnabled(false);
                }
            } else if (f > 800.0f) {
                this.f37643h.setVisibility(0);
                this.f37643h.setEnabled(true);
            }
        }
    }

    public void handleFinalWrongSizeInfo(int i, boolean z) {
        mo96471b();
        String string = this.activity.getString(i > 0 ? i == 1 ? R.string.GRider_OCR_Please_come_OLDR : R.string.GRider_OCR_Stay_away_HQmP : R.string.GRider_OCR_Please_complete_gZWm);
        this.f37652r.setText(string);
        this.f37653s.setVisibility(0);
        this.f37652r.setVisibility(0);
        BusUtils.post(new RestartDetectionEvent());
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "COLLPIC");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, string);
        hashMap.put("code", 5);
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void onDetectWrongLabel() {
        this.f37652r.setText("");
        this.f37653s.setVisibility(4);
        this.f37652r.setVisibility(4);
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "COLLPIC");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "detect wrong label");
        hashMap.put("code", 4);
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void restartDetection() {
        this.f37631O = 1;
        DetectionRectBgDrawables.setBg(this.f37649o, R.drawable.safety_detection_scanner_rect_orange);
        this.f37650p.setVisibility(0);
        this.f37656v.setVisibility(4);
        this.f37636a.restart(this.label, this.card.getCardName(), this.card.getPicAutoDect());
        onResume();
        this.f37627D = 0.0f;
        this.f37628E = 0.0f;
        m28333h();
    }

    public void restartFromBeginning() {
        m28327e();
    }

    /* access modifiers changed from: protected */
    public void recordAndCapture() {
        this.f37636a.recordAndCapture();
    }

    public void quitTask() {
        LogUtils.m28307d("quitTask===");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo96471b() {
        AnimatorSet animatorSet = this.f37624A;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f37624A = null;
            this.f37656v.setVisibility(4);
        }
    }

    /* renamed from: i */
    private void m28335i() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "STARTVID");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void onDetectNothing() {
        clearWeakNotify();
    }

    public void onCaptureFinished(GLSurfaceRecorder.PicInfo picInfo) {
        this.f37634R = false;
        this.f37629F.put(this.f37635S, false).apply();
        this.f37636a.torchOff();
    }

    public void onRecordVideoStart(GLSurfaceRecorder.VideoInfo videoInfo) {
        this.f37631O = 2;
        DetectionRectBgDrawables.setBg(this.f37649o, R.drawable.safety_detection_scanner_rect_blue);
        this.f37650p.setVisibility(4);
        m28335i();
        this.f37638c.postDelayed(new Runnable() {
            public void run() {
                DetectionTask.this.f37656v.setVisibility(0);
                long f = (long) (DetectionTask.this.f37625B * 1000);
                LogUtils.m28307d("recognize animation total duration===" + f);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DetectionTask.this.f37657w, "alpha", new float[]{0.0f, 1.0f});
                ofFloat.setDuration((2 * f) / 3);
                int height = DetectionTask.this.f37658x.getHeight();
                int i = height / -2;
                int height2 = DetectionTask.this.f37649o.getHeight() - height;
                ObjectAnimator duration = ObjectAnimator.ofFloat(DetectionTask.this.f37658x, "translationY", new float[]{(float) i, (float) height2}).setDuration(f);
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{DetectionTask.this.f37625B, 0});
                ofInt.setDuration(f);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        String valueOf = String.valueOf(valueAnimator.getAnimatedValue());
                        if (!TextUtils.equals(valueOf, DetectionTask.this.f37660z.getText())) {
                            DetectionTask.this.f37660z.setText(valueOf);
                        }
                    }
                });
                if (DetectionTask.this.f37624A == null) {
                    AnimatorSet unused = DetectionTask.this.f37624A = new AnimatorSet();
                    DetectionTask.this.f37624A.setInterpolator(new LinearInterpolator());
                    DetectionTask.this.f37624A.playTogether(new Animator[]{ofFloat, duration, ofInt});
                    DetectionTask.this.f37624A.start();
                }
            }
        }, 800);
    }

    /* access modifiers changed from: protected */
    public void notifyTaskListener() {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                if (DetectionTask.this.f37639d != null) {
                    DetectionTask.this.f37639d.onComplete();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void closeCamera() {
        this.f37636a.closeCamera();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.start_detection) {
            mo96470a();
            if (GodManager.getInstance().getManualState()) {
                m28331g();
            }
        } else if (id == R.id.back_layout) {
            if (this.f37631O != 2) {
                this.activity.onBackPressed();
            }
        } else if (id == R.id.detection_label_req_icon) {
            m28337j();
            CaptureRequestsFragment newInstance = CaptureRequestsFragment.newInstance(this.card.getPreviewUrl(), this.card.getCardImgName(), this.card.getCardReqContent(this.activity), 0);
            FragmentTransaction beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.detection_fragment_container, newInstance);
            beginTransaction.addToBackStack((String) null);
            beginTransaction.commitAllowingStateLoss();
        } else if (id == R.id.detection_real_rect) {
            m28333h();
        } else if (id == R.id.camera_icon_click) {
            this.f37636a.startCapture();
        } else if (id == R.id.camera_flashlight_click) {
            boolean z = !this.f37634R;
            this.f37634R = z;
            this.f37655u.setImageResource(z ? R.drawable.btn_torch_open : R.drawable.btn_torch_close);
            this.f37629F.put(this.f37635S, Boolean.valueOf(this.f37634R)).apply();
            if (this.f37634R) {
                this.f37636a.torchOn();
            } else {
                this.f37636a.torchOff();
            }
        }
    }

    public void clearWeakNotify() {
        this.f37652r.setText("");
        this.f37653s.setVisibility(4);
        this.f37652r.setVisibility(4);
    }

    public void clearStrongNotify() {
        this.f37656v.setVisibility(4);
    }

    public void onBackPressed() {
        this.f37636a.pauseDetect();
    }

    public void onBackPressCanceled() {
        this.f37636a.resumeDetect();
    }

    /* renamed from: j */
    private void m28337j() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "CHECKSHOOTREQUIRE");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void onQuitConfirmed() {
        m28339k();
    }

    /* renamed from: k */
    private void m28339k() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "QUIT");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put("cardName", this.card.getCardName());
        hashMap.put("cardImgDesc", this.card.getCardImgDesc());
        int i = this.f37631O;
        int i2 = 6;
        if (i == 0) {
            i2 = 1;
        } else if (i == 1) {
            i2 = 2;
        } else if (i == 3) {
            i2 = 3;
        } else if (i == 4) {
            i2 = 4;
        } else if (i == 5) {
            i2 = 5;
        } else if (i != 6) {
            i2 = 0;
        }
        hashMap.put("code", Integer.valueOf(i2));
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo96472c() {
        this.f37636a.cleanup();
    }

    public void onPause() {
        if (this.f37631O == 1) {
            this.f37636a.pauseDetect();
            closeCamera();
        }
    }

    public void onResume() {
        if (this.f37631O == 1) {
            this.f37636a.resumeDetect();
            if (this.f37636a.openCamera()) {
                this.f37636a.startPreview();
            }
        }
        if (this.f37634R) {
            this.f37636a.torchOn();
        }
    }

    public void onDestroy() {
        mo96472c();
        this.f37636a.onDestroy();
        this.f37630G.release();
    }

    public void onLocalPicSelected(Uri uri) {
        m28329f();
        this.f37646l.setTargetView(this.f37649o);
    }
}
