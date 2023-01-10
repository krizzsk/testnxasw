package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: DeclaredMemberIndex.kt */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {

    /* renamed from: a */
    private final JavaClass f5212a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Function1<JavaMember, Boolean> f5213b;

    /* renamed from: c */
    private final Function1<JavaMethod, Boolean> f5214c = new ClassDeclaredMemberIndex$methodFilter$1(this);

    /* renamed from: d */
    private final Map<Name, List<JavaMethod>> f5215d;

    /* renamed from: e */
    private final Map<Name, JavaField> f5216e;

    /* renamed from: f */
    private final Map<Name, JavaRecordComponent> f5217f;

    public ClassDeclaredMemberIndex(JavaClass javaClass, Function1<? super JavaMember, Boolean> function1) {
        Intrinsics.checkNotNullParameter(javaClass, "jClass");
        Intrinsics.checkNotNullParameter(function1, "memberFilter");
        this.f5212a = javaClass;
        this.f5213b = function1;
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.f5212a.getMethods()), this.f5214c);
        Map<Name, List<JavaMethod>> linkedHashMap = new LinkedHashMap<>();
        for (T next : filter) {
            Name name = ((JavaMethod) next).getName();
            List<JavaMethod> list = linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList<>();
                linkedHashMap.put(name, list);
            }
            list.add(next);
        }
        this.f5215d = linkedHashMap;
        Sequence<T> filter2 = SequencesKt.filter(CollectionsKt.asSequence(this.f5212a.getFields()), this.f5213b);
        Map<Name, JavaField> linkedHashMap2 = new LinkedHashMap<>();
        for (T next2 : filter2) {
            linkedHashMap2.put(((JavaField) next2).getName(), next2);
        }
        this.f5216e = linkedHashMap2;
        Function1<JavaMember, Boolean> function12 = this.f5213b;
        Collection arrayList = new ArrayList();
        for (Object next3 : this.f5212a.getRecordComponents()) {
            if (function12.invoke(next3).booleanValue()) {
                arrayList.add(next3);
            }
        }
        Iterable iterable = (List) arrayList;
        Map<Name, JavaRecordComponent> linkedHashMap3 = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next4 : iterable) {
            linkedHashMap3.put(((JavaRecordComponent) next4).getName(), next4);
        }
        this.f5217f = linkedHashMap3;
    }

    public Collection<JavaMethod> findMethodsByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List list = this.f5215d.get(name);
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        return list;
    }

    public Set<Name> getMethodNames() {
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.f5212a.getMethods()), this.f5214c);
        Collection linkedHashSet = new LinkedHashSet();
        for (T name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }

    public JavaField findFieldByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f5216e.get(name);
    }

    public Set<Name> getFieldNames() {
        Sequence<T> filter = SequencesKt.filter(CollectionsKt.asSequence(this.f5212a.getFields()), this.f5213b);
        Collection linkedHashSet = new LinkedHashSet();
        for (T name : filter) {
            linkedHashSet.add(name.getName());
        }
        return (Set) linkedHashSet;
    }

    public Set<Name> getRecordComponentNames() {
        return this.f5217f.keySet();
    }

    public JavaRecordComponent findRecordComponentByName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f5217f.get(name);
    }
}
