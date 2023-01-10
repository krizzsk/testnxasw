package kotlin;

import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import net.lingala.zip4j.util.InternalZipConstants;

@JvmInline
@Metadata(mo148867d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 |2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001|B\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u001dJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u001fJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u000bJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u0010\u0005J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u001dJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b6\u0010\u001fJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b8\u0010\"J\u001b\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b:\u0010;J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b<\u0010\u0013J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b=\u0010\u000bJ\u001b\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\b>\u0010?J\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\bA\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bC\u0010\u001dJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bE\u0010\u000bJ\u001b\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bF\u0010\"J\u001b\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bL\u0010\u001dJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bM\u0010\u001fJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bN\u0010\u000bJ\u001b\u0010K\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bO\u0010\"J\u001e\u0010P\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010\u001fJ\u001e\u0010S\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\rH\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\bV\u0010\u001dJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\bW\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bX\u0010\u000bJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bY\u0010\"J\u0010\u0010Z\u001a\u00020[H\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020_H\b¢\u0006\u0004\b`\u0010aJ\u0010\u0010b\u001a\u00020cH\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\rH\b¢\u0006\u0004\bg\u0010/J\u0010\u0010h\u001a\u00020\u0003H\b¢\u0006\u0004\bi\u0010\u0005J\u0010\u0010j\u001a\u00020kH\b¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020oH\u0016¢\u0006\u0004\bp\u0010qJ\u0016\u0010r\u001a\u00020\u000eH\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bs\u0010]J\u0016\u0010t\u001a\u00020\u0011H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010/J\u0016\u0010v\u001a\u00020\u0000H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bw\u0010\u0005J\u0016\u0010x\u001a\u00020\u0016H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010mJ\u001b\u0010z\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b{\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006}"}, mo148868d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: ULong.kt */
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;

    /* renamed from: a */
    private final long f55529a;

    /* renamed from: a */
    private int m41456a(long j) {
        return m41459a(this.f55529a, j);
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ULong m47998boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47999constructorimpl(long j) {
        return j;
    }

    /* renamed from: e */
    private static final byte m41476e(long j) {
        return (byte) ((int) j);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m48000equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m48004unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m48001equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: f */
    private static final short m41485f(long j) {
        return (short) ((int) j);
    }

    /* renamed from: g */
    private static final int m41486g(long j) {
        return (int) j;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: h */
    private static final long m41493h(long j) {
        return j;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m48002hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: l */
    private static final long m41504l(long j) {
        return j;
    }

    public boolean equals(Object obj) {
        return m48000equalsimpl(this.f55529a, obj);
    }

    public int hashCode() {
        return m48002hashCodeimpl(this.f55529a);
    }

    public String toString() {
        return m48003toStringimpl(this.f55529a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m48004unboximpl() {
        return this.f55529a;
    }

    private /* synthetic */ ULong(long j) {
        this.f55529a = j;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m41456a(((ULong) obj).m48004unboximpl());
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, mo148868d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: ULong.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: a */
    private static final int m41457a(long j, byte b) {
        return UnsignedKt.ulongCompare(j, m47999constructorimpl(((long) b) & 255));
    }

    /* renamed from: a */
    private static final int m41460a(long j, short s) {
        return UnsignedKt.ulongCompare(j, m47999constructorimpl(((long) s) & 65535));
    }

    /* renamed from: a */
    private static final int m41458a(long j, int i) {
        return UnsignedKt.ulongCompare(j, m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: a */
    private static int m41459a(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: b */
    private static final long m41462b(long j, byte b) {
        return m47999constructorimpl(j + m47999constructorimpl(((long) b) & 255));
    }

    /* renamed from: b */
    private static final long m41465b(long j, short s) {
        return m47999constructorimpl(j + m47999constructorimpl(((long) s) & 65535));
    }

    /* renamed from: b */
    private static final long m41463b(long j, int i) {
        return m47999constructorimpl(j + m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: b */
    private static final long m41464b(long j, long j2) {
        return m47999constructorimpl(j + j2);
    }

    /* renamed from: c */
    private static final long m41467c(long j, byte b) {
        return m47999constructorimpl(j - m47999constructorimpl(((long) b) & 255));
    }

    /* renamed from: c */
    private static final long m41470c(long j, short s) {
        return m47999constructorimpl(j - m47999constructorimpl(((long) s) & 65535));
    }

    /* renamed from: c */
    private static final long m41468c(long j, int i) {
        return m47999constructorimpl(j - m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: c */
    private static final long m41469c(long j, long j2) {
        return m47999constructorimpl(j - j2);
    }

    /* renamed from: d */
    private static final long m41472d(long j, byte b) {
        return m47999constructorimpl(j * m47999constructorimpl(((long) b) & 255));
    }

    /* renamed from: d */
    private static final long m41475d(long j, short s) {
        return m47999constructorimpl(j * m47999constructorimpl(((long) s) & 65535));
    }

    /* renamed from: d */
    private static final long m41473d(long j, int i) {
        return m47999constructorimpl(j * m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: d */
    private static final long m41474d(long j, long j2) {
        return m47999constructorimpl(j * j2);
    }

    /* renamed from: e */
    private static final long m41477e(long j, byte b) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, m47999constructorimpl(((long) b) & 255));
    }

    /* renamed from: e */
    private static final long m41480e(long j, short s) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, m47999constructorimpl(((long) s) & 65535));
    }

    /* renamed from: e */
    private static final long m41478e(long j, int i) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: e */
    private static final long m41479e(long j, long j2) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: f */
    private static final long m41481f(long j, byte b) {
        return UnsignedKt.m48051ulongRemaindereb3DHEI(j, m47999constructorimpl(((long) b) & 255));
    }

    /* renamed from: f */
    private static final long m41484f(long j, short s) {
        return UnsignedKt.m48051ulongRemaindereb3DHEI(j, m47999constructorimpl(((long) s) & 65535));
    }

    /* renamed from: f */
    private static final long m41482f(long j, int i) {
        return UnsignedKt.m48051ulongRemaindereb3DHEI(j, m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: f */
    private static final long m41483f(long j, long j2) {
        return UnsignedKt.m48051ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: g */
    private static final long m41487g(long j, byte b) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, m47999constructorimpl(((long) b) & 255));
    }

    /* renamed from: g */
    private static final long m41490g(long j, short s) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, m47999constructorimpl(((long) s) & 65535));
    }

    /* renamed from: g */
    private static final long m41488g(long j, int i) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    /* renamed from: g */
    private static final long m41489g(long j, long j2) {
        return UnsignedKt.m48050ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: h */
    private static final byte m41491h(long j, byte b) {
        return UByte.m47949constructorimpl((byte) ((int) UnsignedKt.m48051ulongRemaindereb3DHEI(j, m47999constructorimpl(((long) b) & 255))));
    }

    /* renamed from: h */
    private static final short m41495h(long j, short s) {
        return UShort.m48024constructorimpl((short) ((int) UnsignedKt.m48051ulongRemaindereb3DHEI(j, m47999constructorimpl(((long) s) & 65535))));
    }

    /* renamed from: h */
    private static final int m41492h(long j, int i) {
        return UInt.m47974constructorimpl((int) UnsignedKt.m48051ulongRemaindereb3DHEI(j, m47999constructorimpl(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT)));
    }

    /* renamed from: h */
    private static final long m41494h(long j, long j2) {
        return UnsignedKt.m48051ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: b */
    private static final long m41461b(long j) {
        return m47999constructorimpl(j + 1);
    }

    /* renamed from: c */
    private static final long m41466c(long j) {
        return m47999constructorimpl(j - 1);
    }

    /* renamed from: i */
    private static final ULongRange m41498i(long j, long j2) {
        return new ULongRange(j, j2, (DefaultConstructorMarker) null);
    }

    /* renamed from: i */
    private static final long m41497i(long j, int i) {
        return m47999constructorimpl(j << i);
    }

    /* renamed from: j */
    private static final long m41499j(long j, int i) {
        return m47999constructorimpl(j >>> i);
    }

    /* renamed from: j */
    private static final long m41500j(long j, long j2) {
        return m47999constructorimpl(j & j2);
    }

    /* renamed from: k */
    private static final long m41503k(long j, long j2) {
        return m47999constructorimpl(j | j2);
    }

    /* renamed from: l */
    private static final long m41505l(long j, long j2) {
        return m47999constructorimpl(j ^ j2);
    }

    /* renamed from: d */
    private static final long m41471d(long j) {
        return m47999constructorimpl(~j);
    }

    /* renamed from: i */
    private static final byte m41496i(long j) {
        return UByte.m47949constructorimpl((byte) ((int) j));
    }

    /* renamed from: j */
    private static final short m41501j(long j) {
        return UShort.m48024constructorimpl((short) ((int) j));
    }

    /* renamed from: k */
    private static final int m41502k(long j) {
        return UInt.m47974constructorimpl((int) j);
    }

    /* renamed from: m */
    private static final float m41506m(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: n */
    private static final double m41507n(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m48003toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }
}
