package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.utils.Utils;
import com.didi.raven.config.RavenKey;
import com.didi.remotereslibrary.Config;
import com.didi.sdk.util.GlobalCountryCode;
import com.didiglobal.domainservice.utils.DomainConstants;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.osgi.framework.VersionRange;

@JvmInline
@Metadata(mo148867d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b@\u0018\u0000 ¬\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¬\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010WJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010XJ\u001b\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001a\u0010[\u001a\u00020\\2\b\u0010Q\u001a\u0004\u0018\u00010]HÖ\u0003¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\tHÖ\u0001¢\u0006\u0004\ba\u0010\rJ\r\u0010b\u001a\u00020\\¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\\H\u0002¢\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\\H\u0002¢\u0006\u0004\bh\u0010dJ\r\u0010i\u001a\u00020\\¢\u0006\u0004\bj\u0010dJ\r\u0010k\u001a\u00020\\¢\u0006\u0004\bl\u0010dJ\r\u0010m\u001a\u00020\\¢\u0006\u0004\bn\u0010dJ\u001b\u0010o\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010qJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010WJ\u001e\u0010t\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bu\u0010XJ \u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2v\u0010x\u001ar\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(|\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hw0yH\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0001\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2b\u0010x\u001a^\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(}\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hw0\u0001H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001Jw\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w2M\u0010x\u001aI\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(~\u0012\u0013\u0012\u00110\t¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hw0\u0001H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001Jb\u0010v\u001a\u0002Hw\"\u0004\b\u0000\u0010w28\u0010x\u001a4\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bz\u0012\b\b{\u0012\u0004\b\b(\u0012\u0014\u0012\u00120\t¢\u0006\r\bz\u0012\t\b{\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hw0\u0001H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000f2\f\u0010\u0001\u001a\u00070Dj\u0003`\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\t2\f\u0010\u0001\u001a\u00070Dj\u0003`\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00032\f\u0010\u0001\u001a\u00070Dj\u0003`\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0001\u0010\u0005J\u0011\u0010\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0001\u0010\u0005J\u0013\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b\u0001\u0010\u0001J*\u0010\u0001\u001a\u00030\u00012\f\u0010\u0001\u001a\u00070Dj\u0003`\u00012\t\b\u0002\u0010\u0001\u001a\u00020\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0018\u0010 \u0001\u001a\u00020\u0000H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b¡\u0001\u0010\u0005JK\u0010¢\u0001\u001a\u00030£\u0001*\b0¤\u0001j\u0003`¥\u00012\u0007\u0010¦\u0001\u001a\u00020\t2\u0007\u0010§\u0001\u001a\u00020\t2\u0007\u0010¨\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010©\u0001\u001a\u00020\\H\u0002¢\u0006\u0006\bª\u0001\u0010«\u0001R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\u0005R\u001a\u00101\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR\u001a\u0010=\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR\u0014\u0010C\u001a\u00020D8BX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0015\u0010G\u001a\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\rR\u0014\u0010I\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b20\u0001¨\u0006­\u0001"}, mo148868d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays$annotations", "getInWholeDays-impl", "inWholeHours", "getInWholeHours$annotations", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds$annotations", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds$annotations", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes$annotations", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds$annotations", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds$annotations", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(JLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(JLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "Companion", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: Duration.kt */
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final long f5994b = m46450constructorimpl(0);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final long f5995c = DurationKt.m5610d(4611686018427387903L);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final long f5996d = DurationKt.m5610d(-4611686018427387903L);

    /* renamed from: a */
    private final long f5997a;

    /* renamed from: a */
    private static final long m5593a(long j) {
        return j >> 1;
    }

    /* renamed from: b */
    private static final int m5596b(long j) {
        return ((int) j) & 1;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m46448boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: c */
    private static final boolean m5597c(long j) {
        return (((int) j) & 1) == 0;
    }

    /* renamed from: d */
    private static final boolean m5598d(long j) {
        return (((int) j) & 1) == 1;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m46454equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m46499unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m46455equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static /* synthetic */ void getInWholeDays$annotations() {
    }

    public static /* synthetic */ void getInWholeHours$annotations() {
    }

    public static /* synthetic */ void getInWholeMicroseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeMilliseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeMinutes$annotations() {
    }

    public static /* synthetic */ void getInWholeNanoseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeSeconds$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m46475hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m46478isNegativeimpl(long j) {
        return j < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m46479isPositiveimpl(long j) {
        return j > 0;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m46498compareToLRDsOJo(long j) {
        return m46449compareToLRDsOJo(this.f5997a, j);
    }

    public boolean equals(Object obj) {
        return m46454equalsimpl(this.f5997a, obj);
    }

    public int hashCode() {
        return m46475hashCodeimpl(this.f5997a);
    }

    public String toString() {
        return m46494toStringimpl(this.f5997a);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m46499unboximpl() {
        return this.f5997a;
    }

    private /* synthetic */ Duration(long j) {
        this.f5997a = j;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m46498compareToLRDsOJo(((Duration) obj).m46499unboximpl());
    }

    /* renamed from: e */
    private static final TimeUnit m5599e(long j) {
        return m5597c(j) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m46450constructorimpl(long j) {
        if (m5597c(j)) {
            long a = m5593a(j);
            if (-4611686018426999999L > a || 4611686018426999999L < a) {
                throw new AssertionError(m5593a(j) + " ns is out of nanoseconds range");
            }
        } else {
            long a2 = m5593a(j);
            if (-4611686018427387903L > a2 || 4611686018427387903L < a2) {
                throw new AssertionError(m5593a(j) + " ms is out of milliseconds range");
            }
            long a3 = m5593a(j);
            if (-4611686018426L <= a3 && 4611686018426L >= a3) {
                throw new AssertionError(m5593a(j) + " ms is denormalized");
            }
        }
        return j;
    }

    @Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0017J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0017J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0019J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0015J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0017J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0019J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'J\u001d\u0010(\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010'J\u001d\u0010*\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b+J\u001d\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020%H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b-J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0015J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0017J\u001d\u0010.\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u00060"}, mo148868d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "days", "days-UwyO8pc", "(D)J", "", "(I)J", "", "(J)J", "hours", "hours-UwyO8pc", "microseconds", "microseconds-UwyO8pc", "milliseconds", "milliseconds-UwyO8pc", "minutes", "minutes-UwyO8pc", "nanoseconds", "nanoseconds-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "parseOrNull", "parseOrNull-FghU774", "seconds", "seconds-UwyO8pc", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: Duration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m46505getZEROUwyO8pc() {
            return Duration.f5994b;
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m46503getINFINITEUwyO8pc() {
            return Duration.f5995c;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m46504getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.f5996d;
        }

        public final double convert(double d, TimeUnit timeUnit, TimeUnit timeUnit2) {
            Intrinsics.checkNotNullParameter(timeUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(timeUnit2, "targetUnit");
            return DurationUnitKt.convertDurationUnit(d, timeUnit, timeUnit2);
        }

        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m46519nanosecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.NANOSECONDS);
        }

        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m46520nanosecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.NANOSECONDS);
        }

        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m46518nanosecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.NANOSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m46510microsecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.MICROSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m46511microsecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.MICROSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m46509microsecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.MICROSECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m46513millisecondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.MILLISECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m46514millisecondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.MILLISECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m46512millisecondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.MILLISECONDS);
        }

        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m46526secondsUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.SECONDS);
        }

        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m46527secondsUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.SECONDS);
        }

        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m46525secondsUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.SECONDS);
        }

        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m46516minutesUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.MINUTES);
        }

        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m46517minutesUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.MINUTES);
        }

        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m46515minutesUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.MINUTES);
        }

        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m46507hoursUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.HOURS);
        }

        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m46508hoursUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.HOURS);
        }

        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m46506hoursUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.HOURS);
        }

        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m46501daysUwyO8pc(int i) {
            return DurationKt.toDuration(i, TimeUnit.DAYS);
        }

        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m46502daysUwyO8pc(long j) {
            return DurationKt.toDuration(j, TimeUnit.DAYS);
        }

        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m46500daysUwyO8pc(double d) {
            return DurationKt.toDuration(d, TimeUnit.DAYS);
        }

        /* renamed from: parse-UwyO8pc  reason: not valid java name */
        public final long m46521parseUwyO8pc(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return DurationKt.m5605a(str, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + str + "'.", e);
            }
        }

        /* renamed from: parseIsoString-UwyO8pc  reason: not valid java name */
        public final long m46522parseIsoStringUwyO8pc(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return DurationKt.m5605a(str, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + str + "'.", e);
            }
        }

        /* renamed from: parseOrNull-FghU774  reason: not valid java name */
        public final Duration m46524parseOrNullFghU774(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return Duration.m46448boximpl(DurationKt.m5605a(str, false));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        /* renamed from: parseIsoStringOrNull-FghU774  reason: not valid java name */
        public final Duration m46523parseIsoStringOrNullFghU774(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            try {
                return Duration.m46448boximpl(DurationKt.m5605a(str, true));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m46497unaryMinusUwyO8pc(long j) {
        return DurationKt.m5603a(-m5593a(j), ((int) j) & 1);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m46481plusLRDsOJo(long j, long j2) {
        if (m46477isInfiniteimpl(j)) {
            if (m46476isFiniteimpl(j2) || (j2 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m46477isInfiniteimpl(j2)) {
            return j2;
        } else {
            if ((((int) j) & 1) == (((int) j2) & 1)) {
                long a = m5593a(j) + m5593a(j2);
                if (m5597c(j)) {
                    return DurationKt.m5611e(a);
                }
                return DurationKt.m5612f(a);
            } else if (m5598d(j)) {
                return m5594a(j, m5593a(j), m5593a(j2));
            } else {
                return m5594a(j, m5593a(j2), m5593a(j));
            }
        }
    }

    /* renamed from: a */
    private static final long m5594a(long j, long j2, long j3) {
        long access$nanosToMillis = DurationKt.m5602a(j3);
        long j4 = j2 + access$nanosToMillis;
        if (-4611686018426L > j4 || 4611686018426L < j4) {
            return DurationKt.m5610d(RangesKt.coerceIn(j4, -4611686018427387903L, 4611686018427387903L));
        }
        return DurationKt.m5609c(DurationKt.m5608b(j4) + (j3 - DurationKt.m5608b(access$nanosToMillis)));
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m46480minusLRDsOJo(long j, long j2) {
        return m46481plusLRDsOJo(j, m46497unaryMinusUwyO8pc(j2));
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m46483timesUwyO8pc(long j, int i) {
        if (m46477isInfiniteimpl(j)) {
            if (i != 0) {
                return i > 0 ? j : m46497unaryMinusUwyO8pc(j);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        } else if (i == 0) {
            return f5994b;
        } else {
            long a = m5593a(j);
            long j2 = (long) i;
            long j3 = a * j2;
            if (m5597c(j)) {
                if (-2147483647L <= a && 2147483647L >= a) {
                    return DurationKt.m5609c(j3);
                }
                if (j3 / j2 == a) {
                    return DurationKt.m5611e(j3);
                }
                long access$nanosToMillis = DurationKt.m5602a(a);
                long j4 = access$nanosToMillis * j2;
                long access$nanosToMillis2 = DurationKt.m5602a((a - DurationKt.m5608b(access$nanosToMillis)) * j2) + j4;
                if (j4 / j2 != access$nanosToMillis || (access$nanosToMillis2 ^ j4) < 0) {
                    return MathKt.getSign(a) * MathKt.getSign(i) > 0 ? f5995c : f5996d;
                }
                return DurationKt.m5610d(RangesKt.coerceIn(access$nanosToMillis2, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L)));
            } else if (j3 / j2 == a) {
                return DurationKt.m5610d(RangesKt.coerceIn(j3, (ClosedRange<Long>) new LongRange(-4611686018427387903L, 4611686018427387903L)));
            } else {
                return MathKt.getSign(a) * MathKt.getSign(i) > 0 ? f5995c : f5996d;
            }
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m46482timesUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (((double) roundToInt) == d) {
            return m46483timesUwyO8pc(j, roundToInt);
        }
        TimeUnit e = m5599e(j);
        return DurationKt.toDuration(m46488toDoubleimpl(j, e) * d, e);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m46453divUwyO8pc(long j, int i) {
        if (i == 0) {
            if (m46479isPositiveimpl(j)) {
                return f5995c;
            }
            if (m46478isNegativeimpl(j)) {
                return f5996d;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m5597c(j)) {
            return DurationKt.m5609c(m5593a(j) / ((long) i));
        } else {
            if (m46477isInfiniteimpl(j)) {
                return m46483timesUwyO8pc(j, MathKt.getSign(i));
            }
            long j2 = (long) i;
            long a = m5593a(j) / j2;
            if (-4611686018426L > a || 4611686018426L < a) {
                return DurationKt.m5610d(a);
            }
            return DurationKt.m5609c(DurationKt.m5608b(a) + (DurationKt.m5608b(m5593a(j) - (a * j2)) / j2));
        }
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m46452divUwyO8pc(long j, double d) {
        int roundToInt = MathKt.roundToInt(d);
        if (((double) roundToInt) == d && roundToInt != 0) {
            return m46453divUwyO8pc(j, roundToInt);
        }
        TimeUnit e = m5599e(j);
        return DurationKt.toDuration(m46488toDoubleimpl(j, e) / d, e);
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m46451divLRDsOJo(long j, long j2) {
        TimeUnit timeUnit = (TimeUnit) ComparisonsKt.maxOf(m5599e(j), m5599e(j2));
        return m46488toDoubleimpl(j, timeUnit) / m46488toDoubleimpl(j2, timeUnit);
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m46477isInfiniteimpl(long j) {
        return j == f5995c || j == f5996d;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m46476isFiniteimpl(long j) {
        return !m46477isInfiniteimpl(j);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m46456getAbsoluteValueUwyO8pc(long j) {
        return m46478isNegativeimpl(j) ? m46497unaryMinusUwyO8pc(j) : j;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m46449compareToLRDsOJo(long j, long j2) {
        long j3 = j ^ j2;
        if (j3 < 0 || (((int) j3) & 1) == 0) {
            return (j > j2 ? 1 : (j == j2 ? 0 : -1));
        }
        int i = (((int) j) & 1) - (((int) j2) & 1);
        return m46478isNegativeimpl(j) ? -i : i;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m46487toComponentsimpl(long j, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, "action");
        return function5.invoke(Integer.valueOf(m46489toIntimpl(j, TimeUnit.DAYS)), Integer.valueOf(m46457getHoursComponentimpl(j)), Integer.valueOf(m46472getMinutesComponentimpl(j)), Integer.valueOf(m46474getSecondsComponentimpl(j)), Integer.valueOf(m46473getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m46486toComponentsimpl(long j, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, "action");
        return function4.invoke(Integer.valueOf(m46489toIntimpl(j, TimeUnit.HOURS)), Integer.valueOf(m46472getMinutesComponentimpl(j)), Integer.valueOf(m46474getSecondsComponentimpl(j)), Integer.valueOf(m46473getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m46485toComponentsimpl(long j, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, "action");
        return function3.invoke(Integer.valueOf(m46489toIntimpl(j, TimeUnit.MINUTES)), Integer.valueOf(m46474getSecondsComponentimpl(j)), Integer.valueOf(m46473getNanosecondsComponentimpl(j)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m46484toComponentsimpl(long j, Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return function2.invoke(Long.valueOf(m46471getInWholeSecondsimpl(j)), Integer.valueOf(m46473getNanosecondsComponentimpl(j)));
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m46457getHoursComponentimpl(long j) {
        if (m46477isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m46466getInWholeHoursimpl(j) % ((long) 24));
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m46472getMinutesComponentimpl(long j) {
        if (m46477isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m46469getInWholeMinutesimpl(j) % ((long) 60));
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m46474getSecondsComponentimpl(long j) {
        if (m46477isInfiniteimpl(j)) {
            return 0;
        }
        return (int) (m46471getInWholeSecondsimpl(j) % ((long) 60));
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m46473getNanosecondsComponentimpl(long j) {
        long j2;
        if (m46477isInfiniteimpl(j)) {
            return 0;
        }
        if (m5598d(j)) {
            j2 = DurationKt.m5608b(m5593a(j) % ((long) 1000));
        } else {
            j2 = m5593a(j) % ((long) Utils.SECOND_IN_NANOS);
        }
        return (int) j2;
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m46488toDoubleimpl(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (j == f5995c) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == f5996d) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit((double) m5593a(j), m5599e(j), timeUnit);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m46491toLongimpl(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (j == f5995c) {
            return Long.MAX_VALUE;
        }
        if (j == f5996d) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m5593a(j), m5599e(j), timeUnit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m46489toIntimpl(long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return (int) RangesKt.coerceIn(m46491toLongimpl(j, timeUnit), (long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m46458getInDaysimpl(long j) {
        return m46488toDoubleimpl(j, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m46459getInHoursimpl(long j) {
        return m46488toDoubleimpl(j, TimeUnit.HOURS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m46462getInMinutesimpl(long j) {
        return m46488toDoubleimpl(j, TimeUnit.MINUTES);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m46464getInSecondsimpl(long j) {
        return m46488toDoubleimpl(j, TimeUnit.SECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m46461getInMillisecondsimpl(long j) {
        return m46488toDoubleimpl(j, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m46460getInMicrosecondsimpl(long j) {
        return m46488toDoubleimpl(j, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m46463getInNanosecondsimpl(long j) {
        return m46488toDoubleimpl(j, TimeUnit.NANOSECONDS);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m46465getInWholeDaysimpl(long j) {
        return m46491toLongimpl(j, TimeUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m46466getInWholeHoursimpl(long j) {
        return m46491toLongimpl(j, TimeUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m46469getInWholeMinutesimpl(long j) {
        return m46491toLongimpl(j, TimeUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m46471getInWholeSecondsimpl(long j) {
        return m46491toLongimpl(j, TimeUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m46468getInWholeMillisecondsimpl(long j) {
        return (!m5598d(j) || !m46476isFiniteimpl(j)) ? m46491toLongimpl(j, TimeUnit.MILLISECONDS) : m5593a(j);
    }

    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m46467getInWholeMicrosecondsimpl(long j) {
        return m46491toLongimpl(j, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m46470getInWholeNanosecondsimpl(long j) {
        long a = m5593a(j);
        if (m5597c(j)) {
            return a;
        }
        if (a > 9223372036854L) {
            return Long.MAX_VALUE;
        }
        if (a < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.m5608b(a);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m46493toLongNanosecondsimpl(long j) {
        return m46470getInWholeNanosecondsimpl(j);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m46492toLongMillisecondsimpl(long j) {
        return m46468getInWholeMillisecondsimpl(j);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m46494toStringimpl(long j) {
        if (j == 0) {
            return "0s";
        }
        if (j == f5995c) {
            return "Infinity";
        }
        if (j == f5996d) {
            return "-Infinity";
        }
        boolean r2 = m46478isNegativeimpl(j);
        StringBuilder sb = new StringBuilder();
        if (r2) {
            sb.append('-');
        }
        long r3 = m46456getAbsoluteValueUwyO8pc(j);
        m46489toIntimpl(r3, TimeUnit.DAYS);
        int r14 = m46457getHoursComponentimpl(r3);
        int r15 = m46472getMinutesComponentimpl(r3);
        int r6 = m46474getSecondsComponentimpl(r3);
        int r7 = m46473getNanosecondsComponentimpl(r3);
        long r8 = m46465getInWholeDaysimpl(r3);
        int i = 0;
        boolean z = r8 != 0;
        boolean z2 = r14 != 0;
        boolean z3 = r15 != 0;
        boolean z4 = (r6 == 0 && r7 == 0) ? false : true;
        if (z) {
            sb.append(r8);
            sb.append('d');
            i = 1;
        }
        if (z2 || (z && (z3 || z4))) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(r14);
            sb.append('h');
            i = i2;
        }
        if (z3 || (z4 && (z2 || z))) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(r15);
            sb.append('m');
            i = i3;
        }
        if (z4) {
            int i4 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (r6 != 0 || z || z2 || z3) {
                m5595a(r3, sb, r6, r7, 9, RavenKey.STACK, false);
            } else if (r7 >= 1000000) {
                m5595a(r3, sb, r7 / 1000000, r7 % 1000000, 6, "ms", false);
            } else if (r7 >= 1000) {
                m5595a(r3, sb, r7 / 1000, r7 % 1000, 3, DomainConstants.DOMAIN_SUFFIX_US, false);
            } else {
                sb.append(r7);
                sb.append(Config.KEY_NS);
            }
            i = i4;
        }
        if (r2 && i > 1) {
            sb.insert(1, VersionRange.LEFT_OPEN).append(VersionRange.RIGHT_OPEN);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: a */
    private static final void m5595a(long j, StringBuilder sb, int i, int i2, int i3, String str, boolean z) {
        sb.append(i);
        if (i2 != 0) {
            sb.append('.');
            CharSequence padStart = StringsKt.padStart(String.valueOf(i2), i3, '0');
            int i4 = -1;
            int length = padStart.length() - 1;
            while (true) {
                if (length < 0) {
                    break;
                }
                if (padStart.charAt(length) != '0') {
                    i4 = length;
                    break;
                }
                length--;
            }
            int i5 = i4 + 1;
            if (z || i5 >= 3) {
                sb.append(padStart, 0, ((i5 + 2) / 3) * 3);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append(padStart, 0, i5);
                Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m46496toStringimpl$default(long j, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m46495toStringimpl(j, timeUnit, i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m46495toStringimpl(long j, TimeUnit timeUnit, int i) {
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        if (i >= 0) {
            double r2 = m46488toDoubleimpl(j, timeUnit);
            if (Double.isInfinite(r2)) {
                return String.valueOf(r2);
            }
            return FormatToDecimalsKt.formatToExactDecimals(r2, RangesKt.coerceAtMost(i, 12)) + DurationUnitKt.shortName(timeUnit);
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i).toString());
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m46490toIsoStringimpl(long j) {
        StringBuilder sb = new StringBuilder();
        if (m46478isNegativeimpl(j)) {
            sb.append('-');
        }
        sb.append(GlobalCountryCode.PORTUGAL);
        long r0 = m46456getAbsoluteValueUwyO8pc(j);
        m46489toIntimpl(r0, TimeUnit.HOURS);
        int r2 = m46472getMinutesComponentimpl(r0);
        int r3 = m46474getSecondsComponentimpl(r0);
        int r4 = m46473getNanosecondsComponentimpl(r0);
        long r02 = m46466getInWholeHoursimpl(r0);
        if (m46477isInfiniteimpl(j)) {
            r02 = 9999999999999L;
        }
        boolean z = true;
        boolean z2 = r02 != 0;
        boolean z3 = (r3 == 0 && r4 == 0) ? false : true;
        if (r2 == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(r02);
            sb.append('H');
        }
        if (z) {
            sb.append(r2);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            m5595a(j, sb, r3, r4, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
