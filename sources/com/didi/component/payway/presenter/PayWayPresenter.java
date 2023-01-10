package com.didi.component.payway.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.router.PayRouterHandler;
import com.didi.component.common.util.DateConverUtils;
import com.didi.component.common.util.GlobalTipsPriorityManager;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.common.widget.NewBubbleHelper;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.payway.callback.NewPopShowResultListener;
import com.didi.component.payway.view.IPayWayView;
import com.didi.drouter.api.DRouter;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.sdk.global.DidiGlobalCardExpireInterceptData;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didi.sdk.global.common.com.EnterpriseInfo;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.datasource.BubbleSourceManager;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class PayWayPresenter extends AbsPayWayPresenter {

    /* renamed from: a */
    private static final int f17020a = 2;

    /* renamed from: b */
    private static final int f17021b = 3;

    /* renamed from: c */
    private static final int f17022c = 1;

    /* renamed from: d */
    private static final int f17023d = 1100;

    /* renamed from: e */
    private static final int f17024e = 3;

    /* renamed from: f */
    private static final int f17025f = 1101;
    public EnterpriseInfo enterpriseInfo;

    /* renamed from: g */
    private PayWayHelper f17026g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f17027h = false;

    /* renamed from: i */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17028i = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!PayWayPresenter.this.m14281e()) {
                ((IPayWayView) PayWayPresenter.this.mView).dismissPopup();
            }
        }
    };

    /* renamed from: j */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17029j = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!PayWayPresenter.this.m14281e()) {
                EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
                if (PayWayPresenter.this.f17027h && !PayWayPresenter.this.showGuidePopup()) {
                    PayWayPresenter.this.showPayWayGuideIfNeed(estimateItem);
                }
            }
        }
    };

    /* renamed from: k */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17030k = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!PayWayPresenter.this.m14281e()) {
                ((IPayWayView) PayWayPresenter.this.mView).dismissPopup();
            }
        }
    };

    /* renamed from: l */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17031l = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!PayWayPresenter.this.m14281e()) {
                boolean unused = PayWayPresenter.this.f17027h = true;
                EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
                if (!PayWayPresenter.this.showGuidePopup()) {
                    PayWayPresenter.this.showPayWayGuideIfNeed(estimateItem);
                }
            }
        }
    };

    /* renamed from: m */
    private BaseEventPublisher.OnEventListener<PayRouterHandler.PayRouterModel> f17032m = new BaseEventPublisher.OnEventListener<PayRouterHandler.PayRouterModel>() {
        public void onEvent(String str, PayRouterHandler.PayRouterModel payRouterModel) {
            PayRouterHandler.PayInfo payInfo;
            List<PayWayModel.PayWayItem> payWayItem;
            if (PayWayPresenter.this.m14281e() || payRouterModel == null || TextUtils.isEmpty(payRouterModel.actionType) || (payInfo = payRouterModel.payInfo) == null) {
                return;
            }
            if ("1".equals(payRouterModel.actionType)) {
                if (payInfo.resourceId != 0) {
                    DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                    addCardParam.bindType = 8;
                    addCardParam.isShowLoading = true;
                    addCardParam.isSignAfterOrder = false;
                    addCardParam.resourceId = String.valueOf(payInfo.resourceId);
                    addCardParam.discountContent = payInfo.toAddCardInfo;
                    DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(PayWayPresenter.this.getHost(), PayWayPresenter.this.requestCodeForHost(1), addCardParam);
                    boolean unused = PayWayPresenter.this.f17033n = true;
                }
            } else if ("2".equals(payRouterModel.actionType)) {
                if (payInfo.resourceId != 0) {
                    PayWayPresenter.this.onFormPayWayClicked(String.valueOf(payInfo.resourceId));
                }
            } else if ("3".equals(payRouterModel.actionType) && payInfo.payTag != 0 && (payWayItem = PayWayPresenter.this.getPayWayItem(payInfo.payTag)) != null && !payWayItem.isEmpty()) {
                PayWayPresenter.this.setPayWayToForm(payWayItem);
                PayWayPresenter.this.doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }
    };
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    protected List<PayWayModel.PayWayItem> mPaywayItems;
    public List<PayWayModel.PayWayItem> mSelectedPaywayItem = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f17033n = false;

    /* renamed from: p */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17034p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!PayWayPresenter.this.m14281e()) {
                ((IPayWayView) PayWayPresenter.this.mView).dismissPopup();
            }
        }
    };

    /* renamed from: q */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17035q = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!PayWayPresenter.this.m14281e() && TextUtils.equals(BaseEventKeys.Confirm.SHOW_PAYMENTS, str)) {
                PayWayPresenter.this.onFormPayWayClicked();
            }
        }
    };

    /* renamed from: r */
    private BaseEventPublisher.OnEventListener<Boolean> f17036r = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (!PayWayPresenter.this.m14281e() && TextUtils.equals(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, str)) {
                PayWayPresenter.this.refreshPayWay(bool.booleanValue());
            }
        }
    };

    /* renamed from: s */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f17037s = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                ((IPayWayView) PayWayPresenter.this.mView).dismissPopup();
                ((IPayWayView) PayWayPresenter.this.mView).hide();
            }
        }
    };
    public DidiGlobalPayMethodListData.PayMethodListResult selectedResults;

    /* renamed from: t */
    private BaseEventPublisher.OnEventListener<PayWayModel.PayWayItem> f17038t = new BaseEventPublisher.OnEventListener<PayWayModel.PayWayItem>() {
        public void onEvent(String str, final PayWayModel.PayWayItem payWayItem) {
            if (!PayWayPresenter.this.m14281e() && payWayItem != null) {
                DidiGlobalCardExpireInterceptData.CardExpireInterceptParam cardExpireInterceptParam = new DidiGlobalCardExpireInterceptData.CardExpireInterceptParam();
                cardExpireInterceptParam.cardNo = payWayItem.getCard();
                cardExpireInterceptParam.icon = payWayItem.getIconUrl();
                cardExpireInterceptParam.type = 0;
                DidiGlobalPayApiFactory.createDidiPay().startCardExpireIntercept(PayWayPresenter.this.getHost(), cardExpireInterceptParam, (DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback) new DidiGlobalCardExpireInterceptData.CardExpireInterceptCallback() {
                    public void onClick(int i) {
                        if (i == 0) {
                            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                            addCardParam.bindType = 8;
                            addCardParam.isShowLoading = true;
                            addCardParam.isSignAfterOrder = false;
                            addCardParam.cardNo = payWayItem.getCard();
                            addCardParam.resourceId = "74";
                            DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(PayWayPresenter.this.getHost(), PayWayPresenter.this.requestCodeForHost(1), addCardParam);
                            return;
                        }
                        PayWayPresenter.this.onFormPayWayClicked();
                    }
                });
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final HashSet<String> f17039u = new HashSet<>();

    /* renamed from: v */
    private Runnable f17040v;

    /* renamed from: a */
    private String m14265a(EnterpriseInfo enterpriseInfo2) {
        return null;
    }

    /* renamed from: f */
    private EnterpriseInfo m14283f() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void checkPaywayDialog(List<PayWayModel.PayWayItem> list) {
    }

    public void onPayWayCloseClicked(int i, int i2) {
    }

    public void onPayWayGuideClicked(int i, int i2) {
    }

    public PayWayPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        ((IPayWayView) this.mView).setContentDescription("");
        this.f17039u.clear();
        m14276c();
        m14273b();
    }

    /* renamed from: b */
    private void m14273b() {
        this.mSelectedPaywayItem = FormStore.getInstance().getPayWaySelectedItem();
        this.enterpriseInfo = null;
        ((IPayWayView) this.mView).setLabel(this.mSelectedPaywayItem, (String) null);
    }

    /* access modifiers changed from: protected */
    public List<PayWayModel.PayWayItem> getSelectItems(PayWayModel.PayWayItem payWayItem) {
        if (payWayItem == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(payWayItem);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public String getSelectItemsDesc(List<PayWayModel.PayWayItem> list) {
        if (list == null || list.isEmpty()) {
            return this.mContext.getString(R.string.pay_way_title);
        }
        StringBuilder sb = new StringBuilder();
        for (PayWayModel.PayWayItem next : list) {
            if (next != null) {
                sb.append(this.mContext.getResources().getString(R.string.pay_way_selected_desc));
                if (next.channelID == 150) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_via_app_desc));
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_card_ending_desc));
                    sb.append(next.card);
                } else if (next.channelID == 154) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_pos_terminal_desc));
                } else if (next.channelID == 121) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_for_desc, new Object[]{next.text}));
                } else if (next.channelID == 153) {
                    sb.append(next.title);
                } else if (next.channelID == 152 || next.channelID == 183) {
                    sb.append(next.title);
                } else {
                    sb.append(next.title);
                }
                if (next.hasCoupon) {
                    sb.append(this.mContext.getResources().getString(R.string.pay_way_with_discount_desc));
                }
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        m14279d();
        ((IPayWayView) this.mView).dismissPopup();
    }

    /* renamed from: c */
    private void m14276c() {
        subscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f17034p);
        subscribe(BaseEventKeys.Confirm.SHOW_PAYMENTS, this.f17035q);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f17036r);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f17037s);
        subscribe("event_show_sug_page_container", this.f17028i);
        subscribe("event_hide_sug_page_container", this.f17029j);
        subscribe(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED, this.f17030k);
        subscribe(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP, this.f17030k);
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_CARD_EXPIRED_INTERCEPT, this.f17038t);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f17031l);
        subscribe(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_PAYMENT_ACTION, this.f17032m);
    }

    /* renamed from: d */
    private void m14279d() {
        unsubscribe(BaseEventKeys.Confirm.EVENT_SHOW_CONFIRM_ADDRESS, this.f17034p);
        unsubscribe(BaseEventKeys.Confirm.SHOW_PAYMENTS, this.f17035q);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f17036r);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f17037s);
        unsubscribe("event_show_sug_page_container", this.f17028i);
        unsubscribe("event_hide_sug_page_container", this.f17029j);
        unsubscribe(BaseEventKeys.Confirm.EVENT_BOTTOM_FORM_HINTED, this.f17030k);
        unsubscribe(BaseEventKeys.Confirm.EVENT_HIDE_PAY_POPUP, this.f17030k);
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_CARD_EXPIRED_INTERCEPT, this.f17038t);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_COMPONENT_SHOWN, this.f17031l);
        unsubscribe(BaseEventKeys.Estimate.EVENT_PREORDER_INTERCEPT_PAYMENT_ACTION, this.f17032m);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m14281e() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        return confirmListener != null && confirmListener.getIsAnyCar();
    }

    /* access modifiers changed from: protected */
    public void refreshPayWay(boolean z) {
        this.mSelectedPaywayItem.clear();
        ((IPayWayView) this.mView).show();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.userpayUnavailable != 1) {
            ((IPayWayView) this.mView).setClickable(true);
        } else {
            ((IPayWayView) this.mView).setClickable(false);
        }
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        this.mSelectedPaywayItem.clear();
        if (estimateItem == null) {
            ((IPayWayView) this.mView).setLabel((List<PayWayModel.PayWayItem>) null, (String) null);
            ((IPayWayView) this.mView).changeEnableColor(false);
            return;
        }
        this.enterpriseInfo = null;
        if (estimateItem.payWayList != null) {
            int size = estimateItem.payWayList.size();
            for (int i = 0; i < size; i++) {
                PayWayModel.PayWayItem payWayItem = estimateItem.payWayList.get(i);
                if (1 == payWayItem.isSelected()) {
                    this.mSelectedPaywayItem.add(payWayItem);
                }
            }
        }
        ((IPayWayView) this.mView).dismissPopup();
        if (z && !showGuidePopup()) {
            showPayWayGuideIfNeed(estimateItem);
        }
        checkPaywayDialog(this.mSelectedPaywayItem);
        if (z) {
            checkCashLimit(this.mSelectedPaywayItem);
        }
        setPayWayToForm(this.mSelectedPaywayItem);
        setEnterpriseInfoToForm((EnterpriseInfo) null);
        this.mPaywayItems = estimateItem.payWayList;
        ((IPayWayView) this.mView).setLabel(this.mSelectedPaywayItem, (String) null);
        ((IPayWayView) this.mView).setContentDescription(getSelectItemsDesc(this.mSelectedPaywayItem));
        ((IPayWayView) this.mView).hideLoading();
    }

    /* renamed from: a */
    private boolean m14270a(boolean z) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carBubbleModule == null)) {
            BubbleSourceManager bubbleSourceManager = new BubbleSourceManager(this.mContext);
            bubbleSourceManager.setmIsJapan(z);
            final BubbleItemModel bubble = bubbleSourceManager.getBubble(1, newEstimateItem.carBubbleModule, false);
            if (bubble != null) {
                ((IPayWayView) this.mView).showNewPopup(bubble, new NewPopShowResultListener() {
                    public void success(NewBubbleHelper newBubbleHelper) {
                        if (PayWayPresenter.this.f17039u.add(bubble.bubbleId)) {
                            newBubbleHelper.trackEvent(true);
                        }
                    }
                });
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean showPayWayGuideIfNeed(EstimateItem estimateItem) {
        if (this.mRemoved || estimateItem == null || isDialogShowing() || FormStore.getInstance().isShowingPopupCompoent() || CollectionUtil.isEmpty((Collection<?>) estimateItem.payWayList)) {
            return false;
        }
        return m14270a(false);
    }

    public void onNewPayWayGuideClicked(BubbleItemModel bubbleItemModel) {
        List<PayWayModel.PayWayItem> payWayItem;
        ((IPayWayView) this.mView).dismissPopup();
        if (bubbleItemModel != null && bubbleItemModel.actionEvent != null) {
            int i = bubbleItemModel.actionEvent.eventType;
            if (i != 1) {
                if (i == 2) {
                    onFormPayWayClicked();
                } else if (i == 3) {
                    DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
                    addCardParam.bindType = 8;
                    addCardParam.isShowLoading = true;
                    addCardParam.isSignAfterOrder = false;
                    addCardParam.resourceId = "75";
                    DidiGlobalPayApiFactory.createDidiPay().startAddCreditCardActivity(getHost(), requestCodeForHost(1), addCardParam);
                } else if (i == 4 && bubbleItemModel.actionEvent.paramsModel != null) {
                    DRouter.build(bubbleItemModel.actionEvent.paramsModel.scheme).start(this.mContext);
                }
            } else if (bubbleItemModel.actionEvent.paramsModel != null && (payWayItem = getPayWayItem(bubbleItemModel.actionEvent.paramsModel.payTag)) != null && !payWayItem.isEmpty()) {
                setPayWayToForm(payWayItem);
                doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<PayWayModel.PayWayItem> getPayWayItem(int i) {
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        ArrayList arrayList = new ArrayList();
        List<PayWayModel.PayWayItem> list = estimateItem.payWayList;
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            return arrayList;
        }
        for (PayWayModel.PayWayItem next : list) {
            if ((next.getTag() & i) > 0) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void onBindCardResult(int i, Intent intent) {
        if (i == -1) {
            String stringExtra = intent.getStringExtra("card_index");
            if (TextUtil.isEmpty(stringExtra)) {
                FormStore.getInstance().setSkipEstimateGet(true);
                return;
            }
            PayWayModel.PayWayItem payWayItem = new PayWayModel.PayWayItem();
            payWayItem.tag = 256;
            payWayItem.cardIndex = stringExtra;
            ArrayList arrayList = new ArrayList();
            arrayList.add(payWayItem);
            setPayWayToForm(arrayList);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        } else if (this.f17033n) {
            this.f17033n = false;
        } else {
            FormStore.getInstance().setSkipEstimateGet(true);
        }
    }

    /* access modifiers changed from: protected */
    public void checkCashLimit(List<PayWayModel.PayWayItem> list) {
        if (list != null) {
            for (PayWayModel.PayWayItem next : list) {
                if (String.valueOf(1024).equals(FormStore.getInstance().getPayWay())) {
                    if (next == null) {
                        m14267a(this.mContext.getResources().getString(R.string.pay_way_crash_limit_tips_null));
                    } else if (next.getTag() == 256) {
                        m14270a(true);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m14267a(String str) {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(1100);
        normalDialogInfo.setCancelable(true);
        normalDialogInfo.setMessage(str);
        normalDialogInfo.setPositiveText(this.mContext.getResources().getString(R.string.pay_way_crash_limit_tips_confirm));
        showDialog(normalDialogInfo);
        GlobalOmegaUtils.trackEvent("pas_orderconfirm_casharea_sw");
    }

    /* access modifiers changed from: protected */
    public void setPayWayToForm(List<PayWayModel.PayWayItem> list) {
        FormStore.getInstance().setPayWaySelectedItem(list);
        if (list == null || list.isEmpty()) {
            FormStore.getInstance().setPayWay("");
            FormStore.getInstance().setPayWayMsg("");
            return;
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (PayWayModel.PayWayItem next : list) {
            if (next != null) {
                i |= next.tag;
                sb.append(next.getLabel());
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        FormStore instance = FormStore.getInstance();
        instance.setPayWay(i + "");
        FormStore.getInstance().setPayWayMsg(sb.toString());
    }

    /* access modifiers changed from: protected */
    public void setEnterpriseInfoToForm(EnterpriseInfo enterpriseInfo2) {
        if (enterpriseInfo2 == null) {
            FormStore.getInstance().setEnterpriseFlag(1);
        } else {
            FormStore.getInstance().setEnterpriseFlag(enterpriseInfo2.flag);
        }
    }

    public void onFormPayWayClicked() {
        ((IPayWayView) this.mView).dismissPopup();
        if (!NationComponentDataUtil.isLoginNow()) {
            NationComponentDataUtil.goToLoginPageForResult(getHost(), requestCodeForHost(2));
            return;
        }
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        if (estimateItem == null) {
            ToastHelper.showShortInfo(this.mContext, (int) R.string.pay_way_estimate_fail);
        } else if (!isInterceptNoPayWay(this.mPaywayItems).booleanValue()) {
            if (this.f17026g == null) {
                this.f17026g = new PayWayHelper();
            }
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
            payMethodListParam.list = DateConverUtils.converPayMethodInfoList(this.mPaywayItems);
            payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(estimateItem.payGroupList);
            payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(estimateItem.payCfgInfo);
            payMethodListParam.resourceId = "4";
            payMethodListParam.enterpriseInfo = null;
            payMethodListParam.resourceId = "4";
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity(getHost(), requestCodeForHost(3), payMethodListParam, this.f17026g.getPayMethodAdapter());
            this.mLogger.info("Click pay way", new Object[0]);
        }
    }

    public void onFormPayWayClicked(String str) {
        ((IPayWayView) this.mView).dismissPopup();
        if (!NationComponentDataUtil.isLoginNow()) {
            NationComponentDataUtil.goToLoginPageForResult(getHost(), requestCodeForHost(2));
            return;
        }
        EstimateItem estimateItem = FormStore.getInstance().getEstimateItem();
        if (estimateItem == null) {
            ToastHelper.showShortInfo(this.mContext, (int) R.string.pay_way_estimate_fail);
        } else if (!isInterceptNoPayWay(this.mPaywayItems).booleanValue()) {
            if (this.f17026g == null) {
                this.f17026g = new PayWayHelper();
            }
            DidiGlobalPayMethodListData.PayMethodListParam payMethodListParam = new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_PAY_ESTIMATION);
            payMethodListParam.list = DateConverUtils.converPayMethodInfoList(this.mPaywayItems);
            payMethodListParam.groupList = DateConverUtils.convertPayGroupInfoList(estimateItem.payGroupList);
            payMethodListParam.configInfo = DateConverUtils.convertPayPopupInfo(estimateItem.payCfgInfo);
            payMethodListParam.resourceId = str;
            payMethodListParam.enterpriseInfo = null;
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity(getHost(), requestCodeForHost(3), payMethodListParam, this.f17026g.getPayMethodAdapter());
            this.mLogger.info("Click pay way", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public Boolean isInterceptNoPayWay(List<PayWayModel.PayWayItem> list) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        OmegaSDK.putGlobalAttr("g_PageId", GPageIdConstant.G_PAGE_ID_CONF);
        if (2 == i && -1 == i2) {
            setPayWayToForm(this.mSelectedPaywayItem);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        } else if (3 == i && intent != null && -1 == i2) {
            m14274b((DidiGlobalPayMethodListData.PayMethodListResult) intent.getSerializableExtra("pay_method_list_result"));
        } else if (1 == i) {
            onBindCardResult(i2, intent);
        }
    }

    /* renamed from: a */
    private PayWayModel.PayWayItem m14264a(DidiGlobalPayMethodListData.SelectedPayMethod selectedPayMethod) {
        List<PayWayModel.PayWayItem> list;
        if (selectedPayMethod == null || selectedPayMethod.channelId <= 0 || (list = this.mPaywayItems) == null) {
            return null;
        }
        for (PayWayModel.PayWayItem next : list) {
            if (next.channelID == selectedPayMethod.channelId) {
                next.cardIndex = selectedPayMethod.cardIndex;
                next.card = selectedPayMethod.cardNo;
                if (!TextUtils.isEmpty(selectedPayMethod.iconUrl)) {
                    next.card_org = selectedPayMethod.iconUrl;
                }
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private List<PayWayModel.PayWayItem> m14266a(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        ArrayList arrayList = new ArrayList();
        if (!(payMethodListResult == null || payMethodListResult.selectedPayMethods == null)) {
            for (DidiGlobalPayMethodListData.SelectedPayMethod a : payMethodListResult.selectedPayMethods) {
                PayWayModel.PayWayItem a2 = m14264a(a);
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i == 1100 && i2 == 2) {
            if (this.mSelectedPaywayItem == null && ((IPayWayView) this.mView).isClickable()) {
                onFormPayWayClicked();
            }
        } else if (i == 1101) {
            GlobalTipsPriorityManager.getInstance().remove(10);
            if (!((IPayWayView) this.mView).isClickable() || i2 != 2) {
                dismissDialog(i);
                GlobalOmegaUtils.trackEvent("gp_conf_dlg_untiedcard_ck");
                return;
            }
            onFormPayWayClicked();
            GlobalOmegaUtils.trackEvent("gp_conf_dlg_tiedcard_ck");
        }
    }

    /* access modifiers changed from: protected */
    public boolean showGuidePopup() {
        if (this.mContext == null || isDialogShowing() || FormStore.getInstance().isShowingPopupCompoent() || AbsConfirmConfigState.isLoadingInConfirmPage) {
            return false;
        }
        if (AbsConfirmConfigState.isShowPopInConfirmPage) {
            return true;
        }
        return m14270a(false);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        Runnable runnable = this.f17040v;
        if (runnable != null) {
            UiThreadHandler.removeCallbacks(runnable);
            this.f17040v = null;
        }
        return super.onBackPressed(backType);
    }

    /* renamed from: b */
    private void m14274b(DidiGlobalPayMethodListData.PayMethodListResult payMethodListResult) {
        if (payMethodListResult != null) {
            List<PayWayModel.PayWayItem> a = m14266a(payMethodListResult);
            if (!a.isEmpty()) {
                this.mSelectedPaywayItem.clear();
                this.mSelectedPaywayItem.addAll(a);
            }
            this.selectedResults = payMethodListResult;
            setPayWayToForm(this.mSelectedPaywayItem);
            setEnterpriseInfoToForm((EnterpriseInfo) null);
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
            ((IPayWayView) this.mView).setLabel(this.mSelectedPaywayItem, (String) null);
        } else if (payMethodListResult == null || !payMethodListResult.hasRefreshed) {
            FormStore.getInstance().setSkipEstimateGet(true);
        } else {
            doPublish(BaseEventKeys.Estimate.ESTIMATE_GET_ESTIMATE);
        }
        SearchIdUploadManager.getInstance().setEstimateAction("after_select_pay_method");
    }

    public void notifyUpdate() {
        doPublish(BaseEventKeys.Form.KEY_UPDATE_FORM_OPTIONS);
    }
}
