package com.jumio.jvision.jvcardfindjava.swig;

public class DetectionInternalSettings {

    /* renamed from: a */
    public transient long f57886a;

    /* renamed from: b */
    public transient boolean f57887b;

    public DetectionInternalSettings(long j, boolean z) {
        this.f57887b = z;
        this.f57886a = j;
    }

    public static long getCPtr(DetectionInternalSettings detectionInternalSettings) {
        if (detectionInternalSettings == null) {
            return 0;
        }
        return detectionInternalSettings.f57886a;
    }

    public synchronized void delete() {
        long j = this.f57886a;
        if (j != 0) {
            if (this.f57887b) {
                this.f57887b = false;
                JVCardFindJavaJNI.delete_DetectionInternalSettings(j);
            }
            this.f57886a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public DetectionInternalSettings() {
        this(JVCardFindJavaJNI.new_DetectionInternalSettings(), true);
    }
}
