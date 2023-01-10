package com.didiglobal.travel.infra.time;

import com.airbnb.lottie.utils.Utils;
import com.didi.raven.config.RavenKey;
import com.didi.remotereslibrary.Config;
import com.didiglobal.domainservice.utils.DomainConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b@\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001xB\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b0\u00101J'\u00102\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\"H\u0002¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u0002082\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u00107\u001a\u00020\u00002\u0006\u0010;\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\u001b\u00107\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b<\u0010>J\u0013\u0010?\u001a\u00020@2\b\u0010/\u001a\u0004\u0018\u00010AHÖ\u0003J\t\u0010B\u001a\u00020\tHÖ\u0001J\r\u0010C\u001a\u00020@¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020@H\u0002¢\u0006\u0004\bG\u0010EJ\u000f\u0010H\u001a\u00020@H\u0002¢\u0006\u0004\bI\u0010EJ\r\u0010J\u001a\u00020@¢\u0006\u0004\bK\u0010EJ\r\u0010L\u001a\u00020@¢\u0006\u0004\bM\u0010EJ\r\u0010N\u001a\u00020@¢\u0006\u0004\bO\u0010EJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ\u001b\u0010S\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bT\u0010RJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010;\u001a\u000208H\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010=J\u001b\u0010U\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\bV\u0010>J\u0001\u0010W\u001a\u0002HX\"\u0004\b\u0000\u0010X2u\u0010Y\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(]\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(^\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(`\u0012\u0013\u0012\u00110\t¢\u0006\f\b[\u0012\b\b\\\u0012\u0004\b\b(a\u0012\u0004\u0012\u0002HX0ZH\b¢\u0006\u0004\bb\u0010cJ\u0015\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020\"¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J?\u0010n\u001a\u00020o*\u00060pj\u0002`q2\u0006\u0010r\u001a\u00020\t2\u0006\u0010s\u001a\u00020\t2\u0006\u0010t\u001a\u00020\t2\u0006\u0010e\u001a\u00020i2\u0006\u0010u\u001a\u00020@H\u0002¢\u0006\u0004\bv\u0010wR\u0014\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0005R\u0011\u0010\u0014\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0005R\u0011\u0010\u0016\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0005R\u001a\u0010\u0018\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\rR\u001a\u0010\u001b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u0014\u0010!\u001a\u00020\"8BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0015\u0010%\u001a\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\rR\u0014\u0010'\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0005ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006y"}, mo148868d2 = {"Lcom/didiglobal/travel/infra/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-impl", "hoursComponent", "", "hoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "getInDays-impl", "inHours", "getInHours-impl", "inMillis", "getInMillis-impl", "inMinutes", "getInMinutes-impl", "inSeconds", "getInSeconds-impl", "minutesComponent", "minutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "nanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "secondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-impl", "(JJJ)J", "compareTo", "other", "compareTo-VSBMxCo", "(JJ)I", "convertDurationUnit", "sourceUnit", "targetUnit", "convertDurationUnit-impl", "(JJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)J", "div", "", "div-VSBMxCo", "(JJ)D", "scale", "div-impl", "(JD)J", "(JI)J", "equals", "", "", "hashCode", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-VSBMxCo", "(JJ)J", "plus", "plus-VSBMxCo", "times", "times-impl", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "milliseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toLong", "unit", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-impl", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "lib-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: Duration.kt */
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final long f53986b = m47652constructorimpl(0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final long f53987c = DurationKt.m40253d(4611686018427387903L);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final long f53988d = DurationKt.m40253d(-4611686018427387903L);

    /* renamed from: a */
    private final long f53989a;

    @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            $EnumSwitchMapping$0[TimeUnit.MICROSECONDS.ordinal()] = 2;
            int[] iArr2 = new int[TimeUnit.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[TimeUnit.NANOSECONDS.ordinal()] = 1;
            $EnumSwitchMapping$1[TimeUnit.MICROSECONDS.ordinal()] = 2;
            $EnumSwitchMapping$1[TimeUnit.MILLISECONDS.ordinal()] = 3;
            $EnumSwitchMapping$1[TimeUnit.SECONDS.ordinal()] = 4;
            $EnumSwitchMapping$1[TimeUnit.MINUTES.ordinal()] = 5;
            $EnumSwitchMapping$1[TimeUnit.HOURS.ordinal()] = 6;
            $EnumSwitchMapping$1[TimeUnit.DAYS.ordinal()] = 7;
        }
    }

    /* renamed from: a */
    private static final long m40240a(long j) {
        return j >> 1;
    }

    /* renamed from: b */
    private static final int m40244b(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m47650boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m47652constructorimpl(long j) {
        return j;
    }

    /* renamed from: d */
    private static final boolean m40246d(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: e */
    private static final boolean m40247e(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m47656equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m47682unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m47657equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m47668hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static /* synthetic */ void hoursComponent$annotations() {
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m47671isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m47672isPositiveimpl(long j) {
        return j > 0;
    }

    public static /* synthetic */ void minutesComponent$annotations() {
    }

    public static /* synthetic */ void nanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void secondsComponent$annotations() {
    }

    /* renamed from: compareTo-VSBMxCo  reason: not valid java name */
    public int m47681compareToVSBMxCo(long j) {
        return m47651compareToVSBMxCo(this.f53989a, j);
    }

    public boolean equals(Object obj) {
        return m47656equalsimpl(this.f53989a, obj);
    }

    public int hashCode() {
        return m47668hashCodeimpl(this.f53989a);
    }

    public String toString() {
        return m47679toStringimpl(this.f53989a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m47682unboximpl() {
        return this.f53989a;
    }

    private /* synthetic */ Duration(long j) {
        this.f53989a = j;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m47681compareToVSBMxCo(((Duration) obj).m47682unboximpl());
    }

    /* renamed from: getInMillis-impl  reason: not valid java name */
    public static final long m47662getInMillisimpl(long j) {
        return (!m40247e(j) || !m47669isFiniteimpl(j)) ? m47678toLongimpl(j, TimeUnit.MILLISECONDS) : m40240a(j);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final long m47664getInSecondsimpl(long j) {
        return m47678toLongimpl(j, TimeUnit.SECONDS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final long m47663getInMinutesimpl(long j) {
        return m47678toLongimpl(j, TimeUnit.MINUTES);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final long m47661getInHoursimpl(long j) {
        return m47678toLongimpl(j, TimeUnit.HOURS);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final long m47660getInDaysimpl(long j) {
        return m47678toLongimpl(j, TimeUnit.DAYS);
    }

    /* renamed from: getAbsoluteValue-impl  reason: not valid java name */
    public static final long m47658getAbsoluteValueimpl(long j) {
        return m47671isNegativeimpl(j) ? m47680unaryMinusimpl(j) : j;
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m47659getHoursComponentimpl(long j) {
        if (m47670isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m47661getInHoursimpl(j) % ((long) 24));
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m47665getMinutesComponentimpl(long j) {
        if (m47670isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m47663getInMinutesimpl(j) % ((long) 60));
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m47667getSecondsComponentimpl(long j) {
        if (m47670isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m47664getInSecondsimpl(j) % ((long) 60));
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m47666getNanosecondsComponentimpl(long j) {
        long j2;
        if (m47670isInfiniteimpl(j)) {
            return 0;
        }
        if (m40247e(j)) {
            j2 = DurationKt.m40251b(m40240a(j) % ((long) 1000));
        } else {
            j2 = m40240a(j) % ((long) Utils.SECOND_IN_NANOS);
        }
        return (int) j2;
    }

    /* renamed from: c */
    private static final TimeUnit m40245c(long j) {
        return m40246d(j) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    /* renamed from: unaryMinus-impl  reason: not valid java name */
    public static final long m47680unaryMinusimpl(long j) {
        return DurationKt.m40250a(-m40240a(j), ((int) j) & 1);
    }

    /* renamed from: plus-VSBMxCo  reason: not valid java name */
    public static final long m47674plusVSBMxCo(long j, long j2) {
        if (m47670isInfiniteimpl(j)) {
            if (m47669isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m47670isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long a = m40240a(j) + m40240a(j2);
                if (m40246d(j)) {
                    return DurationKt.m40254e(a);
                }
                return DurationKt.m40255f(a);
            } else if (m40247e(j)) {
                return m40241a(j, m40240a(j), m40240a(j2));
            } else {
                return m40241a(j, m40240a(j2), m40240a(j));
            }
        }
    }

    /* renamed from: minus-VSBMxCo  reason: not valid java name */
    public static final long m47673minusVSBMxCo(long j, long j2) {
        return m47674plusVSBMxCo(j, m47680unaryMinusimpl(j2));
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final long m47676timesimpl(long j, int i) {
        if (m47670isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m47680unaryMinusimpl(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return f53986b;
        } else {
            long a = m40240a(j);
            long j2 = (long) i;
            long j3 = a * j2;
            if (m40246d(j)) {
                if (-2147483647L <= a && 2147483647L >= a) {
                    return DurationKt.m40252c(j3);
                }
                if (j3 / j2 == a) {
                    return DurationKt.m40254e(j3);
                }
                long access$nanosToMillis = DurationKt.m40249a(a);
                long j4 = access$nanosToMillis * j2;
                long access$nanosToMillis2 = DurationKt.m40249a((a - DurationKt.m40251b(access$nanosToMillis)) * j2) + j4;
                if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
                    return MathKt.getSign(a) * MathKt.getSign(i) > 0 ? f53987c : f53988d;
                }
                return DurationKt.m40253d(RangesKt.coerceIn(access$nanosToMillis2, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L)));
            } else if (j3 / j2 == a) {
                return DurationKt.m40253d(RangesKt.coerceIn(j3, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L)));
            } else {
                return MathKt.getSign(a) * MathKt.getSign(i) > 0 ? f53987c : f53988d;
            }
        }
    }

    /* renamed from: times-impl  reason: not valid java name */
    public static final long m47675timesimpl(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (((double) roundToInt) == d) {
            return m47676timesimpl(j, roundToInt);
        }
        TimeUnit c = m40245c(j);
        return Companion.mo131274of((long) (((double) m47678toLongimpl(j, c)) * d), c);
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final long m47655divimpl(long j, int i) {
        if (i == 0) {
            if (m47672isPositiveimpl(j)) {
                return f53987c;
            }
            if (m47671isNegativeimpl(j)) {
                return f53988d;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m40246d(j)) {
            return DurationKt.m40252c(m40240a(j) / ((long) i));
        } else {
            if (m47670isInfiniteimpl(j)) {
                return m47676timesimpl(j, MathKt.getSign(i));
            }
            long j2 = (long) i;
            long a = m40240a(j) / j2;
            if (-4611686018426L > a || 4611686018426L < a) {
                return DurationKt.m40253d(a);
            }
            return DurationKt.m40252c(DurationKt.m40251b(a) + (DurationKt.m40251b(m40240a(j) - (a * j2)) / j2));
        }
    }

    /* renamed from: div-impl  reason: not valid java name */
    public static final long m47654divimpl(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (((double) roundToInt) == d && roundToInt != 0) {
            return m47655divimpl(j, roundToInt);
        }
        TimeUnit c = m40245c(j);
        return Companion.mo131274of((long) (((double) m47678toLongimpl(j, c)) / d), c);
    }

    /* renamed from: div-VSBMxCo  reason: not valid java name */
    public static final double m47653divVSBMxCo(long j, long j2) {
        TimeUnit timeUnit = (TimeUnit) ComparisonsKt.maxOf(m40245c(j), m40245c(j2));
        return ((double) m47678toLongimpl(j, timeUnit)) / ((double) m47678toLongimpl(j2, timeUnit));
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m47679toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == f53987c) {
            return "Infinity";
        }
        if (j == f53988d) {
            return "-Infinity";
        }
        boolean r2 = m47671isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (r2) {
            sb.append('-');
        }
        long r3 = m47658getAbsoluteValueimpl(j);
        long r5 = m47660getInDaysimpl(r3);
        int r7 = m47659getHoursComponentimpl(r3);
        int r8 = m47665getMinutesComponentimpl(r3);
        int r9 = m47667getSecondsComponentimpl(r3);
        int r10 = m47666getNanosecondsComponentimpl(r3);
        int i = 0;
        boolean z = r5 != 0;
        boolean z2 = r7 != 0;
        boolean z3 = r8 != 0;
        boolean z4 = (r9 == 0 && r10 == 0) ? false : true;
        if (z) {
            sb.append(r5);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(r7);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(r8);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (r9 != 0 || z || z2 || z3) {
                m40243a(j, sb, r9, r10, 9, RavenKey.STACK, false);
            } else if (r10 >= 1000000) {
                m40243a(j, sb, r10 / 1000000, r10 % 1000000, 6, "ms", false);
            } else if (r10 >= 1000) {
                m40243a(j, sb, r10 / 1000, r10 % 1000, 3, DomainConstants.DOMAIN_SUFFIX_US, false);
            } else {
                sb.append(r10);
                sb.append(Config.KEY_NS);
            }
            i = i4;
        }
        if (r2 && i > 1) {
            sb.insert(1, VersionRange.LEFT_OPEN).append(VersionRange.RIGHT_OPEN);
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: compareTo-VSBMxCo  reason: not valid java name */
    public static int m47651compareToVSBMxCo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return (j > j2 ? 1 : (j == j2 ? 0 : -1));
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m47671isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m47670isInfiniteimpl(long j) {
        return j == f53987c || j == f53988d;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m47669isFiniteimpl(long j) {
        return !m47670isInfiniteimpl(j);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m47678toLongimpl(long j, TimeUnit timeUnit) {
        Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
        if (j == f53987c) {
            return Long.MAX_VALUE;
        }
        if (j == f53988d) {
            return Long.MIN_VALUE;
        }
        return m40242a(j, m40240a(j), m40245c(j), timeUnit);
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m47677toComponentsimpl(long j, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkParameterIsNotNull(function5, "action");
        return function5.invoke(Long.valueOf(m47660getInDaysimpl(j)), Integer.valueOf(m47659getHoursComponentimpl(j)), Integer.valueOf(m47665getMinutesComponentimpl(j)), Integer.valueOf(m47667getSecondsComponentimpl(j)), Integer.valueOf(m47666getNanosecondsComponentimpl(j)));
    }

    /* renamed from: a */
    private static final long m40242a(long j, long j2, TimeUnit timeUnit, TimeUnit timeUnit2) {
        if (timeUnit == TimeUnit.NANOSECONDS) {
            int i = WhenMappings.$EnumSwitchMapping$0[timeUnit2.ordinal()];
            if (i == 1) {
                return j2;
            }
            if (i == 2) {
                return j2 / ((long) 1000);
            }
            j2 = DurationKt.m40249a(j2);
        }
        switch (WhenMappings.$EnumSwitchMapping$1[timeUnit2.ordinal()]) {
            case 1:
                return DurationKt.m40251b(j2);
            case 2:
                return j2 * ((long) 1000);
            case 3:
                return j2;
            case 4:
                if (j2 >= 1000) {
                    return j2 / ((long) 1000);
                }
                break;
            case 5:
                long j3 = j2 / ((long) 1000);
                long j4 = (long) 60;
                if (j3 >= j4) {
                    return j3 / j4;
                }
                break;
            case 6:
                long j5 = j2 / ((long) 60000);
                long j6 = (long) 60;
                if (j5 >= j6) {
                    return j5 / j6;
                }
                break;
            case 7:
                long j7 = j2 / ((long) 3600000);
                long j8 = (long) 24;
                if (j7 >= j8) {
                    return j7 / j8;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return 0;
    }

    /* renamed from: a */
    private static final long m40241a(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.m40249a(j3);
        long j4 = j2 + access$nanosToMillis;
        if (-4611686018426L > j4 || 4611686018426L < j4) {
            return DurationKt.m40253d(RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.m40252c(DurationKt.m40251b(j4) + (j3 - DurationKt.m40251b(access$nanosToMillis)));
    }

    /* renamed from: a */
    private static final void m40243a(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            String padStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            CharSequence charSequence = padStart;
            int i4 = -1;
            int length = charSequence.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                if (charSequence.charAt(length) != '0') {
                    i4 = length;
                    break;
                }
                length--;
            }
            int i5 = i4 + 1;
            if (z || i5 >= 3) {
                int i6 = ((i5 + 2) / 3) * 3;
                if (padStart != null) {
                    String substring = padStart.substring(0, i6);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            } else if (padStart != null) {
                String substring2 = padStart.substring(0, i5);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                sb.append(substring2);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
        }
        sb.append(str);
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0016\u0010\n\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo148868d2 = {"Lcom/didiglobal/travel/infra/time/Duration$Companion;", "", "()V", "INFINITE", "Lcom/didiglobal/travel/infra/time/Duration;", "getINFINITE", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE$lib_common_release", "ZERO", "getZERO", "millis", "value", "", "(J)J", "of", "unit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)J", "lib-common_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
    /* compiled from: Duration.kt */
    public static final class Companion {

        @Metadata(mo148866bv = {1, 0, 3}, mo148869k = 3, mo148870mv = {1, 1, 16})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TimeUnit.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
                $EnumSwitchMapping$0[TimeUnit.MICROSECONDS.ordinal()] = 2;
                $EnumSwitchMapping$0[TimeUnit.MILLISECONDS.ordinal()] = 3;
                $EnumSwitchMapping$0[TimeUnit.SECONDS.ordinal()] = 4;
                $EnumSwitchMapping$0[TimeUnit.MINUTES.ordinal()] = 5;
                $EnumSwitchMapping$0[TimeUnit.HOURS.ordinal()] = 6;
                $EnumSwitchMapping$0[TimeUnit.DAYS.ordinal()] = 7;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long getZERO() {
            return Duration.f53986b;
        }

        public final long getINFINITE() {
            return Duration.f53987c;
        }

        public final long getNEG_INFINITE$lib_common_release() {
            return Duration.f53988d;
        }

        /* renamed from: of */
        public final long mo131274of(long j, TimeUnit timeUnit) {
            long j2;
            int i;
            Intrinsics.checkParameterIsNotNull(timeUnit, "unit");
            int i2 = timeUnit.compareTo(TimeUnit.MILLISECONDS) < 0 ? 0 : 1;
            switch (WhenMappings.$EnumSwitchMapping$0[timeUnit.ordinal()]) {
                case 1:
                case 3:
                    return DurationKt.m40250a(j, i2);
                case 2:
                case 4:
                    j2 = (long) 1000;
                    break;
                case 5:
                    i = 60000;
                    break;
                case 6:
                    j2 = (long) 3600000;
                    break;
                case 7:
                    j *= (long) 3600000;
                    i = 24;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            j2 = (long) i;
            j *= j2;
            return DurationKt.m40250a(j, i2);
        }

        public final long millis(long j) {
            return DurationKt.m40250a(j, 1);
        }
    }
}
