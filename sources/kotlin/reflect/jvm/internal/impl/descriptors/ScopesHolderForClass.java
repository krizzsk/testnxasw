package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.C2404Reflection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ScopesHolderForClass.kt */
public final class ScopesHolderForClass<T extends MemberScope> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    static final /* synthetic */ KProperty<Object>[] f4891a = {C2404Reflection.property1(new PropertyReference1Impl(C2404Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};

    /* renamed from: b */
    private final ClassDescriptor f4892b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Function1<KotlinTypeRefiner, T> f4893c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final KotlinTypeRefiner f4894d;

    /* renamed from: e */
    private final NotNullLazyValue f4895e;

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, storageManager, function1, kotlinTypeRefiner);
    }

    private ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1<? super KotlinTypeRefiner, ? extends T> function1, KotlinTypeRefiner kotlinTypeRefiner) {
        this.f4892b = classDescriptor;
        this.f4893c = function1;
        this.f4894d = kotlinTypeRefiner;
        this.f4895e = storageManager.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    /* renamed from: a */
    private final T m4704a() {
        return (MemberScope) StorageKt.getValue(this.f4895e, (Object) this, (KProperty<?>) f4891a[0]);
    }

    public final T getScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.f4892b))) {
            return m4704a();
        }
        TypeConstructor typeConstructor = this.f4892b.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        if (!kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor)) {
            return m4704a();
        }
        return kotlinTypeRefiner.getOrPutScopeForClass(this.f4892b, new ScopesHolderForClass$getScope$1(this, kotlinTypeRefiner));
    }

    /* compiled from: ScopesHolderForClass.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefiner, Function1<? super KotlinTypeRefiner, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(function1, "scopeFactory");
            return new ScopesHolderForClass(classDescriptor, storageManager, function1, kotlinTypeRefiner, (DefaultConstructorMarker) null);
        }
    }
}
