package com.didi.globalsafetoolkit.business.areaCode;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.android.didi.safetoolkit.presenter.AbsPresenter;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.SafeBusinessData;
import com.didi.globalsafetoolkit.base.BaseSafeToolkitActivity;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.globalsafetoolkit.business.share.model.SfShareResponse;
import com.didi.globalsafetoolkit.business.share.store.SfContactsStore;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.omega.SfOmegaUtil;
import com.didi.globalsafetoolkit.util.BroadcastUtil;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.sdk.util.ToastHelper;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class ManuallyAddCodePresenter extends AbsPresenter<SfManuallyIView> {
    /* access modifiers changed from: private */
    public boolean anyoneAdded = false;
    protected List<SfContactsModel> contactList;
    private int currentAddedPosition = 0;

    public ManuallyAddCodePresenter(SfManuallyIView sfManuallyIView) {
        super(sfManuallyIView);
    }

    public void manuallyAddAreaCode(int i, String str) {
        List<SfContactsModel> list = this.contactList;
        if (list == null || list.size() <= this.currentAddedPosition) {
            ToastHelper.showLongCompleted(((SfManuallyIView) this.mView).getContext(), "Add failed");
            return;
        }
        boolean z = false;
        boolean z2 = i == 1;
        if (i != 0) {
            z = true;
        }
        addContact(z, z2, str, this.contactList.get(this.currentAddedPosition));
    }

    public boolean isAnyoneAdded() {
        return this.anyoneAdded;
    }

    public void onCreate() {
        super.onCreate();
        this.currentAddedPosition = 0;
    }

    public int getCurrentAddedPosition() {
        return this.currentAddedPosition;
    }

    public void setContactList(List<SfContactsModel> list) {
        if (list != null) {
            this.contactList = list;
        }
    }

    public List<SfContactsModel> getContactList() {
        return this.contactList;
    }

    private void addContact(boolean z, final boolean z2, String str, SfContactsModel sfContactsModel) {
        showPDialog();
        final ArrayList arrayList = new ArrayList();
        if (z) {
            sfContactsModel.origin_phone = sfContactsModel.phone;
        }
        sfContactsModel.phone = str + sfContactsModel.phone;
        final String str2 = sfContactsModel.phone;
        arrayList.add(sfContactsModel);
        new SfContactsManageStore().addContact(z, new Gson().toJson((Object) arrayList), new SfContactsManageStore.Callback() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (!(ManuallyAddCodePresenter.this.mView instanceof BaseSafeToolkitActivity) || !((BaseSafeToolkitActivity) ManuallyAddCodePresenter.this.mView).isDestory()) {
                    boolean unused = ManuallyAddCodePresenter.this.anyoneAdded = true;
                    if (z2) {
                        SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
                        if (businessInfo != null) {
                            String oid = businessInfo.getOid();
                            if (!TextUtils.isEmpty(oid)) {
                                SfContactsStore.getInstance().share(arrayList, oid, new SfResponseListener<SfShareResponse>() {
                                    public void onSuccess(SfShareResponse sfShareResponse) {
                                        super.onSuccess(sfShareResponse);
                                        ManuallyAddCodePresenter.this.closePDialog();
                                        ((SfManuallyIView) ManuallyAddCodePresenter.this.mView).onAreaCodeAdded();
                                        if (sfShareResponse.data != null && sfShareResponse.data.shareSuccessCount > 0) {
                                            if (!TextUtils.isEmpty(sfShareResponse.data.successText)) {
                                                ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfShareResponse.data.successText);
                                            }
                                            GlobalSfBusinessInterface.onContactsShared();
                                        }
                                    }

                                    public void onFail(int i, String str) {
                                        super.onFail(i, str);
                                        ((SfManuallyIView) ManuallyAddCodePresenter.this.mView).onAreaCodeAdded();
                                        ManuallyAddCodePresenter.this.closePDialog();
                                        ToastHelper.showLongCompleted(SfContextHelper.getContext(), str);
                                    }
                                });
                            }
                        }
                    } else {
                        ((SfManuallyIView) ManuallyAddCodePresenter.this.mView).onAreaCodeAdded();
                        ManuallyAddCodePresenter.this.closePDialog();
                        if (ManuallyAddCodePresenter.this.getContext() != null) {
                            BroadcastUtil.sendBroadcast(ManuallyAddCodePresenter.this.getContext(), "sf_add_contacts_success");
                        }
                    }
                    ManuallyAddCodePresenter.this.track4AddAreaCodeSuccess(sfContactsManageModel, str2);
                }
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                if (ManuallyAddCodePresenter.this.getContext() != null) {
                    BroadcastUtil.sendBroadcast(ManuallyAddCodePresenter.this.getContext(), "sf_add_contacts_fail");
                    if (sfContactsManageModel != null && !TextUtils.isEmpty(sfContactsManageModel.errmsg)) {
                        ToastHelper.showLongCompleted(ManuallyAddCodePresenter.this.getContext(), sfContactsManageModel.errmsg);
                    }
                }
                ManuallyAddCodePresenter.this.closePDialog();
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        this.currentAddedPosition = 0;
        this.anyoneAdded = false;
    }

    /* access modifiers changed from: private */
    public void track4AddAreaCodeSuccess(SfContactsManageModel sfContactsManageModel, String str) {
        if (sfContactsManageModel != null && sfContactsManageModel.datas != null && sfContactsManageModel.datas.contacts != null && !sfContactsManageModel.datas.contacts.isEmpty() && !TextUtils.isEmpty(str)) {
            for (SfContactsModel sfContactsModel : sfContactsManageModel.datas.contacts) {
                if (sfContactsModel.phone.equals(str)) {
                    SfOmegaUtil.addEventId("gp_addAreaCode_success_rsp").addKeyValue("phone", str).report();
                }
            }
        }
    }

    public void skip2Next() {
        if (getContactList() != null && !getContactList().isEmpty()) {
            int i = this.currentAddedPosition;
            this.currentAddedPosition = i + 1;
            if (i >= getContactList().size() - 1) {
                this.currentAddedPosition = 0;
                ((SfManuallyIView) this.mView).skipOut();
                return;
            }
            ((SfManuallyIView) this.mView).resetView();
            if (!TextUtils.isEmpty(this.contactList.get(this.currentAddedPosition).phone_mask)) {
                ((SfManuallyIView) this.mView).setPhoneNumber(this.contactList.get(this.currentAddedPosition).phone_mask);
            } else {
                ((SfManuallyIView) this.mView).setPhoneNumber(this.contactList.get(this.currentAddedPosition).phone);
            }
            setSpannableString();
        }
    }

    public void setSpannableString() {
        List<SfContactsModel> list = this.contactList;
        if (list != null) {
            String str = list.get(this.currentAddedPosition).name;
            SpannableString spannableString = new SpannableString("(" + (this.currentAddedPosition + 1) + "/" + this.contactList.size() + ")");
            try {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F5782D")), 1, String.valueOf(this.currentAddedPosition + 1).length() + 1, 34);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((SfManuallyIView) this.mView).setNumberAddNameText(str, spannableString);
        }
    }
}
