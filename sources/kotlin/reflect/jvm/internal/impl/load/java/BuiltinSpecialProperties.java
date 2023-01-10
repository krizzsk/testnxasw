package kotlin.reflect.jvm.internal.impl.load.java;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: BuiltinSpecialProperties.kt */
public final class BuiltinSpecialProperties {
    public static final BuiltinSpecialProperties INSTANCE = new BuiltinSpecialProperties();

    /* renamed from: a */
    private static final Map<FqName, Name> f5083a;

    /* renamed from: b */
    private static final Map<Name, List<Name>> f5084b;

    /* renamed from: c */
    private static final Set<FqName> f5085c;

    /* renamed from: d */
    private static final Set<Name> f5086d;

    private BuiltinSpecialProperties() {
    }

    public final Map<FqName, Name> getPROPERTY_FQ_NAME_TO_JVM_GETTER_NAME_MAP() {
        return f5083a;
    }

    static {
        Map<FqName, Name> mapOf = MapsKt.mapOf(TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4766a(StandardNames.FqNames._enum, "name"), Name.identifier("name")), TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4766a(StandardNames.FqNames._enum, "ordinal"), Name.identifier("ordinal")), TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4765a(StandardNames.FqNames.collection, "size"), Name.identifier("size")), TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4765a(StandardNames.FqNames.map, "size"), Name.identifier("size")), TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4766a(StandardNames.FqNames.charSequence, "length"), Name.identifier("length")), TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4765a(StandardNames.FqNames.map, "keys"), Name.identifier("keySet")), TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4765a(StandardNames.FqNames.map, "values"), Name.identifier("values")), TuplesKt.m41339to(BuiltinSpecialPropertiesKt.m4765a(StandardNames.FqNames.map, (String) RemoteConfigConstants.ResponseFieldKey.ENTRIES), Name.identifier("entrySet")));
        f5083a = mapOf;
        Iterable<Map.Entry> entrySet = mapOf.entrySet();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new Pair(((FqName) entry.getKey()).shortName(), entry.getValue()));
        }
        Map linkedHashMap = new LinkedHashMap();
        for (Pair pair : (List) arrayList) {
            Name name = (Name) pair.getSecond();
            Object obj = linkedHashMap.get(name);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(name, obj);
            }
            ((List) obj).add((Name) pair.getFirst());
        }
        Map<Name, List<Name>> linkedHashMap2 = new LinkedHashMap<>(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), CollectionsKt.distinct((Iterable) entry2.getValue()));
        }
        f5084b = linkedHashMap2;
        Set<FqName> keySet = f5083a.keySet();
        f5085c = keySet;
        Iterable<FqName> iterable = keySet;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (FqName shortName : iterable) {
            arrayList2.add(shortName.shortName());
        }
        f5086d = CollectionsKt.toSet((List) arrayList2);
    }

    public final Set<FqName> getSPECIAL_FQ_NAMES() {
        return f5085c;
    }

    public final Set<Name> getSPECIAL_SHORT_NAMES() {
        return f5086d;
    }

    public final List<Name> getPropertyNameCandidatesBySpecialGetterName(Name name) {
        Intrinsics.checkNotNullParameter(name, "name1");
        List<Name> list = f5084b.get(name);
        return list == null ? CollectionsKt.emptyList() : list;
    }
}
