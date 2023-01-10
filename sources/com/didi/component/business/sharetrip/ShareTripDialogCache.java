package com.didi.component.business.sharetrip;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.unifylogin.listener.LoginListeners;
import java.util.List;

public class ShareTripDialogCache implements LoginListeners.LoginOutListener {

    /* renamed from: a */
    private static volatile ShareTripDialogCache f13197a;

    /* renamed from: b */
    private CommonTripShareInfo f13198b;

    /* renamed from: c */
    private List<SfContactsModel> f13199c;

    /* renamed from: d */
    private SfContactsManageStore f13200d = new SfContactsManageStore();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f13201e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f13202f = "";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f13203g = false;

    public interface RequestCallback<T> {
        void onFail(T t);

        void onSuccess(T t);
    }

    public static ShareTripDialogCache getInstance() {
        if (f13197a == null) {
            synchronized (ShareTripDialogCache.class) {
                if (f13197a == null) {
                    f13197a = new ShareTripDialogCache();
                }
            }
        }
        return f13197a;
    }

    private ShareTripDialogCache() {
        NationComponentDataUtil.addLoginOutlistener(this);
    }

    public void setShareInfo(CommonTripShareInfo commonTripShareInfo) {
        this.f13198b = commonTripShareInfo;
    }

    public CommonTripShareInfo getShareInfo() {
        return this.f13198b;
    }

    public List<SfContactsModel> getContacts() {
        return this.f13199c;
    }

    public void setContacts(List<SfContactsModel> list) {
        this.f13199c = list;
    }

    /* renamed from: a */
    private void m11079a(Context context, final String str, int i, final RequestCallback<CommonTripShareInfo> requestCallback, boolean z) {
        final String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        if (str != null) {
            if ((z || !TextUtils.equals(this.f13201e, str) || !TextUtils.equals(this.f13202f, localeCode)) && context != null) {
                CommonTripShareRequest.getInstance(context).getTripShareInfo(str, i, new ResponseListener<CommonTripShareInfo>() {
                    public void onSuccess(CommonTripShareInfo commonTripShareInfo) {
                        super.onSuccess(commonTripShareInfo);
                        ShareTripDialogCache.this.setShareInfo(commonTripShareInfo);
                        String unused = ShareTripDialogCache.this.f13201e = str;
                        String unused2 = ShareTripDialogCache.this.f13202f = localeCode;
                        RequestCallback requestCallback = requestCallback;
                        if (requestCallback != null) {
                            requestCallback.onSuccess(commonTripShareInfo);
                        }
                    }

                    public void onError(CommonTripShareInfo commonTripShareInfo) {
                        super.onError(commonTripShareInfo);
                        RequestCallback requestCallback = requestCallback;
                        if (requestCallback != null) {
                            requestCallback.onFail(commonTripShareInfo);
                        }
                    }

                    public void onFail(CommonTripShareInfo commonTripShareInfo) {
                        super.onFail(commonTripShareInfo);
                        RequestCallback requestCallback = requestCallback;
                        if (requestCallback != null) {
                            requestCallback.onFail(commonTripShareInfo);
                        }
                    }
                });
            }
        }
    }

    public void getTripShareInfo(Context context, String str, int i) {
        m11079a(context, str, i, (RequestCallback<CommonTripShareInfo>) null, false);
    }

    public void getTripShareInfoWithNoCache(Context context, String str, int i, RequestCallback<CommonTripShareInfo> requestCallback) {
        m11079a(context, str, i, requestCallback, true);
    }

    /* renamed from: a */
    private void m11080a(final RequestCallback<SfContactsManageModel> requestCallback, boolean z) {
        if (z || !this.f13203g) {
            this.f13200d.getTrustedContacts(new SfContactsManageStore.Callback() {
                public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                    if (!(sfContactsManageModel == null || !sfContactsManageModel.isAvailable() || sfContactsManageModel.datas == null || sfContactsManageModel.datas.contacts == null)) {
                        ShareTripDialogCache.this.setContacts(sfContactsManageModel.datas.contacts);
                        boolean unused = ShareTripDialogCache.this.f13203g = true;
                    }
                    RequestCallback requestCallback = requestCallback;
                    if (requestCallback != null) {
                        requestCallback.onSuccess(sfContactsManageModel);
                    }
                }

                public void onError(SfContactsManageModel sfContactsManageModel) {
                    RequestCallback requestCallback = requestCallback;
                    if (requestCallback != null) {
                        requestCallback.onFail(sfContactsManageModel);
                    }
                }
            });
        }
    }

    public void loadingTrustedContacts(RequestCallback<SfContactsManageModel> requestCallback) {
        m11080a(requestCallback, true);
    }

    public void loadingTrustedContactsWithNoCache() {
        m11080a((RequestCallback<SfContactsManageModel>) null, false);
    }

    public void onSuccess() {
        NationComponentDataUtil.removeLoginOutlistener(this);
        f13197a = null;
    }
}
