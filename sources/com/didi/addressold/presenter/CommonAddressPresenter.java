package com.didi.addressold.presenter;

import android.content.Context;
import com.didi.addressold.model.ISelectAddressModel;
import com.didi.addressold.model.SelectAddressModel;
import com.didi.addressold.util.NetUtil;
import com.didi.addressold.view.ICommonAddressView;
import com.didi.map.sdk.env.PaxEnvironment;
import com.sdk.poibase.ResultCallback;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.common.RpcCommon;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.io.IOException;

public class CommonAddressPresenter implements ICommonAddressPresenter {

    /* renamed from: a */
    private ISelectAddressModel f9610a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICommonAddressView f9611b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SelectAddressModel f9612c;

    public CommonAddressPresenter(Context context, ICommonAddressView iCommonAddressView) {
        this.f9610a = new SelectAddressModel(context);
        this.f9611b = iCommonAddressView;
        this.f9612c = new SelectAddressModel(context);
    }

    public void getCommonAddress(AddressParam addressParam) {
        if (addressParam == null) {
            this.f9611b.showEmptyView();
            return;
        }
        this.f9611b.showProgressDialog(true);
        this.f9610a.getCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
            public void success(RpcCommon rpcCommon) {
                CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                CommonAddressPresenter.this.f9611b.showContentView();
                CommonAddressPresenter.this.f9611b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                CommonAddressPresenter.this.f9612c.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), rpcCommon);
            }

            public void failure(IOException iOException) {
                CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                CommonAddressPresenter.this.f9611b.showEmptyView();
                if (NetUtil.isNetException(iOException)) {
                    CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_check_network));
                } else {
                    CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_load_fail));
                }
            }
        });
    }

    public void getCommonAddressCache(AddressParam addressParam) {
        RpcCommon commonAddressCache = this.f9610a.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
        this.f9611b.updateCommonAddress(commonAddressCache == null ? null : commonAddressCache.commonAddresses);
    }

    public void deleteCommonAddress(AddressParam addressParam) {
        if (addressParam != null) {
            this.f9611b.showProgressDialog(true);
            this.f9610a.deleteCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                    CommonAddressPresenter.this.f9611b.showContentView();
                    CommonAddressPresenter.this.f9611b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f9611b.showToastComplete(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void deletFavoritePlace(AddressParam addressParam, String str) {
        if (addressParam != null) {
            this.f9611b.showProgressDialog(true);
            this.f9610a.deleteFavoritePlace(addressParam, str, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                    CommonAddressPresenter.this.f9611b.showContentView();
                    CommonAddressPresenter.this.f9611b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f9611b.showToastComplete(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z) {
        if (addressParam != null) {
            this.f9611b.showProgressDialog(true);
            this.f9610a.updateFavoritePlace(addressParam, rpcCommonPoi, z, new ResultCallback<HttpResultBase>() {
                public void success(HttpResultBase httpResultBase) {
                    CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                    CommonAddressPresenter.this.f9611b.onHttpRequestSuccess();
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f9611b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f9611b.showToastError(CommonAddressPresenter.this.f9611b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }
}
