package com.facebook.appevents.internal;

import com.didi.sdk.apm.SystemUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, mo148868d2 = {"com/facebook/appevents/internal/HashUtils$computeChecksumWithPackageManager$listener$1", "Ljava/lang/reflect/InvocationHandler;", "invoke", "", "o", "method", "Ljava/lang/reflect/Method;", "objects", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "facebook-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HashUtils.kt */
public final class HashUtils$computeChecksumWithPackageManager$listener$1 implements InvocationHandler {
    final /* synthetic */ Object $TYPE_WHOLE_MD5;
    final /* synthetic */ Condition $checksumReady;
    final /* synthetic */ ReentrantLock $lock;
    final /* synthetic */ Ref.ObjectRef<String> $resultChecksum;

    HashUtils$computeChecksumWithPackageManager$listener$1(Object obj, Ref.ObjectRef<String> objectRef, ReentrantLock reentrantLock, Condition condition) {
        this.$TYPE_WHOLE_MD5 = obj;
        this.$resultChecksum = objectRef;
        this.$lock = reentrantLock;
        this.$checksumReady = condition;
    }

    public Object invoke(Object obj, Method method, Object[] objArr) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(objArr, "objects");
        try {
            if (Intrinsics.areEqual((Object) method.getName(), (Object) "onChecksumsReady") && objArr.length == 1 && (objArr[0] instanceof List)) {
                for (Object next : objArr[0]) {
                    if (next != null) {
                        Method method2 = next.getClass().getMethod("getSplitName", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method2, "c.javaClass.getMethod(\"getSplitName\")");
                        Method method3 = next.getClass().getMethod("getType", new Class[0]);
                        Intrinsics.checkNotNullExpressionValue(method3, "c.javaClass.getMethod(\"getType\")");
                        if (method2.invoke(next, new Object[0]) == null && Intrinsics.areEqual(method3.invoke(next, new Object[0]), this.$TYPE_WHOLE_MD5)) {
                            Method method4 = next.getClass().getMethod("getValue", new Class[0]);
                            Intrinsics.checkNotNullExpressionValue(method4, "c.javaClass.getMethod(\"getValue\")");
                            Object invoke = method4.invoke(next, new Object[0]);
                            if (invoke != null) {
                                this.$resultChecksum.element = new BigInteger(1, (byte[]) invoke).toString(16);
                                this.$lock.lock();
                                this.$checksumReady.signalAll();
                                this.$lock.unlock();
                                return null;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                        }
                    }
                }
            }
        } catch (Throwable th) {
            SystemUtils.log(3, HashUtils.TAG, "Can't fetch checksum.", th, "com.facebook.appevents.internal.HashUtils$computeChecksumWithPackageManager$listener$1", 107);
        }
        return null;
    }
}
