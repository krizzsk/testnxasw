package com.didi.hawaii.p120ar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.hawaii.p120ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p120ar.core.DiARNavController;
import com.didi.hawaii.p120ar.utils.ARRequestUtil;
import com.didi.hawaii.p120ar.utils.ARSharePref;
import com.didi.hawaii.p120ar.utils.BatteryUtil;
import com.didi.hawaii.p120ar.utils.LocationUtil;
import com.didi.hawaii.p120ar.utils.NetStateUtil;
import com.didi.hawaii.p120ar.utils.SensorUtil;
import com.didi.hawaii.p120ar.view.ARGlView;
import com.didi.sdk.util.SystemUtil;

/* renamed from: com.didi.hawaii.ar.DiARNavView */
public class DiARNavView extends FrameLayout {

    /* renamed from: a */
    private ARGlView f25229a;

    /* renamed from: b */
    private Context f25230b;

    public void onRestart() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public DiARNavView(Context context) throws CreateDiARNavViewException {
        super(context);
        this.f25229a = null;
        this.f25230b = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo73366a(context);
        }
    }

    public DiARNavView(Context context, AttributeSet attributeSet) throws CreateDiARNavViewException {
        this(context, attributeSet, 0);
    }

    public DiARNavView(Context context, AttributeSet attributeSet, int i) throws CreateDiARNavViewException {
        super(context, attributeSet, i);
        this.f25229a = null;
        this.f25230b = null;
        setClickable(true);
        if (!isInEditMode()) {
            mo73366a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo73366a(Context context) throws CreateDiARNavViewException {
        ARSharePref.init(context);
        SystemUtil.init(context);
        NetStateUtil.init(context);
        ARRequestUtil.init(context);
        BatteryUtil.init(context);
        SensorUtil.getInstance().init(context);
        LocationUtil.startGetLocation(context);
        SensorUtil.getInstance().startListenRotationVector();
        this.f25230b = context;
        this.f25229a = new ARGlView(context, (ViewGroup) this);
        addView(this.f25229a, 0, new FrameLayout.LayoutParams(-1, -1));
    }

    public DiDiAR getDiAR() {
        return new DiDiAR(this, this.f25230b);
    }

    public void onResume() {
        this.f25229a.onResume();
    }

    public void onPause() {
        this.f25229a.onPause();
    }

    public void onDestroy() {
        removeAllViews();
        this.f25229a.onDestroy();
        LocationUtil.stopGetLocation(this.f25230b);
        SensorUtil.getInstance().stopListenRotationVector();
    }

    public DiARNavController getDiARController() {
        return this.f25229a.getDiARController();
    }
}
