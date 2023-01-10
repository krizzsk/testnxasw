package com.didi.soda.customer.foundation.rpc.entity;

import android.os.Build;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/PayBizParamEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "cityId", "", "getCityId", "()Ljava/lang/String;", "setCityId", "(Ljava/lang/String;)V", "clientType", "getClientType", "setClientType", "dataType", "getDataType", "setDataType", "locationType", "getLocationType", "setLocationType", "osType", "getOsType", "setOsType", "osVersion", "getOsVersion", "setOsVersion", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayBizParamEntity.kt */
public final class PayBizParamEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 7801262394709163539L;
    private String cityId;
    private String clientType;
    private String dataType;
    private String locationType;
    private String osType;
    private String osVersion;

    public final String getOsType() {
        return this.osType;
    }

    public final void setOsType(String str) {
        this.osType = str;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final void setOsVersion(String str) {
        this.osVersion = str;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final void setDataType(String str) {
        this.dataType = str;
    }

    public final String getClientType() {
        return this.clientType;
    }

    public final void setClientType(String str) {
        this.clientType = str;
    }

    public final String getLocationType() {
        return this.locationType;
    }

    public final void setLocationType(String str) {
        this.locationType = str;
    }

    public final String getCityId() {
        return this.cityId;
    }

    public final void setCityId(String str) {
        this.cityId = str;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/PayBizParamEntity$Companion;", "", "()V", "serialVersionUID", "", "createEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/PayBizParamEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PayBizParamEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PayBizParamEntity createEntity() {
            PayBizParamEntity payBizParamEntity = new PayBizParamEntity();
            payBizParamEntity.setOsType(String.valueOf(ParamsHelper.getClientType()));
            payBizParamEntity.setOsVersion(Build.VERSION.RELEASE);
            payBizParamEntity.setDataType("16");
            payBizParamEntity.setClientType("9");
            payBizParamEntity.setLocationType(String.valueOf(CustomerSystemUtil.getLocationType()));
            payBizParamEntity.setCityId(String.valueOf(LocationUtil.getCityId()));
            return payBizParamEntity;
        }
    }
}
