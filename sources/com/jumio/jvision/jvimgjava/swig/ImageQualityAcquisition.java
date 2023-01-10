package com.jumio.jvision.jvimgjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class ImageQualityAcquisition {

    /* renamed from: a */
    public transient long f57915a;
    public transient boolean swigCMemOwn;

    public ImageQualityAcquisition(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57915a = j;
    }

    public static float Evaluate(ImageSource imageSource) {
        return JVImgJavaJNI.ImageQualityAcquisition_Evaluate(ImageSource.getCPtr(imageSource), imageSource);
    }

    public static long getCPtr(ImageQualityAcquisition imageQualityAcquisition) {
        if (imageQualityAcquisition == null) {
            return 0;
        }
        return imageQualityAcquisition.f57915a;
    }

    public synchronized void delete() {
        if (this.f57915a != 0) {
            if (!this.swigCMemOwn) {
                this.f57915a = 0;
            } else {
                this.swigCMemOwn = false;
                throw new UnsupportedOperationException("C++ destructor does not have public access");
            }
        }
    }
}
