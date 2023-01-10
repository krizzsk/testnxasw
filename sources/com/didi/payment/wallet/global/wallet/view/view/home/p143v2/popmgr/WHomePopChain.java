package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.popmgr;

import android.content.Context;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148867d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/WHomePopChain;", "", "()V", "TAG", "", "isHomeVisible", "", "()Z", "setHomeVisible", "(Z)V", "tasks", "Ljava/util/ArrayList;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopTask;", "Lkotlin/collections/ArrayList;", "addTask", "taskId", "", "dismiss", "", "context", "Landroid/content/Context;", "getTaskById", "getTaskName", "process", "start", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain */
/* compiled from: WHomePopChain.kt */
public final class WHomePopChain {
    public static final WHomePopChain INSTANCE = new WHomePopChain();

    /* renamed from: a */
    private static final String f35321a = "DDF-WHomePopChain";

    /* renamed from: b */
    private static final ArrayList<PopTask> f35322b = new ArrayList<>();

    /* renamed from: c */
    private static boolean f35323c;

    public final String getTaskName(int i) {
        return i != 100 ? i != 200 ? i != 300 ? "null" : "BoletoPopTask" : "FinSysPopTask" : "PopUpApiTask";
    }

    private WHomePopChain() {
    }

    public final boolean isHomeVisible() {
        return f35323c;
    }

    public final void setHomeVisible(boolean z) {
        f35323c = z;
    }

    public final WHomePopChain addTask(int i) {
        String str = f35321a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("addTask %s ", Arrays.copyOf(new Object[]{getTaskName(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        SystemUtils.log(6, str, format, (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 21);
        for (PopTask taskId : f35322b) {
            if (taskId.getTaskId() == i) {
                return this;
            }
        }
        PopTask create = TaskFactory.INSTANCE.create(i);
        if (create == null) {
            return this;
        }
        int priority = create.getPriority();
        if (f35322b.isEmpty()) {
            f35322b.add(create);
            return this;
        }
        int lastIndex = CollectionsKt.getLastIndex(f35322b);
        if (lastIndex >= 0) {
            while (true) {
                int i2 = lastIndex - 1;
                if (f35322b.get(lastIndex).getPriority() < priority) {
                    if (i2 < 0) {
                        break;
                    }
                    lastIndex = i2;
                } else if (lastIndex == CollectionsKt.getLastIndex(f35322b)) {
                    f35322b.add(create);
                } else {
                    f35322b.add(lastIndex + 1, create);
                }
            }
        }
        f35322b.add(create);
        return this;
    }

    public final void start(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        PopTask taskById = getTaskById(i);
        if (taskById != null) {
            String str = f35321a;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("startTask %s ", Arrays.copyOf(new Object[]{getTaskName(i)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            SystemUtils.log(6, str, format, (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 51);
            taskById.reqData(context, new WHomePopChain$start$1(context));
        }
    }

    public final PopTask getTaskById(int i) {
        for (PopTask popTask : f35322b) {
            if (popTask.getTaskId() == i) {
                return popTask;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m26838a(Context context) {
        Context context2 = context;
        Iterator<PopTask> it = f35322b.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "tasks.iterator()");
        while (it.hasNext()) {
            PopTask next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
            PopTask popTask = next;
            if (popTask.getStatus() != 2) {
                SystemUtils.log(6, f35321a, Intrinsics.stringPlus("process: task not ready:  ", getTaskName(popTask.getTaskId())), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 72);
                return;
            }
            SystemUtils.log(6, f35321a, Intrinsics.stringPlus("process: taskid = ", getTaskName(popTask.getTaskId())), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 75);
            if (popTask.canShow(context2)) {
                if (f35323c) {
                    popTask.show(context2);
                } else {
                    SystemUtils.log(6, f35321a, "process: isHomeVisible = false", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 80);
                }
                f35322b.clear();
                SystemUtils.log(6, f35321a, "process: clear tasks", (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 83);
                return;
            }
            it.remove();
            SystemUtils.log(6, f35321a, Intrinsics.stringPlus("process: remove taskid = ", getTaskName(popTask.getTaskId())), (Throwable) null, "com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.WHomePopChain", 87);
        }
    }

    public final void dismiss(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "context");
        PopTask taskById = getTaskById(i);
        if (taskById != null) {
            taskById.dismiss(context);
        }
    }
}
