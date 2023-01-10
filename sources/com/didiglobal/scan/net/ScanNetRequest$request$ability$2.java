package com.didiglobal.scan.net;

import android.content.Context;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.scan.data.ScanAlertModel;
import com.didiglobal.scan.data.ScanResultModel;
import com.didiglobal.scan.net.ScanNetRequest;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo148868d2 = {"com/didiglobal/scan/net/ScanNetRequest$request$ability$2", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/google/gson/JsonObject;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "scan_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ScanNetRequest.kt */
public final class ScanNetRequest$request$ability$2 implements RpcService.Callback<JsonObject> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ScanNetRequest.ErrorActionDelegate $errorDelegate;
    final /* synthetic */ ScanNetRequest.LoadingDelegate $loadingDelegate;

    ScanNetRequest$request$ability$2(ScanNetRequest.LoadingDelegate loadingDelegate, ScanNetRequest.ErrorActionDelegate errorActionDelegate, Context context) {
        this.$loadingDelegate = loadingDelegate;
        this.$errorDelegate = errorActionDelegate;
        this.$context = context;
    }

    public void onSuccess(JsonObject jsonObject) {
        String str;
        String str2;
        String errContent;
        ScanNetRequest.LoadingDelegate loadingDelegate = this.$loadingDelegate;
        if (loadingDelegate != null) {
            loadingDelegate.hideLoading();
        }
        if (jsonObject != null) {
            JsonElement jsonElement = jsonObject.get("errno");
            Intrinsics.checkExpressionValueIsNotNull(jsonElement, "value!![\"errno\"]");
            int asInt = jsonElement.getAsInt();
            JsonElement jsonElement2 = jsonObject.get("errmsg");
            Intrinsics.checkExpressionValueIsNotNull(jsonElement2, "value!![\"errmsg\"]");
            String asString = jsonElement2.getAsString();
            if (asInt == 0) {
                try {
                    ScanResultModel scanResultModel = (ScanResultModel) ScanNetRequest.f53902b.fromJson(jsonObject.get("data"), ScanResultModel.class);
                    if (scanResultModel.getShowErrAlter() != 1) {
                        UiThreadHandler.post(new ScanNetRequest$request$ability$2$onSuccess$1(scanResultModel));
                    } else if (scanResultModel.getScanAlertModel() == null) {
                        ScanNetRequest.ErrorActionDelegate errorActionDelegate = this.$errorDelegate;
                        if (errorActionDelegate != null) {
                            String string = ResourcesHelper.getString(this.$context, R.string.Finance_LightSpeedPC_Identification_failed_wKuB);
                            Intrinsics.checkExpressionValueIsNotNull(string, "ResourcesHelper.getStrin…                        )");
                            errorActionDelegate.showError(string, (String) null, (String) null, (String) null, (String) null);
                        }
                    } else {
                        ScanNetRequest.ErrorActionDelegate errorActionDelegate2 = this.$errorDelegate;
                        if (errorActionDelegate2 != null) {
                            ScanAlertModel scanAlertModel = scanResultModel.getScanAlertModel();
                            if (scanAlertModel == null || (errContent = scanAlertModel.getErrContent()) == null) {
                                String string2 = ResourcesHelper.getString(this.$context, R.string.Finance_LightSpeedPC_Identification_failed_wKuB);
                                Intrinsics.checkExpressionValueIsNotNull(string2, "ResourcesHelper.getStrin…                        )");
                                str = string2;
                            } else {
                                str = errContent;
                            }
                            ScanAlertModel scanAlertModel2 = scanResultModel.getScanAlertModel();
                            String str3 = null;
                            String errTitle = scanAlertModel2 != null ? scanAlertModel2.getErrTitle() : null;
                            ScanAlertModel scanAlertModel3 = scanResultModel.getScanAlertModel();
                            String errBtnTitle = scanAlertModel3 != null ? scanAlertModel3.getErrBtnTitle() : null;
                            ScanAlertModel scanAlertModel4 = scanResultModel.getScanAlertModel();
                            if (scanAlertModel4 != null) {
                                str3 = scanAlertModel4.getErrJumpUrl();
                            }
                            String str4 = str3;
                            ScanNetRequest scanNetRequest = ScanNetRequest.INSTANCE;
                            ScanAlertModel scanAlertModel5 = scanResultModel.getScanAlertModel();
                            if (scanAlertModel5 == null || (str2 = scanAlertModel5.getActionType()) == null) {
                                str2 = "";
                            }
                            errorActionDelegate2.showError(str, errTitle, errBtnTitle, str4, scanNetRequest.transActionType(str2).getType());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                ScanNetRequest.LoadingDelegate loadingDelegate2 = this.$loadingDelegate;
                if (loadingDelegate2 != null) {
                    loadingDelegate2.hideLoading();
                }
                ScanNetRequest.ErrorActionDelegate errorActionDelegate3 = this.$errorDelegate;
                if (errorActionDelegate3 != null) {
                    Intrinsics.checkExpressionValueIsNotNull(asString, "errmsg");
                    errorActionDelegate3.showError(asString, (String) null, (String) null, (String) null, (String) null);
                }
            }
        }
    }

    public void onFailure(IOException iOException) {
        if (iOException != null) {
            iOException.printStackTrace();
        }
        ScanNetRequest.LoadingDelegate loadingDelegate = this.$loadingDelegate;
        if (loadingDelegate != null) {
            loadingDelegate.hideLoading();
        }
        ScanNetRequest.ErrorActionDelegate errorActionDelegate = this.$errorDelegate;
        if (errorActionDelegate != null) {
            String string = ResourcesHelper.getString(this.$context, R.string.Finance_LightSpeedPC_Identification_failed_wKuB);
            Intrinsics.checkExpressionValueIsNotNull(string, "ResourcesHelper.getStrin…                        )");
            errorActionDelegate.showError(string, (String) null, (String) null, (String) null, (String) null);
        }
    }
}
