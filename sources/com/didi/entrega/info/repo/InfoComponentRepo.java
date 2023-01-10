package com.didi.entrega.info.repo;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.info.model.ContactModel;
import com.didi.entrega.info.model.ContactStufModel;
import com.didi.entrega.info.model.StuffRemarkModel;
import com.didi.entrega.info.model.StuffRuleModel;
import com.didi.entrega.info.model.StuffTypeModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u00101\u001a\u000202J\u0012\u00103\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u00105\u001a\u0004\u0018\u00010\u00112\b\u00106\u001a\u0004\u0018\u00010\u00112\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0010\u00109\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108J\u0010\u00109\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010\u0011J\u0010\u0010:\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108J\u0010\u0010:\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010\u0011J\u0010\u0010;\u001a\u0002022\b\u0010<\u001a\u0004\u0018\u00010\u0017J\u0010\u0010=\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010>J\u0010\u0010=\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010,J\u0010\u0010?\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010>J\u0010\u0010?\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010 J\u0010\u0010@\u001a\u0002022\b\u00104\u001a\u0004\u0018\u00010&R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006A"}, mo148868d2 = {"Lcom/didi/entrega/info/repo/InfoComponentRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "", "()V", "cateInfo", "Lcom/didi/entrega/info/model/ContactStufModel;", "getCateInfo", "()Lcom/didi/entrega/info/model/ContactStufModel;", "setCateInfo", "(Lcom/didi/entrega/info/model/ContactStufModel;)V", "commonInfoEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "getCommonInfoEntity", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;", "setCommonInfoEntity", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity;)V", "receiver", "Lcom/didi/entrega/info/model/ContactModel;", "getReceiver", "()Lcom/didi/entrega/info/model/ContactModel;", "setReceiver", "(Lcom/didi/entrega/info/model/ContactModel;)V", "selectedItem", "Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfosItem;", "getSelectedItem", "()Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfosItem;", "setSelectedItem", "(Lcom/didi/entrega/customer/foundation/rpc/entity/CommonInfoEntity$CateInfosItem;)V", "sender", "getSender", "setSender", "stuffRemarkModel", "Lcom/didi/entrega/info/model/StuffRemarkModel;", "getStuffRemarkModel", "()Lcom/didi/entrega/info/model/StuffRemarkModel;", "setStuffRemarkModel", "(Lcom/didi/entrega/info/model/StuffRemarkModel;)V", "stuffRuleModel", "Lcom/didi/entrega/info/model/StuffRuleModel;", "getStuffRuleModel", "()Lcom/didi/entrega/info/model/StuffRuleModel;", "setStuffRuleModel", "(Lcom/didi/entrega/info/model/StuffRuleModel;)V", "stuffTypeModel", "Lcom/didi/entrega/info/model/StuffTypeModel;", "getStuffTypeModel", "()Lcom/didi/entrega/info/model/StuffTypeModel;", "setStuffTypeModel", "(Lcom/didi/entrega/info/model/StuffTypeModel;)V", "clear", "", "setDefaultCallingCode", "value", "setModelValue", "model", "addr", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "setReceiverValue", "setSenderValue", "setStuffTypeItemValue", "item", "setStuffTypeModelValue", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "setstuffRemarkModelValue", "setstuffRuleModelValue", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: InfoComponentRepo.kt */
public final class InfoComponentRepo extends Repo<String> {

    /* renamed from: a */
    private CommonInfoEntity f22660a;

    /* renamed from: b */
    private ContactModel f22661b = new ContactModel();

    /* renamed from: c */
    private ContactModel f22662c = new ContactModel();

    /* renamed from: d */
    private ContactStufModel f22663d = new ContactStufModel();

    /* renamed from: e */
    private StuffTypeModel f22664e;

    /* renamed from: f */
    private StuffRemarkModel f22665f;

    /* renamed from: g */
    private StuffRuleModel f22666g;

    /* renamed from: h */
    private CommonInfoEntity.CateInfosItem f22667h;

    public final CommonInfoEntity getCommonInfoEntity() {
        return this.f22660a;
    }

    public final void setCommonInfoEntity(CommonInfoEntity commonInfoEntity) {
        this.f22660a = commonInfoEntity;
    }

    public final ContactModel getSender() {
        return this.f22661b;
    }

    public final void setSender(ContactModel contactModel) {
        this.f22661b = contactModel;
    }

    public final ContactModel getReceiver() {
        return this.f22662c;
    }

    public final void setReceiver(ContactModel contactModel) {
        this.f22662c = contactModel;
    }

    public final ContactStufModel getCateInfo() {
        return this.f22663d;
    }

    public final void setCateInfo(ContactStufModel contactStufModel) {
        this.f22663d = contactStufModel;
    }

    public final StuffTypeModel getStuffTypeModel() {
        return this.f22664e;
    }

    public final void setStuffTypeModel(StuffTypeModel stuffTypeModel) {
        this.f22664e = stuffTypeModel;
    }

    public final StuffRemarkModel getStuffRemarkModel() {
        return this.f22665f;
    }

    public final void setStuffRemarkModel(StuffRemarkModel stuffRemarkModel) {
        this.f22665f = stuffRemarkModel;
    }

    public final StuffRuleModel getStuffRuleModel() {
        return this.f22666g;
    }

    public final void setStuffRuleModel(StuffRuleModel stuffRuleModel) {
        this.f22666g = stuffRuleModel;
    }

    public final CommonInfoEntity.CateInfosItem getSelectedItem() {
        return this.f22667h;
    }

    public final void setSelectedItem(CommonInfoEntity.CateInfosItem cateInfosItem) {
        this.f22667h = cateInfosItem;
    }

    public final void setSenderValue(ContactModel contactModel) {
        ContactModel contactModel2;
        m18637a(contactModel);
        if (contactModel == null) {
            contactModel2 = null;
        } else {
            contactModel2 = contactModel.clone();
        }
        this.f22661b = contactModel2;
        super.setValue("*");
    }

    public final void setSenderValue(AddressEntity addressEntity) {
        ContactModel contactModel = this.f22661b;
        ContactModel clone = contactModel == null ? null : contactModel.clone();
        m18637a(clone);
        this.f22661b = m18636a(clone, addressEntity);
        super.setValue("*");
    }

    public final void setReceiverValue(ContactModel contactModel) {
        ContactModel contactModel2;
        m18637a(contactModel);
        if (contactModel == null) {
            contactModel2 = null;
        } else {
            contactModel2 = contactModel.clone();
        }
        this.f22662c = contactModel2;
        super.setValue("*");
    }

    public final void setReceiverValue(AddressEntity addressEntity) {
        ContactModel contactModel = this.f22662c;
        ContactModel clone = contactModel == null ? null : contactModel.clone();
        m18637a(clone);
        this.f22662c = m18636a(clone, addressEntity);
        super.setValue("*");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r1 = (r1 = r3.getContact()).getPhoneNumber();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m18637a(com.didi.entrega.info.model.ContactModel r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0017
        L_0x0005:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r1 = r3.getContact()
            if (r1 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r1 = r1.getPhoneNumber()
            if (r1 != 0) goto L_0x0013
            goto L_0x0003
        L_0x0013:
            java.lang.String r1 = r1.getCallingCode()
        L_0x0017:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0037
            if (r3 != 0) goto L_0x0022
            goto L_0x002d
        L_0x0022:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r3 = r3.getContact()
            if (r3 != 0) goto L_0x0029
            goto L_0x002d
        L_0x0029:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r0 = r3.getPhoneNumber()
        L_0x002d:
            if (r0 != 0) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            java.lang.String r3 = com.didi.entrega.customer.foundation.util.LoginUtil.getCallingCode()
            r0.setCallingCode(r3)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.repo.InfoComponentRepo.m18637a(com.didi.entrega.info.model.ContactModel):void");
    }

    public final void setStuffTypeModelValue(StuffTypeModel stuffTypeModel) {
        this.f22664e = stuffTypeModel;
        super.setValue("*");
    }

    public final void setStuffTypeModelValue(ContactStufEntity contactStufEntity) {
        List<CommonInfoEntity.CateInfosItem> list;
        String str;
        CommonInfoEntity.CateInfoTag stuffEntityData;
        StuffTypeModel stuffTypeModel = this.f22664e;
        if (stuffTypeModel == null || (stuffEntityData = stuffTypeModel.getStuffEntityData()) == null) {
            list = null;
        } else {
            list = stuffEntityData.getCateInfoItems();
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        boolean z = false;
        for (CommonInfoEntity.CateInfosItem next : list) {
            if (next == null) {
                str = null;
            } else {
                str = next.getCateID();
            }
            if (TextUtils.equals(str, contactStufEntity == null ? null : contactStufEntity.cateId)) {
                this.f22667h = next;
                next.setSelected(true);
                z = true;
            } else {
                next.setSelected(false);
            }
        }
        if (!z) {
            this.f22667h = null;
        }
        this.f22664e = stuffTypeModel;
        super.setValue("*");
    }

    public final void setStuffTypeItemValue(CommonInfoEntity.CateInfosItem cateInfosItem) {
        List<CommonInfoEntity.CateInfosItem> list;
        String str;
        CommonInfoEntity.CateInfoTag stuffEntityData;
        StuffTypeModel stuffTypeModel = this.f22664e;
        this.f22667h = cateInfosItem;
        if (stuffTypeModel == null || (stuffEntityData = stuffTypeModel.getStuffEntityData()) == null) {
            list = null;
        } else {
            list = stuffEntityData.getCateInfoItems();
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        for (CommonInfoEntity.CateInfosItem next : list) {
            if (next == null) {
                str = null;
            } else {
                str = next.getCateID();
            }
            next.setSelected(Boolean.valueOf(Intrinsics.areEqual((Object) str, (Object) cateInfosItem == null ? null : cateInfosItem.getCateID())));
        }
        this.f22664e = stuffTypeModel;
        super.setValue("*");
    }

    public final void setstuffRemarkModelValue(StuffRemarkModel stuffRemarkModel) {
        this.f22665f = stuffRemarkModel;
        super.setValue("*");
    }

    public final void setstuffRemarkModelValue(ContactStufEntity contactStufEntity) {
        CommonInfoEntity.Remark remark;
        StuffRemarkModel stuffRemarkModel = this.f22665f;
        String str = null;
        if (stuffRemarkModel == null) {
            remark = null;
        } else {
            remark = stuffRemarkModel.getStuffEntityData();
        }
        if (remark != null) {
            if (contactStufEntity != null) {
                str = contactStufEntity.remark;
            }
            remark.setContent(str);
        }
        this.f22665f = stuffRemarkModel;
        super.setValue("*");
    }

    public final void setstuffRuleModelValue(StuffRuleModel stuffRuleModel) {
        this.f22666g = stuffRuleModel;
        super.setValue("*");
    }

    /* renamed from: a */
    private final ContactModel m18636a(ContactModel contactModel, AddressEntity addressEntity) {
        AddressEntity addressEntity2;
        CommonInfoEntity.BuildingAddress buildingAddress;
        CommonInfoEntity.PhoneNumber phoneNumber;
        CommonInfoEntity.PhoneNumber phoneNumber2;
        CommonInfoEntity.FirstName firstName;
        CommonInfoEntity.LastName lastName;
        CommonInfoEntity.Contact contact;
        CommonInfoEntity.Contact contact2;
        CommonInfoEntity.Contact contact3;
        CommonInfoEntity.Contact contact4;
        CommonInfoEntity.Contact contact5;
        AddressEntity.PoiEntity poiEntity;
        CommonInfoEntity.Contact contact6;
        String str = null;
        AddressEntity clone = addressEntity == null ? null : addressEntity.clone();
        if (contactModel == null || (contact6 = contactModel.getContact()) == null) {
            addressEntity2 = null;
        } else {
            addressEntity2 = contact6.getAddress();
        }
        if (addressEntity2 != null) {
            addressEntity2.poi = (clone == null || (poiEntity = clone.poi) == null) ? null : poiEntity.clone();
        }
        if (contactModel == null || (contact5 = contactModel.getContact()) == null) {
            buildingAddress = null;
        } else {
            buildingAddress = contact5.getBuildingAddress();
        }
        if (buildingAddress != null) {
            buildingAddress.setBuildingAddress(clone == null ? null : clone.houseNumber);
        }
        if (contactModel == null || (contact4 = contactModel.getContact()) == null) {
            phoneNumber = null;
        } else {
            phoneNumber = contact4.getPhoneNumber();
        }
        if (phoneNumber != null) {
            phoneNumber.setPhoneNumber(clone == null ? null : clone.phone);
        }
        if (contactModel == null || (contact3 = contactModel.getContact()) == null) {
            phoneNumber2 = null;
        } else {
            phoneNumber2 = contact3.getPhoneNumber();
        }
        if (phoneNumber2 != null) {
            phoneNumber2.setCallingCode(clone == null ? null : clone.callingCode);
        }
        if (contactModel == null || (contact2 = contactModel.getContact()) == null) {
            firstName = null;
        } else {
            firstName = contact2.getFirstName();
        }
        if (firstName != null) {
            firstName.setFirstName(clone == null ? null : clone.firstName);
        }
        if (contactModel == null || (contact = contactModel.getContact()) == null) {
            lastName = null;
        } else {
            lastName = contact.getLastName();
        }
        if (lastName != null) {
            if (clone != null) {
                str = clone.lastName;
            }
            lastName.setLastName(str);
        }
        return contactModel;
    }

    public final void clear() {
        this.f22661b = null;
        this.f22662c = null;
        this.f22663d = null;
        this.f22660a = null;
        this.f22664e = null;
        this.f22665f = null;
        this.f22666g = null;
        this.f22667h = null;
    }
}
