package com.didi.entrega.info.repo;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.info.model.HistoryModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002J&\u0010\u0013\u001a\u00020\u00102\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u0015\u001a\u00020\u0002J&\u0010\u0016\u001a\u00020\u00102\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\u0015\u001a\u00020\u0002R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006\u0018"}, mo148868d2 = {"Lcom/didi/entrega/info/repo/HistoryListRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "()V", "historyReceiveContactList", "Ljava/util/ArrayList;", "Lcom/didi/entrega/info/model/HistoryModel;", "Lkotlin/collections/ArrayList;", "getHistoryReceiveContactList", "()Ljava/util/ArrayList;", "setHistoryReceiveContactList", "(Ljava/util/ArrayList;)V", "historySendContactList", "getHistorySendContactList", "setHistorySendContactList", "clear", "", "deleteOneFromHistory", "aid", "putReceiveHistoryContactList", "contact", "actionStr", "putSendHistoryContactList", "Companion", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: HistoryListRepo.kt */
public final class HistoryListRepo extends Repo<String> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final String f22656c = "delete";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final String f22657d = "update_his";

    /* renamed from: a */
    private ArrayList<HistoryModel> f22658a = new ArrayList<>();

    /* renamed from: b */
    private ArrayList<HistoryModel> f22659b = new ArrayList<>();

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo148868d2 = {"Lcom/didi/entrega/info/repo/HistoryListRepo$Companion;", "", "()V", "DELETE", "", "getDELETE", "()Ljava/lang/String;", "UPDATE_HIS", "getUPDATE_HIS", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: HistoryListRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getDELETE() {
            return HistoryListRepo.f22656c;
        }

        public final String getUPDATE_HIS() {
            return HistoryListRepo.f22657d;
        }
    }

    public final ArrayList<HistoryModel> getHistorySendContactList() {
        return this.f22658a;
    }

    public final void setHistorySendContactList(ArrayList<HistoryModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f22658a = arrayList;
    }

    public final ArrayList<HistoryModel> getHistoryReceiveContactList() {
        return this.f22659b;
    }

    public final void setHistoryReceiveContactList(ArrayList<HistoryModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f22659b = arrayList;
    }

    public final void putSendHistoryContactList(ArrayList<HistoryModel> arrayList, String str) {
        Intrinsics.checkNotNullParameter(arrayList, "contact");
        Intrinsics.checkNotNullParameter(str, "actionStr");
        this.f22658a.clear();
        this.f22658a.addAll(arrayList);
        super.setValue(str);
    }

    public final void putReceiveHistoryContactList(ArrayList<HistoryModel> arrayList, String str) {
        Intrinsics.checkNotNullParameter(arrayList, "contact");
        Intrinsics.checkNotNullParameter(str, "actionStr");
        this.f22659b.clear();
        this.f22659b.addAll(arrayList);
        super.setValue(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0060, code lost:
        r1 = r1.getAddress();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void deleteOneFromHistory(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "aid"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.ArrayList<com.didi.entrega.info.model.HistoryModel> r0 = r4.f22658a
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "historySendContactList.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L_0x0010:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x003c
            java.lang.Object r1 = r0.next()
            java.lang.String r3 = "iterator.next()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            com.didi.entrega.info.model.HistoryModel r1 = (com.didi.entrega.info.model.HistoryModel) r1
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r1 = r1.getHistoryEntity()
            if (r1 != 0) goto L_0x0029
            goto L_0x0032
        L_0x0029:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getAddress()
            if (r1 != 0) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            java.lang.String r2 = r1.aid
        L_0x0032:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x0010
            r0.remove()
            goto L_0x0010
        L_0x003c:
            java.util.ArrayList<com.didi.entrega.info.model.HistoryModel> r0 = r4.f22659b
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r1 = "historyReceiveContactList.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        L_0x0047:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0073
            java.lang.Object r1 = r0.next()
            java.lang.String r3 = "iteratorReceive.next()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            com.didi.entrega.info.model.HistoryModel r1 = (com.didi.entrega.info.model.HistoryModel) r1
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$HistoryContact r1 = r1.getHistoryEntity()
            if (r1 != 0) goto L_0x0060
        L_0x005e:
            r1 = r2
            goto L_0x0069
        L_0x0060:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r1 = r1.getAddress()
            if (r1 != 0) goto L_0x0067
            goto L_0x005e
        L_0x0067:
            java.lang.String r1 = r1.aid
        L_0x0069:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x0047
            r0.remove()
            goto L_0x0047
        L_0x0073:
            java.lang.String r5 = f22656c
            super.setValue(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.repo.HistoryListRepo.deleteOneFromHistory(java.lang.String):void");
    }

    public final void clear() {
        this.f22659b.clear();
        this.f22658a.clear();
    }
}
