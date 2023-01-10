package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

/* compiled from: MemberScope.kt */
public final class DescriptorKindFilter {
    public static final DescriptorKindFilter ALL = new DescriptorKindFilter(f5611j, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter CALLABLES = new DescriptorKindFilter(f5614m, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter CLASSIFIERS = new DescriptorKindFilter(f5612k, (List) null, 2, (DefaultConstructorMarker) null);
    public static final Companion Companion;
    public static final DescriptorKindFilter FUNCTIONS = new DescriptorKindFilter(f5609h, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter NON_SINGLETON_CLASSIFIERS = new DescriptorKindFilter(f5605d, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter PACKAGES = new DescriptorKindFilter(f5608g, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter SINGLETON_CLASSIFIERS = new DescriptorKindFilter(f5606e, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter TYPE_ALIASES = new DescriptorKindFilter(f5607f, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter VALUES = new DescriptorKindFilter(f5613l, (List) null, 2, (DefaultConstructorMarker) null);
    public static final DescriptorKindFilter VARIABLES = new DescriptorKindFilter(f5610i, (List) null, 2, (DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static int f5604c = 1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final int f5605d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final int f5606e = Companion.nextMask();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final int f5607f = Companion.nextMask();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final int f5608g = Companion.nextMask();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static final int f5609h = Companion.nextMask();
    /* access modifiers changed from: private */

    /* renamed from: i */
    public static final int f5610i = Companion.nextMask();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final int f5611j = (Companion.nextMask() - 1);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final int f5612k;

    /* renamed from: l */
    private static final int f5613l;

    /* renamed from: m */
    private static final int f5614m;

    /* renamed from: n */
    private static final List<Companion.MaskToName> f5615n;

    /* renamed from: o */
    private static final List<Companion.MaskToName> f5616o;

    /* renamed from: a */
    private final List<DescriptorKindExclude> f5617a;

    /* renamed from: b */
    private final int f5618b;

    public DescriptorKindFilter(int i, List<? extends DescriptorKindExclude> list) {
        Intrinsics.checkNotNullParameter(list, "excludes");
        this.f5617a = list;
        for (DescriptorKindExclude fullyExcludedDescriptorKinds : list) {
            i &= ~fullyExcludedDescriptorKinds.getFullyExcludedDescriptorKinds();
        }
        this.f5618b = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DescriptorKindFilter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<DescriptorKindExclude> getExcludes() {
        return this.f5617a;
    }

    public final int getKindMask() {
        return this.f5618b;
    }

    public final boolean acceptsKinds(int i) {
        return (i & this.f5618b) != 0;
    }

    public final DescriptorKindFilter restrictedToKindsOrNull(int i) {
        int i2 = i & this.f5618b;
        if (i2 == 0) {
            return null;
        }
        return new DescriptorKindFilter(i2, this.f5617a);
    }

    public String toString() {
        Object obj;
        boolean z;
        Iterator it = f5615n.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Companion.MaskToName) obj).getMask() == getKindMask()) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Companion.MaskToName maskToName = (Companion.MaskToName) obj;
        String name = maskToName == null ? null : maskToName.getName();
        if (name == null) {
            Collection arrayList = new ArrayList();
            for (Companion.MaskToName maskToName2 : f5616o) {
                String name2 = acceptsKinds(maskToName2.getMask()) ? maskToName2.getName() : null;
                if (name2 != null) {
                    arrayList.add(name2);
                }
            }
            name = CollectionsKt.joinToString$default((List) arrayList, " | ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        return "DescriptorKindFilter(" + name + ", " + this.f5617a + VersionRange.RIGHT_OPEN;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            DescriptorKindFilter descriptorKindFilter = (DescriptorKindFilter) obj;
            return Intrinsics.areEqual((Object) this.f5617a, (Object) descriptorKindFilter.f5617a) && this.f5618b == descriptorKindFilter.f5618b;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
    }

    public int hashCode() {
        return (this.f5617a.hashCode() * 31) + this.f5618b;
    }

    /* compiled from: MemberScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int nextMask() {
            int access$getNextMaskValue$cp = DescriptorKindFilter.f5604c;
            Companion companion = DescriptorKindFilter.Companion;
            DescriptorKindFilter.f5604c = DescriptorKindFilter.f5604c << 1;
            return access$getNextMaskValue$cp;
        }

        public final int getNON_SINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.f5605d;
        }

        public final int getSINGLETON_CLASSIFIERS_MASK() {
            return DescriptorKindFilter.f5606e;
        }

        public final int getTYPE_ALIASES_MASK() {
            return DescriptorKindFilter.f5607f;
        }

        public final int getPACKAGES_MASK() {
            return DescriptorKindFilter.f5608g;
        }

        public final int getFUNCTIONS_MASK() {
            return DescriptorKindFilter.f5609h;
        }

        public final int getVARIABLES_MASK() {
            return DescriptorKindFilter.f5610i;
        }

        public final int getALL_KINDS_MASK() {
            return DescriptorKindFilter.f5611j;
        }

        public final int getCLASSIFIERS_MASK() {
            return DescriptorKindFilter.f5612k;
        }

        /* compiled from: MemberScope.kt */
        private static final class MaskToName {
            private final int mask;
            private final String name;

            public MaskToName(int i, String str) {
                Intrinsics.checkNotNullParameter(str, "name");
                this.mask = i;
                this.name = str;
            }

            public final int getMask() {
                return this.mask;
            }

            public final String getName() {
                return this.name;
            }
        }
    }

    static {
        Companion.MaskToName maskToName;
        Companion.MaskToName maskToName2;
        Class<DescriptorKindFilter> cls = DescriptorKindFilter.class;
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        f5605d = companion.nextMask();
        int i = f5605d;
        int i2 = f5606e;
        f5612k = i | i2 | f5607f;
        int i3 = f5609h;
        int i4 = f5610i;
        f5613l = i2 | i3 | i4;
        f5614m = i3 | i4;
        Field[] fields = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields, "T::class.java.fields");
        Collection arrayList = new ArrayList();
        for (Object obj : (Object[]) fields) {
            if (Modifier.isStatic(((Field) obj).getModifiers())) {
                arrayList.add(obj);
            }
        }
        Collection arrayList2 = new ArrayList();
        for (Field field : (List) arrayList) {
            Object obj2 = field.get((Object) null);
            DescriptorKindFilter descriptorKindFilter = obj2 instanceof DescriptorKindFilter ? (DescriptorKindFilter) obj2 : null;
            if (descriptorKindFilter != null) {
                int kindMask = descriptorKindFilter.getKindMask();
                String name = field.getName();
                Intrinsics.checkNotNullExpressionValue(name, "field.name");
                maskToName2 = new Companion.MaskToName(kindMask, name);
            } else {
                maskToName2 = null;
            }
            if (maskToName2 != null) {
                arrayList2.add(maskToName2);
            }
        }
        f5615n = (List) arrayList2;
        Field[] fields2 = cls.getFields();
        Intrinsics.checkNotNullExpressionValue(fields2, "T::class.java.fields");
        Collection arrayList3 = new ArrayList();
        for (Object obj3 : (Object[]) fields2) {
            if (Modifier.isStatic(((Field) obj3).getModifiers())) {
                arrayList3.add(obj3);
            }
        }
        Collection arrayList4 = new ArrayList();
        for (Object next : (List) arrayList3) {
            if (Intrinsics.areEqual((Object) ((Field) next).getType(), (Object) Integer.TYPE)) {
                arrayList4.add(next);
            }
        }
        Collection arrayList5 = new ArrayList();
        for (Field field2 : (List) arrayList4) {
            Object obj4 = field2.get((Object) null);
            if (obj4 != null) {
                int intValue = ((Integer) obj4).intValue();
                if (intValue == ((-intValue) & intValue)) {
                    String name2 = field2.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "field.name");
                    maskToName = new Companion.MaskToName(intValue, name2);
                } else {
                    maskToName = null;
                }
                if (maskToName != null) {
                    arrayList5.add(maskToName);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        }
        f5616o = (List) arrayList5;
    }
}
