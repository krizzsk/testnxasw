package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.ResultPoint;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.DetectorResult;
import com.didi.dqr.common.MultiDetectorResult;
import com.didi.dqr.qrcode.detector.Detector;
import com.didi.dqr.qrcode.detector.FinderPattern;
import com.didi.dqr.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.opencv.core.Point;

public class AutoCompleDetector extends Detector {

    /* renamed from: a */
    private Decoder f20886a = new Decoder();

    public AutoCompleDetector(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    public MultiDetectorResult decode(DetectorResult detectorResult, Map<DecodeHintType, ?> map) throws Exception {
        if (detectorResult.getPoints().length >= 2) {
            ArrayList arrayList = new ArrayList();
            for (ResultPoint resultPoint : detectorResult.getPoints()) {
                if (resultPoint instanceof FinderPattern) {
                    arrayList.add((FinderPattern) resultPoint);
                }
            }
            if (arrayList.size() >= 2) {
                Point[] possiblePoints = getPossiblePoints(new Point[]{new Point((double) ((FinderPattern) arrayList.get(0)).getX(), (double) ((FinderPattern) arrayList.get(0)).getY()), new Point((double) ((FinderPattern) arrayList.get(1)).getX(), (double) ((FinderPattern) arrayList.get(1)).getY())});
                MultiDetectorResult multiDetectorResult = new MultiDetectorResult();
                multiDetectorResult.fromAutoCompete = true;
                for (Point point : possiblePoints) {
                    try {
                        FinderPattern[] a = m17633a((List<FinderPattern>) arrayList, new FinderPattern((float) point.f8521x, (float) point.f8522y, ((FinderPattern) arrayList.get(0)).getEstimatedModuleSize()));
                        ResultPoint.orderBestPatterns(a);
                        multiDetectorResult.addDetectorResult(processFinderPatternInfo(new FinderPatternInfo(a)));
                    } catch (Exception unused) {
                    }
                }
                return multiDetectorResult;
            }
            throw new IllegalArgumentException("Pattern not match");
        }
        throw new IllegalArgumentException("Pattern not match");
    }

    /* renamed from: a */
    private DecoderResult m17631a(FinderPattern[] finderPatternArr) throws Exception {
        ResultPoint.orderBestPatterns(finderPatternArr);
        return this.f20886a.decode(processFinderPatternInfo(new FinderPatternInfo(finderPatternArr)).getBits());
    }

    /* renamed from: a */
    private static FinderPattern[] m17633a(List<FinderPattern> list, FinderPattern finderPattern) {
        FinderPattern[] finderPatternArr = {list.get(0), list.get(1), finderPattern};
        ResultPoint.orderBestPatterns(finderPatternArr);
        return finderPatternArr;
    }

    /* renamed from: a */
    private static float m17630a(List<FinderPattern> list) {
        float y = list.get(1).getY() - list.get(0).getY();
        float x = list.get(1).getX() - list.get(0).getX();
        if (x == 0.0f) {
            return 2.14748365E9f;
        }
        return y / x;
    }

    public static Point[] getPossiblePoints(Point[] pointArr) {
        double sqrt = Math.sqrt(Math.pow(pointArr[1].f8522y - pointArr[0].f8522y, 2.0d) + Math.pow(pointArr[1].f8521x - pointArr[0].f8521x, 2.0d));
        double atan2 = Math.atan2(pointArr[1].f8522y - pointArr[0].f8522y, pointArr[1].f8521x - pointArr[0].f8521x);
        Point a = m17632a(sqrt, atan2 - 1.5707963267948966d);
        Point point = new Point(a.f8521x + pointArr[0].f8521x, a.f8522y + pointArr[0].f8522y);
        double d = sqrt;
        Point point2 = new Point((-a.f8521x) + pointArr[0].f8521x, (-a.f8522y) + pointArr[0].f8522y);
        Point point3 = new Point((point.f8521x + pointArr[1].f8521x) - pointArr[0].f8521x, (point.f8522y + pointArr[1].f8522y) - pointArr[0].f8522y);
        Point point4 = new Point((point2.f8521x + pointArr[1].f8521x) - pointArr[0].f8521x, (point2.f8522y + pointArr[1].f8522y) - pointArr[0].f8522y);
        Point a2 = m17632a(d / Math.sqrt(2.0d), atan2 - 0.7853981633974483d);
        return new Point[]{point, point2, point3, point4, new Point(a2.f8521x + pointArr[0].f8521x, a2.f8522y + pointArr[0].f8522y), new Point(pointArr[1].f8521x - a2.f8521x, pointArr[1].f8522y - a2.f8522y)};
    }

    /* renamed from: a */
    private static Point m17632a(double d, double d2) {
        return new Point((double) ((int) (Math.cos(d2) * d)), (double) ((int) (d * Math.sin(d2))));
    }
}
