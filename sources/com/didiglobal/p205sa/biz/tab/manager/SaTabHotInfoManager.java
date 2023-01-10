package com.didiglobal.p205sa.biz.tab.manager;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.util.SPUtils;
import com.didiglobal.p205sa.biz.fragment.SaTabFragment;
import com.didiglobal.p205sa.biz.tab.model.SaTabHotInfo;
import com.didiglobal.p205sa.biz.tab.model.SaTabMenuModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u0019R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0004R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/tab/manager/SaTabHotInfoManager;", "", "data", "Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "(Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;)V", "appContext", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "getData", "()Lcom/didiglobal/sa/biz/fragment/SaTabFragment$TabModel;", "setData", "groupId", "", "hasClickCount", "", "hasShowCount", "hotInfo", "Lcom/didiglobal/sa/biz/tab/model/SaTabHotInfo;", "keyHideAfterActived", "keyHideAfterShown", "keyMd5", "savedMD5", "clickHot", "", "needShowHot", "", "updateHot", "view", "Landroid/widget/ImageView;", "hasTip", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.manager.SaTabHotInfoManager */
/* compiled from: SaTabHotInfoManager.kt */
public final class SaTabHotInfoManager {

    /* renamed from: a */
    private SaTabFragment.TabModel f53770a;

    /* renamed from: b */
    private final String f53771b;

    /* renamed from: c */
    private final SaTabHotInfo f53772c;

    /* renamed from: d */
    private final String f53773d;

    /* renamed from: e */
    private final String f53774e;

    /* renamed from: f */
    private final String f53775f;

    /* renamed from: g */
    private final Application f53776g;

    /* renamed from: h */
    private int f53777h;

    /* renamed from: i */
    private int f53778i;

    /* renamed from: j */
    private String f53779j;

    public SaTabHotInfoManager(SaTabFragment.TabModel tabModel) {
        Intrinsics.checkNotNullParameter(tabModel, "data");
        this.f53770a = tabModel;
        SaTabMenuModel tabMenu = tabModel.getTabMenu();
        SaTabHotInfo saTabHotInfo = null;
        this.f53771b = tabMenu == null ? null : tabMenu.getTabId();
        SaTabMenuModel tabMenu2 = this.f53770a.getTabMenu();
        this.f53772c = tabMenu2 != null ? tabMenu2.getHotInfo() : saTabHotInfo;
        this.f53773d = Intrinsics.stringPlus("SaTabHotInfoManager_keyMd5_", this.f53771b);
        this.f53774e = Intrinsics.stringPlus("SaTabHotInfoManager_keyHideAfterActived_", this.f53771b);
        this.f53775f = Intrinsics.stringPlus("SaTabHotInfoManager_keyMd5_keyHideAfterShown_", this.f53771b);
        Application appContext = DIDIApplication.getAppContext();
        this.f53776g = appContext;
        Object obj = SPUtils.get(appContext, this.f53775f, 0);
        if (obj != null) {
            this.f53777h = ((Integer) obj).intValue();
            Object obj2 = SPUtils.get(this.f53776g, this.f53774e, 0);
            if (obj2 != null) {
                this.f53778i = ((Integer) obj2).intValue();
                this.f53779j = (String) SPUtils.get(this.f53776g, this.f53773d, "");
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    public final SaTabFragment.TabModel getData() {
        return this.f53770a;
    }

    public final void setData(SaTabFragment.TabModel tabModel) {
        Intrinsics.checkNotNullParameter(tabModel, "<set-?>");
        this.f53770a = tabModel;
    }

    public final void updateHot(ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setVisibility(8);
                return;
            }
            SaTabFragment.TabModel.TabPointInfo tabPointInfo = this.f53770a.getTabPointInfo();
            if (tabPointInfo == null || !tabPointInfo.getHasPoint()) {
                SaTabHotInfo saTabHotInfo = this.f53772c;
                if (saTabHotInfo == null) {
                    imageView.setVisibility(8);
                    return;
                }
                SPUtils.put(this.f53776g, this.f53773d, saTabHotInfo.getMd5());
                if (this.f53772c.getHotShowType() == 1) {
                    imageView.setVisibility(0);
                    ((RequestBuilder) Glide.with((Context) this.f53776g).load(this.f53772c.getHotUrl()).placeholder((int) R.drawable.sa_business_more_item_default)).into(imageView);
                    return;
                }
                if (TextUtils.equals(this.f53779j, this.f53772c.getMd5())) {
                    int i = this.f53777h - 1;
                    this.f53777h = i;
                    if (i <= 0) {
                        this.f53777h = 0;
                    }
                    SPUtils.put(this.f53776g, this.f53775f, Integer.valueOf(this.f53777h));
                } else {
                    this.f53777h = this.f53772c.getHideAfterShown();
                    this.f53778i = this.f53772c.getHideAfterActived();
                    SPUtils.put(this.f53776g, this.f53774e, Integer.valueOf(this.f53772c.getHideAfterActived()));
                    SPUtils.put(this.f53776g, this.f53775f, Integer.valueOf(this.f53772c.getHideAfterShown()));
                }
                if (m40121a()) {
                    imageView.setVisibility(0);
                    ((RequestBuilder) Glide.with((Context) this.f53776g).load(this.f53772c.getHotUrl()).placeholder((int) R.drawable.sa_business_more_item_default)).into(imageView);
                    return;
                }
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            Glide.with((Context) this.f53776g).load(Integer.valueOf(R.drawable.icon_sa_tab_reddot)).into(imageView);
        }
    }

    /* renamed from: a */
    private final boolean m40121a() {
        return this.f53777h > 0 && this.f53778i > 0;
    }

    public final void clickHot() {
        SaTabFragment.TabModel.TabPointInfo tabPointInfo = this.f53770a.getTabPointInfo();
        if (tabPointInfo == null || (TextUtils.isEmpty(tabPointInfo.getTipPoint()) && !tabPointInfo.getHasPoint())) {
            int i = this.f53778i - 1;
            this.f53778i = i;
            if (i <= 0) {
                this.f53778i = 0;
            }
            SPUtils.put(this.f53776g, this.f53774e, Integer.valueOf(this.f53778i));
        }
    }
}
