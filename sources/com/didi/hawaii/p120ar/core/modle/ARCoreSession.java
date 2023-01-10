package com.didi.hawaii.p120ar.core.modle;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.util.Size;
import com.didi.hawaii.p120ar.jni.AREngineJNI;
import com.didi.hawaii.p120ar.jni.DARCARImage;
import com.didi.hawaii.p120ar.jni.DARCARTrackState;
import com.didi.hawaii.p120ar.jni.DARCARTrackStateReason;
import com.didi.hawaii.p120ar.jni.DARCLocationInScene;
import com.didi.hawaii.p120ar.jni.DARCNAVStatus;
import com.didi.hawaii.p120ar.jni.DARCNAVUpdateData;
import com.didi.hawaii.p120ar.utils.ARAPollo;
import com.didi.hawaii.p120ar.utils.ARNavGlobal;
import com.didi.hawaii.p120ar.utils.LocationUtil;
import com.didi.hawaii.p120ar.utils.MatrixUtil;
import com.didi.hawaii.p120ar.utils.SensorUtil;
import com.didichuxing.hawaii.arsdk.darcore.OSImage;
import com.google.p223ar.core.Camera;
import com.google.p223ar.core.CameraConfig;
import com.google.p223ar.core.Config;
import com.google.p223ar.core.Frame;
import com.google.p223ar.core.Session;
import com.google.p223ar.core.TrackingState;
import com.google.p223ar.core.exceptions.CameraNotAvailableException;
import com.google.p223ar.core.exceptions.UnavailableApkTooOldException;
import com.google.p223ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.p223ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p223ar.core.exceptions.UnavailableSdkTooOldException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession */
public class ARCoreSession extends Session {
    public static final int EXCESSMOTION = 2;
    public static final int HINTNAVIGATIONDISMISS = 4;
    public static final int PITCHNOTAVIABLENAVIGATION = 6;

    /* renamed from: b */
    private static final String f25301b = ARCoreSession.class.getSimpleName();

    /* renamed from: c */
    private static ArrayList<Float> f25302c;

    /* renamed from: d */
    private static boolean f25303d = false;

    /* renamed from: e */
    private static int f25304e = 15;

    /* renamed from: x */
    private static boolean f25305x = ARAPollo.isUseDeFaultImageSize();

    /* renamed from: a */
    float[] f25306a;

    /* renamed from: f */
    private Frame f25307f = null;

    /* renamed from: g */
    private Camera f25308g = null;

    /* renamed from: h */
    private Size f25309h = new Size(1280, 720);

    /* renamed from: i */
    private boolean f25310i = false;

    /* renamed from: j */
    private float f25311j;

    /* renamed from: k */
    private float f25312k;

    /* renamed from: l */
    private float f25313l;

    /* renamed from: m */
    private long f25314m;

    /* renamed from: n */
    private long f25315n;

    /* renamed from: o */
    private int f25316o;

    /* renamed from: p */
    private ARPosition f25317p;

    /* renamed from: q */
    private ARPosition f25318q;

    /* renamed from: r */
    private ARAngle f25319r;

    /* renamed from: s */
    private ARAngle f25320s;

    /* renamed from: t */
    private NavStartHintData f25321t = new NavStartHintData();

    /* renamed from: u */
    private long f25322u = 0;

    /* renamed from: v */
    private DARCLocationInScene f25323v;

    /* renamed from: w */
    private DARCLocationInScene f25324w;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$checkStatus */
    public @interface checkStatus {
    }

    /* renamed from: a */
    private static float m20250a(float f) {
        return f < 0.0f ? f + 360.0f : f > 360.0f ? f % 360.0f : f;
    }

    public ARCoreSession(Context context) throws UnavailableSdkTooOldException, UnavailableDeviceNotCompatibleException, UnavailableArcoreNotInstalledException, UnavailableApkTooOldException {
        super(context);
        if (!f25305x) {
            Iterator<CameraConfig> it = getSupportedCameraConfigs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CameraConfig next = it.next();
                if (next.getImageSize().equals(this.f25309h)) {
                    setCameraConfig(next);
                    break;
                }
            }
        }
        Config config = new Config(this);
        config.setFocusMode(Config.FocusMode.FIXED);
        config.setUpdateMode(Config.UpdateMode.LATEST_CAMERA_IMAGE);
        config.setAugmentedFaceMode(Config.AugmentedFaceMode.DISABLED);
        config.setPlaneFindingMode(Config.PlaneFindingMode.DISABLED);
        configure(config);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m20255a(float r2, float r3, float r4) {
        /*
            float r2 = m20250a((float) r2)
            float r3 = m20250a((float) r3)
            float r4 = m20250a((float) r4)
            r0 = 1
            int r1 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x001a
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x001a:
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0024
            r3 = 1135869952(0x43b40000, float:360.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002f
        L_0x0024:
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p120ar.core.modle.ARCoreSession.m20255a(float, float, float):boolean");
    }

    public Frame update(int[] iArr, DARCLocationInScene dARCLocationInScene, DARCNAVStatus dARCNAVStatus) throws CameraNotAvailableException {
        this.f25324w = dARCLocationInScene;
        Frame update = super.update();
        this.f25307f = update;
        this.f25308g = update.getCamera();
        if (!this.f25310i) {
            m20256b();
            this.f25310i = true;
        }
        if (this.f25310i) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f25317p = new ARPosition(this.f25308g.getPose().getTranslation());
            this.f25315n = currentTimeMillis;
            this.f25306a = this.f25308g.getPose().getRotationQuaternion();
            this.f25320s = new ARAngle(MatrixUtil.quaternionToEuler(this.f25308g.getPose().getRotationQuaternion()));
            iArr[0] = m20251a();
            iArr[1] = m20252a(dARCNAVStatus);
            iArr[2] = m20259d();
        }
        return this.f25307f;
    }

    public OSImage acquireCameraOSImage() {
        Image image;
        OSImage oSImage = null;
        try {
            image = this.f25307f.acquireCameraImage();
        } catch (Exception unused) {
            image = null;
        }
        if (image != null) {
            oSImage = new OSImage(image);
            if (Build.VERSION.SDK_INT >= 19) {
                image.close();
            }
        }
        return oSImage;
    }

    public DARCNAVUpdateData getUpdateData(OSImage oSImage, boolean z) {
        float[] fArr = new float[16];
        this.f25308g.getProjectionMatrix(fArr, 0, 1.0E-4f, 1000.0f);
        float[] fArr2 = new float[16];
        this.f25308g.getPose().toMatrix(fArr2, 0);
        return m20253a(fArr, fArr2, this.f25308g, this.f25307f, z, oSImage);
    }

    /* renamed from: a */
    private DARCNAVUpdateData m20253a(float[] fArr, float[] fArr2, Camera camera, Frame frame, boolean z, OSImage oSImage) {
        DARCNAVUpdateData dARCNAVUpdateData = new DARCNAVUpdateData();
        AREngineJNI.DARCNAVUpdateData_cameraColorBuffer_set(dARCNAVUpdateData, (byte[]) null);
        AREngineJNI.DARCNAVUpdateData_cameraDepthBuffer_set(dARCNAVUpdateData, (byte[]) null);
        dARCNAVUpdateData.setProjection(MatrixUtil.convertViewMatrix2DARCMatrix(fArr));
        DARCARImage alloc = DARCARImage.alloc();
        if (z) {
            alloc.setOSImage(oSImage);
        } else {
            alloc.setOSImage((Object) null);
        }
        if (camera.getTrackingState() == TrackingState.PAUSED) {
            alloc.setTrackState(DARCARTrackState.DARCARTrackState_Limited);
            int i = C96271.$SwitchMap$com$google$ar$core$TrackingFailureReason[camera.getTrackingFailureReason().ordinal()];
            if (i == 1) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_None);
            } else if (i == 2) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_Initializing);
            } else if (i == 3) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_Relocalizing);
            } else if (i == 4) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_ExcessiveMotion);
            } else if (i == 5) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_InsufficientFeatures);
            }
        } else if (camera.getTrackingState() == TrackingState.TRACKING) {
            alloc.setTrackState(DARCARTrackState.DARCARTrackState_Normal);
            alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_None);
        } else if (camera.getTrackingState() == TrackingState.STOPPED) {
            alloc.setTrackState(DARCARTrackState.DARCARTrackState_NotAvailable);
            alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_None);
        }
        alloc.setTransform(MatrixUtil.convertViewMatrix2DARCMatrix(fArr2));
        alloc.setEulerAngle(MatrixUtil.convet2DARCPoint3F(MatrixUtil.quaternionToEuler(camera.getPose().getRotationQuaternion())));
        alloc.setAmbientColorTemperature(0.0f);
        alloc.setAmbientIntensity(frame.getLightEstimate().getPixelIntensity());
        alloc.setAirPressure(SensorUtil.getInstance().GetPressureData());
        alloc.setAttitudeMatrix(MatrixUtil.convetMatrix3F2DARCMatrix3F(SensorUtil.getInstance().getRotationMatrix3D()));
        alloc.setGPSData(LocationUtil.getCurLocation2DARCGPSData());
        alloc.setArOriginTimeStamp(((double) frame.getTimestamp()) / 1.0E9d);
        float[] focalLength = camera.getImageIntrinsics().getFocalLength();
        float[] fArr3 = new float[9];
        fArr3[0] = focalLength[0];
        fArr3[1] = focalLength[1];
        alloc.setIntrinsics(MatrixUtil.convetMatrix3F2DARCMatrix3F(fArr3));
        dARCNAVUpdateData.setArImage(alloc);
        return dARCNAVUpdateData;
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$1 */
    static /* synthetic */ class C96271 {
        static final /* synthetic */ int[] $SwitchMap$com$google$ar$core$TrackingFailureReason;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.ar.core.TrackingFailureReason[] r0 = com.google.p223ar.core.TrackingFailureReason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$ar$core$TrackingFailureReason = r0
                com.google.ar.core.TrackingFailureReason r1 = com.google.p223ar.core.TrackingFailureReason.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p223ar.core.TrackingFailureReason.BAD_STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p223ar.core.TrackingFailureReason.INSUFFICIENT_LIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p223ar.core.TrackingFailureReason.EXCESSIVE_MOTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p223ar.core.TrackingFailureReason.INSUFFICIENT_FEATURES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p120ar.core.modle.ARCoreSession.C96271.<clinit>():void");
        }
    }

    /* renamed from: a */
    private int m20251a() {
        return m20258c();
    }

    /* renamed from: a */
    private void m20254a(int[] iArr) {
        if (this.f25320s.f25325x + 90.0f < (-ARNavGlobal.locationParam.maxAngle) || this.f25320s.f25325x + 90.0f > (-ARNavGlobal.locationParam.minAngle)) {
            iArr[0] = 1;
        }
    }

    /* renamed from: b */
    private void m20257b(int[] iArr) {
        f25302c.add(Float.valueOf(this.f25320s.f25326y));
        if (f25302c.size() > 15) {
            f25302c.remove(0);
            float f = ARNavGlobal.locationParam.maxMotionlessAngle;
            float floatValue = f25302c.get(0).floatValue() - f;
            float floatValue2 = f25302c.get(0).floatValue() + f;
            Iterator<Float> it = f25302c.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (m20255a(it.next().floatValue(), floatValue, floatValue2)) {
                    i++;
                }
            }
            if (!(i < f25302c.size())) {
                iArr[0] = 3;
            }
        }
    }

    /* renamed from: b */
    private void m20256b() {
        this.f25311j = 0.0f;
        this.f25312k = 0.0f;
        this.f25313l = 0.0f;
        this.f25314m = 0;
        this.f25315n = 0;
        this.f25316o = 0;
        this.f25321t.status = 0;
        this.f25322u = 0;
    }

    /* renamed from: c */
    private int m20258c() {
        long j = this.f25314m;
        int i = 0;
        if (j != 0) {
            long j2 = this.f25315n;
            if (j2 > j) {
                this.f25311j += (float) Math.sqrt((double) (((this.f25317p.f25328x - this.f25318q.f25328x) * (this.f25317p.f25328x - this.f25318q.f25328x)) + ((this.f25317p.f25329y - this.f25318q.f25329y) * (this.f25317p.f25329y - this.f25318q.f25329y)) + ((this.f25317p.f25330z - this.f25318q.f25330z) * (this.f25317p.f25330z - this.f25318q.f25330z))));
                this.f25312k += Math.abs(this.f25319r.f25326y - this.f25320s.f25326y);
                float f = this.f25313l + (((float) (j2 - j)) / 1000.0f);
                this.f25313l = f;
                if (f >= 0.3f) {
                    if (this.f25311j / f > 0.3f) {
                        this.f25316o++;
                        i = 2;
                    }
                    this.f25311j = 0.0f;
                    this.f25312k = 0.0f;
                    this.f25313l = 0.0f;
                }
            }
        }
        this.f25319r = this.f25320s;
        this.f25314m = this.f25315n;
        this.f25318q = this.f25317p;
        return i;
    }

    public void updateNavHintData() {
        this.f25321t.status = 1;
    }

    /* renamed from: d */
    private int m20259d() {
        int i = this.f25321t.status;
        if (i == 1) {
            this.f25321t.f25331x = this.f25324w.getPos().getX();
            this.f25321t.f25332z = this.f25324w.getPos().getZ();
            this.f25321t.index = this.f25324w.getIndex();
            this.f25321t.status++;
            return 0;
        } else if (i != 2) {
            if (i != 3 || ((double) (((float) (this.f25315n - this.f25321t.startTime)) / 1000.0f)) < 3.0d) {
                return 0;
            }
            this.f25321t.status = 0;
            return 4;
        } else if (((this.f25321t.f25331x - this.f25324w.getPos().getX()) * (this.f25321t.f25331x - this.f25324w.getPos().getX())) + ((this.f25321t.f25332z - this.f25324w.getPos().getZ()) * (this.f25321t.f25332z - this.f25324w.getPos().getZ())) < 9.0f) {
            return 0;
        } else {
            this.f25321t.startTime = System.currentTimeMillis();
            this.f25321t.status++;
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b6, code lost:
        if (java.lang.Math.sqrt((double) (((r8.f25324w.getPos().getX() - r8.f25323v.getPos().getX()) * (r8.f25324w.getPos().getX() - r8.f25323v.getPos().getX())) + ((r8.f25324w.getPos().getZ() - r8.f25323v.getPos().getZ()) * (r8.f25324w.getPos().getZ() - r8.f25323v.getPos().getZ())))) >= 20.0d) goto L_0x00ba;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m20252a(com.didi.hawaii.p120ar.jni.DARCNAVStatus r9) {
        /*
            r8 = this;
            com.didi.hawaii.ar.jni.DARCNAVStatus r0 = com.didi.hawaii.p120ar.jni.DARCNAVStatus.DARCNAVStatus_Running
            r1 = 0
            r3 = 0
            if (r9 != r0) goto L_0x00bf
            com.didi.hawaii.ar.core.modle.ARCoreSession$ARAngle r9 = r8.f25320s
            float r9 = r9.f25327z
            r0 = 1127481344(0x43340000, float:180.0)
            float r9 = r9 * r0
            double r4 = (double) r9
            r6 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r4 = r4 / r6
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            boolean r9 = com.didi.hawaii.p120ar.utils.SensorUtil.isNavigationPitchAviable
            if (r9 != 0) goto L_0x00bc
            long r4 = r8.f25322u
            int r9 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r9 > 0) goto L_0x002a
            long r0 = java.lang.System.currentTimeMillis()
            r8.f25322u = r0
        L_0x002a:
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r8.f25322u
            long r0 = r0 - r4
            float r9 = (float) r0
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r9 = r9 / r0
            r0 = 1101004800(0x41a00000, float:20.0)
            r1 = 6
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 <= 0) goto L_0x003d
            r3 = 6
        L_0x003d:
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f25323v
            if (r9 != 0) goto L_0x0046
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f25324w
            r8.f25323v = r9
            goto L_0x00b9
        L_0x0046:
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f25324w
            int r9 = r9.getIndex()
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f25323v
            int r0 = r0.getIndex()
            if (r9 != r0) goto L_0x00b9
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f25324w
            com.didi.hawaii.ar.jni.DARCPoint3F r9 = r9.getPos()
            float r9 = r9.getX()
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f25323v
            com.didi.hawaii.ar.jni.DARCPoint3F r0 = r0.getPos()
            float r0 = r0.getX()
            float r9 = r9 - r0
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f25324w
            com.didi.hawaii.ar.jni.DARCPoint3F r0 = r0.getPos()
            float r0 = r0.getX()
            com.didi.hawaii.ar.jni.DARCLocationInScene r2 = r8.f25323v
            com.didi.hawaii.ar.jni.DARCPoint3F r2 = r2.getPos()
            float r2 = r2.getX()
            float r0 = r0 - r2
            float r9 = r9 * r0
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f25324w
            com.didi.hawaii.ar.jni.DARCPoint3F r0 = r0.getPos()
            float r0 = r0.getZ()
            com.didi.hawaii.ar.jni.DARCLocationInScene r2 = r8.f25323v
            com.didi.hawaii.ar.jni.DARCPoint3F r2 = r2.getPos()
            float r2 = r2.getZ()
            float r0 = r0 - r2
            com.didi.hawaii.ar.jni.DARCLocationInScene r2 = r8.f25324w
            com.didi.hawaii.ar.jni.DARCPoint3F r2 = r2.getPos()
            float r2 = r2.getZ()
            com.didi.hawaii.ar.jni.DARCLocationInScene r4 = r8.f25323v
            com.didi.hawaii.ar.jni.DARCPoint3F r4 = r4.getPos()
            float r4 = r4.getZ()
            float r2 = r2 - r4
            float r0 = r0 * r2
            float r9 = r9 + r0
            double r4 = (double) r9
            double r4 = java.lang.Math.sqrt(r4)
            r6 = 4626322717216342016(0x4034000000000000, double:20.0)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 < 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r1 = r3
        L_0x00ba:
            r3 = r1
            goto L_0x00c1
        L_0x00bc:
            r8.f25322u = r1
            goto L_0x00c1
        L_0x00bf:
            r8.f25322u = r1
        L_0x00c1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p120ar.core.modle.ARCoreSession.m20252a(com.didi.hawaii.ar.jni.DARCNAVStatus):int");
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$ARPosition */
    static class ARPosition {

        /* renamed from: x */
        float f25328x;

        /* renamed from: y */
        float f25329y;

        /* renamed from: z */
        float f25330z;

        ARPosition(float[] fArr) {
            this.f25328x = fArr[0];
            this.f25329y = fArr[1];
            this.f25330z = fArr[2];
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$ARAngle */
    static class ARAngle {

        /* renamed from: x */
        float f25325x;

        /* renamed from: y */
        float f25326y;

        /* renamed from: z */
        float f25327z;

        ARAngle(double[] dArr) {
            this.f25325x = (float) dArr[0];
            this.f25326y = (float) dArr[1];
            this.f25327z = (float) dArr[2];
        }

        public String toString() {
            return "x=" + this.f25325x + "\ty=" + this.f25326y + "\tz=" + this.f25327z;
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$NavStartHintData */
    static class NavStartHintData {
        int index;
        long startTime;
        int status;

        /* renamed from: x */
        float f25331x;

        /* renamed from: z */
        float f25332z;

        NavStartHintData() {
        }
    }
}
