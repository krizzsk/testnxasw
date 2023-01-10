package com.didi.sdk.global.sign.presenter;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.paypal.model.bean.BaseResult;
import com.didi.sdk.global.sign.model.convert.SelectPageInfoConverter;
import com.didi.sdk.global.sign.model.convert.SelectPageInfoRefresher;
import com.didi.sdk.global.sign.model.convert.SettingPageInfoConverter;
import com.didi.sdk.global.sign.model.event.PayMethodConfirmEvent;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;
import com.didi.sdk.global.sign.model.server.PayMethodRpcModel;
import com.didi.sdk.global.sign.view.PayMethodSelectFragmentView;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class GlobalSelectPagePresenter extends GlobalBasePagePresenter {

    /* renamed from: a */
    private DidiGlobalPayMethodListData.PayMethodListParam f39053a;

    /* renamed from: b */
    private PaySelPageData f39054b;

    /* renamed from: c */
    private RequestItem f39055c;

    /* renamed from: d */
    private RequestItem f39056d;

    /* renamed from: e */
    private EnterprisePayway f39057e;

    /* renamed from: f */
    private String f39058f;

    /* renamed from: g */
    private int f39059g;

    /* renamed from: h */
    private int f39060h;

    /* renamed from: i */
    private Context f39061i;
    protected PayMethodRpcModel mModel = new PayMethodRpcModel(this.mFragmentActivity);

    private class RequestItem {
        public String cardIndex;
        public int channelId;

        public RequestItem(int i, String str) {
            this.channelId = i;
            this.cardIndex = str;
        }
    }

    public GlobalSelectPagePresenter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f39061i = fragmentActivity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveEvent(PayMethodConfirmEvent payMethodConfirmEvent) {
        RequestItem requestItem = this.f39056d;
        if (requestItem != null) {
            m29398a(this.f39054b, requestItem.channelId, this.f39056d.cardIndex);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void initData(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        if (payMethodListParam == null) {
            this.mView.showEmptyView();
            return;
        }
        this.f39053a = payMethodListParam;
        this.f39054b = SelectPageInfoConverter.convert(payMethodListParam);
        EnterprisePayway parseFromParam = SelectPageInfoConverter.parseFromParam(this.f39053a);
        this.f39057e = parseFromParam;
        if (parseFromParam != null) {
            for (PaySelItemData next : this.f39054b.payMethodList) {
                if (next != null && next.channelId == 153) {
                    this.f39058f = next.subTitle;
                    this.f39059g = next.titleStyle;
                    this.f39060h = next.subTitleStyle;
                }
            }
        }
        EnterprisePayway enterprisePayway = this.f39057e;
        if (enterprisePayway != null) {
            m29399a(enterprisePayway.toggle);
        }
        this.mView.updateContentView(this.f39054b, this.f39053a.from, this.f39057e);
    }

    public void onRequestSuccess(PaySelPageData paySelPageData) {
        SystemUtils.log(3, "wallet", "Select page requested data from server", (Throwable) null, "com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter", 130);
        this.mHasRequestDataFromServer = true;
        this.f39054b = paySelPageData;
        EnterprisePayway enterprisePayway = this.f39057e;
        if (enterprisePayway != null) {
            m29399a(enterprisePayway.toggle);
        }
        this.mView.updateContentView(this.f39054b, this.f39053a.from, this.f39057e);
        RequestItem requestItem = this.f39055c;
        if (requestItem != null) {
            m29398a(this.f39054b, requestItem.channelId, this.f39055c.cardIndex);
        }
    }

    public void onRequestSuccess(PayMethodPageResponse payMethodPageResponse) {
        RequestItem requestItem;
        PaySelPageData paySelPageData = this.f39054b;
        if (paySelPageData == null || (requestItem = this.f39055c) == null) {
            this.mView.updateContentView(SettingPageInfoConverter.convert(payMethodPageResponse), this.f39053a.from, this.f39057e);
        } else if (SelectPageInfoRefresher.refresh(paySelPageData, payMethodPageResponse, requestItem.channelId, this.f39055c.cardIndex)) {
            this.mView.updateContentView(this.f39054b, this.f39053a.from, this.f39057e);
            m29398a(this.f39054b, this.f39055c.channelId, this.f39055c.cardIndex);
        }
    }

    public void refreshDataFromLocal(int i, String str) {
        SelectPageInfoRefresher.refreshPayMethodStatus(this.f39054b, i, str);
        EnterprisePayway enterprisePayway = this.f39057e;
        if (enterprisePayway != null) {
            m29399a(enterprisePayway.toggle);
        }
        this.mView.updateContentView(this.f39054b, this.f39053a.from, this.f39057e);
        m29398a(this.f39054b, i, str);
    }

    public void refreshDataFromServer(int i, String str) {
        this.f39055c = new RequestItem(i, str);
        SystemUtils.log(3, "wallet", "Refresh data from server for item: " + this.f39055c.toString(), (Throwable) null, "com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter", 199);
        requestDataFromServer(this.f39053a.from);
    }

    public void refreshDataFromServer() {
        this.f39055c = null;
        requestDataFromServer(this.f39053a.from);
    }

    /* renamed from: a */
    private void m29398a(PaySelPageData paySelPageData, int i, String str) {
        PaySelItemData next;
        if (paySelPageData != null && paySelPageData.payMethodList != null && paySelPageData.payMethodList.size() != 0 && i != -1) {
            if (i == 121) {
                ((PayMethodSelectFragmentView) this.mView).doEnterprisePayMethodPerformClick(i);
                this.mFragmentActivity.onBackPressed();
                return;
            }
            boolean z = false;
            PaySelItemData paySelItemData = null;
            Iterator<PaySelItemData> it = paySelPageData.payMethodList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
                if (next != null) {
                    if (next.channelId == 150) {
                        if (!TextUtils.isEmpty(next.cardIndex) && next.cardIndex.equals(str)) {
                            break;
                        }
                    } else if (next.channelId == i) {
                        break;
                    }
                }
            }
            paySelItemData = next;
            if (paySelItemData != null) {
                if (paySelItemData.channelId != 150 ? !(paySelItemData.channelId != 190 ? !paySelItemData.isEnabled || paySelItemData.status != 1 : !paySelItemData.isEnabled || paySelItemData.status != 1 || !paySelItemData.isSufficient) : paySelItemData.status == 1) {
                    z = true;
                }
                if (z) {
                    ((PayMethodSelectFragmentView) this.mView).doPayMethodPerformClick(paySelItemData);
                }
            }
        }
    }

    public int getOmegaSource() {
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f39053a;
        if (payMethodListParam == null) {
            return 1;
        }
        int i = C131262.f39062x8a3a0836[payMethodListParam.from.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        if (i == 4) {
            return 2;
        }
        if (i != 5) {
            return 1;
        }
        return 5;
    }

    /* renamed from: com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter$2 */
    static /* synthetic */ class C131262 {

        /* renamed from: $SwitchMap$com$didi$sdk$global$DidiGlobalPayMethodListData$Entrance */
        static final /* synthetic */ int[] f39062x8a3a0836;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance[] r0 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f39062x8a3a0836 = r0
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f39062x8a3a0836     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f39062x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_UNIFIED_PAY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f39062x8a3a0836     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_GUIDE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f39062x8a3a0836     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.sdk.global.DidiGlobalPayMethodListData$Entrance r1 = com.didi.sdk.global.DidiGlobalPayMethodListData.Entrance.FROM_BIKE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.sign.presenter.GlobalSelectPagePresenter.C131262.<clinit>():void");
        }
    }

    public int getOmegaCardCount() {
        PaySelPageData paySelPageData = this.f39054b;
        int i = 0;
        if (paySelPageData == null || paySelPageData.payMethodList == null || this.f39054b.payMethodList.size() == 0) {
            return 0;
        }
        for (PaySelItemData paySelItemData : this.f39054b.payMethodList) {
            if (paySelItemData.channelId == 150) {
                i++;
            }
        }
        return i >= 1 ? i - 1 : i;
    }

    public int getOmegaClickType(PaySelItemData paySelItemData) {
        if (paySelItemData == null) {
            return 1;
        }
        if (paySelItemData.channelId == 150) {
            if (paySelItemData.status == 1) {
                return 2;
            }
            return 3;
        } else if (paySelItemData.channelId == 121) {
            return 1;
        } else {
            return (paySelItemData.channelId == 120 || paySelItemData.status == 1) ? 2 : 1;
        }
    }

    public String getOmegaDefaultPayment() {
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.f39053a;
        String str = "";
        if (!(payMethodListParam == null || payMethodListParam.list == null || this.f39053a.list.size() == 0)) {
            for (DidiGlobalPayMethodListData.PayMethodInfo next : this.f39053a.list) {
                if (next.isSelected) {
                    if (TextUtil.isEmpty(str)) {
                        str = str + next.channelId;
                    } else {
                        str = str + "," + next.channelId;
                    }
                }
            }
        }
        return str;
    }

    public void updateEnterpriseView(boolean z) {
        PaySelPageData paySelPageData = this.f39054b;
        if (paySelPageData != null && paySelPageData.payMethodList != null) {
            if (this.f39057e != null) {
                m29399a(z);
            }
            this.f39057e.toggle = z;
            this.mView.updateContentView(this.f39054b, this.f39053a.from, this.f39057e);
        }
    }

    /* renamed from: a */
    private void m29399a(boolean z) {
        for (PaySelItemData next : this.f39054b.payMethodList) {
            if (next != null && next.channelId == 153) {
                if (z) {
                    next.isEnabled = false;
                    next.subTitle = this.f39061i.getString(R.string.one_payment_global_enterprise_cash_tips);
                    next.titleStyle = 2;
                    next.subTitleStyle = 0;
                } else {
                    next.isEnabled = true;
                    next.subTitle = this.f39058f;
                    next.titleStyle = this.f39059g;
                    next.subTitleStyle = this.f39060h;
                }
            }
        }
    }

    public int getEnterpriseFlag() {
        return this.mView.getEnterpriseFlag();
    }

    public boolean hasAvailableCard() {
        PaySelPageData paySelPageData = this.f39054b;
        if (paySelPageData == null || CollectionUtil.isEmpty((Collection<?>) paySelPageData.payMethodList)) {
            return false;
        }
        for (PaySelItemData next : this.f39054b.payMethodList) {
            if (next.channelId == 150 && next.status == 1) {
                return true;
            }
        }
        return false;
    }

    public void postSelectedItemDelay(int i, String str) {
        this.f39056d = new RequestItem(i, str);
    }

    public int getCurrentSelectedChannelId() {
        PaySelPageData paySelPageData = this.f39054b;
        if (paySelPageData == null || CollectionUtil.isEmpty((Collection<?>) paySelPageData.payMethodList)) {
            return 0;
        }
        for (PaySelItemData next : this.f39054b.payMethodList) {
            if (next != null && next.isSelected) {
                return next.channelId;
            }
        }
        return 0;
    }

    public void setCombinePaymentStatus(boolean z) {
        this.mView.showProgressDialog("");
        this.mModel.setCombinePaymentStatus(z, new RpcService.Callback<BaseResult>() {
            public void onSuccess(BaseResult baseResult) {
                GlobalSelectPagePresenter.this.mView.dismissProgressDialog();
            }

            public void onFailure(IOException iOException) {
                GlobalSelectPagePresenter.this.mView.dismissProgressDialog();
            }
        });
    }
}
