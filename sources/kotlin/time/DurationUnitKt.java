package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"kotlin/time/DurationUnitKt__DurationUnitJvmKt", "kotlin/time/DurationUnitKt__DurationUnitKt"}, mo148869k = 4, mo148870mv = {1, 5, 1}, mo148872xi = 1)
public final class DurationUnitKt extends C2725c {

    @Metadata(mo148869k = 3, mo148870mv = {1, 5, 1})
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

    private DurationUnitKt() {
    }
}
