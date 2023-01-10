package com.didi.component.mapflow.presenter;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.address.model.WayPoint;
import com.didi.address.util.SugWayPointsUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.dialog.GlobalDialog;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.map.global.flow.scene.sug.ISubmitWayPointsCallback;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.WayPointDialogModel;
import com.didi.travel.psnger.model.response.WayPointModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbsAfterOrderMapFlowDelegatePresenter extends AbsMapFlowDelegatePresenter {

    /* renamed from: a */
    private static final int f16207a = 1;

    /* renamed from: b */
    private static final int f16208b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<WayPoint> f16209c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ISubmitWayPointsCallback f16210d;

    /* renamed from: e */
    private LEGODrawer f16211e;

    /* access modifiers changed from: protected */
    public boolean addDefaultWayPoint() {
        return false;
    }

    public AbsAfterOrderMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onSubmitWayPoints(FragmentActivity fragmentActivity, List<WayPoint> list, List<WayPoint> list2, ISubmitWayPointsCallback iSubmitWayPointsCallback) {
        GLog.m11354d("zl-route-editor", "[on service] onSubmit WayPoints : " + list + " changed:" + list2);
        if (list != null && !list.isEmpty()) {
            this.f16209c = list;
            m13442a(list);
            this.f16210d = iSubmitWayPointsCallback;
            if (list2 == null || list2.isEmpty()) {
                iSubmitWayPointsCallback.onSuccess();
            } else {
                m13443a(true, fragmentActivity);
            }
        }
    }

    /* renamed from: a */
    private void m13442a(List<WayPoint> list) {
        if (list != null && list.size() > 0) {
            boolean z = false;
            String str = "";
            for (WayPoint next : list) {
                if (next.getWayPointType() == 3) {
                    z = true;
                } else if (next.getWayPointType() == 2) {
                    str = next.getAddress().uid;
                }
            }
            if (!z) {
                for (WayPoint next2 : list) {
                    if (next2.getAddress() != null && str.equals(next2.getAddress().uid)) {
                        next2.setWayPointType(3);
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13443a(boolean z, FragmentActivity fragmentActivity) {
        Address address;
        ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        Address address2 = null;
        loop0:
        while (true) {
            address = address2;
            for (WayPoint next : this.f16209c) {
                if (next.getWayPointType() == 3) {
                    address2 = next.getAddress();
                } else if (next.getWayPointType() == 2) {
                    arrayList.add(next.getAddress());
                    arrayList2.add(next);
                }
            }
            break loop0;
        }
        String jsonStrFromWayPoints = SugWayPointsUtils.getJsonStrFromWayPoints(arrayList2);
        final CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return;
        }
        if (address != null || !arrayList.isEmpty()) {
            GLog.m11354d("zl-route-editor", "[on service] === Request WayPoints Change Api === ");
            GLog.m11354d("zl-route-editor", "[on service] orderId = " + order.oid);
            GLog.m11354d("zl-route-editor", "[on service] destAddress = " + address);
            GLog.m11354d("zl-route-editor", "[on service] stopAddressesJson = " + jsonStrFromWayPoints);
            GLog.m11354d("zl-route-editor", "[on service] wayPointsVersion = " + order.wayPointsVersion);
            final boolean z2 = z;
            final FragmentActivity fragmentActivity2 = fragmentActivity;
            final Address address3 = address;
            CarRequest.updateWayPoints(this.mContext, order.oid, address, jsonStrFromWayPoints, order.wayPointsVersion, z, (Map<String, Object>) null, new ResponseListener<WayPointModel>() {
                public void onSuccess(WayPointModel wayPointModel) {
                    super.onSuccess(wayPointModel);
                    GLog.m11354d("zl-route-editor", "[on service] onSuccess = " + wayPointModel);
                    if (z2) {
                        wayPointModel.setStatus(0);
                        boolean unused = AbsAfterOrderMapFlowDelegatePresenter.this.m13448b(wayPointModel, fragmentActivity2);
                    } else if (wayPointModel.errno == 0) {
                        wayPointModel.setStatus(0);
                        order.wayPointList = arrayList2;
                        Address address = address3;
                        if (address != null) {
                            order.endAddress = address;
                        }
                        order.wayPointsVersion = wayPointModel.getVersion();
                        ToastHelper.showShortInfo(AbsAfterOrderMapFlowDelegatePresenter.this.mContext, AbsAfterOrderMapFlowDelegatePresenter.this.mContext.getString(R.string.global_waypoint_update_success), (int) R.drawable.global_ic_toast_success);
                        BaseEventPublisher.getPublisher().publishSticky(BaseEventKeys.RouteEditor.EVENT_WAY_POINTS_CHANGED, AbsAfterOrderMapFlowDelegatePresenter.this.f16209c);
                        AbsAfterOrderMapFlowDelegatePresenter.this.f16210d.onSuccess();
                        AbsAfterOrderMapFlowDelegatePresenter.this.doPublish(BaseEventKeys.Service.EVENT_WAY_POINT_CHANGED_RECEIVED);
                        AbsAfterOrderMapFlowDelegatePresenter.this.m13446b();
                    } else {
                        AbsAfterOrderMapFlowDelegatePresenter.this.m13441a(wayPointModel, fragmentActivity2);
                    }
                }

                public void onError(WayPointModel wayPointModel) {
                    super.onError(wayPointModel);
                    GLog.m11354d("zl-route-editor", "[on service] onError intercept = " + wayPointModel);
                    AbsAfterOrderMapFlowDelegatePresenter.this.m13446b();
                    AbsAfterOrderMapFlowDelegatePresenter.this.m13441a(wayPointModel, fragmentActivity2);
                }

                public void onFail(WayPointModel wayPointModel) {
                    super.onFail(wayPointModel);
                    GLog.m11354d("zl-route-editor", "[on service] onFail intercept = " + wayPointModel);
                    AbsAfterOrderMapFlowDelegatePresenter.this.m13446b();
                    AbsAfterOrderMapFlowDelegatePresenter.this.m13441a(wayPointModel, fragmentActivity2);
                }

                public void onFinish(WayPointModel wayPointModel) {
                    super.onFinish(wayPointModel);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public List<Integer> getEditableWayPointsType() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        arrayList.add(3);
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public List<WayPoint> getWayPoints() {
        CarOrder order = CarOrderHelper.getOrder();
        ArrayList<WayPoint> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (order != null) {
            if (order.startAddress != null) {
                arrayList.add(0, new WayPoint(1, order.startAddress));
            } else {
                GLog.m11354d("zl-route-editor", "no start address ...");
            }
            if (order.wayPointList == null || order.wayPointList.isEmpty()) {
                GLog.m11354d("zl-route-editor", "no stop address ...");
            } else {
                for (WayPoint next : order.wayPointList) {
                    next.setWayPointType(2);
                    arrayList2.add(next);
                }
            }
            if (order.endAddress != null) {
                arrayList.add(arrayList.size(), new WayPoint(3, order.endAddress));
            } else {
                GLog.m11354d("zl-route-editor", "no end address ...");
            }
        }
        WayPoint wayPoint = null;
        WayPoint wayPoint2 = null;
        for (WayPoint wayPoint3 : arrayList) {
            if (wayPoint3.getWayPointType() == 1) {
                wayPoint = wayPoint3;
            } else if (wayPoint3.getWayPointType() == 3) {
                wayPoint2 = wayPoint3;
            }
        }
        if (wayPoint == null) {
            arrayList.add(0, new WayPoint(1, (Address) null));
        }
        if (wayPoint2 == null) {
            arrayList.add(arrayList.size(), new WayPoint(3, (Address) null));
        }
        if (!arrayList2.isEmpty()) {
            arrayList.addAll(arrayList.size() - 1, arrayList2);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m13439a(FragmentActivity fragmentActivity, String str, String str2, final GlobalDialog.IButtonAction... iButtonActionArr) {
        LEGODrawerModel1 lEGODrawerModel1;
        if (iButtonActionArr.length != 0) {
            LEGODrawer lEGODrawer = this.f16211e;
            if ((lEGODrawer == null || !lEGODrawer.isShowing()) && fragmentActivity != null) {
                LEGOBtnTextAndCallback lEGOBtnTextAndCallback = new LEGOBtnTextAndCallback(iButtonActionArr[0].getName(), new LEGOOnAntiShakeClickListener() {
                    public void onAntiShakeClick(View view) {
                        AbsAfterOrderMapFlowDelegatePresenter.this.m13446b();
                        Runnable action = iButtonActionArr[0].getAction();
                        if (action != null) {
                            action.run();
                        }
                    }
                });
                LEGOBtnTextAndCallback lEGOBtnTextAndCallback2 = null;
                if (iButtonActionArr.length == 2) {
                    lEGOBtnTextAndCallback2 = new LEGOBtnTextAndCallback(iButtonActionArr[1].getName(), new LEGOOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            AbsAfterOrderMapFlowDelegatePresenter.this.m13446b();
                            Runnable action = iButtonActionArr[1].getAction();
                            if (action != null) {
                                action.run();
                            }
                        }
                    });
                }
                if (iButtonActionArr.length == 2) {
                    lEGODrawerModel1 = new LEGODrawerModel1(str, lEGOBtnTextAndCallback2);
                    lEGODrawerModel1.addMinorBtn(lEGOBtnTextAndCallback);
                } else {
                    lEGODrawerModel1 = new LEGODrawerModel1(str, lEGOBtnTextAndCallback);
                }
                lEGODrawerModel1.setSubTitle(str2);
                this.f16211e = LEGOUICreator.showDrawerTemplate(fragmentActivity, lEGODrawerModel1);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m13446b() {
        LEGODrawer lEGODrawer = this.f16211e;
        if (lEGODrawer != null && lEGODrawer.isShowing()) {
            this.f16211e.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13441a(WayPointModel wayPointModel, FragmentActivity fragmentActivity) {
        if (wayPointModel != null) {
            GlobalOmegaUtils.trackEvent("ibt_gp_editroute_submit_error_bt", "err_no", "" + wayPointModel.getErrorCode());
            ISubmitWayPointsCallback iSubmitWayPointsCallback = this.f16210d;
            if (iSubmitWayPointsCallback != null) {
                iSubmitWayPointsCallback.onFailure("");
            }
            wayPointModel.setStatus(1);
            if (TextUtils.isEmpty(wayPointModel.getTitle())) {
                wayPointModel.setTitle(this.mContext.getString(R.string.global_waypoint_alert_title_for_network));
            }
            if (TextUtils.isEmpty(wayPointModel.getMessage())) {
                wayPointModel.setMessage(this.mContext.getString(R.string.global_waypoint_alert_message_for_network));
            }
            m13448b(wayPointModel, fragmentActivity);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m13448b(final WayPointModel wayPointModel, final FragmentActivity fragmentActivity) {
        GLog.m11354d("zl-route-editor", "[on service] onInterceptSubmitRoute WayPointModel : " + wayPointModel);
        if (wayPointModel != null) {
            if (!CollectionUtils.isEmpty((Map) wayPointModel.getLogData())) {
                GlobalOmegaUtils.trackEvent("gp_editRoute_popup_sw", (Map<String, Object>) wayPointModel.getLogData());
            }
            int status = wayPointModel.getStatus();
            if (status == 0) {
                m13439a(fragmentActivity, wayPointModel.getTitle(), wayPointModel.getMessage(), new GlobalDialog.IButtonAction() {
                    public String getName() {
                        WayPointDialogModel cancelDialogModel = wayPointModel.getCancelDialogModel();
                        if (cancelDialogModel != null) {
                            return cancelDialogModel.getContent();
                        }
                        return AbsAfterOrderMapFlowDelegatePresenter.this.mContext.getString(R.string.global_waypoint_alert_cancel);
                    }

                    public Runnable getAction() {
                        return new Runnable() {
                            public void run() {
                                CarOrder order = CarOrderHelper.getOrder();
                                if (order != null) {
                                    GlobalOmegaUtils.trackEvent("gp_editRoute_popupCancel_ck", "title", order.isCapPrice + "");
                                }
                                if (AbsAfterOrderMapFlowDelegatePresenter.this.f16210d != null) {
                                    AbsAfterOrderMapFlowDelegatePresenter.this.f16210d.onFailure("");
                                }
                                AbsAfterOrderMapFlowDelegatePresenter.this.m13446b();
                            }
                        };
                    }

                    public GlobalDialog.IButtonAction.ButtonType getType() {
                        return GlobalDialog.IButtonAction.ButtonType.NEGATIVE;
                    }
                }, new GlobalDialog.IButtonAction() {
                    public String getName() {
                        WayPointDialogModel oKDialogModel = wayPointModel.getOKDialogModel();
                        if (oKDialogModel != null) {
                            return oKDialogModel.getContent();
                        }
                        return AbsAfterOrderMapFlowDelegatePresenter.this.mContext.getString(R.string.global_waypoint_alert_confirm);
                    }

                    public Runnable getAction() {
                        return new Runnable() {
                            public void run() {
                                CarOrder order = CarOrderHelper.getOrder();
                                if (order != null) {
                                    GlobalOmegaUtils.trackEvent("gp_editRoute_popupConfirm_ck", "title", order.isCapPrice + "");
                                }
                                AbsAfterOrderMapFlowDelegatePresenter.this.m13443a(false, fragmentActivity);
                                AbsAfterOrderMapFlowDelegatePresenter.this.m13446b();
                            }
                        };
                    }

                    public GlobalDialog.IButtonAction.ButtonType getType() {
                        return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
                    }
                });
                return true;
            } else if (status == 1) {
                m13439a(fragmentActivity, wayPointModel.getTitle(), wayPointModel.getMessage(), new GlobalDialog.IButtonAction() {
                    public Runnable getAction() {
                        return null;
                    }

                    public String getName() {
                        WayPointDialogModel oKDialogModel = wayPointModel.getOKDialogModel();
                        if (oKDialogModel != null) {
                            return oKDialogModel.getContent();
                        }
                        return AbsAfterOrderMapFlowDelegatePresenter.this.mContext.getString(R.string.global_waypoint_alert_ok);
                    }

                    public GlobalDialog.IButtonAction.ButtonType getType() {
                        return GlobalDialog.IButtonAction.ButtonType.POSITIVE;
                    }
                });
                return true;
            }
        }
        return false;
    }
}
