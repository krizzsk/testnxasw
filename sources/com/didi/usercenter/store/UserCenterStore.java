package com.didi.usercenter.store;

import android.content.Context;
import android.os.Parcelable;
import com.didi.sdk.store.BaseStore;
import com.didi.sdk.store.util.ParcelableUtil;
import com.didi.usercenter.entity.UserInfo;

public class UserCenterStore extends BaseStore {

    /* renamed from: a */
    private static String f47793a = "UserInfo";

    /* renamed from: b */
    private static UserCenterStore f47794b;

    /* renamed from: c */
    private UserInfo f47795c;

    /* renamed from: d */
    private com.didi.one.login.model.UserInfo f47796d;

    UserCenterStore() {
        super("com.didi.sdk.login.c.j");
    }

    public static UserCenterStore getIns() {
        if (f47794b == null) {
            synchronized (UserCenterStore.class) {
                if (f47794b == null) {
                    f47794b = new UserCenterStore();
                }
            }
        }
        return f47794b;
    }

    public void setUserInfo(Context context, UserInfo userInfo) {
        this.f47795c = userInfo;
        this.f47796d = com.didi.one.login.model.UserInfo.getUserInfo(userInfo);
        putAndSave(context, f47793a, (Parcelable) userInfo);
    }

    public UserInfo getUserInfo(Context context) {
        if (this.f47795c == null) {
            try {
                Object inner = getInner(context, f47793a);
                if (inner instanceof byte[]) {
                    inner = ParcelableUtil.unmarshall((byte[]) inner, UserInfo.CREATOR);
                }
                this.f47795c = (UserInfo) inner;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.f47795c;
    }

    public com.didi.one.login.model.UserInfo getOldUserInfo(Context context) {
        if (this.f47796d == null) {
            this.f47796d = com.didi.one.login.model.UserInfo.getUserInfo(getUserInfo(context));
        }
        return this.f47796d;
    }

    public void clearUserInfo(Context context) {
        this.f47795c = null;
        this.f47796d = null;
        clearAll(f47793a);
    }
}
