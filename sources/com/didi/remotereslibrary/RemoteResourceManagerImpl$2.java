package com.didi.remotereslibrary;

import android.text.TextUtils;
import com.didi.remotereslibrary.response.IRemoteCallBack;
import com.didi.remotereslibrary.response.ResourceListResponser;
import com.didi.remotereslibrary.store.RemoteResourceStore;
import com.didi.remotereslibrary.utils.C12329Util;
import com.didi.remotereslibrary.utils.DLog;

class RemoteResourceManagerImpl$2 implements IRemoteCallBack<ResourceListResponser> {
    final /* synthetic */ C12325a this$0;
    final /* synthetic */ ResourceListResponser val$cacheResourceListResponser;
    final /* synthetic */ double val$lat;
    final /* synthetic */ double val$lng;

    RemoteResourceManagerImpl$2(C12325a aVar, ResourceListResponser resourceListResponser, double d, double d2) {
        this.this$0 = aVar;
        this.val$cacheResourceListResponser = resourceListResponser;
        this.val$lat = d;
        this.val$lng = d2;
    }

    public void onSuccess(ResourceListResponser resourceListResponser) {
        if (resourceListResponser.isSuccess()) {
            ResourceListResponser resourceListResponser2 = this.val$cacheResourceListResponser;
            if (resourceListResponser2 == null || !TextUtils.equals(resourceListResponser2.md5, resourceListResponser.md5)) {
                this.this$0.m27090a(resourceListResponser);
                RemoteResourceStore.getInstance(this.this$0.f35925a).putResourceListCache(RemoteResourceStore.KEY_RESLIST_DATA, resourceListResponser);
                this.this$0.m27093b(resourceListResponser);
                return;
            }
            DLog.m27099d(C12329Util.TAG, "md5没有变化，使用缓存数据");
            this.this$0.m27093b(this.val$cacheResourceListResponser);
            return;
        }
        DLog.m27099d(C12329Util.TAG, "数据返回出错");
    }

    public void onError(ResourceListResponser resourceListResponser) {
        this.this$0.m27091b(this.val$lat, this.val$lng);
    }
}
