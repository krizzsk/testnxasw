package com.didi.sdk.sidebar.travelsafe;

import android.content.Context;
import android.content.SharedPreferences;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.sidebar.sdk.commonapi.Consts;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import java.io.IOException;

public class TravelSafeManager {

    /* renamed from: a */
    private static final String f40171a = "auto_share_travel_db";

    /* renamed from: b */
    private static final String f40172b = "auto_share_data";

    /* renamed from: c */
    private static TravelSafeManager f40173c = null;

    /* renamed from: d */
    private static final int f40174d = 0;

    /* renamed from: e */
    private static final int f40175e = 1;

    /* renamed from: f */
    private static final int f40176f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TravelSafetyState f40177g = new TravelSafetyState();

    /* renamed from: h */
    private Context f40178h = null;

    public interface IRefreshState {
        void dataRefresh(TravelSafetyState travelSafetyState);
    }

    private TravelSafeManager(Context context) {
        this.f40178h = context;
    }

    public static TravelSafeManager getInstance(Context context) {
        if (f40173c == null) {
            f40173c = new TravelSafeManager(context);
        }
        return f40173c;
    }

    public void init(IRefreshState iRefreshState) {
        m30284b(iRefreshState);
        m30282a(iRefreshState);
    }

    public TravelSafetyState getTravelSafeState() {
        return this.f40177g;
    }

    /* renamed from: a */
    private void m30282a(final IRefreshState iRefreshState) {
        m30281a(1, (RpcService.Callback<TripSecurityResponse>) new RpcService.Callback<TripSecurityResponse>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(TripSecurityResponse tripSecurityResponse) {
                if (tripSecurityResponse != null && tripSecurityResponse.errno == 0 && tripSecurityResponse.result != null) {
                    TravelSafetyState unused = TravelSafeManager.this.f40177g = tripSecurityResponse.result;
                    iRefreshState.dataRefresh(TravelSafeManager.this.f40177g);
                }
            }
        });
    }

    public void saveAndSync() {
        m30280a();
        m30283a((RpcService.Callback<TripSecurityResponse>) new RpcService.Callback<TripSecurityResponse>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(TripSecurityResponse tripSecurityResponse) {
            }
        });
    }

    /* renamed from: a */
    private void m30283a(RpcService.Callback<TripSecurityResponse> callback) {
        m30281a(0, callback);
    }

    /* renamed from: a */
    private void m30281a(int i, RpcService.Callback<TripSecurityResponse> callback) {
        TravelSafetyService travelSafetyService = (TravelSafetyService) new RpcServiceFactory(this.f40178h).newRpcService(TravelSafetyService.class, Consts.getCommonApiByEnviroment(this.f40178h));
        String token = NationTypeUtil.getNationComponentData().getLoginInfo().getToken();
        if (token != null && !token.isEmpty()) {
            if (i == 0) {
                TravelSafetyState travelSafetyState = this.f40177g;
                if (travelSafetyState != null) {
                    travelSafetyService.syncAutoShareTravel(token, travelSafetyState.toJsonString(), i, callback);
                }
            } else if (i == 1) {
                travelSafetyService.syncAutoShareTravel(token, "", i, callback);
            }
        }
    }

    /* renamed from: b */
    private void m30284b(IRefreshState iRefreshState) {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f40178h, f40171a, 0);
        TravelSafetyState fromJsonString = TravelSafetyState.fromJsonString(sharedPreferences.getString(f40172b + NationTypeUtil.getNationComponentData().getLoginInfo().getUid(), ""));
        if (fromJsonString != null) {
            this.f40177g = fromJsonString;
            iRefreshState.dataRefresh(fromJsonString);
        }
    }

    /* renamed from: a */
    private void m30280a() {
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f40178h, f40171a, 0);
        if (this.f40177g != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(f40172b + NationTypeUtil.getNationComponentData().getLoginInfo().getUid(), this.f40177g.toJsonString());
            edit.apply();
        }
    }
}
