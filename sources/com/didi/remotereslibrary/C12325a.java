package com.didi.remotereslibrary;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.remotereslibrary.broadcast.FileDownBroadcast;
import com.didi.remotereslibrary.downservice.DiDiDownLoadManager;
import com.didi.remotereslibrary.downservice.IRemoteSourceDownLoadManager;
import com.didi.remotereslibrary.exception.RemoteResourceNotFoundException;
import com.didi.remotereslibrary.exception.RemoteResourcenInitException;
import com.didi.remotereslibrary.response.BaseResponse;
import com.didi.remotereslibrary.response.IRemoteCallBack;
import com.didi.remotereslibrary.response.ResourceListResponser;
import com.didi.remotereslibrary.rpcservice.DiDiHttpRequestManager;
import com.didi.remotereslibrary.rpcservice.IRemoteResourceHttpRequestManager;
import com.didi.remotereslibrary.store.RemoteResourceStore;
import com.didi.remotereslibrary.utils.C12329Util;
import com.didi.remotereslibrary.utils.Constants;
import com.didi.remotereslibrary.utils.DLog;
import com.didi.remotereslibrary.utils.FileUtils;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.remotereslibrary.a */
/* compiled from: RemoteResourceManagerImpl */
class C12325a implements IRemoteResourceManager {

    /* renamed from: a */
    protected Context f35925a;

    /* renamed from: b */
    private IRemoteSourceDownLoadManager f35926b;

    /* renamed from: c */
    private IRemoteResourceHttpRequestManager f35927c;

    /* renamed from: d */
    private FileDownBroadcast f35928d = new FileDownBroadcast();

    /* renamed from: e */
    private boolean f35929e = false;

    /* renamed from: f */
    private int f35930f = 0;

    /* renamed from: g */
    private final int f35931g = 3;

    /* renamed from: h */
    private boolean f35932h = true;

    /* renamed from: i */
    private Config f35933i;

    /* renamed from: j */
    private OnToggleStateChangeListener f35934j = new RemoteResourceManagerImpl$1(this);

    /* renamed from: a */
    public void mo93700a(Config config) {
        this.f35933i = config;
    }

    public C12325a() {
        setDebugMode(false);
        Apollo.addToggleStateChangeListener(this.f35934j);
    }

    public void setDebugMode(boolean z) {
        this.f35929e = z;
    }

    public void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f35925a = applicationContext;
        this.f35926b = new DiDiDownLoadManager(applicationContext);
        this.f35927c = new DiDiHttpRequestManager(this.f35925a);
        m27086a();
    }

    /* renamed from: a */
    private void m27086a() {
        try {
            this.f35925a.registerReceiver(this.f35928d, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public long downFile(ResourceItemModel resourceItemModel) {
        return this.f35926b.downFile(resourceItemModel);
    }

    public long httpRequest(String str, HashMap hashMap, BaseResponse baseResponse, IRemoteCallBack iRemoteCallBack) {
        return this.f35927c.httpRequest(str, hashMap, baseResponse, iRemoteCallBack);
    }

    public void pullRemoteResource(double d, double d2) {
        m27087a(d, d2);
    }

    /* renamed from: a */
    private void m27087a(double d, double d2) {
        String str;
        DLog.m27099d(C12329Util.TAG, "调用了远程资源Init  lat:" + d + "  lng:" + d2);
        if (!m27094b()) {
            DLog.m27099d(C12329Util.TAG, "APOLLO IS SWITCH OFF");
            return;
        }
        ResourceListResponser resourceListResponser = new ResourceListResponser();
        ResourceListResponser resourceListCache = RemoteResourceStore.getInstance(this.f35925a).getResourceListCache(RemoteResourceStore.KEY_RESLIST_DATA);
        HashMap hashMap = new HashMap();
        Config config = this.f35933i;
        String str2 = config == null ? "2.0.0" : config.apiver;
        Config config2 = this.f35933i;
        String str3 = config2 == null ? Config.VALUE_DEFAULT_NS : config2.f35919ns;
        String remoteResourceUrl = Constants.getRemoteResourceUrl();
        if (resourceListCache == null) {
            str = "";
        } else {
            str = resourceListCache.md5;
        }
        hashMap.put(Config.KEY_APIVER, str2);
        hashMap.put(Config.KEY_NS, str3);
        hashMap.put(Config.KEY_LASTMD5, str);
        hashMap.put("flat", Double.valueOf(d));
        hashMap.put("flng", Double.valueOf(d2));
        httpRequest(remoteResourceUrl, hashMap, resourceListResponser, new RemoteResourceManagerImpl$2(this, resourceListCache, d, d2));
    }

    public File getResource(String str, String str2) throws RemoteResourceNotFoundException {
        return getResource(str + "/" + str2);
    }

    public File getResource(String str) throws RemoteResourceNotFoundException {
        if (this.f35925a == null) {
            throw new RemoteResourcenInitException("context is null,you must call RemoteResourceManager.getInstance().init(Context)");
        } else if (m27094b()) {
            File downLoadFileBySubPath = FileUtils.getDownLoadFileBySubPath(this.f35925a, str);
            if (downLoadFileBySubPath.exists()) {
                return downLoadFileBySubPath;
            }
            throw new RemoteResourceNotFoundException("remote resource file is not exits", 1);
        } else {
            throw new RemoteResourceNotFoundException("apollo switch off ", 2);
        }
    }

    /* renamed from: b */
    private boolean m27094b() {
        return !this.f35932h || Apollo.getToggle("remote_resource").allow();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27090a(ResourceListResponser resourceListResponser) {
        File downLoadFileDirectory = FileUtils.getDownLoadFileDirectory(this.f35925a);
        if (downLoadFileDirectory != null) {
            ArrayList arrayList = new ArrayList();
            FileUtils.getFiles(arrayList, downLoadFileDirectory.getPath());
            DLog.m27099d(C12329Util.TAG, "已缓存的文件列表:" + arrayList.toString());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < resourceListResponser.mData.size(); i++) {
                ResourceItemModel resourceItemModel = resourceListResponser.mData.get(i);
                try {
                    if (arrayList.contains(FileUtils.getDownLoadFileBySubPath(this.f35925a, resourceItemModel.key).getPath()) && TextUtils.equals(MD5.getFileMD5(FileUtils.getDownLoadFileBySubPath(this.f35925a, resourceItemModel.key)), "")) {
                        if (resourceItemModel.key.endsWith(PmFileConstant.ZIP_SUFFIX)) {
                            try {
                                File downLoadFileBySubPath = FileUtils.getDownLoadFileBySubPath(this.f35925a, resourceItemModel.key);
                                List<String> filesOfZipAndRar = FileUtils.getFilesOfZipAndRar(downLoadFileBySubPath.getPath());
                                arrayList2.addAll(filesOfZipAndRar);
                                for (int i2 = 0; i2 < filesOfZipAndRar.size(); i2++) {
                                    if (!new File(downLoadFileBySubPath.getParent(), filesOfZipAndRar.get(i2)).exists()) {
                                        FileUtils.unZip(downLoadFileBySubPath.getPath(), downLoadFileBySubPath.getParent());
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        arrayList2.add(FileUtils.getDownLoadFileBySubPath(this.f35925a, resourceItemModel.key).getPath());
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            DLog.m27099d(C12329Util.TAG, "保留的文件列表:" + arrayList2.toString());
            arrayList.removeAll(arrayList2);
            DLog.m27099d(C12329Util.TAG, "需要删除的文件列表:" + arrayList.toString());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                File file = new File((String) arrayList.get(i3));
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27093b(ResourceListResponser resourceListResponser) {
        this.f35930f = 0;
        List<ResourceItemModel> list = resourceListResponser.mData;
        for (int i = 0; i < list.size(); i++) {
            ResourceItemModel resourceItemModel = list.get(i);
            if (this.f35933i != null) {
                resourceItemModel.OnlyWifiType = resourceItemModel.OnlyWifiType;
            }
            downFile(list.get(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27091b(double d, double d2) {
        int i = this.f35930f + 1;
        this.f35930f = i;
        if (i <= 3) {
            UiThreadHandler.postOnceDelayed(new RemoteResourceManagerImpl$3(this, d, d2), 15000);
        }
    }

    public void setEnableApollo(boolean z) {
        this.f35932h = z;
    }

    public void destroy() {
        try {
            this.f35925a.unregisterReceiver(this.f35928d);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        Apollo.removeToggleStateChangeListener(this.f35934j);
    }
}
