package com.jumio.jvision.jvcardfindjava.swig;

public class DetectionResult {

    /* renamed from: a */
    public transient long f57891a;
    public transient boolean swigCMemOwn;

    public DetectionResult(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57891a = j;
    }

    public static long getCPtr(DetectionResult detectionResult) {
        if (detectionResult == null) {
            return 0;
        }
        return detectionResult.f57891a;
    }

    public synchronized void delete() {
        long j = this.f57891a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCardFindJavaJNI.delete_DetectionResult(j);
            }
            this.f57891a = 0;
        }
    }

    public void finalize() {
        delete();
    }

    public int getCardImageQualityScore() {
        return JVCardFindJavaJNI.DetectionResult_getCardImageQualityScore(this.f57891a, this);
    }

    public IntQuadrangle getCardQuadrangle() {
        return new IntQuadrangle(JVCardFindJavaJNI.DetectionResult_getCardQuadrangle(this.f57891a, this), true);
    }

    public IntPoint getExposurePointOfInterest() {
        return new IntPoint(JVCardFindJavaJNI.DetectionResult_getExposurePointOfInterest(this.f57891a, this), true);
    }

    public boolean getFlashTurnOn() {
        return JVCardFindJavaJNI.DetectionResult_getFlashTurnOn(this.f57891a, this);
    }

    public IntPoint getFocusPointOfInterest() {
        return new IntPoint(JVCardFindJavaJNI.DetectionResult_getFocusPointOfInterest(this.f57891a, this), true);
    }

    public boolean hasBottomOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasBottomOfCard(this.f57891a, this);
    }

    public boolean hasLeftOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasLeftOfCard(this.f57891a, this);
    }

    public boolean hasRightOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasRightOfCard(this.f57891a, this);
    }

    public boolean hasTopOfCard() {
        return JVCardFindJavaJNI.DetectionResult_hasTopOfCard(this.f57891a, this);
    }

    public boolean isCardImageOfGoodQuality() {
        return JVCardFindJavaJNI.DetectionResult_isCardImageOfGoodQuality(this.f57891a, this);
    }

    public boolean isCardInRoi() {
        return JVCardFindJavaJNI.DetectionResult_isCardInRoi(this.f57891a, this);
    }

    public DetectionResult() {
        this(JVCardFindJavaJNI.new_DetectionResult__SWIG_0(), true);
    }

    public DetectionResult(boolean z, boolean z2, int i, boolean z3, boolean z4, boolean z5, boolean z6, IntPoint intPoint, IntPoint intPoint2, boolean z7, IntQuadrangle intQuadrangle) {
        this(JVCardFindJavaJNI.new_DetectionResult__SWIG_1(z, z2, i, z3, z4, z5, z6, IntPoint.getCPtr(intPoint), intPoint, IntPoint.getCPtr(intPoint2), intPoint2, z7, IntQuadrangle.getCPtr(intQuadrangle), intQuadrangle), true);
    }
}
