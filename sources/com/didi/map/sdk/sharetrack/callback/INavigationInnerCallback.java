package com.didi.map.sdk.sharetrack.callback;

import com.didi.map.sdk.sharetrack.entity.NaviRoute;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/map/sdk/sharetrack/callback/INavigationInnerCallback;", "Lcom/didi/map/sdk/sharetrack/callback/INavigationCallback;", "onReceiveETA", "", "eta", "", "onRouteUpdate", "newRoute", "Lcom/didi/map/sdk/sharetrack/entity/NaviRoute;", "isOffRoute", "", "CommonShareTrack_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: INavigationInnerCallback.kt */
public interface INavigationInnerCallback extends INavigationCallback {
    void onReceiveETA(int i);

    void onRouteUpdate(NaviRoute naviRoute, boolean z);
}
