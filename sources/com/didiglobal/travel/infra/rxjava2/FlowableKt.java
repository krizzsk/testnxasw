package com.didiglobal.travel.infra.rxjava2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p218io.reactivex.Flowable;
import p218io.reactivex.android.schedulers.AndroidSchedulers;
import p218io.reactivex.schedulers.Schedulers;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a5\u0010\u0004\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001d\u0010\u0006\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n\u001a\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001¨\u0006\f"}, mo148868d2 = {"fromIoToMain", "Lio/reactivex/Flowable;", "T", "observeOnMain", "subscribeBy", "Lio/reactivex/disposables/Disposable;", "supplier", "Lkotlin/Function1;", "Lcom/didiglobal/travel/infra/rxjava2/FlowableSubscribe;", "", "Lkotlin/ExtensionFunctionType;", "subscribeOnIo", "lib-rxjava2_release"}, mo148869k = 2, mo148870mv = {1, 1, 16})
/* compiled from: Flowable.kt */
public final class FlowableKt {
    /* JADX WARNING: type inference failed for: r3v0, types: [com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: type inference failed for: r3v1, types: [com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Action$0] */
    /* JADX WARNING: type inference failed for: r2v6, types: [com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> p218io.reactivex.disposables.Disposable subscribeBy(p218io.reactivex.Flowable<T> r4, kotlin.jvm.functions.Function1<? super com.didiglobal.travel.infra.rxjava2.FlowableSubscribe<T>, kotlin.Unit> r5) {
        /*
            java.lang.String r0 = "$this$subscribeBy"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = "supplier"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r5, r0)
            com.didiglobal.travel.infra.rxjava2.FlowableSubscribe r0 = new com.didiglobal.travel.infra.rxjava2.FlowableSubscribe
            r0.<init>()
            r5.invoke(r0)
            kotlin.jvm.functions.Function1 r5 = r0.getOnNextAction$lib_rxjava2_release()
            if (r5 == 0) goto L_0x0068
            com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0 r1 = new com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0
            r1.<init>(r5)
            io.reactivex.functions.Consumer r1 = (p218io.reactivex.functions.Consumer) r1
            kotlin.jvm.functions.Function1 r5 = r0.getOnErrorAction$lib_rxjava2_release()
            if (r5 == 0) goto L_0x0026
            goto L_0x002a
        L_0x0026:
            kotlin.jvm.functions.Function1 r5 = com.didiglobal.travel.infra.rxjava2.RxSubscriber.defaultErrorHandler()
        L_0x002a:
            if (r5 == 0) goto L_0x0032
            com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0 r2 = new com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0
            r2.<init>(r5)
            r5 = r2
        L_0x0032:
            io.reactivex.functions.Consumer r5 = (p218io.reactivex.functions.Consumer) r5
            kotlin.jvm.functions.Function0 r2 = r0.getOnCompleteAction$lib_rxjava2_release()
            if (r2 == 0) goto L_0x003b
            goto L_0x003f
        L_0x003b:
            kotlin.jvm.functions.Function0 r2 = com.didiglobal.travel.infra.rxjava2.RxSubscriber.getEmptyCompleteAction()
        L_0x003f:
            if (r2 == 0) goto L_0x0047
            com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Action$0 r3 = new com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Action$0
            r3.<init>(r2)
            r2 = r3
        L_0x0047:
            io.reactivex.functions.Action r2 = (p218io.reactivex.functions.Action) r2
            kotlin.jvm.functions.Function1 r0 = r0.getOnSubscribeAction$lib_rxjava2_release()
            if (r0 == 0) goto L_0x0050
            goto L_0x0054
        L_0x0050:
            kotlin.jvm.functions.Function1 r0 = com.didiglobal.travel.infra.rxjava2.RxSubscriber.getEmptyConsumer()
        L_0x0054:
            if (r0 == 0) goto L_0x005c
            com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0 r3 = new com.didiglobal.travel.infra.rxjava2.FlowableKt$sam$io_reactivex_functions_Consumer$0
            r3.<init>(r0)
            r0 = r3
        L_0x005c:
            io.reactivex.functions.Consumer r0 = (p218io.reactivex.functions.Consumer) r0
            io.reactivex.disposables.Disposable r4 = r4.subscribe(r1, r5, r2, r0)
            java.lang.String r5 = "this.subscribe(\n        …mer<Subscription>()\n    )"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            return r4
        L_0x0068:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "Must provide onNext consumer."
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.travel.infra.rxjava2.FlowableKt.subscribeBy(io.reactivex.Flowable, kotlin.jvm.functions.Function1):io.reactivex.disposables.Disposable");
    }

    public static final <T> Flowable<T> subscribeOnIo(Flowable<T> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$subscribeOnIo");
        Flowable<T> subscribeOn = flowable.subscribeOn(Schedulers.m46030io());
        Intrinsics.checkExpressionValueIsNotNull(subscribeOn, "this.subscribeOn(Schedulers.io())");
        return subscribeOn;
    }

    public static final <T> Flowable<T> observeOnMain(Flowable<T> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$observeOnMain");
        Flowable<T> observeOn = flowable.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.observeOn(AndroidSchedulers.mainThread())");
        return observeOn;
    }

    public static final <T> Flowable<T> fromIoToMain(Flowable<T> flowable) {
        Intrinsics.checkParameterIsNotNull(flowable, "$this$fromIoToMain");
        Flowable<T> observeOn = flowable.subscribeOn(Schedulers.m46030io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkExpressionValueIsNotNull(observeOn, "this.subscribeOn(Schedul…dSchedulers.mainThread())");
        return observeOn;
    }
}
