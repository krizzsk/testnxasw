package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u000bHÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006!"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/RewardInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "title", "", "subTitle", "replaceInfo", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/ReplaceInfo;", "process", "Lcom/didi/entrega/customer/foundation/rpc/entity/order/RewardStepInfo;", "compensationStage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;I)V", "getCompensationStage", "()I", "getProcess", "()Ljava/util/List;", "getReplaceInfo", "getSubTitle", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class RewardInfo implements IEntity {
    private final int compensationStage;
    private final List<RewardStepInfo> process;
    private final List<ReplaceInfo> replaceInfo;
    private final String subTitle;
    private final String title;

    public RewardInfo() {
        this((String) null, (String) null, (List) null, (List) null, 0, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RewardInfo copy$default(RewardInfo rewardInfo, String str, String str2, List<ReplaceInfo> list, List<RewardStepInfo> list2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rewardInfo.title;
        }
        if ((i2 & 2) != 0) {
            str2 = rewardInfo.subTitle;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            list = rewardInfo.replaceInfo;
        }
        List<ReplaceInfo> list3 = list;
        if ((i2 & 8) != 0) {
            list2 = rewardInfo.process;
        }
        List<RewardStepInfo> list4 = list2;
        if ((i2 & 16) != 0) {
            i = rewardInfo.compensationStage;
        }
        return rewardInfo.copy(str, str3, list3, list4, i);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subTitle;
    }

    public final List<ReplaceInfo> component3() {
        return this.replaceInfo;
    }

    public final List<RewardStepInfo> component4() {
        return this.process;
    }

    public final int component5() {
        return this.compensationStage;
    }

    public final RewardInfo copy(String str, String str2, List<ReplaceInfo> list, List<RewardStepInfo> list2, int i) {
        return new RewardInfo(str, str2, list, list2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardInfo)) {
            return false;
        }
        RewardInfo rewardInfo = (RewardInfo) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) rewardInfo.title) && Intrinsics.areEqual((Object) this.subTitle, (Object) rewardInfo.subTitle) && Intrinsics.areEqual((Object) this.replaceInfo, (Object) rewardInfo.replaceInfo) && Intrinsics.areEqual((Object) this.process, (Object) rewardInfo.process) && this.compensationStage == rewardInfo.compensationStage;
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subTitle;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<ReplaceInfo> list = this.replaceInfo;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<RewardStepInfo> list2 = this.process;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.compensationStage;
    }

    public String toString() {
        return "RewardInfo(title=" + this.title + ", subTitle=" + this.subTitle + ", replaceInfo=" + this.replaceInfo + ", process=" + this.process + ", compensationStage=" + this.compensationStage + VersionRange.RIGHT_OPEN;
    }

    public RewardInfo(String str, String str2, List<ReplaceInfo> list, List<RewardStepInfo> list2, int i) {
        this.title = str;
        this.subTitle = str2;
        this.replaceInfo = list;
        this.process = list2;
        this.compensationStage = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RewardInfo(java.lang.String r4, java.lang.String r5, java.util.List r6, java.util.List r7, int r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            if (r10 == 0) goto L_0x0007
            r10 = r0
            goto L_0x0008
        L_0x0007:
            r10 = r4
        L_0x0008:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r5
        L_0x000f:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r6
        L_0x0016:
            r4 = r9 & 8
            if (r4 == 0) goto L_0x001b
            goto L_0x001c
        L_0x001b:
            r0 = r7
        L_0x001c:
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0023
            r8 = 0
            r9 = 0
            goto L_0x0024
        L_0x0023:
            r9 = r8
        L_0x0024:
            r4 = r3
            r5 = r10
            r6 = r1
            r7 = r2
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.customer.foundation.rpc.entity.order.RewardInfo.<init>(java.lang.String, java.lang.String, java.util.List, java.util.List, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final List<ReplaceInfo> getReplaceInfo() {
        return this.replaceInfo;
    }

    public final List<RewardStepInfo> getProcess() {
        return this.process;
    }

    public final int getCompensationStage() {
        return this.compensationStage;
    }
}
