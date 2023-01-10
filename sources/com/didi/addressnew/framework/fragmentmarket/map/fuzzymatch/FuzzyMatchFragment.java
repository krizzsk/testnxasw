package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.map.SugMapBaseFragment;
import com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchAddressComponent;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchCardCallback;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchCardController;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchCardView;
import com.didi.addressnew.framework.fragmentmarket.map.view.fuzzymatch.FuzzyMatchListView;
import com.didi.addressnew.framework.mapholder.SugSharedMapView;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.ParentAddress;
import com.didi.addressnew.model.ISelectAddressModel;
import com.didi.addressnew.model.SelectAddressModel;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.PreferenceUtil;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.addressnew.view.shadow.ShadowLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.Map;
import com.didi.common.map.MapView;
import com.didi.common.map.OnMapReadyCallBack;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.dropoff.DropOffCompParam;
import com.didi.map.global.component.dropoff.DropOffComponent;
import com.didi.map.global.component.dropoff.IDropOffCompContract;
import com.didi.map.global.component.dropoff.IDropOffComponentCallback;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.pin.PinStyle;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.didi.sdk.address.address.entity.Address;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FuzzyMatchFragment extends SugMapBaseFragment {

    /* renamed from: D */
    private static final int f8956D = 0;

    /* renamed from: E */
    private static final int f8957E = 1;

    /* renamed from: F */
    private static final int f8958F = 2;

    /* renamed from: G */
    private static final int f8959G = 3;

    /* renamed from: H */
    private static final int f8960H = 4;

    /* renamed from: I */
    private static final String f8961I = "key_new_hand_show";

    /* renamed from: A */
    private boolean f8962A = true;

    /* renamed from: B */
    private boolean f8963B = true;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f8964C = 0;

    /* renamed from: J */
    private Padding f8965J;

    /* renamed from: K */
    private final int f8966K = 30;

    /* renamed from: L */
    private int f8967L = 0;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f8968M = false;

    /* renamed from: N */
    private ViewGroup f8969N;

    /* renamed from: a */
    FuzzyMatchAddressComponent.AdapterMoveBackQuestionCallback f8970a = new FuzzyMatchAddressComponent.AdapterMoveBackQuestionCallback() {
        public boolean onMoveBack() {
            return FuzzyMatchFragment.this.f8968M;
        }
    };

    /* renamed from: b */
    private View f8971b;

    /* renamed from: c */
    private View f8972c;

    /* renamed from: d */
    private View f8973d;

    /* renamed from: e */
    private View f8974e;

    /* renamed from: f */
    private ImageView f8975f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public FrameLayout f8976g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f8977h;

    /* renamed from: i */
    private FrameLayout f8978i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Map f8979j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f8980k;

    /* renamed from: l */
    private IDropOffCompContract f8981l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public DropOffAddress f8982m;

    /* renamed from: n */
    private ISelectAddressModel f8983n;

    /* renamed from: o */
    private FuzzyMatchAddressComponent f8984o;

    /* renamed from: p */
    private FuzzyMatchCardController f8985p;

    /* renamed from: q */
    private FuzzyMatchListView f8986q;

    /* renamed from: r */
    private FuzzyMatchCardView f8987r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public RpcPoi f8988s;

    /* renamed from: t */
    private int f8989t;

    /* renamed from: u */
    private RpcRecSug.TrackParameterForChild f8990u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public List<RpcPoi> f8991v = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: w */
    public List<RpcPoi> f8992w;

    /* renamed from: x */
    private boolean f8993x;

    /* renamed from: y */
    private int f8994y;

    /* renamed from: z */
    private int f8995z;

    public boolean getDragHandlerEnable() {
        return false;
    }

    public View getFallbackView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.map_same_address_fragment_layout;
    }

    /* access modifiers changed from: protected */
    public void onInit(View view) {
        this.f8971b = view;
        this.f8972c = view.findViewById(R.id.map_mask);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_reset_map);
        this.f8975f = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                FuzzyMatchFragment.this.m7693b();
            }
        });
        View findViewById = view.findViewById(R.id.btnNavBack);
        this.f8974e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FuzzyMatchFragment.this.m7695b(view);
            }
        });
        this.f8978i = (FrameLayout) view.findViewById(R.id.mapContainer);
        this.f8977h = view.findViewById(R.id.mapViewOverLayer);
        this.f8976g = (FrameLayout) view.findViewById(R.id.cardViewContainer);
        this.f8973d = view.findViewById(R.id.card_mask_bg);
        this.f8971b.postDelayed(new Runnable() {
            public final void run() {
                FuzzyMatchFragment.this.m7728q();
            }
        }, 800);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m7695b(View view) {
        m7701d();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7728q() {
        if (getActivity() != null && getContext() != null && this.f8971b != null) {
            int i = PreferenceUtil.getInstance(getContext()).getInt(f8961I);
            ViewStub viewStub = (ViewStub) this.f8971b.findViewById(R.id.view_new_hand);
            if (i < 1) {
                this.f8980k = viewStub.inflate();
                PreferenceUtil.getInstance(getContext()).put(f8961I, i + 1);
                this.f8980k.findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (FuzzyMatchFragment.this.f8980k != null) {
                            FuzzyMatchFragment.this.f8980k.setVisibility(8);
                        }
                    }
                });
                this.f8980k.setOnTouchListener(new View.OnTouchListener() {
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7693b() {
        if (this.f8979j != null) {
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f8984o;
            if (fuzzyMatchAddressComponent != null) {
                fuzzyMatchAddressComponent.doBestView(this.f8965J);
            }
            ImageView imageView = this.f8975f;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }
    }

    public boolean onBackPressed() {
        m7698c();
        if (this.f8964C == 0 || this.f8989t == 1) {
            return super.onBackPressed();
        }
        m7701d();
        return false;
    }

    /* renamed from: c */
    private void m7698c() {
        if (this.f8984o != null) {
            this.f8968M = true;
            if (this.f8971b != null && getContext() != null) {
                this.f8971b.postDelayed(new Runnable() {
                    public final void run() {
                        FuzzyMatchFragment.this.m7726p();
                    }
                }, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void m7726p() {
        if (this.f8984o != null) {
            this.f8968M = false;
        }
    }

    /* renamed from: d */
    private void m7701d() {
        DropOffAddress dropOffAddress;
        DropOffAddress dropOffAddress2;
        int i = this.f8964C;
        if (i == 0) {
            AddressTrack.trackFuzzyMatchBackOrConfirm((RpcPoi) null, this.f8990u, getmParam().addressParam.clone(), AddressTrack.SEARCH_CK_TYPE.MAP_BACK);
            m7711i();
            if (this.f8964C == 4 && (dropOffAddress = this.f8982m) != null) {
                m7687a(dropOffAddress.getAddress());
            }
        } else if (i == 1 || i == 2 || i == 3 || i == 4) {
            AddressTrack.trackFuzzyMatchBackOrConfirm(this.f8988s, this.f8990u, getmParam().addressParam.clone(), AddressTrack.SEARCH_CK_TYPE.POI_BACK);
            if (this.f8989t == 1) {
                m7711i();
                if (this.f8964C == 4 && (dropOffAddress2 = this.f8982m) != null) {
                    m7687a(dropOffAddress2.getAddress());
                    return;
                }
                return;
            }
            m7680a(0, false);
            m7679a(0);
        }
    }

    public void onPageEnter() {
        super.onPageEnter();
        getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
        if (getView() != null) {
            getView().requestFocus();
        }
        SugSharedMapView.getInstance(getActivity()).onAdd(this.f8978i);
        SugSharedMapView.getInstance(getActivity()).onResume();
        View view = this.f8972c;
        if (view != null) {
            view.setVisibility(8);
        }
        m7704e();
        final MapView mapView = SugSharedMapView.getInstance(getActivity()).getMapView();
        if (mapView != null) {
            mapView.getMapAsync(new OnMapReadyCallBack() {
                public void onMapReady(Map map) {
                    Map unused = FuzzyMatchFragment.this.f8979j = map;
                    FuzzyMatchFragment.this.m7718l();
                    FuzzyMatchFragment fuzzyMatchFragment = FuzzyMatchFragment.this;
                    fuzzyMatchFragment.m7679a(fuzzyMatchFragment.f8964C);
                    FuzzyMatchFragment fuzzyMatchFragment2 = FuzzyMatchFragment.this;
                    fuzzyMatchFragment2.m7680a(fuzzyMatchFragment2.f8964C, false);
                    FuzzyMatchFragment fuzzyMatchFragment3 = FuzzyMatchFragment.this;
                    fuzzyMatchFragment3.playAnimationMapLayer(fuzzyMatchFragment3.f8977h);
                    FuzzyMatchFragment.this.addOnMapGestureListener(map);
                    mapView.sendAccessibilityEvent(8);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onShowMapReset() {
        ImageView imageView = this.f8975f;
        if (imageView == null) {
            return;
        }
        if (this.f8964C == 4) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }

    public void onPageExit() {
        removeOnMapGestureListener(this.f8979j);
        m7714j();
        m7716k();
        SugSharedMapView.getInstance(getActivity()).setNeedLocation(true);
        View view = this.f8972c;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f8979j = null;
        SugSharedMapView.getInstance(getActivity()).onRemove(this.f8978i);
        super.onPageExit();
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.MAPCONFIRM;
    }

    /* renamed from: e */
    private void m7704e() {
        this.f8991v.addAll((ArrayList) getArguments().getSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST));
        this.f8988s = (RpcPoi) getArguments().getSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS);
        this.f8990u = (RpcRecSug.TrackParameterForChild) getArguments().getSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM);
        this.f8994y = getArguments().getInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP);
        this.f8995z = getArguments().getInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE);
        this.f8993x = getArguments().getBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER);
        this.f8962A = true;
        this.f8963B = true;
        RpcPoi rpcPoi = this.f8988s;
        if (rpcPoi == null) {
            this.f8964C = 0;
            this.f8989t = 0;
            return;
        }
        this.f8989t = 1;
        if (rpcPoi == null || !CollectionUtil.isEmpty((Collection<?>) rpcPoi.sub_poi_list)) {
            this.f8964C = 2;
        } else {
            this.f8964C = 1;
        }
    }

    /* renamed from: a */
    private void m7687a(Address address) {
        if (address != null && address.poiId != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(ParamKeys.PARAM_TO_POI_UID, address.poiId);
            GlobalOmegaTracker.trackEvent("map_dropoff_ck", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7679a(int i) {
        this.f8964C = i;
        if (i == 0) {
            m7714j();
            m7716k();
            m7688a(this.f8991v);
        } else if (i == 1) {
            SugSharedMapView.getInstance(getActivity()).setNeedLocation(true);
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f8984o;
            if (fuzzyMatchAddressComponent == null) {
                m7714j();
                m7688a(this.f8991v);
            } else {
                fuzzyMatchAddressComponent.onSelectValueChanged(this.f8988s, false);
            }
        } else if (i == 2) {
            SugSharedMapView.getInstance(getActivity()).setNeedLocation(false);
            m7714j();
            m7716k();
            m7688a(this.f8992w);
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent2 = this.f8984o;
            if (fuzzyMatchAddressComponent2 != null) {
                fuzzyMatchAddressComponent2.onSelectValueChanged(this.f8988s, true);
            }
        } else if (i == 4) {
            SugSharedMapView.getInstance(getActivity()).setNeedLocation(false);
            m7716k();
            m7714j();
            m7706f();
        }
        FuzzyMatchAddressComponent fuzzyMatchAddressComponent3 = this.f8984o;
        if (fuzzyMatchAddressComponent3 != null) {
            fuzzyMatchAddressComponent3.doBestView(this.f8965J);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7680a(int i, boolean z) {
        FuzzyMatchCardController fuzzyMatchCardController;
        FuzzyMatchCardController fuzzyMatchCardController2;
        FuzzyMatchCardController fuzzyMatchCardController3;
        FrameLayout frameLayout;
        this.f8964C = i;
        if (i == 0) {
            this.f8967L = 0;
            if (this.f8986q == null && (fuzzyMatchCardController = this.f8985p) != null) {
                this.f8986q = (FuzzyMatchListView) fuzzyMatchCardController.getView(1);
            }
            this.f8986q.updateListData(this.f8991v, this.f8990u, this.mCurrAddressType, this.f8993x, this.f8994y);
            FrameLayout frameLayout2 = this.f8976g;
            if (frameLayout2 != null) {
                frameLayout2.removeAllViews();
                this.f8976g.addView(this.f8986q);
                if (!z) {
                    m7720m();
                }
            }
        } else if (i == 1 || i == 2) {
            this.f8967L = 1;
            if (this.f8987r == null && (fuzzyMatchCardController2 = this.f8985p) != null) {
                this.f8987r = (FuzzyMatchCardView) fuzzyMatchCardController2.getView(0);
            }
            this.f8987r.updateView(this.f8988s, this.f8990u, this.mCurrAddressType);
            FrameLayout frameLayout3 = this.f8976g;
            if (frameLayout3 != null) {
                frameLayout3.removeAllViews();
                this.f8976g.addView(m7672a((View) this.f8987r), new FrameLayout.LayoutParams(-1, -2));
                if (!z) {
                    m7720m();
                }
            }
        } else if (i == 3) {
            if (this.f8987r == null && (fuzzyMatchCardController3 = this.f8985p) != null) {
                this.f8987r = (FuzzyMatchCardView) fuzzyMatchCardController3.getView(0);
            }
            FrameLayout frameLayout4 = this.f8976g;
            if (frameLayout4 != null) {
                frameLayout4.removeAllViews();
                this.f8976g.addView(m7672a((View) this.f8987r), new FrameLayout.LayoutParams(-1, -2));
                this.f8987r.onDataLoading(this.mCurrAddressType);
            }
        } else if (i == 4 && (frameLayout = this.f8976g) != null) {
            frameLayout.removeAllViews();
        }
    }

    /* renamed from: f */
    private void m7706f() {
        if (this.f8979j != null) {
            this.f8981l = new DropOffComponent();
            PinStyle pinStyle = new PinStyle();
            pinStyle.pinNormalColor = Color.parseColor("#ff8903");
            pinStyle.rectVisible = true;
            this.f8981l.setConfigParam(new DropOffCompParam.Builder(CallFrom.DROPOFF_PAGE, new IDropOffComponentCallback() {
                public void onStartDragging() {
                }

                public void onDropOffAddressChanged(boolean z, DropOffAddress dropOffAddress, View view) {
                    DropOffAddress unused = FuzzyMatchFragment.this.f8982m = dropOffAddress;
                    FuzzyMatchFragment.this.f8976g.removeAllViews();
                    FuzzyMatchFragment.this.f8976g.addView(FuzzyMatchFragment.this.m7672a(view), new FrameLayout.LayoutParams(-1, -2));
                    FuzzyMatchFragment.this.m7720m();
                }

                public void onDropoffLoading(View view) {
                    FuzzyMatchFragment.this.f8976g.removeAllViews();
                    FuzzyMatchFragment.this.f8976g.addView(FuzzyMatchFragment.this.m7672a(view), new FrameLayout.LayoutParams(-1, -2));
                }

                public void onCardViewOperation(int i) {
                    if (i == 0 && !ViewFastDoubleClickInterceptor.isFastClick()) {
                        FuzzyMatchFragment.this.m7709h();
                    }
                }
            }).locationInfo(m7708g()).pinStyle(pinStyle).zoom(18.0f).build());
            this.f8981l.create(getContext(), this.f8979j);
            this.f8981l.start();
        }
    }

    /* renamed from: g */
    private DropOffLocationInfo m7708g() {
        Map map;
        DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(getActivity());
        DropOffLocationInfo dropOffLocationInfo = null;
        LatLng latLng = lastKnownLocation != null ? new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude()) : null;
        Address convertToAddress = ModelConverter.convertToAddress(this.f8988s);
        convertToAddress.operationType = this.f8995z;
        if (this.f8988s != null) {
            latLng = new LatLng(convertToAddress.getLatitude(), convertToAddress.getLongitude());
        }
        if (!(latLng != null || (map = this.f8979j) == null || map.getCameraPosition() == null)) {
            latLng = this.f8979j.getCameraPosition().target;
        }
        if (latLng != null) {
            dropOffLocationInfo = new DropOffLocationInfo();
            dropOffLocationInfo.latLng = latLng;
            dropOffLocationInfo.sugPoi = convertToAddress;
            if (this.mParentAddress != null) {
                dropOffLocationInfo.parentPoi = this.mParentAddress.address;
            }
            RpcPoi rpcPoi = this.f8988s;
            if (rpcPoi != null) {
                dropOffLocationInfo.extendInfo = rpcPoi.extend_info;
            }
            dropOffLocationInfo.coordinateType = convertToAddress.coordinate_type;
        }
        return dropOffLocationInfo;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m7709h() {
        if (this.f8981l != null && this.f8982m != null) {
            getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Chose);
            m7699c(this.f8982m.getAddress());
            RpcPoi rpcPoi = this.f8988s;
            if (rpcPoi != null) {
                if (this.f8983n == null) {
                    this.f8983n = new SelectAddressModel(getContext());
                }
                this.f8983n.recordClickPoi(getmParam().addressParam, rpcPoi.base_info);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7697b(Address address) {
        if (address != null) {
            getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.FuzzyMatch);
            m7699c(address);
        }
    }

    /* renamed from: c */
    private void m7699c(Address address) {
        if (!this.mDestroyed) {
            if (this.mCurrAddressType == 5) {
                getmParam().addressParam.targetAddress = address;
                getmResult().setCommonAddress(AddressConvertUtil.addressToRpcCommonPoi(address, getmResult().getCommonAddress()));
                onConfirm(getmParam(), getmResult());
                switchEditFavorite(getmParam(), getmResult());
                return;
            }
            getmResult().setResult(this.mCurrAddressType, address);
            onConfirm(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        }
    }

    /* renamed from: i */
    private void m7711i() {
        if (!this.mDestroyed) {
            getmResult().setResultAllowNull(this.mCurrAddressType, (Address) null);
            updateAddressToSwitcher(getmParam(), getmResult());
            onCancel(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        }
    }

    /* renamed from: j */
    private void m7714j() {
        IDropOffCompContract iDropOffCompContract = this.f8981l;
        if (iDropOffCompContract != null) {
            iDropOffCompContract.destroy();
            this.f8981l = null;
        }
    }

    /* renamed from: a */
    private void m7688a(final List<RpcPoi> list) {
        if (this.f8979j != null && getContext() != null && !CollectionUtil.isEmpty((Collection<?>) list)) {
            FuzzyMatchParam fuzzyMatchParam = new FuzzyMatchParam(list, this.mCurrAddressType, new FuzzyMatchOperationCallback() {
                public void onShowAllAddress(ArrayList<RpcPoi> arrayList) {
                }

                public void onSelectAddress(RpcPoi rpcPoi, boolean z, boolean z2) {
                    if (rpcPoi != null) {
                        RpcPoi unused = FuzzyMatchFragment.this.f8988s = rpcPoi;
                        FuzzyMatchFragment fuzzyMatchFragment = FuzzyMatchFragment.this;
                        fuzzyMatchFragment.m7689a(list, rpcPoi, z2, fuzzyMatchFragment.f8964C);
                        if (FuzzyMatchFragment.this.mCurrAddressType == 2 && ((rpcPoi.extend_info != null && rpcPoi.extend_info.enable_confirm_dropoff == 1) || rpcPoi.isDiscountPoi)) {
                            FuzzyMatchFragment.this.m7680a(4, z2);
                            FuzzyMatchFragment.this.m7679a(4);
                        } else if (z) {
                            FuzzyMatchFragment.this.m7680a(2, z2);
                        } else {
                            FuzzyMatchFragment.this.m7680a(1, z2);
                        }
                    }
                }

                public void onDateLoading() {
                    FuzzyMatchFragment.this.m7680a(3, false);
                }
            });
            if (this.f8964C != 0) {
                fuzzyMatchParam.setSelectAddress(this.f8988s);
            }
            fuzzyMatchParam.setGroup(this.f8964C == 2);
            if (CommonUtils.isFromHomePage(getmParam().fromType)) {
                fuzzyMatchParam.setPageFrom(0);
            } else if (CommonUtils.isFromConfirmPage(getmParam().fromType)) {
                fuzzyMatchParam.setPageFrom(1);
            }
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = new FuzzyMatchAddressComponent();
            this.f8984o = fuzzyMatchAddressComponent;
            fuzzyMatchAddressComponent.setParamConfig(fuzzyMatchParam);
            this.f8984o.create(getContext(), this.f8979j);
            this.f8984o.setAdapterMoveBackQuestionCallback(this.f8970a);
        }
    }

    /* renamed from: k */
    private void m7716k() {
        FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f8984o;
        if (fuzzyMatchAddressComponent != null) {
            fuzzyMatchAddressComponent.onDestroy();
            this.f8984o = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m7718l() {
        if (this.f8979j != null && getContext() != null) {
            if (this.f8985p == null) {
                this.f8985p = new FuzzyMatchCardController(getContext(), new FuzzyMatchCardCallback() {
                    public void onSelectAddress(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
                        RpcPoi unused = FuzzyMatchFragment.this.f8988s = rpcPoi;
                        AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, FuzzyMatchFragment.this.getmParam().addressParam.clone(), i, i2, AddressTrack.SEARCH_CK_TYPE.SEARCH_LIST_CK);
                        if (FuzzyMatchFragment.this.mCurrAddressType == 2 && ((rpcPoi.extend_info != null && rpcPoi.extend_info.enable_confirm_dropoff == 1) || rpcPoi.isDiscountPoi)) {
                            if (i2 != -1 && !CollectionUtil.isEmpty((Collection<?>) FuzzyMatchFragment.this.f8991v) && FuzzyMatchFragment.this.f8991v.size() > i) {
                                ParentAddress unused2 = FuzzyMatchFragment.this.mParentAddress = new ParentAddress();
                                FuzzyMatchFragment.this.mParentAddress.addressType = 2;
                                FuzzyMatchFragment.this.mParentAddress.address = ModelConverter.convertToAddress((RpcPoi) FuzzyMatchFragment.this.f8991v.get(i));
                                FuzzyMatchFragment.this.getmResult().setParent(FuzzyMatchFragment.this.mParentAddress);
                            }
                            int unused3 = FuzzyMatchFragment.this.f8964C = 4;
                        } else if (!CollectionUtil.isEmpty((Collection<?>) FuzzyMatchFragment.this.f8988s.sub_poi_list) || i2 != -1) {
                            if (FuzzyMatchFragment.this.f8992w == null) {
                                List unused4 = FuzzyMatchFragment.this.f8992w = new ArrayList();
                            }
                            FuzzyMatchFragment.this.f8992w.clear();
                            if (i2 == -1) {
                                FuzzyMatchFragment.this.f8992w.add(FuzzyMatchFragment.this.f8988s);
                                FuzzyMatchFragment.this.f8992w.addAll(FuzzyMatchFragment.this.f8988s.sub_poi_list);
                            } else if (FuzzyMatchFragment.this.f8991v != null && i < FuzzyMatchFragment.this.f8991v.size()) {
                                RpcPoi rpcPoi2 = (RpcPoi) FuzzyMatchFragment.this.f8991v.get(i);
                                FuzzyMatchFragment.this.f8992w.add(rpcPoi2);
                                FuzzyMatchFragment.this.f8992w.addAll(rpcPoi2.sub_poi_list);
                            }
                            int unused5 = FuzzyMatchFragment.this.f8964C = 2;
                        } else {
                            int unused6 = FuzzyMatchFragment.this.f8964C = 1;
                        }
                        FuzzyMatchFragment fuzzyMatchFragment = FuzzyMatchFragment.this;
                        fuzzyMatchFragment.m7680a(fuzzyMatchFragment.f8964C, false);
                        FuzzyMatchFragment fuzzyMatchFragment2 = FuzzyMatchFragment.this;
                        fuzzyMatchFragment2.m7679a(fuzzyMatchFragment2.f8964C);
                    }

                    public void onConfirmAddress(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild) {
                        if (!(rpcPoi == null || rpcPoi.base_info == null || rpcPoi.base_info.srctag == null || !rpcPoi.base_info.srctag.equals("newes_parent_child") || TextUtils.isEmpty(rpcPoi.base_info.fullname))) {
                            rpcPoi.base_info.displayname = rpcPoi.base_info.fullname;
                        }
                        Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
                        AddressTrack.trackFuzzyMatchBackOrConfirm(rpcPoi, trackParameterForChild, FuzzyMatchFragment.this.getmParam().addressParam.clone(), AddressTrack.SEARCH_CK_TYPE.POI_CONFIRM);
                        FuzzyMatchFragment.this.m7697b(convertToAddress);
                    }
                });
            }
            this.f8986q = (FuzzyMatchListView) this.f8985p.getView(1);
            this.f8987r = (FuzzyMatchCardView) this.f8985p.getView(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public View m7672a(View view) {
        if (this.f8969N == null) {
            this.f8969N = (ViewGroup) View.inflate(getContext(), R.layout.map_view_shadowlayout, (ViewGroup) null);
        }
        ShadowLayout shadowLayout = (ShadowLayout) this.f8969N.findViewById(R.id.cardViewContainer);
        shadowLayout.removeAllViews();
        shadowLayout.setCornerRadius(40);
        shadowLayout.addView(view, new FrameLayout.LayoutParams(-1, -1));
        return this.f8969N;
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m7720m() {
        if (this.f8976g != null) {
            m7722n();
            this.f8976g.postDelayed(new Runnable() {
                public final void run() {
                    FuzzyMatchFragment.this.m7724o();
                }
            }, 100);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void m7724o() {
        if (this.f8976g != null && getContext() != null && getActivity() != null) {
            this.f8965J = new Padding(30, 30, 30, this.f8976g.getHeight() + DisplayUtils.dp2px(getActivity(), 10.0f));
            m7694b(this.f8976g.getHeight());
            IDropOffCompContract iDropOffCompContract = this.f8981l;
            if (iDropOffCompContract != null) {
                iDropOffCompContract.adjustMapCamera(this.f8965J);
            }
            FuzzyMatchAddressComponent fuzzyMatchAddressComponent = this.f8984o;
            if (fuzzyMatchAddressComponent != null) {
                fuzzyMatchAddressComponent.setPadding(this.f8965J);
            }
            View view = this.f8973d;
            if (view != null && this.f8976g != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int height = this.f8976g.getHeight();
                if (layoutParams.height != height) {
                    layoutParams.height = height;
                    this.f8973d.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7689a(List<RpcPoi> list, RpcPoi rpcPoi, boolean z, int i) {
        int i2;
        if (list != null && !list.isEmpty()) {
            if (z) {
                if (this.f8967L == 0) {
                    if (this.mCurrAddressType == 1) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.START_MAP_SELECT, this.f8962A);
                    } else if (this.mCurrAddressType == 2) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.END_MAP_SELECT, this.f8962A);
                    }
                    this.f8962A = false;
                }
                if (this.f8967L == 1) {
                    if (this.mCurrAddressType == 1) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.START_POI, this.f8963B);
                    } else if (this.mCurrAddressType == 2) {
                        AddressTrack.trackFuzzyMatchAddMapMarker(rpcPoi, getmParam().addressParam.clone(), AddressTrack.SUG_MAP_PAGE.END_POI, this.f8963B);
                    }
                    this.f8963B = false;
                    return;
                }
                return;
            }
            int i3 = this.f8964C;
            int i4 = -1;
            if (i3 == 0) {
                AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, getmParam().addressParam.clone(), list.indexOf(rpcPoi), -1, AddressTrack.SEARCH_CK_TYPE.SEARCH_MAP_CK);
            } else if (i3 == 1) {
                AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, getmParam().addressParam.clone(), list.indexOf(rpcPoi), -1, AddressTrack.SEARCH_CK_TYPE.POI_MAP_CK);
            } else if (i3 == 2 && rpcPoi != null && !CollectionUtil.isEmpty((Collection<?>) this.f8992w)) {
                if (!CollectionUtil.isEmpty((Collection<?>) rpcPoi.sub_poi_list)) {
                    i4 = list.indexOf(rpcPoi);
                    i2 = -1;
                } else {
                    i2 = this.f8992w.indexOf(rpcPoi) - 1;
                }
                AddressTrack.trackFuzzyMatchMapOrListCK(rpcPoi, getmParam().addressParam.clone(), i4, i2, AddressTrack.SEARCH_CK_TYPE.POI_GROUP_CK);
            }
        }
    }

    /* renamed from: n */
    private void m7722n() {
        FrameLayout frameLayout = this.f8976g;
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -1;
            this.f8976g.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: b */
    private void m7694b(int i) {
        ImageView imageView = this.f8975f;
        if (imageView != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, i - DisplayUtils.dp2px(getContext(), 5.0f));
        }
    }
}
