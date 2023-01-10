package com.didi.remotereslibrary;

import android.content.Context;
import com.didi.remotereslibrary.exception.RemoteResourceNotFoundException;
import com.didi.remotereslibrary.response.BaseResponse;
import com.didi.remotereslibrary.response.IRemoteCallBack;
import java.io.File;
import java.util.HashMap;

public class RemoteResourceManager implements IRemoteResourceManager {

    /* renamed from: a */
    private static RemoteResourceManager f35920a;

    /* renamed from: b */
    private IRemoteResourceManager f35921b = new C12325a();

    /* renamed from: c */
    private ILoginParam f35922c;

    /* renamed from: d */
    private IDepartureParam f35923d;

    /* renamed from: e */
    private IDomainParam f35924e;

    public void setLoginParam(ILoginParam iLoginParam) {
        this.f35922c = iLoginParam;
    }

    public void setDomainParam(IDomainParam iDomainParam) {
        this.f35924e = iDomainParam;
    }

    public ILoginParam getLoginParam() {
        return this.f35922c;
    }

    public IDomainParam getDomainParam() {
        return this.f35924e;
    }

    public void setDepartureParam(IDepartureParam iDepartureParam) {
        this.f35923d = iDepartureParam;
    }

    public IDepartureParam getDepartureParam() {
        return this.f35923d;
    }

    private RemoteResourceManager() {
    }

    public void setDebugMode(boolean z) {
        this.f35921b.setDebugMode(z);
    }

    public void init(Context context) {
        this.f35921b.init(context);
    }

    public void pullRemoteResource(double d, double d2) {
        this.f35921b.pullRemoteResource(d, d2);
    }

    public static RemoteResourceManager getInstance() {
        if (f35920a == null) {
            f35920a = new RemoteResourceManager();
        }
        return f35920a;
    }

    public long downFile(ResourceItemModel resourceItemModel) {
        return this.f35921b.downFile(resourceItemModel);
    }

    public long httpRequest(String str, HashMap hashMap, BaseResponse baseResponse, IRemoteCallBack iRemoteCallBack) {
        return this.f35921b.httpRequest(str, hashMap, baseResponse, iRemoteCallBack);
    }

    public File getResource(String str, String str2) throws RemoteResourceNotFoundException {
        return this.f35921b.getResource(str, str2);
    }

    public File getResource(String str) throws RemoteResourceNotFoundException {
        return this.f35921b.getResource(str);
    }

    public void destroy() {
        this.f35921b.destroy();
    }

    public void setEnableApollo(boolean z) {
        this.f35921b.setEnableApollo(z);
    }
}
