package com.didi.globalsafetoolkit.net;

import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import com.didi.globalsafetoolkit.model.SfBaseObject;
import com.didi.globalsafetoolkit.util.SfEnvironment;
import com.didi.globalsafetoolkit.util.SfLog;
import com.didi.globalsafetoolkit.util.SfParseException;
import com.didi.globalsafetoolkit.util.SfStringGetter;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;

public abstract class SfRpcCallback<T extends SfBaseObject> implements RpcService.Callback<T> {
    private SfResponseListener<T> mResponseListener;

    public SfRpcCallback(SfResponseListener<T> sfResponseListener) {
        this.mResponseListener = sfResponseListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068 A[Catch:{ Exception -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(T r4) {
        /*
            r3 = this;
            java.lang.String r0 = "SfRpcCallback"
            if (r4 == 0) goto L_0x001b
            boolean r1 = r4.isAvailable()     // Catch:{ Exception -> 0x006e }
            if (r1 != 0) goto L_0x000b
            goto L_0x001b
        L_0x000b:
            java.lang.String r1 = "onSuccess "
            com.didi.globalsafetoolkit.util.SfLog.m20152i(r0, r1)     // Catch:{ Exception -> 0x006e }
            com.didi.globalsafetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006e }
            if (r0 == 0) goto L_0x0064
            com.didi.globalsafetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006e }
            r0.onSuccess(r4)     // Catch:{ Exception -> 0x006e }
            goto L_0x0064
        L_0x001b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = "onError : "
            r1.<init>(r2)     // Catch:{ Exception -> 0x006e }
            if (r4 != 0) goto L_0x002b
            java.lang.String r2 = "Response is NULL."
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
            goto L_0x0054
        L_0x002b:
            java.lang.String r2 = "Response error, traceid = "
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = ",  error code = "
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
            int r2 = r4.errno     // Catch:{ Exception -> 0x006e }
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = ", error msg = "
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = r4.errmsg     // Catch:{ Exception -> 0x006e }
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = ", response class typeLocal = "
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
            java.lang.Class r2 = r4.getClass()     // Catch:{ Exception -> 0x006e }
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x006e }
            r1.append(r2)     // Catch:{ Exception -> 0x006e }
        L_0x0054:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x006e }
            com.didi.globalsafetoolkit.util.SfLog.m20156w(r0, r1)     // Catch:{ Exception -> 0x006e }
            com.didi.globalsafetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006e }
            if (r0 == 0) goto L_0x0064
            com.didi.globalsafetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006e }
            r0.onError(r4)     // Catch:{ Exception -> 0x006e }
        L_0x0064:
            com.didi.globalsafetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006e }
            if (r0 == 0) goto L_0x0073
            com.didi.globalsafetoolkit.net.SfResponseListener<T> r0 = r3.mResponseListener     // Catch:{ Exception -> 0x006e }
            r0.onFinish(r4)     // Catch:{ Exception -> 0x006e }
            goto L_0x0073
        L_0x006e:
            r4 = move-exception
            boolean r0 = com.didi.globalsafetoolkit.util.SfEnvironment.DEBUG
            if (r0 != 0) goto L_0x0074
        L_0x0073:
            return
        L_0x0074:
            com.didi.globalsafetoolkit.util.SfParseException r0 = new com.didi.globalsafetoolkit.util.SfParseException
            r0.<init>((java.lang.Throwable) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.globalsafetoolkit.net.SfRpcCallback.onSuccess(com.didi.globalsafetoolkit.model.SfBaseObject):void");
    }

    public void onFailure(IOException iOException) {
        SfLog.m20148e("SfRpcCallback", "【onFailure】", iOException);
        if (SfEnvironment.DEBUG && iOException != null) {
            Throwable cause = iOException.getCause();
            if (cause instanceof SfParseException) {
                String localCause = ((SfParseException) cause).getLocalCause();
                if (TextUtils.isEmpty(localCause)) {
                    localCause = "NetCallback CRASH!";
                }
                throw new AndroidRuntimeException(localCause, cause);
            }
        }
        SfResponseListener<T> sfResponseListener = this.mResponseListener;
        if (sfResponseListener != null) {
            sfResponseListener.onFail(-1, SfStringGetter.getString(R.string.sf_common_no_net_error_tips));
            this.mResponseListener.onFinish(null);
        }
    }
}
