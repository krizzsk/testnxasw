package p235do;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.exifinterface.media.ExifInterface;
import p095switch.C3679throw;

/* renamed from: do.this */
/* compiled from: EXIFData */
public class C21828this {

    /* renamed from: a */
    private final Double f59971a;

    /* renamed from: b */
    private final Double f59972b;

    /* renamed from: c */
    private final Double f59973c;

    /* renamed from: d */
    private final Double f59974d;

    /* renamed from: e */
    private final Double f59975e;

    /* renamed from: f */
    private final Double f59976f;

    /* renamed from: g */
    private final Double f59977g;

    /* renamed from: h */
    private final Double f59978h;

    /* renamed from: i */
    private final Double f59979i;

    /* renamed from: j */
    private final Double f59980j;

    /* renamed from: k */
    private final Double f59981k;

    /* renamed from: l */
    private final Double f59982l;

    /* renamed from: m */
    private final Double f59983m;

    /* renamed from: n */
    private final Double f59984n;

    /* renamed from: o */
    private final Double f59985o;

    /* renamed from: p */
    private final Double f59986p;

    /* renamed from: q */
    private final Double f59987q;

    /* renamed from: r */
    private final Double f59988r;

    /* renamed from: s */
    private final Double f59989s;

    /* renamed from: t */
    private final Double f59990t;

    public C21828this(TotalCaptureResult totalCaptureResult) {
        Double d = C21823else.m45131do((Float) totalCaptureResult.get(CaptureResult.LENS_APERTURE));
        this.f59971a = d;
        this.f59974d = d;
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        this.f59973c = (num == null || num.intValue() == 0) ? null : C21823else.m45132do(num);
        Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        this.f59972b = (l == null || l.longValue() == 0) ? null : Double.valueOf(((double) l.longValue()) / 1.0E9d);
        this.f59975e = C21823else.m45131do((Float) totalCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH));
        this.f59976f = null;
        this.f59977g = C21823else.m45131do((Float) totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE));
        this.f59978h = C21823else.m45132do((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION));
        this.f59979i = null;
        this.f59980j = null;
        this.f59981k = null;
        this.f59982l = null;
        this.f59983m = null;
        this.f59984n = null;
        this.f59985o = null;
        this.f59986p = null;
        this.f59987q = null;
        this.f59988r = null;
        this.f59989s = null;
        this.f59990t = null;
    }

    /* renamed from: break  reason: not valid java name */
    public Double m48220break() {
        return this.f59973c;
    }

    /* renamed from: case  reason: not valid java name */
    public Double m48221case() {
        return this.f59978h;
    }

    /* renamed from: catch  reason: not valid java name */
    public Double m48222catch() {
        return this.f59989s;
    }

    /* renamed from: class  reason: not valid java name */
    public Double m48223class() {
        return this.f59980j;
    }

    /* renamed from: const  reason: not valid java name */
    public Double m48224const() {
        return this.f59984n;
    }

    /* renamed from: do */
    public Double mo180448do() {
        return this.f59971a;
    }

    /* renamed from: else  reason: not valid java name */
    public Double m48225else() {
        return this.f59972b;
    }

    /* renamed from: final  reason: not valid java name */
    public Double m48226final() {
        return this.f59982l;
    }

    /* renamed from: for  reason: not valid java name */
    public Double m48227for() {
        return this.f59981k;
    }

    /* renamed from: goto  reason: not valid java name */
    public Double m48228goto() {
        return this.f59975e;
    }

    /* renamed from: if */
    public Double mo180453if() {
        return this.f59976f;
    }

    /* renamed from: import  reason: not valid java name */
    public Double m48229import() {
        return this.f59988r;
    }

    /* renamed from: native  reason: not valid java name */
    public Double m48230native() {
        return this.f59987q;
    }

    /* renamed from: new  reason: not valid java name */
    public Double m48231new() {
        return this.f59983m;
    }

    /* renamed from: public  reason: not valid java name */
    public Double m48232public() {
        return this.f59974d;
    }

    /* renamed from: super  reason: not valid java name */
    public Double m48233super() {
        return this.f59990t;
    }

    /* renamed from: this  reason: not valid java name */
    public Double m48234this() {
        return this.f59986p;
    }

    /* renamed from: throw  reason: not valid java name */
    public Double m48235throw() {
        return this.f59979i;
    }

    public String toString() {
        return "EXIFData{aperture=" + this.f59971a + ", exposureTime=" + this.f59972b + ", iso=" + this.f59973c + ", fNumber=" + this.f59974d + ", focalLength=" + this.f59975e + ", brightness=" + this.f59976f + ", subjectDistance=" + this.f59977g + ", exposureBias=" + this.f59978h + ", subjectArea=" + this.f59979i + ", meteringMode=" + this.f59980j + ", colorSpace=" + this.f59981k + ", sensingMethod=" + this.f59982l + ", componentsConfiguration=" + this.f59983m + ", saturation=" + this.f59984n + ", contrast=" + this.f59985o + ", gainControl=" + this.f59986p + ", whiteBalance=" + this.f59987q + ", subjectDistanceRange=" + this.f59988r + ", maxApertureValue=" + this.f59989s + ", spatialFrequencyResponse=" + this.f59990t + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public Double m48236try() {
        return this.f59985o;
    }

    /* renamed from: while  reason: not valid java name */
    public Double m48237while() {
        return this.f59977g;
    }

    public C21828this(ExifInterface exifInterface) {
        ExifInterface exifInterface2 = exifInterface;
        String attribute = exifInterface2.getAttribute(ExifInterface.TAG_APERTURE_VALUE);
        String attribute2 = exifInterface2.getAttribute(ExifInterface.TAG_F_NUMBER);
        String attribute3 = exifInterface2.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
        String attribute4 = exifInterface2.getAttribute(ExifInterface.TAG_ISO_SPEED_RATINGS);
        String attribute5 = exifInterface2.getAttribute(ExifInterface.TAG_BRIGHTNESS_VALUE);
        String attribute6 = exifInterface2.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
        String attribute7 = exifInterface2.getAttribute(ExifInterface.TAG_SUBJECT_DISTANCE);
        String attribute8 = exifInterface2.getAttribute(ExifInterface.TAG_EXPOSURE_BIAS_VALUE);
        String attribute9 = exifInterface2.getAttribute(ExifInterface.TAG_SUBJECT_AREA);
        String attribute10 = exifInterface2.getAttribute(ExifInterface.TAG_METERING_MODE);
        String attribute11 = exifInterface2.getAttribute(ExifInterface.TAG_COLOR_SPACE);
        String attribute12 = exifInterface2.getAttribute(ExifInterface.TAG_SENSING_METHOD);
        String attribute13 = exifInterface2.getAttribute(ExifInterface.TAG_COMPONENTS_CONFIGURATION);
        String attribute14 = exifInterface2.getAttribute(ExifInterface.TAG_SATURATION);
        String attribute15 = exifInterface2.getAttribute(ExifInterface.TAG_CONTRAST);
        String attribute16 = exifInterface2.getAttribute(ExifInterface.TAG_GAIN_CONTROL);
        String attribute17 = exifInterface2.getAttribute(ExifInterface.TAG_WHITE_BALANCE);
        String attribute18 = exifInterface2.getAttribute(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE);
        String attribute19 = exifInterface2.getAttribute(ExifInterface.TAG_MAX_APERTURE_VALUE);
        String attribute20 = exifInterface2.getAttribute(ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE);
        Double d = C21823else.m45133do(attribute);
        Double d2 = C21823else.m45133do(attribute2);
        this.f59971a = (Double) C3679throw.m7439do(d, d2);
        this.f59972b = C21823else.m45133do(attribute3);
        this.f59973c = C21823else.m45133do(attribute4);
        this.f59974d = (Double) C3679throw.m7439do(d2, d);
        this.f59976f = C21823else.m45133do(attribute5);
        this.f59975e = C21823else.m45133do(attribute6);
        this.f59977g = C21823else.m45133do(attribute7);
        this.f59978h = C21823else.m45133do(attribute8);
        this.f59979i = C21823else.m45133do(attribute9);
        this.f59980j = C21823else.m45133do(attribute10);
        this.f59981k = C21823else.m45133do(attribute11);
        this.f59982l = C21823else.m45133do(attribute12);
        this.f59983m = C21823else.m45133do(attribute13);
        this.f59984n = C21823else.m45133do(attribute14);
        this.f59985o = C21823else.m45133do(attribute15);
        this.f59986p = C21823else.m45133do(attribute16);
        this.f59987q = C21823else.m45133do(attribute17);
        this.f59988r = C21823else.m45133do(attribute18);
        this.f59989s = C21823else.m45133do(attribute19);
        this.f59990t = C21823else.m45133do(attribute20);
    }
}
