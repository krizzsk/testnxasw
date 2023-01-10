package kshark;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kshark.HprofRecord;
import okio.BufferedSink;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, mo148868d2 = {"<anonymous>", "", "Lokio/BufferedSink;", "invoke"}, mo148869k = 3, mo148870mv = {1, 1, 15})
/* compiled from: HprofWriter.kt */
final class HprofWriter$write$2 extends Lambda implements Function1<BufferedSink, Unit> {
    final /* synthetic */ HprofRecord $record;
    final /* synthetic */ HprofWriter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HprofWriter$write$2(HprofWriter hprofWriter, HprofRecord hprofRecord) {
        super(1);
        this.this$0 = hprofWriter;
        this.$record = hprofRecord;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BufferedSink) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BufferedSink bufferedSink) {
        Intrinsics.checkParameterIsNotNull(bufferedSink, "$receiver");
        bufferedSink.writeInt(((HprofRecord.LoadClassRecord) this.$record).getClassSerialNumber());
        this.this$0.m6342a(bufferedSink, ((HprofRecord.LoadClassRecord) this.$record).getId());
        bufferedSink.writeInt(((HprofRecord.LoadClassRecord) this.$record).getStackTraceSerialNumber());
        this.this$0.m6342a(bufferedSink, ((HprofRecord.LoadClassRecord) this.$record).getClassNameStringId());
    }
}
