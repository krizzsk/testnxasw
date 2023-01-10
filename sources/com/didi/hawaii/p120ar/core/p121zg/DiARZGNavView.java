package com.didi.hawaii.p120ar.core.p121zg;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.didi.hawaii.p120ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p120ar.utils.ARSharePref;
import com.didi.hawaii.p120ar.utils.LocationUtil;
import com.didi.hawaii.p120ar.utils.SensorUtil;

/* renamed from: com.didi.hawaii.ar.core.zg.DiARZGNavView */
public class DiARZGNavView extends FrameLayout {

    /* renamed from: a */
    DiARZGNavController f25397a;

    /* renamed from: b */
    private CameraSurfaceView f25398b;

    /* renamed from: c */
    private Context f25399c;

    public DiARZGNavView(Context context) throws CreateDiARNavViewException {
        super(context);
        this.f25398b = null;
        this.f25397a = null;
        this.f25399c = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo73552a(context);
        }
    }

    public DiARZGNavView(Context context, AttributeSet attributeSet) throws CreateDiARNavViewException {
        this(context, attributeSet, 0);
    }

    public DiARZGNavView(Context context, AttributeSet attributeSet, int i) throws CreateDiARNavViewException {
        super(context, attributeSet, i);
        this.f25398b = null;
        this.f25397a = null;
        this.f25399c = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo73552a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo73552a(Context context) throws CreateDiARNavViewException {
        this.f25399c = context;
        ARSharePref.init(context);
        this.f25397a = new DiARZGNavController(context, this);
        LocationUtil.startGetLocation(context);
        LocationUtil.setNotifyLocationListener(this.f25397a);
        SensorUtil.getInstance().init(this.f25399c);
        initCameraView(this.f25399c);
    }

    public void initCameraView(Context context) {
        if (this.f25398b == null) {
            this.f25398b = new CameraSurfaceView(context);
            addView(this.f25398b, 0, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public void openCamera() {
        CameraSurfaceView cameraSurfaceView = this.f25398b;
        if (cameraSurfaceView != null) {
            cameraSurfaceView.openCamera();
        }
    }

    public void setUiManagerListener(ZGUIListener zGUIListener) {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.setUiManagerListener(zGUIListener);
        }
    }

    public void onDriverArrived(String str) {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.onDriverArrived(str);
        }
    }

    public void activeZGNav() {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.activeZGNav();
        }
    }

    public void onRestart() {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.onRestart();
        }
    }

    public void onResume() {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.onResume();
        }
        SensorUtil.getInstance().startZGSensor(this.f25397a);
    }

    public void onStart() {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.onStart();
        }
    }

    public void onStop() {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.onStop();
        }
    }

    public void onPause() {
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.onPause();
        }
        SensorUtil.getInstance().stopZGSensor();
    }

    public void onDestroy() {
        removeAllViews();
        LocationUtil.setNotifyLocationListener((LocationUtil.NotifyLocationListener) null);
        LocationUtil.stopGetLocation(this.f25399c);
        DiARZGNavController diARZGNavController = this.f25397a;
        if (diARZGNavController != null) {
            diARZGNavController.onDestroy();
            this.f25397a = null;
        }
        if (this.f25398b != null) {
            this.f25398b = null;
        }
        CameraSurfaceView cameraSurfaceView = this.f25398b;
        if (cameraSurfaceView != null) {
            cameraSurfaceView.onDestroy();
        }
    }
}
