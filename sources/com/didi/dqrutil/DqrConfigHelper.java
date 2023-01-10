package com.didi.dqrutil;

import com.didi.dqr.qrcode.detector.BestPatternMethodEnum;

public class DqrConfigHelper {

    /* renamed from: a */
    private DqrDecodeConfig f20982a;

    public static int useNativeDecodeRate() {
        return 0;
    }

    private static class InstanceHolder {
        public static DqrConfigHelper instance = new DqrConfigHelper();

        private InstanceHolder() {
        }
    }

    private DqrConfigHelper() {
    }

    public static void init(DqrDecodeConfig dqrDecodeConfig) {
        InstanceHolder.instance.f20982a = dqrDecodeConfig;
    }

    public static boolean useContourFinder() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.useContourFinder();
        }
        return false;
    }

    public static boolean useDynamicCVBlocksize() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.useDynamicCVBlocksize();
        }
        return true;
    }

    public static int contourDilateCount() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.contourDilateCount();
        }
        return 1;
    }

    public static int opencvBlockBulking() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.opencvBlockBulking();
        }
        return 1;
    }

    public static BestPatternMethodEnum findBestPatternType() {
        int findBestPatternType;
        if (InstanceHolder.instance.f20982a == null || (findBestPatternType = InstanceHolder.instance.f20982a.findBestPatternType()) < 0 || findBestPatternType >= BestPatternMethodEnum.values().length) {
            return BestPatternMethodEnum.TYPE_MIX;
        }
        return BestPatternMethodEnum.values()[findBestPatternType];
    }

    public static boolean usePatternAutoComple() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.usePatternAutoComple();
        }
        return true;
    }

    public static boolean usePatternCorrect() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.usePatternCorrect();
        }
        return false;
    }

    public static float patternCorrectLimit() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.patternCorrectLimit();
        }
        return 10.0f;
    }

    public static int newFinderRate() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.newFinderRate();
        }
        return 10;
    }

    public static int contourFinderRate() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.contourFinderRate();
        }
        return 15;
    }

    public static int patternCorrectRate() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.patternCorrectRate();
        }
        return 0;
    }

    public static boolean caculateIncline() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.caculateIncline();
        }
        return true;
    }

    public static float patternTolerant() {
        if (InstanceHolder.instance.f20982a == null) {
            return 0.4f;
        }
        float patternTolerant = InstanceHolder.instance.f20982a.patternTolerant();
        if (patternTolerant > 0.0f) {
            return patternTolerant;
        }
        return 0.4f;
    }

    public static int patternMinValidCount() {
        int patternMinValidCount;
        if (InstanceHolder.instance.f20982a == null || (patternMinValidCount = InstanceHolder.instance.f20982a.patternMinValidCount()) <= 0) {
            return 3;
        }
        return patternMinValidCount;
    }

    public static float cvBlockSizeFact() {
        if (InstanceHolder.instance.f20982a == null) {
            return 1.0f;
        }
        float cvBlockSizeFact = InstanceHolder.instance.f20982a.cvBlockSizeFact();
        if (cvBlockSizeFact > 0.0f) {
            return cvBlockSizeFact;
        }
        return 1.0f;
    }

    public static int binarizerType() {
        if (InstanceHolder.instance.f20982a == null) {
            return 3;
        }
        int binarizerType = InstanceHolder.instance.f20982a.binarizerType();
        if (binarizerType > 0) {
            return binarizerType;
        }
        return 4;
    }

    public static boolean analysisDqr() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.analysisDqr();
        }
        return false;
    }

    public static boolean cropRect() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.cropRect();
        }
        return false;
    }

    public static int cropRedundancy() {
        if (InstanceHolder.instance.f20982a == null) {
            return 20;
        }
        int cropRedundancy = InstanceHolder.instance.f20982a.cropRedundancy();
        if (cropRedundancy > 0) {
            return cropRedundancy;
        }
        return 4;
    }

    public static boolean useFilter() {
        if (InstanceHolder.instance.f20982a != null) {
            return InstanceHolder.instance.f20982a.useFilter();
        }
        return false;
    }
}
