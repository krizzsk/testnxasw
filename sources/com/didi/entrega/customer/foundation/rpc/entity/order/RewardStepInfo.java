package com.didi.entrega.customer.foundation.rpc.entity.order;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/entrega/customer/foundation/rpc/entity/order/RewardStepInfo;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "desc", "", "status", "", "time", "passed", "(Ljava/lang/String;III)V", "getDesc", "()Ljava/lang/String;", "getPassed", "()I", "getStatus", "getTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrderInfoEntity.kt */
public final class RewardStepInfo implements IEntity {
    private final String desc;
    private final int passed;
    private final int status;
    private final int time;

    public RewardStepInfo() {
        this((String) null, 0, 0, 0, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RewardStepInfo copy$default(RewardStepInfo rewardStepInfo, String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = rewardStepInfo.desc;
        }
        if ((i4 & 2) != 0) {
            i = rewardStepInfo.status;
        }
        if ((i4 & 4) != 0) {
            i2 = rewardStepInfo.time;
        }
        if ((i4 & 8) != 0) {
            i3 = rewardStepInfo.passed;
        }
        return rewardStepInfo.copy(str, i, i2, i3);
    }

    public final String component1() {
        return this.desc;
    }

    public final int component2() {
        return this.status;
    }

    public final int component3() {
        return this.time;
    }

    public final int component4() {
        return this.passed;
    }

    public final RewardStepInfo copy(String str, int i, int i2, int i3) {
        return new RewardStepInfo(str, i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RewardStepInfo)) {
            return false;
        }
        RewardStepInfo rewardStepInfo = (RewardStepInfo) obj;
        return Intrinsics.areEqual((Object) this.desc, (Object) rewardStepInfo.desc) && this.status == rewardStepInfo.status && this.time == rewardStepInfo.time && this.passed == rewardStepInfo.passed;
    }

    public int hashCode() {
        String str = this.desc;
        return ((((((str == null ? 0 : str.hashCode()) * 31) + this.status) * 31) + this.time) * 31) + this.passed;
    }

    public String toString() {
        return "RewardStepInfo(desc=" + this.desc + ", status=" + this.status + ", time=" + this.time + ", passed=" + this.passed + VersionRange.RIGHT_OPEN;
    }

    public RewardStepInfo(String str, int i, int i2, int i3) {
        this.desc = str;
        this.status = i;
        this.time = i2;
        this.passed = i3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardStepInfo(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? null : str, (i4 & 2) != 0 ? 0 : i, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getStatus() {
        return this.status;
    }

    public final int getTime() {
        return this.time;
    }

    public final int getPassed() {
        return this.passed;
    }
}
