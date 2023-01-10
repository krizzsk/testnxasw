package com.didichuxing.dfbasesdk.algomodel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.dfbasesdk.BuildConfig;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelConfigParam;
import com.didichuxing.dfbasesdk.algomodel.AlgoModelConfigResult;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.security.safecollector.WsgSecInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AlgoModelTaskManager {
    public static final int MSG_REQUEST_CONFIG = 100;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile String f49160a = null;

    /* renamed from: b */
    private static volatile String f49161b = null;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static int f49162c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static int f49163d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static Handler f49164e = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (100 == message.what) {
                LinkedList linkedList = new LinkedList();
                AlgoModelConfigService algoModelConfigService = null;
                Context context = null;
                AlgoModelConfigParam algoModelConfigParam = null;
                boolean z = false;
                while (!AlgoModelTaskManager.f49165f.isEmpty()) {
                    AlgoModelTaskImpl algoModelTaskImpl = (AlgoModelTaskImpl) AlgoModelTaskManager.f49165f.remove(0);
                    if (algoModelTaskImpl.f49150a != null) {
                        context = algoModelTaskImpl.f49150a;
                    }
                    AlgoModelConfigParam.ParamModel paramModel = new AlgoModelConfigParam.ParamModel();
                    paramModel.type = algoModelTaskImpl.f49151b;
                    paramModel.md5 = algoModelTaskImpl.mo122061a();
                    paramModel.sdkVer = algoModelTaskImpl.f49152c;
                    paramModel.background = algoModelTaskImpl.f49153d;
                    if (paramModel.background == 0) {
                        z = true;
                    }
                    if (algoModelConfigParam == null) {
                        algoModelConfigParam = new AlgoModelConfigParam();
                        algoModelConfigParam.appPac = WsgSecInfo.packageName(algoModelTaskImpl.f49150a);
                        algoModelConfigParam.appVer = WsgSecInfo.appVersionName(algoModelTaskImpl.f49150a);
                        algoModelConfigParam.f49147os = 1;
                        algoModelConfigParam.baseSdkVer = BuildConfig.VERSION_NAME;
                        algoModelConfigParam.models = new ArrayList();
                    }
                    algoModelConfigParam.models.add(paramModel);
                    CallbackParam callbackParam = new CallbackParam();
                    callbackParam.type = algoModelTaskImpl.f49151b;
                    callbackParam.configCallback = algoModelTaskImpl.mo122062b();
                    linkedList.add(callbackParam);
                    if (algoModelConfigService == null) {
                        algoModelConfigService = (AlgoModelConfigService) new RpcServiceFactory(algoModelTaskImpl.f49150a).newRpcService(AlgoModelConfigService.class, AlgoModelTaskManager.f49160a);
                    }
                }
                if (algoModelConfigService != null) {
                    AlgoModelTaskManager.m36857b(context, algoModelConfigService, algoModelConfigParam, z, linkedList);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static List<AlgoModelTaskImpl> f49165f = new LinkedList();

    public interface ConfigCallback {
        void onFailure(Exception exc);

        void onSuccess(AlgoModelConfigResult.ResultModel resultModel);
    }

    /* renamed from: c */
    static /* synthetic */ int m36858c() {
        int i = f49163d;
        f49163d = i + 1;
        return i;
    }

    /* renamed from: f */
    static /* synthetic */ int m36861f() {
        int i = f49162c;
        f49162c = i - 1;
        return i;
    }

    @Deprecated
    public static void execute(AlgoModelTaskImpl algoModelTaskImpl) {
        if (f49160a != null && f49161b != null) {
            algoModelTaskImpl.prepareModels();
        }
    }

    public static void execute(AlgoModelTaskImpl algoModelTaskImpl, String str, String str2) {
        f49160a = str;
        f49161b = str2;
        algoModelTaskImpl.prepareModels();
    }

    public static String getModelDir(Context context, int i) {
        return AlgoModelTaskImpl.m36807a(context, i);
    }

    /* renamed from: a */
    static void m36854a(AlgoModelTaskImpl algoModelTaskImpl) {
        f49164e.removeMessages(100);
        if (!f49165f.contains(algoModelTaskImpl)) {
            f49165f.add(algoModelTaskImpl);
        }
        f49164e.sendMessageDelayed(f49164e.obtainMessage(100), 200);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m36857b(Context context, AlgoModelConfigService algoModelConfigService, AlgoModelConfigParam algoModelConfigParam, boolean z, List<CallbackParam> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "1.0.0");
        final boolean z2 = z;
        final List<CallbackParam> list2 = list;
        final Context context2 = context;
        final AlgoModelConfigParam algoModelConfigParam2 = algoModelConfigParam;
        final AlgoModelConfigService algoModelConfigService2 = algoModelConfigService;
        algoModelConfigService.getConfig(hashMap, algoModelConfigParam, new RpcService.Callback<AlgoModelConfigResult>() {
            public void onSuccess(AlgoModelConfigResult algoModelConfigResult) {
                boolean z;
                if (algoModelConfigResult == null || algoModelConfigResult.data == null || 100002 != algoModelConfigResult.data.code) {
                    int unused = AlgoModelTaskManager.f49163d = 0;
                    if (algoModelConfigResult == null || algoModelConfigResult.data == null || 100000 != algoModelConfigResult.data.code) {
                        for (CallbackParam callbackParam : list2) {
                            callbackParam.configCallback.onFailure(new Exception(String.valueOf(algoModelConfigResult)));
                        }
                        return;
                    }
                    for (CallbackParam callbackParam2 : list2) {
                        if (algoModelConfigResult.data.result != null) {
                            z = false;
                            for (AlgoModelConfigResult.ResultModel next : algoModelConfigResult.data.result) {
                                if (callbackParam2.type == next.type) {
                                    z = true;
                                    callbackParam2.configCallback.onSuccess(next);
                                }
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            callbackParam2.configCallback.onSuccess((AlgoModelConfigResult.ResultModel) null);
                        }
                    }
                    return;
                }
                if (z2) {
                    AlgoModelTaskManager.m36858c();
                }
                onFailure(new ServerBrokenExp("server response 100002"));
            }

            public void onFailure(IOException iOException) {
                if (z2 && AlgoModelTaskManager.f49163d >= 3) {
                    AlgoModelTaskManager.m36856b(context2, algoModelConfigParam2, list2);
                } else if (z2 || AlgoModelTaskManager.f49162c <= 0) {
                    for (CallbackParam callbackParam : list2) {
                        callbackParam.configCallback.onFailure(iOException);
                    }
                } else {
                    AlgoModelTaskManager.m36861f();
                    AlgoModelTaskManager.f49164e.postDelayed(new Runnable() {
                        public void run() {
                            AlgoModelTaskManager.m36857b(context2, algoModelConfigService2, algoModelConfigParam2, z2, list2);
                        }
                    }, 2000);
                }
            }
        });
    }

    private static class ServerBrokenExp extends IOException {
        public ServerBrokenExp() {
        }

        public ServerBrokenExp(String str) {
            super(str);
        }

        public ServerBrokenExp(String str, Throwable th) {
            super(str, th);
        }

        public ServerBrokenExp(Throwable th) {
            super(th);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m36856b(Context context, AlgoModelConfigParam algoModelConfigParam, final List<CallbackParam> list) {
        HashMap hashMap = new HashMap();
        hashMap.put("apiVersion", "1.0.0");
        ((AlgoModelConfigService) new RpcServiceFactory(context).newRpcService(AlgoModelConfigService.class, f49161b)).requestReserve(hashMap, algoModelConfigParam, new RpcService.Callback<AlgoModelConfigResult>() {
            public void onSuccess(AlgoModelConfigResult algoModelConfigResult) {
                if (algoModelConfigResult == null || algoModelConfigResult.data == null || 100000 != algoModelConfigResult.data.code) {
                    onFailure(new IOException(String.valueOf(algoModelConfigResult)));
                    return;
                }
                for (CallbackParam callbackParam : list) {
                    boolean z = false;
                    if (algoModelConfigResult.data.result != null) {
                        for (AlgoModelConfigResult.ResultModel next : algoModelConfigResult.data.result) {
                            if (callbackParam.type == next.type) {
                                z = true;
                                callbackParam.configCallback.onSuccess(next);
                            }
                        }
                    }
                    if (!z) {
                        callbackParam.configCallback.onSuccess((AlgoModelConfigResult.ResultModel) null);
                    }
                }
            }

            public void onFailure(IOException iOException) {
                for (CallbackParam callbackParam : list) {
                    callbackParam.configCallback.onFailure(iOException);
                }
            }
        });
    }

    private static class CallbackParam {
        ConfigCallback configCallback;
        int type;

        private CallbackParam() {
        }
    }
}
