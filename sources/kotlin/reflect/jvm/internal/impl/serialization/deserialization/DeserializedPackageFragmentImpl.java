package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedPackageFragmentImpl.kt */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {

    /* renamed from: a */
    private final BinaryVersion f5698a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DeserializedContainerSource f5699b;

    /* renamed from: c */
    private final NameResolverImpl f5700c;

    /* renamed from: d */
    private final ProtoBasedClassDataFinder f5701d;

    /* renamed from: e */
    private ProtoBuf.PackageFragment f5702e;

    /* renamed from: f */
    private MemberScope f5703f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        super(fqName, storageManager, moduleDescriptor);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(packageFragment, "proto");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        this.f5698a = binaryVersion;
        this.f5699b = deserializedContainerSource;
        ProtoBuf.StringTable strings = packageFragment.getStrings();
        Intrinsics.checkNotNullExpressionValue(strings, "proto.strings");
        ProtoBuf.QualifiedNameTable qualifiedNames = packageFragment.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.f5700c = nameResolverImpl;
        this.f5701d = new ProtoBasedClassDataFinder(packageFragment, nameResolverImpl, this.f5698a, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this.f5702e = packageFragment;
    }

    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.f5701d;
    }

    public void initialize(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        ProtoBuf.PackageFragment packageFragment = this.f5702e;
        if (packageFragment != null) {
            this.f5702e = null;
            ProtoBuf.Package packageR = packageFragment.getPackage();
            Intrinsics.checkNotNullExpressionValue(packageR, "proto.`package`");
            this.f5703f = new DeserializedPackageMemberScope(this, packageR, this.f5700c, this.f5698a, this.f5699b, deserializationComponents, Intrinsics.stringPlus("scope of ", this), new DeserializedPackageFragmentImpl$initialize$1(this));
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    public MemberScope getMemberScope() {
        MemberScope memberScope = this.f5703f;
        if (memberScope != null) {
            return memberScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        return null;
    }
}
