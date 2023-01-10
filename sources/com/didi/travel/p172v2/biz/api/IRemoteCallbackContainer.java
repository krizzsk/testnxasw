package com.didi.travel.p172v2.biz.api;

/* renamed from: com.didi.travel.v2.biz.api.IRemoteCallbackContainer */
public interface IRemoteCallbackContainer<T> {
    void addRemoteCallback(RemoteCallback<T> remoteCallback);

    void removeRemoteCallback(RemoteCallback<T> remoteCallback);
}
