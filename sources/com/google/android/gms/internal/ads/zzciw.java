package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import com.didi.sdk.apm.SystemUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzciw extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzciu {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzciv zzb;
    private final float[] zzc = new float[9];
    private final float[] zzd = new float[9];
    private final float[] zze = new float[9];
    private final float[] zzf = new float[9];
    private final float[] zzg = new float[9];
    private final float[] zzh = new float[9];
    private final float[] zzi = new float[9];
    private float zzj = Float.NaN;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzciw(Context context) {
        super("SphericalVideoProcessor");
        int length = zza.length;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = asFloatBuffer;
        asFloatBuffer.put(zza).position(0);
        zzciv zzciv = new zzciv(context);
        this.zzb = zzciv;
        zzciv.zza(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            SystemUtils.log(6, "SphericalVideoRenderer", str + ": glError " + glGetError, (Throwable) null, "com.google.android.gms.internal.ads.zzciw", 2);
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static final void zzj(float[] fArr, float f) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d = (double) f;
        fArr[4] = (float) Math.cos(d);
        fArr[5] = (float) (-Math.sin(d));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d);
        fArr[8] = (float) Math.cos(d);
    }

    private static final void zzk(float[] fArr, float f) {
        double d = (double) f;
        fArr[0] = (float) Math.cos(d);
        fArr[1] = (float) (-Math.sin(d));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d);
        fArr[4] = (float) Math.cos(d);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        zzh("createShader");
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(glCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                SystemUtils.log(6, "SphericalVideoRenderer", "Could not compile shader " + i + ":", (Throwable) null, "com.google.android.gms.internal.ads.zzciw", 9);
                SystemUtils.log(6, "SphericalVideoRenderer", GLES20.glGetShaderInfoLog(glCreateShader), (Throwable) null, "com.google.android.gms.internal.ads.zzciw", 10);
                GLES20.glDeleteShader(glCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return glCreateShader;
    }

    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01d4 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r22 = this;
            r1 = r22
            android.graphics.SurfaceTexture r0 = r1.zzp
            if (r0 == 0) goto L_0x03b0
            javax.microedition.khronos.egl.EGL r0 = javax.microedition.khronos.egl.EGLContext.getEGL()
            javax.microedition.khronos.egl.EGL10 r0 = (javax.microedition.khronos.egl.EGL10) r0
            r1.zzw = r0
            java.lang.Object r2 = javax.microedition.khronos.egl.EGL10.EGL_DEFAULT_DISPLAY
            javax.microedition.khronos.egl.EGLDisplay r0 = r0.eglGetDisplay(r2)
            r1.zzx = r0
            javax.microedition.khronos.egl.EGLDisplay r2 = javax.microedition.khronos.egl.EGL10.EGL_NO_DISPLAY
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r0 != r2) goto L_0x0022
        L_0x001f:
            r0 = 0
            goto L_0x008d
        L_0x0022:
            int[] r0 = new int[r4]
            javax.microedition.khronos.egl.EGL10 r2 = r1.zzw
            javax.microedition.khronos.egl.EGLDisplay r8 = r1.zzx
            boolean r0 = r2.eglInitialize(r8, r0)
            if (r0 != 0) goto L_0x002f
            goto L_0x001f
        L_0x002f:
            int[] r0 = new int[r6]
            javax.microedition.khronos.egl.EGLConfig[] r2 = new javax.microedition.khronos.egl.EGLConfig[r6]
            r8 = 11
            int[] r10 = new int[r8]
            r10 = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r8 = r1.zzw
            javax.microedition.khronos.egl.EGLDisplay r9 = r1.zzx
            r12 = 1
            r11 = r2
            r13 = r0
            boolean r8 = r8.eglChooseConfig(r9, r10, r11, r12, r13)
            if (r8 != 0) goto L_0x0049
        L_0x0047:
            r0 = r5
            goto L_0x004f
        L_0x0049:
            r0 = r0[r7]
            if (r0 <= 0) goto L_0x0047
            r0 = r2[r7]
        L_0x004f:
            if (r0 != 0) goto L_0x0052
            goto L_0x001f
        L_0x0052:
            int[] r2 = new int[r3]
            r2 = {12440, 2, 12344} // fill-array
            javax.microedition.khronos.egl.EGL10 r8 = r1.zzw
            javax.microedition.khronos.egl.EGLDisplay r9 = r1.zzx
            javax.microedition.khronos.egl.EGLContext r10 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            javax.microedition.khronos.egl.EGLContext r2 = r8.eglCreateContext(r9, r0, r10, r2)
            r1.zzy = r2
            if (r2 == 0) goto L_0x001f
            javax.microedition.khronos.egl.EGLContext r8 = javax.microedition.khronos.egl.EGL10.EGL_NO_CONTEXT
            if (r2 != r8) goto L_0x006a
            goto L_0x001f
        L_0x006a:
            javax.microedition.khronos.egl.EGL10 r2 = r1.zzw
            javax.microedition.khronos.egl.EGLDisplay r8 = r1.zzx
            android.graphics.SurfaceTexture r9 = r1.zzp
            javax.microedition.khronos.egl.EGLSurface r0 = r2.eglCreateWindowSurface(r8, r0, r9, r5)
            r1.zzz = r0
            if (r0 == 0) goto L_0x001f
            javax.microedition.khronos.egl.EGLSurface r2 = javax.microedition.khronos.egl.EGL10.EGL_NO_SURFACE
            if (r0 != r2) goto L_0x007d
            goto L_0x001f
        L_0x007d:
            javax.microedition.khronos.egl.EGL10 r0 = r1.zzw
            javax.microedition.khronos.egl.EGLDisplay r2 = r1.zzx
            javax.microedition.khronos.egl.EGLSurface r8 = r1.zzz
            javax.microedition.khronos.egl.EGLContext r9 = r1.zzy
            boolean r0 = r0.eglMakeCurrent(r2, r8, r8, r9)
            if (r0 != 0) goto L_0x008c
            goto L_0x001f
        L_0x008c:
            r0 = 1
        L_0x008d:
            com.google.android.gms.internal.ads.zzbiu r2 = com.google.android.gms.internal.ads.zzbjc.zzbc
            com.google.android.gms.internal.ads.zzbja r8 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r8 = r8.zzb(r2)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.zzm()
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00ae
            com.google.android.gms.internal.ads.zzbja r8 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r2 = r8.zzb(r2)
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r2 = "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}"
        L_0x00b0:
            r8 = 35633(0x8b31, float:4.9932E-41)
            int r2 = zzl(r8, r2)
            if (r2 != 0) goto L_0x00bc
        L_0x00b9:
            r9 = 0
            goto L_0x014d
        L_0x00bc:
            com.google.android.gms.internal.ads.zzbiu r8 = com.google.android.gms.internal.ads.zzbjc.zzbd
            com.google.android.gms.internal.ads.zzbja r9 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r9 = r9.zzb(r8)
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r8.zzm()
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzbja r9 = com.google.android.gms.ads.internal.client.zzay.zzc()
            java.lang.Object r8 = r9.zzb(r8)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x00df
        L_0x00dd:
            java.lang.String r8 = "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}"
        L_0x00df:
            r9 = 35632(0x8b30, float:4.9931E-41)
            int r8 = zzl(r9, r8)
            if (r8 != 0) goto L_0x00e9
            goto L_0x00b9
        L_0x00e9:
            int r9 = android.opengl.GLES20.glCreateProgram()
            java.lang.String r10 = "createProgram"
            zzh(r10)
            if (r9 == 0) goto L_0x014d
            android.opengl.GLES20.glAttachShader(r9, r2)
            java.lang.String r2 = "attachShader"
            zzh(r2)
            android.opengl.GLES20.glAttachShader(r9, r8)
            java.lang.String r2 = "attachShader"
            zzh(r2)
            android.opengl.GLES20.glLinkProgram(r9)
            java.lang.String r2 = "linkProgram"
            zzh(r2)
            int[] r2 = new int[r6]
            r8 = 35714(0x8b82, float:5.0046E-41)
            android.opengl.GLES20.glGetProgramiv(r9, r8, r2, r7)
            java.lang.String r8 = "getProgramiv"
            zzh(r8)
            r2 = r2[r7]
            if (r2 == r6) goto L_0x0145
            java.lang.String r11 = "SphericalVideoRenderer"
            java.lang.String r12 = "Could not link program: "
            r10 = 6
            r13 = 0
            java.lang.String r14 = "com.google.android.gms.internal.ads.zzciw"
            r15 = 29
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
            java.lang.String r17 = "SphericalVideoRenderer"
            java.lang.String r18 = android.opengl.GLES20.glGetProgramInfoLog(r9)
            r16 = 6
            r19 = 0
            java.lang.String r20 = "com.google.android.gms.internal.ads.zzciw"
            r21 = 30
            com.didi.sdk.apm.SystemUtils.log(r16, r17, r18, r19, r20, r21)
            android.opengl.GLES20.glDeleteProgram(r9)
            java.lang.String r2 = "deleteProgram"
            zzh(r2)
            goto L_0x00b9
        L_0x0145:
            android.opengl.GLES20.glValidateProgram(r9)
            java.lang.String r2 = "validateProgram"
            zzh(r2)
        L_0x014d:
            r1.zzq = r9
            android.opengl.GLES20.glUseProgram(r9)
            java.lang.String r2 = "useProgram"
            zzh(r2)
            int r2 = r1.zzq
            java.lang.String r8 = "aPosition"
            int r2 = android.opengl.GLES20.glGetAttribLocation(r2, r8)
            r10 = 3
            r11 = 5126(0x1406, float:7.183E-42)
            r12 = 0
            r13 = 12
            java.nio.FloatBuffer r14 = r1.zzt
            r9 = r2
            android.opengl.GLES20.glVertexAttribPointer(r9, r10, r11, r12, r13, r14)
            java.lang.String r8 = "vertexAttribPointer"
            zzh(r8)
            android.opengl.GLES20.glEnableVertexAttribArray(r2)
            java.lang.String r2 = "enableVertexAttribArray"
            zzh(r2)
            int[] r2 = new int[r6]
            android.opengl.GLES20.glGenTextures(r6, r2, r7)
            java.lang.String r8 = "genTextures"
            zzh(r8)
            r2 = r2[r7]
            r8 = 36197(0x8d65, float:5.0723E-41)
            android.opengl.GLES20.glBindTexture(r8, r2)
            java.lang.String r9 = "bindTextures"
            zzh(r9)
            r9 = 10240(0x2800, float:1.4349E-41)
            r10 = 9729(0x2601, float:1.3633E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r9 = "texParameteri"
            zzh(r9)
            r9 = 10241(0x2801, float:1.435E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r9 = "texParameteri"
            zzh(r9)
            r9 = 10242(0x2802, float:1.4352E-41)
            r10 = 33071(0x812f, float:4.6342E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r9 = "texParameteri"
            zzh(r9)
            r9 = 10243(0x2803, float:1.4354E-41)
            android.opengl.GLES20.glTexParameteri(r8, r9, r10)
            java.lang.String r8 = "texParameteri"
            zzh(r8)
            int r8 = r1.zzq
            java.lang.String r9 = "uVMat"
            int r8 = android.opengl.GLES20.glGetUniformLocation(r8, r9)
            r1.zzr = r8
            r9 = 9
            float[] r9 = new float[r9]
            r9 = {1065353216, 0, 0, 0, 1065353216, 0, 0, 0, 1065353216} // fill-array
            android.opengl.GLES20.glUniformMatrix3fv(r8, r6, r7, r9, r7)
            int r8 = r1.zzq
            if (r0 == 0) goto L_0x0382
            if (r8 != 0) goto L_0x01d8
            goto L_0x0382
        L_0x01d8:
            android.graphics.SurfaceTexture r0 = new android.graphics.SurfaceTexture
            r0.<init>(r2)
            r1.zzo = r0
            r0.setOnFrameAvailableListener(r1)
            java.util.concurrent.CountDownLatch r0 = r1.zzu
            r0.countDown()
            com.google.android.gms.internal.ads.zzciv r0 = r1.zzb
            r0.zzb()
            r1.zzA = r6     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
        L_0x01ee:
            boolean r0 = r1.zzB     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            if (r0 != 0) goto L_0x032d
        L_0x01f2:
            int r0 = r1.zzs     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            if (r0 <= 0) goto L_0x0202
            android.graphics.SurfaceTexture r0 = r1.zzo     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r0.updateTexImage()     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r0 = r1.zzs     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r0 = r0 + -1
            r1.zzs = r0     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            goto L_0x01f2
        L_0x0202:
            com.google.android.gms.internal.ads.zzciv r0 = r1.zzb     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r2 = r1.zzc     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            boolean r0 = r0.zzd(r2)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r2 = 5
            r8 = 4
            r9 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            if (r0 == 0) goto L_0x027c
            float r0 = r1.zzj     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            boolean r0 = java.lang.Float.isNaN(r0)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            if (r0 == 0) goto L_0x0271
            float[] r0 = r1.zzc     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r10 = new float[r3]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r11 = 0
            r10[r7] = r11     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r12 = 1065353216(0x3f800000, float:1.0)
            r10[r6] = r12     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r10[r4] = r11     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r11 = new float[r3]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r12 = r0[r7]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r13 = r10[r7]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r12 = r12 * r13
            r14 = r0[r6]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r15 = r10[r6]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r14 = r14 * r15
            float r12 = r12 + r14
            r14 = r0[r4]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r10 = r10[r4]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r14 = r14 * r10
            float r12 = r12 + r14
            r11[r7] = r12     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r12 = r0[r3]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r12 = r12 * r13
            r14 = r0[r8]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r14 = r14 * r15
            float r12 = r12 + r14
            r14 = r0[r2]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r14 = r14 * r10
            float r12 = r12 + r14
            r11[r6] = r12     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r12 = 6
            r12 = r0[r12]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r12 = r12 * r13
            r13 = 7
            r13 = r0[r13]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r13 = r13 * r15
            float r12 = r12 + r13
            r13 = 8
            r0 = r0[r13]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r0 = r0 * r10
            float r12 = r12 + r0
            r11[r4] = r12     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r0 = r11[r6]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            double r12 = (double) r0     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r0 = r11[r7]     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            double r10 = (double) r0     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            double r10 = java.lang.Math.atan2(r12, r10)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r0 = (float) r10     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r0 = r0 + r9
            float r0 = -r0
            r1.zzj = r0     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
        L_0x0271:
            float[] r0 = r1.zzh     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r9 = r1.zzj     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r10 = r1.zzk     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r9 = r9 + r10
            zzk(r0, r9)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            goto L_0x0288
        L_0x027c:
            float[] r0 = r1.zzc     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            zzj(r0, r9)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r0 = r1.zzh     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r9 = r1.zzk     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            zzk(r0, r9)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
        L_0x0288:
            float[] r0 = r1.zzd     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r9 = 1070141403(0x3fc90fdb, float:1.5707964)
            zzj(r0, r9)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r0 = r1.zze     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r9 = r1.zzh     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r10 = r1.zzd     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            zzi(r0, r9, r10)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r0 = r1.zzf     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r9 = r1.zzc     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r10 = r1.zze     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            zzi(r0, r9, r10)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r0 = r1.zzg     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r9 = r1.zzl     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            zzj(r0, r9)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r0 = r1.zzi     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r9 = r1.zzg     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r10 = r1.zzf     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            zzi(r0, r9, r10)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r0 = r1.zzr     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float[] r9 = r1.zzi     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            android.opengl.GLES20.glUniformMatrix3fv(r0, r6, r7, r9, r7)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            android.opengl.GLES20.glDrawArrays(r2, r7, r8)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            java.lang.String r0 = "drawArrays"
            zzh(r0)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            android.opengl.GLES20.glFinish()     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            javax.microedition.khronos.egl.EGL10 r0 = r1.zzw     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            javax.microedition.khronos.egl.EGLDisplay r2 = r1.zzx     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            javax.microedition.khronos.egl.EGLSurface r8 = r1.zzz     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r0.eglSwapBuffers(r2, r8)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            boolean r0 = r1.zzA     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            if (r0 == 0) goto L_0x0313
            int r0 = r1.zzn     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r2 = r1.zzm     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            android.opengl.GLES20.glViewport(r7, r7, r0, r2)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            java.lang.String r0 = "viewport"
            zzh(r0)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r0 = r1.zzq     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            java.lang.String r2 = "uFOVx"
            int r0 = android.opengl.GLES20.glGetUniformLocation(r0, r2)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r2 = r1.zzq     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            java.lang.String r8 = "uFOVy"
            int r2 = android.opengl.GLES20.glGetUniformLocation(r2, r8)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r8 = r1.zzn     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r9 = r1.zzm     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            r10 = 1063216883(0x3f5f66f3, float:0.87266463)
            if (r8 <= r9) goto L_0x0306
            android.opengl.GLES20.glUniform1f(r0, r10)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            int r0 = r1.zzm     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r0 = (float) r0     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r0 = r0 * r10
            int r8 = r1.zzn     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r0 = r0 / r8
            android.opengl.GLES20.glUniform1f(r2, r0)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            goto L_0x0311
        L_0x0306:
            float r8 = (float) r8     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r8 = r8 * r10
            float r9 = (float) r9     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            float r8 = r8 / r9
            android.opengl.GLES20.glUniform1f(r0, r8)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
            android.opengl.GLES20.glUniform1f(r2, r10)     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
        L_0x0311:
            r1.zzA = r7     // Catch:{ IllegalStateException -> 0x035c, all -> 0x033d }
        L_0x0313:
            java.lang.Object r2 = r1.zzv     // Catch:{ InterruptedException -> 0x01ee }
            monitor-enter(r2)     // Catch:{ InterruptedException -> 0x01ee }
            boolean r0 = r1.zzB     // Catch:{ all -> 0x032a }
            if (r0 != 0) goto L_0x0327
            boolean r0 = r1.zzA     // Catch:{ all -> 0x032a }
            if (r0 != 0) goto L_0x0327
            int r0 = r1.zzs     // Catch:{ all -> 0x032a }
            if (r0 != 0) goto L_0x0327
            java.lang.Object r0 = r1.zzv     // Catch:{ all -> 0x032a }
            r0.wait()     // Catch:{ all -> 0x032a }
        L_0x0327:
            monitor-exit(r2)     // Catch:{ all -> 0x032a }
            goto L_0x01ee
        L_0x032a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x032a }
            throw r0     // Catch:{ InterruptedException -> 0x01ee }
        L_0x032d:
            com.google.android.gms.internal.ads.zzciv r0 = r1.zzb
            r0.zzc()
            android.graphics.SurfaceTexture r0 = r1.zzo
            r0.setOnFrameAvailableListener(r5)
            r1.zzo = r5
            r22.zzg()
            return
        L_0x033d:
            r0 = move-exception
            java.lang.String r2 = "SphericalVideoProcessor died."
            com.google.android.gms.ads.internal.util.zze.zzh(r2, r0)     // Catch:{ all -> 0x0371 }
            com.google.android.gms.internal.ads.zzcfy r2 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x0371 }
            java.lang.String r3 = "SphericalVideoProcessor.run.2"
            r2.zzt(r0, r3)     // Catch:{ all -> 0x0371 }
            com.google.android.gms.internal.ads.zzciv r0 = r1.zzb
            r0.zzc()
            android.graphics.SurfaceTexture r0 = r1.zzo
            r0.setOnFrameAvailableListener(r5)
            r1.zzo = r5
            r22.zzg()
            return
        L_0x035c:
            java.lang.String r0 = "SphericalVideoProcessor halted unexpectedly."
            com.google.android.gms.ads.internal.util.zze.zzj(r0)     // Catch:{ all -> 0x0371 }
            com.google.android.gms.internal.ads.zzciv r0 = r1.zzb
            r0.zzc()
            android.graphics.SurfaceTexture r0 = r1.zzo
            r0.setOnFrameAvailableListener(r5)
            r1.zzo = r5
            r22.zzg()
            return
        L_0x0371:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzciv r2 = r1.zzb
            r2.zzc()
            android.graphics.SurfaceTexture r2 = r1.zzo
            r2.setOnFrameAvailableListener(r5)
            r1.zzo = r5
            r22.zzg()
            throw r0
        L_0x0382:
            java.lang.String r0 = "EGL initialization failed: "
            javax.microedition.khronos.egl.EGL10 r2 = r1.zzw
            int r2 = r2.eglGetError()
            java.lang.String r2 = android.opengl.GLUtils.getEGLErrorString(r2)
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r0 = r0.concat(r2)
            com.google.android.gms.ads.internal.util.zze.zzg(r0)
            com.google.android.gms.internal.ads.zzcfy r2 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.Throwable r3 = new java.lang.Throwable
            r3.<init>(r0)
            java.lang.String r0 = "SphericalVideoProcessor.run.1"
            r2.zzt(r3, r0)
            r22.zzg()
            java.util.concurrent.CountDownLatch r0 = r1.zzu
            r0.countDown()
            return
        L_0x03b0:
            java.lang.String r0 = "SphericalVideoProcessor started with no output texture."
            com.google.android.gms.ads.internal.util.zze.zzg(r0)
            java.util.concurrent.CountDownLatch r0 = r1.zzu
            r0.countDown()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzciw.run():void");
    }

    public final void zza() {
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    public final SurfaceTexture zzb() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzc(int i, int i2) {
        synchronized (this.zzv) {
            this.zzn = i;
            this.zzm = i2;
            this.zzA = true;
            this.zzv.notifyAll();
        }
    }

    public final void zzd(SurfaceTexture surfaceTexture, int i, int i2) {
        this.zzn = i;
        this.zzm = i2;
        this.zzp = surfaceTexture;
    }

    public final void zze() {
        synchronized (this.zzv) {
            this.zzB = true;
            this.zzp = null;
            this.zzv.notifyAll();
        }
    }

    public final void zzf(float f, float f2) {
        int i = this.zzn;
        int i2 = this.zzm;
        float f3 = i > i2 ? (float) i : (float) i2;
        this.zzk -= (f * 1.7453293f) / f3;
        float f4 = this.zzl - ((f2 * 1.7453293f) / f3);
        this.zzl = f4;
        if (f4 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f4 = -1.5707964f;
        }
        if (f4 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        EGLSurface eGLSurface = this.zzz;
        boolean z = false;
        if (!(eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE)) {
            z = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            z |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return z;
        }
        boolean eglTerminate = this.zzw.eglTerminate(eGLDisplay);
        this.zzx = null;
        return eglTerminate | z;
    }
}
