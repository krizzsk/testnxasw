package com.threatmetrix.TrustDefender;

import android.os.Process;
import com.threatmetrix.TrustDefender.TMXProfilingModule.BuildConfig;
import com.threatmetrix.TrustDefender.jkjjkj;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nonnull;

public class yqyyqq {
    private static final int b006200620062b0062b = 48;
    private static final int b00620062b00620062b = 1024;
    private static final int b0062bb00620062b = 10;
    private static final int bb00620062b0062b = 32;
    private static final int bb0062b00620062b = 8192;
    private static final int bbbb00620062b = 120;

    private yqyyqq() {
    }

    public static jkjjkj.kkjjkj b00690069ii0069i() {
        String concat = "lib".concat(BuildConfig.JNI_FILENAME).concat(".so");
        char[] cArr = new char[8192];
        try {
            FileReader fileReader = new FileReader("/proc/" + Process.myPid() + "/maps");
            int i = -1;
            FileReader fileReader2 = fileReader;
            int i2 = -1;
            int i3 = 0;
            int i4 = -1;
            boolean z = false;
            int i5 = -1;
            boolean z2 = false;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (fileReader2 == null && i3 < 0) {
                    break;
                }
                if (z) {
                    while (true) {
                        try {
                            char c = cArr[i6];
                            i6++;
                            if (c == 10) {
                                break;
                            }
                        } catch (ArrayIndexOutOfBoundsException | SecurityException unused) {
                        }
                    }
                }
                i3 -= i6 - i7;
                i7 = i6;
                while (fileReader2 != null && i3 < 1024) {
                    int bii0069i0069i = bii0069i0069i(cArr, i7, i3, fileReader2);
                    if (bii0069i0069i < 0) {
                        fileReader2 = null;
                    } else {
                        i3 += bii0069i0069i;
                    }
                    i7 = 0;
                }
                int bi0069ii0069i = bi0069ii0069i(cArr, i7);
                boolean z3 = false;
                while (cArr[bi0069ii0069i] != ' ') {
                    if (cArr[bi0069ii0069i] == 'x') {
                        z3 = true;
                    }
                    bi0069ii0069i++;
                }
                int i8 = bi0069ii0069i + 1;
                if (!z3) {
                    i6 = i8;
                } else {
                    i6 = bi0069ii0069i(cArr, bi0069ii0069i(cArr, i8));
                    if (cArr[i6] != '0' || cArr[i6 + 1] != ' ') {
                        int bi0069ii0069i2 = bi0069ii0069i(cArr, i6);
                        while (cArr[bi0069ii0069i2] == ' ') {
                            bi0069ii0069i2++;
                        }
                        int i9 = bi0069ii0069i2;
                        while (cArr[i9] != 10) {
                            i9++;
                        }
                        i6 = i9 + 1;
                        String str = new String(cArr, bi0069ii0069i2, i9 - bi0069ii0069i2);
                        if (str.startsWith("/system")) {
                            i++;
                            i4 = (int) (((long) i4) + new File(str).length());
                        } else if (str.startsWith("/dev")) {
                            i2++;
                        } else if (str.endsWith(concat)) {
                            z2 = true;
                        } else {
                            i2++;
                            i5 = (int) (((long) i5) + new File(str).length());
                        }
                        z = false;
                    }
                }
                z = true;
            }
            return new jkjjkj.kkjjkj(i, i4, i2, i5, z2);
        } catch (FileNotFoundException unused2) {
            return new jkjjkj.kkjjkj(-1, -1, -1, -1, false);
        }
    }

    private static int bi0069ii0069i(char[] cArr, int i) {
        char c;
        do {
            c = cArr[i];
            i++;
        } while (c != ' ');
        return i;
    }

    private static int bii0069i0069i(@Nonnull char[] cArr, int i, int i2, @Nonnull FileReader fileReader) {
        if (i > 0) {
            System.arraycopy(cArr, i, cArr, 0, i2);
        }
        try {
            int read = fileReader.read(cArr, i2, 8192 - i2);
            if (read > 0) {
                return read;
            }
            fileReader.close();
            return -1;
        } catch (IOException unused) {
            return -1;
        }
    }
}
