package com.didi.safety.god.util;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class CameraMatrix {

    /* renamed from: a */
    static float[] f37571a = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: b */
    static float[] f37572b = {0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: c */
    static float[] f37573c = {0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};

    /* renamed from: d */
    private static final int f37574d = 2;

    /* renamed from: e */
    private final String f37575e = "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition; gl_PointSize = 10.0;textureCoordinate = inputTextureCoordinate;}";

    /* renamed from: f */
    private final String f37576f = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}";

    /* renamed from: g */
    private final int f37577g;

    /* renamed from: h */
    private final int f37578h = 8;

    /* renamed from: i */
    private final int f37579i = (f37573c.length / 3);
    public boolean isDraw = false;

    /* renamed from: j */
    private FloatBuffer f37580j;

    /* renamed from: k */
    private FloatBuffer f37581k;

    /* renamed from: l */
    private ShortBuffer f37582l;

    /* renamed from: m */
    private short[] f37583m = {0, 1, 2, 0, 2, 3};

    /* renamed from: n */
    private int f37584n;

    public CameraMatrix(int i) {
        this.f37584n = i;
        this.f37580j = floatBufferUtil(f37571a);
        this.f37582l = m28290a(this.f37583m);
        this.f37581k = floatBufferUtil(f37572b);
        this.f37577g = GLES20.glCreateProgram();
        GLES20.glAttachShader(this.f37577g, m28287a(35633, "attribute vec4 vPosition;attribute vec2 inputTextureCoordinate;varying vec2 textureCoordinate;void main(){gl_Position = vPosition; gl_PointSize = 10.0;textureCoordinate = inputTextureCoordinate;}"));
        GLES20.glAttachShader(this.f37577g, m28287a(35632, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;varying vec2 textureCoordinate;\nuniform samplerExternalOES s_texture;\nvoid main() {  gl_FragColor = texture2D( s_texture, textureCoordinate );\n}"));
        GLES20.glLinkProgram(this.f37577g);
    }

    public void draw(float[] fArr) {
        GLES20.glUseProgram(this.f37577g);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f37584n);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f37577g, "vPosition");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 8, this.f37580j);
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.f37577g, "inputTextureCoordinate");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        this.f37581k.clear();
        this.f37581k.put(m28291a(f37572b, fArr));
        this.f37581k.position(0);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 8, this.f37581k);
        GLES20.glDrawElements(4, this.f37583m.length, 5123, this.f37582l);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation);
        GLES20.glDisableVertexAttribArray(glGetAttribLocation2);
    }

    /* renamed from: a */
    private float[] m28291a(float[] fArr, float[] fArr2) {
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
    private int m28287a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        return glCreateShader;
    }

    /* renamed from: a */
    private IntBuffer m28289a(int[] iArr) {
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
    private ShortBuffer m28290a(short[] sArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        return asShortBuffer;
    }

    /* renamed from: a */
    private ByteBuffer m28288a(Byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
        allocateDirect.position(0);
        return allocateDirect;
    }
}
