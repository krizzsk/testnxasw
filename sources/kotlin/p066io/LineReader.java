package kotlin.p066io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, mo148868d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* renamed from: kotlin.io.LineReader */
/* compiled from: Console.kt */
public final class LineReader {
    public static final LineReader INSTANCE = new LineReader();

    /* renamed from: a */
    private static final int f4591a = 32;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static CharsetDecoder f4592b;

    /* renamed from: c */
    private static boolean f4593c;

    /* renamed from: d */
    private static final byte[] f4594d;

    /* renamed from: e */
    private static final char[] f4595e = new char[32];

    /* renamed from: f */
    private static final ByteBuffer f4596f;

    /* renamed from: g */
    private static final CharBuffer f4597g;

    /* renamed from: h */
    private static final StringBuilder f4598h = new StringBuilder();

    static {
        byte[] bArr = new byte[32];
        f4594d = bArr;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        Intrinsics.checkNotNullExpressionValue(wrap, "ByteBuffer.wrap(bytes)");
        f4596f = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(f4595e);
        Intrinsics.checkNotNullExpressionValue(wrap2, "CharBuffer.wrap(chars)");
        f4597g = wrap2;
    }

    private LineReader() {
    }

    public static final /* synthetic */ CharsetDecoder access$getDecoder$p(LineReader lineReader) {
        CharsetDecoder charsetDecoder = f4592b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        return charsetDecoder;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        if (f4598h.length() != 0) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r10 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r10 == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        if (r0 != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r2 != 0) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r10 = m4359a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if ((!kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0.charset(), (java.lang.Object) r11)) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String readLine(java.io.InputStream r10, java.nio.charset.Charset r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = "inputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)     // Catch:{ all -> 0x00db }
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)     // Catch:{ all -> 0x00db }
            java.nio.charset.CharsetDecoder r0 = f4592b     // Catch:{ all -> 0x00db }
            r1 = 1
            if (r0 == 0) goto L_0x0024
            java.nio.charset.CharsetDecoder r0 = f4592b     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x0019
            java.lang.String r2 = "decoder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)     // Catch:{ all -> 0x00db }
        L_0x0019:
            java.nio.charset.Charset r0 = r0.charset()     // Catch:{ all -> 0x00db }
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)     // Catch:{ all -> 0x00db }
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x0027
        L_0x0024:
            r9.m4361a((java.nio.charset.Charset) r11)     // Catch:{ all -> 0x00db }
        L_0x0027:
            r11 = 0
            r0 = 0
            r2 = 0
        L_0x002a:
            int r3 = r10.read()     // Catch:{ all -> 0x00db }
            r4 = 32
            r5 = 10
            r6 = -1
            if (r3 != r6) goto L_0x0050
            java.lang.StringBuilder r10 = f4598h     // Catch:{ all -> 0x00db }
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ all -> 0x00db }
            int r10 = r10.length()     // Catch:{ all -> 0x00db }
            if (r10 != 0) goto L_0x0041
            r10 = 1
            goto L_0x0042
        L_0x0041:
            r10 = 0
        L_0x0042:
            if (r10 == 0) goto L_0x004b
            if (r0 != 0) goto L_0x004b
            if (r2 != 0) goto L_0x004b
            r10 = 0
            monitor-exit(r9)
            return r10
        L_0x004b:
            int r10 = r9.m4359a(r0, r2)     // Catch:{ all -> 0x00db }
            goto L_0x0080
        L_0x0050:
            byte[] r6 = f4594d     // Catch:{ all -> 0x00db }
            int r7 = r0 + 1
            byte r8 = (byte) r3     // Catch:{ all -> 0x00db }
            r6[r0] = r8     // Catch:{ all -> 0x00db }
            if (r3 == r5) goto L_0x0062
            if (r7 == r4) goto L_0x0062
            boolean r0 = f4593c     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x0060
            goto L_0x0062
        L_0x0060:
            r0 = r7
            goto L_0x002a
        L_0x0062:
            java.nio.ByteBuffer r0 = f4596f     // Catch:{ all -> 0x00db }
            r0.limit(r7)     // Catch:{ all -> 0x00db }
            java.nio.CharBuffer r0 = f4597g     // Catch:{ all -> 0x00db }
            r0.position(r2)     // Catch:{ all -> 0x00db }
            int r2 = r9.m4360a((boolean) r11)     // Catch:{ all -> 0x00db }
            if (r2 <= 0) goto L_0x00d5
            char[] r0 = f4595e     // Catch:{ all -> 0x00db }
            int r3 = r2 + -1
            char r0 = r0[r3]     // Catch:{ all -> 0x00db }
            if (r0 != r5) goto L_0x00d5
            java.nio.ByteBuffer r10 = f4596f     // Catch:{ all -> 0x00db }
            r10.position(r11)     // Catch:{ all -> 0x00db }
            r10 = r2
        L_0x0080:
            if (r10 <= 0) goto L_0x009a
            char[] r0 = f4595e     // Catch:{ all -> 0x00db }
            int r2 = r10 + -1
            char r0 = r0[r2]     // Catch:{ all -> 0x00db }
            if (r0 != r5) goto L_0x009a
            int r10 = r10 + -1
            if (r10 <= 0) goto L_0x009a
            char[] r0 = f4595e     // Catch:{ all -> 0x00db }
            int r2 = r10 + -1
            char r0 = r0[r2]     // Catch:{ all -> 0x00db }
            r2 = 13
            if (r0 != r2) goto L_0x009a
            int r10 = r10 + -1
        L_0x009a:
            java.lang.StringBuilder r0 = f4598h     // Catch:{ all -> 0x00db }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x00db }
            int r0 = r0.length()     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            r1 = 0
        L_0x00a6:
            if (r1 == 0) goto L_0x00b1
            char[] r0 = f4595e     // Catch:{ all -> 0x00db }
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00db }
            r1.<init>(r0, r11, r10)     // Catch:{ all -> 0x00db }
            monitor-exit(r9)
            return r1
        L_0x00b1:
            java.lang.StringBuilder r0 = f4598h     // Catch:{ all -> 0x00db }
            char[] r1 = f4595e     // Catch:{ all -> 0x00db }
            r0.append(r1, r11, r10)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r10 = f4598h     // Catch:{ all -> 0x00db }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00db }
            java.lang.String r0 = "sb.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)     // Catch:{ all -> 0x00db }
            java.lang.StringBuilder r0 = f4598h     // Catch:{ all -> 0x00db }
            int r0 = r0.length()     // Catch:{ all -> 0x00db }
            if (r0 <= r4) goto L_0x00ce
            r9.m4363c()     // Catch:{ all -> 0x00db }
        L_0x00ce:
            java.lang.StringBuilder r0 = f4598h     // Catch:{ all -> 0x00db }
            r0.setLength(r11)     // Catch:{ all -> 0x00db }
            monitor-exit(r9)
            return r10
        L_0x00d5:
            int r0 = r9.m4358a()     // Catch:{ all -> 0x00db }
            goto L_0x002a
        L_0x00db:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p066io.LineReader.readLine(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    /* renamed from: a */
    private final int m4360a(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = f4592b;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
            }
            CoderResult decode = charsetDecoder.decode(f4596f, f4597g, z);
            Intrinsics.checkNotNullExpressionValue(decode, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (decode.isError()) {
                m4362b();
                decode.throwException();
            }
            int position = f4597g.position();
            if (!decode.isOverflow()) {
                return position;
            }
            int i = position - 1;
            f4598h.append(f4595e, 0, i);
            f4597g.position(0);
            f4597g.limit(32);
            f4597g.put(f4595e[i]);
        }
    }

    /* renamed from: a */
    private final int m4358a() {
        ByteBuffer byteBuffer = f4596f;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    /* renamed from: a */
    private final int m4359a(int i, int i2) {
        f4596f.limit(i);
        f4597g.position(i2);
        int a = m4360a(true);
        CharsetDecoder charsetDecoder = f4592b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        f4596f.position(0);
        return a;
    }

    /* renamed from: a */
    private final void m4361a(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        f4592b = newDecoder;
        f4596f.clear();
        f4597g.clear();
        f4596f.put((byte) 10);
        f4596f.flip();
        CharsetDecoder charsetDecoder = f4592b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        boolean z = false;
        charsetDecoder.decode(f4596f, f4597g, false);
        if (f4597g.position() == 1 && f4597g.get(0) == 10) {
            z = true;
        }
        f4593c = z;
        m4362b();
    }

    /* renamed from: b */
    private final void m4362b() {
        CharsetDecoder charsetDecoder = f4592b;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
        }
        charsetDecoder.reset();
        f4596f.position(0);
        f4598h.setLength(0);
    }

    /* renamed from: c */
    private final void m4363c() {
        f4598h.setLength(32);
        f4598h.trimToSize();
    }
}
