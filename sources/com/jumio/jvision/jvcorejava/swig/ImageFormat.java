package com.jumio.jvision.jvcorejava.swig;

public final class ImageFormat {
    public static final ImageFormat BGR;
    public static final ImageFormat BGRA;
    public static final ImageFormat GRAY;
    public static final ImageFormat RGB;
    public static final ImageFormat RGBA;
    public static final ImageFormat YUVNV21;
    public static final ImageFormat YUVYV12;

    /* renamed from: c */
    public static ImageFormat[] f57902c;

    /* renamed from: a */
    public final int f57903a;

    /* renamed from: b */
    public final String f57904b;

    static {
        ImageFormat imageFormat = new ImageFormat("GRAY", JVCoreJavaJNI.ImageFormat_GRAY_get());
        GRAY = imageFormat;
        ImageFormat imageFormat2 = new ImageFormat("RGB", JVCoreJavaJNI.ImageFormat_RGB_get());
        RGB = imageFormat2;
        ImageFormat imageFormat3 = new ImageFormat("BGR", JVCoreJavaJNI.ImageFormat_BGR_get());
        BGR = imageFormat3;
        ImageFormat imageFormat4 = new ImageFormat("RGBA", JVCoreJavaJNI.ImageFormat_RGBA_get());
        RGBA = imageFormat4;
        ImageFormat imageFormat5 = new ImageFormat("BGRA", JVCoreJavaJNI.ImageFormat_BGRA_get());
        BGRA = imageFormat5;
        ImageFormat imageFormat6 = new ImageFormat("YUVNV21", JVCoreJavaJNI.ImageFormat_YUVNV21_get());
        YUVNV21 = imageFormat6;
        ImageFormat imageFormat7 = new ImageFormat("YUVYV12", JVCoreJavaJNI.ImageFormat_YUVYV12_get());
        YUVYV12 = imageFormat7;
        f57902c = new ImageFormat[]{imageFormat, imageFormat2, imageFormat3, imageFormat4, imageFormat5, imageFormat6, imageFormat7};
    }

    public ImageFormat(String str, int i) {
        this.f57904b = str;
        this.f57903a = i;
    }

    public static ImageFormat swigToEnum(int i) {
        ImageFormat[] imageFormatArr = f57902c;
        if (i < imageFormatArr.length && i >= 0 && imageFormatArr[i].f57903a == i) {
            return imageFormatArr[i];
        }
        int i2 = 0;
        while (true) {
            ImageFormat[] imageFormatArr2 = f57902c;
            if (i2 >= imageFormatArr2.length) {
                throw new IllegalArgumentException("No enum " + ImageFormat.class + " with value " + i);
            } else if (imageFormatArr2[i2].f57903a == i) {
                return imageFormatArr2[i2];
            } else {
                i2++;
            }
        }
    }

    public final int swigValue() {
        return this.f57903a;
    }

    public String toString() {
        return this.f57904b;
    }
}
