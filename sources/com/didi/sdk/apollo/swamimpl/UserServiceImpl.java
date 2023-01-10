package com.didi.sdk.apollo.swamimpl;

import android.os.Bundle;
import com.didi.sdk.data.DataLoadUtil;
import com.didi.sdk.data.UserDataGenerator;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.swarm.toolkit.UserService;

@ServiceProvider({UserService.class})
public class UserServiceImpl implements UserService {

    /* renamed from: a */
    final UserDataGenerator f37840a = ((UserDataGenerator) DataLoadUtil.loadGenerator(UserDataGenerator.class));

    public Bundle getAuthData() {
        Bundle bundle = new Bundle();
        bundle.putString("phone", this.f37840a.getPhone());
        bundle.putString("uid", this.f37840a.getUid());
        bundle.putString("token", this.f37840a.getToken());
        bundle.putString("phonecountrycode", "");
        return bundle;
    }
}
