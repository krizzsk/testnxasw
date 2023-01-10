package com.didi.sdk.idfa;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.sdk.p155ms.common.type.IMSType;
import com.didi.sdk.p155ms.common.utils.LogUtil;
import com.didi.sdk.p155ms.common.utils.ServiceUtil;
import com.didi.sdk.p155ms.p156ad.IAdOperation;

public class IDFAManager {

    /* renamed from: a */
    private static final String f39193a = "IDFAManager";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f39194b;

    public interface onIDFAChangeListener {
        void onIDFAChanged(String str);
    }

    public static synchronized String getIdfa(final Context context, final onIDFAChangeListener onidfachangelistener) {
        synchronized (IDFAManager.class) {
            if (context == null) {
                return "";
            }
            if (TextUtils.isEmpty(f39194b)) {
                new AsyncTask<Context, Void, String>() {
                    /* access modifiers changed from: protected */
                    public String doInBackground(Context... contextArr) {
                        IAdOperation iAdOperation = (IAdOperation) ServiceUtil.getServiceImp(IAdOperation.class, IMSType.GMS);
                        if (iAdOperation != null) {
                            String advertisingId = iAdOperation.getAdvertisingId(context);
                            LogUtil.m29855i(IDFAManager.f39193a, "doInBackground : gmsOperation is load, idfa = " + advertisingId);
                            return advertisingId;
                        }
                        IAdOperation iAdOperation2 = (IAdOperation) ServiceUtil.getServiceImp(IAdOperation.class, IMSType.HMS);
                        if (iAdOperation2 != null) {
                            String advertisingId2 = iAdOperation2.getAdvertisingId(context);
                            LogUtil.m29855i(IDFAManager.f39193a, "doInBackground : hmsOperation is load, idfa = " + advertisingId2);
                            return advertisingId2;
                        }
                        LogUtil.m29855i(IDFAManager.f39193a, "doInBackground : no IADOperation is load, idfa = " + null);
                        return "";
                    }

                    /* access modifiers changed from: protected */
                    public void onPostExecute(String str) {
                        super.onPostExecute(str);
                        String unused = IDFAManager.f39194b = str;
                        if (IDFAManager.f39194b == null) {
                            String unused2 = IDFAManager.f39194b = "";
                        }
                        onIDFAChangeListener onidfachangelistener = onidfachangelistener;
                        if (onidfachangelistener != null) {
                            onidfachangelistener.onIDFAChanged(IDFAManager.f39194b);
                        }
                    }
                }.execute(new Context[]{context});
            }
            String str = f39194b;
            return str;
        }
    }

    public static synchronized String getIdfa(Context context) {
        String idfa;
        synchronized (IDFAManager.class) {
            idfa = getIdfa(context, (onIDFAChangeListener) null);
        }
        return idfa;
    }
}
