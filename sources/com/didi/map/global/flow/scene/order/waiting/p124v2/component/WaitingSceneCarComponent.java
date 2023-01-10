package com.didi.map.global.flow.scene.order.waiting.p124v2.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.pax.commonline.CommonLineManager;
import com.didi.map.global.component.markers.view.ScaleAnimMarker;
import com.didi.map.global.component.slideCars.api.ApiType;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ICarNavigatorCallback;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.navigator.NavigatorPresenter;
import com.didi.map.global.flow.scene.order.waiting.p124v2.ICarPositionFlushCallback;
import com.didi.map.global.flow.scene.order.waiting.p124v2.WaitingCarParam;
import com.didi.map.sdk.component.IBaseComponent;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.VectorCoordinate;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.component.WaitingSceneCarComponent */
public class WaitingSceneCarComponent implements IBaseComponent<WaitingCarParam> {

    /* renamed from: a */
    private static final String f29513a = "WaitingSceneCarComponent";

    /* renamed from: f */
    private static final int f29514f = 3000;

    /* renamed from: b */
    private Context f29515b;

    /* renamed from: c */
    private Map f29516c;

    /* renamed from: d */
    private CommonLineManager f29517d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScaleAnimMarker f29518e;

    /* renamed from: g */
    private int f29519g = 3000;

    /* renamed from: h */
    private Driver f29520h;

    /* renamed from: i */
    private FlushCarPositionHandler f29521i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ICarPositionFlushCallback f29522j;

    /* renamed from: k */
    private NavigatorPresenter f29523k;

    /* renamed from: l */
    private CarNavigatorRequest f29524l;

    public void create(Context context, Map map) {
        this.f29515b = context;
        this.f29516c = map;
        if (context != null) {
            this.f29523k = new NavigatorPresenter(context, ApiType.SINGLE);
        }
        FlushCarPositionHandler flushCarPositionHandler = new FlushCarPositionHandler();
        this.f29521i = flushCarPositionHandler;
        flushCarPositionHandler.setResponseCar(this);
    }

    public void destroy() {
        CommonLineManager commonLineManager = this.f29517d;
        if (commonLineManager != null) {
            commonLineManager.destroy();
            this.f29517d = null;
        }
        FlushCarPositionHandler flushCarPositionHandler = this.f29521i;
        if (flushCarPositionHandler != null) {
            flushCarPositionHandler.removeCallbacksAndMessages((Object) null);
            this.f29521i = null;
        }
        ScaleAnimMarker scaleAnimMarker = this.f29518e;
        if (scaleAnimMarker != null) {
            scaleAnimMarker.destroy();
            this.f29518e = null;
        }
        this.f29520h = null;
        this.f29515b = null;
        this.f29516c = null;
        this.f29524l = null;
    }

    public void setConfigParam(WaitingCarParam waitingCarParam) {
        if (waitingCarParam != null) {
            int pullIntervalMs = waitingCarParam.getPullIntervalMs();
            this.f29519g = pullIntervalMs;
            if (pullIntervalMs < 3000) {
                this.f29519g = 3000;
            }
            this.f29522j = waitingCarParam.getCarPositionFlushCallback();
            this.f29524l = waitingCarParam.getCarNavigatorRequest();
        }
    }

    public void onMapVisible(boolean z) {
        CommonLineManager commonLineManager = this.f29517d;
        if (commonLineManager != null) {
            commonLineManager.setLineVisible(z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22859a() {
        Driver driver = this.f29520h;
        if (driver != null) {
            m22861a(driver);
            FlushCarPositionHandler flushCarPositionHandler = this.f29521i;
            if (flushCarPositionHandler != null) {
                flushCarPositionHandler.sendEmptyMessageDelayed(1, (long) this.f29519g);
            }
        }
    }

    public void stopLooper() {
        FlushCarPositionHandler flushCarPositionHandler = this.f29521i;
        if (flushCarPositionHandler != null) {
            flushCarPositionHandler.sendEmptyMessage(0);
        }
    }

    /* renamed from: a */
    private void m22860a(LatLng latLng, Bitmap bitmap, boolean z) {
        if (latLng != null) {
            DLog.m10773d(f29513a, "小车位置：lat" + latLng.latitude + "long" + latLng.longitude, new Object[0]);
            if (this.f29518e == null) {
                DLog.m10773d(f29513a, "初始化小车组件", new Object[0]);
                this.f29518e = new ScaleAnimMarker();
                ScaleAnimMarker.ScaleMarkerParam scaleMarkerParam = new ScaleAnimMarker.ScaleMarkerParam(latLng, bitmap, z);
                scaleMarkerParam.setzIndex(121);
                this.f29518e.setConfigParam(scaleMarkerParam);
                this.f29518e.create(this.f29515b, this.f29516c);
            }
            this.f29518e.showMarker(latLng);
            m22859a();
        }
    }

    /* renamed from: a */
    private void m22861a(Driver driver) {
        CarNavigatorRequest carNavigatorRequest;
        if (driver != null && this.f29523k != null && (carNavigatorRequest = this.f29524l) != null) {
            carNavigatorRequest.setDriverId(driver.getId());
            this.f29523k.getCarNavigatorData(this.f29524l, new ICarNavigatorCallback() {
                public void onSuccess(NearCarDriver nearCarDriver) {
                    List<NearCarDriver.Coordinate> list;
                    LatLng latLng = null;
                    if (((nearCarDriver == null || nearCarDriver.driverLocations == null || nearCarDriver.driverLocations.isEmpty()) ? false : true) && (list = nearCarDriver.driverLocations.get(0).coords) != null && !list.isEmpty() && list.get(0) != null) {
                        latLng = new LatLng(list.get(0).f28438x, list.get(0).f28439y);
                    }
                    if (!(WaitingSceneCarComponent.this.f29518e == null || latLng == null)) {
                        DLog.m10773d(WaitingSceneCarComponent.f29513a, "刷新小车位置：lat" + latLng.latitude + "long" + latLng.longitude, new Object[0]);
                        WaitingSceneCarComponent.this.f29518e.updatePosition(latLng);
                    }
                    if (WaitingSceneCarComponent.this.f29522j != null && latLng != null) {
                        WaitingSceneCarComponent.this.f29522j.onCarPositionFlushed(latLng);
                    }
                }

                public void onFails(String str) {
                    DLog.m10773d(WaitingSceneCarComponent.f29513a, "IRequestCapacityCallback onFailure " + str, new Object[0]);
                }
            });
        }
    }

    public void updateCarIcon(Bitmap bitmap) {
        if (this.f29518e != null && bitmap != null) {
            DLog.m10773d(f29513a, "刷新小车图片", new Object[0]);
            this.f29518e.updateIcon(bitmap);
        }
    }

    /* renamed from: b */
    private LatLng m22862b(Driver driver) {
        if (driver == null || driver.getVectorCoordinateList() == null || driver.getVectorCoordinateList().isEmpty()) {
            return null;
        }
        VectorCoordinate vectorCoordinate = (VectorCoordinate) driver.getVectorCoordinateList().get(0);
        return new LatLng(vectorCoordinate.getLat(), vectorCoordinate.getLng());
    }

    public void showCarMarker(Driver driver, Bitmap bitmap, boolean z) {
        if (driver != null) {
            this.f29520h = driver;
            LatLng b = m22862b(driver);
            Driver driver2 = this.f29520h;
            if (driver2 == null || driver2.getBitmap() == null || this.f29520h.getBitmap().getBitmap() == null) {
                DLog.m10773d(f29513a, "使用默认bitmap", new Object[0]);
            } else {
                DLog.m10773d(f29513a, "使用driver  bitmap", new Object[0]);
                bitmap = this.f29520h.getBitmap().getBitmap();
            }
            m22860a(b, bitmap, z);
        }
    }

    public void hideCarMarker(boolean z) {
        if (this.f29518e != null) {
            DLog.m10773d(f29513a, "隐藏小车图片", new Object[0]);
            this.f29518e.hideMarker(z);
        }
        stopLooper();
    }

    public List<IMapElement> getAllMarkerElements() {
        ArrayList arrayList = new ArrayList();
        ScaleAnimMarker scaleAnimMarker = this.f29518e;
        if (scaleAnimMarker != null) {
            arrayList.addAll(scaleAnimMarker.getMarkerElements());
        }
        CommonLineManager commonLineManager = this.f29517d;
        if (commonLineManager != null) {
            arrayList.addAll(commonLineManager.getBestViewElements());
        }
        return arrayList;
    }

    public List<IMapElement> getCarMarkerElements() {
        ArrayList arrayList = new ArrayList();
        ScaleAnimMarker scaleAnimMarker = this.f29518e;
        if (scaleAnimMarker != null) {
            arrayList.addAll(scaleAnimMarker.getMarkerElements());
        }
        return arrayList;
    }

    /* renamed from: com.didi.map.global.flow.scene.order.waiting.v2.component.WaitingSceneCarComponent$FlushCarPositionHandler */
    private static class FlushCarPositionHandler extends Handler {
        private WeakReference<WaitingSceneCarComponent> waitingSceneComponentWeakReference;

        private FlushCarPositionHandler() {
        }

        public void setResponseCar(WaitingSceneCarComponent waitingSceneCarComponent) {
            this.waitingSceneComponentWeakReference = new WeakReference<>(waitingSceneCarComponent);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                DLog.m10773d(WaitingSceneCarComponent.f29513a, "停止刷新小车图片", new Object[0]);
                removeCallbacksAndMessages((Object) null);
            } else if (i == 1) {
                DLog.m10773d(WaitingSceneCarComponent.f29513a, "启动刷新小车图片", new Object[0]);
                WeakReference<WaitingSceneCarComponent> weakReference = this.waitingSceneComponentWeakReference;
                if (weakReference != null && weakReference.get() != null) {
                    ((WaitingSceneCarComponent) this.waitingSceneComponentWeakReference.get()).m22859a();
                }
            }
        }
    }
}
