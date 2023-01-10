package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: VersionRequirement.kt */
public final class VersionRequirement {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private final Version f5405a;

    /* renamed from: b */
    private final ProtoBuf.VersionRequirement.VersionKind f5406b;

    /* renamed from: c */
    private final DeprecationLevel f5407c;

    /* renamed from: d */
    private final Integer f5408d;

    /* renamed from: e */
    private final String f5409e;

    public VersionRequirement(Version version, ProtoBuf.VersionRequirement.VersionKind versionKind, DeprecationLevel deprecationLevel, Integer num, String str) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(versionKind, "kind");
        Intrinsics.checkNotNullParameter(deprecationLevel, "level");
        this.f5405a = version;
        this.f5406b = versionKind;
        this.f5407c = deprecationLevel;
        this.f5408d = num;
        this.f5409e = str;
    }

    public final Version getVersion() {
        return this.f5405a;
    }

    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.f5406b;
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Version {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final Version INFINITY = new Version(256, 256, 256);
        private final int major;
        private final int minor;
        private final int patch;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Version)) {
                return false;
            }
            Version version = (Version) obj;
            return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Version(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }

        public final String asString() {
            int i;
            StringBuilder sb;
            if (this.patch == 0) {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                i = this.minor;
            } else {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append('.');
                sb.append(this.minor);
                sb.append('.');
                i = this.patch;
            }
            sb.append(i);
            return sb.toString();
        }

        public String toString() {
            return asString();
        }

        /* compiled from: VersionRequirement.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Version decode(Integer num, Integer num2) {
                if (num2 != null) {
                    return new Version(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return Version.INFINITY;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.f5405a);
        sb.append(' ');
        sb.append(this.f5407c);
        Integer num = this.f5408d;
        String str = "";
        sb.append(num != null ? Intrinsics.stringPlus(" error ", num) : str);
        String str2 = this.f5409e;
        if (str2 != null) {
            str = Intrinsics.stringPlus(": ", str2);
        }
        sb.append(str);
        return sb.toString();
    }

    /* compiled from: VersionRequirement.kt */
    public static final class Companion {

        /* compiled from: VersionRequirement.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf.VersionRequirement.Level.values().length];
                iArr[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                iArr[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                iArr[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<VersionRequirement> create(MessageLite messageLite, NameResolver nameResolver, VersionRequirementTable versionRequirementTable) {
            List<Integer> list;
            Intrinsics.checkNotNullParameter(messageLite, "proto");
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(versionRequirementTable, "table");
            if (messageLite instanceof ProtoBuf.Class) {
                list = ((ProtoBuf.Class) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Constructor) {
                list = ((ProtoBuf.Constructor) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Function) {
                list = ((ProtoBuf.Function) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Property) {
                list = ((ProtoBuf.Property) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.TypeAlias) {
                list = ((ProtoBuf.TypeAlias) messageLite).getVersionRequirementList();
            } else {
                throw new IllegalStateException(Intrinsics.stringPlus("Unexpected declaration: ", messageLite.getClass()));
            }
            Intrinsics.checkNotNullExpressionValue(list, "ids");
            Collection arrayList = new ArrayList();
            for (Integer num : list) {
                Companion companion = VersionRequirement.Companion;
                Intrinsics.checkNotNullExpressionValue(num, "id");
                VersionRequirement create = companion.create(num.intValue(), nameResolver, versionRequirementTable);
                if (create != null) {
                    arrayList.add(create);
                }
            }
            return (List) arrayList;
        }

        public final VersionRequirement create(int i, NameResolver nameResolver, VersionRequirementTable versionRequirementTable) {
            DeprecationLevel deprecationLevel;
            Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
            Intrinsics.checkNotNullParameter(versionRequirementTable, "table");
            ProtoBuf.VersionRequirement versionRequirement = versionRequirementTable.get(i);
            String str = null;
            if (versionRequirement == null) {
                return null;
            }
            Version decode = Version.Companion.decode(versionRequirement.hasVersion() ? Integer.valueOf(versionRequirement.getVersion()) : null, versionRequirement.hasVersionFull() ? Integer.valueOf(versionRequirement.getVersionFull()) : null);
            ProtoBuf.VersionRequirement.Level level = versionRequirement.getLevel();
            Intrinsics.checkNotNull(level);
            int i2 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 == 1) {
                deprecationLevel = DeprecationLevel.WARNING;
            } else if (i2 == 2) {
                deprecationLevel = DeprecationLevel.ERROR;
            } else if (i2 == 3) {
                deprecationLevel = DeprecationLevel.HIDDEN;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            Integer valueOf = versionRequirement.hasErrorCode() ? Integer.valueOf(versionRequirement.getErrorCode()) : null;
            if (versionRequirement.hasMessage()) {
                str = nameResolver.getString(versionRequirement.getMessage());
            }
            ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement.getVersionKind();
            Intrinsics.checkNotNullExpressionValue(versionKind, "info.versionKind");
            return new VersionRequirement(decode, versionKind, deprecationLevel2, valueOf, str);
        }
    }
}
