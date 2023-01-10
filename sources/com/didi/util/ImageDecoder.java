package com.didi.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.didi.dqr.BarcodeFormat;
import com.didi.dqr.BinarizerEnum;
import com.didi.dqr.BinaryBitmap;
import com.didi.dqr.DecodeHintType;
import com.didi.dqr.DecodeOptions;
import com.didi.dqr.NativeDecode;
import com.didi.dqr.OpenCVBinarizer;
import com.didi.dqr.PlanarYUVLuminanceSource;
import com.didi.dqr.Reader;
import com.didi.dqr.Result;
import com.didi.dqr.common.GlobalHistogramBinarizer;
import com.didi.dqr.common.HybridBinarizer;
import com.didi.dqr.qrcode.QRCodeReader;
import com.didi.dqr.qrcode.detector.BestPatternMethodEnum;
import com.didi.dqrutil.DqrConfigHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.util.ImageDecoderExecutor;
import com.didi.zxing.barcodescanner.DecodeConfig;
import com.didi.zxing.barcodescanner.Decoder;
import com.didi.zxing.barcodescanner.DefaultDecoderFactory;
import com.didi.zxing.barcodescanner.SourceData;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class ImageDecoder {

    /* renamed from: a */
    private static final String f47799a = "ImageDecoder";

    /* renamed from: b */
    private static final int f47800b = 2000;

    /* renamed from: c */
    private static DecodeConfig f47801c = new DefaultDecodeConfigImpl() {
        public boolean useContourFinder() {
            return true;
        }
    };

    /* renamed from: d */
    private static final int f47802d = 1080;

    /* renamed from: e */
    private static DecodeOptions f47803e;

    public static String syncDecodeQRCode(Context context, String str) {
        return syncDecodeQRCode(context, str, 2000);
    }

    public static String syncDecodeQRCode(Context context, String str, int i) {
        try {
            return syncDecodeQRCode(context, BitmapFactory.decodeFile(str), i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String syncDecodeQRCode(Context context, Bitmap bitmap) {
        return syncDecodeQRCode(context, bitmap, 2000);
    }

    public static String syncDecodeQRCode(Context context, Bitmap bitmap, int i) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            return m35909a(context, YUVUtil.getYUV420sp(width, height, bitmap), width, height, i);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static String m35909a(Context context, byte[] bArr, int i, int i2, int i3) {
        String a = m35911a(bArr, i, i2);
        if (a != null) {
            return a;
        }
        DqrConfigHelper.init(f47801c);
        final Object obj = new Object();
        C156592 r1 = new DecodeCallBackImpl() {
            public void onResult(String str) {
                super.onResult(str);
                synchronized (obj) {
                    try {
                        obj.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onTimeout() {
                super.onTimeout();
                synchronized (obj) {
                    try {
                        obj.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        ImageDecoderExecutor imageDecoderExecutor = new ImageDecoderExecutor(context, m35908a(), r1);
        long j = (long) i3;
        imageDecoderExecutor.mo119960a(new SourceData(bArr, i, i2, 17, 0), j);
        synchronized (obj) {
            try {
                obj.wait(j);
            } catch (Exception e) {
                e.printStackTrace();
                SystemUtils.log(6, f47799a, e.toString(), (Throwable) null, "com.didi.util.ImageDecoder", 148);
            }
        }
        imageDecoderExecutor.mo119962b();
        return r1.result;
    }

    /* renamed from: a */
    private static Decoder m35908a() {
        Hashtable hashtable = new Hashtable();
        hashtable.put(DecodeHintType.CHARACTER_SET, "utf-8");
        hashtable.put(DecodeHintType.TRY_HARDER, Boolean.TRUE);
        DecodeOptions decodeOptions = new DecodeOptions();
        decodeOptions.binarizer = BinarizerEnum.CommixtureWithOpenCV;
        decodeOptions.baseHints = hashtable;
        ArrayList arrayList = new ArrayList();
        arrayList.add(BarcodeFormat.QR_CODE);
        decodeOptions.decodeFormats = arrayList;
        return new Decoder(decodeOptions, false);
    }

    public static String quickDecode(String str) {
        try {
            return quickDecode(BitmapFactory.decodeFile(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String quickDecode(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        boolean z = true;
        if (width > height && width > 1080) {
            height = (height * 1080) / width;
            width = 1080;
        } else if (height <= width || height <= 1080) {
            z = false;
        } else {
            width = (width * 1080) / height;
            height = 1080;
        }
        if (z) {
            bitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        }
        PrintStream printStream = System.out;
        printStream.println("quickDecode() called, w===" + width + ", h=" + height + ", changed=" + z);
        return m35911a(YUVUtil.getYUV420sp(width, height, bitmap), width, height);
    }

    /* renamed from: a */
    private static String m35911a(byte[] bArr, int i, int i2) {
        if (f47803e == null) {
            f47803e = new DefaultDecoderFactory().createDecoder(new HashMap()).getDecodeOptions();
        }
        PlanarYUVLuminanceSource planarYUVLuminanceSource = new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
        DqrConfigHelper.init(new DefaultDecodeConfigImpl() {
            public int newFinderRate() {
                return 2;
            }

            public boolean useDynamicCVBlocksize() {
                return false;
            }

            public int findBestPatternType() {
                return BestPatternMethodEnum.TYPE_MOUDLE_SIZE.ordinal();
            }
        });
        QRCodeReader qRCodeReader = new QRCodeReader();
        String a = m35910a(planarYUVLuminanceSource, (Reader) qRCodeReader, f47803e);
        if (a != null) {
            System.out.println("got by global...");
            return a;
        }
        String b = m35912b(planarYUVLuminanceSource, (Reader) qRCodeReader, f47803e);
        if (b != null) {
            System.out.println("got by hybrid...");
            return b;
        }
        String c = m35914c(planarYUVLuminanceSource, qRCodeReader, f47803e);
        if (c != null) {
            System.out.println("got by opencv...");
            return c;
        }
        String b2 = m35913b(bArr, i, i2);
        if (b2 == null) {
            return null;
        }
        System.out.println("got by native...");
        return b2;
    }

    /* renamed from: a */
    private static String m35910a(PlanarYUVLuminanceSource planarYUVLuminanceSource, Reader reader, DecodeOptions decodeOptions) {
        try {
            Result decode = reader.decode(new BinaryBitmap(new GlobalHistogramBinarizer(planarYUVLuminanceSource)), decodeOptions);
            if (decode == null || decode.getText() == null) {
                return null;
            }
            SystemUtils.log(3, f47799a, "decodeGlobal succ " + decode.getText(), (Throwable) null, "com.didi.util.ImageDecoder", 266);
            return decode.getText();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static String m35912b(PlanarYUVLuminanceSource planarYUVLuminanceSource, Reader reader, DecodeOptions decodeOptions) {
        try {
            Result decode = reader.decode(new BinaryBitmap(new HybridBinarizer(planarYUVLuminanceSource)), decodeOptions);
            if (decode == null || decode.getText() == null) {
                return null;
            }
            SystemUtils.log(3, f47799a, "decodeHybrid succ " + decode.getText(), (Throwable) null, "com.didi.util.ImageDecoder", 279);
            return decode.getText();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    private static String m35914c(PlanarYUVLuminanceSource planarYUVLuminanceSource, Reader reader, DecodeOptions decodeOptions) {
        try {
            Result decode = reader.decode(new BinaryBitmap(new OpenCVBinarizer(planarYUVLuminanceSource)), decodeOptions);
            if (decode == null || decode.getText() == null) {
                return null;
            }
            SystemUtils.log(3, f47799a, "decodeOpencv succ " + decode.getText(), (Throwable) null, "com.didi.util.ImageDecoder", 292);
            return decode.getText();
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static String m35913b(byte[] bArr, int i, int i2) {
        SourceData sourceData = new SourceData(bArr, i, i2, 17, 0);
        NativeDecode nativeDecode = new NativeDecode();
        String decode = nativeDecode.decode(sourceData.getDataWidth(), sourceData.getDataHeight(), sourceData.getData());
        nativeDecode.destroy();
        return decode;
    }

    private static class DecodeCallBackImpl implements ImageDecoderExecutor.DecodeCallBack {
        String result;

        public void onTimeout() {
        }

        private DecodeCallBackImpl() {
        }

        public void onResult(String str) {
            this.result = str;
        }
    }
}
