package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import java.util.List;

public class FuzzyMatchParam {
    public static final String FUZZY_PARAM_ADDRESS_LIST = "addresses";
    public static final String FUZZY_PARAM_POI_TIP = "poiTipType";
    public static final String FUZZY_PARAM_SELECT_ADDRESS = "selectAddress";
    public static final String FUZZY_PARAM_SHOW_DATA_PROVIDER = "showDataProvider";
    public static final String FUZZY_PARAM_SUG_OP_TYPE = "opType";
    public static final String FUZZY_PARAM_SUG_PARAM = "sugparam";

    /* renamed from: a */
    private List<RpcPoi> f8996a;

    /* renamed from: b */
    private int f8997b;

    /* renamed from: c */
    private FuzzyMatchOperationCallback f8998c;

    /* renamed from: d */
    private RpcRecSug.TrackParameterForChild f8999d;

    /* renamed from: e */
    private RpcPoi f9000e;

    /* renamed from: f */
    private boolean f9001f;

    /* renamed from: g */
    private int f9002g;

    public FuzzyMatchParam(List<RpcPoi> list, int i, FuzzyMatchOperationCallback fuzzyMatchOperationCallback) {
        this.f8996a = list;
        this.f8998c = fuzzyMatchOperationCallback;
        this.f8997b = i;
    }

    public FuzzyMatchParam(List<RpcPoi> list, int i, FuzzyMatchOperationCallback fuzzyMatchOperationCallback, RpcRecSug.TrackParameterForChild trackParameterForChild) {
        this.f8996a = list;
        this.f8997b = i;
        this.f8998c = fuzzyMatchOperationCallback;
        this.f8999d = trackParameterForChild;
    }

    public FuzzyMatchParam(List<RpcPoi> list, int i, FuzzyMatchOperationCallback fuzzyMatchOperationCallback, RpcRecSug.TrackParameterForChild trackParameterForChild, RpcPoi rpcPoi) {
        this.f8996a = list;
        this.f8997b = i;
        this.f8998c = fuzzyMatchOperationCallback;
        this.f8999d = trackParameterForChild;
        this.f9000e = rpcPoi;
    }

    public RpcRecSug.TrackParameterForChild getmSugParam() {
        return this.f8999d;
    }

    public List<RpcPoi> getAddressData() {
        return this.f8996a;
    }

    public FuzzyMatchOperationCallback getCallback() {
        return this.f8998c;
    }

    public int getAddressType() {
        return this.f8997b;
    }

    public RpcPoi getSelectAddress() {
        return this.f9000e;
    }

    public void setSelectAddress(RpcPoi rpcPoi) {
        this.f9000e = rpcPoi;
    }

    public boolean isGroup() {
        return this.f9001f;
    }

    public void setGroup(boolean z) {
        this.f9001f = z;
    }

    public int getPageFrom() {
        return this.f9002g;
    }

    public void setPageFrom(int i) {
        this.f9002g = i;
    }
}
