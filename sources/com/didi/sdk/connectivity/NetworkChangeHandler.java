package com.didi.sdk.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.util.ArrayList;
import java.util.List;

class NetworkChangeHandler {

    /* renamed from: a */
    private static final String f38513a = "connectivity";

    /* renamed from: b */
    private static String f38514b = "0-None";

    /* renamed from: c */
    private static volatile NetworkChangeHandler f38515c;

    /* renamed from: d */
    private final List<NetworkChangedCallback> f38516d = new ArrayList();

    interface NetworkChangedCallback {
        void onAvailable(Context context);

        void onLost(Context context);
    }

    NetworkChangeHandler() {
    }

    /* renamed from: a */
    static NetworkChangeHandler m29035a() {
        if (f38515c == null) {
            synchronized (NetworkChangeHandler.class) {
                if (f38515c == null) {
                    f38515c = new NetworkChangeHandler();
                }
            }
        }
        return f38515c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97877a(Context context) {
        f38514b = m29037d(context);
        m29038e(context);
    }

    /* renamed from: e */
    private void m29038e(final Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (Build.VERSION.SDK_INT >= 24 && (connectivityManager = (ConnectivityManager) context.getSystemService(f38513a)) != null) {
                NetworkRequest.Builder builder = new NetworkRequest.Builder();
                builder.addCapability(13);
                connectivityManager.registerNetworkCallback(builder.build(), new ConnectivityManager.NetworkCallback() {
                    public void onAvailable(Network network) {
                        super.onAvailable(network);
                        NetworkChangeHandler.this.mo97879b(context);
                    }

                    public void onLost(Network network) {
                        super.onLost(network);
                        NetworkChangeHandler.this.mo97881c(context);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97879b(Context context) {
        try {
            String d = m29037d(context);
            if (!TextUtils.isEmpty(d) && !d.equals(f38514b)) {
                f38514b = d;
                m29039f(context);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: f */
    private void m29039f(Context context) {
        ArrayList<NetworkChangedCallback> arrayList = new ArrayList<>();
        synchronized (this.f38516d) {
            arrayList.addAll(this.f38516d);
        }
        for (NetworkChangedCallback onAvailable : arrayList) {
            onAvailable.onAvailable(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo97881c(Context context) {
        if (!"0-None".equals(f38514b)) {
            f38514b = "0-None";
            m29040g(context);
        }
    }

    /* renamed from: g */
    private void m29040g(Context context) {
        ArrayList<NetworkChangedCallback> arrayList = new ArrayList<>();
        synchronized (this.f38516d) {
            arrayList.addAll(this.f38516d);
        }
        for (NetworkChangedCallback onLost : arrayList) {
            onLost.onLost(context);
        }
    }

    /* renamed from: d */
    static String m29037d(Context context) {
        try {
            StringBuilder sb = new StringBuilder();
            int a = C12995f.m29064a(context);
            if (a == 0) {
                sb.append("0-None");
            } else if (a == 1) {
                sb.append("1-");
                sb.append(m29036a(C12995f.m29067c(context)));
            } else {
                sb.append("2-");
                sb.append(C12995f.m29066b(context));
                sb.append("-");
                if (a == 2) {
                    sb.append("2G");
                } else if (a == 3) {
                    sb.append("3G");
                } else if (a == 4) {
                    sb.append("4G");
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private static String m29036a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.startsWith(Const.jsQuote)) {
            sb.deleteCharAt(0);
        }
        if (str.endsWith(Const.jsQuote)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97878a(NetworkChangedCallback networkChangedCallback) {
        synchronized (this.f38516d) {
            this.f38516d.add(networkChangedCallback);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo97880b(NetworkChangedCallback networkChangedCallback) {
        synchronized (this.f38516d) {
            this.f38516d.remove(networkChangedCallback);
        }
    }
}
