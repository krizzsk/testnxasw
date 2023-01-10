package com.didi.component.mapflow.newpresenter;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.address.FromType;
import com.didi.address.model.WayPoint;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.event.ResetMapEvent;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.base.ComponentWrap;
import com.didi.component.common.base.EventDataObj;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.carsliding.IconHelper;
import com.didi.component.mapflow.model.DeparturePickUp;
import com.didi.component.mapflow.presenter.ConfirmMapFlowDelegatePresenter;
import com.didi.component.mapflow.view.IMapFlowDelegateView;
import com.didi.component.mapflow.view.widget.NewCarPoolTipsViewV2;
import com.didi.component.mapflow.view.widget.StartDestAbnormalDrawerView;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGOBaseDrawerModel;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.map.global.component.departure.controller.OrderInterceptMode;
import com.didi.map.global.component.departure.model.AddressExtendInfo;
import com.didi.map.global.component.departure.model.AddressWalkGuide;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.model.PinStyle;
import com.didi.map.global.component.departure.view.DepartureConfirmCardView;
import com.didi.map.global.component.slideCars.api.AnyCarInfo;
import com.didi.map.global.component.slideCars.model.ICarBitmapDescriptor;
import com.didi.map.global.flow.scene.CarSlidingParam;
import com.didi.map.global.flow.scene.global.IMapChangeListener;
import com.didi.map.global.flow.scene.order.confirm.BubbleContentParam;
import com.didi.map.global.flow.scene.order.confirm.MapElementStatus;
import com.didi.map.global.flow.scene.order.confirm.RoutePlanParam;
import com.didi.map.global.flow.scene.order.confirm.normal.CarLevelParam;
import com.didi.map.global.flow.scene.order.confirm.normal.CircleParam;
import com.didi.map.global.flow.scene.order.confirm.normal.IOrderConfirmController;
import com.didi.map.global.flow.scene.order.confirm.normal.LineMode;
import com.didi.map.global.flow.scene.order.confirm.normal.OrderConfirmSceneParam;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.scene.simple.IDeparturePinCallback;
import com.didi.map.global.flow.scene.simple.IOrderInterceptCallbackNew;
import com.didi.map.global.flow.scene.simple.ISimpleMapSceneController;
import com.didi.map.global.flow.scene.simple.params.SimpleSceneParams;
import com.didi.map.global.flow.scene.sug.ISugSceneCallback;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.messagecenter.p153pb.OrderStat;
import com.didi.sdk.misconfig.model.CarInfo;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.CarMoveBean;
import com.didi.travel.psnger.model.response.TaxiCompanyListModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.anycar.AnyCarGlobalConfig;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didiglobal.travel.biz.experim.GlobalAbExperims;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ConfirmMapFlowDelegateNewPresenter extends ConfirmMapFlowDelegatePresenter {

    /* renamed from: a */
    BaseEventPublisher.OnEventListener<Integer> f16180a = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            if (num == null) {
                return;
            }
            if (num.intValue() == 2) {
                if (!ConfirmMapFlowDelegateNewPresenter.this.mIsRouteEditorEnable || !FormStore.getInstance().hasStopPoints()) {
                    ConfirmMapFlowDelegateNewPresenter.this.enterSugPageScene(2, FormStore.getInstance().getStartAddress(), FromType.OPEN_RIDE_CONFIRM, ConfirmMapFlowDelegateNewPresenter.this.mGlobalSugCallback);
                } else {
                    ConfirmMapFlowDelegateNewPresenter.this.enterSugPageScene(2, FormStore.getInstance().getStartAddress(), FromType.OPEN_RIDE_ROUTE_EDIT, ConfirmMapFlowDelegateNewPresenter.this.mGlobalSugCallback);
                }
            } else if (num.intValue() == 1) {
                ConfirmMapFlowDelegateNewPresenter.this.enterSugPageScene(1, FormStore.getInstance().getStartAddress(), FromType.CONFIRM_NEW, ConfirmMapFlowDelegateNewPresenter.this.mGlobalSugCallback);
            } else if (num.intValue() == 6 && ConfirmMapFlowDelegateNewPresenter.this.mIsRouteEditorEnable && !FormStore.getInstance().isBubbleShowCarpoolStyle() && FormStore.getInstance().hasStopPoints()) {
                ConfirmMapFlowDelegateNewPresenter.this.enterSugPageScene(1, FormStore.getInstance().getStartAddress(), FromType.ROUTE_EDITOR, ConfirmMapFlowDelegateNewPresenter.this.mGlobalSugCallback);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Logger f16181b = LoggerFactory.getLogger(getClass());

    /* renamed from: c */
    private CarInfo f16182c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CarMoveBean f16183d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f16184e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ISimpleMapSceneController f16185f;

    /* renamed from: g */
    private boolean f16186g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LEGODrawer f16187h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final DeparturePickUp f16188i = new DeparturePickUp();
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f16189j = true;

    /* renamed from: k */
    private final BaseEventPublisher.OnEventListener<Address> f16190k = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, Address address) {
            boolean unused = ConfirmMapFlowDelegateNewPresenter.this.f16189j = true;
            ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
            confirmMapFlowDelegateNewPresenter.m13378a(confirmMapFlowDelegateNewPresenter.f16188i.getDeparture());
        }
    };

    /* renamed from: l */
    private final BaseEventPublisher.OnEventListener<Address> f16191l = new BaseEventPublisher.OnEventListener<Address>() {
        public void onEvent(String str, Address address) {
            boolean unused = ConfirmMapFlowDelegateNewPresenter.this.f16189j = false;
            ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
            confirmMapFlowDelegateNewPresenter.m13378a(confirmMapFlowDelegateNewPresenter.f16188i.getDeparture());
        }
    };

    /* renamed from: m */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16192m = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET.equals(str)) {
                ConfirmMapFlowDelegateNewPresenter.this.m13405j();
            }
        }
    };
    protected ICarBitmapDescriptor mCarBitmapDescriptor = new ICarBitmapDescriptor() {
        public BitmapDescriptor getBitmapDescriptor() {
            return IconHelper.getInstance().getSmoothDriverIcon(ConfirmMapFlowDelegateNewPresenter.this.mContext.getApplicationContext(), ConfirmMapFlowDelegateNewPresenter.this.f16184e, R.drawable.global_mapflow_default_car_icon);
        }

        public BitmapDescriptor getDefaultBitmapDescriptor() {
            return IconHelper.getInstance().getSmoothDriverIcon(ConfirmMapFlowDelegateNewPresenter.this.mContext.getApplicationContext(), ConfirmMapFlowDelegateNewPresenter.this.f16184e, R.drawable.global_mapflow_default_car_icon);
        }
    };
    protected ISimpleMapSceneController mGetOnPageMapController;
    protected BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> mNewStarEndAbnormalListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!BaseEventKeys.Service.SendOrder.EVENT_START_END_ABNORMAL.equals(str)) {
                return;
            }
            if (ConfirmMapFlowDelegateNewPresenter.this.mGetOnPageMapController == null) {
                ConfirmMapFlowDelegateNewPresenter.this.f16181b.info("IOrderInterceptCallbackNew", "mGetOnPageMapController == null");
                ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER);
                return;
            }
            ConfirmMapFlowDelegateNewPresenter.this.mGetOnPageMapController.onOrderIntercepted(new IOrderInterceptCallbackNew() {
                public void onIntercept(OrderInterceptMode orderInterceptMode, boolean z, String str, String str2, String str3) {
                    Logger r = ConfirmMapFlowDelegateNewPresenter.this.f16181b;
                    r.info("IOrderInterceptCallbackNew onIntercept : " + orderInterceptMode, new Object[0]);
                    OrderInterceptMode unused = ConfirmMapFlowDelegateNewPresenter.this.mModel = orderInterceptMode;
                    ConfirmMapFlowDelegateNewPresenter.this.hideLoading();
                    if (orderInterceptMode != OrderInterceptMode.MODE_NORMAL) {
                        ConfirmMapFlowDelegateNewPresenter.this.m13377a(orderInterceptMode, z, str, str2, str3);
                    }
                }

                public void onContinue() {
                    OrderInterceptMode unused = ConfirmMapFlowDelegateNewPresenter.this.mModel = OrderInterceptMode.MODE_NORMAL;
                    ConfirmMapFlowDelegateNewPresenter.this.f16181b.info("IOrderInterceptCallbackNew onIntercept onContinue ", new Object[0]);
                    ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER);
                }

                public void onStart() {
                    ConfirmMapFlowDelegateNewPresenter.this.showLoading();
                }
            });
        }
    };
    protected BaseEventPublisher.OnEventListener<Integer> mPudoPaddingBottomMapListener = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            Padding padding;
            if (ConfirmMapFlowDelegateNewPresenter.this.mCurrentPadding != null) {
                padding = new Padding(ConfirmMapFlowDelegateNewPresenter.this.mCurrentPadding.left, ConfirmMapFlowDelegateNewPresenter.this.mCurrentPadding.top, ConfirmMapFlowDelegateNewPresenter.this.mCurrentPadding.right, num.intValue());
            } else {
                padding = new Padding(0, 0, 0, num.intValue());
            }
            if (ConfirmMapFlowDelegateNewPresenter.this.mGetOnPageMapController != null) {
                ConfirmMapFlowDelegateNewPresenter.this.mGetOnPageMapController.setPadding(padding);
            }
        }
    };

    /* renamed from: n */
    private final BaseEventPublisher.OnEventListener<Boolean> f16193n = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (TextUtils.equals(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, str) || TextUtils.equals(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, str)) {
                ConfirmMapFlowDelegateNewPresenter.this.updateMapView(bool, false);
            }
        }
    };

    /* renamed from: p */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16194p = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT.equals(str)) {
                ConfirmMapFlowDelegateNewPresenter.this.m13397f();
            }
        }
    };

    /* renamed from: q */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16195q = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (BaseEventKeys.AnyCar.ANYCAR_EYEBALL_PREFERENCE_CHANGE.equals(str)) {
                ConfirmMapFlowDelegateNewPresenter.this.m13397f();
            }
        }
    };

    /* renamed from: r */
    private final BaseEventPublisher.OnEventListener<EventDataObj> f16196r = new BaseEventPublisher.OnEventListener<EventDataObj>() {
        public void onEvent(String str, EventDataObj eventDataObj) {
            if (!TextUtils.equals(BaseEventKeys.Estimate.EVENT_ESTIMATE_GET_ROUTE_ID, str) || eventDataObj == null || eventDataObj.getCallback() == null || ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController == null) {
                Logger r = ConfirmMapFlowDelegateNewPresenter.this.f16181b;
                r.info("mOrderConfirmController:" + ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController, new Object[0]);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("select", Long.valueOf(ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController.getSelectedRouteId()));
            hashMap.put("default", Long.valueOf(ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController.getDefaultRouteId()));
            eventDataObj.getCallback().onCallBack(hashMap);
        }
    };

    /* renamed from: s */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16197s = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            ConfirmMapFlowDelegateNewPresenter.this.m13397f();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: t */
    public DepartureConfirmCardView f16198t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f16199u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f16200v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public LatLng f16201w = null;

    /* renamed from: x */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f16202x = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController != null) {
                if (FormStore.getInstance().isBubbleShowCarpoolStyle() && !ConfirmMapFlowDelegateNewPresenter.this.mIsCarpoolOverviewState) {
                    ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController.doBestView(ConfirmMapFlowDelegateNewPresenter.this.getCurrentPadding());
                }
            } else if (ConfirmMapFlowDelegateNewPresenter.this.mGetOnPageMapController != null) {
                ConfirmMapFlowDelegateNewPresenter.this.mGetOnPageMapController.doBestView(ConfirmMapFlowDelegateNewPresenter.this.getCurrentPadding());
            } else if (ConfirmMapFlowDelegateNewPresenter.this.f16185f != null) {
                ConfirmMapFlowDelegateNewPresenter.this.f16185f.doBestView(ConfirmMapFlowDelegateNewPresenter.this.getCurrentPadding());
            }
        }
    };

    /* access modifiers changed from: protected */
    public void carslidingOnSuccess() {
        this.f16181b.info("mCarSlidingCallback>>>onSuccess", new Object[0]);
        if (FormStore.getInstance().getTransportTime() == 0) {
            m13399g();
        } else if (this.mOrderConfirmController != null) {
            this.mOrderConfirmController.markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.HIDE, (BubbleContentParam) null);
        }
    }

    /* renamed from: b */
    private int m13381b() {
        EstimateItemModel newEstimateItem;
        List<AnyCarEstimateItemModel> selectedList = getSelectedList();
        if (selectedList != null && selectedList.size() > 0 && selectedList.get(0).mAnyCarEstimateNetItem.carConfig != null) {
            return selectedList.get(0).mAnyCarEstimateNetItem.carConfig.carBussinessId;
        }
        if (isAnycar() || (newEstimateItem = FormStore.getInstance().getNewEstimateItem()) == null || newEstimateItem.carConfig == null) {
            return 0;
        }
        return newEstimateItem.carConfig.carBussinessId;
    }

    /* renamed from: c */
    private String m13390c() {
        EstimateItemModel newEstimateItem;
        List<AnyCarEstimateItemModel> selectedList = getSelectedList();
        if (selectedList != null && selectedList.size() > 0 && selectedList.get(0).mAnyCarEstimateNetItem.carConfig != null) {
            return selectedList.get(0).mAnyCarEstimateNetItem.carConfig.estimateId;
        }
        if (isAnycar() || (newEstimateItem = FormStore.getInstance().getNewEstimateItem()) == null || newEstimateItem.carConfig == null || newEstimateItem.carConfig.estimateId == null) {
            return "";
        }
        return newEstimateItem.carConfig.estimateId;
    }

    /* renamed from: d */
    private int m13392d() {
        EstimateItemModel newEstimateItem;
        List<AnyCarEstimateItemModel> selectedList = getSelectedList();
        if (selectedList != null && selectedList.size() > 0 && selectedList.get(0).mAnyCarEstimateNetItem.carConfig != null) {
            return selectedList.get(0).mAnyCarEstimateNetItem.carConfig.carLevel;
        }
        if (isAnycar() || (newEstimateItem = FormStore.getInstance().getNewEstimateItem()) == null || newEstimateItem.carConfig == null) {
            return 0;
        }
        return newEstimateItem.carConfig.carLevel;
    }

    public List<AnyCarEstimateItemModel> getSelectedList() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            return null;
        }
        int currentPage = confirmListener.getCurrentPage();
        if (currentPage == 1) {
            if (confirmListener.getAnyCarResponse() == null || confirmListener.getSelectedAnyCarItems() == null) {
                return null;
            }
            return confirmListener.getSelectedAnyCarItems();
        } else if (currentPage != 3) {
            return null;
        } else {
            if (confirmListener.getAnyCarResponse() != null && confirmListener.getSelectedSingleAnyCarItem() != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(confirmListener.getSelectedSingleAnyCarItem());
                return arrayList;
            } else if (confirmListener.getAnyCarResponse() == null || confirmListener.getSelectedAnyCarItems() == null) {
                return null;
            } else {
                return confirmListener.getSelectedAnyCarItems();
            }
        }
    }

    /* renamed from: e */
    private CarInfo m13395e() {
        if (isAnycar()) {
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (!(confirmListener == null || confirmListener.getAnyCarResponse() == null || confirmListener.getAnyCarResponse().globalConfig == null || confirmListener.getAnyCarResponse().globalConfig.mapInfo == null)) {
                AnyCarGlobalConfig.AnyCarMapInfo anyCarMapInfo = confirmListener.getAnyCarResponse().globalConfig.mapInfo;
                if (!TextUtils.isEmpty(anyCarMapInfo.mapCarIcon)) {
                    if (this.f16182c == null) {
                        this.f16182c = new CarInfo();
                    }
                    this.f16182c.setMapIcon(anyCarMapInfo.mapCarIcon);
                }
            }
            return this.f16182c;
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (!(newEstimateItem == null || newEstimateItem.carConfig == null || TextUtils.isEmpty(newEstimateItem.carConfig.carMapIconUrl))) {
            if (this.f16182c == null) {
                this.f16182c = new CarInfo();
            }
            this.f16182c.setMapIcon(newEstimateItem.carConfig.carMapIconUrl);
        }
        return this.f16182c;
    }

    /* access modifiers changed from: protected */
    public boolean isAnycar() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        return confirmListener != null && confirmListener.getIsAnyCar();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m13397f() {
        this.f16183d.channel = m13381b();
        this.f16183d.carLevelType = 0;
        TaxiCompanyListModel.CompanyModel curCompany = FormStore.getInstance().getCurCompany();
        List<String> list = null;
        this.f16183d.companyId = (curCompany == null || TextUtils.equals(curCompany.f46886id, "0") || TextUtils.equals(curCompany.f46886id, "1")) ? null : curCompany.f46886id;
        CarMoveBean carMoveBean = this.f16183d;
        if (curCompany != null) {
            list = curCompany.childCids;
        }
        carMoveBean.pickupFreeCompIds = list;
        CarSlidingParam carSlidingParam = getCarSlidingParam(this.mCarBitmapDescriptor, OrderStat.Bubble, this.f16183d);
        CarLevelParam carLevelParam = new CarLevelParam();
        carLevelParam.setCarSlidingParam(carSlidingParam);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener != null && confirmListener.getIsAnyCar()) {
            if (confirmListener.getSelectedSingleAnyCarItem() != null) {
                carLevelParam.setSceneType(0);
            } else if (confirmListener.getSelectedAnyCarItems() == null || confirmListener.getSelectedAnyCarItems().size() <= 0) {
                carLevelParam.setSceneType(2);
            } else {
                carLevelParam.setSceneType(1);
            }
        }
        Address startAddress = FormStore.getInstance().getStartAddress();
        Address endAddress = FormStore.getInstance().getEndAddress();
        List<WayPoint> wayPointAddressList = FormStore.getInstance().getWayPointAddressList();
        LineMode lineMode = LineMode.MODE_MULTI_ROUTE;
        ArrayList arrayList = new ArrayList();
        if (!CollectionUtil.isEmpty((Collection<?>) wayPointAddressList)) {
            for (WayPoint next : wayPointAddressList) {
                if (next != null) {
                    arrayList.add(new LatLng(next.getAddress().getLatitude(), next.getAddress().getLongitude()));
                }
            }
        }
        CommonLineParam commonLineParam = new CommonLineParam(MapElementId.ID_LINE_START_END, ResourcesHelper.getColor(this.mContext, R.color.mapflow_carpool_circle_stroke_color), 6, 1, new LatLng(startAddress.getLatitude(), startAddress.getLongitude()), new LatLng(endAddress.getLatitude(), endAddress.getLongitude()), arrayList);
        RoutePlanParam routePlanParam = new RoutePlanParam();
        routePlanParam.setLineMode(lineMode);
        routePlanParam.setOrderType(FormStore.getInstance().getTransportTime() != 0 ? EpfOrderType.Appointed : EpfOrderType.NormalType);
        routePlanParam.setBubbleId(m13390c());
        routePlanParam.setLineParam(commonLineParam);
        carLevelParam.setRoutePlanParam(routePlanParam);
        if (this.mOrderConfirmController != null) {
            this.mOrderConfirmController.updateCarLevel(carLevelParam);
        }
    }

    public ConfirmMapFlowDelegateNewPresenter(ComponentParams componentParams) {
        super(componentParams);
        CarMoveBean carMoveBean = new CarMoveBean();
        this.f16183d = carMoveBean;
        carMoveBean.sdkmaptype = NationComponentDataUtil.getMapTypeString();
        this.f16183d.orderStage = OrderStat.Bubble;
        m13407k();
    }

    /* renamed from: a */
    private void m13379a(String str) {
        this.f16184e = str;
        if (!TextUtils.isEmpty(str) && !IconHelper.getInstance().haveCache(this.f16184e)) {
            IconHelper.getInstance().requestMisIcon(this.mContext.getApplicationContext(), this.f16184e, true, new IconHelper.IconChangeListener() {
                public void iconChange() {
                    if (ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController != null) {
                        ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                        CarSlidingParam carSlidingParam = confirmMapFlowDelegateNewPresenter.getCarSlidingParam(confirmMapFlowDelegateNewPresenter.mCarBitmapDescriptor, OrderStat.Bubble, ConfirmMapFlowDelegateNewPresenter.this.f16183d);
                        if (carSlidingParam != null) {
                            ConfirmMapFlowDelegateNewPresenter.this.mOrderConfirmController.slidingCarHandler(MapElementStatus.UPDATE, carSlidingParam);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: g */
    private void m13399g() {
        EstimateItemModel newEstimateItem;
        if (this.mOrderConfirmController != null && (newEstimateItem = FormStore.getInstance().getNewEstimateItem()) != null && newEstimateItem.mapInfoModel != null && newEstimateItem.mapInfoModel.startPointText != null && !TextUtils.isEmpty(newEstimateItem.mapInfoModel.startPointText.getContent())) {
            BubbleContentParam bubbleContentParam = new BubbleContentParam();
            bubbleContentParam.setContent(newEstimateItem.mapInfoModel.startPointText.getContent());
            this.mOrderConfirmController.markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.SHOW, bubbleContentParam);
        }
    }

    /* renamed from: h */
    private void m13400h() {
        if (this.mOrderConfirmController != null) {
            this.mOrderConfirmController.markerBubbleHandler(MapElementId.ID_MARKER_START, MapElementStatus.HIDE, (BubbleContentParam) null);
        }
    }

    /* renamed from: i */
    private void m13403i() {
        if (this.mOrderConfirmController != null) {
            Padding currentPadding = getCurrentPadding();
            GLog.m11354d("mahui", currentPadding.toString());
            this.mOrderConfirmController.doBestView(currentPadding);
        }
    }

    public CarSlidingParam getCarSlidingParam(ICarBitmapDescriptor iCarBitmapDescriptor, OrderStat orderStat, CarMoveBean carMoveBean) {
        CarSlidingParam carSlidingParam = super.getCarSlidingParam(iCarBitmapDescriptor, orderStat, carMoveBean);
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            carSlidingParam.setIsAnyCarIntl(0);
        } else {
            carSlidingParam.setIsAnyCarIntl(1);
            carSlidingParam.setAnyCarPriority(confirmListener.getPreference());
            List<AnyCarEstimateItemModel> selectedList = getSelectedList();
            if (selectedList != null && selectedList.size() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < selectedList.size(); i++) {
                    AnyCarEstimateItemModel anyCarEstimateItemModel = selectedList.get(i);
                    if (anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig != null) {
                        AnyCarInfo anyCarInfo = new AnyCarInfo();
                        anyCarInfo.setCarLevel(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel + "");
                        anyCarInfo.setProductId(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carBussinessId + "");
                        anyCarInfo.setRequireLevel(anyCarEstimateItemModel.mAnyCarEstimateNetItem.carConfig.carLevel + "");
                        arrayList.add(anyCarInfo);
                    }
                }
                carSlidingParam.setAnyCarInfo(arrayList);
            }
            carSlidingParam.setType(m13392d());
            carSlidingParam.setProductId("" + m13381b());
            carSlidingParam.setCarLevel(m13392d());
            carSlidingParam.setBubbleId(m13390c());
        }
        return carSlidingParam;
    }

    /* access modifiers changed from: protected */
    public void updateMapState() {
        LineMode lineMode;
        if (this.mOrderConfirmController != null) {
            CarSlidingParam carSlidingParam = getCarSlidingParam(this.mCarBitmapDescriptor, OrderStat.Bubble, this.f16183d);
            CarLevelParam carLevelParam = new CarLevelParam();
            carLevelParam.setCarSlidingParam(carSlidingParam);
            ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
            if (confirmListener != null && confirmListener.getIsAnyCar()) {
                if (confirmListener.getSelectedSingleAnyCarItem() != null) {
                    carLevelParam.setSceneType(0);
                } else if (confirmListener.getSelectedAnyCarItems() == null || confirmListener.getSelectedAnyCarItems().size() <= 0) {
                    carLevelParam.setSceneType(2);
                } else {
                    carLevelParam.setSceneType(1);
                }
            }
            Address startAddress = FormStore.getInstance().getStartAddress();
            Address endAddress = FormStore.getInstance().getEndAddress();
            List<WayPoint> wayPointAddressList = FormStore.getInstance().getWayPointAddressList();
            CommonLineParam commonLineParam = null;
            LatLng latLng = startAddress != null ? new LatLng(startAddress.getLatitude(), startAddress.getLongitude()) : null;
            LatLng latLng2 = endAddress != null ? new LatLng(endAddress.getLatitude(), endAddress.getLongitude()) : null;
            int bubbleRouteType = FormStore.getInstance().getBubbleRouteType();
            if (bubbleRouteType == 1) {
                lineMode = LineMode.MODE_ARC;
                if (!(latLng == null || latLng2 == null)) {
                    commonLineParam = new CommonLineParam(MapElementId.ID_LINE_START_END, ResourcesHelper.getColor(this.mContext, R.color.mapflow_carpool_circle_stroke_color), 6, 1, latLng, latLng2, (List<LatLng>) null);
                }
            } else if (bubbleRouteType == 2) {
                if (this.f16186g) {
                    carLevelParam.setCircleParam(new CircleParam((double) (FormStore.getInstance().getCarpoolRadius() > 0 ? FormStore.getInstance().getCarpoolRadius() : 200), ResourcesHelper.getColor(this.mContext, R.color.mapflow_carpool_circle_fill_color_v2), ResourcesHelper.getColor(this.mContext, R.color.mapflow_carpool_circle_stroke_color_v2), UIUtils.dip2pxInt(this.mContext, 1.0f)));
                    if (!this.mIsCarpoolOverviewState) {
                        carLevelParam.setViewTip(new NewCarPoolTipsViewV2(this.mContext));
                    }
                }
                lineMode = LineMode.MODE_NONE;
            } else if (bubbleRouteType == 3) {
                lineMode = LineMode.MODE_NONE;
            } else if (bubbleRouteType != 4) {
                lineMode = LineMode.MODE_MULTI_ROUTE;
                ArrayList arrayList = new ArrayList();
                if (!CollectionUtil.isEmpty((Collection<?>) wayPointAddressList)) {
                    for (WayPoint next : wayPointAddressList) {
                        if (next != null) {
                            arrayList.add(new LatLng(next.getAddress().getLatitude(), next.getAddress().getLongitude()));
                        }
                    }
                }
                if (!(latLng == null || latLng2 == null)) {
                    commonLineParam = new CommonLineParam(MapElementId.ID_LINE_START_END, ResourcesHelper.getColor(this.mContext, R.color.mapflow_carpool_circle_stroke_color), 6, 1, latLng, latLng2, arrayList);
                }
            } else {
                carLevelParam.setMiniBusParamInterface(getMiniBusParam(FormStore.getInstance().getLineInfo(), FormStore.getInstance().getMarkerInfo()));
                carLevelParam.setCarSlidingParam((CarSlidingParam) null);
                this.mOrderConfirmController.updateCarLevel(carLevelParam);
                return;
            }
            RoutePlanParam routePlanParam = new RoutePlanParam();
            routePlanParam.setLineMode(lineMode);
            routePlanParam.setOrderType(FormStore.getInstance().getTransportTime() != 0 ? EpfOrderType.Appointed : EpfOrderType.NormalType);
            routePlanParam.setBubbleId(m13390c());
            if (commonLineParam != null) {
                routePlanParam.setLineParam(commonLineParam);
            }
            carLevelParam.setRoutePlanParam(routePlanParam);
            this.mOrderConfirmController.updateCarLevel(carLevelParam);
        }
    }

    /* access modifiers changed from: protected */
    public void updateMapView(Boolean bool, Boolean bool2) {
        super.updateMapView(bool, bool2);
        this.mIsCarpoolOverviewState = bool2.booleanValue();
        ((IMapFlowDelegateView) this.mView).removeBottomMask();
        if (bool.booleanValue()) {
            this.f16186g = true;
            m13399g();
            m13407k();
            updateMapState();
            m13403i();
            return;
        }
        m13400h();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public synchronized void m13405j() {
        m13407k();
    }

    /* renamed from: k */
    private void m13407k() {
        CarInfo e = m13395e();
        this.f16182c = e;
        if (e != null) {
            this.f16183d.channel = m13381b();
            this.f16183d.carLevelType = 0;
            m13379a(this.f16182c.getMapIcon());
            return;
        }
        this.f16183d.channel = 0;
        this.f16183d.carLevelType = 0;
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        String str;
        doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.PUDO);
        if (CarOrderHelper.getOrder() == null) {
            str = "";
        } else {
            str = CarOrderHelper.getOrder().getOid();
        }
        GlobalOmegaUtils.trackEvent(LoginOmegaUtil.PAS_RETURN_CK, "g_OrderId", str);
        this.f16199u = false;
        this.f16189j = true;
        this.f16188i.clearPickUp();
        Logger logger = this.f16181b;
        logger.info("ConfirmMapFlowDelegate onBackPressed mCurrentScene => " + this.mCurrentScene, new Object[0]);
        return false;
    }

    /* access modifiers changed from: protected */
    public void registerStartEndAbnormalListener() {
        subscribe(BaseEventKeys.Service.SendOrder.EVENT_START_END_ABNORMAL, this.mNewStarEndAbnormalListener);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_COMPANY_CHANGED, this.f16197s);
    }

    /* access modifiers changed from: protected */
    public void unregisterStartEndAbnormalListener() {
        unsubscribe(BaseEventKeys.Service.SendOrder.EVENT_START_END_ABNORMAL, this.mNewStarEndAbnormalListener);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_COMPANY_CHANGED, this.f16197s);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f16192m);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f16193n);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f16193n);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f16194p);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_PREFERENCE_CHANGE, this.f16195q);
        subscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_CHANGE_ADDRESS_SHOW_SUG, this.f16180a);
        subscribe(BaseEventKeys.Location.EVENT_RESET_BTN_CLICK, this.f16202x);
        subscribe("event_confirm_boarding_enable_city", this.f16190k);
        subscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOARDING_UNENABLE_CITY, this.f16191l);
        subscribe(BaseEventKeys.Map.EVENT_GET_ON_FENCE_PADDING_BOTTOM, this.mPudoPaddingBottomMapListener);
        subscribe(BaseEventKeys.Estimate.EVENT_ESTIMATE_GET_ROUTE_ID, this.f16196r);
        this.f16189j = true;
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Common.KEY_MIS_CHANGED_FROM_NET, this.f16192m);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f16193n);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f16193n);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_SELECT_OR_UNSELECT, this.f16194p);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_PREFERENCE_CHANGE, this.f16195q);
        unsubscribe(BaseEventKeys.Confirm.EVENT_NEW_ESTIMATE_CHANGE_ADDRESS_SHOW_SUG, this.f16180a);
        unsubscribe(BaseEventKeys.Location.EVENT_RESET_BTN_CLICK, this.f16202x);
        unsubscribe("event_confirm_boarding_enable_city", this.f16190k);
        unsubscribe(BaseEventKeys.Confirm.EVENT_CONFIRM_BOARDING_UNENABLE_CITY, this.f16191l);
        unsubscribe(BaseEventKeys.Map.EVENT_GET_ON_FENCE_PADDING_BOTTOM, this.mPudoPaddingBottomMapListener);
        unsubscribe(BaseEventKeys.Estimate.EVENT_ESTIMATE_GET_ROUTE_ID, this.f16196r);
    }

    /* renamed from: a */
    private void m13369a(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("from_lat", Double.valueOf(FormStore.getInstance().getStartAddress().getLatitude()));
        hashMap.put("from_lng", Double.valueOf(FormStore.getInstance().getStartAddress().getLongitude()));
        hashMap.put("nearcar", Integer.valueOf(i));
        hashMap.put("cartype", Integer.valueOf(FormStore.getInstance().getCarLevel()));
        GlobalOmegaUtils.trackEvent("gp_confirm_refresh_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void addOrUpdateExtraParams(OrderConfirmSceneParam.Builder builder) {
        super.addOrUpdateExtraParams(builder);
        builder.setGuessDestination(FormStore.getInstance().getIsClickGuessDestination());
        FormStore.getInstance().setIsClickGuessDestination(false);
        builder.setPinCallback(new IDeparturePinCallback() {
            public /* synthetic */ void onBroadOtherMapCallback(int i) {
                IDeparturePinCallback.CC.$default$onBroadOtherMapCallback(this, i);
            }

            public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                IDeparturePinCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
            }

            public /* synthetic */ void onClickBubble() {
                IDeparturePinCallback.CC.$default$onClickBubble(this);
            }

            public /* synthetic */ void onConfirmPickup(DepartureAddress departureAddress) {
                IDeparturePinCallback.CC.$default$onConfirmPickup(this, departureAddress);
            }

            public /* synthetic */ void onDepartureLoading(LatLng latLng) {
                IDeparturePinCallback.CC.$default$onDepartureLoading(this, latLng);
            }

            public /* synthetic */ void onDragging(int i) {
                IDeparturePinCallback.CC.$default$onDragging(this, i);
            }

            public /* synthetic */ void onFetchAddressFail(LatLng latLng) {
                IDeparturePinCallback.CC.$default$onFetchAddressFail(this, latLng);
            }

            public /* synthetic */ void onStartDragging() {
                IDeparturePinCallback.CC.$default$onStartDragging(this);
            }

            public /* synthetic */ void onStartSugPage(Address address) {
                IDeparturePinCallback.CC.$default$onStartSugPage(this, address);
            }

            public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
                IDeparturePinCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
            }

            public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                Address address = departureAddress.getAddress();
                if (!TextUtils.isEmpty(Preconditions.nonNull(address) ? address.getDisplayName() : "")) {
                    ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.Map.EVENT_ESTIMATE_UPDATE_GUESS_DESTINATION_START, address.getDisplayName());
                    if (GlobalAbExperims.checkSugAddrPax()) {
                        FormStore.getInstance().setStartAddress(address);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void enterConfirmScene() {
        this.mGetOnPageMapController = null;
        this.f16185f = null;
        doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.PUDO);
        super.enterConfirmScene();
        doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 0);
    }

    /* renamed from: l */
    private void m13409l() {
        if (this.f16198t == null) {
            DepartureConfirmCardView departureConfirmCardView = new DepartureConfirmCardView(this.mContext);
            this.f16198t = departureConfirmCardView;
            departureConfirmCardView.requestPoiSelectCardFeature(1);
            this.f16198t.setButtonOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ConfirmMapFlowDelegateNewPresenter.this.m13414o();
                }
            });
            this.f16198t.setSearchOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ConfirmMapFlowDelegateNewPresenter.this.m13412n();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13378a(DepartureAddress departureAddress) {
        String str;
        String str2;
        m13409l();
        if (departureAddress != null) {
            Address address = departureAddress.getAddress();
            if (!TextUtils.isEmpty(address.getDisplayName())) {
                str = address.getDisplayName();
            } else {
                str = ResourcesHelper.getString(this.mContext, R.string.map_flow_current_location);
            }
            if (!TextUtils.isEmpty(FormStore.getInstance().getConfirmPickupSubTitle())) {
                str2 = FormStore.getInstance().getConfirmPickupSubTitle();
            } else {
                str2 = (departureAddress.getExtendInfo() == null || TextUtils.isEmpty(departureAddress.getExtendInfo().getSubNoticeTitle())) ? "" : departureAddress.getExtendInfo().getSubNoticeTitle();
            }
            if (FormStore.getInstance().isBubbleShowCarpoolStyle()) {
                this.f16198t.setMainTitleDefault();
            } else if (departureAddress.getExtendInfo() != null && !TextUtils.isEmpty(departureAddress.getExtendInfo().getMainNoticeTitle())) {
                this.f16198t.setMainTitle(departureAddress.getExtendInfo().getMainNoticeTitle());
            }
            this.f16198t.setAddress(str);
            TextView button = this.f16198t.getButton();
            if (this.f16189j) {
                this.f16198t.setSubTitle(str2);
                if (button != null) {
                    button.setEnabled(true);
                    return;
                }
                return;
            }
            this.f16198t.setSubTitle(this.mContext.getString(R.string.global_unenable_city_title));
            if (button != null) {
                button.setEnabled(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m13411m() {
        m13409l();
        this.f16198t.setAddress(ResourcesHelper.getString(this.mContext, R.string.map_flow_current_location));
        if (!this.f16189j) {
            this.f16198t.setSubTitle(this.mContext.getString(R.string.global_unenable_city_title));
            if (this.f16198t.getButton() != null) {
                this.f16198t.getButton().setEnabled(false);
            }
        } else if (this.f16198t.getButton() != null) {
            this.f16198t.getButton().setEnabled(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m13412n() {
        this.f16188i.clearPickUp();
        openSugPage();
        HashMap hashMap = new HashMap();
        Address startAddress = FormStore.getInstance().getStartAddress();
        if (startAddress != null) {
            hashMap.put("from_lat", Double.valueOf(startAddress.latitude));
            hashMap.put("from_lng", Double.valueOf(startAddress.longitude));
            hashMap.put("from_poi", startAddress.poiId);
        }
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem != null) {
            hashMap.put("bubble_id", newEstimateItem.estimateId);
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_fromaddr_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m13414o() {
        ISimpleMapSceneController iSimpleMapSceneController;
        if (!this.f16199u || this.f16188i.getDepartureZoneType() != 0 || (iSimpleMapSceneController = this.mGetOnPageMapController) == null) {
            doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_SEND_BUTTON_CLICK);
            return;
        }
        iSimpleMapSceneController.onConfirmClickInBroadOther();
        View departureTerminalView = this.mGetOnPageMapController.getDepartureTerminalView();
        if (departureTerminalView != null) {
            m13370a(departureTerminalView);
        }
        this.f16199u = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13370a(View view) {
        doPublish(BaseEventKeys.Template.EVENT_SHOW_POPUP_COMPONENT, new ComponentWrap(ComponentType.PUDO, false));
        doPublish(BaseEventKeys.Confirm.EVENT_HIDE_XPANEL);
        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.Confirm.EVENT_CONFIRM_GET_ON_SHOW_FENCE, view);
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m13417p() {
        doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.PUDO);
        doPublish(BaseEventKeys.Confirm.EVENT_SHOW_XPANEL);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13385b(View view) {
        doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_GET_ON_SHOW_NORMAL, view);
    }

    /* access modifiers changed from: protected */
    public void enterGetOnScene() {
        this.f16181b.info("ConfirmMapFlowDelegate enterGetOnScene..", new Object[0]);
        Address startAddress = FormStore.getInstance().getStartAddress();
        if (startAddress == null) {
            this.f16181b.error("ConfirmMapFlowDelegate startAddress is empty, startAddress is null.", new Object[0]);
            return;
        }
        if (this.mCurrentScene == 0) {
            this.f16188i.reset();
        }
        leaveConfirmScene();
        this.mIsFirstPoi = true;
        this.f16200v = false;
        this.f16189j = true;
        trackLocationInGetOnScene();
        DepartureFenceOptions departureFenceOptions = new DepartureFenceOptions();
        departureFenceOptions.cardWizardStart = 3;
        departureFenceOptions.cardStyle = 1;
        if (this.mCurrentScene == 0) {
            this.f16201w = null;
            this.f16188i.clearPickUp();
            FormStore.getInstance().setGetOnStartAddress(startAddress);
        }
        this.mOrderConfirmController = null;
        this.f16185f = null;
        DepartureLocationInfo s = m13422s();
        if (this.mGetOnPageMapController == null || !this.f16199u) {
            SimpleSceneParams build = new SimpleSceneParams.Builder().pinStyle(m13424t()).context(this.mContext).mapChangeListener((IMapChangeListener) new IMapChangeListener() {
                public void hideResetView() {
                    ConfirmMapFlowDelegateNewPresenter.super.hideResetView();
                }

                public void showResetView() {
                    ConfirmMapFlowDelegateNewPresenter.super.showResetView();
                }
            }).departureLocationInfo(s).sceneType(0).departurePinCallback(m13419q()).hasWayPoint(FormStore.getInstance().hasStopPoints()).endInfo(FormStore.getInstance().getEndAddress()).build();
            Logger logger = this.f16181b;
            logger.debug("Enter get-on scene with location: " + s, new Object[0]);
            this.mGetOnPageMapController = transformToMainPageMapScene(build);
        } else {
            Logger logger2 = this.f16181b;
            logger2.debug("Re-enter get-on scene with location update: " + s, new Object[0]);
            ((ISimpleMapSceneController) Objects.requireNonNull(this.mGetOnPageMapController)).updatePositionWhenOutStation(s);
        }
        this.f16188i.setPickOtherArea(false);
        if (FormStore.getInstance().hasChangeAddressType(2)) {
            doPublish(BaseEventKeys.Map.EVENT_SHOW_RESET_MAP);
        }
        ISimpleMapSceneController iSimpleMapSceneController = this.mGetOnPageMapController;
        if (iSimpleMapSceneController != null) {
            iSimpleMapSceneController.setPadding(getCurrentPadding());
        }
        doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 8);
        this.mCurrentScene = 1;
    }

    /* access modifiers changed from: protected */
    public void onPickUpNewAddress(Address address) {
        super.onPickUpNewAddress(address);
        this.f16188i.pickUp((Address) Objects.requireNonNull(address));
    }

    /* renamed from: q */
    private IDeparturePinCallback m13419q() {
        return new IDeparturePinCallback() {
            public /* synthetic */ void onStartDragging() {
                IDeparturePinCallback.CC.$default$onStartDragging(this);
            }

            public /* synthetic */ void onStartSugPage(Address address) {
                IDeparturePinCallback.CC.$default$onStartSugPage(this, address);
            }

            public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                Address startAddress;
                Address address = departureAddress != null ? departureAddress.getAddress() : null;
                if (address != null) {
                    if (!(!ConfirmMapFlowDelegateNewPresenter.this.isAnycar() || (startAddress = FormStore.getInstance().getStartAddress()) == null || startAddress.cityId == address.cityId)) {
                        AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneChangeCity, (Map<String, Object>) null);
                    }
                    int zoneType = departureAddress.getZoneType();
                    FormStore.getInstance().setStartParkingProperty(departureAddress.getStartParkingProperty());
                    FormStore.getInstance().setIsShowInterceptorPop(departureAddress.isShowSpecialNotifacation());
                    FormStore.getInstance().setShowRealPicInXpanel(departureAddress.isShowRealPicInXpanel());
                    ConfirmMapFlowDelegateNewPresenter.this.f16188i.update(departureAddress);
                    FormStore.getInstance().setDepartureAddress(address);
                    FormStore.getInstance().setStartAddress(address);
                    boolean z = false;
                    boolean unused = ConfirmMapFlowDelegateNewPresenter.this.f16199u = false;
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                    if (zoneType == 0) {
                        z = true;
                    }
                    boolean unused2 = confirmMapFlowDelegateNewPresenter.f16200v = z;
                    if (zoneType == 0) {
                        View departureTerminalView = ConfirmMapFlowDelegateNewPresenter.this.mGetOnPageMapController.getDepartureTerminalView();
                        if (departureTerminalView != null) {
                            ConfirmMapFlowDelegateNewPresenter.this.m13370a(departureTerminalView);
                        }
                        FormStore.getInstance().setAirPotAddress(departureAddress);
                        return;
                    }
                    ConfirmMapFlowDelegateNewPresenter.this.m13378a(departureAddress);
                    ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, departureAddress);
                    ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.DDMirror.EVENT_MSG_DEPARTURE_LOAD);
                    ConfirmMapFlowDelegateNewPresenter.this.m13417p();
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter2 = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter2.m13385b((View) confirmMapFlowDelegateNewPresenter2.f16198t);
                    if (ConfirmMapFlowDelegateNewPresenter.this.f16199u && ConfirmMapFlowDelegateNewPresenter.this.f16198t != null) {
                        ConfirmMapFlowDelegateNewPresenter.this.f16198t.setStationBroadOtherTitleNames();
                    }
                } else if (departureAddress == null || departureAddress.getPosition() == null) {
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter3 = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter3.m13371a(confirmMapFlowDelegateNewPresenter3.f16201w);
                } else {
                    ConfirmMapFlowDelegateNewPresenter.this.m13371a(departureAddress.getPosition());
                }
            }

            public void onFetchAddressFail(LatLng latLng) {
                ConfirmMapFlowDelegateNewPresenter.this.m13371a(latLng);
                if (!ConfirmMapFlowDelegateNewPresenter.this.f16200v) {
                    ConfirmMapFlowDelegateNewPresenter.this.m13411m();
                    ConfirmMapFlowDelegateNewPresenter.this.m13417p();
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter.m13385b((View) confirmMapFlowDelegateNewPresenter.f16198t);
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter2 = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter2.doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_GET_ON_SHOW_NORMAL, confirmMapFlowDelegateNewPresenter2.f16198t);
                    ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.DDMirror.EVENT_MSG_DEPARTURE_LOAD);
                }
            }

            public void onDragging(int i) {
                FormStore.getInstance().addChangeAddressTypes(1);
            }

            public void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                Address address = departureAddress != null ? departureAddress.getAddress() : null;
                if (address != null) {
                    FormStore.getInstance().setDepartureAddress(address);
                    ConfirmMapFlowDelegateNewPresenter.this.m13378a(departureAddress);
                    ConfirmMapFlowDelegateNewPresenter.this.m13417p();
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter.m13385b((View) confirmMapFlowDelegateNewPresenter.f16198t);
                    ConfirmMapFlowDelegateNewPresenter.this.f16198t.setStationBroadOtherTitleNames();
                    ConfirmMapFlowDelegateNewPresenter.this.f16198t.getButton().setEnabled(false);
                    boolean unused = ConfirmMapFlowDelegateNewPresenter.this.f16199u = true;
                    ConfirmMapFlowDelegateNewPresenter.this.f16188i.setPickOtherArea(true);
                }
            }

            public void onBroadOtherMapCallback(int i) {
                TextView button = ConfirmMapFlowDelegateNewPresenter.this.f16198t != null ? ConfirmMapFlowDelegateNewPresenter.this.f16198t.getButton() : null;
                if (button != null) {
                    button.setEnabled(true);
                }
            }

            public void onDepartureLoading(LatLng latLng) {
                LatLng unused = ConfirmMapFlowDelegateNewPresenter.this.f16201w = latLng;
                if (!ConfirmMapFlowDelegateNewPresenter.this.f16200v) {
                    ConfirmMapFlowDelegateNewPresenter.this.m13378a((DepartureAddress) null);
                    ConfirmMapFlowDelegateNewPresenter.this.f16198t.showLoadding();
                    ConfirmMapFlowDelegateNewPresenter.this.m13417p();
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter.m13385b((View) confirmMapFlowDelegateNewPresenter.f16198t);
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter2 = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter2.doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_GET_ON_SHOW_NORMAL, confirmMapFlowDelegateNewPresenter2.f16198t);
                }
            }

            public void onStartTerminalWindow(DepartureAddress departureAddress) {
                Logger r = ConfirmMapFlowDelegateNewPresenter.this.f16181b;
                r.debug("onStartTerminalWindow: " + departureAddress, new Object[0]);
            }

            public void onConfirmPickup(DepartureAddress departureAddress) {
                if (departureAddress != null) {
                    FormStore.getInstance().setDepartureAddress(departureAddress.getAddress());
                    ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_SEND_BUTTON_CLICK);
                }
            }

            public void onClickBubble() {
                AddressExtendInfo departureExtends = ConfirmMapFlowDelegateNewPresenter.this.f16188i.getDepartureExtends();
                AddressWalkGuide walkGuide = departureExtends != null ? departureExtends.getWalkGuide() : null;
                if (walkGuide != null) {
                    ConfirmMapFlowDelegateNewPresenter.this.openWebActivity(walkGuide.getGuidePhotoH5());
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void enterGetOnSceneInCarPool() {
        this.f16181b.info("ConfirmMapFlowDelegate enterGetOnScene..", new Object[0]);
        Address startAddress = FormStore.getInstance().getStartAddress();
        if (startAddress == null) {
            Logger logger = this.f16181b;
            logger.error("ConfirmMapFlowDelegate startAddress is empty, startAddress=" + startAddress, new Object[0]);
            return;
        }
        if (this.mCurrentScene == 0) {
            this.f16188i.reset();
        }
        leaveConfirmScene();
        this.mIsFirstPoi = true;
        trackLocationInGetOnScene();
        C662119 r3 = new IMapChangeListener() {
            public void hideResetView() {
                ConfirmMapFlowDelegateNewPresenter.super.hideResetView();
            }

            public void showResetView() {
                ConfirmMapFlowDelegateNewPresenter.super.showResetView();
            }
        };
        new DepartureFenceOptions().cardWizardStart = 3;
        SimpleSceneParams build = new SimpleSceneParams.Builder().pinStyle(m13424t()).departureLocationInfo(m13422s()).sceneType(isAnycar() ^ true ? 1 : 0).departurePinCallback(m13420r()).mapChangeListener((IMapChangeListener) r3).context(this.mContext).hasWayPoint(false).endInfo((Address) null).build();
        if (this.mCurrentScene == 0) {
            this.f16201w = null;
            this.f16188i.clearPickUp();
            FormStore.getInstance().setGetOnStartAddress(startAddress);
        }
        this.mOrderConfirmController = null;
        this.mGetOnPageMapController = null;
        this.f16185f = transformToMainPageMapScene(build);
        if (FormStore.getInstance().hasChangeAddressType(2)) {
            doPublish(BaseEventKeys.Map.EVENT_SHOW_RESET_MAP);
        }
        ISimpleMapSceneController iSimpleMapSceneController = this.f16185f;
        if (iSimpleMapSceneController != null) {
            iSimpleMapSceneController.setPadding(getCurrentPadding());
        }
        doPublish(BaseEventKeys.Confirm.EVENT_CONFIRM_SENSE_TOP_WINDOW_VISIBILITY, 8);
        this.mCurrentScene = 1;
    }

    /* renamed from: r */
    private IDeparturePinCallback m13420r() {
        return new IDeparturePinCallback() {
            public /* synthetic */ void onBroadOtherMapCallback(int i) {
                IDeparturePinCallback.CC.$default$onBroadOtherMapCallback(this, i);
            }

            public /* synthetic */ void onClickBroadOtherInStationCard(DepartureAddress departureAddress) {
                IDeparturePinCallback.CC.$default$onClickBroadOtherInStationCard(this, departureAddress);
            }

            public /* synthetic */ void onClickBubble() {
                IDeparturePinCallback.CC.$default$onClickBubble(this);
            }

            public /* synthetic */ void onConfirmPickup(DepartureAddress departureAddress) {
                IDeparturePinCallback.CC.$default$onConfirmPickup(this, departureAddress);
            }

            public /* synthetic */ void onStartDragging() {
                IDeparturePinCallback.CC.$default$onStartDragging(this);
            }

            public /* synthetic */ void onStartSugPage(Address address) {
                IDeparturePinCallback.CC.$default$onStartSugPage(this, address);
            }

            public /* synthetic */ void onStartTerminalWindow(DepartureAddress departureAddress) {
                IDeparturePinCallback.CC.$default$onStartTerminalWindow(this, departureAddress);
            }

            public void onDepartureAddressChanged(DepartureAddress departureAddress) {
                if (departureAddress != null && departureAddress.getAddress() != null) {
                    FormStore.getInstance().setStartParkingProperty(departureAddress.getStartParkingProperty());
                    FormStore.getInstance().setIsShowInterceptorPop(departureAddress.isShowSpecialNotifacation());
                    FormStore.getInstance().setShowRealPicInXpanel(departureAddress.isShowRealPicInXpanel());
                    ConfirmMapFlowDelegateNewPresenter.this.f16188i.update(departureAddress);
                    Address address = departureAddress.getAddress();
                    FormStore.getInstance().setDepartureAddress(address);
                    FormStore.getInstance().setStartAddress(address);
                    ConfirmMapFlowDelegateNewPresenter.this.m13378a(departureAddress);
                    ConfirmMapFlowDelegateNewPresenter.this.m13417p();
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter.m13385b((View) confirmMapFlowDelegateNewPresenter.f16198t);
                    ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, departureAddress);
                } else if (departureAddress == null || departureAddress.getPosition() == null) {
                    ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter2 = ConfirmMapFlowDelegateNewPresenter.this;
                    confirmMapFlowDelegateNewPresenter2.m13371a(confirmMapFlowDelegateNewPresenter2.f16201w);
                } else {
                    ConfirmMapFlowDelegateNewPresenter.this.m13371a(departureAddress.getPosition());
                }
            }

            public void onFetchAddressFail(LatLng latLng) {
                ConfirmMapFlowDelegateNewPresenter.this.m13371a(latLng);
                ConfirmMapFlowDelegateNewPresenter.this.m13411m();
                ConfirmMapFlowDelegateNewPresenter.this.m13417p();
                ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                confirmMapFlowDelegateNewPresenter.m13385b((View) confirmMapFlowDelegateNewPresenter.f16198t);
                ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter2 = ConfirmMapFlowDelegateNewPresenter.this;
                confirmMapFlowDelegateNewPresenter2.doPublish(BaseEventKeys.Confirm.EVENT_CONFORM_GET_ON_SHOW_NORMAL, confirmMapFlowDelegateNewPresenter2.f16198t);
            }

            public void onDepartureLoading(LatLng latLng) {
                LatLng unused = ConfirmMapFlowDelegateNewPresenter.this.f16201w = latLng;
                ConfirmMapFlowDelegateNewPresenter.this.m13378a((DepartureAddress) null);
                ConfirmMapFlowDelegateNewPresenter.this.f16198t.showLoadding();
                ConfirmMapFlowDelegateNewPresenter.this.m13417p();
                ConfirmMapFlowDelegateNewPresenter confirmMapFlowDelegateNewPresenter = ConfirmMapFlowDelegateNewPresenter.this;
                confirmMapFlowDelegateNewPresenter.m13385b((View) confirmMapFlowDelegateNewPresenter.f16198t);
            }

            public void onDragging(int i) {
                FormStore.getInstance().addChangeAddressTypes(1);
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13371a(LatLng latLng) {
        if (latLng != null) {
            Address address = new Address();
            address.latitude = latLng.latitude;
            address.longitude = latLng.longitude;
            address.displayName = ResourcesHelper.getString(this.mContext, R.string.map_flow_the_pin);
            address.fullName = ResourcesHelper.getString(this.mContext, R.string.map_flow_the_pin);
            address.mainTitleDesc = "fail";
            FormStore.getInstance().setDepartureAddress(address);
        }
    }

    public void openSugPage() {
        if (NationComponentDataUtil.getLastKnownLocation() != null || NationComponentDataUtil.isLoginNow()) {
            doPublish(BaseEventKeys.Confirm.EVENT_SHOW_SUG_PAGE);
        } else {
            OneLoginFacade.getAction().go2Login(this.mContext);
        }
    }

    /* access modifiers changed from: protected */
    public void resetMap() {
        ISimpleMapSceneController iSimpleMapSceneController = this.mGetOnPageMapController;
        if (iSimpleMapSceneController != null) {
            iSimpleMapSceneController.setPadding(getCurrentPadding());
            return;
        }
        ISimpleMapSceneController iSimpleMapSceneController2 = this.f16185f;
        if (iSimpleMapSceneController2 != null) {
            iSimpleMapSceneController2.setPadding(getCurrentPadding());
        } else {
            super.resetMap();
        }
    }

    /* access modifiers changed from: protected */
    public void getOnInitBestView(String str, ResetMapEvent resetMapEvent) {
        if (BaseEventKeys.Map.EVENT_GET_ON_SCENE_INIT_MAP.equals(str) && resetMapEvent != null && resetMapEvent.getPadding() != null) {
            this.mCurrentPadding = resetMapEvent.getPadding();
            resetMapEvent.recycle();
            Padding currentPadding = getCurrentPadding();
            ISimpleMapSceneController iSimpleMapSceneController = this.mGetOnPageMapController;
            if (iSimpleMapSceneController != null) {
                iSimpleMapSceneController.setPadding(currentPadding);
                return;
            }
            ISimpleMapSceneController iSimpleMapSceneController2 = this.f16185f;
            if (iSimpleMapSceneController2 != null) {
                iSimpleMapSceneController2.setPadding(currentPadding);
            }
        }
    }

    /* renamed from: s */
    private DepartureLocationInfo m13422s() {
        Address address = this.f16188i.getAddress();
        if (address == null) {
            address = FormStore.getInstance().getStartAddress();
        }
        return new DepartureLocationInfo((LatLng) null, address, "wgs84");
    }

    /* renamed from: t */
    private PinStyle m13424t() {
        PinStyle pinStyle = new PinStyle();
        pinStyle.bigCircleColor = ResourcesHelper.getColor(this.mContext, R.color.g_color_4A4C5B);
        pinStyle.smallCircleColor = ResourcesHelper.getColor(this.mContext, R.color.g_color_00C8A7);
        pinStyle.rectVisible = true;
        pinStyle.rectColor = ResourcesHelper.getColor(this.mContext, R.color.g_color_4A4C5B);
        pinStyle.shadowColor = ResourcesHelper.getColor(this.mContext, R.color.g_color_4A4C5B);
        return pinStyle;
    }

    /* access modifiers changed from: protected */
    public void openRouterEditorPage(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        enterSugPageScene(i, address, fromType, iSugSceneCallback);
    }

    public IOrderConfirmController transformToConfirmScene(OrderConfirmSceneParam orderConfirmSceneParam) {
        return super.transformToConfirmScene(orderConfirmSceneParam);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13377a(final OrderInterceptMode orderInterceptMode, boolean z, String str, String str2, String str3) {
        LEGOBaseDrawerModel clickOutsideCanCancel = new LEGODrawerModel1(str, new LEGOBtnTextAndCallback(str2, new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (orderInterceptMode == OrderInterceptMode.MODE_START_NEAR_END) {
                    ConfirmMapFlowDelegateNewPresenter.this.enterSugPageScene(2, FormStore.getInstance().getEndAddress(), FromType.CONFIRM, ConfirmMapFlowDelegateNewPresenter.this.mGlobalSugCallback);
                }
                if (ConfirmMapFlowDelegateNewPresenter.this.f16187h != null) {
                    ConfirmMapFlowDelegateNewPresenter.this.f16187h.dismiss();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(ConfirmMapFlowDelegateNewPresenter.this.m13366a(orderInterceptMode)));
                hashMap.put("rank", 1);
                GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_mappopup_button_ck", (Map<String, Object>) hashMap);
            }
        })).setIsShowCloseImg(false).setClickOutsideCanCancel(false);
        if (!TextUtils.isEmpty(str3)) {
            clickOutsideCanCancel.addMinorBtn(new LEGOBtnTextAndCallback(str3, new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    if (orderInterceptMode == OrderInterceptMode.MODE_START_POSITION_TO_FAR || orderInterceptMode == OrderInterceptMode.MODE_REC_POSITION_TO_FAR || orderInterceptMode == OrderInterceptMode.MODE_START_NEAR_END || orderInterceptMode == OrderInterceptMode.MODE_REC_POSITION_LEVEL_BAD) {
                        ConfirmMapFlowDelegateNewPresenter.this.doPublish(BaseEventKeys.Service.SendOrder.EVENT_REQUEST_SEND_ORDER);
                    }
                    if (ConfirmMapFlowDelegateNewPresenter.this.f16187h != null) {
                        ConfirmMapFlowDelegateNewPresenter.this.f16187h.dismiss();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("type", Integer.valueOf(ConfirmMapFlowDelegateNewPresenter.this.m13366a(orderInterceptMode)));
                    hashMap.put("rank", 2);
                    GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_mappopup_button_ck", (Map<String, Object>) hashMap);
                }
            }));
        }
        StartDestAbnormalDrawerView startDestAbnormalDrawerView = new StartDestAbnormalDrawerView(this.mContext);
        int i = C662724.f16203x9cf5a386[orderInterceptMode.ordinal()];
        if (i == 1) {
            startDestAbnormalDrawerView.setStartDest(FormStore.getInstance().getStartAddress().getDisplayName(), FormStore.getInstance().getEndAddress().getDisplayName());
        } else if (i == 2) {
            startDestAbnormalDrawerView.setOnlyStart(FormStore.getInstance().getStartAddress().getDisplayName());
        } else if (i != 3) {
            if (i == 4 && z) {
                startDestAbnormalDrawerView.setOnlyStart(FormStore.getInstance().getDepartureAddress().getDisplayName());
            }
        } else if (z) {
            startDestAbnormalDrawerView.setOnlyStart(FormStore.getInstance().getDepartureAddress().getDisplayName());
        } else {
            startDestAbnormalDrawerView.setOnlyStart(FormStore.getInstance().getStartAddress().getDisplayName());
        }
        clickOutsideCanCancel.setExtendedUpView(startDestAbnormalDrawerView);
        this.f16187h = LEGOUICreator.showDrawerTemplate(this.mContext, clickOutsideCanCancel);
        HashMap hashMap = new HashMap();
        hashMap.put("type", Integer.valueOf(m13366a(orderInterceptMode)));
        GlobalOmegaUtils.trackEvent("ibt_gp_orderconfirm_mappopup_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: com.didi.component.mapflow.newpresenter.ConfirmMapFlowDelegateNewPresenter$24 */
    static /* synthetic */ class C662724 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$departure$controller$OrderInterceptMode */
        static final /* synthetic */ int[] f16203x9cf5a386;

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
                com.didi.map.global.component.departure.controller.OrderInterceptMode[] r0 = com.didi.map.global.component.departure.controller.OrderInterceptMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16203x9cf5a386 = r0
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_START_NEAR_END     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f16203x9cf5a386     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_START_POSITION_TO_FAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f16203x9cf5a386     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_REC_POSITION_TO_FAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f16203x9cf5a386     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_REC_POSITION_LEVEL_BAD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f16203x9cf5a386     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.map.global.component.departure.controller.OrderInterceptMode r1 = com.didi.map.global.component.departure.controller.OrderInterceptMode.MODE_NORMAL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.mapflow.newpresenter.ConfirmMapFlowDelegateNewPresenter.C662724.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m13366a(OrderInterceptMode orderInterceptMode) {
        int i = C662724.f16203x9cf5a386[orderInterceptMode.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void enterSugPageScene(int i, Address address, FromType fromType, ISugSceneCallback iSugSceneCallback) {
        this.f16181b.info("ConfirmMapFlowDelegateNew enterSugPageScene..", new Object[0]);
        if (address == null || this.mSugPageContainerId <= 0) {
            Logger logger = this.f16181b;
            logger.error("ConfirmMapFlowDelegateNew target is empty, targetAddress=" + address + " containerId=" + this.mSugPageContainerId, new Object[0]);
            return;
        }
        leaveConfirmScene();
        BaseEventPublisher.getPublisher().publish("event_show_sug_page_container");
        this.mPoiChangedAddress = address;
        this.mOrderConfirmController = null;
        enterNewSugPageScene(i, address, fromType, iSugSceneCallback);
    }
}
