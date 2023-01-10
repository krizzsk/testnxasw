package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: context.kt */
public final class DeserializationContext {

    /* renamed from: a */
    private final DeserializationComponents f5686a;

    /* renamed from: b */
    private final NameResolver f5687b;

    /* renamed from: c */
    private final DeclarationDescriptor f5688c;

    /* renamed from: d */
    private final TypeTable f5689d;

    /* renamed from: e */
    private final VersionRequirementTable f5690e;

    /* renamed from: f */
    private final BinaryVersion f5691f;

    /* renamed from: g */
    private final DeserializedContainerSource f5692g;

    /* renamed from: h */
    private final TypeDeserializer f5693h;

    /* renamed from: i */
    private final MemberDeserializer f5694i;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0068, code lost:
        r0 = r0.getPresentableString();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeserializationContext(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r13, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r14, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r15, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable r16, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable r17, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion r18, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r19, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r20, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter> r21) {
        /*
            r12 = this;
            r9 = r12
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            java.lang.String r6 = "components"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r6)
            java.lang.String r6 = "nameResolver"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r6)
            java.lang.String r6 = "containingDeclaration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r6)
            java.lang.String r6 = "typeTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r6)
            java.lang.String r6 = "versionRequirementTable"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r6)
            java.lang.String r6 = "metadataVersion"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            java.lang.String r6 = "typeParameters"
            r7 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            r12.<init>()
            r9.f5686a = r0
            r9.f5687b = r1
            r9.f5688c = r2
            r9.f5689d = r3
            r9.f5690e = r4
            r9.f5691f = r5
            r0 = r19
            r9.f5692g = r0
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer r10 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Deserializer for \""
            r0.append(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r9.f5688c
            kotlin.reflect.jvm.internal.impl.name.Name r1 = r1.getName()
            r0.append(r1)
            r1 = 34
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource r0 = r9.f5692g
            java.lang.String r1 = "[container not found]"
            if (r0 != 0) goto L_0x0068
        L_0x0066:
            r5 = r1
            goto L_0x0070
        L_0x0068:
            java.lang.String r0 = r0.getPresentableString()
            if (r0 != 0) goto L_0x006f
            goto L_0x0066
        L_0x006f:
            r5 = r0
        L_0x0070:
            r6 = 0
            r8 = 32
            r11 = 0
            r0 = r10
            r1 = r12
            r2 = r20
            r3 = r21
            r7 = r8
            r8 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.f5693h = r10
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer r0 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer
            r0.<init>(r12)
            r9.f5694i = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable, kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource, kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer, java.util.List):void");
    }

    public final DeserializationComponents getComponents() {
        return this.f5686a;
    }

    public final NameResolver getNameResolver() {
        return this.f5687b;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.f5688c;
    }

    public final TypeTable getTypeTable() {
        return this.f5689d;
    }

    public final VersionRequirementTable getVersionRequirementTable() {
        return this.f5690e;
    }

    public final DeserializedContainerSource getContainerSource() {
        return this.f5692g;
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.f5693h;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.f5694i;
    }

    public final StorageManager getStorageManager() {
        return this.f5686a.getStorageManager();
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext deserializationContext, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            nameResolver = deserializationContext.f5687b;
        }
        NameResolver nameResolver2 = nameResolver;
        if ((i & 8) != 0) {
            typeTable = deserializationContext.f5689d;
        }
        TypeTable typeTable2 = typeTable;
        if ((i & 16) != 0) {
            versionRequirementTable = deserializationContext.f5690e;
        }
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        if ((i & 32) != 0) {
            binaryVersion = deserializationContext.f5691f;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver2, typeTable2, versionRequirementTable2, binaryVersion);
    }

    public final DeserializationContext childContext(DeclarationDescriptor declarationDescriptor, List<ProtoBuf.TypeParameter> list, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion) {
        DeclarationDescriptor declarationDescriptor2 = declarationDescriptor;
        Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
        List<ProtoBuf.TypeParameter> list2 = list;
        Intrinsics.checkNotNullParameter(list, "typeParameterProtos");
        NameResolver nameResolver2 = nameResolver;
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        Intrinsics.checkNotNullParameter(versionRequirementTable2, "versionRequirementTable");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        DeserializationComponents deserializationComponents = this.f5686a;
        if (!VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(binaryVersion)) {
            versionRequirementTable2 = this.f5690e;
        }
        return new DeserializationContext(deserializationComponents, nameResolver, declarationDescriptor, typeTable, versionRequirementTable2, binaryVersion, this.f5692g, this.f5693h, list);
    }
}
