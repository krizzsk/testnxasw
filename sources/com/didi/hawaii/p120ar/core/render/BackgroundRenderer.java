package com.didi.hawaii.p120ar.core.render;

import android.content.Context;
import android.opengl.GLES20;
import com.didi.hawaii.p120ar.utils.ShaderUtil;
import com.google.p223ar.core.Coordinates2d;
import com.google.p223ar.core.Frame;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.didi.hawaii.ar.core.render.BackgroundRenderer */
public class BackgroundRenderer {

    /* renamed from: a */
    private static final String f25335a = BackgroundRenderer.class.getSimpleName();

    /* renamed from: b */
    private static final String f25336b = "shaders/screenquad.vert";

    /* renamed from: c */
    private static final String f25337c = "shaders/screenquad.frag";

    /* renamed from: d */
    private static final int f25338d = 2;

    /* renamed from: e */
    private static final int f25339e = 2;

    /* renamed from: f */
    private static final int f25340f = 4;

    /* renamed from: m */
    private static final float[] f25341m = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: g */
    private FloatBuffer f25342g;

    /* renamed from: h */
    private FloatBuffer f25343h;

    /* renamed from: i */
    private int f25344i;

    /* renamed from: j */
    private int f25345j;

    /* renamed from: k */
    private int f25346k;

    /* renamed from: l */
    private int f25347l = -1;

    public int getTextureId() {
        return this.f25347l;
    }

    public void createOnGlThread(Context context) throws IOException {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.f25347l = i;
        GLES20.glBindTexture(36197, i);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        float[] fArr = f25341m;
        if (4 == fArr.length / 2) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            this.f25342g = asFloatBuffer;
            asFloatBuffer.put(f25341m);
            this.f25342g.position(0);
            ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
            allocateDirect2.order(ByteOrder.nativeOrder());
            this.f25343h = allocateDirect2.asFloatBuffer();
            int loadGLShader = ShaderUtil.loadGLShader(f25335a, context, 35633, f25336b);
            int loadGLShader2 = ShaderUtil.loadGLShader(f25335a, context, 35632, f25337c);
            int glCreateProgram = GLES20.glCreateProgram();
            this.f25344i = glCreateProgram;
            GLES20.glAttachShader(glCreateProgram, loadGLShader);
            GLES20.glAttachShader(this.f25344i, loadGLShader2);
            GLES20.glLinkProgram(this.f25344i);
            GLES20.glUseProgram(this.f25344i);
            ShaderUtil.checkGLError(f25335a, "Program creation");
            this.f25345j = GLES20.glGetAttribLocation(this.f25344i, "a_Position");
            this.f25346k = GLES20.glGetAttribLocation(this.f25344i, "a_TexCoord");
            ShaderUtil.checkGLError(f25335a, "Program parameters");
            return;
        }
        throw new RuntimeException("Unexpected number of vertices in BackgroundRenderer.");
    }

    public void draw(Frame frame) {
        if (frame.hasDisplayGeometryChanged()) {
            frame.transformCoordinates2d(Coordinates2d.OPENGL_NORMALIZED_DEVICE_COORDINATES, this.f25342g, Coordinates2d.TEXTURE_NORMALIZED, this.f25343h);
        }
        if (frame.getTimestamp() != 0) {
            m20260a();
        }
    }

    public void draw(int i, int i2, float f, int i3) {
        float f2;
        float f3;
        float[] fArr;
        float f4 = (float) i;
        float f5 = (float) i2;
        if (f < f4 / f5) {
            f2 = f * f5;
            f3 = f5;
        } else {
            f3 = f4 / f;
            f2 = f4;
        }
        float f6 = ((f4 - f2) / f4) * 0.5f;
        float f7 = ((f5 - f3) / f5) * 0.5f;
        if (i3 == 0) {
            float f8 = 1.0f - f7;
            float f9 = 1.0f - f6;
            fArr = new float[]{f6, f8, f6, f7, f9, f8, f9, f7};
        } else if (i3 == 90) {
            float f10 = 1.0f - f6;
            float f11 = 1.0f - f7;
            fArr = new float[]{f10, f11, f6, f11, f10, f7, f6, f7};
        } else if (i3 == 180) {
            float f12 = 1.0f - f6;
            float f13 = 1.0f - f7;
            fArr = new float[]{f12, f7, f12, f13, f6, f7, f6, f13};
        } else if (i3 == 270) {
            float f14 = 1.0f - f6;
            float f15 = 1.0f - f7;
            fArr = new float[]{f6, f7, f14, f7, f6, f15, f14, f15};
        } else {
            throw new IllegalArgumentException("Unhandled rotation: " + i3);
        }
        this.f25343h.position(0);
        this.f25343h.put(fArr);
        m20260a();
    }

    /* renamed from: a */
    private void m20260a() {
        this.f25343h.position(0);
        GLES20.glDisable(2929);
        GLES20.glDepthMask(false);
        GLES20.glBindTexture(36197, this.f25347l);
        GLES20.glUseProgram(this.f25344i);
        GLES20.glVertexAttribPointer(this.f25345j, 2, 5126, false, 0, this.f25342g);
        GLES20.glVertexAttribPointer(this.f25346k, 2, 5126, false, 0, this.f25343h);
        GLES20.glEnableVertexAttribArray(this.f25345j);
        GLES20.glEnableVertexAttribArray(this.f25346k);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f25345j);
        GLES20.glDisableVertexAttribArray(this.f25346k);
        GLES20.glDepthMask(true);
        GLES20.glEnable(2929);
        ShaderUtil.checkGLError(f25335a, "BackgroundRendererDraw");
    }
}
