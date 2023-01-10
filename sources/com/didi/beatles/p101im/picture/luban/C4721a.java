package com.didi.beatles.p101im.picture.luban;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.didi.beatles.p101im.omega.IMTraceError;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMApolloConfigUtil;
import com.didi.beatles.p101im.utils.IMLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.didi.beatles.im.picture.luban.a */
/* compiled from: Engine */
class C4721a {

    /* renamed from: a */
    private static final int f11275a = 10;

    /* renamed from: b */
    private static final int f11276b = 10;

    /* renamed from: c */
    private InputStreamProvider f11277c;

    /* renamed from: d */
    private File f11278d;

    /* renamed from: e */
    private int f11279e;

    /* renamed from: f */
    private int f11280f;

    /* renamed from: g */
    private boolean f11281g;

    C4721a(InputStreamProvider inputStreamProvider, File file, boolean z) throws IOException {
        this.f11278d = file;
        this.f11277c = inputStreamProvider;
        this.f11281g = z;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        BitmapFactory.decodeStream(inputStreamProvider.open(), (Rect) null, options);
        this.f11279e = options.outWidth;
        this.f11280f = options.outHeight;
    }

    /* renamed from: a */
    private int m9805a() {
        int i = this.f11279e;
        if (i % 2 == 1) {
            i++;
        }
        this.f11279e = i;
        int i2 = this.f11280f;
        if (i2 % 2 == 1) {
            i2++;
        }
        this.f11280f = i2;
        int max = Math.max(this.f11279e, i2);
        float min = ((float) Math.min(this.f11279e, this.f11280f)) / ((float) max);
        if (min > 1.0f || ((double) min) <= 0.5625d) {
            double d = (double) min;
            if (d > 0.5625d || d <= 0.5d) {
                return (int) Math.ceil(((double) max) / (1280.0d / d));
            }
            int i3 = max / 1280;
            if (i3 == 0) {
                return 1;
            }
            return i3;
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            if (max > 4990 && max < 10240) {
                return 4;
            }
            int i4 = max / 1280;
            if (i4 == 0) {
                return 1;
            }
            return i4;
        }
    }

    /* renamed from: a */
    private Bitmap m9806a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public LubanOutput mo48024a(int i) throws IOException {
        int i2 = i;
        if (i2 == 0) {
            throw new IllegalArgumentException("MaxImageSize must be greater than 0.");
        } else if (this.f11278d == null) {
            IMLog.m10021e(Luban.TAG_LUBAN, "[compress] #ERROR# with NULL file");
            return null;
        } else {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = m9805a();
                Bitmap decodeStream = BitmapFactory.decodeStream(this.f11277c.open(), (Rect) null, options);
                if (decodeStream == null) {
                    IMLog.m10021e(Luban.TAG_LUBAN, "[compress] #ERROR# with NULL bitmap by decodeStream");
                    return null;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (Checker.SINGLE.isJPG(this.f11277c.open())) {
                    decodeStream = m9806a(decodeStream, Checker.SINGLE.getOrientation(this.f11277c.open()));
                }
                if (decodeStream == null) {
                    IMLog.m10021e(Luban.TAG_LUBAN, "[compress] #ERROR# with NULL bitmap by rotatingImage");
                    return null;
                }
                int imageBaseCompressQuality = IMApolloConfigUtil.getImageBaseCompressQuality();
                decodeStream.compress(this.f11281g ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, imageBaseCompressQuality, byteArrayOutputStream);
                IMLog.m10020d(Luban.TAG_LUBAN, C4786I.m9980t("[compress] maxImageSize=", Integer.valueOf(i), " #step1# compressQuality=", Integer.valueOf(imageBaseCompressQuality)));
                int i3 = 1;
                while (true) {
                    int length = byteArrayOutputStream.toByteArray().length / 1024;
                    if (length <= i2) {
                        break;
                    }
                    byteArrayOutputStream.reset();
                    i3++;
                    imageBaseCompressQuality = Math.max(imageBaseCompressQuality - 10, 10);
                    IMLog.m10020d(Luban.TAG_LUBAN, C4786I.m9980t("[compress] #Loop# compressQuality=", Integer.valueOf(imageBaseCompressQuality), " |imageSize(kb)=", Integer.valueOf(length)));
                    decodeStream.compress(this.f11281g ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG, imageBaseCompressQuality, byteArrayOutputStream);
                    if (imageBaseCompressQuality == 10) {
                        IMLog.m10020d(Luban.TAG_LUBAN, C4786I.m9980t("[compress] #BreakLoop# LOW COMPRESS QUALITY. imageSize(kb)=", Integer.valueOf(length)));
                        break;
                    }
                }
                int i4 = i3;
                int i5 = options.outWidth;
                int i6 = options.outHeight;
                decodeStream.recycle();
                FileOutputStream fileOutputStream = new FileOutputStream(this.f11278d);
                fileOutputStream.write(byteArrayOutputStream.toByteArray());
                fileOutputStream.flush();
                fileOutputStream.close();
                byteArrayOutputStream.close();
                return new LubanOutput(this.f11278d, i5, i6, this.f11278d.length(), i4, imageBaseCompressQuality);
            } catch (OutOfMemoryError e) {
                IMTraceError.trackError("[Luban]#compress#", e);
                return null;
            }
        }
    }
}
