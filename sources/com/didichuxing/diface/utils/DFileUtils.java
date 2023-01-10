package com.didichuxing.diface.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DFileUtils {

    /* renamed from: a */
    private Context f50100a;

    public DFileUtils(Context context) {
        this.f50100a = context;
    }

    public static void saveFile(byte[] bArr, String str, File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static void delFiles(List<File> list) {
        boolean z = true;
        for (File delete : list) {
            z &= delete.delete();
        }
        LogUtils.m37051d("del files ok=" + z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028 A[SYNTHETIC, Splitter:B:15:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compressBitmap(int r2, int r3, byte[] r4) {
        /*
            r0 = 0
            android.graphics.Bitmap r2 = bitmapFromRgba(r2, r3, r4)     // Catch:{ all -> 0x0021 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0021 }
            r3.<init>()     // Catch:{ all -> 0x0021 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x001f }
            r1 = 75
            r2.compress(r4, r1, r3)     // Catch:{ all -> 0x001f }
            r2.recycle()     // Catch:{ all -> 0x001f }
            byte[] r2 = r3.toByteArray()     // Catch:{ all -> 0x001f }
            r3.close()     // Catch:{ all -> 0x001f }
            r3.close()     // Catch:{ all -> 0x001e }
        L_0x001e:
            return r2
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r3 = r0
        L_0x0023:
            r2.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r3 == 0) goto L_0x002b
            r3.close()     // Catch:{ all -> 0x002b }
        L_0x002b:
            return r0
        L_0x002c:
            r2 = move-exception
            if (r3 == 0) goto L_0x0032
            r3.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.utils.DFileUtils.compressBitmap(int, int, byte[]):byte[]");
    }

    public static Bitmap bitmapFromRgba(int i, int i2, byte[] bArr) {
        int length = bArr.length / 4;
        int[] iArr = new int[length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            iArr[i3] = ((bArr[i4] & 255) << 16) | ((bArr[i7] & 255) << Ascii.CAN) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
            i3++;
            i4 = i7 + 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static String sourceToMD5(List<ILivenessCallback.PicWithScore> list) {
        String str = "";
        if (list == null) {
            return str;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            str = str + FileUtils.byteToMD5(list.get(i).rgba);
            i++;
            if (i < size) {
                str = str + ParamKeys.SIGN_AND;
            }
        }
        return str;
    }
}
