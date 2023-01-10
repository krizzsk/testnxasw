package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import net.lingala.zip4j.util.InternalZipConstants;

@JvmInline
@Metadata(mo148867d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001yB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000bJ\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000bJ\u001b\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b%\u0010\u000fJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u001dJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0016\u0010+\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u0005J\u0016\u0010-\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010\u0005J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b0\u0010\u000fJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u001dJ\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u0016J\u001b\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b8\u0010\u001dJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b<\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000fJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000bJ\u001b\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u0016J\u001b\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bD\u0010EJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u000fJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010F\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bI\u0010\u001dJ\u001b\u0010F\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0016J\u001e\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bM\u0010\u000bJ\u001e\u0010N\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u0003H\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000fJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bR\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bS\u0010\u001dJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bT\u0010\u0016J\u0010\u0010U\u001a\u00020VH\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020ZH\b¢\u0006\u0004\b[\u0010\\J\u0010\u0010]\u001a\u00020^H\b¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\b¢\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020dH\b¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020hH\b¢\u0006\u0004\bi\u0010jJ\u000f\u0010k\u001a\u00020lH\u0016¢\u0006\u0004\bm\u0010nJ\u0016\u0010o\u001a\u00020\rH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bp\u0010XJ\u0016\u0010q\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u0010\u0005J\u0016\u0010s\u001a\u00020\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bt\u0010fJ\u0016\u0010u\u001a\u00020\u0014H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010jJ\u001b\u0010w\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bx\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006z"}, mo148868d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: UInt.kt */
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;

    /* renamed from: a */
    private final int f55527a;

    /* renamed from: a */
    private int m41396a(int i) {
        return m41398a(this.f55527a, i);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m47973boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m47974constructorimpl(int i) {
        return i;
    }

    /* renamed from: e */
    private static final byte m41416e(int i) {
        return (byte) i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47975equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m47979unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47976equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: f */
    private static final short m41425f(int i) {
        return (short) i;
    }

    /* renamed from: g */
    private static final int m41426g(int i) {
        return i;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: h */
    private static final long m41433h(int i) {
        return ((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47977hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: k */
    private static final int m41440k(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m47975equalsimpl(this.f55527a, obj);
    }

    public int hashCode() {
        return m47977hashCodeimpl(this.f55527a);
    }

    public String toString() {
        return m47978toStringimpl(this.f55527a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m47979unboximpl() {
        return this.f55527a;
    }

    private /* synthetic */ UInt(int i) {
        this.f55527a = i;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m41396a(((UInt) obj).m47979unboximpl());
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, mo148868d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: UInt.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private static final int m41397a(int i, byte b) {
        return UnsignedKt.uintCompare(i, m47974constructorimpl(b & 255));
    }

    /* renamed from: a */
    private static final int m41400a(int i, short s) {
        return UnsignedKt.uintCompare(i, m47974constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: a */
    private static int m41398a(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* renamed from: a */
    private static final int m41399a(int i, long j) {
        return UnsignedKt.ulongCompare(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT), j);
    }

    /* renamed from: b */
    private static final int m41402b(int i, byte b) {
        return m47974constructorimpl(i + m47974constructorimpl(b & 255));
    }

    /* renamed from: b */
    private static final int m41404b(int i, short s) {
        return m47974constructorimpl(i + m47974constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: b */
    private static final int m41403b(int i, int i2) {
        return m47974constructorimpl(i + i2);
    }

    /* renamed from: b */
    private static final long m41405b(int i, long j) {
        return ULong.m47999constructorimpl(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT) + j);
    }

    /* renamed from: c */
    private static final int m41407c(int i, byte b) {
        return m47974constructorimpl(i - m47974constructorimpl(b & 255));
    }

    /* renamed from: c */
    private static final int m41409c(int i, short s) {
        return m47974constructorimpl(i - m47974constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: c */
    private static final int m41408c(int i, int i2) {
        return m47974constructorimpl(i - i2);
    }

    /* renamed from: c */
    private static final long m41410c(int i, long j) {
        return ULong.m47999constructorimpl(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT) - j);
    }

    /* renamed from: d */
    private static final int m41412d(int i, byte b) {
        return m47974constructorimpl(i * m47974constructorimpl(b & 255));
    }

    /* renamed from: d */
    private static final int m41414d(int i, short s) {
        return m47974constructorimpl(i * m47974constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: d */
    private static final int m41413d(int i, int i2) {
        return m47974constructorimpl(i * i2);
    }

    /* renamed from: d */
    private static final long m41415d(int i, long j) {
        return ULong.m47999constructorimpl(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * j);
    }

    /* renamed from: e */
    private static final int m41417e(int i, byte b) {
        return UnsignedKt.m48048uintDivideJ1ME1BU(i, m47974constructorimpl(b & 255));
    }

    /* renamed from: e */
    private static final int m41419e(int i, short s) {
        return UnsignedKt.m48048uintDivideJ1ME1BU(i, m47974constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: e */
    private static final int m41418e(int i, int i2) {
        return UnsignedKt.m48048uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: e */
    private static final long m41420e(int i, long j) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT), j);
    }

    /* renamed from: f */
    private static final int m41421f(int i, byte b) {
        return UnsignedKt.m48049uintRemainderJ1ME1BU(i, m47974constructorimpl(b & 255));
    }

    /* renamed from: f */
    private static final int m41423f(int i, short s) {
        return UnsignedKt.m48049uintRemainderJ1ME1BU(i, m47974constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: f */
    private static final int m41422f(int i, int i2) {
        return UnsignedKt.m48049uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: f */
    private static final long m41424f(int i, long j) {
        return UnsignedKt.m48051ulongRemaindereb3DHEI(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT), j);
    }

    /* renamed from: g */
    private static final int m41427g(int i, byte b) {
        return UnsignedKt.m48048uintDivideJ1ME1BU(i, m47974constructorimpl(b & 255));
    }

    /* renamed from: g */
    private static final int m41429g(int i, short s) {
        return UnsignedKt.m48048uintDivideJ1ME1BU(i, m47974constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: g */
    private static final int m41428g(int i, int i2) {
        return UnsignedKt.m48048uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: g */
    private static final long m41430g(int i, long j) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT), j);
    }

    /* renamed from: h */
    private static final byte m41431h(int i, byte b) {
        return UByte.m47949constructorimpl((byte) UnsignedKt.m48049uintRemainderJ1ME1BU(i, m47974constructorimpl(b & 255)));
    }

    /* renamed from: h */
    private static final short m41435h(int i, short s) {
        return UShort.m48024constructorimpl((short) UnsignedKt.m48049uintRemainderJ1ME1BU(i, m47974constructorimpl(s & UShort.MAX_VALUE)));
    }

    /* renamed from: h */
    private static final int m41432h(int i, int i2) {
        return UnsignedKt.m48049uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: h */
    private static final long m41434h(int i, long j) {
        return UnsignedKt.m48051ulongRemaindereb3DHEI(ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT), j);
    }

    /* renamed from: b */
    private static final int m41401b(int i) {
        return m47974constructorimpl(i + 1);
    }

    /* renamed from: c */
    private static final int m41406c(int i) {
        return m47974constructorimpl(i - 1);
    }

    /* renamed from: i */
    private static final UIntRange m41437i(int i, int i2) {
        return new UIntRange(i, i2, (DefaultConstructorMarker) null);
    }

    /* renamed from: j */
    private static final int m41438j(int i, int i2) {
        return m47974constructorimpl(i << i2);
    }

    /* renamed from: k */
    private static final int m41441k(int i, int i2) {
        return m47974constructorimpl(i >>> i2);
    }

    /* renamed from: l */
    private static final int m41442l(int i, int i2) {
        return m47974constructorimpl(i & i2);
    }

    /* renamed from: m */
    private static final int m41445m(int i, int i2) {
        return m47974constructorimpl(i | i2);
    }

    /* renamed from: n */
    private static final int m41447n(int i, int i2) {
        return m47974constructorimpl(i ^ i2);
    }

    /* renamed from: d */
    private static final int m41411d(int i) {
        return m47974constructorimpl(~i);
    }

    /* renamed from: i */
    private static final byte m41436i(int i) {
        return UByte.m47949constructorimpl((byte) i);
    }

    /* renamed from: j */
    private static final short m41439j(int i) {
        return UShort.m48024constructorimpl((short) i);
    }

    /* renamed from: l */
    private static final long m41443l(int i) {
        return ULong.m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }

    /* renamed from: m */
    private static final float m41444m(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: n */
    private static final double m41446n(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47978toStringimpl(int i) {
        return String.valueOf(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }
}
