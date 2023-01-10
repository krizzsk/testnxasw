package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.util.CheckResult;
import kotlin.text.Regex;

/* compiled from: modifierChecks.kt */
public final class Checks {

    /* renamed from: a */
    private final Name f5891a;

    /* renamed from: b */
    private final Regex f5892b;

    /* renamed from: c */
    private final Collection<Name> f5893c;

    /* renamed from: d */
    private final Function1<FunctionDescriptor, String> f5894d;

    /* renamed from: e */
    private final Check[] f5895e;

    private Checks(Name name, Regex regex, Collection<Name> collection, Function1<? super FunctionDescriptor, String> function1, Check... checkArr) {
        this.f5891a = name;
        this.f5892b = regex;
        this.f5893c = collection;
        this.f5894d = function1;
        this.f5895e = checkArr;
    }

    public final boolean isApplicable(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        if (this.f5891a != null && !Intrinsics.areEqual((Object) functionDescriptor.getName(), (Object) this.f5891a)) {
            return false;
        }
        if (this.f5892b != null) {
            String asString = functionDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "functionDescriptor.name.asString()");
            if (!this.f5892b.matches(asString)) {
                return false;
            }
        }
        Collection<Name> collection = this.f5893c;
        if (collection == null || collection.contains(functionDescriptor.getName())) {
            return true;
        }
        return false;
    }

    public final CheckResult checkAll(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        Check[] checkArr = this.f5895e;
        int length = checkArr.length;
        int i = 0;
        while (i < length) {
            Check check = checkArr[i];
            i++;
            String invoke = check.invoke(functionDescriptor);
            if (invoke != null) {
                return new CheckResult.IllegalSignature(invoke);
            }
        }
        String invoke2 = this.f5894d.invoke(functionDescriptor);
        if (invoke2 != null) {
            return new CheckResult.IllegalSignature(invoke2);
        }
        return CheckResult.SuccessCheck.INSTANCE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Name name, Check[] checkArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(name, checkArr, (Function1<? super FunctionDescriptor, String>) (i & 4) != 0 ? C26812.INSTANCE : function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Checks(Name name, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        this(name, (Regex) null, (Collection<Name>) null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(checkArr, "checks");
        Intrinsics.checkNotNullParameter(function1, "additionalChecks");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Regex regex, Check[] checkArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(regex, checkArr, (Function1<? super FunctionDescriptor, String>) (i & 4) != 0 ? C26823.INSTANCE : function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Checks(Regex regex, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        this((Name) null, regex, (Collection<Name>) null, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        Intrinsics.checkNotNullParameter(regex, "regex");
        Intrinsics.checkNotNullParameter(checkArr, "checks");
        Intrinsics.checkNotNullParameter(function1, "additionalChecks");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Checks(Collection collection, Check[] checkArr, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((Collection<Name>) collection, checkArr, (Function1<? super FunctionDescriptor, String>) (i & 4) != 0 ? C26834.INSTANCE : function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Checks(Collection<Name> collection, Check[] checkArr, Function1<? super FunctionDescriptor, String> function1) {
        this((Name) null, (Regex) null, collection, function1, (Check[]) Arrays.copyOf(checkArr, checkArr.length));
        Intrinsics.checkNotNullParameter(collection, "nameList");
        Intrinsics.checkNotNullParameter(checkArr, "checks");
        Intrinsics.checkNotNullParameter(function1, "additionalChecks");
    }
}
