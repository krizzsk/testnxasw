package com.jumio.ale.swig;

public class ALESettings {

    /* renamed from: a */
    public transient long f57355a;
    public transient boolean swigCMemOwn;

    public ALESettings(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57355a = j;
    }

    public static long getCPtr(ALESettings aLESettings) {
        if (aLESettings == null) {
            return 0;
        }
        return aLESettings.f57355a;
    }

    public synchronized void delete() {
        long j = this.f57355a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                aleEngineJNI.delete_ALESettings(j);
            }
            this.f57355a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public String getDirectory() {
        return aleEngineJNI.ALESettings_getDirectory(this.f57355a, this);
    }

    public String getKeyID() {
        return aleEngineJNI.ALESettings_getKeyID(this.f57355a, this);
    }

    public String getPublicKey() {
        return aleEngineJNI.ALESettings_getPublicKey(this.f57355a, this);
    }

    public void setDirectory(String str) {
        aleEngineJNI.ALESettings_setDirectory(this.f57355a, this, str);
    }

    public void setKeyID(String str) {
        aleEngineJNI.ALESettings_setKeyID(this.f57355a, this, str);
    }

    public void setPublicKey(String str) {
        aleEngineJNI.ALESettings_setPublicKey(this.f57355a, this, str);
    }

    public void swigDirectorDisconnect() {
        this.swigCMemOwn = false;
        delete();
    }

    public void swigReleaseOwnership() {
        this.swigCMemOwn = false;
        aleEngineJNI.ALESettings_change_ownership(this, this.f57355a, false);
    }

    public void swigTakeOwnership() {
        this.swigCMemOwn = true;
        aleEngineJNI.ALESettings_change_ownership(this, this.f57355a, true);
    }

    public ALESettings() {
        this(aleEngineJNI.new_ALESettings(), true);
        aleEngineJNI.ALESettings_director_connect(this, this.f57355a, true, true);
    }
}
