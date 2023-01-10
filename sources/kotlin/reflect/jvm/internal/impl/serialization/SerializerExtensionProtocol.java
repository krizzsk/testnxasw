package kotlin.reflect.jvm.internal.impl.serialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* compiled from: SerializerExtensionProtocol.kt */
public class SerializerExtensionProtocol {

    /* renamed from: a */
    private final ExtensionRegistryLite f5638a;

    /* renamed from: b */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> f5639b;

    /* renamed from: c */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> f5640c;

    /* renamed from: d */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> f5641d;

    /* renamed from: e */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> f5642e;

    /* renamed from: f */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> f5643f;

    /* renamed from: g */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> f5644g;

    /* renamed from: h */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> f5645h;

    /* renamed from: i */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> f5646i;

    /* renamed from: j */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> f5647j;

    /* renamed from: k */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> f5648k;

    /* renamed from: l */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> f5649l;

    /* renamed from: m */
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> f5650m;

    public SerializerExtensionProtocol(ExtensionRegistryLite extensionRegistryLite, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> generatedExtension, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> generatedExtension2, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> generatedExtension3, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> generatedExtension4, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension5, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension6, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> generatedExtension7, GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> generatedExtension8, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> generatedExtension9, GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> generatedExtension10, GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> generatedExtension11, GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> generatedExtension12) {
        Intrinsics.checkNotNullParameter(extensionRegistryLite, "extensionRegistry");
        Intrinsics.checkNotNullParameter(generatedExtension, "packageFqName");
        Intrinsics.checkNotNullParameter(generatedExtension2, "constructorAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension3, "classAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension4, "functionAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension5, "propertyAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension6, "propertyGetterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension7, "propertySetterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension8, "enumEntryAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension9, "compileTimeValue");
        Intrinsics.checkNotNullParameter(generatedExtension10, "parameterAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension11, "typeAnnotation");
        Intrinsics.checkNotNullParameter(generatedExtension12, "typeParameterAnnotation");
        this.f5638a = extensionRegistryLite;
        this.f5639b = generatedExtension;
        this.f5640c = generatedExtension2;
        this.f5641d = generatedExtension3;
        this.f5642e = generatedExtension4;
        this.f5643f = generatedExtension5;
        this.f5644g = generatedExtension6;
        this.f5645h = generatedExtension7;
        this.f5646i = generatedExtension8;
        this.f5647j = generatedExtension9;
        this.f5648k = generatedExtension10;
        this.f5649l = generatedExtension11;
        this.f5650m = generatedExtension12;
    }

    public final ExtensionRegistryLite getExtensionRegistry() {
        return this.f5638a;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, List<ProtoBuf.Annotation>> getConstructorAnnotation() {
        return this.f5640c;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Annotation>> getClassAnnotation() {
        return this.f5641d;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, List<ProtoBuf.Annotation>> getFunctionAnnotation() {
        return this.f5642e;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertyAnnotation() {
        return this.f5643f;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertyGetterAnnotation() {
        return this.f5644g;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, List<ProtoBuf.Annotation>> getPropertySetterAnnotation() {
        return this.f5645h;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.EnumEntry, List<ProtoBuf.Annotation>> getEnumEntryAnnotation() {
        return this.f5646i;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, ProtoBuf.Annotation.Argument.Value> getCompileTimeValue() {
        return this.f5647j;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.ValueParameter, List<ProtoBuf.Annotation>> getParameterAnnotation() {
        return this.f5648k;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> getTypeAnnotation() {
        return this.f5649l;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> getTypeParameterAnnotation() {
        return this.f5650m;
    }
}
