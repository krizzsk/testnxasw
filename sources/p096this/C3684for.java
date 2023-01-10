package p096this;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: this.for */
/* compiled from: RenderBuffer */
public class C3684for {

    /* renamed from: a */
    private int f8812a = 0;

    /* renamed from: b */
    private int f8813b = 0;

    /* renamed from: c */
    private int f8814c = 0;

    /* renamed from: d */
    private int f8815d;

    /* renamed from: e */
    private int f8816e;

    public C3684for(int i, int i2, int i3) {
        this.f8815d = i;
        this.f8816e = i2;
        int[] iArr = new int[1];
        GLES20.glActiveTexture(i3);
        this.f8812a = C3685if.m7494do();
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, ByteBuffer.allocateDirect(i * i2 * 4).order(ByteOrder.nativeOrder()).asIntBuffer());
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glGenFramebuffers(1, iArr, 0);
        int i4 = iArr[0];
        this.f8814c = i4;
        GLES20.glBindFramebuffer(36160, i4);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        int i5 = iArr[0];
        this.f8813b = i5;
        GLES20.glBindRenderbuffer(36161, i5);
        GLES20.glRenderbufferStorage(36161, 33189, i, i2);
        m46675case();
    }

    /* renamed from: case  reason: not valid java name */
    public void m46675case() {
        GLES20.glBindFramebuffer(36160, 0);
    }

    /* renamed from: do */
    public void mo43524do() {
        mo43526if();
        GLES20.glBindFramebuffer(36160, this.f8814c);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f8812a, 0);
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.f8813b);
    }

    /* renamed from: for  reason: not valid java name */
    public int m46676for() {
        return this.f8816e;
    }

    /* renamed from: if */
    public void mo43526if() {
        GLES20.glViewport(0, 0, this.f8815d, this.f8816e);
    }

    /* renamed from: new  reason: not valid java name */
    public int m46677new() {
        return this.f8812a;
    }

    /* renamed from: try  reason: not valid java name */
    public int m46678try() {
        return this.f8815d;
    }
}
