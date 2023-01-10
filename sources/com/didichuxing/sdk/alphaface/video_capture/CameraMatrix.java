package com.didichuxing.sdk.alphaface.video_capture;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class CameraMatrix {

    /* renamed from: a */
    static float[] f51329a = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: b */
    static float[] f51330b = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: c */
    static float[] f51331c = {0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: d */
    private static final int f51332d = 2;

    /* renamed from: e */
    private final String f51333e = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition; gl_PointSize = 10.0;textureCoordinate = inputTextureCoordinate;}";

    /* renamed from: f */
    private final String f51334f = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";

    /* renamed from: g */
    private final int f51335g;

    /* renamed from: h */
    private final int f51336h = 8;

    /* renamed from: i */
    private final int f51337i = (f51331c.length / 3);
    public boolean isDraw = false;

    /* renamed from: j */
    private FloatBuffer f51338j;

    /* renamed from: k */
    private FloatBuffer f51339k;

    /* renamed from: l */
    private ShortBuffer f51340l;

    /* renamed from: m */
    private short[] f51341m = {0, 1, 2, 0, 2, 3};

    /* renamed from: n */
    private int f51342n;

    public CameraMatrix(int i) {
        this.f51342n = i;
        this.f51338j = floatBufferUtil(f51329a);
        this.f51340l = m38447a(this.f51341m);
        this.f51339k = floatBufferUtil(f51330b);
        this.f51335g = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f51335g, m38444a(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition; gl_PointSize = 10.0;textureCoordinate = inputTextureCoordinate;}"));
        GLES20.glAttachShader(this.f51335g, m38444a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}"));
        GLES20.glLinkProgram(this.f51335g);
    }

    public void draw(float[] fArr) {
        GLES20.glUseProgram(this.f51335g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f51342n);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f51335g, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, this.f51338j);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f51335g, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        this.f51339k.clear();
        this.f51339k.put(m38448a(f51330b, fArr));
        this.f51339k.position(0);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, this.f51339k);
        GLES20.glDrawElements(4, this.f51341m.length, 5123, this.f51340l);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
    }

    /* renamed from: a */
    private float[] m38448a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[fArr.length];
        float[] fArr4 = new float[4];
        for (int i = 0; i < fArr.length; i += 2) {
            int i2 = i + 1;
            Matrix.multiplyMV(fArr4, 0, fArr2, 0, new float[]{fArr[i], fArr[i2], 0.0f, 1.0f}, 0);
            fArr3[i] = fArr4[0];
            fArr3[i2] = fArr[i2];
        }
        return fArr3;
    }

    /* renamed from: a */
    private int m38444a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* renamed from: a */
    private IntBuffer m38446a(int[] iArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(iArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        asIntBuffer.put(iArr);
        asIntBuffer.position(0);
        return asIntBuffer;
    }

    public FloatBuffer floatBufferUtil(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    /* renamed from: a */
    private ShortBuffer m38447a(short[] sArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        return asShortBuffer;
    }

    /* renamed from: a */
    private ByteBuffer m38445a(Byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.position(0);
        return allocateDirect;
    }
}
