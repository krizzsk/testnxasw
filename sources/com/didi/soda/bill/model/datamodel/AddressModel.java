package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerAddressManager;
import com.didi.soda.manager.base.ICustomerBillManager;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148867d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u001a\u0010A\u001a\u00020\u00002\b\u0010B\u001a\u0004\u0018\u00010\r2\b\u0010>\u001a\u0004\u0018\u00010\rJ\u0010\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020CH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR\u001c\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR\u001a\u00100\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000201X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u001c\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011¨\u0006D"}, mo148868d2 = {"Lcom/didi/soda/bill/model/datamodel/AddressModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "addressAptBuildingName", "", "getAddressAptBuildingName", "()Ljava/lang/String;", "setAddressAptBuildingName", "(Ljava/lang/String;)V", "addressDisplayName", "getAddressDisplayName", "setAddressDisplayName", "addressEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "getAddressEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "setAddressEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;)V", "addressName", "", "getAddressName", "()Ljava/lang/CharSequence;", "setAddressName", "(Ljava/lang/CharSequence;)V", "aid", "getAid", "setAid", "aidTypeName", "getAidTypeName", "setAidTypeName", "buildingName", "getBuildingName", "setBuildingName", "contactEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "getContactEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;", "setContactEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/ContactEntity;)V", "contactName", "getContactName", "setContactName", "contactPhone", "getContactPhone", "setContactPhone", "houseNumber", "getHouseNumber", "setHouseNumber", "isAddressClicked", "", "()Z", "setAddressClicked", "(Z)V", "needFocus", "getNeedFocus", "setNeedFocus", "poiEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;", "getPoiEntity", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;", "setPoiEntity", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity$PoiEntity;)V", "recAddressEntity", "getRecAddressEntity", "setRecAddressEntity", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AddressModel.kt */
public final class AddressModel extends ComponentAbsModel {

    /* renamed from: a */
    private String f41785a;

    /* renamed from: b */
    private boolean f41786b;

    /* renamed from: c */
    private String f41787c;

    /* renamed from: d */
    private CharSequence f41788d = "";

    /* renamed from: e */
    private String f41789e;

    /* renamed from: f */
    private AddressEntity f41790f;

    /* renamed from: g */
    private String f41791g = "";

    /* renamed from: h */
    private String f41792h;

    /* renamed from: i */
    private String f41793i;

    /* renamed from: j */
    private ContactEntity f41794j;

    /* renamed from: k */
    private String f41795k;

    /* renamed from: l */
    private String f41796l;

    /* renamed from: m */
    private AddressEntity f41797m;

    /* renamed from: n */
    private AddressEntity.PoiEntity f41798n;

    /* renamed from: o */
    private boolean f41799o;

    public final String getAid() {
        return this.f41785a;
    }

    public final void setAid(String str) {
        this.f41785a = str;
    }

    public final boolean getNeedFocus() {
        return this.f41786b;
    }

    public final void setNeedFocus(boolean z) {
        this.f41786b = z;
    }

    public final String getAidTypeName() {
        return this.f41787c;
    }

    public final void setAidTypeName(String str) {
        this.f41787c = str;
    }

    public final CharSequence getAddressName() {
        return this.f41788d;
    }

    public final void setAddressName(CharSequence charSequence) {
        this.f41788d = charSequence;
    }

    public final String getAddressDisplayName() {
        return this.f41789e;
    }

    public final void setAddressDisplayName(String str) {
        this.f41789e = str;
    }

    public final AddressEntity getAddressEntity() {
        return this.f41790f;
    }

    public final void setAddressEntity(AddressEntity addressEntity) {
        this.f41790f = addressEntity;
    }

    public final String getAddressAptBuildingName() {
        return this.f41791g;
    }

    public final void setAddressAptBuildingName(String str) {
        this.f41791g = str;
    }

    public final String getContactPhone() {
        return this.f41792h;
    }

    public final void setContactPhone(String str) {
        this.f41792h = str;
    }

    public final String getContactName() {
        return this.f41793i;
    }

    public final void setContactName(String str) {
        this.f41793i = str;
    }

    public final ContactEntity getContactEntity() {
        return this.f41794j;
    }

    public final void setContactEntity(ContactEntity contactEntity) {
        this.f41794j = contactEntity;
    }

    public final String getHouseNumber() {
        return this.f41795k;
    }

    public final void setHouseNumber(String str) {
        this.f41795k = str;
    }

    public final String getBuildingName() {
        return this.f41796l;
    }

    public final void setBuildingName(String str) {
        this.f41796l = str;
    }

    public final AddressEntity getRecAddressEntity() {
        return this.f41797m;
    }

    public final void setRecAddressEntity(AddressEntity addressEntity) {
        this.f41797m = addressEntity;
    }

    public final AddressEntity.PoiEntity getPoiEntity() {
        return this.f41798n;
    }

    public final void setPoiEntity(AddressEntity.PoiEntity poiEntity) {
        this.f41798n = poiEntity;
    }

    public final boolean isAddressClicked() {
        return this.f41799o;
    }

    public final void setAddressClicked(boolean z) {
        this.f41799o = z;
    }

    public AddressModel() {
        String str;
        ContactEntity currentContact = ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).getCurrentContact();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z = false;
        String format = String.format("%1$s %2$s", Arrays.copyOf(new Object[]{currentContact.callingCode, currentContact.phone}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        this.f41792h = format;
        CharSequence firstName = currentContact.getFirstName();
        if (!(firstName == null || firstName.length() == 0)) {
            CharSequence lastName = currentContact.getLastName();
            if (!(lastName == null || lastName.length() == 0)) {
                str = currentContact.getFirstName() + ' ' + currentContact.getLastName();
                this.f41793i = str;
                this.f41794j = currentContact;
                this.f41790f = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
            }
        }
        CharSequence firstName2 = currentContact.getFirstName();
        if ((firstName2 == null || firstName2.length() == 0) ? true : z) {
            str = currentContact.getLastName();
        } else {
            str = currentContact.getFirstName();
        }
        this.f41793i = str;
        this.f41794j = currentContact;
        this.f41790f = ((ICustomerAddressManager) CustomerManagerLoader.loadManager(ICustomerAddressManager.class)).getDelieveryAddress();
    }

    public AddressModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        return convertModel(billComponentDataEntity.getAddress(), billComponentDataEntity.getRecAddress());
    }

    public final AddressModel convertModel(AddressEntity addressEntity, AddressEntity addressEntity2) {
        if (addressEntity != null) {
            setAddressDisplayName(addressEntity.getHouseDepartPoi());
            setAddressAptBuildingName(addressEntity.getAptAndBuildingName());
            AddressEntity.PoiEntity poiEntity = addressEntity.poi;
            setAddressName(poiEntity == null ? null : poiEntity.displayName);
            setAidTypeName(addressEntity.getAidTypeName());
            setAddressEntity(addressEntity);
            setNeedFocus(false);
            setHouseNumber(addressEntity.houseNumber);
            setBuildingName(addressEntity.buildingName);
            setAid(addressEntity.getAid());
            setPoiEntity(addressEntity.poi);
        }
        this.f41797m = addressEntity2;
        return this;
    }
}
