package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.didi.map.constant.StringConstant;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.p074io.IOUtils;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: a */
    private static final String f5414a = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);

    /* renamed from: b */
    private static final Map<String, String> f5415b;

    private ClassMapperLite() {
    }

    static {
        int i = 0;
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        List listOf = CollectionsKt.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 2;
                int i4 = i2 + 1;
                linkedHashMap.put(f5414a + IOUtils.DIR_SEPARATOR_UNIX + ((String) listOf.get(i2)), listOf.get(i4));
                linkedHashMap.put(f5414a + IOUtils.DIR_SEPARATOR_UNIX + ((String) listOf.get(i2)) + "Array", Intrinsics.stringPlus(Const.jaLeft, listOf.get(i4)));
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 = i3;
            }
        }
        linkedHashMap.put(Intrinsics.stringPlus(f5414a, "/Unit"), ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m4947a(linkedHashMap, "Any", "java/lang/Object");
        m4947a(linkedHashMap, "Nothing", "java/lang/Void");
        m4947a(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str : CollectionsKt.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            m4947a(linkedHashMap, str, Intrinsics.stringPlus("java/lang/", str));
        }
        for (String str2 : CollectionsKt.listOf("Iterator", "Collection", "List", "Set", StringConstant.META_NAME, "ListIterator")) {
            m4947a(linkedHashMap, Intrinsics.stringPlus("collections/", str2), Intrinsics.stringPlus("java/util/", str2));
            m4947a(linkedHashMap, Intrinsics.stringPlus("collections/Mutable", str2), Intrinsics.stringPlus("java/util/", str2));
        }
        m4947a(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m4947a(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m4947a(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m4947a(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        while (true) {
            int i5 = i + 1;
            String stringPlus = Intrinsics.stringPlus("Function", Integer.valueOf(i));
            m4947a(linkedHashMap, stringPlus, f5414a + "/jvm/functions/Function" + i);
            m4947a(linkedHashMap, Intrinsics.stringPlus("reflect/KFunction", Integer.valueOf(i)), Intrinsics.stringPlus(f5414a, "/reflect/KFunction"));
            if (i5 > 22) {
                break;
            }
            i = i5;
        }
        for (String str3 : CollectionsKt.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            String stringPlus2 = Intrinsics.stringPlus(str3, ".Companion");
            m4947a(linkedHashMap, stringPlus2, f5414a + "/jvm/internal/" + str3 + "CompanionObject");
        }
        f5415b = linkedHashMap;
    }

    /* renamed from: a */
    private static final void m4947a(Map<String, String> map, String str, String str2) {
        map.put(f5414a + IOUtils.DIR_SEPARATOR_UNIX + str, Matrix.MATRIX_TYPE_RANDOM_LT + str2 + ';');
    }

    @JvmStatic
    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = f5415b.get(str);
        if (str2 != null) {
            return str2;
        }
        return Matrix.MATRIX_TYPE_RANDOM_LT + StringsKt.replace$default(str, '.', '$', false, 4, (Object) null) + ';';
    }
}
