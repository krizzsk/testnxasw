package com.threatmetrix.TrustDefender;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class qttttt extends HashMap<String, String> {
    private static final String b0066ff0066ff = yyyyqy.b0074t007400740074t(qttttt.class);
    @Nonnull
    private final HashMap<String, Integer> b00660066f0066ff = new HashMap<>();
    private int bf0066f0066ff = 0;

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        r2.addSuppressed(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] byy0079y00790079(java.lang.String r2) throws java.io.IOException {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            int r1 = r2.length()
            r0.<init>(r1)
            java.util.zip.GZIPOutputStream r1 = new java.util.zip.GZIPOutputStream
            r1.<init>(r0)
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x001d }
            r1.write(r2)     // Catch:{ all -> 0x001d }
            r1.close()
            byte[] r2 = r0.toByteArray()
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0024 }
            goto L_0x0028
        L_0x0024:
            r1 = move-exception
            r2.addSuppressed(r1)
        L_0x0028:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qttttt.byy0079y00790079(java.lang.String):byte[]");
    }

    @Nonnull
    public String b007900790079y00790079() {
        int i;
        StringBuilder sb = new StringBuilder();
        for (String str : keySet()) {
            String str2 = (String) get(str);
            if (str2 != null && !str2.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(ParamKeys.SIGN_AND);
                }
                sb.append(str);
                Integer num = this.b00660066f0066ff.get(str);
                if (!(num == null || num.intValue() == -1 || str2.length() <= num.intValue())) {
                    str2 = str2.substring(0, num.intValue());
                }
                if (num == null && this.bf0066f0066ff != 0 && str2.length() > (i = this.bf0066f0066ff)) {
                    str2 = str2.substring(0, i);
                }
                sb.append("=");
                sb.append(yqqyqq.b0069ii006900690069(str2));
            }
        }
        return sb.toString();
    }

    @Nonnull
    public qttttt b00790079yy00790079(Map<String, String> map) {
        if (map instanceof qttttt) {
            for (Map.Entry next : map.entrySet()) {
                Integer b0079y0079y00790079 = ((qttttt) map).b0079y0079y00790079((String) next.getKey());
                if (b0079y0079y00790079 != null) {
                    b0079yyy00790079((String) next.getKey(), (String) next.getValue(), b0079y0079y00790079);
                } else {
                    byyyy00790079((String) next.getKey(), (String) next.getValue());
                }
            }
        } else {
            putAll(map);
        }
        return this;
    }

    public Integer b0079y0079y00790079(String str) {
        return this.b00660066f0066ff.get(str);
    }

    public byte[] b0079yy007900790079() {
        byte[] bArr;
        String b007900790079y00790079 = b007900790079y00790079();
        try {
            bArr = byy0079y00790079(b007900790079y00790079);
        } catch (IOException e) {
            yyyyqy.b00740074t00740074t(b0066ff0066ff, "Cannot compress!", e);
            bArr = null;
        }
        return bArr == null ? b007900790079y00790079.getBytes() : bArr;
    }

    @Nonnull
    public qttttt b0079yyy00790079(String str, @Nullable String str2, Integer num) {
        this.b00660066f0066ff.put(str, num);
        by0079yy00790079(str, str2, false);
        return this;
    }

    public int by00790079y00790079() {
        return this.bf0066f0066ff;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (com.threatmetrix.TrustDefender.yqqyqq.b0069ii0069i0069(r2) != false) goto L_0x0015;
     */
    @javax.annotation.Nonnull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.threatmetrix.TrustDefender.qttttt by0079yy00790079(java.lang.String r1, @javax.annotation.Nullable java.lang.String r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x000f
            boolean r3 = com.threatmetrix.TrustDefender.yqqyqq.b0069ii0069i0069(r2)
            if (r3 == 0) goto L_0x000f
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r2 = r2.toLowerCase(r3)
            goto L_0x0015
        L_0x000f:
            boolean r3 = com.threatmetrix.TrustDefender.yqqyqq.b0069ii0069i0069(r2)
            if (r3 == 0) goto L_0x0018
        L_0x0015:
            r0.put(r1, r2)
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefender.qttttt.by0079yy00790079(java.lang.String, java.lang.String, boolean):com.threatmetrix.TrustDefender.qttttt");
    }

    public void byyy007900790079(int i) {
        this.bf0066f0066ff = i;
    }

    @Nonnull
    public qttttt byyyy00790079(String str, @Nullable String str2) {
        by0079yy00790079(str, str2, false);
        return this;
    }
}
