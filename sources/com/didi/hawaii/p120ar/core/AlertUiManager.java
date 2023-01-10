package com.didi.hawaii.p120ar.core;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.hawaii.p120ar.jni.DARCNAVEDShowAlert;
import com.didi.hawaii.p120ar.utils.ARNavGlobal;
import com.didi.hawaii.p120ar.utils.BatteryUtil;
import com.didi.hawaii.p120ar.utils.SensorUtil;
import com.didi.hawaii.p120ar.view.AutoVerticalScrollTextView;
import com.didi.hawaii.p120ar.view.LocationView;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* renamed from: com.didi.hawaii.ar.core.AlertUiManager */
public class AlertUiManager extends BaseDelegate {
    public static final int BACKMSG = 10001;
    public static final int BATTERYLOWERMSG = 10003;
    public static final int ExcessiveMotionMSG = 10006;
    public static final int ExcessiveMotionMSGHIDE = 1008;
    public static final int HELPMSG = 10002;
    public static final int LOCATIONRUNNING = 2;
    public static final int LOCATONING = 0;
    public static final int LOCATONSUCCESS = 1;
    public static final int MOVEORSTABLEMSG = 10005;
    public static final int NAVIGATIONHINTDISSMISSMSG = 1012;
    public static final int NAVIGATIONPITCHMSG = 1011;
    public static final int NOSTATUS = -1;
    public static final int PitchAviableMSG = 10004;
    public static final int REACHDESTINATIONMSG = 1010;
    public static final int RECOVERYMSG = 10007;
    public static final int REFESHDELAYOFAUTOTEXT = 100001;
    public static final int REFESHMSG = 1013;
    public static final int REFESHMSGDelay = 1014;
    public static final int SAFETIPS = 1015;
    public static final int SDKALERTMSG = 1009;

    /* renamed from: b */
    private static final int f25233b = 0;

    /* renamed from: c */
    private static final int f25234c = 1;

    /* renamed from: d */
    private static final int f25235d = -2;
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f25236A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public DARCNAVEDShowAlert f25237B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public HandleButton f25238C = new HandleButton();

    /* renamed from: D */
    private boolean f25239D = true;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public Handler f25240E = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message != null) {
                int i = message.what;
                if (i != 100001) {
                    switch (i) {
                        case 1008:
                            if (AlertUiManager.this.f25256p != null) {
                                AlertUiManager.this.f25256p.setVisibility(8);
                            }
                            boolean unused = AlertUiManager.this.f25242G = false;
                            return;
                        case 1009:
                            ALertContent aLertContent = (ALertContent) message.obj;
                            if (AlertUiManager.this.f25262v != null && aLertContent.buttons.size() <= 2) {
                                AlertUiManager.this.m20206b();
                                AlertUiManager.this.f25262v.onALertFromSDK((ALertContent) message.obj, AlertUiManager.this.f25238C);
                                return;
                            }
                            return;
                        case 1010:
                            String str = (String) message.obj;
                            if (AlertUiManager.this.f25262v != null) {
                                AlertUiManager.this.m20206b();
                                AlertUiManager.this.f25262v.onALertReachDestination(str);
                                return;
                            }
                            return;
                        case 1011:
                            AlertUiManager.this.checkPitchAviableForNavigation(((Boolean) message.obj).booleanValue());
                            return;
                        case 1012:
                            if (AlertUiManager.this.f25245e == 2) {
                                AlertUiManager.this.f25254n.setVisibility(8);
                                AlertUiManager.this.f25252l.setVisibility(8);
                                boolean unused2 = AlertUiManager.this.f25241F = false;
                                AlertUiManager.this.m20213d();
                                return;
                            }
                            return;
                        case 1013:
                        case 1014:
                            int intValue = ((Integer) message.obj).intValue();
                            if (intValue == -1) {
                                AlertUiManager.this.refeshForNotStatus();
                                return;
                            } else if (intValue == 0) {
                                AlertUiManager.this.m20199a();
                                return;
                            } else if (intValue == 1) {
                                AlertUiManager.this.m20204a(false);
                                return;
                            } else if (intValue == 2) {
                                AlertUiManager.this.m20207b(false);
                                return;
                            } else {
                                return;
                            }
                        case 1015:
                            if (AlertUiManager.this.f25245e == 2) {
                                AlertUiManager.this.f25253m.setVisibility(8);
                                return;
                            }
                            return;
                        default:
                            switch (i) {
                                case 10001:
                                    AlertUiManager.this.m20206b();
                                    if (AlertUiManager.this.f25262v != null) {
                                        AlertUiManager.this.f25262v.onFinishBtnClick();
                                        return;
                                    }
                                    return;
                                case 10002:
                                    AlertUiManager.this.m20206b();
                                    if (AlertUiManager.this.f25262v != null) {
                                        AlertUiManager.this.f25262v.onHelpBtnClick();
                                        return;
                                    }
                                    return;
                                case 10003:
                                    AlertUiManager.this.m20206b();
                                    if (AlertUiManager.this.f25262v != null) {
                                        AlertUiManager.this.f25262v.onBatteryStateLower();
                                        return;
                                    }
                                    return;
                                case 10004:
                                    AlertUiManager.this.checkPitchAviable(((Boolean) message.obj).booleanValue());
                                    return;
                                case 10005:
                                    AlertUiManager.this.checkMoveOrNot(((Boolean) message.obj).booleanValue());
                                    return;
                                case 10006:
                                    AlertUiManager.this.m20212c(((Boolean) message.obj).booleanValue());
                                    return;
                                case 10007:
                                    boolean unused3 = AlertUiManager.this.f25266z = false;
                                    int c = AlertUiManager.this.f25245e;
                                    if (c == -1) {
                                        AlertUiManager.this.refeshForNotStatus();
                                        return;
                                    } else if (c == 0) {
                                        AlertUiManager.this.m20199a();
                                        return;
                                    } else if (c == 2) {
                                        AlertUiManager.this.m20207b(true);
                                        return;
                                    } else {
                                        return;
                                    }
                                default:
                                    return;
                            }
                    }
                } else if (AlertUiManager.this.f25245e == 0) {
                    if (!AlertUiManager.this.f25266z && AlertUiManager.this.f25264x) {
                        AlertUiManager.this.f25249i.setVisibility(0);
                        AlertUiManager.this.f25250j.setVisibility(0);
                    }
                    boolean unused4 = AlertUiManager.this.f25243H = true;
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: F */
    public boolean f25241F = true;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public volatile boolean f25242G = false;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public boolean f25243H = false;

    /* renamed from: a */
    int f25244a = -2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f25245e = -1;

    /* renamed from: f */
    private Context f25246f = null;

    /* renamed from: g */
    private ViewGroup f25247g = null;

    /* renamed from: h */
    private LocationView f25248h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public RelativeLayout f25249i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AutoVerticalScrollTextView f25250j;

    /* renamed from: k */
    private LinearLayout f25251k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LinearLayout f25252l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public RelativeLayout f25253m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public TextView f25254n;

    /* renamed from: o */
    private TextView f25255o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public TextView f25256p;

    /* renamed from: q */
    private TextView f25257q;

    /* renamed from: r */
    private TextView f25258r;

    /* renamed from: s */
    private Button f25259s;

    /* renamed from: t */
    private Button f25260t;

    /* renamed from: u */
    private View f25261u = null;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public UIListener f25262v;

    /* renamed from: w */
    private ImageView f25263w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public volatile boolean f25264x = true;

    /* renamed from: y */
    private volatile boolean f25265y = true;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f25266z = true;

    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$ALertContent */
    public static class ALertContent {
        public HashMap<String, String> buttons = new HashMap<>();
        public String msg;
        public String title;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$MsgType */
    public @interface MsgType {
    }

    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$UIListener */
    public interface UIListener {
        void onALertFromSDK(ALertContent aLertContent, HandleButton handleButton);

        void onALertReachDestination(String str);

        void onBatteryStateLower();

        void onFinishBtnClick();

        void onHelpBtnClick();

        void onLocationSuccess();

        void onLocationing();
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$locationSpeed */
    public @interface locationSpeed {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$status */
    public @interface C9617status {
    }

    public AlertUiManager(Context context, ViewGroup viewGroup, DiAREngine diAREngine) {
        attachEngine(diAREngine);
        this.f25246f = context;
        this.f25247g = viewGroup;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hawaii_ar, (ViewGroup) null);
        this.f25261u = inflate;
        this.f25248h = (LocationView) inflate.findViewById(R.id.location);
        this.f25249i = (RelativeLayout) this.f25261u.findViewById(R.id.location_tip);
        this.f25250j = (AutoVerticalScrollTextView) this.f25261u.findViewById(R.id.auto_text);
        this.f25254n = (TextView) this.f25261u.findViewById(R.id.alert);
        this.f25257q = (TextView) this.f25261u.findViewById(R.id.alert_sucloc);
        this.f25259s = (Button) this.f25261u.findViewById(R.id.back_btn);
        this.f25260t = (Button) this.f25261u.findViewById(R.id.question_btn);
        this.f25263w = (ImageView) this.f25261u.findViewById(R.id.pitch);
        this.f25255o = (TextView) this.f25261u.findViewById(R.id.pitch_hint);
        this.f25256p = (TextView) this.f25261u.findViewById(R.id.hint_move);
        this.f25251k = (LinearLayout) this.f25261u.findViewById(R.id.mask);
        this.f25250j.setDataList(ARNavGlobal.list);
        this.f25252l = (LinearLayout) this.f25261u.findViewById(R.id.top_nav);
        this.f25253m = (RelativeLayout) this.f25261u.findViewById(R.id.safe_alert);
        this.f25258r = (TextView) this.f25261u.findViewById(R.id.nav_content);
        m20210c();
        this.f25259s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = AlertUiManager.this.f25240E.obtainMessage();
                obtainMessage.what = 10001;
                AlertUiManager.this.f25240E.sendMessage(obtainMessage);
            }
        });
        this.f25260t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Message obtainMessage = AlertUiManager.this.f25240E.obtainMessage();
                obtainMessage.what = 10002;
                AlertUiManager.this.f25240E.sendMessage(obtainMessage);
            }
        });
        SensorUtil.getInstance().setPostureChangeListener(new SensorUtil.PostureChangeListener() {
            public void onPitchAviableChange(boolean z) {
                Message obtainMessage = AlertUiManager.this.f25240E.obtainMessage();
                obtainMessage.what = 10004;
                obtainMessage.obj = Boolean.valueOf(z);
                AlertUiManager.this.f25240E.sendMessage(obtainMessage);
            }

            public void onStableOrMoveHanppen(boolean z) {
                Message obtainMessage = AlertUiManager.this.f25240E.obtainMessage();
                obtainMessage.what = 10005;
                obtainMessage.obj = Boolean.valueOf(z);
                AlertUiManager.this.f25240E.sendMessage(obtainMessage);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20199a() {
        this.f25245e = 0;
        if (!this.f25266z) {
            UIListener uIListener = this.f25262v;
            if (uIListener != null) {
                uIListener.onLocationing();
            }
            if (this.f25261u == null) {
                return;
            }
            if (this.f25264x) {
                this.f25255o.setVisibility(8);
                this.f25263w.setVisibility(8);
                this.f25257q.setVisibility(8);
                this.f25248h.setVisibility(0);
                if (this.f25243H) {
                    this.f25249i.setVisibility(0);
                    this.f25250j.setVisibility(0);
                }
                this.f25256p.setVisibility(8);
                this.f25254n.setText(R.string.locationing);
                this.f25251k.setVisibility(8);
                this.f25252l.setVisibility(8);
                this.f25254n.setVisibility(0);
                this.f25253m.setVisibility(8);
                this.f25248h.startScan();
                return;
            }
            this.f25251k.setVisibility(0);
            this.f25255o.setVisibility(0);
            this.f25263w.setVisibility(0);
            this.f25257q.setVisibility(8);
            this.f25252l.setVisibility(8);
            this.f25248h.setVisibility(8);
            this.f25249i.setVisibility(8);
            this.f25250j.setVisibility(8);
            this.f25256p.setVisibility(8);
            this.f25253m.setVisibility(8);
            this.f25254n.setText(R.string.locationing);
            this.f25254n.setVisibility(8);
            this.f25248h.stopScan();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20204a(boolean z) {
        this.f25245e = 1;
        if (this.f25261u != null) {
            UIListener uIListener = this.f25262v;
            if (uIListener != null) {
                uIListener.onLocationSuccess();
            }
            this.f25255o.setVisibility(8);
            this.f25263w.setVisibility(8);
            this.f25252l.setVisibility(8);
            this.f25251k.setVisibility(8);
            this.f25257q.setVisibility(8);
            this.f25256p.setVisibility(8);
            this.f25254n.setVisibility(8);
            this.f25253m.setVisibility(8);
            this.f25250j.setVisibility(8);
            this.f25249i.setVisibility(8);
            this.f25248h.stopScan();
            this.f25248h.setVisibility(0);
            this.f25248h.exeDisAppearAnimator();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20207b(boolean z) {
        this.f25245e = 2;
        if (!this.f25266z && this.f25261u != null) {
            this.f25248h.stopScan();
            this.f25255o.setVisibility(8);
            this.f25263w.setVisibility(8);
            this.f25251k.setVisibility(8);
            this.f25257q.setVisibility(8);
            this.f25248h.setVisibility(8);
            this.f25249i.setVisibility(8);
            this.f25250j.setVisibility(8);
            this.f25256p.setVisibility(8);
            if (!z) {
                this.f25254n.setText(ThemeManager.getInstance().getThemeResId(R.string.locationSuccess));
                this.f25254n.setVisibility(0);
                this.f25252l.setVisibility(0);
                this.f25253m.setVisibility(8);
                this.f25258r.setText(ARNavGlobal.destSpotName);
                this.f25241F = true;
            } else if (!this.f25241F) {
                this.f25254n.setText(ThemeManager.getInstance().getThemeResId(R.string.locationSuccess));
                this.f25254n.setVisibility(8);
                this.f25252l.setVisibility(8);
                if (!this.f25265y) {
                    this.f25257q.setVisibility(0);
                }
            } else {
                this.f25254n.setText(ThemeManager.getInstance().getThemeResId(R.string.locationSuccess));
                this.f25254n.setVisibility(0);
                this.f25252l.setVisibility(0);
                this.f25258r.setText(ARNavGlobal.destSpotName);
            }
        }
    }

    public void refeshForNotStatus() {
        this.f25245e = -1;
        if (!this.f25266z && this.f25261u != null) {
            this.f25248h.stopScan();
            this.f25255o.setVisibility(8);
            this.f25263w.setVisibility(8);
            this.f25251k.setVisibility(8);
            this.f25248h.setVisibility(8);
            this.f25249i.setVisibility(8);
            this.f25250j.setVisibility(8);
            this.f25257q.setVisibility(8);
            this.f25254n.setVisibility(8);
            this.f25256p.setVisibility(8);
            this.f25252l.setVisibility(8);
            this.f25253m.setVisibility(8);
        }
    }

    public void checkPitchAviable(boolean z) {
        if (this.f25266z || this.f25245e != 0) {
            return;
        }
        if (!z) {
            if (this.f25264x) {
                this.f25264x = false;
                if (this.f25261u != null) {
                    this.f25248h.stopScan();
                    this.f25248h.setVisibility(8);
                    this.f25249i.setVisibility(8);
                    this.f25250j.setVisibility(8);
                    this.f25254n.setVisibility(8);
                    this.f25257q.setVisibility(8);
                    this.f25263w.setVisibility(0);
                    this.f25255o.setVisibility(0);
                    this.f25251k.setVisibility(0);
                    this.f25256p.setVisibility(8);
                    this.f25252l.setVisibility(8);
                }
            }
        } else if (!this.f25264x) {
            this.f25264x = true;
            m20199a();
        }
    }

    public void checkPitchAviableForNavigation(boolean z) {
        if (!this.f25266z && !this.f25241F && this.f25245e == 2) {
            if (!z) {
                if (this.f25265y) {
                    this.f25265y = false;
                    if (this.f25261u != null) {
                        this.f25248h.stopScan();
                        this.f25248h.setVisibility(8);
                        this.f25249i.setVisibility(8);
                        this.f25250j.setVisibility(8);
                        this.f25263w.setVisibility(8);
                        this.f25255o.setVisibility(8);
                        this.f25251k.setVisibility(8);
                        this.f25256p.setVisibility(8);
                        this.f25252l.setVisibility(8);
                        this.f25254n.setVisibility(8);
                        this.f25257q.setVisibility(0);
                        if (this.f25239D) {
                            m20216d(false);
                            this.f25239D = false;
                        }
                    }
                }
            } else if (!this.f25265y) {
                this.f25265y = true;
                if (!this.f25239D) {
                    m20216d(true);
                    this.f25239D = true;
                }
                m20207b(true);
            }
        }
    }

    public void checkMoveOrNot(boolean z) {
        if (!this.f25266z && this.f25264x && this.f25245e == 0 && !this.f25242G) {
            if (!z) {
                this.f25244a = 0;
                if (this.f25261u != null) {
                    this.f25256p.setText(R.string.move_phone);
                    this.f25256p.setVisibility(0);
                    return;
                }
                return;
            }
            this.f25244a = -2;
            this.f25256p.setVisibility(8);
        }
    }

    public int getCurARStatus() {
        return this.f25245e;
    }

    public void hintForExcessiveMotion(boolean z) {
        Message obtainMessage = this.f25240E.obtainMessage();
        obtainMessage.what = 10006;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f25240E.sendMessage(obtainMessage);
    }

    public void checkPitchForNavigation(boolean z) {
        Message obtainMessage = this.f25240E.obtainMessage();
        obtainMessage.what = 1011;
        obtainMessage.obj = Boolean.valueOf(z);
        this.f25240E.sendMessage(obtainMessage);
    }

    public void dissMissHintForNavigation(boolean z) {
        if (z) {
            Message obtainMessage = this.f25240E.obtainMessage();
            obtainMessage.what = 1012;
            this.f25240E.sendMessage(obtainMessage);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20212c(boolean z) {
        if (!this.f25266z && this.f25264x && this.f25245e == 0 && z) {
            this.f25244a = 1;
            if (this.f25261u != null) {
                this.f25256p.setText(R.string.jiansu);
                this.f25256p.setVisibility(0);
                this.f25242G = true;
            }
            this.f25240E.removeMessages(1008);
            Message obtainMessage = this.f25240E.obtainMessage();
            obtainMessage.what = 1008;
            this.f25240E.sendMessageDelayed(obtainMessage, 1000);
        }
    }

    public void recoveryUI() {
        Message obtainMessage = this.f25240E.obtainMessage();
        obtainMessage.what = 10007;
        this.f25240E.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20206b() {
        this.f25266z = true;
        if (this.f25245e != 1 && this.f25261u != null) {
            this.f25248h.stopScan();
            this.f25255o.setVisibility(8);
            this.f25263w.setVisibility(8);
            this.f25251k.setVisibility(8);
            this.f25248h.setVisibility(8);
            this.f25254n.setVisibility(8);
            this.f25256p.setVisibility(8);
            this.f25252l.setVisibility(8);
            this.f25249i.setVisibility(8);
            this.f25250j.setVisibility(8);
        }
    }

    public void start() {
        startCheckMoveOrNot();
        startBatteryCheck();
    }

    public void startCheckMoveOrNot() {
        SensorUtil.getInstance().startMoveStatusCheck();
    }

    public void startBatteryCheck() {
        BatteryUtil.startListenBatteryState(new BatteryUtil.BatteryChangeListener() {
            public void onBatteryChange(float f) {
                if (!AlertUiManager.this.f25236A && f < ((float) ARNavGlobal.BATTERY_MOSTLOW_STATE)) {
                    Message obtainMessage = AlertUiManager.this.f25240E.obtainMessage();
                    obtainMessage.what = 10003;
                    AlertUiManager.this.f25240E.sendMessage(obtainMessage);
                    boolean unused = AlertUiManager.this.f25236A = true;
                }
            }
        });
    }

    public void onALertFromSDK(DARCNAVEDShowAlert dARCNAVEDShowAlert, String str, String str2, HashMap<String, String> hashMap) {
        this.f25237B = dARCNAVEDShowAlert;
        Message obtainMessage = this.f25240E.obtainMessage();
        obtainMessage.what = 1009;
        ALertContent aLertContent = new ALertContent();
        aLertContent.title = str;
        aLertContent.msg = str2;
        aLertContent.buttons = hashMap;
        obtainMessage.obj = aLertContent;
        this.f25240E.sendMessage(obtainMessage);
    }

    public void alertReachDestination(String str) {
        Message obtainMessage = this.f25240E.obtainMessage();
        obtainMessage.what = 1010;
        obtainMessage.obj = str;
        this.f25240E.sendMessage(obtainMessage);
    }

    public void setUIListener(UIListener uIListener) {
        this.f25262v = uIListener;
    }

    /* renamed from: c */
    private void m20210c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f25247g.indexOfChild(this.f25261u) < 0) {
            this.f25247g.addView(this.f25261u, layoutParams);
        } else {
            this.f25247g.updateViewLayout(this.f25261u, layoutParams);
        }
    }

    public void release() {
        this.f25240E.removeCallbacksAndMessages((Object) null);
        BatteryUtil.stopListenBatteryState();
        this.f25262v = null;
    }

    public void exitOfOrderCancell() {
        m20206b();
        this.f25262v = null;
    }

    public void hideARNavUI() {
        m20206b();
    }

    /* renamed from: d */
    private void m20216d(boolean z) {
        if (this.mAREngine != null) {
            this.mAREngine.setCorrectNodeVisible(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20203a(DARCNAVEDShowAlert dARCNAVEDShowAlert, int i) {
        if (this.mAREngine != null) {
            this.mAREngine.eventShowAlertReply(dARCNAVEDShowAlert, i);
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.AlertUiManager$HandleButton */
    public class HandleButton {
        public HandleButton() {
        }

        public void handleClick(int i) {
            if (AlertUiManager.this.f25237B != null) {
                AlertUiManager alertUiManager = AlertUiManager.this;
                alertUiManager.m20203a(alertUiManager.f25237B, i);
            }
        }
    }

    public void refeshStatus(int i) {
        this.f25240E.removeMessages(100001);
        this.f25243H = false;
        this.f25240E.removeMessages(1015);
        this.f25240E.removeMessages(1014);
        Message obtainMessage = this.f25240E.obtainMessage();
        obtainMessage.what = 1013;
        obtainMessage.obj = Integer.valueOf(i);
        if (i == 0) {
            Message obtainMessage2 = this.f25240E.obtainMessage();
            obtainMessage2.what = 100001;
            this.f25240E.sendMessageDelayed(obtainMessage2, 5000);
        }
        if (i == 2) {
            obtainMessage.what = 1014;
            this.f25240E.sendMessageDelayed(obtainMessage, 2400);
            return;
        }
        this.f25240E.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m20213d() {
        this.f25253m.setVisibility(0);
        Message obtainMessage = this.f25240E.obtainMessage();
        obtainMessage.what = 1015;
        this.f25240E.sendMessageDelayed(obtainMessage, 5000);
    }
}
