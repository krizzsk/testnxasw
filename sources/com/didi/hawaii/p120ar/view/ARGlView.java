package com.didi.hawaii.p120ar.view;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.didi.hawaii.p120ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p120ar.core.DiARNavController;
import com.didi.hawaii.p120ar.jni.AREngineJNI;
import com.didi.hawaii.p120ar.jni.DARCNAVCreateData;
import com.didi.hawaii.p120ar.utils.ARAPollo;
import com.didi.hawaii.p120ar.utils.ARCoreCheckerAndGenerator;
import com.didi.hawaii.p120ar.utils.NetStateUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.didi.hawaii.ar.view.ARGlView */
public class ARGlView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: b */
    private static final int f25612b = ARAPollo.getARNavVersion();

    /* renamed from: c */
    private static final boolean f25613c = ARAPollo.isUseOldBoard();

    /* renamed from: d */
    private static final boolean f25614d = ARAPollo.getUsePDR();

    /* renamed from: e */
    private static final boolean f25615e = ARAPollo.getUsePDRShadow();

    /* renamed from: f */
    private static final boolean f25616f = ARAPollo.getUsePDRFusion();

    /* renamed from: g */
    private static final int f25617g = ARAPollo.getUsePDRTotalDuration();

    /* renamed from: h */
    private static final int f25618h = ARAPollo.getUsePDRCoreDuration();

    /* renamed from: i */
    private static final int f25619i = ARAPollo.getUsePDRInterLocInterval();

    /* renamed from: j */
    private static final int f25620j = ARAPollo.getUsePDRInterLocDistance();

    /* renamed from: k */
    private static final boolean f25621k = ARAPollo.getUsePDRLevelDetection();

    /* renamed from: l */
    private static final boolean f25622l = ARAPollo.getUseARDriftDetectionInInit();

    /* renamed from: m */
    private static final int f25623m = ARAPollo.getARDriftDetectionSpeedInInit();

    /* renamed from: n */
    private static final boolean f25624n = ARAPollo.getUseARDriftDetectionInNavi();

    /* renamed from: o */
    private static final int f25625o = ARAPollo.getARDriftDetectionSpeedInNavi();

    /* renamed from: a */
    private DiARNavController f25626a;

    /* renamed from: p */
    private DARCNAVCreateData f25627p;

    /* renamed from: q */
    private int f25628q;

    /* renamed from: r */
    private int f25629r;

    /* renamed from: com.didi.hawaii.ar.view.ARGlView$LifeCycleCallback */
    public interface LifeCycleCallback {
        void onHostCreated();

        void onHostDestroy();

        void onHostDetached();

        void onHostPause();

        void onHostResume();

        void onHostSizeChanged(int i, int i2);
    }

    public ARGlView(Context context, ViewGroup viewGroup) throws CreateDiARNavViewException {
        super(context);
        this.f25626a = null;
        this.f25628q = 0;
        this.f25629r = 0;
        mo74348a();
        mo74349a(context, viewGroup);
    }

    public ARGlView(Context context, AttributeSet attributeSet) throws CreateDiARNavViewException {
        this(context, attributeSet, 0);
    }

    public ARGlView(Context context, AttributeSet attributeSet, int i) throws CreateDiARNavViewException {
        super(context);
        this.f25626a = null;
        this.f25628q = 0;
        this.f25629r = 0;
        mo74348a();
        mo74349a(context, (ViewGroup) getParent());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo74348a() {
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        setRenderMode(1);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo74349a(Context context, ViewGroup viewGroup) throws CreateDiARNavViewException {
        try {
            DARCNAVCreateData alloc = DARCNAVCreateData.alloc();
            this.f25627p = alloc;
            AREngineJNI.DARCNAVCreateData_containerView_set(alloc, viewGroup);
            this.f25627p.setDataPath("file");
            this.f25627p.setDataIsSimple(false);
            this.f25627p.setNetworkStatus(NetStateUtil.convertNetworkeStateJava2AR(NetStateUtil.getNetworkState()));
            this.f25627p.setUid(ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getmUID());
            String orderID = ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getOrderID();
            if (!TextUtils.isEmpty(orderID)) {
                this.f25627p.setOrderID(AREngineJNI.encryptStringWrap(orderID, orderID.length()));
            }
            this.f25627p.setAskData(ARCoreCheckerAndGenerator.cacheResponseData.getcResData());
            this.f25627p.setLocVersion(f25612b);
            this.f25627p.setUseOldBoard(f25613c);
            this.f25627p.setPDREnabled(f25614d);
            this.f25627p.setPDRShadowEnabled(f25615e);
            this.f25627p.setPDRFusionEnable(f25616f);
            this.f25627p.setPDRTotalDuration(f25617g);
            this.f25627p.setPDRCoreDuration(f25618h);
            this.f25627p.setPDRInterLocInterval(f25619i);
            this.f25627p.setPDRInterLocDistance(f25620j);
            this.f25627p.setPDRLevelDetectionEnable(f25621k);
            this.f25627p.setARDriftDetectionInInitEnable(f25622l);
            this.f25627p.setARDriftDetectionInInitSpeed((float) f25623m);
            this.f25627p.setARDriftDetectionInNaviEnable(f25624n);
            this.f25627p.setARDriftDetectionInNaviSpeed((float) f25625o);
            this.f25626a = new DiARNavController(this.f25627p, context, viewGroup);
        } catch (Exception unused) {
            throw new CreateDiARNavViewException();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        this.f25626a.onHostCreated();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.f25628q = i;
        this.f25629r = i2;
        this.f25626a.onHostSizeChanged(i, i2);
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16640);
        this.f25626a.drawFrame();
    }

    public DiARNavController getDiARController() {
        return this.f25626a;
    }

    public void onDestroy() {
        this.f25626a.onHostDestroy();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f25626a.onHostDetached();
    }

    public void onResume() {
        this.f25626a.onHostResume();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.f25626a.onHostPause();
    }
}
