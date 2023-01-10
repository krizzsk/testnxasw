package com.compatible.old.topbar;

import android.util.Pair;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.misconfig.p154v2.impl.PriConfImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/compatible/old/topbar/SaIndexPriConf;", "Lcom/didi/sdk/misconfig/v2/impl/PriConfImpl;", "()V", "getDefaultGroupId", "", "getDefaultSelectedType", "", "getSelectGroupId", "Landroid/util/Pair;", "getSelectedGroupId", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SaIndexPriConf.kt */
public final class SaIndexPriConf extends PriConfImpl {
    public Pair<Integer, Integer> getSelectGroupId() {
        if (SuperAppBusinessManager.INSTANCE.isCurrentSa()) {
            return new Pair<>(0, 30008);
        }
        Pair<Integer, Integer> selectGroupId = super.getSelectGroupId();
        Intrinsics.checkNotNullExpressionValue(selectGroupId, "super.getSelectGroupId()");
        return selectGroupId;
    }

    public int getDefaultGroupId() {
        if (SuperAppBusinessManager.INSTANCE.isCurrentSa()) {
            return 30008;
        }
        return super.getDefaultGroupId();
    }

    public String getDefaultSelectedType() {
        if (SuperAppBusinessManager.INSTANCE.isCurrentSa()) {
            return "sa_home";
        }
        String defaultSelectedType = super.getDefaultSelectedType();
        Intrinsics.checkNotNullExpressionValue(defaultSelectedType, "super.getDefaultSelectedType()");
        return defaultSelectedType;
    }

    public int getSelectedGroupId() {
        if (SuperAppBusinessManager.INSTANCE.isCurrentSa()) {
            return 30008;
        }
        return super.getSelectedGroupId();
    }
}
