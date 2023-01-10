package com.didi.addressnew.presenter;

import android.content.Context;
import com.didi.address.util.NetUtil;
import com.didi.addressnew.model.ISelectAddressModel;
import com.didi.addressnew.model.SelectAddressModel;
import com.didi.addressnew.view.ICommonAddressView;
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
    private ISelectAddressModel f9301a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICommonAddressView f9302b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SelectAddressModel f9303c;

    public CommonAddressPresenter(Context context, ICommonAddressView iCommonAddressView) {
        this.f9301a = new SelectAddressModel(context);
        this.f9302b = iCommonAddressView;
        this.f9303c = new SelectAddressModel(context);
    }

    public void getCommonAddress(AddressParam addressParam) {
        if (addressParam == null) {
            this.f9302b.showEmptyView();
            return;
        }
        this.f9302b.showProgressDialog(true);
        this.f9301a.getCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
            public void success(RpcCommon rpcCommon) {
                CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                CommonAddressPresenter.this.f9302b.showContentView();
                CommonAddressPresenter.this.f9302b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                CommonAddressPresenter.this.f9303c.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), rpcCommon);
            }

            public void failure(IOException iOException) {
                CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                CommonAddressPresenter.this.f9302b.showEmptyView();
                if (NetUtil.isNetException(iOException)) {
                    CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_check_network));
                } else {
                    CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_load_fail));
                }
            }
        });
    }

    public void getCommonAddressCache(AddressParam addressParam) {
        RpcCommon commonAddressCache = this.f9301a.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
        this.f9302b.updateCommonAddress(commonAddressCache == null ? null : commonAddressCache.commonAddresses);
    }

    public void deleteCommonAddress(AddressParam addressParam) {
        if (addressParam != null) {
            this.f9302b.showProgressDialog(true);
            this.f9301a.deleteCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                    CommonAddressPresenter.this.f9302b.showContentView();
                    CommonAddressPresenter.this.f9302b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f9302b.showToastComplete(CommonAddressPresenter.this.f9302b.getString(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void deletFavoritePlace(AddressParam addressParam, String str) {
        if (addressParam != null) {
            this.f9302b.showProgressDialog(true);
            this.f9301a.deleteFavoritePlace(addressParam, str, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                    CommonAddressPresenter.this.f9302b.showContentView();
                    CommonAddressPresenter.this.f9302b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f9302b.showToastComplete(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z) {
        if (addressParam != null) {
            this.f9302b.showProgressDialog(true);
            this.f9301a.updateFavoritePlace(addressParam, rpcCommonPoi, z, new ResultCallback<HttpResultBase>() {
                public void success(HttpResultBase httpResultBase) {
                    if (httpResultBase == null || httpResultBase.errno == 0) {
                        CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                        CommonAddressPresenter.this.f9302b.onHttpRequestSuccess();
                        return;
                    }
                    CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_load_fail));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f9302b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f9302b.showToastError(CommonAddressPresenter.this.f9302b.getStringVal(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }
}
