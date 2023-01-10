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
import com.didi.addressnew.util.CheckParamUtil;
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

public class OpenRideFragmentEx extends FragmentImpl implements IAddressView, ISearchViewCallback, IStationFetcherView {
    public static final int ENTER_ANIMATION_INTERVAL = 750;
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = "OpenRideFragmentEx";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ArrayList<RpcPoi> f9103A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f9104B;

    /* renamed from: C */
    private boolean f9105C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public RpcRecSug.TrackParameterForChild f9106D;

    /* renamed from: E */
    private FrameLayout f9107E = null;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public EmptyView f9108F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public NetErrorView f9109G = null;

    /* renamed from: H */
    private boolean f9110H = true;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public AddressAdapter.OnItemSelectedListener f9111I = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            boolean z;
            Address address;
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (OpenRideFragmentEx.this.f9127n == 1) {
                boolean unused = OpenRideFragmentEx.this.f9131r = true;
            }
            OpenRideFragmentEx.this.getmParam().addressParam.addressType = OpenRideFragmentEx.this.f9127n;
            if (ApolloUtil.getRecOmegaCKAB()) {
                z = AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG || AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG;
            } else {
                z = OpenRideFragmentEx.this.f9127n == 1 ? OpenRideFragmentEx.this.f9135v : OpenRideFragmentEx.this.f9136w;
            }
            int i3 = 3;
            int i4 = z ? 3 : 2;
            if (OpenRideFragmentEx.this.f9104B == RpcRecSugInfo.TYPE_EMPTY_RESULT && rpcPoi3.extend_info.enable_confirm_dropoff == 0 && !rpcPoi3.isDiscountPoi && CollectionUtil.isEmpty((Collection<?>) rpcPoi3.discount_poi)) {
                AddressTrack.trackAddressClick(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideFragmentEx.this.f9127n, AddressTrack.SUG_JUMP_TYPE.JUMP_POI, i4);
                OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                openRideFragmentEx.switchMapConfirm(openRideFragmentEx.getmParam(), rpcPoi, trackParameterForChild, OpenRideFragmentEx.this.getmResult(), OpenRideFragmentEx.this.f9104B);
            } else if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (OpenRideFragmentEx.this.f9127n == 1) {
                    if (!ApolloUtil.getRecOmegaCKAB() ? !OpenRideFragmentEx.this.f9135v : AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        i3 = 2;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (OpenRideFragmentEx.this.f9127n == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                OpenRideFragmentEx.this.f9124k.getGeocodeResult(OpenRideFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, OpenRideFragmentEx.this.f9127n, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                        OpenRideFragmentEx.this.setResultBack(OpenRideFragmentEx.this.getmParam().addressParam.addressType, address);
                    }
                });
            } else {
                SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi3, trackParameterForChild2);
                if (rpcPoi3.base_info != null) {
                    rpcPoi3.base_info.searchId = trackParameterForChild2.search_id;
                }
                Address a = OpenRideFragmentEx.this.mo43844a(rpcPoi3);
                a.operationType = i4;
                if (OpenRideFragmentEx.this.f9127n != 2 || (!a.enableConfirmDropoff && !a.isDiscountPoi)) {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideFragmentEx.this.f9127n, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i4);
                } else {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideFragmentEx.this.f9127n, AddressTrack.SUG_JUMP_TYPE.JUMP_DROP_CONFIRM, i4);
                }
                if (OpenRideFragmentEx.this.f9127n == 3 || OpenRideFragmentEx.this.f9127n == 4) {
                    if (OpenRideFragmentEx.this.f9118e != null) {
                        OpenRideFragmentEx.this.f9118e.removeCommonWatcher(OpenRideFragmentEx.this.getmParam().addressParam);
                        OpenRideFragmentEx.this.f9118e.getCommonEditText().setText(rpcPoi3.base_info.displayname);
                    }
                    OpenRideFragmentEx.this.f9124k.setCommonAddress(OpenRideFragmentEx.this.getmParam(), rpcPoi3);
                } else if (OpenRideFragmentEx.this.f9127n == 1) {
                    if (OpenRideFragmentEx.this.getSugCallback() == null || OpenRideFragmentEx.this.getSugCallback().getSugBuild() == null || OpenRideFragmentEx.this.getSugCallback().getSugBuild().getVersion() != 1) {
                        OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                        openRideFragmentEx2.setResultBack(openRideFragmentEx2.f9127n, address);
                        if (!z) {
                            boolean unused2 = OpenRideFragmentEx.this.f9138y = true;
                            AddressTrack.trackRecItemSelect(i + 1);
                        }
                    } else {
                        SugParams clone = OpenRideFragmentEx.this.getmParam().clone();
                        clone.addressParam.addressType = 1;
                        IAddressResult iAddressResult = OpenRideFragmentEx.this.getmResult();
                        iAddressResult.setStart(address);
                        OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                        openRideFragmentEx3.onConfirm(openRideFragmentEx3.getmParam(), iAddressResult.clone());
                        OpenRideFragmentEx.this.switchMapSelect(clone, iAddressResult.clone(), 1);
                        int unused3 = OpenRideFragmentEx.this.f9139z = 1;
                        return;
                    }
                } else if (OpenRideFragmentEx.this.f9127n == 2) {
                    OpenRideFragmentEx openRideFragmentEx4 = OpenRideFragmentEx.this;
                    openRideFragmentEx4.setResultBack(openRideFragmentEx4.f9127n, address);
                }
                OpenRideFragmentEx.this.f9124k.recordClickPoi(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info);
            }
        }

        private String getSearchText() {
            if (OpenRideFragmentEx.this.f9118e == null) {
                return "";
            }
            if (OpenRideFragmentEx.this.f9127n == 1) {
                return OpenRideFragmentEx.this.f9118e.getStartEditText().getText().toString();
            }
            if (OpenRideFragmentEx.this.f9127n == 2) {
                return OpenRideFragmentEx.this.f9118e.getEndEditText().getText().toString();
            }
            if (OpenRideFragmentEx.this.f9127n == 3) {
                return OpenRideFragmentEx.this.f9118e.getCommonEditText().getText().toString();
            }
            if (OpenRideFragmentEx.this.f9127n == 4) {
                return OpenRideFragmentEx.this.f9118e.getCommonEditText().getText().toString();
            }
            return "";
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: J */
    public AddressAdapter.OnMapConfirmClickListener f9112J = new AddressAdapter.OnMapConfirmClickListener() {
        public void onMapConfirmClicked(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.switchMapConfirm(openRideFragmentEx.getmParam(), (RpcPoi) null, trackParameterForChild, OpenRideFragmentEx.this.getmResult(), i2);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public View.OnClickListener f9113K = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (OpenRideFragmentEx.this.f9112J != null) {
                OpenRideFragmentEx.this.f9112J.onMapConfirmClicked(OpenRideFragmentEx.this.f9103A, OpenRideFragmentEx.this.f9106D, OpenRideFragmentEx.this.f9127n, OpenRideFragmentEx.this.f9104B);
            }
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f9114a;

    /* renamed from: b */
    CommonAddressReactor f9115b = new CommonAddressReactor();

    /* renamed from: c */
    int f9116c = 0;

    /* renamed from: d */
    private final int f9117d = 12;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugSearchView f9118e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SugListViewContainer f9119f;

    /* renamed from: g */
    private ISugControlCallback f9120g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Address f9121h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f9122i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f9123j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f9124k;

    /* renamed from: l */
    private Handler f9125l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f9126m = 2;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f9127n = -1;

    /* renamed from: o */
    private int f9128o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f9129p;

    /* renamed from: q */
    private boolean f9130q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f9131r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f9132s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f9133t = false;

    /* renamed from: u */
    private boolean f9134u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f9135v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f9136w = false;

    /* renamed from: x */
    private boolean f9137x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f9138y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f9139z = -1;

    public boolean getDragHandlerEnable() {
        return true;
    }

    public View getFallbackView() {
        return null;
    }

    public /* synthetic */ String getStringVal(int i) {
        return IView.CC.$default$getStringVal(this, i);
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
        if (getmParam() != null) {
            Context context = getContext();
            CheckParamUtil.rescueAddressParam(context, getClass().getSimpleName() + " onAttach", getmParam().addressParam);
            setCurrAddressType(getmParam().addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f9123j;
        if (globalSugCallback != null) {
            globalSugCallback.onAttach((getmParam() == null || getmParam().addressParam == null) ? Integer.MIN_VALUE : getmParam().addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m7857a();
    }

    /* renamed from: a */
    private void m7857a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f9124k = new AddressPresenter(getActivity(), this);
        this.f9114a = new SimpleCompanyHomePresenter(getActivity());
        this.f9132s = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        setCurrAddressType(getmParam().addressParam.addressType);
        this.f9125l = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    OpenRideFragmentEx.this.m7859a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f9127n = i;
    }

    public void setSearchViewType(int i) {
        this.f9126m = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        getActivity();
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sug_fragment, viewGroup, false);
        m7860a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m7860a(View view) {
        view.findViewById(R.id.top_bar).setVisibility(8);
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f9118e = sugSearchView;
        sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        this.f9119f = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f9107E = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f9108F = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f9109G = (NetErrorView) view.findViewById(R.id.net_view_error);
        m7882c();
        m7870b();
        m7886d();
        m7888e();
    }

    /* renamed from: b */
    private void m7870b() {
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(OpenRideFragmentEx.this.getActivity(), OpenRideFragmentEx.this.getView());
                    if (OpenRideFragmentEx.this.getSugCallback() != null) {
                        OpenRideFragmentEx.this.getSugCallback().onStartEndAddressChanged(OpenRideFragmentEx.this.m7894h(), OpenRideFragmentEx.this.f9122i);
                    }
                    if (!(OpenRideFragmentEx.this.getmParam() == null || OpenRideFragmentEx.this.getmParam().wayPointParam == null || OpenRideFragmentEx.this.getmParam().wayPointParam.getWayPoints() == null || OpenRideFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0) == null || OpenRideFragmentEx.this.m7894h() == null)) {
                        OpenRideFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0).setAddress(OpenRideFragmentEx.this.m7894h());
                    }
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.onConfirm(openRideFragmentEx.getmParam(), OpenRideFragmentEx.this.getmResult());
                    OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                    openRideFragmentEx2.switchOpenRideWayPointer(openRideFragmentEx2.getmParam(), OpenRideFragmentEx.this.getmResult());
                }
            });
            storeStartAddress(getmParam().addressParam);
            this.f9122i = getmParam().endAddress;
            this.f9118e.initSugSearchView(getmParam());
            if (this.f9118e.getStartEditText() != null) {
                this.f9118e.getStartEditText().setEnabled(false);
            }
            this.f9118e.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    OpenRideFragmentEx.this.m7859a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(getmParam().fromType) || CommonUtils.isFromGetOnPage(getmParam().fromType)) && getmParam().addressParam.addressType == 1) {
                m7916s();
            }
            m7863a(getmParam().addressParam);
            this.f9118e.setListener(getmParam().addressParam);
            this.f9118e.makeStartTextFocusedWhenIsRed();
            this.f9118e.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(OpenRideFragmentEx.this.getmParam().fromType)) {
                        if (OpenRideFragmentEx.this.getmParam().addressParam.addressType == 1 && OpenRideFragmentEx.this.f9118e.isStartTextNeedScrollToBottomWhenFocused) {
                            OpenRideFragmentEx.this.m7904m();
                        }
                    } else if (CommonUtils.isFromGetOnPage(OpenRideFragmentEx.this.getmParam().fromType) && OpenRideFragmentEx.this.getmParam().addressParam.addressType == 1) {
                        OpenRideFragmentEx.this.m7916s();
                        OpenRideFragmentEx.this.f9118e.addWatcherForStart();
                    }
                }
            });
            this.f9118e.postDelayed(new Runnable() {
                public void run() {
                    if (OpenRideFragmentEx.this.f9119f != null) {
                        OpenRideFragmentEx.this.f9119f.setTopPadding(OpenRideFragmentEx.this.f9118e.getMeasuredHeight());
                    }
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.m7863a(openRideFragmentEx.getmParam().addressParam);
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7863a(AddressParam addressParam) {
        if (addressParam.addressType == 2) {
            m7910p();
            EditTextErasable endEditText = this.f9118e.getEndEditText();
            if (endEditText != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (addressParam.addressType == 1) {
            m7908o();
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m7866a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f9127n;
    }

    /* renamed from: a */
    private boolean m7866a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 350);
        this.f9121h = address;
        onStartChoosen(address);
        if (address == null) {
            return false;
        }
        getmParam().addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m7882c() {
        this.f9119f.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.log(3, OpenRideFragmentEx.TAG, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + OpenRideFragmentEx.this.f9126m + ", mCurrAddressType: " + OpenRideFragmentEx.this.f9127n, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx$6", 368);
                AddressTrack.trackMapSelect(OpenRideFragmentEx.this.getmParam().addressParam, OpenRideFragmentEx.this.f9127n, AddressPresenter.isLastCachedRecommendCache(OpenRideFragmentEx.this.f9127n));
                OpenRideFragmentEx.this.f9118e.setSearchViewCallback((ISearchViewCallback) null);
                if (ApolloUtil.getRecOmegaCKAB()) {
                    z = false;
                    if (OpenRideFragmentEx.this.f9127n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        z = true;
                    }
                } else {
                    z = OpenRideFragmentEx.this.f9127n == 1 ? OpenRideFragmentEx.this.f9135v : OpenRideFragmentEx.this.f9136w;
                }
                if (OpenRideFragmentEx.this.getmResult().getResult(OpenRideFragmentEx.this.f9127n) != null) {
                    OpenRideFragmentEx.this.getmResult().getResult(OpenRideFragmentEx.this.f9127n).operationType = !z ? 2 : 3;
                }
                OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                openRideFragmentEx.onConfirm(openRideFragmentEx.getmParam(), OpenRideFragmentEx.this.getmResult());
                SugParams clone = OpenRideFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideFragmentEx.this.f9127n;
                AddressResult addressResult = OpenRideFragmentEx.this.getmResult().getAddressResult();
                if (OpenRideFragmentEx.this.f9127n == 1) {
                    if (addressResult.start != null) {
                        clone.addressParam.targetAddress = addressResult.start;
                    }
                    int unused = OpenRideFragmentEx.this.f9139z = 1;
                } else if (OpenRideFragmentEx.this.f9127n == 2 && addressResult.end != null) {
                    clone.addressParam.targetAddress = addressResult.end;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.switchMapSelect(clone, openRideFragmentEx2.getmResult(), OpenRideFragmentEx.this.f9127n, bundle);
            }
        });
        this.f9119f.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(OpenRideFragmentEx.this.getContext(), OpenRideFragmentEx.this.f9119f.getListView());
                    if (OpenRideFragmentEx.this.f9116c != absListView.getFirstVisiblePosition()) {
                        int j = OpenRideFragmentEx.this.f9127n;
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(OpenRideFragmentEx.this.getmParam().fromType);
                        int pageLevel = CommonUtils.getPageLevel(OpenRideFragmentEx.this.getmParam().fromType, OpenRideFragmentEx.this.f9127n);
                        OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                        AddressTrack.trackScrollCK(j, isFromRouteEditor ? 1 : 0, pageLevel, openRideFragmentEx.m7853a(openRideFragmentEx.f9127n), OpenRideFragmentEx.this.f9106D, OpenRideFragmentEx.this.f9116c, absListView.getFirstVisiblePosition(), OpenRideFragmentEx.this.f9127n == 1 ? OpenRideFragmentEx.this.f9135v : OpenRideFragmentEx.this.f9136w);
                    }
                }
                if (i == 1 || i == 2) {
                    OpenRideFragmentEx.this.f9116c = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m7886d() {
        this.f9107E.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f9108F.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideFragmentEx.this.f9127n == 1) {
                    editTextErasable = OpenRideFragmentEx.this.f9118e.getStartEditText();
                } else {
                    editTextErasable = OpenRideFragmentEx.this.f9127n == 2 ? OpenRideFragmentEx.this.f9118e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f9109G.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideFragmentEx.this.f9127n == 1) {
                    editTextErasable = OpenRideFragmentEx.this.f9118e.getStartEditText();
                } else {
                    editTextErasable = OpenRideFragmentEx.this.f9127n == 2 ? OpenRideFragmentEx.this.f9118e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f9108F.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f9109G.getRetryBtn() != null) {
            this.f9109G.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    view.setClickable(false);
                    OpenRideFragmentEx.this.f9108F.setVisibility(8);
                    if (OpenRideFragmentEx.this.f9127n == 1) {
                        OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                        openRideFragmentEx.m7871b(openRideFragmentEx.f9127n, OpenRideFragmentEx.this.f9118e.getStartEditText().getText().toString(), true);
                    } else if (OpenRideFragmentEx.this.f9127n == 2) {
                        OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                        openRideFragmentEx2.m7871b(openRideFragmentEx2.f9127n, OpenRideFragmentEx.this.f9118e.getEndEditText().getText().toString(), true);
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
    private void m7872b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(OpenRideFragmentEx.this.f9127n == 3 && OpenRideFragmentEx.this.f9127n == 4)) {
                    AddressTrack.trackCloseButtonClick(OpenRideFragmentEx.this.getmParam(), OpenRideFragmentEx.this.m7898j());
                }
                if (OpenRideFragmentEx.this.f9123j != null) {
                    z = OpenRideFragmentEx.this.f9123j.onCloseButtonIntercept();
                }
                if (!z) {
                    OpenRideFragmentEx.this.closeFragment();
                    if (OpenRideFragmentEx.this.f9123j != null) {
                        OpenRideFragmentEx.this.f9123j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m7888e() {
        this.f9119f.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(OpenRideFragmentEx.this.getmParam().addressParam, OpenRideFragmentEx.this.f9127n - 1, OpenRideFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = OpenRideFragmentEx.this.f9119f.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(OpenRideFragmentEx.this.getmParam(), homeAddress, OpenRideFragmentEx.this.f9127n);
                    homeAddress.operationType = 4;
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.setResultBack(openRideFragmentEx.f9127n, homeAddress);
                    return;
                }
                OpenRideFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.onConfirm(openRideFragmentEx2.getmParam(), OpenRideFragmentEx.this.getmResult());
                OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                openRideFragmentEx3.switchSingle(openRideFragmentEx3.getmParam(), OpenRideFragmentEx.this.getmResult(), 3);
                int unused = OpenRideFragmentEx.this.f9139z = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(OpenRideFragmentEx.this.getmParam().addressParam, OpenRideFragmentEx.this.f9127n - 1, OpenRideFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = OpenRideFragmentEx.this.f9119f.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(OpenRideFragmentEx.this.getmParam(), companyAddress, OpenRideFragmentEx.this.f9127n);
                    companyAddress.operationType = 5;
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.setResultBack(openRideFragmentEx.f9127n, companyAddress);
                    return;
                }
                OpenRideFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.onConfirm(openRideFragmentEx2.getmParam(), OpenRideFragmentEx.this.getmResult());
                OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                openRideFragmentEx3.switchSingle(openRideFragmentEx3.getmParam(), OpenRideFragmentEx.this.getmResult(), 4);
                int unused = OpenRideFragmentEx.this.f9139z = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(OpenRideFragmentEx.this.f9119f.getHomeAddress()), CommonUtils.isValidLocation(OpenRideFragmentEx.this.f9119f.getCompanyAddress()), OpenRideFragmentEx.this.getmParam().addressParam.addressType - 1);
                SugParams clone = OpenRideFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideFragmentEx.this.f9127n;
                OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                openRideFragmentEx.onConfirm(clone, openRideFragmentEx.getmResult());
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.switchFavorite(clone, openRideFragmentEx2.getmResult());
            }
        });
    }

    /* renamed from: a */
    private String m7854a(AddressResult addressResult) {
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
        this.f9120g = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f9110H = z;
    }

    public ISugViewController getSugViewController() {
        return this.f9119f;
    }

    public String getStartAddressText() {
        return this.f9118e.getStartEditText().getText().toString().trim();
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f9118e != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f9118e.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f9119f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f9119f.getListView().setAdapter(waittingAdapter);
        }
    }

    public String getStringSafe(int i) {
        return getStringVal(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7859a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 696);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f9118e.post(new Runnable() {
                public void run() {
                    if (!OpenRideFragmentEx.this.f9132s && OpenRideFragmentEx.this.f9109G.getVisibility() != 0) {
                        if (TextUtil.isEmpty(str) || OpenRideFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                            OpenRideFragmentEx.this.showWaittingList();
                        }
                    }
                }
            });
            if (m7867a(str)) {
                if (i == 2) {
                    this.f9136w = true;
                } else if (i == 1) {
                    this.f9135v = true;
                }
                this.f9124k.processDataRequire(clone, str, z, i);
                return;
            }
            this.f9124k.processDataRequire(clone, "", z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7871b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 735);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f9118e.post(new Runnable() {
                public void run() {
                    if (!OpenRideFragmentEx.this.f9132s) {
                        OpenRideFragmentEx.this.f9119f.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(OpenRideFragmentEx.this.getActivity()) - OpenRideFragmentEx.this.f9118e.getHeight()) / DisplayUtils.dp2px(OpenRideFragmentEx.this.getActivity(), 66.0f)) - 1));
                    }
                }
            });
            if (m7867a(str)) {
                if (i == 2) {
                    this.f9136w = true;
                } else if (i == 1) {
                    this.f9135v = true;
                }
                this.f9124k.getSuggestPoiList(clone, str, z, i, true);
                return;
            }
            this.f9124k.processDataRequire(clone, "", z, i);
        }
    }

    /* renamed from: a */
    private boolean m7867a(String str) {
        Address address;
        Address address2;
        if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
            return false;
        }
        if (this.f9127n == 1 && (((address2 = this.f9121h) != null && str.equals(address2.displayName)) || (getmParam().addressParam.targetAddress != null && str.equals(getmParam().addressParam.targetAddress.displayName)))) {
            return false;
        }
        if (this.f9127n != 2 || (address = this.f9122i) == null || !str.equals(address.displayName)) {
            return true;
        }
        return false;
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f9132s = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f9119f;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
        if (!this.f9138y && AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
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
        m7891g();
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
        AddressTrack.onViewCreated(getmParam(), this.f9118e, this.f9119f);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.setStartAddressDrawableLeftGrey();
            if (this.f9118e.getStartEditText() != null) {
                this.f9118e.getStartEditText().setTextColor(-3355444);
            }
        }
        m7859a(getmParam().addressParam.addressType, "", false);
        SugAnimationConstants.setSugSearchViewHeightWhenHomepage(this.f9118e.getStartwithEndFullSize());
        if ((getmParam().addressParam.targetAddress != null && (getmParam().addressParam.targetAddress.displayName.equals(getString(R.string.GRider_Sug_2020_currentLoc)) || TextUtils.isEmpty(getmParam().addressParam.targetAddress.displayName))) || getmParam().addressParam.targetAddress.displayName == null) {
            this.f9124k.startRevertGeo(getmParam());
        }
    }

    /* renamed from: b */
    private void m7876b(RpcPoi rpcPoi) {
        if (this.f9124k != null && CommonUtils.isValidLocation(getmParam().addressParam) && getSugCallback() != null && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            this.f9124k.verifyStationAddress(getmParam(), rpcPoi);
        }
    }

    /* renamed from: f */
    private void m7889f() {
        if (this.f9124k != null && CommonUtils.isValidLocation(getmParam().addressParam)) {
            this.f9124k.fetchStartPoiInfo(getmParam());
        }
    }

    /* renamed from: g */
    private void m7891g() {
        AddressPresenter addressPresenter = this.f9124k;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f9124k.stopRevertGeo();
        }
    }

    public void onResume() {
        this.f9133t = true;
        super.onResume();
        AddressPresenter addressPresenter = this.f9124k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        this.f9133t = false;
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f9124k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo43845a(GlobalSugCallback globalSugCallback) {
        this.f9123j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f9123j;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach((getmParam() == null || getmParam().addressParam == null) ? Integer.MIN_VALUE : getmParam().addressParam.addressType);
        }
        Handler handler = this.f9125l;
        if (handler != null) {
            handler.removeMessages(12);
            this.f9125l = null;
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
        this.f9108F.setVisibility(8);
        this.f9109G.setVisibility(8);
        this.f9119f.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo43844a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f9119f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            if (addressParam == null || addressParam.addressType == this.f9127n) {
                boolean z = false;
                if (this.f9137x && !this.f9138y && AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    AddressTrack.trackRecItemSelect(0);
                }
                this.f9138y = false;
                if (AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    z = true;
                }
                this.f9137x = z;
                this.f9119f.post(new Runnable() {
                    public void run() {
                        if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT || i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
                            ArrayList unused = OpenRideFragmentEx.this.f9103A = arrayList;
                            OpenRideFragmentEx.this.f9119f.getMapConfirmView().setOnClickListener(OpenRideFragmentEx.this.f9113K);
                        }
                        RpcRecSug.TrackParameterForChild unused2 = OpenRideFragmentEx.this.f9106D = trackParameterForChild;
                        int unused3 = OpenRideFragmentEx.this.f9104B = i;
                        AddressAdapter addressAdapter = new AddressAdapter();
                        addressAdapter.setOnItemSelectedListener(OpenRideFragmentEx.this.f9111I);
                        addressAdapter.updateAddress(arrayList, OpenRideFragmentEx.this.getmParam().clone(), trackParameterForChild, OpenRideFragmentEx.this.f9127n, i);
                        SugListViewContainer h = OpenRideFragmentEx.this.f9119f;
                        ArrayList arrayList = arrayList;
                        h.onAddressOcupy(arrayList == null ? true : arrayList.isEmpty(), false);
                        OpenRideFragmentEx.this.f9119f.getListView().setAdapter(addressAdapter);
                    }
                });
                hideLoading();
            }
        }
    }

    public void showCommonAddressView(boolean z) {
        if (getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) {
            z = false;
        }
        this.f9119f.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9119f.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9119f.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        this.f9119f.onlyShowSelectPoiFooterView();
        updateSelectPoiFooters(true);
        showCommonAddressView(false);
        this.f9108F.setVisibility(8);
        this.f9109G.setVisibility(0);
        this.f9109G.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        this.f9119f.onlyShowSelectPoiFooterView();
        this.f9109G.setVisibility(8);
        this.f9108F.setVisibility(0);
        this.f9108F.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f9108F.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f9109G;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f9108F;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1366);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = this.f9131r;
            if (m7864a(i, address)) {
                closeSessionWithResult(getmResult());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m7894h() {
        Address address = this.f9121h;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: i */
    private Address m7896i() {
        Address address = this.f9122i;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: b */
    private void m7873b(AddressResult addressResult) {
        if (this.f9110H) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getContext().getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f9123j;
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
        this.f9119f.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        this.f9119f.showSelectPoiFooterView(true);
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        if (str == null || i == 0 || i2 == 0) {
            this.f9105C = false;
        } else {
            this.f9105C = true;
        }
        this.f9119f.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f9118e != null && !this.f9130q && !this.f9132s && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1486);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), m7853a(i));
                if (i == 1) {
                    m7891g();
                    if (this.f9118e.isStartTextNeedScrollToBottomWhenFocused) {
                        m7904m();
                    }
                    m7859a(1, "", false);
                    AddressTrack.trackStartPointViewClick(getmParam().addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(getmParam()));
                    this.f9118e.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f9118e.getEndEditText().getText();
                    if (text != null) {
                        text.toString();
                    }
                    m7859a(2, "", false);
                    ViewUtils.showInputMethodForEditText(getContext(), this.f9118e.getEndEditText(), !this.f9132s);
                }
                this.f9118e.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f9121h != null) {
                    this.f9118e.getStartEditText().setText(this.f9121h.displayName);
                    if (this.f9121h.displayName == null || !this.f9121h.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
                        this.f9118e.getStartEditText().setTextColor(-3355444);
                        return;
                    }
                    this.f9118e.getStartEditText().setTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                    m7889f();
                }
            } else if (i == 2 && this.f9122i != null) {
                this.f9118e.getEndEditText().setText(this.f9122i.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m7853a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f9118e.getEndEditText().getText().toString().trim();
        }
        return (this.f9118e.getCommonEditText() == null || TextUtils.isEmpty(this.f9118e.getCommonEditText().getText())) ? "" : this.f9118e.getCommonEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m7898j() {
        return AddressTrack.getCurrPage(this.f9127n, this.f9118e, this.f9119f);
    }

    /* renamed from: k */
    private void m7899k() {
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.getEndEditText().setText("");
        }
    }

    /* renamed from: l */
    private void m7901l() {
        if (getmParam() != null && getmParam().addressParam.targetAddress != null) {
            this.f9118e.getStartEditText().setText(getmParam().addressParam.targetAddress.displayName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m7904m() {
        SugSearchView sugSearchView;
        if (!this.f9132s && (sugSearchView = this.f9118e) != null) {
            sugSearchView.getStartEditText().setSelection(0, this.f9118e.getStartEditText().length());
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f9118e.getStartEditText());
        }
    }

    /* renamed from: n */
    private void m7906n() {
        SugSearchView sugSearchView;
        if (!this.f9132s && (sugSearchView = this.f9118e) != null) {
            sugSearchView.getCommonEditText().requestFocus();
        }
    }

    /* renamed from: o */
    private void m7908o() {
        SugSearchView sugSearchView;
        if (!this.f9132s && (sugSearchView = this.f9118e) != null) {
            if (!sugSearchView.getStartEditText().isFocused()) {
                this.f9118e.setPressedState(true);
            }
            this.f9118e.getStartEditText().requestFocus();
        }
    }

    /* renamed from: p */
    private void m7910p() {
        SugSearchView sugSearchView;
        AddressTrack.isInSelectDestination = false;
        if (!this.f9132s && (sugSearchView = this.f9118e) != null) {
            if (!sugSearchView.getEndEditText().isFocused()) {
                this.f9118e.setPressedState(true);
            }
            this.f9118e.getEndEditText().requestFocus();
        }
    }

    /* renamed from: q */
    private void m7911q() {
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            Editable text = sugSearchView.getStartEditText().getText();
            if (!TextUtils.isEmpty(text)) {
                Selection.setSelection(text, text.length(), 0);
            }
        }
    }

    /* renamed from: r */
    private void m7914r() {
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.getStartEditText().setSelection(0);
        }
    }

    public void onClick(int i) {
        if (this.f9118e != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1662);
                m7891g();
                m7916s();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9118e.getStartEditText(), true ^ this.f9132s);
                this.f9118e.addWatcherForStart();
            } else if (i == 2) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1669);
                m7891g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9118e.getEndEditText(), true ^ this.f9132s);
                this.f9118e.addEndTextWatcher();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m7916s() {
        SugSearchView sugSearchView;
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(getmParam().addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getContext().getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText()) && (sugSearchView = this.f9118e) != null) {
            sugSearchView.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f9118e != null) {
            setSearchViewType(i);
            if (i == 2 && this.f9134u) {
                this.f9134u = false;
            } else if (view.hasFocus()) {
                m7858a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m7858a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f9125l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f9125l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m7879b(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
            this.f9118e.getStartEditText().setTextColor(-3355444);
        }
    }

    /* renamed from: b */
    private boolean m7879b(AddressParam addressParam) {
        if (addressParam == null || this.f9118e == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f9118e.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f9118e.getEndEditText().hasFocus();
        }
        return this.f9118e.getCommonEditText().hasFocus();
    }

    public void onClearClick(int i, String str) {
        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
        AddressTrack.trackSugClear(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f9127n, convertToAddress);
        }
    }

    /* renamed from: a */
    private boolean m7864a(int i, Address address) {
        if (!CommonUtils.isValidLocation(address)) {
            return false;
        }
        if (i != 2 || CommonUtils.isTwoAddressEqual(this.f9121h, address)) {
            return true;
        }
        getmResult().setStart(this.f9121h);
        getmResult().setEnd(address);
        onConfirm(getmParam(), getmResult());
        return true;
    }

    public void onPageEnter() {
        long j;
        SugSearchView sugSearchView;
        if (this.f9118e != null) {
            final int i = this.f9127n;
            final int i2 = this.f9139z;
            if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                int i3 = this.f9127n;
                if (i3 == 1) {
                    getmResult().setStart(this.f9121h);
                } else if (i3 == 2) {
                    getmResult().setEnd(this.f9122i);
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
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, this.f9127n);
                }
            }
            this.f9118e.setSearchViewCallback((ISearchViewCallback) null);
            this.f9118e.removeWatcherForStart();
            this.f9118e.removeEndTextWatcher();
            this.f9118e.hideShadow();
            SugSearchView sugSearchView2 = this.f9118e;
            if (sugSearchView2 != null) {
                sugSearchView2.getStartEditText().setFocusable(false);
                this.f9118e.getStartEditText().setFocusableInTouchMode(false);
                this.f9118e.getEndEditText().setFocusable(false);
                this.f9118e.getEndEditText().setFocusableInTouchMode(false);
                this.f9118e.postDelayed(new Runnable() {
                    public void run() {
                        OpenRideFragmentEx.this.f9118e.addWatcherForStart();
                        OpenRideFragmentEx.this.f9118e.addEndTextWatcher();
                        OpenRideFragmentEx.this.f9118e.setSearchViewCallback(OpenRideFragmentEx.this);
                    }
                }, 750);
            }
            SugSearchView sugSearchView3 = this.f9118e;
            if (sugSearchView3 != null) {
                final boolean z5 = z;
                final boolean z6 = z4;
                final int i4 = i;
                j = 30;
                final boolean z7 = z2;
                final boolean z8 = z3;
                sugSearchView3.postDelayed(new Runnable() {
                    public void run() {
                        if (OpenRideFragmentEx.this.f9118e != null) {
                            OpenRideFragmentEx.this.f9118e.setSearchViewCallback(OpenRideFragmentEx.this);
                            OpenRideFragmentEx.this.f9118e.getStartEditText().setFocusable(true);
                            OpenRideFragmentEx.this.f9118e.getStartEditText().setFocusableInTouchMode(true);
                            OpenRideFragmentEx.this.f9118e.getEndEditText().setFocusable(true);
                            OpenRideFragmentEx.this.f9118e.getEndEditText().setFocusableInTouchMode(true);
                        }
                        if (!OpenRideFragmentEx.this.isFirstEnter() && !z5 && !z6 && i2 == -1) {
                            return;
                        }
                        if (i4 == 1 && !z7 && !z8) {
                            OpenRideFragmentEx.this.f9118e.setPressedState(false);
                            if (OpenRideFragmentEx.this.f9118e != null) {
                                OpenRideFragmentEx.this.f9118e.getStartEditText().requestFocus();
                                OpenRideFragmentEx.this.f9118e.getStartEditText().setTextIsSelectable(true);
                                OpenRideFragmentEx.this.f9118e.getStartEditText().setCursorVisible(false);
                                OpenRideFragmentEx.this.f9118e.getStartEditText().setCursorVisible(true);
                                if ((OpenRideFragmentEx.this.isFirstEnter() || !OpenRideFragmentEx.this.f9133t) && OpenRideFragmentEx.this.getmResult().getResult(i4) != null) {
                                    OpenRideFragmentEx.this.f9118e.getStartEditText().setText(OpenRideFragmentEx.this.getmResult().getResult(i4).displayName);
                                }
                                if (!TextUtils.isEmpty(OpenRideFragmentEx.this.f9118e.getStartEditText().getText())) {
                                    OpenRideFragmentEx.this.f9118e.getStartEditText().setClearIconVisible(true);
                                }
                                OpenRideFragmentEx.this.f9118e.getStartEditText().setSelection(0, OpenRideFragmentEx.this.f9118e.getStartEditText().length());
                            }
                        } else if (i4 == 2) {
                            if (OpenRideFragmentEx.this.f9118e != null) {
                                OpenRideFragmentEx.this.f9118e.getEndEditText().requestFocus();
                            }
                            OpenRideFragmentEx.this.f9118e.getEndEditText().setSelection(0, OpenRideFragmentEx.this.f9118e.getEndEditText().length());
                        }
                    }
                }, 30);
                this.f9118e.postDelayed(new Runnable() {
                    public void run() {
                        if (z2 && !OpenRideFragmentEx.this.f9133t) {
                            return;
                        }
                        if (z3 && !OpenRideFragmentEx.this.isResumeCalled()) {
                            return;
                        }
                        if (OpenRideFragmentEx.this.f9127n == 1) {
                            ViewUtils.showInputMethodForEditText(OpenRideFragmentEx.this.getContext(), OpenRideFragmentEx.this.f9118e.getStartEditText());
                            OpenRideFragmentEx.this.f9118e.resetShadow(OpenRideFragmentEx.this.f9118e.getStartEditText());
                        } else if (OpenRideFragmentEx.this.f9127n == 2) {
                            ViewUtils.showInputMethodForEditText(OpenRideFragmentEx.this.getContext(), OpenRideFragmentEx.this.f9118e.getEndEditText());
                            OpenRideFragmentEx.this.f9118e.resetShadow(OpenRideFragmentEx.this.f9118e.getEndEditText());
                        }
                    }
                }, 500);
            } else {
                j = 30;
            }
            if (getmResult().getLastOperType() != AddressResultEnhancer.OperType.Cancel && getmResult().getLastOperType() != AddressResultEnhancer.OperType.Other) {
                if (isFirstEnter() || !this.f9133t) {
                    if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT) {
                        int i5 = this.f9139z;
                        if (i5 == 3) {
                            if (this.f9119f != null && getmResult().getAddressResult().home != null) {
                                this.f9119f.setHomeAddress(getmResult().getAddressResult().home);
                                SugParams clone = getmParam().clone();
                                clone.addressParam.addressType = 3;
                                this.f9114a.setHomeCompany(clone.addressParam, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f9115b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f9115b.onHomeUploadFailed();
                            }
                            this.f9139z = -1;
                            return;
                        } else if (i5 == 4) {
                            if (this.f9119f != null && getmResult().getAddressResult().company != null) {
                                this.f9119f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone2 = getmParam().addressParam.clone();
                                clone2.addressType = 4;
                                this.f9114a.setHomeCompany(clone2, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f9115b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f9115b.onCompanyUploadFailed();
                            }
                            this.f9139z = -1;
                            return;
                        } else if (i5 == 1 && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().start != null) {
                                SugSearchView sugSearchView4 = this.f9118e;
                                if (sugSearchView4 != null) {
                                    sugSearchView4.postDelayed(new Runnable() {
                                        public void run() {
                                            if (OpenRideFragmentEx.this.getmResult().getAddressResult().start != null) {
                                                OpenRideFragmentEx.this.f9118e.getStartEditText().setText(OpenRideFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                                OpenRideFragmentEx.this.m7859a(i, "", false);
                                            }
                                            OpenRideFragmentEx.this.f9118e.getStartEditText().requestFocus();
                                            OpenRideFragmentEx.this.f9118e.getStartEditText().setSelection(0, OpenRideFragmentEx.this.f9118e.getStartEditText().length());
                                            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                                            String unused = openRideFragmentEx.f9129p = openRideFragmentEx.getmResult().getAddressResult().start.displayName;
                                        }
                                    }, j);
                                }
                            } else {
                                Address address = getmResult().getAddressResult().start;
                            }
                            this.f9139z = -1;
                            return;
                        }
                    } else {
                        int i6 = this.f9139z;
                        if (i6 == 3) {
                            if (this.f9119f != null && getmResult().getAddressResult().home != null) {
                                this.f9119f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone3 = getmParam().addressParam.clone();
                                clone3.addressType = this.f9139z;
                                this.f9114a.setHomeCompany(clone3, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f9115b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f9115b.onHomeUploadFailed();
                            }
                            this.f9139z = -1;
                            return;
                        } else if (i6 == 4) {
                            if (this.f9119f != null && getmResult().getAddressResult().company != null) {
                                this.f9119f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone4 = getmParam().addressParam.clone();
                                clone4.addressType = this.f9139z;
                                this.f9114a.setHomeCompany(clone4, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f9115b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f9115b.onCompanyUploadFailed();
                            }
                            this.f9139z = -1;
                            return;
                        }
                    }
                    if (i == 1) {
                        if (this.f9118e != null && !isFirstEnter() && getmResult().getAddressResult().start != null) {
                            this.f9118e.postDelayed(new Runnable() {
                                public void run() {
                                    if (OpenRideFragmentEx.this.getmResult().getAddressResult().start != null) {
                                        OpenRideFragmentEx.this.f9118e.getStartEditText().setText(OpenRideFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                        OpenRideFragmentEx.this.m7859a(i, "", false);
                                        OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                                        Address unused = openRideFragmentEx.f9121h = openRideFragmentEx.getmResult().getAddressResult().start;
                                        OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                                        openRideFragmentEx2.onStartChoosen(openRideFragmentEx2.f9121h);
                                        OpenRideFragmentEx.this.f9118e.getStartEditText().requestFocus();
                                        OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                                        openRideFragmentEx3.setResultBack(i, openRideFragmentEx3.f9121h);
                                    }
                                }
                            }, j);
                        }
                    } else if (i == 2 && (sugSearchView = this.f9118e) != null) {
                        sugSearchView.getEndEditText().requestFocus();
                        this.f9118e.addEndTextWatcher();
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().end != null) {
                                this.f9118e.getEndEditText().setText(getmResult().getAddressResult().end.displayName);
                            }
                        } else if (getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT || getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Other) {
                            this.f9122i = getmResult().getAddressResult().end;
                            if (!isFirstEnter() && this.f9122i != null) {
                                this.f9118e.postDelayed(new Runnable() {
                                    public void run() {
                                        if (OpenRideFragmentEx.this.getmResult().getAddressResult().end != null) {
                                            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                                            openRideFragmentEx.setResultBack(i, openRideFragmentEx.getmResult().getAddressResult().end);
                                        }
                                    }
                                }, j);
                            }
                        } else if (this.f9122i != null) {
                            this.f9118e.getEndEditText().setText(this.f9122i.displayName);
                        } else {
                            m7899k();
                        }
                    }
                }
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        int i = 0;
        this.f9133t = false;
        SugSearchView sugSearchView = this.f9118e;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            this.f9118e.setSearchViewCallback((ISearchViewCallback) null);
        }
        if (getType() == FragmentFactory.FragmentType.FULL) {
            int i2 = this.f9127n;
            if (i2 == 1) {
                if (this.f9121h == null) {
                    getmResult().setStart(getmParam().addressParam.targetAddress);
                    onConfirm(getmParam(), getmResult());
                } else {
                    getmResult().setStart(this.f9121h);
                }
                if (this.f9118e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f9118e.getStartEditText());
                }
            } else if (i2 == 2) {
                if (this.f9122i != null) {
                    getmResult().setEnd(this.f9122i);
                }
                if (AddressPresenter.isLastCachedRecommendCache(2)) {
                    AddressParam addressParam = getmParam().addressParam;
                    SugListViewContainer sugListViewContainer = this.f9119f;
                    if (sugListViewContainer != null) {
                        i = sugListViewContainer.getVisibleCount();
                    }
                    AddressTrack.trackEndRecVisibleListItemCount(addressParam, i);
                }
                if (this.f9118e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f9118e.getEndEditText());
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
        return this.f9118e;
    }

    public void onStartChoosen(Address address) {
        super.onStartChoosen(address);
    }

    public void switchToStationMapSelect() {
        if (this.f9127n == 1 && !isRemoving() && !isSugFragmentRemoved()) {
            onConfirm(getmParam(), getmResult());
            switchMapSelect(getmParam().clone(), getmResult(), 1);
        }
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m7877b(openRideFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m7884c(openRideFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m7884c(openRideFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m7877b(openRideFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !OpenRideFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7877b(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m7884c(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showFail(getContext(), str);
        }
    }

    public IFragment.ParentNode getNodeType() {
        return IFragment.ParentNode.FULL;
    }

    public boolean switchMapConfirm(SugParams sugParams, RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, IAddressResult iAddressResult, int i) {
        SugParams clone;
        boolean z = false;
        if (sugParams == null || iAddressResult == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        if (this.f9127n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
            z = true;
        }
        int i2 = z ? 3 : 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST, this.f9103A);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS, rpcPoi);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM, trackParameterForChild);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP, i);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE, i2);
        bundle.putBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER, this.f9105C);
        if (rpcPoi != null) {
            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
            convertToAddress.operationType = i2;
            int i3 = this.f9127n;
            if (i3 == 1) {
                clone.addressParam.addressType = 1;
                this.f9139z = 1;
                iAddressResult.setStart(convertToAddress);
            } else if (i3 == 2) {
                clone.addressParam.addressType = 2;
                this.f9139z = 2;
                iAddressResult.setEnd(convertToAddress);
            }
        }
        onConfirm(getmParam(), iAddressResult.clone());
        switchMapConfirm(clone, iAddressResult, this.f9127n, bundle);
        return true;
    }
}
