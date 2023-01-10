package p095switch;

import java.util.ArrayList;
import java.util.List;

/* renamed from: switch.do */
/* compiled from: ArrayUtils */
public class C3667do {
    /* renamed from: do */
    public static byte[] m7414do(byte[] bArr, List<byte[]> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bArr);
        arrayList.addAll(list);
        return m7415do((byte[][]) arrayList.toArray(new byte[arrayList.size()][]));
    }

    /* renamed from: do */
    public static byte[] m7415do(byte[]... bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (byte[] bArr3 : bArr) {
            int length2 = bArr3.length;
            System.arraycopy(bArr3, 0, bArr2, i2, length2);
            i2 += length2;
        }
        return bArr2;
    }

    /* renamed from: do */
    public static byte[] m7413do(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[(bArr.length - i) - 1] = bArr[i];
        }
        return bArr2;
    }
}
