package com.didi.soda.address.edit.binder;

import com.didi.soda.address.util.AddressUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\f\b\b\u0018\u0000 <2\u00020\u0001:\u0001<B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00108\u001a\u00020\u00182\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u000201HÖ\u0001J\t\u0010;\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\nR\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\b\"\u0004\b,\u0010\nR\u001a\u0010-\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001bR\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006="}, mo148868d2 = {"Lcom/didi/soda/address/edit/binder/EditAddressModel;", "", "originAddressEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;)V", "addressAll", "", "getAddressAll", "()Ljava/lang/String;", "setAddressAll", "(Ljava/lang/String;)V", "addressDisplayName", "getAddressDisplayName", "setAddressDisplayName", "aid", "getAid", "setAid", "buildingName", "getBuildingName", "setBuildingName", "houseNumber", "getHouseNumber", "setHouseNumber", "isExpendMap", "", "()Z", "setExpendMap", "(Z)V", "isValid", "setValid", "lat", "", "getLat", "()D", "setLat", "(D)V", "lng", "getLng", "setLng", "getOriginAddressEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "setOriginAddressEntity", "poiId", "getPoiId", "setPoiId", "showImeActionNext", "getShowImeActionNext", "setShowImeActionNext", "type", "", "getType", "()I", "setType", "(I)V", "component1", "copy", "equals", "other", "hashCode", "toString", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: EditAddressModel.kt */
public final class EditAddressModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private AddressEntity f41424a;

    /* renamed from: b */
    private String f41425b;

    /* renamed from: c */
    private String f41426c;

    /* renamed from: d */
    private String f41427d;

    /* renamed from: e */
    private String f41428e;

    /* renamed from: f */
    private String f41429f;

    /* renamed from: g */
    private String f41430g;

    /* renamed from: h */
    private double f41431h;

    /* renamed from: i */
    private double f41432i;

    /* renamed from: j */
    private int f41433j;

    /* renamed from: k */
    private boolean f41434k;

    /* renamed from: l */
    private boolean f41435l;

    /* renamed from: m */
    private boolean f41436m;

    public static /* synthetic */ EditAddressModel copy$default(EditAddressModel editAddressModel, AddressEntity addressEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            addressEntity = editAddressModel.f41424a;
        }
        return editAddressModel.copy(addressEntity);
    }

    public final AddressEntity component1() {
        return this.f41424a;
    }

    public final EditAddressModel copy(AddressEntity addressEntity) {
        return new EditAddressModel(addressEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EditAddressModel) && Intrinsics.areEqual((Object) this.f41424a, (Object) ((EditAddressModel) obj).f41424a);
    }

    public int hashCode() {
        AddressEntity addressEntity = this.f41424a;
        if (addressEntity == null) {
            return 0;
        }
        return addressEntity.hashCode();
    }

    public String toString() {
        return "EditAddressModel(originAddressEntity=" + this.f41424a + VersionRange.RIGHT_OPEN;
    }

    public EditAddressModel(AddressEntity addressEntity) {
        this.f41424a = addressEntity;
    }

    public final AddressEntity getOriginAddressEntity() {
        return this.f41424a;
    }

    public final void setOriginAddressEntity(AddressEntity addressEntity) {
        this.f41424a = addressEntity;
    }

    public final String getAddressDisplayName() {
        return this.f41425b;
    }

    public final void setAddressDisplayName(String str) {
        this.f41425b = str;
    }

    public final String getAddressAll() {
        return this.f41426c;
    }

    public final void setAddressAll(String str) {
        this.f41426c = str;
    }

    public final String getBuildingName() {
        return this.f41427d;
    }

    public final void setBuildingName(String str) {
        this.f41427d = str;
    }

    public final String getHouseNumber() {
        return this.f41428e;
    }

    public final void setHouseNumber(String str) {
        this.f41428e = str;
    }

    public final String getPoiId() {
        return this.f41429f;
    }

    public final void setPoiId(String str) {
        this.f41429f = str;
    }

    public final String getAid() {
        return this.f41430g;
    }

    public final void setAid(String str) {
        this.f41430g = str;
    }

    public final double getLat() {
        return this.f41431h;
    }

    public final void setLat(double d) {
        this.f41431h = d;
    }

    public final double getLng() {
        return this.f41432i;
    }

    public final void setLng(double d) {
        this.f41432i = d;
    }

    public final int getType() {
        return this.f41433j;
    }

    public final void setType(int i) {
        this.f41433j = i;
    }

    public final boolean isValid() {
        return this.f41434k;
    }

    public final void setValid(boolean z) {
        this.f41434k = z;
    }

    public final boolean isExpendMap() {
        return this.f41435l;
    }

    public final void setExpendMap(boolean z) {
        this.f41435l = z;
    }

    public final boolean getShowImeActionNext() {
        return this.f41436m;
    }

    public final void setShowImeActionNext(boolean z) {
        this.f41436m = z;
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/soda/address/edit/binder/EditAddressModel$Companion;", "", "()V", "from", "Lcom/didi/soda/address/edit/binder/EditAddressModel;", "addressEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: EditAddressModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EditAddressModel from(AddressEntity addressEntity) {
            EditAddressModel editAddressModel = new EditAddressModel(addressEntity);
            if (addressEntity != null) {
                if (AddressUtil.checkAddressValid(addressEntity)) {
                    editAddressModel.setOriginAddressEntity(addressEntity);
                    editAddressModel.setValid(true);
                    editAddressModel.setAddressDisplayName(addressEntity.poi.displayName);
                    editAddressModel.setAddressAll(addressEntity.poi.addressAllDisplay);
                    editAddressModel.setBuildingName(addressEntity.buildingName);
                    editAddressModel.setHouseNumber(addressEntity.houseNumber);
                    editAddressModel.setAid(addressEntity.aid);
                    editAddressModel.setPoiId(addressEntity.poi.poiId);
                    editAddressModel.setLat(addressEntity.poi.lat);
                    editAddressModel.setLng(addressEntity.poi.lng);
                    editAddressModel.setType(addressEntity.type);
                } else {
                    editAddressModel.setValid(false);
                }
            }
            return editAddressModel;
        }
    }
}
