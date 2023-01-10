package com.jumio.jvision.jvcardfindjava.swig;

public class CardDetectorConfiguration {

    /* renamed from: a */
    public transient long f57884a;
    public transient boolean swigCMemOwn;

    public CardDetectorConfiguration(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57884a = j;
    }

    public static long getCPtr(CardDetectorConfiguration cardDetectorConfiguration) {
        if (cardDetectorConfiguration == null) {
            return 0;
        }
        return cardDetectorConfiguration.f57884a;
    }

    public synchronized void delete() {
        long j = this.f57884a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_CardDetectorConfiguration(j);
            }
            this.f57884a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public CardDetectorConfiguration() {
        this(JVCardFindJavaJNI.new_CardDetectorConfiguration(), true);
    }
}
