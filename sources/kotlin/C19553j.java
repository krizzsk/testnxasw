package kotlin;

@Metadata(mo148867d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\b¨\u0006\u000b"}, mo148868d2 = {"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, mo148869k = 5, mo148870mv = {1, 5, 1}, mo148872xi = 1, mo148873xs = "kotlin/NumbersKt")
/* renamed from: kotlin.j */
/* compiled from: Numbers.kt */
class C19553j extends C19552i {
    public static final byte rotateLeft(byte b, int i) {
        byte b2 = i & 7;
        return (byte) (((b & 255) >>> (8 - b2)) | (b << b2));
    }

    public static final short rotateLeft(short s, int i) {
        short s2 = i & 15;
        return (short) (((s & UShort.MAX_VALUE) >>> (16 - s2)) | (s << s2));
    }

    public static final byte rotateRight(byte b, int i) {
        byte b2 = i & 7;
        return (byte) (((b & 255) >>> b2) | (b << (8 - b2)));
    }

    public static final short rotateRight(short s, int i) {
        short s2 = i & 15;
        return (short) (((s & UShort.MAX_VALUE) >>> s2) | (s << (16 - s2)));
    }

    /* renamed from: a */
    private static final int m41710a(byte b) {
        return Integer.bitCount(b & 255);
    }

    /* renamed from: b */
    private static final int m41712b(byte b) {
        return Integer.numberOfLeadingZeros(b & 255) - 24;
    }

    /* renamed from: c */
    private static final int m41714c(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    /* renamed from: d */
    private static final byte m41716d(byte b) {
        return (byte) Integer.highestOneBit(b & 255);
    }

    /* renamed from: e */
    private static final byte m41718e(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    /* renamed from: a */
    private static final int m41711a(short s) {
        return Integer.bitCount(s & UShort.MAX_VALUE);
    }

    /* renamed from: b */
    private static final int m41713b(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.MAX_VALUE) - 16;
    }

    /* renamed from: c */
    private static final int m41715c(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    /* renamed from: d */
    private static final short m41717d(short s) {
        return (short) Integer.highestOneBit(s & UShort.MAX_VALUE);
    }

    /* renamed from: e */
    private static final short m41719e(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
