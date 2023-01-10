package com.didi.addressold.presenter;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.didi.address.model.SugParams;
import com.didi.addressold.model.ISelectAddressModel;
import com.didi.addressold.model.SelectAddressModel;
import com.didi.addressold.util.AddressConvertUtil;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.util.CheckParamUtil;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.util.NetUtil;
import com.didi.addressold.view.IAddressView;
import com.didi.addressold.view.SugDeparturePin;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.model.location.LocationHelper;
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
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class AddressPresenter implements IAddressPresenter {

    /* renamed from: a */
    private static final String f9598a = "AddressPresenter";

    /* renamed from: j */
    private static final String f9599j = "RECOMMEND_RPC";

    /* renamed from: k */
    private static final String f9600k = "SUGGESTION_RPC";

    /* renamed from: b */
    private boolean f9601b = true;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Context f9602c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ISelectAddressModel f9603d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IAddressView f9604e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final LastQueryKey f9605f;

    /* renamed from: g */
    private DIDILocationListener f9606g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public LatLng f9607h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IHttpListener<ReverseGeoResult> f9608i;

    /* renamed from: l */
    private SugDeparturePin f9609l;

    public void uploadPoi(SugParams sugParams, RpcPoi rpcPoi) {
    }

    public AddressPresenter(Context context, IAddressView iAddressView) {
        this.f9602c = context;
        this.f9603d = new SelectAddressModel(context);
        this.f9604e = iAddressView;
        this.f9605f = new LastQueryKey();
        boolean unused = LastCachedKey.isLastEndAddrSugFailed = false;
    }

    public void onLogout(SugParams sugParams) {
        this.f9603d.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), (RpcCommon) null);
        m8326a((RpcCommon) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m8331a() {
        IAddressView iAddressView = this.f9604e;
        return iAddressView == null || iAddressView.isSugFragmentRemoved();
    }

    /* renamed from: a */
    private void m8328a(String str, AddressParam addressParam) {
        if (this.f9602c != null) {
            if (addressParam == null || !CommonUtils.isValidLocation(addressParam.currentAddress) || !CommonUtils.isValidLocation(addressParam.targetAddress)) {
                CheckParamUtil.rescueAddressParam(this.f9602c.getApplicationContext(), str, addressParam);
            }
        }
    }

    public void getRecommendPoiList(SugParams sugParams, boolean z, int i) {
        SugParams sugParams2 = sugParams;
        if (this.f9604e == null || m8331a()) {
            SystemUtils.log(5, f9598a, "getRecommendPoiList() mView == null || ", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 102);
            return;
        }
        String str = z ? "1" : "0";
        if (this.f9605f.isSame(sugParams2.addressParam.addressType, "", str)) {
            SystemUtils.log(5, f9598a, "getRecommendPoiList() key.isSame(param.addressType, \"\", manSearch)", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 108);
        }
        m8328a("AddressPresenter getRecommendPoiList()", sugParams2.addressParam);
        sugParams2.addressParam.query = "";
        sugParams2.addressParam.mansearch = str;
        this.f9604e.showProgressView();
        this.f9604e.setSugTips("");
        IAddressView iAddressView = this.f9604e;
        boolean z2 = true;
        if (sugParams2.addressParam.addressType == 1) {
            z2 = this.f9601b;
        }
        iAddressView.showCommonAddressView(z2);
        this.f9604e.updateTipsInfoHeaderView((RpcRecSug.TipsInfo) null);
        m8330a(sugParams2.showCommonAddress, sugParams2.addressParam, (RpcRecSug) null);
        final long currentTimeMillis = System.currentTimeMillis();
        this.f9605f.setKey(sugParams2.addressParam.addressType, sugParams2.addressParam.query, sugParams2.addressParam.mansearch);
        ISelectAddressModel iSelectAddressModel = this.f9603d;
        AddressParam addressParam = sugParams2.addressParam;
        final SugParams sugParams3 = sugParams;
        final int i2 = i;
        iSelectAddressModel.getRecommendPoiList(addressParam, new ResultCallback<RpcRecSug>() {
            public void success(RpcRecSug rpcRecSug) {
                if (!AddressPresenter.this.m8331a() && AddressPresenter.this.f9605f.isSame(sugParams3.addressParam.addressType, sugParams3.addressParam.query, sugParams3.addressParam.mansearch)) {
                    if (rpcRecSug == null || rpcRecSug.errno != 0) {
                        AddressTrack.trackError(sugParams3.addressParam, false, AddressTrack.ErrorType.service_abnormal);
                        AddressPresenter.getLatestCache().setLastCachedRpc(sugParams3.addressParam.addressType, (RpcRecSug) null, AddressPresenter.f9599j, (String) null);
                        AddressPresenter.this.f9604e.showErrorView(rpcRecSug != null ? rpcRecSug.errmsg : "");
                    } else {
                        AddressTrack.trackRecommendRequest(sugParams3, rpcRecSug, String.valueOf(System.currentTimeMillis() - currentTimeMillis), i2);
                        AddressPresenter.this.m8329a(rpcRecSug.rec_poi_list, rpcRecSug.getTrackParameter(), sugParams3.addressParam);
                        AddressPresenter.this.m8330a(sugParams3.showCommonAddress, sugParams3.addressParam, rpcRecSug);
                        AddressPresenter.getLatestCache().setLastCachedRpc(sugParams3.addressParam.addressType, rpcRecSug, AddressPresenter.f9599j, (String) null);
                    }
                    AddressTrack.trackFirstTimeRecList(sugParams3.addressParam, AddressPresenter.this.f9604e.getStartAddressText(), rpcRecSug);
                }
            }

            public void failure(IOException iOException) {
                if (!AddressPresenter.this.m8331a() && AddressPresenter.this.f9605f.isSame(sugParams3.addressParam.addressType, sugParams3.addressParam.query, sugParams3.addressParam.mansearch)) {
                    if (NetUtil.isNetException(iOException)) {
                        AddressTrack.trackError(sugParams3.addressParam, false, AddressTrack.ErrorType.network_abnormal);
                        AddressPresenter.this.m8325a(sugParams3.addressParam, (RpcRecSug) null, AddressPresenter.this.f9604e.getString(R.string.global_sug_check_network));
                    } else {
                        AddressTrack.trackError(sugParams3.addressParam, false, AddressTrack.ErrorType.service_abnormal);
                        AddressPresenter.this.m8325a(sugParams3.addressParam, (RpcRecSug) null, AddressPresenter.this.f9604e.getString(R.string.global_sug_load_fail));
                    }
                    AddressPresenter.getLatestCache().setLastCachedRpc(sugParams3.addressParam.addressType, (RpcRecSug) null, AddressPresenter.f9599j, (String) null);
                    AddressTrack.trackFirstTimeRecList(sugParams3.addressParam, AddressPresenter.this.f9604e.getStartAddressText(), (RpcRecSug) null);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8329a(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, AddressParam addressParam) {
        this.f9604e.updateSelectPoiFooters(addressParam.addressType == 1);
        this.f9604e.updateLogoFooters(false, "", 0, 0);
        this.f9604e.updateContentView(addressParam, trackParameterForChild, arrayList);
        if (arrayList == null || arrayList.size() < 1) {
            this.f9604e.showErrorView("");
            return;
        }
        this.f9604e.showContentView();
        if (addressParam.addressType == 1) {
            AddressTrack.trackRecListEnter();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8325a(AddressParam addressParam, RpcRecSug rpcRecSug, String str) {
        this.f9604e.showErrorView(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8330a(boolean z, AddressParam addressParam, RpcRecSug rpcRecSug) {
        if (z) {
            boolean z2 = true;
            if (addressParam.addressType != 1 && addressParam.addressType != 2) {
                return;
            }
            if (rpcRecSug == null || rpcRecSug.company_poi == null || rpcRecSug.home_poi == null) {
                RpcCommon commonAddressCache = this.f9603d.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
                SystemUtils.log(3, "zl-cache", "set common address from cache...> rpcCommonAddress:" + commonAddressCache, (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 210);
                if (addressParam.addressType == 1) {
                    z2 = this.f9601b;
                }
                m8327a(commonAddressCache, z2);
                return;
            }
            RpcCommon convertToCommon = AddressConvertUtil.convertToCommon(this.f9602c, rpcRecSug);
            this.f9603d.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), convertToCommon);
            if (addressParam.addressType == 1) {
                z2 = this.f9601b;
            }
            m8327a(convertToCommon, z2);
        }
    }

    public void getSuggestPoiList(SugParams sugParams, String str, boolean z, int i) {
        SugParams sugParams2 = sugParams;
        String str2 = str;
        if (this.f9604e == null || m8331a()) {
            SystemUtils.log(5, f9598a, "getSuggestPoiList() mView == null || checkRemoved()", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 221);
        } else if (!this.f9604e.isIntendSugRequest(sugParams2.addressParam)) {
            SystemUtils.log(5, f9598a, "getSuggestPoiList() mView != null && !mView.isIntendSugRequest(param)", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 228);
        } else {
            String str3 = z ? "1" : "0";
            if (str2 == null || this.f9605f.isSame(sugParams2.addressParam.addressType, str2, str3)) {
                SystemUtils.log(5, f9598a, "getSuggestPoiList() queryMessage == null || key.isSame(param.addressType, queryMessage, manSearch)", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 234);
                return;
            }
            m8328a("AddressPresenter getSuggestPoiList()", sugParams2.addressParam);
            this.f9604e.showProgressView();
            sugParams2.addressParam.query = str2;
            sugParams2.addressParam.mansearch = str3;
            final long currentTimeMillis = System.currentTimeMillis();
            this.f9605f.setKey(sugParams2.addressParam.addressType, sugParams2.addressParam.query, sugParams2.addressParam.mansearch);
            ISelectAddressModel iSelectAddressModel = this.f9603d;
            AddressParam addressParam = sugParams2.addressParam;
            final SugParams sugParams3 = sugParams;
            final String str4 = str;
            final int i2 = i;
            iSelectAddressModel.getSuggestPoiList(addressParam, new ResultCallback<RpcRecSug>() {
                public void success(RpcRecSug rpcRecSug) {
                    if (AddressPresenter.this.f9604e != null && !AddressPresenter.this.m8331a() && AddressPresenter.this.f9605f.isSame(sugParams3.addressParam.addressType, sugParams3.addressParam.query, sugParams3.addressParam.mansearch) && AddressPresenter.this.f9604e.isIntendSugRequest(sugParams3.addressParam)) {
                        if (rpcRecSug == null || rpcRecSug.result != null || rpcRecSug.rec_poi_list == null) {
                            AddressPresenter.this.f9604e.showCommonAddressView(false);
                            AddressPresenter.this.f9604e.updateTipsInfoHeaderView(rpcRecSug != null ? rpcRecSug.tips_info : null);
                            AddressPresenter.this.f9604e.updateSelectPoiFooters(sugParams3.addressParam.addressType == 1);
                            if (rpcRecSug == null || TextUtils.isEmpty(rpcRecSug.data_provider_logo) || rpcRecSug.logosize == null) {
                                AddressPresenter.this.f9604e.updateLogoFooters(false, (String) null, 0, 0);
                            } else {
                                AddressPresenter.this.f9604e.updateLogoFooters(true, rpcRecSug.data_provider_logo, rpcRecSug.logosize.width, rpcRecSug.logosize.height);
                            }
                            if (rpcRecSug == null || rpcRecSug.result == null || rpcRecSug.result.size() < 1) {
                                if (rpcRecSug == null) {
                                    AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.service_abnormal);
                                } else {
                                    AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.no_result);
                                }
                                AddressPresenter.this.f9604e.showNoSearchView();
                                AddressPresenter.getLatestCache().setLastCachedRpc(sugParams3.addressParam.addressType, (RpcRecSug) null, AddressPresenter.f9600k, str4);
                                return;
                            }
                            AddressTrack.trackSuggestRequest(sugParams3, rpcRecSug, str4, String.valueOf(System.currentTimeMillis() - currentTimeMillis), i2);
                            AddressPresenter.this.f9604e.showContentView();
                            AddressPresenter.this.f9604e.setSugTips(rpcRecSug.tips);
                            AddressPresenter.this.f9604e.updateContentView(sugParams3.addressParam, rpcRecSug.getTrackParameter(), rpcRecSug.result);
                            AddressPresenter.getLatestCache().setLastCachedRpc(sugParams3.addressParam.addressType, rpcRecSug, AddressPresenter.f9600k, str4);
                            return;
                        }
                        AddressPresenter.this.m8329a(rpcRecSug.rec_poi_list, rpcRecSug.getTrackParameter(), sugParams3.addressParam);
                        AddressPresenter.this.m8330a(sugParams3.showCommonAddress, sugParams3.addressParam, rpcRecSug);
                    }
                }

                public void failure(IOException iOException) {
                    if (AddressPresenter.this.f9604e != null && !AddressPresenter.this.m8331a() && AddressPresenter.this.f9605f.isSame(sugParams3.addressParam.addressType, sugParams3.addressParam.query, sugParams3.addressParam.mansearch) && AddressPresenter.this.f9604e.isIntendSugRequest(sugParams3.addressParam)) {
                        AddressPresenter.this.f9604e.updateSelectPoiFooters(sugParams3.addressParam.addressType == 1);
                        if (NetUtil.isNetException(iOException)) {
                            AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.network_abnormal);
                            showFailView(AddressPresenter.this.f9604e.getString(R.string.global_sug_check_network));
                        } else {
                            AddressTrack.trackError(sugParams3.addressParam, true, AddressTrack.ErrorType.service_abnormal);
                            showFailView(AddressPresenter.this.f9604e.getString(R.string.global_sug_load_fail));
                        }
                        AddressPresenter.getLatestCache().setLastCachedRpc(sugParams3.addressParam.addressType, (RpcRecSug) null, AddressPresenter.f9600k, str4);
                    }
                }

                private void showFailView(String str) {
                    AddressPresenter.this.f9604e.showErrorView(str);
                }
            });
        }
    }

    public void getGeocodeResult(SugParams sugParams, RpcPoi rpcPoi, String str, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2, int i3) {
        SugParams sugParams2 = sugParams;
        if (!m8331a()) {
            m8328a("AddressPresenter getGeocodeResult()", sugParams2.addressParam);
            IAddressView iAddressView = this.f9604e;
            iAddressView.showProgressDialog(iAddressView.getString(R.string.global_sug_loading), false);
            ISelectAddressModel iSelectAddressModel = this.f9603d;
            AddressParam addressParam = sugParams2.addressParam;
            final RpcPoi rpcPoi2 = rpcPoi;
            final SugParams sugParams3 = sugParams;
            final String str2 = str;
            final int i4 = i;
            final int i5 = i2;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            final int i6 = i3;
            RpcPoi rpcPoi3 = rpcPoi;
            iSelectAddressModel.getGeocodeResult(addressParam, rpcPoi, new ResultCallback<RpcRecSug>() {
                public void success(RpcRecSug rpcRecSug) {
                    if (!AddressPresenter.this.m8331a()) {
                        AddressPresenter.this.f9604e.dismissProgressDialog();
                        if (rpcRecSug == null || rpcRecSug.result == null || rpcRecSug.result.size() < 1) {
                            AddressPresenter.this.f9604e.showToastError(AddressPresenter.this.f9604e.getString(R.string.global_sug_system_busy));
                            return;
                        }
                        RpcPoi rpcPoi = rpcRecSug.result.get(0);
                        rpcPoi2.base_info.lat = rpcPoi.base_info.lat;
                        rpcPoi2.base_info.lng = rpcPoi.base_info.lng;
                        rpcPoi2.base_info.city_id = rpcPoi.base_info.city_id;
                        rpcPoi2.base_info.city_name = rpcPoi.base_info.city_name;
                        AddressTrack.trackAddressClick(sugParams3, rpcPoi2.base_info, str2, String.valueOf(i4), String.valueOf(i5), trackParameterForChild2, i6);
                        int i = 3;
                        if (sugParams3.addressParam.addressType == 3 || sugParams3.addressParam.addressType == 4) {
                            AddressPresenter.this.setCommonAddress(sugParams3, rpcPoi2);
                        } else {
                            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi2);
                            if (TextUtils.isEmpty(str2)) {
                                i = 2;
                            }
                            convertToAddress.operationType = i;
                            AddressPresenter.this.f9604e.setResultBack(sugParams3.addressParam.addressType, convertToAddress);
                        }
                        AddressPresenter.this.recordClickPoi(sugParams3, rpcPoi2.base_info);
                    }
                }

                public void failure(IOException iOException) {
                    if (!AddressPresenter.this.m8331a()) {
                        AddressPresenter.this.f9604e.dismissProgressDialog();
                        AddressPresenter.this.f9604e.showToastError(AddressPresenter.this.f9604e.getString(R.string.global_sug_system_busy));
                    }
                }
            });
        }
    }

    public void recordClickPoi(SugParams sugParams, RpcPoiBaseInfo rpcPoiBaseInfo) {
        if (this.f9603d != null && sugParams != null && sugParams.addressParam != null) {
            this.f9603d.recordClickPoi(sugParams.addressParam, rpcPoiBaseInfo);
        }
    }

    /* renamed from: a */
    private void m8327a(RpcCommon rpcCommon, boolean z) {
        this.f9604e.showContentView();
        this.f9604e.showCommonAddressView(z);
        this.f9604e.updateHomeAddress((RpcCommonPoi) null);
        this.f9604e.updateCompanyAddress((RpcCommonPoi) null);
        if (rpcCommon != null && rpcCommon.errno == 0 && rpcCommon.commonAddresses != null && rpcCommon.commonAddresses.size() > 0) {
            Iterator<RpcCommonPoi> it = rpcCommon.commonAddresses.iterator();
            while (it.hasNext()) {
                RpcCommonPoi next = it.next();
                if (next != null && 3 == next.type) {
                    this.f9604e.updateHomeAddress(next);
                } else if (next != null && 4 == next.type) {
                    this.f9604e.updateCompanyAddress(next);
                }
            }
        }
    }

    /* renamed from: a */
    private void m8326a(RpcCommon rpcCommon) {
        m8327a(rpcCommon, true);
    }

    public void setCommonAddress(final SugParams sugParams, final RpcPoi rpcPoi) {
        if (!m8331a() && sugParams != null && sugParams.addressParam != null) {
            if (sugParams.addressParam.addressType == 3 || sugParams.addressParam.addressType == 4) {
                IAddressView iAddressView = this.f9604e;
                iAddressView.showProgressDialog(iAddressView.getString(R.string.global_sug_saving), true);
                this.f9603d.setCommonAddress(sugParams.addressParam, rpcPoi, new ResultCallback<RpcCommon>() {
                    public void success(RpcCommon rpcCommon) {
                        if (!AddressPresenter.this.m8331a()) {
                            AddressPresenter.this.f9604e.dismissProgressDialog();
                            AddressPresenter.this.f9604e.showToastComplete(AddressPresenter.this.f9604e.getString(R.string.global_sug_edit_success));
                            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
                            convertToAddress.operationType = 0;
                            AddressPresenter.getLatestCache().updateCachedRecCommenRpc(sugParams.addressParam.addressType, rpcPoi);
                            AddressPresenter.this.f9604e.setResultBack(sugParams.addressParam.addressType, convertToAddress);
                        }
                    }

                    public void failure(IOException iOException) {
                        if (!AddressPresenter.this.m8331a()) {
                            AddressPresenter.this.f9604e.dismissProgressDialog();
                            if (NetUtil.isNetException(iOException)) {
                                AddressPresenter.this.f9604e.showToastError(AddressPresenter.this.f9604e.getString(R.string.global_sug_check_network));
                            } else {
                                AddressPresenter.this.f9604e.showToastError(AddressPresenter.this.f9604e.getString(R.string.global_sug_edit_fail));
                            }
                        }
                    }
                });
            }
        }
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
        if (this.f9608i == null) {
            this.f9608i = new IHttpListener<ReverseGeoResult>() {
                public void onSuccess(ReverseGeoResult reverseGeoResult) {
                    AddressTrack.trackSugLocationCheck(sugParams.addressParam, true);
                    if (AddressPresenter.this.f9607h != null && reverseGeoResult != null && reverseGeoResult.result != null && !reverseGeoResult.result.isEmpty()) {
                        RpcPoi rpcPoi = reverseGeoResult.result.get(0);
                        String string = AddressPresenter.this.f9602c.getResources().getString(R.string.global_sug_current_location);
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
                        AddressPresenter.this.f9604e.storeStartAddress(sugParams.addressParam);
                        AddressPresenter.this.f9604e.setStartPoiInfo(sugParams);
                    }
                }

                public void onFail(IOException iOException) {
                    AddressTrack.trackSugLocationCheck(sugParams.addressParam, false);
                    if (AddressPresenter.this.f9603d.getStartPoiInfoFromCache(sugParams.addressParam.targetAddress) == null) {
                        if (AddressPresenter.this.f9607h != null) {
                            sugParams.addressParam.targetAddress.displayName = AddressPresenter.this.f9602c.getResources().getString(R.string.global_sug_current_location);
                            sugParams.addressParam.targetAddress.latitude = AddressPresenter.this.f9607h.latitude;
                            sugParams.addressParam.targetAddress.longitude = AddressPresenter.this.f9607h.longitude;
                            AddressPresenter.this.f9604e.storeStartAddress(sugParams.addressParam);
                            AddressPresenter.this.f9604e.setStartPoiInfo(sugParams);
                        }
                        LatLng unused = AddressPresenter.this.f9607h = null;
                    }
                }
            };
        }
        if (CommonUtils.isValidLocation(sugParams.addressParam) && this.f9603d != null) {
            SystemUtils.log(4, "log4", "one request", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 571);
            if (this.f9607h == null) {
                this.f9607h = new LatLng(sugParams.addressParam.currentAddress.latitude, sugParams.addressParam.currentAddress.longitude);
                this.f9603d.getStartPoiInfo(sugParams.addressParam, this.f9608i);
            }
        }
        if (this.f9606g == null) {
            this.f9606g = new DIDILocationListener() {
                public void onLocationError(int i, ErrInfo errInfo) {
                }

                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    if (dIDILocation != null) {
                        SystemUtils.log(4, "log4", "onLocationUpdate", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$6", 583);
                        if (AddressPresenter.this.f9607h == null) {
                            SystemUtils.log(4, "log4", "one one request", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$6", 585);
                            AddressPresenter addressPresenter = AddressPresenter.this;
                            LatLng unused = addressPresenter.f9607h = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                            if (sugParams.addressParam.currentAddress == null) {
                                sugParams.addressParam.currentAddress = new Address();
                            }
                            sugParams.addressParam.currentAddress.latitude = AddressPresenter.this.f9607h.latitude;
                            sugParams.addressParam.currentAddress.longitude = AddressPresenter.this.f9607h.longitude;
                            AddressPresenter.this.f9603d.getStartPoiInfo(sugParams.addressParam, AddressPresenter.this.f9608i);
                        } else if (dIDILocation.getLatitude() != AddressPresenter.this.f9607h.latitude && dIDILocation.getLongitude() != AddressPresenter.this.f9607h.longitude) {
                            float[] fArr = new float[1];
                            Location.distanceBetween(AddressPresenter.this.f9607h.latitude, AddressPresenter.this.f9607h.longitude, dIDILocation.getLatitude(), dIDILocation.getLongitude(), fArr);
                            if (fArr[0] > 30.0f) {
                                SystemUtils.log(4, "log4", "tow request", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$6", 601);
                                AddressPresenter.this.f9607h.latitude = dIDILocation.getLatitude();
                                AddressPresenter.this.f9607h.longitude = dIDILocation.getLongitude();
                                sugParams.addressParam.currentAddress.latitude = AddressPresenter.this.f9607h.latitude;
                                sugParams.addressParam.currentAddress.longitude = AddressPresenter.this.f9607h.longitude;
                                AddressPresenter.this.f9603d.getStartPoiInfo(sugParams.addressParam, AddressPresenter.this.f9608i);
                            }
                        }
                    }
                }
            };
        }
        LocationHelper.registerListener(this.f9602c, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f9606g);
    }

    public void stopRevertGeo() {
        this.f9607h = null;
        DIDILocationListener dIDILocationListener = this.f9606g;
        if (dIDILocationListener != null) {
            LocationHelper.unRegisterListener(this.f9602c, dIDILocationListener);
            this.f9606g = null;
        }
    }

    public void fetchStartPoiInfo(final SugParams sugParams) {
        if (!CommonUtils.isValidLocation(sugParams.addressParam)) {
            SystemUtils.log(6, f9598a, "fetchStartPoiInfo() !CommonUtils.isValidLocation(addressParam)", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 643);
        } else if (this.f9602c == null || this.f9604e == null || m8331a()) {
            SystemUtils.log(6, f9598a, "fetchStartPoiInfo() mContext == null || mView == null || checkRemoved()", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 648);
        } else {
            if (this.f9609l == null) {
                this.f9609l = new SugDeparturePin();
            }
            this.f9609l.start(this.f9602c, sugParams.addressParam, new SugDeparturePin.FetchStartPoiInfoCallback() {
                public void onFetchStart() {
                }

                public void onFetchSuccess(DepartureAddress departureAddress) {
                    if (AddressPresenter.this.f9604e == null || AddressPresenter.this.f9602c == null || AddressPresenter.this.m8331a()) {
                        SystemUtils.log(6, AddressPresenter.f9598a, "fetchStartPoiInfo() onFetchSuccess() mView == null || checkRemoved()", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$7", 665);
                        return;
                    }
                    if (sugParams.addressParam.targetAddress == null) {
                        SystemUtils.log(6, AddressPresenter.f9598a, "fetchStartPoiInfo() onFetchSuccess() addressParam.targetAddress == null", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$7", 670);
                        sugParams.addressParam.targetAddress = new Address();
                    }
                    Address rgeoResult = departureAddress.getRgeoResult();
                    Address address = departureAddress.getAddress();
                    if (address != null) {
                        sugParams.addressParam.targetAddress.displayName = address.getDisplayName();
                        sugParams.addressParam.targetAddress.address = address.getAddress();
                        sugParams.addressParam.targetAddress.fullName = address.getFullName();
                    } else if (rgeoResult != null) {
                        sugParams.addressParam.targetAddress.displayName = rgeoResult.getDisplayName();
                        sugParams.addressParam.targetAddress.address = rgeoResult.getAddress();
                        sugParams.addressParam.targetAddress.fullName = rgeoResult.getFullName();
                    } else {
                        String string = AddressPresenter.this.f9602c.getResources().getString(R.string.global_sug_current_location);
                        sugParams.addressParam.targetAddress.displayName = string;
                        sugParams.addressParam.targetAddress.address = string;
                        sugParams.addressParam.targetAddress.fullName = string;
                    }
                    if (address != null) {
                        sugParams.addressParam.targetAddress.latitude = address.getLatitude();
                        sugParams.addressParam.targetAddress.longitude = address.getLongitude();
                        sugParams.addressParam.targetAddress.cityId = address.getCityId();
                        sugParams.addressParam.targetAddress.cityName = address.getCityName();
                        sugParams.addressParam.targetAddress.countryID = address.countryID;
                        sugParams.addressParam.targetAddress.operationType = 0;
                        sugParams.addressParam.targetAddress.poiId = address.poiId;
                    } else if (rgeoResult != null) {
                        sugParams.addressParam.targetAddress.latitude = rgeoResult.getLatitude();
                        sugParams.addressParam.targetAddress.longitude = rgeoResult.getLongitude();
                        sugParams.addressParam.targetAddress.cityId = rgeoResult.getCityId();
                        sugParams.addressParam.targetAddress.cityName = rgeoResult.getCityName();
                        sugParams.addressParam.targetAddress.countryID = rgeoResult.countryID;
                        sugParams.addressParam.targetAddress.operationType = 0;
                        sugParams.addressParam.targetAddress.poiId = rgeoResult.poiId;
                    }
                    AddressPresenter.this.f9604e.storeStartAddress(sugParams.addressParam);
                    AddressPresenter.this.f9604e.setStartPoiInfo(sugParams);
                }

                public void onFetchFailed(com.didi.common.map.model.LatLng latLng) {
                    if (AddressPresenter.this.f9604e == null || AddressPresenter.this.m8331a()) {
                        SystemUtils.log(6, AddressPresenter.f9598a, "fetchStartPoiInfo() onFetchFailed() mView == null || checkRemoved()", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$7", 718);
                    } else if (AddressPresenter.this.f9602c == null || latLng == null) {
                        SystemUtils.log(6, AddressPresenter.f9598a, "fetchStartPoiInfo() onFetchFailed() mContext == null || latLng == null", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$7", 723);
                    } else {
                        if (sugParams.addressParam.targetAddress == null) {
                            SystemUtils.log(6, AddressPresenter.f9598a, "fetchStartPoiInfo() onFetchFailed() sugParams.addressParam.targetAddress == null", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$7", 728);
                            sugParams.addressParam.targetAddress = new Address();
                            sugParams.addressParam.targetAddress.displayName = AddressPresenter.this.f9602c.getResources().getString(R.string.global_sug_current_location);
                            sugParams.addressParam.targetAddress.latitude = latLng.latitude;
                            sugParams.addressParam.targetAddress.longitude = latLng.longitude;
                        }
                        AddressPresenter.this.f9604e.storeStartAddress(sugParams.addressParam);
                        AddressPresenter.this.f9604e.setStartPoiInfo(sugParams);
                    }
                }
            });
        }
    }

    public void stopFetchStartPoiInfo() {
        SugDeparturePin sugDeparturePin = this.f9609l;
        if (sugDeparturePin != null) {
            sugDeparturePin.stop();
            this.f9609l = null;
        }
    }

    public Address getStartPoiFromCache(Address address) {
        return this.f9603d.getStartPoiInfoFromCache(address);
    }

    public void cacheStartPoiInfo(Address address) {
        this.f9603d.cacheStartPoiInfo(address);
    }

    public void onStop() {
        DIDILocationListener dIDILocationListener;
        Context context = this.f9602c;
        if (context != null && (dIDILocationListener = this.f9606g) != null) {
            LocationHelper.unRegisterListener(context, dIDILocationListener);
        }
    }

    public void onResume() {
        Context context = this.f9602c;
        if (context != null && this.f9606g != null) {
            LocationHelper.registerListener(context, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f9606g);
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

    public static boolean isQueryEverEdited() {
        return getLatestCache().isTextCacheSettedEver;
    }

    public static void clearAllCache() {
        getLatestCache().clearAllCachedRpc();
    }

    public static boolean isLastCachedRecommendCache(int i) {
        return getLatestCache().isLastCacheRecommendCache(i);
    }

    public static boolean isLastEndAddrSugFailed() {
        return LastCachedKey.isLastEndAddrSugFailed;
    }

    public static String getLastCachedQuery(int i) {
        return getLatestCache().getLastCachedText(i);
    }

    public void processDataRequire(SugParams sugParams, String str, boolean z, int i) {
        SystemUtils.log(2, f9598a, "process eky=" + getLatestCache().sEndkey + ",sky=" + getLatestCache().sStartkey + ",qmsg = " + str + ",sbt = " + z + ",cradt = " + i, (Throwable) null, "com.didi.addressold.presenter.AddressPresenter", 860);
        if (TextUtils.isEmpty(str)) {
            getRecommendPoiList(sugParams, z, i);
        } else {
            getSuggestPoiList(sugParams, str, z, i);
        }
    }

    private static class LastCachedKey {
        /* access modifiers changed from: private */
        public static boolean isLastEndAddrSugFailed = false;
        private static final boolean isNeedCache = false;
        /* access modifiers changed from: private */
        public static final LastCachedKey mLastCachedKey = new LastCachedKey();
        /* access modifiers changed from: private */
        public boolean isTextCacheSettedEver = false;
        private HashMap<String, RpcRecSug> mRpcCache = new HashMap<>(4);
        private final HashMap<String, String> mTextCache = new HashMap<>(2);
        /* access modifiers changed from: private */
        public String sEndkey = "";
        /* access modifiers changed from: private */
        public String sStartkey = "";

        private LastCachedKey() {
        }

        private void setLastCachedKey(int i, String str) {
            SystemUtils.log(2, AddressPresenter.f9598a, "kyset e =" + this.sEndkey + ",s =" + this.sStartkey, (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$LastCachedKey", 986);
            if (i == 1) {
                this.sStartkey = str;
            } else if (i == 2) {
                this.sEndkey = str;
            } else {
                SystemUtils.log(6, AddressPresenter.f9598a, "kyset wrong (" + str + "," + i + ")", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$LastCachedKey", 994);
            }
        }

        /* access modifiers changed from: private */
        public boolean isLastCacheRecommendCache(int i) {
            if (i == 2) {
                return this.sEndkey.startsWith(AddressPresenter.f9599j);
            }
            if (i == 1) {
                return this.sStartkey.startsWith(AddressPresenter.f9599j);
            }
            return false;
        }

        private RpcRecSug getLastCachedRpc(int i) {
            String str;
            SystemUtils.log(2, AddressPresenter.f9598a, "cgt (" + this.sEndkey + "," + this.sStartkey + "," + i + ")", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$LastCachedKey", 1020);
            if (i == 1) {
                str = this.sStartkey;
            } else if (i == 2) {
                str = this.sEndkey;
            } else {
                SystemUtils.log(5, AddressPresenter.f9598a, "cgt wrg", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$LastCachedKey", 1027);
                str = "";
            }
            return this.mRpcCache.get(str);
        }

        /* access modifiers changed from: private */
        public void setLastCachedRpc(int i, RpcRecSug rpcRecSug, String str, String str2) {
            String str3 = str + i;
            SystemUtils.log(2, AddressPresenter.f9598a, "cst (" + this.sEndkey + "," + this.sStartkey + "," + i + "," + str3 + ")", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$LastCachedKey", 1043);
            setLastCachedKey(i, str3);
            if (rpcRecSug == null) {
                this.mRpcCache.remove(str3);
                if (i == 2 && str3.startsWith(AddressPresenter.f9600k)) {
                    this.mTextCache.remove(str3);
                    setLastCachedKey(i, AddressPresenter.f9599j + i);
                    isLastEndAddrSugFailed = true;
                    return;
                }
                return;
            }
            if (i == 2 && str3.startsWith(AddressPresenter.f9600k)) {
                this.mTextCache.put(str3, str2);
                this.isTextCacheSettedEver = true;
                isLastEndAddrSugFailed = false;
            }
            this.mRpcCache.put(str3, rpcRecSug);
        }

        /* access modifiers changed from: private */
        public void updateCachedRecCommenRpc(int i, RpcPoi rpcPoi) {
            for (Map.Entry next : this.mRpcCache.entrySet()) {
                if (!(next == null || next.getValue() == null)) {
                    if (i == 3) {
                        ((RpcRecSug) next.getValue()).home_poi = rpcPoi;
                    } else if (i == 4) {
                        ((RpcRecSug) next.getValue()).company_poi = rpcPoi;
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public String getLastCachedText(int i) {
            String str;
            if (i == 1) {
                str = this.sStartkey;
            } else if (i == 2) {
                str = this.sEndkey;
            } else {
                SystemUtils.log(5, AddressPresenter.f9598a, "tgt wrg", (Throwable) null, "com.didi.addressold.presenter.AddressPresenter$LastCachedKey", 1090);
                str = "";
            }
            return this.mTextCache.get(str);
        }

        /* access modifiers changed from: private */
        public void clearAllCachedRpc() {
            this.mRpcCache.clear();
            this.mTextCache.clear();
            this.isTextCacheSettedEver = false;
        }
    }
}
