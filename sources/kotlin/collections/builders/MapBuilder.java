package kotlin.collections.builders;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;

@Metadata(mo148867d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 v*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003:\u0006vwxyz{B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007BE\b\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000¢\u0006\u0004\b0\u00101J\u0013\u00102\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0002¢\u0006\u0002\u00103J\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105J\r\u00106\u001a\u000207H\u0000¢\u0006\u0002\b8J\b\u00109\u001a\u000207H\u0016J\b\u0010:\u001a\u000207H\u0002J\u0019\u0010;\u001a\u00020\u001f2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030=H\u0000¢\u0006\u0002\b>J!\u0010?\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0002\bBJ\u0015\u0010C\u001a\u00020\u001f2\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00020\u001f2\u0006\u0010F\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010DJ\u0018\u0010G\u001a\u00020\u001f2\u000e\u0010H\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000305H\u0002J\u0010\u0010I\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020\u0006H\u0002J\u0019\u0010L\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010MH\u0000¢\u0006\u0002\bNJ\u0013\u0010O\u001a\u00020\u001f2\b\u0010H\u001a\u0004\u0018\u00010PH\u0002J\u0015\u0010Q\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\u0015\u0010R\u001a\u00020\u00062\u0006\u0010F\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00101J\u0018\u0010S\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010TJ\u0015\u0010U\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J\b\u0010V\u001a\u00020\u0006H\u0016J\b\u0010W\u001a\u00020\u001fH\u0016J\u0019\u0010X\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010YH\u0000¢\u0006\u0002\bZJ\u001f\u0010[\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u00002\u0006\u0010F\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\\J\u001e\u0010]\u001a\u0002072\u0014\u0010^\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000105H\u0016J\"\u0010_\u001a\u00020\u001f2\u0018\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010A0=H\u0002J\u001c\u0010`\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0002J\u0010\u0010a\u001a\u00020\u001f2\u0006\u0010b\u001a\u00020\u0006H\u0002J\u0010\u0010c\u001a\u0002072\u0006\u0010d\u001a\u00020\u0006H\u0002J\u0017\u0010e\u001a\u0004\u0018\u00018\u00012\u0006\u0010/\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010TJ!\u0010f\u001a\u00020\u001f2\u0012\u0010@\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010AH\u0000¢\u0006\u0002\bgJ\u0010\u0010h\u001a\u0002072\u0006\u0010i\u001a\u00020\u0006H\u0002J\u0017\u0010j\u001a\u00020\u00062\u0006\u0010/\u001a\u00028\u0000H\u0000¢\u0006\u0004\bk\u00101J\u0010\u0010l\u001a\u0002072\u0006\u0010m\u001a\u00020\u0006H\u0002J\u0017\u0010n\u001a\u00020\u001f2\u0006\u0010o\u001a\u00028\u0001H\u0000¢\u0006\u0004\bp\u0010DJ\b\u0010q\u001a\u00020rH\u0016J\u0019\u0010s\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010tH\u0000¢\u0006\u0002\buR\u0014\u0010\u0011\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00160\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0018R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0013R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0016\u0010,\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000¨\u0006|"}, mo148868d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", "", "()V", "initialCapacity", "", "(I)V", "keysArray", "", "valuesArray", "presenceArray", "", "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", "", "", "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "isReadOnly", "", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "<set-?>", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", "key", "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", "", "checkIsMutable", "", "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", "", "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", "", "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", "", "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", "", "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: MapBuilder.kt */
public final class MapBuilder<K, V> implements Map<K, V>, KMutableMap {
    @Deprecated

    /* renamed from: m */
    private static final int f4546m = -1640531527;
    @Deprecated

    /* renamed from: n */
    private static final int f4547n = 8;
    @Deprecated

    /* renamed from: o */
    private static final int f4548o = 2;
    @Deprecated

    /* renamed from: p */
    private static final int f4549p = -1;

    /* renamed from: q */
    private static final Companion f4550q = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private int f4551a;

    /* renamed from: b */
    private int f4552b;

    /* renamed from: c */
    private MapBuilderKeys<K> f4553c;

    /* renamed from: d */
    private MapBuilderValues<V> f4554d;

    /* renamed from: e */
    private MapBuilderEntries<K, V> f4555e;

    /* renamed from: f */
    private boolean f4556f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public K[] f4557g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public V[] f4558h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int[] f4559i;

    /* renamed from: j */
    private int[] f4560j;

    /* renamed from: k */
    private int f4561k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f4562l;

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i, int i2) {
        this.f4557g = kArr;
        this.f4558h = vArr;
        this.f4559i = iArr;
        this.f4560j = iArr2;
        this.f4561k = i;
        this.f4562l = i2;
        this.f4551a = f4550q.computeShift(m2975b());
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public final Set<K> keySet() {
        return getKeys();
    }

    public final int size() {
        return getSize();
    }

    public final Collection<V> values() {
        return getValues();
    }

    public int getSize() {
        return this.f4552b;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i) {
        this(ListBuilderKt.arrayOfUninitializedElements(i), (V[]) null, new int[i], new int[f4550q.computeHashSize(i)], 2, 0);
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.f4556f = true;
        return this;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object obj) {
        return m2976b(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m2978c(obj) >= 0;
    }

    public V get(Object obj) {
        int b = m2976b(obj);
        if (b < 0) {
            return null;
        }
        V[] vArr = this.f4558h;
        Intrinsics.checkNotNull(vArr);
        return vArr[b];
    }

    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] c = m2980c();
        if (addKey$kotlin_stdlib < 0) {
            int i = (-addKey$kotlin_stdlib) - 1;
            V v2 = c[i];
            c[i] = v;
            return v2;
        }
        c[addKey$kotlin_stdlib] = v;
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        m2972a(map.entrySet());
    }

    public V remove(Object obj) {
        int removeKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (removeKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.f4558h;
        Intrinsics.checkNotNull(vArr);
        V v = vArr[removeKey$kotlin_stdlib];
        ListBuilderKt.resetAt(vArr, removeKey$kotlin_stdlib);
        return v;
    }

    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i = this.f4562l - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f4559i;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.f4560j[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        ListBuilderKt.resetRange(this.f4557g, 0, this.f4562l);
        V[] vArr = this.f4558h;
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, 0, this.f4562l);
        }
        this.f4552b = 0;
        this.f4562l = 0;
    }

    public Set<K> getKeys() {
        MapBuilderKeys<K> mapBuilderKeys = this.f4553c;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.f4553c = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    public Collection<V> getValues() {
        MapBuilderValues<V> mapBuilderValues = this.f4554d;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.f4554d = mapBuilderValues2;
        return mapBuilderValues2;
    }

    public Set<Map.Entry<K, V>> getEntries() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.f4555e;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.f4555e = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && m2974a((Map<?, ?>) (Map) obj));
    }

    public int hashCode() {
        EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            i += entriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append(Const.joLeft);
        EntriesItr entriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i = 0;
        while (entriesIterator$kotlin_stdlib.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            entriesIterator$kotlin_stdlib.nextAppendString(sb);
            i++;
        }
        sb.append("}");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }

    /* renamed from: a */
    private final int m2969a() {
        return this.f4557g.length;
    }

    /* renamed from: b */
    private final int m2975b() {
        return this.f4560j.length;
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.f4556f) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a */
    private final void m2971a(int i) {
        m2977b(this.f4562l + i);
    }

    /* renamed from: b */
    private final void m2977b(int i) {
        if (i > m2969a()) {
            int a = (m2969a() * 3) / 2;
            if (i <= a) {
                i = a;
            }
            this.f4557g = ListBuilderKt.copyOfUninitializedElements(this.f4557g, i);
            V[] vArr = this.f4558h;
            this.f4558h = vArr != null ? ListBuilderKt.copyOfUninitializedElements(vArr, i) : null;
            int[] copyOf = Arrays.copyOf(this.f4559i, i);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
            this.f4559i = copyOf;
            int access$computeHashSize = f4550q.computeHashSize(i);
            if (access$computeHashSize > m2975b()) {
                m2979c(access$computeHashSize);
            }
        } else if ((this.f4562l + i) - size() > m2969a()) {
            m2979c(m2975b());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final V[] m2980c() {
        V[] vArr = this.f4558h;
        if (vArr != null) {
            return vArr;
        }
        V[] arrayOfUninitializedElements = ListBuilderKt.arrayOfUninitializedElements(m2969a());
        this.f4558h = arrayOfUninitializedElements;
        return arrayOfUninitializedElements;
    }

    /* renamed from: a */
    private final int m2970a(K k) {
        return ((k != null ? k.hashCode() : 0) * f4546m) >>> this.f4551a;
    }

    /* renamed from: d */
    private final void m2981d() {
        int i;
        V[] vArr = this.f4558h;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.f4562l;
            if (i2 >= i) {
                break;
            }
            if (this.f4559i[i2] >= 0) {
                K[] kArr = this.f4557g;
                kArr[i3] = kArr[i2];
                if (vArr != null) {
                    vArr[i3] = vArr[i2];
                }
                i3++;
            }
            i2++;
        }
        ListBuilderKt.resetRange(this.f4557g, i3, i);
        if (vArr != null) {
            ListBuilderKt.resetRange(vArr, i3, this.f4562l);
        }
        this.f4562l = i3;
    }

    /* renamed from: c */
    private final void m2979c(int i) {
        if (this.f4562l > size()) {
            m2981d();
        }
        int i2 = 0;
        if (i != m2975b()) {
            this.f4560j = new int[i];
            this.f4551a = f4550q.computeShift(i);
        } else {
            ArraysKt.fill(this.f4560j, 0, 0, m2975b());
        }
        while (i2 < this.f4562l) {
            int i3 = i2 + 1;
            if (m2982d(i2)) {
                i2 = i3;
            } else {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
        }
    }

    /* renamed from: d */
    private final boolean m2982d(int i) {
        int a = m2970a(this.f4557g[i]);
        int i2 = this.f4561k;
        while (true) {
            int[] iArr = this.f4560j;
            if (iArr[a] == 0) {
                iArr[a] = i + 1;
                this.f4559i[i] = a;
                return true;
            }
            i2--;
            if (i2 < 0) {
                return false;
            }
            a = a == 0 ? m2975b() - 1 : a - 1;
        }
    }

    /* renamed from: b */
    private final int m2976b(K k) {
        int a = m2970a(k);
        int i = this.f4561k;
        while (true) {
            int i2 = this.f4560j[a];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (Intrinsics.areEqual((Object) this.f4557g[i3], (Object) k)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            a = a == 0 ? m2975b() - 1 : a - 1;
        }
    }

    /* renamed from: c */
    private final int m2978c(V v) {
        int i = this.f4562l;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f4559i[i] >= 0) {
                V[] vArr = this.f4558h;
                Intrinsics.checkNotNull(vArr);
                if (Intrinsics.areEqual((Object) vArr[i], (Object) v)) {
                    return i;
                }
            }
        }
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int a = m2970a(k);
            int coerceAtMost = RangesKt.coerceAtMost(this.f4561k * 2, m2975b() / 2);
            int i = 0;
            while (true) {
                int i2 = this.f4560j[a];
                if (i2 <= 0) {
                    if (this.f4562l >= m2969a()) {
                        m2971a(1);
                    } else {
                        int i3 = this.f4562l;
                        int i4 = i3 + 1;
                        this.f4562l = i4;
                        this.f4557g[i3] = k;
                        this.f4559i[i3] = a;
                        this.f4560j[a] = i4;
                        this.f4552b = size() + 1;
                        if (i > this.f4561k) {
                            this.f4561k = i;
                        }
                        return i3;
                    }
                } else if (Intrinsics.areEqual((Object) this.f4557g[i2 - 1], (Object) k)) {
                    return -i2;
                } else {
                    i++;
                    if (i > coerceAtMost) {
                        m2979c(m2975b() * 2);
                        break;
                    }
                    a = a == 0 ? m2975b() - 1 : a - 1;
                }
            }
        }
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int b = m2976b(k);
        if (b < 0) {
            return -1;
        }
        m2983e(b);
        return b;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m2983e(int i) {
        ListBuilderKt.resetAt(this.f4557g, i);
        m2984f(this.f4559i[i]);
        this.f4559i[i] = -1;
        this.f4552b = size() - 1;
    }

    /* renamed from: f */
    private final void m2984f(int i) {
        int coerceAtMost = RangesKt.coerceAtMost(this.f4561k * 2, m2975b() / 2);
        int i2 = 0;
        int i3 = i;
        do {
            i = i == 0 ? m2975b() - 1 : i - 1;
            i2++;
            if (i2 > this.f4561k) {
                this.f4560j[i3] = 0;
                return;
            }
            int[] iArr = this.f4560j;
            int i4 = iArr[i];
            if (i4 == 0) {
                iArr[i3] = 0;
                return;
            }
            if (i4 < 0) {
                iArr[i3] = -1;
            } else {
                int i5 = i4 - 1;
                if (((m2970a(this.f4557g[i5]) - i) & (m2975b() - 1)) >= i2) {
                    this.f4560j[i3] = i4;
                    this.f4559i[i5] = i3;
                }
                coerceAtMost--;
            }
            i3 = i;
            i2 = 0;
            coerceAtMost--;
        } while (coerceAtMost >= 0);
        this.f4560j[i3] = -1;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, ParamKeys.PARAM_COMPLAIN_ENTRY);
        int b = m2976b(entry.getKey());
        if (b < 0) {
            return false;
        }
        V[] vArr = this.f4558h;
        Intrinsics.checkNotNull(vArr);
        return Intrinsics.areEqual((Object) vArr[b], (Object) entry.getValue());
    }

    /* renamed from: a */
    private final boolean m2974a(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "m");
        for (Object next : collection) {
            if (next != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) next)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private final boolean m2973a(Map.Entry<? extends K, ? extends V> entry) {
        int addKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        Object[] c = m2980c();
        if (addKey$kotlin_stdlib >= 0) {
            c[addKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i = (-addKey$kotlin_stdlib) - 1;
        if (!(!Intrinsics.areEqual((Object) entry.getValue(), c[i]))) {
            return false;
        }
        c[i] = entry.getValue();
        return true;
    }

    /* renamed from: a */
    private final boolean m2972a(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        m2971a(collection.size());
        for (Map.Entry a : collection) {
            if (m2973a(a)) {
                z = true;
            }
        }
        return z;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, ParamKeys.PARAM_COMPLAIN_ENTRY);
        checkIsMutable$kotlin_stdlib();
        int b = m2976b(entry.getKey());
        if (b < 0) {
            return false;
        }
        V[] vArr = this.f4558h;
        Intrinsics.checkNotNull(vArr);
        if (!Intrinsics.areEqual((Object) vArr[b], (Object) entry.getValue())) {
            return false;
        }
        m2983e(b);
        return true;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int c = m2978c(v);
        if (c < 0) {
            return false;
        }
        m2983e(c);
        return true;
    }

    public final KeysItr<K, V> keysIterator$kotlin_stdlib() {
        return new KeysItr<>(this);
    }

    public final ValuesItr<K, V> valuesIterator$kotlin_stdlib() {
        return new ValuesItr<>(this);
    }

    public final EntriesItr<K, V> entriesIterator$kotlin_stdlib() {
        return new EntriesItr<>(this);
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", "", "()V", "INITIAL_CAPACITY", "", "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: MapBuilder.kt */
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final int computeHashSize(int i) {
            return Integer.highestOneBit(RangesKt.coerceAtLeast(i, 1) * 3);
        }

        /* access modifiers changed from: private */
        public final int computeShift(int i) {
            return Integer.numberOfLeadingZeros(i) + 1;
        }
    }

    @Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, mo148868d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", "", "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", "", "initNext", "", "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: MapBuilder.kt */
    public static class Itr<K, V> {
        private int index;
        private int lastIndex = -1;
        private final MapBuilder<K, V> map;

        public Itr(MapBuilder<K, V> mapBuilder) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.map = mapBuilder;
            initNext$kotlin_stdlib();
        }

        public final MapBuilder<K, V> getMap$kotlin_stdlib() {
            return this.map;
        }

        public final int getIndex$kotlin_stdlib() {
            return this.index;
        }

        public final void setIndex$kotlin_stdlib(int i) {
            this.index = i;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.lastIndex;
        }

        public final void setLastIndex$kotlin_stdlib(int i) {
            this.lastIndex = i;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.index < this.map.f4562l) {
                int[] access$getPresenceArray$p = this.map.f4559i;
                int i = this.index;
                if (access$getPresenceArray$p[i] < 0) {
                    this.index = i + 1;
                } else {
                    return;
                }
            }
        }

        public final boolean hasNext() {
            return this.index < this.map.f4562l;
        }

        public final void remove() {
            if (this.lastIndex != -1) {
                this.map.checkIsMutable$kotlin_stdlib();
                this.map.m2983e(this.lastIndex);
                this.lastIndex = -1;
                return;
            }
            throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, mo148868d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: MapBuilder.kt */
    public static final class KeysItr<K, V> extends Itr<K, V> implements Iterator<K>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public KeysItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        public K next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().f4562l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                K k = getMap$kotlin_stdlib().f4557g[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return k;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, mo148868d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: MapBuilder.kt */
    public static final class ValuesItr<K, V> extends Itr<K, V> implements Iterator<V>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ValuesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        public V next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().f4562l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                V[] access$getValuesArray$p = getMap$kotlin_stdlib().f4558h;
                Intrinsics.checkNotNull(access$getValuesArray$p);
                V v = access$getValuesArray$p[getLastIndex$kotlin_stdlib()];
                initNext$kotlin_stdlib();
                return v;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(mo148867d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, mo148868d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", "", "", "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", "", "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: MapBuilder.kt */
    public static final class EntriesItr<K, V> extends Itr<K, V> implements Iterator<Map.Entry<K, V>>, KMutableIterator {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EntriesItr(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
        }

        public EntryRef<K, V> next() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().f4562l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                EntryRef<K, V> entryRef = new EntryRef<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
                initNext$kotlin_stdlib();
                return entryRef;
            }
            throw new NoSuchElementException();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().f4562l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().f4557g[getLastIndex$kotlin_stdlib()];
                int i = 0;
                int hashCode = obj != null ? obj.hashCode() : 0;
                Object[] access$getValuesArray$p = getMap$kotlin_stdlib().f4558h;
                Intrinsics.checkNotNull(access$getValuesArray$p);
                Object obj2 = access$getValuesArray$p[getLastIndex$kotlin_stdlib()];
                if (obj2 != null) {
                    i = obj2.hashCode();
                }
                int i2 = hashCode ^ i;
                initNext$kotlin_stdlib();
                return i2;
            }
            throw new NoSuchElementException();
        }

        public final void nextAppendString(StringBuilder sb) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() < getMap$kotlin_stdlib().f4562l) {
                int index$kotlin_stdlib = getIndex$kotlin_stdlib();
                setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
                setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
                Object obj = getMap$kotlin_stdlib().f4557g[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj, (Object) getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj);
                }
                sb.append('=');
                Object[] access$getValuesArray$p = getMap$kotlin_stdlib().f4558h;
                Intrinsics.checkNotNull(access$getValuesArray$p);
                Object obj2 = access$getValuesArray$p[getLastIndex$kotlin_stdlib()];
                if (Intrinsics.areEqual(obj2, (Object) getMap$kotlin_stdlib())) {
                    sb.append("(this Map)");
                } else {
                    sb.append(obj2);
                }
                initNext$kotlin_stdlib();
                return;
            }
            throw new NoSuchElementException();
        }
    }

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, mo148868d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", "", "map", "Lkotlin/collections/builders/MapBuilder;", "index", "", "(Lkotlin/collections/builders/MapBuilder;I)V", "key", "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", "", "other", "", "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: MapBuilder.kt */
    public static final class EntryRef<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {
        private final int index;
        private final MapBuilder<K, V> map;

        public EntryRef(MapBuilder<K, V> mapBuilder, int i) {
            Intrinsics.checkNotNullParameter(mapBuilder, "map");
            this.map = mapBuilder;
            this.index = i;
        }

        public K getKey() {
            return this.map.f4557g[this.index];
        }

        public V getValue() {
            V[] access$getValuesArray$p = this.map.f4558h;
            Intrinsics.checkNotNull(access$getValuesArray$p);
            return access$getValuesArray$p[this.index];
        }

        public V setValue(V v) {
            this.map.checkIsMutable$kotlin_stdlib();
            V[] access$allocateValuesArray = this.map.m2980c();
            int i = this.index;
            V v2 = access$allocateValuesArray[i];
            access$allocateValuesArray[i] = v;
            return v2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return Intrinsics.areEqual(entry.getKey(), getKey()) && Intrinsics.areEqual(entry.getValue(), getValue());
            }
        }

        public int hashCode() {
            Object key = getKey();
            int i = 0;
            int hashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode ^ i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }
}
