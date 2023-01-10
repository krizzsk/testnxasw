package com.jumio.jvision.jvimgjava.swig;

import com.jumio.jvision.jvcorejava.swig.ImageSource;

public class ImageCheck {

    /* renamed from: a */
    public transient long f57914a;
    public transient boolean swigCMemOwn;

    public ImageCheck(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57914a = j;
    }

    public static float computeFlashConfidence(ImageSource imageSource) {
        return JVImgJavaJNI.ImageCheck_computeFlashConfidence(ImageSource.getCPtr(imageSource), imageSource);
    }

    public static long getCPtr(ImageCheck imageCheck) {
        if (imageCheck == null) {
            return 0;
        }
        return imageCheck.f57914a;
    }

    public static boolean isFlashNeeded(ImageSource imageSource, int i) {
        return JVImgJavaJNI.ImageCheck_isFlashNeeded(ImageSource.getCPtr(imageSource), imageSource, i);
    }

    public static boolean isRefocusNeeded(ImageSource imageSource, int i) {
        return JVImgJavaJNI.ImageCheck_isRefocusNeeded(ImageSource.getCPtr(imageSource), imageSource, i);
    }

    public synchronized void delete() {
        long j = this.f57914a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVImgJavaJNI.delete_ImageCheck(j);
            }
            this.f57914a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public ImageCheck() {
        this(JVImgJavaJNI.new_ImageCheck(), true);
    }
}
