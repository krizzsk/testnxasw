package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;

/* compiled from: KotlinClassHeader.kt */
public final class KotlinClassHeader {

    /* renamed from: a */
    private final Kind f5376a;

    /* renamed from: b */
    private final JvmMetadataVersion f5377b;

    /* renamed from: c */
    private final String[] f5378c;

    /* renamed from: d */
    private final String[] f5379d;

    /* renamed from: e */
    private final String[] f5380e;

    /* renamed from: f */
    private final String f5381f;

    /* renamed from: g */
    private final int f5382g;

    /* renamed from: h */
    private final String f5383h;

    /* renamed from: a */
    private final boolean m4930a(int i, int i2) {
        return (i & i2) != 0;
    }

    public KotlinClassHeader(Kind kind, JvmMetadataVersion jvmMetadataVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "metadataVersion");
        this.f5376a = kind;
        this.f5377b = jvmMetadataVersion;
        this.f5378c = strArr;
        this.f5379d = strArr2;
        this.f5380e = strArr3;
        this.f5381f = str;
        this.f5382g = i;
        this.f5383h = str2;
    }

    public final Kind getKind() {
        return this.f5376a;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.f5377b;
    }

    public final String[] getData() {
        return this.f5378c;
    }

    public final String[] getIncompatibleData() {
        return this.f5379d;
    }

    public final String[] getStrings() {
        return this.f5380e;
    }

    /* compiled from: KotlinClassHeader.kt */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        public static final Companion Companion = null;
        /* access modifiers changed from: private */
        public static final Map<Integer, Kind> entryById = null;

        /* renamed from: id */
        private final int f5384id;

        @JvmStatic
        public static final Kind getById(int i) {
            return Companion.getById(i);
        }

        private Kind(int i) {
            this.f5384id = i;
        }

        public final int getId() {
            return this.f5384id;
        }

        static {
            int i;
            Companion = new Companion((DefaultConstructorMarker) null);
            Kind[] values = values();
            Map<Integer, Kind> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        /* compiled from: KotlinClassHeader.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Kind getById(int i) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }
    }

    public final String getMultifileClassName() {
        String str = this.f5381f;
        if (getKind() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        String[] strArr = this.f5378c;
        List<String> list = null;
        if (!(getKind() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        if (strArr != null) {
            list = ArraysKt.asList((T[]) strArr);
        }
        return list != null ? list : CollectionsKt.emptyList();
    }

    public final boolean isUnstableJvmIrBinary() {
        return m4930a(this.f5382g, 16) && !m4930a(this.f5382g, 32);
    }

    public final boolean isUnstableFirBinary() {
        return m4930a(this.f5382g, 64) && !m4930a(this.f5382g, 32);
    }

    public final boolean isPreRelease() {
        return m4930a(this.f5382g, 2);
    }

    public String toString() {
        return this.f5376a + " version=" + this.f5377b;
    }
}
