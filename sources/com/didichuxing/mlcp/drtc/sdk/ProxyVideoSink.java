package com.didichuxing.mlcp.drtc.sdk;

import com.didichuxing.mlcp.drtc.interfaces.C16689d;
import org.webrtc.VideoFrame;
import org.webrtc.VideoSink;

public class ProxyVideoSink implements VideoSink {

    /* renamed from: a */
    private VideoSink f50965a;

    /* renamed from: b */
    private C16689d f50966b;

    public synchronized void onFrame(VideoFrame videoFrame) {
        VideoSink videoSink = this.f50965a;
        if (videoSink != null) {
            videoSink.onFrame(videoFrame);
        }
        C16689d dVar = this.f50966b;
        if (dVar != null) {
            dVar.mo125458a(videoFrame);
        }
    }

    public synchronized void setListener(C16689d dVar) {
        this.f50966b = dVar;
    }

    public synchronized void setTarget(VideoSink videoSink) {
        this.f50965a = videoSink;
    }
}
