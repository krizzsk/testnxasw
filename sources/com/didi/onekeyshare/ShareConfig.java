package com.didi.onekeyshare;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import java.util.ArrayList;

public class ShareConfig {
    public static final int WITHOUT_CORNER = 2;
    public static final int WITH_CORNER = 1;

    /* renamed from: a */
    private static ShareConfig f32213a = new ShareConfig();

    /* renamed from: b */
    private Nation f32214b = Nation.CHINA;

    /* renamed from: c */
    private ShareFragmentListener f32215c;

    /* renamed from: d */
    private int f32216d = 1;

    /* renamed from: e */
    private ShareFragmentFactory f32217e;

    public enum Nation {
        CHINA,
        GLOBAL
    }

    public interface ShareFragmentFactory {
        ShareFragment createShareFragment(ShareInfo shareInfo);

        ShareFragment createShareFragment(ArrayList<OneKeyShareInfo> arrayList);
    }

    public void setCornerStyle(int i) {
        this.f32216d = i;
    }

    public int getCornerStyle() {
        return this.f32216d;
    }

    public static ShareConfig getConfig() {
        return f32213a;
    }

    public ShareConfig setNation(Nation nation) {
        this.f32214b = nation;
        return f32213a;
    }

    public void addFragmentListener(ShareFragmentListener shareFragmentListener) {
        this.f32215c = shareFragmentListener;
    }

    public ShareFragmentListener getFragmentListener() {
        return this.f32215c;
    }

    public Nation getNation() {
        return this.f32214b;
    }

    public ShareFragmentFactory getShareFragmentFactory() {
        return this.f32217e;
    }

    public void setShareFragmentFactory(ShareFragmentFactory shareFragmentFactory) {
        this.f32217e = shareFragmentFactory;
    }
}
