package com.jumio.jvision.jvcardfindjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class DetectionEngine {

    /* renamed from: a */
    public transient long f57885a;
    public transient boolean swigCMemOwn;

    public DetectionEngine(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57885a = j;
    }

    public static long getCPtr(DetectionEngine detectionEngine) {
        if (detectionEngine == null) {
            return 0;
        }
        return detectionEngine.f57885a;
    }

    public synchronized void delete() {
        long j = this.f57885a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_DetectionEngine(j);
            }
            this.f57885a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public DetectionResult processImage(ImageSource imageSource) {
        return new DetectionResult(JVCardFindJavaJNI.DetectionEngine_processImage(this.f57885a, this, ImageSource.getCPtr(imageSource), imageSource), true);
    }

    public void resetSession() {
        JVCardFindJavaJNI.DetectionEngine_resetSession(this.f57885a, this);
    }

    public DetectionEngine(DetectionSettings detectionSettings, DetectionInternalSettingsImpl detectionInternalSettingsImpl) {
        this(JVCardFindJavaJNI.new_DetectionEngine(DetectionSettings.getCPtr(detectionSettings), detectionSettings, DetectionInternalSettingsImpl.getCPtr(detectionInternalSettingsImpl), detectionInternalSettingsImpl), true);
    }
}
