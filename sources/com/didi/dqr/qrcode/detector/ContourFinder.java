package com.didi.dqr.qrcode.detector;

import com.didi.dqr.OpenCVBinarizer;
import com.didi.dqr.common.BitMatrix;
import com.didi.dqrutil.DqrConfigHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.RotatedRect;
import org.opencv.imgproc.Imgproc;

public class ContourFinder {

    /* renamed from: a */
    private static final int f20912a = DqrConfigHelper.contourFinderRate();

    /* renamed from: b */
    private static final String f20913b = "ContourFinder";

    /* renamed from: c */
    private float[] f20914c;
    public int contourDilateCount;

    /* renamed from: d */
    private FinderPattern f20915d;

    /* renamed from: e */
    private List<FinderPattern> f20916e;
    public int realContourDilateCount;

    public List<FinderPattern> getBestCenter(List<FinderPattern> list, BitMatrix bitMatrix) {
        List<FinderPattern> list2 = list;
        if (list2 == null || list.size() == 0 || OpenCVBinarizer.isLoadLibraryError() || f20912a == 0 || Detector.detectCount % f20912a != 0) {
            return list2;
        }
        this.f20916e = list2;
        for (FinderPattern next : list) {
            if (this.f20915d == null) {
                this.f20915d = next;
            } else if (next.getCount() > this.f20915d.getCount()) {
                this.f20915d = next;
            }
        }
        float estimatedModuleSize = this.f20915d.getEstimatedModuleSize();
        Iterator<FinderPattern> it = list.iterator();
        while (it.hasNext()) {
            FinderPattern next2 = it.next();
            if (next2.getEstimatedModuleSize() > m17667a(estimatedModuleSize)[1] / 7.0f || next2.getEstimatedModuleSize() < m17667a(estimatedModuleSize)[0] / 7.0f) {
                it.remove();
            }
        }
        Mat mat = new Mat(bitMatrix.getHeight() + (bitMatrix.getHeight() / 2), bitMatrix.getWidth(), CvType.CV_8UC1);
        mat.put(0, 0, bitMatrix.getSource());
        long currentTimeMillis = System.currentTimeMillis();
        Imgproc.cvtColor(mat, mat, 106);
        Imgproc.adaptiveThreshold(mat, mat, 255.0d, 0, 0, m17664a(), 1.0d);
        int contourDilateCount2 = DqrConfigHelper.contourDilateCount();
        this.contourDilateCount = contourDilateCount2;
        if (contourDilateCount2 < 0) {
            contourDilateCount2 = new Random().nextInt(5) + 1;
        }
        this.realContourDilateCount = contourDilateCount2;
        while (contourDilateCount2 > 0) {
            Imgproc.dilate(mat, mat, new Mat());
            contourDilateCount2--;
        }
        System.out.println("findContours cost  == " + (System.currentTimeMillis() - currentTimeMillis));
        ArrayList arrayList = new ArrayList();
        ArrayList<RotatedRect> arrayList2 = new ArrayList<>();
        Imgproc.findContours(mat, arrayList, mat, 3, 2);
        for (int i = 0; i < arrayList.size(); i++) {
            RotatedRect minAreaRect = Imgproc.minAreaRect(new MatOfPoint2f(((MatOfPoint) arrayList.get(i)).toArray()));
            if (minAreaRect.size.width > ((double) m17667a(estimatedModuleSize)[0]) && minAreaRect.size.height > ((double) m17667a(estimatedModuleSize)[0]) && minAreaRect.size.width < ((double) m17667a(estimatedModuleSize)[1]) && minAreaRect.size.height < ((double) m17667a(estimatedModuleSize)[1])) {
                System.out.println("ContourFindersize = " + minAreaRect.size.width + " x " + minAreaRect.size.height + "  " + minAreaRect.center.f8521x + " " + minAreaRect.center.f8522y);
                arrayList2.add(minAreaRect);
            }
        }
        System.out.println("findContours cost2  == " + (System.currentTimeMillis() - currentTimeMillis) + " " + arrayList.size());
        mat.release();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(list2);
        for (RotatedRect rotatedRect : arrayList2) {
            m17666a((List<FinderPattern>) arrayList3, new FinderPattern((float) rotatedRect.center.f8521x, (float) rotatedRect.center.f8522y, estimatedModuleSize));
        }
        return m17665a((List<FinderPattern>) arrayList3);
    }

    /* renamed from: a */
    private float[] m17667a(float f) {
        if (this.f20914c == null) {
            float[] fArr = new float[2];
            this.f20914c = fArr;
            fArr[0] = 0.8f * f * 7.0f;
            fArr[1] = f * 1.2f * 7.0f;
        }
        return this.f20914c;
    }

    /* renamed from: a */
    private void m17666a(List<FinderPattern> list, FinderPattern finderPattern) {
        FinderPattern finderPattern2;
        Iterator<FinderPattern> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                finderPattern2 = null;
                break;
            }
            finderPattern2 = it.next();
            if (Math.abs(finderPattern2.getY() - finderPattern.getY()) < finderPattern2.getEstimatedModuleSize() / 2.0f && Math.abs(finderPattern2.getX() - finderPattern.getX()) < finderPattern2.getEstimatedModuleSize() / 2.0f) {
                if (this.f20916e.contains(finderPattern2) || finderPattern2.getEstimatedModuleSize() >= finderPattern.getEstimatedModuleSize()) {
                    return;
                }
            }
        }
        if (finderPattern2 != null) {
            list.remove(finderPattern2);
        }
        list.add(finderPattern);
    }

    /* renamed from: a */
    private int m17664a() {
        if (OpenCVBinarizer.blockSize == 0) {
            OpenCVBinarizer.blockSize = 31;
        }
        return OpenCVBinarizer.blockSize;
    }

    /* renamed from: a */
    private List<FinderPattern> m17665a(List<FinderPattern> list) {
        PointMatchData pointMatchData = null;
        if (this.f20916e.size() == 1) {
            for (int i = 0; i < list.size(); i++) {
                if (!this.f20916e.contains(list.get(i))) {
                    for (int i2 = i + 1; i2 < list.size(); i2++) {
                        if (!this.f20916e.contains(list.get(i2))) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.addAll(this.f20916e);
                            arrayList.add(list.get(i));
                            arrayList.add(list.get(i2));
                            PointMatchData b = m17668b(arrayList);
                            if (b.isBetterThan(pointMatchData)) {
                                pointMatchData = b;
                            }
                        }
                    }
                }
            }
        } else if (this.f20916e.size() == 2) {
            for (FinderPattern next : list) {
                if (!this.f20916e.contains(next)) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(this.f20916e);
                    arrayList2.add(next);
                    PointMatchData b2 = m17668b(arrayList2);
                    if (b2.isBetterThan(pointMatchData)) {
                        pointMatchData = b2;
                    }
                }
            }
        }
        return pointMatchData != null ? pointMatchData.outPatterns : list;
    }

    /* renamed from: b */
    private PointMatchData m17668b(List<FinderPattern> list) {
        float a = m17663a(list.get(0), list.get(1));
        float a2 = m17663a(list.get(1), list.get(2));
        float a3 = m17663a(list.get(2), list.get(0));
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(a));
        arrayList.add(Float.valueOf(a2));
        arrayList.add(Float.valueOf(a3));
        Collections.sort(arrayList);
        float floatValue = (((((((Float) arrayList.get(0)).floatValue() * ((Float) arrayList.get(0)).floatValue()) + (((Float) arrayList.get(1)).floatValue() * ((Float) arrayList.get(1)).floatValue())) - (((Float) arrayList.get(2)).floatValue() * ((Float) arrayList.get(2)).floatValue())) / 2.0f) / ((Float) arrayList.get(0)).floatValue()) / ((Float) arrayList.get(1)).floatValue();
        PointMatchData pointMatchData = new PointMatchData();
        pointMatchData.angle = (float) Math.acos((double) floatValue);
        pointMatchData.lengthDif = ((Float) arrayList.get(1)).floatValue() / ((Float) arrayList.get(0)).floatValue();
        pointMatchData.outPatterns = list;
        return pointMatchData;
    }

    /* renamed from: a */
    private float m17663a(FinderPattern finderPattern, FinderPattern finderPattern2) {
        return (float) Math.sqrt(Math.pow((double) (finderPattern.getX() - finderPattern2.getX()), 2.0d) + Math.pow((double) (finderPattern.getY() - finderPattern2.getY()), 2.0d));
    }

    class PointMatchData {
        float angle;
        float lengthDif;
        List<FinderPattern> outPatterns;

        PointMatchData() {
        }

        /* access modifiers changed from: package-private */
        public float getDif() {
            return this.lengthDif + ((float) Math.abs((((double) this.angle) - 1.5707963267948966d) / 1.5707963267948966d));
        }

        /* access modifiers changed from: package-private */
        public boolean isBetterThan(PointMatchData pointMatchData) {
            return pointMatchData == null || getDif() < pointMatchData.getDif();
        }
    }
}
