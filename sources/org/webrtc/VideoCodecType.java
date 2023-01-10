package org.webrtc;

import p055case.C1273goto;

enum VideoCodecType {
    VP8(C1273goto.f62273new),
    VP9(C1273goto.f62272for),
    H264(C1273goto.f468do);
    
    private final String mimeType;

    private VideoCodecType(String str) {
        this.mimeType = str;
    }

    /* access modifiers changed from: package-private */
    public String mimeType() {
        return this.mimeType;
    }
}
