package com.didi.addressold.vamos;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.ISugControlCallback;
import com.didi.address.SugAlertOmegaUtil;
import com.didi.address.model.SugParams;
import com.didi.address.view.IPoiChangeListener;
import com.didi.address.view.ISugViewController;
import com.didi.addressold.delegate.SelectAddressByDraggedDelegate;
import com.didi.addressold.delegate.SoftKeyboardDelegate;
import com.didi.addressold.presenter.AddressPresenter;
import com.didi.addressold.util.AddressConvertUtil;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.util.CheckParamUtil;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.util.LogUtils;
import com.didi.addressold.util.ViewUtils;
import com.didi.addressold.vamos.Util.ApolloUtil;
import com.didi.addressold.view.AddressAdapter;
import com.didi.addressold.view.CommonAddressActivity;
import com.didi.addressold.view.IAddressView;
import com.didi.addressold.view.ISearchViewCallback;
import com.didi.addressold.view.ISugContainerOpCallback;
import com.didi.addressold.view.ISugMapCtrlCallback;
import com.didi.addressold.view.SugListViewContainer;
import com.didi.addressold.view.SugSearchView;
import com.didi.addressold.widget.EditTextErasable;
import com.didi.addressold.widget.EmptyView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.Padding;
import com.didi.global.loading.app.AbsLoadingAppFragment;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.env.PointType;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;

public class GlobalSugFragment extends AbsLoadingAppFragment implements IAddressView, ISearchViewCallback {
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;

    /* renamed from: a */
    private static final String f9630a = "GlobalSugFragment";

    /* renamed from: c */
    private static final String f9631c = "param";

    /* renamed from: A */
    private EmptyView f9632A = null;

    /* renamed from: B */
    private boolean f9633B = true;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public AddressAdapter.OnItemSelectedListener f9634C = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            RpcPoi rpcPoi2 = rpcPoi;
            RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (GlobalSugFragment.this.f9650r == 1) {
                boolean unused = GlobalSugFragment.this.f9646n = true;
            }
            GlobalSugFragment.this.f9639g.addressParam.addressType = GlobalSugFragment.this.f9650r;
            int i3 = 2;
            int i4 = 3;
            if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (GlobalSugFragment.this.f9650r == 1) {
                    if (GlobalSugFragment.this.f9654v) {
                        i3 = 3;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (GlobalSugFragment.this.f9650r == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                GlobalSugFragment.this.f9643k.getGeocodeResult(GlobalSugFragment.this.f9639g, rpcPoi, getSearchText(), trackParameterForChild, i, i2, GlobalSugFragment.this.f9650r);
                return;
            }
            SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild);
            AddressTrack.trackAddressClick(GlobalSugFragment.this.f9639g, rpcPoi2.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2), trackParameterForChild, GlobalSugFragment.this.f9650r);
            if (GlobalSugFragment.this.f9650r == 3 || GlobalSugFragment.this.f9650r == 4) {
                GlobalSugFragment.this.f9636d.removeCommonWatcher(GlobalSugFragment.this.f9639g.addressParam);
                GlobalSugFragment.this.f9636d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                GlobalSugFragment.this.f9643k.setCommonAddress(GlobalSugFragment.this.f9639g, rpcPoi);
            } else {
                rpcPoi2.base_info.searchId = trackParameterForChild2.search_id;
                Address a = GlobalSugFragment.this.mo44560a(rpcPoi);
                if (!GlobalSugFragment.this.f9654v) {
                    i4 = 2;
                }
                a.operationType = i4;
                if (GlobalSugFragment.this.f9650r == 1) {
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9650r, a);
                    AddressTrack.trackRecItemSelect(i + 1);
                } else if (GlobalSugFragment.this.f9650r == 2) {
                    GlobalSugFragment globalSugFragment2 = GlobalSugFragment.this;
                    globalSugFragment2.setResultBack(globalSugFragment2.f9650r, a);
                } else if (GlobalSugFragment.this.f9650r == 5) {
                    GlobalSugFragment.this.f9636d.removeCommonWatcher(GlobalSugFragment.this.f9639g.addressParam);
                    GlobalSugFragment.this.f9636d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                    GlobalSugFragment globalSugFragment3 = GlobalSugFragment.this;
                    globalSugFragment3.setResultBack(globalSugFragment3.f9650r, a);
                    AddressTrack.trackAddAddressItemClick();
                } else if (GlobalSugFragment.this.f9650r == 6) {
                    GlobalSugFragment globalSugFragment4 = GlobalSugFragment.this;
                    globalSugFragment4.setResultBack(globalSugFragment4.f9650r, a);
                }
            }
            GlobalSugFragment.this.f9643k.recordClickPoi(GlobalSugFragment.this.f9639g, rpcPoi2.base_info);
        }

        private String getSearchText() {
            if (GlobalSugFragment.this.f9650r == 1) {
                return GlobalSugFragment.this.f9636d.getStartEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f9650r == 2) {
                return GlobalSugFragment.this.f9636d.getEndEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f9650r == 3) {
                return GlobalSugFragment.this.f9636d.getCommonEditText().getText().toString();
            }
            return GlobalSugFragment.this.f9650r == 4 ? GlobalSugFragment.this.f9636d.getCommonEditText().getText().toString() : "";
        }
    };

    /* renamed from: b */
    private final int f9635b = 12;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SugSearchView f9636d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugListViewContainer f9637e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ISugControlCallback f9638f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SugParams f9639g;

    /* renamed from: h */
    private Address f9640h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f9641i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f9642j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f9643k;

    /* renamed from: l */
    private Handler f9644l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f9645m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f9646n = true;

    /* renamed from: o */
    private boolean f9647o;

    /* renamed from: p */
    private boolean f9648p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f9649q = 2;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f9650r = -1;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SelectAddressByDraggedDelegate f9651s;

    /* renamed from: t */
    private SoftKeyboardDelegate f9652t;

    /* renamed from: u */
    private boolean f9653u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f9654v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f9655w = false;

    /* renamed from: x */
    private View.OnClickListener f9656x = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (!GlobalSugFragment.this.f9651s.canSelectAddressByDragged()) {
                Address b = GlobalSugFragment.this.m8394h();
                b.operationType = 1;
                if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f9639g.fromType) || CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f9639g.fromType)) {
                    GlobalSugFragment.this.setResultBack(1, b);
                    return;
                }
                GlobalSugFragment.this.m8409p();
                GlobalSugFragment.this.f9637e.scrollToTop();
                GlobalSugFragment.this.m8367a(2, "", false);
            } else if (!CommonUtils.isFromHomePage(GlobalSugFragment.this.f9639g.fromType) || GlobalSugFragment.this.f9650r != 1) {
                Address address = null;
                if (GlobalSugFragment.this.f9650r == 1) {
                    address = GlobalSugFragment.this.f9651s.getStartAddressByDragged();
                    GlobalSugFragment.this.f9636d.addWatcherForStart();
                } else if (GlobalSugFragment.this.f9650r == 2) {
                    address = GlobalSugFragment.this.f9651s.getEndAddressByDragged();
                    GlobalSugFragment.this.f9636d.addEndTextWatcher();
                }
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9650r, address);
                    if (GlobalSugFragment.this.f9650r == 2) {
                        AddressTrack.trackSelectDestinationInMapConfirm(GlobalSugFragment.this.f9639g.addressParam, address, GlobalSugFragment.this.f9655w, true);
                    }
                }
            } else {
                GlobalSugFragment.this.m8409p();
                GlobalSugFragment.this.f9637e.scrollToTop();
                GlobalSugFragment.this.m8367a(2, "", false);
            }
        }
    };

    /* renamed from: y */
    private IPoiChangeListener f9657y = new IPoiChangeListener() {
        public void onPinLoading(double d, double d2) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.showLoading();
                GlobalSugFragment.this.f9637e.setConfirmBtnEnabled(false);
                Address address = new Address();
                address.latitude = d;
                address.longitude = d2;
                address.displayName = GlobalSugFragment.this.getString(R.string.global_sug_to_departure);
                address.operationType = 1;
                GlobalSugFragment.this.f9651s.onPinLoading(address);
                if (GlobalSugFragment.this.f9649q == 1) {
                    boolean unused = GlobalSugFragment.this.f9646n = false;
                    boolean unused2 = GlobalSugFragment.this.m8376a(address);
                }
            }
        }

        public void onPinPoiChanged(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f9637e.setConfirmBtnEnabled(true);
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment.this.f9651s.onPinPoiChanged(address);
                    if (GlobalSugFragment.this.f9649q == 1) {
                        boolean unused = GlobalSugFragment.this.f9646n = false;
                        boolean unused2 = GlobalSugFragment.this.m8376a(address);
                    } else if (GlobalSugFragment.this.f9649q == 2) {
                        Address unused3 = GlobalSugFragment.this.f9641i = address;
                    }
                }
            }
        }

        public void onPinFetchPoiFailed(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f9637e.setConfirmBtnEnabled(true);
                if (address != null) {
                    GlobalSugFragment.this.f9651s.onPinFetchPoiFailed(address);
                    address.operationType = 1;
                    if (GlobalSugFragment.this.f9649q == 1) {
                        boolean unused = GlobalSugFragment.this.f9646n = false;
                        boolean unused2 = GlobalSugFragment.this.m8376a(address);
                    } else if (GlobalSugFragment.this.f9649q == 2) {
                        Address unused3 = GlobalSugFragment.this.f9641i = address;
                    }
                }
            }
        }
    };

    /* renamed from: z */
    private FrameLayout f9658z = null;

    public void onClearClick(int i) {
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

    public static GlobalSugFragment getInstance(SugParams sugParams) {
        GlobalSugFragment globalSugFragment = new GlobalSugFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("param", sugParams);
        globalSugFragment.setArguments(bundle);
        return globalSugFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null) {
            this.f9639g = (SugParams) getArguments().getSerializable("param");
            AddressTrack.trackCheckAddressParam(activity.getApplicationContext(), this.f9639g.addressParam, this.f9639g.fromType);
            CheckParamUtil.rescueAddressParam(activity.getApplicationContext(), "GlobalSugFragment onAttach()", this.f9639g.addressParam);
            setCurrAddressType(this.f9639g.addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f9642j;
        if (globalSugCallback != null) {
            SugParams sugParams = this.f9639g;
            globalSugCallback.onAttach((sugParams == null || sugParams.addressParam == null) ? Integer.MIN_VALUE : this.f9639g.addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m8364a();
    }

    /* renamed from: a */
    private void m8364a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, this.f9639g.usrType);
        this.f9643k = new AddressPresenter(getActivity(), this);
        this.f9647o = true;
        this.f9648p = false;
        ApolloUtil.initSugSearchInternalTime();
        this.f9651s = new SelectAddressByDraggedDelegate(this.f9639g.addressParam, this.f9639g.fromType);
        this.f9652t = new SoftKeyboardDelegate(getActivity(), this.f9639g.addressParam, this.f9639g.fromType);
        setCurrAddressType(this.f9639g.addressParam.addressType);
        this.f9644l = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    GlobalSugFragment.this.m8367a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f9650r = i;
        SelectAddressByDraggedDelegate selectAddressByDraggedDelegate = this.f9651s;
        if (selectAddressByDraggedDelegate != null) {
            selectAddressByDraggedDelegate.setCurrAddressType(i);
        }
    }

    public void setSearchViewType(int i) {
        this.f9649q = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        int i3;
        Activity activity = getActivity();
        if (activity != null) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(activity, R.animator.old_poi_one_address_animate_exit);
            if (!z && loadAnimator != null && ((i3 = this.f9650r) == 1 || i3 == 2 || i3 == 6)) {
                return loadAnimator;
            }
        }
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.old_layout_sug_fragment, viewGroup, false);
        m8368a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m8368a(View view) {
        m8381b(view.findViewById(R.id.sug_close_btn));
        this.f9636d = (SugSearchView) view.findViewById(R.id.search_view);
        this.f9637e = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f9658z = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f9632A = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f9651s.setSugSearchView(this.f9636d);
        this.f9652t.hideOrShowSoftKeyboard(this.f9636d);
        this.f9652t.onCreateView();
        m8384c();
        m8380b();
        m8386d();
        m8388e();
    }

    /* renamed from: b */
    private void m8380b() {
        if (this.f9636d != null) {
            if (!CommonUtils.isFromSetting(this.f9639g.fromType) && !CommonUtils.isFromRouteEditor(this.f9639g.fromType)) {
                this.f9636d.addStatusBarHeightView();
            }
            this.f9636d.setSearchViewCallback(this);
            this.f9636d.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.getView());
                    if (GlobalSugFragment.this.f9642j != null) {
                        GlobalSugFragment.this.f9642j.onEnterWayPoint(GlobalSugFragment.this.m8394h(), GlobalSugFragment.this.f9641i);
                    }
                }
            });
            Address startPoiFromCache = this.f9643k.getStartPoiFromCache(this.f9639g.addressParam.targetAddress);
            if (startPoiFromCache != null && !TextUtils.isEmpty(startPoiFromCache.hideAddress)) {
                SystemUtils.log(3, f9630a, "set start poi info from cache --> Address startPoi:" + startPoiFromCache.toString(), (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 239);
                this.f9639g.addressParam.targetAddress = startPoiFromCache;
            }
            if (CommonUtils.isFromHomePage(this.f9639g.fromType)) {
                String string = getResources().getString(R.string.global_sug_current_location);
                this.f9639g.addressParam.targetAddress.address = string;
                this.f9639g.addressParam.targetAddress.displayName = string;
                this.f9639g.addressParam.targetAddress.fullName = string;
                this.f9643k.cacheStartPoiInfo(this.f9639g.addressParam.targetAddress);
            }
            this.f9636d.initSugSearchView(this.f9639g);
            if (CommonUtils.isFromHomePage(this.f9639g.fromType)) {
                m8418t();
            }
            this.f9636d.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    GlobalSugFragment.this.m8367a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(this.f9639g.fromType) || CommonUtils.isFromGetOnPage(this.f9639g.fromType)) && this.f9639g.addressParam.addressType == 1) {
                m8416s();
            }
            storeStartAddress(this.f9639g.addressParam);
            m8370a(this.f9639g);
            this.f9636d.setListener(this.f9639g);
            this.f9636d.makeStartTextFocusedWhenIsRed();
            this.f9636d.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f9639g.fromType)) {
                        if (GlobalSugFragment.this.f9639g.addressParam.addressType == 1 && GlobalSugFragment.this.f9636d.isStartTextNeedScrollToBottomWhenFocused) {
                            GlobalSugFragment.this.m8404m();
                        }
                    } else if (CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f9639g.fromType) && GlobalSugFragment.this.f9639g.addressParam.addressType == 1) {
                        GlobalSugFragment.this.m8416s();
                        GlobalSugFragment.this.f9637e.scrollToTop();
                        GlobalSugFragment.this.f9636d.addWatcherForStart();
                    }
                }
            });
            this.f9636d.postDelayed(new Runnable() {
                public void run() {
                    if (GlobalSugFragment.this.f9637e != null) {
                        GlobalSugFragment.this.f9637e.setTopPadding(GlobalSugFragment.this.f9636d.getMeasuredHeight());
                    }
                }
            }, 200);
        }
    }

    /* renamed from: a */
    private void m8370a(SugParams sugParams) {
        EditTextErasable endEditText;
        if ((sugParams.fromType != FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR) && sugParams.addressParam.addressType == 2) {
            m8409p();
            if (sugParams.fromType == FromType.HOME && (endEditText = this.f9636d.getEndEditText()) != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (sugParams.fromType == FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || sugParams.addressParam.addressType != 1) {
            m8406n();
            EditTextErasable commonEditText = this.f9636d.getCommonEditText();
            if (commonEditText != null) {
                commonEditText.setFocusable(true);
                commonEditText.sendAccessibilityEvent(128);
            }
        } else {
            m8407o();
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m8376a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f9650r;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m8376a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 338);
        this.f9640h = address;
        if (address == null) {
            return false;
        }
        this.f9639g.addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m8384c() {
        this.f9637e.setOperCallback(new ISugMapCtrlCallback() {
            private boolean lastShow = false;

            public void onResetBtnClick() {
                if (GlobalSugFragment.this.f9638f != null) {
                    GlobalSugFragment.this.f9638f.onResetBtnClick();
                }
            }

            public void onDeparturePinShow(boolean z, Padding padding) {
                PointType pointType;
                if (GlobalSugFragment.this.f9650r == 1) {
                    pointType = PointType.START;
                    AddressTrack.isInSelectStart = z;
                    if (GlobalSugFragment.this.f9638f != null) {
                        GlobalSugFragment.this.f9638f.onDeparturePinShow(z, GlobalSugFragment.this.f9650r, GlobalSugFragment.this.m8394h(), padding);
                    }
                } else if (GlobalSugFragment.this.f9650r == 2) {
                    pointType = PointType.END;
                    AddressTrack.isInSelectDestination = z;
                    if (GlobalSugFragment.this.f9638f != null) {
                        GlobalSugFragment.this.f9638f.onDeparturePinShow(z, GlobalSugFragment.this.f9650r, GlobalSugFragment.this.m8396i(), padding);
                    }
                } else {
                    pointType = PointType.OTHER;
                }
                PaxEnvironment.getInstance().setPointType(pointType);
                if (z && this.lastShow != z) {
                    this.lastShow = z;
                    if (!CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f9639g.fromType)) {
                        GlobalSugFragment.this.m8414r();
                    }
                }
            }
        });
        this.f9637e.setSugContainerOpCallback(new ISugContainerOpCallback() {
            public void hideInputWindow() {
                if (!GlobalSugFragment.this.isSugFragmentRemoved() && GlobalSugFragment.this.f9636d != null) {
                    GlobalSugFragment.this.f9636d.removeWatcherForStart();
                    GlobalSugFragment.this.f9636d.setStartText(GlobalSugFragment.this.f9639g);
                    ViewUtils.hideInputMethodForEditText(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f9636d.getStartEditText());
                }
            }

            public Address getTargetAddress() {
                if (GlobalSugFragment.this.f9639g == null || GlobalSugFragment.this.f9639g.addressParam == null) {
                    return null;
                }
                return GlobalSugFragment.this.f9639g.addressParam.targetAddress;
            }

            private void onSugContainerScrollToTop() {
                if (GlobalSugFragment.this.f9650r == 1) {
                    GlobalSugFragment.this.m8416s();
                    boolean unused = GlobalSugFragment.this.f9645m = true;
                    GlobalSugFragment.this.f9636d.getStartEditText().clearFocus();
                    GlobalSugFragment.this.f9636d.getStartEditText().setCursorVisible(true);
                    GlobalSugFragment.this.m8407o();
                    GlobalSugFragment.this.f9636d.addWatcherForStart();
                    boolean unused2 = GlobalSugFragment.this.f9645m = false;
                    GlobalSugFragment.this.m8411q();
                }
            }

            public void onSugContainerScrollChanged(int i, int i2, int i3, int i4) {
                if (i2 < -20) {
                    GlobalSugFragment.this.f9636d.getStartEditText().setCursorVisible(false);
                } else if (i2 == 0 && i4 > -100) {
                    onSugContainerScrollToTop();
                }
            }

            public void onScrollToTop() {
                if (GlobalSugFragment.this.f9650r == 1) {
                    GlobalSugFragment.this.f9636d.addWatcherForStart();
                } else if (GlobalSugFragment.this.f9650r == 2) {
                    GlobalSugFragment.this.f9636d.addEndTextWatcher();
                }
            }

            public void onScrollToBottom() {
                if (GlobalSugFragment.this.f9650r == 1) {
                    GlobalSugFragment.this.f9636d.removeWatcherForStart();
                } else if (GlobalSugFragment.this.f9650r == 2) {
                    GlobalSugFragment.this.f9636d.removeEndTextWatcher();
                }
            }
        });
        this.f9637e.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.log(3, GlobalSugFragment.f9630a, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + GlobalSugFragment.this.f9649q + ", mCurrAddressType: " + GlobalSugFragment.this.f9650r, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment$9", 503);
                if (GlobalSugFragment.this.f9650r == 1) {
                    GlobalSugFragment.this.f9636d.removeWatcherForStart();
                } else if (GlobalSugFragment.this.f9650r == 2) {
                    GlobalSugFragment.this.f9636d.removeEndTextWatcher();
                    AddressTrack.trackSelectDestinationInMap(GlobalSugFragment.this.f9639g.addressParam, GlobalSugFragment.this.f9636d.getEndEditText().getText().toString(), GlobalSugFragment.this.f9655w, true);
                }
            }
        });
        this.f9637e.setConfirmBtnClickListener(this.f9656x);
        if (this.f9651s.canSelectAddressByDragged()) {
            this.f9637e.addPoiListener(this.f9657y);
        }
        if (CommonUtils.isFromHomePage(this.f9639g.fromType)) {
            if (this.f9639g.addressParam.addressType != 1 && this.f9639g.addressParam.addressType == 2) {
                m8409p();
            }
        } else if (CommonUtils.isFromConfirmPage(this.f9639g.fromType)) {
            if (this.f9639g.addressParam.addressType != 1 && this.f9639g.addressParam.addressType == 2) {
                m8409p();
            }
        } else if (CommonUtils.isFromGetOnPage(this.f9639g.fromType)) {
            if (this.f9639g.addressParam.addressType == 1) {
                m8407o();
            } else if (this.f9639g.addressParam.addressType == 2) {
                m8409p();
            }
        } else if (CommonUtils.isFromRouteEditor(this.f9639g.fromType)) {
            int i = this.f9639g.addressParam.addressType;
        }
    }

    /* renamed from: d */
    private void m8386d() {
        this.f9658z.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f9632A.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f9632A.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
    }

    /* renamed from: b */
    private void m8381b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(GlobalSugFragment.this.f9650r == 3 && GlobalSugFragment.this.f9650r == 4)) {
                    AddressTrack.trackCloseButtonClick(GlobalSugFragment.this.f9639g, GlobalSugFragment.this.m8398j());
                }
                if (GlobalSugFragment.this.f9642j != null) {
                    z = GlobalSugFragment.this.f9642j.onCloseButtonIntercept();
                }
                if (!z) {
                    GlobalSugFragment.this.closeFragment();
                    if (GlobalSugFragment.this.f9642j != null) {
                        GlobalSugFragment.this.f9642j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m8388e() {
        this.f9637e.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(GlobalSugFragment.this.f9639g.addressParam);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address homeAddress = GlobalSugFragment.this.f9637e.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(GlobalSugFragment.this.f9639g, homeAddress, GlobalSugFragment.this.f9650r);
                    homeAddress.operationType = 4;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9650r, homeAddress);
                    return;
                }
                GlobalSugFragment.this.m8365a(3, GlobalSugFragment.this.f9639g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly();
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address companyAddress = GlobalSugFragment.this.f9637e.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(GlobalSugFragment.this.f9639g, companyAddress, GlobalSugFragment.this.f9650r);
                    companyAddress.operationType = 5;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9650r, companyAddress);
                    return;
                }
                GlobalSugFragment.this.m8365a(4, GlobalSugFragment.this.f9639g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(GlobalSugFragment.this.f9637e.getHomeAddress()), CommonUtils.isValidLocation(GlobalSugFragment.this.f9637e.getCompanyAddress()));
                Intent intent = CommonAddressActivity.getIntent(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f9639g.clone());
                intent.putExtra(CommonAddressActivity.BUNDLE_TYPE, 2);
                GlobalSugFragment.this.startActivityForResult(intent, 1);
            }
        });
    }

    public void setSugControlCallback(ISugControlCallback iSugControlCallback) {
        this.f9638f = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f9633B = z;
    }

    public ISugViewController getSugViewController() {
        return this.f9637e;
    }

    public String getStartAddressText() {
        return this.f9636d.getStartEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8367a(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, f9630a, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 746);
            SugParams clone = this.f9639g.clone();
            clone.addressParam.addressType = i;
            if (TextUtil.isEmpty(str) || getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f9643k.processDataRequire(clone, "", z, i);
                return;
            }
            if (clone.addressParam.addressType == 2) {
                this.f9655w = true;
            } else if (clone.addressParam.addressType == 1) {
                this.f9654v = true;
            }
            this.f9643k.processDataRequire(clone, str, z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8365a(int i, SugParams sugParams) {
        sugParams.addressParam.addressType = i;
        if (sugParams.fromType == FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.HOME || sugParams.fromType == FromType.CONFIRM || CommonUtils.isGetOnFromType(sugParams.fromType)) {
            this.f9645m = true;
            try {
                if (getActivity().findViewById(getId()) != null) {
                    DidiAddressApiFactory.createDidiAddress(getActivity()).selectAddress(getActivity(), getId(), sugParams, (GlobalSugCallback) new GlobalSugCallback() {
                        public void onAttach(int i) {
                        }

                        public void onCloseButtonClick() {
                            resetFocus();
                        }

                        private void resetFocus() {
                            if (GlobalSugFragment.this.f9650r == 1) {
                                GlobalSugFragment.this.m8407o();
                            } else if (GlobalSugFragment.this.f9650r == 2) {
                                GlobalSugFragment.this.m8409p();
                            }
                            boolean unused = GlobalSugFragment.this.f9645m = false;
                        }

                        public void setResult(AddressResult addressResult) {
                            if (addressResult.type == 3) {
                                GlobalSugFragment.this.f9637e.setHomeAddress(addressResult.home);
                            } else if (addressResult.type == 4) {
                                GlobalSugFragment.this.f9637e.setCompanyAddress(addressResult.company);
                            }
                            resetFocus();
                        }

                        public void onDetach(int i) {
                            if (i == 3 || i == 4) {
                                resetFocus();
                            }
                        }
                    });
                    getFragmentManager().executePendingTransactions();
                }
            } catch (AddressException e) {
                SystemUtils.log(6, f9630a, "addCommonAddressSelectFragment() " + e.getMessage(), (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 816);
            }
        }
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f9652t.onDestroyView();
        this.f9648p = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f9637e;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        AddressTrack.isInSelectDestination = false;
        AddressTrack.isInSelectStart = false;
        if (!this.f9647o) {
            return true;
        }
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager.getBackStackEntryCount() <= 1) {
            return false;
        }
        fragmentManager.popBackStackImmediate();
        return true;
    }

    public boolean closeFragment() {
        m8391g();
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager != null) {
            try {
                if (fragmentManager.getBackStackEntryCount() > 1) {
                    fragmentManager.popBackStackImmediate();
                    return true;
                }
                if (this.f9637e != null) {
                    this.f9637e.removePoiListener(this.f9657y);
                }
                fragmentManager.popBackStackImmediate();
                return false;
            } catch (Exception e) {
                LogUtils.m8354e("sfs", "GlobalSugFragment closeFragment() err msg: " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AddressTrack.onViewCreated(this.f9639g, this.f9636d, this.f9637e);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        if (AddressPresenter.isQueryEverEdited() && !TextUtils.isEmpty(this.f9636d.getEndEditText().getText())) {
            this.f9655w = true;
        }
        if (CommonUtils.isFromGetOnPage(this.f9639g.fromType)) {
            m8367a(this.f9639g.addressParam.addressType, "", false);
        } else {
            m8367a(this.f9639g.addressParam.addressType, "", false);
        }
        if ((CommonUtils.isFromGetOnPage(this.f9639g.fromType) || this.f9639g.addressParam.addressType != 1) && (CommonUtils.isFromRouteEditor(this.f9639g.fromType) || this.f9639g.addressParam.addressType != 2)) {
            this.f9637e.showSelectPoiFooterView(false);
        } else {
            this.f9637e.showSelectPoiFooterView(true);
        }
        if (CommonUtils.isFromHomePage(this.f9639g.fromType) && this.f9639g.addressParam.addressType == 2) {
            m8389f();
        }
    }

    /* renamed from: f */
    private void m8389f() {
        if (this.f9643k != null && CommonUtils.isValidLocation(this.f9639g.addressParam)) {
            this.f9643k.fetchStartPoiInfo(this.f9639g);
        }
    }

    /* renamed from: g */
    private void m8391g() {
        AddressPresenter addressPresenter = this.f9643k;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f9643k.stopRevertGeo();
        }
    }

    public void onResume() {
        super.onResume();
        AddressPresenter addressPresenter = this.f9643k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f9643k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f9636d;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44561a(GlobalSugCallback globalSugCallback) {
        this.f9642j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f9642j;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach(this.f9639g.addressParam != null ? this.f9639g.addressParam.addressType : Integer.MIN_VALUE);
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
        this.f9632A.setVisibility(8);
        this.f9637e.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo44560a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList) {
        SugListViewContainer sugListViewContainer = this.f9637e;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f9637e.post(new Runnable() {
                public void run() {
                    AddressAdapter addressAdapter = new AddressAdapter(true);
                    addressAdapter.setOnItemSelectedListener(GlobalSugFragment.this.f9634C);
                    addressAdapter.updateAddress(arrayList, trackParameterForChild, GlobalSugFragment.this.f9650r);
                    GlobalSugFragment.this.f9637e.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (this.f9639g.addressParam.addressType == 3 || this.f9639g.addressParam.addressType == 4 || this.f9639g.addressParam.addressType == 5 || this.f9639g.addressParam.addressType == 6) {
            z = false;
        }
        this.f9637e.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9637e.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9637e.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        int i = 8;
        this.f9637e.findViewById(R.id.lv).setVisibility(8);
        this.f9632A.setVisibility(0);
        this.f9632A.showError(str);
        View findViewById = this.f9632A.findViewById(R.id.image_error);
        if (!TextUtils.isEmpty(str)) {
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    public void showNoSearchView() {
        int i;
        hideLoading();
        if (!this.f9651s.canSelectAddressByDragged() || !((i = this.f9650r) == 2 || i == 1)) {
            this.f9637e.findViewById(R.id.lv).setVisibility(8);
        } else {
            this.f9637e.onlyShowSelectPoiFooterView();
        }
        this.f9632A.setVisibility(0);
        this.f9632A.showError(getResources().getText(R.string.global_sug_no_result));
        this.f9632A.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1191);
            if (!m8373a(i, address)) {
                AddressResult addressResult = new AddressResult();
                addressResult.fromType = this.f9639g.fromType;
                addressResult.type = i;
                addressResult.isStartNeedNearRoad = this.f9646n;
                if (i == 4) {
                    addressResult.company = address;
                } else if (i == 3) {
                    addressResult.home = address;
                } else if (i == 1) {
                    if (CommonUtils.isFromRouteEditor(this.f9639g.fromType)) {
                        addressResult.common = address;
                    } else if (this.f9641i != null) {
                        addressResult.start = address;
                        addressResult.end = this.f9641i;
                    } else {
                        m8409p();
                        m8376a(address);
                        this.f9636d.getStartEditText().setText(address.displayName);
                        this.f9636d.getEndEditText().setText("");
                        addressResult.start = address;
                        return;
                    }
                } else if (i == 2) {
                    if (CommonUtils.isFromRouteEditor(this.f9639g.fromType)) {
                        addressResult.common = address;
                    } else if (CommonUtils.isValidLocation(this.f9640h)) {
                        addressResult.start = this.f9640h;
                        addressResult.end = address;
                    } else {
                        m8407o();
                        this.f9641i = address;
                        this.f9636d.getEndEditText().setText(address.displayName);
                        return;
                    }
                } else if (i == 5) {
                    addressResult.common = address;
                } else if (i == 6) {
                    addressResult.common = address;
                }
                m8369a(addressResult);
                return;
            }
            return;
        }
        throw new RuntimeException("setResultBack with null address, type:" + i);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m8394h() {
        Address address = this.f9640h;
        return address == null ? this.f9639g.addressParam.targetAddress : address;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public Address m8396i() {
        Address address = this.f9641i;
        return address == null ? this.f9639g.addressParam.targetAddress : address;
    }

    /* renamed from: a */
    private boolean m8373a(int i, Address address) {
        if (!CommonUtils.isFromConfirmPage(this.f9639g.fromType) && !CommonUtils.isFromGetOnPage(this.f9639g.fromType)) {
            return false;
        }
        AddressResult addressResult = new AddressResult();
        addressResult.fromType = this.f9639g.fromType;
        addressResult.type = i;
        if (i == 1) {
            this.f9636d.getStartEditText().setText(address.displayName);
            addressResult.start = address;
            addressResult.isStartNeedNearRoad = this.f9646n;
            this.f9636d.addWatcherForStart();
        } else if (i == 2) {
            this.f9636d.removeEndTextWatcher();
            this.f9636d.getEndEditText().setText(address.displayName);
            addressResult.end = address;
            this.f9636d.addEndTextWatcher();
        } else {
            this.f9636d.getCommonEditText().setText(address.displayName);
            if (i == 3) {
                addressResult.home = address;
            } else if (i == 4) {
                addressResult.company = address;
            } else {
                throw new RuntimeException("Unknown address type with CONFIRM type");
            }
        }
        m8369a(addressResult);
        return true;
    }

    /* renamed from: a */
    private void m8369a(AddressResult addressResult) {
        if (this.f9633B) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f9642j;
        if (globalSugCallback != null) {
            globalSugCallback.setResult(addressResult);
        }
    }

    public void toLogin() {
        if (!isSugFragmentRemoved() && this.f9639g.addressParam != null && this.f9639g.managerCallback != null && this.f9639g.addressParam.currentAddress != null) {
            this.f9639g.managerCallback.toLogin(getActivity(), this.f9639g.addressParam.currentAddress.latitude, this.f9639g.addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f9637e.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        if (CommonUtils.isFromHomePage(this.f9639g.fromType)) {
            int i = this.f9650r;
            if (i == 1 || i == 2) {
                this.f9637e.showSelectPoiFooterView(true);
            } else {
                this.f9637e.showSelectPoiFooterView(false);
            }
        } else if (CommonUtils.isFromGetOnPage(this.f9639g.fromType) || CommonUtils.isFromRouteEditor(this.f9639g.fromType)) {
            this.f9637e.showSelectPoiFooterView(false);
        } else if (CommonUtils.isFromConfirmPage(this.f9639g.fromType)) {
            int i2 = this.f9650r;
            if (i2 == 1 || i2 == 2) {
                this.f9637e.showSelectPoiFooterView(true);
            } else {
                this.f9637e.showSelectPoiFooterView(false);
            }
        } else {
            this.f9637e.showSelectPoiFooterView(z);
        }
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        this.f9637e.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f9636d != null && !this.f9645m && !this.f9648p && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1364);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                String str = "";
                if (i == 1) {
                    m8391g();
                    m8399k();
                    if (this.f9636d.isStartTextNeedScrollToBottomWhenFocused) {
                        m8404m();
                    }
                    if (CommonUtils.isFromHomePage(this.f9639g.fromType)) {
                        m8418t();
                    }
                    m8367a(1, str, false);
                    this.f9637e.scrollToTop();
                    AddressTrack.trackStartPointViewClick(this.f9639g.addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(this.f9639g.fromType, this.f9639g.addressParam));
                    this.f9636d.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f9636d.getEndEditText().getText();
                    if (text != null) {
                        str = text.toString();
                    }
                    m8367a(2, str, false);
                    m8409p();
                    this.f9637e.scrollToTop();
                }
                this.f9636d.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f9640h != null) {
                    this.f9636d.getStartEditText().setText(this.f9640h.displayName);
                    if (this.f9640h.displayName != null && this.f9640h.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
                        this.f9636d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                        m8389f();
                    } else if (CommonUtils.isFromHomePage(this.f9639g.fromType)) {
                        m8418t();
                    } else {
                        this.f9636d.getStartEditText().setTextColor(-16777216);
                    }
                }
            } else if (i == 2 && this.f9641i != null) {
                this.f9636d.getEndEditText().setText(this.f9641i.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m8398j() {
        return AddressTrack.getCurrPage(this.f9650r, this.f9636d, this.f9637e);
    }

    /* renamed from: k */
    private void m8399k() {
        this.f9636d.getEndEditText().setText("");
    }

    /* renamed from: l */
    private void m8401l() {
        if (this.f9639g.addressParam != null && this.f9639g.addressParam.targetAddress != null) {
            this.f9636d.getStartEditText().setText(this.f9639g.addressParam.targetAddress.displayName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m8404m() {
        if (!this.f9648p) {
            this.f9637e.addPoiListener(this.f9657y);
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f9636d.getStartEditText());
            this.f9637e.scrollToBottom();
        }
    }

    /* renamed from: n */
    private void m8406n() {
        if (!this.f9648p) {
            this.f9636d.getCommonEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m8407o() {
        if (!this.f9648p) {
            this.f9636d.getStartEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m8409p() {
        AddressTrack.isInSelectDestination = false;
        if (!this.f9648p) {
            this.f9636d.getEndEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m8411q() {
        Editable text = this.f9636d.getStartEditText().getText();
        if (!TextUtils.isEmpty(text)) {
            Selection.setSelection(text, text.length(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m8414r() {
        this.f9636d.getStartEditText().setSelection(0);
    }

    public void onClick(int i) {
        if (this.f9636d != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, f9630a, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1469);
                m8391g();
                m8416s();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9636d.getStartEditText(), true ^ this.f9648p);
                this.f9637e.scrollToTop();
                this.f9636d.addWatcherForStart();
                AddressTrack.isInSelectStart = false;
                if (this.f9636d.getStartEditText() != null && TextUtils.isEmpty(this.f9636d.getStartEditText().getText())) {
                    m8367a(i, "", false);
                }
            } else if (i == 2) {
                SystemUtils.log(3, f9630a, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1481);
                m8391g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9636d.getEndEditText(), true ^ this.f9648p);
                this.f9637e.scrollToTop();
                this.f9636d.addEndTextWatcher();
                AddressTrack.isInSelectDestination = false;
                if (this.f9636d.getEndEditText() != null && TextUtils.isEmpty(this.f9636d.getEndEditText().getText())) {
                    m8367a(i, "", false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m8416s() {
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(this.f9639g.addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText())) {
            this.f9636d.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f9636d != null) {
            setSearchViewType(i);
            if (i == 2 && this.f9653u) {
                this.f9653u = false;
            } else if (view.hasFocus()) {
                m8366a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m8366a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f9644l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f9644l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m8377a(addressParam);
    }

    public void setStartPoiInfo(SugParams sugParams) {
        this.f9636d.setStartText(sugParams);
    }

    /* renamed from: a */
    private boolean m8377a(AddressParam addressParam) {
        if (addressParam == null || this.f9636d == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f9636d.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f9636d.getEndEditText().hasFocus();
        }
        return this.f9636d.getCommonEditText().hasFocus();
    }

    public View getFallbackView() {
        return this.f9658z;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f9650r, convertToAddress);
        }
    }

    /* renamed from: t */
    private void m8418t() {
        this.f9636d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
        this.f9636d.getStartEditText().setHighlightColor(getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
    }
}
