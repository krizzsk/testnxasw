package kotlin.random;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import net.lingala.zip4j.util.InternalZipConstants;

@Metadata(mo148867d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a2\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0003*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u001e\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a&\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010 \u001a\u0014\u0010!\u001a\u00020\b*\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\"\u001a\u001e\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a&\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010!\u001a\u00020\b*\u00020\r2\u0006\u0010\u001e\u001a\u00020'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, mo148868d2 = {"checkUIntRangeBounds", "", "from", "Lkotlin/UInt;", "until", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkULongRangeBounds", "Lkotlin/ULong;", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "nextUBytes", "Lkotlin/UByteArray;", "Lkotlin/random/Random;", "size", "", "(Lkotlin/random/Random;I)[B", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "nextUInt", "(Lkotlin/random/Random;)I", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "range", "Lkotlin/ranges/UIntRange;", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "kotlin-stdlib"}, mo148869k = 2, mo148870mv = {1, 5, 1})
/* compiled from: URandom.kt */
public final class URandomKt {
    public static final int nextUInt(Random random) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        return UInt.m47974constructorimpl(random.nextInt());
    }

    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m46384nextUIntqCasIEU(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        return m46383nextUInta8DCA5k(random, 0, i);
    }

    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m46383nextUInta8DCA5k(Random random, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        m46378checkUIntRangeBoundsJ1ME1BU(i, i2);
        return UInt.m47974constructorimpl(random.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    public static final int nextUInt(Random random, UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        Intrinsics.checkNotNullParameter(uIntRange, "range");
        if (uIntRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uIntRange);
        } else if (UnsignedKt.uintCompare(uIntRange.m46388getLastpVg5ArA(), -1) < 0) {
            return m46383nextUInta8DCA5k(random, uIntRange.m46387getFirstpVg5ArA(), UInt.m47974constructorimpl(uIntRange.m46388getLastpVg5ArA() + 1));
        } else {
            if (UnsignedKt.uintCompare(uIntRange.m46387getFirstpVg5ArA(), 0) > 0) {
                return UInt.m47974constructorimpl(m46383nextUInta8DCA5k(random, UInt.m47974constructorimpl(uIntRange.m46387getFirstpVg5ArA() - 1), uIntRange.m46388getLastpVg5ArA()) + 1);
            }
            return nextUInt(random);
        }
    }

    public static final long nextULong(Random random) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        return ULong.m47999constructorimpl(random.nextLong());
    }

    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m46385nextULongV1Xi4fY(Random random, long j) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        return m46386nextULongjmpaWc(random, 0, j);
    }

    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m46386nextULongjmpaWc(Random random, long j, long j2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        m46379checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m47999constructorimpl(random.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    public static final long nextULong(Random random, ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        Intrinsics.checkNotNullParameter(uLongRange, "range");
        if (uLongRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uLongRange);
        } else if (UnsignedKt.ulongCompare(uLongRange.m46394getLastsVKNKU(), -1) < 0) {
            return m46386nextULongjmpaWc(random, uLongRange.m46393getFirstsVKNKU(), ULong.m47999constructorimpl(uLongRange.m46394getLastsVKNKU() + ULong.m47999constructorimpl(((long) 1) & InternalZipConstants.ZIP_64_SIZE_LIMIT)));
        } else {
            if (UnsignedKt.ulongCompare(uLongRange.m46393getFirstsVKNKU(), 0) <= 0) {
                return nextULong(random);
            }
            long r4 = uLongRange.m46393getFirstsVKNKU();
            long j = ((long) 1) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
            return ULong.m47999constructorimpl(m46386nextULongjmpaWc(random, ULong.m47999constructorimpl(r4 - ULong.m47999constructorimpl(j)), uLongRange.m46394getLastsVKNKU()) + ULong.m47999constructorimpl(j));
        }
    }

    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m46380nextUBytesEVgfTAA(Random random, byte[] bArr) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr);
        return bArr;
    }

    public static final byte[] nextUBytes(Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        return UByteArray.m47957constructorimpl(random.nextBytes(i));
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m46382nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m47963getSizeimpl(bArr);
        }
        return m46381nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m46381nextUBytesWvrt4B4(Random random, byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr, i, i2);
        return bArr;
    }

    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m46378checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (!(UnsignedKt.uintCompare(i2, i) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m47973boximpl(i), UInt.m47973boximpl(i2)).toString());
        }
    }

    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m46379checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (!(UnsignedKt.ulongCompare(j2, j) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m47998boximpl(j), ULong.m47998boximpl(j2)).toString());
        }
    }
}
