package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.ImageView;
import com.didi.common.map.BestViewer;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnMapLongClickListener;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.ImageUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy1.IDMarkerContractV1;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersCompParams;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.OnMarkerCompClickListener;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.map.language.LocaleCodeHolder;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.IPoiBaseApi;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FuzzyMatchAddressComponent implements BaseComponent<RpcPoi> {

    /* renamed from: j */
    private static final int f8929j = 0;

    /* renamed from: k */
    private static final int f8930k = 1;

    /* renamed from: l */
    private static final int f8931l = 2;

    /* renamed from: A */
    private AdapterMoveBackQuestionCallback f8932A;

    /* renamed from: a */
    ICollideStrategy f8933a = CollideStrategyFactory.getCollideStrategyV1(new IDMarkerContractV1() {
        public int getDefaultLabelPosition() {
            return 4;
        }

        public /* synthetic */ List<Rect> getDisabledRect() {
            return IDMarkerContractV1.CC.$default$getDisabledRect(this);
        }

        public int getEnableLabelPosition() {
            return 68;
        }

        public boolean getIsLabelHideWhenPined() {
            return true;
        }

        public boolean isCanWork() {
            return true;
        }

        public /* synthetic */ boolean isLabelDirectClockwise() {
            return IDMarkerContractV1.CC.$default$isLabelDirectClockwise(this);
        }

        public /* synthetic */ boolean isZoomConditionOnly() {
            return IDMarkerContractV1.CC.$default$isZoomConditionOnly(this);
        }

        public Map getMap() {
            return FuzzyMatchAddressComponent.this.f8936d;
        }

        public boolean isPined(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.equals("id_reverse_point") || str.equals(FuzzyMatchAddressComponent.this.f8955z)) {
                return true;
            }
            return false;
        }

        public int getHot(String str) {
            if (FuzzyMatchAddressComponent.this.f8938f == null) {
                return 0;
            }
            return FuzzyMatchAddressComponent.this.f8938f.getMarkerZindex(str);
        }

        public void setLabelDirect(String str, int i) {
            if (FuzzyMatchAddressComponent.this.f8938f != null) {
                FuzzyMatchAddressComponent.this.f8938f.updateMarkerLabelDirect(str, i);
            }
        }

        public void setVisible(String str, boolean z) {
            if (FuzzyMatchAddressComponent.this.f8938f != null) {
                FuzzyMatchAddressComponent.this.f8938f.setMarkerVisible(str, z);
                if (z && isPined(str)) {
                    FuzzyMatchAddressComponent.this.f8938f.setLabelVisible(str, false);
                    SystemUtils.log(6, "ccc", "isPined , hide label " + str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent$1", 142);
                } else if (!z || isPined(str)) {
                    FuzzyMatchAddressComponent.this.f8938f.setLabelVisible(str, false);
                    SystemUtils.log(6, "ccc", "other , hide label " + str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent$1", 148);
                } else {
                    FuzzyMatchAddressComponent.this.f8938f.setLabelVisible(str, true);
                    SystemUtils.log(6, "ccc", "not pined , show label " + str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent$1", 145);
                }
            }
        }
    });

    /* renamed from: b */
    private final String f8934b = "FuzzyMatchAddressComponent";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f8935c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map f8936d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FuzzyMatchOperationCallback f8937e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public IMarkersCompContract f8938f;

    /* renamed from: g */
    private List<RpcPoi> f8939g = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RpcPoi f8940h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f8941i = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public Padding f8942m;

    /* renamed from: n */
    private IPoiBaseApi f8943n;

    /* renamed from: o */
    private final int f8944o = 100;

    /* renamed from: p */
    private final int f8945p = 110;

    /* renamed from: q */
    private int f8946q = 0;

    /* renamed from: r */
    private boolean f8947r = false;

    /* renamed from: s */
    private int f8948s = R.drawable.icon_map_select_start;

    /* renamed from: t */
    private int f8949t = R.drawable.icon_map_select_end;

    /* renamed from: u */
    private int f8950u = R.drawable.icon_map_unselect_start;

    /* renamed from: v */
    private int f8951v = R.drawable.icon_map_unselect_end;

    /* renamed from: w */
    private final String f8952w = "id_reverse_point";
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f8953x = false;

    /* renamed from: y */
    private int f8954y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public String f8955z;

    public interface AdapterMoveBackQuestionCallback {
        boolean onMoveBack();
    }

    public void onMapVisible(boolean z) {
    }

    public void setAdapterMoveBackQuestionCallback(AdapterMoveBackQuestionCallback adapterMoveBackQuestionCallback) {
        this.f8932A = adapterMoveBackQuestionCallback;
    }

    public void create(Context context, Map map) {
        if (map != null && context != null) {
            this.f8935c = context;
            this.f8936d = map;
            m7646a();
        }
    }

    public void setPadding(Padding padding) {
        boolean z = true;
        if (this.f8941i == 1 && this.f8942m != null) {
            z = false;
        }
        this.f8942m = padding;
        if (z) {
            doBestView(padding);
            return;
        }
        Map map = this.f8936d;
        if (map != null && padding != null && map.getMapVendor() != MapVendor.DIDI) {
            Map map2 = this.f8936d;
            BestViewer.doBestView(map2, false, Float.valueOf((float) map2.getCameraPosition().zoom), this.f8936d.getCameraPosition().target, this.f8942m, (BestViewer.IBestViewListener) new BestViewer.IBestViewListener() {
                public void onFinished() {
                }
            });
        }
    }

    public void doBestView(Padding padding) {
        this.f8942m = padding;
        ArrayList arrayList = new ArrayList();
        int i = this.f8941i;
        if (i == 0) {
            arrayList.addAll(getAllElements());
        } else if (i == 1) {
            arrayList.addAll(getAllElements());
        } else if (i == 2) {
            arrayList.addAll(getAllElements());
        }
        BestViewer.doBestView(this.f8936d, true, (List<IMapElement>) arrayList, this.f8942m, (Padding) null, (BestViewer.IBestViewListener) null);
    }

    public List<IMapElement> getAllElements() {
        ArrayList arrayList = new ArrayList();
        IMarkersCompContract iMarkersCompContract = this.f8938f;
        if (iMarkersCompContract != null && !CollectionUtil.isEmpty((Collection<?>) iMarkersCompContract.getAllMarkers())) {
            arrayList.addAll(this.f8938f.getAllMarkers());
        }
        return arrayList;
    }

    public void onDestroy() {
        m7660c();
        this.f8936d = null;
        this.f8935c = null;
        this.f8943n = null;
    }

    public void setParamConfig(FuzzyMatchParam fuzzyMatchParam) {
        if (fuzzyMatchParam != null) {
            this.f8939g.addAll(fuzzyMatchParam.getAddressData());
            this.f8937e = fuzzyMatchParam.getCallback();
            this.f8940h = fuzzyMatchParam.getSelectAddress();
            this.f8946q = fuzzyMatchParam.getAddressType();
            this.f8947r = fuzzyMatchParam.isGroup();
            this.f8954y = fuzzyMatchParam.getPageFrom();
        }
    }

    /* renamed from: a */
    private void m7646a() {
        if (this.f8936d != null && this.f8935c != null) {
            if (this.f8940h == null) {
                this.f8941i = 0;
            } else if (this.f8947r) {
                this.f8941i = 2;
            } else {
                this.f8941i = 1;
            }
            m7654b();
            this.f8936d.addOnMapLongClickListener(new OnMapLongClickListener() {
                public final void onMapLongClick(LatLng latLng) {
                    FuzzyMatchAddressComponent.this.m7661c(latLng);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m7661c(LatLng latLng) {
        AdapterMoveBackQuestionCallback adapterMoveBackQuestionCallback = this.f8932A;
        if (adapterMoveBackQuestionCallback != null && adapterMoveBackQuestionCallback.onMoveBack()) {
            DLog.m10773d("FuzzyMatchAddressComponent", "moveback 导致无法反解图钉", new Object[0]);
        } else if (this.f8936d != null && this.f8935c != null && this.f8941i != 2 && LatLngUtils.locateCorrect(latLng)) {
            DLog.m10773d("FuzzyMatchAddressComponent", "添加 reverse 点 图钉", new Object[0]);
            m7662d();
            m7656b(latLng);
            m7648a(latLng);
        }
    }

    public void onSelectValueChanged(RpcPoi rpcPoi, boolean z) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f8939g) && this.f8938f != null && rpcPoi != null && !this.f8953x) {
            if (z) {
                this.f8941i = 2;
            } else {
                this.f8941i = 1;
            }
            if (rpcPoi.base_info != null) {
                m7657b(rpcPoi);
                this.f8940h = rpcPoi;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public RpcPoi m7645a(String str) {
        if (CollectionUtil.isEmpty((Collection<?>) this.f8939g)) {
            return null;
        }
        for (RpcPoi next : this.f8939g) {
            if (next != null) {
                if (next.base_info != null && next.base_info.poi_id.equals(str)) {
                    return next;
                }
                if (!CollectionUtil.isEmpty((Collection<?>) next.sub_poi_list)) {
                    Iterator<RpcPoi> it = next.sub_poi_list.iterator();
                    while (it.hasNext()) {
                        RpcPoi next2 = it.next();
                        if (next2 != null && next2.base_info != null && next2.base_info.poi_id.equals(str)) {
                            return next2;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m7654b() {
        RpcPoi rpcPoi;
        if (!CollectionUtil.isEmpty((Collection<?>) this.f8939g) && this.f8935c != null && this.f8936d != null) {
            DLog.m10773d("FuzzyMatchAddressComponent", " initMarkerComponent currentStatus: " + this.f8941i, new Object[0]);
            boolean z = this.f8941i != 0;
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < this.f8939g.size()) {
                RpcPoi rpcPoi2 = this.f8939g.get(i);
                MarkerModel markerModel = null;
                boolean z2 = i < 3 || this.f8941i == 2;
                if (z) {
                    if (!((rpcPoi2 == null || rpcPoi2.base_info == null || (rpcPoi = this.f8940h) == null || rpcPoi.base_info == null || !rpcPoi2.base_info.poi_id.equals(this.f8940h.base_info.poi_id)) ? false : true)) {
                        markerModel = m7643a(rpcPoi2, z2, false, false, 100 - i);
                    }
                } else {
                    markerModel = m7643a(rpcPoi2, z2, false, true, 100 - i);
                }
                if (markerModel != null) {
                    arrayList.add(markerModel);
                }
                i++;
            }
            MarkersCompParams build = new MarkersCompParams.Builder().markerModels(arrayList).build();
            MarkersComponent markersComponent = new MarkersComponent();
            this.f8938f = markersComponent;
            markersComponent.setConfigParam(build);
            this.f8938f.create(this.f8935c, this.f8936d);
            RpcPoi rpcPoi3 = this.f8940h;
            if (rpcPoi3 != null) {
                MarkerModel a = m7643a(rpcPoi3, this.f8941i == 2, true, true, 110);
                this.f8938f.addNewMarkerToComponent(a, m7652b(a.getId()));
                this.f8938f.setLabelVisible(this.f8955z, false);
            }
            this.f8938f.setOnClickListener(new OnMarkerCompClickListener() {
                public boolean onClick(String str) {
                    if (FuzzyMatchAddressComponent.this.f8953x) {
                        return false;
                    }
                    if (FuzzyMatchAddressComponent.this.f8938f != null && !TextUtils.isEmpty(str)) {
                        RpcPoi a = FuzzyMatchAddressComponent.this.m7645a(str);
                        SystemUtils.log(6, "ccc", "findAddressWithId , rpcPoi = " + a, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent$3", 372);
                        if (a != null) {
                            int unused = FuzzyMatchAddressComponent.this.f8941i = 1;
                            if (FuzzyMatchAddressComponent.this.f8940h != null && FuzzyMatchAddressComponent.this.f8940h.base_info != null && a.base_info != null && FuzzyMatchAddressComponent.this.f8940h.base_info.poi_id.equals(a.base_info.poi_id)) {
                                return false;
                            }
                            FuzzyMatchAddressComponent.this.m7662d();
                            if ((FuzzyMatchAddressComponent.this.f8941i == 0 || FuzzyMatchAddressComponent.this.f8941i == 1) && !CollectionUtil.isEmpty((Collection<?>) a.sub_poi_list)) {
                                FuzzyMatchAddressComponent.this.m7649a(a);
                                if (FuzzyMatchAddressComponent.this.f8937e != null) {
                                    FuzzyMatchAddressComponent.this.f8937e.onSelectAddress(a, FuzzyMatchAddressComponent.this.f8941i == 2, false);
                                }
                                if (FuzzyMatchAddressComponent.this.f8942m != null) {
                                    FuzzyMatchAddressComponent fuzzyMatchAddressComponent = FuzzyMatchAddressComponent.this;
                                    fuzzyMatchAddressComponent.doBestView(fuzzyMatchAddressComponent.f8942m);
                                }
                                return true;
                            }
                            FuzzyMatchAddressComponent.this.m7657b(a);
                            RpcPoi unused2 = FuzzyMatchAddressComponent.this.f8940h = a;
                            if (FuzzyMatchAddressComponent.this.f8937e != null) {
                                FuzzyMatchAddressComponent.this.f8937e.onSelectAddress(a, FuzzyMatchAddressComponent.this.f8941i == 2, false);
                            }
                        }
                    }
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7649a(RpcPoi rpcPoi) {
        DLog.m10773d("FuzzyMatchAddressComponent", "onSelectGroupMarker", new Object[0]);
        m7660c();
        this.f8941i = 2;
        this.f8939g.clear();
        this.f8939g.add(rpcPoi);
        if (!CollectionUtil.isEmpty((Collection<?>) rpcPoi.sub_poi_list)) {
            this.f8939g.addAll(rpcPoi.sub_poi_list);
        }
        this.f8940h = rpcPoi;
        m7654b();
    }

    /* renamed from: a */
    private MarkerModel m7643a(RpcPoi rpcPoi, boolean z, boolean z2, boolean z3, int i) {
        if (rpcPoi == null) {
            return null;
        }
        MarkerModel markerModel = new MarkerModel();
        RpcPoiBaseInfo rpcPoiBaseInfo = rpcPoi.base_info;
        Bitmap a = m7640a(z3);
        if (a != null) {
            markerModel.setMarkerIcon(a);
        }
        if (z2) {
            this.f8955z = rpcPoiBaseInfo.poi_id;
        }
        markerModel.setPoint(new LatLng(rpcPoiBaseInfo.lat, rpcPoiBaseInfo.lng));
        markerModel.setAnchorU(0.5f);
        markerModel.setAnchorV(0.9f);
        markerModel.setId(rpcPoiBaseInfo.poi_id);
        markerModel.setZOrder(i);
        if (rpcPoi.extend_info != null) {
            if (z3) {
                markerModel.setMarkerUrl(rpcPoi.extend_info.in_normal_icon_url);
            } else {
                markerModel.setMarkerUrl(rpcPoi.extend_info.in_fade_icon_url);
            }
        }
        markerModel.setStrategy(this.f8933a);
        markerModel.setUrlIconScaleParam(m7664e());
        markerModel.setClickable(true);
        if (z) {
            markerModel.setLabelView(new FuzzymatchBubble(this.f8946q));
            markerModel.setLabelDirection(4);
            markerModel.setAddressName(rpcPoiBaseInfo.displayname);
            markerModel.setLabelZIndex(i);
        }
        return markerModel;
    }

    /* renamed from: a */
    private MarkerModel m7642a(LatLng latLng, String str) {
        MarkerModel markerModel = new MarkerModel();
        Bitmap a = m7640a(true);
        if (a != null) {
            markerModel.setMarkerIcon(a);
        }
        if (LatLngUtils.locateCorrect(latLng)) {
            markerModel.setPoint(latLng);
        }
        markerModel.setAnchorU(0.5f);
        markerModel.setAnchorV(0.9f);
        markerModel.setId(str);
        markerModel.setZOrder(110);
        markerModel.setClickable(true);
        markerModel.setStrategy(this.f8933a);
        return markerModel;
    }

    /* renamed from: c */
    private void m7660c() {
        IMarkersCompContract iMarkersCompContract = this.f8938f;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f8938f = null;
        }
        ICollideStrategy iCollideStrategy = this.f8933a;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f8933a = null;
        }
    }

    /* renamed from: a */
    private void m7648a(final LatLng latLng) {
        CallFrom callFrom;
        if (LatLngUtils.locateCorrect(latLng) && this.f8935c != null && this.f8936d != null) {
            FuzzyMatchOperationCallback fuzzyMatchOperationCallback = this.f8937e;
            if (fuzzyMatchOperationCallback != null) {
                fuzzyMatchOperationCallback.onDateLoading();
            }
            this.f8953x = true;
            ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
            Map map = this.f8936d;
            reverseGeoParam.mapType = map == null ? "gmap" : map.getMapVendor().toString();
            if (this.f8954y == 0) {
                if (this.f8946q == 1) {
                    callFrom = CallFrom.LONG_PRESS_START_FROMHOME;
                } else {
                    callFrom = CallFrom.LONG_PRESS_END_FROMHOME;
                }
            } else if (this.f8946q == 1) {
                callFrom = CallFrom.LONG_PRESS_START_FROMBUBBLE;
            } else {
                callFrom = CallFrom.LONG_PRESS_END_FROMBUBBLE;
            }
            reverseGeoParam.callFrom = callFrom;
            reverseGeoParam.select_lng = latLng.longitude;
            reverseGeoParam.select_lat = latLng.latitude;
            DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f8935c).getLastKnownLocation();
            if (lastKnownLocation != null) {
                reverseGeoParam.user_loc_lat = lastKnownLocation.getLatitude();
                reverseGeoParam.user_loc_lng = lastKnownLocation.getLongitude();
                reverseGeoParam.accuracy = lastKnownLocation.getAccuracy();
                reverseGeoParam.provider = lastKnownLocation.getProvider();
            }
            reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
            reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
            reverseGeoParam.phone = PaxEnvironment.getInstance().getPhoneNumber();
            reverseGeoParam.productId = PaxEnvironment.getInstance().getProductId();
            reverseGeoParam.token = PaxEnvironment.getInstance().getToken();
            reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
            reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
            reverseGeoParam.lang = LocaleCodeHolder.getInstance().getCurrentLang();
            DLog.m10773d("FuzzyMatchAddressComponent", "startRevertGeo params : " + reverseGeoParam, new Object[0]);
            if (this.f8943n == null) {
                this.f8943n = PoiBaseApiFactory.createDidiApi(this.f8935c);
            }
            this.f8943n.reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
                public void onSuccess(ReverseGeoResult reverseGeoResult) {
                    boolean unused = FuzzyMatchAddressComponent.this.f8953x = false;
                    if (FuzzyMatchAddressComponent.this.f8936d != null && FuzzyMatchAddressComponent.this.f8935c != null) {
                        DLog.m10773d("FuzzyMatchAddressComponent", "reverse geo success", new Object[0]);
                        if (reverseGeoResult != null && reverseGeoResult.result != null && !reverseGeoResult.result.isEmpty() && FuzzyMatchAddressComponent.this.f8937e != null) {
                            RpcPoi rpcPoi = reverseGeoResult.result.get(0);
                            if (!(rpcPoi == null || rpcPoi.base_info == null || latLng == null)) {
                                rpcPoi.base_info.lat = latLng.latitude;
                                rpcPoi.base_info.lng = latLng.longitude;
                            }
                            RpcPoi unused2 = FuzzyMatchAddressComponent.this.f8940h = rpcPoi;
                            FuzzyMatchAddressComponent.this.f8937e.onSelectAddress(rpcPoi, false, true);
                        }
                    }
                }

                public void onFail(IOException iOException) {
                    DLog.m10773d("FuzzyMatchAddressComponent", "reverse geo fail", new Object[0]);
                    if (FuzzyMatchAddressComponent.this.f8935c != null && FuzzyMatchAddressComponent.this.f8936d != null) {
                        boolean unused = FuzzyMatchAddressComponent.this.f8953x = false;
                        RpcPoi rpcPoi = new RpcPoi();
                        rpcPoi.base_info = new RpcPoiBaseInfo();
                        rpcPoi.base_info.displayname = FuzzyMatchAddressComponent.this.f8935c.getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                        if (latLng != null) {
                            rpcPoi.base_info.lat = latLng.latitude;
                            rpcPoi.base_info.lng = latLng.longitude;
                        }
                        rpcPoi.base_info.poi_id = "android_reverse_geo_error_default_id";
                        if (FuzzyMatchAddressComponent.this.f8937e != null) {
                            FuzzyMatchAddressComponent.this.f8937e.onSelectAddress(rpcPoi, false, true);
                        }
                    }
                }
            });
        }
    }

    /* renamed from: b */
    private void m7656b(LatLng latLng) {
        if (this.f8938f != null) {
            this.f8938f.addNewMarkerToComponent(m7642a(latLng, "id_reverse_point"), m7652b("id_reverse_point"));
            m7657b((RpcPoi) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m7662d() {
        IMarkersCompContract iMarkersCompContract = this.f8938f;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.removeMarker("id_reverse_point");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m7638a(Bitmap bitmap, float f) {
        return ImageUtil.scale(bitmap, ((float) bitmap.getWidth()) * f, ((float) bitmap.getHeight()) * f, ImageView.ScaleType.CENTER_CROP, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7657b(RpcPoi rpcPoi) {
        RpcPoi rpcPoi2 = rpcPoi;
        if (this.f8938f != null) {
            String str = "";
            String str2 = (rpcPoi2 == null || rpcPoi2.base_info == null) ? str : rpcPoi2.base_info.poi_id;
            if (TextUtils.isEmpty(str2) || !str2.equals(this.f8955z)) {
                boolean z = !TextUtils.isEmpty(str2);
                if (!(rpcPoi2 == null || rpcPoi2.extend_info == null)) {
                    RpcPoiExtendInfo rpcPoiExtendInfo = rpcPoi2.extend_info;
                    str = z ? rpcPoiExtendInfo.in_normal_icon_url : rpcPoiExtendInfo.in_fade_icon_url;
                }
                if (!CollectionUtil.isEmpty((Collection<?>) this.f8939g)) {
                    boolean z2 = false;
                    int i = 0;
                    for (RpcPoi next : this.f8939g) {
                        if (!(next == null || next.base_info == null || next.base_info.poi_id == null)) {
                            String str3 = next.base_info.poi_id;
                            if (str3.equals(str2)) {
                                this.f8938f.updateMarkerIcon(str3, m7640a(z));
                                this.f8938f.changeMarkerIcon(str3, str, m7664e(), m7652b(str3));
                                this.f8938f.updateMarkerZindex(str3, 110);
                                this.f8938f.setMarkerVisible(str3, true);
                                this.f8938f.setLabelVisible(str3, z2);
                                SystemUtils.log(6, "ccc", "未选中->选中， " + str3 + ", " + next.base_info.displayname, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent", 672);
                            } else {
                                this.f8938f.updateMarkerIcon(str3, m7640a(z2));
                                this.f8938f.updateMarkerZindex(str3, 100 - i);
                                if (!(next.extend_info == null || next.extend_info.in_fade_icon_url == null)) {
                                    this.f8938f.changeMarkerIcon(next.base_info.poi_id, next.extend_info.in_fade_icon_url, m7664e(), (MarkersComponent.ImageNetWorkCallback) null);
                                }
                                if (str3.equals(this.f8955z)) {
                                    this.f8938f.setMarkerVisible(str3, true);
                                    this.f8938f.setLabelVisible(str3, true);
                                }
                                SystemUtils.log(6, "ccc", "选中->未选中，" + str3 + ", " + next.base_info.displayname, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent", 685);
                            }
                        }
                        i++;
                        z2 = false;
                    }
                }
                this.f8955z = str2;
                this.f8940h = rpcPoi2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m7640a(boolean z) {
        Bitmap bitmap;
        Context context = this.f8935c;
        if (context == null || this.f8936d == null) {
            return null;
        }
        int i = 1;
        if (this.f8946q == 1) {
            if (z) {
                bitmap = BitmapFactory.decodeResource(context.getResources(), this.f8948s);
            } else {
                i = 2;
                bitmap = BitmapFactory.decodeResource(context.getResources(), this.f8950u);
            }
        } else if (z) {
            i = 3;
            bitmap = BitmapFactory.decodeResource(context.getResources(), this.f8949t);
        } else {
            i = 4;
            bitmap = BitmapFactory.decodeResource(context.getResources(), this.f8951v);
        }
        SystemUtils.log(6, "ccc", "getCurrentMarkerDefaultBitmap = " + i, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent", 723);
        return bitmap;
    }

    /* renamed from: b */
    private MarkersComponent.ImageNetWorkCallback m7652b(final String str) {
        Bitmap a;
        if (!(this.f8938f == null || (a = m7640a(true)) == null)) {
            this.f8938f.updateMarkerIcon(str, m7638a(a, 1.5f));
            this.f8938f.updateMarkerZindex(str, 110);
        }
        return new MarkersComponent.ImageNetWorkCallback() {
            public void onImageNetSuccess(Bitmap bitmap) {
                if (FuzzyMatchAddressComponent.this.f8935c != null && FuzzyMatchAddressComponent.this.f8936d != null) {
                    Bitmap a = FuzzyMatchAddressComponent.this.m7638a(bitmap, FuzzyMatchAddressComponent.this.m7664e() * 1.5f);
                    if (FuzzyMatchAddressComponent.this.f8938f != null && a != null) {
                        FuzzyMatchAddressComponent.this.f8938f.updateMarkerIcon(str, a);
                        FuzzyMatchAddressComponent.this.f8938f.updateMarkerZindex(str, 110);
                    }
                }
            }

            public void onImageNetFails() {
                DLog.m10773d("FuzzyMatchAddressComponent", "onImageNetFails", new Object[0]);
                if (FuzzyMatchAddressComponent.this.f8935c != null && FuzzyMatchAddressComponent.this.f8936d != null && FuzzyMatchAddressComponent.this.f8938f != null) {
                    FuzzyMatchAddressComponent.this.f8938f.updateMarkerIcon(str, FuzzyMatchAddressComponent.this.m7638a(FuzzyMatchAddressComponent.this.m7640a(true), 1.5f));
                    FuzzyMatchAddressComponent.this.f8938f.updateMarkerZindex(str, 110);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public float m7664e() {
        double d;
        double d2;
        Context context = this.f8935c;
        float f = 1.0f;
        if (context == null || context.getResources() == null || this.f8935c.getResources().getDisplayMetrics() == null) {
            return 1.0f;
        }
        float f2 = this.f8935c.getResources().getDisplayMetrics().xdpi;
        if (f2 < 120.0f) {
            d = (double) 1.0f;
            d2 = 0.75d;
        } else {
            if (f2 >= 160.0f) {
                if (f2 < 240.0f) {
                    d = (double) 1.0f;
                    d2 = 1.5d;
                } else {
                    f = f2 < 320.0f ? 2.0f : f2 < 480.0f ? 3.0f : 4.0f;
                }
            }
            float f3 = f / 3.0f;
            DLog.m10773d("FuzzyMatchAddressComponent", "currentDensityScale" + f3, new Object[0]);
            return f3;
        }
        f = (float) (d * d2);
        float f32 = f / 3.0f;
        DLog.m10773d("FuzzyMatchAddressComponent", "currentDensityScale" + f32, new Object[0]);
        return f32;
    }
}
