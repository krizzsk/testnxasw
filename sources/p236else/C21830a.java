package p236else;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.media.FaceDetector;
import com.iproov.sdk.IProov;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.FaceFeatureSmoother;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import p095switch.C3678this;

/* renamed from: else.a */
/* compiled from: ClassicFaceDetector */
class C21830a implements FaceDetector {

    /* renamed from: a */
    private static final String f59991a = ("👱 " + C21830a.class.getSimpleName());

    /* renamed from: b */
    private final FaceFeatureSmoother f59992b = new FaceFeatureSmoother(0.2d);

    /* renamed from: c */
    private android.media.FaceDetector f59993c;

    C21830a() {
        new C3678this(0.8d);
    }

    public FaceFeature detectFace(Bitmap bitmap) {
        if (this.f59993c == null) {
            this.f59993c = new android.media.FaceDetector(bitmap.getWidth(), bitmap.getHeight(), 1);
        }
        FaceDetector.Face[] faceArr = new FaceDetector.Face[1];
        Bitmap copy = bitmap.copy(Bitmap.Config.RGB_565, false);
        System.currentTimeMillis();
        this.f59993c.findFaces(copy, faceArr);
        System.currentTimeMillis();
        if (faceArr[0] == null) {
            this.f59992b.reset();
            return null;
        } else if (faceArr[0].eyesDistance() == 0.0f) {
            this.f59992b.reset();
            return null;
        } else {
            double eyesDistance = ((double) (faceArr[0].eyesDistance() / ((float) FaceDetector.CC.calculateNormalisationFactor(bitmap.getWidth(), bitmap.getHeight())))) * 2.4d;
            PointF pointF = new PointF();
            faceArr[0].getMidPoint(pointF);
            float f = pointF.x;
            float eyesDistance2 = ((float) (((double) faceArr[0].eyesDistance()) * 2.4d)) / 2.0f;
            float f2 = pointF.y;
            RectF rectF = new RectF(f - eyesDistance2, f2 - eyesDistance2, f + eyesDistance2, f2 + eyesDistance2);
            StringBuilder sb = new StringBuilder();
            sb.append("Face found of size ");
            sb.append(eyesDistance);
            return this.f59992b.smooth(new FaceFeature(eyesDistance, rectF, (Pose) null));
        }
    }

    public IProov.FaceDetector getFaceDetector() {
        return IProov.FaceDetector.CLASSIC;
    }

    public void release() {
    }

    public void setOmega(double d) {
    }
}
