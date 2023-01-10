package com.didi.hawaii.p120ar.core.p121zg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DLog;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.flutter.nacho2.p116v2.NachoLifecycleManager;
import com.didi.hawaii.p120ar.DiARNavActivity;
import com.didi.hawaii.p120ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p120ar.utils.ARCoreCheckerAndGenerator;
import com.didi.hawaii.p120ar.utils.ARNavGlobal;
import com.didi.hawaii.p120ar.utils.AROmega;
import com.didi.hawaii.p120ar.utils.PermissionHelper;
import com.didi.hawaii.p120ar.view.AlertDialog;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGNavActivity */
public class DiARZGNavActivity extends AppCompatActivity implements ZGUIListener {

    /* renamed from: a */
    private static long f25362a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static DiARZGNavActivity f25363b = null;

    /* renamed from: c */
    private static boolean f25364c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Handler f25365d = new Handler(Looper.getMainLooper());
    public static DiARNavActivity.NotifyStatusSubscriber subscriber = new DiARNavActivity.NotifyStatusSubscriber() {
        public void onStatusChange(final int i) {
            DiARZGNavActivity.f25365d.post(new Runnable() {
                public void run() {
                    if (DiARZGNavActivity.f25363b != null) {
                        DLog.m10773d("ZGNotifySubscriber", "type:" + i, new Object[0]);
                        String string = DiARZGNavActivity.f25363b.getString(R.string.driver_exception);
                        int i = i;
                        if (i == 1) {
                            string = DiARZGNavActivity.f25363b.getString(R.string.GRider_guide_Trips_have_XmYI);
                        } else if (i == 2) {
                            string = DiARZGNavActivity.f25363b.getString(R.string.GRider_guide_The_driver_Xheq);
                        }
                        DiARZGNavActivity.f25363b.onOrderStateChange(string);
                    }
                }
            });
        }

        public void onDriverArrived(final String str) {
            DiARZGNavActivity.f25365d.post(new Runnable() {
                public void run() {
                    DLog.m10773d("onDriverArrived", "msg:" + str, new Object[0]);
                    if (DiARZGNavActivity.f25363b != null) {
                        DiARZGNavActivity.f25363b.onDriverArrived(str);
                    }
                }
            });
        }
    };

    /* renamed from: e */
    private AlertDialog f25366e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DiARZGNavView f25367f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f25368g = false;

    /* renamed from: h */
    private boolean f25369h = false;

    /* renamed from: i */
    private boolean f25370i = false;

    public static boolean isStartedActivity() {
        return f25364c;
    }

    public static DiARNavActivity.NotifyStatusSubscriber startDiARZGNavActivity(Context context) {
        if (context == null) {
            return null;
        }
        if (f25364c) {
            DLog.m10773d("AR-ZG", "ZGARNavStarted:" + f25364c + " actvitiy:" + f25363b, new Object[0]);
            return subscriber;
        }
        Intent intent = new Intent(context, DiARZGNavActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
        f25364c = true;
        f25362a = System.currentTimeMillis();
        DLog.m10773d("AR-ZG", "startZGARActivity", new Object[0]);
        return subscriber;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        SystemUtils.log(4, "zgdebug", NachoLifecycleManager.LIFECYCLE_ON_CREATE, (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 123);
        super.onCreate(bundle);
        m20275d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        SystemUtils.log(4, "zgdebug", "onResume", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 132);
        super.onResume();
        if (!this.f25368g && !this.f25370i && !PermissionHelper.hasCameraPermission(this)) {
            PermissionHelper.requestCameraPermission(this);
        } else if (!PermissionHelper.hasStoragePerssion(this) && PermissionHelper.requestStoragePermissions(this)) {
        } else {
            if (PermissionHelper.hasLocationPerssion(this) || !PermissionHelper.requestLocationPermissions(this)) {
                if (PermissionHelper.hasCameraPermission(this)) {
                    DiARZGNavView diARZGNavView = this.f25367f;
                    if (diARZGNavView != null) {
                        diARZGNavView.openCamera();
                    }
                    if (this.f25369h) {
                        DiARZGNavView diARZGNavView2 = this.f25367f;
                        if (diARZGNavView2 != null) {
                            diARZGNavView2.activeZGNav();
                        }
                    } else {
                        alertSafeDialog(ARNavGlobal.zgAlertMessage);
                    }
                }
                DiARZGNavView diARZGNavView3 = this.f25367f;
                if (diARZGNavView3 != null) {
                    diARZGNavView3.onResume();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        SystemUtils.log(4, "zgdebug", "onPause", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 172);
        super.onPause();
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        SystemUtils.log(4, "zgdebug", "onStart", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 184);
        super.onStart();
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.onStart();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        SystemUtils.log(4, "zgdebug", "onRestart", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 196);
        super.onRestart();
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.onRestart();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        SystemUtils.log(4, "zgdebug", "onStop", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 208);
        super.onStop();
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        DLog.m10773d("AR-ZG", "onDestroy zgActivityStarted:" + f25364c, new Object[0]);
        SystemUtils.log(4, "zgdebug", NachoLifecycleManager.LIFECYCLE_ON_DESTROY, (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 222);
        super.onDestroy();
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.onDestroy();
            this.f25367f = null;
        }
        AlertDialog alertDialog = this.f25366e;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f25366e.dismiss();
            DLog.m10773d("AR-ZG", "onDestroy dismiss Dialog", new Object[0]);
        }
        f25364c = false;
        f25363b = null;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 0 && !PermissionHelper.hasCameraPermission(this)) {
            AROmega.zgMapARNavDirectAuthorizeCam();
            if (!this.f25368g && !this.f25370i) {
                m20276e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        SystemUtils.log(4, "zgdebug", "onRestoreInstanceState", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 254);
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        SystemUtils.log(4, "zgdebug", "onSaveInstanceState", (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 261);
    }

    public void finish() {
        DLog.m10773d("AR-ZG", "finish zgActivityStarted:" + f25364c, new Object[0]);
        SystemUtils.log(4, "zgdebug", XPanelScene.SCENE_FINISH, (Throwable) null, "com.didi.hawaii.ar.core.zg.DiARZGNavActivity", 269);
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.onPause();
        }
        AROmega.zgMapARNavDirectUseSeconds(((float) (System.currentTimeMillis() - f25362a)) / 1000.0f);
        ARCoreCheckerAndGenerator.clearCache();
        ZGThemeManager.getInstance().reset();
        super.finish();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m20274c();
    }

    /* renamed from: c */
    private void m20274c() {
        getWindow().getDecorView().setSystemUiVisibility(4866);
        getWindow().addFlags(128);
    }

    /* renamed from: d */
    private void m20275d() {
        try {
            ARNavGlobal.init(this);
            AROmega.setMapVendor(this);
            m20274c();
            this.f25366e = new AlertDialog(this);
            DiARZGNavView diARZGNavView = new DiARZGNavView(this);
            this.f25367f = diARZGNavView;
            setContentView((View) diARZGNavView);
            this.f25367f.setUiManagerListener(this);
            ZGThemeManager.getInstance().init(this, ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption() != null ? ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getScene() : 0);
            f25363b = this;
            f25364c = true;
            DLog.m10773d("AR-ZG", "initZG", new Object[0]);
        } catch (CreateDiARNavViewException unused) {
            DLog.m10773d("AR-ZG", "initZG CreateDiARNavViewException", new Object[0]);
            finish();
        }
    }

    /* renamed from: e */
    private void m20276e() {
        this.f25366e.builder(1).setMsg(getString(R.string.GRider_guide_Open_camera_dUdA)).setNegativeButton(getString(R.string.GRider_guide_Not_set_fOSr), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARZGNavActivity.this.finish();
            }
        }).setPositiveButton(getString(R.string.GRider_guide_Go_Settings_yMQQ), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean unused = DiARZGNavActivity.this.f25368g = false;
                PermissionHelper.launchPermissionSettings(DiARZGNavActivity.this);
            }
        }).setCancelable(false);
        this.f25366e.show();
        this.f25368g = true;
    }

    public void alertSafeDialog(String str) {
        if (TextUtils.isEmpty(str)) {
            AROmega.zgMapARNavResDataError();
        }
        this.f25366e.builder(2).setTitle(getString(R.string.GRider_guide_Safety_Tips_Zwle)).setMsg(str).setPositiveButton(getString(R.string.GRider_guide_I_see_YCKe), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (DiARZGNavActivity.this.f25367f != null) {
                    DiARZGNavActivity.this.f25367f.activeZGNav();
                }
            }
        }).setCancelable(false).show();
        this.f25369h = true;
        AROmega.zgMapARNavDirectWarning();
    }

    /* renamed from: f */
    private void m20277f() {
        this.f25370i = true;
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.setUiManagerListener((ZGUIListener) null);
        }
    }

    public void onOrderStateChange(String str) {
        this.f25366e.builder(1).setMsg(str).setPositiveButton(getString(R.string.GRider_guide_Exit_Navigation_xQcr), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARZGNavActivity.this.finish();
            }
        }).setCancelable(false).show();
        m20277f();
    }

    public void onDriverArrived(String str) {
        DiARZGNavView diARZGNavView = this.f25367f;
        if (diARZGNavView != null) {
            diARZGNavView.onDriverArrived(str);
        }
    }

    public void onBackPressed() {
        onFinishBtnClick();
    }

    public void onFinishBtnClick() {
        this.f25366e.builder(1).setMsg(getString(R.string.GRider_guide_Are_you_BPIy)).setNegativeButton(getString(R.string.GRider_guide_Cancel_XIbT), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        }).setPositiveButton(getString(R.string.GRider_guide_Determination_KSWw), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AROmega.zgMapARNavDirectBack();
                DiARZGNavActivity.this.finish();
            }
        }).setCancelable(false);
        this.f25366e.show();
    }

    public void onHelpBtnClick() {
        this.f25366e.builder(3).setTitle(getString(R.string.use_introduct)).setMsg(ARNavGlobal.zgHelpText).setPositiveButton(getString(R.string.GRider_guide_Got_it_XtfI), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        }).setCancelable(true).show();
    }

    public void onReachDestination() {
        this.f25366e.builder(1).setCancelable(false).setMsg(ZGThemeManager.getInstance().getThemeString(R.string.GRider_guide_Arrive_near_eIRX)).setPositiveButton(getString(R.string.GRider_guide_Exit_Navigation_xQcr), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiARZGNavActivity.this.finish();
            }
        });
        this.f25366e.show();
        m20277f();
    }
}
