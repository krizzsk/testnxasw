package com.didi.globalsafetoolkit.business.areaCode;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.safetoolkit.presenter.AbsPresenter;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.SafeBusinessData;
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
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class MandatoryGuidePresenter extends AbsPresenter<SfGuideIView> {
    /* access modifiers changed from: private */
    public String code;
    private List<SfContactsModel> contactsList;
    /* access modifiers changed from: private */
    public Context context;

    public interface Callback {
        void onAddAreaSuccess();
    }

    public MandatoryGuidePresenter(SfGuideIView sfGuideIView) {
        super(sfGuideIView);
    }

    public void onCreate() {
        super.onCreate();
        this.context = ((SfGuideIView) this.mView).getContext();
    }

    public void setContactsList(List<SfContactsModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.contactsList = list;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void addAllOfThemAndShare(int i, Callback callback) {
        addContactAndShare(i, callback);
    }

    private void addContactAndShare(int i, Callback callback) {
        showPDialog();
        boolean z = false;
        final boolean z2 = i == 1;
        if (i != 0) {
            z = true;
        }
        final ArrayList<SfContactsModel> arrayList = new ArrayList<>(this.contactsList);
        for (SfContactsModel sfContactsModel : arrayList) {
            if (z) {
                sfContactsModel.origin_phone = sfContactsModel.phone;
            }
            sfContactsModel.phone = this.code + sfContactsModel.phone;
        }
        final int i2 = i;
        final Callback callback2 = callback;
        new SfContactsManageStore().addContact(z, new Gson().toJson((Object) arrayList), new SfContactsManageStore.Callback() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (z2) {
                    SafeBusinessData businessInfo = GlobalSfBusinessInterface.getBusinessInfo();
                    if (businessInfo != null) {
                        String oid = businessInfo.getOid();
                        if (!TextUtils.isEmpty(oid)) {
                            SfContactsStore.getInstance().share(arrayList, oid, new SfResponseListener<SfShareResponse>() {
                                public void onSuccess(SfShareResponse sfShareResponse) {
                                    super.onSuccess(sfShareResponse);
                                    MandatoryGuidePresenter.this.closePDialog();
                                    ((SfGuideIView) MandatoryGuidePresenter.this.mView).onAllNumberAdded();
                                    if (sfShareResponse.data != null && sfShareResponse.data.shareSuccessCount > 0) {
                                        if (!TextUtils.isEmpty(sfShareResponse.data.successText)) {
                                            ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfShareResponse.data.successText);
                                        }
                                        GlobalSfBusinessInterface.onContactsShared();
                                    }
                                }

                                public void onFail(int i, String str) {
                                    super.onFail(i, str);
                                    MandatoryGuidePresenter.this.closePDialog();
                                    ((SfGuideIView) MandatoryGuidePresenter.this.mView).onAllNumberAdded();
                                    ToastHelper.showLongCompleted(SfContextHelper.getContext(), str);
                                }
                            });
                        }
                    }
                } else {
                    MandatoryGuidePresenter.this.closePDialog();
                    ((SfGuideIView) MandatoryGuidePresenter.this.mView).onAllNumberAdded();
                    int i = i2;
                    if (i == 0) {
                        ToastHelper.showLongCompleted(MandatoryGuidePresenter.this.context, MandatoryGuidePresenter.this.context.getResources().getString(R.string.sf_add_area_code_success_msg));
                    } else if (i == 2) {
                        ToastHelper.showLongCompleted(MandatoryGuidePresenter.this.context, MandatoryGuidePresenter.this.context.getResources().getString(R.string.sf_add_area_code_success_msg_by_stock, new Object[]{MandatoryGuidePresenter.this.code}));
                    }
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.onAddAreaSuccess();
                    }
                }
                MandatoryGuidePresenter.this.track4AddAreaCodeSuccess(sfContactsManageModel);
                if (MandatoryGuidePresenter.this.getContext() != null) {
                    BroadcastUtil.sendBroadcast(MandatoryGuidePresenter.this.getContext(), "sf_add_contacts_success");
                }
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                if (MandatoryGuidePresenter.this.getContext() != null) {
                    BroadcastUtil.sendBroadcast(MandatoryGuidePresenter.this.getContext(), "sf_add_contacts_fail");
                    if (sfContactsManageModel != null && !TextUtils.isEmpty(sfContactsManageModel.errmsg)) {
                        ToastHelper.showLongCompleted(MandatoryGuidePresenter.this.getContext(), sfContactsManageModel.errmsg);
                    }
                }
                MandatoryGuidePresenter.this.closePDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    public void track4AddAreaCodeSuccess(SfContactsManageModel sfContactsManageModel) {
        List<SfContactsModel> list;
        if (sfContactsManageModel != null && sfContactsManageModel.datas != null && sfContactsManageModel.datas.contacts != null && !sfContactsManageModel.datas.contacts.isEmpty() && (list = this.contactsList) != null && !list.isEmpty()) {
            for (SfContactsModel next : sfContactsManageModel.datas.contacts) {
                for (SfContactsModel sfContactsModel : this.contactsList) {
                    if (next.phone.equals(sfContactsModel.phone)) {
                        SfOmegaUtil.addEventId("gp_addAreaCode_success_rsp").addKeyValue("phone", next.phone).report();
                    }
                }
            }
        }
    }
}
