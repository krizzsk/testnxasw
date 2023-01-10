package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.text.StringsKt;

/* compiled from: JvmNameResolver.kt */
public final class JvmNameResolver implements NameResolver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: e */
    private static final String f5420e;

    /* renamed from: f */
    private static final List<String> f5421f;

    /* renamed from: g */
    private static final Map<String, Integer> f5422g;

    /* renamed from: a */
    private final JvmProtoBuf.StringTableTypes f5423a;

    /* renamed from: b */
    private final String[] f5424b;

    /* renamed from: c */
    private final Set<Integer> f5425c;

    /* renamed from: d */
    private final List<JvmProtoBuf.StringTableTypes.Record> f5426d;

    /* compiled from: JvmNameResolver.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public JvmNameResolver(JvmProtoBuf.StringTableTypes stringTableTypes, String[] strArr) {
        Set<Integer> set;
        Intrinsics.checkNotNullParameter(stringTableTypes, "types");
        Intrinsics.checkNotNullParameter(strArr, "strings");
        this.f5423a = stringTableTypes;
        this.f5424b = strArr;
        List<Integer> localNameList = stringTableTypes.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = SetsKt.emptySet();
        } else {
            Intrinsics.checkNotNullExpressionValue(localNameList, "");
            set = CollectionsKt.toSet(localNameList);
        }
        this.f5425c = set;
        ArrayList arrayList = new ArrayList();
        List<JvmProtoBuf.StringTableTypes.Record> recordList = getTypes().getRecordList();
        arrayList.ensureCapacity(recordList.size());
        for (JvmProtoBuf.StringTableTypes.Record next : recordList) {
            int range = next.getRange();
            for (int i = 0; i < range; i++) {
                arrayList.add(next);
            }
        }
        arrayList.trimToSize();
        Unit unit = Unit.INSTANCE;
        this.f5426d = arrayList;
    }

    public final JvmProtoBuf.StringTableTypes getTypes() {
        return this.f5423a;
    }

    public String getString(int i) {
        String str;
        int i2 = i;
        JvmProtoBuf.StringTableTypes.Record record = this.f5426d.get(i2);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                int size = f5421f.size() - 1;
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex >= 0 && predefinedIndex <= size) {
                    str = f5421f.get(record.getPredefinedIndex());
                }
            }
            str = this.f5424b[i2];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNullExpressionValue(num2, "end");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNullExpressionValue(str, TypedValues.Custom.S_STRING);
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Intrinsics.checkNotNullExpressionValue(str2, TypedValues.Custom.S_STRING);
            str2 = StringsKt.replace$default(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i3 == 2) {
            Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
            str3 = StringsKt.replace$default(str3, '$', '.', false, 4, (Object) null);
        } else if (i3 == 3) {
            if (str3.length() >= 2) {
                Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
                str3 = str3.substring(1, str3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            String str4 = str3;
            Intrinsics.checkNotNullExpressionValue(str4, TypedValues.Custom.S_STRING);
            str3 = StringsKt.replace$default(str4, '$', '.', false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
        return str3;
    }

    public String getQualifiedClassName(int i) {
        return getString(i);
    }

    public boolean isLocalClassName(int i) {
        return this.f5425c.contains(Integer.valueOf(i));
    }

    /* compiled from: JvmNameResolver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        f5420e = joinToString$default;
        List<String> listOf = CollectionsKt.listOf(Intrinsics.stringPlus(joinToString$default, "/Any"), Intrinsics.stringPlus(f5420e, "/Nothing"), Intrinsics.stringPlus(f5420e, "/Unit"), Intrinsics.stringPlus(f5420e, "/Throwable"), Intrinsics.stringPlus(f5420e, "/Number"), Intrinsics.stringPlus(f5420e, "/Byte"), Intrinsics.stringPlus(f5420e, "/Double"), Intrinsics.stringPlus(f5420e, "/Float"), Intrinsics.stringPlus(f5420e, "/Int"), Intrinsics.stringPlus(f5420e, "/Long"), Intrinsics.stringPlus(f5420e, "/Short"), Intrinsics.stringPlus(f5420e, "/Boolean"), Intrinsics.stringPlus(f5420e, "/Char"), Intrinsics.stringPlus(f5420e, "/CharSequence"), Intrinsics.stringPlus(f5420e, "/String"), Intrinsics.stringPlus(f5420e, "/Comparable"), Intrinsics.stringPlus(f5420e, "/Enum"), Intrinsics.stringPlus(f5420e, "/Array"), Intrinsics.stringPlus(f5420e, "/ByteArray"), Intrinsics.stringPlus(f5420e, "/DoubleArray"), Intrinsics.stringPlus(f5420e, "/FloatArray"), Intrinsics.stringPlus(f5420e, "/IntArray"), Intrinsics.stringPlus(f5420e, "/LongArray"), Intrinsics.stringPlus(f5420e, "/ShortArray"), Intrinsics.stringPlus(f5420e, "/BooleanArray"), Intrinsics.stringPlus(f5420e, "/CharArray"), Intrinsics.stringPlus(f5420e, "/Cloneable"), Intrinsics.stringPlus(f5420e, "/Annotation"), Intrinsics.stringPlus(f5420e, "/collections/Iterable"), Intrinsics.stringPlus(f5420e, "/collections/MutableIterable"), Intrinsics.stringPlus(f5420e, "/collections/Collection"), Intrinsics.stringPlus(f5420e, "/collections/MutableCollection"), Intrinsics.stringPlus(f5420e, "/collections/List"), Intrinsics.stringPlus(f5420e, "/collections/MutableList"), Intrinsics.stringPlus(f5420e, "/collections/Set"), Intrinsics.stringPlus(f5420e, "/collections/MutableSet"), Intrinsics.stringPlus(f5420e, "/collections/Map"), Intrinsics.stringPlus(f5420e, "/collections/MutableMap"), Intrinsics.stringPlus(f5420e, "/collections/Map.Entry"), Intrinsics.stringPlus(f5420e, "/collections/MutableMap.MutableEntry"), Intrinsics.stringPlus(f5420e, "/collections/Iterator"), Intrinsics.stringPlus(f5420e, "/collections/MutableIterator"), Intrinsics.stringPlus(f5420e, "/collections/ListIterator"), Intrinsics.stringPlus(f5420e, "/collections/MutableListIterator"));
        f5421f = listOf;
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(listOf);
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        f5422g = linkedHashMap;
    }
}
