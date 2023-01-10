package com.didi.map.global.component.dropoff.core;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.CameraPosition;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy1.IDMarkerContractV1;
import com.didi.map.global.component.dropoff.DropOffCompParam;
import com.didi.map.global.component.dropoff.IDropOffComponentCallback;
import com.didi.map.global.component.dropoff.card.DropOffCardViewController;
import com.didi.map.global.component.dropoff.card.IDropOffCard;
import com.didi.map.global.component.dropoff.card.RichTextInfo;
import com.didi.map.global.component.dropoff.controller.BestViewController;
import com.didi.map.global.component.dropoff.controller.DiscountPoiController;
import com.didi.map.global.component.dropoff.core.DropOffContract;
import com.didi.map.global.component.dropoff.core.DropOffView;
import com.didi.map.global.component.dropoff.core.IDropOffMapListerer;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.pin.DropOffPinView;
import com.didi.map.global.component.dropoff.pin.IDropOffPinView;
import com.didi.map.global.component.dropoff.recmarker.DropOffBubbleView;
import com.didi.map.global.component.dropoff.util.DropOffOmegaTracker;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.global.component.recmarker.IRecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerController;
import com.didi.map.global.component.recmarker.RecMarkerControllerParam;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.map.global.component.recmarker.model.RecPointStyle;
import com.didi.map.global.component.recmarker.view.IRecMarker;
import com.didi.map.global.component.recmarker.view.OnRecMarkClickListener;
import com.sdk.poibase.model.RpcPoi;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class DropOffView implements IDropOffCard.DropOffCardCallback, DropOffContract.View, IDropOffMapListerer {

    /* renamed from: a */
    private static final String f27752a = "DropOffView";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f27753b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Map f27754c;

    /* renamed from: d */
    private DropOffCompParam f27755d;

    /* renamed from: e */
    private DropOffContract.Presenter f27756e;

    /* renamed from: f */
    private IDropOffComponentCallback f27757f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public DropOffLocationInfo f27758g;

    /* renamed from: h */
    private DropOffAddress f27759h;

    /* renamed from: i */
    private boolean f27760i;

    /* renamed from: j */
    private boolean f27761j;

    /* renamed from: k */
    private IDropOffPinView f27762k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IRecMarkerController f27763l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DropOffCardViewController f27764m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View f27765n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BestViewController f27766o;

    /* renamed from: p */
    private float f27767p;

    /* renamed from: q */
    private Padding f27768q;

    /* renamed from: r */
    private boolean f27769r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f27770s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public DiscountPoiController f27771t;

    /* renamed from: u */
    private ICollideStrategy f27772u;

    /* renamed from: v */
    private DiscountPoiController.WalkLineResultListener f27773v = new DiscountPoiController.WalkLineResultListener() {
        public void onGetEtaEda(boolean z, int i, int i2) {
            if (DropOffView.this.f27771t != null && DropOffView.this.f27770s && DropOffView.this.f27764m != null && !TextUtils.isEmpty(DropOffView.this.f27758g.sugPoi.xpanelDesc)) {
                String str = DropOffView.this.f27758g.sugPoi.xpanelDesc;
                String generateSubTitleRichJson = DropOffView.this.f27771t.generateSubTitleRichJson(str.replace("{{distance}}", String.valueOf(i2) + "m").replace("{{duration}}", String.valueOf(i)));
                DropOffUtils.LOGD("discountXXX desc = " + generateSubTitleRichJson);
                DropOffView.this.f27764m.setSubTitle(generateSubTitleRichJson);
                if (DropOffView.this.f27765n != null) {
                    DropOffView.this.f27765n.postDelayed(new Runnable() {
                        public final void run() {
                            DropOffView.C102511.this.lambda$onGetEtaEda$0$DropOffView$1();
                        }
                    }, 100);
                }
            }
        }

        public /* synthetic */ void lambda$onGetEtaEda$0$DropOffView$1() {
            if (DropOffView.this.f27766o != null && DropOffView.this.f27771t != null && DropOffView.this.f27765n != null) {
                DropOffView.this.f27766o.setMapPadding(new Padding(0, 0, 0, DropOffView.this.f27765n.getHeight() + DisplayUtils.dp2px(DropOffView.this.f27753b, 10.0f)));
                DropOffView.this.f27766o.discountAdjustMapCameraIncludesInternal(DropOffView.this.f27758g, DropOffView.this.f27771t.getMapElements());
            }
        }
    };

    /* renamed from: w */
    private double f27774w;

    /* renamed from: x */
    private boolean f27775x;

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21919d() {
    }

    /* renamed from: e */
    private int m21920e() {
        return 1;
    }

    public /* synthetic */ boolean onDoubleTap(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onDoubleTap(this, f, f2);
    }

    public /* synthetic */ boolean onFling(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onFling(this, f, f2);
    }

    public /* synthetic */ boolean onLongPress(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onLongPress(this, f, f2);
    }

    public /* synthetic */ boolean onSingleTap(float f, float f2) {
        return IDropOffMapListerer.CC.$default$onSingleTap(this, f, f2);
    }

    public DropOffView(Context context, Map map, DropOffCompParam dropOffCompParam) {
        this.f27753b = context;
        this.f27754c = map;
        this.f27755d = dropOffCompParam;
        this.f27758g = dropOffCompParam.getLocationInfo();
        this.f27757f = dropOffCompParam.getComponentCallback();
        this.f27766o = new BestViewController(this.f27754c);
        DropOffPresenter dropOffPresenter = new DropOffPresenter(this, dropOffCompParam);
        this.f27756e = dropOffPresenter;
        dropOffPresenter.setContext(this.f27753b, this.f27754c);
        this.f27767p = dropOffCompParam.getZoom();
        int dp2px = DisplayUtils.dp2px(this.f27753b, 90.0f);
        int dp2px2 = DisplayUtils.dp2px(this.f27753b, 45.0f);
        Map map2 = this.f27754c;
        if (map2 != null && map2.getMapVendor() == MapVendor.GOOGLE) {
            dp2px2 = DisplayUtils.dp2px(this.f27753b, 50.0f);
        }
        Padding padding = new Padding(dp2px, dp2px2, dp2px, dp2px2);
        this.f27768q = padding;
        this.f27766o.setInPadding(padding);
    }

    public void start() {
        DropOffLocationInfo dropOffLocationInfo = this.f27758g;
        if (dropOffLocationInfo != null && dropOffLocationInfo.sugPoi != null) {
            m21911b();
            m21916c();
            this.f27764m = new DropOffCardViewController(this.f27753b, this);
            if (this.f27758g.sugPoi.isDiscountPoi) {
                DiscountPoiController discountPoiController = new DiscountPoiController(this.f27753b, this.f27754c, this.f27758g);
                this.f27771t = discountPoiController;
                discountPoiController.setWalkLineResultListener(this.f27773v);
                this.f27771t.start();
                m21906a();
                this.f27766o.discountStart(this.f27758g);
            } else {
                getDropOffData(this.f27758g, false);
                this.f27766o.start(this.f27758g);
            }
            this.f27770s = true;
        }
    }

    /* renamed from: a */
    private void m21906a() {
        DropOffContract.Presenter presenter = this.f27756e;
        if (presenter != null) {
            presenter.getDiscountData();
        }
    }

    public void getDropOffData(DropOffLocationInfo dropOffLocationInfo, boolean z) {
        DropOffContract.Presenter presenter = this.f27756e;
        if (presenter != null) {
            presenter.startDataTask(dropOffLocationInfo, z);
        }
    }

    /* renamed from: b */
    private void m21911b() {
        Map map = this.f27754c;
        if (map != null) {
            map.addOnMapGestureListener(this);
            this.f27754c.addOnCameraChangeListener(this);
        }
    }

    /* renamed from: c */
    private void m21916c() {
        if (this.f27755d != null && this.f27754c != null) {
            m21930j();
            DropOffPinView dropOffPinView = new DropOffPinView(this.f27753b);
            this.f27762k = dropOffPinView;
            dropOffPinView.create(this.f27753b, this.f27754c);
            this.f27762k.setConfigParam(this.f27755d.getPinStyle());
            this.f27762k.add();
        }
    }

    public void adjustMapCamera(Padding padding) {
        this.f27766o.setMapPadding(padding);
        this.f27766o.setPinViewAttachListener(new BestViewController.PinViewAttachListener() {
            public final void onAttach(LatLng latLng) {
                DropOffView.this.m21907a(latLng);
            }
        });
        m21910a(!this.f27761j);
    }

    /* renamed from: a */
    private void m21910a(boolean z) {
        if (this.f27766o != null) {
            DropOffContract.Presenter presenter = this.f27756e;
            List<RpcPoi> list = null;
            RpcPoi adsorptionPoi = presenter != null ? presenter.getAdsorptionPoi() : null;
            DropOffContract.Presenter presenter2 = this.f27756e;
            if (presenter2 != null) {
                list = presenter2.getReconmmendRpcPois();
            }
            List<RpcPoi> list2 = list;
            if (!this.f27758g.sugPoi.isDiscountPoi || this.f27771t == null) {
                this.f27766o.adjustMapCameraInternal(z, adsorptionPoi, this.f27758g, list2, this.f27775x, this.f27767p, new BestViewer.IBestViewListener() {
                    public final void onFinished() {
                        DropOffView.this.m21919d();
                    }
                });
            } else {
                this.f27766o.discountAdjustMapCameraInternal(this.f27758g, new BestViewer.IBestViewListener() {
                    public final void onFinished() {
                        DropOffView.this.m21919d();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21907a(LatLng latLng) {
        IRecMarkerController iRecMarkerController = this.f27763l;
        if (iRecMarkerController != null) {
            ((RecMarkerController) iRecMarkerController).updateMarkerPinedState(latLng);
        }
    }

    public void onMapVisible(boolean z) {
        this.f27769r = z;
    }

    public void onDataLoading() {
        IDropOffPinView iDropOffPinView = this.f27762k;
        if (iDropOffPinView != null) {
            iDropOffPinView.startLoading(false);
        }
        DropOffCardViewController dropOffCardViewController = this.f27764m;
        if (dropOffCardViewController != null) {
            this.f27765n = dropOffCardViewController.onDataLoading();
        }
        IDropOffComponentCallback iDropOffComponentCallback = this.f27757f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onDropoffLoading(this.f27765n);
        }
    }

    /* renamed from: a */
    private String m21905a(DropOffAddress dropOffAddress) {
        if (dropOffAddress == null || dropOffAddress.getExtendInfo() == null) {
            return null;
        }
        RichTextInfo richTextInfo = new RichTextInfo();
        richTextInfo.setInfo(dropOffAddress.getExtendInfo().getBubbleText());
        return richTextInfo.getContent();
    }

    public void showCardView(DropOffAddress dropOffAddress) {
        if (this.f27764m != null) {
            this.f27765n = this.f27764m.getView(m21920e(), dropOffAddress);
            DropOffUtils.LOGD(" show card view ");
        }
    }

    public void refreshPinView(DropOffAddress dropOffAddress) {
        m21917c(dropOffAddress);
    }

    public void onAddressFetchResult(boolean z, DropOffAddress dropOffAddress) {
        m21913b(dropOffAddress);
        this.f27759h = dropOffAddress;
        IDropOffComponentCallback iDropOffComponentCallback = this.f27757f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onDropOffAddressChanged(z, dropOffAddress, this.f27765n);
        }
        DropOffUtils.LOGD(" notify Address = " + dropOffAddress);
    }

    /* renamed from: b */
    private void m21913b(DropOffAddress dropOffAddress) {
        DropOffAddress dropOffAddress2 = this.f27759h;
        if (dropOffAddress2 != null && dropOffAddress != null && dropOffAddress2.getAddress() != null && dropOffAddress.getAddress() != null) {
            double d = 0.0d;
            Map map = this.f27754c;
            if (map != null) {
                d = map.getCameraPosition().zoom;
            }
            DropOffOmegaTracker.trackMapDragged(this.f27759h, dropOffAddress, d);
        }
    }

    public void onCardItemClick(int i) {
        if (i == 0) {
            int i2 = 1;
            RpcPoi rpcPoi = null;
            DropOffContract.Presenter presenter = this.f27756e;
            if (presenter != null) {
                rpcPoi = presenter.getAdsorptionPoi();
            }
            if (this.f27761j) {
                i2 = rpcPoi != null ? 2 : 3;
            }
            DropOffAddress dropOffAddress = this.f27759h;
            if (!(dropOffAddress == null || dropOffAddress.getAddress() == null)) {
                DropOffOmegaTracker.trackConfirmClick(this.f27759h, i2);
            }
        }
        IDropOffComponentCallback iDropOffComponentCallback = this.f27757f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onCardViewOperation(i);
        }
        DropOffUtils.LOGD(" on card operation = " + i);
    }

    /* renamed from: c */
    private void m21917c(DropOffAddress dropOffAddress) {
        if (this.f27762k != null) {
            String a = dropOffAddress != null ? m21905a(dropOffAddress) : "";
            if (TextUtils.isEmpty(a)) {
                a = this.f27753b.getResources().getString(R.string.GRider_destination_Departure_point_lmkd);
            }
            this.f27762k.showText(a);
        }
    }

    public void showReconmmnedMarkers(List<RecPoint> list, RecPoint recPoint) {
        DropOffUtils.LOGD(" show rec markers ");
        m21909a(list, recPoint);
    }

    /* renamed from: a */
    private void m21909a(List<RecPoint> list, RecPoint recPoint) {
        if (!CollectionUtil.isEmpty((Collection<?>) list) && this.f27755d != null && this.f27754c != null && this.f27753b != null) {
            m21923f();
            RecMarkerController recMarkerController = new RecMarkerController();
            this.f27763l = recMarkerController;
            recMarkerController.create(this.f27754c.getContext(), this.f27754c);
            this.f27763l.setNeedShowInfoWindow(false);
            RecMarkerControllerParam recMarkerControllerParam = new RecMarkerControllerParam();
            recMarkerControllerParam.list = list;
            recMarkerControllerParam.pinedPoint = recPoint;
            RecPointStyle recPointStyle = DropOffUtils.getRecPointStyle(this.f27753b, this.f27755d.getRecPointStyle());
            if (recPointStyle != null) {
                recMarkerControllerParam.icon = recPointStyle.icon;
                recMarkerControllerParam.selectedIcon = recPointStyle.selectedIcon;
            }
            recMarkerControllerParam.isClickable = true;
            recMarkerControllerParam.markerClickListener = new OnRecMarkClickListener() {
                public final void onClick(IRecMarker iRecMarker) {
                    DropOffView.this.m21908a(iRecMarker);
                }
            };
            recMarkerControllerParam.isShowLabel = true;
            recMarkerControllerParam.labelView = new DropOffBubbleView();
            recMarkerControllerParam.labelDirection = 4;
            ICollideStrategy collideStrategyV1 = CollideStrategyFactory.getCollideStrategyV1(new IDMarkerContractV1() {
                public int getDefaultLabelPosition() {
                    return 4;
                }

                public /* synthetic */ List<Rect> getDisabledRect() {
                    return IDMarkerContractV1.CC.$default$getDisabledRect(this);
                }

                public int getEnableLabelPosition() {
                    return 68;
                }

                public /* synthetic */ int getHot(String str) {
                    return IDMarkerContractV1.CC.$default$getHot(this, str);
                }

                public /* synthetic */ boolean getIsLabelHideWhenPined() {
                    return IDMarkerContractV1.CC.$default$getIsLabelHideWhenPined(this);
                }

                public boolean isCanWork() {
                    return true;
                }

                public boolean isLabelDirectClockwise() {
                    return true;
                }

                public /* synthetic */ boolean isPined(String str) {
                    return IDMarkerContractV1.CC.$default$isPined(this, str);
                }

                public /* synthetic */ boolean isZoomConditionOnly() {
                    return IDMarkerContractV1.CC.$default$isZoomConditionOnly(this);
                }

                public Map getMap() {
                    return DropOffView.this.f27754c;
                }

                public void setLabelDirect(String str, int i) {
                    if (DropOffView.this.f27763l != null) {
                        DropOffView.this.f27763l.setLabelDirect(str, i);
                    }
                }

                public void setVisible(String str, boolean z) {
                    if (DropOffView.this.f27763l != null) {
                        DropOffView.this.f27763l.setVisible(str, z);
                    }
                }
            });
            this.f27772u = collideStrategyV1;
            recMarkerControllerParam.strategy = collideStrategyV1;
            this.f27763l.setConfigParam(recMarkerControllerParam);
            this.f27763l.add();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21908a(IRecMarker iRecMarker) {
        if (this.f27756e != null && !LatLngUtils.isSameLatLng(iRecMarker.getLocation(), DropOffUtils.getMapCenterPoint(this.f27754c))) {
            RpcPoi neareatReconmmendPoi = this.f27756e.getNeareatReconmmendPoi(iRecMarker.getLocation());
            if (neareatReconmmendPoi == null) {
                DropOffUtils.LOGD(" rec click point == null ");
                return;
            }
            DropOffAddress dropOffAddress = this.f27756e.getDropOffAddress(neareatReconmmendPoi);
            this.f27775x = true;
            RpcPoi rpcPoi = neareatReconmmendPoi;
            this.f27766o.attachPinViewToAdsorptionPoi(rpcPoi, new LatLng(neareatReconmmendPoi.base_info.lat, neareatReconmmendPoi.base_info.lng), true, true, false, this.f27767p);
            showCardView(dropOffAddress);
            onAddressFetchResult(true, dropOffAddress);
            if (neareatReconmmendPoi != null && neareatReconmmendPoi.base_info != null) {
                DropOffOmegaTracker.trackRecMarkerClick(neareatReconmmendPoi);
            }
        }
    }

    /* renamed from: f */
    private void m21923f() {
        ICollideStrategy iCollideStrategy = this.f27772u;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f27772u = null;
        }
        IRecMarkerController iRecMarkerController = this.f27763l;
        if (iRecMarkerController != null) {
            iRecMarkerController.destroy();
            this.f27763l = null;
        }
    }

    public boolean onDown(float f, float f2) {
        Map map = this.f27754c;
        if (map == null) {
            return false;
        }
        this.f27774w = map.getCameraPosition().zoom;
        return false;
    }

    public boolean onUp(float f, float f2) {
        Map map = this.f27754c;
        if (map == null) {
            return false;
        }
        double d = map.getCameraPosition().zoom;
        if (Math.abs(this.f27774w - d) <= 0.30000001192092896d) {
            return false;
        }
        this.f27775x = true;
        LatLng mapCenterPoint = DropOffUtils.getMapCenterPoint(this.f27754c);
        if (mapCenterPoint == null) {
            return false;
        }
        DropOffOmegaTracker.trackMapZoomChanged(this.f27758g.sugPoi.poiId, mapCenterPoint, this.f27774w, d);
        return false;
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        DropOffUtils.LOGD("camera position zoom = " + cameraPosition.zoom);
    }

    public boolean onScroll(float f, float f2) {
        IRecMarkerController iRecMarkerController = this.f27763l;
        if (iRecMarkerController != null) {
            iRecMarkerController.onMapScroll();
        }
        m21925g();
        this.f27760i = true;
        return false;
    }

    /* renamed from: g */
    private void m21925g() {
        IDropOffPinView iDropOffPinView = this.f27762k;
        if (iDropOffPinView != null) {
            iDropOffPinView.startDragging();
        }
        IDropOffComponentCallback iDropOffComponentCallback = this.f27757f;
        if (iDropOffComponentCallback != null) {
            iDropOffComponentCallback.onStartDragging();
        }
    }

    public void onMapStable() {
        m21927h();
        this.f27760i = false;
    }

    /* renamed from: h */
    private void m21927h() {
        IRecMarkerController iRecMarkerController = this.f27763l;
        if (iRecMarkerController != null) {
            iRecMarkerController.onMapStable();
        }
        if (this.f27760i) {
            m21912b(DropOffUtils.getMapCenterPoint(this.f27754c));
            this.f27761j = true;
        }
    }

    /* renamed from: b */
    private void m21912b(LatLng latLng) {
        DropOffLocationInfo dropOffLocationInfo;
        if (!LatLngUtils.locateCorrect(latLng) || (dropOffLocationInfo = this.f27758g) == null || !this.f27769r) {
            m21917c(this.f27759h);
        } else if (LatLngUtils.isSameLatLng(dropOffLocationInfo.latLng, latLng)) {
            m21917c(this.f27759h);
        } else {
            this.f27758g.latLng = latLng;
            m21929i();
            DropOffCardViewController dropOffCardViewController = this.f27764m;
            if (dropOffCardViewController != null) {
                dropOffCardViewController.setSubTitle("");
            }
            getDropOffData(this.f27758g, true);
        }
    }

    /* renamed from: i */
    private void m21929i() {
        DiscountPoiController discountPoiController = this.f27771t;
        if (discountPoiController != null) {
            discountPoiController.destroy();
            this.f27771t = null;
        }
    }

    public void destroy() {
        this.f27760i = false;
        this.f27761j = false;
        this.f27775x = false;
        this.f27774w = 0.0d;
        m21931k();
        m21930j();
        m21923f();
        BestViewController bestViewController = this.f27766o;
        if (bestViewController != null) {
            bestViewController.destroy();
            this.f27766o = null;
        }
        m21929i();
        Map map = this.f27754c;
        if (map != null) {
            map.stopAnimation();
        }
        this.f27754c = null;
        this.f27759h = null;
        this.f27756e.destroy();
        this.f27756e = null;
        this.f27757f = null;
        this.f27770s = false;
    }

    /* renamed from: j */
    private void m21930j() {
        IDropOffPinView iDropOffPinView = this.f27762k;
        if (iDropOffPinView != null) {
            iDropOffPinView.destroy();
            this.f27762k = null;
        }
    }

    /* renamed from: k */
    private void m21931k() {
        Map map = this.f27754c;
        if (map != null) {
            map.removeOnMapGestureListener(this);
            this.f27754c.removeOnCameraChangeListener(this);
        }
    }
}
