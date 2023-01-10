package com.didi.globalsafetoolkit.business.share.store;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.globalsafetoolkit.apollo.SfApolloUtil;
import com.didi.globalsafetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.globalsafetoolkit.business.sdk.GlobalSafeToolKit;
import com.didi.globalsafetoolkit.business.share.model.NewContactsModelForShare;
import com.didi.globalsafetoolkit.business.share.model.SfContactsDataBaseModel;
import com.didi.globalsafetoolkit.business.share.model.SfShareResponse;
import com.didi.globalsafetoolkit.business.share.model.SfSortKey;
import com.didi.globalsafetoolkit.business.share.request.SfShareSMSRequest;
import com.didi.globalsafetoolkit.business.share.util.SfCharMapUtil;
import com.didi.globalsafetoolkit.model.SfContactsModel;
import com.didi.globalsafetoolkit.net.SfHttpManager;
import com.didi.globalsafetoolkit.net.SfResponseListener;
import com.didi.globalsafetoolkit.net.SfRpcCallback;
import com.didi.globalsafetoolkit.store.SfContactsRequestBiz;
import com.didi.globalsafetoolkit.util.SfCollectionUtil;
import com.didi.globalsafetoolkit.util.SfContextHelper;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.globalsafetoolkit.util.SfUIThreadHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.security.uuid.share.ShareDBHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class SfContactsStore implements ISfContactsStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f25106a = SfContactsStore.class.getSimpleName();

    /* renamed from: b */
    private static volatile SoftReference<List<SfContactsModel>> f25107b;

    /* renamed from: g */
    private static ISfContactsStore f25108g;

    /* renamed from: c */
    private SfShareSMSRequest f25109c;

    /* renamed from: d */
    private ArrayList<String> f25110d = new ArrayList<>();

    /* renamed from: e */
    private List<SfContactsModel> f25111e;

    /* renamed from: f */
    private boolean f25112f;

    private SfContactsStore() {
    }

    public static ISfContactsStore getInstance() {
        if (f25108g == null) {
            synchronized (SfContactsStore.class) {
                if (f25108g == null) {
                    f25108g = new SfContactsStore();
                }
            }
        }
        return f25108g;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized List<SfContactsModel> m20102b() {
        if (!m20106c()) {
            return m20105c(f25107b.get());
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<SfContactsDataBaseModel> e = m20108e();
        List<SfContactsDataBaseModel> d = m20107d();
        if (!SfCollectionUtil.isEmpty((Collection) e)) {
            if (!SfCollectionUtil.isEmpty((Collection) d)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < d.size(); i++) {
                    long j = d.get(i).f25102id;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= e.size()) {
                            break;
                        }
                        if (e.get(i2).f25102id == j) {
                            SfContactsModel sfContactsModel = new SfContactsModel();
                            sfContactsModel.phone = e.get(i2).phone;
                            sfContactsModel.name = d.get(i).name;
                            if (TextUtils.isEmpty(sfContactsModel.name)) {
                                break;
                            } else if (TextUtils.isEmpty(sfContactsModel.phone)) {
                                break;
                            } else if (!arrayList.contains(sfContactsModel)) {
                                arrayList.add(sfContactsModel);
                            }
                        }
                        i2++;
                    }
                }
                List<SfContactsModel> b = m20103b((List<SfContactsModel>) arrayList);
                String str = f25106a;
                SfLog.m20145d(str, "getContacts spend time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b;
            }
        }
        return null;
    }

    public void getSystemContacts(final SfCallback sfCallback) {
        this.f25112f = false;
        if (!m20106c()) {
            SfLog.m20152i(f25106a, "getSystemContacts from cache");
            this.f25111e = f25107b.get();
            sfCallback.onSucceed(m20105c(f25107b.get()));
            return;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                SystemUtils.setProcessThreadPriority(10);
                SfLog.m20152i(SfContactsStore.f25106a, "getSystemContacts from database");
                try {
                    List a = SfContactsStore.this.m20102b();
                    SfContactsStore.this.m20099a((List<SfContactsModel>) a);
                    SfContactsStore.this.m20093a(sfCallback, (List<SfContactsModel>) a);
                } catch (Exception e) {
                    SfContactsStore sfContactsStore = SfContactsStore.this;
                    SfCallback sfCallback = sfCallback;
                    sfContactsStore.m20092a(sfCallback, "something wrong! msg = " + e.toString());
                    e.printStackTrace();
                }
            }
        });
        thread.setName("sf_getContacts_thread");
        thread.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20099a(List<SfContactsModel> list) {
        if (m20106c()) {
            f25107b = new SoftReference<>(list);
        }
        if (!this.f25112f) {
            this.f25111e = list;
        }
    }

    /* renamed from: c */
    private boolean m20106c() {
        return f25107b == null || f25107b.get() == null || f25107b.get().size() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20092a(final SfCallback sfCallback, final String str) {
        SfUIThreadHelper.post(new Runnable() {
            public void run() {
                sfCallback.onFailed(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20093a(final SfCallback sfCallback, final List<SfContactsModel> list) {
        SfUIThreadHelper.post(new Runnable() {
            public void run() {
                sfCallback.onSucceed(list);
            }
        });
    }

    /* renamed from: b */
    private List<SfContactsModel> m20103b(List<SfContactsModel> list) {
        TreeMap treeMap = new TreeMap();
        if (list == null || list.size() == 0) {
            return null;
        }
        for (SfContactsModel next : list) {
            if (!TextUtils.isEmpty(next.name)) {
                char groupChar = SfCharMapUtil.getGroupChar(next.name.charAt(0));
                List list2 = (List) treeMap.get(new SfSortKey(groupChar));
                if (list2 == null) {
                    list2 = new ArrayList();
                }
                list2.add(next);
                treeMap.put(new SfSortKey(groupChar), list2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (SfSortKey sfSortKey : treeMap.keySet()) {
            List list3 = (List) treeMap.get(sfSortKey);
            if (list3 != null && !list3.isEmpty()) {
                for (int i = 0; i < list3.size(); i++) {
                    if (i == 0) {
                        SfContactsModel sfContactsModel = new SfContactsModel();
                        sfContactsModel.type = 3;
                        sfContactsModel.name = sfSortKey.key.toString();
                        arrayList.add(sfContactsModel);
                    }
                    arrayList.add(list3.get(i));
                }
            }
        }
        treeMap.clear();
        return arrayList;
    }

    public void getSOSContacts(final SfCallback sfCallback) {
        SfContactsRequestBiz.getTrustedContacts(new SfResponseListener<SfContactsManageModel>() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                SfContactsManageModel.SfContactsDatas sfContactsDatas = sfContactsManageModel.datas;
                if (sfContactsDatas == null || sfContactsDatas.contacts == null) {
                    sfCallback.onSucceed((List<SfContactsModel>) null);
                    return;
                }
                for (SfContactsModel sfContactsModel : sfContactsDatas.contacts) {
                    sfContactsModel.type = 2;
                }
                sfCallback.onSucceed(sfContactsDatas.contacts);
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                sfCallback.onFailed("failed");
            }
        });
    }

    public void getMatchList(String str, SfCallback sfCallback) {
        List<SfContactsModel> list = this.f25111e;
        if (list == null || list.size() == 0) {
            sfCallback.onFailed("origin data is null!");
            SfLog.m20152i(f25106a, "getMatchList failed while cache is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SfContactsModel next : this.f25111e) {
            if (m20100a(next.name, str) || m20100a(next.phone, str)) {
                arrayList.add(next);
            }
        }
        sfCallback.onSucceed(arrayList);
    }

    /* renamed from: a */
    private boolean m20100a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    public void share(List<SfContactsModel> list, String str, SfResponseListener sfResponseListener) {
        SfShareSMSRequest sfShareSMSRequest = new SfShareSMSRequest();
        if (SfApolloUtil.isNewSyncContactInterface()) {
            ArrayList arrayList = new ArrayList();
            for (SfContactsModel next : list) {
                NewContactsModelForShare newContactsModelForShare = new NewContactsModelForShare();
                newContactsModelForShare.name = next.name;
                newContactsModelForShare.need_areacode = next.need_areacode;
                if (TextUtils.isEmpty(next.phone_encode)) {
                    newContactsModelForShare.phone = next.phone;
                } else {
                    newContactsModelForShare.phone = next.phone_encode;
                }
                arrayList.add(newContactsModelForShare);
            }
            try {
                sfShareSMSRequest.contacts = new Gson().toJson((Object) arrayList);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                sfShareSMSRequest.contacts = new Gson().toJson((Object) list);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        sfShareSMSRequest.orderId = str;
        sfShareSMSRequest.productId = GlobalSafeToolKit.getIns().getProductId();
        this.f25110d.clear();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                this.f25110d.add(list.get(i).name);
            }
        }
        m20091a(sfShareSMSRequest, sfResponseListener);
    }

    public void shareRetry() {
        m20091a(this.f25109c, (SfResponseListener) null);
    }

    public void shareToSOSContacts() {
        m20091a(new SfShareSMSRequest(), (SfResponseListener) null);
    }

    public void clearData() {
        this.f25112f = true;
        if (this.f25111e != null) {
            this.f25111e = null;
        }
    }

    /* renamed from: a */
    private void m20091a(SfShareSMSRequest sfShareSMSRequest, SfResponseListener sfResponseListener) {
        if (sfShareSMSRequest != null) {
            this.f25109c = sfShareSMSRequest;
            if (sfResponseListener == null) {
                m20098a("sf_start_share");
                sfResponseListener = new SfResponseListener<SfShareResponse>() {
                    public void onSuccess(SfShareResponse sfShareResponse) {
                        SfContactsStore.this.m20098a("sf_share_success");
                    }

                    public void onFail(int i, String str) {
                        SfContactsStore.this.m20098a("sf_share_failed");
                    }

                    public void onError(SfShareResponse sfShareResponse) {
                        SfContactsStore.this.m20098a("sf_share_failed");
                    }
                };
            }
            SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfShareSMSRequest, new SfRpcCallback<SfShareResponse>(sfResponseListener) {
            });
        }
    }

    /* renamed from: b */
    private void m20104b(SfShareSMSRequest sfShareSMSRequest, final SfResponseListener sfResponseListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("share_third", 0);
        hashMap.put("oid", sfShareSMSRequest.orderId);
        hashMap.put(InvitationPageActivity.CONTACTS, sfShareSMSRequest.contacts);
        hashMap.put("product_id", Integer.valueOf(sfShareSMSRequest.productId));
        Bff.call(new IBffProxy.Ability.Builder(SfContextHelper.getContext(), "heimdallr/oasisDriverStartShare").setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                sfResponseListener.onSuccess((SfShareResponse) new Gson().fromJson(jsonObject.toString(), SfShareResponse.class));
            }

            public void onFailure(IOException iOException) {
                sfResponseListener.onFail(-1, iOException.getMessage());
            }
        }).build());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m20098a(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("sf_name_list", this.f25110d);
        LocalBroadcastManager.getInstance(SfContextHelper.getContext()).sendBroadcast(intent);
    }

    /* renamed from: c */
    private List<SfContactsModel> m20105c(List<SfContactsModel> list) {
        if (!(list == null || list.size() == 0)) {
            for (SfContactsModel sfContactsModel : list) {
                sfContactsModel.checked = false;
            }
        }
        return list;
    }

    /* renamed from: d */
    private List<SfContactsDataBaseModel> m20107d() {
        Cursor query = SfContextHelper.getContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "display_name"}, (String) null, (String[]) null, "display_name");
        if (query == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        while (query.moveToNext()) {
            SfContactsDataBaseModel sfContactsDataBaseModel = new SfContactsDataBaseModel();
            sfContactsDataBaseModel.f25102id = query.getLong(0);
            sfContactsDataBaseModel.name = query.getString(1);
            treeSet.add(sfContactsDataBaseModel);
        }
        query.close();
        return new ArrayList(treeSet);
    }

    /* renamed from: e */
    private List<SfContactsDataBaseModel> m20108e() {
        ArrayList arrayList = new ArrayList();
        Cursor query = SfContextHelper.getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "contact_id"}, (String) null, (String[]) null, (String) null);
        if (query == null || !query.moveToFirst()) {
            return arrayList;
        }
        do {
            SfContactsDataBaseModel sfContactsDataBaseModel = new SfContactsDataBaseModel();
            sfContactsDataBaseModel.phone = m20101b(query.getString(0));
            sfContactsDataBaseModel.f25102id = query.getLong(1);
            arrayList.add(sfContactsDataBaseModel);
        } while (query.moveToNext());
        return arrayList;
    }

    /* renamed from: b */
    private String m20101b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("-", "").replaceAll(" ", "");
    }
}
