package com.didi.globalsafetoolkit.business.contacts.store;

import android.text.TextUtils;
import com.didi.globalsafetoolkit.GlobalSfBusinessInterface;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.store.SfContactsRequestBiz;
import java.util.List;

public class SfContactsManageStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<SfContactsModel> f24992a;

    public interface Callback {
        void onError(SfContactsManageModel sfContactsManageModel);

        void onSuccess(SfContactsManageModel sfContactsManageModel);
    }

    public int getDataSize() {
        List<SfContactsModel> list = this.f24992a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<SfContactsModel> getData() {
        return this.f24992a;
    }

    public void getTrustedContacts(final Callback callback) {
        SfContactsRequestBiz.getTrustedContacts(new SfResponseListener<SfContactsManageModel>() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (sfContactsManageModel.datas != null) {
                    List unused = SfContactsManageStore.this.f24992a = sfContactsManageModel.datas.contacts;
                }
                SfContactsManageStore.this.m20033a(sfContactsManageModel);
                callback.onSuccess(sfContactsManageModel);
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                callback.onError(sfContactsManageModel);
            }

            public void onFail(int i, String str) {
                callback.onError((SfContactsManageModel) null);
            }
        });
    }

    public void addContact(boolean z, String str, final Callback callback) {
        if (!TextUtils.isEmpty(str)) {
            C94992 r0 = new SfResponseListener<SfContactsManageModel>() {
                public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                    if (sfContactsManageModel.datas != null) {
                        List unused = SfContactsManageStore.this.f24992a = sfContactsManageModel.datas.contacts;
                    }
                    SfContactsManageStore.this.m20033a(sfContactsManageModel);
                    callback.onSuccess(sfContactsManageModel);
                }

                public void onError(SfContactsManageModel sfContactsManageModel) {
                    callback.onError(sfContactsManageModel);
                }

                public void onFail(int i, String str) {
                    callback.onError((SfContactsManageModel) null);
                }
            };
            if (z) {
                SfContactsRequestBiz.updateContact(str, r0);
            } else {
                SfContactsRequestBiz.addContact(str, r0);
            }
        }
    }

    public void deleteContact(String str, final Callback callback) {
        SfContactsRequestBiz.deleteContact(str, new SfResponseListener<SfContactsManageModel>() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (sfContactsManageModel.datas != null) {
                    List unused = SfContactsManageStore.this.f24992a = sfContactsManageModel.datas.contacts;
                }
                SfContactsManageStore.this.m20033a(sfContactsManageModel);
                callback.onSuccess(sfContactsManageModel);
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                callback.onError(sfContactsManageModel);
            }

            public void onFail(int i, String str) {
                callback.onError((SfContactsManageModel) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20033a(SfContactsManageModel sfContactsManageModel) {
        GlobalSfBusinessInterface.onTrustedContactChanged(sfContactsManageModel);
    }
}
