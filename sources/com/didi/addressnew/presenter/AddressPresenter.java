package com.didi.addressnew.presenter;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.didi.address.FromType;
import com.didi.address.actors.GeoCodeReActor;
import com.didi.address.model.SugParams;
import com.didi.address.util.NetUtil;
import com.didi.addressnew.model.ISelectAddressModel;
import com.didi.addressnew.model.SelectAddressModel;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CheckParamUtil;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.view.IAddressView;
import com.didi.addressnew.view.IStationFetcherView;
import com.didi.addressnew.view.departure.BaseDeparture;
import com.didi.addressnew.view.departure.SugDeparturePinNew;
import com.didi.common.map.Map;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.omega.AppFluentOmega;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.ResultCallback;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfo;
import com.sdk.poibase.model.common.RpcCommon;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.recsug.RpcRecSugInfo;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class AddressPresenter implements IAddressPresenter {

    /* renamed from: a */
    private static final String f9287a = "AddressPresenter";

    /* renamed from: i */
    private static final String f9288i = "RECOMMEND_RPC";

    /* renamed from: j */
    private static final String f9289j = "SUGGESTION_RPC";

    /* renamed from: k */
    private static final int f9290k = 185;

    /* renamed from: l */
    private static final int f9291l = 34;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Context f9292b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ISelectAddressModel f9293c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IAddressView f9294d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final LastQueryKey f9295e;

    /* renamed from: f */
    private DIDILocationListener f9296f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LatLng f9297g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IHttpListener<ReverseGeoResult> f9298h;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f9299m = true;

    /* renamed from: n */
    private BaseDeparture f9300n;

    public void uploadPoi(SugParams sugParams, RpcPoi rpcPoi) {
    }

    public AddressPresenter(Context context, IAddressView iAddressView) {
        this.f9292b = context;
        this.f9293c = new SelectAddressModel(context);
        this.f9294d = iAddressView;
        this.f9295e = new LastQueryKey();
    }

    public void onLogout(SugParams sugParams) {
        this.f9293c.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), (RpcCommon) null);
        m8083a((RpcCommon) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m8087a() {
        IAddressView iAddressView = this.f9294d;
        return iAddressView == null || iAddressView.isSugFragmentRemoved();
    }

    /* renamed from: a */
    private void m8085a(String str, AddressParam addressParam) {
        if (this.f9292b != null) {
            if (addressParam == null || !CommonUtils.isValidLocation(addressParam.currentAddress) || !CommonUtils.isValidLocation(addressParam.targetAddress)) {
                CheckParamUtil.rescueAddressParam(this.f9292b.getApplicationContext(), str, addressParam);
            }
        }
    }

    public void getRecommendPoiList(SugParams sugParams, boolean z, int i) {
        SugParams sugParams2 = sugParams;
        if (this.f9294d == null || m8087a()) {
            SystemUtils.log(5, f9287a, "getRecommendPoiList() mView == null || ", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 107);
            return;
        }
        String str = z ? "1" : "0";
        if (this.f9295e.isSame(sugParams2.addressParam.addressType, "", str)) {
            SystemUtils.log(5, f9287a, "getRecommendPoiList() key.isSame(param.addressType, \"\", manSearch)", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 113);
        }
        m8085a("AddressPresenter getRecommendPoiList()", sugParams2.addressParam);
        sugParams2.addressParam.query = "";
        sugParams2.addressParam.mansearch = str;
        this.f9294d.showProgressView();
        this.f9294d.setSugTips("");
        this.f9294d.showCommonAddressView(true);
        this.f9294d.updateTipsInfoHeaderView((RpcRecSug.TipsInfo) null);
        final int i2 = i;
        this.f9294d.updateMapConfirmHeaderView((RpcRecSug.TipsInfo) null, i2);
        m8078a(sugParams2, (RpcRecSug) null);
        this.f9294d.showWaittingList();
        final long currentTimeMillis = System.currentTimeMillis();
        this.f9295e.setKey(sugParams2.addressParam.addressType, sugParams2.addressParam.query, sugParams2.addressParam.mansearch);
        ISelectAddressModel iSelectAddressModel = this.f9293c;
        AddressParam addressParam = sugParams2.addressParam;
        final SugParams sugParams3 = sugParams;
        iSelectAddressModel.getRecommendPoiList(addressParam, new ResultCallback<RpcRecSug>() {
            public void success(RpcRecSug rpcRecSug) {
                SystemUtils.log(4, AddressPresenter.f9287a, "RecSuccess callback = " + hashCode() + "\n" + rpcRecSug, (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$1", 132);
                if (!AddressPresenter.this.m8087a()) {
                    if (sugParams3.addressParam.addressType == 2) {
                        AddressTrack.setListRequestType(AddressTrack.LIST_REQUEST_TYPE.END_REC);
                    }
                    if (sugParams3.addressParam.addressType == 1) {
                        AddressTrack.setListRequestType(AddressTrack.LIST_REQUEST_TYPE.START_REC);
                    }
                    if (rpcRecSug == null || rpcRecSug.errno != 0) {
                        AddressTrack.trackError(sugParams3.addressParam, false, AddressTrack.ErrorType.service_abnormal);
                        AddressPresenter.this.f9294d.showErrorView("");
                    } else {
                        AddressTrack.trackRecommendRequest(sugParams3, rpcRecSug, String.valueOf(System.currentTimeMillis() - currentTimeMillis), i2);
                        AddressPresenter.this.m8086a(rpcRecSug.rec_poi_list, rpcRecSug.getTrackParameter(), sugParams3.addressParam, rpcRecSug.tips_info == null ? RpcRecSugInfo.TYPE_DEFAULT : rpcRecSug.tips_info.type);
                        AddressPresenter.this.m8078a(sugParams3, rpcRecSug);
                    }
                    AddressPresenter.getLatestCache().setLastCachedKey(sugParams3.addressParam.addressType, AddressPresenter.f9288i);
                    if (sugParams3.addressParam.addressType == 2) {
                        AddressTrack.trackEndAddressRecList(sugParams3.addressParam, AddressPresenter.this.f9294d.getStartAddressText(), rpcRecSug);
                        if (AddressPresenter.this.f9299m) {
                            boolean unused = AddressPresenter.this.f9299m = false;
                            AppFluentOmega.getInstance().stopCalculateTime(AddressPresenter.this.f9292b, (Map) null, 5, (HashMap<String, Object>) null);
                        }
                    }
                }
            }

            public void failure(IOException iOException) {
                SystemUtils.log(4, AddressPresenter.f9287a, "RecFailed callback = " + hashCode() + "\n" + iOException, (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$1", 168);
                if (!AddressPresenter.this.m8087a() && AddressPresenter.this.f9295e.isSame(sugParams3.addressParam.addressType, sugParams3.addressParam.query, sugParams3.addressParam.mansearch)) {
                    if (NetUtil.isNetException(iOException)) {
                        AddressTrack.trackError(sugParams3.addressParam, false, AddressTrack.ErrorType.network_abnormal);
                    } else {
                        AddressTrack.trackError(sugParams3.addressParam, false, AddressTrack.ErrorType.service_abnormal);
                    }
                    if (NetUtil.isNetworkAvailable(AddressPresenter.this.f9292b)) {
                        AddressPresenter.this.m8082a(sugParams3.addressParam, (RpcRecSug) null, AddressPresenter.this.f9294d.getStringSafe(R.string.GRider_Sug_2020_timeout_1));
                    } else {
                        AddressPresenter.this.m8082a(sugParams3.addressParam, (RpcRecSug) null, AddressPresenter.this.f9294d.getStringSafe(R.string.global_sug_load_fail));
                    }
                    AddressPresenter.getLatestCache().setLastCachedKey(sugParams3.addressParam.addressType, AddressPresenter.f9288i);
                    if (sugParams3.addressParam.addressType == 2) {
                        AddressTrack.trackEndAddressRecList(sugParams3.addressParam, AddressPresenter.this.f9294d.getStartAddressText(), (RpcRecSug) null);
                    }
                }
            }
        });
    }

    public void getSuggestPoiList(SugParams sugParams, String str, boolean z, int i) {
        getSuggestPoiList(sugParams, str, z, i, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8086a(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, AddressParam addressParam, int i) {
        this.f9294d.updateSelectPoiFooters(addressParam.addressType == 1);
        this.f9294d.updateLogoFooters(false, "", 0, 0);
        this.f9294d.updateContentView(addressParam, trackParameterForChild, arrayList, i);
        this.f9294d.showContentView();
        if (arrayList != null && arrayList.size() > 0 && addressParam.addressType == 1) {
            AddressTrack.trackRecListEnter();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8082a(AddressParam addressParam, RpcRecSug rpcRecSug, String str) {
        this.f9294d.showErrorView(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8078a(SugParams sugParams, RpcRecSug rpcRecSug) {
        if (sugParams.showCommonAddress && sugParams.addressParam != null) {
            if (sugParams.addressParam.addressType != 1 && sugParams.addressParam.addressType != 2 && sugParams.addressParam.addressType != 6 && sugParams.addressParam.addressType != 101 && sugParams.addressParam.addressType != 102) {
                return;
            }
            if (rpcRecSug == null || rpcRecSug.company_poi == null || rpcRecSug.home_poi == null) {
                RpcCommon commonAddressCache = this.f9293c.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
                SystemUtils.log(3, "zl-cache", "set common address from cache...> rpcCommonAddress:" + commonAddressCache, (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 238);
                m8084a(commonAddressCache, true);
                return;
            }
            RpcCommon convertToCommon = AddressConvertUtil.convertToCommon(this.f9292b, rpcRecSug);
            this.f9293c.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), convertToCommon);
            m8084a(convertToCommon, true);
        }
    }

    public void getSuggestPoiList(SugParams sugParams, String str, boolean z, int i, boolean z2) {
        SugParams sugParams2 = sugParams;
        String str2 = str;
        if (this.f9294d == null || m8087a()) {
            SystemUtils.log(5, f9287a, "getSuggestPoiList() mView == null || checkRemoved()", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 249);
        } else if (!this.f9294d.isIntendSugRequest(sugParams2.addressParam)) {
            SystemUtils.log(5, f9287a, "getSuggestPoiList() mView != null && !mView.isIntendSugRequest(param)", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 256);
        } else {
            String str3 = z ? "1" : "0";
            if (str2 == null || (this.f9295e.isSame(sugParams2.addressParam.addressType, str2, str3) && !z2)) {
                SystemUtils.log(5, f9287a, "getSuggestPoiList() queryMessage == null || key.isSame(param.addressType, queryMessage, manSearch)", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 262);
                return;
            }
            this.f9294d.showWaittingList();
            this.f9294d.updateTipsInfoHeaderView((RpcRecSug.TipsInfo) null);
            final int i2 = i;
            this.f9294d.updateMapConfirmHeaderView((RpcRecSug.TipsInfo) null, i2);
            m8085a("AddressPresenter getSuggestPoiList()", sugParams2.addressParam);
            this.f9294d.showProgressView();
            sugParams2.addressParam.query = str2;
            sugParams2.addressParam.mansearch = str3;
            final long currentTimeMillis = System.currentTimeMillis();
            this.f9295e.setKey(sugParams2.addressParam.addressType, sugParams2.addressParam.query, sugParams2.addressParam.mansearch);
            ISelectAddressModel iSelectAddressModel = this.f9293c;
            AddressParam addressParam = sugParams2.addressParam;
            final SugParams sugParams3 = sugParams;
            final String str4 = str;
            iSelectAddressModel.getSuggestPoiList(addressParam, new ResultCallback<RpcRecSug>() {
                public void success(RpcRecSug rpcRecSug) {
                    SystemUtils.log(4, AddressPresenter.f9287a, "SugSuccess callback = " + hashCode() + "\n" + rpcRecSug, (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$2", 282);
                    if (AddressPresenter.this.f9294d != null && !AddressPresenter.this.m8087a()) {
                        if (sugParams3.addressParam.addressType == 2) {
                            AddressTrack.setListRequestType(AddressTrack.LIST_REQUEST_TYPE.END_SUG);
                        }
                        if (sugParams3.addressParam.addressType == 1) {
                            AddressTrack.setListRequestType(AddressTrack.LIST_REQUEST_TYPE.START_SUG);
                        }
                        if (rpcRecSug != null && rpcRecSug.result == null && rpcRecSug.rec_poi_list != null) {
                            AddressPresenter.this.m8086a(rpcRecSug.rec_poi_list, rpcRecSug.getTrackParameter(), sugParams3.addressParam, rpcRecSug.tips_info == null ? RpcRecSugInfo.TYPE_DEFAULT : rpcRecSug.tips_info.type);
                            AddressPresenter.this.m8078a(sugParams3, rpcRecSug);
                        } else if (AddressPresenter.this.f9294d.isIntendSugRequest(sugParams3.addressParam)) {
                            AddressPresenter.this.f9294d.showCommonAddressView(false);
                            if (AddressPresenter.this.m8091a(rpcRecSug, sugParams3.addressParam, sugParams3.fromType)) {
                                AddressTrack.trackMapConfirmTipShow(rpcRecSug.tips_info == null ? RpcRecSugInfo.TYPE_DEFAULT : rpcRecSug.tips_info.type, rpcRecSug.search_id, System.currentTimeMillis());
                                AddressPresenter.this.f9294d.updateMapConfirmHeaderView(rpcRecSug.tips_info, sugParams3.addressParam.addressType);
                            } else {
                                AddressPresenter.this.f9294d.updateTipsInfoHeaderView(rpcRecSug != null ? rpcRecSug.tips_info : null);
                            }
                            AddressPresenter.this.f9294d.updateSelectPoiFooters(sugParams3.addressParam.addressType == 1);
                            if (rpcRecSug == null || TextUtils.isEmpty(rpcRecSug.data_provider_logo)) {
                                AddressPresenter.this.f9294d.updateLogoFooters(false, (String) null, 0, 0);
                            } else {
                                AddressPresenter.this.f9294d.updateLogoFooters(true, rpcRecSug.data_provider_logo, rpcRecSug.logosize != null ? rpcRecSug.logosize.width : 185, rpcRecSug.logosize != null ? rpcRecSug.logosize.height : 34);
                            }
                            if (rpcRecSug == null || rpcRecSug.result == null || rpcRecSug.result.size() < 1) {
                                if (rpcRecSug == null) {
                                    AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.service_abnormal);
                                } else {
                                    AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.no_result);
                                }
                                AddressPresenter.this.f9294d.updateMapConfirmHeaderView((RpcRecSug.TipsInfo) null, sugParams3.addressParam.addressType);
                                AddressPresenter.this.f9294d.updateTipsInfoHeaderView((RpcRecSug.TipsInfo) null);
                                AddressPresenter.this.f9294d.showNoSearchView();
                            } else {
                                AddressPresenter.this.f9294d.showContentView();
                                AddressPresenter.this.f9294d.setSugTips(rpcRecSug.tips);
                                AddressPresenter.this.f9294d.updateContentView(sugParams3.addressParam, rpcRecSug.getTrackParameter(), rpcRecSug.result, rpcRecSug.tips_info == null ? RpcRecSugInfo.TYPE_DEFAULT : rpcRecSug.tips_info.type);
                            }
                            AddressTrack.trackSuggestRequest(sugParams3, rpcRecSug, str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), i2);
                            AddressPresenter.getLatestCache().setLastCachedKey(sugParams3.addressParam.addressType, AddressPresenter.f9289j);
                        }
                    }
                }

                public void failure(IOException iOException) {
                    SystemUtils.log(4, AddressPresenter.f9287a, "SugFailed callback = " + hashCode() + "\n" + iOException, (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$2", 348);
                    if (AddressPresenter.this.f9294d != null && !AddressPresenter.this.m8087a() && AddressPresenter.this.f9295e.isSame(sugParams3.addressParam.addressType, sugParams3.addressParam.query, sugParams3.addressParam.mansearch) && AddressPresenter.this.f9294d.isIntendSugRequest(sugParams3.addressParam)) {
                        AddressPresenter.this.f9294d.updateSelectPoiFooters(sugParams3.addressParam.addressType == 1);
                        if (NetUtil.isNetException(iOException)) {
                            AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.network_abnormal);
                        } else {
                            AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.service_abnormal);
                        }
                        if (NetUtil.isNetworkAvailable(AddressPresenter.this.f9292b)) {
                            showFailView(AddressPresenter.this.f9294d.getStringSafe(R.string.GRider_Sug_2020_timeout_1));
                        } else {
                            showFailView(AddressPresenter.this.f9294d.getStringSafe(R.string.global_sug_load_fail));
                        }
                        AddressPresenter.getLatestCache().setLastCachedKey(sugParams3.addressParam.addressType, AddressPresenter.f9289j);
                    }
                }

                private void showFailView(String str) {
                    AddressPresenter.this.f9294d.showErrorView(str);
                }
            });
        }
    }

    public void getGeocodeResult(SugParams sugParams, RpcPoi rpcPoi, String str, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2, int i3, GeoCodeReActor geoCodeReActor) {
        SugParams sugParams2 = sugParams;
        if (!m8087a()) {
            m8085a("AddressPresenter getGeocodeResult()", sugParams2.addressParam);
            IAddressView iAddressView = this.f9294d;
            iAddressView.showProgressDialog(iAddressView.getStringSafe(R.string.global_sug_loading), false);
            ISelectAddressModel iSelectAddressModel = this.f9293c;
            AddressParam addressParam = sugParams2.addressParam;
            final RpcPoi rpcPoi2 = rpcPoi;
            final String str2 = str;
            final SugParams sugParams3 = sugParams;
            final int i4 = i;
            final int i5 = i2;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            final int i6 = i3;
            final GeoCodeReActor geoCodeReActor2 = geoCodeReActor;
            iSelectAddressModel.getGeocodeResult(addressParam, rpcPoi, new ResultCallback<RpcRecSug>() {
                public void success(RpcRecSug rpcRecSug) {
                    if (!AddressPresenter.this.m8087a()) {
                        AddressPresenter.this.f9294d.dismissProgressDialog();
                        if (rpcRecSug == null || rpcRecSug.result == null || rpcRecSug.result.size() < 1) {
                            AddressPresenter.this.f9294d.showToastError(AddressPresenter.this.f9294d.getStringSafe(R.string.global_sug_system_busy));
                            return;
                        }
                        RpcPoi rpcPoi = rpcRecSug.result.get(0);
                        rpcPoi2.base_info.lat = rpcPoi.base_info.lat;
                        rpcPoi2.base_info.lng = rpcPoi.base_info.lng;
                        rpcPoi2.base_info.city_id = rpcPoi.base_info.city_id;
                        rpcPoi2.base_info.city_name = rpcPoi.base_info.city_name;
                        int i = TextUtils.isEmpty(str2) ? 2 : 3;
                        AddressTrack.trackAddressClick(sugParams3, rpcPoi2.base_info, str2, String.valueOf(i4), String.valueOf(i5), trackParameterForChild2, i6, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i);
                        Address convertToAddress = ModelConverter.convertToAddress(rpcPoi2);
                        convertToAddress.operationType = i;
                        GeoCodeReActor geoCodeReActor = geoCodeReActor2;
                        if (geoCodeReActor != null) {
                            geoCodeReActor.onGeoCodeSuccess(sugParams3.addressParam, convertToAddress, rpcPoi2);
                        }
                        AddressPresenter.this.recordClickPoi(sugParams3, rpcPoi2.base_info);
                    }
                }

                public void failure(IOException iOException) {
                    if (!AddressPresenter.this.m8087a()) {
                        AddressPresenter.this.f9294d.dismissProgressDialog();
                        AddressPresenter.this.f9294d.showToastError(AddressPresenter.this.f9294d.getStringSafe(R.string.global_sug_system_busy));
                    }
                }
            });
        }
    }

    public void recordClickPoi(SugParams sugParams, RpcPoiBaseInfo rpcPoiBaseInfo) {
        ISelectAddressModel iSelectAddressModel = this.f9293c;
        if (iSelectAddressModel != null) {
            iSelectAddressModel.recordClickPoi(sugParams.addressParam, rpcPoiBaseInfo);
        }
    }

    /* renamed from: a */
    private void m8084a(RpcCommon rpcCommon, boolean z) {
        this.f9294d.showContentView();
        this.f9294d.showCommonAddressView(z);
        this.f9294d.updateHomeAddress((RpcCommonPoi) null);
        this.f9294d.updateCompanyAddress((RpcCommonPoi) null);
        if (rpcCommon != null && rpcCommon.errno == 0 && rpcCommon.commonAddresses != null && rpcCommon.commonAddresses.size() > 0) {
            Iterator<RpcCommonPoi> it = rpcCommon.commonAddresses.iterator();
            while (it.hasNext()) {
                RpcCommonPoi next = it.next();
                if (next != null && 3 == next.type) {
                    this.f9294d.updateHomeAddress(next);
                } else if (next != null && 4 == next.type) {
                    this.f9294d.updateCompanyAddress(next);
                }
            }
        }
    }

    /* renamed from: a */
    private void m8083a(RpcCommon rpcCommon) {
        m8084a(rpcCommon, true);
    }

    public void setCommonAddress(final SugParams sugParams, final RpcPoi rpcPoi) {
        if (!m8087a()) {
            if (sugParams.addressParam.addressType == 3 || sugParams.addressParam.addressType == 4) {
                IAddressView iAddressView = this.f9294d;
                iAddressView.showProgressDialog(iAddressView.getStringSafe(R.string.global_sug_saving), true);
                this.f9293c.setCommonAddress(sugParams.addressParam, rpcPoi, new ResultCallback<RpcCommon>() {
                    public void success(RpcCommon rpcCommon) {
                        if (!AddressPresenter.this.m8087a()) {
                            AddressPresenter.this.f9294d.dismissProgressDialog();
                            AddressPresenter.this.f9294d.showToastComplete(AddressPresenter.this.f9294d.getStringSafe(R.string.global_sug_edit_success));
                            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
                            convertToAddress.operationType = 0;
                            AddressPresenter.this.f9294d.setResultBack(sugParams.addressParam.addressType, convertToAddress);
                        }
                    }

                    public void failure(IOException iOException) {
                        if (!AddressPresenter.this.m8087a()) {
                            AddressPresenter.this.f9294d.dismissProgressDialog();
                            if (NetUtil.isNetException(iOException)) {
                                AddressPresenter.this.f9294d.showToastError(AddressPresenter.this.f9294d.getStringSafe(R.string.global_sug_check_network));
                            } else {
                                AddressPresenter.this.f9294d.showToastError(AddressPresenter.this.f9294d.getStringSafe(R.string.global_sug_edit_fail));
                            }
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m8091a(RpcRecSug rpcRecSug, AddressParam addressParam, FromType fromType) {
        if (rpcRecSug == null || rpcRecSug.tips_info == null || ((rpcRecSug.tips_info.type != RpcRecSugInfo.TYPE_EMPTY_RESULT && rpcRecSug.tips_info.type != RpcRecSugInfo.TYPE_SIMILAR_SCENE) || CommonUtils.isFromRouteEditor(fromType) || CommonUtils.isFromGetOnPage(fromType) || (addressParam.addressType != 1 && addressParam.addressType != 2))) {
            return false;
        }
        return true;
    }

    private static class LastQueryKey {
        private int _addressType;
        private String _manSearch;
        private String _queryText;

        private LastQueryKey() {
            this._addressType = -1;
        }

        /* access modifiers changed from: private */
        public boolean isSame(int i, String str, String str2) {
            if (this._addressType == i && Objects.equals(this._queryText, str)) {
                return Objects.equals(this._manSearch, str2);
            }
            return false;
        }

        /* access modifiers changed from: private */
        public void setKey(int i, String str, String str2) {
            this._addressType = i;
            this._queryText = str;
            this._manSearch = str2;
        }
    }

    public void startRevertGeo(final SugParams sugParams) {
        if (this.f9298h == null) {
            this.f9298h = new IHttpListener<ReverseGeoResult>() {
                public void onSuccess(ReverseGeoResult reverseGeoResult) {
                    AddressTrack.trackSugLocationCheck(sugParams.addressParam, true);
                    if (AddressPresenter.this.f9297g != null && reverseGeoResult != null && reverseGeoResult.result != null && !reverseGeoResult.result.isEmpty()) {
                        RpcPoi rpcPoi = reverseGeoResult.result.get(0);
                        String string = AddressPresenter.this.f9292b.getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                        if (rpcPoi.base_info.displayname.equals(string)) {
                            sugParams.addressParam.targetAddress.displayName = string;
                            sugParams.addressParam.targetAddress.address = string;
                            sugParams.addressParam.targetAddress.fullName = string;
                        } else {
                            sugParams.addressParam.targetAddress.displayName = rpcPoi.base_info.displayname;
                            sugParams.addressParam.targetAddress.address = rpcPoi.base_info.address;
                            sugParams.addressParam.targetAddress.fullName = rpcPoi.base_info.addressAll;
                        }
                        sugParams.addressParam.targetAddress.latitude = rpcPoi.base_info.lat;
                        sugParams.addressParam.targetAddress.longitude = rpcPoi.base_info.lng;
                        sugParams.addressParam.targetAddress.cityId = rpcPoi.base_info.city_id;
                        sugParams.addressParam.targetAddress.cityName = rpcPoi.base_info.city_name;
                        sugParams.addressParam.targetAddress.countryID = rpcPoi.base_info.countryId;
                        sugParams.addressParam.targetAddress.coordinate_type = rpcPoi.base_info.coordinate_type;
                        sugParams.addressParam.targetAddress.srcTag = rpcPoi.base_info.srctag;
                        if (!(sugParams.wayPointParam == null || sugParams.wayPointParam.getWayPoints() == null || sugParams.wayPointParam.getWayPoints().get(0) == null)) {
                            sugParams.wayPointParam.getWayPoints().get(0).setAddress(sugParams.addressParam.targetAddress);
                        }
                        AddressPresenter.this.f9294d.storeStartAddress(sugParams.addressParam);
                        AddressPresenter.this.f9294d.setStartPoiInfo(sugParams.addressParam);
                    }
                }

                public void onFail(IOException iOException) {
                    AddressTrack.trackSugLocationCheck(sugParams.addressParam, false);
                    if (AddressPresenter.this.f9297g != null) {
                        sugParams.addressParam.targetAddress.displayName = AddressPresenter.this.f9292b.getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                        sugParams.addressParam.targetAddress.latitude = AddressPresenter.this.f9297g.latitude;
                        sugParams.addressParam.targetAddress.longitude = AddressPresenter.this.f9297g.longitude;
                        AddressPresenter.this.f9294d.storeStartAddress(sugParams.addressParam);
                        AddressPresenter.this.f9294d.setStartPoiInfo(sugParams.addressParam);
                    }
                    LatLng unused = AddressPresenter.this.f9297g = null;
                }
            };
        }
        if (CommonUtils.isValidLocation(sugParams.addressParam) && this.f9293c != null) {
            SystemUtils.log(4, "log4", "one request", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 638);
            if (this.f9297g == null) {
                this.f9297g = new LatLng(sugParams.addressParam.currentAddress.latitude, sugParams.addressParam.currentAddress.longitude);
                this.f9293c.getStartPoiInfo(sugParams.addressParam, this.f9298h);
            }
        }
        if (this.f9296f == null) {
            this.f9296f = new DIDILocationListener() {
                public void onLocationError(int i, ErrInfo errInfo) {
                }

                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    if (dIDILocation != null) {
                        SystemUtils.log(4, "log4", "onLocationUpdate", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$6", 650);
                        if (AddressPresenter.this.f9297g == null) {
                            SystemUtils.log(4, "log4", "one one request", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$6", 652);
                            AddressPresenter addressPresenter = AddressPresenter.this;
                            LatLng unused = addressPresenter.f9297g = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                            if (sugParams.addressParam.currentAddress == null) {
                                sugParams.addressParam.currentAddress = new Address();
                            }
                            sugParams.addressParam.currentAddress.latitude = AddressPresenter.this.f9297g.latitude;
                            sugParams.addressParam.currentAddress.longitude = AddressPresenter.this.f9297g.longitude;
                            AddressPresenter.this.f9293c.getStartPoiInfo(sugParams.addressParam, AddressPresenter.this.f9298h);
                        } else if (dIDILocation.getLatitude() != AddressPresenter.this.f9297g.latitude && dIDILocation.getLongitude() != AddressPresenter.this.f9297g.longitude) {
                            float[] fArr = new float[1];
                            Location.distanceBetween(AddressPresenter.this.f9297g.latitude, AddressPresenter.this.f9297g.longitude, dIDILocation.getLatitude(), dIDILocation.getLongitude(), fArr);
                            if (fArr[0] > 30.0f) {
                                SystemUtils.log(4, "log4", "tow request", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$6", 668);
                                AddressPresenter.this.f9297g.latitude = dIDILocation.getLatitude();
                                AddressPresenter.this.f9297g.longitude = dIDILocation.getLongitude();
                                sugParams.addressParam.currentAddress.latitude = AddressPresenter.this.f9297g.latitude;
                                sugParams.addressParam.currentAddress.longitude = AddressPresenter.this.f9297g.longitude;
                                AddressPresenter.this.f9293c.getStartPoiInfo(sugParams.addressParam, AddressPresenter.this.f9298h);
                            }
                        }
                    }
                }
            };
        }
        LocationHelper.registerListener(this.f9292b, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f9296f);
    }

    public void stopRevertGeo() {
        DIDILocationListener dIDILocationListener;
        this.f9297g = null;
        Context context = this.f9292b;
        if (context != null && (dIDILocationListener = this.f9296f) != null) {
            LocationHelper.unRegisterListener(context, dIDILocationListener);
            this.f9296f = null;
        }
    }

    public void fetchStartPoiInfo(final SugParams sugParams) {
        if (!CommonUtils.isValidLocation(sugParams.addressParam)) {
            SystemUtils.log(6, f9287a, "fetchStartPoiInfo() !CommonUtils.isValidLocation(addressParam)", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 710);
        } else if (this.f9292b == null || this.f9294d == null || m8087a()) {
            SystemUtils.log(6, f9287a, "fetchStartPoiInfo() mContext == null || mView == null || checkRemoved()", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 714);
        } else {
            SugDeparturePinNew sugDeparturePinNew = new SugDeparturePinNew();
            this.f9300n = sugDeparturePinNew;
            sugDeparturePinNew.start(this.f9292b, sugParams.addressParam, new BaseDeparture.FetchStartPoiInfoCallback() {
                public /* synthetic */ void onFetchStart() {
                    BaseDeparture.FetchStartPoiInfoCallback.CC.$default$onFetchStart(this);
                }

                public void onFetchSuccess(DepartureAddress departureAddress) {
                    if (AddressPresenter.this.f9294d == null || AddressPresenter.this.f9292b == null || AddressPresenter.this.m8087a()) {
                        SystemUtils.log(6, AddressPresenter.f9287a, "fetchStartPoiInfo() onFetchSuccess() mView == null || checkRemoved()", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$7", 723);
                        return;
                    }
                    if (sugParams.addressParam.targetAddress == null) {
                        SystemUtils.log(6, AddressPresenter.f9287a, "fetchStartPoiInfo() onFetchSuccess() addressParam.targetAddress == null", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$7", 728);
                        sugParams.addressParam.targetAddress = new Address();
                    }
                    Address rgeoResult = departureAddress.getRgeoResult();
                    Address address = departureAddress.getAddress();
                    String string = AddressPresenter.this.f9292b.getResources().getString(R.string.global_sug_current_location);
                    sugParams.addressParam.targetAddress.displayName = string;
                    sugParams.addressParam.targetAddress.address = string;
                    sugParams.addressParam.targetAddress.fullName = string;
                    if (address != null) {
                        sugParams.addressParam.targetAddress = address.clone();
                    } else if (rgeoResult != null) {
                        sugParams.addressParam.targetAddress = rgeoResult.clone();
                    }
                    AddressPresenter.this.f9294d.storeStartAddress(sugParams.addressParam);
                    AddressPresenter.this.f9294d.setStartPoiInfo(sugParams.addressParam);
                    AppFluentOmega.getInstance().stopCalculateTime(AddressPresenter.this.f9292b, (Map) null, 4, (HashMap<String, Object>) null);
                }

                public void onFetchFailed(com.didi.common.map.model.LatLng latLng) {
                    if (AddressPresenter.this.f9294d == null || AddressPresenter.this.m8087a()) {
                        SystemUtils.log(6, AddressPresenter.f9287a, "fetchStartPoiInfo() onFetchFailed() mView == null || checkRemoved()", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$7", 757);
                    } else if (AddressPresenter.this.f9292b == null || latLng == null) {
                        SystemUtils.log(6, AddressPresenter.f9287a, "fetchStartPoiInfo() onFetchFailed() mContext == null || latLng == null", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$7", 762);
                    } else {
                        if (!CommonUtils.isValidLocation(sugParams.addressParam.targetAddress)) {
                            SystemUtils.log(6, AddressPresenter.f9287a, "fetchStartPoiInfo() onFetchFailed() addressParam.targetAddress == null", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$7", 767);
                            sugParams.addressParam.targetAddress = new Address();
                            sugParams.addressParam.targetAddress.displayName = AddressPresenter.this.f9292b.getResources().getString(R.string.global_sug_current_location);
                            sugParams.addressParam.targetAddress.latitude = latLng.latitude;
                            sugParams.addressParam.targetAddress.longitude = latLng.longitude;
                        }
                        AddressPresenter.this.f9294d.storeStartAddress(sugParams.addressParam);
                        AddressPresenter.this.f9294d.setStartPoiInfo(sugParams.addressParam);
                    }
                }
            });
        }
    }

    public void verifyStationAddress(SugParams sugParams, RpcPoi rpcPoi) {
        if (!CommonUtils.isValidLocation(sugParams.addressParam)) {
            SystemUtils.log(6, f9287a, "fetchStartPoiInfo() !CommonUtils.isValidLocation(addressParam)", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 783);
        } else if (rpcPoi != null && rpcPoi.base_info != null) {
            if (this.f9292b == null || this.f9294d == null || m8087a()) {
                SystemUtils.log(6, f9287a, "fetchStartPoiInfo() mContext == null || mView == null || checkRemoved()", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter", 795);
                return;
            }
            SugDeparturePinNew sugDeparturePinNew = new SugDeparturePinNew();
            this.f9300n = sugDeparturePinNew;
            sugDeparturePinNew.startVerifyStationAddress(this.f9292b, sugParams.addressParam, new BaseDeparture.FetchStartPoiInfoCallback() {
                public /* synthetic */ void onFetchFailed(com.didi.common.map.model.LatLng latLng) {
                    BaseDeparture.FetchStartPoiInfoCallback.CC.$default$onFetchFailed(this, latLng);
                }

                public /* synthetic */ void onFetchStart() {
                    BaseDeparture.FetchStartPoiInfoCallback.CC.$default$onFetchStart(this);
                }

                public void onFetchSuccess(DepartureAddress departureAddress) {
                    if (AddressPresenter.this.f9294d == null || AddressPresenter.this.m8087a()) {
                        SystemUtils.log(6, AddressPresenter.f9287a, "fetchStartPoiInfo() onFetchSuccess() mView == null || checkRemoved()", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$8", 805);
                    } else if (AddressPresenter.this.f9292b == null || departureAddress == null || departureAddress.getAddress() == null) {
                        SystemUtils.log(6, AddressPresenter.f9287a, "fetchStartPoiInfo() onFetchSuccess() mContext == null || rpcPoi == null ", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$8", 810);
                    } else if (departureAddress.getGeofenceTags() != null && !departureAddress.getGeofenceTags().isEmpty() && (AddressPresenter.this.f9294d instanceof IStationFetcherView)) {
                        ((IStationFetcherView) AddressPresenter.this.f9294d).switchToStationMapSelect();
                    }
                }
            }, rpcPoi);
        }
    }

    public void stopFetchStartPoiInfo() {
        BaseDeparture baseDeparture = this.f9300n;
        if (baseDeparture != null) {
            baseDeparture.stop();
            this.f9300n = null;
        }
    }

    public void onStop() {
        DIDILocationListener dIDILocationListener;
        Context context = this.f9292b;
        if (context != null && (dIDILocationListener = this.f9296f) != null) {
            LocationHelper.unRegisterListener(context, dIDILocationListener);
        }
    }

    public void onResume() {
        Context context = this.f9292b;
        if (context != null && this.f9296f != null) {
            LocationHelper.registerListener(context, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f9296f);
        }
    }

    private class LatLng {
        public double latitude;
        public double longitude;

        public LatLng(double d, double d2) {
            this.latitude = d;
            this.longitude = d2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LatLng)) {
                return false;
            }
            LatLng latLng = (LatLng) obj;
            if (Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude)) {
                return true;
            }
            return false;
        }
    }

    public static LastCachedKey getLatestCache() {
        return LastCachedKey.mLastCachedKey;
    }

    public static boolean isLastCachedRecommendCache(int i) {
        return getLatestCache().isLastCacheRecommendCache(i);
    }

    public static int getLastAddressType() {
        return getLatestCache().getLastAddressType();
    }

    public void processDataRequire(SugParams sugParams, String str, boolean z, int i) {
        if (TextUtils.isEmpty(str)) {
            getRecommendPoiList(sugParams, z, i);
        } else {
            getSuggestPoiList(sugParams, str, z, i);
        }
    }

    private static class LastCachedKey {
        /* access modifiers changed from: private */
        public static final LastCachedKey mLastCachedKey = new LastCachedKey();
        private static int sLastAddressType = 2;
        private String sEndkey = "";
        private String sStartkey = "";

        private LastCachedKey() {
        }

        /* access modifiers changed from: private */
        public void setLastCachedKey(int i, String str) {
            sLastAddressType = i;
            String str2 = str + i;
            SystemUtils.log(2, AddressPresenter.f9287a, "cst (" + this.sEndkey + "," + this.sStartkey + "," + i + "," + str2 + ")", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$LastCachedKey", 935);
            if (i == 1) {
                this.sStartkey = str2;
            } else if (i == 2) {
                this.sEndkey = str2;
            } else {
                SystemUtils.log(6, AddressPresenter.f9287a, "kyset wrong (" + str2 + "," + i + ")", (Throwable) null, "com.didi.addressnew.presenter.AddressPresenter$LastCachedKey", 942);
            }
        }

        /* access modifiers changed from: private */
        public boolean isLastCacheRecommendCache(int i) {
            if (i == 2) {
                return this.sEndkey.startsWith(AddressPresenter.f9288i);
            }
            if (i == 1) {
                return this.sStartkey.startsWith(AddressPresenter.f9288i);
            }
            return false;
        }

        /* access modifiers changed from: private */
        public int getLastAddressType() {
            return sLastAddressType;
        }
    }
}
