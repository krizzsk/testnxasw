package kshark.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kshark.HeapField;
import kshark.HeapObject;
import kshark.HeapValue;
import kshark.ValueHolder;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006\u001a"}, mo148868d2 = {"Lkshark/internal/KeyedWeakReferenceMirror;", "", "referent", "Lkshark/ValueHolder$ReferenceHolder;", "key", "", "description", "watchDurationMillis", "", "retainedDurationMillis", "(Lkshark/ValueHolder$ReferenceHolder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", "getDescription", "()Ljava/lang/String;", "hasReferent", "", "getHasReferent", "()Z", "isRetained", "getKey", "getReferent", "()Lkshark/ValueHolder$ReferenceHolder;", "getRetainedDurationMillis", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getWatchDurationMillis", "Companion", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
/* compiled from: KeyedWeakReferenceMirror.kt */
public final class KeyedWeakReferenceMirror {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: h */
    private static final String f6497h = "Unknown (legacy)";

    /* renamed from: a */
    private final boolean f6498a;

    /* renamed from: b */
    private final boolean f6499b;

    /* renamed from: c */
    private final ValueHolder.ReferenceHolder f6500c;

    /* renamed from: d */
    private final String f6501d;

    /* renamed from: e */
    private final String f6502e;

    /* renamed from: f */
    private final Long f6503f;

    /* renamed from: g */
    private final Long f6504g;

    public KeyedWeakReferenceMirror(ValueHolder.ReferenceHolder referenceHolder, String str, String str2, Long l, Long l2) {
        Intrinsics.checkParameterIsNotNull(referenceHolder, "referent");
        Intrinsics.checkParameterIsNotNull(str, "key");
        Intrinsics.checkParameterIsNotNull(str2, "description");
        this.f6500c = referenceHolder;
        this.f6501d = str;
        this.f6502e = str2;
        this.f6503f = l;
        this.f6504g = l2;
        boolean z = true;
        this.f6498a = referenceHolder.getValue() != 0;
        Long l3 = this.f6504g;
        if (!(l3 == null || l3 == null || l3.longValue() != -1)) {
            z = false;
        }
        this.f6499b = z;
    }

    public final ValueHolder.ReferenceHolder getReferent() {
        return this.f6500c;
    }

    public final String getKey() {
        return this.f6501d;
    }

    public final String getDescription() {
        return this.f6502e;
    }

    public final Long getWatchDurationMillis() {
        return this.f6503f;
    }

    public final Long getRetainedDurationMillis() {
        return this.f6504g;
    }

    public final boolean getHasReferent() {
        return this.f6498a;
    }

    public final boolean isRetained() {
        return this.f6499b;
    }

    @Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lkshark/internal/KeyedWeakReferenceMirror$Companion;", "", "()V", "UNKNOWN_LEGACY", "", "fromInstance", "Lkshark/internal/KeyedWeakReferenceMirror;", "weakRef", "Lkshark/HeapObject$HeapInstance;", "heapDumpUptimeMillis", "", "(Lkshark/HeapObject$HeapInstance;Ljava/lang/Long;)Lkshark/internal/KeyedWeakReferenceMirror;", "shark"}, mo148869k = 1, mo148870mv = {1, 1, 15})
    /* compiled from: KeyedWeakReferenceMirror.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeyedWeakReferenceMirror fromInstance(HeapObject.HeapInstance heapInstance, Long l) {
            Long l2;
            String str;
            HeapValue value;
            Intrinsics.checkParameterIsNotNull(heapInstance, "weakRef");
            String instanceClassName = heapInstance.getInstanceClassName();
            Long l3 = null;
            if (l != null) {
                long longValue = l.longValue();
                HeapField heapField = heapInstance.get(instanceClassName, "watchUptimeMillis");
                if (heapField == null) {
                    Intrinsics.throwNpe();
                }
                Long asLong = heapField.getValue().getAsLong();
                if (asLong == null) {
                    Intrinsics.throwNpe();
                }
                l2 = Long.valueOf(longValue - asLong.longValue());
            } else {
                l2 = null;
            }
            if (l != null) {
                HeapField heapField2 = heapInstance.get(instanceClassName, "retainedUptimeMillis");
                if (heapField2 == null) {
                    Intrinsics.throwNpe();
                }
                Long asLong2 = heapField2.getValue().getAsLong();
                if (asLong2 == null) {
                    Intrinsics.throwNpe();
                }
                long longValue2 = asLong2.longValue();
                long j = -1;
                if (longValue2 != -1) {
                    j = l.longValue() - longValue2;
                }
                l3 = Long.valueOf(j);
            }
            Long l4 = l3;
            HeapField heapField3 = heapInstance.get(instanceClassName, "key");
            if (heapField3 == null) {
                Intrinsics.throwNpe();
            }
            String readAsJavaString = heapField3.getValue().readAsJavaString();
            if (readAsJavaString == null) {
                Intrinsics.throwNpe();
            }
            HeapField heapField4 = heapInstance.get(instanceClassName, "description");
            if (heapField4 == null) {
                heapField4 = heapInstance.get(instanceClassName, "name");
            }
            if (heapField4 == null || (value = heapField4.getValue()) == null || (str = value.readAsJavaString()) == null) {
                str = KeyedWeakReferenceMirror.f6497h;
            }
            String str2 = str;
            HeapField heapField5 = heapInstance.get("java.lang.ref.Reference", "referent");
            if (heapField5 == null) {
                Intrinsics.throwNpe();
            }
            ValueHolder holder = heapField5.getValue().getHolder();
            if (holder != null) {
                return new KeyedWeakReferenceMirror((ValueHolder.ReferenceHolder) holder, readAsJavaString, str2, l2, l4);
            }
            throw new TypeCastException("null cannot be cast to non-null type kshark.ValueHolder.ReferenceHolder");
        }
    }
}
