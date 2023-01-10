package com.didichuxing.dfbasesdk.video_capture;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class GLDrawer2D {

    /* renamed from: e */
    private static final boolean f49458e = false;

    /* renamed from: f */
    private static final String f49459f = "GLDrawer2D";

    /* renamed from: g */
    private static final String f49460g = "uniform mat4 uMVPMatrix;\nuniform mat4 uTexMatrix;\nattribute highp vec4 aPosition;\nattribute highp vec4 aTextureCoord;\nvarying highp vec2 vTextureCoord;\n\nvoid main() {\n\tgl_Position = uMVPMatrix * aPosition;\n\tvTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: h */
    private static final String f49461h = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying highp vec2 vTextureCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}";

    /* renamed from: i */
    private static final float[] f49462i = {1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};

    /* renamed from: j */
    private static final float[] f49463j = {1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: k */
    private static final int f49464k = 4;

    /* renamed from: l */
    private static final int f49465l = 4;

    /* renamed from: m */
    private static final int f49466m = 8;

    /* renamed from: a */
    int f49467a;

    /* renamed from: b */
    int f49468b;

    /* renamed from: c */
    int f49469c;

    /* renamed from: d */
    int f49470d;

    /* renamed from: n */
    private final FloatBuffer f49471n;

    /* renamed from: o */
    private final FloatBuffer f49472o;

    /* renamed from: p */
    private final float[] f49473p = new float[16];

    /* renamed from: q */
    private int f49474q;

    public GLDrawer2D() {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f49471n = asFloatBuffer;
        asFloatBuffer.put(f49462i);
        this.f49471n.flip();
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f49472o = asFloatBuffer2;
        asFloatBuffer2.put(f49463j);
        this.f49472o.flip();
        int loadShader = loadShader(f49460g, f49461h);
        this.f49474q = loadShader;
        GLES20.glUseProgram(loadShader);
        this.f49467a = GLES20.glGetAttribLocation(this.f49474q, "aPosition");
        this.f49468b = GLES20.glGetAttribLocation(this.f49474q, "aTextureCoord");
        this.f49469c = GLES20.glGetUniformLocation(this.f49474q, "uMVPMatrix");
        this.f49470d = GLES20.glGetUniformLocation(this.f49474q, "uTexMatrix");
        Matrix.setIdentityM(this.f49473p, 0);
        GLES20.glUniformMatrix4fv(this.f49469c, 1, false, this.f49473p, 0);
        GLES20.glUniformMatrix4fv(this.f49470d, 1, false, this.f49473p, 0);
        GLES20.glVertexAttribPointer(this.f49467a, 2, 5126, false, 8, this.f49471n);
        GLES20.glVertexAttribPointer(this.f49468b, 2, 5126, false, 8, this.f49472o);
        GLES20.glEnableVertexAttribArray(this.f49467a);
        GLES20.glEnableVertexAttribArray(this.f49468b);
    }

    public static int initTex() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9728);
        return iArr[0];
    }

    public static void deleteTex(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static int loadShader(String str, String str2) {
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        int i = 0;
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            glCreateShader = 0;
        }
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, str2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader2);
        } else {
            i = glCreateShader2;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, i);
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    public void release() {
        int i = this.f49474q;
        if (i >= 0) {
            GLES20.glDeleteProgram(i);
        }
        this.f49474q = -1;
    }

    public void draw(int i, float[] fArr) {
        GLES20.glUseProgram(this.f49474q);
        if (fArr != null) {
            GLES20.glUniformMatrix4fv(this.f49470d, 1, false, fArr, 0);
        }
        GLES20.glUniformMatrix4fv(this.f49469c, 1, false, this.f49473p, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
        GLES20.glUseProgram(0);
    }

    public void setMatrix(float[] fArr, int i) {
        if (fArr == null || fArr.length < i + 16) {
            Matrix.setIdentityM(this.f49473p, 0);
        } else {
            System.arraycopy(fArr, i, this.f49473p, 0, 16);
        }
    }
}
