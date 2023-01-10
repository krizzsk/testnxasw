package com.jumio.jvision.jvcorejava.swig;

public class Image {

    /* renamed from: a */
    public transient long f57901a;
    public transient boolean swigCMemOwn;

    public Image(long j, boolean z) {
        this.swigCMemOwn = z;
        this.f57901a = j;
    }

    public static long getCPtr(Image image) {
        if (image == null) {
            return 0;
        }
        return image.f57901a;
    }

    public int channelDepth() {
        return JVCoreJavaJNI.Image_channelDepth(this.f57901a, this);
    }

    public int channels() {
        return JVCoreJavaJNI.Image_channels(this.f57901a, this);
    }

    public synchronized void delete() {
        long j = this.f57901a;
        if (j != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                JVCoreJavaJNI.delete_Image(j);
            }
            this.f57901a = 0;
        }
    }

    public boolean empty() {
        return JVCoreJavaJNI.Image_empty(this.f57901a, this);
    }

    public void finalize() {
        delete();
    }

    public ImageFormat format() {
        return ImageFormat.swigToEnum(JVCoreJavaJNI.Image_format(this.f57901a, this));
    }

    public void getBytes(byte[] bArr) {
        JVCoreJavaJNI.Image_getBytes(this.f57901a, this, bArr);
    }

    public int height() {
        return JVCoreJavaJNI.Image_height(this.f57901a, this);
    }

    public int length() {
        return JVCoreJavaJNI.Image_length(this.f57901a, this);
    }

    public int stride() {
        return JVCoreJavaJNI.Image_stride(this.f57901a, this);
    }

    public byte[] toBytes() {
        byte[] bArr = new byte[length()];
        getBytes(bArr);
        return bArr;
    }

    public int width() {
        return JVCoreJavaJNI.Image_width(this.f57901a, this);
    }

    public Image() {
        this(JVCoreJavaJNI.new_Image(), true);
    }
}
