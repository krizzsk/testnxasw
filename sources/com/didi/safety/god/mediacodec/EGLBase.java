package com.didi.safety.god.mediacodec;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.didi.sdk.apm.SystemUtils;

public class EGLBase {

    /* renamed from: a */
    private static final boolean f37379a = false;

    /* renamed from: b */
    private static final String f37380b = "EGLBase";

    /* renamed from: c */
    private static final int f37381c = 12610;

    /* renamed from: d */
    private EGLConfig f37382d = null;

    /* renamed from: e */
    private EGLContext f37383e = EGL14.EGL_NO_CONTEXT;

    /* renamed from: f */
    private EGLDisplay f37384f = EGL14.EGL_NO_DISPLAY;

    /* renamed from: g */
    private EGLContext f37385g = EGL14.EGL_NO_CONTEXT;

    public EGLBase(EGLContext eGLContext, boolean z, boolean z2) {
        m28194a(eGLContext, z, z2);
    }

    public void release() {
        if (this.f37384f != EGL14.EGL_NO_DISPLAY) {
            m28201b();
            EGL14.eglTerminate(this.f37384f);
            EGL14.eglReleaseThread();
        }
        this.f37384f = EGL14.EGL_NO_DISPLAY;
        this.f37383e = EGL14.EGL_NO_CONTEXT;
    }

    public EglSurface createFromSurface(Object obj) {
        EglSurface eglSurface = new EglSurface(this, obj);
        eglSurface.makeCurrent();
        return eglSurface;
    }

    public EglSurface createOffscreen(int i, int i2) {
        EglSurface eglSurface = new EglSurface(this, i, i2);
        eglSurface.makeCurrent();
        return eglSurface;
    }

    public EGLContext getContext() {
        return this.f37383e;
    }

    public int querySurface(EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.f37384f, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    /* renamed from: a */
    private void m28194a(EGLContext eGLContext, boolean z, boolean z2) {
        if (this.f37384f == EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f37384f = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(this.f37384f, iArr, 0, iArr, 1)) {
                    if (eGLContext == null) {
                        eGLContext = EGL14.EGL_NO_CONTEXT;
                    }
                    if (this.f37383e == EGL14.EGL_NO_CONTEXT) {
                        EGLConfig a = m28187a(z, z2);
                        this.f37382d = a;
                        if (a != null) {
                            this.f37383e = m28188a(eGLContext);
                        } else {
                            throw new RuntimeException("chooseConfig failed");
                        }
                    }
                    EGL14.eglQueryContext(this.f37384f, this.f37383e, 12440, new int[1], 0);
                    m28193a();
                    return;
                }
                this.f37384f = null;
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }
        throw new RuntimeException("EGL already set up");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m28197a(EGLSurface eGLSurface) {
        if (eGLSurface == null || eGLSurface == EGL14.EGL_NO_SURFACE) {
            if (EGL14.eglGetError() == 12299) {
                SystemUtils.log(6, f37380b, "makeCurrent:returned EGL_BAD_NATIVE_WINDOW.", (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 115);
            }
            return false;
        } else if (EGL14.eglMakeCurrent(this.f37384f, eGLSurface, eGLSurface, this.f37383e)) {
            return true;
        } else {
            SystemUtils.log(5, f37380b, "eglMakeCurrent:" + EGL14.eglGetError(), (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 121);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28193a() {
        if (!EGL14.eglMakeCurrent(this.f37384f, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT)) {
            SystemUtils.log(5, "TAG", "makeDefault" + EGL14.eglGetError(), (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 130);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m28199b(EGLSurface eGLSurface) {
        if (!EGL14.eglSwapBuffers(this.f37384f, eGLSurface)) {
            return EGL14.eglGetError();
        }
        return 12288;
    }

    /* renamed from: a */
    private EGLContext m28188a(EGLContext eGLContext) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(this.f37384f, this.f37382d, eGLContext, new int[]{12440, 2, 12344}, 0);
        m28196a("eglCreateContext");
        return eglCreateContext;
    }

    /* renamed from: b */
    private void m28201b() {
        if (!EGL14.eglDestroyContext(this.f37384f, this.f37383e)) {
            SystemUtils.log(6, "destroyContext", "display:" + this.f37384f + " context: " + this.f37383e, (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 160);
            StringBuilder sb = new StringBuilder();
            sb.append("eglDestroyContex:");
            sb.append(EGL14.eglGetError());
            SystemUtils.log(6, f37380b, sb.toString(), (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 161);
        }
        this.f37383e = EGL14.EGL_NO_CONTEXT;
        if (this.f37385g != EGL14.EGL_NO_CONTEXT) {
            if (!EGL14.eglDestroyContext(this.f37384f, this.f37385g)) {
                SystemUtils.log(6, "destroyContext", "display:" + this.f37384f + " context: " + this.f37385g, (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 166);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("eglDestroyContex:");
                sb2.append(EGL14.eglGetError());
                SystemUtils.log(6, f37380b, sb2.toString(), (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 167);
            }
            this.f37385g = EGL14.EGL_NO_CONTEXT;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public EGLSurface m28192a(Object obj) {
        try {
            return EGL14.eglCreateWindowSurface(this.f37384f, this.f37382d, obj, new int[]{12344}, 0);
        } catch (IllegalArgumentException e) {
            SystemUtils.log(6, f37380b, "eglCreateWindowSurface", e, "com.didi.safety.god.mediacodec.EGLBase", 183);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public EGLSurface m28189a(int i, int i2) {
        int[] iArr = {12375, i, 12374, i2, 12344};
        EGLSurface eGLSurface = null;
        try {
            eGLSurface = EGL14.eglCreatePbufferSurface(this.f37384f, this.f37382d, iArr, 0);
            m28196a("eglCreatePbufferSurface");
            if (eGLSurface != null) {
                return eGLSurface;
            }
            throw new RuntimeException("surface was null");
        } catch (IllegalArgumentException e) {
            SystemUtils.log(6, f37380b, "createOffscreenSurface", e, "com.didi.safety.god.mediacodec.EGLBase", 206);
        } catch (RuntimeException e2) {
            SystemUtils.log(6, f37380b, "createOffscreenSurface", e2, "com.didi.safety.god.mediacodec.EGLBase", 208);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m28202c(EGLSurface eGLSurface) {
        if (eGLSurface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglMakeCurrent(this.f37384f, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f37384f, eGLSurface);
        }
        EGLSurface eGLSurface2 = EGL14.EGL_NO_SURFACE;
    }

    /* renamed from: a */
    private void m28196a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    /* renamed from: a */
    private EGLConfig m28187a(boolean z, boolean z2) {
        int[] iArr = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12344, 12344, 12344, 12344, 12344, 12344, 12344};
        int i = 10;
        if (z) {
            iArr[10] = 12325;
            i = 12;
            iArr[11] = 16;
        }
        if (z2 && Build.VERSION.SDK_INT >= 18) {
            int i2 = i + 1;
            iArr[i] = 12610;
            i = i2 + 1;
            iArr[i2] = 1;
        }
        for (int i3 = 16; i3 >= i; i3--) {
            iArr[i3] = 12344;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.f37384f, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        SystemUtils.log(5, f37380b, "unable to find RGBA8888 /  EGLConfig", (Throwable) null, "com.didi.safety.god.mediacodec.EGLBase", 266);
        return null;
    }

    public static class EglSurface {
        private final EGLBase mEgl;
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private final int mHeight;
        private final int mWidth;

        EglSurface(EGLBase eGLBase, Object obj) {
            if ((obj instanceof SurfaceView) || (obj instanceof Surface) || (obj instanceof SurfaceHolder) || (obj instanceof SurfaceTexture)) {
                this.mEgl = eGLBase;
                EGLSurface a = eGLBase.m28192a(obj);
                this.mEglSurface = a;
                this.mWidth = this.mEgl.querySurface(a, 12375);
                this.mHeight = this.mEgl.querySurface(this.mEglSurface, 12374);
                return;
            }
            throw new IllegalArgumentException("unsupported surface");
        }

        EglSurface(EGLBase eGLBase, int i, int i2) {
            this.mEgl = eGLBase;
            this.mEglSurface = eGLBase.m28189a(i, i2);
            this.mWidth = i;
            this.mHeight = i2;
        }

        public void makeCurrent() {
            boolean unused = this.mEgl.m28197a(this.mEglSurface);
        }

        public void swap() {
            int unused = this.mEgl.m28199b(this.mEglSurface);
        }

        public EGLContext getContext() {
            return this.mEgl.getContext();
        }

        public void release() {
            this.mEgl.m28193a();
            this.mEgl.m28202c(this.mEglSurface);
            this.mEglSurface = EGL14.EGL_NO_SURFACE;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }
    }
}
