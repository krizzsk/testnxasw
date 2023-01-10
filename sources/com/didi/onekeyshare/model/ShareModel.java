package com.didi.onekeyshare.model;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import java.util.List;

public class ShareModel implements IShareModel {

    /* renamed from: a */
    private List<OneKeyShareInfo> f32229a;

    public void setShareInfo(List<OneKeyShareInfo> list) {
        this.f32229a = list;
    }

    public List<OneKeyShareInfo> getShareInfo() {
        return this.f32229a;
    }
}
