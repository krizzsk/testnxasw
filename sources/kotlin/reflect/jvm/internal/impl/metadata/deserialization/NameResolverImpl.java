package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.apache.commons.p074io.IOUtils;

/* compiled from: NameResolverImpl.kt */
public final class NameResolverImpl implements NameResolver {

    /* renamed from: a */
    private final ProtoBuf.StringTable f5402a;

    /* renamed from: b */
    private final ProtoBuf.QualifiedNameTable f5403b;

    /* compiled from: NameResolverImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NameResolverImpl(ProtoBuf.StringTable stringTable, ProtoBuf.QualifiedNameTable qualifiedNameTable) {
        Intrinsics.checkNotNullParameter(stringTable, "strings");
        Intrinsics.checkNotNullParameter(qualifiedNameTable, "qualifiedNames");
        this.f5402a = stringTable;
        this.f5403b = qualifiedNameTable;
    }

    public String getString(int i) {
        String string = this.f5402a.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "strings.getString(index)");
        return string;
    }

    public String getQualifiedClassName(int i) {
        Triple<List<String>, List<String>, Boolean> a = m4941a(i);
        List component1 = a.component1();
        String joinToString$default = CollectionsKt.joinToString$default(a.component2(), ".", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (component1.isEmpty()) {
            return joinToString$default;
        }
        return CollectionsKt.joinToString$default(component1, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + IOUtils.DIR_SEPARATOR_UNIX + joinToString$default;
    }

    public boolean isLocalClassName(int i) {
        return m4941a(i).getThird().booleanValue();
    }

    /* renamed from: a */
    private final Triple<List<String>, List<String>, Boolean> m4941a(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName qualifiedName = this.f5403b.getQualifiedName(i);
            String string = this.f5402a.getString(qualifiedName.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = qualifiedName.getKind();
            Intrinsics.checkNotNull(kind);
            int i2 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i2 == 1) {
                linkedList2.addFirst(string);
            } else if (i2 == 2) {
                linkedList.addFirst(string);
            } else if (i2 == 3) {
                linkedList2.addFirst(string);
                z = true;
            }
            i = qualifiedName.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }
}
