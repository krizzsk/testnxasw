package p096this;

import android.graphics.Rect;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import p230const.C21727do;
import p235do.C21820break;
import p241goto.C21996do;
import p241goto.C21997if;

/* renamed from: this.do */
/* compiled from: CameraFilter */
public abstract class C3683do {

    /* renamed from: a */
    static final float[] f8801a = {1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f};

    /* renamed from: b */
    static final float[] f8802b = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};

    /* renamed from: c */
    static FloatBuffer f8803c;

    /* renamed from: d */
    static FloatBuffer f8804d;

    /* renamed from: e */
    static int f8805e;

    /* renamed from: h */
    private static C21996do f8806h;

    /* renamed from: i */
    private static FloatBuffer f8807i;

    /* renamed from: j */
    private static C21820break f8808j = new C21820break(0, 0);

    /* renamed from: f */
    final long f8809f = System.currentTimeMillis();

    /* renamed from: g */
    int f8810g = 0;

    /* renamed from: k */
    private C21727do f8811k = new C21727do();

    public C3683do(float[] fArr) {
        if (f8803c == null) {
            float[] fArr2 = f8801a;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f8803c = asFloatBuffer;
            asFloatBuffer.put(fArr2);
            f8803c.position(0);
        }
        if (f8804d == null) {
            float[] fArr3 = f8802b;
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(fArr3.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f8804d = asFloatBuffer2;
            asFloatBuffer2.put(fArr3);
            f8804d.position(0);
        }
        if (f8807i == null) {
            FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            f8807i = asFloatBuffer3;
            asFloatBuffer3.put(fArr);
            f8807i.position(0);
        }
        if (f8805e == 0) {
            f8805e = C3685if.m7497do("attribute vec4 vPosition;\nattribute vec4 vTexCoord;\n\nvarying vec2 texCoord;\n\nvoid main() {\n    gl_Position = vPosition;\n    texCoord = vTexCoord.xy;\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n\nvarying vec2                texCoord;\nuniform samplerExternalOES  iChannel0;\n\nvoid main() {\n    gl_FragColor = texture2D(iChannel0, texCoord);\n}");
        }
    }

    /* renamed from: a */
    private boolean m7483a() {
        return f8805e == 0 && f8806h == null;
    }

    /* renamed from: do */
    public static int m7484do() {
        C21996do doVar = f8806h;
        if (doVar == null) {
            return f8808j.mo180432do();
        }
        return doVar.m46676for();
    }

    /* renamed from: if */
    public static int m7486if() {
        C21996do doVar = f8806h;
        if (doVar == null) {
            return f8808j.mo180435if();
        }
        return doVar.m46678try();
    }

    /* renamed from: do */
    public abstract void mo14163do(int i, int i2, int i3);

    /* renamed from: new  reason: not valid java name */
    public void m46673new() {
        this.f8810g = 0;
    }

    /* renamed from: try  reason: not valid java name */
    public synchronized void m46674try() {
        f8805e = 0;
        f8806h = null;
        f8803c = null;
        f8804d = null;
        f8807i = null;
    }

    /* renamed from: do */
    public final synchronized void mo43518do(int i, int i2, int i3, C21997if ifVar) {
        C21996do doVar = f8806h;
        if (!(doVar != null && doVar.m46678try() == i2 && f8806h.m46676for() == i3)) {
            f8806h = new C21996do(i2, i3, 33992, ifVar);
        }
        GLES20.glUseProgram(f8805e);
        int glGetUniformLocation = GLES20.glGetUniformLocation(f8805e, "iChannel0");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(glGetUniformLocation, 0);
        int glGetAttribLocation = GLES20.glGetAttribLocation(f8805e, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, f8803c);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(f8805e, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, f8807i);
        f8806h.mo43524do();
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        f8806h.m46675case();
        GLES20.glClear(16384);
        mo14163do(f8806h.m46677new(), i2, i3);
        this.f8810g++;
    }

    /* renamed from: do */
    public void mo43519do(int i, int[] iArr, int[] iArr2, int[][] iArr3) {
        mo43517a(i, f8803c, f8804d, iArr, iArr2, iArr3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43517a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2, int[] iArr, int[] iArr2, int[][] iArr3) {
        int i2 = i;
        int[] iArr4 = iArr2;
        int[][] iArr5 = iArr3;
        GLES20.glUseProgram(i);
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(i2, "iResolution"), 1, FloatBuffer.wrap(new float[]{(float) iArr[0], (float) iArr[1], 1.0f}));
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "iGlobalTime"), ((float) (System.currentTimeMillis() - this.f8809f)) / 1000.0f);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(i2, "iFrame"), this.f8810g);
        int glGetAttribLocation = GLES20.glGetAttribLocation(i2, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, floatBuffer);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(i2, "vTexCoord");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, floatBuffer2);
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "scaleX"), this.f8811k.m48206try());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "scaleY"), this.f8811k.m48204case());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "offsetX"), this.f8811k.mo178970do());
        GLES20.glUniform1f(GLES20.glGetUniformLocation(i2, "offsetY"), this.f8811k.mo178973if());
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(i2, "iChannel" + i3);
            GLES20.glActiveTexture(33984 + i3);
            GLES20.glBindTexture(3553, iArr4[i3]);
            GLES20.glUniform1i(glGetUniformLocation, i3);
        }
        int length = iArr5.length * 3;
        float[] fArr = new float[length];
        for (int i4 = 0; i4 < iArr5.length; i4++) {
            int i5 = i4 * 3;
            fArr[i5] = (float) iArr5[i4][0];
            fArr[i5 + 1] = (float) iArr5[i4][1];
            fArr[i5 + 2] = 1.0f;
        }
        GLES20.glUniform3fv(GLES20.glGetUniformLocation(i2, "iChannelResolution"), length, FloatBuffer.wrap(fArr));
    }

    /* renamed from: do */
    public synchronized void mo43520do(Rect rect, C21820break breakR) {
        if (!m7483a()) {
            this.f8811k.mo178971do(rect, breakR);
        }
    }

    /* renamed from: do */
    public static void m7485do(int i, int i2) {
        f8808j = new C21820break(i, i2);
    }
}
