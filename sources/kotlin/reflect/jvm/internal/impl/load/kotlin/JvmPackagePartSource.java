package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.didi.flutter.nacho2.p116v2.NachoConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.text.StringsKt;
import org.apache.commons.p074io.IOUtils;

/* compiled from: JvmPackagePartSource.kt */
public final class JvmPackagePartSource implements DeserializedContainerSource {

    /* renamed from: a */
    private final JvmClassName f5352a;

    /* renamed from: b */
    private final JvmClassName f5353b;

    /* renamed from: c */
    private final IncompatibleVersionErrorData<JvmMetadataVersion> f5354c;

    /* renamed from: d */
    private final boolean f5355d;

    /* renamed from: e */
    private final DeserializedContainerAbiStability f5356e;

    /* renamed from: f */
    private final KotlinJvmBinaryClass f5357f;

    /* renamed from: g */
    private final String f5358g;

    public JvmPackagePartSource(JvmClassName jvmClassName, JvmClassName jvmClassName2, ProtoBuf.Package packageR, NameResolver nameResolver, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z, DeserializedContainerAbiStability deserializedContainerAbiStability, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        String string;
        Intrinsics.checkNotNullParameter(jvmClassName, "className");
        Intrinsics.checkNotNullParameter(packageR, "packageProto");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(deserializedContainerAbiStability, "abiStability");
        this.f5352a = jvmClassName;
        this.f5353b = jvmClassName2;
        this.f5354c = incompatibleVersionErrorData;
        this.f5355d = z;
        this.f5356e = deserializedContainerAbiStability;
        this.f5357f = kotlinJvmBinaryClass;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> generatedExtension = JvmProtoBuf.packageModuleName;
        Intrinsics.checkNotNullExpressionValue(generatedExtension, "packageModuleName");
        Integer num = (Integer) ProtoBufUtilKt.getExtensionOrNull(packageR, generatedExtension);
        String str = NachoConstants.NACHO_ENTRYPOINT_NAME;
        if (!(num == null || (string = nameResolver.getString(num.intValue())) == null)) {
            str = string;
        }
        this.f5358g = str;
    }

    public final JvmClassName getFacadeClassName() {
        return this.f5353b;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.f5357f;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JvmPackagePartSource(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass r11, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package r12, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver r13, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData<kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion> r14, boolean r15, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability r16) {
        /*
            r10 = this;
            java.lang.String r0 = "kotlinClass"
            r9 = r11
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "packageProto"
            r4 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "nameResolver"
            r5 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "abiStability"
            r8 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r11.getClassId()
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r2 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byClassId(r0)
            java.lang.String r0 = "byClassId(kotlinClass.classId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader r0 = r11.getClassHeader()
            java.lang.String r0 = r0.getMultifileClassName()
            r1 = 0
            if (r0 != 0) goto L_0x0033
        L_0x0031:
            r3 = r1
            goto L_0x0046
        L_0x0033:
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x003e
            r3 = 1
            goto L_0x003f
        L_0x003e:
            r3 = 0
        L_0x003f:
            if (r3 == 0) goto L_0x0031
            kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName r1 = kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName.byInternalName(r0)
            goto L_0x0031
        L_0x0046:
            r1 = r10
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r16
            r9 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource.<init>(kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver, kotlin.reflect.jvm.internal.impl.serialization.deserialization.IncompatibleVersionErrorData, boolean, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability):void");
    }

    public String getPresentableString() {
        return "Class '" + getClassId().asSingleFqName().asString() + '\'';
    }

    public final Name getSimpleName() {
        String internalName = this.f5352a.getInternalName();
        Intrinsics.checkNotNullExpressionValue(internalName, "className.internalName");
        Name identifier = Name.identifier(StringsKt.substringAfterLast$default(internalName, (char) IOUtils.DIR_SEPARATOR_UNIX, (String) null, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(className.int???.substringAfterLast('/'))");
        return identifier;
    }

    public final ClassId getClassId() {
        return new ClassId(this.f5352a.getPackageFqName(), getSimpleName());
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + this.f5352a;
    }

    public SourceFile getContainingFile() {
        SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
        Intrinsics.checkNotNullExpressionValue(sourceFile, "NO_SOURCE_FILE");
        return sourceFile;
    }
}
