package com.didi.addressnew.framework.fragmentmarket.single;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.address.FromType;
import com.didi.address.SugAlertOmegaUtil;
import com.didi.address.actors.GeoCodeReActor;
import com.didi.address.model.SugParams;
import com.didi.addressnew.fastframe.IView;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.framework.utils.AddressConverter;
import com.didi.addressnew.framework.widget.loadingbutton.LoadableButton;
import com.didi.addressnew.presenter.AddressPresenter;
import com.didi.addressnew.presenter.CommonAddressPresenter;
import com.didi.addressnew.presenter.ISimpleCompanyHomePresenter;
import com.didi.addressnew.presenter.SimpleCompanyHomePresenter;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.ApolloUtil;
import com.didi.addressnew.util.CheckParamUtil;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.ToastHelper;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.AddressAdapter;
import com.didi.addressnew.view.IAddressView;
import com.didi.addressnew.view.ICommonAddressView;
import com.didi.addressnew.view.ISearchViewCallback;
import com.didi.addressnew.view.SugListViewContainer;
import com.didi.addressnew.view.SugSearchView;
import com.didi.addressnew.view.commonaddress.IHomeCompanyUploadRequestReactor;
import com.didi.addressnew.view.enhance.WaittingAdapter;
import com.didi.addressnew.widget.EmptyView;
import com.didi.addressnew.widget.NetErrorView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;

public class SingleFragmentEx extends FragmentImpl implements IAddressView, ICommonAddressView, ISearchViewCallback {
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = "SingleFragmentEx";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public RpcRecSug.TrackParameterForChild f9192A;

    /* renamed from: B */
    private FrameLayout f9193B = null;

    /* renamed from: C */
    private EmptyView f9194C = null;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public NetErrorView f9195D = null;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public AddressAdapter.OnItemSelectedListener f9196E = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (SingleFragmentEx.this.getmParam().addressParam.addressType == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                SingleFragmentEx.this.f9212p.getGeocodeResult(SingleFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, SingleFragmentEx.this.getmParam().addressParam.addressType, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                        SingleFragmentEx.this.setResultBackOnSingle(SingleFragmentEx.this.getmParam().addressParam.addressType, address, rpcPoi);
                    }
                });
                return;
            }
            SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
            int i3 = SingleFragmentEx.this.f9221y ? 3 : 2;
            AddressTrack.trackAddressClick(SingleFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2), trackParameterForChild, SingleFragmentEx.this.getmParam().addressParam.addressType, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i3);
            Address rpc2Address = AddressConverter.rpc2Address(rpcPoi);
            if (rpc2Address != null) {
                rpc2Address.operationType = i3;
            }
            if ((SingleFragmentEx.this.getmParam().addressParam.addressType == 3 || SingleFragmentEx.this.getmParam().addressParam.addressType == 4 || SingleFragmentEx.this.getmParam().addressParam.addressType == 5) && SingleFragmentEx.this.getSugCallback() != null && SingleFragmentEx.this.getSugCallback().getSugBuild() != null && SingleFragmentEx.this.getSugCallback().getSugBuild().getVersion() == 1) {
                SugParams clone = SingleFragmentEx.this.getmParam().clone();
                IAddressResult clone2 = SingleFragmentEx.this.getmResult().clone();
                clone2.setResult(clone.addressParam.addressType, rpc2Address);
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onConfirm(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx.this.switchMapSelect(clone, clone2, clone.addressParam.addressType);
                int unused = SingleFragmentEx.this.f9220x = clone.addressParam.addressType;
                return;
            }
            SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
            singleFragmentEx2.setResultBackOnSingle(singleFragmentEx2.getmParam().addressParam.addressType, rpc2Address, rpcPoi);
            SingleFragmentEx.this.f9212p.recordClickPoi(SingleFragmentEx.this.getmParam(), rpcPoi3.base_info);
        }

        private String getSearchText() {
            if (SingleFragmentEx.this.f9208l == null) {
                return "";
            }
            if (SingleFragmentEx.this.getmParam().addressParam.addressType == 3) {
                return SingleFragmentEx.this.f9208l.getCommonEditText().getText().toString();
            }
            if (SingleFragmentEx.this.getmParam().addressParam.addressType == 4) {
                return SingleFragmentEx.this.f9208l.getCommonEditText().getText().toString();
            }
            return "";
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f9197a;

    /* renamed from: b */
    CommonAddressReactor f9198b = new CommonAddressReactor();

    /* renamed from: c */
    ImageView f9199c;

    /* renamed from: d */
    View f9200d;

    /* renamed from: e */
    View f9201e;

    /* renamed from: f */
    TextView f9202f;

    /* renamed from: g */
    TextView f9203g;

    /* renamed from: h */
    LoadableButton f9204h;

    /* renamed from: i */
    int f9205i = 0;

    /* renamed from: j */
    private final FragmentFactory.FragmentType f9206j = FragmentFactory.FragmentType.SINGLE;

    /* renamed from: k */
    private final int f9207k = 12;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SugSearchView f9208l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public SugListViewContainer f9209m;

    /* renamed from: n */
    private ImageView f9210n;

    /* renamed from: o */
    private TextView f9211o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public AddressPresenter f9212p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CommonAddressPresenter f9213q;

    /* renamed from: r */
    private Handler f9214r;

    /* renamed from: s */
    private Address f9215s = null;

    /* renamed from: t */
    private boolean f9216t;

    /* renamed from: u */
    private boolean f9217u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f9218v;

    /* renamed from: w */
    private boolean f9219w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f9220x = -1;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f9221y = false;

    /* renamed from: z */
    private boolean f9222z = false;

    /* renamed from: h */
    private void m8004h() {
    }

    public boolean getDragHandlerEnable() {
        return false;
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

    public boolean storeStartAddress(AddressParam addressParam) {
        return false;
    }

    public void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null && getmParam() != null) {
            Context applicationContext = activity.getApplicationContext();
            CheckParamUtil.rescueAddressParam(applicationContext, getClass().getSimpleName() + " onAttach", getmParam().addressParam);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m7976a();
    }

    /* renamed from: a */
    private void m7976a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f9212p = new AddressPresenter(getActivity(), this);
        this.f9213q = new CommonAddressPresenter(getActivity(), this);
        this.f9197a = new SimpleCompanyHomePresenter(getActivity());
        this.f9217u = true;
        this.f9218v = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        this.f9214r = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    SingleFragmentEx.this.m7978a(i, (String) message.obj, false);
                }
            }
        };
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_single_sug_fragment, viewGroup, false);
        m7979a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m7979a(View view) {
        m7990b(view.findViewById(R.id.sug_close_btn));
        this.f9199c = (ImageView) view.findViewById(R.id.sug_close_btn);
        this.f9210n = (ImageView) view.findViewById(R.id.delte_btn);
        this.f9211o = (TextView) view.findViewById(R.id.set_common_title);
        this.f9200d = view.findViewById(R.id.common_del_panel_mask);
        this.f9201e = view.findViewById(R.id.common_del_panel);
        this.f9202f = (TextView) view.findViewById(R.id.common_del_panel_title);
        this.f9203g = (TextView) view.findViewById(R.id.common_del_panel_cancel);
        LoadableButton loadableButton = (LoadableButton) view.findViewById(R.id.common_del_panel_confirm);
        this.f9204h = loadableButton;
        loadableButton.setText(getString(R.string.GRider_Sug_2020_confirm));
        this.f9204h.setTextSize(24);
        this.f9204h.setTextStyle(Typeface.DEFAULT_BOLD);
        this.f9204h.reset();
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f9208l = sugSearchView;
        if (sugSearchView != null) {
            sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        }
        m7999e();
        this.f9209m = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f9193B = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f9194C = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f9195D = (NetErrorView) view.findViewById(R.id.net_view_error);
        m7994c();
        m7988b();
        m7996d();
        m8013l();
    }

    /* renamed from: b */
    private void m7988b() {
        if (this.f9208l != null && getmParam() != null) {
            if (CommonUtils.isFromSetting(getmParam().fromType)) {
                this.f9208l.addStatusBarHeightView();
            }
            this.f9208l.setSearchViewCallback(this);
            this.f9208l.initSugSearchView(getmParam());
            this.f9208l.onSingle(getmParam().addressParam, getmResult());
            if (this.f9208l.getCancel(getmParam().addressParam.addressType) != null) {
                this.f9208l.getCancel(getmParam().addressParam.addressType).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                        singleFragmentEx.onCancel(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                        SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                        singleFragmentEx2.switchBack(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                        AddressTrack.trackSugCancelCK(SingleFragmentEx.this.getmParam(), SingleFragmentEx.this.getmParam().addressParam.addressType);
                    }
                });
            }
            this.f9208l.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    SingleFragmentEx.this.m7978a(i, str, true);
                }
            });
            this.f9208l.setListener(getmParam().addressParam);
            this.f9208l.makeStartTextFocusedWhenIsRed();
            this.f9208l.post(new Runnable() {
                public void run() {
                    if (SingleFragmentEx.this.f9209m != null) {
                        SingleFragmentEx.this.f9209m.setTopPadding(SingleFragmentEx.this.f9208l.getHeight());
                    }
                    SingleFragmentEx.this.m8003g();
                }
            });
        }
    }

    public int getCurrentDataAddressType() {
        return getmParam().addressParam.addressType;
    }

    /* renamed from: c */
    private void m7994c() {
        this.f9209m.onSingle(getmParam().addressParam);
        this.f9209m.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackMapSelect(SingleFragmentEx.this.getmParam().addressParam, SingleFragmentEx.this.getmParam().addressParam.addressType, false);
                if (SingleFragmentEx.this.getmResult().getResult(SingleFragmentEx.this.getmParam().addressParam.addressType) != null) {
                    SingleFragmentEx.this.getmResult().getResult(SingleFragmentEx.this.getmParam().addressParam.addressType).operationType = !SingleFragmentEx.this.f9221y ? 2 : 3;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onConfirm(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.switchMapSelect(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult(), SingleFragmentEx.this.getmParam().addressParam.addressType, bundle);
            }
        });
        this.f9209m.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f9209m.getListView());
                    if (SingleFragmentEx.this.f9205i != absListView.getFirstVisiblePosition()) {
                        int currentDataAddressType = SingleFragmentEx.this.getCurrentDataAddressType();
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(SingleFragmentEx.this.getmParam().fromType);
                        AddressTrack.trackScrollCK(currentDataAddressType, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(SingleFragmentEx.this.getmParam().fromType, SingleFragmentEx.this.getCurrentDataAddressType()), SingleFragmentEx.this.f9208l.getCommonEditText().getText().toString(), SingleFragmentEx.this.f9192A, SingleFragmentEx.this.f9205i, absListView.getFirstVisiblePosition(), SingleFragmentEx.this.f9221y);
                    }
                }
                if (i == 1 || i == 2) {
                    SingleFragmentEx.this.f9205i = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m7996d() {
        this.f9193B.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f9194C.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SingleFragmentEx.this.f9208l != null) {
                    ViewUtils.hideInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f9208l.getCommonEditText());
                }
            }
        });
        this.f9195D.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SingleFragmentEx.this.f9208l != null) {
                    ViewUtils.hideInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f9208l.getCommonEditText());
                }
            }
        });
        this.f9194C.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f9195D.getRetryBtn() != null) {
            this.f9195D.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SingleFragmentEx.this.f9195D.setVisibility(8);
                    view.setClickable(false);
                    if (SingleFragmentEx.this.f9208l != null) {
                        SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                        singleFragmentEx.m7989b(singleFragmentEx.getmParam().addressParam.addressType, SingleFragmentEx.this.f9208l.getCommonEditText().getText().toString(), false);
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
    private void m7990b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(SingleFragmentEx.this.getmParam().addressParam.addressType == 3 && SingleFragmentEx.this.getmParam().addressParam.addressType == 4)) {
                    AddressTrack.trackCloseButtonClick(SingleFragmentEx.this.getmParam(), SingleFragmentEx.this.m8001f());
                }
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onCancel(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.switchBack(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
            }
        });
    }

    /* renamed from: e */
    private void m7999e() {
        ImageView imageView;
        if (getmParam().fromType == FromType.SETTING) {
            this.f9199c.setVisibility(0);
            this.f9211o.setVisibility(0);
            if (getmParam().addressParam.addressType == 4) {
                if (getmResult().getResult(4) != null) {
                    this.f9211o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_editwork));
                } else {
                    this.f9211o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_addwork));
                }
            } else if (getmParam().addressParam.addressType == 3) {
                if (getmResult().getResult(3) != null) {
                    this.f9211o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_editHome));
                } else {
                    this.f9211o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_addHome));
                }
            }
            if (getmResult().getResult(getmParam().addressParam.addressType) == null && (imageView = this.f9210n) != null) {
                imageView.setVisibility(8);
            }
            if (getmResult().getCommonAddress() != null) {
                if (getmParam().addressParam.addressType == 5) {
                    this.f9211o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_editfavorite));
                    ImageView imageView2 = this.f9210n;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                }
            } else if (getmParam().addressParam.addressType == 5) {
                this.f9211o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_addfavorite));
            }
            ImageView imageView3 = this.f9210n;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SingleFragmentEx.this.f9208l != null) {
                            ViewUtils.hideInputWindow(SingleFragmentEx.this.getActivity(), SingleFragmentEx.this.f9208l.getCommonEditText());
                        }
                        SingleFragmentEx.this.m8008j();
                    }
                });
            }
            this.f9204h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    RpcCommonPoi commonAddress;
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SingleFragmentEx.this.f9204h.isReseted()) {
                        SingleFragmentEx.this.f9204h.playAnim();
                    }
                    AddressParam clone = SingleFragmentEx.this.getmParam().addressParam.clone();
                    if (SingleFragmentEx.this.getmParam().addressParam.addressType == 4) {
                        clone.addressType = 4;
                        SingleFragmentEx.this.getmResult().eraseAllAddress();
                        SingleFragmentEx.this.delSwitcherResultAddress(4);
                        SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                        singleFragmentEx.onConfirm(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                        SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                        singleFragmentEx2.switchBack(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                    } else if (SingleFragmentEx.this.getmParam().addressParam.addressType == 3) {
                        clone.addressType = 3;
                        SingleFragmentEx.this.delSwitcherResultAddress(3);
                        SingleFragmentEx.this.getmResult().eraseAllAddress();
                        SingleFragmentEx singleFragmentEx3 = SingleFragmentEx.this;
                        singleFragmentEx3.onConfirm(singleFragmentEx3.getmParam(), SingleFragmentEx.this.getmResult());
                        SingleFragmentEx singleFragmentEx4 = SingleFragmentEx.this;
                        singleFragmentEx4.switchBack(singleFragmentEx4.getmParam(), SingleFragmentEx.this.getmResult());
                    } else if (SingleFragmentEx.this.getmParam().addressParam.addressType == 5 && (commonAddress = SingleFragmentEx.this.getmResult().getCommonAddress()) != null && !TextUtils.isEmpty(commonAddress.primaryId)) {
                        clone.addressType = 5;
                        SingleFragmentEx.this.f9213q.deletFavoritePlace(clone, commonAddress.primaryId);
                        AddressTrack.trackFavoriteDeleteClick();
                    }
                }
            });
            this.f9203g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SingleFragmentEx.this.m8010k();
                }
            });
            this.f9200d.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
    }

    public String getStartAddressText() {
        SugSearchView sugSearchView = this.f9208l;
        return sugSearchView != null ? sugSearchView.getStartEditText().getText().toString().trim() : "";
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f9208l != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f9208l.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f9209m;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f9209m.getListView().setAdapter(waittingAdapter);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7978a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 544);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            SugSearchView sugSearchView = this.f9208l;
            if (sugSearchView != null) {
                sugSearchView.post(new Runnable() {
                    public void run() {
                        if (SingleFragmentEx.this.f9195D.getVisibility() != 0) {
                            if (TextUtil.isEmpty(str) || SingleFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                                SingleFragmentEx.this.showWaittingList();
                            }
                        }
                    }
                });
            }
            if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f9221y = false;
                this.f9212p.processDataRequire(clone, "", z, i);
                return;
            }
            this.f9221y = true;
            this.f9212p.processDataRequire(clone, str, z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7989b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 579);
            SugParams clone = getmParam().clone();
            if (getmParam().fromType == FromType.HOME && AddressPresenter.getLastAddressType() == 2 && AddressPresenter.isLastCachedRecommendCache(2)) {
                AddressParam addressParam = clone.addressParam;
                SugListViewContainer sugListViewContainer = this.f9209m;
                AddressTrack.trackEndRecVisibleListItemCount(addressParam, sugListViewContainer != null ? sugListViewContainer.getVisibleCount() : 0);
            }
            clone.addressParam.addressType = i;
            SugSearchView sugSearchView = this.f9208l;
            if (sugSearchView != null) {
                sugSearchView.post(new Runnable() {
                    public void run() {
                        if (!SingleFragmentEx.this.f9218v) {
                            SingleFragmentEx.this.f9209m.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(SingleFragmentEx.this.getActivity()) - SingleFragmentEx.this.f9208l.getHeight()) / DisplayUtils.dp2px(SingleFragmentEx.this.getActivity(), 66.0f)) - 1));
                        }
                    }
                });
            }
            if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f9221y = false;
                this.f9212p.processDataRequire(clone, "", z, i);
                return;
            }
            this.f9221y = true;
            this.f9212p.getSuggestPoiList(clone, str, z, i, true);
        }
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f9218v = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f9209m;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AddressTrack.onViewCreated(getmParam(), this.f9208l, this.f9209m);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        if (m8015m()) {
            m7978a(2, "", false);
        } else {
            m7978a(getmParam().addressParam.addressType, "", false);
        }
        if (getmParam().fromType != FromType.MAP_POINT_SELECT) {
            this.f9209m.showSelectPoiFooterView(true);
        } else {
            this.f9209m.showSelectPoiFooterView(false);
        }
    }

    public void onResume() {
        this.f9222z = true;
        super.onResume();
        AddressPresenter addressPresenter = this.f9212p;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f9208l;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        this.f9222z = false;
        if (getView() != null) {
            ViewUtils.hideInputWindow(getActivity(), getView());
            getView().clearFocus();
        }
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f9212p;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f9208l;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
    }

    public void onDetach() {
        super.onDetach();
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
        this.f9219w = false;
        m8010k();
        this.f9204h.reset();
        onConfirm(getmParam(), getmResult());
        switchBack(getmParam(), getmResult());
    }

    public void showToastError(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showFail(getActivity(), str);
        }
        this.f9219w = false;
    }

    public void showToastError(String str, boolean z) {
        if (!isDetached()) {
            ToastHelper.showFail(getActivity(), str);
            m8010k();
            this.f9204h.reset();
        }
    }

    public void showContentView() {
        this.f9194C.setVisibility(8);
        this.f9195D.setVisibility(8);
        this.f9209m.findViewById(R.id.lv).setVisibility(0);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f9209m;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f9192A = trackParameterForChild;
            this.f9209m.post(new Runnable() {
                public void run() {
                    AddressAdapter addressAdapter = new AddressAdapter();
                    addressAdapter.setOnItemSelectedListener(SingleFragmentEx.this.f9196E);
                    addressAdapter.updateAddress(arrayList, SingleFragmentEx.this.getmParam().clone(), trackParameterForChild, SingleFragmentEx.this.getmParam().addressParam.addressType, i);
                    SugListViewContainer a = SingleFragmentEx.this.f9209m;
                    ArrayList arrayList = arrayList;
                    a.onAddressOcupy(arrayList == null ? true : arrayList.isEmpty(), false);
                    SingleFragmentEx.this.f9209m.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) {
            z = false;
        }
        this.f9209m.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9209m.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f9209m.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        this.f9209m.onlyShowSelectPoiFooterView();
        this.f9194C.setVisibility(8);
        this.f9195D.setVisibility(0);
        showCommonAddressView(false);
        this.f9195D.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        if (getmParam().fromType != FromType.MAP_POINT_SELECT) {
            this.f9209m.onlyShowSelectPoiFooterView();
        } else {
            this.f9209m.showSelectPoiFooterView(false);
        }
        this.f9195D.setVisibility(8);
        this.f9194C.setVisibility(0);
        this.f9194C.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f9194C.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f9195D;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f9194C;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if ((getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            SugParams clone = getmParam().clone();
            IAddressResult clone2 = getmResult().clone();
            clone2.setResult(clone.addressParam.addressType, address);
            onConfirm(getmParam(), getmResult());
            switchMapSelect(clone, clone2, clone.addressParam.addressType);
            this.f9220x = clone.addressParam.addressType;
            return;
        }
        setResultBackOnSingle(getmParam().addressParam.addressType, address, AddressConverter.address2Rpc(address));
    }

    public void setResultBackOnSingle(int i, Address address, RpcPoi rpcPoi) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 1020);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = false;
            if (m7985a(i, address, rpcPoi)) {
                switchBack(getmParam(), getmResult());
                return;
            }
            return;
        }
        throw new RuntimeException("setResultBack with null address, type:" + i);
    }

    public void toLogin() {
        if (!isSugFragmentRemoved() && getmParam() != null && getmParam().managerCallback != null && getmParam().addressParam != null && getmParam().addressParam.currentAddress != null) {
            getmParam().managerCallback.toLogin(getActivity(), getmParam().addressParam.currentAddress.latitude, getmParam().addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f9209m.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i) {
        this.f9209m.updateMapConfirmHeaderView(tipsInfo, i);
    }

    public void updateSelectPoiFooters(boolean z) {
        if (getmParam().fromType != FromType.MAP_POINT_SELECT) {
            this.f9209m.showSelectPoiFooterView(true);
        } else {
            this.f9209m.showSelectPoiFooterView(false);
        }
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        this.f9209m.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f9208l != null && !this.f9216t && !this.f9218v && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 1097);
        }
    }

    /* renamed from: a */
    private String m7975a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f9208l.getEndEditText().getText().toString().trim();
        }
        return (this.f9208l.getCommonEditText() == null || TextUtils.isEmpty(this.f9208l.getCommonEditText().getText())) ? "" : this.f9208l.getCommonEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m8001f() {
        return AddressTrack.getCurrPage(getmParam().addressParam.addressType, this.f9208l, this.f9209m);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m8003g() {
        SugSearchView sugSearchView;
        if (!this.f9218v && (sugSearchView = this.f9208l) != null) {
            sugSearchView.getCommonEditText().requestFocus();
        }
    }

    public void onClick(int i) {
        if (this.f9208l == null || isSugFragmentRemoved()) {
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f9208l != null && view.hasFocus()) {
            m7977a(i, editable.toString().trim());
        }
    }

    /* renamed from: a */
    private void m7977a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f9214r.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f9214r;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m7986a(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f9208l;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
        }
    }

    /* renamed from: a */
    private boolean m7986a(AddressParam addressParam) {
        SugSearchView sugSearchView;
        if (addressParam == null || (sugSearchView = this.f9208l) == null) {
            return false;
        }
        return sugSearchView.getCommonEditText().hasFocus();
    }

    public void onClearClick(int i, String str) {
        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
        AddressTrack.trackSugClear(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), str);
    }

    /* renamed from: a */
    private boolean m7985a(int i, Address address, RpcPoi rpcPoi) {
        if (address == null) {
            return false;
        }
        if (getmParam().fromType != FromType.SETTING) {
            if (i == 4) {
                getmResult().setCompany(address);
            } else if (i == 3) {
                getmResult().setHome(address);
            } else if (i == 5) {
                getmParam().addressParam.targetAddress = address;
                getmResult().setCommonAddress(AddressConvertUtil.addressToRpcCommonPoi(address, getmResult().getCommonAddress()));
                onConfirm(getmParam(), getmResult());
                switchEditFavorite(getmParam(), getmResult());
                return false;
            } else if (i != 101 && i != 102) {
                return false;
            } else {
                getmResult().setCommon(address);
            }
            onConfirm(getmParam(), getmResult());
        } else if (i == 4) {
            getmResult().eraseAllAddress();
            getmResult().setResult(i, address);
            onConfirm(getmParam(), getmResult());
            return true;
        } else if (i == 3) {
            getmResult().eraseAllAddress();
            getmResult().setResult(i, address);
            onConfirm(getmParam(), getmResult());
            return true;
        } else if (i == 5) {
            getmParam().addressParam.targetAddress = address;
            getmResult().setCommonAddress(AddressConvertUtil.addressToRpcCommonPoi(address, getmResult().getCommonAddress()));
            onConfirm(getmParam(), getmResult());
            switchEditFavorite(getmParam(), getmResult());
            return false;
        }
        return true;
    }

    public void onPageEnter() {
        super.onPageEnter();
        SugSearchView sugSearchView = this.f9208l;
        if (sugSearchView != null) {
            sugSearchView.postDelayed(new Runnable() {
                public void run() {
                    ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f9208l.getCommonEditText());
                }
            }, 500);
            if (isFirstEnter() || !this.f9222z) {
                this.f9208l.getCommonEditText().setFocusable(true);
                this.f9208l.getCommonEditText().setFocusableInTouchMode(true);
                setParentNodeType(IFragment.ParentNode.CHILD);
                int i = getmParam().addressParam.addressType;
                this.f9208l.removeCommonWatcher(getmParam().addressParam);
                if (getmParam().fromType == FromType.SETTING && getmResult().getLastPageType() == FragmentFactory.FragmentType.SETTING) {
                    AddressTrack.trackSugPageSW(0, AddressTrack.page_level_two, i);
                    if (i == 4) {
                        if (getmResult().getAddressResult().company != null) {
                            m8007i();
                        }
                    } else if (i == 3) {
                        if (getmResult().getAddressResult().home != null) {
                            m8007i();
                        }
                    } else if (i == 5 && getmResult().getCommonAddress() != null) {
                        getmResult().setResultAllowNull(5, AddressConverter.commonRpc2Address(getmResult().getCommonAddress()));
                        m8007i();
                    }
                    this.f9215s = getmResult().getResult(getmParam().addressParam.addressType);
                } else if (!m8015m()) {
                    AddressTrack.trackSugPageSW(0, AddressTrack.page_level_two, i);
                    if (i == 4) {
                        m7982a(getmResult().getAddressResult().company);
                    } else if (i == 3) {
                        m7982a(getmResult().getAddressResult().home);
                    } else if (i == 5) {
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.FAVORITE) {
                            m7983a(getmResult().getCommonAddress());
                            getmResult().setResultAllowNull(5, AddressConverter.commonRpc2Address(getmResult().getCommonAddress()));
                        } else {
                            m7982a(getmResult().getAddressResult().common);
                        }
                    } else if (i == 6) {
                        m7982a(getmResult().getAddressResult().common);
                    }
                    if (!isFirstEnter()) {
                        getmResult().setResultAllowNull(i, this.f9215s);
                        updataSwitcherResultAddressAllowNull(i, this.f9215s);
                    }
                } else if (getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel) {
                    this.f9220x = -1;
                    this.f9208l.addCommonTextWatcher(getmParam().addressParam);
                    this.f9208l.postDelayed(new Runnable() {
                        public void run() {
                            ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f9208l.getCommonEditText());
                        }
                    }, 500);
                    return;
                } else {
                    m7982a(getmResult().getAddressResult().common);
                    getmResult().getMapSelectOperType();
                    AddressResultEnhancer.MapSelectOper mapSelectOper = AddressResultEnhancer.MapSelectOper.Edit;
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, i);
                    int i2 = this.f9220x;
                    if (i2 == 3) {
                        if (this.f9209m != null && getmResult().getAddressResult().home != null) {
                            this.f9209m.setHomeAddress(getmResult().getAddressResult().home);
                            AddressParam clone = getmParam().addressParam.clone();
                            clone.addressType = 3;
                            this.f9197a.setHomeCompany(clone, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f9198b);
                        } else if (getmResult().getAddressResult().home == null) {
                            this.f9198b.onHomeUploadFailed();
                        }
                        this.f9220x = -1;
                        this.f9208l.addCommonTextWatcher(getmParam().addressParam);
                        this.f9208l.postDelayed(new Runnable() {
                            public void run() {
                                ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f9208l.getCommonEditText());
                            }
                        }, 500);
                        return;
                    } else if (i2 == 4) {
                        if (this.f9209m != null && getmResult().getAddressResult().company != null) {
                            this.f9209m.setCompanyAddress(getmResult().getAddressResult().company);
                            AddressParam clone2 = getmParam().addressParam.clone();
                            clone2.addressType = 4;
                            this.f9197a.setHomeCompany(clone2, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f9198b);
                        } else if (getmResult().getAddressResult().company == null) {
                            this.f9198b.onCompanyUploadFailed();
                        }
                        this.f9220x = -1;
                        this.f9208l.addCommonTextWatcher(getmParam().addressParam);
                        this.f9208l.postDelayed(new Runnable() {
                            public void run() {
                                ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f9208l.getCommonEditText());
                            }
                        }, 500);
                        return;
                    } else if (!isFirstEnter()) {
                        getmResult().setResultAllowNull(getmParam().addressParam.addressType, this.f9215s);
                        updataSwitcherResultAddressAllowNull(getmParam().addressParam.addressType, this.f9215s);
                    }
                }
                this.f9208l.removeCommonWatcher(getmParam().addressParam);
                if (getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Edit) {
                    if (i == 5) {
                        if (getmResult().getCommonAddress() != null) {
                            this.f9208l.getCommonEditText().setText(getmResult().getCommonAddress().displayName);
                            this.f9208l.getCommonEditText().selectAll();
                            this.f9208l.getCommonEditText().setClearIconVisible(true);
                        }
                    } else if (getmResult().getResult(getmParam().addressParam.addressType) != null) {
                        this.f9208l.getCommonEditText().setText(getmResult().getResult(getmParam().addressParam.addressType).displayName);
                        this.f9208l.getCommonEditText().selectAll();
                        this.f9208l.getCommonEditText().setClearIconVisible(true);
                    }
                }
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, 2, m7975a(i));
                this.f9208l.addCommonTextWatcher(getmParam().addressParam);
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                if (!TextUtils.isEmpty(this.f9208l.getCommonEditText().getText())) {
                    this.f9208l.getCommonEditText().setClearIconVisible(true);
                }
                this.f9220x = -1;
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        this.f9222z = false;
        SugSearchView sugSearchView = this.f9208l;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            if (getActivity() != null && isFragmentOnDuty()) {
                ViewUtils.hideInputMethodForEditText(getContext(), this.f9208l.getCommonEditText());
            }
            this.f9208l.getCommonEditText().setFocusable(false);
            this.f9208l.getCommonEditText().setFocusableInTouchMode(false);
        }
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        super.onCancel(sugParams, iAddressResult);
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        super.onConfirm(sugParams, iAddressResult);
    }

    public FragmentFactory.FragmentType getType() {
        return this.f9206j;
    }

    /* renamed from: i */
    private void m8007i() {
        ImageView imageView = this.f9210n;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m8008j() {
        this.f9201e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_enter);
        this.f9201e.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                SingleFragmentEx.this.f9200d.setVisibility(0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m8010k() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_exit);
        this.f9201e.startAnimation(loadAnimation);
        this.f9201e.setVisibility(4);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                SingleFragmentEx.this.f9200d.setVisibility(8);
            }
        });
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m7984a(singleFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m7993b(singleFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m7993b(singleFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m7984a(singleFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !SingleFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7984a(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7993b(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showFail(getContext(), str);
        }
    }

    /* renamed from: a */
    private void m7982a(Address address) {
        SugSearchView sugSearchView;
        if (address != null) {
            SugSearchView sugSearchView2 = this.f9208l;
            if (sugSearchView2 != null) {
                sugSearchView2.removeCommonWatcher(getmParam().addressParam);
                if (address != null) {
                    this.f9208l.getCommonEditText().setText(address.displayName);
                    int i = getmParam().addressParam.addressType;
                    if (m8015m()) {
                        i = 2;
                    }
                    if (!isFirstEnter()) {
                        m7978a(i, "", false);
                    }
                }
                this.f9208l.getCommonEditText().requestFocus();
                this.f9208l.getCommonEditText().selectAll();
                this.f9208l.addCommonTextWatcher(getmParam().addressParam);
            }
        } else if (address == null && (sugSearchView = this.f9208l) != null) {
            sugSearchView.post(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(SingleFragmentEx.this.f9208l.getCommonEditText().getText()) && SingleFragmentEx.this.f9208l != null) {
                        SingleFragmentEx.this.f9208l.getCommonEditText().requestFocus();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m7983a(RpcCommonPoi rpcCommonPoi) {
        SugSearchView sugSearchView;
        if (rpcCommonPoi != null) {
            SugSearchView sugSearchView2 = this.f9208l;
            if (sugSearchView2 != null) {
                sugSearchView2.removeCommonWatcher(getmParam().addressParam);
                if (rpcCommonPoi != null) {
                    this.f9208l.getCommonEditText().setText(rpcCommonPoi.displayName);
                    int i = getmParam().addressParam.addressType;
                    if (m8015m()) {
                        i = 2;
                    }
                    m7978a(i, "", false);
                }
                this.f9208l.getCommonEditText().requestFocus();
                this.f9208l.getCommonEditText().selectAll();
                this.f9208l.addCommonTextWatcher(getmParam().addressParam);
            }
        } else if (rpcCommonPoi == null && (sugSearchView = this.f9208l) != null) {
            sugSearchView.post(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(SingleFragmentEx.this.f9208l.getCommonEditText().getText()) && SingleFragmentEx.this.f9208l != null) {
                        SingleFragmentEx.this.f9208l.getCommonEditText().requestFocus();
                    }
                }
            });
        }
    }

    /* renamed from: l */
    private void m8013l() {
        this.f9209m.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(SingleFragmentEx.this.getmParam().addressParam, SingleFragmentEx.this.m8015m() ? 2 : 3, SingleFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    SingleFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = SingleFragmentEx.this.f9209m.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(SingleFragmentEx.this.getmParam(), homeAddress, SingleFragmentEx.this.getmParam().addressParam.addressType);
                    homeAddress.operationType = 4;
                    SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                    singleFragmentEx.setResultBackOnSingle(singleFragmentEx.getmParam().addressParam.addressType, homeAddress, AddressConverter.address2Rpc(homeAddress));
                    return;
                }
                SingleFragmentEx.this.setParentNodeType(IFragment.ParentNode.WAYPOINT_SELECTOR);
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.onConfirm(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx3 = SingleFragmentEx.this;
                singleFragmentEx3.switchSingle(singleFragmentEx3.getmParam(), SingleFragmentEx.this.getmResult(), 3);
                int unused = SingleFragmentEx.this.f9220x = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(SingleFragmentEx.this.getmParam().addressParam, SingleFragmentEx.this.m8015m() ? 2 : 3, SingleFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    SingleFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = SingleFragmentEx.this.f9209m.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(SingleFragmentEx.this.getmParam(), companyAddress, SingleFragmentEx.this.getmParam().addressParam.addressType);
                    companyAddress.operationType = 5;
                    SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                    singleFragmentEx.setResultBackOnSingle(singleFragmentEx.getmParam().addressParam.addressType, companyAddress, AddressConverter.address2Rpc(companyAddress));
                    return;
                }
                SingleFragmentEx.this.setParentNodeType(IFragment.ParentNode.WAYPOINT_SELECTOR);
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.onConfirm(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx3 = SingleFragmentEx.this;
                singleFragmentEx3.switchSingle(singleFragmentEx3.getmParam(), SingleFragmentEx.this.getmResult(), 4);
                int unused = SingleFragmentEx.this.f9220x = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    SingleFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(SingleFragmentEx.this.f9209m.getHomeAddress()), CommonUtils.isValidLocation(SingleFragmentEx.this.f9209m.getCompanyAddress()), SingleFragmentEx.this.m8015m() ? 2 : 3);
                SugParams clone = SingleFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = SingleFragmentEx.this.getmParam().addressParam.addressType;
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onConfirm(clone, singleFragmentEx.getmResult());
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.switchFavorite(clone, singleFragmentEx2.getmResult());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m8015m() {
        return ((getmParam().fromType != FromType.ROUTE_EDITOR && getmParam().fromType != FromType.FROM_HOME_ROUTE_EDITOR && getmParam().fromType != FromType.FROM_CONFIRM_ROUTE_EDITOR) || getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) ? false : true;
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public String getStringSafe(int i) {
        try {
            return getContext().getString(i);
        } catch (Exception unused) {
            return "";
        }
    }
}
