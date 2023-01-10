package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ AnnotatedCallableKind $kind;
    final /* synthetic */ MessageLite $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$getAnnotations$1(MemberDeserializer memberDeserializer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$proto = messageLite;
        this.$kind = annotatedCallableKind;
    }

    public final List<AnnotationDescriptor> invoke() {
        List<AnnotationDescriptor> list;
        MemberDeserializer memberDeserializer = this.this$0;
        ProtoContainer access$asProtoContainer = memberDeserializer.m5160a(memberDeserializer.f5708a.getContainingDeclaration());
        if (access$asProtoContainer == null) {
            list = null;
        } else {
            list = CollectionsKt.toList(this.this$0.f5708a.getComponents().getAnnotationAndConstantLoader().loadCallableAnnotations(access$asProtoContainer, this.$proto, this.$kind));
        }
        return list != null ? list : CollectionsKt.emptyList();
    }
}
