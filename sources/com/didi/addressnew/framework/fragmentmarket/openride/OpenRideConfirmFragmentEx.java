package com.didi.addressnew.framework.fragmentmarket.openride;

import android.animation.Animator;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.didi.address.AddressResult;
import com.didi.address.GlobalSugCallback;
import com.didi.address.ISugControlCallback;
import com.didi.address.SugAlertOmegaUtil;
import com.didi.address.actors.GeoCodeReActor;
import com.didi.address.model.SugParams;
import com.didi.address.util.PoiidCompleteUtils;
import com.didi.address.view.ISugViewController;
import com.didi.addressnew.fastframe.IView;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchParam;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.framework.utils.AddressConverter;
import com.didi.addressnew.presenter.AddressPresenter;
import com.didi.addressnew.presenter.ISimpleCompanyHomePresenter;
import com.didi.addressnew.presenter.SimpleCompanyHomePresenter;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.ApolloUtil;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.SugAnimationConstants;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.AddressAdapter;
import com.didi.addressnew.view.IAddressView;
import com.didi.addressnew.view.ISearchViewCallback;
import com.didi.addressnew.view.IStationFetcherView;
import com.didi.addressnew.view.SugListViewContainer;
import com.didi.addressnew.view.SugSearchView;
import com.didi.addressnew.view.commonaddress.IHomeCompanyUploadRequestReactor;
import com.didi.addressnew.view.enhance.WaittingAdapter;
import com.didi.addressnew.widget.EditTextErasable;
import com.didi.addressnew.widget.EmptyView;
import com.didi.addressnew.widget.NetErrorView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.recsug.RpcRecSugInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class OpenRideConfirmFragmentEx extends FragmentImpl implements IAddressView, ISearchViewCallback, IStationFetcherView {
    public static final int ENTER_ANIMATION_INTERVAL = 750;
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = OpenRideConfirmFragmentEx.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ArrayList<RpcPoi> f9066A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f9067B;

    /* renamed from: C */
    private boolean f9068C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public RpcRecSug.TrackParameterForChild f9069D;

    /* renamed from: E */
    private FrameLayout f9070E = null;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public EmptyView f9071F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public NetErrorView f9072G = null;

    /* renamed from: H */
    private boolean f9073H = true;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public AddressAdapter.OnItemSelectedListener f9074I = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            boolean z;
            Address address;
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                boolean unused = OpenRideConfirmFragmentEx.this.f9094r = true;
            }
            OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType = OpenRideConfirmFragmentEx.this.f9090n;
            if (ApolloUtil.getRecOmegaCKAB()) {
                z = AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG || AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG;
            } else {
                z = OpenRideConfirmFragmentEx.this.f9090n == 1 ? OpenRideConfirmFragmentEx.this.f9098v : OpenRideConfirmFragmentEx.this.f9099w;
            }
            int i3 = 3;
            int i4 = z ? 3 : 2;
            if (OpenRideConfirmFragmentEx.this.f9067B == RpcRecSugInfo.TYPE_EMPTY_RESULT && rpcPoi3.extend_info.enable_confirm_dropoff == 0 && !rpcPoi3.isDiscountPoi && CollectionUtil.isEmpty((Collection<?>) rpcPoi3.discount_poi)) {
                AddressTrack.trackAddressClick(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideConfirmFragmentEx.this.f9090n, AddressTrack.SUG_JUMP_TYPE.JUMP_POI, i4);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx.switchMapConfirm(openRideConfirmFragmentEx.getmParam(), rpcPoi, trackParameterForChild, OpenRideConfirmFragmentEx.this.getmResult(), OpenRideConfirmFragmentEx.this.f9067B);
            } else if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                    if (!ApolloUtil.getRecOmegaCKAB() ? !OpenRideConfirmFragmentEx.this.f9098v : AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        i3 = 2;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (OpenRideConfirmFragmentEx.this.f9090n == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                OpenRideConfirmFragmentEx.this.f9087k.getGeocodeResult(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, OpenRideConfirmFragmentEx.this.f9090n, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                        OpenRideConfirmFragmentEx.this.setResultBack(OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType, address);
                    }
                });
            } else {
                SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi3, trackParameterForChild2);
                if (rpcPoi3.base_info != null) {
                    rpcPoi3.base_info.searchId = trackParameterForChild2.search_id;
                }
                Address a = OpenRideConfirmFragmentEx.this.mo43812a(rpcPoi3);
                a.operationType = i4;
                if (OpenRideConfirmFragmentEx.this.f9090n != 2 || (!a.enableConfirmDropoff && !a.isDiscountPoi)) {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideConfirmFragmentEx.this.f9090n, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i4);
                } else {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideConfirmFragmentEx.this.f9090n, AddressTrack.SUG_JUMP_TYPE.JUMP_DROP_CONFIRM, i4);
                }
                if (OpenRideConfirmFragmentEx.this.f9090n == 3 || OpenRideConfirmFragmentEx.this.f9090n == 4) {
                    if (OpenRideConfirmFragmentEx.this.f9081e != null) {
                        OpenRideConfirmFragmentEx.this.f9081e.removeCommonWatcher(OpenRideConfirmFragmentEx.this.getmParam().addressParam);
                        OpenRideConfirmFragmentEx.this.f9081e.getCommonEditText().setText(rpcPoi3.base_info.displayname);
                    }
                    OpenRideConfirmFragmentEx.this.f9087k.setCommonAddress(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3);
                } else if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                    if (OpenRideConfirmFragmentEx.this.getSugCallback() == null || OpenRideConfirmFragmentEx.this.getSugCallback().getSugBuild() == null || OpenRideConfirmFragmentEx.this.getSugCallback().getSugBuild().getVersion() != 1) {
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx2.setResultBack(openRideConfirmFragmentEx2.f9090n, address);
                        if (!z) {
                            boolean unused2 = OpenRideConfirmFragmentEx.this.f9101y = true;
                            AddressTrack.trackRecItemSelect(i + 1);
                        }
                    } else {
                        SugParams clone = OpenRideConfirmFragmentEx.this.getmParam().clone();
                        clone.addressParam.addressType = 1;
                        IAddressResult iAddressResult = OpenRideConfirmFragmentEx.this.getmResult();
                        iAddressResult.setStart(address);
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx3.onConfirm(openRideConfirmFragmentEx3.getmParam(), iAddressResult.clone());
                        OpenRideConfirmFragmentEx.this.switchMapSelect(clone, iAddressResult.clone(), 1);
                        int unused3 = OpenRideConfirmFragmentEx.this.f9102z = 1;
                        return;
                    }
                } else if (OpenRideConfirmFragmentEx.this.f9090n == 2) {
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx4 = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx4.setResultBack(openRideConfirmFragmentEx4.f9090n, address);
                }
                OpenRideConfirmFragmentEx.this.f9087k.recordClickPoi(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info);
            }
        }

        private String getSearchText() {
            if (OpenRideConfirmFragmentEx.this.f9081e == null) {
                return "";
            }
            if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                return OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().getText().toString();
            }
            if (OpenRideConfirmFragmentEx.this.f9090n == 2) {
                return OpenRideConfirmFragmentEx.this.f9081e.getEndEditText().getText().toString();
            }
            if (OpenRideConfirmFragmentEx.this.f9090n == 3) {
                return OpenRideConfirmFragmentEx.this.f9081e.getCommonEditText().getText().toString();
            }
            if (OpenRideConfirmFragmentEx.this.f9090n == 4) {
                return OpenRideConfirmFragmentEx.this.f9081e.getCommonEditText().getText().toString();
            }
            return "";
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: J */
    public AddressAdapter.OnMapConfirmClickListener f9075J = new AddressAdapter.OnMapConfirmClickListener() {
        public void onMapConfirmClicked(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.switchMapConfirm(openRideConfirmFragmentEx.getmParam(), (RpcPoi) null, trackParameterForChild, OpenRideConfirmFragmentEx.this.getmResult(), i2);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public View.OnClickListener f9076K = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (OpenRideConfirmFragmentEx.this.f9075J != null) {
                OpenRideConfirmFragmentEx.this.f9075J.onMapConfirmClicked(OpenRideConfirmFragmentEx.this.f9066A, OpenRideConfirmFragmentEx.this.f9069D, OpenRideConfirmFragmentEx.this.f9090n, OpenRideConfirmFragmentEx.this.f9067B);
            }
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f9077a;

    /* renamed from: b */
    CommonAddressReactor f9078b = new CommonAddressReactor();

    /* renamed from: c */
    int f9079c = 0;

    /* renamed from: d */
    private final int f9080d = 12;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugSearchView f9081e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SugListViewContainer f9082f;

    /* renamed from: g */
    private ISugControlCallback f9083g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Address f9084h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f9085i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f9086j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f9087k;

    /* renamed from: l */
    private Handler f9088l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f9089m = 2;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f9090n = -1;

    /* renamed from: o */
    private int f9091o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f9092p;

    /* renamed from: q */
    private boolean f9093q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f9094r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f9095s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f9096t = false;

    /* renamed from: u */
    private boolean f9097u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f9098v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f9099w = false;

    /* renamed from: x */
    private boolean f9100x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f9101y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f9102z = -1;

    public boolean getDragHandlerEnable() {
        return true;
    }

    public View getFallbackView() {
        return null;
    }

    public /* synthetic */ String getStringVal(int i) {
        return IView.CC.$default$getStringVal(this, i);
    }

    public void onClearClick(int i, String str) {
    }

    public void onHttpRequestSuccess() {
    }

    public void setSugTips(String str) {
    }

    public void showEmptyView() {
    }

    public void showHasCommonAddressButError() {
    }

    public void showToastError(String str, boolean z) {
    }

    public void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null) {
            setCurrAddressType(getmParam().addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f9086j;
        if (globalSugCallback != null) {
            globalSugCallback.onAttach((getmParam() == null || getmParam().addressParam == null) ? Integer.MIN_VALUE : getmParam().addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m7777a();
    }

    /* renamed from: a */
    private void m7777a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f9087k = new AddressPresenter(getActivity(), this);
        this.f9077a = new SimpleCompanyHomePresenter(getActivity());
        this.f9095s = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        setCurrAddressType(getmParam().addressParam.addressType);
        this.f9088l = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    OpenRideConfirmFragmentEx.this.m7779a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f9090n = i;
    }

    public void setSearchViewType(int i) {
        this.f9089m = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        getActivity();
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sug_fragment, viewGroup, false);
        m7780a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m7780a(View view) {
        view.findViewById(R.id.top_bar).setVisibility(8);
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f9081e = sugSearchView;
        sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        this.f9082f = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f9070E = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f9071F = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f9072G = (NetErrorView) view.findViewById(R.id.net_view_error);
        m7802c();
        m7790b();
        m7806d();
        m7808e();
    }

    /* renamed from: b */
    private void m7790b() {
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(OpenRideConfirmFragmentEx.this.getActivity(), OpenRideConfirmFragmentEx.this.getView());
                    if (OpenRideConfirmFragmentEx.this.getSugCallback() != null) {
                        OpenRideConfirmFragmentEx.this.getSugCallback().onStartEndAddressChanged(OpenRideConfirmFragmentEx.this.m7814h(), OpenRideConfirmFragmentEx.this.f9085i);
                    }
                    if (!(OpenRideConfirmFragmentEx.this.getmParam() == null || OpenRideConfirmFragmentEx.this.getmParam().wayPointParam == null || OpenRideConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints() == null || OpenRideConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0) == null || OpenRideConfirmFragmentEx.this.m7814h() == null)) {
                        OpenRideConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0).setAddress(OpenRideConfirmFragmentEx.this.m7814h());
                    }
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.onConfirm(openRideConfirmFragmentEx.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx2.switchOpenRideWayPointer(openRideConfirmFragmentEx2.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                }
            });
            storeStartAddress(getmParam().addressParam);
            this.f9085i = getmParam().endAddress;
            this.f9081e.initSugSearchView(getmParam());
            this.f9081e.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    OpenRideConfirmFragmentEx.this.m7779a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(getmParam().fromType) || CommonUtils.isFromGetOnPage(getmParam().fromType)) && getmParam().addressParam.addressType == 1) {
                m7836s();
            }
            m7783a(getmParam().addressParam);
            this.f9081e.setListener(getmParam().addressParam);
            this.f9081e.makeStartTextFocusedWhenIsRed();
            this.f9081e.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(OpenRideConfirmFragmentEx.this.getmParam().fromType)) {
                        if (OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType == 1 && OpenRideConfirmFragmentEx.this.f9081e.isStartTextNeedScrollToBottomWhenFocused) {
                            OpenRideConfirmFragmentEx.this.m7824m();
                        }
                    } else if (CommonUtils.isFromGetOnPage(OpenRideConfirmFragmentEx.this.getmParam().fromType) && OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType == 1) {
                        OpenRideConfirmFragmentEx.this.m7836s();
                        OpenRideConfirmFragmentEx.this.f9081e.addWatcherForStart();
                    }
                }
            });
            this.f9081e.postDelayed(new Runnable() {
                public void run() {
                    if (OpenRideConfirmFragmentEx.this.f9082f != null) {
                        OpenRideConfirmFragmentEx.this.f9082f.setTopPadding(OpenRideConfirmFragmentEx.this.f9081e.getMeasuredHeight());
                    }
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.m7783a(openRideConfirmFragmentEx.getmParam().addressParam);
                }
            }, 200);
            if (this.f9081e.getStartEditText() != null) {
                this.f9081e.getStartEditText().setEnabled(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7783a(AddressParam addressParam) {
        if (addressParam.addressType == 2) {
            m7830p();
            EditTextErasable endEditText = this.f9081e.getEndEditText();
            if (endEditText != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (addressParam.addressType == 1) {
            m7828o();
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m7786a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f9090n;
    }

    /* renamed from: a */
    private boolean m7786a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 350);
        this.f9084h = address;
        onStartChoosen(address);
        if (address == null) {
            return false;
        }
        getmParam().addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m7802c() {
        this.f9082f.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                AutoTrackHelper.trackViewOnClick(view);
                String str = OpenRideConfirmFragmentEx.TAG;
                SystemUtils.log(3, str, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + OpenRideConfirmFragmentEx.this.f9089m + ", mCurrAddressType: " + OpenRideConfirmFragmentEx.this.f9090n, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx$6", 368);
                AddressTrack.trackMapSelect(OpenRideConfirmFragmentEx.this.getmParam().addressParam, OpenRideConfirmFragmentEx.this.f9090n, AddressPresenter.isLastCachedRecommendCache(OpenRideConfirmFragmentEx.this.f9090n));
                OpenRideConfirmFragmentEx.this.f9081e.setSearchViewCallback((ISearchViewCallback) null);
                if (ApolloUtil.getRecOmegaCKAB()) {
                    z = false;
                    if (OpenRideConfirmFragmentEx.this.f9090n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        z = true;
                    }
                } else {
                    z = OpenRideConfirmFragmentEx.this.f9090n == 1 ? OpenRideConfirmFragmentEx.this.f9098v : OpenRideConfirmFragmentEx.this.f9099w;
                }
                if (OpenRideConfirmFragmentEx.this.getmResult().getResult(OpenRideConfirmFragmentEx.this.f9090n) != null) {
                    OpenRideConfirmFragmentEx.this.getmResult().getResult(OpenRideConfirmFragmentEx.this.f9090n).operationType = !z ? 2 : 3;
                }
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx.onConfirm(openRideConfirmFragmentEx.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                SugParams clone = OpenRideConfirmFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideConfirmFragmentEx.this.f9090n;
                AddressResult addressResult = OpenRideConfirmFragmentEx.this.getmResult().getAddressResult();
                if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                    if (addressResult.start != null) {
                        clone.addressParam.targetAddress = addressResult.start;
                    }
                    int unused = OpenRideConfirmFragmentEx.this.f9102z = 1;
                } else if (OpenRideConfirmFragmentEx.this.f9090n == 2 && addressResult.end != null) {
                    clone.addressParam.targetAddress = addressResult.end;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.switchMapSelect(clone, openRideConfirmFragmentEx2.getmResult(), OpenRideConfirmFragmentEx.this.f9090n, bundle);
            }
        });
        this.f9082f.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(OpenRideConfirmFragmentEx.this.getContext(), OpenRideConfirmFragmentEx.this.f9082f.getListView());
                    if (OpenRideConfirmFragmentEx.this.f9079c != absListView.getFirstVisiblePosition()) {
                        int j = OpenRideConfirmFragmentEx.this.f9090n;
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(OpenRideConfirmFragmentEx.this.getmParam().fromType);
                        int pageLevel = CommonUtils.getPageLevel(OpenRideConfirmFragmentEx.this.getmParam().fromType, OpenRideConfirmFragmentEx.this.f9090n);
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                        AddressTrack.trackScrollCK(j, isFromRouteEditor ? 1 : 0, pageLevel, openRideConfirmFragmentEx.m7773a(openRideConfirmFragmentEx.f9090n), OpenRideConfirmFragmentEx.this.f9069D, OpenRideConfirmFragmentEx.this.f9079c, absListView.getFirstVisiblePosition(), OpenRideConfirmFragmentEx.this.f9090n == 1 ? OpenRideConfirmFragmentEx.this.f9098v : OpenRideConfirmFragmentEx.this.f9099w);
                    }
                }
                if (i == 1 || i == 2) {
                    OpenRideConfirmFragmentEx.this.f9079c = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m7806d() {
        this.f9070E.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f9071F.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f9081e.getStartEditText();
                } else {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f9090n == 2 ? OpenRideConfirmFragmentEx.this.f9081e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f9072G.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f9081e.getStartEditText();
                } else {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f9090n == 2 ? OpenRideConfirmFragmentEx.this.f9081e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f9071F.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f9072G.getRetryBtn() != null) {
            this.f9072G.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    view.setClickable(false);
                    OpenRideConfirmFragmentEx.this.f9071F.setVisibility(8);
                    if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx.m7791b(openRideConfirmFragmentEx.f9090n, OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().getText().toString(), true);
                    } else if (OpenRideConfirmFragmentEx.this.f9090n == 2) {
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx2.m7791b(openRideConfirmFragmentEx2.f9090n, OpenRideConfirmFragmentEx.this.f9081e.getEndEditText().getText().toString(), true);
                    }
                    view.postDelayed(new Runnable() {
                        public void run() {
                            view.setClickable(true);
                        }
                    }, 500);
                }
            });
        }
    }

    /* renamed from: b */
    private void m7792b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(OpenRideConfirmFragmentEx.this.f9090n == 3 && OpenRideConfirmFragmentEx.this.f9090n == 4)) {
                    AddressTrack.trackCloseButtonClick(OpenRideConfirmFragmentEx.this.getmParam(), OpenRideConfirmFragmentEx.this.m7818j());
                }
                if (OpenRideConfirmFragmentEx.this.f9086j != null) {
                    z = OpenRideConfirmFragmentEx.this.f9086j.onCloseButtonIntercept();
                }
                if (!z) {
                    OpenRideConfirmFragmentEx.this.closeFragment();
                    if (OpenRideConfirmFragmentEx.this.f9086j != null) {
                        OpenRideConfirmFragmentEx.this.f9086j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m7808e() {
        this.f9082f.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(OpenRideConfirmFragmentEx.this.getmParam().addressParam, OpenRideConfirmFragmentEx.this.f9090n - 1, OpenRideConfirmFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideConfirmFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = OpenRideConfirmFragmentEx.this.f9082f.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(OpenRideConfirmFragmentEx.this.getmParam(), homeAddress, OpenRideConfirmFragmentEx.this.f9090n);
                    homeAddress.operationType = 4;
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.setResultBack(openRideConfirmFragmentEx.f9090n, homeAddress);
                    return;
                }
                OpenRideConfirmFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.onConfirm(openRideConfirmFragmentEx2.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx3.switchSingle(openRideConfirmFragmentEx3.getmParam(), OpenRideConfirmFragmentEx.this.getmResult(), 3);
                int unused = OpenRideConfirmFragmentEx.this.f9102z = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(OpenRideConfirmFragmentEx.this.getmParam().addressParam, OpenRideConfirmFragmentEx.this.f9090n - 1, OpenRideConfirmFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideConfirmFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = OpenRideConfirmFragmentEx.this.f9082f.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(OpenRideConfirmFragmentEx.this.getmParam(), companyAddress, OpenRideConfirmFragmentEx.this.f9090n);
                    companyAddress.operationType = 5;
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.setResultBack(openRideConfirmFragmentEx.f9090n, companyAddress);
                    return;
                }
                OpenRideConfirmFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.onConfirm(openRideConfirmFragmentEx2.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx3.switchSingle(openRideConfirmFragmentEx3.getmParam(), OpenRideConfirmFragmentEx.this.getmResult(), 4);
                int unused = OpenRideConfirmFragmentEx.this.f9102z = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideConfirmFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(OpenRideConfirmFragmentEx.this.f9082f.getHomeAddress()), CommonUtils.isValidLocation(OpenRideConfirmFragmentEx.this.f9082f.getCompanyAddress()), OpenRideConfirmFragmentEx.this.f9090n - 1);
                SugParams clone = OpenRideConfirmFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideConfirmFragmentEx.this.f9090n;
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx.onConfirm(clone, openRideConfirmFragmentEx.getmResult());
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.switchFavorite(clone, openRideConfirmFragmentEx2.getmResult());
            }
        });
    }

    /* renamed from: a */
    private String m7774a(AddressResult addressResult) {
        String str;
        String str2;
        String str3;
        String str4;
        if (addressResult == null) {
            return "，";
        }
        if (addressResult.start != null) {
            str = "，" + "[起点:" + addressResult.start.displayName + "]\n";
        } else {
            str = "，[起点没设]\n";
        }
        if (addressResult.end != null) {
            str2 = str + "[终点:" + addressResult.end.displayName + "]\n";
        } else {
            str2 = str + "[终点没设]\n";
        }
        if (addressResult.home != null) {
            str3 = str2 + "[家:" + addressResult.home.displayName + "]\n";
        } else {
            str3 = str2 + "[家没设]\n";
        }
        if (addressResult.company != null) {
            str4 = str3 + "[公司点:" + addressResult.company.displayName + "]\n";
        } else {
            str4 = str3 + "[公司没设]\n";
        }
        if (addressResult.common != null) {
            return str4 + "[常点:" + addressResult.common.displayName + "]\n";
        }
        return str4 + "[常点没设]\n";
    }

    public void setSugControlCallback(ISugControlCallback iSugControlCallback) {
        this.f9083g = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f9073H = z;
    }

    public ISugViewController getSugViewController() {
        return this.f9082f;
    }

    public String getStartAddressText() {
        return this.f9081e.getStartEditText().getText().toString().trim();
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f9081e != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f9081e.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f9082f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f9082f.getListView().setAdapter(waittingAdapter);
        }
    }

    public String getStringSafe(int i) {
        return getStringVal(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7779a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 699);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f9081e.post(new Runnable() {
                public void run() {
                    if (!OpenRideConfirmFragmentEx.this.f9095s && OpenRideConfirmFragmentEx.this.f9072G.getVisibility() != 0) {
                        if (TextUtil.isEmpty(str) || OpenRideConfirmFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                            OpenRideConfirmFragmentEx.this.showWaittingList();
                        }
                    }
                }
            });
            if (m7787a(str)) {
                if (i == 2) {
                    this.f9099w = true;
                } else if (i == 1) {
                    this.f9098v = true;
                }
                this.f9087k.processDataRequire(clone, str, z, i);
                return;
            }
            this.f9087k.processDataRequire(clone, "", z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7791b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 737);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f9081e.post(new Runnable() {
                public void run() {
                    if (!OpenRideConfirmFragmentEx.this.f9095s) {
                        OpenRideConfirmFragmentEx.this.f9082f.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(OpenRideConfirmFragmentEx.this.getActivity()) - OpenRideConfirmFragmentEx.this.f9081e.getHeight()) / DisplayUtils.dp2px(OpenRideConfirmFragmentEx.this.getActivity(), 66.0f)) - 1));
                    }
                }
            });
            if (m7787a(str)) {
                if (i == 2) {
                    this.f9099w = true;
                } else if (i == 1) {
                    this.f9098v = true;
                }
                this.f9087k.getSuggestPoiList(clone, str, z, i, true);
                return;
            }
            this.f9087k.processDataRequire(clone, "", z, i);
        }
    }

    /* renamed from: a */
    private boolean m7787a(String str) {
        Address address;
        Address address2;
        if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
            return false;
        }
        if (this.f9090n == 1 && (((address2 = this.f9084h) != null && str.equals(address2.displayName)) || (getmParam().addressParam.targetAddress != null && str.equals(getmParam().addressParam.targetAddress.displayName)))) {
            return false;
        }
        if (this.f9090n != 2 || (address = this.f9085i) == null || !str.equals(address.displayName)) {
            return true;
        }
        return false;
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f9095s = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f9082f;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
        if (!this.f9101y && AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
            AddressTrack.trackRecItemSelect(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public boolean closeFragment() {
        m7811g();
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager != null) {
            try {
                if (fragmentManager.getBackStackEntryCount() > 1) {
                    fragmentManager.popBackStackImmediate();
                    return true;
                }
                fragmentManager.popBackStackImmediate();
                return false;
            } catch (Exception e) {
                DLog.m10773d("sfs", "GlobalSugFragment closeFragment() err msg: " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AddressTrack.onViewCreated(getmParam(), this.f9081e, this.f9082f);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.setStartAddressDrawableLeftGrey();
            if (this.f9081e.getStartEditText() != null) {
                this.f9081e.getStartEditText().setTextColor(-3355444);
            }
        }
        m7779a(getmParam().addressParam.addressType, "", false);
        SugAnimationConstants.setSugSearchViewHeightWhenHomepage(this.f9081e.getStartwithEndFullSize());
        m7809f();
    }

    /* renamed from: b */
    private void m7796b(RpcPoi rpcPoi) {
        if (this.f9087k != null && CommonUtils.isValidLocation(getmParam().addressParam) && getSugCallback() != null && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            this.f9087k.verifyStationAddress(getmParam(), rpcPoi);
        }
    }

    /* renamed from: f */
    private void m7809f() {
        if (this.f9087k != null && CommonUtils.isValidLocation(getmParam().addressParam)) {
            this.f9087k.fetchStartPoiInfo(getmParam());
        }
    }

    /* renamed from: g */
    private void m7811g() {
        AddressPresenter addressPresenter = this.f9087k;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f9087k.stopRevertGeo();
        }
    }

    public void onResume() {
        this.f9096t = true;
        super.onResume();
        AddressPresenter addressPresenter = this.f9087k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        this.f9096t = false;
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f9087k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43813a(GlobalSugCallback globalSugCallback) {
        this.f9086j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f9086j;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach(getmParam() != null ? getmParam().addressParam.addressType : Integer.MIN_VALUE);
        }
    }

    public void showProgressDialog(String str, boolean z) {
        if (z) {
            showLoading();
        } else {
            showMaskLayerLoading();
        }
    }

    public void showProgressDialog(boolean z) {
        if (z) {
            showLoading();
        } else {
            showMaskLayerLoading();
        }
    }

    public void dismissProgressDialog() {
        hideLoading();
    }

    public void showToastComplete(String str) {
        ToastHelper.showShortCompleted((Context) getActivity(), str);
    }

    public void showToastError(String str) {
        ToastHelper.showShortError((Context) getActivity(), str);
    }

    public void showContentView() {
        this.f9071F.setVisibility(8);
        this.f9072G.setVisibility(8);
        this.f9082f.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo43812a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f9082f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            boolean z = false;
            if (this.f9100x && !this.f9101y && AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                AddressTrack.trackRecItemSelect(0);
            }
            this.f9101y = false;
            if (AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                z = true;
            }
            this.f9100x = z;
            this.f9082f.post(new Runnable() {
                public void run() {
                    if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT || i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
                        ArrayList unused = OpenRideConfirmFragmentEx.this.f9066A = arrayList;
                        OpenRideConfirmFragmentEx.this.f9082f.getMapConfirmView().setOnClickListener(OpenRideConfirmFragmentEx.this.f9076K);
                    }
                    RpcRecSug.TrackParameterForChild unused2 = OpenRideConfirmFragmentEx.this.f9069D = trackParameterForChild;
                    int unused3 = OpenRideConfirmFragmentEx.this.f9067B = i;
                    AddressAdapter addressAdapter = new AddressAdapter();
                    addressAdapter.setOnItemSelectedListener(OpenRideConfirmFragmentEx.this.f9074I);
                    addressAdapter.updateAddress(arrayList, OpenRideConfirmFragmentEx.this.getmParam().clone(), trackParameterForChild, OpenRideConfirmFragmentEx.this.f9090n, i);
                    SugListViewContainer h = OpenRideConfirmFragmentEx.this.f9082f;
                    ArrayList arrayList = arrayList;
                    h.onAddressOcupy(arrayList == null ? true : arrayList.isEmpty(), false);
                    OpenRideConfirmFragmentEx.this.f9082f.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) {
            z = false;
        }
        this.f9082f.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9082f.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9082f.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        this.f9082f.onlyShowSelectPoiFooterView();
        updateSelectPoiFooters(true);
        showCommonAddressView(false);
        this.f9071F.setVisibility(8);
        this.f9072G.setVisibility(0);
        this.f9072G.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        this.f9082f.onlyShowSelectPoiFooterView();
        this.f9072G.setVisibility(8);
        this.f9071F.setVisibility(0);
        this.f9071F.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f9071F.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f9072G;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f9071F;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1357);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = this.f9094r;
            if (m7784a(i, address)) {
                closeSessionWithResult(getmResult());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m7814h() {
        Address address = this.f9084h;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: i */
    private Address m7816i() {
        Address address = this.f9085i;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: b */
    private void m7793b(AddressResult addressResult) {
        if (this.f9073H) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getContext().getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f9086j;
        if (globalSugCallback != null) {
            globalSugCallback.setResult(addressResult);
        }
    }

    public void toLogin() {
        if (!isSugFragmentRemoved() && getmParam() != null && getmParam().managerCallback != null && getmParam().addressParam.currentAddress != null) {
            getmParam().managerCallback.toLogin(getActivity(), getmParam().addressParam.currentAddress.latitude, getmParam().addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f9082f.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        this.f9082f.showSelectPoiFooterView(true);
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        if (str == null || i == 0 || i2 == 0) {
            this.f9068C = false;
        } else {
            this.f9068C = true;
        }
        this.f9082f.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f9081e != null && !this.f9093q && !this.f9095s && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1477);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), m7773a(i));
                if (i == 1) {
                    m7811g();
                    if (this.f9081e.isStartTextNeedScrollToBottomWhenFocused) {
                        m7824m();
                    }
                    m7779a(1, "", false);
                    AddressTrack.trackStartPointViewClick(getmParam().addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(getmParam()));
                    this.f9081e.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f9081e.getEndEditText().getText();
                    if (text != null) {
                        text.toString();
                    }
                    m7779a(2, "", false);
                    ViewUtils.showInputMethodForEditText(getContext(), this.f9081e.getEndEditText(), !this.f9095s);
                }
                this.f9081e.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f9084h != null) {
                    this.f9081e.getStartEditText().setText(this.f9084h.displayName);
                    if (this.f9084h.displayName == null || !this.f9084h.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
                        this.f9081e.getStartEditText().setTextColor(-16777216);
                        return;
                    }
                    this.f9081e.getStartEditText().setTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                    m7809f();
                }
            } else if (i == 2 && this.f9085i != null) {
                this.f9081e.getEndEditText().setText(this.f9085i.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m7773a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f9081e.getEndEditText().getText().toString().trim();
        }
        return (this.f9081e.getCommonEditText() == null || TextUtils.isEmpty(this.f9081e.getCommonEditText().getText())) ? "" : this.f9081e.getCommonEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m7818j() {
        return AddressTrack.getCurrPage(this.f9090n, this.f9081e, this.f9082f);
    }

    /* renamed from: k */
    private void m7819k() {
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.getEndEditText().setText("");
        }
    }

    /* renamed from: l */
    private void m7821l() {
        if (getmParam() != null && getmParam().addressParam.targetAddress != null) {
            this.f9081e.getStartEditText().setText(getmParam().addressParam.targetAddress.displayName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m7824m() {
        SugSearchView sugSearchView;
        if (!this.f9095s && (sugSearchView = this.f9081e) != null) {
            sugSearchView.getStartEditText().setSelection(0, this.f9081e.getStartEditText().length());
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f9081e.getStartEditText());
        }
    }

    /* renamed from: n */
    private void m7826n() {
        SugSearchView sugSearchView;
        if (!this.f9095s && (sugSearchView = this.f9081e) != null) {
            sugSearchView.getCommonEditText().requestFocus();
        }
    }

    /* renamed from: o */
    private void m7828o() {
        SugSearchView sugSearchView;
        if (!this.f9095s && (sugSearchView = this.f9081e) != null) {
            if (!sugSearchView.getStartEditText().isFocused()) {
                this.f9081e.setPressedState(true);
            }
            this.f9081e.getStartEditText().requestFocus();
        }
    }

    /* renamed from: p */
    private void m7830p() {
        SugSearchView sugSearchView;
        AddressTrack.isInSelectDestination = false;
        if (!this.f9095s && (sugSearchView = this.f9081e) != null) {
            if (!sugSearchView.getEndEditText().isFocused()) {
                this.f9081e.setPressedState(true);
            }
            this.f9081e.getEndEditText().requestFocus();
        }
    }

    /* renamed from: q */
    private void m7831q() {
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            Editable text = sugSearchView.getStartEditText().getText();
            if (!TextUtils.isEmpty(text)) {
                Selection.setSelection(text, text.length(), 0);
            }
        }
    }

    /* renamed from: r */
    private void m7834r() {
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.getStartEditText().setSelection(0);
        }
    }

    public void onClick(int i) {
        if (this.f9081e != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1654);
                m7811g();
                m7836s();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9081e.getStartEditText(), true ^ this.f9095s);
                this.f9081e.addWatcherForStart();
            } else if (i == 2) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1661);
                m7811g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9081e.getEndEditText(), true ^ this.f9095s);
                this.f9081e.addEndTextWatcher();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m7836s() {
        SugSearchView sugSearchView;
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(getmParam().addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getContext().getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText()) && (sugSearchView = this.f9081e) != null) {
            sugSearchView.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f9081e != null) {
            setSearchViewType(i);
            if (i == 2 && this.f9097u) {
                this.f9097u = false;
            } else if (view.hasFocus()) {
                m7778a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m7778a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f9088l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f9088l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m7799b(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
            this.f9081e.getStartEditText().setTextColor(-3355444);
        }
    }

    /* renamed from: b */
    private boolean m7799b(AddressParam addressParam) {
        if (addressParam == null || this.f9081e == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f9081e.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f9081e.getEndEditText().hasFocus();
        }
        return this.f9081e.getCommonEditText().hasFocus();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f9090n, convertToAddress);
        }
    }

    /* renamed from: a */
    private boolean m7784a(int i, Address address) {
        if (!CommonUtils.isValidLocation(address)) {
            return false;
        }
        if (i == 1) {
            if (address != null) {
                if (TextUtils.isEmpty(address.displayName) && isFragmentOnDuty()) {
                    DLog.m10773d("SugAddress", "start address.displayName = null,address = " + address, new Object[0]);
                    address.displayName = getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                }
                PoiidCompleteUtils.completePoiid(address);
            }
            Address address2 = this.f9085i;
            if (address2 != null) {
                if (!CommonUtils.isTwoAddressEqual(address2, address)) {
                    getmResult().setStart(address);
                    getmResult().setEnd(this.f9085i);
                    onConfirm(getmParam(), getmResult());
                } else {
                    CommonUtils.showDuplicateAlert(getContext());
                    return false;
                }
            }
        } else if (i == 2 && CommonUtils.isValidLocation(this.f9084h)) {
            if (!CommonUtils.isTwoAddressEqual(this.f9084h, address)) {
                getmResult().setStart(this.f9084h);
                getmResult().setEnd(address);
                onConfirm(getmParam(), getmResult());
            } else {
                CommonUtils.showDuplicateAlert(getContext());
                return false;
            }
        }
        return true;
    }

    public void onPageEnter() {
        long j;
        SugSearchView sugSearchView;
        if (this.f9081e != null) {
            final int i = this.f9090n;
            final int i2 = this.f9102z;
            if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                int i3 = this.f9090n;
                if (i3 == 1) {
                    getmResult().setStart(this.f9084h);
                } else if (i3 == 2) {
                    getmResult().setEnd(this.f9085i);
                }
            }
            super.onPageEnter();
            boolean z = getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit;
            final boolean z2 = getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Chose;
            final boolean z3 = getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.FuzzyMatch;
            boolean z4 = getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel;
            if (!z && !z2 && !z3 && !z4) {
                if (CommonUtils.isFromGetOnPage(getmParam().fromType) || CommonUtils.isFromNewConfirmPage(getmParam().fromType) || CommonUtils.isFromHomePage(getmParam().fromType)) {
                    AddressTrack.trackSugPageSW(0, AddressTrack.page_level_one, 0);
                }
                if (CommonUtils.isFromRouteEditor(getmParam().fromType)) {
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, this.f9090n);
                }
            }
            this.f9081e.setSearchViewCallback((ISearchViewCallback) null);
            this.f9081e.removeWatcherForStart();
            this.f9081e.removeEndTextWatcher();
            this.f9081e.hideShadow();
            SugSearchView sugSearchView2 = this.f9081e;
            if (sugSearchView2 != null) {
                sugSearchView2.getStartEditText().setFocusable(false);
                this.f9081e.getStartEditText().setFocusableInTouchMode(false);
                this.f9081e.getEndEditText().setFocusable(false);
                this.f9081e.getEndEditText().setFocusableInTouchMode(false);
                this.f9081e.postDelayed(new Runnable() {
                    public void run() {
                        OpenRideConfirmFragmentEx.this.f9081e.addWatcherForStart();
                        OpenRideConfirmFragmentEx.this.f9081e.addEndTextWatcher();
                        OpenRideConfirmFragmentEx.this.f9081e.setSearchViewCallback(OpenRideConfirmFragmentEx.this);
                    }
                }, 750);
            }
            SugSearchView sugSearchView3 = this.f9081e;
            if (sugSearchView3 != null) {
                final boolean z5 = z;
                final boolean z6 = z4;
                final int i4 = i;
                j = 30;
                final boolean z7 = z2;
                final boolean z8 = z3;
                sugSearchView3.postDelayed(new Runnable() {
                    public void run() {
                        if (OpenRideConfirmFragmentEx.this.f9081e != null) {
                            OpenRideConfirmFragmentEx.this.f9081e.setSearchViewCallback(OpenRideConfirmFragmentEx.this);
                            OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setFocusable(true);
                            OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setFocusableInTouchMode(true);
                            OpenRideConfirmFragmentEx.this.f9081e.getEndEditText().setFocusable(true);
                            OpenRideConfirmFragmentEx.this.f9081e.getEndEditText().setFocusableInTouchMode(true);
                        }
                        if (!OpenRideConfirmFragmentEx.this.isFirstEnter() && !z5 && !z6 && i2 == -1) {
                            return;
                        }
                        if (i4 == 1 && !z7 && !z8) {
                            OpenRideConfirmFragmentEx.this.f9081e.setPressedState(false);
                            if (OpenRideConfirmFragmentEx.this.f9081e != null) {
                                OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().requestFocus();
                                OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setTextIsSelectable(true);
                                OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setCursorVisible(false);
                                OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setCursorVisible(true);
                                if ((OpenRideConfirmFragmentEx.this.isFirstEnter() || !OpenRideConfirmFragmentEx.this.f9096t) && OpenRideConfirmFragmentEx.this.getmResult().getResult(i4) != null) {
                                    OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setText(OpenRideConfirmFragmentEx.this.getmResult().getResult(i4).displayName);
                                }
                                if (!TextUtils.isEmpty(OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().getText())) {
                                    OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setClearIconVisible(true);
                                }
                                OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setSelection(0, OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().length());
                            }
                        } else if (i4 == 2) {
                            if (OpenRideConfirmFragmentEx.this.f9081e != null) {
                                OpenRideConfirmFragmentEx.this.f9081e.getEndEditText().requestFocus();
                            }
                            OpenRideConfirmFragmentEx.this.f9081e.getEndEditText().setSelection(0, OpenRideConfirmFragmentEx.this.f9081e.getEndEditText().length());
                        }
                    }
                }, 30);
                this.f9081e.postDelayed(new Runnable() {
                    public void run() {
                        if (z2 && !OpenRideConfirmFragmentEx.this.f9096t) {
                            return;
                        }
                        if (z3 && !OpenRideConfirmFragmentEx.this.isResumeCalled()) {
                            return;
                        }
                        if (OpenRideConfirmFragmentEx.this.f9090n == 1) {
                            ViewUtils.showInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), OpenRideConfirmFragmentEx.this.f9081e.getStartEditText());
                            OpenRideConfirmFragmentEx.this.f9081e.resetShadow(OpenRideConfirmFragmentEx.this.f9081e.getStartEditText());
                        } else if (OpenRideConfirmFragmentEx.this.f9090n == 2) {
                            ViewUtils.showInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), OpenRideConfirmFragmentEx.this.f9081e.getEndEditText());
                            OpenRideConfirmFragmentEx.this.f9081e.resetShadow(OpenRideConfirmFragmentEx.this.f9081e.getEndEditText());
                        }
                    }
                }, 500);
            } else {
                j = 30;
            }
            if (getmResult().getLastOperType() != AddressResultEnhancer.OperType.Cancel && getmResult().getLastOperType() != AddressResultEnhancer.OperType.Other) {
                if (isFirstEnter() || !this.f9096t) {
                    if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT) {
                        int i5 = this.f9102z;
                        if (i5 == 3) {
                            if (this.f9082f != null && getmResult().getAddressResult().home != null) {
                                this.f9082f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone = getmParam().addressParam.clone();
                                clone.addressType = 3;
                                this.f9077a.setHomeCompany(clone, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f9078b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f9078b.onHomeUploadFailed();
                            }
                            this.f9102z = -1;
                            return;
                        } else if (i5 == 4) {
                            if (this.f9082f != null && getmResult().getAddressResult().company != null) {
                                this.f9082f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone2 = getmParam().addressParam.clone();
                                clone2.addressType = 4;
                                this.f9077a.setHomeCompany(clone2, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f9078b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f9078b.onCompanyUploadFailed();
                            }
                            this.f9102z = -1;
                            return;
                        } else if (i5 == 1 && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().start != null) {
                                SugSearchView sugSearchView4 = this.f9081e;
                                if (sugSearchView4 != null) {
                                    sugSearchView4.postDelayed(new Runnable() {
                                        public void run() {
                                            if (OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start != null) {
                                                OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setText(OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                                OpenRideConfirmFragmentEx.this.m7779a(i, "", false);
                                            }
                                            OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().requestFocus();
                                            OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setSelection(0, OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().length());
                                            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                                            String unused = openRideConfirmFragmentEx.f9092p = openRideConfirmFragmentEx.getmResult().getAddressResult().start.displayName;
                                        }
                                    }, j);
                                }
                            } else {
                                Address address = getmResult().getAddressResult().start;
                            }
                            this.f9102z = -1;
                            return;
                        }
                    } else {
                        int i6 = this.f9102z;
                        if (i6 == 3) {
                            if (this.f9082f != null && getmResult().getAddressResult().home != null) {
                                this.f9082f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone3 = getmParam().addressParam.clone();
                                clone3.addressType = this.f9102z;
                                this.f9077a.setHomeCompany(clone3, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f9078b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f9078b.onHomeUploadFailed();
                            }
                            this.f9102z = -1;
                            return;
                        } else if (i6 == 4) {
                            if (this.f9082f != null && getmResult().getAddressResult().company != null) {
                                this.f9082f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone4 = getmParam().addressParam.clone();
                                clone4.addressType = this.f9102z;
                                this.f9077a.setHomeCompany(clone4, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f9078b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f9078b.onCompanyUploadFailed();
                            }
                            this.f9102z = -1;
                            return;
                        }
                    }
                    if (i == 1) {
                        if (this.f9081e != null && !isFirstEnter() && getmResult().getAddressResult().start != null) {
                            this.f9081e.postDelayed(new Runnable() {
                                public void run() {
                                    if (OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start != null) {
                                        OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().setText(OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                        OpenRideConfirmFragmentEx.this.m7779a(i, "", false);
                                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                                        Address unused = openRideConfirmFragmentEx.f9084h = openRideConfirmFragmentEx.getmResult().getAddressResult().start;
                                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                                        openRideConfirmFragmentEx2.onStartChoosen(openRideConfirmFragmentEx2.f9084h);
                                        OpenRideConfirmFragmentEx.this.f9081e.getStartEditText().requestFocus();
                                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                                        openRideConfirmFragmentEx3.setResultBack(i, openRideConfirmFragmentEx3.f9084h);
                                    }
                                }
                            }, j);
                        }
                    } else if (i == 2 && (sugSearchView = this.f9081e) != null) {
                        sugSearchView.getEndEditText().requestFocus();
                        this.f9081e.addEndTextWatcher();
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().end != null) {
                                this.f9081e.getEndEditText().setText(getmResult().getAddressResult().end.displayName);
                            }
                        } else if (getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT || getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Other) {
                            this.f9085i = getmResult().getAddressResult().end;
                            if (!isFirstEnter() && this.f9085i != null) {
                                this.f9081e.postDelayed(new Runnable() {
                                    public void run() {
                                        if (OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().end != null) {
                                            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                                            openRideConfirmFragmentEx.setResultBack(i, openRideConfirmFragmentEx.getmResult().getAddressResult().end);
                                        }
                                    }
                                }, j);
                            }
                        } else if (this.f9085i != null) {
                            this.f9081e.getEndEditText().setText(this.f9085i.displayName);
                        } else {
                            m7819k();
                        }
                    }
                }
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        int i = 0;
        this.f9096t = false;
        SugSearchView sugSearchView = this.f9081e;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            this.f9081e.setSearchViewCallback((ISearchViewCallback) null);
        }
        if (getType() == FragmentFactory.FragmentType.FULL) {
            int i2 = this.f9090n;
            if (i2 == 1) {
                if (this.f9084h == null) {
                    getmResult().setStart(getmParam().addressParam.targetAddress);
                    onConfirm(getmParam(), getmResult());
                } else {
                    getmResult().setStart(this.f9084h);
                }
                if (this.f9081e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f9081e.getStartEditText());
                }
            } else if (i2 == 2) {
                if (this.f9085i != null) {
                    getmResult().setEnd(this.f9085i);
                }
                if (AddressPresenter.isLastCachedRecommendCache(2)) {
                    AddressParam addressParam = getmParam().addressParam;
                    SugListViewContainer sugListViewContainer = this.f9082f;
                    if (sugListViewContainer != null) {
                        i = sugListViewContainer.getVisibleCount();
                    }
                    AddressTrack.trackEndRecVisibleListItemCount(addressParam, i);
                }
                if (this.f9081e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f9081e.getEndEditText());
                }
            }
        }
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        super.onCancel(sugParams, iAddressResult);
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        super.onConfirm(sugParams, iAddressResult);
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.FULL;
    }

    public SugSearchView getmSugSearchView() {
        return this.f9081e;
    }

    public void onStartChoosen(Address address) {
        super.onStartChoosen(address);
    }

    public void switchToStationMapSelect() {
        if (this.f9090n == 1 && !isRemoving() && !isSugFragmentRemoved()) {
            onConfirm(getmParam(), getmResult());
            switchMapSelect(getmParam().clone(), getmResult(), 1);
        }
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m7797b(openRideConfirmFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m7804c(openRideConfirmFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m7804c(openRideConfirmFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m7797b(openRideConfirmFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !OpenRideConfirmFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7797b(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7804c(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showFail(getContext(), str);
        }
    }

    public boolean switchMapConfirm(SugParams sugParams, RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, IAddressResult iAddressResult, int i) {
        SugParams clone;
        boolean z = false;
        if (sugParams == null || iAddressResult == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        if (this.f9090n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
            z = true;
        }
        int i2 = z ? 3 : 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST, this.f9066A);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS, rpcPoi);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM, trackParameterForChild);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP, i);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE, i2);
        bundle.putBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER, this.f9068C);
        if (rpcPoi != null) {
            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
            convertToAddress.operationType = i2;
            int i3 = this.f9090n;
            if (i3 == 1) {
                clone.addressParam.addressType = 1;
                this.f9102z = 1;
                iAddressResult.setStart(convertToAddress);
            } else if (i3 == 2) {
                clone.addressParam.addressType = 2;
                this.f9102z = 2;
                iAddressResult.setEnd(convertToAddress);
            }
        }
        onConfirm(getmParam(), iAddressResult.clone());
        switchMapConfirm(clone, iAddressResult, this.f9090n, bundle);
        return true;
    }
}
