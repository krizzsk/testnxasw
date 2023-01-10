package com.didichuxing.dfbasesdk.utils;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class CameraMatrix {

    /* renamed from: a */
    static float[] f49355a = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: b */
    static float[] f49356b = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: c */
    static float[] f49357c = {0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: d */
    private static final int f49358d = 2;

    /* renamed from: e */
    private final String f49359e = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition; gl_PointSize = 10.0;textureCoordinate = inputTextureCoordinate;}";

    /* renamed from: f */
    private final String f49360f = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";

    /* renamed from: g */
    private final int f49361g;

    /* renamed from: h */
    private final int f49362h = 8;

    /* renamed from: i */
    private final int f49363i = (f49357c.length / 3);
    public boolean isDraw = false;

    /* renamed from: j */
    private FloatBuffer f49364j;

    /* renamed from: k */
    private FloatBuffer f49365k;

    /* renamed from: l */
    private ShortBuffer f49366l;

    /* renamed from: m */
    private short[] f49367m = {0, 1, 2, 0, 2, 3};

    /* renamed from: n */
    private int f49368n;

    public CameraMatrix(int i) {
        this.f49368n = i;
        this.f49364j = floatBufferUtil(f49355a);
        this.f49366l = m37030a(this.f49367m);
        this.f49365k = floatBufferUtil(f49356b);
        this.f49361g = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f49361g, m37027a(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition; gl_PointSize = 10.0;textureCoordinate = inputTextureCoordinate;}"));
        GLES20.glAttachShader(this.f49361g, m37027a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}"));
        GLES20.glLinkProgram(this.f49361g);
    }

    public void draw(float[] fArr) {
        GLES20.glUseProgram(this.f49361g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f49368n);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f49361g, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, this.f49364j);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f49361g, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        this.f49365k.clear();
        this.f49365k.put(m37031a(f49356b, fArr));
        this.f49365k.position(0);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, this.f49365k);
        GLES20.glDrawElements(4, this.f49367m.length, 5123, this.f49366l);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
    }

    /* renamed from: a */
    private float[] m37031a(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[fArr.length];
        float[] fArr4 = new float[4];
        for (int i = 0; i < fArr.length; i += 2) {
            int i2 = i + 1;
            Matrix.multiplyMV(fArr4, 0, fArr2, 0, new float[]{fArr[i], fArr[i2], 0.0f, 1.0f}, 0);
            fArr3[i] = fArr4[1];
            fArr3[i2] = fArr4[0];
        }
        return fArr3;
    }

    /* renamed from: a */
    private int m37027a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* renamed from: a */
    private IntBuffer m37029a(int[] iArr) {
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
    private ShortBuffer m37030a(short[] sArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        return asShortBuffer;
    }

    /* renamed from: a */
    private ByteBuffer m37028a(Byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.position(0);
        return allocateDirect;
    }
}
