package com.didi.addressnew.presenter;

import android.content.Context;
import com.didi.addressnew.model.ISelectAddressModel;
import com.didi.addressnew.model.SelectAddressModel;
import com.didi.addressnew.view.commonaddress.IHomeCompanyDeleteRequestReactor;
import com.didi.addressnew.view.commonaddress.IHomeCompanyUploadRequestReactor;
import com.sdk.poibase.ResultCallback;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommon;
import java.io.IOException;

public class SimpleCompanyHomePresenter implements ISimpleCompanyHomePresenter {

    /* renamed from: a */
    Context f9304a;

    /* renamed from: b */
    private ISelectAddressModel f9305b;

    public SimpleCompanyHomePresenter(Context context) {
        this.f9304a = context;
        this.f9305b = new SelectAddressModel(context);
    }

    public void setHomeCompany(final AddressParam addressParam, RpcPoi rpcPoi, final IHomeCompanyUploadRequestReactor iHomeCompanyUploadRequestReactor) {
        if (!m8106a(iHomeCompanyUploadRequestReactor)) {
            if (addressParam.addressType == 3 || addressParam.addressType == 4) {
                this.f9305b.setCommonAddress(addressParam, rpcPoi, new ResultCallback<RpcCommon>() {
                    public void success(RpcCommon rpcCommon) {
                        SimpleCompanyHomePresenter.this.m8104a(iHomeCompanyUploadRequestReactor, true, addressParam);
                    }

                    public void failure(IOException iOException) {
                        SimpleCompanyHomePresenter.this.m8104a(iHomeCompanyUploadRequestReactor, false, addressParam);
                    }
                });
            }
        }
    }

    public void deleteCommonAddress(final AddressParam addressParam, final IHomeCompanyDeleteRequestReactor iHomeCompanyDeleteRequestReactor) {
        if (addressParam != null) {
            this.f9305b.deleteCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    SimpleCompanyHomePresenter.this.m8103a(iHomeCompanyDeleteRequestReactor, true, addressParam);
                }

                public void failure(IOException iOException) {
                    SimpleCompanyHomePresenter.this.m8103a(iHomeCompanyDeleteRequestReactor, false, addressParam);
                }
            });
        }
    }

    /* renamed from: a */
    private boolean m8106a(IHomeCompanyUploadRequestReactor iHomeCompanyUploadRequestReactor) {
        return iHomeCompanyUploadRequestReactor == null || !iHomeCompanyUploadRequestReactor.isReactorOnDuty();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8104a(IHomeCompanyUploadRequestReactor iHomeCompanyUploadRequestReactor, boolean z, AddressParam addressParam) {
        if (!m8106a(iHomeCompanyUploadRequestReactor)) {
            if (addressParam.addressType != 3 && addressParam.addressType != 4) {
                return;
            }
            if (z) {
                try {
                    if (addressParam.addressType == 3) {
                        iHomeCompanyUploadRequestReactor.onHomeUploadSuccess();
                    } else if (addressParam.addressType == 4) {
                        iHomeCompanyUploadRequestReactor.onCompanyUploadSuccess();
                    }
                } catch (Exception unused) {
                }
            } else if (addressParam.addressType == 3) {
                iHomeCompanyUploadRequestReactor.onHomeUploadFailed();
            } else if (addressParam.addressType == 4) {
                iHomeCompanyUploadRequestReactor.onCompanyUploadFailed();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8103a(IHomeCompanyDeleteRequestReactor iHomeCompanyDeleteRequestReactor, boolean z, AddressParam addressParam) {
        if (!m8105a(iHomeCompanyDeleteRequestReactor)) {
            if (addressParam.addressType != 3 && addressParam.addressType != 4) {
                return;
            }
            if (z) {
                try {
                    if (addressParam.addressType == 3) {
                        iHomeCompanyDeleteRequestReactor.onHomeDelSuccess();
                    } else if (addressParam.addressType == 4) {
                        iHomeCompanyDeleteRequestReactor.onCompanyDelSuccess();
                    }
                } catch (Exception unused) {
                }
            } else if (addressParam.addressType == 3) {
                iHomeCompanyDeleteRequestReactor.onHomeDelFailed();
            } else if (addressParam.addressType == 4) {
                iHomeCompanyDeleteRequestReactor.onCompanyDelFailed();
            }
        }
    }

    /* renamed from: a */
    private boolean m8105a(IHomeCompanyDeleteRequestReactor iHomeCompanyDeleteRequestReactor) {
        return iHomeCompanyDeleteRequestReactor == null || !iHomeCompanyDeleteRequestReactor.isReactorOnDuty();
    }
}
