package com.didichuxing.mlcp.drtc.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import org.webrtc.GlRectDrawer;
import org.webrtc.GlTextureFrameBuffer;
import org.webrtc.GlUtil;
import org.webrtc.RendererCommon;
import org.webrtc.VideoFrame;
import org.webrtc.VideoFrameDrawer;

/* renamed from: com.didichuxing.mlcp.drtc.utils.a */
/* compiled from: BitMapUtil */
public class C16715a {

    /* renamed from: a */
    private static final VideoFrameDrawer f51012a = new VideoFrameDrawer();

    /* renamed from: b */
    private static RendererCommon.GlDrawer f51013b = new GlRectDrawer();

    /* renamed from: c */
    private static final Matrix f51014c = new Matrix();

    /* renamed from: d */
    private static final GlTextureFrameBuffer f51015d = new GlTextureFrameBuffer(6408);

    /* renamed from: a */
    public static Bitmap m38160a(VideoFrame videoFrame) {
        f51014c.reset();
        f51014c.preTranslate(0.5f, 0.5f);
        f51014c.preScale(1.0f, -1.0f);
        f51014c.preTranslate(-0.5f, -0.5f);
        int rotatedWidth = videoFrame.getRotatedWidth() * 1;
        int rotatedHeight = videoFrame.getRotatedHeight() * 1;
        f51015d.setSize(rotatedWidth, rotatedHeight);
        GLES20.glBindFramebuffer(36160, f51015d.getFrameBufferId());
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, f51015d.getTextureId(), 0);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        f51012a.drawFrame(videoFrame, f51013b, f51014c, 0, 0, rotatedWidth, rotatedHeight);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(rotatedWidth * rotatedHeight * 4);
        GLES20.glViewport(0, 0, rotatedWidth, rotatedHeight);
        GLES20.glReadPixels(0, 0, rotatedWidth, rotatedHeight, 6408, 5121, allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        GlUtil.checkNoGLES2Error("EglRenderer.notifyCallbacks");
        Bitmap createBitmap = Bitmap.createBitmap(rotatedWidth, rotatedHeight, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        return createBitmap;
    }
}
