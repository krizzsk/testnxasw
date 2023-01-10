package com.didi.addressnew.framework.fragmentmarket.setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.address.FromType;
import com.didi.address.model.SugParams;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteAdapter;
import com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteListView;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.framework.utils.AddressConverter;
import com.didi.addressnew.presenter.CommonAddressPresenter;
import com.didi.addressnew.presenter.ICommonAddressPresenter;
import com.didi.addressnew.presenter.ISimpleCompanyHomePresenter;
import com.didi.addressnew.presenter.SimpleCompanyHomePresenter;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.ToastHelper;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.ICommonAddressView;
import com.didi.addressnew.view.commonaddress.IHomeCompanyDeleteRequestReactor;
import com.didi.addressnew.view.commonaddress.IHomeCompanyUploadRequestReactor;
import com.didi.addressnew.widget.SwipeMenuLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SettingFragment extends FragmentImpl implements ICommonAddressView {

    /* renamed from: a */
    ICommonAddressPresenter f9168a;

    /* renamed from: b */
    ISimpleCompanyHomePresenter f9169b;

    /* renamed from: c */
    CommonAddressReactor f9170c = new CommonAddressReactor();

    /* renamed from: d */
    private SwipeMenuLayout f9171d;

    /* renamed from: e */
    private SwipeMenuLayout f9172e;

    /* renamed from: f */
    private TextView f9173f;

    /* renamed from: g */
    private TextView f9174g;

    /* renamed from: h */
    private TextView f9175h;

    /* renamed from: i */
    private TextView f9176i;

    /* renamed from: j */
    private ViewGroup f9177j;

    /* renamed from: k */
    private ViewGroup f9178k;

    /* renamed from: l */
    private ViewGroup f9179l;

    /* renamed from: m */
    private ViewGroup f9180m;

    /* renamed from: n */
    private TextView f9181n;

    /* renamed from: o */
    private TextView f9182o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public FavoriteListView f9183p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public List<RpcCommonPoi> f9184q;

    /* renamed from: r */
    private ArrayList<RpcPoi> f9185r = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public RpcCommonPoi f9186s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public RpcCommonPoi f9187t;

    /* renamed from: u */
    private View f9188u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public int f9189v = -1;

    /* renamed from: w */
    private boolean f9190w = false;

    /* renamed from: x */
    private FavoriteAdapter.OnFavoriteItemClickListener f9191x = new FavoriteAdapter.OnFavoriteItemClickListener() {
        public void onItemClick(FavoriteAdapter.FavoriteAddressModel favoriteAddressModel, int i) {
            SettingFragment.this.getmResult().setCommonAddressList(SettingFragment.this.f9184q);
            SettingFragment.this.getmResult().setCommonAddress(favoriteAddressModel.rpcCommonPoi);
            SugParams clone = SettingFragment.this.getmParam().clone();
            clone.fromType = FromType.SETTING;
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.onConfirm(settingFragment.getmParam(), SettingFragment.this.getmResult());
            SettingFragment.this.switchSingle(clone, (IAddressResult) null, 5);
        }

        public void onAddClick() {
            if (SettingFragment.this.f9183p.getTotalFavoriteCnt() >= 10) {
                ToastHelper.showFail(SettingFragment.this.getContext(), SettingFragment.this.getContext().getResources().getString(R.string.GRider_Sug_2020_favoritePage_limit));
                return;
            }
            SettingFragment.this.getmResult().setCommonAddress((RpcCommonPoi) null);
            SettingFragment.this.getmResult().setResultAllowNull(5, (Address) null);
            SettingFragment.this.getmResult().setCommonAddressList(SettingFragment.this.f9184q);
            SettingFragment.this.getmParam().clone().fromType = FromType.SETTING;
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.onConfirm(settingFragment.getmParam(), SettingFragment.this.getmResult());
            SettingFragment settingFragment2 = SettingFragment.this;
            settingFragment2.switchSingle(settingFragment2.getmParam(), (IAddressResult) null, 5);
        }

        public void onDeleteClick(final FavoriteAdapter.FavoriteAddressModel favoriteAddressModel) {
            SettingFragment.this.f9183p.post(new Runnable() {
                public void run() {
                    AddressParam clone = SettingFragment.this.getmParam().addressParam.clone();
                    clone.addressType = 5;
                    SettingFragment.this.f9168a.deletFavoritePlace(clone, favoriteAddressModel.rpcCommonPoi.primaryId);
                }
            });
        }
    };

    public void dismissProgressDialog() {
    }

    public boolean getDragHandlerEnable() {
        return false;
    }

    public View getFallbackView() {
        return null;
    }

    public void onHttpRequestSuccess() {
    }

    public void showContentView() {
    }

    public void showEmptyView() {
    }

    public void showProgressDialog(String str, boolean z) {
    }

    public void showProgressDialog(boolean z) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9168a = new CommonAddressPresenter(getActivity(), this);
        this.f9169b = new SimpleCompanyHomePresenter(getActivity());
        this.f9168a.getCommonAddress(getmParam().addressParam);
        this.f9190w = true;
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        SystemUtils.log(4, "RefreshXXX", "onHiddenChanged: hidden = " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.setting.SettingFragment", 142);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_fragment_layout, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.close_icon);
        this.f9188u = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SettingFragment settingFragment = SettingFragment.this;
                settingFragment.onCancel(settingFragment.getmParam(), SettingFragment.this.getmResult());
                SettingFragment.this.closeSessionImediately();
            }
        });
        this.f9175h = (TextView) inflate.findViewById(R.id.add_home);
        this.f9176i = (TextView) inflate.findViewById(R.id.add_work);
        this.f9177j = (ViewGroup) inflate.findViewById(R.id.home_layout);
        this.f9178k = (ViewGroup) inflate.findViewById(R.id.work_layout);
        this.f9179l = (ViewGroup) inflate.findViewById(R.id.home_content_layout);
        this.f9180m = (ViewGroup) inflate.findViewById(R.id.work_content_layout);
        this.f9181n = (TextView) inflate.findViewById(R.id.home_content);
        this.f9182o = (TextView) inflate.findViewById(R.id.work_content);
        FavoriteListView favoriteListView = (FavoriteListView) inflate.findViewById(R.id.favorite_list);
        this.f9183p = favoriteListView;
        favoriteListView.setOnFavoriteItemClickListener(this.f9191x);
        this.f9183p.setHasHeaderAndFooter(true);
        this.f9171d = (SwipeMenuLayout) inflate.findViewById(R.id.home_sweep);
        this.f9172e = (SwipeMenuLayout) inflate.findViewById(R.id.work_sweep);
        this.f9173f = (TextView) inflate.findViewById(R.id.home_delete);
        this.f9174g = (TextView) inflate.findViewById(R.id.work_delete);
        addStatusBarHeight(inflate);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f9190w = false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f9173f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SettingFragment.this.getmParam().addressParam.addressType = 3;
                SettingFragment.this.f9169b.deleteCommonAddress(SettingFragment.this.getmParam().addressParam, SettingFragment.this.f9170c);
            }
        });
        this.f9174g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SettingFragment.this.getmParam().addressParam.addressType = 4;
                SettingFragment.this.f9169b.deleteCommonAddress(SettingFragment.this.getmParam().addressParam, SettingFragment.this.f9170c);
            }
        });
        this.f9177j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SugParams clone = SettingFragment.this.getmParam().clone();
                SettingFragment.this.getmResult().eraseAllAddress();
                SettingFragment.this.getmResult().setResult(3, AddressConverter.commonRpc2Address(SettingFragment.this.f9186s));
                SettingFragment settingFragment = SettingFragment.this;
                settingFragment.onConfirm(settingFragment.getmParam(), SettingFragment.this.getmResult());
                SettingFragment.this.switchSingle(clone, (IAddressResult) null, 3);
                int unused = SettingFragment.this.f9189v = 3;
                AddressTrack.trackHomeBtnClickDirectly(clone.addressParam, 3, clone.fromType);
            }
        });
        this.f9178k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SugParams clone = SettingFragment.this.getmParam().clone();
                SettingFragment.this.getmResult().eraseAllAddress();
                SettingFragment.this.getmResult().setResult(4, AddressConverter.commonRpc2Address(SettingFragment.this.f9187t));
                SettingFragment settingFragment = SettingFragment.this;
                settingFragment.onConfirm(settingFragment.getmParam(), SettingFragment.this.getmResult());
                SettingFragment.this.switchSingle(clone, (IAddressResult) null, 4);
                int unused = SettingFragment.this.f9189v = 4;
                AddressTrack.trackWorkBtnClickDirectly(clone.addressParam, 3, clone.fromType);
            }
        });
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.SETTING;
    }

    public void showToastComplete(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showSuccessful(getContext(), str);
        }
    }

    public void showToastError(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showFail(getContext(), str);
        }
    }

    public void showToastError(String str, boolean z) {
        if (!isFragmentOnDuty()) {
        }
    }

    public String getStringVal(int i) {
        try {
            return getContext().getString(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
        if (isFragmentOnDuty()) {
            this.f9184q = arrayList;
            ArrayList arrayList2 = new ArrayList();
            if (arrayList != null) {
                Iterator<RpcCommonPoi> it = arrayList.iterator();
                boolean z = false;
                boolean z2 = false;
                while (it.hasNext()) {
                    RpcCommonPoi next = it.next();
                    if (next != null && next.type == 3) {
                        next.name = getString(R.string.global_sug_home);
                        this.f9186s = next;
                        z = true;
                    } else if (next != null && next.type == 4) {
                        next.name = getString(R.string.global_sug_company);
                        this.f9187t = next;
                        z2 = true;
                    } else if (next != null && next.type == 5) {
                        arrayList2.add(next);
                    }
                }
                if (!z) {
                    this.f9179l.setVisibility(8);
                    this.f9175h.setVisibility(0);
                    this.f9177j.setVisibility(0);
                    this.f9186s = null;
                    delSwitcherResultAddress(3);
                    this.f9171d.setEnableSwipe(false);
                } else {
                    this.f9179l.setVisibility(0);
                    this.f9181n.setText(this.f9186s.addressDetail);
                    this.f9175h.setVisibility(8);
                    this.f9171d.setEnableSwipe(true);
                    if (ViewUtils.isRTL()) {
                        this.f9171d.setEnableLeftMenu(true);
                    } else {
                        this.f9171d.setEnableLeftMenu(false);
                    }
                }
                if (!z2) {
                    this.f9180m.setVisibility(8);
                    this.f9178k.setVisibility(0);
                    this.f9176i.setVisibility(0);
                    this.f9187t = null;
                    delSwitcherResultAddress(4);
                    this.f9172e.setEnableSwipe(false);
                } else {
                    this.f9180m.setVisibility(0);
                    this.f9182o.setText(this.f9187t.addressDetail);
                    this.f9176i.setVisibility(8);
                    this.f9172e.setEnableSwipe(true);
                    if (ViewUtils.isRTL()) {
                        this.f9172e.setEnableLeftMenu(true);
                    } else {
                        this.f9172e.setEnableLeftMenu(false);
                    }
                }
                this.f9183p.setFavoriteItems(arrayList2);
                this.f9184q = arrayList2;
            }
        }
    }

    public void addStatusBarHeight(View view) {
        int statusBarHeight = ViewUtils.getStatusBarHeight(getActivity());
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.topMargin = statusBarHeight;
        view.setLayoutParams(marginLayoutParams);
    }

    public void onPageEnter() {
        super.onPageEnter();
        if (getmResult().getLastOperType() != AddressResultEnhancer.OperType.Cancel && getmResult().getLastOperType() != AddressResultEnhancer.OperType.Other && !isFirstEnter()) {
            int i = this.f9189v;
            if (i == 4 || i == 3) {
                if (getmResult().getResult(this.f9189v) != null) {
                    RpcPoi address2Rpc = AddressConverter.address2Rpc(getmResult().getResult(this.f9189v));
                    AddressParam clone = getmParam().addressParam.clone();
                    clone.addressType = this.f9189v;
                    this.f9169b.setHomeCompany(clone, address2Rpc, this.f9170c);
                } else if (this.f9189v != -1) {
                    AddressParam clone2 = getmParam().addressParam.clone();
                    clone2.addressType = this.f9189v;
                    this.f9169b.deleteCommonAddress(clone2, this.f9170c);
                }
                this.f9189v = -1;
                return;
            }
            this.f9168a.getCommonAddress(getmParam().addressParam);
        }
    }

    public void onPageExit() {
        super.onPageExit();
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        super.onConfirm(sugParams, iAddressResult);
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        super.onCancel(sugParams, iAddressResult);
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    class CommonAddressReactor implements IHomeCompanyDeleteRequestReactor, IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            if (SettingFragment.this.f9186s != null) {
                SettingFragment settingFragment = SettingFragment.this;
                settingFragment.m7966a(settingFragment.getStringVal(R.string.GRider_Sug_2020_common_addSuc));
            } else {
                SettingFragment settingFragment2 = SettingFragment.this;
                settingFragment2.m7966a(settingFragment2.getStringVal(R.string.GRider_Sug_2020_common_addSuc));
            }
            SettingFragment.this.f9168a.getCommonAddress(SettingFragment.this.getmParam().addressParam);
        }

        public void onHomeUploadFailed() {
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.m7970b(settingFragment.getStringVal(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.m7970b(settingFragment.getStringVal(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            if (SettingFragment.this.f9187t != null) {
                SettingFragment settingFragment = SettingFragment.this;
                settingFragment.m7966a(settingFragment.getStringVal(R.string.GRider_Sug_2020_common_addSuc));
            } else {
                SettingFragment settingFragment2 = SettingFragment.this;
                settingFragment2.m7966a(settingFragment2.getStringVal(R.string.GRider_Sug_2020_common_addSuc));
            }
            SettingFragment.this.f9168a.getCommonAddress(SettingFragment.this.getmParam().addressParam);
        }

        public boolean isReactorOnDuty() {
            return SettingFragment.this.getActivity() != null && !SettingFragment.this.isRemoving() && SettingFragment.this.isAdded();
        }

        public void onHomeDelSuccess() {
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.m7966a(settingFragment.getStringVal(R.string.GRider_Sug_2020_sidebar_delete_toast_Suc));
            RpcCommonPoi unused = SettingFragment.this.f9186s = null;
            SettingFragment.this.delSwitcherResultAddress(3);
            SettingFragment.this.f9168a.getCommonAddress(SettingFragment.this.getmParam().addressParam);
        }

        public void onHomeDelFailed() {
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.m7970b(settingFragment.getStringVal(R.string.global_sug_load_fail));
        }

        public void onCompanyDelFailed() {
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.m7970b(settingFragment.getStringVal(R.string.global_sug_load_fail));
        }

        public void onCompanyDelSuccess() {
            SettingFragment settingFragment = SettingFragment.this;
            settingFragment.m7966a(settingFragment.getStringVal(R.string.GRider_Sug_2020_sidebar_delete_toast_Suc));
            RpcCommonPoi unused = SettingFragment.this.f9187t = null;
            SettingFragment.this.delSwitcherResultAddress(4);
            SettingFragment.this.f9168a.getCommonAddress(SettingFragment.this.getmParam().addressParam);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7966a(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7970b(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showFail(getContext(), str);
        }
    }
}
