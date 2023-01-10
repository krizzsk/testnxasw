package com.jumio.ale.swig;

public class ALECore {

    /* renamed from: a */
    public transient long f57340a;
    public transient boolean swigCMemOwn;

    public ALECore(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57340a = j;
    }

    public static long getCPtr(ALECore aLECore) {
        if (aLECore == null) {
            return 0;
        }
        return aLECore.f57340a;
    }

    public ALERequest createRequest() throws Exception {
        long ALECore_createRequest = aleEngineJNI.ALECore_createRequest(this.f57340a, this);
        if (ALECore_createRequest == 0) {
            return null;
        }
        return new ALERequest(ALECore_createRequest, false);
    }

    public synchronized void delete() {
        long j = this.f57340a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALECore(j);
            }
            this.f57340a = 0;
        }
    }

    public void destroyRequest(ALERequest aLERequest) {
        aleEngineJNI.ALECore_destroyRequest(this.f57340a, this, ALERequest.getCPtr(aLERequest), aLERequest);
    }

    public void finalize() {
        delete();
    }

    public ALECore(ALESettings aLESettings) {
        this(aleEngineJNI.new_ALECore(ALESettings.getCPtr(aLESettings), aLESettings), true);
    }
}
