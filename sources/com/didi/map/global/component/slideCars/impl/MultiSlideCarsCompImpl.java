package com.didi.map.global.component.slideCars.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.slideCars.ISlideCarsCompContract;
import com.didi.map.global.component.slideCars.SlideCarsCompParams;
import com.didi.map.global.component.slideCars.api.ApiType;
import com.didi.map.global.component.slideCars.api.CarNavigatorRequest;
import com.didi.map.global.component.slideCars.api.ICarNavigatorCallback;
import com.didi.map.global.component.slideCars.api.NearCarDriver;
import com.didi.map.global.component.slideCars.model.IDriverChangeListener;
import com.didi.map.global.component.slideCars.navigator.CarDriverModel;
import com.didi.map.global.component.slideCars.navigator.CarNavigatorConfigParam;
import com.didi.map.global.component.slideCars.navigator.NavigatorPresenter;
import com.didi.map.global.model.location.LocationHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.carsliding.api.CarSlidingRender;
import com.didichuxing.carsliding.api.CarSlidingRenderFactory;
import com.didichuxing.carsliding.filter.DistanceFilter;
import com.didichuxing.carsliding.filter.TimestampFilter;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.RenderParams;
import com.didichuxing.carsliding.model.RenderStrategy;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.model.VectorCoordinateList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiSlideCarsCompImpl implements ISlideCarsCompContract {

    /* renamed from: a */
    private static final String f28445a = "SlideCarsCompImpl";

    /* renamed from: b */
    private static final int f28446b = 5000;

    /* renamed from: c */
    private static final int f28447c = 10000;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public int f28448d = 10000;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ArrayList<LatLng> f28449e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CarSlidingRender f28450f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SlideCarsCompParams f28451g;

    /* renamed from: h */
    private Handler f28452h = new Handler(Looper.getMainLooper());

    /* renamed from: i */
    private Map f28453i;

    /* renamed from: j */
    private Context f28454j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f28455k = true;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IDriverChangeListener f28456l;

    /* renamed from: m */
    private CapacitiesReqRunnable f28457m = new CapacitiesReqRunnable();

    /* renamed from: n */
    private NavigatorPresenter f28458n;

    /* renamed from: o */
    private CarNavigatorRequest f28459o;

    /* renamed from: p */
    private boolean f28460p = true;

    public void create(Context context, Map map) {
        this.f28453i = map;
        this.f28454j = context;
        if (this.f28451g != null && map != null && context != null) {
            m22234a();
            int pullIntervalMs = this.f28451g.getPullIntervalMs();
            this.f28448d = pullIntervalMs;
            if (pullIntervalMs < 5000) {
                this.f28448d = 5000;
            }
            this.f28458n = new NavigatorPresenter(this.f28454j, ApiType.MULTI);
        }
    }

    public void destroy() {
        m22239b();
        m22245e();
        Handler handler = this.f28452h;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f28452h = null;
        }
    }

    public void setConfigParam(SlideCarsCompParams slideCarsCompParams) {
        this.f28451g = slideCarsCompParams;
        if (slideCarsCompParams != null) {
            this.f28459o = slideCarsCompParams.getCarSlidingRequestParam();
            this.f28460p = this.f28451g.isShowSlidingCar();
        }
    }

    public void onMapVisible(boolean z) {
        this.f28455k = z;
        if (z) {
            CarSlidingRender carSlidingRender = this.f28450f;
            if (carSlidingRender != null) {
                carSlidingRender.show(false);
            }
            m22235a(1);
            return;
        }
        CarSlidingRender carSlidingRender2 = this.f28450f;
        if (carSlidingRender2 != null) {
            carSlidingRender2.hide(false);
        }
        m22239b();
    }

    public void start() {
        m22235a(10);
    }

    public void stop() {
        m22239b();
    }

    public void reStart(CarNavigatorRequest carNavigatorRequest) {
        if (this.f28453i != null && this.f28451g != null) {
            if (carNavigatorRequest != null) {
                this.f28459o = carNavigatorRequest;
            }
            m22245e();
            m22234a();
            m22235a(10);
        }
    }

    public void setCarVisible(boolean z) {
        CarSlidingRender carSlidingRender = this.f28450f;
        if (carSlidingRender != null) {
            this.f28460p = z;
            if (z) {
                carSlidingRender.show(false);
            } else {
                carSlidingRender.hide(false);
            }
        }
    }

    public void updateLocationPosition(LatLng latLng) {
        CarNavigatorRequest carNavigatorRequest = this.f28459o;
        if (carNavigatorRequest != null && latLng != null) {
            carNavigatorRequest.setStartPosition(latLng);
        }
    }

    public void refreshCarIcon() {
        SlideCarsCompParams slideCarsCompParams;
        if (this.f28450f != null && (slideCarsCompParams = this.f28451g) != null && slideCarsCompParams.getBitmapGetter() != null) {
            this.f28450f.initIcon(this.f28451g.getBitmapGetter().getBitmapDescriptor(), this.f28451g.getBitmapGetter().getDefaultBitmapDescriptor());
        }
    }

    public List<LatLng> getDriverPoints() {
        return this.f28449e;
    }

    public void setListener(IDriverChangeListener iDriverChangeListener) {
        this.f28456l = iDriverChangeListener;
    }

    /* renamed from: a */
    private void m22234a() {
        Map map = this.f28453i;
        if (map != null && this.f28460p) {
            if (this.f28450f == null) {
                this.f28450f = CarSlidingRenderFactory.createRender(map);
            }
            if (this.f28451g.getBitmapGetter() != null) {
                this.f28450f.initIcon(this.f28451g.getBitmapGetter().getBitmapDescriptor(), this.f28451g.getBitmapGetter().getDefaultBitmapDescriptor());
            }
        }
    }

    /* renamed from: b */
    private void m22239b() {
        Handler handler = this.f28452h;
        if (handler != null) {
            handler.removeCallbacks(this.f28457m);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22235a(long j) {
        Handler handler = this.f28452h;
        if (handler != null) {
            handler.removeCallbacks(this.f28457m);
            this.f28452h.postDelayed(this.f28457m, j);
        }
    }

    /* renamed from: c */
    private LatLng m22240c() {
        DIDILocation lastKnownLocation;
        CarNavigatorRequest carNavigatorRequest = this.f28459o;
        if (carNavigatorRequest != null && carNavigatorRequest.getStartPosition() != null) {
            return this.f28459o.getStartPosition();
        }
        Context context = this.f28454j;
        if (context == null || (lastKnownLocation = LocationHelper.getLastKnownLocation(context)) == null) {
            return null;
        }
        return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m22243d() {
        NavigatorPresenter navigatorPresenter;
        CarNavigatorRequest carNavigatorRequest;
        if (this.f28451g != null && this.f28454j != null && LatLngUtils.locateCorrect(m22240c()) && (navigatorPresenter = this.f28458n) != null && (carNavigatorRequest = this.f28459o) != null) {
            navigatorPresenter.getCarNavigatorData(carNavigatorRequest, new ICarNavigatorCallback() {
                public void onSuccess(NearCarDriver nearCarDriver) {
                    VectorCoordinate vectorCoordinate;
                    try {
                        RenderParams navigatorResponse = MultiSlideCarsCompImpl.this.getNavigatorResponse(nearCarDriver);
                        if (!(!MultiSlideCarsCompImpl.this.f28455k || MultiSlideCarsCompImpl.this.f28450f == null || MultiSlideCarsCompImpl.this.f28451g == null)) {
                            if (MultiSlideCarsCompImpl.this.f28451g.getBitmapGetter() != null) {
                                if ((navigatorResponse == null || navigatorResponse.getDriverCollection() == null || navigatorResponse.getDriverCollection().isEmpty()) ? false : true) {
                                    MultiSlideCarsCompImpl.this.f28450f.initIcon(MultiSlideCarsCompImpl.this.f28451g.getBitmapGetter().getBitmapDescriptor(), MultiSlideCarsCompImpl.this.f28451g.getBitmapGetter().getDefaultBitmapDescriptor());
                                    MultiSlideCarsCompImpl.this.f28450f.render(navigatorResponse);
                                    if (MultiSlideCarsCompImpl.this.f28449e == null) {
                                        ArrayList unused = MultiSlideCarsCompImpl.this.f28449e = new ArrayList();
                                    }
                                    MultiSlideCarsCompImpl.this.f28449e.clear();
                                    Iterator it = navigatorResponse.getDriverCollection().iterator();
                                    while (it.hasNext()) {
                                        Driver driver = (Driver) it.next();
                                        if (!(driver == null || driver.getVectorCoordinateList() == null || driver.getVectorCoordinateList().isEmpty() || (vectorCoordinate = (VectorCoordinate) driver.getVectorCoordinateList().get(0)) == null)) {
                                            MultiSlideCarsCompImpl.this.f28449e.add(new LatLng(vectorCoordinate.getLat(), vectorCoordinate.getLng()));
                                        }
                                    }
                                }
                                if (MultiSlideCarsCompImpl.this.f28456l == null) {
                                    return;
                                }
                                MultiSlideCarsCompImpl.this.f28456l.onGetResultSuccess(nearCarDriver);
                                return;
                            }
                        }
                        if (MultiSlideCarsCompImpl.this.f28456l != null) {
                            MultiSlideCarsCompImpl.this.f28456l.onGetResultSuccess(nearCarDriver);
                        }
                    } catch (Exception e) {
                        DLog.m10773d(MultiSlideCarsCompImpl.f28445a, "IRequestCapacityCallback onSuccess 发生异常" + e.getMessage(), new Object[0]);
                        if (MultiSlideCarsCompImpl.this.f28456l == null) {
                        }
                    } catch (Throwable th) {
                        if (MultiSlideCarsCompImpl.this.f28456l != null) {
                            MultiSlideCarsCompImpl.this.f28456l.onGetResultSuccess(nearCarDriver);
                        }
                        throw th;
                    }
                }

                public void onFails(String str) {
                    if (MultiSlideCarsCompImpl.this.f28456l != null) {
                        MultiSlideCarsCompImpl.this.f28456l.onGetResultError(str);
                    }
                    DLog.m10773d(MultiSlideCarsCompImpl.f28445a, "IRequestCapacityCallback onFailure " + str, new Object[0]);
                }
            });
        }
    }

    /* renamed from: e */
    private void m22245e() {
        CarSlidingRender carSlidingRender = this.f28450f;
        if (carSlidingRender != null) {
            carSlidingRender.hide(false);
            this.f28450f.destroy();
            this.f28450f = null;
        }
        ArrayList<LatLng> arrayList = this.f28449e;
        if (arrayList != null) {
            arrayList.clear();
        }
    }

    /* access modifiers changed from: protected */
    public RenderParams getNavigatorResponse(NearCarDriver nearCarDriver) {
        DLog.m10773d(f28445a, "renderParam" + nearCarDriver, new Object[0]);
        if (nearCarDriver == null) {
            return null;
        }
        return initBaseRenderParam(nearCarDriver).create();
    }

    /* access modifiers changed from: protected */
    public DriverCollection getDriverCollection(NearCarDriver nearCarDriver) {
        NearCarDriver nearCarDriver2 = nearCarDriver;
        DriverCollection driverCollection = new DriverCollection();
        if (!(nearCarDriver2 == null || nearCarDriver2.driverLocations == null || nearCarDriver2.driverLocations.isEmpty())) {
            for (NearCarDriver.Loc next : nearCarDriver2.driverLocations) {
                if (next != null) {
                    CarDriverModel carDriverModel = new CarDriverModel(next.driverId + "");
                    VectorCoordinateList vectorCoordinateList = new VectorCoordinateList();
                    List<NearCarDriver.Coordinate> list = next.coords;
                    if (list != null) {
                        for (NearCarDriver.Coordinate next2 : list) {
                            if (next2 != null) {
                                long j = (long) next2.timestamp;
                                VectorCoordinate vectorCoordinate = r8;
                                VectorCoordinate vectorCoordinate2 = new VectorCoordinate(next2.f28438x, next2.f28439y, (float) next2.angle, j);
                                vectorCoordinateList.add(vectorCoordinate);
                            }
                        }
                    }
                    carDriverModel.setVectorCoordinateList(vectorCoordinateList);
                    if (nearCarDriver2.isDebugOpen == 1) {
                        carDriverModel.setDebugStatus(next.debugStatus);
                        carDriverModel.setDebugStatusDetail(next.debugStatusDetail);
                    }
                    carDriverModel.setCarLevel(next.carLevel);
                    driverCollection.add(carDriverModel);
                }
            }
        }
        return driverCollection;
    }

    /* access modifiers changed from: protected */
    public RenderParams.Builder initBaseRenderParam(NearCarDriver nearCarDriver) {
        DriverCollection driverCollection = getDriverCollection(nearCarDriver);
        RenderParams.Builder builder = new RenderParams.Builder();
        if (driverCollection == null) {
            return builder;
        }
        builder.setDriverCollection(driverCollection);
        CarNavigatorConfigParam carNavigatorConfigParam = new CarNavigatorConfigParam();
        carNavigatorConfigParam.setAngleSensitive(true);
        carNavigatorConfigParam.setSlidingTime(5000);
        builder.setSlidingTimeMillis(carNavigatorConfigParam.getSlidingTime());
        if (carNavigatorConfigParam.getRenderStrategy() == 2) {
            builder.setRenderStrategy(RenderStrategy.SLIDE);
        } else {
            builder.setRenderStrategy(RenderStrategy.SKIP);
        }
        builder.setFadeAnimEnable(carNavigatorConfigParam.isFadeAnimInEnable(), carNavigatorConfigParam.isFadeAnimOutEnable());
        builder.setAngleSensitive(carNavigatorConfigParam.isAngleSensitive());
        TimestampFilter timestampFilter = new TimestampFilter();
        DistanceFilter distanceFilter = new DistanceFilter(10.0d);
        builder.addVectorCoordinateFilter(timestampFilter);
        builder.addVectorCoordinateFilter(distanceFilter);
        return builder;
    }

    private class CapacitiesReqRunnable implements Runnable {
        private CapacitiesReqRunnable() {
        }

        public void run() {
            MultiSlideCarsCompImpl.this.m22243d();
            MultiSlideCarsCompImpl multiSlideCarsCompImpl = MultiSlideCarsCompImpl.this;
            multiSlideCarsCompImpl.m22235a((long) multiSlideCarsCompImpl.f28448d);
        }
    }
}
