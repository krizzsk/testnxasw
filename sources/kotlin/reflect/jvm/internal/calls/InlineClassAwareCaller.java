package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, mo148868d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: InlineClassAwareCaller.kt */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {

    /* renamed from: a */
    private final BoxUnboxData f4791a;

    /* renamed from: b */
    private final Caller<M> f4792b;

    /* renamed from: c */
    private final boolean f4793c;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        if ((r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0077;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r9, kotlin.reflect.jvm.internal.calls.Caller<? extends M> r10, boolean r11) {
        /*
            r8 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "caller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r8.<init>()
            r8.f4792b = r10
            r8.f4793c = r11
            r10 = r8
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller r10 = (kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller) r10
            kotlin.reflect.jvm.internal.impl.types.KotlinType r11 = r9.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            java.lang.String r0 = "descriptor.returnType!!"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            java.lang.Class r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r11)
            r0 = 0
            if (r11 == 0) goto L_0x002c
            java.lang.reflect.Method r11 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getBoxMethod(r11, r9)
            goto L_0x002d
        L_0x002c:
            r11 = r0
        L_0x002d:
            r1 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r1
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r1)
            r2 = 0
            if (r1 == 0) goto L_0x0046
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r9 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            kotlin.ranges.IntRange$Companion r10 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r10 = r10.getEMPTY()
            java.lang.reflect.Method[] r0 = new java.lang.reflect.Method[r2]
            r9.<init>(r10, r0, r11)
            goto L_0x015c
        L_0x0046:
            kotlin.reflect.jvm.internal.calls.Caller<M> r1 = r10.f4792b
            boolean r3 = r1 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            java.lang.String r4 = "descriptor.containingDeclaration"
            r5 = -1
            r6 = 1
            if (r3 == 0) goto L_0x0051
            goto L_0x0077
        L_0x0051:
            boolean r3 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r3 == 0) goto L_0x005a
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r1 == 0) goto L_0x0076
            goto L_0x0077
        L_0x005a:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r1 = r9.getDispatchReceiverParameter()
            if (r1 == 0) goto L_0x0076
            kotlin.reflect.jvm.internal.calls.Caller<M> r1 = r10.f4792b
            boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r1 != 0) goto L_0x0076
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r1 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            boolean r1 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r1)
            if (r1 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r5 = 1
            goto L_0x0077
        L_0x0076:
            r5 = 0
        L_0x0077:
            boolean r1 = r10.f4793c
            if (r1 == 0) goto L_0x007d
            r1 = 2
            goto L_0x007e
        L_0x007d:
            r1 = 0
        L_0x007e:
            boolean r3 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r3 == 0) goto L_0x008c
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r3
            boolean r3 = r3.isSuspend()
            if (r3 == 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r6 = 0
        L_0x008d:
            int r1 = r1 + r6
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r6 = r9.getExtensionReceiverParameter()
            if (r6 == 0) goto L_0x009e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            goto L_0x009f
        L_0x009e:
            r6 = r0
        L_0x009f:
            if (r6 == 0) goto L_0x00a5
            r3.add(r6)
            goto L_0x00ed
        L_0x00a5:
            boolean r6 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r6 == 0) goto L_0x00d3
            r4 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = r4.getConstructedClass()
            java.lang.String r6 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            boolean r6 = r4.isInner()
            if (r6 == 0) goto L_0x00ed
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r4 = r4.getContainingDeclaration()
            if (r4 == 0) goto L_0x00cb
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r4
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r4.getDefaultType()
            r3.add(r4)
            goto L_0x00ed
        L_0x00cb:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            r9.<init>(r10)
            throw r9
        L_0x00d3:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r9.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            boolean r4 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r4 == 0) goto L_0x00ed
            boolean r4 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r6)
            if (r4 == 0) goto L_0x00ed
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.SimpleType r4 = r6.getDefaultType()
            r3.add(r4)
        L_0x00ed:
            java.util.List r4 = r9.getValueParameters()
            java.lang.String r6 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x00fc:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0113
            java.lang.Object r6 = r4.next()
            r7 = r3
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            r7.add(r6)
            goto L_0x00fc
        L_0x0113:
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            java.util.List r3 = (java.util.List) r3
            int r4 = r3.size()
            int r4 = r4 + r5
            int r4 = r4 + r1
            r1 = r10
            kotlin.reflect.jvm.internal.calls.Caller r1 = (kotlin.reflect.jvm.internal.calls.Caller) r1
            int r6 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r1)
            if (r6 != r4) goto L_0x015f
            int r10 = java.lang.Math.max(r5, r2)
            int r1 = r3.size()
            int r1 = r1 + r5
            kotlin.ranges.IntRange r10 = kotlin.ranges.RangesKt.until((int) r10, (int) r1)
            java.lang.reflect.Method[] r1 = new java.lang.reflect.Method[r4]
        L_0x0136:
            if (r2 >= r4) goto L_0x0157
            boolean r6 = r10.contains((int) r2)
            if (r6 == 0) goto L_0x0151
            int r6 = r2 - r5
            java.lang.Object r6 = r3.get(r6)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r6
            java.lang.Class r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r6)
            if (r6 == 0) goto L_0x0151
            java.lang.reflect.Method r6 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getUnboxMethod(r6, r9)
            goto L_0x0152
        L_0x0151:
            r6 = r0
        L_0x0152:
            r1[r2] = r6
            int r2 = r2 + 1
            goto L_0x0136
        L_0x0157:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r9 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r9.<init>(r10, r1, r11)
        L_0x015c:
            r8.f4791a = r9
            return
        L_0x015f:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r11 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            r0.append(r2)
            int r1 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r1)
            r0.append(r1)
            java.lang.String r1 = " != "
            r0.append(r1)
            r0.append(r4)
            r1 = 10
            r0.append(r1)
            java.lang.String r2 = "Calling: "
            r0.append(r2)
            r0.append(r9)
            r0.append(r1)
            java.lang.String r9 = "Parameter types: "
            r0.append(r9)
            java.util.List r9 = r10.getParameterTypes()
            r0.append(r9)
            java.lang.String r9 = ")\n"
            r0.append(r9)
            java.lang.String r9 = "Default: "
            r0.append(r9)
            boolean r9 = r10.f4793c
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r11.<init>(r9)
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    public M getMember() {
        return this.f4792b.getMember();
    }

    public Type getReturnType() {
        return this.f4792b.getReturnType();
    }

    public List<Type> getParameterTypes() {
        return this.f4792b.getParameterTypes();
    }

    @Metadata(mo148867d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, mo148868d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, mo148869k = 1, mo148870mv = {1, 5, 1})
    /* compiled from: InlineClassAwareCaller.kt */
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            Intrinsics.checkNotNullParameter(intRange, "argumentRange");
            Intrinsics.checkNotNullParameter(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
        r0 = r0.invoke((java.lang.Object) null, new java.lang.Object[]{r10});
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call(java.lang.Object[] r10) {
        /*
            r9 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = r9.f4791a
            kotlin.ranges.IntRange r1 = r0.component1()
            java.lang.reflect.Method[] r2 = r0.component2()
            java.lang.reflect.Method r0 = r0.component3()
            int r3 = r10.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r10, r3)
            java.lang.String r4 = "java.util.Arrays.copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            if (r3 == 0) goto L_0x0065
            int r4 = r1.getFirst()
            int r1 = r1.getLast()
            r5 = 0
            if (r4 > r1) goto L_0x004f
        L_0x002a:
            r6 = r2[r4]
            r7 = r10[r4]
            if (r6 == 0) goto L_0x0048
            if (r7 == 0) goto L_0x0039
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r7 = r6.invoke(r7, r8)
            goto L_0x0048
        L_0x0039:
            java.lang.Class r6 = r6.getReturnType()
            java.lang.String r7 = "method.returnType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.reflect.Type r6 = (java.lang.reflect.Type) r6
            java.lang.Object r7 = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(r6)
        L_0x0048:
            r3[r4] = r7
            if (r4 == r1) goto L_0x004f
            int r4 = r4 + 1
            goto L_0x002a
        L_0x004f:
            kotlin.reflect.jvm.internal.calls.Caller<M> r10 = r9.f4792b
            java.lang.Object r10 = r10.call(r3)
            if (r0 == 0) goto L_0x0064
            r1 = 0
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r10
            java.lang.Object r0 = r0.invoke(r1, r2)
            if (r0 == 0) goto L_0x0064
            r10 = r0
        L_0x0064:
            return r10
        L_0x0065:
            java.lang.NullPointerException r10 = new java.lang.NullPointerException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>"
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.call(java.lang.Object[]):java.lang.Object");
    }
}
