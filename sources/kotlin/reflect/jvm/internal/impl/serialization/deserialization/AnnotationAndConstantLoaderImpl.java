package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AnnotationAndConstantLoaderImpl.kt */
public final class AnnotationAndConstantLoaderImpl implements AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> {

    /* renamed from: a */
    private final SerializerExtensionProtocol f5655a;

    /* renamed from: b */
    private final AnnotationDeserializer f5656b;

    /* compiled from: AnnotationAndConstantLoaderImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnnotationAndConstantLoaderImpl(ModuleDescriptor moduleDescriptor, NotFoundClasses notFoundClasses, SerializerExtensionProtocol serializerExtensionProtocol) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(serializerExtensionProtocol, "protocol");
        this.f5655a = serializerExtensionProtocol;
        this.f5656b = new AnnotationDeserializer(moduleDescriptor, notFoundClasses);
    }

    public List<AnnotationDescriptor> loadClassAnnotations(ProtoContainer.Class classR) {
        Intrinsics.checkNotNullParameter(classR, "container");
        List list = (List) classR.getClassProto().getExtension(this.f5655a.getClassAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.f5656b.deserializeAnnotation(deserializeAnnotation, classR.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        List list;
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        if (messageLite instanceof ProtoBuf.Constructor) {
            list = (List) ((ProtoBuf.Constructor) messageLite).getExtension(this.f5655a.getConstructorAnnotation());
        } else if (messageLite instanceof ProtoBuf.Function) {
            list = (List) ((ProtoBuf.Function) messageLite).getExtension(this.f5655a.getFunctionAnnotation());
        } else if (messageLite instanceof ProtoBuf.Property) {
            int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
            if (i == 1) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.f5655a.getPropertyAnnotation());
            } else if (i == 2) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.f5655a.getPropertyGetterAnnotation());
            } else if (i == 3) {
                list = (List) ((ProtoBuf.Property) messageLite).getExtension(this.f5655a.getPropertySetterAnnotation());
            } else {
                throw new IllegalStateException("Unsupported callable kind with property proto".toString());
            }
        } else {
            throw new IllegalStateException(Intrinsics.stringPlus("Unknown message: ", messageLite).toString());
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.f5656b.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        return CollectionsKt.emptyList();
    }

    public List<AnnotationDescriptor> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        return CollectionsKt.emptyList();
    }

    public List<AnnotationDescriptor> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf.EnumEntry enumEntry) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(enumEntry, "proto");
        List list = (List) enumEntry.getExtension(this.f5655a.getEnumEntryAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.f5656b.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf.ValueParameter valueParameter) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "callableProto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        Intrinsics.checkNotNullParameter(valueParameter, "proto");
        List list = (List) valueParameter.getExtension(this.f5655a.getParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.f5656b.deserializeAnnotation(deserializeAnnotation, protoContainer.getNameResolver()));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(messageLite, "proto");
        Intrinsics.checkNotNullParameter(annotatedCallableKind, "kind");
        return CollectionsKt.emptyList();
    }

    public List<AnnotationDescriptor> loadTypeAnnotations(ProtoBuf.Type type, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(type, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List list = (List) type.getExtension(this.f5655a.getTypeAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.f5656b.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return (List) arrayList;
    }

    public List<AnnotationDescriptor> loadTypeParameterAnnotations(ProtoBuf.TypeParameter typeParameter, NameResolver nameResolver) {
        Intrinsics.checkNotNullParameter(typeParameter, "proto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        List list = (List) typeParameter.getExtension(this.f5655a.getTypeParameterAnnotation());
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        Iterable<ProtoBuf.Annotation> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ProtoBuf.Annotation deserializeAnnotation : iterable) {
            arrayList.add(this.f5656b.deserializeAnnotation(deserializeAnnotation, nameResolver));
        }
        return (List) arrayList;
    }

    public ConstantValue<?> loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, "container");
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        ProtoBuf.Annotation.Argument.Value value = (ProtoBuf.Annotation.Argument.Value) ProtoBufUtilKt.getExtensionOrNull(property, this.f5655a.getCompileTimeValue());
        if (value == null) {
            return null;
        }
        return this.f5656b.resolveValue(kotlinType, value, protoContainer.getNameResolver());
    }
}
