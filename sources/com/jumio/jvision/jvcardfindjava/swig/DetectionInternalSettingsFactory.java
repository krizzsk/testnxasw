package com.jumio.jvision.jvcardfindjava.swig;

public class DetectionInternalSettingsFactory {

    /* renamed from: a */
    public transient long f57888a;
    public transient boolean swigCMemOwn;

    public DetectionInternalSettingsFactory(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57888a = j;
    }

    public static DetectionInternalSettingsImpl createFromFileSystem(String str) {
        long DetectionInternalSettingsFactory_createFromFileSystem = JVCardFindJavaJNI.DetectionInternalSettingsFactory_createFromFileSystem(str);
        if (DetectionInternalSettingsFactory_createFromFileSystem == 0) {
            return null;
        }
        return new DetectionInternalSettingsImpl(DetectionInternalSettingsFactory_createFromFileSystem, true);
    }

    public static long getCPtr(DetectionInternalSettingsFactory detectionInternalSettingsFactory) {
        if (detectionInternalSettingsFactory == null) {
            return 0;
        }
        return detectionInternalSettingsFactory.f57888a;
    }

    public synchronized void delete() {
        long j = this.f57888a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_DetectionInternalSettingsFactory(j);
            }
            this.f57888a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public DetectionInternalSettingsFactory() {
        this(JVCardFindJavaJNI.new_DetectionInternalSettingsFactory(), true);
    }
}
