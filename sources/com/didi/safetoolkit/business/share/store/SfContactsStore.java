package com.didi.safetoolkit.business.share.store;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsRequestBiz;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.model.NewContactsModelForShare;
import com.didi.safetoolkit.business.share.model.SfContactsDataBaseModel;
import com.didi.safetoolkit.business.share.model.SfShareResponse;
import com.didi.safetoolkit.business.share.model.SfSortKey;
import com.didi.safetoolkit.business.share.request.SfShareSMSRequest;
import com.didi.safetoolkit.business.share.util.SfCharMapUtil;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.net.SfHttpManager;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.net.SfRpcCallback;
import com.didi.safetoolkit.util.SfCollectionUtil;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfUIThreadHelper;
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
    public static final String f37207a = SfContactsStore.class.getSimpleName();

    /* renamed from: b */
    private static volatile SoftReference<List<SfContactsModel>> f37208b;

    /* renamed from: g */
    private static ISfContactsStore f37209g;

    /* renamed from: c */
    private SfShareSMSRequest f37210c;

    /* renamed from: d */
    private ArrayList<String> f37211d = new ArrayList<>();

    /* renamed from: e */
    private List<SfContactsModel> f37212e;

    /* renamed from: f */
    private boolean f37213f;

    private SfContactsStore() {
    }

    public static ISfContactsStore getInstance() {
        if (f37209g == null) {
            synchronized (SfContactsStore.class) {
                if (f37209g == null) {
                    f37209g = new SfContactsStore();
                }
            }
        }
        return f37209g;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized List<SfContactsModel> m28086b() {
        if (!m28090c()) {
            return m28089c(f37208b.get());
        }
        long currentTimeMillis = System.currentTimeMillis();
        List<SfContactsDataBaseModel> e = m28092e();
        List<SfContactsDataBaseModel> d = m28091d();
        if (!SfCollectionUtil.isEmpty((Collection) e)) {
            if (!SfCollectionUtil.isEmpty((Collection) d)) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < d.size(); i++) {
                    long j = d.get(i).f37203id;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= e.size()) {
                            break;
                        }
                        if (e.get(i2).f37203id == j) {
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
                List<SfContactsModel> b = m28087b((List<SfContactsModel>) arrayList);
                String str = f37207a;
                SfLog.m28131d(str, "getContacts spend time = " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return b;
            }
        }
        return null;
    }

    public void getSystemContacts(final SfCallback sfCallback) {
        this.f37213f = false;
        if (!m28090c()) {
            SfLog.m28138i(f37207a, "getSystemContacts from cache");
            this.f37212e = f37208b.get();
            sfCallback.onSucceed(m28089c(f37208b.get()));
            return;
        }
        Thread thread = new Thread(new Runnable() {
            public void run() {
                SystemUtils.setProcessThreadPriority(10);
                SfLog.m28138i(SfContactsStore.f37207a, "getSystemContacts from database");
                try {
                    List a = SfContactsStore.this.m28086b();
                    SfContactsStore.this.m28083a((List<SfContactsModel>) a);
                    SfContactsStore.this.m28077a(sfCallback, (List<SfContactsModel>) a);
                } catch (Exception e) {
                    SfContactsStore sfContactsStore = SfContactsStore.this;
                    SfCallback sfCallback = sfCallback;
                    sfContactsStore.m28076a(sfCallback, "something wrong! msg = " + e.toString());
                    e.printStackTrace();
                }
            }
        });
        thread.setName("sf_getContacts_thread");
        SystemUtils.startThread(thread);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28083a(List<SfContactsModel> list) {
        if (m28090c()) {
            f37208b = new SoftReference<>(list);
        }
        if (!this.f37213f) {
            this.f37212e = list;
        }
    }

    /* renamed from: c */
    private boolean m28090c() {
        return f37208b == null || f37208b.get() == null || f37208b.get().size() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28076a(final SfCallback sfCallback, final String str) {
        SfUIThreadHelper.post(new Runnable() {
            public void run() {
                sfCallback.onFailed(str);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m28077a(final SfCallback sfCallback, final List<SfContactsModel> list) {
        SfUIThreadHelper.post(new Runnable() {
            public void run() {
                sfCallback.onSucceed(list);
            }
        });
    }

    /* renamed from: b */
    private List<SfContactsModel> m28087b(List<SfContactsModel> list) {
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
        List<SfContactsModel> list = this.f37212e;
        if (list == null || list.size() == 0) {
            sfCallback.onFailed("origin data is null!");
            SfLog.m28138i(f37207a, "getMatchList failed while cache is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SfContactsModel next : this.f37212e) {
            if (m28084a(next.name, str) || m28084a(next.phone, str)) {
                arrayList.add(next);
            }
        }
        sfCallback.onSucceed(arrayList);
    }

    /* renamed from: a */
    private boolean m28084a(String str, String str2) {
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
        sfShareSMSRequest.productId = SafeToolKit.getIns().getProductId();
        this.f37211d.clear();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                this.f37211d.add(list.get(i).name);
            }
        }
        m28075a(sfShareSMSRequest, sfResponseListener);
    }

    public void shareRetry() {
        m28075a(this.f37210c, (SfResponseListener) null);
    }

    public void shareToSOSContacts() {
        m28075a(new SfShareSMSRequest(), (SfResponseListener) null);
    }

    public void clearData() {
        this.f37213f = true;
        if (this.f37212e != null) {
            this.f37212e = null;
        }
    }

    /* renamed from: a */
    private void m28075a(SfShareSMSRequest sfShareSMSRequest, SfResponseListener sfResponseListener) {
        if (sfShareSMSRequest != null) {
            this.f37210c = sfShareSMSRequest;
            if (sfResponseListener == null) {
                m28082a("sf_start_share");
                sfResponseListener = new SfResponseListener<SfShareResponse>() {
                    public void onSuccess(SfShareResponse sfShareResponse) {
                        SfContactsStore.this.m28082a("sf_share_success");
                    }

                    public void onFail(int i, String str) {
                        SfContactsStore.this.m28082a("sf_share_failed");
                    }

                    public void onError(SfShareResponse sfShareResponse) {
                        SfContactsStore.this.m28082a("sf_share_failed");
                    }
                };
            }
            if (SafeToolKit.getIns().isVamosDriver()) {
                m28088b(sfShareSMSRequest, sfResponseListener);
            } else {
                SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfShareSMSRequest, new SfRpcCallback<SfShareResponse>(sfResponseListener) {
                });
            }
        }
    }

    /* renamed from: b */
    private void m28088b(SfShareSMSRequest sfShareSMSRequest, final SfResponseListener sfResponseListener) {
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
    public void m28082a(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        intent.putExtra("sf_name_list", this.f37211d);
        LocalBroadcastManager.getInstance(SfContextHelper.getContext()).sendBroadcast(intent);
    }

    /* renamed from: c */
    private List<SfContactsModel> m28089c(List<SfContactsModel> list) {
        if (!(list == null || list.size() == 0)) {
            for (SfContactsModel sfContactsModel : list) {
                sfContactsModel.checked = false;
            }
        }
        return list;
    }

    /* renamed from: d */
    private List<SfContactsDataBaseModel> m28091d() {
        Cursor query = SfContextHelper.getContext().getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, new String[]{ShareDBHelper.ID_NAME, "display_name"}, (String) null, (String[]) null, "display_name");
        if (query == null) {
            return null;
        }
        TreeSet treeSet = new TreeSet();
        while (query.moveToNext()) {
            SfContactsDataBaseModel sfContactsDataBaseModel = new SfContactsDataBaseModel();
            sfContactsDataBaseModel.f37203id = query.getLong(0);
            sfContactsDataBaseModel.name = query.getString(1);
            treeSet.add(sfContactsDataBaseModel);
        }
        query.close();
        return new ArrayList(treeSet);
    }

    /* renamed from: e */
    private List<SfContactsDataBaseModel> m28092e() {
        ArrayList arrayList = new ArrayList();
        Cursor query = SfContextHelper.getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, new String[]{"data1", "contact_id"}, (String) null, (String[]) null, (String) null);
        if (query == null || !query.moveToFirst()) {
            return arrayList;
        }
        do {
            SfContactsDataBaseModel sfContactsDataBaseModel = new SfContactsDataBaseModel();
            sfContactsDataBaseModel.phone = m28085b(query.getString(0));
            sfContactsDataBaseModel.f37203id = query.getLong(1);
            arrayList.add(sfContactsDataBaseModel);
        } while (query.moveToNext());
        return arrayList;
    }

    /* renamed from: b */
    private String m28085b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replace("-", "").replaceAll(" ", "");
    }
}
