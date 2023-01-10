package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirementTable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final VersionRequirementTable f5410b = new VersionRequirementTable(CollectionsKt.emptyList());

    /* renamed from: a */
    private final List<ProtoBuf.VersionRequirement> f5411a;

    public /* synthetic */ VersionRequirementTable(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }

    private VersionRequirementTable(List<ProtoBuf.VersionRequirement> list) {
        this.f5411a = list;
    }

    public final ProtoBuf.VersionRequirement get(int i) {
        return (ProtoBuf.VersionRequirement) CollectionsKt.getOrNull(this.f5411a, i);
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.f5410b;
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable versionRequirementTable) {
            Intrinsics.checkNotNullParameter(versionRequirementTable, "table");
            if (versionRequirementTable.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = versionRequirementTable.getRequirementList();
            Intrinsics.checkNotNullExpressionValue(requirementList, "table.requirementList");
            return new VersionRequirementTable(requirementList, (DefaultConstructorMarker) null);
        }
    }
}
