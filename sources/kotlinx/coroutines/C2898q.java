package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002R/\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo148868d2 = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "kotlinx-coroutines-core"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: kotlinx.coroutines.q */
/* compiled from: JobSupport.kt */
final class C2898q extends JobNode {

    /* renamed from: a */
    private final Function1<Throwable, Unit> f6280a;

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public C2898q(Function1<? super Throwable, Unit> function1) {
        this.f6280a = function1;
    }

    public void invoke(Throwable th) {
        this.f6280a.invoke(th);
    }
}
