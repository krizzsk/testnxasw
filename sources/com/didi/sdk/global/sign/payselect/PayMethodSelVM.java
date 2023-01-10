package com.didi.sdk.global.sign.payselect;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.base.Event;
import com.didi.sdk.global.base.p152ui.BaseVM;
import com.didi.sdk.global.sign.model.convert.SelectPageInfoRefresher;
import com.didi.sdk.global.sign.model.convert.SettingPageInfoConverter;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.model.local.PaySelPageData;
import com.didi.sdk.global.sign.model.server.PayMethodPageResponse;
import com.didi.sdk.global.sign.model.server.PayMethodRpcModel;
import com.didi.sdk.global.sign.payselect.utils.PayDataConverter;
import com.didi.sdk.global.sign.payselect.utils.PaySelRefresher;
import com.didi.sdk.global.sign.payselect.utils.PaySelUT;
import com.didi.sdk.global.sign.payselect.utils.PaySelUtils;
import com.didi.sdk.global.sign.presenter.PayMethodSelectAdapter;
import com.didi.sdk.global.sign.view.helper.PayMethodSelectHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002UVB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00101\u001a\u00020\u00112\u0006\u00102\u001a\u00020%J\"\u00103\u001a\u00020\u00112\b\u00104\u001a\u0004\u0018\u00010\u00072\u0006\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u000bH\u0002J\u0006\u00107\u001a\u00020\rJ\f\u00108\u001a\b\u0012\u0004\u0012\u00020%09J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020%09J\u0006\u0010;\u001a\u00020\u0014J\u0006\u0010<\u001a\u00020\u0014J\u0018\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u001d2\b\u0010?\u001a\u0004\u0018\u00010.J\b\u0010@\u001a\u00020\u0011H\u0016J\u0010\u0010A\u001a\u00020\u00112\u0006\u0010B\u001a\u00020%H\u0002J\u0010\u0010C\u001a\u00020\u00112\u0006\u00102\u001a\u00020%H\u0002J\u0010\u0010D\u001a\u00020\u00112\b\u0010E\u001a\u0004\u0018\u00010\u0007J\u0010\u0010D\u001a\u00020\u00112\b\u0010F\u001a\u0004\u0018\u00010GJ\u0018\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\r2\b\u00106\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010J\u001a\u00020\u0011J\u0016\u0010J\u001a\u00020\u00112\u0006\u0010I\u001a\u00020\r2\u0006\u00106\u001a\u00020\u000bJ\u000e\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020MJ \u0010N\u001a\u00020\u00112\u0006\u0010O\u001a\u00020\u00142\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010QH\u0002J\u001e\u0010R\u001a\u00020\u00142\u0006\u0010S\u001a\u00020%2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020%09H\u0002R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\tR\u001d\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\tR\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\tR\u001d\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\tR\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\t¨\u0006W"}, mo148868d2 = {"Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM;", "Lcom/didi/sdk/global/base/ui/BaseVM;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "bizDataLD", "Landroidx/lifecycle/MutableLiveData;", "Lcom/didi/sdk/global/sign/model/local/PaySelPageData;", "getBizDataLD", "()Landroidx/lifecycle/MutableLiveData;", "cashDesc", "", "cashDescStyle", "", "cashTitleStyle", "closePageEvent", "Lcom/didi/sdk/global/base/Event;", "", "getClosePageEvent", "hasRequestDataFromServer", "", "getHasRequestDataFromServer", "()Z", "setHasRequestDataFromServer", "(Z)V", "mModel", "Lcom/didi/sdk/global/sign/model/server/PayMethodRpcModel;", "mPageData", "mParam", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListParam;", "getMParam", "()Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListParam;", "setMParam", "(Lcom/didi/sdk/global/DidiGlobalPayMethodListData$PayMethodListParam;)V", "mRequestItem", "Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM$RequestItem;", "mockClkEvent", "Lcom/didi/sdk/global/sign/model/local/PaySelItemData;", "getMockClkEvent", "onClkArrowEvent", "getOnClkArrowEvent", "onClkSelectEvent", "getOnClkSelectEvent", "openH5Event", "getOpenH5Event", "payMethodSelectAdapter", "Lcom/didi/sdk/global/sign/presenter/PayMethodSelectAdapter;", "updatePaySelItemLD", "getUpdatePaySelItemLD", "doItemClick", "itemData", "doPayMethodPerformClick", "pageInfo", "selectChannel", "cardIndex", "getCurBalanceChannelId", "getSelectedPayMethod", "", "getSelectedPayMethodExactly", "hasAvailableCard", "hasSelectablePayMethod", "init", "param", "adapter", "loadData", "onClkSelect", "targetItem", "onClkSwitch", "onRequestSuccess", "pageData", "response", "Lcom/didi/sdk/global/sign/model/server/PayMethodPageResponse;", "refreshDataFromLocal", "channel", "refreshDataFromServer", "requestDataFromServer", "entrance", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$Entrance;", "setCombinePaymentStatus", "isSelect", "onFinish", "Lkotlin/Function0;", "updatePaySelItems", "clickItemInfo", "payMethodList", "DefaultPaySelectAdapter", "RequestItem", "payment_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayMethodSelVM.kt */
public final class PayMethodSelVM extends BaseVM {

    /* renamed from: a */
    private PayMethodSelectAdapter f38991a;

    /* renamed from: b */
    private PaySelPageData f38992b;

    /* renamed from: c */
    private String f38993c;

    /* renamed from: d */
    private int f38994d;

    /* renamed from: e */
    private int f38995e;

    /* renamed from: f */
    private final MutableLiveData<PaySelPageData> f38996f = new MutableLiveData<>();

    /* renamed from: g */
    private final MutableLiveData<Event<Unit>> f38997g = new MutableLiveData<>();

    /* renamed from: h */
    private final MutableLiveData<Event<PaySelItemData>> f38998h = new MutableLiveData<>();

    /* renamed from: i */
    private final MutableLiveData<Event<PaySelItemData>> f38999i = new MutableLiveData<>();

    /* renamed from: j */
    private final MutableLiveData<Event<PaySelItemData>> f39000j = new MutableLiveData<>();

    /* renamed from: k */
    private final MutableLiveData<Event<PaySelItemData>> f39001k = new MutableLiveData<>();

    /* renamed from: l */
    private final MutableLiveData<Event<Unit>> f39002l = new MutableLiveData<>();

    /* renamed from: m */
    private boolean f39003m;
    public DidiGlobalPayMethodListData.PayMethodListParam mParam;

    /* renamed from: n */
    private RequestItem f39004n;

    /* renamed from: o */
    private final PayMethodRpcModel f39005o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PayMethodSelVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f39005o = new PayMethodRpcModel(application);
    }

    public final DidiGlobalPayMethodListData.PayMethodListParam getMParam() {
        DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = this.mParam;
        if (payMethodListParam != null) {
            return payMethodListParam;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mParam");
        return null;
    }

    public final void setMParam(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam) {
        Intrinsics.checkNotNullParameter(payMethodListParam, "<set-?>");
        this.mParam = payMethodListParam;
    }

    public final MutableLiveData<PaySelPageData> getBizDataLD() {
        return this.f38996f;
    }

    public final MutableLiveData<Event<Unit>> getUpdatePaySelItemLD() {
        return this.f38997g;
    }

    public final MutableLiveData<Event<PaySelItemData>> getMockClkEvent() {
        return this.f38998h;
    }

    public final MutableLiveData<Event<PaySelItemData>> getOnClkArrowEvent() {
        return this.f38999i;
    }

    public final MutableLiveData<Event<PaySelItemData>> getOnClkSelectEvent() {
        return this.f39000j;
    }

    public final MutableLiveData<Event<PaySelItemData>> getOpenH5Event() {
        return this.f39001k;
    }

    public final MutableLiveData<Event<Unit>> getClosePageEvent() {
        return this.f39002l;
    }

    public final boolean getHasRequestDataFromServer() {
        return this.f39003m;
    }

    public final void setHasRequestDataFromServer(boolean z) {
        this.f39003m = z;
    }

    public void loadData() {
        List<PaySelItemData> list;
        if (getMParam() == null) {
            isNetErrorLD().setValue(true);
            return;
        }
        PaySelPageData convert = PayDataConverter.convert(getMParam());
        this.f38992b = convert;
        boolean z = false;
        if (!(convert == null || (list = convert.payMethodList) == null)) {
            z = !list.isEmpty();
        }
        isNetErrorLD().setValue(Boolean.valueOf(!z));
        if (z) {
            this.f38996f.setValue(this.f38992b);
        }
    }

    public final void init(DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam, PayMethodSelectAdapter payMethodSelectAdapter) {
        Intrinsics.checkNotNullParameter(payMethodListParam, "param");
        setMParam(payMethodListParam);
        this.f38991a = payMethodSelectAdapter;
        if (payMethodSelectAdapter == null) {
            Application application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "getApplication()");
            this.f38991a = new DefaultPaySelectAdapter(this, application);
        }
        PayMethodSelectAdapter payMethodSelectAdapter2 = this.f38991a;
        Intrinsics.checkNotNull(payMethodSelectAdapter2);
        payMethodSelectAdapter2.setObserver(new PayMethodSelVM$init$1(this));
    }

    public final List<PaySelItemData> getSelectedPayMethod() {
        ArrayList arrayList = new ArrayList();
        PaySelPageData paySelPageData = this.f38992b;
        List<PaySelItemData> list = paySelPageData == null ? null : paySelPageData.payMethodList;
        if (list == null) {
            return arrayList;
        }
        for (PaySelItemData paySelItemData : list) {
            if (paySelItemData.isSelected) {
                arrayList.add(paySelItemData);
            }
        }
        return arrayList;
    }

    public final List<PaySelItemData> getSelectedPayMethodExactly() {
        ArrayList arrayList = new ArrayList();
        PaySelPageData paySelPageData = this.f38992b;
        List<PaySelItemData> list = paySelPageData == null ? null : paySelPageData.payMethodList;
        if (list == null) {
            return arrayList;
        }
        if (list.isEmpty()) {
            return arrayList;
        }
        for (PaySelItemData paySelItemData : list) {
            if (paySelItemData.isSelected && paySelItemData.isEnabled && !paySelItemData.isFrozen) {
                arrayList.add(paySelItemData);
            }
        }
        return arrayList;
    }

    public final boolean hasSelectablePayMethod() {
        PaySelPageData paySelPageData = this.f38992b;
        List<PaySelItemData> list = paySelPageData == null ? null : paySelPageData.payMethodList;
        if (list != null && list.isEmpty()) {
        }
        return false;
    }

    public final void doItemClick(PaySelItemData paySelItemData) {
        Intrinsics.checkNotNullParameter(paySelItemData, "itemData");
        int i = paySelItemData.style;
        if (i == 1) {
            m29353a(paySelItemData);
        } else if (i == 2) {
            this.f38999i.setValue(new Event(paySelItemData));
        } else if (i == 3) {
            m29357b(paySelItemData);
        }
    }

    /* renamed from: a */
    private final void m29353a(PaySelItemData paySelItemData) {
        if (TextUtils.isEmpty(paySelItemData.guideH5Url) || PaySharedPreferencesUtil.isNewPayChannelGuideH5Shown(getApplication(), paySelItemData.channelId)) {
            PaySelPageData paySelPageData = this.f38992b;
            Intrinsics.checkNotNull(paySelPageData);
            List<PaySelItemData> list = paySelPageData.payMethodList;
            if (list != null) {
                boolean a = m29356a(paySelItemData, (List<? extends PaySelItemData>) list);
                this.f38997g.setValue(new Event(Unit.INSTANCE));
                if (a) {
                    m29355a(false, (Function0<Unit>) new PayMethodSelVM$onClkSelect$1(this, paySelItemData));
                } else {
                    this.f39000j.setValue(new Event(paySelItemData));
                }
            }
        } else {
            PaySharedPreferencesUtil.setNewPayChannelGuideH5Shown(getApplication(), paySelItemData.channelId, true);
            this.f39001k.setValue(new Event(paySelItemData));
        }
    }

    /* renamed from: a */
    private final boolean m29356a(PaySelItemData paySelItemData, List<? extends PaySelItemData> list) {
        boolean z = false;
        for (PaySelItemData paySelItemData2 : list) {
            if (PaySelUtils.INSTANCE.isSameChannel(paySelItemData2, paySelItemData)) {
                paySelItemData2.isSelected = true;
            } else if (!PayMethodSelectHelper.canCombine(paySelItemData2, paySelItemData)) {
                if (PaySelUtils.INSTANCE.isBalanceCombinedMode(paySelItemData2) && paySelItemData2.isSelected && paySelItemData2.isEnabled) {
                    z = true;
                }
                paySelItemData2.isSelected = false;
            } else if (190 == paySelItemData2.channelId && !paySelItemData2.isHit99payCombination) {
                paySelItemData2.isSelected = false;
            }
        }
        return z;
    }

    /* renamed from: b */
    private final void m29357b(PaySelItemData paySelItemData) {
        PaySelPageData paySelPageData = this.f38992b;
        Intrinsics.checkNotNull(paySelPageData);
        PayMethodSelectHelper.SwitchResult doSwitchEventV2 = PayMethodSelectHelper.doSwitchEventV2(paySelItemData, paySelPageData.payMethodList);
        if (doSwitchEventV2 != PayMethodSelectHelper.SwitchResult.SUCCESS) {
            ToastHelper.showLongInfo((Context) getApplication(), PayMethodSelectHelper.getSwitchErrorMessage(getApplication(), doSwitchEventV2), (int) R.drawable.pay_toast_error);
            return;
        }
        this.f38997g.setValue(new Event(Unit.INSTANCE));
        if (PaySelUtils.INSTANCE.isBalanceCombinedMode(paySelItemData)) {
            m29355a(paySelItemData.isSelected, (Function0<Unit>) null);
        }
        PaySelUT paySelUT = PaySelUT.INSTANCE;
        boolean z = paySelItemData.isSelected;
        String str = paySelItemData.logData;
        List<String> list = paySelItemData.cardDiscountTags;
        Intrinsics.checkNotNullExpressionValue(list, "itemData.cardDiscountTags");
        paySelUT.trackSwitchBtn(z, str, list);
    }

    public final boolean hasAvailableCard() {
        PaySelPageData paySelPageData = this.f38992b;
        if (paySelPageData == null || CollectionUtil.isEmpty((Collection<?>) paySelPageData.payMethodList)) {
            return false;
        }
        for (PaySelItemData next : paySelPageData.payMethodList) {
            if (next.channelId == 150 && next.status == 1) {
                return true;
            }
        }
        return false;
    }

    public final void onRequestSuccess(PaySelPageData paySelPageData) {
        List<PaySelItemData> list;
        if (paySelPageData != null) {
            this.f39003m = true;
            this.f38992b = paySelPageData;
            boolean z = false;
            if (!(paySelPageData == null || (list = paySelPageData.payMethodList) == null)) {
                z = !list.isEmpty();
            }
            isNetErrorLD().setValue(Boolean.valueOf(!z));
            if (z) {
                MutableLiveData<PaySelPageData> mutableLiveData = this.f38996f;
                PaySelPageData paySelPageData2 = this.f38992b;
                Intrinsics.checkNotNull(paySelPageData2);
                mutableLiveData.setValue(paySelPageData2);
            }
            RequestItem requestItem = this.f39004n;
            if (requestItem != null && z) {
                PaySelPageData paySelPageData3 = this.f38992b;
                Intrinsics.checkNotNull(requestItem);
                int channelId = requestItem.getChannelId();
                RequestItem requestItem2 = this.f39004n;
                Intrinsics.checkNotNull(requestItem2);
                m29354a(paySelPageData3, channelId, requestItem2.getCardIndex());
            }
        }
    }

    public final void onRequestSuccess(PayMethodPageResponse payMethodPageResponse) {
        RequestItem requestItem;
        PaySelPageData paySelPageData = this.f38992b;
        if (paySelPageData == null || (requestItem = this.f39004n) == null) {
            PaySelPageData convert = SettingPageInfoConverter.convert(payMethodPageResponse);
            this.f38992b = convert;
            this.f38996f.setValue(convert);
            return;
        }
        Intrinsics.checkNotNull(requestItem);
        int channelId = requestItem.getChannelId();
        RequestItem requestItem2 = this.f39004n;
        Intrinsics.checkNotNull(requestItem2);
        if (SelectPageInfoRefresher.refresh(paySelPageData, payMethodPageResponse, channelId, requestItem2.getCardIndex())) {
            this.f38996f.setValue(this.f38992b);
            PaySelPageData paySelPageData2 = this.f38992b;
            RequestItem requestItem3 = this.f39004n;
            Intrinsics.checkNotNull(requestItem3);
            int channelId2 = requestItem3.getChannelId();
            RequestItem requestItem4 = this.f39004n;
            Intrinsics.checkNotNull(requestItem4);
            m29354a(paySelPageData2, channelId2, requestItem4.getCardIndex());
        }
    }

    /* renamed from: a */
    private final void m29354a(PaySelPageData paySelPageData, int i, String str) {
        PaySelItemData next;
        PaySelItemData paySelItemData = null;
        if ((paySelPageData == null ? null : paySelPageData.payMethodList) != null && paySelPageData.payMethodList.size() != 0 && i != -1) {
            boolean z = false;
            Iterator<PaySelItemData> it = paySelPageData.payMethodList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
                if (next != null) {
                    if (next.channelId == 150) {
                        if (!TextUtils.isEmpty(next.cardIndex) && Intrinsics.areEqual((Object) next.cardIndex, (Object) str)) {
                            break;
                        }
                    } else if (next.channelId == i) {
                        break;
                    }
                }
            }
            paySelItemData = next;
            if (paySelItemData != null) {
                if ((paySelItemData.channelId != 190 && paySelItemData.channelId != 120) || ((paySelItemData.style != 3 || !paySelItemData.isSelected) && !PaySelUtils.INSTANCE.canShowTopUpBtn(paySelItemData))) {
                    if (paySelItemData.channelId != 150 ? !(paySelItemData.channelId == 190 || paySelItemData.channelId == 120 ? !paySelItemData.isEnabled || paySelItemData.status != 1 || !paySelItemData.isSufficient : !paySelItemData.isEnabled || paySelItemData.status != 1) : paySelItemData.status == 1) {
                        z = true;
                    }
                    if (z) {
                        this.f38998h.setValue(new Event(paySelItemData));
                    }
                }
            }
        }
    }

    public final void refreshDataFromServer(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "cardIndex");
        RequestItem requestItem = new RequestItem(i, str);
        this.f39004n = requestItem;
        SystemUtils.log(3, "wallet", Intrinsics.stringPlus("Refresh data from server for item: ", requestItem), (Throwable) null, "com.didi.sdk.global.sign.payselect.PayMethodSelVM", 385);
        DidiGlobalPayMethodListData.Entrance entrance = getMParam().from;
        Intrinsics.checkNotNullExpressionValue(entrance, "mParam.from");
        requestDataFromServer(entrance);
    }

    public final void refreshDataFromServer() {
        this.f39004n = null;
        DidiGlobalPayMethodListData.Entrance entrance = getMParam().from;
        Intrinsics.checkNotNullExpressionValue(entrance, "mParam.from");
        requestDataFromServer(entrance);
    }

    public final void requestDataFromServer(DidiGlobalPayMethodListData.Entrance entrance) {
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        isLoadingLD().setValue(true);
        PayMethodSelectAdapter payMethodSelectAdapter = this.f38991a;
        if (payMethodSelectAdapter != null) {
            payMethodSelectAdapter.refreshPayMethodList(entrance);
        }
    }

    public final void refreshDataFromLocal(int i, String str) {
        PaySelRefresher.refreshPayMethodStatus(this.f38992b, i, str);
        if (i == 121) {
            PaySelPageData paySelPageData = this.f38992b;
            Intrinsics.checkNotNull(paySelPageData);
            List<PaySelItemData> list = paySelPageData.payMethodList;
            if (list != null) {
                PaySelItemData paySelItemData = null;
                Iterator<PaySelItemData> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    PaySelItemData next = it.next();
                    if (next.channelId == 121) {
                        paySelItemData = next;
                        break;
                    }
                }
                if (paySelItemData != null) {
                    boolean a = m29356a(paySelItemData, (List<? extends PaySelItemData>) list);
                    this.f38997g.setValue(new Event(Unit.INSTANCE));
                    if (a) {
                        m29355a(false, (Function0<Unit>) new PayMethodSelVM$refreshDataFromLocal$1(this));
                    } else {
                        this.f39002l.setValue(new Event(Unit.INSTANCE));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private final void m29355a(boolean z, Function0<Unit> function0) {
        isLoadingLD().setValue(true);
        this.f39005o.setCombinePaymentStatus(z, new PayMethodSelVM$setCombinePaymentStatus$1(this, function0));
    }

    public final int getCurBalanceChannelId() {
        PaySelPageData paySelPageData = this.f38992b;
        List<PaySelItemData> list = paySelPageData == null ? null : paySelPageData.payMethodList;
        if (list == null) {
            return 190;
        }
        for (PaySelItemData paySelItemData : list) {
            if (paySelItemData.channelId == 190) {
                return 190;
            }
            if (paySelItemData.channelId == 120) {
                return 120;
            }
        }
        return 190;
    }

    @Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM$DefaultPaySelectAdapter;", "Lcom/didi/sdk/global/sign/presenter/PayMethodSelectAdapter;", "application", "Landroid/app/Application;", "(Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM;Landroid/app/Application;)V", "mModel", "Lcom/didi/sdk/global/sign/model/server/PayMethodRpcModel;", "refreshPayMethodList", "", "from", "Lcom/didi/sdk/global/DidiGlobalPayMethodListData$Entrance;", "payment_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PayMethodSelVM.kt */
    public final class DefaultPaySelectAdapter extends PayMethodSelectAdapter {
        private PayMethodRpcModel mModel;
        final /* synthetic */ PayMethodSelVM this$0;

        public DefaultPaySelectAdapter(PayMethodSelVM payMethodSelVM, Application application) {
            Intrinsics.checkNotNullParameter(payMethodSelVM, "this$0");
            Intrinsics.checkNotNullParameter(application, "application");
            this.this$0 = payMethodSelVM;
            this.mModel = new PayMethodRpcModel(application);
        }

        public void refreshPayMethodList(DidiGlobalPayMethodListData.Entrance entrance) {
            Intrinsics.checkNotNullParameter(entrance, "from");
            this.mModel.requestPayMethodList(new PayMethodSelVM$DefaultPaySelectAdapter$refreshPayMethodList$1(this.this$0, this));
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, mo148868d2 = {"Lcom/didi/sdk/global/sign/payselect/PayMethodSelVM$RequestItem;", "", "channelId", "", "cardIndex", "", "(ILjava/lang/String;)V", "getCardIndex", "()Ljava/lang/String;", "setCardIndex", "(Ljava/lang/String;)V", "getChannelId", "()I", "setChannelId", "(I)V", "payment_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: PayMethodSelVM.kt */
    private static final class RequestItem {
        private String cardIndex;
        private int channelId;

        public RequestItem(int i, String str) {
            Intrinsics.checkNotNullParameter(str, "cardIndex");
            this.channelId = i;
            this.cardIndex = str;
        }

        public final String getCardIndex() {
            return this.cardIndex;
        }

        public final int getChannelId() {
            return this.channelId;
        }

        public final void setCardIndex(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.cardIndex = str;
        }

        public final void setChannelId(int i) {
            this.channelId = i;
        }
    }
}
