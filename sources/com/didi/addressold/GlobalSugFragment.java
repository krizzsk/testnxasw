package com.didi.addressold;

import android.animation.Animator;
import android.animation.AnimatorInflater;
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
import android.widget.FrameLayout;
import com.didi.address.AddressException;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.GlobalSugCallback;
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
import com.didi.addressold.util.ApolloUtil;
import com.didi.addressold.util.CheckParamUtil;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.util.LogUtils;
import com.didi.addressold.util.ViewUtils;
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
    private static final String f9548a = "GlobalSugFragment";

    /* renamed from: c */
    private static final String f9549c = "param";

    /* renamed from: A */
    private FrameLayout f9550A = null;

    /* renamed from: B */
    private EmptyView f9551B = null;

    /* renamed from: C */
    private boolean f9552C = true;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public AddressAdapter.OnItemSelectedListener f9553D = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            RpcPoi rpcPoi2 = rpcPoi;
            RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (GlobalSugFragment.this.f9570s == 1) {
                boolean unused = GlobalSugFragment.this.f9565n = true;
            }
            GlobalSugFragment.this.f9558g.addressParam.addressType = GlobalSugFragment.this.f9570s;
            int i3 = 2;
            int i4 = 3;
            if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (GlobalSugFragment.this.f9570s == 1) {
                    if (GlobalSugFragment.this.f9574w) {
                        i3 = 3;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (GlobalSugFragment.this.f9570s == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                GlobalSugFragment.this.f9562k.getGeocodeResult(GlobalSugFragment.this.f9558g, rpcPoi, getSearchText(), trackParameterForChild, i, i2, GlobalSugFragment.this.f9570s);
                return;
            }
            SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild);
            AddressTrack.trackAddressClick(GlobalSugFragment.this.f9558g, rpcPoi2.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2), trackParameterForChild, GlobalSugFragment.this.f9570s);
            if (GlobalSugFragment.this.f9570s == 3 || GlobalSugFragment.this.f9570s == 4) {
                GlobalSugFragment.this.f9555d.removeCommonWatcher(GlobalSugFragment.this.f9558g.addressParam);
                GlobalSugFragment.this.f9555d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                GlobalSugFragment.this.f9562k.setCommonAddress(GlobalSugFragment.this.f9558g, rpcPoi);
            } else {
                rpcPoi2.base_info.searchId = trackParameterForChild2.search_id;
                Address a = GlobalSugFragment.this.mo44383a(rpcPoi);
                if (!GlobalSugFragment.this.f9574w) {
                    i4 = 2;
                }
                a.operationType = i4;
                if (GlobalSugFragment.this.f9570s == 1) {
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9570s, a);
                    AddressTrack.trackRecItemSelect(i + 1);
                } else if (GlobalSugFragment.this.f9570s == 2) {
                    GlobalSugFragment globalSugFragment2 = GlobalSugFragment.this;
                    globalSugFragment2.setResultBack(globalSugFragment2.f9570s, a);
                } else if (GlobalSugFragment.this.f9570s == 5) {
                    GlobalSugFragment.this.f9555d.removeCommonWatcher(GlobalSugFragment.this.f9558g.addressParam);
                    GlobalSugFragment.this.f9555d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                    GlobalSugFragment globalSugFragment3 = GlobalSugFragment.this;
                    globalSugFragment3.setResultBack(globalSugFragment3.f9570s, a);
                    AddressTrack.trackAddAddressItemClick();
                } else if (GlobalSugFragment.this.f9570s == 6) {
                    GlobalSugFragment globalSugFragment4 = GlobalSugFragment.this;
                    globalSugFragment4.setResultBack(globalSugFragment4.f9570s, a);
                }
            }
            GlobalSugFragment.this.f9562k.recordClickPoi(GlobalSugFragment.this.f9558g, rpcPoi2.base_info);
        }

        private String getSearchText() {
            if (GlobalSugFragment.this.f9570s == 1) {
                return GlobalSugFragment.this.f9555d.getStartEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f9570s == 2) {
                return GlobalSugFragment.this.f9555d.getEndEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f9570s == 3) {
                return GlobalSugFragment.this.f9555d.getCommonEditText().getText().toString();
            }
            return GlobalSugFragment.this.f9570s == 4 ? GlobalSugFragment.this.f9555d.getCommonEditText().getText().toString() : "";
        }
    };

    /* renamed from: b */
    private final int f9554b = 12;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SugSearchView f9555d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugListViewContainer f9556e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ISugControlCallback f9557f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SugParams f9558g;

    /* renamed from: h */
    private Address f9559h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f9560i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f9561j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f9562k;

    /* renamed from: l */
    private Handler f9563l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f9564m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f9565n = true;

    /* renamed from: o */
    private boolean f9566o;

    /* renamed from: p */
    private boolean f9567p;

    /* renamed from: q */
    private boolean f9568q = true;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f9569r = 2;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f9570s = -1;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public SelectAddressByDraggedDelegate f9571t;

    /* renamed from: u */
    private SoftKeyboardDelegate f9572u;

    /* renamed from: v */
    private boolean f9573v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f9574w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f9575x = false;

    /* renamed from: y */
    private View.OnClickListener f9576y = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (!GlobalSugFragment.this.f9571t.canSelectAddressByDragged()) {
                Address b = GlobalSugFragment.this.m8285h();
                b.operationType = 1;
                if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f9558g.fromType) || CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f9558g.fromType)) {
                    GlobalSugFragment.this.setResultBack(1, b);
                    return;
                }
                GlobalSugFragment.this.m8298o();
                GlobalSugFragment.this.f9556e.scrollToTop();
                GlobalSugFragment.this.m8258a(2, "", false);
            } else if (!CommonUtils.isFromHomePage(GlobalSugFragment.this.f9558g.fromType) || GlobalSugFragment.this.f9570s != 1) {
                Address address = null;
                if (GlobalSugFragment.this.f9570s == 1) {
                    address = GlobalSugFragment.this.f9571t.getStartAddressByDragged();
                    GlobalSugFragment.this.f9555d.addWatcherForStart();
                    GlobalSugFragment.this.f9556e.setDragEnable(false);
                } else if (GlobalSugFragment.this.f9570s == 2) {
                    address = GlobalSugFragment.this.f9571t.getEndAddressByDragged();
                    GlobalSugFragment.this.f9555d.addEndTextWatcher();
                    GlobalSugFragment.this.f9556e.setDragEnable(false);
                }
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9570s, address);
                    if (GlobalSugFragment.this.f9570s == 2) {
                        AddressTrack.trackSelectDestinationInMapConfirm(GlobalSugFragment.this.f9558g.addressParam, address, GlobalSugFragment.this.f9575x, true);
                    }
                }
            } else {
                GlobalSugFragment.this.m8298o();
                GlobalSugFragment.this.f9556e.scrollToTop();
                GlobalSugFragment.this.m8258a(2, "", false);
            }
        }
    };

    /* renamed from: z */
    private IPoiChangeListener f9577z = new IPoiChangeListener() {
        public void onPinLoading(double d, double d2) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.showLoading();
                GlobalSugFragment.this.f9556e.setConfirmBtnEnabled(false);
                Address address = new Address();
                address.latitude = d;
                address.longitude = d2;
                address.displayName = GlobalSugFragment.this.getString(R.string.global_sug_to_departure);
                address.operationType = 1;
                GlobalSugFragment.this.f9571t.onPinLoading(address);
                if (GlobalSugFragment.this.f9569r == 1) {
                    boolean unused = GlobalSugFragment.this.f9565n = false;
                    boolean unused2 = GlobalSugFragment.this.m8267a(address);
                }
            }
        }

        public void onPinPoiChanged(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f9556e.setConfirmBtnEnabled(true);
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment.this.f9571t.onPinPoiChanged(address);
                    if (GlobalSugFragment.this.f9569r == 1) {
                        boolean unused = GlobalSugFragment.this.f9565n = false;
                        boolean unused2 = GlobalSugFragment.this.m8267a(address);
                    } else if (GlobalSugFragment.this.f9569r == 2) {
                        Address unused3 = GlobalSugFragment.this.f9560i = address;
                    }
                }
            }
        }

        public void onPinFetchPoiFailed(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f9556e.setConfirmBtnEnabled(true);
                if (address != null) {
                    GlobalSugFragment.this.f9571t.onPinFetchPoiFailed(address);
                    address.operationType = 1;
                    if (GlobalSugFragment.this.f9569r == 1) {
                        boolean unused = GlobalSugFragment.this.f9565n = false;
                        boolean unused2 = GlobalSugFragment.this.m8267a(address);
                    } else if (GlobalSugFragment.this.f9569r == 2) {
                        Address unused3 = GlobalSugFragment.this.f9560i = address;
                    }
                }
            }
        }
    };

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
            this.f9558g = (SugParams) getArguments().getSerializable("param");
            AddressTrack.trackCheckAddressParam(activity.getApplicationContext(), this.f9558g.addressParam, this.f9558g.fromType);
            CheckParamUtil.rescueAddressParam(activity.getApplicationContext(), "GlobalSugFragment onAttach()", this.f9558g.addressParam);
            setCurrAddressType(this.f9558g.addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f9561j;
        if (globalSugCallback != null) {
            SugParams sugParams = this.f9558g;
            globalSugCallback.onAttach((sugParams == null || sugParams.addressParam == null) ? Integer.MIN_VALUE : this.f9558g.addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m8255a();
    }

    /* renamed from: a */
    private void m8255a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, this.f9558g.usrType);
        this.f9562k = new AddressPresenter(getActivity(), this);
        this.f9566o = true;
        this.f9567p = false;
        ApolloUtil.initSugSearchInternalTime();
        this.f9571t = new SelectAddressByDraggedDelegate(this.f9558g.addressParam, this.f9558g.fromType);
        this.f9572u = new SoftKeyboardDelegate(getActivity(), this.f9558g.addressParam, this.f9558g.fromType);
        setCurrAddressType(this.f9558g.addressParam.addressType);
        this.f9563l = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    GlobalSugFragment.this.m8258a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f9570s = i;
        SelectAddressByDraggedDelegate selectAddressByDraggedDelegate = this.f9571t;
        if (selectAddressByDraggedDelegate != null) {
            selectAddressByDraggedDelegate.setCurrAddressType(i);
        }
    }

    public void setSearchViewType(int i) {
        this.f9569r = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        int i3;
        Activity activity = getActivity();
        if (activity != null) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(activity, R.animator.old_poi_one_address_animate_exit);
            if (!z && loadAnimator != null && ((i3 = this.f9570s) == 1 || i3 == 2 || i3 == 6)) {
                return loadAnimator;
            }
        }
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.old_layout_sug_fragment, viewGroup, false);
        m8259a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m8259a(View view) {
        m8272b(view.findViewById(R.id.sug_close_btn));
        this.f9555d = (SugSearchView) view.findViewById(R.id.search_view);
        this.f9556e = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f9550A = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f9551B = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f9571t.setSugSearchView(this.f9555d);
        this.f9572u.hideOrShowSoftKeyboard(this.f9555d);
        this.f9572u.onCreateView();
        m8275c();
        m8271b();
        m8277d();
        m8279e();
    }

    /* renamed from: b */
    private void m8271b() {
        if (this.f9555d != null) {
            if (!CommonUtils.isFromSetting(this.f9558g.fromType) && !CommonUtils.isFromRouteEditor(this.f9558g.fromType)) {
                this.f9555d.addStatusBarHeightView();
            }
            this.f9555d.setSearchViewCallback(this);
            this.f9555d.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.getView());
                    if (GlobalSugFragment.this.f9561j != null) {
                        GlobalSugFragment.this.f9561j.onEnterWayPoint(GlobalSugFragment.this.m8285h(), GlobalSugFragment.this.f9560i);
                    }
                }
            });
            Address startPoiFromCache = this.f9562k.getStartPoiFromCache(this.f9558g.addressParam.targetAddress);
            if (startPoiFromCache != null && !TextUtils.isEmpty(startPoiFromCache.hideAddress)) {
                SystemUtils.log(3, f9548a, "set start poi info from cache --> Address startPoi:" + startPoiFromCache.toString(), (Throwable) null, "com.didi.addressold.GlobalSugFragment", 243);
                this.f9558g.addressParam.targetAddress = startPoiFromCache;
            }
            if (!this.f9568q && this.f9558g.fromType == FromType.HOME) {
                String string = getResources().getString(R.string.global_sug_current_location);
                this.f9558g.addressParam.targetAddress.address = string;
                this.f9558g.addressParam.targetAddress.displayName = string;
                this.f9558g.addressParam.targetAddress.fullName = string;
                this.f9562k.cacheStartPoiInfo(this.f9558g.addressParam.targetAddress);
            }
            this.f9555d.initSugSearchView(this.f9558g);
            if (CommonUtils.isFromHomePage(this.f9558g.fromType)) {
                m8307s();
            }
            this.f9555d.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    GlobalSugFragment.this.m8258a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(this.f9558g.fromType) || CommonUtils.isFromGetOnPage(this.f9558g.fromType)) && this.f9558g.addressParam.addressType == 1) {
                m8305r();
            }
            storeStartAddress(this.f9558g.addressParam);
            m8261a(this.f9558g);
            this.f9555d.setListener(this.f9558g);
            this.f9555d.makeStartTextFocusedWhenIsRed();
            this.f9555d.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f9558g.fromType)) {
                        if (GlobalSugFragment.this.f9558g.addressParam.addressType == 1 && GlobalSugFragment.this.f9555d.isStartTextNeedScrollToBottomWhenFocused) {
                            GlobalSugFragment.this.m8292l();
                        }
                    } else if (CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f9558g.fromType) && GlobalSugFragment.this.f9558g.addressParam.addressType == 1) {
                        GlobalSugFragment.this.m8305r();
                        GlobalSugFragment.this.f9556e.scrollToTop();
                        GlobalSugFragment.this.f9555d.addWatcherForStart();
                        GlobalSugFragment.this.f9556e.setDragEnable(false);
                    }
                }
            });
            this.f9555d.postDelayed(new Runnable() {
                public void run() {
                    if (GlobalSugFragment.this.f9556e != null) {
                        GlobalSugFragment.this.f9556e.setTopPadding(GlobalSugFragment.this.f9555d.getMeasuredHeight());
                    }
                }
            }, 200);
        }
    }

    /* renamed from: a */
    private void m8261a(SugParams sugParams) {
        EditTextErasable endEditText;
        if ((sugParams.fromType != FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR) && sugParams.addressParam.addressType == 2) {
            m8298o();
            if (sugParams.fromType == FromType.HOME && (endEditText = this.f9555d.getEndEditText()) != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (sugParams.fromType != FromType.ROUTE_EDITOR && sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR && sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR && sugParams.addressParam.addressType == 1) {
            m8297n();
        } else {
            m8295m();
            EditTextErasable commonEditText = this.f9555d.getCommonEditText();
            if (commonEditText != null) {
                commonEditText.setFocusable(true);
                commonEditText.sendAccessibilityEvent(128);
            }
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m8267a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f9570s;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m8267a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressold.GlobalSugFragment", 347);
        this.f9559h = address;
        if (address == null) {
            return false;
        }
        this.f9558g.addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m8275c() {
        this.f9556e.setOperCallback(new ISugMapCtrlCallback() {
            private boolean lastShow = false;

            public void onResetBtnClick() {
                if (GlobalSugFragment.this.f9557f != null) {
                    GlobalSugFragment.this.f9557f.onResetBtnClick();
                }
            }

            public void onDeparturePinShow(boolean z, Padding padding) {
                if (GlobalSugFragment.this.f9570s == 1) {
                    AddressTrack.isInSelectStart = z;
                    if (GlobalSugFragment.this.f9557f != null) {
                        GlobalSugFragment.this.f9557f.onDeparturePinShow(z, GlobalSugFragment.this.f9570s, GlobalSugFragment.this.m8285h(), padding);
                    }
                } else if (GlobalSugFragment.this.f9570s == 2) {
                    AddressTrack.isInSelectDestination = z;
                    if (GlobalSugFragment.this.f9557f != null) {
                        GlobalSugFragment.this.f9557f.onDeparturePinShow(z, GlobalSugFragment.this.f9570s, GlobalSugFragment.this.m8287i(), padding);
                    }
                }
                if (z && this.lastShow != z) {
                    this.lastShow = z;
                    if (!CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f9558g.fromType)) {
                        GlobalSugFragment.this.m8302q();
                    }
                }
            }
        });
        this.f9556e.setSugContainerOpCallback(new ISugContainerOpCallback() {
            public void hideInputWindow() {
                if (!GlobalSugFragment.this.isSugFragmentRemoved() && GlobalSugFragment.this.f9555d != null) {
                    GlobalSugFragment.this.f9555d.removeWatcherForStart();
                    GlobalSugFragment.this.f9555d.setStartText(GlobalSugFragment.this.f9558g);
                    ViewUtils.hideInputMethodForEditText(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f9555d.getStartEditText());
                }
            }

            public Address getTargetAddress() {
                if (GlobalSugFragment.this.f9558g == null || GlobalSugFragment.this.f9558g.addressParam == null) {
                    return null;
                }
                return GlobalSugFragment.this.f9558g.addressParam.targetAddress;
            }

            private void onSugContainerScrollToTop() {
                if (GlobalSugFragment.this.f9570s == 1) {
                    GlobalSugFragment.this.m8305r();
                    boolean unused = GlobalSugFragment.this.f9564m = true;
                    GlobalSugFragment.this.f9555d.getStartEditText().clearFocus();
                    GlobalSugFragment.this.f9555d.getStartEditText().setCursorVisible(true);
                    GlobalSugFragment.this.m8297n();
                    GlobalSugFragment.this.f9555d.addWatcherForStart();
                    boolean unused2 = GlobalSugFragment.this.f9564m = false;
                    GlobalSugFragment.this.m8300p();
                }
            }

            public void onSugContainerScrollChanged(int i, int i2, int i3, int i4) {
                if (i2 < -20) {
                    GlobalSugFragment.this.f9555d.getStartEditText().setCursorVisible(false);
                } else if (i2 == 0 && i4 > -100) {
                    onSugContainerScrollToTop();
                }
            }

            public void onScrollToTop() {
                GlobalSugFragment.this.f9556e.setDragEnable(false);
                if (GlobalSugFragment.this.f9570s == 1) {
                    GlobalSugFragment.this.f9555d.addWatcherForStart();
                } else if (GlobalSugFragment.this.f9570s == 2) {
                    GlobalSugFragment.this.f9555d.addEndTextWatcher();
                }
            }

            public void onScrollToBottom() {
                if (GlobalSugFragment.this.f9570s == 1) {
                    GlobalSugFragment.this.f9555d.removeWatcherForStart();
                } else if (GlobalSugFragment.this.f9570s == 2) {
                    GlobalSugFragment.this.f9555d.removeEndTextWatcher();
                }
            }
        });
        this.f9556e.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.log(3, GlobalSugFragment.f9548a, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + GlobalSugFragment.this.f9569r + ", mCurrAddressType: " + GlobalSugFragment.this.f9570s, (Throwable) null, "com.didi.addressold.GlobalSugFragment$9", 510);
                if (GlobalSugFragment.this.f9570s == 1) {
                    GlobalSugFragment.this.f9555d.removeWatcherForStart();
                    GlobalSugFragment.this.f9556e.setDragEnable(true);
                } else if (GlobalSugFragment.this.f9570s == 2) {
                    GlobalSugFragment.this.f9555d.removeEndTextWatcher();
                    GlobalSugFragment.this.f9556e.setDragEnable(true);
                    AddressTrack.trackSelectDestinationInMap(GlobalSugFragment.this.f9558g.addressParam, GlobalSugFragment.this.f9555d.getEndEditText().getText().toString(), GlobalSugFragment.this.f9575x, true);
                }
            }
        });
        this.f9556e.setConfirmBtnClickListener(this.f9576y);
        if (this.f9571t.canSelectAddressByDragged()) {
            this.f9556e.addPoiListener(this.f9577z);
        }
        if (CommonUtils.isFromHomePage(this.f9558g.fromType)) {
            if (this.f9558g.addressParam.addressType != 1 && this.f9558g.addressParam.addressType == 2) {
                this.f9556e.setDragEnable(false);
                m8298o();
            }
        } else if (CommonUtils.isFromConfirmPage(this.f9558g.fromType)) {
            if (this.f9558g.addressParam.addressType != 1 && this.f9558g.addressParam.addressType == 2) {
                this.f9556e.setDragEnable(false);
                m8298o();
            }
        } else if (CommonUtils.isFromGetOnPage(this.f9558g.fromType)) {
            if (this.f9558g.addressParam.addressType == 1) {
                m8297n();
            } else if (this.f9558g.addressParam.addressType == 2) {
                this.f9556e.setDragEnable(false);
                m8298o();
            }
        } else if (CommonUtils.isFromRouteEditor(this.f9558g.fromType)) {
            int i = this.f9558g.addressParam.addressType;
        }
    }

    /* renamed from: d */
    private void m8277d() {
        this.f9550A.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f9551B.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f9551B.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
    }

    /* renamed from: b */
    private void m8272b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(GlobalSugFragment.this.f9570s == 3 && GlobalSugFragment.this.f9570s == 4)) {
                    AddressTrack.trackCloseButtonClick(GlobalSugFragment.this.f9558g, GlobalSugFragment.this.m8289j());
                }
                if (GlobalSugFragment.this.f9561j != null) {
                    z = GlobalSugFragment.this.f9561j.onCloseButtonIntercept();
                }
                if (!z) {
                    GlobalSugFragment.this.closeFragment();
                    if (GlobalSugFragment.this.f9561j != null) {
                        GlobalSugFragment.this.f9561j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m8279e() {
        this.f9556e.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(GlobalSugFragment.this.f9558g.addressParam);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address homeAddress = GlobalSugFragment.this.f9556e.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(GlobalSugFragment.this.f9558g, homeAddress, GlobalSugFragment.this.f9570s);
                    homeAddress.operationType = 4;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9570s, homeAddress);
                    return;
                }
                GlobalSugFragment.this.m8256a(3, GlobalSugFragment.this.f9558g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly();
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address companyAddress = GlobalSugFragment.this.f9556e.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(GlobalSugFragment.this.f9558g, companyAddress, GlobalSugFragment.this.f9570s);
                    companyAddress.operationType = 5;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f9570s, companyAddress);
                    return;
                }
                GlobalSugFragment.this.m8256a(4, GlobalSugFragment.this.f9558g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(GlobalSugFragment.this.f9556e.getHomeAddress()), CommonUtils.isValidLocation(GlobalSugFragment.this.f9556e.getCompanyAddress()));
                Intent intent = CommonAddressActivity.getIntent(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f9558g.clone());
                intent.putExtra(CommonAddressActivity.BUNDLE_TYPE, 2);
                GlobalSugFragment.this.startActivityForResult(intent, 1);
            }
        });
    }

    public void setSugControlCallback(ISugControlCallback iSugControlCallback) {
        this.f9557f = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f9552C = z;
    }

    public ISugViewController getSugViewController() {
        return this.f9556e;
    }

    public String getStartAddressText() {
        return this.f9555d.getStartEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8258a(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, f9548a, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressold.GlobalSugFragment", 758);
            SugParams clone = this.f9558g.clone();
            clone.addressParam.addressType = i;
            if (TextUtil.isEmpty(str) || getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f9562k.processDataRequire(clone, "", z, i);
                return;
            }
            if (clone.addressParam.addressType == 2) {
                this.f9575x = true;
            } else if (clone.addressParam.addressType == 1) {
                this.f9574w = true;
            }
            this.f9562k.processDataRequire(clone, str, z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8256a(int i, SugParams sugParams) {
        sugParams.addressParam.addressType = i;
        if (sugParams.fromType == FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || sugParams.fromType == FromType.HOME || sugParams.fromType == FromType.CONFIRM || CommonUtils.isGetOnFromType(sugParams.fromType)) {
            this.f9564m = true;
            try {
                if (getActivity().findViewById(getId()) != null) {
                    DidiAddressApiFactory.createDidiAddress(getActivity()).selectAddress(getActivity(), getId(), sugParams, (GlobalSugCallback) new GlobalSugCallback() {
                        public void onAttach(int i) {
                        }

                        public void onCloseButtonClick() {
                            resetFocus();
                        }

                        private void resetFocus() {
                            if (GlobalSugFragment.this.f9570s == 1) {
                                GlobalSugFragment.this.m8297n();
                            } else if (GlobalSugFragment.this.f9570s == 2) {
                                GlobalSugFragment.this.m8298o();
                            }
                            boolean unused = GlobalSugFragment.this.f9564m = false;
                        }

                        public void setResult(AddressResult addressResult) {
                            if (addressResult.type == 3) {
                                GlobalSugFragment.this.f9556e.setHomeAddress(addressResult.home);
                            } else if (addressResult.type == 4) {
                                GlobalSugFragment.this.f9556e.setCompanyAddress(addressResult.company);
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
                SystemUtils.log(6, f9548a, "addCommonAddressSelectFragment() " + e.getMessage(), (Throwable) null, "com.didi.addressold.GlobalSugFragment", 828);
            }
        }
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        SystemUtils.log(6, f9548a, "onDestroyView()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 838);
        this.f9572u.onDestroyView();
        this.f9567p = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f9556e;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        SystemUtils.log(6, f9548a, "onDestroy()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 854);
    }

    public boolean onBackPressed() {
        AddressTrack.isInSelectDestination = false;
        AddressTrack.isInSelectStart = false;
        if (!this.f9566o) {
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
        m8282g();
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager != null) {
            try {
                if (fragmentManager.getBackStackEntryCount() > 1) {
                    fragmentManager.popBackStackImmediate();
                    return true;
                }
                if (this.f9556e != null) {
                    this.f9556e.removePoiListener(this.f9577z);
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
        AddressTrack.onViewCreated(this.f9558g, this.f9555d, this.f9556e);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        if (AddressPresenter.isQueryEverEdited() && !TextUtils.isEmpty(this.f9555d.getEndEditText().getText())) {
            this.f9575x = true;
        }
        m8258a(this.f9558g.addressParam.addressType, "", false);
        if ((CommonUtils.isFromGetOnPage(this.f9558g.fromType) || this.f9558g.addressParam.addressType != 1) && (CommonUtils.isFromRouteEditor(this.f9558g.fromType) || this.f9558g.addressParam.addressType != 2)) {
            this.f9556e.showSelectPoiFooterView(false);
        } else {
            this.f9556e.showSelectPoiFooterView(true);
        }
        if (CommonUtils.isFromHomePage(this.f9558g.fromType) && this.f9558g.addressParam.addressType == 2) {
            m8280f();
        }
    }

    /* renamed from: f */
    private void m8280f() {
        if (this.f9562k != null && CommonUtils.isValidLocation(this.f9558g.addressParam)) {
            this.f9562k.fetchStartPoiInfo(this.f9558g);
            this.f9568q = true;
        }
    }

    /* renamed from: g */
    private void m8282g() {
        AddressPresenter addressPresenter = this.f9562k;
        if (addressPresenter != null) {
            addressPresenter.stopRevertGeo();
            this.f9562k.stopFetchStartPoiInfo();
        }
    }

    public void onResume() {
        super.onResume();
        AddressPresenter addressPresenter = this.f9562k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        SystemUtils.log(6, f9548a, "onPause()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 956);
    }

    public void onStop() {
        super.onStop();
        SystemUtils.log(6, f9548a, "onStop()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 962);
        AddressPresenter addressPresenter = this.f9562k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f9555d;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo44384a(GlobalSugCallback globalSugCallback) {
        this.f9561j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f9561j;
        if (globalSugCallback != null) {
            SugParams sugParams = this.f9558g;
            globalSugCallback.onDetach((sugParams == null || sugParams.addressParam == null) ? Integer.MIN_VALUE : this.f9558g.addressParam.addressType);
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
        this.f9551B.setVisibility(8);
        this.f9556e.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo44383a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList) {
        SugListViewContainer sugListViewContainer = this.f9556e;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f9556e.post(new Runnable() {
                public void run() {
                    AddressAdapter addressAdapter = new AddressAdapter(false);
                    addressAdapter.setOnItemSelectedListener(GlobalSugFragment.this.f9553D);
                    addressAdapter.updateAddress(arrayList, trackParameterForChild, GlobalSugFragment.this.f9570s);
                    GlobalSugFragment.this.f9556e.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (this.f9558g.addressParam.addressType == 3 || this.f9558g.addressParam.addressType == 4 || this.f9558g.addressParam.addressType == 5 || this.f9558g.addressParam.addressType == 6) {
            z = false;
        }
        this.f9556e.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9556e.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9556e.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        int i = 8;
        this.f9556e.findViewById(R.id.lv).setVisibility(8);
        this.f9551B.setVisibility(0);
        this.f9551B.showError(str);
        View findViewById = this.f9551B.findViewById(R.id.image_error);
        if (!TextUtils.isEmpty(str)) {
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    public void showNoSearchView() {
        int i;
        hideLoading();
        if (!this.f9571t.canSelectAddressByDragged() || !((i = this.f9570s) == 2 || i == 1)) {
            this.f9556e.setDragEnable(false);
            this.f9556e.findViewById(R.id.lv).setVisibility(8);
        } else {
            this.f9556e.setDragEnable(true);
            this.f9556e.onlyShowSelectPoiFooterView();
        }
        this.f9551B.setVisibility(0);
        this.f9551B.showError(getResources().getText(R.string.global_sug_no_result));
        this.f9551B.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1207);
            if (!m8264a(i, address)) {
                AddressResult addressResult = new AddressResult();
                addressResult.fromType = this.f9558g.fromType;
                addressResult.type = i;
                addressResult.isStartNeedNearRoad = this.f9565n;
                if (i == 4) {
                    addressResult.company = address;
                } else if (i == 3) {
                    addressResult.home = address;
                } else if (i == 1) {
                    if (CommonUtils.isFromRouteEditor(this.f9558g.fromType)) {
                        addressResult.common = address;
                    } else if (this.f9560i == null) {
                        m8298o();
                        m8267a(address);
                        this.f9555d.getStartEditText().setText(address.displayName);
                        this.f9555d.getEndEditText().setText("");
                        addressResult.start = address;
                        return;
                    } else if (!CommonUtils.isTwoAddressEqual(this.f9559h, address)) {
                        addressResult.start = address;
                        addressResult.end = this.f9560i;
                    } else {
                        try {
                            showToastError(getActivity().getString(R.string.GRider_1102_The_same_LaNx));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                } else if (i == 2) {
                    if (CommonUtils.isFromRouteEditor(this.f9558g.fromType)) {
                        addressResult.common = address;
                    } else if (!CommonUtils.isValidLocation(this.f9559h)) {
                        m8297n();
                        this.f9560i = address;
                        this.f9555d.getEndEditText().setText(address.displayName);
                        return;
                    } else if (!CommonUtils.isTwoAddressEqual(this.f9559h, address)) {
                        addressResult.start = this.f9559h;
                        addressResult.end = address;
                    } else {
                        try {
                            showToastError(getActivity().getString(R.string.GRider_1102_The_same_LaNx));
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                } else if (i == 5) {
                    addressResult.common = address;
                } else if (i == 6) {
                    addressResult.common = address;
                }
                m8260a(addressResult);
                return;
            }
            return;
        }
        throw new RuntimeException("setResultBack with null address, type:" + i);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m8285h() {
        Address address = this.f9559h;
        return address == null ? this.f9558g.addressParam.targetAddress : address;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public Address m8287i() {
        Address address = this.f9560i;
        return address == null ? this.f9558g.addressParam.targetAddress : address;
    }

    /* renamed from: a */
    private boolean m8264a(int i, Address address) {
        if (!CommonUtils.isFromConfirmPage(this.f9558g.fromType) && !CommonUtils.isFromGetOnPage(this.f9558g.fromType)) {
            return false;
        }
        AddressResult addressResult = new AddressResult();
        addressResult.fromType = this.f9558g.fromType;
        addressResult.type = i;
        if (i == 1) {
            this.f9555d.getStartEditText().setText(address.displayName);
            addressResult.start = address;
            addressResult.isStartNeedNearRoad = this.f9565n;
            this.f9555d.addWatcherForStart();
            this.f9556e.setDragEnable(false);
        } else if (i == 2) {
            this.f9555d.removeEndTextWatcher();
            this.f9555d.getEndEditText().setText(address.displayName);
            addressResult.end = address;
            this.f9555d.addEndTextWatcher();
            this.f9556e.setDragEnable(false);
        } else {
            this.f9555d.getCommonEditText().setText(address.displayName);
            if (i == 3) {
                addressResult.home = address;
            } else if (i == 4) {
                addressResult.company = address;
            } else {
                throw new RuntimeException("Unknown address type with CONFIRM type");
            }
        }
        m8260a(addressResult);
        return true;
    }

    /* renamed from: a */
    private void m8260a(AddressResult addressResult) {
        if (this.f9552C) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f9561j;
        if (globalSugCallback != null) {
            globalSugCallback.setResult(addressResult);
        }
    }

    public void toLogin() {
        SugParams sugParams;
        if (!isSugFragmentRemoved() && (sugParams = this.f9558g) != null && sugParams.managerCallback != null && this.f9558g.addressParam.currentAddress != null) {
            this.f9558g.managerCallback.toLogin(getActivity(), this.f9558g.addressParam.currentAddress.latitude, this.f9558g.addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f9556e.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        if (CommonUtils.isFromHomePage(this.f9558g.fromType)) {
            int i = this.f9570s;
            if (i == 1 || i == 2) {
                this.f9556e.showSelectPoiFooterView(true);
            } else {
                this.f9556e.showSelectPoiFooterView(false);
            }
        } else if (CommonUtils.isFromGetOnPage(this.f9558g.fromType) || CommonUtils.isFromRouteEditor(this.f9558g.fromType)) {
            this.f9556e.showSelectPoiFooterView(false);
        } else if (CommonUtils.isFromConfirmPage(this.f9558g.fromType)) {
            int i2 = this.f9570s;
            if (i2 == 1 || i2 == 2) {
                this.f9556e.showSelectPoiFooterView(true);
            } else {
                this.f9556e.showSelectPoiFooterView(false);
            }
        } else {
            this.f9556e.showSelectPoiFooterView(z);
        }
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        this.f9556e.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f9555d != null && !this.f9564m && !this.f9567p && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1402);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                String str = "";
                if (i == 1) {
                    m8282g();
                    m8290k();
                    if (this.f9555d.isStartTextNeedScrollToBottomWhenFocused) {
                        m8292l();
                    }
                    if (CommonUtils.isFromHomePage(this.f9558g.fromType)) {
                        m8307s();
                    }
                    m8258a(1, str, false);
                    this.f9556e.scrollToTop();
                    AddressTrack.trackStartPointViewClick(this.f9558g.addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(this.f9558g.fromType, this.f9558g.addressParam));
                    this.f9555d.addWatcherForStart();
                } else if (i == 2) {
                    this.f9556e.setDragEnable(false);
                    Editable text = this.f9555d.getEndEditText().getText();
                    if (text != null) {
                        str = text.toString();
                    }
                    m8258a(2, str, false);
                    m8298o();
                    this.f9556e.scrollToTop();
                }
                this.f9555d.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f9559h != null) {
                    this.f9555d.getStartEditText().setText(this.f9559h.displayName);
                    if (this.f9559h.displayName != null && this.f9559h.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
                        this.f9555d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                        m8280f();
                    } else if (CommonUtils.isFromHomePage(this.f9558g.fromType)) {
                        m8307s();
                    } else {
                        this.f9555d.getStartEditText().setTextColor(-16777216);
                    }
                }
            } else if (i == 2 && this.f9560i != null) {
                this.f9555d.getEndEditText().setText(this.f9560i.displayName);
            }
            this.f9556e.setDragEnable(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m8289j() {
        return AddressTrack.getCurrPage(this.f9570s, this.f9555d, this.f9556e);
    }

    /* renamed from: k */
    private void m8290k() {
        this.f9555d.getEndEditText().setText("");
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m8292l() {
        if (!this.f9567p) {
            this.f9556e.addPoiListener(this.f9577z);
            this.f9556e.setDragEnable(true);
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f9555d.getStartEditText());
            this.f9556e.scrollToBottom();
        }
    }

    /* renamed from: m */
    private void m8295m() {
        if (!this.f9567p) {
            this.f9555d.getCommonEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m8297n() {
        if (!this.f9567p) {
            this.f9555d.getStartEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m8298o() {
        AddressTrack.isInSelectDestination = false;
        if (!this.f9567p) {
            this.f9555d.getEndEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m8300p() {
        Editable text = this.f9555d.getStartEditText().getText();
        if (!TextUtils.isEmpty(text)) {
            Selection.setSelection(text, text.length(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m8302q() {
        this.f9555d.getStartEditText().setSelection(0);
    }

    public void onClick(int i) {
        if (this.f9555d != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, f9548a, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1504);
                m8282g();
                m8305r();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9555d.getStartEditText(), true ^ this.f9567p);
                this.f9556e.scrollToTop();
                this.f9555d.addWatcherForStart();
                this.f9556e.setDragEnable(false);
                AddressTrack.isInSelectStart = false;
            } else if (i == 2) {
                SystemUtils.log(3, f9548a, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1513);
                m8282g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f9555d.getEndEditText(), true ^ this.f9567p);
                this.f9556e.scrollToTop();
                this.f9555d.addEndTextWatcher();
                this.f9556e.setDragEnable(false);
                AddressTrack.isInSelectDestination = false;
            }
            m8258a(i, "", false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m8305r() {
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(this.f9558g.addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText())) {
            this.f9555d.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f9555d != null) {
            setSearchViewType(i);
            if (i == 2 && this.f9573v) {
                this.f9573v = false;
            } else if (view.hasFocus()) {
                m8257a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m8257a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f9563l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f9563l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m8268a(addressParam);
    }

    public void setStartPoiInfo(SugParams sugParams) {
        this.f9555d.setStartText(sugParams);
    }

    /* renamed from: a */
    private boolean m8268a(AddressParam addressParam) {
        if (addressParam == null || this.f9555d == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f9555d.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f9555d.getEndEditText().hasFocus();
        }
        return this.f9555d.getCommonEditText().hasFocus();
    }

    public View getFallbackView() {
        return this.f9550A;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f9570s, convertToAddress);
        }
    }

    /* renamed from: s */
    private void m8307s() {
        this.f9555d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
        this.f9555d.getStartEditText().setHighlightColor(getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
    }
}
