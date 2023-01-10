package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.text.TextUtils;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.misconfig.model.HotInfo;
import com.didi.sdk.util.SPUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BizNavItemMgr {

    /* renamed from: b */
    private static final String f39127b = "nav_red_point_md5";

    /* renamed from: c */
    private static final String f39128c = "nav_red_point_hide_after_actived";

    /* renamed from: d */
    private static final String f39129d = "nav_red_point_hide_after_shown";

    /* renamed from: a */
    List<TopCarGroupWrapper> f39130a;

    /* renamed from: e */
    private Context f39131e;

    /* renamed from: f */
    private HotInfo f39132f;

    /* renamed from: g */
    private boolean f39133g = false;

    /* renamed from: h */
    private boolean f39134h = false;

    /* renamed from: i */
    private final int f39135i = 5;

    /* renamed from: j */
    private BizNavItemView f39136j;
    public int mHideAfterActived = 0;
    public int mHideAfterShown = 0;

    public int getMaxColumnNum() {
        return 5;
    }

    public BizNavItemMgr(Context context) {
        this.f39131e = context;
    }

    public HotInfo getHotInfo() {
        return this.f39132f;
    }

    public void setHotInfo(HotInfo hotInfo) {
        if (hotInfo == null || ((TextUtils.isEmpty(hotInfo.hotTab) && TextUtils.isEmpty(hotInfo.navTag)) || this.f39130a == null)) {
            this.mHideAfterActived = 0;
            this.mHideAfterShown = 0;
            this.f39132f = null;
            BizNavItemView bizNavItemView = this.f39136j;
            if (bizNavItemView != null) {
                bizNavItemView.setRedPointVisibility(8);
                return;
            }
            return;
        }
        HotInfo hotInfo2 = this.f39132f;
        if (hotInfo2 == null || !TextUtils.equals(hotInfo2.MD5, hotInfo.MD5)) {
            this.f39136j = null;
            this.f39132f = hotInfo;
            m29469a();
            if (this.f39132f.hotShowType == 1) {
                this.f39133g = true;
                return;
            }
            String str = (String) SPUtils.get(this.f39131e, f39127b, "");
            if (str == null || !TextUtils.equals(str, hotInfo.MD5)) {
                this.mHideAfterActived = hotInfo.hideAfterActived;
                this.mHideAfterShown = hotInfo.hideAfterShown;
                SPUtils.put(this.f39131e, f39127b, hotInfo.MD5);
                SPUtils.put(this.f39131e, f39128c, Integer.valueOf(this.mHideAfterActived));
            } else {
                this.mHideAfterActived = ((Integer) SPUtils.get(this.f39131e, f39128c, 0)).intValue();
                int intValue = ((Integer) SPUtils.get(this.f39131e, f39129d, 0)).intValue();
                this.mHideAfterShown = intValue;
                this.mHideAfterShown = intValue - 1;
            }
            SPUtils.put(this.f39131e, f39129d, Integer.valueOf(this.mHideAfterShown));
            if (isRedPointNeedShow()) {
                HashMap hashMap = new HashMap();
                hashMap.put("hot_tab", this.f39132f.hotTab);
                hashMap.put("hot_show_type", Integer.valueOf(this.f39132f.hotShowType));
                OmegaSDKAdapter.trackEvent("ibt_gp_business_label_sw", (Map<String, Object>) hashMap);
            }
        }
    }

    public boolean hasRedPoint(String str, String str2) {
        HotInfo hotInfo = this.f39132f;
        return hotInfo != null && (TextUtils.equals(hotInfo.hotTab, str) || TextUtils.equals(this.f39132f.navTag, str2));
    }

    public boolean isRedPointNeedShow() {
        if (!this.f39133g) {
            return this.mHideAfterActived > 0 && this.mHideAfterShown > 0;
        }
        return true;
    }

    public boolean isRedPointShowOnMore() {
        return this.f39134h;
    }

    public void activeRedPointCount() {
        int i;
        if (!this.f39133g && (i = this.mHideAfterActived) > 0) {
            int i2 = i - 1;
            this.mHideAfterActived = i2;
            SPUtils.put(this.f39131e, f39128c, Integer.valueOf(i2));
        }
    }

    public void setNavRedPointItemView(BizNavItemView bizNavItemView) {
        this.f39136j = bizNavItemView;
    }

    public void updateNavRedPointItemView() {
        BizNavItemView bizNavItemView = this.f39136j;
        if (bizNavItemView != null && bizNavItemView.getRedPointVisibility() == 0 && !isRedPointNeedShow()) {
            this.f39136j.setRedPointVisibility(8);
        }
    }

    public List<TopCarGroupWrapper> getList() {
        return this.f39130a;
    }

    public void setList(List<TopCarGroupWrapper> list) {
        int size = list.size();
        boolean z = size > 5;
        for (int i = 0; i < size; i++) {
            TopCarGroupWrapper topCarGroupWrapper = list.get(i);
            if (topCarGroupWrapper.isSelected && i >= 4 && z) {
                list.remove(topCarGroupWrapper);
                list.add(3, topCarGroupWrapper);
            }
        }
        this.f39130a = list;
    }

    public void changeItemToMainBar(TopCarGroupWrapper topCarGroupWrapper) {
        this.f39130a.remove(topCarGroupWrapper);
        this.f39130a.add(3, topCarGroupWrapper);
        m29469a();
    }

    /* renamed from: a */
    private void m29469a() {
        this.f39134h = false;
        if (this.f39130a.size() > 5) {
            int i = 4;
            while (i < this.f39130a.size()) {
                HotInfo hotInfo = this.f39132f;
                if (hotInfo == null || (!hotInfo.hotTab.equals(this.f39130a.get(i).carGrop.getGroupType()) && (this.f39132f.navTag == null || !this.f39132f.navTag.equals(this.f39130a.get(i).carGrop.getNavTag())))) {
                    i++;
                } else {
                    this.f39134h = true;
                    return;
                }
            }
        }
    }
}
